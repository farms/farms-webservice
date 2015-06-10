package br.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Researcher {

	@Id
	@GeneratedValue(generator="PesquisadorGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="PesquisadorGenerator",sequenceName="sq_pesquisador")
	private Long id;
	
	@Column(nullable=false,length=70)
	private String name;
	
	@Column(nullable=false,length=256)
	private String password;
	
	@Column(nullable=false,length=50)
	private String email;
	
	@ManyToMany
	private List<Project> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	
}
