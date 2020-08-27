import java.util.Scanner;

public class Duke {
    private static String [] commandList = new String[100];
    private static int numberOfCommands = 0;
    public static void printCommandList(){
        int i;
        for (i=0; i< numberOfCommands; i++){
            System.out.println((i+1) + ". " + commandList[i]);
        }
    }

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
            if (command.toLowerCase().equals("list")){
                //print the list
                printCommandList();
            }
            else{
                commandList[numberOfCommands] = command;
                numberOfCommands++;
                System.out.println("Added: " + command);

            }
            command = sc.nextLine();
        }
        System.out.println("Bye! Hope to see you again soon!");
    }
}
