package Home003;

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
        incDec(mat);
        moveRLUD(mat, 2);
        rotate90(mat);
        rotate180(mat);
        rotate270(mat);
        newMatSubArifAver(mat);
        //compMatrix(mat);
        zeroEnd(mat);

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

    public static void rotate90(int[][] mat) {
        int[][] temp = new int[mat[0].length][mat.length];

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
        int[][] temp = new int[mat[0].length][mat.length];

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
        int[][] temp = new int[mat[0].length][mat.length];

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
        int[][] temp = new int[mat[0].length][mat.length];

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
        int[][] temp = new int[mat[0].length][mat.length];

        System.arraycopy(temp, 0, mat, 0, mat.length);
        printMat(mat, "The compressed");
    }

    public static void zeroEnd(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            boolean sort;
            do {
                sort = false;
                for (int j = mat.length - 1; j > 0; j--) {
                    if (mat[i][j - 1] == 0) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[i][j - 1];
                        mat[i][j - 1] = temp;
                        sort = true;
                    }
                }
            }
            while (sort);
        }
        printMat(mat, "Is zero number in end");
    }

    public static void numIncreDecr(int[][] mat) {
        int elIndInc = 0;
        int sizeInc = 0;
        int elIndDec = 0;
        int sizeDec = 0;

        for (int i = 0; i < mat.length -; i++) {
            for (int j = 0; j < mat.length - 1; j++) {
                if (mat[i][j] > mat[i][j + 1] ) {
                    sizeInc++;
                }
            }
        }

        printMat(mat, "The greatest number of the increasing (decreasing) elements");
    }
}