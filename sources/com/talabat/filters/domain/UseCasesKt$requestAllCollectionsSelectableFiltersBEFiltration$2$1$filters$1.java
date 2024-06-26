package com.talabat.filters.domain;

import datamodels.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H@"}, d2 = {"", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1", f = "UseCases.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends Filter>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59486h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersRepository f59487i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1(FiltersRepository filtersRepository, Continuation<? super UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1> continuation) {
        super(1, continuation);
        this.f59487i = filtersRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1(this.f59487i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super List<? extends Filter>> continuation) {
        return ((UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1$filters$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59486h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FiltersRepository filtersRepository = this.f59487i;
            this.f59486h = 1;
            obj = filtersRepository.requestAllCollectionsFilters(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
