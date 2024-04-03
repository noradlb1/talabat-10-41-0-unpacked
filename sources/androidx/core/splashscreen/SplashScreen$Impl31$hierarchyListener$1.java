package androidx.core.splashscreen;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.window.SplashScreenView;
import androidx.core.splashscreen.SplashScreen;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"androidx/core/splashscreen/SplashScreen$Impl31$hierarchyListener$1", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashScreen$Impl31$hierarchyListener$1 implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.Impl31 f11409b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f11410c;

    public SplashScreen$Impl31$hierarchyListener$1(SplashScreen.Impl31 impl31, Activity activity) {
        this.f11409b = impl31;
        this.f11410c = activity;
    }

    public void onChildViewAdded(@Nullable View view, @Nullable View view2) {
        if (view2 instanceof SplashScreenView) {
            SplashScreen.Impl31 impl31 = this.f11409b;
            impl31.setMDecorFitWindowInsets(impl31.computeDecorFitsWindow((SplashScreenView) view2));
            ((ViewGroup) this.f11410c.getWindow().getDecorView()).setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
        }
    }

    public void onChildViewRemoved(@Nullable View view, @Nullable View view2) {
    }
}
