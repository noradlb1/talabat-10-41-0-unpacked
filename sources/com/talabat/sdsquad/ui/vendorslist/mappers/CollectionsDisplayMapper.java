package com.talabat.sdsquad.ui.vendorslist.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.vendorslist.response.Collections;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/mappers/CollectionsDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "()V", "mapToView", "type", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsDisplayMapper implements DisplayModelMapper<CollectionDisplayModel, Collections> {
    @NotNull
    public CollectionDisplayModel mapToView(@NotNull Collections collections) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(collections, "type");
        Integer id2 = collections.getId();
        int intValue = id2 != null ? id2.intValue() : 0;
        String sic = collections.getSic();
        String str4 = sic == null ? "" : sic;
        String wnm = collections.getWnm();
        if (wnm == null) {
            str = "";
        } else {
            str = wnm;
        }
        String cc2 = collections.getCc();
        if (cc2 == null) {
            cc2 = "000000";
        }
        String str5 = "#" + cc2;
        String des = collections.getDes();
        if (des == null) {
            str2 = "";
        } else {
            str2 = des;
        }
        Boolean its = collections.getIts();
        boolean booleanValue = its != null ? its.booleanValue() : false;
        String bic = collections.getBic();
        if (bic == null) {
            str3 = "";
        } else {
            str3 = bic;
        }
        Boolean isc = collections.getIsc();
        boolean booleanValue2 = isc != null ? isc.booleanValue() : false;
        Boolean ht2 = collections.getHt();
        return new CollectionDisplayModel(intValue, str4, str, str5, str2, booleanValue, str3, "", booleanValue2, ht2 != null ? ht2.booleanValue() : false);
    }
}
