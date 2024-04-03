package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$rememberTopAppBarState$1$1 extends Lambda implements Function0<TopAppBarState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f6542g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6543h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f6544i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$rememberTopAppBarState$1$1(float f11, float f12, float f13) {
        super(0);
        this.f6542g = f11;
        this.f6543h = f12;
        this.f6544i = f13;
    }

    @NotNull
    public final TopAppBarState invoke() {
        return new TopAppBarState(this.f6542g, this.f6543h, this.f6544i);
    }
}
