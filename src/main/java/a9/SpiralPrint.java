package a9;

/*
1 ,2 ,3 ,4
5 ,6 ,7 ,8
9 ,10,11,12
13,14,15,16
*/
public class SpiralPrint {
    public void print(int[][] matrix) {
        int r1 = 0, c1 = 0, r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            print(matrix, r1, c1, r2, c2);
            r1++;
            c1++;
            r2--;
            c2--;
        }
    }

    private void print(int[][] matrix, int r1, int c1, int r2, int c2) {
        if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                System.out.print(matrix[r1][i] + " ");
            }
        } else if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                System.out.print(matrix[i][c1] + " ");
            }
        } else {
            int r = r1, c = c1;
            while (c < c2) {
                System.out.print(matrix[r][c] + " ");
                c++;
            }
            while (r < r2) {
                System.out.print(matrix[r][c2] + " ");
                r++;
            }
            while (c > c1) {
                System.out.print(matrix[r2][c] + " ");
                c--;
            }
            while (r > r1) {
                System.out.print(matrix[r][c1] + " ");
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        SpiralPrint print = new SpiralPrint();
        print.print(matrix);
    }
}

