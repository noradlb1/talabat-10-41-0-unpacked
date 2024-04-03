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
public final class PreWarmedFlutterFragment$legacyDeeplinkNavigationMethodChannel$2 extends Lambda implements Function0<LegacyDeeplinkNavigationMethodChannel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PreWarmedFlutterFragment f59774g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreWarmedFlutterFragment$legacyDeeplinkNavigationMethodChannel$2(PreWarmedFlutterFragment preWarmedFlutterFragment) {
        super(0);
        this.f59774g = preWarmedFlutterFragment;
    }

    @NotNull
    public final LegacyDeeplinkNavigationMethodChannel invoke() {
        final PreWarmedFlutterFragment preWarmedFlutterFragment = this.f59774g;
        return new LegacyDeeplinkNavigationMethodChannel(new LegacyDeeplinkNavigationChannelCallback() {
            public void openLegacyDeeplink(@NotNull String str, @NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(str, "deeplink");
                Intrinsics.checkNotNullParameter(activity, "activity");
                Activity activity2 = activity;
                Navigator.DefaultImpls.navigateTo$default(preWarmedFlutterFragment.getNavigator(), activity2, new DeeplinkHomeScreen(new DeeplinkHomeScreen.DeeplinkHomeScreenData(str)), (Function1) null, 4, (Object) null);
            }
        });
    }
}
