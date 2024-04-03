package com.talabat.filters.domain;

import datamodels.Filter;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {0}, l = {122}, m = "withFilterIds", n = {"filter"}, s = {"L$0"})
public final class UseCasesKt$withFilterIds$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59555h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59556i;

    /* renamed from: j  reason: collision with root package name */
    public int f59557j;

    public UseCasesKt$withFilterIds$1(Continuation<? super UseCasesKt$withFilterIds$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59556i = obj;
        this.f59557j |= Integer.MIN_VALUE;
        return UseCasesKt.withFilterIds((Deferred<? extends List<? extends Restaurant>>) null, (Filter) null, this);
    }
}
