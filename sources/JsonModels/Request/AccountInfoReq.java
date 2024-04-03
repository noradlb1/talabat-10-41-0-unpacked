package JsonModels.Request;

import com.google.gson.annotations.SerializedName;
import datamodels.RegistrationType;

public class AccountInfoReq {
    public int bday;
    public int bmon;
    public int byr;
    public int countryId;
    public String email;
    public String firstName;
    public boolean gender;
    public String lastName;
    @SerializedName("mobileNumber")
    public String mobileNumber;
    @SerializedName("registrationType")
    public RegistrationType registrationType;
    public boolean subscribedToNewsletter;
    public boolean subscribedToSMS;
}
