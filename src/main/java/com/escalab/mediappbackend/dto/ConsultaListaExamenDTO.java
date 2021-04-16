package com.escalab.mediappbackend.dto;

import com.escalab.mediappbackend.model.Consulta;
import com.escalab.mediappbackend.model.Examen;

import java.io.Serializable;
import java.util.List;

public class ConsultaListaExamenDTO implements Serializable {

    private Consulta consulta;
    private List<Examen> lstExamen;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Examen> getLstExamen() {
        return lstExamen;
    }

    public void setLstExamen(List<Examen> lstExamen) {
        this.lstExamen = lstExamen;
    }
}
