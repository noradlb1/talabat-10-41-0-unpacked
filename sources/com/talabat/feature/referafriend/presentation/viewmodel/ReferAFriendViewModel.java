package com.talabat.feature.referafriend.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.visa.checkout.PurchaseInfo;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000e\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel;", "Landroidx/lifecycle/ViewModel;", "redeemVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "coroutineScope", "com/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel$coroutineScope$1", "Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel$coroutineScope$1;", "getRedeemVoucherCodeUseCase", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "successRedeemPromo", "Landroidx/lifecycle/MutableLiveData;", "", "getSuccessRedeemPromo", "()Landroidx/lifecycle/MutableLiveData;", "redeemPromoCode", "", "promoCode", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "trackObservability", "event", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReferAFriendViewModel extends ViewModel {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final ReferAFriendViewModel$coroutineScope$1 coroutineScope = new ReferAFriendViewModel$coroutineScope$1(this);
    @NotNull
    private final RedeemVoucherCodeUseCase redeemVoucherCodeUseCase;
    @NotNull
    private final MutableLiveData<Boolean> successRedeemPromo = new MutableLiveData<>();

    @Inject
    public ReferAFriendViewModel(@NotNull RedeemVoucherCodeUseCase redeemVoucherCodeUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(redeemVoucherCodeUseCase2, "redeemVoucherCodeUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        this.redeemVoucherCodeUseCase = redeemVoucherCodeUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        return this.configurationLocalRepository;
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        return this.coroutineDispatchersFactory;
    }

    @NotNull
    public final RedeemVoucherCodeUseCase getRedeemVoucherCodeUseCase() {
        return this.redeemVoucherCodeUseCase;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSuccessRedeemPromo() {
        return this.successRedeemPromo;
    }

    public final void redeemPromoCode(@NotNull String str, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.PROMO_CODE);
        Intrinsics.checkNotNullParameter(result, "result");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.coroutineScope.getCoroutineContext(), (CoroutineStart) null, new ReferAFriendViewModel$redeemPromoCode$1(this, str, result, (Continuation<? super ReferAFriendViewModel$redeemPromoCode$1>) null), 2, (Object) null);
    }

    public final void trackObservability(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        GrowthTracker.INSTANCE.trackObservability("Refer a Friend", str, ScreenNames.VOUCHER_WALLET_SCREEN);
    }
}
