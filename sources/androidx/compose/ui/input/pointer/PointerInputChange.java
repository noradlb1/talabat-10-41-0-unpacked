package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BT\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011Bh\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0017Bp\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001aBf\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001bB\\\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010;\u001a\u00020<J\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJo\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJw\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJm\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ}\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020MH\u0016R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0004\n\u0002\u0010\u001fR&\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148GX\u0004¢\u0006\f\u0012\u0004\b%\u0010\"\u001a\u0004\b&\u0010'R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b,\u0010\"\u001a\u0004\b+\u0010-R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b.\u0010)R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u001a\u0010\u0018\u001a\u00020\u00198GX\u0004¢\u0006\f\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u00102R\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b3\u0010)R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u001c\u0010\u0016\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b6\u0010)R\u001c\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "isInitiallyConsumed", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "(JJJZJJZZILjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "(JJJZFJJZZILjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "_pressure", "Ljava/lang/Float;", "<set-?>", "getConsumed$annotations", "()V", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getPosition-F1C5BW0", "getPressed", "getPressure$annotations", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PointerInputChange {
    @Nullable
    private List<HistoricalChange> _historical;
    @Nullable
    private Float _pressure;
    @NotNull
    private ConsumedData consumed;

    /* renamed from: id  reason: collision with root package name */
    private final long f9785id;
    private final long position;
    private final boolean pressed;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    @ExperimentalComposeUiApi
    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, j16);
    }

    @ExperimentalComposeUiApi
    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, List list, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, (List<HistoricalChange>) list, j16);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, j14, j15, z12, consumedData, i11);
    }

    private PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, boolean z13, int i11, long j16) {
        this.f9785id = j11;
        this.uptimeMillis = j12;
        this.position = j13;
        this.pressed = z11;
        this.previousUptimeMillis = j14;
        this.previousPosition = j15;
        this.previousPressed = z12;
        this.type = i11;
        this.scrollDelta = j16;
        boolean z14 = z13;
        this.consumed = new ConsumedData(z14, z14);
    }

    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, boolean z13, int i11, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, j14, j15, z12, z13, i11, j16);
    }

    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, boolean z13, int i11, List list, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, j14, j15, z12, z13, i11, (List<HistoricalChange>) list, j16);
    }

    /* renamed from: copy-0GkPj7c$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4295copy0GkPj7c$default(PointerInputChange pointerInputChange, long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11, long j16, int i12, Object obj) {
        long j17;
        long j18;
        long j19;
        boolean z13;
        long j21;
        long j22;
        boolean z14;
        int i13;
        long j23;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i14 = i12;
        if ((i14 & 1) != 0) {
            j17 = pointerInputChange2.f9785id;
        } else {
            j17 = j11;
        }
        if ((i14 & 2) != 0) {
            j18 = pointerInputChange2.uptimeMillis;
        } else {
            j18 = j12;
        }
        if ((i14 & 4) != 0) {
            j19 = pointerInputChange2.position;
        } else {
            j19 = j13;
        }
        if ((i14 & 8) != 0) {
            z13 = pointerInputChange2.pressed;
        } else {
            z13 = z11;
        }
        if ((i14 & 16) != 0) {
            j21 = pointerInputChange2.previousUptimeMillis;
        } else {
            j21 = j14;
        }
        if ((i14 & 32) != 0) {
            j22 = pointerInputChange2.previousPosition;
        } else {
            j22 = j15;
        }
        if ((i14 & 64) != 0) {
            z14 = pointerInputChange2.previousPressed;
        } else {
            z14 = z12;
        }
        if ((i14 & 256) != 0) {
            i13 = pointerInputChange2.type;
        } else {
            i13 = i11;
        }
        int i15 = i13;
        if ((i14 & 512) != 0) {
            j23 = pointerInputChange2.scrollDelta;
        } else {
            j23 = j16;
        }
        return pointerInputChange.m4300copy0GkPj7c(j17, j18, j19, z13, j21, j22, z14, consumedData, i15, j23);
    }

    /* renamed from: copy-Ezr-O64$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4296copyEzrO64$default(PointerInputChange pointerInputChange, long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11, int i12, Object obj) {
        long j16;
        long j17;
        long j18;
        boolean z13;
        long j19;
        long j21;
        boolean z14;
        ConsumedData consumedData2;
        int i13;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i14 = i12;
        if ((i14 & 1) != 0) {
            j16 = pointerInputChange2.f9785id;
        } else {
            j16 = j11;
        }
        if ((i14 & 2) != 0) {
            j17 = pointerInputChange2.uptimeMillis;
        } else {
            j17 = j12;
        }
        if ((i14 & 4) != 0) {
            j18 = pointerInputChange2.position;
        } else {
            j18 = j13;
        }
        if ((i14 & 8) != 0) {
            z13 = pointerInputChange2.pressed;
        } else {
            z13 = z11;
        }
        if ((i14 & 16) != 0) {
            j19 = pointerInputChange2.previousUptimeMillis;
        } else {
            j19 = j14;
        }
        if ((i14 & 32) != 0) {
            j21 = pointerInputChange2.previousPosition;
        } else {
            j21 = j15;
        }
        if ((i14 & 64) != 0) {
            z14 = pointerInputChange2.previousPressed;
        } else {
            z14 = z12;
        }
        if ((i14 & 128) != 0) {
            consumedData2 = pointerInputChange2.consumed;
        } else {
            consumedData2 = consumedData;
        }
        if ((i14 & 256) != 0) {
            i13 = pointerInputChange2.type;
        } else {
            i13 = i11;
        }
        return pointerInputChange.m4301copyEzrO64(j16, j17, j18, z13, j19, j21, z14, consumedData2, i13);
    }

    /* renamed from: copy-JKmWfYY$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4297copyJKmWfYY$default(PointerInputChange pointerInputChange, long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, int i11, long j16, int i12, Object obj) {
        long j17;
        long j18;
        long j19;
        boolean z13;
        long j21;
        long j22;
        boolean z14;
        int i13;
        long j23;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i14 = i12;
        if ((i14 & 1) != 0) {
            j17 = pointerInputChange2.f9785id;
        } else {
            j17 = j11;
        }
        if ((i14 & 2) != 0) {
            j18 = pointerInputChange2.uptimeMillis;
        } else {
            j18 = j12;
        }
        if ((i14 & 4) != 0) {
            j19 = pointerInputChange2.position;
        } else {
            j19 = j13;
        }
        if ((i14 & 8) != 0) {
            z13 = pointerInputChange2.pressed;
        } else {
            z13 = z11;
        }
        if ((i14 & 16) != 0) {
            j21 = pointerInputChange2.previousUptimeMillis;
        } else {
            j21 = j14;
        }
        if ((i14 & 32) != 0) {
            j22 = pointerInputChange2.previousPosition;
        } else {
            j22 = j15;
        }
        if ((i14 & 64) != 0) {
            z14 = pointerInputChange2.previousPressed;
        } else {
            z14 = z12;
        }
        if ((i14 & 128) != 0) {
            i13 = pointerInputChange2.type;
        } else {
            i13 = i11;
        }
        int i15 = i13;
        if ((i14 & 256) != 0) {
            j23 = pointerInputChange2.scrollDelta;
        } else {
            j23 = j16;
        }
        return pointerInputChange.m4302copyJKmWfYY(j17, j18, j19, z13, j21, j22, z14, i15, j23);
    }

    /* renamed from: copy-OHpmEuE$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4298copyOHpmEuE$default(PointerInputChange pointerInputChange, long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, int i11, List list, long j16, int i12, Object obj) {
        long j17;
        long j18;
        long j19;
        boolean z13;
        long j21;
        long j22;
        boolean z14;
        int i13;
        long j23;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i14 = i12;
        if ((i14 & 1) != 0) {
            j17 = pointerInputChange2.f9785id;
        } else {
            j17 = j11;
        }
        if ((i14 & 2) != 0) {
            j18 = pointerInputChange2.uptimeMillis;
        } else {
            j18 = j12;
        }
        if ((i14 & 4) != 0) {
            j19 = pointerInputChange2.position;
        } else {
            j19 = j13;
        }
        if ((i14 & 8) != 0) {
            z13 = pointerInputChange2.pressed;
        } else {
            z13 = z11;
        }
        if ((i14 & 16) != 0) {
            j21 = pointerInputChange2.previousUptimeMillis;
        } else {
            j21 = j14;
        }
        if ((i14 & 32) != 0) {
            j22 = pointerInputChange2.previousPosition;
        } else {
            j22 = j15;
        }
        if ((i14 & 64) != 0) {
            z14 = pointerInputChange2.previousPressed;
        } else {
            z14 = z12;
        }
        if ((i14 & 128) != 0) {
            i13 = pointerInputChange2.type;
        } else {
            i13 = i11;
        }
        int i15 = i13;
        if ((i14 & 512) != 0) {
            j23 = pointerInputChange2.scrollDelta;
        } else {
            j23 = j16;
        }
        return pointerInputChange.m4303copyOHpmEuE(j17, j18, j19, z13, j21, j22, z14, i15, list, j23);
    }

    /* renamed from: copy-wbzehF4$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4299copywbzehF4$default(PointerInputChange pointerInputChange, long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, int i11, List list, long j16, int i12, Object obj) {
        long j17;
        long j18;
        long j19;
        boolean z13;
        float f12;
        long j21;
        long j22;
        boolean z14;
        int i13;
        long j23;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i14 = i12;
        if ((i14 & 1) != 0) {
            j17 = pointerInputChange2.f9785id;
        } else {
            j17 = j11;
        }
        if ((i14 & 2) != 0) {
            j18 = pointerInputChange2.uptimeMillis;
        } else {
            j18 = j12;
        }
        if ((i14 & 4) != 0) {
            j19 = pointerInputChange2.position;
        } else {
            j19 = j13;
        }
        if ((i14 & 8) != 0) {
            z13 = pointerInputChange2.pressed;
        } else {
            z13 = z11;
        }
        if ((i14 & 16) != 0) {
            f12 = pointerInputChange.getPressure();
        } else {
            f12 = f11;
        }
        if ((i14 & 32) != 0) {
            j21 = pointerInputChange2.previousUptimeMillis;
        } else {
            j21 = j14;
        }
        if ((i14 & 64) != 0) {
            j22 = pointerInputChange2.previousPosition;
        } else {
            j22 = j15;
        }
        if ((i14 & 128) != 0) {
            z14 = pointerInputChange2.previousPressed;
        } else {
            z14 = z12;
        }
        if ((i14 & 256) != 0) {
            i13 = pointerInputChange2.type;
        } else {
            i13 = i11;
        }
        boolean z15 = z14;
        int i15 = i13;
        if ((i14 & 1024) != 0) {
            j23 = pointerInputChange2.scrollDelta;
        } else {
            j23 = j16;
        }
        return pointerInputChange.m4304copywbzehF4(j17, j18, j19, z13, f12, j21, j22, z15, i15, list, j23);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getHistorical$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getPressure$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    @NotNull
    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    /* renamed from: copy-0GkPj7c  reason: not valid java name */
    public final PointerInputChange m4300copy0GkPj7c(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, @NotNull ConsumedData consumedData, int i11, long j16) {
        boolean z13;
        ConsumedData consumedData2 = consumedData;
        Intrinsics.checkNotNullParameter(consumedData2, "consumed");
        float pressure = getPressure();
        if (consumedData.getDownChange() || consumedData.getPositionChange()) {
            z13 = true;
        } else {
            z13 = false;
        }
        PointerInputChange pointerInputChange = new PointerInputChange(j11, j12, j13, z11, pressure, j14, j15, z12, z13, i11, (List) getHistorical(), j16, (DefaultConstructorMarker) null);
        this.consumed = consumedData2;
        return pointerInputChange;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* renamed from: copy-Ezr-O64  reason: not valid java name */
    public final /* synthetic */ PointerInputChange m4301copyEzrO64(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11) {
        boolean z13;
        ConsumedData consumedData2 = consumedData;
        Intrinsics.checkNotNullParameter(consumedData2, "consumed");
        float pressure = getPressure();
        if (consumedData.getDownChange() || consumedData.getPositionChange()) {
            z13 = true;
        } else {
            z13 = false;
        }
        PointerInputChange pointerInputChange = new PointerInputChange(j11, j12, j13, z11, pressure, j14, j15, z12, z13, i11, (List) getHistorical(), this.scrollDelta, (DefaultConstructorMarker) null);
        this.consumed = consumedData2;
        return pointerInputChange;
    }

    @NotNull
    /* renamed from: copy-JKmWfYY  reason: not valid java name */
    public final PointerInputChange m4302copyJKmWfYY(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, int i11, long j16) {
        PointerInputChange pointerInputChange = r0;
        PointerInputChange pointerInputChange2 = new PointerInputChange(j11, j12, j13, z11, getPressure(), j14, j15, z12, false, i11, (List) getHistorical(), j16, (DefaultConstructorMarker) null);
        PointerInputChange pointerInputChange3 = pointerInputChange;
        pointerInputChange3.consumed = this.consumed;
        return pointerInputChange3;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: copy-OHpmEuE  reason: not valid java name */
    public final PointerInputChange m4303copyOHpmEuE(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, int i11, @NotNull List<HistoricalChange> list, long j16) {
        Intrinsics.checkNotNullParameter(list, "historical");
        PointerInputChange pointerInputChange = r0;
        PointerInputChange pointerInputChange2 = new PointerInputChange(j11, j12, j13, z11, getPressure(), j14, j15, z12, false, i11, (List) list, j16, (DefaultConstructorMarker) null);
        PointerInputChange pointerInputChange3 = pointerInputChange;
        pointerInputChange3.consumed = this.consumed;
        return pointerInputChange3;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: copy-wbzehF4  reason: not valid java name */
    public final PointerInputChange m4304copywbzehF4(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, int i11, @NotNull List<HistoricalChange> list, long j16) {
        Intrinsics.checkNotNullParameter(list, "historical");
        PointerInputChange pointerInputChange = r0;
        PointerInputChange pointerInputChange2 = new PointerInputChange(j11, j12, j13, z11, f11, j14, j15, z12, false, i11, (List) list, j16, (DefaultConstructorMarker) null);
        PointerInputChange pointerInputChange3 = pointerInputChange;
        pointerInputChange3.consumed = this.consumed;
        return pointerInputChange3;
    }

    @NotNull
    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m4305getIdJ3iCeTQ() {
        return this.f9785id;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m4306getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    @ExperimentalComposeUiApi
    public final float getPressure() {
        Float f11 = this._pressure;
        if (f11 != null) {
            return f11.floatValue();
        }
        return 0.0f;
    }

    /* renamed from: getPreviousPosition-F1C5BW0  reason: not valid java name */
    public final long m4307getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m4308getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m4309getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    @NotNull
    public String toString() {
        return "PointerInputChange(id=" + PointerId.m4293toStringimpl(this.f9785id) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m2684toStringimpl(this.position) + ", pressed=" + this.pressed + ", pressure=" + getPressure() + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + Offset.m2684toStringimpl(this.previousPosition) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + PointerType.m4367toStringimpl(this.type) + ", historical=" + getHistorical() + ",scrollDelta=" + Offset.m2684toStringimpl(this.scrollDelta) + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r21, long r23, long r25, boolean r27, long r28, long r30, boolean r32, boolean r33, int r34, long r35, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4372getTouchT8wyACA()
            r16 = r1
            goto L_0x0011
        L_0x000f:
            r16 = r34
        L_0x0011:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m2692getZeroF1C5BW0()
            r17 = r0
            goto L_0x0020
        L_0x001e:
            r17 = r35
        L_0x0020:
            r19 = 0
            r2 = r20
            r3 = r21
            r5 = r23
            r7 = r25
            r9 = r27
            r10 = r28
            r12 = r30
            r14 = r32
            r15 = r33
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (long) r10, (long) r12, (boolean) r14, (boolean) r15, (int) r16, (long) r17, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, j14, j15, z12, consumedData, (i12 & 256) != 0 ? PointerType.Companion.m4372getTouchT8wyACA() : i11, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, ConsumedData consumedData, int i11) {
        this(j11, j12, j13, z11, 1.0f, j14, j15, z12, consumedData.getDownChange() || consumedData.getPositionChange(), i11, Offset.Companion.m2692getZeroF1C5BW0(), (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, boolean z13, int i11, List<HistoricalChange> list, long j16) {
        this(j11, j12, j13, z11, 1.0f, j14, j15, z12, z13, i11, (List) list, j16, (DefaultConstructorMarker) null);
        this._historical = list;
    }

    private PointerInputChange(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, List<HistoricalChange> list, long j16) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, j16, (DefaultConstructorMarker) null);
        this._historical = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r22, long r24, long r26, boolean r28, float r29, long r30, long r32, boolean r34, boolean r35, int r36, long r37, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4372getTouchT8wyACA()
            r17 = r1
            goto L_0x0011
        L_0x000f:
            r17 = r36
        L_0x0011:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m2692getZeroF1C5BW0()
            r18 = r0
            goto L_0x0020
        L_0x001e:
            r18 = r37
        L_0x0020:
            r20 = 0
            r2 = r21
            r3 = r22
            r5 = r24
            r7 = r26
            r9 = r28
            r10 = r29
            r11 = r30
            r13 = r32
            r15 = r34
            r16 = r35
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (float) r10, (long) r11, (long) r13, (boolean) r15, (boolean) r16, (int) r17, (long) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, float, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private PointerInputChange(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, long j16) {
        this(j11, j12, j13, z11, j14, j15, z12, z13, i11, j16, (DefaultConstructorMarker) null);
        this._pressure = Float.valueOf(f11);
    }
}
