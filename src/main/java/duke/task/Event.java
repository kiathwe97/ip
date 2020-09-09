package duke.task;

public class Event extends Task{
    private String eventDate;

    public Event(String eventName, String eventDate) throws DukeException{
        super(eventName);
        this.eventDate = eventDate;
    }

    public String toString(){
        return  "[E] " + super.toString()+ " (at: " + this.eventDate + ")";
    }
}
