package org.springframework.samples.petclinic.care;

import java.util.Set;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="care")
public class Care extends BaseEntity {

    @NotEmpty
    @Size(min=5,max=30)
    @Column(name = "name",unique = true)
    String name;
    
    @NotEmpty
    @Column(name="description")
    String description;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(name="compPetTypes")
    Set<PetType> compatiblePetTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(name="incompPetTypes")
    Set<Care> incompatibleCares;
}
