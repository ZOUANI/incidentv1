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
public class TraitementIncidentItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Equipement equipement;
    @ManyToOne
    private Technicien technicien;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTraitement;
    private int etat;
    @ManyToOne
    private TraitementIncident traitementIncident;

    public Equipement getEquipement() {
        return equipement;
    }

    public TraitementIncident getTraitementIncident() {
        return traitementIncident;
    }

    public void setTraitementIncident(TraitementIncident traitementIncident) {
        this.traitementIncident = traitementIncident;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
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
        if (!(object instanceof TraitementIncidentItem)) {
            return false;
        }
        TraitementIncidentItem other = (TraitementIncidentItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TraitementIncidentItem[ id=" + id + " ]";
    }

}
