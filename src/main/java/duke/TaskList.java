package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Class that aggregates Task objects
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /**
     * Constructor to create new TaskList object from scratch
     */
    public TaskList(){
        this.taskList = new ArrayList<Task>();
    }

    /**
     * Constructor to create TaskList object from existing ArrayList of Task
     * @param taskList ArrayList of Task
     */
    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    /**
     * Returns ArrayList of Task
     * @return ArrayList of Task
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Deletes a Task
     * @param index integer denoting which Task to delete
     * @return Task object
     */
    public Task deleteTask(int index){
        Task removedTask = taskList.remove(index-1);
        return removedTask;
    }

    /**
     * Set completion status to completed
     * @param command string input by user
     * @return Task object
     */
    public Task markTaskAsDone(String command){
        int taskNumber = Integer.parseInt(command.split(" ")[1]);
        if (taskList.get(taskNumber-1) != null) {
            taskList.get(taskNumber-1).setCompleted(true);
            return taskList.get(taskNumber-1);
        } else{
            return null;
        }
    }

    /**
     * add Task to ArrayList of Task(taskList)
     * @param task Task object
     */
    public void addTask(Task task){
        this.taskList.add(task);
    }

    /**
     * Returns number of Task objects
     * @return number of Task objects
     */
    public int getNumberOfTasks(){
        return this.taskList.size();
    }

    public ArrayList<Task> findTasksContaining(String keyword){
        ArrayList<Task> desiredTasks = new ArrayList<Task>();
        for (int i = 0; i < taskList.size(); i++){
            String taskName = taskList.get(i).getTaskName();
            if (taskName.contains(keyword)){
                desiredTasks.add(taskList.get(i));
            }
        }
        return desiredTasks;
    }
}
