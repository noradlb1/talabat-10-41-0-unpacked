package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "", "stringValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStringValue", "()Ljava/lang/String;", "UNDEFINED", "WALLET", "CHARITY", "VOUCHER", "RAFFLE", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum LoyaltyBurnOptionType {
    UNDEFINED("Undefined"),
    WALLET("Wallet"),
    CHARITY("Charity"),
    VOUCHER("Voucher"),
    RAFFLE("Raffle");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String stringValue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType$Companion;", "", "()V", "getRedeemBurnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "valueOfType", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LoyaltyBurnOptionType getRedeemBurnOptionType(@Nullable String str) {
            LoyaltyBurnOptionType loyaltyBurnOptionType;
            if (str != null) {
                LoyaltyBurnOptionType[] values = LoyaltyBurnOptionType.values();
                int length = values.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        loyaltyBurnOptionType = null;
                        break;
                    }
                    loyaltyBurnOptionType = values[i11];
                    String name2 = loyaltyBurnOptionType.name();
                    String upperCase = str.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if (Intrinsics.areEqual((Object) name2, (Object) upperCase)) {
                        break;
                    }
                    i11++;
                }
                if (loyaltyBurnOptionType != null) {
                    return loyaltyBurnOptionType;
                }
            }
            return LoyaltyBurnOptionType.UNDEFINED;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private LoyaltyBurnOptionType(String str) {
        this.stringValue = str;
    }

    @NotNull
    public final String getStringValue() {
        return this.stringValue;
    }
}
