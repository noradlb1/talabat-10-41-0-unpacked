package com.talabat.filters.domain;

import datamodels.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class UseCasesKt$isCollectionsFilterOrSortTypeSelected$3 extends FunctionReferenceImpl implements Function1<Continuation<? super List<? extends Filter>>, Object>, SuspendFunction {
    public UseCasesKt$isCollectionsFilterOrSortTypeSelected$3(Object obj) {
        super(1, obj, FiltersRepository.class, "requestSelectedCollectionsFilters", "requestSelectedCollectionsFilters(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return ((FiltersRepository) this.receiver).requestSelectedCollectionsFilters(continuation);
    }
}
