package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$rememberBottomDrawerState$2 extends Lambda implements Function0<BottomDrawerState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomDrawerValue f4508g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<BottomDrawerValue, Boolean> f4509h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$rememberBottomDrawerState$2(BottomDrawerValue bottomDrawerValue, Function1<? super BottomDrawerValue, Boolean> function1) {
        super(0);
        this.f4508g = bottomDrawerValue;
        this.f4509h = function1;
    }

    @NotNull
    public final BottomDrawerState invoke() {
        return new BottomDrawerState(this.f4508g, this.f4509h);
    }
}
