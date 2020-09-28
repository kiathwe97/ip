package duke.task;

/**
 * Corresponds to a task that has to be completed by a certain date(deadline)
 */
public class Deadline extends Task{
    private String dueDate;

    /**
     * Constructor that creates a Deadline object
     * @param deadlineName name of the task that needs to be completed
     * @param dueDate date that the task needs to be completed by
     * @throws DukeException if whitespace deadlineName specified
     */
    public Deadline(String deadlineName, String dueDate) throws DukeException{
        super(deadlineName);
        this.dueDate = dueDate;
    }

    /**
     * Returns a string containing the details of the Deadline for human interpretation
     * @return string containing the details of the Deadline for human interpretation
     */
    public String toString(){
        return "[D] " + super.toString()+ " (by: " + this.dueDate + ")";
    }

    /**
     * Returns a string containing the details of the Deadline for storage
     * @return string containing the details of the Deadline for storage
     */
    public String toSaveFormat(){
        int isCompletedInt;
        if (this.isCompleted()){
            isCompletedInt = 1;
        }
        else{
            isCompletedInt = 0;
        }
        return "D|" + isCompletedInt+"|"+ this.getTaskName()+"|"+ this.dueDate;
    }
}
