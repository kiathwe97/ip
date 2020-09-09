package duke.task;

public class ToDo extends Task{

    public ToDo(String toDoName) throws DukeException{
        super(toDoName);
    }
    public String toString(){
        return "[T] " + super.toString();
    }
}
