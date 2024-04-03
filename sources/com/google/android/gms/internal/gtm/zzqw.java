package com.google.android.gms.internal.gtm;

import java.lang.reflect.Type;

public enum zzqw {
    DOUBLE(0, r13, r14),
    FLOAT(1, r11, r1),
    INT64(2, r11, r12),
    UINT64(3, r11, r12),
    INT32(4, r11, r21),
    FIXED64(5, r11, r3),
    FIXED32(6, r11, r21),
    BOOL(7, r11, r25),
    STRING(8, r11, r27),
    MESSAGE(9, r11, r29),
    BYTES(10, r11, r31),
    UINT32(11, r11, r21),
    ENUM(12, r11, r34),
    SFIXED32(13, r11, r21),
    SFIXED64(14, r11, r3),
    SINT32(15, r11, r21),
    SINT64(16, r11, r3),
    GROUP(17, r11, r29),
    DOUBLE_LIST(18, r40, r12),
    FLOAT_LIST(19, r19, r1),
    INT64_LIST(20, r19, r20),
    UINT64_LIST(21, r19, r20),
    INT32_LIST(22, r19, r21),
    FIXED64_LIST(23, r19, r3),
    FIXED32_LIST(24, r19, r21),
    BOOL_LIST(25, r19, r25),
    STRING_LIST(26, r19, r27),
    MESSAGE_LIST(27, r19, r29),
    BYTES_LIST(28, r19, r31),
    UINT32_LIST(29, r19, r21),
    ENUM_LIST(30, r19, r34),
    SFIXED32_LIST(31, r19, r21),
    SFIXED64_LIST(32, r19, r3),
    SINT32_LIST(33, r19, r21),
    SINT64_LIST(34, r19, r3),
    DOUBLE_LIST_PACKED(35, r56, r12),
    FLOAT_LIST_PACKED(36, r19, r1),
    INT64_LIST_PACKED(37, r19, r20),
    UINT64_LIST_PACKED(38, r19, r20),
    INT32_LIST_PACKED(39, r19, r21),
    FIXED64_LIST_PACKED(40, r19, r3),
    FIXED32_LIST_PACKED(41, r19, r21),
    BOOL_LIST_PACKED(42, r19, r25),
    UINT32_LIST_PACKED(43, r19, r21),
    ENUM_LIST_PACKED(44, r19, r34),
    SFIXED32_LIST_PACKED(45, r19, r21),
    SFIXED64_LIST_PACKED(46, r19, r3),
    SINT32_LIST_PACKED(47, r19, r21),
    SINT64_LIST_PACKED(48, r19, r3),
    GROUP_LIST(49, r40, r29),
    MAP(50, zzqy.MAP, zzrm.VOID);
    
    private static final zzqw[] zzazv = null;
    private static final Type[] zzazw = null;

    /* renamed from: id  reason: collision with root package name */
    private final int f35101id;
    private final zzrm zzazr;
    private final zzqy zzazs;
    private final Class<?> zzazt;
    private final boolean zzazu;

    /* access modifiers changed from: public */
    static {
        int i11;
        zzazw = new Type[0];
        zzqw[] values = values();
        zzazv = new zzqw[values.length];
        for (zzqw zzqw : values) {
            zzazv[zzqw.f35101id] = zzqw;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = com.google.android.gms.internal.gtm.zzqx.zzazz[r5.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzqw(int r3, com.google.android.gms.internal.gtm.zzqy r4, com.google.android.gms.internal.gtm.zzrm r5) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.f35101id = r3
            r0.zzazs = r4
            r0.zzazr = r5
            int[] r1 = com.google.android.gms.internal.gtm.zzqx.zzazy
            int r2 = r4.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0022
            if (r1 == r2) goto L_0x001b
            r1 = 0
            r0.zzazt = r1
            goto L_0x0028
        L_0x001b:
            java.lang.Class r1 = r5.zzpx()
            r0.zzazt = r1
            goto L_0x0028
        L_0x0022:
            java.lang.Class r1 = r5.zzpx()
            r0.zzazt = r1
        L_0x0028:
            com.google.android.gms.internal.gtm.zzqy r1 = com.google.android.gms.internal.gtm.zzqy.SCALAR
            if (r4 != r1) goto L_0x003c
            int[] r1 = com.google.android.gms.internal.gtm.zzqx.zzazz
            int r4 = r5.ordinal()
            r1 = r1[r4]
            if (r1 == r3) goto L_0x003c
            if (r1 == r2) goto L_0x003c
            r2 = 3
            if (r1 == r2) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            r0.zzazu = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqw.<init>(java.lang.String, int, int, com.google.android.gms.internal.gtm.zzqy, com.google.android.gms.internal.gtm.zzrm):void");
    }

    public final int id() {
        return this.f35101id;
    }
}
