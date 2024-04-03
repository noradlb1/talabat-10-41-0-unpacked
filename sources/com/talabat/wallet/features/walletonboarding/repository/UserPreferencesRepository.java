package com.talabat.wallet.features.walletonboarding.repository;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository;", "", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Landroidx/datastore/core/DataStore;)V", "userPreferencesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferences;", "getUserPreferencesFlow", "()Lkotlinx/coroutines/flow/Flow;", "updateWasWalletOnboardingShown", "", "value", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserPreferencesRepository {
    @NotNull
    private final DataStore<Preferences> dataStore;
    @NotNull
    private final Flow<UserPreferences> userPreferencesFlow;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository$PreferencesKeys;", "", "()V", "WAS_WALLET_ONBOARDING_SHOWN", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getWAS_WALLET_ONBOARDING_SHOWN", "()Landroidx/datastore/preferences/core/Preferences$Key;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PreferencesKeys {
        @NotNull
        public static final PreferencesKeys INSTANCE = new PreferencesKeys();
        @NotNull
        private static final Preferences.Key<Boolean> WAS_WALLET_ONBOARDING_SHOWN = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("wasWalletOnboardingShown");

        private PreferencesKeys() {
        }

        @NotNull
        public final Preferences.Key<Boolean> getWAS_WALLET_ONBOARDING_SHOWN() {
            return WAS_WALLET_ONBOARDING_SHOWN;
        }
    }

    public UserPreferencesRepository(@NotNull DataStore<Preferences> dataStore2) {
        Intrinsics.checkNotNullParameter(dataStore2, "dataStore");
        this.dataStore = dataStore2;
        this.userPreferencesFlow = new UserPreferencesRepository$special$$inlined$map$1(FlowKt.m7822catch(dataStore2.getData(), new UserPreferencesRepository$userPreferencesFlow$1((Continuation<? super UserPreferencesRepository$userPreferencesFlow$1>) null)));
    }

    @NotNull
    public final Flow<UserPreferences> getUserPreferencesFlow() {
        return this.userPreferencesFlow;
    }

    @Nullable
    public final Object updateWasWalletOnboardingShown(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object edit = PreferencesKt.edit(this.dataStore, new UserPreferencesRepository$updateWasWalletOnboardingShown$2(z11, (Continuation<? super UserPreferencesRepository$updateWasWalletOnboardingShown$2>) null), continuation);
        return edit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? edit : Unit.INSTANCE;
    }
}
