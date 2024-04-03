package com.designsystem.ds_alert;

import com.designsystem.ds_icon_button.DSIconButtonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertIconButton$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f30507g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertIconButton$1$1$1(DSIconButtonModel dSIconButtonModel) {
        super(0);
        this.f30507g = dSIconButtonModel;
    }

    public final void invoke() {
        this.f30507g.getOnTap().invoke();
    }
}
