package Task.Management.System.example.Service.Imple;

import java.util.List;

import org.springframework.stereotype.Service;

import Task.Management.System.example.Entity.Task;
import Task.Management.System.example.Repository.TaskRepository;
import Task.Management.System.example.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTaskById(Long id) {
		taskRepository.deleteById(id);	
	}


	
}
