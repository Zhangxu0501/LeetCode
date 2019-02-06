package problem567_permutation_in_string;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26]; // s1每个字符出现的次数
        int[] count2 = new int[26]; // s2每个字符出现的次数
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int[] diff = new int[26]; // s1和s2每个字符的数量差距
        for (int i = 0; i < diff.length; i++) {
            diff[i] = count2[i] - count1[i];
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if(isSame(diff)) {
                return true;
            }
            diff[s2.charAt(i - s1.length()) - 'a']--; // 去掉首个字符
            diff[s2.charAt(i) - 'a']++; // 添加最新的字符
        }
        return isSame(diff);
    }

    public boolean isSame(int[] diff) {
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0) {
                return false;
            }
        }
        return true;
    }
}