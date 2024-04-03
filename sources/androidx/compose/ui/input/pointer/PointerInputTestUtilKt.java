package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001aG\u0010\b\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0013\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0019\"\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001aU\u0010\u0017\u001a\u00020\t*\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\nj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001d\u001a(\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0000\u001a(\u0010!\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\"\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000*<\b\u0000\u0010#\"\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\n2\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "invokeOverAllPasses", "", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "moveBy", "dx", "dy", "moveTo", "up", "PointerInputHandler", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PointerInputTestUtilKt {
    @NotNull
    public static final PointerInputChange down(long j11, long j12, float f11, float f12) {
        return new PointerInputChange(PointerId.m4289constructorimpl(j11), j12, OffsetKt.Offset(f11, f12), true, 1.0f, j12, OffsetKt.Offset(f11, f12), false, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange down$default(long j11, long j12, float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = 0;
        }
        return down(j11, j12, (i11 & 4) != 0 ? 0.0f : f11, (i11 & 8) != 0 ? 0.0f : f12);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY  reason: not valid java name */
    public static final void m4343invokeOverAllPassesH0pRuoY(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, long j11) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverAllPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        m4347invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt__CollectionsKt.listOf(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), j11);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY$default  reason: not valid java name */
    public static /* synthetic */ void m4344invokeOverAllPassesH0pRuoY$default(Function3 function3, PointerEvent pointerEvent, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4343invokeOverAllPassesH0pRuoY(function3, pointerEvent, j11);
    }

    /* renamed from: invokeOverPass-hUlJWOE  reason: not valid java name */
    public static final void m4345invokeOverPasshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j11) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPass");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pointerEventPass");
        m4347invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) CollectionsKt__CollectionsJVMKt.listOf(pointerEventPass), j11);
    }

    /* renamed from: invokeOverPass-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4346invokeOverPasshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4345invokeOverPasshUlJWOE(function3, pointerEvent, pointerEventPass, j11);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m4348invokeOverPasseshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass[] pointerEventPassArr, long j11) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPassArr, "pointerEventPasses");
        m4347invokeOverPasseshUlJWOE(function3, pointerEvent, (List<? extends PointerEventPass>) ArraysKt___ArraysKt.toList((T[]) pointerEventPassArr), j11);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4350invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4348invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, pointerEventPassArr, j11);
    }

    @NotNull
    public static final PointerInputChange moveBy(@NotNull PointerInputChange pointerInputChange, long j11, float f11, float f12) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long r32 = pointerInputChange.m4305getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(r32, pointerInputChange.getUptimeMillis() + j11, OffsetKt.Offset(Offset.m2676getXimpl(pointerInputChange.m4306getPositionF1C5BW0()) + f11, Offset.m2677getYimpl(pointerInputChange.m4306getPositionF1C5BW0()) + f12), true, 1.0f, uptimeMillis, pointerInputChange.m4306getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f12 = 0.0f;
        }
        return moveBy(pointerInputChange, j11, f11, f12);
    }

    @NotNull
    public static final PointerInputChange moveTo(@NotNull PointerInputChange pointerInputChange, long j11, float f11, float f12) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long r12 = pointerInputChange.m4305getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(r12, j11, OffsetKt.Offset(f11, f12), true, 1.0f, uptimeMillis, pointerInputChange.m4306getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f12 = 0.0f;
        }
        return moveTo(pointerInputChange, j11, f11, f12);
    }

    @NotNull
    public static final PointerInputChange up(@NotNull PointerInputChange pointerInputChange, long j11) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        long r12 = pointerInputChange.m4305getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(r12, j11, pointerInputChange.m4306getPositionF1C5BW0(), false, 1.0f, uptimeMillis, pointerInputChange.m4306getPositionF1C5BW0(), pressed, false, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m4347invokeOverPasseshUlJWOE(@NotNull Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, @NotNull PointerEvent pointerEvent, @NotNull List<? extends PointerEventPass> list, long j11) {
        Intrinsics.checkNotNullParameter(function3, "$this$invokeOverPasses");
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(list, "pointerEventPasses");
        if (!(!pointerEvent.getChanges().isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!list.isEmpty()) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                function3.invoke(pointerEvent, (PointerEventPass) list.get(i11), IntSize.m5630boximpl(j11));
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m4349invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, List list, long j11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4347invokeOverPasseshUlJWOE((Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit>) function3, pointerEvent, (List<? extends PointerEventPass>) list, j11);
    }
}
