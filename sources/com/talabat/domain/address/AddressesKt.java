package com.talabat.domain.address;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"EPSILON", "", "description", "", "Lcom/talabat/domain/address/Address;", "isCountryOnlySupportsOldAddress", "", "isValid", "merge", "address", "com_talabat_domain_address_address"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AddressesKt {
    public static final double EPSILON = 1.0E-5d;

    @NotNull
    public static final String description(@NotNull Address address, boolean z11) {
        Intrinsics.checkNotNullParameter(address, "<this>");
        if (address.isOldAddreses || z11) {
            String str = address.extraDirections;
            if (str == null) {
                return "";
            }
            return str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(address.block);
        arrayList.add(address.street);
        arrayList.add(address.buildingNo);
        arrayList.add(address.judda);
        arrayList.add(address.floor);
        arrayList.add(address.suite);
        ArrayList arrayList2 = new ArrayList();
        for (Object next : CollectionsKt___CollectionsKt.filterNotNull(arrayList)) {
            if (!StringsKt__StringsJVMKt.isBlank((String) next)) {
                arrayList2.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final boolean isValid(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "<this>");
        if (Math.abs(address.latitude) < 1.0E-5d || Math.abs(address.longitude) < 1.0E-5d) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0171, code lost:
        if (r11 == null) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r3 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r4 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        if (r5 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ad, code lost:
        if (r9 == null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c0, code lost:
        if (r10 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d3, code lost:
        if (r13 == null) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ec, code lost:
        if (r12 == null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x015c, code lost:
        if (r11 == null) goto L_0x015e;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.domain.address.Address merge(@org.jetbrains.annotations.NotNull com.talabat.domain.address.Address r38, @org.jetbrains.annotations.NotNull com.talabat.domain.address.Address r39) {
        /*
            r0 = r38
            r15 = r39
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = r15.f58343id
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)
            r32 = 1
            r2 = r2 ^ 1
            r33 = 0
            if (r2 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r1 = r33
        L_0x001f:
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = r0.f58343id
        L_0x0023:
            int r2 = r15.areaId
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r2.intValue()
            r34 = 0
            if (r3 <= 0) goto L_0x0034
            r3 = r32
            goto L_0x0036
        L_0x0034:
            r3 = r34
        L_0x0036:
            if (r3 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r2 = r33
        L_0x003b:
            if (r2 == 0) goto L_0x0042
            int r2 = r2.intValue()
            goto L_0x0044
        L_0x0042:
            int r2 = r0.areaId
        L_0x0044:
            java.lang.String r3 = r15.areaName
            if (r3 == 0) goto L_0x0055
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r3)
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r3 = r33
        L_0x0053:
            if (r3 != 0) goto L_0x0057
        L_0x0055:
            java.lang.String r3 = r0.areaName
        L_0x0057:
            java.lang.String r4 = r15.block
            if (r4 == 0) goto L_0x0068
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r4)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = r33
        L_0x0066:
            if (r4 != 0) goto L_0x006a
        L_0x0068:
            java.lang.String r4 = r0.block
        L_0x006a:
            java.lang.String r5 = r15.buildingNo
            if (r5 == 0) goto L_0x007b
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r5 = r33
        L_0x0079:
            if (r5 != 0) goto L_0x007d
        L_0x007b:
            java.lang.String r5 = r0.buildingNo
        L_0x007d:
            int r6 = r15.cityId
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r7 = r6.intValue()
            if (r7 <= 0) goto L_0x008c
            r7 = r32
            goto L_0x008e
        L_0x008c:
            r7 = r34
        L_0x008e:
            if (r7 == 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r6 = r33
        L_0x0093:
            if (r6 == 0) goto L_0x009a
            int r6 = r6.intValue()
            goto L_0x009c
        L_0x009a:
            int r6 = r0.cityId
        L_0x009c:
            r7 = 0
            r8 = 0
            java.lang.String r9 = r15.extraDirections
            if (r9 == 0) goto L_0x00af
            boolean r10 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            r10 = r10 ^ 1
            if (r10 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r9 = r33
        L_0x00ad:
            if (r9 != 0) goto L_0x00b1
        L_0x00af:
            java.lang.String r9 = r0.extraDirections
        L_0x00b1:
            java.lang.String r10 = r15.floor
            if (r10 == 0) goto L_0x00c2
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r10)
            r11 = r11 ^ 1
            if (r11 == 0) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            r10 = r33
        L_0x00c0:
            if (r10 != 0) goto L_0x00c4
        L_0x00c2:
            java.lang.String r10 = r0.floor
        L_0x00c4:
            java.lang.String r13 = r15.grl
            if (r13 == 0) goto L_0x00d5
            boolean r14 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r13)
            r14 = r14 ^ 1
            if (r14 == 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r13 = r33
        L_0x00d3:
            if (r13 != 0) goto L_0x00d7
        L_0x00d5:
            java.lang.String r13 = r0.grl
        L_0x00d7:
            boolean r14 = r15.isAreaSplit
            r17 = 0
            r18 = 0
            java.lang.String r12 = r15.judda
            if (r12 == 0) goto L_0x00ee
            boolean r20 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)
            r20 = r20 ^ 1
            if (r20 == 0) goto L_0x00ea
            goto L_0x00ec
        L_0x00ea:
            r12 = r33
        L_0x00ec:
            if (r12 != 0) goto L_0x00f0
        L_0x00ee:
            java.lang.String r12 = r0.judda
        L_0x00f0:
            r20 = r12
            double r11 = r15.latitude
            java.lang.Double r11 = java.lang.Double.valueOf(r11)
            double r22 = r11.doubleValue()
            double r22 = java.lang.Math.abs(r22)
            r24 = 4532020583610935537(0x3ee4f8b588e368f1, double:1.0E-5)
            int r12 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r12 < 0) goto L_0x010c
            r12 = r32
            goto L_0x010e
        L_0x010c:
            r12 = r34
        L_0x010e:
            if (r12 == 0) goto L_0x0111
            goto L_0x0113
        L_0x0111:
            r11 = r33
        L_0x0113:
            if (r11 == 0) goto L_0x011a
            double r11 = r11.doubleValue()
            goto L_0x011c
        L_0x011a:
            double r11 = r0.latitude
        L_0x011c:
            r22 = r11
            double r11 = r15.longitude
            java.lang.Double r11 = java.lang.Double.valueOf(r11)
            double r26 = r11.doubleValue()
            double r26 = java.lang.Math.abs(r26)
            int r12 = (r26 > r24 ? 1 : (r26 == r24 ? 0 : -1))
            if (r12 < 0) goto L_0x0133
            r12 = r32
            goto L_0x0135
        L_0x0133:
            r12 = r34
        L_0x0135:
            if (r12 == 0) goto L_0x0138
            goto L_0x013a
        L_0x0138:
            r11 = r33
        L_0x013a:
            if (r11 == 0) goto L_0x0141
            double r11 = r11.doubleValue()
            goto L_0x0143
        L_0x0141:
            double r11 = r0.longitude
        L_0x0143:
            r24 = r11
            r26 = 0
            r27 = 0
            r28 = 0
            r35 = 0
            java.lang.String r11 = r15.street
            if (r11 == 0) goto L_0x015e
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r11)
            r12 = r12 ^ 1
            if (r12 == 0) goto L_0x015a
            goto L_0x015c
        L_0x015a:
            r11 = r33
        L_0x015c:
            if (r11 != 0) goto L_0x0160
        L_0x015e:
            java.lang.String r11 = r0.street
        L_0x0160:
            r36 = r11
            java.lang.String r11 = r15.suite
            if (r11 == 0) goto L_0x0173
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r11)
            r12 = r12 ^ 1
            if (r12 == 0) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r11 = r33
        L_0x0171:
            if (r11 != 0) goto L_0x0175
        L_0x0173:
            java.lang.String r11 = r0.suite
        L_0x0175:
            r37 = r11
            r29 = 0
            r30 = 82947264(0x4f1acc0, float:5.6817474E-36)
            r31 = 0
            r0 = r38
            r11 = 0
            r12 = 0
            r16 = r14
            r14 = 0
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r20
            r19 = r22
            r21 = r24
            r23 = r26
            r24 = r27
            r25 = r28
            r26 = r35
            r27 = r36
            r28 = r37
            com.talabat.domain.address.Address r0 = com.talabat.domain.address.Address.copy$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r1 = r39
            java.lang.String r1 = r1.grlid
            if (r1 == 0) goto L_0x01b0
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)
            if (r2 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r32 = r34
        L_0x01b0:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r32)
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x01bc
            r33 = r1
        L_0x01bc:
            if (r33 != 0) goto L_0x01c1
            java.lang.String r1 = r0.grlid
            goto L_0x01c3
        L_0x01c1:
            r1 = r33
        L_0x01c3:
            r0.grlid = r1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.domain.address.AddressesKt.merge(com.talabat.domain.address.Address, com.talabat.domain.address.Address):com.talabat.domain.address.Address");
    }
}
