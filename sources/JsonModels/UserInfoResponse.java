package JsonModels;

import com.google.gson.annotations.SerializedName;
import datamodels.JMenuSection;

public class UserInfoResponse {
    public boolean alwaysShowBanner;
    public int appIndexingLevel;
    public String chatId;
    public String countryCode;
    public int countryId;
    public int googleApiDelay;
    public boolean hasPreload;
    public boolean isUpdateAvailable;
    @SerializedName("menusection")
    public JMenuSection[] linkmenusection;
    public boolean showBanner;
    public boolean showMenuBanner;
    public boolean showRateApp;
    public String url;
}
