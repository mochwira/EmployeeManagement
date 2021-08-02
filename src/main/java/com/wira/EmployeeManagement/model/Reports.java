/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wira.EmployeeManagement.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @NamedQuery(name = "Reports.findByKategoriId", query = "SELECT r FROM Reports r WHERE r.kategoriId = :kategoriId"),
    @NamedQuery(name = "Reports.findByReportDetail", query = "SELECT r FROM Reports r WHERE r.reportDetail = :reportDetail"),
    @NamedQuery(name = "Reports.findByReportTime", query = "SELECT r FROM Reports r WHERE r.reportTime = :reportTime"),
    @NamedQuery(name = "Reports.findByProjectId", query = "SELECT r FROM Reports r WHERE r.projectId = :projectId")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_id")
    private Long reportId;
    @Basic(optional = false)
    @Column(name = "report_name")
    private String reportName;
    @Basic(optional = false)
    @Column(name = "kategori_id")
    private int kategoriId;
    @Basic(optional = false)
    @Column(name = "report_detail")
    private String reportDetail;
    @Column(name = "report_time")
    @Temporal(TemporalType.DATE)
    private Date reportTime;
    @Basic(optional = false)
    @Column(name = "project_id")
    private long projectId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employees employeeId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reports", fetch = FetchType.LAZY)
    private Project project;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reports", fetch = FetchType.LAZY)
    private Kategori kategori;

    public Reports() {
    }

    public Reports(Long reportId) {
        this.reportId = reportId;
    }

    public Reports(Long reportId, String reportName, int kategoriId, String reportDetail, long projectId) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.kategoriId = kategoriId;
        this.reportDetail = reportDetail;
        this.projectId = projectId;
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

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
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

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
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
