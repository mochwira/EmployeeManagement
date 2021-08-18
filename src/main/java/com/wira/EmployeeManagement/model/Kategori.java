/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wira.EmployeeManagement.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mocha
 */
@Entity
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k"),
    @NamedQuery(name = "Kategori.findByKategoriId", query = "SELECT k FROM Kategori k WHERE k.kategoriId = :kategoriId"),
    @NamedQuery(name = "Kategori.findByNamaKategori", query = "SELECT k FROM Kategori k WHERE k.namaKategori = :namaKategori")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kategori_id")
    private Integer kategoriId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nama_kategori")
    private String namaKategori;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kategoriId", fetch = FetchType.LAZY)
    private Reports reports;

    public Kategori() {
    }

    public Kategori(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Kategori(Integer kategoriId, String namaKategori) {
        this.kategoriId = kategoriId;
        this.namaKategori = namaKategori;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
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
        hash += (kategoriId != null ? kategoriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.kategoriId == null && other.kategoriId != null) || (this.kategoriId != null && !this.kategoriId.equals(other.kategoriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wira.EmployeeManagement.model.Kategori[ kategoriId=" + kategoriId + " ]";
    }
    
}
