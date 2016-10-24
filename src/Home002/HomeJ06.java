package Home002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by m.sokolovskiy on 13.10.2016.
 */
public class HomeJ06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String conInp = reader.readLine();
        String[] conArrayS = conInp.split(" ");
        int num[] = new int[conArrayS.length];

        for (int i = 0; i < conArrayS.length; i++) {
            num[i] = Integer.parseInt(conArrayS[i]);
        }

        evenUnEvenn(num);
        devBy39(conArrayS);
        devBy57(num, conArrayS);
        uniqThree(conArrayS);
        happyNum(num);
        equalHalfSum(num);
    }

    public static void evenUnEvenn(int[] num) {
        String res1 = "", res2 = "";
        for (int i : num) {
            if (i % 2 == 0) {
                res1 += i + " ";
            } else {
                res2 += i + " ";
            }
        }
        System.out.printf("Even: %s\nUneven: %s\n\n", res1, res2);

        Arrays.sort(num);
        System.out.printf("Max: %s\nMin: %s\n\n", num[num.length - 1], num[0]);
    }

    public static void devBy39(String[] str) {
        String res1 = "";
        int sum = 0;

        for (String s : str) {
            for (int i = 0; i < s.length(); i++) {
                sum += Character.getNumericValue(s.charAt(i));
            }
            if (sum % 3 == 0 || sum % 9 == 0) {
                res1 += s + " ";
            }
            sum = 0;
        }
        System.out.printf("Divisible by 3 or 9: %s\n\n", res1);
    }

    public static void devBy57(int[] num, String[] str) {
        String res1 = "";
        for (int i : num) {
            if (i % 5 == 0 && i % 7 == 0) {
                res1 += i + " ";
            }
        }
        System.out.printf("Divisible by 5 and 7: %s\n\n", res1);
    }

    public static void uniqThree(String[] str) {
        String res1 = "";

        for (String s : str) {
            if (Integer.parseInt(s) >= 100 && Integer.parseInt(s) <= 999) {
                if (s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2)) {
                    res1 += s + " ";
                }
            }
        }
        System.out.printf("Unique three signs: %s\n\n", res1);
    }

    public static void happyNum(int[] num) {
        String res1 = "";
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= num[num.length - 1]; i++) {
            if (i % 2 != 0)
                list.add(i);
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (i % 6 == 0) {
                list.remove(i);
            }
        }
        for (int n : num) {
            for (int i : list) {
                if (n == i) {
                    res1 += n + " ";
                    break;
                }
            }
        }
        System.out.printf("Happy numbers: %s\n\n", res1);
    }

    public static void equalHalfSum(int[] num) {
        String res1 = "";
        for (int i = 1; i < num[num.length - 2]; i++) {
            if (num[i] == (num[i - 1] + num[i + 1]) / 2) {
                res1 += num[i] + " ";
            }
        }
        System.out.printf("Are equal to a half-sum of the next: %s\n\n", res1);
    }
}