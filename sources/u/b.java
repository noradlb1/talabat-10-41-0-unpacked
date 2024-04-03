package u;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LayoutCoordinates f11624b;

    public /* synthetic */ b(LayoutCoordinates layoutCoordinates) {
        this.f11624b = layoutCoordinates;
    }

    public final int compare(Object obj, Object obj2) {
        return SelectionRegistrarImpl.m1037sort$lambda2(this.f11624b, (Selectable) obj, (Selectable) obj2);
    }
}
