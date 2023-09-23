package a9;

/*
1 2 6  7  12
3 5 8  11 13
4 9 10 14 15

result:
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
*/
public class ZigZagMatrixPrint {
    public void ZigZagPrint(int[][] matrix) {
        int ar = 0, ac = 0, br = 0, bc = 0;
        int maxR = matrix.length - 1, maxC = matrix[0].length - 1;
        boolean isUpDown = false;
        while (ar <= maxR) {
            print(matrix, ar, ac, br, bc, isUpDown);
            ar = ac == maxC ? ar + 1 : ar;
            ac = ac == maxC ? ac : ac + 1;
            bc = br == maxR ? bc + 1 : bc;
            br = br == maxR ? br : br + 1;
            isUpDown = !isUpDown;
        }
    }

    private void print(int[][] matrix, int ar, int ac, int br, int bc, boolean isUpDown) {
        if (isUpDown) {
            while (ar != br + 1) {
                System.out.print(matrix[ar++][ac--] + " ");
            }
        } else {
            while (br != ar - 1) {
                System.out.print(matrix[br--][bc++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,6,7,12}, {3,5,8,11,13}, {4,9,10,14,15}};
        ZigZagMatrixPrint app = new ZigZagMatrixPrint();
        app.ZigZagPrint(matrix);
    }
}
