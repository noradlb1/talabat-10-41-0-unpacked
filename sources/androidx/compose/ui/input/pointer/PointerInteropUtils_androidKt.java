package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a5\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u001a=\u0010\r\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"emptyCancelMotionEventScope", "", "nowMillis", "", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toCancelMotionEventScope", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "toCancelMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toMotionEventScope", "toMotionEventScope-d-4ec7I", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long j11, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MotionEvent obtain = MotionEvent.obtain(j11, j11, 3, 0.0f, 0.0f, 0);
        obtain.setSource(0);
        Intrinsics.checkNotNullExpressionValue(obtain, "motionEvent");
        function1.invoke(obtain);
        obtain.recycle();
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j11, function1);
    }

    /* renamed from: toCancelMotionEventScope-d-4ec7I  reason: not valid java name */
    public static final void m4352toCancelMotionEventScoped4ec7I(@NotNull PointerEvent pointerEvent, long j11, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(pointerEvent, "$this$toCancelMotionEventScope");
        Intrinsics.checkNotNullParameter(function1, "block");
        m4354toMotionEventScopeubNVwUQ(pointerEvent, j11, function1, true);
    }

    /* renamed from: toMotionEventScope-d-4ec7I  reason: not valid java name */
    public static final void m4353toMotionEventScoped4ec7I(@NotNull PointerEvent pointerEvent, long j11, @NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(pointerEvent, "$this$toMotionEventScope");
        Intrinsics.checkNotNullParameter(function1, "block");
        m4354toMotionEventScopeubNVwUQ(pointerEvent, j11, function1, false);
    }

    /* renamed from: toMotionEventScope-ubNVwUQ  reason: not valid java name */
    private static final void m4354toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j11, Function1<? super MotionEvent, Unit> function1, boolean z11) {
        MotionEvent motionEvent$ui_release = pointerEvent.getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int action = motionEvent$ui_release.getAction();
            if (z11) {
                motionEvent$ui_release.setAction(3);
            }
            motionEvent$ui_release.offsetLocation(-Offset.m2676getXimpl(j11), -Offset.m2677getYimpl(j11));
            function1.invoke(motionEvent$ui_release);
            motionEvent$ui_release.offsetLocation(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
            motionEvent$ui_release.setAction(action);
            return;
        }
        throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
    }
}
