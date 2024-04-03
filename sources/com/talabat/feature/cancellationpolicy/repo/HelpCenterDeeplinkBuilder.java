package com.talabat.feature.cancellationpolicy.repo;

import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/repo/HelpCenterDeeplinkBuilder;", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "()V", "build", "", "orderId", "caseId", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterDeeplinkBuilder implements IHelpCenterDeeplinkBuilder {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r3 == false) goto L_0x0025;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String build(@org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "talabat://?s=helpcenter/home"
            r0.<init>(r1)
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0014
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            if (r3 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r3 = r1
            goto L_0x0015
        L_0x0014:
            r3 = r2
        L_0x0015:
            if (r3 == 0) goto L_0x0025
            if (r7 == 0) goto L_0x0022
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r7)
            if (r3 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = r1
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            if (r3 != 0) goto L_0x007e
        L_0x0025:
            java.lang.String r3 = "?"
            r0.append(r3)
            if (r6 == 0) goto L_0x0035
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = r1
            goto L_0x0036
        L_0x0035:
            r3 = r2
        L_0x0036:
            if (r3 != 0) goto L_0x004c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "orderId="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r0.append(r3)
        L_0x004c:
            if (r7 == 0) goto L_0x0057
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r7)
            if (r3 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r3 = r1
            goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            if (r3 != 0) goto L_0x007e
            if (r6 == 0) goto L_0x0062
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            if (r6 == 0) goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            if (r1 != 0) goto L_0x006a
            java.lang.String r6 = "&"
            r0.append(r6)
        L_0x006a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "caseId="
            r6.append(r1)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.append(r6)
        L_0x007e:
            java.lang.String r6 = r0.toString()
            java.lang.String r7 = "routeBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.cancellationpolicy.repo.HelpCenterDeeplinkBuilder.build(java.lang.String, java.lang.String):java.lang.String");
    }
}
