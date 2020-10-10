package br.com.coti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Long id;
	
	@Column(length = 50)
	@Pattern(regexp = "[a-z A-Z]{2,50}", message = "Erro no Nome do Produto")
	private String nomeProduto;
	
	@Column
	@DecimalMin("1.00")
	private Double preco;
	
	@Column
	private String foto;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long id,
			@Pattern(regexp = "[a-z A-Z]{2,50}", message = "Erro no Nome do Produto") String nomeProduto,
			@DecimalMin("1.00") Double preco, String foto) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", foto=" + foto + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
