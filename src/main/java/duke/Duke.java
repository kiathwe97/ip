package duke;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import duke.task.*;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<Task>();
    private static void saveTasksIntoTxt(){
        int numberOfTasks = taskList.size();

        //open the existing file
        String home = System.getProperty("user.home");
        Path path = Paths.get(home, "Desktop", "IP", "ip", "data", "duke.txt");
        boolean directoryExists = Files.exists(path);
        if (!directoryExists){
            try {
                Files.createFile(path);
            } catch (IOException e){
                System.out.println("Not created");
            }
        }

        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for(int i = 0; i<numberOfTasks; i++){
                writer.write(taskList.get(i).toSaveFormat());
                if(!(i==numberOfTasks-1)){
                    writer.newLine();
                }
            }
            writer.close();
        }catch (IOException e ){
            System.out.println("Save not successful.");
        }




    }

    private static void loadTasksFromTxt(){
        String home = System.getProperty("user.home");
        Path path = Paths.get(home, "Desktop", "IP", "ip", "data", "duke.txt");
        boolean directoryExists = Files.exists(path);
        if (directoryExists){
            File dataFile = new File(path.toString()); // create a File for the given file path
            try{
                Scanner sc = new Scanner(dataFile);
                while (sc.hasNext()) {
                    taskList.add(Task.fromSaveFormatString(sc.nextLine()));
                }
            }catch (FileNotFoundException e){
                System.out.println("No data file found, existing task list is empty.");
            }

        }
    }


    private enum MainCommand{
        LIST, BYE, TODO, EVENT, DEADLINE, DONE
    }
    public static void printCommandList(){
        int i;
        for (i=0; i< Task.getNumberOfTasks(); i++){
            if (taskList.get(i).isCompleted()) {
                System.out.println((i+1) + ". " +taskList.get(i)); // use a tostring method
            } else{
                System.out.println((i+1) + ". " +taskList.get(i));
            }
        }
    }

    public static MainCommand findMainCommand(String command){
        if (command.toLowerCase().matches("^deadline.*$")) {
            return MainCommand.DEADLINE;
        } else if (command.toLowerCase().matches("^todo.*$")){
            return MainCommand.TODO;
        } else if (command.toLowerCase().matches("^event.*$")){
            return MainCommand.EVENT;
        } else if (command.equals("bye")){
            return MainCommand.BYE;
        } else if (command.toLowerCase().equals("list")) {
            return MainCommand.LIST;
        } else if (command.toLowerCase().matches("done [1-9]([0-9]{2})?")) {
            return MainCommand.DONE;
        } else {
            return null;
        }
    }

    ////// COULD WRITE A FUNCTION TO EXTRACT THE COMMAND ///////

    public static void main(String[] args) {
        loadTasksFromTxt();



        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        MainCommand mainCommand = findMainCommand(command);
        while (mainCommand != MainCommand.BYE){
            if (mainCommand == MainCommand.LIST){ // calls for list
                //print the list
                printCommandList();
            } else if (mainCommand == MainCommand.DONE){ // marks for done
                int taskNumber = Integer.parseInt(command.split(" ")[1]);
                if (taskList.get(taskNumber-1) != null) {
                    taskList.get(taskNumber-1).setCompleted(true);
                    System.out.println("You have completed: " + taskList.get(taskNumber-1).getTaskName());
                } else{
                    System.out.println("Index out of bounds.");
                }

            } else{ // for new task

                if (mainCommand == MainCommand.DEADLINE){ // SHOULD CHANGE THE REGEX
                    String deadlineWithDueDateString = command.substring("deadline".length()).trim();
                    String [] deadlineAndDueDateArray = deadlineWithDueDateString.split("/");
                    String trimmedDeadline = deadlineAndDueDateArray[0].trim();
                    String trimmedDueDate;
                    if (deadlineAndDueDateArray.length == 2) {
                        trimmedDueDate = deadlineAndDueDateArray[1].substring(3).trim();
                    }
                    else{
                        trimmedDueDate = "";
                    }
                    try {
                        taskList.add(new Deadline(trimmedDeadline, trimmedDueDate));
                    }catch (DukeException e){
                        System.out.println("Name cannot be empty");
                    }
                    // this part maybe can rewrite ah

                } else if (mainCommand == MainCommand.TODO){ // SHOULD CHANGE THE REGEX
                    String toDo = command.substring("todo".length()).trim();
                    try {
                        taskList.add(new ToDo(toDo));
                    }catch (DukeException e){
                        System.out.println("Name cannot be empty");
                    }
                } else if (mainCommand == MainCommand.EVENT){ //SHOULD CHANGE THE REGEX
                    // need to write this
                    String eventWithEventDateString = command.substring("event".length()).trim();
                    String [] eventAndEventDateArray = eventWithEventDateString.split("/");
                    String trimmedEvent = eventAndEventDateArray[0].trim();
                    String trimmedEventDate;
                    if (eventAndEventDateArray.length == 2) {
                        trimmedEventDate = eventAndEventDateArray[1].substring(3).trim();
                    }
                    else{
                        trimmedEventDate = "";
                    }
                    try{
                        taskList.add(new Event(trimmedEvent, trimmedEventDate));
                    } catch (DukeException e){
                        System.out.println("Name cannot be empty");
                    }

                } else{
                    System.out.println("I don't understand, please try again.");
                }

                System.out.println("Now you have " + Task.getNumberOfTasks()+ " tasks in the list.");

            }
            command = sc.nextLine();
            mainCommand = findMainCommand(command);
        }
        saveTasksIntoTxt();
        System.out.println("Bye! Hope to see you again soon!");
    }
}
