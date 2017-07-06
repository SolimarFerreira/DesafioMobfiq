
package br.com.solimar.desafiomobfiq.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Image")
    @Expose
    private Object image;
    @SerializedName("Redirect")
    @Expose
    private Redirect redirect;
    @SerializedName("SubCategories")
    @Expose
    private Object subCategories;
    @SerializedName("Highlight")
    @Expose
    private Boolean highlight;
    @SerializedName("Icon")
    @Expose
    private Object icon;
    @SerializedName("CategoryListOrder")
    @Expose
    private Integer categoryListOrder;
    @SerializedName("CategoryTreeOrder")
    @Expose
    private Integer categoryTreeOrder;
    @SerializedName("LinkId")
    @Expose
    private Integer linkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public Object getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Object subCategories) {
        this.subCategories = subCategories;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Integer getCategoryListOrder() {
        return categoryListOrder;
    }

    public void setCategoryListOrder(Integer categoryListOrder) {
        this.categoryListOrder = categoryListOrder;
    }

    public Integer getCategoryTreeOrder() {
        return categoryTreeOrder;
    }

    public void setCategoryTreeOrder(Integer categoryTreeOrder) {
        this.categoryTreeOrder = categoryTreeOrder;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

}
