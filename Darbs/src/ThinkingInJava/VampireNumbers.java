package ThinkingInJava;

import java.util.*;

public class VampireNumbers {

    public class FindVNFirst {
        private List sort(String s) {
            List<Character> characterList = new ArrayList<Character>();
            for (int i = 0; i < s.length(); i++) {
                characterList.add(s.charAt(i));
            }
            Collections.sort(characterList);
            return characterList;
        }

        public void findVN() {
            for (int i = 10; i <= 100; i++) {
                String si = String.valueOf(i);
                for (int j = i; j < 100; j++) {
                    int res = i * j;
                    String sj = String.valueOf(j);
                    String resOf = String.valueOf(res);
                    if (sort(si + sj).equals(sort(resOf))) {
                        System.out.printf("%d * %d = %d%n", i, j, res);
                    }
                }
            }
        }
    }

    @Deprecated
    public class FindVNSecond {
        @Deprecated
        public void findVN() {
            Set<Integer> set = new HashSet<>();
            for (int i = 1000; i < 10_000; i++) {
                int[] digits = new int[4];
                digits[0] = i / 1000;
                digits[1] = (i / 100) % 10;
                digits[2] = (i / 10) % 10;
                digits[3] = i % 10;
                for (int j = 0; j < digits.length; j++) {
                    for (int k = 0; k < digits.length; k++) {
                        for (int l = 0; l < digits.length; l++) {
                            for (int m = 0; m < digits.length; m++) {
                                int res = (digits[j] * 10 + digits[k]) * (digits[l] * 10 + digits[m]);
                                if (i == res) {
                                    set.add(i);
                                }
                            }
                        }
                    }
                }
            }
            for (int i : set) {
                System.out.printf("%d%n", i);
            }
        }
    }

    public class FindVNThird {
        public void findVN() {
            HashSet<Integer> vamps = new HashSet<Integer>();
            for (int i = 10; vamps.size() <= 25; i++) {
                if ((numDigits(i) % 2) != 0) {
                    i = i * 10 - 1;
                    continue;
                }
                for (int fang1 = 2; fang1 <= Math.sqrt(i) + 1; fang1++) {
                    if (i % fang1 == 0) {
                        int fang2 = i / fang1;
                        if (fangCheck(i, fang1, fang2) && fang1 <= fang2) {
                            vamps.add(i);
                            System.out.println(i + ": [" + fang1 + ", " + fang2 + "]");
                        }
                    }
                }
            }
        }

        private boolean fangCheck(int orig, int fang1, int fang2) {
            if (Integer.toString(fang1).endsWith("0") && Integer.toString(fang2).endsWith("0")) return false;

            int origLen = numDigits(orig);
            if (numDigits(fang1) != origLen / 2 || numDigits(fang2) != origLen / 2) return false;

            byte[] origBytes = Long.toString(orig).getBytes();
            byte[] fangBytes = (Long.toString(fang1) + Long.toString(fang2)).getBytes();
            Arrays.sort(origBytes);
            Arrays.sort(fangBytes);
            return Arrays.equals(origBytes, fangBytes);
        }

        private int numDigits(int num) {
            return Integer.toString(Math.abs(num)).length();
        }
    }
}
