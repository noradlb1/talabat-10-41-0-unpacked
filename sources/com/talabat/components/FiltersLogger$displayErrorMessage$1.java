package com.talabat.components;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.components.FiltersLogger$displayErrorMessage$1", f = "Filters.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersLogger$displayErrorMessage$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55688h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiltersLogger f55689i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Throwable f55690j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersLogger$displayErrorMessage$1(FiltersLogger filtersLogger, Throwable th2, Continuation<? super FiltersLogger$displayErrorMessage$1> continuation) {
        super(1, continuation);
        this.f55689i = filtersLogger;
        this.f55690j = th2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new FiltersLogger$displayErrorMessage$1(this.f55689i, this.f55690j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((FiltersLogger$displayErrorMessage$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f55688h == 0) {
            ResultKt.throwOnFailure(obj);
            Context access$getContext$p = this.f55689i.context;
            String message = this.f55690j.getMessage();
            if (message == null) {
                message = this.f55690j.toString();
            }
            Toast.makeText(access$getContext$p, message, 0).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
