package a10;

/*
given one meeting room, how to arrange maximum meetings
 */
public class Meeting {
    public static class Program {
        int start;
        int end;
        Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int arrange(Program[] programs) {
        if (programs == null | programs.length == 0) {
            return 0;
        }
        return arrange(programs, 0, 0);
    }

    private int arrange(Program[] programs, int done, int timeline) {
        if (programs.length == 0) {
            return 0;
        }
        int max = done;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeline) {
                Program[] rest = copyExcept(programs, i);
                max = Math.max(max, arrange(rest, done + 1, programs[i].end));
            }
        }
        return max;
    }

    private Program[] copyExcept(Program[] programs, int i) {
        Program[] res = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < res.length; k++) {
            if (index == i) {
                index++;
            }
            res[k] = programs[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        Meeting meeting = new Meeting();
        Program[] programs = {new Program(8, 12), new Program(9, 10), new Program(10, 11), new Program(11, 12)};
        System.out.println(meeting.arrange(programs));
    }
}
