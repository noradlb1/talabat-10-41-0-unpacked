package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "delta", "invoke-MK-Hz9U", "(J)J"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 extends Lambda implements Function1<Offset, Offset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScrollingLogic f2208g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ScrollScope f2209h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(ScrollingLogic scrollingLogic, ScrollScope scrollScope) {
        super(1);
        this.f2208g = scrollingLogic;
        this.f2209h = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m2665boximpl(m358invokeMKHz9U(((Offset) obj).m2686unboximpl()));
    }

    /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
    public final long m358invokeMKHz9U(long j11) {
        ScrollingLogic scrollingLogic = this.f2208g;
        return Offset.m2680minusMKHz9U(j11, this.f2208g.m351reverseIfNeededMKHz9U(scrollingLogic.m346dispatchScroll3eAAhYA(this.f2209h, scrollingLogic.m351reverseIfNeededMKHz9U(j11), NestedScrollSource.Companion.m4219getFlingWNlRxjI())));
    }
}
