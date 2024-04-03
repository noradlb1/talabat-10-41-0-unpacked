package com.talabat.feature.fees.domain.usecase;

import com.talabat.feature.fees.domain.model.Fee;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/fees/domain/usecase/ServiceFeeFallback;", "", "fee", "Lcom/talabat/feature/fees/domain/model/Fee;", "subTotal", "", "(Lcom/talabat/feature/fees/domain/model/Fee;F)V", "getFee", "()Lcom/talabat/feature/fees/domain/model/Fee;", "getSubTotal", "()F", "calculate", "getPercentageCalculatedFee", "", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServiceFeeFallback {
    @NotNull
    private final Fee fee;
    private final float subTotal;

    public ServiceFeeFallback(@NotNull Fee fee2, float f11) {
        Intrinsics.checkNotNullParameter(fee2, "fee");
        this.fee = fee2;
        this.subTotal = f11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Double} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final double getPercentageCalculatedFee(float r5, com.talabat.feature.fees.domain.model.Fee r6) {
        /*
            r4 = this;
            double r0 = (double) r5
            double r2 = r6.getSetupValue()
            double r0 = r0 * r2
            r5 = 1120403456(0x42c80000, float:100.0)
            double r2 = (double) r5
            double r0 = r0 / r2
            java.util.Map r5 = r6.getTags()
            java.lang.String r2 = "cap_max"
            java.lang.Object r5 = r5.get(r2)
            boolean r2 = r5 instanceof java.lang.Double
            r3 = 0
            if (r2 == 0) goto L_0x001c
            java.lang.Double r5 = (java.lang.Double) r5
            goto L_0x001d
        L_0x001c:
            r5 = r3
        L_0x001d:
            java.util.Map r6 = r6.getTags()
            java.lang.String r2 = "cap_min"
            java.lang.Object r6 = r6.get(r2)
            boolean r2 = r6 instanceof java.lang.Double
            if (r2 == 0) goto L_0x002e
            r3 = r6
            java.lang.Double r3 = (java.lang.Double) r3
        L_0x002e:
            java.lang.Double r6 = java.lang.Double.valueOf(r0)
            java.lang.Comparable r5 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r6, r3, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.fees.domain.usecase.ServiceFeeFallback.getPercentageCalculatedFee(float, com.talabat.feature.fees.domain.model.Fee):double");
    }

    @NotNull
    public final Fee calculate() {
        if (this.fee.getValueType() != 1) {
            return this.fee;
        }
        Fee fee2 = this.fee;
        return Fee.copy$default(fee2, (String) null, (String) null, 0.0d, 0, getPercentageCalculatedFee(this.subTotal, fee2), (Map) null, 47, (Object) null);
    }

    @NotNull
    public final Fee getFee() {
        return this.fee;
    }

    public final float getSubTotal() {
        return this.subTotal;
    }
}
