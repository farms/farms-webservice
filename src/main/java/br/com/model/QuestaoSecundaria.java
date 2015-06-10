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
public class QuestaoSecundaria {
	@Id
	@GeneratedValue(generator="QuestaoSecundariaGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="QuestaoSecundariaGenerator",sequenceName="sq_questao_secundaria")
	private Long id;

	@Column(nullable = false)
	private String descricao;
	
	@JoinColumn(nullable=false)
	@ManyToOne
	private Project projeto;

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

	public Project getProjeto() {
		return projeto;
	}

	public void setProjeto(Project projeto) {
		this.projeto = projeto;
	}
}
