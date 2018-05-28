/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Employee;
import bean.TypeIncident;
import controller.util.MathUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import service.StatistiqueFacade;

/**
 *
 * @author youness
 */
@Named(value = "statistiqueController")
@SessionScoped
public class StatistiqueController implements Serializable {

    private int annee;
    private Integer etatTraitement;
    private Integer etatIncident;
    private TypeIncident typeIncident;
    private Employee employeeDeclarant;

    @EJB
    private StatistiqueFacade statistiqueFacade;
    private Long max = new Long(0);

    private BarChartModel barModel;
    private LineChartModel lineModel;

    private int typeChart;
    private LineChartModel chartModel;

    @PostConstruct
    public void init() {
        barModel = new BarChartModel();
        ChartSeries incident = new ChartSeries();
        ChartSeries traitementIncident = new ChartSeries();
        for (int i = 0; i < 12; i++) {
            incident.set("mois " + (i + 1), 0);
            traitementIncident.set("mois " + (i + 1), 0);
        }
        barModel.addSeries(traitementIncident);
        barModel.addSeries(incident);
    }

    /**
     * Creates a new instance of statistiqueController
     */
    public void afficherChartIncident() {
        createBarModelIncident();
    }

    public void afficherChartPlan() {
        createBarModelPlan();
    }

    private void createBarModelIncident() {
        barModel = new BarChartModel();
        initBarModelForIncident(barModel);
        paramGraphForIncident(barModel);
    }

    private void paramGraphForIncident(CartesianChartModel model) {
        model.setTitle("Statistiques de l'annee " + annee);
        model.setLegendPosition("e");
        model.setAnimate(true);
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("NOMBRE D'OCCURENCE");
        yAxis.setMin(0);
        yAxis.setMax(max * (1.1));
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setTickAngle(-30);
    }

    private void initBarModelForIncident(CartesianChartModel model) {
        attachResultatToModelForIncident(model);
    }

    private void initBarModelForPlan(CartesianChartModel model) {
        attachResultatToModelForPlan(model);
    }

    private void attachResultatToModelForIncident(CartesianChartModel model) {
        Object[] res = statistiqueFacade.findIncidentAndTraitementByCriteria(annee, etatTraitement, etatIncident, typeIncident, employeeDeclarant);
        max = MathUtil.calculerMax(res);
        ChartSeries incident = new ChartSeries();
        incident.setLabel("Incident");
        ChartSeries traitementIncident = new ChartSeries();
        traitementIncident.setLabel("Traitement Incident");
        List<Long> incidentStat = (List<Long>) res[0];
        List<Long> traitementStat = (List<Long>) res[0];
        for (int i = 1; i <= 12; i++) {
            incident.set("" + i, incidentStat.get(i - 1));
            traitementIncident.set("" + i, traitementStat.get(i - 1));
        }
        model.addSeries(incident);
        model.addSeries(traitementIncident);
    }

    private void createBarModelPlan() {
        barModel = new BarChartModel();
        initBarModelForPlan(barModel);
        paramGraphForPlan(barModel);
    }

    private void paramGraphForPlan(CartesianChartModel model) {
        model.setTitle("Statistiques de l'annee " + annee);
        model.setLegendPosition("e");
        model.setAnimate(true);
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("NOMBRE D'OCCURENCE");
        yAxis.setMin(0);
        yAxis.setMax(max * (1.1));
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setTickAngle(-30);
    }

   

    private void attachResultatToModelForPlan(CartesianChartModel model) {
        Object[] res = statistiqueFacade.findPlanAndExecutionByCriteria(annee, employeeDeclarant);
        max = MathUtil.calculerMax(res);
        ChartSeries planPreventif = new ChartSeries();
        planPreventif.setLabel("Plan Preventif");
        ChartSeries executionPlanPreventif = new ChartSeries();
        executionPlanPreventif.setLabel("Execution Plan Preventif");
        List<Long> planStat = (List<Long>) res[0];
        List<Long> executionStat = (List<Long>) res[0];
        for (int i = 1; i <= 12; i++) {
            planPreventif.set("" + i, planStat.get(i - 1));
            executionPlanPreventif.set("" + i, executionStat.get(i - 1));
        }
        model.addSeries(planPreventif);
        model.addSeries(executionPlanPreventif);
    }

    public void setTypeChart(int typeChart) {
        this.typeChart = typeChart;
    }

    public BarChartModel getBarModel() {
        if (barModel == null) {
            barModel = new BarChartModel();
        }
        return barModel;
    }

    public StatistiqueController() {
    }

    public LineChartModel getChartModel() {
        if (chartModel == null) {
            chartModel = new LineChartModel();
        }
        return chartModel;
    }

    public void setChartModel(LineChartModel chartModel) {
        this.chartModel = chartModel;
    }

    public int getTypeChart() {
        return typeChart;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public LineChartModel getLineModel() {
        if (lineModel == null) {
            lineModel = new LineChartModel();
        }
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
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

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

}
