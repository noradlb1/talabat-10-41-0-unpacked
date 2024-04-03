package JsonModels.Request;

import com.google.gson.annotations.SerializedName;

public class PasswordReq {
    @SerializedName("Email")
    public String email;
    @SerializedName("mobileCountryCode")
    public int mobileCountryCode;
    @SerializedName("MobileNumber")
    public String mobileNumber = "";
}
