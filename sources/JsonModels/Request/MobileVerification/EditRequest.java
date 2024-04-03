package JsonModels.Request.MobileVerification;

public class EditRequest {
    public String countrycode;
    public int countryid;
    public String emobile;

    /* renamed from: id  reason: collision with root package name */
    public String f474id;
    public String mobile;
    public String smstoken;

    public EditRequest(String str, String str2, int i11, String str3, String str4, String str5) {
        this.f474id = str;
        this.mobile = str2;
        this.countryid = i11;
        this.smstoken = str3;
        this.emobile = str4;
        this.countrycode = str5;
    }
}
