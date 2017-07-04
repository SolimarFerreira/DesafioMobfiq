
package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestInstallment {

    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Value")
    @Expose
    private Double value;
    @SerializedName("Total")
    @Expose
    private Double total;
    @SerializedName("Rate")
    @Expose
    private Integer rate;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
