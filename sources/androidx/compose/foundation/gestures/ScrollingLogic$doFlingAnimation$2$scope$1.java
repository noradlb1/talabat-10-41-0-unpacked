package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"androidx/compose/foundation/gestures/ScrollingLogic$doFlingAnimation$2$scope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScrollingLogic$doFlingAnimation$2$scope$1 implements ScrollScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScrollingLogic f2210a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Offset> f2211b;

    public ScrollingLogic$doFlingAnimation$2$scope$1(ScrollingLogic scrollingLogic, Function1<? super Offset, Offset> function1) {
        this.f2210a = scrollingLogic;
        this.f2211b = function1;
    }

    public float scrollBy(float f11) {
        ScrollingLogic scrollingLogic = this.f2210a;
        return scrollingLogic.m355toFloatk4lQ0M(this.f2211b.invoke(Offset.m2665boximpl(scrollingLogic.m356toOffsettuRUvjQ(f11))).m2686unboximpl());
    }
}
