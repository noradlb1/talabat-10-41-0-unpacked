package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"androidx/compose/foundation/gestures/DefaultScrollableState$scrollScope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultScrollableState$scrollScope$1 implements ScrollScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScrollableState f1848a;

    public DefaultScrollableState$scrollScope$1(DefaultScrollableState defaultScrollableState) {
        this.f1848a = defaultScrollableState;
    }

    public float scrollBy(float f11) {
        return this.f1848a.getOnDelta().invoke(Float.valueOf(f11)).floatValue();
    }
}
