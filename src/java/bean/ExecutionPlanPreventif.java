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
public class ExecutionPlanPreventif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
    private Employee responsable;
    @ManyToOne
    private PlanPreventif planPreventif;
    private String description;
    @OneToMany(mappedBy = "executionPlanPreventif")
    private List<ExecutionPlanPreventifItem> executionPlanPreventifItems;

    public PlanPreventif getPlanPreventif() {
        return planPreventif;
    }

    public void setPlanPreventif(PlanPreventif planPreventif) {
        this.planPreventif = planPreventif;
    }

    public List<ExecutionPlanPreventifItem> getExecutionPlanPreventifItems() {
        return executionPlanPreventifItems;
    }

    public void setExecutionPlanPreventifItems(List<ExecutionPlanPreventifItem> executionPlanPreventifItems) {
        this.executionPlanPreventifItems = executionPlanPreventifItems;
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
        if (!(object instanceof ExecutionPlanPreventif)) {
            return false;
        }
        ExecutionPlanPreventif other = (ExecutionPlanPreventif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.ExecutionPlanPreventif[ id=" + id + " ]";
    }

}
