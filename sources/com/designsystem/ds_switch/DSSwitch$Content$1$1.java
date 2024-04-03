package com.designsystem.ds_switch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSwitch$Content$1$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSwitch f33024g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f33025h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSwitch$Content$1$1(DSSwitch dSSwitch, Function1<? super Boolean, Unit> function1) {
        super(1);
        this.f33024g = dSSwitch;
        this.f33025h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        this.f33024g.setSwitchChecked(z11);
        this.f33025h.invoke(Boolean.valueOf(z11));
    }
}
