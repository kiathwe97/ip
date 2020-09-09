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

    /*
    public Deadline(String deadlineName, int year, int month, int date, int hour, int minute){
        super(deadlineName);
        GregorianCalendar dueDate = new GregorianCalendar(year, month, date, hour, minute);
        this.dueDate = dueDate;

    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(GregorianCalendar dueDate) { // can use this method to change the due date in future
        this.dueDate = dueDate;
    }

    public String toString(){
        return "[D] " + super.toString() + "(by: " + dueDate.toString() + ")"; //not sure of how this will turn out yet
    }*/
}
