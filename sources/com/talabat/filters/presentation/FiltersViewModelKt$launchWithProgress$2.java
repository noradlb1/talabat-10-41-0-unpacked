package com.talabat.filters.presentation;

import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.presentation.FiltersViewModelKt$launchWithProgress$2", f = "FiltersViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersViewModelKt$launchWithProgress$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59650h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59651i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f59652j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersViewModelKt$launchWithProgress$2(FiltersViewModel filtersViewModel, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super FiltersViewModelKt$launchWithProgress$2> continuation) {
        super(1, continuation);
        this.f59651i = filtersViewModel;
        this.f59652j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new FiltersViewModelKt$launchWithProgress$2(this.f59651i, this.f59652j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((FiltersViewModelKt$launchWithProgress$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59650h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f59651i.getProgressing().postValue(Boxing.boxBoolean(true));
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f59652j;
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.f59651i);
            this.f59650h = 1;
            if (function2.invoke(viewModelScope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.f59651i.getProgressing().postValue(Boxing.boxBoolean(false));
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f59651i.getProgressing().postValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
