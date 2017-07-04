
package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Specifications {

    @SerializedName("Lav\u00e1vel e reutiliz\u00e1vel")
    @Expose
    private List<String> lavVelEReutilizVel = null;
    @SerializedName("Parte do corpo modelada")
    @Expose
    private List<String> parteDoCorpoModelada = null;
    @SerializedName("Outros Detalhes")
    @Expose
    private List<String> outrosDetalhes = null;
    @SerializedName("Garantia do Fabricante")
    @Expose
    private List<String> garantiaDoFabricante = null;
    @SerializedName("Composi\u00e7\u00e3o")
    @Expose
    private List<String> composiO = null;
    @SerializedName("Assist\u00eancia T\u00e9cnica")
    @Expose
    private List<String> assistNciaTCnica = null;
    @SerializedName("Informa\u00e7\u00f5es Importantes")
    @Expose
    private List<String> informaEsImportantes = null;
    @SerializedName("Itens Inclusos")
    @Expose
    private List<String> itensInclusos = null;

    public List<String> getLavVelEReutilizVel() {
        return lavVelEReutilizVel;
    }

    public void setLavVelEReutilizVel(List<String> lavVelEReutilizVel) {
        this.lavVelEReutilizVel = lavVelEReutilizVel;
    }

    public List<String> getParteDoCorpoModelada() {
        return parteDoCorpoModelada;
    }

    public void setParteDoCorpoModelada(List<String> parteDoCorpoModelada) {
        this.parteDoCorpoModelada = parteDoCorpoModelada;
    }

    public List<String> getOutrosDetalhes() {
        return outrosDetalhes;
    }

    public void setOutrosDetalhes(List<String> outrosDetalhes) {
        this.outrosDetalhes = outrosDetalhes;
    }

    public List<String> getGarantiaDoFabricante() {
        return garantiaDoFabricante;
    }

    public void setGarantiaDoFabricante(List<String> garantiaDoFabricante) {
        this.garantiaDoFabricante = garantiaDoFabricante;
    }

    public List<String> getComposiO() {
        return composiO;
    }

    public void setComposiO(List<String> composiO) {
        this.composiO = composiO;
    }

    public List<String> getAssistNciaTCnica() {
        return assistNciaTCnica;
    }

    public void setAssistNciaTCnica(List<String> assistNciaTCnica) {
        this.assistNciaTCnica = assistNciaTCnica;
    }

    public List<String> getInformaEsImportantes() {
        return informaEsImportantes;
    }

    public void setInformaEsImportantes(List<String> informaEsImportantes) {
        this.informaEsImportantes = informaEsImportantes;
    }

    public List<String> getItensInclusos() {
        return itensInclusos;
    }

    public void setItensInclusos(List<String> itensInclusos) {
        this.itensInclusos = itensInclusos;
    }

}
