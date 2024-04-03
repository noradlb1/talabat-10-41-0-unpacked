package com.talabat.wallet.bnplmanager.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.designsystem.ds_dialog.DSDialogSecondaryAction;
import com.talabat.localization.R;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLOrderPaymentErrorDialog;", "", "context", "Landroid/content/Context;", "bnplOrderPaymentError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "callback", "Lcom/talabat/wallet/bnplmanager/ui/BnplOrderPaymentErrorDialogCallback;", "(Landroid/content/Context;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;Lcom/talabat/wallet/bnplmanager/ui/BnplOrderPaymentErrorDialogCallback;)V", "dialog", "Lcom/designsystem/ds_dialog/DSDialog;", "getDialog", "()Lcom/designsystem/ds_dialog/DSDialog;", "setPrimaryButton", "", "isCardValidationFailed", "", "setSecondaryButton", "show", "rootView", "Landroid/view/ViewGroup;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentErrorDialog {
    @NotNull
    private final BNPLOrderPaymentError bnplOrderPaymentError;
    /* access modifiers changed from: private */
    @Nullable
    public final BnplOrderPaymentErrorDialogCallback callback;
    @NotNull
    private final Context context;
    @NotNull
    private final DSDialog dialog;

    public BNPLOrderPaymentErrorDialog(@NotNull Context context2, @NotNull BNPLOrderPaymentError bNPLOrderPaymentError, @Nullable BnplOrderPaymentErrorDialogCallback bnplOrderPaymentErrorDialogCallback) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentError, "bnplOrderPaymentError");
        this.context = context2;
        this.bnplOrderPaymentError = bNPLOrderPaymentError;
        this.callback = bnplOrderPaymentErrorDialogCallback;
        this.dialog = new DSDialog(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    private final void setPrimaryButton(boolean z11) {
        String string = this.context.getString(R.string.f61016ok);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.ok)");
        if (z11) {
            string = "Change card";
        }
        this.dialog.setPrimaryAction(new DSDialogPrimaryAction(string, new BNPLOrderPaymentErrorDialog$setPrimaryButton$1(this, z11), DSDialogPrimaryActionType.NORMAL));
    }

    private final void setSecondaryButton() {
        DSDialog dSDialog = this.dialog;
        String string = this.context.getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.close)");
        dSDialog.setSecondaryAction(new DSDialogSecondaryAction(string, new BNPLOrderPaymentErrorDialog$setSecondaryButton$1(this)));
    }

    @NotNull
    public final DSDialog getDialog() {
        return this.dialog;
    }

    public final void show(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        String code = this.bnplOrderPaymentError.getCode();
        this.dialog.setTitle(this.bnplOrderPaymentError.getTitle());
        this.dialog.setContent(this.bnplOrderPaymentError.getDescription());
        this.dialog.setProperties(new DialogProperties(false, false, SecureFlagPolicy.SecureOn));
        boolean areEqual = Intrinsics.areEqual((Object) code, (Object) BNPLOrderPaymentErrorDialogKt.ERROR_CODE_CARD_VALIDATION_FAILED);
        if (areEqual) {
            setSecondaryButton();
        }
        setPrimaryButton(areEqual);
        this.dialog.show(viewGroup);
    }
}
