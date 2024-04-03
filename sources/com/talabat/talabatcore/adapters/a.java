package com.talabat.talabatcore.adapters;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f12013b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Binding f12014c;

    public /* synthetic */ a(Function2 function2, Binding binding) {
        this.f12013b = function2;
        this.f12014c = binding;
    }

    public final void accept(Object obj) {
        FunctionalAdaptersKt.m5824disposable$lambda6(this.f12013b, this.f12014c, (List) obj);
    }
}
