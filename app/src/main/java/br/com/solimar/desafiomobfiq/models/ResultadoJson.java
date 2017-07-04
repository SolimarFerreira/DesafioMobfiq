
package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultadoJson {

    @SerializedName("Size")
    @Expose
    private Integer size;
    @SerializedName("Offset")
    @Expose
    private Integer offset;
    @SerializedName("Total")
    @Expose
    private Integer total;
    @SerializedName("Delay")
    @Expose
    private Double delay;
    @SerializedName("Products")
    @Expose
    private List<Product> products = null;
    @SerializedName("ApiQuery")
    @Expose
    private String apiQuery;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getDelay() {
        return delay;
    }

    public void setDelay(Double delay) {
        this.delay = delay;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }

}
