package controller;

import bean.Employee;
import bean.TypeIncident;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import service.StatistiqueFacade;

@Named("chartController")
@SessionScoped
public class ChartController implements Serializable {

    private BarChartModel barModelIncident;
    private BarChartModel barModelPlanPreventif;

    private int annee;
    private Integer etatTraitement;
    private Integer etatIncident;
    private TypeIncident typeIncident;
    private Employee employeeDeclarant;

    @EJB
    private StatistiqueFacade statistiqueFacade;

    public BarChartModel getBarModelIncident() {
        if (barModelIncident == null) {
            barModelIncident = new BarChartModel();
        }
        return barModelIncident;
    }

    public BarChartModel getBarModelPlanPreventif() {
        if (barModelPlanPreventif == null) {
            barModelPlanPreventif = new BarChartModel();
        }
        return barModelPlanPreventif;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries incident = new ChartSeries();
        incident.setLabel("Incident");

        ChartSeries traitementIncident = new ChartSeries();
        traitementIncident.setLabel("Traitement Incident");

        Object[] res = statistiqueFacade.findIncidentAndTraitementByCriteria(annee, etatTraitement, etatIncident, typeIncident, employeeDeclarant);
        List<Long> incidentStat = (List<Long>) res[0];
        List<Long> traitementStat = (List<Long>) res[0];
        for (int i = 1; i <= 12; i++) {
            System.out.println("pour mois "+i+" incident ==> "+incidentStat.get(i - 1));
            System.out.println("pour mois "+i+" traitementStat ==> "+traitementStat.get(i - 1));
            incident.set("" + i, incidentStat.get(i - 1));
            traitementIncident.set("" + i, traitementStat.get(i - 1));
        }

        model.addSeries(incident);
        model.addSeries(traitementIncident);

        return model;
    }

    public void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModelIncident = initBarModel();

        barModelIncident.setTitle("Incident Pour l'annee " + annee);
        barModelIncident.setLegendPosition("ne");

        Axis xAxis = barModelIncident.getAxis(AxisType.X);
        xAxis.setLabel("Mois");

        Axis yAxis = barModelIncident.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    public int getAnnee() {
        if (annee == 0) {
            annee = new Date().getYear() + 1900;
        }
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Integer getEtatTraitement() {
        return etatTraitement;
    }

    public void setEtatTraitement(Integer etatTraitement) {
        this.etatTraitement = etatTraitement;
    }

    public Integer getEtatIncident() {
        return etatIncident;
    }

    public void setEtatIncident(Integer etatIncident) {
        this.etatIncident = etatIncident;
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

    public StatistiqueFacade getStatistiqueFacade() {
        return statistiqueFacade;
    }

    public void setStatistiqueFacade(StatistiqueFacade statistiqueFacade) {
        this.statistiqueFacade = statistiqueFacade;
    }

}
