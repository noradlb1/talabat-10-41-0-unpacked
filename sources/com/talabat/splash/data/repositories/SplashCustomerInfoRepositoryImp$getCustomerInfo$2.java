package com.talabat.splash.data.repositories;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashCustomerInfoRepositoryImp$getCustomerInfo$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public SplashCustomerInfoRepositoryImp$getCustomerInfo$2(Object obj) {
        super(1, obj, SplashCustomerInfoRepositoryImp.class, "handleThrowable", "handleThrowable(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        ((SplashCustomerInfoRepositoryImp) this.receiver).handleThrowable(th2);
    }
}
