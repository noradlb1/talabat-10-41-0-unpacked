package com.talabat.sdsquad.ui.vendorslist.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.vendorslist.response.ActiveEvent;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/mappers/EventActionDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/ActiveEventDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "()V", "mapToView", "type", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventActionDisplayMapper implements DisplayModelMapper<ActiveEventDisplayModel, ActiveEvent> {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r3 = r6.getIsac();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel mapToView(@org.jetbrains.annotations.Nullable com.talabat.sdsquad.data.vendorslist.response.ActiveEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x000a
            java.lang.String r1 = r6.getEmg()
            if (r1 != 0) goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            r2 = 0
            if (r6 == 0) goto L_0x0019
            java.lang.Boolean r3 = r6.getIsac()
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.booleanValue()
            goto L_0x001a
        L_0x0019:
            r3 = r2
        L_0x001a:
            if (r6 == 0) goto L_0x0024
            java.lang.String r4 = r6.getEvt()
            if (r4 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r4
        L_0x0024:
            if (r6 == 0) goto L_0x0030
            java.lang.Integer r6 = r6.getEva()
            if (r6 == 0) goto L_0x0030
            int r2 = r6.intValue()
        L_0x0030:
            com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel r6 = new com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel
            r6.<init>(r1, r2, r0, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.ui.vendorslist.mappers.EventActionDisplayMapper.mapToView(com.talabat.sdsquad.data.vendorslist.response.ActiveEvent):com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel");
    }
}
