package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemOfferTitleViewPort;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0002\u001a\"\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0007\u001a\f\u0010\u000b\u001a\u00020\t*\u00020\nH\u0007¨\u0006\f"}, d2 = {"currency", "", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "formattedSavingsAmount", "kotlin.jvm.PlatformType", "bindTitleData", "", "Lcom/talabat/gem/ports/presentation/GemOfferTitleViewPort;", "bindUserName", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemTitleBusinessRulesKt {
    @BusinessRules
    public static final void bindTitleData(@NotNull GemOfferTitleViewPort gemOfferTitleViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferTitleViewPort, "<this>");
        gemOfferTitleViewPort.autoDispose(new GemTitleBusinessRulesKt$bindTitleData$1(gemOfferTitleViewPort));
    }

    @BusinessRules
    public static final void bindUserName(@NotNull GemOfferTitleViewPort gemOfferTitleViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferTitleViewPort, "<this>");
        gemOfferTitleViewPort.autoDispose(new GemTitleBusinessRulesKt$bindUserName$1(gemOfferTitleViewPort));
    }

    /* access modifiers changed from: private */
    public static final String currency(List<GemTier> list) {
        Object obj;
        String currency;
        boolean z11;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((GemTier) obj).getCurrency() != null) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        GemTier gemTier = (GemTier) obj;
        if (gemTier == null || (currency = gemTier.getCurrency()) == null) {
            return "";
        }
        return currency;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.talabat.gem.domain.entities.GemTier} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String formattedSavingsAmount(java.util.List<com.talabat.gem.domain.entities.GemTier> r10) {
        /*
            java.text.DecimalFormat r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            boolean r1 = r10.hasNext()
            r2 = 0
            if (r1 != 0) goto L_0x0014
            r10 = 0
            goto L_0x0051
        L_0x0014:
            java.lang.Object r1 = r10.next()
            boolean r4 = r10.hasNext()
            if (r4 != 0) goto L_0x0020
        L_0x001e:
            r10 = r1
            goto L_0x0051
        L_0x0020:
            r4 = r1
            com.talabat.gem.domain.entities.GemTier r4 = (com.talabat.gem.domain.entities.GemTier) r4
            java.lang.Double r4 = r4.getOnTotalAmount()
            if (r4 == 0) goto L_0x002e
            double r4 = r4.doubleValue()
            goto L_0x002f
        L_0x002e:
            r4 = r2
        L_0x002f:
            java.lang.Object r6 = r10.next()
            r7 = r6
            com.talabat.gem.domain.entities.GemTier r7 = (com.talabat.gem.domain.entities.GemTier) r7
            java.lang.Double r7 = r7.getOnTotalAmount()
            if (r7 == 0) goto L_0x0041
            double r7 = r7.doubleValue()
            goto L_0x0042
        L_0x0041:
            r7 = r2
        L_0x0042:
            int r9 = java.lang.Double.compare(r4, r7)
            if (r9 >= 0) goto L_0x004a
            r1 = r6
            r4 = r7
        L_0x004a:
            boolean r6 = r10.hasNext()
            if (r6 != 0) goto L_0x002f
            goto L_0x001e
        L_0x0051:
            com.talabat.gem.domain.entities.GemTier r10 = (com.talabat.gem.domain.entities.GemTier) r10
            if (r10 == 0) goto L_0x0059
            double r2 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r10)
        L_0x0059:
            java.lang.String r10 = r0.format(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.usecases.GemTitleBusinessRulesKt.formattedSavingsAmount(java.util.List):java.lang.String");
    }
}
