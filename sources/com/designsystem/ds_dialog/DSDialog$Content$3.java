package com.designsystem.ds_dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDialog$Content$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSDialog f31065g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDialog$Content$3(DSDialog dSDialog) {
        super(0);
        this.f31065g = dSDialog;
    }

    public final void invoke() {
        Function0<Unit> onDismissRequest = this.f31065g.getOnDismissRequest();
        if (onDismissRequest != null) {
            onDismissRequest.invoke();
        }
        this.f31065g.close();
    }
}
