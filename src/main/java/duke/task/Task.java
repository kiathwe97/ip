package duke.task;

/**
 * Corresponds to something that user has to do
 */
public abstract class Task {

    private String taskName;
    private boolean isCompleted;

    /**
     * Creates a Task object
     * @param taskName name of the Task
     * @throws DukeException if whitespace taskName specified
     */
    public Task(String taskName) throws DukeException{
        if (taskName.isBlank()){
            throw new DukeException();
        }
        this.taskName = taskName;
        this.isCompleted = false;
    }

    /**
     * Returns name of the Task
     * @return name of the Task
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Returns true if Task is completed, false otherwise
     * @return boolean denoting Task completion
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Set completion status
     * @param completed boolean denoting Task completion
     */
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }


    /**
     * Returns details of Task in human readable form
     * @return details of Task in human readable form
     */
    public String toString(){
        if (isCompleted == true){
            return "[\u2713] " + this.taskName;
        } else{
            return "[\u2718] " + this.taskName ;
        }

    }

    public abstract String toSaveFormat();

    /**
     * Returns a Task object from string containing Task details in saved format
     * @param saveFormatString containx Task details in saved format
     * @return Task object
     */
    public static Task fromSaveFormatString(String saveFormatString){
        String [] attributeList = saveFormatString.split("\\|");
        Task newTask = null;
        if (attributeList[0].equals("T")){
            try {
                newTask = new ToDo(attributeList[2]);
            } catch (DukeException e){
                return null;
            }
        }
        else if (attributeList[0].equals("D")){
            try{
                newTask = new Deadline(attributeList[2], attributeList[3]);

            } catch (DukeException e){
                return null;
            }
        }
        else if (attributeList[0].equals("E")){
            try{
                newTask = new Event(attributeList[2], attributeList[3]);

            } catch (DukeException e){
                return null;
            }
        }

        if (newTask != null){
            if (attributeList[1].equals("1")){
                newTask.setCompleted(true);
            }
        }

        return newTask;
    }
}
