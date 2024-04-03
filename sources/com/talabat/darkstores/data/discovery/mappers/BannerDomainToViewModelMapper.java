package com.talabat.darkstores.data.discovery.mappers;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/discovery/mappers/BannerDomainToViewModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "Lcom/talabat/darkstores/model/Banner;", "()V", "apply", "banner", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerDomainToViewModelMapper implements ModelMapper<Banner, com.talabat.darkstores.model.Banner> {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0022, code lost:
        r13 = r13.getTrackingId();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.darkstores.model.Banner apply(@org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.vendorlanding.domain.model.Banner r13) {
        /*
            r12 = this;
            java.lang.String r0 = "banner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r2 = r13.getGlobalId()
            java.lang.String r3 = r13.getName()
            java.lang.String r4 = r13.getBannerUrl()
            int r5 = r13.getPosition()
            com.talabat.darkstores.model.TargetAudienceType r6 = com.talabat.darkstores.model.TargetAudienceType.ALL
            boolean r7 = r13.isStatic()
            r8 = 0
            com.talabat.feature.darkstores.vendorlanding.domain.model.BannerTracking r13 = r13.getTracking()
            if (r13 == 0) goto L_0x002f
            java.lang.String r13 = r13.getTrackingId()
            if (r13 == 0) goto L_0x002f
            com.talabat.feature.darkstorescart.data.model.Tracking r0 = new com.talabat.feature.darkstorescart.data.model.Tracking
            r0.<init>(r13)
            r9 = r0
            goto L_0x0031
        L_0x002f:
            r13 = 0
            r9 = r13
        L_0x0031:
            r10 = 0
            r11 = 0
            com.talabat.darkstores.model.Banner r13 = new com.talabat.darkstores.model.Banner
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.discovery.mappers.BannerDomainToViewModelMapper.apply(com.talabat.feature.darkstores.vendorlanding.domain.model.Banner):com.talabat.darkstores.model.Banner");
    }
}
