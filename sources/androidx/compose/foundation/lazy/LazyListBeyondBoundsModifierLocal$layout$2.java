package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/LazyListBeyondBoundsModifierLocal$layout$2", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "hasMoreContent", "", "getHasMoreContent", "()Z", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListBeyondBoundsModifierLocal$layout$2 implements BeyondBoundsLayout.BeyondBoundsScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazyListBeyondBoundsModifierLocal f2735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<LazyListBeyondBoundsInfo.Interval> f2736b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2737c;

    public LazyListBeyondBoundsModifierLocal$layout$2(LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal, Ref.ObjectRef<LazyListBeyondBoundsInfo.Interval> objectRef, int i11) {
        this.f2735a = lazyListBeyondBoundsModifierLocal;
        this.f2736b = objectRef;
        this.f2737c = i11;
    }

    public boolean getHasMoreContent() {
        return this.f2735a.m628hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) this.f2736b.element, this.f2737c);
    }
}
