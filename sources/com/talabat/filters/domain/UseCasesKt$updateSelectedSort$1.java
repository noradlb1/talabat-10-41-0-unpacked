package com.talabat.filters.domain;

import datamodels.filters.SelectableSortType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {0}, l = {190}, m = "updateSelectedSort", n = {"selectedSelectableSortType"}, s = {"L$0"})
public final class UseCasesKt$updateSelectedSort$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59552h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59553i;

    /* renamed from: j  reason: collision with root package name */
    public int f59554j;

    public UseCasesKt$updateSelectedSort$1(Continuation<? super UseCasesKt$updateSelectedSort$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59553i = obj;
        this.f59554j |= Integer.MIN_VALUE;
        return UseCasesKt.updateSelectedSort((SelectableSortType) null, (FiltersRepository) null, this);
    }
}
