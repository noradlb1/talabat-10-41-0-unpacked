package com.talabat.wallet.bnplmanager.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentErrorDialog$setPrimaryButton$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BNPLOrderPaymentErrorDialog f12510g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f12511h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLOrderPaymentErrorDialog$setPrimaryButton$1(BNPLOrderPaymentErrorDialog bNPLOrderPaymentErrorDialog, boolean z11) {
        super(0);
        this.f12510g = bNPLOrderPaymentErrorDialog;
        this.f12511h = z11;
    }

    public final void invoke() {
        BnplOrderPaymentErrorDialogCallback access$getCallback$p;
        this.f12510g.getDialog().close();
        if (this.f12511h && (access$getCallback$p = this.f12510g.callback) != null) {
            access$getCallback$p.onChangeCardClicked();
        }
    }
}
