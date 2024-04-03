package com.talabat.sidemenu;

import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.UserBNPLEligibility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.sidemenu.SideMenuInteractor$checkUserEligibleForBNPL$1", f = "SideMenuInteractor.kt", i = {0}, l = {171}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class SideMenuInteractor$checkUserEligibleForBNPL$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61361h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f61362i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuInteractor$checkUserEligibleForBNPL$1(SideMenuInteractor sideMenuInteractor, Continuation<? super SideMenuInteractor$checkUserEligibleForBNPL$1> continuation) {
        super(2, continuation);
        this.f61362i = sideMenuInteractor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SideMenuInteractor$checkUserEligibleForBNPL$1 sideMenuInteractor$checkUserEligibleForBNPL$1 = new SideMenuInteractor$checkUserEligibleForBNPL$1(this.f61362i, continuation);
        sideMenuInteractor$checkUserEligibleForBNPL$1.L$0 = obj;
        return sideMenuInteractor$checkUserEligibleForBNPL$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuInteractor$checkUserEligibleForBNPL$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        UserBNPLEligibility userBNPLEligibility;
        CoroutineScope coroutineScope;
        SideMenuListener access$getSideMenuListener$p;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61361h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            IsUserBNPLEligibleUseCase access$isUserBNPLEligibleUseCase$p = this.f61362i.isUserBNPLEligibleUseCase;
            if (access$isUserBNPLEligibleUseCase$p != null) {
                this.L$0 = coroutineScope2;
                this.f61361h = 1;
                Object invoke = access$isUserBNPLEligibleUseCase$p.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = invoke;
            } else {
                coroutineScope = coroutineScope2;
                userBNPLEligibility = null;
                if (CoroutineScopeKt.isActive(coroutineScope) && userBNPLEligibility == UserBNPLEligibility.BNPL_ELIGIBLE && (access$getSideMenuListener$p = this.f61362i.sideMenuListener) != null) {
                    access$getSideMenuListener$p.showBNPLOption();
                }
                return Unit.INSTANCE;
            }
        } else if (i11 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        userBNPLEligibility = (UserBNPLEligibility) obj;
        access$getSideMenuListener$p.showBNPLOption();
        return Unit.INSTANCE;
    }
}
