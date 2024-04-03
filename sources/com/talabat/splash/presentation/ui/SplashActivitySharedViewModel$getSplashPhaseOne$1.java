package com.talabat.splash.presentation.ui;

import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.splash.core.extension.Event;
import com.talabat.splash.domain.model.SplashPhaseOneWrapper;
import com.talabat.splash.presentation.ui.displaymodel.Campaign;
import com.talabat.splash.presentation.ui.displaymodel.Content;
import com.talabat.splash.presentation.ui.displaymodel.SplashContentDisplayModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivitySharedViewModel$getSplashPhaseOne$1", f = "SplashActivitySharedViewModel.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
public final class SplashActivitySharedViewModel$getSplashPhaseOne$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61530h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashActivitySharedViewModel f61531i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivitySharedViewModel$getSplashPhaseOne$1(SplashActivitySharedViewModel splashActivitySharedViewModel, Continuation<? super SplashActivitySharedViewModel$getSplashPhaseOne$1> continuation) {
        super(2, continuation);
        this.f61531i = splashActivitySharedViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivitySharedViewModel$getSplashPhaseOne$1(this.f61531i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SplashActivitySharedViewModel$getSplashPhaseOne$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61530h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IsOnboardingExperimentEnabledUseCase access$isOnboardingExperimentEnabledUseCaseImpl$p = this.f61531i.isOnboardingExperimentEnabledUseCaseImpl;
            this.f61530h = 1;
            obj = access$isOnboardingExperimentEnabledUseCaseImpl$p.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final boolean booleanValue = ((Boolean) obj).booleanValue();
        this.f61531i.getShowNotificationPermission().postValue(Boxing.boxBoolean(booleanValue));
        if (this.f61531i.isDynamicSplashEnabled()) {
            final SplashActivitySharedViewModel splashActivitySharedViewModel = this.f61531i;
            splashActivitySharedViewModel.loadDynamicContentForSplash(new Function1<SplashContentDisplayModel, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SplashContentDisplayModel) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SplashContentDisplayModel splashContentDisplayModel) {
                    Intrinsics.checkNotNullParameter(splashContentDisplayModel, "it");
                    SplashPhaseOneWrapper splashPhaseOneWrapper = (SplashPhaseOneWrapper) splashActivitySharedViewModel.getSplashPhaseOneUseCase.invoke();
                    Integer splashUIType = splashPhaseOneWrapper.getSplashUIType();
                    Intrinsics.checkNotNull(splashUIType);
                    int intValue = splashUIType.intValue();
                    Boolean showCampaignLogo = splashPhaseOneWrapper.getShowCampaignLogo();
                    Intrinsics.checkNotNull(showCampaignLogo);
                    SplashPhaseOneViewEntity splashPhaseOneViewEntity = new SplashPhaseOneViewEntity(intValue, showCampaignLogo.booleanValue(), splashPhaseOneWrapper.getCampaignType());
                    boolean z11 = true;
                    boolean z12 = splashPhaseOneWrapper.getViewType() == 0;
                    if ((!splashContentDisplayModel.hasDynamicContent() && !splashContentDisplayModel.hasCampaign()) || !z12) {
                        z11 = false;
                    }
                    if (z11) {
                        splashActivitySharedViewModel.getDynamicSplashContent().postValue(SplashContentDisplayModel.copy$default(splashContentDisplayModel, (Content) null, (Campaign) null, splashPhaseOneViewEntity, 3, (Object) null));
                    } else if (z12) {
                        splashActivitySharedViewModel.getMSplashViewPhaseWithImageOrVideo().postValue(new Event(splashPhaseOneViewEntity));
                    } else {
                        splashActivitySharedViewModel.getMSplashViewPhaseWithWelcome().postValue(new Event(new Pair(Boolean.TRUE, Boolean.valueOf(booleanValue))));
                    }
                }
            });
        } else {
            this.f61531i.legacySplashConfiguration(booleanValue);
        }
        return Unit.INSTANCE;
    }
}
