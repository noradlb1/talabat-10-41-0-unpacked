package com.talabat.configuration.payment.mapper;

import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.configuration.payment.model.TokenizedBankCardEntity;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/configuration/payment/mapper/TokenizedBankCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "()V", "apply", "source", "makeDate", "Lcom/talabat/configuration/payment/mapper/TokenizedBankCardMapper$InternalLocalDate;", "year", "", "month", "parseExpiryDate", "InternalLocalDate", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class TokenizedBankCardMapper implements ModelMapper<TokenizedBankCardEntity, TokenizedBankCard> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/configuration/payment/mapper/TokenizedBankCardMapper$InternalLocalDate;", "", "year", "", "month", "(II)V", "getMonth", "()I", "getYear", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InternalLocalDate {
        private final int month;
        private final int year;

        public InternalLocalDate(int i11, int i12) {
            this.year = i11;
            this.month = i12;
        }

        public static /* synthetic */ InternalLocalDate copy$default(InternalLocalDate internalLocalDate, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = internalLocalDate.year;
            }
            if ((i13 & 2) != 0) {
                i12 = internalLocalDate.month;
            }
            return internalLocalDate.copy(i11, i12);
        }

        public final int component1() {
            return this.year;
        }

        public final int component2() {
            return this.month;
        }

        @NotNull
        public final InternalLocalDate copy(int i11, int i12) {
            return new InternalLocalDate(i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InternalLocalDate)) {
                return false;
            }
            InternalLocalDate internalLocalDate = (InternalLocalDate) obj;
            return this.year == internalLocalDate.year && this.month == internalLocalDate.month;
        }

        public final int getMonth() {
            return this.month;
        }

        public final int getYear() {
            return this.year;
        }

        public int hashCode() {
            return (this.year * 31) + this.month;
        }

        @NotNull
        public String toString() {
            int i11 = this.year;
            int i12 = this.month;
            return "InternalLocalDate(year=" + i11 + ", month=" + i12 + ")";
        }
    }

    private final InternalLocalDate makeDate(int i11, int i12) {
        boolean z11 = false;
        if (1 <= i12 && i12 < 13) {
            z11 = true;
        }
        if (z11) {
            return new InternalLocalDate(i11, i12);
        }
        throw new RuntimeException("TokenizedBankCardMapper: date parsing error (invalid month): " + i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[Catch:{ Exception -> 0x009b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.configuration.payment.mapper.TokenizedBankCardMapper.InternalLocalDate parseExpiryDate(com.talabat.configuration.payment.model.TokenizedBankCardEntity r12) {
        /*
            r11 = this;
            java.lang.String r0 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.lang.Integer r1 = r12.getExpiryYear()     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x0027
            java.lang.Integer r1 = r12.getExpiryMonth()     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x0027
            java.lang.Integer r0 = r12.getExpiryYear()     // Catch:{ Exception -> 0x009b }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x009b }
            int r0 = r0 + 2000
            java.lang.Integer r12 = r12.getExpiryMonth()     // Catch:{ Exception -> 0x009b }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x009b }
            com.talabat.configuration.payment.mapper.TokenizedBankCardMapper$InternalLocalDate r12 = r11.makeDate(r0, r12)     // Catch:{ Exception -> 0x009b }
            goto L_0x009c
        L_0x0027:
            java.lang.String r1 = r12.getExpiryDate()     // Catch:{ Exception -> 0x009b }
            r2 = 0
            if (r1 == 0) goto L_0x0037
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r1 = r2
            goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            if (r1 != 0) goto L_0x0084
            java.lang.String r1 = r12.getExpiryDate()     // Catch:{ Exception -> 0x009b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ Exception -> 0x009b }
            java.lang.CharSequence r1 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r1)     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009b }
            int r1 = r1.length()     // Catch:{ Exception -> 0x009b }
            r3 = 4
            if (r1 != r3) goto L_0x0084
            java.lang.String r1 = r12.getExpiryDate()     // Catch:{ Exception -> 0x009b }
            r4 = 2
            java.lang.String r1 = r1.substring(r2, r4)     // Catch:{ Exception -> 0x009b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ Exception -> 0x009b }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x009b }
            int r1 = r1 + 2000
            java.lang.String r12 = r12.getExpiryDate()     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = "0"
            r7 = 2
            r8 = 0
            r9 = 4
            r10 = 0
            r5 = r12
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x009b }
            if (r2 == 0) goto L_0x0074
            r4 = 3
        L_0x0074:
            java.lang.String r12 = r12.substring(r4, r3)     // Catch:{ Exception -> 0x009b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch:{ Exception -> 0x009b }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x009b }
            com.talabat.configuration.payment.mapper.TokenizedBankCardMapper$InternalLocalDate r12 = r11.makeDate(r1, r12)     // Catch:{ Exception -> 0x009b }
            goto L_0x009c
        L_0x0084:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x009b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
            r1.<init>()     // Catch:{ Exception -> 0x009b }
            java.lang.String r2 = "TokenizedBankCardMapper: date parsing error "
            r1.append(r2)     // Catch:{ Exception -> 0x009b }
            r1.append(r12)     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = r1.toString()     // Catch:{ Exception -> 0x009b }
            r0.<init>(r12)     // Catch:{ Exception -> 0x009b }
            throw r0     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r12 = 0
        L_0x009c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.payment.mapper.TokenizedBankCardMapper.parseExpiryDate(com.talabat.configuration.payment.model.TokenizedBankCardEntity):com.talabat.configuration.payment.mapper.TokenizedBankCardMapper$InternalLocalDate");
    }

    @NotNull
    public TokenizedBankCard apply(@NotNull TokenizedBankCardEntity tokenizedBankCardEntity) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(tokenizedBankCardEntity, "source");
        InternalLocalDate parseExpiryDate = parseExpiryDate(tokenizedBankCardEntity);
        String binMessage = tokenizedBankCardEntity.getBinMessage();
        String binNumber = tokenizedBankCardEntity.getBinNumber();
        int month = parseExpiryDate != null ? parseExpiryDate.getMonth() : -1;
        int year = parseExpiryDate != null ? parseExpiryDate.getYear() : -1;
        String holderName = tokenizedBankCardEntity.getHolderName();
        String str4 = holderName == null ? "" : holderName;
        Boolean isBinDiscountValid = tokenizedBankCardEntity.isBinDiscountValid();
        boolean z11 = false;
        boolean booleanValue = isBinDiscountValid != null ? isBinDiscountValid.booleanValue() : false;
        Boolean isForceCvv = tokenizedBankCardEntity.isForceCvv();
        boolean booleanValue2 = isForceCvv != null ? isForceCvv.booleanValue() : false;
        Boolean isValid = tokenizedBankCardEntity.isValid();
        if (isValid != null) {
            z11 = isValid.booleanValue();
        }
        boolean z12 = z11;
        String number = tokenizedBankCardEntity.getNumber();
        if (number == null) {
            str = "";
        } else {
            str = number;
        }
        String token = tokenizedBankCardEntity.getToken();
        if (token == null) {
            str2 = "";
        } else {
            str2 = token;
        }
        String type = tokenizedBankCardEntity.getType();
        if (type == null) {
            str3 = "";
        } else {
            str3 = type;
        }
        return new TokenizedBankCard(binMessage, binNumber, month, year, str4, booleanValue, booleanValue2, z12, str, str2, str3);
    }
}
