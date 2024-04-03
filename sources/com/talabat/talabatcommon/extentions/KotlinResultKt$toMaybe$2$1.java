package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$toMaybe$2$1", f = "KotlinResult.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$toMaybe$2$1 extends SuspendLambda implements Function2 {

    /* renamed from: h  reason: collision with root package name */
    public int f47058h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1 f47059i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$toMaybe$2$1(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f47059i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new KotlinResultKt$toMaybe$2$1(this.f47059i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation continuation) {
        return ((KotlinResultKt$toMaybe$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f47058h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1 function1 = this.f47059i;
            this.f47058h = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object r42 = ((Result) obj).m6338unboximpl();
        ResultKt.throwOnFailure(r42);
        return r42;
    }
}
