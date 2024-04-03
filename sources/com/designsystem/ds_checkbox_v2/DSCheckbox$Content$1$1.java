package com.designsystem.ds_checkbox_v2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCheckbox$Content$1$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSCheckbox f30890g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f30891h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCheckbox$Content$1$1(DSCheckbox dSCheckbox, Function1<? super Boolean, Unit> function1) {
        super(1);
        this.f30890g = dSCheckbox;
        this.f30891h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        this.f30890g.setCheckboxChecked(z11);
        this.f30891h.invoke(Boolean.valueOf(z11));
    }
}
