package br.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(generator="ProjetoGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ProjetoGenerator",sequenceName="sq_projeto")
	private Long id;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false, length=50)
	private String titulo;

	@Column(nullable = false)
	private String objetivo;
	
	
	@OneToMany(mappedBy="projeto")
	private List<Idioma> idiomas;
	
	@OneToOne
	private StringPadrao stringPadrao;
	
	@OneToMany
	private List<Keyword> keywords;
	
	@ManyToMany
	private List<Pesquisador> pesquisadores;

	@OneToOne
	private QuestaoPrincipal questaoPrincipal;
	
	@OneToMany
	private List<QuestaoSecundaria> questoesSecundarias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public StringPadrao getStringPadrao() {
		return stringPadrao;
	}

	public void setStringPadrao(StringPadrao stringPadrao) {
		this.stringPadrao = stringPadrao;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
}
