package com.talabat.userandlocation.compliance.verification.ui.fragment;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationFragment$observeValidationErrorDialogMessage$1$1 extends Lambda implements Function1<DialogInterface, Unit> {
    public static final UserVerificationFragment$observeValidationErrorDialogMessage$1$1 INSTANCE = new UserVerificationFragment$observeValidationErrorDialogMessage$1$1();

    public UserVerificationFragment$observeValidationErrorDialogMessage$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DialogInterface) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "it");
        dialogInterface.dismiss();
    }
}
