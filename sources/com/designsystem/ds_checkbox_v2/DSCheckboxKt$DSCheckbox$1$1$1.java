package com.designsystem.ds_checkbox_v2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCheckboxKt$DSCheckbox$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f30899g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30900h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCheckboxKt$DSCheckbox$1$1$1(Function1<? super Boolean, Unit> function1, boolean z11) {
        super(0);
        this.f30899g = function1;
        this.f30900h = z11;
    }

    public final void invoke() {
        this.f30899g.invoke(Boolean.valueOf(!this.f30900h));
    }
}
