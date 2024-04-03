package y4;

import com.deliveryhero.fluid.widgets.collections.grid.FreeSpacingLayoutManager;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;

public final /* synthetic */ class a implements FreeSpacingLayoutManager.ItemSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GridWidget f34834a;

    public /* synthetic */ a(GridWidget gridWidget) {
        this.f34834a = gridWidget;
    }

    public final FreeSpacingLayoutManager.ItemSize getSize(int i11) {
        return GridWidget.m8203cellLayoutManager$lambda0(this.f34834a, i11);
    }
}
