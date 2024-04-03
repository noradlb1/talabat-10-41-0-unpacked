package com.talabat.wallet.bnplmanager.domain.application.usecase;

import com.talabat.configuration.country.Country;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.application.usecase.GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2", f = "GetBnplFakeDoorTestFeatureFlagUseCase.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
public final class GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12463h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetBnplFakeDoorTestFeatureFlagUseCase f12464i;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.UAE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2(GetBnplFakeDoorTestFeatureFlagUseCase getBnplFakeDoorTestFeatureFlagUseCase, Continuation<? super GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12464i = getBnplFakeDoorTestFeatureFlagUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2(this.f12464i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((GetBnplFakeDoorTestFeatureFlagUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12463h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            z11 = false;
            if (WhenMappings.$EnumSwitchMapping$0[this.f12464i.configurationLocalRepository.selectedCountry().ordinal()] == 1) {
                ITalabatFeatureFlag access$getFeatureFlagRepo$p = this.f12464i.featureFlagRepo;
                PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry payFeatureFlagsWithoutCountry = PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.WALLET_BNPL_FAKE_DOOR_TEST;
                this.f12463h = 1;
                obj = access$getFeatureFlagRepo$p.getFeatureFlag((FWFKey) payFeatureFlagsWithoutCountry, false, false, (Continuation<? super Boolean>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z11);
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z11 = ((Boolean) obj).booleanValue();
        return Boxing.boxBoolean(z11);
    }
}
