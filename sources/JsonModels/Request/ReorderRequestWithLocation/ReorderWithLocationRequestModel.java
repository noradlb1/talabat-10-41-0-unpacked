package JsonModels.Request.ReorderRequestWithLocation;

public class ReorderWithLocationRequestModel {
    public String addressId;
    public String areaId;
    public String countryid;
    public String latitude;
    public String longitude;

    public ReorderWithLocationRequestModel(String str, String str2, String str3, String str4, String str5) {
        this.addressId = str;
        this.areaId = str2;
        this.latitude = str3;
        this.longitude = str4;
        this.countryid = str5;
    }
}
