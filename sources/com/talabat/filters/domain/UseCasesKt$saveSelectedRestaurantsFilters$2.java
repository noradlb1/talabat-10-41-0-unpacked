package com.talabat.filters.domain;

import com.talabat.filters.FiltersIntegratorKt;
import datamodels.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H@"}, d2 = {"", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$saveSelectedRestaurantsFilters$2", f = "UseCases.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$saveSelectedRestaurantsFilters$2 extends SuspendLambda implements Function2<List<? extends Filter>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59544h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59545i;

    public UseCasesKt$saveSelectedRestaurantsFilters$2(Continuation<? super UseCasesKt$saveSelectedRestaurantsFilters$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$saveSelectedRestaurantsFilters$2 useCasesKt$saveSelectedRestaurantsFilters$2 = new UseCasesKt$saveSelectedRestaurantsFilters$2(continuation);
        useCasesKt$saveSelectedRestaurantsFilters$2.f59545i = obj;
        return useCasesKt$saveSelectedRestaurantsFilters$2;
    }

    @Nullable
    public final Object invoke(@NotNull List<? extends Filter> list, @Nullable Continuation<? super Unit> continuation) {
        return ((UseCasesKt$saveSelectedRestaurantsFilters$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59544h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FiltersRepository repository = FiltersIntegratorKt.getRepository();
            this.f59544h = 1;
            if (repository.saveSelectedRestaurantsFilters((List) this.f59545i, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
