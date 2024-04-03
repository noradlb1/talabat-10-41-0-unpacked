package datamodels;

import com.talabat.helpers.GlobalDataModel;

public class QuickRegister {
    public String ConfirmPassword;
    public String EncTransactioniD;
    public String Password;
    public String Username;
    public String countryId = ("" + GlobalDataModel.SelectedCountryId);

    public QuickRegister(String str, String str2, String str3, String str4) {
        this.Username = str;
        this.Password = str2;
        this.ConfirmPassword = str3;
        this.EncTransactioniD = str4;
    }
}
