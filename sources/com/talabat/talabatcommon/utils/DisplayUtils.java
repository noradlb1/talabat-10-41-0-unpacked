package com.talabat.talabatcommon.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import gv.c;
import io.flutter.plugin.platform.PlatformPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/utils/DisplayUtils;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisplayUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/utils/DisplayUtils$Companion;", "", "()V", "setStatusBarHeight", "", "view", "Landroid/view/View;", "viewToApplyPaddingTo", "setWindowFlag", "activity", "Landroid/app/Activity;", "bits", "", "on", "", "transparentStatus", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: setStatusBarHeight$lambda-1  reason: not valid java name */
        public static final WindowInsets m10943setStatusBarHeight$lambda1(View view, View view2, WindowInsets windowInsets) {
            Intrinsics.checkNotNullParameter(view, "$viewToApplyPaddingTo");
            Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(windowInsets, "insets");
            int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = systemWindowInsetTop;
                return windowInsets;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        private final void setWindowFlag(Activity activity, int i11, boolean z11) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.getWindow()");
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z11) {
                attributes.flags = i11 | attributes.flags;
            } else {
                attributes.flags = (~i11) & attributes.flags;
            }
            window.setAttributes(attributes);
        }

        @RequiresApi(20)
        public final void setStatusBarHeight(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(view2, "viewToApplyPaddingTo");
            view.setOnApplyWindowInsetsListener(new c(view2));
        }

        public final void transparentStatus(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
            setWindowFlag(activity, 67108864, false);
            activity.getWindow().setStatusBarColor(0);
        }
    }
}
