package duke;

import duke.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that helps to read from and save to a data file
 */
public class Storage {
    private Path path;
    public Storage(Path path){
        this.path = path;
    }

    /**
     * Saves Tasks into .txt file
     * @param taskList TaskList object
     */
    public void saveTasksIntoTxt(TaskList taskList){
        int numberOfTasks = taskList.getTaskList().size();

        //open the existing file


        boolean directoryExists = Files.exists(path);
        if (!directoryExists){
            try {
                Files.createFile(path);
            } catch (IOException e){

            }
        }

        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for(int i = 0; i<numberOfTasks; i++){
                writer.write(taskList.getTaskList().get(i).toSaveFormat());
                if(!(i==numberOfTasks-1)){
                    writer.newLine();
                }
            }
            writer.close();
        }catch (IOException e ){
            System.out.println("Save not successful.");
        }




    }

    /**
     * Returns an ArrayList of Task that are saved in .txt file
     * @return ArrayList of Task
     */
    public ArrayList<Task> loadTasksFromTxt(){
        ArrayList<Task> taskList = new ArrayList<Task>();
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
        return taskList;
    }
}
