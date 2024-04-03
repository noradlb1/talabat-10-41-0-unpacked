package com.designsystem.ds_alert;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertContent$1$2$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSAlertActionButtonModel f30498g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertContent$1$2$1$1(DSAlertActionButtonModel dSAlertActionButtonModel) {
        super(0);
        this.f30498g = dSAlertActionButtonModel;
    }

    public final void invoke() {
        this.f30498g.getOnTap().invoke();
    }
}
