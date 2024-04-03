package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$refresh$1", f = "SideMenuTProSavingsViewPresenter.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTProSavingsViewPresenter$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59410h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59411i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LocationConfigurationRepository f59412j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$refresh$1(SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter, LocationConfigurationRepository locationConfigurationRepository, Continuation<? super SideMenuTProSavingsViewPresenter$refresh$1> continuation) {
        super(2, continuation);
        this.f59411i = sideMenuTProSavingsViewPresenter;
        this.f59412j = locationConfigurationRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SideMenuTProSavingsViewPresenter$refresh$1 sideMenuTProSavingsViewPresenter$refresh$1 = new SideMenuTProSavingsViewPresenter$refresh$1(this.f59411i, this.f59412j, continuation);
        sideMenuTProSavingsViewPresenter$refresh$1.L$0 = obj;
        return sideMenuTProSavingsViewPresenter$refresh$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTProSavingsViewPresenter$refresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59410h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter = this.f59411i;
            LocationConfigurationRepository locationConfigurationRepository = this.f59412j;
            Result.Companion companion = Result.Companion;
            SubscriptionSavingsInfo access$getCachedSavingsInfo$p = sideMenuTProSavingsViewPresenter.cachedSavingsInfo;
            if (access$getCachedSavingsInfo$p != null) {
                this.f59410h = 1;
                if (sideMenuTProSavingsViewPresenter.bindData(access$getCachedSavingsInfo$p, locationConfigurationRepository, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                sideMenuTProSavingsViewPresenter.startLoading(locationConfigurationRepository);
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.m6329constructorimpl(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}
