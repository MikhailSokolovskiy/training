package Home002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.random;

/**
 * Created by m.sokolovskiy on 23.10.2016.
 */
public class HomeJ09 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int razm = Integer.parseInt(reader.readLine());
        int[][] mat = new int[razm][razm];

        for (int i = 0; i < razm; i++) {
            for (int j = 0; j < razm; j++) {
                mat[i][j] = ((int) (random() * ((razm * 2) + 1) - razm));
            }
        }

        printMat(mat, "The original");
        incDec(mat);            //1
        moveRLUD(mat, 2);       //2
        numIncrDecr(mat);       //3
        //sumOneTwoEl(mat);     //4
        rotate90(mat);          //5,1
        rotate180(mat);         //5,2
        rotate270(mat);         //5,3
        newMatSubArifAver(mat); //6
        //compMatrix(mat);      //7
        zeroEnd(mat);           //8
    }

    public static void printMat(int[][] mat, String text) {
        System.out.printf("\n%s matrix:\n", text);
        for (int[] i : mat) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printMat(int[] mat, String text, int start, int end) {
        System.out.printf("\n%s matrix:\n", text);
        for (int i = start; i <= start + end; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println();
    }

    public static void incDec(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            boolean sort;
            do {
                sort = false;
                for (int j = 0; j < mat[0].length - 1; j++) {
                    if (mat[i][j] > mat[i][j + 1]) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[i][j + 1];
                        mat[i][j + 1] = temp;
                        sort = true;
                    }
                }
            }
            while (sort);
        }

        for (int i = 0; i < mat[0].length; i++) {
            boolean sort;
            do {
                sort = false;
                for (int j = 0; j < mat.length - 1; j++) {
                    if (mat[j][i] > mat[j + 1][i]) {
                        int temp = mat[j][i];
                        mat[j][i] = mat[j + 1][i];
                        mat[j + 1][i] = temp;
                        sort = true;
                    }
                }
            }
            while (sort);
        }

        printMat(mat, "incDec");
    }

    public static void moveRLUD(int[][] mat, int k) {
        int temp;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < mat.length; j++) {
                temp = mat[j][mat.length - 1];
                System.arraycopy(mat[j], 0, mat[j], 1, mat.length - 1);
                mat[j][0] = temp;
            }
        }
        printMat(mat, "It is shifted in the right for " + k + " pos");

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < mat.length; j++) {
                temp = mat[j][0];
                System.arraycopy(mat[j], 1, mat[j], 0, mat.length - 1);
                mat[j][mat.length - 1] = temp;
            }
        }
        printMat(mat, "It is shifted in the left for " + k + " pos");

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                temp = mat[0][j];
                for (int l = 0; l < mat[0].length - 1; l++) {
                    mat[l][j] = mat[l + 1][j];
                }
                mat[mat.length - 1][j] = temp;
            }
        }
        printMat(mat, "It is shifted in the up for " + k + " pos");

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                temp = mat[mat.length - 1][j];
                for (int l = mat[0].length - 1; l > 0; l--) {
                    mat[l][j] = mat[l - 1][j];
                }
                mat[0][j] = temp;
            }
        }
        printMat(mat, "It is shifted in the down for " + k + " pos");
    }

    public static void sumOneTwoEl(int[][] mat) {
        int sum = 0;
        int fistInd = -1;
        int secoInd = -1;
        int step = 0;
        printMat(mat, "The TestPrint");
        for (int i = 0; i < mat.length; i++) {
            if (mat[i].length > 2) {
                sum = 0;
                fistInd = -1;
                secoInd = -1;
                for (int j = 0; j < mat[i].length; j++) {
                    step++;
                    //System.out.print(step + "s ");
                    if (mat[i][j] > 0 && fistInd == -1) {
                        fistInd = j;
                    } else if (mat[i][j] > 0 && fistInd != -1 && (j < mat[j].length & mat[j][i + 1] > 0)) {
                        sum += mat[i][j];
                        secoInd = j;
                    } else if (mat[i][j] <= 0 && fistInd != -1) {
                        break;
                    }
                }
            }
            //if (sum > 0 && secoInd - fistInd > 1) {
            System.out.println(sum);
            //}
        }


    }

    public static void rotate90(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];

        int n = 0;
        for (int j = mat.length - 1; j >= 0; j--) {
            for (int i = 0; i < mat.length; i++) {
                temp[n][i] = mat[i][j];
            }
            n++;
        }
        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "It is turned by 90 degrees against hour");
    }

    public static void rotate180(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];

        int n = 0;
        for (int i = mat.length - 1; i >= 0; i--) {
            int k = 0;
            for (int j = mat.length - 1; j >= 0; j--) {
                temp[n][k] = mat[i][j];
                k++;
            }
            n++;
        }
        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "It is turned by 180 degrees against hour");
    }

    public static void rotate270(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];

        int n = 0;
        for (int i = 0; i < mat.length; i++) {
            int k = 0;
            for (int j = mat.length - 1; j >= 0; j--) {
                temp[n][k] = mat[j][i];
                k++;
            }
            n++;
        }
        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "It is turned by 270 degrees against hour");
    }

    public static void newMatSubArifAver(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];

        for (int i = 0; i < mat.length; i++) {
            int aver = 0;
            for (int j = 0; j < mat.length; j++) {
                aver += mat[i][j];
            }
            aver = aver / mat.length;
            for (int j = 0; j < mat.length; j++) {
                temp[i][j] = mat[i][j] - aver;
            }
        }
        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "It is new matrix, subtraction of an arithmetic average");
    }

    public static void compMatrix(int[][] mat) {
        int[][] temp = new int[mat.length][mat.length];

        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "The compressed");
    }

    public static void zeroEnd(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            boolean sort;
            do {
                sort = false;
                for (int j = mat.length - 1; j > 0; j--) {
                    if (mat[i][j - 1] == 0 && mat[i][j] != 0) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[i][j - 1];
                        mat[i][j - 1] = temp;
                        sort = true;
                    } else continue;
                }
            }
            while (sort);
        }
        printMat(mat, "Is zero number in end");
    }

    public static void numIncrDecr(int[][] mat) {
        int[] inc = {0, 0};
        int stepInc = 0;
        int[] dec = {0, 0};
        int stepDec = 0;
        int[] tArr = new int[mat.length * mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, tArr, (mat.length * i), mat[i].length - 1);
        }

        for (int i = 0; i < tArr.length - 1; i++) {
            if (tArr[i] < tArr[i + 1]) {
                stepInc++;
                if (inc[0] == 0) {
                    inc[0] = i;
                    inc[1] = stepInc;
                } else if (stepInc > inc[1]) {
                    inc[1] = stepInc;
                }
            } else {
                stepInc = 0;
            }

            if (tArr[i] > tArr[i + 1]) {
                stepDec++;
                if (dec[0] == 0) {
                    dec[0] = i;
                    dec[1] = stepDec;
                } else if (stepDec > dec[1]) {
                    dec[1] = stepDec;
                }
            } else {
                stepDec = 0;
            }
        }
        printMat(tArr, "The greatest number of the increasing elements", inc[0], inc[1]);
        printMat(tArr, "The greatest number of the decreasing elements", dec[0], dec[1]);
    }
}