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
public class IncidentItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Equipement equipement;
    @ManyToOne
    private DegreUrgence degreUrgence;
    @ManyToOne
    private CategorieDelai categorieDelai;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTraitement;
    @ManyToOne
    private Incident incident;

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

  

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public DegreUrgence getDegreUrgence() {
        return degreUrgence;
    }

    public void setDegreUrgence(DegreUrgence degreUrgence) {
        this.degreUrgence = degreUrgence;
    }

    public CategorieDelai getCategorieDelai() {
        return categorieDelai;
    }

    public void setCategorieDelai(CategorieDelai categorieDelai) {
        this.categorieDelai = categorieDelai;
    }

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
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
        if (!(object instanceof IncidentItem)) {
            return false;
        }
        IncidentItem other = (IncidentItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.IncidentItem[ id=" + id + " ]";
    }

}
