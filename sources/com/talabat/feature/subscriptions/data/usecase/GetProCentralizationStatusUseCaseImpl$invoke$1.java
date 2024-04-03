package com.talabat.feature.subscriptions.data.usecase;

import com.talabat.feature.subscriptions.domain.model.CountryParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl", f = "GetProCentralizationStatusUseCaseImpl.kt", i = {0}, l = {17}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetProCentralizationStatusUseCaseImpl$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58956h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58957i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetProCentralizationStatusUseCaseImpl f58958j;

    /* renamed from: k  reason: collision with root package name */
    public int f58959k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetProCentralizationStatusUseCaseImpl$invoke$1(GetProCentralizationStatusUseCaseImpl getProCentralizationStatusUseCaseImpl, Continuation<? super GetProCentralizationStatusUseCaseImpl$invoke$1> continuation) {
        super(continuation);
        this.f58958j = getProCentralizationStatusUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58957i = obj;
        this.f58959k |= Integer.MIN_VALUE;
        return this.f58958j.invoke((CountryParams) null, this);
    }
}
