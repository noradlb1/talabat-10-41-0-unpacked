package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 implements MeasuredLineFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f2947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutMeasureScope f2948c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2949d;

    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(boolean z11, List<Integer> list, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11) {
        this.f2946a = z11;
        this.f2947b = list;
        this.f2948c = lazyLayoutMeasureScope;
        this.f2949d = i11;
    }

    @NotNull
    /* renamed from: createLine-H9FfpSk  reason: not valid java name */
    public final LazyMeasuredLine m697createLineH9FfpSk(int i11, @NotNull LazyMeasuredItem[] lazyMeasuredItemArr, @NotNull List<GridItemSpan> list, int i12) {
        Intrinsics.checkNotNullParameter(lazyMeasuredItemArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(list, "spans");
        return new LazyMeasuredLine(i11, lazyMeasuredItemArr, list, this.f2946a, this.f2947b.size(), this.f2948c.getLayoutDirection(), i12, this.f2949d, (DefaultConstructorMarker) null);
    }
}
