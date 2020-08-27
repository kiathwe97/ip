import java.util.Scanner;

public class Duke {
    private static Task [] taskList = new Task[100];
    public static void printCommandList(){
        int i;
        for (i=0; i< Task.getNumberOfTasks(); i++){
            if (taskList[i].isCompleted()) {
                System.out.println((i+1) + ". " +"[DONE] " +taskList[i].getTaskName());
            }
            else{
                System.out.println((i+1) + ". " +"[NOT DONE] " +taskList[i].getTaskName());
            }
        }
    }

    public static void main(String[] args) {

        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"; */


        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while (!command.equals("bye")){
            if (command.toLowerCase().equals("list")){
                //print the list
                printCommandList();
            }
            else if (command.toLowerCase().matches("done [1-9]([0-9]{2})?")){
                int taskNumber = Integer.parseInt(command.split(" ")[1]);
                if (taskList[taskNumber-1] != null) {
                    taskList[taskNumber - 1].setCompleted(true);
                    System.out.println("You have completed: " + taskList[taskNumber-1].getTaskName());
                }
                else{
                    System.out.println("Index out of bounds.");
                }

            }
            else{
                taskList[Task.getNumberOfTasks()] = new Task(command);
                System.out.println("Added: " + command);

            }
            command = sc.nextLine();
        }
        System.out.println("Bye! Hope to see you again soon!");
    }
}
