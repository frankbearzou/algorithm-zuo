package a10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
one person has three ids, id1, id2, and id3.
if two people's id1 or id2 or id3 is equal, they are same person.
how many people in the group?
 */
public class IdUnionSet {
    public static class Person {
        int id1;
        int id2;
        int id3;
        Person(int id1, int id2, int id3) {
            this.id1 = id1;
            this.id2 = id2;
            this.id3 = id3;
        }
    }

    Map<Person, Person> parentMap = new HashMap<>();
    Map<Person, Integer> sizeMap = new HashMap<>();
    Map<Integer, Person> id1Map = new HashMap<>();
    Map<Integer, Person> id2Map = new HashMap<>();
    Map<Integer, Person> id3Map = new HashMap<>();

    public int find(List<Person> personList) {
        for (Person person : personList) {
            parentMap.put(person, person);
            sizeMap.put(person, 1);
        }

        for (Person person : personList) {
            if (!id1Map.containsKey(person.id1)) {
                id1Map.put(person.id1, person);
            } else {
                union(id1Map.get(person.id1), person);
            }
            if (!id2Map.containsKey(person.id2)) {
                id2Map.put(person.id2, person);
            } else {
                union(id2Map.get(person.id2), person);
            }
            if (!id3Map.containsKey(person.id3)) {
                id3Map.put(person.id3, person);
            } else {
                union(id3Map.get(person.id3), person);
            }
        }
        return sizeMap.size();
    }

    private void union(Person p1, Person p2) {
        if (isSameSet(p1, p2)) {
            return;
        }
        Person parent1 = findParent(p1);
        Person parent2 = findParent(p2);
        int size1 = sizeMap.get(parent1);
        int size2 = sizeMap.get(parent2);
        Person larger = size1 >= size2 ? parent1 : parent2;
        Person smaller = larger == parent1 ? parent2 : parent1;
        parentMap.put(smaller, larger);
        sizeMap.put(larger, size1 + size2);
        sizeMap.remove(smaller);
    }

    private boolean isSameSet(Person p1, Person p2) {
        if (p1.id1 == p2.id1 && p1.id2 == p2.id2 && p1.id3 == p2.id3) {
            return true;
        }
        Person parent1 = findParent(p1);
        Person parent2 = findParent(p2);
        return parent1 == parent2;
    }

    private Person findParent(Person person) {
        Stack<Person> stack = new Stack<>();
        Person cur = person;
        while (parentMap.get(cur) != cur) {
            stack.push(cur);
            cur = parentMap.get(cur);
        }
        while (!stack.isEmpty()) {
            parentMap.put(stack.pop(), cur);
        }
        return cur;
    }

    public static void main(String[] args) {
        List<Person> list = List.of(new Person(11,21,31), new Person(12,21,32), new Person(13,23,31),
                new Person(14,24,34), new Person(15,25,34));
        IdUnionSet idUnionSet = new IdUnionSet();
        System.out.println(idUnionSet.find(list));
    }
}
