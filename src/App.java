import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        ToDoList todoList = new ToDoList();
        Task task1 = new Task("Complete assignment", "Finish the current group project on java", LocalDate.of(2023, 7, 31), 2);
        Task task2 = new Task("Study for exam", "Finish work on the origins of the world", LocalDate.of(2023, 8, 10), 5);
        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.showToDoList();
    }
}
