package com.gbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ingredient")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Ingredient implements Serializable {

	private static final long serialVersionUID = -5526649676695135113L;

	public enum INGREDIENT_TYPE {
			HOP,
			GRAIN
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String Name;

    @NotBlank
    private String Ingredient_Type;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Recipie recipie;
    
    
    
    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Recipie getRecipie() {
		return recipie;
	}

	public void setRecipie(Recipie recipie) {
		this.recipie = recipie;
	}

	public String getIngredient_Type() {
		return Ingredient_Type;
	}

	public void setIngredient_Type(String ingredient_Type) {
		Ingredient_Type = ingredient_Type;
	}

}