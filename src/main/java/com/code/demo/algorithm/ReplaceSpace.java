package com.code.demo.algorithm;

/**
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为 We Are Happy.
 * 则经过替换之后的字符串为 We%20Are%20Happy。
 * 复杂度：O(N) + O(1)
 *
 */
public class ReplaceSpace {

    /**
     * 思路
     * 在字符串尾部填充任意字符，使得字符串的长度等于字符串替换之后的长度。
     * 因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
     * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，
     * 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
     * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     *
     */
    public static void main(String[] args){

        StringBuffer sb = new StringBuffer("We are family");

        ReplaceSpace replaceSpace = new ReplaceSpace();

        System.out.println(replaceSpace.replaceSpace(sb));
    }

    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        // (We are family) -> (We are family    )
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int idxOfOld = oldLen - 1;
        int idxOfNew = str.length() - 1;
        while (idxOfOld >= 0 && idxOfNew > idxOfOld) {
            char c = str.charAt(idxOfOld--);
            if (c == ' ') {
                str.setCharAt(idxOfNew--, '0');
                str.setCharAt(idxOfNew--, '2');
                str.setCharAt(idxOfNew--, '%');
            } else {
                str.setCharAt(idxOfNew--, c);
            }
        }
        return str.toString();
    }
}
