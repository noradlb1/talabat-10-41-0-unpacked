package com.talabat.darkstores.feature.main;

import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/afollestad/materialdialogs/MaterialDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMainActivity$showBottomCartViewError$2$3 extends Lambda implements Function1<MaterialDialog, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MaterialDialog f56457g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$showBottomCartViewError$2$3(MaterialDialog materialDialog) {
        super(1);
        this.f56457g = materialDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MaterialDialog) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkNotNullParameter(materialDialog, "it");
        this.f56457g.dismiss();
    }
}
