/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author YOUNES
 */
@Entity
public class PlanPreventifItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CategorieEquipement categorieEquipement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
    private Employee responsable;
    private String description;
    @ManyToOne
    private PlanPreventif planPreventif;

    public PlanPreventif getPlanPreventif() {
        return planPreventif;
    }

    public void setPlanPreventif(PlanPreventif planPreventif) {
        this.planPreventif = planPreventif;
    }

 
    public CategorieEquipement getCategorieEquipement() {
        return categorieEquipement;
    }

    public void setCategorieEquipement(CategorieEquipement categorieEquipement) {
        this.categorieEquipement = categorieEquipement;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Employee getResponsable() {
        return responsable;
    }

    public void setResponsable(Employee responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanPreventifItem)) {
            return false;
        }
        PlanPreventifItem other = (PlanPreventifItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.PlanPreventifItem[ id=" + id + " ]";
    }

}
