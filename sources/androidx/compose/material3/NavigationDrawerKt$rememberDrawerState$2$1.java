package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$rememberDrawerState$2$1 extends Lambda implements Function0<DrawerState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DrawerValue f7553g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<DrawerValue, Boolean> f7554h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$rememberDrawerState$2$1(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        super(0);
        this.f7553g = drawerValue;
        this.f7554h = function1;
    }

    @NotNull
    public final DrawerState invoke() {
        return new DrawerState(this.f7553g, this.f7554h);
    }
}
