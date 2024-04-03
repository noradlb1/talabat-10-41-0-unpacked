package com.talabat.userandlocation.compliance.verification.ui.activity;

import androidx.appcompat.widget.Toolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class UserVerificationHostActivity$onAttachFragment$1 extends FunctionReferenceImpl implements Function1<Toolbar, Unit> {
    public UserVerificationHostActivity$onAttachFragment$1(Object obj) {
        super(1, obj, UserVerificationHostActivity.class, "setupToolBar", "setupToolBar(Landroidx/appcompat/widget/Toolbar;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Toolbar) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "p0");
        ((UserVerificationHostActivity) this.receiver).setupToolBar(toolbar);
    }
}
