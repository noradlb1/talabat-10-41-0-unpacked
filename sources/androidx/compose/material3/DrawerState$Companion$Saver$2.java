package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DrawerState;", "it", "Landroidx/compose/material3/DrawerValue;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DrawerState$Companion$Saver$2 extends Lambda implements Function1<DrawerValue, DrawerState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<DrawerValue, Boolean> f6963g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerState$Companion$Saver$2(Function1<? super DrawerValue, Boolean> function1) {
        super(1);
        this.f6963g = function1;
    }

    @Nullable
    public final DrawerState invoke(@NotNull DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return new DrawerState(drawerValue, this.f6963g);
    }
}
