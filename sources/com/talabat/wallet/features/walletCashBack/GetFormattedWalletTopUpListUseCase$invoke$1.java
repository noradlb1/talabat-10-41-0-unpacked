package com.talabat.wallet.features.walletCashBack;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletTopUpCardListMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "walletTransactionListResponse", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetFormattedWalletTopUpListUseCase$invoke$1 extends Lambda implements Function2<WalletCashBackCampaignResponse, WalletCardListDisplayModel, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<List<WalletCreditCardListDataItemDisplayModel>> f12590g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetFormattedWalletTopUpListUseCase$invoke$1(Ref.ObjectRef<List<WalletCreditCardListDataItemDisplayModel>> objectRef) {
        super(2);
        this.f12590g = objectRef;
    }

    @Nullable
    public final Object invoke(@NotNull WalletCashBackCampaignResponse walletCashBackCampaignResponse, @NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCashBackCampaignResponse, "walletTransactionListResponse");
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        if (walletCardListDisplayModel.getCardList().isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        this.f12590g.element = CollectionsKt___CollectionsKt.toMutableList(WalletTopUpCardListMapper.Companion.combineTopListDisplayModels(walletCashBackCampaignResponse, walletCardListDisplayModel));
        return Unit.INSTANCE;
    }
}
