package com.talabat.fluid.homescreen.presentation.mapper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\n"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/BannerAdItemMapper;", "", "()V", "mapFrom", "Lcom/talabat/homescreen/adapter/model/banner/BannerAdItem;", "url", "", "param", "", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerAdItemMapper {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY_BANNER_ID = "bannerId";
    @NotNull
    @Deprecated
    public static final String KEY_BANNER_NAME = "bannerName";
    @NotNull
    @Deprecated
    public static final String KEY_BANNER_ZONE = "bannerZone";
    @NotNull
    @Deprecated
    public static final String KEY_CHAIN_ID = "chainId";
    @NotNull
    @Deprecated
    public static final String KEY_CHAIN_NAME = "chainName";
    @NotNull
    @Deprecated
    public static final String KEY_IS_DARK_STORE = "isDarkStore";
    @NotNull
    @Deprecated
    public static final String KEY_IS_GRL_ENABLED = "isGrlEnabled";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_ID = "shopId";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_NAME = "shopName";
    @NotNull
    @Deprecated
    public static final String KEY_TYPE = "type";
    @NotNull
    @Deprecated
    public static final String KEY_VERTICAL_ID = "verticalId";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/BannerAdItemMapper$Companion;", "", "()V", "KEY_BANNER_ID", "", "KEY_BANNER_NAME", "KEY_BANNER_ZONE", "KEY_CHAIN_ID", "KEY_CHAIN_NAME", "KEY_IS_DARK_STORE", "KEY_IS_GRL_ENABLED", "KEY_SHOP_ID", "KEY_SHOP_NAME", "KEY_TYPE", "KEY_VERTICAL_ID", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (r10 != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (r2 != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0038, code lost:
        if (r8 != false) goto L_0x003c;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.talabat.homescreen.adapter.model.banner.BannerAdItem mapFrom(@org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r27) {
        /*
            r25 = this;
            r0 = r27
            java.lang.String r1 = "url"
            r15 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "param"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "bannerId"
            java.lang.Object r1 = r0.get(r1)
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            java.lang.String r1 = "bannerName"
            java.lang.Object r1 = r0.get(r1)
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r1 = "shopId"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1
            r6 = 0
            r7 = 0
            if (r1 == 0) goto L_0x003b
            int r8 = r1.length()
            if (r8 <= 0) goto L_0x0037
            r8 = r2
            goto L_0x0038
        L_0x0037:
            r8 = r6
        L_0x0038:
            if (r8 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = r7
        L_0x003c:
            java.lang.String r8 = "shopName"
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "chainId"
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x005a
            int r10 = r9.length()
            if (r10 <= 0) goto L_0x0056
            r10 = r2
            goto L_0x0057
        L_0x0056:
            r10 = r6
        L_0x0057:
            if (r10 == 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r9 = r7
        L_0x005b:
            java.lang.String r10 = "chainName"
            java.lang.Object r10 = r0.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            r11 = 0
            java.lang.String r12 = "verticalId"
            java.lang.Object r12 = r0.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x007a
            int r13 = r12.length()
            if (r13 <= 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r2 = r6
        L_0x0077:
            if (r2 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r12 = r7
        L_0x007b:
            java.lang.String r2 = "isGrlEnabled"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r2)
            java.lang.String r2 = "isDarkStore"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r2)
            java.lang.String r2 = "bannerZone"
            java.lang.Object r2 = r0.get(r2)
            r24 = r2
            java.lang.String r24 = (java.lang.String) r24
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00c1 }
            java.lang.String r2 = "type"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00bb
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00c1 }
            goto L_0x00bc
        L_0x00bb:
            r0 = r7
        L_0x00bc:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00c1 }
            goto L_0x00cc
        L_0x00c1:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00cc:
            boolean r2 = kotlin.Result.m6335isFailureimpl(r0)
            if (r2 == 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r7 = r0
        L_0x00d4:
            r16 = r7
            java.lang.Integer r16 = (java.lang.Integer) r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            com.talabat.homescreen.adapter.model.banner.BannerAdItem r0 = new com.talabat.homescreen.adapter.model.banner.BannerAdItem
            r2 = r0
            r6 = r1
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r24
            r15 = r26
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper.mapFrom(java.lang.String, java.util.Map):com.talabat.homescreen.adapter.model.banner.BannerAdItem");
    }
}
