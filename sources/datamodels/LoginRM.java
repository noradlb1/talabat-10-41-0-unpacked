package datamodels;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LoginRM {
    public String GrantType = "password";
    public String Password;
    public String UDID;
    public String UserName;
    public String adjustId;
    public String advertisingId;
    public int mobileCountryCode;
    @Nullable
    public String otp;
    @NotNull
    public RegistrationType registrationType = RegistrationType.EMAIL;
}
