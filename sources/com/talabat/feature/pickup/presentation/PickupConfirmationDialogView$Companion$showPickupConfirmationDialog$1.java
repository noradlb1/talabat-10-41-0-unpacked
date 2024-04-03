package com.talabat.feature.pickup.presentation;

import com.designsystem.ds_dialog.DSDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupConfirmationDialogView$Companion$showPickupConfirmationDialog$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSDialog f58661g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f58662h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupConfirmationDialogView$Companion$showPickupConfirmationDialog$1(DSDialog dSDialog, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.f58661g = dSDialog;
        this.f58662h = function1;
    }

    public final void invoke() {
        this.f58661g.close();
        this.f58662h.invoke(Boolean.TRUE);
    }
}
