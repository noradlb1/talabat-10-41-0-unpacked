package com.talabat.adscreen;

import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.visa.checkout.Profile;
import net.bytebuddy.utility.JavaConstant;

public class AdUnitHelper {
    private static String getLanguageCode() {
        return GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC) ? Profile.Country.AR : "EN";
    }

    public static String getMainBanner(String str) {
        return "/160416261/TALABAT_ANDROID_" + str + JavaConstant.Dynamic.DEFAULT_NAME + getLanguageCode();
    }

    public static String getSideBanner(String str) {
        return "/160416261/TALABAT_ANDROID_SIDE_" + str + JavaConstant.Dynamic.DEFAULT_NAME + getLanguageCode();
    }
}
