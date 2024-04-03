package com.talabat.talabatcore.interactor;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002 \u0000*\u00020\u0003H@"}, d2 = {"", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcore.interactor.UseCase$invoke$2", f = "UseCase.kt", i = {}, l = {28, 30}, m = "invokeSuspend", n = {}, s = {})
public final class UseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12022h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UseCase<Type, Params> f12023i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Params f12024j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Either<? extends Failure, ? extends Type>, Unit> f12025k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002 \u0000*\u00020\u0003H@"}, d2 = {"", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.talabatcore.interactor.UseCase$invoke$2$1", f = "UseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.talabatcore.interactor.UseCase$invoke$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f12026h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(function1, either, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12026h == 0) {
                ResultKt.throwOnFailure(obj);
                function1.invoke(either);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCase$invoke$2(UseCase<? extends Type, ? super Params> useCase, Params params, Function1<? super Either<? extends Failure, ? extends Type>, Unit> function1, Continuation<? super UseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12023i = useCase;
        this.f12024j = params;
        this.f12025k = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UseCase$invoke$2(this.f12023i, this.f12024j, this.f12025k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12022h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UseCase<Type, Params> useCase = this.f12023i;
            Params params = this.f12024j;
            this.f12022h = 1;
            obj = useCase.run(params, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final Either either = (Either) obj;
        CoroutineDispatcher access$getDispatcher$p = this.f12023i.dispatcher;
        final Function1<Either<? extends Failure, ? extends Type>, Unit> function1 = this.f12025k;
        AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.f12022h = 2;
        if (BuildersKt.withContext(access$getDispatcher$p, r32, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
