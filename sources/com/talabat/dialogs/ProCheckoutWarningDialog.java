package com.talabat.dialogs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.designsystem.ds_dialog.DSDialogSecondaryAction;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/talabat/dialogs/ProCheckoutWarningDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialog", "Lcom/designsystem/ds_dialog/DSDialog;", "getDialog", "()Lcom/designsystem/ds_dialog/DSDialog;", "showProCheckoutWarningDialog", "", "rootView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "onClick", "Lkotlin/Function1;", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProCheckoutWarningDialog {
    @NotNull
    private final DSDialog dialog;

    public ProCheckoutWarningDialog(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dialog = new DSDialog(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final DSDialog getDialog() {
        return this.dialog;
    }

    public final void showProCheckoutWarningDialog(@NotNull ViewGroup viewGroup, @NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        this.dialog.setProperties(new DialogProperties(false, false, (SecureFlagPolicy) null, 4, (DefaultConstructorMarker) null));
        this.dialog.setTitle(activity.getString(R.string.pro_subscription_error_warning_title));
        this.dialog.setContent(activity.getString(R.string.pro_subscription_error_warning_detail));
        DSDialog dSDialog = this.dialog;
        String string = activity.getString(R.string.proceed_with_order_button_text);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…d_with_order_button_text)");
        dSDialog.setPrimaryAction(new DSDialogPrimaryAction(string, new ProCheckoutWarningDialog$showProCheckoutWarningDialog$1(this, function1), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
        DSDialog dSDialog2 = this.dialog;
        String string2 = activity.getString(R.string.go_back_button_text);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.go_back_button_text)");
        dSDialog2.setSecondaryAction(new DSDialogSecondaryAction(string2, new ProCheckoutWarningDialog$showProCheckoutWarningDialog$2(this)));
        this.dialog.show(viewGroup);
    }
}
