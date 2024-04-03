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
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {0, 0}, l = {170}, m = "withFiltersAndCollectionIds", n = {"filter", "selectedCollectionId"}, s = {"L$0", "L$1"})
public final class UseCasesKt$withFiltersAndCollectionIds$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59558h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59559i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59560j;

    /* renamed from: k  reason: collision with root package name */
    public int f59561k;

    public UseCasesKt$withFiltersAndCollectionIds$1(Continuation<? super UseCasesKt$withFiltersAndCollectionIds$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59560j = obj;
        this.f59561k |= Integer.MIN_VALUE;
        return UseCasesKt.withFiltersAndCollectionIds((Deferred<? extends List<? extends Restaurant>>) null, (Filter) null, (Integer) null, this);
    }
}
