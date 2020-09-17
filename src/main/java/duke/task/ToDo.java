package duke.task;

public class ToDo extends Task{

    public ToDo(String toDoName) throws DukeException{
        super(toDoName);
    }
    public String toString(){
        return "[T] " + super.toString();
    }

    public String toSaveFormat(){
        int isCompletedInt;
        if (this.isCompleted()){
            isCompletedInt = 1;
        }
        else{
            isCompletedInt = 0;
        }
        return "T|" + isCompletedInt+"|"+ this.getTaskName();
    }


}
