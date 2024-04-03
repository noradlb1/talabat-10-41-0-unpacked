package androidx.core.splashscreen;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.splashscreen.SplashScreen;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/core/splashscreen/SplashScreen$Impl31$setKeepOnScreenCondition$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashScreen$Impl31$setKeepOnScreenCondition$1 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.Impl31 f11411b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f11412c;

    public SplashScreen$Impl31$setKeepOnScreenCondition$1(SplashScreen.Impl31 impl31, View view) {
        this.f11411b = impl31;
        this.f11412c = view;
    }

    public boolean onPreDraw() {
        if (this.f11411b.getSplashScreenWaitPredicate().shouldKeepOnScreen()) {
            return false;
        }
        this.f11412c.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
