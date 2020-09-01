public class ToDo extends Task{

    public ToDo(String toDoName){
        super(toDoName);
    }
    public String toString(){
        return "[T] " + super.toString();
    }
}
