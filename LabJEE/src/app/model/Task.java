package app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "task")
@Entity
public class Task {
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private Integer taskId;
	
	@Column(nullable = false)
	private Integer projectId;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(name = "order_field")
	private Integer order;
	
	@Column(length = 1000)
	private String description;
	
	@Column(nullable = false)
	private LocalDateTime returnTime;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
