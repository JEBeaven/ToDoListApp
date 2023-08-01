import java.util.ArrayList;
import java.util.List;

/**
 * The ToDoList class is used to represent the groupings of tasks
 * 
 */
public class ToDoList {
    private List<Task> tasks;
    /**
     * Construcs a new instace of the ToDoList class.
     * Initialises the task list with an empty array list
     */
    public ToDoList(){
        tasks = new ArrayList<>();
    }
    /**
     * Adds task to the current ToDoList
     * @param task
     */
    public void addTask(Task task){
        tasks.add(task);
    }
    /**
     * Removes given task from the ToDoList
     * @param task
     */
    public void removeTask(Task task){
        tasks.remove(task);
    }

    /**
     * Displays to the user their current ToDoList
     */
    public void showToDoList(){
        if(tasks.isEmpty()){
            System.out.println("Current ToDoList is Empty. Good Job!");
        }
        else{
            for(Task task: tasks){
                System.out.println(task.getName() + " --- " + task.getDescription() + " --- " + task.getDueDate());
            }
        }
    }
}
