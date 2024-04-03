package com.talabat.userandlocation.choosecountry.di.module;

import com.talabat.userandlocation.choosecountry.ChooseCountryModuleIntegrator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.di.module.DomainModule$provideOnUserChooseCountryUseCase$1", f = "DomainModule.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class DomainModule$provideOnUserChooseCountryUseCase$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12209h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.userandlocation.choosecountry.di.module.DomainModule$provideOnUserChooseCountryUseCase$1$1", f = "DomainModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.userandlocation.choosecountry.di.module.DomainModule$provideOnUserChooseCountryUseCase$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f12210h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12210h == 0) {
                ResultKt.throwOnFailure(obj);
                ChooseCountryModuleIntegrator.INSTANCE.getOnCountryChange().invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DomainModule$provideOnUserChooseCountryUseCase$1(Continuation<? super DomainModule$provideOnUserChooseCountryUseCase$1> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new DomainModule$provideOnUserChooseCountryUseCase$1(continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((DomainModule$provideOnUserChooseCountryUseCase$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12209h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f12209h = 1;
            if (BuildersKt.withContext(main, r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
