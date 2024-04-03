package com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.platform.PlatformView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xz.b;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplayView;", "Lio/flutter/plugin/platform/PlatformView;", "context", "Landroid/content/Context;", "session", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplaySession;", "(Landroid/content/Context;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplaySession;)V", "view", "Landroid/view/View;", "dispose", "", "getView", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdDisplayView implements PlatformView {
    @NotNull
    private final View view;

    public AdDisplayView(@NotNull Context context, @Nullable AdDisplaySession adDisplaySession) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = new AdView(context, adDisplaySession);
    }

    public void dispose() {
    }

    @NotNull
    public View getView() {
        return this.view;
    }

    public /* synthetic */ void onFlutterViewAttached(View view2) {
        b.a(this, view2);
    }

    public /* synthetic */ void onFlutterViewDetached() {
        b.b(this);
    }

    public /* synthetic */ void onInputConnectionLocked() {
        b.c(this);
    }

    public /* synthetic */ void onInputConnectionUnlocked() {
        b.d(this);
    }
}
