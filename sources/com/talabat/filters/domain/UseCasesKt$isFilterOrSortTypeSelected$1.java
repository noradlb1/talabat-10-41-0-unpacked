package com.talabat.filters.domain;

import datamodels.Filter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {0, 0, 1, 1, 2, 2}, l = {217, 218, 219}, m = "isFilterOrSortTypeSelected", n = {"requestSelectedFilters", "requestSelectablePopularFilters", "requestSelectablePopularFilters", "sortType", "sortType", "filters"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class UseCasesKt$isFilterOrSortTypeSelected$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59463h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59464i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59465j;

    /* renamed from: k  reason: collision with root package name */
    public int f59466k;

    public UseCasesKt$isFilterOrSortTypeSelected$1(Continuation<? super UseCasesKt$isFilterOrSortTypeSelected$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59465j = obj;
        this.f59466k |= Integer.MIN_VALUE;
        return UseCasesKt.isFilterOrSortTypeSelected((Function1<? super Continuation<? super SortType>, ? extends Object>) null, (Function1<? super Continuation<? super List<? extends Filter>>, ? extends Object>) null, (Function1<? super Continuation<? super List<SelectablePopularFilter>>, ? extends Object>) null, this);
    }
}
