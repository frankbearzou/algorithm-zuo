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

    public static void main(String[] args) {
        Lights lights = new Lights();
        System.out.println(lights.light("X...XXX......X."));
    }
}
