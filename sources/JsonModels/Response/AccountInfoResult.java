package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import datamodels.RegistrationType;

public class AccountInfoResult {
    public int bday;
    public int bmon;
    public int byr;
    public String firstName;
    public boolean gender;
    public String lastName;
    @SerializedName("registrationType")
    public RegistrationType registrationType = RegistrationType.UNDEFINED;
    public AccountInfoRst rst;
    public boolean subscribedToNewsletter;
    public boolean subscribedToSMS;
}
