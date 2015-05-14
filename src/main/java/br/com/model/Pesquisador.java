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
public class Pesquisador {

	@Id
	@GeneratedValue(generator="PesquisadorGenerator",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="PesquisadorGenerator",sequenceName="sq_pesquisador")
	private Long id;
	
	@Column(nullable=false,length=70)
	private String nome;
	
	@Column(nullable=false,length=256)
	private String senha;
	
	@Column(nullable=false,length=50)
	private String email;
	
	@ManyToMany
	private List<Projeto> projetos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	
}
