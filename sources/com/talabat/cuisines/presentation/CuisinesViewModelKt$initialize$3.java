package com.talabat.cuisines.presentation;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CuisinesViewModelKt$initialize$3 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public CuisinesViewModelKt$initialize$3(Object obj) {
        super(1, obj, MutableLiveData.class, "setValue", "setValue(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2) {
        ((MutableLiveData) this.receiver).setValue(th2);
    }
}
