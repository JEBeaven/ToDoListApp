import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The ToDoList class is used to represent the groupings of tasks
 * 
 */
public class ToDoList {
    private PriorityQueue<Task> tasks;
    /**
     * Constructs a new instace of the ToDoList class.
     * Initialises the task priority queue with an empty queue that compares using the tasks priority.
     */
    public ToDoList(){
        tasks = new PriorityQueue<>((task1, task2) -> task1.getPriority() - task2.getPriority());
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
     * Removes all completed tasks from the todo list
     */
    public void removeCompletedTasks(){
        List<Task> tasksToRemove = new ArrayList<>();
        for (Task task : tasks){
            if (task.isCompleted){
                tasksToRemove.add(task);
            }
        }
        tasks.removeAll(tasksToRemove);
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
                System.out.println(task.getName() + " --- " + task.getDescription() + " --- " + task.getDueDate() + " --- " + task.getPriority());
            }
        }
    }
    /**
     * A getter for all the tasks in the current ToDoList
     * @return the list of tasks
     */
    public List<Task> getTasks(){
        return new ArrayList<>(tasks);
    }

    /**
     * Sets the desired task to completed
     * @param task
     */
    public void taskCompleted(Task task){
        task.setCompleted(true);
    }
}
