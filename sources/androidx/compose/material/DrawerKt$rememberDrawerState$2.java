package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$rememberDrawerState$2 extends Lambda implements Function0<DrawerState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DrawerValue f4510g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<DrawerValue, Boolean> f4511h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$rememberDrawerState$2(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        super(0);
        this.f4510g = drawerValue;
        this.f4511h = function1;
    }

    @NotNull
    public final DrawerState invoke() {
        return new DrawerState(this.f4510g, this.f4511h);
    }
}
