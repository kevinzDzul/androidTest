package test.com.hellogenio.tools.interfaces;

/**
 * Created by kevin on 24/10/17.
 */

public interface ListItem {

    int TYPE_HEADER = 1;
    int TYPE_FOOTER = 2;
    int TYPE_ITEM_LEFT = 3;
    int TYPE_ITEM_RIGHT = 4;

    int getListItemType();

}
