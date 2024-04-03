package datamodels;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RegistrationRM {
    public int AreaId;
    public String BirthDate;
    public String Company;
    public String Email;
    public String FirstName;
    public boolean Gender;
    public String LastName;
    public String Mobile;
    public String Password;
    public String ProviderKey;
    public String UDID;
    public String Username;
    public String adjustId;
    public String advertisingId;
    public int bday;
    public int bmon;
    public int byr;
    public String facebookUserId;
    public int mobileCountryCode;
    @Nullable
    public String mobileNumber;
    @Nullable
    public String otp;
    @NotNull
    public RegistrationType registrationType = RegistrationType.EMAIL;
    public boolean subscribedToNewsletter;
    public boolean subscribedToSMS;
    public String token;
}
