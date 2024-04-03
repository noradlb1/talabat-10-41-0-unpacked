package com.talabat.wallet.ui.walletTopUp.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponseResult;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponseResult;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletTopUpCardListMapper;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpCardListMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletTopUpCardListMapper$Companion;", "", "()V", "combineTopListDisplayModels", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "campaignResponse", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "cardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "mapCalculatedCashBackResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "walletCalculateCashBackResponse", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "mapToWalletCardListDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "mapWalletCashBackCampaignResponseToDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCashBackCampaignOfferDisplayModel;", "response", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponse;", "position", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCashBackCampaignDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<WalletCreditCardListDataItemDisplayModel> combineTopListDisplayModels(@Nullable WalletCashBackCampaignResponse walletCashBackCampaignResponse, @NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
            Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "cardListDisplayModel");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(mapWalletCashBackCampaignResponseToDisplayModel(walletCashBackCampaignResponse));
            arrayList.addAll(mapToWalletCardListDisplayModel(walletCardListDisplayModel));
            return arrayList;
        }

        @NotNull
        public final WalletCalculateCashBackDisplayModel mapCalculatedCashBackResponseToDisplayModel(@Nullable WalletCalculateCashBackResponse walletCalculateCashBackResponse) {
            WalletCalculateCashBackResponseResult result;
            if (walletCalculateCashBackResponse == null || (result = walletCalculateCashBackResponse.getResult()) == null) {
                return new WalletCalculateCashBackDisplayModel();
            }
            WalletCalculateCashBackDisplayModel walletCalculateCashBackDisplayModel = new WalletCalculateCashBackDisplayModel();
            walletCalculateCashBackDisplayModel.setAmount(FloatKt.orZero(result.getAmount()));
            walletCalculateCashBackDisplayModel.setCampaignActive(BooleanKt.orFalse(result.isCampaignActive()));
            return walletCalculateCashBackDisplayModel;
        }

        @NotNull
        public final List<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel> mapToWalletCardListDisplayModel(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
            Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "cardListDisplayModel");
            ArrayList arrayList = new ArrayList();
            for (WalletCardDisplayModel next : walletCardListDisplayModel.getCardList()) {
                WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel = new WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel();
                walletCardAdapterDisplayModel.setToken(next.getToken());
                walletCardAdapterDisplayModel.setTokenId(next.getTokenId());
                walletCardAdapterDisplayModel.setCardNumber(next.getCardNumber());
                walletCardAdapterDisplayModel.setCardType(next.getCardType());
                walletCardAdapterDisplayModel.setBinNumber(next.getBinNumber());
                walletCardAdapterDisplayModel.setDefaultCard(next.isDefaultCard());
                walletCardAdapterDisplayModel.setExpiryMonth(next.getExpiryMonth());
                walletCardAdapterDisplayModel.setExpiryYear(next.getExpiryYear());
                arrayList.add(walletCardAdapterDisplayModel);
            }
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r6 = r6.getResult();
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel.WalletCashBackCampaignDisplayModel> mapWalletCashBackCampaignResponseToDisplayModel(@org.jetbrains.annotations.Nullable com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse r6) {
            /*
                r5 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                if (r6 == 0) goto L_0x0012
                com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponseResult r6 = r6.getResult()
                if (r6 == 0) goto L_0x0012
                java.util.List r6 = r6.getCampaigns()
                goto L_0x0013
            L_0x0012:
                r6 = 0
            L_0x0013:
                if (r6 == 0) goto L_0x0064
                java.util.Iterator r6 = r6.iterator()
            L_0x0019:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0064
                java.lang.Object r1 = r6.next()
                com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignModel r1 = (com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignModel) r1
                com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel$WalletCashBackCampaignDisplayModel r2 = new com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel$WalletCashBackCampaignDisplayModel
                r2.<init>()
                java.lang.Integer r3 = r1.getBankId()
                int r3 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r3)
                r2.setBankId(r3)
                java.lang.String r3 = r1.getImgUrl()
                java.lang.String r4 = ""
                if (r3 != 0) goto L_0x003e
                r3 = r4
            L_0x003e:
                r2.setImgUrl(r3)
                java.lang.String r3 = r1.getTitle()
                if (r3 != 0) goto L_0x0048
                r3 = r4
            L_0x0048:
                r2.setTitle(r3)
                java.lang.String r3 = r1.getDescription()
                if (r3 != 0) goto L_0x0052
                r3 = r4
            L_0x0052:
                r2.setDescription(r3)
                java.lang.String r1 = r1.getCardNetwork()
                if (r1 != 0) goto L_0x005c
                goto L_0x005d
            L_0x005c:
                r4 = r1
            L_0x005d:
                r2.setCardNetwork(r4)
                r0.add(r2)
                goto L_0x0019
            L_0x0064:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTopUp.model.WalletTopUpCardListMapper.Companion.mapWalletCashBackCampaignResponseToDisplayModel(com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse):java.util.List");
        }

        @NotNull
        public final WalletCashBackCampaignOfferDisplayModel mapWalletCashBackCampaignResponseToDisplayModel(@Nullable WalletCashBackCampaignOfferResponse walletCashBackCampaignOfferResponse, int i11) {
            WalletCashBackCampaignOfferResponseResult result;
            String adTextMessage;
            WalletCashBackCampaignOfferDisplayModel walletCashBackCampaignOfferDisplayModel = new WalletCashBackCampaignOfferDisplayModel();
            if (!(walletCashBackCampaignOfferResponse == null || (result = walletCashBackCampaignOfferResponse.getResult()) == null || (adTextMessage = result.getAdTextMessage()) == null)) {
                walletCashBackCampaignOfferDisplayModel.setCampaignText(adTextMessage);
                walletCashBackCampaignOfferDisplayModel.setAdapterPosition(i11);
            }
            return walletCashBackCampaignOfferDisplayModel;
        }
    }
}
