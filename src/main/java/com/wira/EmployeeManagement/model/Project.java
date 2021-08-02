/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wira.EmployeeManagement.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mocha
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectId", query = "SELECT p FROM Project p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Project.findByNamaProject", query = "SELECT p FROM Project p WHERE p.namaProject = :namaProject"),
    @NamedQuery(name = "Project.findByKeteranganProject", query = "SELECT p FROM Project p WHERE p.keteranganProject = :keteranganProject"),
    @NamedQuery(name = "Project.findByAsalProject", query = "SELECT p FROM Project p WHERE p.asalProject = :asalProject"),
    @NamedQuery(name = "Project.findByDurasiProject", query = "SELECT p FROM Project p WHERE p.durasiProject = :durasiProject")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Long projectId;
    @Basic(optional = false)
    @Column(name = "nama_project")
    private String namaProject;
    @Basic(optional = false)
    @Column(name = "keterangan_project")
    private String keteranganProject;
    @Basic(optional = false)
    @Column(name = "asal_project")
    private String asalProject;
    @Basic(optional = false)
    @Column(name = "durasi_project")
    @Temporal(TemporalType.DATE)
    private Date durasiProject;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Reports reports;

    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }

    public Project(Long projectId, String namaProject, String keteranganProject, String asalProject, Date durasiProject) {
        this.projectId = projectId;
        this.namaProject = namaProject;
        this.keteranganProject = keteranganProject;
        this.asalProject = asalProject;
        this.durasiProject = durasiProject;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getNamaProject() {
        return namaProject;
    }

    public void setNamaProject(String namaProject) {
        this.namaProject = namaProject;
    }

    public String getKeteranganProject() {
        return keteranganProject;
    }

    public void setKeteranganProject(String keteranganProject) {
        this.keteranganProject = keteranganProject;
    }

    public String getAsalProject() {
        return asalProject;
    }

    public void setAsalProject(String asalProject) {
        this.asalProject = asalProject;
    }

    public Date getDurasiProject() {
        return durasiProject;
    }

    public void setDurasiProject(Date durasiProject) {
        this.durasiProject = durasiProject;
    }

    public Reports getReports() {
        return reports;
    }

    public void setReports(Reports reports) {
        this.reports = reports;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wira.EmployeeManagement.model.Project[ projectId=" + projectId + " ]";
    }
    
}
