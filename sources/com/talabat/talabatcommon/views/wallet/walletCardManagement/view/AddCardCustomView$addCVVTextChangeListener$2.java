package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddCardCustomView$addCVVTextChangeListener$2 extends Lambda implements Function1<Editable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f11949g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddCardCustomView$addCVVTextChangeListener$2(AddCardCustomView addCardCustomView) {
        super(1);
        this.f11949g = addCardCustomView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "it");
        this.f11949g.getViewModel().onCardCVVInput(editable.toString(), false);
    }
}
