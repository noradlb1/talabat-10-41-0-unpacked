package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0014R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Landroidx/navigation/ui/ToolbarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "", "onDestinationChanged", "", "title", "b", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "a", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/widget/Toolbar;", "toolbarWeakReference", "Ljava/lang/ref/WeakReference;", "toolbar", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "<init>", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/ui/AppBarConfiguration;)V", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
public final class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    @NotNull
    private final WeakReference<Toolbar> toolbarWeakReference;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ToolbarOnDestinationChangedListener(@org.jetbrains.annotations.NotNull androidx.appcompat.widget.Toolbar r3, @org.jetbrains.annotations.NotNull androidx.navigation.ui.AppBarConfiguration r4) {
        /*
            r2 = this;
            java.lang.String r0 = "toolbar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "toolbar.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0, r4)
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r3)
            r2.toolbarWeakReference = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ToolbarOnDestinationChangedListener.<init>(androidx.appcompat.widget.Toolbar, androidx.navigation.ui.AppBarConfiguration):void");
    }

    public void a(@Nullable Drawable drawable, @StringRes int i11) {
        boolean z11;
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            if (drawable != null || toolbar.getNavigationIcon() == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i11);
            if (z11) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    public void b(@Nullable CharSequence charSequence) {
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
    }

    public void onDestinationChanged(@NotNull NavController navController, @NotNull NavDestination navDestination, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        if (this.toolbarWeakReference.get() == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }
}
