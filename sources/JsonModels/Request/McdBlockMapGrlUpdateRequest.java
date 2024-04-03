package JsonModels.Request;

public class McdBlockMapGrlUpdateRequest {
    public String eid;
    public String grl;
    public String grlid;

    public McdBlockMapGrlUpdateRequest(String str, String str2, String str3) {
        this.grl = str;
        this.grlid = str2;
        this.eid = str3;
    }
}
