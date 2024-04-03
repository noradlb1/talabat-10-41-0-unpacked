package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/BottomDrawerState;", "it", "Landroidx/compose/material/BottomDrawerValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomDrawerState$Companion$Saver$2 extends Lambda implements Function1<BottomDrawerValue, BottomDrawerState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<BottomDrawerValue, Boolean> f4068g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomDrawerState$Companion$Saver$2(Function1<? super BottomDrawerValue, Boolean> function1) {
        super(1);
        this.f4068g = function1;
    }

    @Nullable
    public final BottomDrawerState invoke(@NotNull BottomDrawerValue bottomDrawerValue) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "it");
        return new BottomDrawerState(bottomDrawerValue, this.f4068g);
    }
}
