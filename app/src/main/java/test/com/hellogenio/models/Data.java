package test.com.hellogenio.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kevin on 22/10/17.
 */

public class Data {



    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("text")
    @Expose
    private String text;


    @SerializedName("image")
    @Expose
    private String image;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFooter(){
        return  type.equals("footer") ? true : false;
    }
    public boolean isHeader(){
        return  type.equals("header") ? true : false;
    }
}
