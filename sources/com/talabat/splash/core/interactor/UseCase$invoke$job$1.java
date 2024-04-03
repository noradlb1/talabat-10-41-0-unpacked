package com.talabat.splash.core.interactor;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u0004\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002 \u0000*\u00020\u0003H@"}, d2 = {"", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.core.interactor.UseCase$invoke$job$1", f = "UseCase.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class UseCase$invoke$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends Object>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61436h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UseCase<Type, Params> f61437i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Params f61438j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCase$invoke$job$1(UseCase<? extends Type, ? super Params> useCase, Params params, Continuation<? super UseCase$invoke$job$1> continuation) {
        super(2, continuation);
        this.f61437i = useCase;
        this.f61438j = params;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UseCase$invoke$job$1(this.f61437i, this.f61438j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Either<? extends Failure, ? extends Object>> continuation) {
        return ((UseCase$invoke$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61436h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UseCase<Type, Params> useCase = this.f61437i;
            Params params = this.f61438j;
            this.f61436h = 1;
            obj = useCase.run(params, this);
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
