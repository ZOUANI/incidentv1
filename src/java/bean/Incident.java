/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author YOUNES
 */
@Entity
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateIncident;
    private int etat;// en cours,traite, non traite
    @ManyToOne
    private TypeIncident typeIncident;
    @ManyToOne
    private Employee employeeDeclarant;
    @ManyToOne
    private Employee validateur;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateValidation;
    private String description;
    @OneToMany(mappedBy = "incident")
    private List<IncidentItem> incidentItems;
    
    public List<IncidentItem> getIncidentItems() {
        return incidentItems;
    }

    public void setIncidentItems(List<IncidentItem> incidentItems) {
        this.incidentItems = incidentItems;
    }

    public Date getDateIncident() {
        return dateIncident;
    }

    public void setDateIncident(Date dateIncident) {
        this.dateIncident = dateIncident;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public TypeIncident getTypeIncident() {
        return typeIncident;
    }

    public void setTypeIncident(TypeIncident typeIncident) {
        this.typeIncident = typeIncident;
    }

    public Employee getEmployeeDeclarant() {
        return employeeDeclarant;
    }

    public void setEmployeeDeclarant(Employee employeeDeclarant) {
        this.employeeDeclarant = employeeDeclarant;
    }

    public Employee getValidateur() {
        return validateur;
    }

    public void setValidateur(Employee validateur) {
        this.validateur = validateur;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
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
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return description+" "+dateValidation+" "+dateIncident;
    }

}
