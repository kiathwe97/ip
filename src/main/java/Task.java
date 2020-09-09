public class Task {

    private String taskName;
    private boolean completed; //MIGHT NEED TO CHANGE THIS
    private static int numberOfTasks = 0;

    public Task(String taskName) throws DukeException{
        if (taskName.isBlank()){
            throw new DukeException();
        }
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

    //should write a tostring method here
    public String toString(){
        if (completed == true){
            return "[\u2713] " + this.taskName;
        } else{
            return "[\u2718] " + this.taskName ;
        }

    }
}
