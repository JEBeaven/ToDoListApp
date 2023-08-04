package tests;
import java.time.LocalDate;
import org.junit.Test;

import TaskCode.Task;


public class taskTests {
    @Test
    public void testTaskIsCompleted(){
        Task task = new Task("Test Task", "Test Desc", LocalDate.now(), 1);
        
    }
}
