package com.talabat.feature.fees.presentation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.facebook.internal.NativeProtocol;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/fees/presentation/ui/FeesMismatchErrorDialog;", "", "()V", "show", "", "parentView", "Landroid/view/ViewGroup;", "content", "", "action", "Landroid/view/View$OnClickListener;", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesMismatchErrorDialog {
    public static final int $stable = 0;
    @NotNull
    public static final FeesMismatchErrorDialog INSTANCE = new FeesMismatchErrorDialog();

    private FeesMismatchErrorDialog() {
    }

    @JvmStatic
    public static final void show(@NotNull ViewGroup viewGroup, @NotNull String str, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(onClickListener, NativeProtocol.WEB_DIALOG_ACTION);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        DSDialog dSDialog = new DSDialog(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSDialog.setTitle(ViewKt.getString(viewGroup, R.string.fees_mismatch_error_title));
        dSDialog.setContent(str);
        dSDialog.setPrimaryAction(new DSDialogPrimaryAction(ViewKt.getString(viewGroup, R.string.fees_mismatch_cta), new FeesMismatchErrorDialog$show$1(onClickListener, dSDialog), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
        dSDialog.show(viewGroup);
    }
}
