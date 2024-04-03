package com.talabat.filters.domain;

import com.talabat.filters.FiltersIntegratorKt;
import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Ldatamodels/filters/SortType;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$saveSelectedRestaurantsSortType$2", f = "UseCases.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$saveSelectedRestaurantsSortType$2 extends SuspendLambda implements Function2<SortType, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59546h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59547i;

    public UseCasesKt$saveSelectedRestaurantsSortType$2(Continuation<? super UseCasesKt$saveSelectedRestaurantsSortType$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$saveSelectedRestaurantsSortType$2 useCasesKt$saveSelectedRestaurantsSortType$2 = new UseCasesKt$saveSelectedRestaurantsSortType$2(continuation);
        useCasesKt$saveSelectedRestaurantsSortType$2.f59547i = obj;
        return useCasesKt$saveSelectedRestaurantsSortType$2;
    }

    @Nullable
    public final Object invoke(@NotNull SortType sortType, @Nullable Continuation<? super Unit> continuation) {
        return ((UseCasesKt$saveSelectedRestaurantsSortType$2) create(sortType, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59546h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FiltersRepository repository = FiltersIntegratorKt.getRepository();
            this.f59546h = 1;
            if (repository.saveSelectedRestaurantsSortType((SortType) this.f59547i, this) == coroutine_suspended) {
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
