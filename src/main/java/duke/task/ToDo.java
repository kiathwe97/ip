package duke.task;

/**
 * Corresponds to a Task that user has to do
 */
public class ToDo extends Task{
    /**
     * Constructor to create a ToDo object
     * @param toDoName name of the Task to be done
     * @throws DukeException if whitespace toDoName specified
     */
    public ToDo(String toDoName) throws DukeException{
        super(toDoName);
    }

    /**
     * Returns details of ToDo in human readable form
     * @return details of ToDo in human readable form
     */
    public String toString(){
        return "[T] " + super.toString();
    }

    /**
     * Returns a string containing the details of the ToDo for storage
     * @return string containing the details of the ToDo for storage
     */
    public String toSaveFormat(){
        int isCompletedInt;
        if (this.isCompleted()){
            isCompletedInt = 1;
        }
        else{
            isCompletedInt = 0;
        }
        return "T|" + isCompletedInt + "|" + this.getTaskName();
    }


}
