package datamodels;

public class ContinuousMenuItemModel {
    public static final int TYPE_MENU_HEADER = 1;
    public static final int TYPE_MENU_ITEM = 2;
    public Object data;
    public int type;

    public ContinuousMenuItemModel(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }
}
