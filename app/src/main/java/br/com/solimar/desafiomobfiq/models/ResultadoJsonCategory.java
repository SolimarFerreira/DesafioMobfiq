package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Solimar on 06/07/2017.
 */

public class ResultadoJsonCategory {

    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("Id")
    @Expose
    private Integer id;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}