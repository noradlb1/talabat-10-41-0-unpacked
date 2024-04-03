package com.talabat.talabatcommon.listeners;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.listeners.DebounceQueryTextListener$onTextChanged$1", f = "DebounceQueryTextListener.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
public final class DebounceQueryTextListener$onTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f61778h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61779i;

    /* renamed from: j  reason: collision with root package name */
    public int f61780j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CharSequence f61781k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DebounceQueryTextListener f61782l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebounceQueryTextListener$onTextChanged$1(CharSequence charSequence, DebounceQueryTextListener debounceQueryTextListener, Continuation<? super DebounceQueryTextListener$onTextChanged$1> continuation) {
        super(2, continuation);
        this.f61781k = charSequence;
        this.f61782l = debounceQueryTextListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DebounceQueryTextListener$onTextChanged$1(this.f61781k, this.f61782l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DebounceQueryTextListener$onTextChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        DebounceQueryTextListener debounceQueryTextListener;
        String str;
        String obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61780j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = this.f61781k;
            if (!(charSequence == null || (obj2 = charSequence.toString()) == null)) {
                debounceQueryTextListener = this.f61782l;
                Function1 access$getViewAction$p = debounceQueryTextListener.viewAction;
                if (access$getViewAction$p != null) {
                    access$getViewAction$p.invoke(obj2);
                }
                long access$getDebouncePeriod$p = debounceQueryTextListener.debouncePeriod;
                this.f61778h = debounceQueryTextListener;
                this.f61779i = obj2;
                this.f61780j = 1;
                if (DelayKt.delay(access$getDebouncePeriod$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = obj2;
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            str = (String) this.f61779i;
            debounceQueryTextListener = (DebounceQueryTextListener) this.f61778h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        debounceQueryTextListener.onDebounceQueryTextChange.invoke(str);
        return Unit.INSTANCE;
    }
}
