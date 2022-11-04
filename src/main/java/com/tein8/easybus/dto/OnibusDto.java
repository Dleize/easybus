package com.tein8.easybus.dto;

public record OnibusDto (

    Long cdOnibus,
    String dsPlaca,
    int nrOnibus,
    int cdEmpresa,
    int nrRota,
    String nmRota,
    String dsMarca,
    int nrMax,
    int nrAtual,
    int nrEntradas,
    int nrSaidas,
    int nrSensores,
    String dsStatus
) {

    public OnibusDto(String dsPlaca, int nrOnibus, int cdEmpresa, String nmRota, int nrRota, String dsMarca, int nrMax, int nrEntradas, int nrSaidas, int nrSensores, String dsStatus) {
        this(0l, dsPlaca, nrOnibus, cdEmpresa, nrRota, nmRota, dsMarca, nrMax, 0, nrEntradas, nrSaidas, nrSensores, dsStatus);
    }


}
