import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"; */

        String message = "Hello! I'm Duke\nWhat can I do for you?";
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!command.equals("bye")){
            System.out.println(command);
            command = sc.nextLine();
        }
        System.out.println("Bye! Hope to see you again soon!");
    }
}
