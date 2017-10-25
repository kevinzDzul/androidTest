package test.com.hellogenio.models;

import test.com.hellogenio.tools.interfaces.ListItem;

/**
 * Created by kevin on 24/10/17.
 */

public class Footer  implements ListItem{

    private String type;
    private String name;
    private String text;

    public Footer(String type, String name, String text) {
        this.type = type;
        this.name = name;
        this.text = text;
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

    @Override
    public int getListItemType() {
        return TYPE_FOOTER;
    }
}
