package com.talabat.filters.presentation;

import datamodels.filters.SelectableFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.presentation.FiltersViewModelKt$onFilterClicked$1", f = "FiltersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersViewModelKt$onFilterClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59653h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59654i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SelectableFilter f59655j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersViewModelKt$onFilterClicked$1(FiltersViewModel filtersViewModel, SelectableFilter selectableFilter, Continuation<? super FiltersViewModelKt$onFilterClicked$1> continuation) {
        super(2, continuation);
        this.f59654i = filtersViewModel;
        this.f59655j = selectableFilter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FiltersViewModelKt$onFilterClicked$1(this.f59654i, this.f59655j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FiltersViewModelKt$onFilterClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59653h == 0) {
            ResultKt.throwOnFailure(obj);
            List value = this.f59654i.getFilters().getValue();
            if (value == null) {
                value = CollectionsKt__CollectionsKt.emptyList();
            }
            this.f59654i.getFilters().postValue(this.f59654i.getUpdateSelectedFiltersUseCase().invoke(value, Boxing.boxInt(this.f59655j.getFilter().getId())));
            if (this.f59655j.isOn()) {
                this.f59654i.getAnalyticsClick().postValue(new Pair(FiltersViewModelKt.getSortingSlug(this.f59654i), FiltersViewModelKt.getFiltersSlug(this.f59654i)));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
