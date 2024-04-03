package JsonModels.Request.MobileVerification;

public class GetCodeRequest {
    public String countrycode;
    public int countryid;
    public String emobile;
    public String mobile;
    public String smstoken;
    public int verifyoption;

    public GetCodeRequest(String str, int i11, int i12, String str2, String str3, String str4) {
        this.mobile = str;
        this.verifyoption = i11;
        this.countryid = i12;
        this.countrycode = str2;
        this.smstoken = str3;
        this.emobile = str4;
    }
}
