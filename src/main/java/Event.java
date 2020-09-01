public class Event extends Task{
    private String eventDate;

    public Event(String eventName, String eventDate){
        super(eventName);
        this.eventDate = eventDate;
    }

    public String toString(){
        return  "[E] " + super.toString()+ " (at: " + this.eventDate + ")";
    }
}
