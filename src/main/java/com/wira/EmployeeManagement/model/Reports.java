/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wira.EmployeeManagement.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mocha
 */
@Entity
@Table(name = "reports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r"),
    @NamedQuery(name = "Reports.findByReportId", query = "SELECT r FROM Reports r WHERE r.reportId = :reportId"),
    @NamedQuery(name = "Reports.findByReportName", query = "SELECT r FROM Reports r WHERE r.reportName = :reportName"),
    @NamedQuery(name = "Reports.findByReportDetail", query = "SELECT r FROM Reports r WHERE r.reportDetail = :reportDetail"),
    @NamedQuery(name = "Reports.findByReportTime", query = "SELECT r FROM Reports r WHERE r.reportTime = :reportTime")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_id")
    private Long reportId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "report_name")
    private String reportName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "report_detail")
    private String reportDetail;
    @Column(name = "report_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date reportTime;
    @JoinColumn(name = "kategori_id", referencedColumnName = "kategori_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Kategori kategoriId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employees employeeId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Project projectId;

    public Reports() {
    }

    public Reports(Long reportId) {
        this.reportId = reportId;
    }

    public Reports(Long reportId, String reportName, String reportDetail) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportDetail = reportDetail;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wira.EmployeeManagement.model.Reports[ reportId=" + reportId + " ]";
    }
    
}
