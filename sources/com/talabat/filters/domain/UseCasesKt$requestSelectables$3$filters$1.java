package com.talabat.filters.domain;

import datamodels.filters.SelectableFilter;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H@"}, d2 = {"", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestSelectables$3$filters$1", f = "UseCases.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class UseCasesKt$requestSelectables$3$filters$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends SelectableFilter>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59527h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super List<SelectableFilter>>, Object> f59528i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestSelectables$3$filters$1(Function1<? super Continuation<? super List<SelectableFilter>>, ? extends Object> function1, Continuation<? super UseCasesKt$requestSelectables$3$filters$1> continuation) {
        super(1, continuation);
        this.f59528i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new UseCasesKt$requestSelectables$3$filters$1(this.f59528i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super List<SelectableFilter>> continuation) {
        return ((UseCasesKt$requestSelectables$3$filters$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59527h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super List<SelectableFilter>>, Object> function1 = this.f59528i;
            this.f59527h = 1;
            obj = function1.invoke(this);
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
