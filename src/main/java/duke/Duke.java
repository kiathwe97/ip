package duke;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import duke.task.*;


public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;




    public void run() {
        String home = System.getProperty("user.home");
        Path path = Paths.get(home, "Desktop", "IP", "ip", "data", "duke.txt");
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
                ui.printTaskList(taskList);
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

    public static void main(String args[]){
        new Duke().run();
    }
}
