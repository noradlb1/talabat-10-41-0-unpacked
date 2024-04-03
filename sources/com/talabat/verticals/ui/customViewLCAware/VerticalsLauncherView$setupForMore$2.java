package com.talabat.verticals.ui.customViewLCAware;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView$setupForMore$2", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsLauncherView$setupForMore$2 extends GridLayoutManager.SpanSizeLookup {
    public int getSpanSize(int i11) {
        if (i11 == 0 || i11 == 1) {
            return 3;
        }
        return i11 != 2 ? 1 : 6;
    }
}
