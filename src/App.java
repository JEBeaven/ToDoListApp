import java.time.LocalDate;
/**
 * No utility here in the app class, this is just the class used to test the software works correctly
 */
public class App {
    public static void main(String[] args) throws Exception {
        ToDoList todoList = new ToDoList();
        Task task1 = new Task("test1", "Finish the current group project on java", LocalDate.of(2023, 7, 31), 3);
        Task task2 = new Task("test2", "Finish work on the origins of the world", LocalDate.of(2023, 8, 10), 4);
        Task task3 = new Task("test3", "Finish work on the origins of the world", LocalDate.of(2023, 8, 10), 0);
        Task task4 = new Task("test4", "Finish work on the origins of the world", LocalDate.of(2023, 8, 10), 1);
        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);
        todoList.addTask(task4);
        todoList.showToDoList();
        TaskFileManager.saveTasksToFile("tasks.json",todoList);
        TaskFileManager.loadTasksFromFile("tasks.json", todoList);
    }
}
