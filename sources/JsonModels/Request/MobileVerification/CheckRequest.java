package JsonModels.Request.MobileVerification;

public class CheckRequest {
    public int countryId;
    public String countrycode;
    public String emobile;
    public String mobile;
    public String smstoken;

    public CheckRequest(int i11, String str, String str2, String str3, String str4) {
        this.countryId = i11;
        this.mobile = str;
        this.smstoken = str2;
        this.emobile = str3;
        this.countrycode = str4;
    }
}
