package com.talabat.fluttercore.presentation;

import android.content.Context;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.fluttercore.channels.AuthenticationChannelCallback;
import com.talabat.fluttercore.channels.LogoutEventCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity$setupAuthenticationChannel$1$1", "Lcom/talabat/fluttercore/channels/AuthenticationChannelCallback;", "onLogout", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatFlutterFragmentActivity$setupAuthenticationChannel$1$1 implements AuthenticationChannelCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TalabatFlutterFragmentActivity f59789a;

    public TalabatFlutterFragmentActivity$setupAuthenticationChannel$1$1(TalabatFlutterFragmentActivity talabatFlutterFragmentActivity) {
        this.f59789a = talabatFlutterFragmentActivity;
    }

    public void onLogout() {
        LogoutEventCallback logoutEventCallback;
        if (this.f59789a.getTalabatFeatureFlag().getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false)) {
            Context applicationContext = this.f59789a.getApplicationContext();
            if (applicationContext instanceof LogoutEventCallback) {
                logoutEventCallback = (LogoutEventCallback) applicationContext;
            } else {
                logoutEventCallback = null;
            }
            if (logoutEventCallback != null) {
                logoutEventCallback.onLogout();
            }
            this.f59789a.launchHomeScreen();
        }
    }
}
