package com.talabat.sdsquad.ui.vendorslist.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/mappers/VendorInfoDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "()V", "mapToView", "type", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoDisplayMapper implements DisplayModelMapper<VendorInfo, VendorsInfoResponse> {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r3 = (r3 = r3.getCountry()).getDno();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo mapToView(@org.jetbrains.annotations.NotNull com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse r3) {
        /*
            r2 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo r0 = new com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo
            java.lang.String r1 = r3.getBaseUrl()
            if (r1 != 0) goto L_0x0010
            java.lang.String r1 = ""
        L_0x0010:
            com.talabat.sdsquad.data.vendorslist.response.Result r3 = r3.getResult()
            if (r3 == 0) goto L_0x0027
            com.talabat.sdsquad.data.vendorslist.response.Country r3 = r3.getCountry()
            if (r3 == 0) goto L_0x0027
            java.lang.Integer r3 = r3.getDno()
            if (r3 == 0) goto L_0x0027
            int r3 = r3.intValue()
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            r0.<init>(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.ui.vendorslist.mappers.VendorInfoDisplayMapper.mapToView(com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse):com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo");
    }
}
