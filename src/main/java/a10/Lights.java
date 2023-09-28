package a10;

import java.util.HashSet;
import java.util.Set;

/*
There are empty fields(.) and stone(X) on the street.
lights can be put on the fields but not stone.
one light can bright itself and its left and right neighbors.
how many lights at least needed to bright the street?
 */
public class Lights {
    public int light(String street) {
        return process(street.toCharArray(), 0, new HashSet<Integer>());
    }

    private int process(char[] arr, int index, Set<Integer> light) {
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '.') {
                    if (!light.contains(i - 1) && !light.contains(i) && !light.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return light.size();
        } else {
            int noLight = process(arr, index + 1, light);
            int hasLight = Integer.MAX_VALUE;
            if (arr[index] == '.') {
                light.add(index);
                hasLight = process(arr, index + 1, light);
                light.remove(index);
            }
            return Math.min(noLight, hasLight);
        }
    }

    // greedy
    public int light2(String street) {
        char[] arr = street.toCharArray();
        int index = 0, light = 0;
        while (index < arr.length) {
            if (arr[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 >= arr.length) {
                    index++;
                } else {
                    if (arr[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }

    public static void main(String[] args) {
        Lights lights = new Lights();
        String street = "X...XXX......X.";
        System.out.println(lights.light(street));
        System.out.println(lights.light2(street));
    }
}
