package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.core.app.ActivityCompat;
import f2.b;
import f2.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0017"}, d2 = {"Landroidx/navigation/Navigation;", "", "()V", "createNavigateOnClickListener", "Landroid/view/View$OnClickListener;", "directions", "Landroidx/navigation/NavDirections;", "resId", "", "args", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "activity", "Landroid/app/Activity;", "viewId", "view", "Landroid/view/View;", "findViewNavController", "getViewNavController", "setViewNavController", "", "controller", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Navigation {
    @NotNull
    public static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int i11) {
        return createNavigateOnClickListener$default(i11, (Bundle) null, 2, (Object) null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int i11, @Nullable Bundle bundle) {
        return new c(i11, bundle);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int i11, Bundle bundle, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bundle = null;
        }
        return createNavigateOnClickListener(i11, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: createNavigateOnClickListener$lambda-0  reason: not valid java name */
    public static final void m9102createNavigateOnClickListener$lambda0(int i11, Bundle bundle, View view) {
        Intrinsics.checkNotNullExpressionValue(view, "view");
        findNavController(view).navigate(i11, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: createNavigateOnClickListener$lambda-1  reason: not valid java name */
    public static final void m9103createNavigateOnClickListener$lambda1(NavDirections navDirections, View view) {
        Intrinsics.checkNotNullParameter(navDirections, "$directions");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        findNavController(view).navigate(navDirections);
    }

    @JvmStatic
    @NotNull
    public static final NavController findNavController(@NotNull Activity activity, @IdRes int i11) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View requireViewById = ActivityCompat.requireViewById(activity, i11);
        Intrinsics.checkNotNullExpressionValue(requireViewById, "requireViewById<View>(activity, viewId)");
        NavController findViewNavController = INSTANCE.findViewNavController(requireViewById);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i11);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(SequencesKt__SequencesKt.generateSequence(view, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    /* access modifiers changed from: private */
    public final NavController getViewNavController(View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @JvmStatic
    public static final void setViewNavController(@NotNull View view, @Nullable NavController navController) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    @JvmStatic
    @NotNull
    public static final View.OnClickListener createNavigateOnClickListener(@NotNull NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        return new b(navDirections);
    }

    @JvmStatic
    @NotNull
    public static final NavController findNavController(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController findViewNavController = INSTANCE.findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
