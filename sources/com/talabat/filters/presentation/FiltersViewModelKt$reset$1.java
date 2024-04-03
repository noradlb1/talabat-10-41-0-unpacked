package com.talabat.filters.presentation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.presentation.FiltersViewModelKt$reset$1", f = "FiltersViewModel.kt", i = {}, l = {151, 152}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersViewModelKt$reset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59663h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59664i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersViewModelKt$reset$1(FiltersViewModel filtersViewModel, Continuation<? super FiltersViewModelKt$reset$1> continuation) {
        super(2, continuation);
        this.f59664i = filtersViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FiltersViewModelKt$reset$1(this.f59664i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FiltersViewModelKt$reset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59663h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Unit>, Object> resetSelectedSortTypeUseCase = this.f59664i.getResetSelectedSortTypeUseCase();
            this.f59663h = 1;
            if (resetSelectedSortTypeUseCase.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            FiltersViewModelKt.initialize(this.f59664i);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Function1<Continuation<? super Unit>, Object> resetSelectedFiltersUseCase = this.f59664i.getResetSelectedFiltersUseCase();
        this.f59663h = 2;
        if (resetSelectedFiltersUseCase.invoke(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        FiltersViewModelKt.initialize(this.f59664i);
        return Unit.INSTANCE;
    }
}
