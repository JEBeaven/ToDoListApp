import java.time.LocalDate;

/**
 * The task class is used to represent a single task contained within the ToDo List
 * Within the task are attributes for the task which include:
 * name, description, dueDate, isCompleted, tasks priority
 */
public class Task {
    private String name;
    private String description;
    private LocalDate dueDate;
    public boolean isCompleted;
    private Integer priority;

    /**
     * /*
     * The task Constructor that contrusts a task object with the given name, descrpition, its due date, and the priority of the task
     * @param name        The name of the given task
     * @param description The descirption of the given task
     * @param dueDate     The due date of the given task
     * @param priority    The tasks priority - 1:the highest, 2: middle, 3: lowest priority-must be after the 1 and 2's.
     */
    public Task(String name, String description, LocalDate dueDate, Integer priority){
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false; //Tasks are automatically not completed.
        if(priority < 1){
            this.priority = 1;
            System.out.println("Priority entered was less than 1, assumed you have meant 1");
        }
        else if(priority > 3){
            this.priority = 3;
            System.out.println("Priority entered was greater than 3, assumed you have meant 3");
        }
        else{
            this.priority = priority;
        }

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
     * @return dueDate
     */
    public LocalDate getDueDate(){
        return dueDate;
    }
    /**
     * Return the priority of the task
     * @return priority
     */
    public Integer getPriority(){
        return priority;
    }
    /**
     * Sets the isCompleted variable to true indicating that the task has been completed
     */
    public void setCompleted(){
        this.isCompleted = true;
    }
    /**
     * Setter for the description
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * Setter for the date
     * @param date
     */
    public void setDate(LocalDate date){
        this.dueDate = date;
    }
}
