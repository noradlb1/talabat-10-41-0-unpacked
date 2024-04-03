package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "()V", "previousPointerInputData", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "clear", "", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "PointerInputData", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PointerInputChangeEventProducer {
    @NotNull
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "down", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getPositionOnScreen-F1C5BW0", "()J", "J", "getType-T8wyACA", "()I", "I", "getUptime", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        private PointerInputData(long j11, long j12, boolean z11, int i11) {
            this.uptime = j11;
            this.positionOnScreen = j12;
            this.down = z11;
            this.type = i11;
        }

        public /* synthetic */ PointerInputData(long j11, long j12, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11, j12, z11, i11);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
        public final long m4310getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        /* renamed from: getType-T8wyACA  reason: not valid java name */
        public final int m4311getTypeT8wyACA() {
            return this.type;
        }

        public final long getUptime() {
            return this.uptime;
        }
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    @NotNull
    public final InternalPointerEvent produce(@NotNull PointerInputEvent pointerInputEvent, @NotNull PositionCalculator positionCalculator) {
        boolean z11;
        long j11;
        long j12;
        PointerInputEvent pointerInputEvent2 = pointerInputEvent;
        PositionCalculator positionCalculator2 = positionCalculator;
        Intrinsics.checkNotNullParameter(pointerInputEvent2, "pointerInputEvent");
        Intrinsics.checkNotNullParameter(positionCalculator2, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i11 = 0; i11 < size; i11++) {
            PointerInputEventData pointerInputEventData = pointers.get(i11);
            PointerInputData pointerInputData = this.previousPointerInputData.get(PointerId.m4288boximpl(pointerInputEventData.m4319getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                j12 = pointerInputEventData.getUptime();
                j11 = pointerInputEventData.m4320getPositionF1C5BW0();
                z11 = false;
            } else {
                long uptime = pointerInputData.getUptime();
                j12 = uptime;
                z11 = pointerInputData.getDown();
                j11 = positionCalculator2.m4375screenToLocalMKHz9U(pointerInputData.m4310getPositionOnScreenF1C5BW0());
            }
            linkedHashMap.put(PointerId.m4288boximpl(pointerInputEventData.m4319getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m4319getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m4320getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), j12, j11, z11, false, pointerInputEventData.m4323getTypeT8wyACA(), (List) pointerInputEventData.getHistorical(), pointerInputEventData.m4322getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null));
            if (pointerInputEventData.getDown()) {
                Map<PointerId, PointerInputData> map = this.previousPointerInputData;
                PointerId r102 = PointerId.m4288boximpl(pointerInputEventData.m4319getIdJ3iCeTQ());
                PointerInputData pointerInputData2 = r11;
                PointerInputData pointerInputData3 = new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m4321getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m4323getTypeT8wyACA(), (DefaultConstructorMarker) null);
                map.put(r102, pointerInputData2);
            } else {
                this.previousPointerInputData.remove(PointerId.m4288boximpl(pointerInputEventData.m4319getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent2);
    }
}
