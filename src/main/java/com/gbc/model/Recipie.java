package com.gbc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recipie")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Recipie implements Serializable {

	private static final long serialVersionUID = -5526649676695135113L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String Name;

    @NotBlank
    private String MashTime;

    @NotBlank
    private String MashVolume;
    
    @NotBlank
    private String MashTemperature;

    @OneToMany(mappedBy = "recipie")
	private List<Ingredient> ingredients = new ArrayList<>();
   
//    @NotBlank
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "post_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Ingredient ingregients;

    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMashTime() {
		return MashTime;
	}

	public void setMashTime(String mashTime) {
		MashTime = mashTime;
	}

	public String getMashVolume() {
		return MashVolume;
	}

	public void setMashVolume(String mashVolume) {
		MashVolume = mashVolume;
	}

	public String getMashTemperature() {
		return MashTemperature;
	}

	public void setMashTemperature(String mashTemperature) {
		MashTemperature = mashTemperature;
	}

//	public ArrayList<Ingredient> getMashGrain() {
//		return MashGrain;
//	}
//
//	public void setMashGrain(ArrayList<Ingredient> mashGrain) {
//		MashGrain = mashGrain;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

}