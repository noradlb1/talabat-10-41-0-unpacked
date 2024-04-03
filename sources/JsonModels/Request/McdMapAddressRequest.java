package JsonModels.Request;

public class McdMapAddressRequest {
    public int areaid;
    public String lat;
    public String lng;
    public int restId;

    public McdMapAddressRequest(int i11, String str, String str2) {
        this.areaid = i11;
        this.lat = str;
        this.lng = str2;
    }

    public McdMapAddressRequest(int i11, int i12, String str, String str2) {
        this.areaid = i11;
        this.lat = str;
        this.lng = str2;
        this.restId = i12;
    }
}
