package com.talabat.filters.domain;

import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestSelectables$3$selectedSortType$1", f = "UseCases.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$requestSelectables$3$selectedSortType$1 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59531h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super SortType>, Object> f59532i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestSelectables$3$selectedSortType$1(Function1<? super Continuation<? super SortType>, ? extends Object> function1, Continuation<? super UseCasesKt$requestSelectables$3$selectedSortType$1> continuation) {
        super(1, continuation);
        this.f59532i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new UseCasesKt$requestSelectables$3$selectedSortType$1(this.f59532i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Integer> continuation) {
        return ((UseCasesKt$requestSelectables$3$selectedSortType$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59531h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super SortType>, Object> function1 = this.f59532i;
            this.f59531h = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SortType sortType = (SortType) obj;
        if (sortType != null) {
            return Boxing.boxInt(sortType.getValue());
        }
        return null;
    }
}
