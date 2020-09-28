package duke;

import duke.task.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(){
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public Task deleteTask(int index){
        Task removedTask = taskList.remove(index-1);
        return removedTask;
    }

    public Task markTaskAsDone(String command){
        int taskNumber = Integer.parseInt(command.split(" ")[1]);
        if (taskList.get(taskNumber-1) != null) {
            taskList.get(taskNumber-1).setCompleted(true);
            return taskList.get(taskNumber-1);
        } else{
            return null;
        }
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public int getNumberOfTasks(){
        return this.taskList.size();
    }
}
