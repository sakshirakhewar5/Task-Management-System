package Task.Management.System.example.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Task.Management.System.example.Entity.Task;
import Task.Management.System.example.Service.TaskService;

@Controller
public class TaskController {
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
 	// handler method to handle list students and return mode and view
	@GetMapping("/tasks")
	public String listtasks(Model model) {
		model.addAttribute("task", taskService.getAllTasks());
		return "tasks";
	}
	 
  	
	@GetMapping("/tasks/new")
	public String createTaskForm(Model model) {
		
		// create student object to hold student form data
		Task task = new Task();
		model.addAttribute("task", task);
		return "create_tasks";
		
	}
	@GetMapping("/tasks/edit/{id}")
	public String editTasksForm(@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.getTaskById(id));
		return "edit_task";
	}
	
	@PostMapping("/tasks")
	public String saveTask(@ModelAttribute("task") Task task) {
		taskService.saveTask(task);
		return "redirect:/tasks";
	}

	@PostMapping("/tasks/{id}")
	public String updateTask(
	        @PathVariable Long id,
	        @ModelAttribute("task") Task task) {

	    Task existingTask = taskService.getTaskById(id);
	    existingTask.setTitle(task.getTitle());
	    existingTask.setDescription(task.getDescription());
	    existingTask.setStatus(task.getStatus());

	    // Save the updated task object
	    taskService.updateTask(existingTask);

	    return "redirect:/tasks";
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTaskById(id);
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/view/{id}")
	public String viewTask(@PathVariable Long id, Model model) {
	    model.addAttribute("task", taskService.getTaskById(id));
	    return "view";
	}
	
}
