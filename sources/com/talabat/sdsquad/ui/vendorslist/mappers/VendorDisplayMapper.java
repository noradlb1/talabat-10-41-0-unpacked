package com.talabat.sdsquad.ui.vendorslist.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.vendorslist.response.Cuisine;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/mappers/VendorDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "()V", "getCuisineIds", "", "", "cuisines", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "getCuisineString", "", "getUpSellImage", "upSellUrl", "getVendorLogo", "logo", "isUserHaveSubscribe", "", "isVendorSubscribed", "mapToView", "type", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorDisplayMapper implements DisplayModelMapper<VendorDisplayModel, Vendor> {
    private final List<Integer> getCuisineIds(List<Cuisine> list) {
        int i11;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Cuisine id2 : list) {
            Integer id3 = id2.getId();
            if (id3 != null) {
                i11 = id3.intValue();
            } else {
                i11 = 0;
            }
            arrayList.add(Integer.valueOf(i11));
        }
        return arrayList;
    }

    private final String getCuisineString(List<Cuisine> list) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            for (Cuisine next : list) {
                if (sb2.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next.getNa());
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    private final String getUpSellImage(String str) {
        return "";
    }

    private final String getVendorLogo(String str) {
        if (str == null) {
            return "";
        }
        String replace = new Regex(" ").replace((CharSequence) str, "%20");
        return "https://images.deliveryhero.io/image/talabat/restaurants/" + replace;
    }

    private final boolean isUserHaveSubscribe(boolean z11) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016b  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel mapToView(@org.jetbrains.annotations.NotNull com.talabat.sdsquad.data.vendorslist.response.Vendor r46) {
        /*
            r45 = this;
            r0 = r45
            java.lang.String r1 = "type"
            r2 = r46
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.Integer r1 = r46.getId()
            if (r1 == 0) goto L_0x0016
            int r1 = r1.intValue()
            r5 = r1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            int r6 = r46.getBid()
            java.lang.String r1 = r46.getNa()
            java.lang.String r4 = ""
            if (r1 != 0) goto L_0x0025
            r7 = r4
            goto L_0x0026
        L_0x0025:
            r7 = r1
        L_0x0026:
            java.util.List r1 = r46.getCus()
            java.lang.String r8 = r0.getCuisineString(r1)
            java.lang.Boolean r1 = r46.getIsn()
            if (r1 == 0) goto L_0x003a
            boolean r1 = r1.booleanValue()
            r9 = r1
            goto L_0x003b
        L_0x003a:
            r9 = 0
        L_0x003b:
            java.lang.Double r1 = r46.getRat()
            if (r1 == 0) goto L_0x0047
            double r10 = r1.doubleValue()
            float r1 = (float) r10
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            r10 = r1
            java.lang.Integer r1 = r46.getDtim()
            if (r1 == 0) goto L_0x0055
            int r1 = r1.intValue()
            r11 = r1
            goto L_0x0056
        L_0x0055:
            r11 = 0
        L_0x0056:
            java.lang.Double r1 = r46.getMna()
            r12 = 0
            if (r1 == 0) goto L_0x0063
            double r14 = r1.doubleValue()
            goto L_0x0064
        L_0x0063:
            r14 = r12
        L_0x0064:
            java.lang.Double r1 = r46.getDch()
            if (r1 == 0) goto L_0x006e
            double r12 = r1.doubleValue()
        L_0x006e:
            r16 = r12
            java.lang.String r1 = r46.getTrts()
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = "0"
        L_0x0078:
            java.lang.Boolean r12 = r46.getItg()
            if (r12 == 0) goto L_0x0085
            boolean r12 = r12.booleanValue()
            r18 = r12
            goto L_0x0087
        L_0x0085:
            r18 = 0
        L_0x0087:
            java.lang.Boolean r12 = r46.getIda()
            if (r12 == 0) goto L_0x0094
            boolean r12 = r12.booleanValue()
            r19 = r12
            goto L_0x0096
        L_0x0094:
            r19 = 0
        L_0x0096:
            java.lang.Boolean r12 = r46.getIpa()
            if (r12 == 0) goto L_0x00a3
            boolean r12 = r12.booleanValue()
            r20 = r12
            goto L_0x00a5
        L_0x00a3:
            r20 = 0
        L_0x00a5:
            java.lang.Boolean r12 = r46.getIsub()
            if (r12 == 0) goto L_0x00b0
            boolean r12 = r12.booleanValue()
            goto L_0x00b1
        L_0x00b0:
            r12 = 0
        L_0x00b1:
            boolean r21 = r0.isUserHaveSubscribe(r12)
            java.lang.String r12 = r46.getUsicon()
            java.lang.String r22 = r0.getUpSellImage(r12)
            java.lang.Integer r12 = r46.getStt()
            if (r12 == 0) goto L_0x00c8
            int r12 = r12.intValue()
            goto L_0x00c9
        L_0x00c8:
            r12 = 0
        L_0x00c9:
            r13 = 2
            r3 = 1
            if (r12 == r13) goto L_0x00e0
            java.lang.Integer r12 = r46.getStt()
            if (r12 == 0) goto L_0x00d8
            int r12 = r12.intValue()
            goto L_0x00d9
        L_0x00d8:
            r12 = 0
        L_0x00d9:
            r13 = 4
            if (r12 != r13) goto L_0x00dd
            goto L_0x00e0
        L_0x00dd:
            r24 = 0
            goto L_0x00e2
        L_0x00e0:
            r24 = r3
        L_0x00e2:
            java.lang.Integer r12 = r46.getStt()
            if (r12 == 0) goto L_0x00ed
            int r12 = r12.intValue()
            goto L_0x00ee
        L_0x00ed:
            r12 = 0
        L_0x00ee:
            if (r12 != r3) goto L_0x00f3
            r25 = r3
            goto L_0x00f5
        L_0x00f3:
            r25 = 0
        L_0x00f5:
            java.lang.Integer r12 = r46.getStt()
            if (r12 == 0) goto L_0x0100
            int r12 = r12.intValue()
            goto L_0x0101
        L_0x0100:
            r12 = 0
        L_0x0101:
            if (r12 != 0) goto L_0x0106
            r26 = r3
            goto L_0x0108
        L_0x0106:
            r26 = 0
        L_0x0108:
            java.lang.String r12 = r46.getLg()
            if (r12 != 0) goto L_0x0111
            r27 = r4
            goto L_0x0113
        L_0x0111:
            r27 = r12
        L_0x0113:
            java.lang.Boolean r12 = r46.getIss()
            if (r12 == 0) goto L_0x0120
            boolean r12 = r12.booleanValue()
            r28 = r12
            goto L_0x0122
        L_0x0120:
            r28 = 0
        L_0x0122:
            java.lang.Boolean r12 = r46.getIush()
            if (r12 == 0) goto L_0x012f
            boolean r12 = r12.booleanValue()
            r29 = r12
            goto L_0x0131
        L_0x012f:
            r29 = 0
        L_0x0131:
            java.util.List r12 = r46.getFids()
            if (r12 != 0) goto L_0x013b
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x013b:
            r30 = r12
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x014f }
            java.lang.String r13 = "dd/MM/yyyy HH:mm:ss"
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x014f }
            r12.<init>(r13, r3)     // Catch:{ Exception -> 0x014f }
            java.lang.String r3 = r46.getAct()     // Catch:{ Exception -> 0x014f }
            java.util.Date r3 = r12.parse(r3)     // Catch:{ Exception -> 0x014f }
            goto L_0x0154
        L_0x014f:
            java.util.Date r3 = new java.util.Date
            r3.<init>()
        L_0x0154:
            java.lang.String r12 = "try {\n                Si…     Date()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            java.util.List r12 = r46.getCus()
            java.util.List r32 = r0.getCuisineIds(r12)
            java.lang.String r12 = r46.getGtl()
            if (r12 != 0) goto L_0x016b
            r33 = r4
            goto L_0x016d
        L_0x016b:
            r33 = r12
        L_0x016d:
            java.lang.String r34 = ""
            r35 = 0
            java.lang.String r12 = r46.getAvd()
            if (r12 != 0) goto L_0x017a
            r36 = r4
            goto L_0x017c
        L_0x017a:
            r36 = r12
        L_0x017c:
            java.lang.Boolean r12 = r46.getAc()
            if (r12 == 0) goto L_0x0187
            boolean r12 = r12.booleanValue()
            goto L_0x0188
        L_0x0187:
            r12 = 0
        L_0x0188:
            if (r12 == 0) goto L_0x01a9
            java.lang.Boolean r12 = r46.getAcr()
            if (r12 == 0) goto L_0x0195
            boolean r12 = r12.booleanValue()
            goto L_0x0196
        L_0x0195:
            r12 = 0
        L_0x0196:
            if (r12 != 0) goto L_0x01a9
            java.lang.Boolean r12 = r46.getAdb()
            if (r12 == 0) goto L_0x01a3
            boolean r12 = r12.booleanValue()
            goto L_0x01a4
        L_0x01a3:
            r12 = 0
        L_0x01a4:
            if (r12 != 0) goto L_0x01a9
            r37 = 1
            goto L_0x01ab
        L_0x01a9:
            r37 = 0
        L_0x01ab:
            java.lang.Boolean r12 = r46.getIpt()
            if (r12 == 0) goto L_0x01b8
            boolean r12 = r12.booleanValue()
            r38 = r12
            goto L_0x01ba
        L_0x01b8:
            r38 = 0
        L_0x01ba:
            java.lang.String r12 = r46.getDtxt()
            if (r12 != 0) goto L_0x01c3
            r39 = r4
            goto L_0x01c5
        L_0x01c3:
            r39 = r12
        L_0x01c5:
            java.lang.Integer r4 = r46.getPriceTag()
            if (r4 == 0) goto L_0x01d2
            int r4 = r4.intValue()
            r40 = r4
            goto L_0x01d4
        L_0x01d2:
            r40 = 0
        L_0x01d4:
            java.lang.Integer r4 = r46.getVerticalType()
            if (r4 == 0) goto L_0x01e1
            int r4 = r4.intValue()
            r41 = r4
            goto L_0x01e3
        L_0x01e1:
            r41 = 0
        L_0x01e3:
            java.lang.Boolean r4 = r46.getRgrl()
            if (r4 == 0) goto L_0x01f0
            boolean r4 = r4.booleanValue()
            r42 = r4
            goto L_0x01f2
        L_0x01f0:
            r42 = 0
        L_0x01f2:
            java.lang.Boolean r4 = r46.getIsds()
            if (r4 == 0) goto L_0x01ff
            boolean r4 = r4.booleanValue()
            r43 = r4
            goto L_0x0201
        L_0x01ff:
            r43 = 0
        L_0x0201:
            java.lang.Boolean r2 = r46.isSafeDropOff()
            if (r2 == 0) goto L_0x020c
            boolean r2 = r2.booleanValue()
            goto L_0x020d
        L_0x020c:
            r2 = 0
        L_0x020d:
            com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel r44 = new com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel
            r4 = r44
            r12 = r14
            r14 = r16
            r16 = r1
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r24
            r23 = r25
            r24 = r26
            r25 = r27
            r26 = r28
            r27 = r29
            r28 = r30
            r29 = r3
            r30 = r32
            r31 = r33
            r32 = r34
            r33 = r35
            r34 = r36
            r35 = r37
            r36 = r38
            r37 = r39
            r38 = r40
            r39 = r41
            r40 = r42
            r41 = r43
            r42 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return r44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.ui.vendorslist.mappers.VendorDisplayMapper.mapToView(com.talabat.sdsquad.data.vendorslist.response.Vendor):com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel");
    }
}
