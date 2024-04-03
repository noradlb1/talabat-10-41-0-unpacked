package com.huawei.hms.analytics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ar {
    private static final String[] ghi;
    private static final String[] hij;
    private static final String[] ijk;
    public static final List<String> ikl;
    public static final List<String> klm;
    public static final List<String> lmn;

    static {
        String[] strArr = {"$HA_NOTIFICATION_DISPLAY", "$DisplayNotification", "$HA_NOTIFICATION_CLICK", "$ClickNotification", "$HA_NOTIFICATION_CLEAR", "$ClearNotification", "$HA_APP_INSTALL", "$InstallApp", "$HA_APP_START", "$LaunchApp", "$HA_APP_UPDATE", "$UpdateApp", "$HA_FIRST_OPEN", "$AppFirstOpen", "$CustomReferrer", "$HA_SCREEN_ENTER", "$EnterScreen", "$HA_SCREEN_EXIT", "$ExitScreen", "$HA_CLEAR_DATA", "$ClearData", "$HA_CLEAR_CACHE", "$ClearCache", "$HA_APP_UNINSTALL", "$UninstallApp", "$InAppPurchase", "$RequestAd", "$DisplayAd", "$ClickAd", "$ObtainAdAward", "$StopAnalyticsCollection", "$CampaignPushClick", "$AppPushToken"};
        ijk = strArr;
        String[] strArr2 = {"$OpenAppFromAppLinking", "$UpdateFromAppLinking", "$ReOpenAppFromAppLinking", "$DisplayAppMessaging", "$DismissInAppMessage", "$ClickInAppMessage"};
        hij = strArr2;
        String[] strArr3 = {"USERAGENT"};
        ghi = strArr3;
        lmn = Collections.unmodifiableList(Arrays.asList(strArr));
        klm = Collections.unmodifiableList(Arrays.asList(strArr2));
        ikl = Collections.unmodifiableList(Arrays.asList(strArr3));
    }
}
