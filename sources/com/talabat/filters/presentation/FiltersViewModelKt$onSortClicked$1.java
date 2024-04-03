package com.talabat.filters.presentation;

import androidx.lifecycle.MutableLiveData;
import datamodels.filters.SelectableSortType;
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
@DebugMetadata(c = "com.talabat.filters.presentation.FiltersViewModelKt$onSortClicked$1", f = "FiltersViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersViewModelKt$onSortClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59659h;

    /* renamed from: i  reason: collision with root package name */
    public int f59660i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59661j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SelectableSortType f59662k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersViewModelKt$onSortClicked$1(FiltersViewModel filtersViewModel, SelectableSortType selectableSortType, Continuation<? super FiltersViewModelKt$onSortClicked$1> continuation) {
        super(2, continuation);
        this.f59661j = filtersViewModel;
        this.f59662k = selectableSortType;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FiltersViewModelKt$onSortClicked$1(this.f59661j, this.f59662k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FiltersViewModelKt$onSortClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<List<SelectableSortType>> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59660i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<List<SelectableSortType>> sorts = this.f59661j.getSorts();
            Function2<SelectableSortType, Continuation<? super List<SelectableSortType>>, Object> updateSelectedSortUseCase = this.f59661j.getUpdateSelectedSortUseCase();
            SelectableSortType selectableSortType = this.f59662k;
            this.f59659h = sorts;
            this.f59660i = 1;
            Object invoke = updateSelectedSortUseCase.invoke(selectableSortType, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = sorts;
            obj = invoke;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f59659h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(obj);
        this.f59661j.getAnalyticsClick().postValue(new Pair(FiltersViewModelKt.getSortingSlug(this.f59661j), FiltersViewModelKt.getFiltersSlug(this.f59661j)));
        return Unit.INSTANCE;
    }
}
