package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/gestures/DefaultDraggableState$dragScope$1", "Landroidx/compose/foundation/gestures/DragScope;", "dragBy", "", "pixels", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultDraggableState$dragScope$1 implements DragScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultDraggableState f1833a;

    public DefaultDraggableState$dragScope$1(DefaultDraggableState defaultDraggableState) {
        this.f1833a = defaultDraggableState;
    }

    public void dragBy(float f11) {
        this.f1833a.getOnDelta().invoke(Float.valueOf(f11));
    }
}
