package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tJ\u0011\u0010\u0011\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DismissState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/DismissValue;", "initialValue", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;)V", "dismissDirection", "Landroidx/compose/material/DismissDirection;", "getDismissDirection", "()Landroidx/compose/material/DismissDirection;", "dismiss", "", "direction", "(Landroidx/compose/material/DismissDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDismissed", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Landroidx/compose/material/DismissState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DismissState;", "Landroidx/compose/material/DismissValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<DismissState, DismissValue> Saver(@NotNull Function1<? super DismissValue, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return SaverKt.Saver(DismissState$Companion$Saver$1.INSTANCE, new DismissState$Companion$Saver$2(function1));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DismissState(DismissValue dismissValue, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(dismissValue, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    @Nullable
    public final Object dismiss(@NotNull DismissDirection dismissDirection, @NotNull Continuation<? super Unit> continuation) {
        DismissValue dismissValue;
        if (dismissDirection == DismissDirection.StartToEnd) {
            dismissValue = DismissValue.DismissedToEnd;
        } else {
            dismissValue = DismissValue.DismissedToStart;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this, dismissValue, (AnimationSpec) null, continuation, 2, (Object) null);
        if (animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo$default;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final DismissDirection getDismissDirection() {
        if (getOffset().getValue().floatValue() == 0.0f) {
            return null;
        }
        return getOffset().getValue().floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final boolean isDismissed(@NotNull DismissDirection dismissDirection) {
        DismissValue dismissValue;
        Intrinsics.checkNotNullParameter(dismissDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Object currentValue = getCurrentValue();
        if (dismissDirection == DismissDirection.StartToEnd) {
            dismissValue = DismissValue.DismissedToEnd;
        } else {
            dismissValue = DismissValue.DismissedToStart;
        }
        if (currentValue == dismissValue) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Object reset(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, DismissValue.Default, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DismissState(@NotNull DismissValue dismissValue, @NotNull Function1<? super DismissValue, Boolean> function1) {
        super(dismissValue, (AnimationSpec) null, function1, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(dismissValue, "initialValue");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
    }
}
