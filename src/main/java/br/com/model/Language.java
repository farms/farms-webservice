package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Language {
	
	@Id
	@GeneratedValue(generator="IdiomaGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="IdiomaGenerator",sequenceName="sq_idioma")
	private Integer id;

	@Column(nullable = false)
	private String description;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Project project;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
