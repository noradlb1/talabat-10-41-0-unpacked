package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B/\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "", "cardName", "", "cardNumberLength", "", "cvvLength", "iconResource", "(Ljava/lang/String;ILjava/lang/String;III)V", "getCardName", "()Ljava/lang/String;", "getCardNumberLength", "()I", "getCvvLength", "getIconResource", "UN_KNOWN", "VISA", "MASTER_CARD", "AMEX", "MEEZA", "DEAFULT", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletCardType {
    UN_KNOWN(StringUtils.empty(r10), 16, 3, 0, 8, (int) null),
    VISA("Visa", 0, 0, R.drawable.visa_icon, 6, (int) null),
    MASTER_CARD("MasterCard", 0, 0, R.drawable.master_card_icon, 6, (int) null),
    AMEX("Amex", 15, 4, R.drawable.amex_card_icon),
    MEEZA("Meeza", 0, 0, R.drawable.ic_meeza_card_icon, 6, (int) null),
    DEAFULT(StringUtils.empty(r10), 16, 3, 0, 8, (int) null);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String cardName;
    private final int cardNumberLength;
    private final int cvvLength;
    private final int iconResource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType$Companion;", "", "()V", "getCardTypeFromCardName", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "value", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletCardType getCardTypeFromCardName(@Nullable String str) {
            WalletCardType walletCardType;
            WalletCardType[] values = WalletCardType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    walletCardType = null;
                    break;
                }
                walletCardType = values[i11];
                if (StringsKt__StringsJVMKt.equals(walletCardType.getCardName(), str, true)) {
                    break;
                }
                i11++;
            }
            if (walletCardType == null) {
                return WalletCardType.UN_KNOWN;
            }
            return walletCardType;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private WalletCardType(String str, int i11, int i12, int i13) {
        this.cardName = str;
        this.cardNumberLength = i11;
        this.cvvLength = i12;
        this.iconResource = i13;
    }

    @NotNull
    public final String getCardName() {
        return this.cardName;
    }

    public final int getCardNumberLength() {
        return this.cardNumberLength;
    }

    public final int getCvvLength() {
        return this.cvvLength;
    }

    public final int getIconResource() {
        return this.iconResource;
    }
}
