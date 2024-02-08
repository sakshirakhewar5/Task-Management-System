package Task.Management.System.example.Service;

import java.util.List;

import Task.Management.System.example.Entity.Task;

public interface TaskService {
    List<Task> getAllTasks();
	
    Task saveTask(Task task);
	
    Task getTaskById(Long id);
	
    Task updateTask(Task task);
	
	void deleteTaskById(Long id);
}
