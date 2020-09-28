package duke;

import duke.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private Path path;
    public Storage(Path path){
        this.path = path;
    }

    public void saveTasksIntoTxt(TaskList taskList){
        int numberOfTasks = taskList.getTaskList().size();

        //open the existing file






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
