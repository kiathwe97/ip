import java.util.Scanner;

public class Duke {
    private static Task [] taskList = new Task[100];
    public static void printCommandList(){
        int i;
        for (i=0; i< Task.getNumberOfTasks(); i++){
            if (taskList[i].isCompleted()) {
                System.out.println((i+1) + ". " +taskList[i]); // use a tostring method
            }
            else{
                System.out.println((i+1) + ". " +taskList[i]);
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
            if (command.toLowerCase().equals("list")){ // calls for list
                //print the list
                printCommandList();
            }
            else if (command.toLowerCase().matches("done [1-9]([0-9]{2})?")){ // marks for done
                int taskNumber = Integer.parseInt(command.split(" ")[1]);
                if (taskList[taskNumber-1] != null) {
                    taskList[taskNumber - 1].setCompleted(true);
                    System.out.println("You have completed: " + taskList[taskNumber-1].getTaskName());
                }
                else{
                    System.out.println("Index out of bounds.");
                }

            }
            else{ // for new task

                if (command.toLowerCase().matches("^deadline .+$")){ // if is deadline
                    String deadlineWithDueDateString = command.substring("deadline ".length());
                    String [] deadlineAndDueDateArray = deadlineWithDueDateString.split("/");
                    taskList[Task.getNumberOfTasks()] = new Deadline(deadlineAndDueDateArray[0].trim(), deadlineAndDueDateArray[1].substring(3).trim());
                    // this part maybe can rewrite ah

                }

                else if (command.toLowerCase().matches("^todo .+$")){
                    String toDo = command.substring("todo ".length());
                    taskList[Task.getNumberOfTasks()] = new ToDo(toDo);
                }

                else if (command.toLowerCase().matches("^event .+$")){
                    // need to write this
                    String eventWithEventDateString = command.substring("event ".length());
                    String [] eventAndEventDateArray = eventWithEventDateString.split("/");
                    taskList[Task.getNumberOfTasks()] = new Event(eventAndEventDateArray[0].trim(), eventAndEventDateArray[1].substring(3).trim());
                }
                else{
                    System.out.println("I don't understand, please try again.");
                }

                System.out.println("Now you have " + Task.getNumberOfTasks()+ " tasks in the list.");

            }
            command = sc.nextLine();
        }
        System.out.println("Bye! Hope to see you again soon!");
    }
}
