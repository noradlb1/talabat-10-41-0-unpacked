package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScrollState f1811g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2(ScrollState scrollState) {
        super(0);
        this.f1811g = scrollState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf((float) this.f1811g.getMaxValue());
    }
}
