package duke;
import duke.task.Task;

public class Ui {

    public void printTaskList(TaskList taskList){
        int i;
        for (i=0; i< taskList.getTaskList().size(); i++){
            if (taskList.getTaskList().get(i).isCompleted()) {
                System.out.println((i+1) + ". " +taskList.getTaskList().get(i)); // use a tostring method
            } else{
                System.out.println((i+1) + ". " +taskList.getTaskList().get(i));
            }
        }
    }

    public void displayWelcomeMessage(){
        System.out.println("Yooo what it do baby? What can I do for you homie?");
    }

    public void deletedTaskMessage(Task removedTask, int numberOfTasksLeft){
        System.out.println("I got you fam. I've removed this task:\n" + removedTask.toString() +"\nNow you have "+ numberOfTasksLeft + " tasks in the list.");
    }

    public void completedTaskMessage(Task completedTask){
        System.out.println("Yeah boy, you have completed: " + completedTask.getTaskName());
    }

    public void indexOutOfBoundsMessage(){
        System.out.println("Yo hold up, index out of bounds man.");
    }

    public void invalidIndexMessage(){
        System.out.println("Nah you can't do that man.");
    }

    public void displayNumberOfTasks(int numberOfTasks){
        System.out.println("Now you have " + numberOfTasks+ " tasks in the list.");
    }

    public void exitMessage(){
        System.out.println("Holla at me soon homie.");
    }

    public void nameEmptyMessage(){
        System.out.println("Name cannot be empty.");
    }
}
