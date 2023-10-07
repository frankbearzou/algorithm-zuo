package a14;

/*
Walk in the line position 1 ~ N
M: current position
K: how many steps can walk
P: destination
 */
public class RobotWalk {
    public int way1(int N, int M, int K, int P) {
        return walk1(N, M, K, P);
    }

    private int walk1(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return walk1(N, cur + 1, rest - 1, P);
        }
        if (cur == N) {
            return walk1(N, cur - 1, rest - 1, P);
        }
        return walk1(N, cur - 1, rest - 1, P) + walk1(N, cur + 1, rest - 1, P);
    }

    public static void main(String[] args) {
        RobotWalk robotWalk = new RobotWalk();
        System.out.println(robotWalk.way1(5, 2, 6, 4));
        System.out.println(robotWalk.way1(6, 3, 3, 4));
    }
}
