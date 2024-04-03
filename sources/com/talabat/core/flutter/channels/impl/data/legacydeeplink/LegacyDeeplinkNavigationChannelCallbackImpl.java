package com.talabat.core.flutter.channels.impl.data.legacydeeplink;

import android.app.Activity;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.DeeplinkHomeScreen;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/legacydeeplink/LegacyDeeplinkNavigationChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "openLegacyDeeplink", "", "deeplink", "", "activity", "Landroid/app/Activity;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyDeeplinkNavigationChannelCallbackImpl implements LegacyDeeplinkNavigationChannelCallback {
    @NotNull
    private final Navigator navigator;

    @Inject
    public LegacyDeeplinkNavigationChannelCallbackImpl(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
    }

    public void openLegacyDeeplink(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        Navigator.DefaultImpls.navigateTo$default(this.navigator, activity2, new DeeplinkHomeScreen(new DeeplinkHomeScreen.DeeplinkHomeScreenData(str)), (Function1) null, 4, (Object) null);
    }
}
