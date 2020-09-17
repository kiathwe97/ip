package duke.task;

public abstract class Task {

    private String taskName;
    private boolean completed; //MIGHT NEED TO CHANGE THIS


    public Task(String taskName) throws DukeException{
        if (taskName.isBlank()){
            throw new DukeException();
        }
        this.taskName = taskName;
        this.completed = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    //should write a tostring method here
    public String toString(){
        if (completed == true){
            return "[\u2713] " + this.taskName;
        } else{
            return "[\u2718] " + this.taskName ;
        }

    }

    public abstract String toSaveFormat();
    public static Task fromSaveFormatString(String saveFormatString){
        String [] attributeList = saveFormatString.split("\\|");
        Task newTask= null;
        if (attributeList[0].equals("T")){
            try {
                newTask = new ToDo(attributeList[2]);
            } catch (DukeException e){

            }
        }
        else if (attributeList[0].equals("D")){
            try{
                newTask = new Deadline(attributeList[2], attributeList[3]);

            } catch (DukeException e){

            }
        }
        else if (attributeList[0].equals("E")){
            try{
                newTask = new Event(attributeList[2], attributeList[3]);

            } catch (DukeException e){

            }
        }

        if (newTask != null){
            if (attributeList[1].equals("1")){
                newTask.setCompleted(true);
            }
        }

        return newTask;
    }
}
