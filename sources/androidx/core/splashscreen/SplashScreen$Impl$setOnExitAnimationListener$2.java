package androidx.core.splashscreen;

import android.view.View;
import androidx.core.splashscreen.SplashScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"androidx/core/splashscreen/SplashScreen$Impl$setOnExitAnimationListener$2", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashScreen$Impl$setOnExitAnimationListener$2 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.Impl f11407b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SplashScreenViewProvider f11408c;

    public SplashScreen$Impl$setOnExitAnimationListener$2(SplashScreen.Impl impl, SplashScreenViewProvider splashScreenViewProvider) {
        this.f11407b = impl;
        this.f11408c = splashScreenViewProvider;
    }

    public void onLayoutChange(@NotNull View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.isAttachedToWindow()) {
            view.removeOnLayoutChangeListener(this);
            if (!this.f11407b.getSplashScreenWaitPredicate().shouldKeepOnScreen()) {
                this.f11407b.dispatchOnExitAnimation(this.f11408c);
            } else {
                this.f11407b.mSplashScreenViewProvider = this.f11408c;
            }
        }
    }
}
