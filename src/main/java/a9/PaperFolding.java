package a9;

public class PaperFolding {
    public void printAllFold(int N) {
        process(1, N, true);
    }

    private void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.println(down ? "down" : "up");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        PaperFolding paperFolding = new PaperFolding();
        paperFolding.printAllFold(2);
    }
}
