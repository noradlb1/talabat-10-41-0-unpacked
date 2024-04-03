package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 implements MeasuredItemFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutMeasureScope f2939a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f2941c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2942d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f2943e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LazyGridItemPlacementAnimator f2944f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f2945g;

    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyLayoutMeasureScope lazyLayoutMeasureScope, boolean z11, boolean z12, int i11, int i12, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j11) {
        this.f2939a = lazyLayoutMeasureScope;
        this.f2940b = z11;
        this.f2941c = z12;
        this.f2942d = i11;
        this.f2943e = i12;
        this.f2944f = lazyGridItemPlacementAnimator;
        this.f2945g = j11;
    }

    @NotNull
    /* renamed from: createItem-PU_OBEw  reason: not valid java name */
    public final LazyMeasuredItem m696createItemPU_OBEw(int i11, @NotNull Object obj, int i12, int i13, @NotNull List<? extends Placeable> list) {
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, "key");
        List<? extends Placeable> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeables");
        return new LazyMeasuredItem(i11, obj2, this.f2940b, i12, i13, this.f2941c, this.f2939a.getLayoutDirection(), this.f2942d, this.f2943e, list2, this.f2944f, this.f2945g, (DefaultConstructorMarker) null);
    }
}
