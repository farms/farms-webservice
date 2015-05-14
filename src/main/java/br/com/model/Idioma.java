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
public class Idioma {
	
	@Id
	@GeneratedValue(generator="IdiomaGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="IdiomaGenerator",sequenceName="sq_idioma")
	private Integer id;

	@Column(nullable = false)
	private String descricao;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Projeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
