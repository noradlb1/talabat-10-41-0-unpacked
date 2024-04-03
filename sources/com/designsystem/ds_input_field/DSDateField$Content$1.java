package com.designsystem.ds_input_field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDateField$Content$1 extends Lambda implements Function1<Long, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSDateField f31384g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDateField$Content$1(DSDateField dSDateField) {
        super(1);
        this.f31384g = dSDateField;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j11) {
        this.f31384g.setDate(Long.valueOf(j11));
        Function1<Long, Unit> onDateChange = this.f31384g.getOnDateChange();
        if (onDateChange != null) {
            onDateChange.invoke(Long.valueOf(j11));
        }
    }
}
