package br.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(generator="ProjetoGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ProjetoGenerator",sequenceName="sq_projeto")
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false, length=50)
	private String title;

	@Column(nullable = false)
	private String objectives;
	
	
	@OneToMany(mappedBy="project")
	private List<Language> languages;
	
	/*@OneToOne
	private StringPadrao stringPadrao;
	
	@OneToMany
	private List<Keyword> keywords;*/
	
	@ManyToMany
	private List<Researcher> researchers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}

/*	@OneToOne
	private QuestaoPrincipal questaoPrincipal;
	
	@OneToMany
	private List<QuestaoSecundaria> questoesSecundarias;*/
	
}
