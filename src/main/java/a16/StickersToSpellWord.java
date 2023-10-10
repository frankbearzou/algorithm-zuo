package a16;

public class StickersToSpellWord {
    public int minSticker1(String[] stickers, String target) {
        int ans = process1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int process1(String[] stickers, String target) {
        if (target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String rest = minus(target, sticker);
            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private String minus(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];

        for (char c : str1) {
            count[c - 'a']++;
        }
        for (char c : str2) {
            count[c - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] stickers = {"aabb", "bbb", "ccc"};
        String target = "bbacc";
        StickersToSpellWord word = new StickersToSpellWord();
        System.out.println(word.minSticker1(stickers, target));
    }
}
