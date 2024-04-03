package com.talabat.filters.domain;

import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class UseCasesKt$requestCollectionsSelectables$2 extends FunctionReferenceImpl implements Function1<Continuation<? super SortType>, Object>, SuspendFunction {
    public UseCasesKt$requestCollectionsSelectables$2(Object obj) {
        super(1, obj, FiltersRepository.class, "requestSelectedCollectionsSortType", "requestSelectedCollectionsSortType(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super SortType> continuation) {
        return ((FiltersRepository) this.receiver).requestSelectedCollectionsSortType(continuation);
    }
}
