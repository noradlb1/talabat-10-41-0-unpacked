package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeableState$latestNonEmptyAnchorsFlow$1 extends Lambda implements Function0<Map<Float, ? extends T>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f5675g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$latestNonEmptyAnchorsFlow$1(SwipeableState<T> swipeableState) {
        super(0);
        this.f5675g = swipeableState;
    }

    @NotNull
    public final Map<Float, T> invoke() {
        return this.f5675g.getAnchors$material_release();
    }
}
