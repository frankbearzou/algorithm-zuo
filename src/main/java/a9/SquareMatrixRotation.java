package a9;

/*
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

clockwise rotation
13 9  5 1
14 10 6 2
15 11 7 3
16 12 8 4
 */
public class SquareMatrixRotation {
    public void rotate(int[][] matrix) {
        int r1 = 0, c1 = 0, r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 < r2) {
            rotate(matrix, r1++, c1++, r2--, c2--);
        }
    }

    private void rotate(int[][] matrix, int r1, int c1, int r2, int c2) {
        for (int i = 0; i < r2 - r1; i++) {
            int tmp = matrix[r1][c1 + i];
            matrix[r1][c1 + i] = matrix[r2 - i][c1];
            matrix[r2 - i][c1] = matrix[r2][c2 - i];
            matrix[r2][c2 - i] = matrix[r1 + i][c2];
            matrix[r1 + i][c2] = tmp;
        }
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        SquareMatrixRotation app = new SquareMatrixRotation();
        System.out.println("before");
        app.print(matrix);
        System.out.println("after");
        app.rotate(matrix);
        app.print(matrix);
    }
}
