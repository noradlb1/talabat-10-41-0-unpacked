package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollKt$rememberScrollState$1$1 extends Lambda implements Function0<ScrollState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1791g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollKt$rememberScrollState$1$1(int i11) {
        super(0);
        this.f1791g = i11;
    }

    @NotNull
    public final ScrollState invoke() {
        return new ScrollState(this.f1791g);
    }
}
