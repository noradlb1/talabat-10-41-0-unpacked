package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 implements MeasuredItemFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2786a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2787b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutMeasureScope f2788c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2789d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2790e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2791f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f2792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LazyListItemPlacementAnimator f2795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f2796k;

    public LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(int i11, int i12, LazyLayoutMeasureScope lazyLayoutMeasureScope, boolean z11, Alignment.Horizontal horizontal, Alignment.Vertical vertical, boolean z12, int i13, int i14, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j11) {
        this.f2786a = i11;
        this.f2787b = i12;
        this.f2788c = lazyLayoutMeasureScope;
        this.f2789d = z11;
        this.f2790e = horizontal;
        this.f2791f = vertical;
        this.f2792g = z12;
        this.f2793h = i13;
        this.f2794i = i14;
        this.f2795j = lazyListItemPlacementAnimator;
        this.f2796k = j11;
    }

    @NotNull
    /* renamed from: createItem-HK0c1C0  reason: not valid java name */
    public final LazyMeasuredItem m635createItemHK0c1C0(int i11, @NotNull Object obj, @NotNull List<? extends Placeable> list) {
        int i12;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(list, "placeables");
        if (i11 == this.f2786a - 1) {
            i12 = 0;
        } else {
            i12 = this.f2787b;
        }
        int i13 = i12;
        return new LazyMeasuredItem(i11, list, this.f2789d, this.f2790e, this.f2791f, this.f2788c.getLayoutDirection(), this.f2792g, this.f2793h, this.f2794i, this.f2795j, i13, this.f2796k, obj, (DefaultConstructorMarker) null);
    }
}
