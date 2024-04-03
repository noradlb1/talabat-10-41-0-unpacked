package datamodels;

public class RestMenuItemModel {
    public static final int TYPE_MENU_ITEM = 1;
    public static final int TYPE_OFFER_ITEM = 2;
    public static final int TYPE_REVIEW_ITEM = 3;
    public Object data;
    public int type;

    public RestMenuItemModel() {
    }

    public RestMenuItemModel(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }
}
