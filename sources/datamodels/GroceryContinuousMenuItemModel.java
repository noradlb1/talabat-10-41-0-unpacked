package datamodels;

public class GroceryContinuousMenuItemModel {
    public static final int TYPE_MENU_HEADER = 1;
    public static final int TYPE_MENU_ITEM = 2;
    public static final int TYPE_SHOW_MORE = 3;
    public Object data;
    public int type;

    public GroceryContinuousMenuItemModel(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }
}
