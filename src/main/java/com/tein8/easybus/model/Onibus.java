package com.tein8.easybus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.tein8.easybus.dto.OnibusDto;

@Entity
@Table(name = "TB_ONIBUS")
public class Onibus {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdOnibus;
    @NotBlank(message = "A placa do onibus é obrigatoria")
    private String dsPlaca;
    private int nrOnibus;
    private int cdEmpresa;
    private int nrRota;
    private String nmRota;
    private String dsMarca;
    private int nrMax;
    private int nrAtual;
    private int nrEntradas;
    private int nrSaidas;
    private int nrSensores;
    private String dsStatus;


    
    public Onibus() {
    }

    public Onibus(String dsPlaca, int nrOnibus, int cdEmpresa, int nrRota, String nmRota, String dsMarca, int nrMax,
            int nrAtual, int nrEntradas, int nrSaidas, int nrSensores, String dsStatus) {
        this.dsPlaca = dsPlaca;
        this.nrOnibus = nrOnibus;
        this.cdEmpresa = cdEmpresa;
        this.nrRota = nrRota;
        this.nmRota = nmRota;
        this.dsMarca = dsMarca;
        this.nrMax = nrMax;
        this.nrAtual = nrAtual;
        this.nrEntradas = nrEntradas;
        this.nrSaidas = nrSaidas;
        this.nrSensores = nrSensores;
        this.dsStatus = dsStatus;
    }


    public Long getCdOnibus() {
        return cdOnibus;
    }
    public void setCdOnibus(Long cdOnibus) {
        this.cdOnibus = cdOnibus;
    }
    public String getDsPlaca() {
        return dsPlaca;
    }
    public void setDsPlaca(String dsPlaca) {
        this.dsPlaca = dsPlaca;
    }
    public int getNrOnibus() {
        return nrOnibus;
    }
    public void setNrOnibus(int nrOnibus) {
        this.nrOnibus = nrOnibus;
    }
    public int getCdEmpresa() {
        return cdEmpresa;
    }
    public void setCdEmpresa(int cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }
    public int getNrRota() {
        return nrRota;
    }
    public void setNrRota(int nrRota) {
        this.nrRota = nrRota;
    }
    public String getNmRota() {
        return nmRota;
    }
    public void setNmRota(String nmRota) {
        this.nmRota = nmRota;
    }
    public String getDsMarca() {
        return dsMarca;
    }
    public void setDsMarca(String dsMarca) {
        this.dsMarca = dsMarca;
    }
    public int getNrMax() {
        return nrMax;
    }
    public void setNrMax(int nrMax) {
        this.nrMax = nrMax;
    }
    public int getNrAtual() {
        return nrAtual;
    }
    public void setNrAtual(int nrAtual) {
        this.nrAtual = nrAtual;
    }
    public int getNrEntradas() {
        return nrEntradas;
    }
    public void setNrEntradas(int nrEntradas) {
        this.nrEntradas = nrEntradas;
    }
    public int getNrSaidas() {
        return nrSaidas;
    }
    public void setNrSaidas(int nrSaidas) {
        this.nrSaidas = nrSaidas;
    }
    public int getNrSensores() {
        return nrSensores;
    }
    public void setNrSensores(int nrSensores) {
        this.nrSensores = nrSensores;
    }
    public String getDsStatus() {
        return dsStatus;
    }
    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public OnibusDto toDto() {
        return new OnibusDto(dsPlaca, nrOnibus, cdEmpresa, nmRota, nrRota, dsMarca, nrMax, nrEntradas, nrSaidas, nrSensores, dsStatus);
    }

    @Override
    public String toString() {
        return "Onibus [dsPlaca=" + dsPlaca + ", nrOnibus=" + nrOnibus + ", cdEmpresa=" + cdEmpresa + ", nmRota=" + ", nrRota=" + nrRota 
                + nmRota + ", dsMarca=" + dsMarca + ", nrMax=" + nrMax + ", nrAtual=" + nrAtual + ", nrEntradas="
                + nrEntradas + ", nrSaidas=" + nrSaidas + ", nrSensores=" + nrSensores + ", dsStatus=" + dsStatus + "]";
    }

}
