package com.talabat.filters.presentation;

import datamodels.filters.SelectablePopularFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.presentation.FiltersViewModelKt$onPopularFilterClicked$1", f = "FiltersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersViewModelKt$onPopularFilterClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59656h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59657i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SelectablePopularFilter f59658j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersViewModelKt$onPopularFilterClicked$1(FiltersViewModel filtersViewModel, SelectablePopularFilter selectablePopularFilter, Continuation<? super FiltersViewModelKt$onPopularFilterClicked$1> continuation) {
        super(2, continuation);
        this.f59657i = filtersViewModel;
        this.f59658j = selectablePopularFilter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FiltersViewModelKt$onPopularFilterClicked$1(this.f59657i, this.f59658j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FiltersViewModelKt$onPopularFilterClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59656h == 0) {
            ResultKt.throwOnFailure(obj);
            List value = this.f59657i.getPopularFilters().getValue();
            if (value == null) {
                value = CollectionsKt__CollectionsKt.emptyList();
            }
            this.f59657i.getPopularFilters().postValue(this.f59657i.getUpdateSelectedPopularFiltersUseCase().invoke(value, this.f59658j));
            if (this.f59658j.isOn()) {
                this.f59657i.getAnalyticsClick().postValue(new Pair(FiltersViewModelKt.getSortingSlug(this.f59657i), FiltersViewModelKt.getFiltersSlug(this.f59657i)));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
