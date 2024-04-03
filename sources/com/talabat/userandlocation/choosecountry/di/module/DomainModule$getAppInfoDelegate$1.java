package com.talabat.userandlocation.choosecountry.di.module;

import com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DomainModule$getAppInfoDelegate$1 extends FunctionReferenceImpl implements Function2<Integer, Continuation<? super Unit>, Object>, SuspendFunction {
    public DomainModule$getAppInfoDelegate$1(Object obj) {
        super(2, obj, AppInfoRepositoryImpl.class, "fetchAppInfo", "fetchAppInfo(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(int i11, @NotNull Continuation<? super Unit> continuation) {
        return ((AppInfoRepositoryImpl) this.receiver).fetchAppInfo(i11, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }
}
