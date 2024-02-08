package Task.Management.System.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Task.Management.System.example.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long >{

}
