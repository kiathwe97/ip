package duke.task;

//import java.util.GregorianCalendar;
public class Deadline extends Task{
    //private GregorianCalendar dueDate;
    private String dueDate;
    public Deadline(String deadlineName, String dueDate) throws DukeException{
        super(deadlineName);
        this.dueDate = dueDate;
    }

    public String toString(){
        return "[D] " + super.toString()+ " (by: " + this.dueDate + ")";
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

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
