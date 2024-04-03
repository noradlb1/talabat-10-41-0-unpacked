package JsonModels.Request;

public class MobileNumberVerifyRequest {
    public String code;
    public String countrycode;
    public String countryid;
    public String mobile;

    public MobileNumberVerifyRequest(String str, String str2, String str3, String str4) {
        this.countrycode = str4;
        this.mobile = str2;
        this.code = str;
        this.countryid = str3;
    }
}
