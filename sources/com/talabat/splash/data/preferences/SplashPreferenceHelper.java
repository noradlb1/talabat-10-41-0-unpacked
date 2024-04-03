package com.talabat.splash.data.preferences;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/splash/data/preferences/SplashPreferenceHelper;", "", "enableSplashVideo", "", "enable", "", "getAppLanguage", "getIsEnableSplashVideo", "getIsEnableSplashWelcome", "getIsFreshInstall", "getQatarSpecialLogo", "getSavedPreferences", "getSplashVideoStatus", "isUserLoggedIn", "setInitalAppPreferences", "setSplashViewType", "splashViewType", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SplashPreferenceHelper {
    void enableSplashVideo(boolean z11);

    boolean getAppLanguage();

    boolean getIsEnableSplashVideo();

    boolean getIsEnableSplashWelcome();

    boolean getIsFreshInstall();

    boolean getQatarSpecialLogo();

    boolean getSavedPreferences();

    boolean getSplashVideoStatus();

    boolean isUserLoggedIn();

    boolean setInitalAppPreferences();

    void setSplashViewType(@NotNull String str);
}
