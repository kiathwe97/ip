package duke;
import duke.task.*;

public class Parser {
    public Parser(){

    }

    public MainCommand getMainCommand(String command){
        if (command.toLowerCase().matches("^deadline.*$")) {
            return MainCommand.DEADLINE;
        } else if (command.toLowerCase().matches("^todo.*$")){
            return MainCommand.TODO;
        } else if (command.toLowerCase().matches("^event.*$")){
            return MainCommand.EVENT;
        } else if (command.equals("bye")){
            return MainCommand.BYE;
        } else if (command.toLowerCase().equals("list")) {
            return MainCommand.LIST;
        } else if (command.toLowerCase().matches("done [1-9]([0-9]{2})?")) {
            return MainCommand.DONE;
        } else if (command.toLowerCase().matches("delete [1-9]([0-9]{2})?")){
            return MainCommand.DELETE;
        } else if (command.toLowerCase().matches("find .*")){
            return MainCommand.FIND;
        }else {
            return null;
        }
    }

    public Task obtainTask(String command, MainCommand mainCommand){
        Task task = null;
        if (mainCommand == MainCommand.DEADLINE){ // SHOULD CHANGE THE REGEX
            String deadlineWithDueDateString = command.substring("deadline".length()).trim();
            String [] deadlineAndDueDateArray = deadlineWithDueDateString.split("/");
            String trimmedDeadline = deadlineAndDueDateArray[0].trim();
            String trimmedDueDate;
            if (deadlineAndDueDateArray.length == 2) {
                trimmedDueDate = deadlineAndDueDateArray[1].substring(3).trim();
            }
            else{
                trimmedDueDate = "";
            }
            try {
                task = new Deadline(trimmedDeadline, trimmedDueDate);
            }catch (DukeException e){


            }
            // this part maybe can rewrite ah

        } else if (mainCommand == MainCommand.TODO){ // SHOULD CHANGE THE REGEX
            String toDo = command.substring("todo".length()).trim();
            try {
                task = new ToDo(toDo);
            }catch (DukeException e){


            }
        } else if (mainCommand == MainCommand.EVENT){ //SHOULD CHANGE THE REGEX
            // need to write this
            String eventWithEventDateString = command.substring("event".length()).trim();
            String [] eventAndEventDateArray = eventWithEventDateString.split("/");
            String trimmedEvent = eventAndEventDateArray[0].trim();
            String trimmedEventDate;
            if (eventAndEventDateArray.length == 2) {
                trimmedEventDate = eventAndEventDateArray[1].substring(3).trim();
            }
            else{
                trimmedEventDate = "";
            }
            try{
                task = new Event(trimmedEvent, trimmedEventDate);
            } catch (DukeException e){

            }

        }

        return task;

    }

    public String obtainKeyword(String command){
        return command.replace("find", "").trim();
    }

}
