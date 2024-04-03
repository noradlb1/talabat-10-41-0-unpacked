package com.talabat.wallet.features.walletonboarding.repository;

import androidx.datastore.preferences.core.MutablePreferences;
import com.talabat.wallet.features.walletonboarding.repository.UserPreferencesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "preferences", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.features.walletonboarding.repository.UserPreferencesRepository$updateWasWalletOnboardingShown$2", f = "UserPreferencesRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserPreferencesRepository$updateWasWalletOnboardingShown$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12612h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f12614j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserPreferencesRepository$updateWasWalletOnboardingShown$2(boolean z11, Continuation<? super UserPreferencesRepository$updateWasWalletOnboardingShown$2> continuation) {
        super(2, continuation);
        this.f12614j = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UserPreferencesRepository$updateWasWalletOnboardingShown$2 userPreferencesRepository$updateWasWalletOnboardingShown$2 = new UserPreferencesRepository$updateWasWalletOnboardingShown$2(this.f12614j, continuation);
        userPreferencesRepository$updateWasWalletOnboardingShown$2.f12613i = obj;
        return userPreferencesRepository$updateWasWalletOnboardingShown$2;
    }

    @Nullable
    public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((UserPreferencesRepository$updateWasWalletOnboardingShown$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f12612h == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.f12613i).set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getWAS_WALLET_ONBOARDING_SHOWN(), Boxing.boxBoolean(this.f12614j));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
