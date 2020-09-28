package duke.task;

/**
 * Corresponds to a task that will happen on a specific date
 */
public class Event extends Task{
    private String eventDate;

    /**
     * Constructor to create an Event
     * @param eventName name of the Event
     * @param eventDate date that Event takes place on
     * @throws DukeException if whitespace eventName specified
     */
    public Event(String eventName, String eventDate) throws DukeException{
        super(eventName);
        this.eventDate = eventDate;
    }

    /**
     * Returns a string containing the details of the Event for human interpretation
     * @return string containing the details of the Event for human interpretation
     */
    public String toString(){
        return  "[E] " + super.toString()+ " (at: " + this.eventDate + ")";
    }

    /**
     * Returns a string containing the details of the Event for storage
     * @return string containing the details of the Event for storage
     */
    public String toSaveFormat(){
        int isCompletedInt;
        if (this.isCompleted()){
            isCompletedInt = 1;
        }
        else{
            isCompletedInt = 0;
        }
        return "E|" + isCompletedInt+"|"+ this.getTaskName()+"|"+ this.eventDate;
    }
}
