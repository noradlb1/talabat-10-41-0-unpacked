package com.talabat.filters.presentation;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class FiltersViewModelKt$launchWithProgress$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public FiltersViewModelKt$launchWithProgress$1(Object obj) {
        super(1, obj, MutableLiveData.class, "postValue", "postValue(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2) {
        ((MutableLiveData) this.receiver).postValue(th2);
    }
}
