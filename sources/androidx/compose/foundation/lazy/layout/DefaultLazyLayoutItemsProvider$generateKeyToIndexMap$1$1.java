package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "it", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1 extends Lambda implements Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2982g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2983h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HashMap<Object, Integer> f2984i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(int i11, int i12, HashMap<Object, Integer> hashMap) {
        super(1);
        this.f2982g = i11;
        this.f2983h = i12;
        this.f2984i = hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent>) (IntervalList.Interval) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntervalList.Interval<? extends LazyLayoutIntervalContent> interval) {
        Intrinsics.checkNotNullParameter(interval, "it");
        if (((LazyLayoutIntervalContent) interval.getValue()).getKey() != null) {
            Function1<Integer, Object> key = ((LazyLayoutIntervalContent) interval.getValue()).getKey();
            if (key != null) {
                int max = Math.max(this.f2982g, interval.getStartIndex());
                int min = Math.min(this.f2983h, (interval.getStartIndex() + interval.getSize()) - 1);
                if (max <= min) {
                    while (true) {
                        this.f2984i.put(key.invoke(Integer.valueOf(max - interval.getStartIndex())), Integer.valueOf(max));
                        if (max != min) {
                            max++;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }
}
