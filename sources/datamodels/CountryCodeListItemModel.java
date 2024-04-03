package datamodels;

public class CountryCodeListItemModel {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;
    public Object data;
    public int type;

    public CountryCodeListItemModel(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }
}
