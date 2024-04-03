package com.afollestad.materialdialogs.customview;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.LayoutRes;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aO\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u0007*\u00020\u0003H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"CUSTOM_VIEW_NO_VERTICAL_PADDING", "", "customView", "Lcom/afollestad/materialdialogs/MaterialDialog;", "viewRes", "", "view", "Landroid/view/View;", "scrollable", "", "noVerticalPadding", "horizontalPadding", "dialogWrapContent", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Landroid/view/View;ZZZZ)Lcom/afollestad/materialdialogs/MaterialDialog;", "getCustomView", "com.afollestad.material-dialogs.core"}, k = 2, mv = {1, 1, 15})
public final class DialogCustomViewExtKt {
    @NotNull
    public static final String CUSTOM_VIEW_NO_VERTICAL_PADDING = "md.custom_view_no_vertical_padding";

    @NotNull
    public static final MaterialDialog customView(@NotNull MaterialDialog materialDialog, @Nullable @LayoutRes Integer num, @Nullable View view, boolean z11, boolean z12, boolean z13, boolean z14) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$customView");
        MDUtil mDUtil = MDUtil.INSTANCE;
        mDUtil.assertOneSet("customView", view, num);
        materialDialog.getConfig().put(CUSTOM_VIEW_NO_VERTICAL_PADDING, Boolean.valueOf(z12));
        if (z14) {
            MaterialDialog.maxWidth$default(materialDialog, (Integer) null, 0, 1, (Object) null);
        }
        View addCustomView = materialDialog.getView().getContentLayout().addCustomView(num, view, z11, z13);
        if (z14) {
            mDUtil.waitForWidth(addCustomView, new DialogCustomViewExtKt$customView$$inlined$also$lambda$1(materialDialog, z14));
        }
        return materialDialog;
    }

    public static /* synthetic */ MaterialDialog customView$default(MaterialDialog materialDialog, Integer num, View view, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            view = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            z12 = false;
        }
        if ((i11 & 16) != 0) {
            z13 = false;
        }
        if ((i11 & 32) != 0) {
            z14 = false;
        }
        return customView(materialDialog, num, view, z11, z12, z13, z14);
    }

    @CheckResult
    @NotNull
    public static final View getCustomView(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$getCustomView");
        View customView = materialDialog.getView().getContentLayout().getCustomView();
        if (customView != null) {
            return customView;
        }
        throw new IllegalStateException("You have not setup this dialog as a customView dialog.");
    }
}
