package com.talabat.wallet.ui.walletTopUp.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListViewType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ITEM_VIEW_TYPE_CREDIT_CARD", "ITEM_VIEW_TYPE_ADD_CARD", "ITEM_VIEW_TYPE_CAMPAIGN", "ITEM_VIEW_TYPE_CARD_HEADER_MESSAGE", "ITEM_VIEW_TYPE_EMPTY_CARD", "ITEM_VIEW_TYPE_EMPTY_VIEW", "ITEM_ERROR_VIEW", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletCreditCardListViewType {
    ITEM_VIEW_TYPE_CREDIT_CARD(1),
    ITEM_VIEW_TYPE_ADD_CARD(2),
    ITEM_VIEW_TYPE_CAMPAIGN(3),
    ITEM_VIEW_TYPE_CARD_HEADER_MESSAGE(4),
    ITEM_VIEW_TYPE_EMPTY_CARD(5),
    ITEM_VIEW_TYPE_EMPTY_VIEW(6),
    ITEM_ERROR_VIEW(7);
    
    private final int value;

    private WalletCreditCardListViewType(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
