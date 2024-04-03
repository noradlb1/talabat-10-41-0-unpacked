package com.talabat.fluttercore.presentation;

import android.app.Activity;
import com.talabat.core.flutter.channels.data.legacydeeplink.LegacyDeeplinkNavigationMethodChannel;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.DeeplinkHomeScreen;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatFlutterFragmentActivity$legacyDeeplinkNavigationMethodChannel$2 extends Lambda implements Function0<LegacyDeeplinkNavigationMethodChannel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatFlutterFragmentActivity f59786g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatFlutterFragmentActivity$legacyDeeplinkNavigationMethodChannel$2(TalabatFlutterFragmentActivity talabatFlutterFragmentActivity) {
        super(0);
        this.f59786g = talabatFlutterFragmentActivity;
    }

    @NotNull
    public final LegacyDeeplinkNavigationMethodChannel invoke() {
        final TalabatFlutterFragmentActivity talabatFlutterFragmentActivity = this.f59786g;
        return new LegacyDeeplinkNavigationMethodChannel(new LegacyDeeplinkNavigationChannelCallback() {
            public void openLegacyDeeplink(@NotNull String str, @NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(str, "deeplink");
                Intrinsics.checkNotNullParameter(activity, "activity");
                Activity activity2 = activity;
                Navigator.DefaultImpls.navigateTo$default(talabatFlutterFragmentActivity.getNavigator(), activity2, new DeeplinkHomeScreen(new DeeplinkHomeScreen.DeeplinkHomeScreenData(str)), (Function1) null, 4, (Object) null);
            }
        });
    }
}
