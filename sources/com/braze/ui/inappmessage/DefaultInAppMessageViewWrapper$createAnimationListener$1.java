package com.braze.ui.inappmessage;

import android.view.animation.Animation;
import com.braze.enums.inappmessage.DismissType;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$createAnimationListener$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageViewWrapper$createAnimationListener$1 implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44083b;

    public DefaultInAppMessageViewWrapper$createAnimationListener$1(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f44083b = defaultInAppMessageViewWrapper;
    }

    public void onAnimationEnd(@Nullable Animation animation) {
        if (this.f44083b.getInAppMessage().getDismissType() == DismissType.AUTO_DISMISS) {
            this.f44083b.addDismissRunnable();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewWrapper$createAnimationListener$1$onAnimationEnd$1.INSTANCE, 7, (Object) null);
        DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper = this.f44083b;
        defaultInAppMessageViewWrapper.finalizeViewBeforeDisplay(defaultInAppMessageViewWrapper.getInAppMessage(), this.f44083b.getInAppMessageView(), this.f44083b.getInAppMessageViewLifecycleListener());
    }

    public void onAnimationRepeat(@Nullable Animation animation) {
    }

    public void onAnimationStart(@Nullable Animation animation) {
    }
}
