import java.time.LocalDate;

/**
 * The task class is used to represent a single task contained within the ToDo List
 * Within the task are attributes for the task which include:
 * name, description, dueDate, isCompleted
 */
public class Task {
    private String name;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    /**
     * /*
     * The task Constructor that contrusts a task object with the given name, descrpition an its due date
     * @param name        The name of the given task
     * @param description The descirption of the given task
     * @param dueDate     The due date of the given task
     */
    public Task(String name, String description, LocalDate dueDate){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false; //Tasks are automatically not completed.
    }
    /**
     * Return for the tasks name
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Return the description of the task
     * @return description
     */
    public String getDescription(){
        return description;
    }
    /**
     * Return the Due date of the task
     * @return
     */
    public LocalDate getDueDate(){
        return dueDate;
    }
}
