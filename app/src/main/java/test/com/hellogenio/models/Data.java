package test.com.hellogenio.models;

import test.com.hellogenio.tools.Constant;
import test.com.hellogenio.tools.interfaces.ListItem;

/**
 * Created by kevin on 24/10/17.
 */

public class Data implements ListItem {

    private String type;
    private String text;
    private String image;

    public Data(String type, String text, String image) {
        this.type = type;
        this.text = text;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        if(type.equals(Constant.TYPE_DATA_1))
            return TYPE_ITEM_LEFT;
        else
            return TYPE_ITEM_RIGHT;

    }
}
