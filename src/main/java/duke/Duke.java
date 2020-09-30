package duke;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import duke.task.*;

/**
 * Main class of the program
 */
public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    /**
     * Function that runs the application
     */
    public void run() {
        //String home = System.getProperty("user.home");
        Path path = Paths.get("ip", "src", "main", "java", "duke", "data", "duke.txt");
        storage = new Storage(path);
        taskList = new TaskList(storage.loadTasksFromTxt());
        ui = new Ui();
        parser = new Parser();

        ui.displayWelcomeMessage();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        MainCommand mainCommand = parser.getMainCommand(command);
        while (mainCommand != MainCommand.BYE){
            if (mainCommand == MainCommand.LIST){ // calls for list
                //print the list
                ui.printTaskList(taskList.getTaskList());
            } else if (mainCommand == MainCommand.DONE){ // marks for done
                Task completedTask = taskList.markTaskAsDone(command);
                if (completedTask == null){
                    ui.indexOutOfBoundsMessage();
                }else{
                    ui.completedTaskMessage(completedTask);
                }

            } else if (mainCommand == MainCommand.DELETE){
                try {
                    int index = Integer.parseInt(command.split(" ")[1]);
                    Task removedTask = taskList.deleteTask(index);
                    ui.deletedTaskMessage(removedTask, taskList.getNumberOfTasks());
                } catch (InputMismatchException e){
                    ui.invalidIndexMessage();
                } catch (IndexOutOfBoundsException e){
                    ui.indexOutOfBoundsMessage();
                }
            } else if (mainCommand == MainCommand.FIND){
                String keyword = parser.obtainKeyword(command);
                ui.printTaskList(taskList.findTasksContaining(keyword));

            } else{ // for new task
                Task newTask = parser.obtainTask(command, mainCommand);
                if (newTask == null){
                    ui.nameEmptyMessage();
                }else{
                    taskList.addTask(newTask);

                }

                ui.displayNumberOfTasks(taskList.getNumberOfTasks());


            }
            command = sc.nextLine();
            mainCommand = parser.getMainCommand(command);
        }

        ui.exitMessage();
        storage.saveTasksIntoTxt(taskList);
    }

    /**
     * main function
     * @param args
     */
    public static void main(String args[]){
        new Duke().run();
    }
}
