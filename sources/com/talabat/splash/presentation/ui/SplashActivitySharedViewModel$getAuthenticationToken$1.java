package com.talabat.splash.presentation.ui;

import com.talabat.splash.core.extension.Event;
import com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivitySharedViewModel$getAuthenticationToken$1", f = "SplashActivitySharedViewModel.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
public final class SplashActivitySharedViewModel$getAuthenticationToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61528h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashActivitySharedViewModel f61529i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivitySharedViewModel$getAuthenticationToken$1(SplashActivitySharedViewModel splashActivitySharedViewModel, Continuation<? super SplashActivitySharedViewModel$getAuthenticationToken$1> continuation) {
        super(2, continuation);
        this.f61529i = splashActivitySharedViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivitySharedViewModel$getAuthenticationToken$1(this.f61529i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SplashActivitySharedViewModel$getAuthenticationToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61528h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetAuthenticationTokenUseCase access$getGetAuthenticationTokenUseCase$p = this.f61529i.getAuthenticationTokenUseCase;
            this.f61528h = 1;
            obj = access$getGetAuthenticationTokenUseCase$p.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.f61529i.getMGetAuthenticationToken().postValue(new Event(Boxing.boxBoolean(true)));
        }
        return Unit.INSTANCE;
    }
}
