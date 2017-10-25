package test.com.hellogenio.models;

import test.com.hellogenio.tools.interfaces.ListItem;

/**
 * Created by kevin on 24/10/17.
 */

public class Header implements ListItem {

    private String type;
    private String name;
    private String text;
    private String image;

    public Header(String type, String name, String text, String image) {
        this.type = type;
        this.name = name;
        this.text = text;
        this.image = image;
    }

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

    @Override
    public int getListItemType() {
        return TYPE_HEADER;
    }
}
