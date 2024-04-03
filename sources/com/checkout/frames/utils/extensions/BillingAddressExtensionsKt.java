package com.checkout.frames.utils.extensions;

import com.checkout.base.model.Country;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"isValid", "", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "summary", "", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressExtensionsKt {
    private static final boolean isValid(BillingAddress billingAddress) {
        if (billingAddress.getAddress() == null || billingAddress.getAddress().getCountry() == Country.INVALID_COUNTRY || billingAddress.getPhone() == null) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012a, code lost:
        if (r1 != true) goto L_0x012d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0129  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String summary(@org.jetbrains.annotations.NotNull com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = isValid(r8)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x017a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r8.getName()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0027
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0022
            r2 = r3
            goto L_0x0023
        L_0x0022:
            r2 = r4
        L_0x0023:
            if (r2 != r3) goto L_0x0027
            r2 = r3
            goto L_0x0028
        L_0x0027:
            r2 = r4
        L_0x0028:
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = r8.getName()
            r0.append(r2)
        L_0x0031:
            com.checkout.tokenization.model.Address r2 = r8.getAddress()
            if (r2 == 0) goto L_0x0115
            java.lang.String r5 = r2.getAddressLine1()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0043
            r5 = r3
            goto L_0x0044
        L_0x0043:
            r5 = r4
        L_0x0044:
            java.lang.String r6 = "\n"
            if (r5 == 0) goto L_0x005e
            java.lang.String r5 = r2.getAddressLine1()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
        L_0x005e:
            java.lang.String r5 = r2.getAddressLine2()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x006a
            r5 = r3
            goto L_0x006b
        L_0x006a:
            r5 = r4
        L_0x006b:
            if (r5 == 0) goto L_0x0083
            java.lang.String r5 = r2.getAddressLine2()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
        L_0x0083:
            java.lang.String r5 = r2.getCity()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x008f
            r5 = r3
            goto L_0x0090
        L_0x008f:
            r5 = r4
        L_0x0090:
            if (r5 == 0) goto L_0x00a8
            java.lang.String r5 = r2.getCity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
        L_0x00a8:
            java.lang.String r5 = r2.getState()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x00b4
            r5 = r3
            goto L_0x00b5
        L_0x00b4:
            r5 = r4
        L_0x00b5:
            if (r5 == 0) goto L_0x00cd
            java.lang.String r5 = r2.getState()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
        L_0x00cd:
            java.lang.String r5 = r2.getZip()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x00d9
            r5 = r3
            goto L_0x00da
        L_0x00d9:
            r5 = r4
        L_0x00da:
            if (r5 == 0) goto L_0x00f2
            java.lang.String r5 = r2.getZip()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.append(r5)
        L_0x00f2:
            java.util.Locale r5 = new java.util.Locale
            com.checkout.base.model.Country r2 = r2.getCountry()
            java.lang.String r2 = r2.getIso3166Alpha2()
            r5.<init>(r1, r2)
            java.lang.String r1 = r5.getDisplayCountry()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.append(r1)
        L_0x0115:
            com.checkout.tokenization.model.Phone r1 = r8.getPhone()
            if (r1 == 0) goto L_0x012d
            java.lang.String r1 = r1.getNumber()
            if (r1 == 0) goto L_0x012d
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0129
            r1 = r3
            goto L_0x012a
        L_0x0129:
            r1 = r4
        L_0x012a:
            if (r1 != r3) goto L_0x012d
            goto L_0x012e
        L_0x012d:
            r3 = r4
        L_0x012e:
            if (r3 == 0) goto L_0x0169
            com.checkout.tokenization.model.Phone r1 = r8.getPhone()
            r2 = 0
            if (r1 == 0) goto L_0x0142
            com.checkout.base.model.Country r1 = r1.getCountry()
            if (r1 == 0) goto L_0x0142
            java.lang.String r1 = r1.getDialingCode()
            goto L_0x0143
        L_0x0142:
            r1 = r2
        L_0x0143:
            com.checkout.tokenization.model.Phone r8 = r8.getPhone()
            if (r8 == 0) goto L_0x014d
            java.lang.String r2 = r8.getNumber()
        L_0x014d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "\n+"
            r8.append(r3)
            r8.append(r1)
            java.lang.String r1 = " "
            r8.append(r1)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r0.append(r8)
        L_0x0169:
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "strBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.CharSequence r8 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r8)
            java.lang.String r1 = r8.toString()
        L_0x017a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.utils.extensions.BillingAddressExtensionsKt.summary(com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress):java.lang.String");
    }
}
