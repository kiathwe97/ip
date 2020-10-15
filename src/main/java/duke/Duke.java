package duke;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import duke.task.Task;


/**
 * Main class of the program
 */
public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;
    private final String fileName = "duke.txt";

    public void done(String command){
        Task completedTask = taskList.markTaskAsDone(command);
        if (completedTask == null){
            ui.indexOutOfBoundsMessage();
        }else{
            ui.completedTaskMessage(completedTask);
        }
    }

    public void delete(String command){
        try {
            int index = Integer.parseInt(command.split(" ")[1]);
            Task removedTask = taskList.deleteTask(index);
            ui.deletedTaskMessage(removedTask, taskList.getNumberOfTasks());
        } catch (InputMismatchException e){
            ui.invalidIndexMessage();
        } catch (IndexOutOfBoundsException e){
            ui.indexOutOfBoundsMessage();
        }
    }

    public void find(String command){
        String keyword = parser.obtainKeyword(command);
        ui.printTaskList(taskList.findTasksContaining(keyword));

    }

    public void addTask(String command, MainCommand mainCommand){
        Task newTask = parser.obtainTask(command, mainCommand);
        if (newTask == null){
            ui.nameEmptyMessage();
        }else{
            taskList.addTask(newTask);
        }
        ui.displayNumberOfTasks(taskList.getNumberOfTasks());
    }
    /**
     * Function that runs the application
     */
    public void run() {
        storage = new Storage(fileName);
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
                done(command);
            } else if (mainCommand == MainCommand.DELETE){
                delete(command);
            } else if (mainCommand == MainCommand.FIND){
                find(command);
            } else if (mainCommand == MainCommand.TODO || mainCommand == MainCommand.DEADLINE || mainCommand == MainCommand.EVENT ){ // for new task
                addTask(command, mainCommand);
            } else {
                ui.unknownCommandMessage();
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
