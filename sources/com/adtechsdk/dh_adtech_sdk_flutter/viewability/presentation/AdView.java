package com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "session", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplaySession;", "(Landroid/content/Context;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplaySession;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AdView extends View {
    @Nullable
    private final AdDisplaySession session;

    public AdView(@Nullable Context context, @Nullable AdDisplaySession adDisplaySession) {
        super(context);
        this.session = adDisplaySession;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AdDisplaySession adDisplaySession = this.session;
        if (adDisplaySession != null) {
            adDisplaySession.start(this);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AdDisplaySession adDisplaySession = this.session;
        if (adDisplaySession != null) {
            adDisplaySession.finish();
        }
    }
}
