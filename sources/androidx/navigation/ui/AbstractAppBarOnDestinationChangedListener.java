package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H$J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\f\u001a\u00020\u000bH$J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "showAsDrawerIndicator", "", "setActionBarUpIndicator", "", "title", "b", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "a", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "onDestinationChanged", "Landroid/content/Context;", "context", "Landroid/content/Context;", "", "topLevelDestinations", "Ljava/util/Set;", "Ljava/lang/ref/WeakReference;", "Landroidx/customview/widget/Openable;", "kotlin.jvm.PlatformType", "openableLayoutWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "arrowDrawable", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "<init>", "(Landroid/content/Context;Landroidx/navigation/ui/AppBarConfiguration;)V", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    @Nullable
    private ValueAnimator animator;
    @Nullable
    private DrawerArrowDrawable arrowDrawable;
    @NotNull
    private final Context context;
    @Nullable
    private final WeakReference<Openable> openableLayoutWeakReference;
    @NotNull
    private final Set<Integer> topLevelDestinations;

    public AbstractAppBarOnDestinationChangedListener(@NotNull Context context2, @NotNull AppBarConfiguration appBarConfiguration) {
        WeakReference<Openable> weakReference;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "configuration");
        this.context = context2;
        this.topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        if (openableLayout != null) {
            weakReference = new WeakReference<>(openableLayout);
        } else {
            weakReference = null;
        }
        this.openableLayoutWeakReference = weakReference;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void setActionBarUpIndicator(boolean z11) {
        Pair pair;
        int i11;
        float f11;
        DrawerArrowDrawable drawerArrowDrawable = this.arrowDrawable;
        if (drawerArrowDrawable == null || (pair = TuplesKt.to(drawerArrowDrawable, Boolean.TRUE)) == null) {
            DrawerArrowDrawable drawerArrowDrawable2 = new DrawerArrowDrawable(this.context);
            this.arrowDrawable = drawerArrowDrawable2;
            pair = TuplesKt.to(drawerArrowDrawable2, Boolean.FALSE);
        }
        DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) pair.component1();
        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
        if (z11) {
            i11 = R.string.nav_app_bar_open_drawer_description;
        } else {
            i11 = R.string.nav_app_bar_navigate_up_description;
        }
        a(drawerArrowDrawable3, i11);
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = 1.0f;
        }
        if (booleanValue) {
            float progress = drawerArrowDrawable3.getProgress();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawerArrowDrawable3, "progress", new float[]{progress, f11});
            this.animator = ofFloat;
            if (ofFloat != null) {
                ofFloat.start();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
        }
        drawerArrowDrawable3.setProgress(f11);
    }

    public abstract void a(@Nullable Drawable drawable, @StringRes int i11);

    public abstract void b(@Nullable CharSequence charSequence);

    public void onDestinationChanged(@NotNull NavController navController, @NotNull NavDestination navDestination, @Nullable Bundle bundle) {
        Openable openable;
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        if (!(navDestination instanceof FloatingWindow)) {
            WeakReference<Openable> weakReference = this.openableLayoutWeakReference;
            if (weakReference != null) {
                openable = weakReference.get();
            } else {
                openable = null;
            }
            if (this.openableLayoutWeakReference == null || openable != null) {
                CharSequence label = navDestination.getLabel();
                boolean z11 = true;
                if (label != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle == null || !bundle.containsKey(group)) {
                            throw new IllegalArgumentException("Could not find \"" + group + "\" in " + bundle + " to fill label \"" + label + '\"');
                        }
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(String.valueOf(bundle.get(group)));
                    }
                    matcher.appendTail(stringBuffer);
                    b(stringBuffer);
                }
                boolean matchDestinations$navigation_ui_release = NavigationUI.matchDestinations$navigation_ui_release(navDestination, this.topLevelDestinations);
                if (openable != null || !matchDestinations$navigation_ui_release) {
                    if (openable == null || !matchDestinations$navigation_ui_release) {
                        z11 = false;
                    }
                    setActionBarUpIndicator(z11);
                    return;
                }
                a((Drawable) null, 0);
                return;
            }
            navController.removeOnDestinationChangedListener(this);
        }
    }
}
