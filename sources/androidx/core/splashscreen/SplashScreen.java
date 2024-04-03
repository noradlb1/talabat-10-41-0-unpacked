package androidx.core.splashscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.window.SplashScreenView;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.core.splashscreen.ThemeUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/core/splashscreen/SplashScreen;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "impl", "Landroidx/core/splashscreen/SplashScreen$Impl;", "install", "", "setKeepOnScreenCondition", "condition", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setOnExitAnimationListener", "listener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "Companion", "Impl", "Impl31", "KeepOnScreenCondition", "OnExitAnimationListener", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
public final class SplashScreen {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MASK_FACTOR = 0.6666667f;
    @NotNull
    private final Impl impl;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Companion;", "", "()V", "MASK_FACTOR", "", "installSplashScreen", "Landroidx/core/splashscreen/SplashScreen;", "Landroid/app/Activity;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SplashScreen installSplashScreen(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            SplashScreen splashScreen = new SplashScreen(activity, (DefaultConstructorMarker) null);
            splashScreen.install();
            return splashScreen;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tR\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0004J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006E"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl;", "", "Landroid/view/View;", "splashScreenView", "Landroid/graphics/drawable/Drawable;", "icon", "", "displaySplashScreenIcon", "install", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "currentTheme", "Landroid/util/TypedValue;", "typedValue", "c", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "keepOnScreenCondition", "setKeepOnScreenCondition", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "exitAnimationListener", "setOnExitAnimationListener", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "splashScreenViewProvider", "dispatchOnExitAnimation", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "", "finalThemeId", "I", "getFinalThemeId", "()I", "setFinalThemeId", "(I)V", "backgroundResId", "Ljava/lang/Integer;", "getBackgroundResId", "()Ljava/lang/Integer;", "setBackgroundResId", "(Ljava/lang/Integer;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "hasBackground", "Z", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "splashScreenWaitPredicate", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "getSplashScreenWaitPredicate", "()Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setSplashScreenWaitPredicate", "(Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;)V", "animationListener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "mSplashScreenViewProvider", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "<init>", "(Landroid/app/Activity;)V", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public static class Impl {
        @NotNull
        private final Activity activity;
        @Nullable
        private OnExitAnimationListener animationListener;
        @Nullable
        private Integer backgroundColor;
        @Nullable
        private Integer backgroundResId;
        private int finalThemeId;
        private boolean hasBackground;
        @Nullable
        private Drawable icon;
        /* access modifiers changed from: private */
        @Nullable
        public SplashScreenViewProvider mSplashScreenViewProvider;
        @NotNull
        private KeepOnScreenCondition splashScreenWaitPredicate = new b();

        public Impl(@NotNull Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchOnExitAnimation$lambda-3  reason: not valid java name */
        public static final void m5738dispatchOnExitAnimation$lambda3(SplashScreenViewProvider splashScreenViewProvider, OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "$splashScreenViewProvider");
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "$finalListener");
            splashScreenViewProvider.getView().bringToFront();
            onExitAnimationListener.onSplashScreenExit(splashScreenViewProvider);
        }

        private final void displaySplashScreenIcon(View view, Drawable drawable) {
            float f11;
            ImageView imageView = (ImageView) view.findViewById(R.id.splashscreen_icon_view);
            if (this.hasBackground) {
                Drawable drawable2 = imageView.getContext().getDrawable(R.drawable.icon_background);
                f11 = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_with_background) * SplashScreen.MASK_FACTOR;
                if (drawable2 != null) {
                    imageView.setBackground(new MaskedDrawable(drawable2, f11));
                }
            } else {
                f11 = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_no_background) * SplashScreen.MASK_FACTOR;
            }
            imageView.setImageDrawable(new MaskedDrawable(drawable, f11));
        }

        /* access modifiers changed from: private */
        /* renamed from: splashScreenWaitPredicate$lambda-0  reason: not valid java name */
        public static final boolean m5739splashScreenWaitPredicate$lambda0() {
            return false;
        }

        public final void c(@NotNull Resources.Theme theme, @NotNull TypedValue typedValue) {
            Intrinsics.checkNotNullParameter(theme, "currentTheme");
            Intrinsics.checkNotNullParameter(typedValue, "typedValue");
            if (theme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true)) {
                int i11 = typedValue.resourceId;
                this.finalThemeId = i11;
                if (i11 != 0) {
                    this.activity.setTheme(i11);
                }
            }
        }

        public final void dispatchOnExitAnimation(@NotNull SplashScreenViewProvider splashScreenViewProvider) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "splashScreenViewProvider");
            OnExitAnimationListener onExitAnimationListener = this.animationListener;
            if (onExitAnimationListener != null) {
                this.animationListener = null;
                splashScreenViewProvider.getView().postOnAnimation(new a(splashScreenViewProvider, onExitAnimationListener));
            }
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }

        @Nullable
        public final Integer getBackgroundColor() {
            return this.backgroundColor;
        }

        @Nullable
        public final Integer getBackgroundResId() {
            return this.backgroundResId;
        }

        public final int getFinalThemeId() {
            return this.finalThemeId;
        }

        public final boolean getHasBackground() {
            return this.hasBackground;
        }

        @Nullable
        public final Drawable getIcon() {
            return this.icon;
        }

        @NotNull
        public final KeepOnScreenCondition getSplashScreenWaitPredicate() {
            return this.splashScreenWaitPredicate;
        }

        public void install() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.activity.getTheme();
            boolean z11 = true;
            if (theme.resolveAttribute(R.attr.windowSplashScreenBackground, typedValue, true)) {
                this.backgroundResId = Integer.valueOf(typedValue.resourceId);
                this.backgroundColor = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(R.attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.icon = theme.getDrawable(typedValue.resourceId);
            }
            if (theme.resolveAttribute(R.attr.splashScreenIconSize, typedValue, true)) {
                if (typedValue.resourceId != R.dimen.splashscreen_icon_size_with_background) {
                    z11 = false;
                }
                this.hasBackground = z11;
            }
            Intrinsics.checkNotNullExpressionValue(theme, "currentTheme");
            c(theme, typedValue);
        }

        public final void setBackgroundColor(@Nullable Integer num) {
            this.backgroundColor = num;
        }

        public final void setBackgroundResId(@Nullable Integer num) {
            this.backgroundResId = num;
        }

        public final void setFinalThemeId(int i11) {
            this.finalThemeId = i11;
        }

        public final void setHasBackground(boolean z11) {
            this.hasBackground = z11;
        }

        public final void setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
        }

        public void setKeepOnScreenCondition(@NotNull KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
            View findViewById = this.activity.findViewById(16908290);
            findViewById.getViewTreeObserver().addOnPreDrawListener(new SplashScreen$Impl$setKeepOnScreenCondition$1(this, findViewById));
        }

        public void setOnExitAnimationListener(@NotNull OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "exitAnimationListener");
            this.animationListener = onExitAnimationListener;
            SplashScreenViewProvider splashScreenViewProvider = new SplashScreenViewProvider(this.activity);
            Integer num = this.backgroundResId;
            Integer num2 = this.backgroundColor;
            View view = splashScreenViewProvider.getView();
            if (num != null && num.intValue() != 0) {
                view.setBackgroundResource(num.intValue());
            } else if (num2 != null) {
                view.setBackgroundColor(num2.intValue());
            } else {
                view.setBackground(this.activity.getWindow().getDecorView().getBackground());
            }
            Drawable drawable = this.icon;
            if (drawable != null) {
                displaySplashScreenIcon(view, drawable);
            }
            view.addOnLayoutChangeListener(new SplashScreen$Impl$setOnExitAnimationListener$2(this, splashScreenViewProvider));
        }

        public final void setSplashScreenWaitPredicate(@NotNull KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "<set-?>");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
        }
    }

    @RequiresApi(31)
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl31;", "Landroidx/core/splashscreen/SplashScreen$Impl;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "hierarchyListener", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "getHierarchyListener", "()Landroid/view/ViewGroup$OnHierarchyChangeListener;", "mDecorFitWindowInsets", "", "getMDecorFitWindowInsets", "()Z", "setMDecorFitWindowInsets", "(Z)V", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "applyAppSystemUiTheme", "", "computeDecorFitsWindow", "child", "Landroid/window/SplashScreenView;", "install", "setKeepOnScreenCondition", "keepOnScreenCondition", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setOnExitAnimationListener", "exitAnimationListener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Impl31 extends Impl {
        @NotNull
        private final ViewGroup.OnHierarchyChangeListener hierarchyListener;
        private boolean mDecorFitWindowInsets = true;
        @Nullable
        private ViewTreeObserver.OnPreDrawListener preDrawListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl31(@NotNull Activity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.hierarchyListener = new SplashScreen$Impl31$hierarchyListener$1(this, activity);
        }

        private final void applyAppSystemUiTheme() {
            boolean z11;
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getActivity().getTheme();
            Window window = getActivity().getWindow();
            boolean z12 = true;
            if (theme.resolveAttribute(16843857, typedValue, true)) {
                window.setStatusBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(16843858, typedValue, true)) {
                window.setNavigationBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(16843856, typedValue, true)) {
                if (typedValue.data != 0) {
                    window.addFlags(Integer.MIN_VALUE);
                } else {
                    window.clearFlags(Integer.MIN_VALUE);
                }
            }
            if (theme.resolveAttribute(16844293, typedValue, true)) {
                if (typedValue.data != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                window.setNavigationBarContrastEnforced(z11);
            }
            if (theme.resolveAttribute(16844292, typedValue, true)) {
                if (typedValue.data == 0) {
                    z12 = false;
                }
                window.setStatusBarContrastEnforced(z12);
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(theme, "theme");
            ThemeUtils.Api31.applyThemesSystemBarAppearance(theme, viewGroup, typedValue);
            viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
            window.setDecorFitsSystemWindows(this.mDecorFitWindowInsets);
        }

        /* access modifiers changed from: private */
        /* renamed from: setOnExitAnimationListener$lambda-0  reason: not valid java name */
        public static final void m5740setOnExitAnimationListener$lambda0(Impl31 impl31, OnExitAnimationListener onExitAnimationListener, SplashScreenView splashScreenView) {
            Intrinsics.checkNotNullParameter(impl31, "this$0");
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "$exitAnimationListener");
            Intrinsics.checkNotNullParameter(splashScreenView, "splashScreenView");
            impl31.applyAppSystemUiTheme();
            onExitAnimationListener.onSplashScreenExit(new SplashScreenViewProvider(splashScreenView, impl31.getActivity()));
        }

        public final boolean computeDecorFitsWindow(@NotNull SplashScreenView splashScreenView) {
            Intrinsics.checkNotNullParameter(splashScreenView, "child");
            WindowInsets a11 = new WindowInsets.Builder().build();
            Intrinsics.checkNotNullExpressionValue(a11, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            if (a11 != splashScreenView.getRootView().computeSystemWindowInsets(a11, rect) || !rect.isEmpty()) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ViewGroup.OnHierarchyChangeListener getHierarchyListener() {
            return this.hierarchyListener;
        }

        public final boolean getMDecorFitWindowInsets() {
            return this.mDecorFitWindowInsets;
        }

        @Nullable
        public final ViewTreeObserver.OnPreDrawListener getPreDrawListener() {
            return this.preDrawListener;
        }

        public void install() {
            Resources.Theme theme = getActivity().getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "activity.theme");
            c(theme, new TypedValue());
            ((ViewGroup) getActivity().getWindow().getDecorView()).setOnHierarchyChangeListener(this.hierarchyListener);
        }

        public void setKeepOnScreenCondition(@NotNull KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            setSplashScreenWaitPredicate(keepOnScreenCondition);
            View findViewById = getActivity().findViewById(16908290);
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            if (this.preDrawListener != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            }
            SplashScreen$Impl31$setKeepOnScreenCondition$1 splashScreen$Impl31$setKeepOnScreenCondition$1 = new SplashScreen$Impl31$setKeepOnScreenCondition$1(this, findViewById);
            this.preDrawListener = splashScreen$Impl31$setKeepOnScreenCondition$1;
            viewTreeObserver.addOnPreDrawListener(splashScreen$Impl31$setKeepOnScreenCondition$1);
        }

        public final void setMDecorFitWindowInsets(boolean z11) {
            this.mDecorFitWindowInsets = z11;
        }

        public void setOnExitAnimationListener(@NotNull OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "exitAnimationListener");
            getActivity().getSplashScreen().setOnExitAnimationListener(new c(this, onExitAnimationListener));
        }

        public final void setPreDrawListener(@Nullable ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.preDrawListener = onPreDrawListener;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "", "shouldKeepOnScreen", "", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface KeepOnScreenCondition {
        @MainThread
        boolean shouldKeepOnScreen();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "", "onSplashScreenExit", "", "splashScreenViewProvider", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnExitAnimationListener {
        @MainThread
        void onSplashScreenExit(@NotNull SplashScreenViewProvider splashScreenViewProvider);
    }

    private SplashScreen(Activity activity) {
        Impl impl2;
        if (Build.VERSION.SDK_INT >= 31) {
            impl2 = new Impl31(activity);
        } else {
            impl2 = new Impl(activity);
        }
        this.impl = impl2;
    }

    public /* synthetic */ SplashScreen(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    /* access modifiers changed from: private */
    public final void install() {
        this.impl.install();
    }

    @JvmStatic
    @NotNull
    public static final SplashScreen installSplashScreen(@NotNull Activity activity) {
        return Companion.installSplashScreen(activity);
    }

    public final void setKeepOnScreenCondition(@NotNull KeepOnScreenCondition keepOnScreenCondition) {
        Intrinsics.checkNotNullParameter(keepOnScreenCondition, "condition");
        this.impl.setKeepOnScreenCondition(keepOnScreenCondition);
    }

    public final void setOnExitAnimationListener(@NotNull OnExitAnimationListener onExitAnimationListener) {
        Intrinsics.checkNotNullParameter(onExitAnimationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.impl.setOnExitAnimationListener(onExitAnimationListener);
    }
}
