
package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variations {

    @SerializedName("Cor")
    @Expose
    private List<String> cor = null;
    @SerializedName("Tamanho")
    @Expose
    private List<String> tamanho = null;

    public List<String> getCor() {
        return cor;
    }

    public void setCor(List<String> cor) {
        this.cor = cor;
    }

    public List<String> getTamanho() {
        return tamanho;
    }

    public void setTamanho(List<String> tamanho) {
        this.tamanho = tamanho;
    }

}
