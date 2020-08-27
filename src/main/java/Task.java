public class Task {

    private String taskName;
    private boolean completed;
    private static int numberOfTasks = 0;

    public Task(String taskName){
        this.taskName = taskName;
        this.completed = false;
        numberOfTasks++;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }


}
