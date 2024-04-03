package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorCellType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ToggleHeader", "Vendor", "VendorCard", "Collections", "Swimlane", "InlineAd", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum VendorCellType {
    ToggleHeader(0),
    Vendor(1),
    VendorCard(2),
    Collections(3),
    Swimlane(4),
    InlineAd(5);
    
    private final int type;

    private VendorCellType(int i11) {
        this.type = i11;
    }

    public final int getType() {
        return this.type;
    }
}
