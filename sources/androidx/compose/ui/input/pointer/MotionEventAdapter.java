package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010(\u001a\u00020\u001f*\u00020\u00152\u0006\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "canHover", "Landroid/util/SparseBooleanArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousSource", "", "previousToolType", "addFreshIds", "", "motionEvent", "Landroid/view/MotionEvent;", "clearOnDeviceChange", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "pressed", "", "endStream", "pointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "removeStaleIds", "hasPointerId", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MotionEventAdapter {
    @NotNull
    private final SparseBooleanArray canHover = new SparseBooleanArray();
    @NotNull
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private long nextId;
    @NotNull
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousSource = -1;
    private int previousToolType = -1;

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j11 = this.nextId;
                this.nextId = 1 + j11;
                sparseLongArray.put(pointerId, j11);
                if (motionEvent.getToolType(actionIndex) == 3) {
                    this.canHover.put(pointerId, true);
                }
            }
        } else if (actionMasked == 9) {
            int pointerId2 = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
                SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
                long j12 = this.nextId;
                this.nextId = 1 + j12;
                sparseLongArray2.put(pointerId2, j12);
            }
        }
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            int toolType = motionEvent.getToolType(0);
            int source = motionEvent.getSource();
            if (toolType != this.previousToolType || source != this.previousSource) {
                this.previousToolType = toolType;
                this.previousSource = source;
                this.canHover.clear();
                this.motionEventToComposePointerIdMap.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.input.pointer.PointerInputEventData createPointerInputEventData(androidx.compose.ui.input.pointer.PositionCalculator r25, android.view.MotionEvent r26, int r27, boolean r28) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            int r4 = r26.getPointerId(r27)
            long r6 = r0.m4239getComposePointerId_I2yYro(r4)
            float r15 = r26.getPressure(r27)
            float r4 = r26.getX(r27)
            float r5 = r26.getY(r27)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            if (r3 != 0) goto L_0x0035
            float r4 = r26.getRawX()
            float r5 = r26.getRawY()
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            long r8 = r1.m4375screenToLocalMKHz9U(r4)
        L_0x0032:
            r10 = r4
            r12 = r8
            goto L_0x004c
        L_0x0035:
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r8 < r9) goto L_0x0046
            androidx.compose.ui.input.pointer.MotionEventHelper r4 = androidx.compose.ui.input.pointer.MotionEventHelper.INSTANCE
            long r4 = r4.m4240toRawOffsetdBAh8RU(r2, r3)
            long r8 = r1.m4375screenToLocalMKHz9U(r4)
            goto L_0x0032
        L_0x0046:
            long r8 = r1.m4374localToScreenMKHz9U(r4)
            r12 = r4
            r10 = r8
        L_0x004c:
            int r1 = r26.getToolType(r27)
            r4 = 1
            if (r1 == 0) goto L_0x0081
            if (r1 == r4) goto L_0x007a
            r5 = 2
            if (r1 == r5) goto L_0x0073
            r5 = 3
            if (r1 == r5) goto L_0x006c
            r5 = 4
            if (r1 == r5) goto L_0x0065
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4373getUnknownT8wyACA()
            goto L_0x0087
        L_0x0065:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4369getEraserT8wyACA()
            goto L_0x0087
        L_0x006c:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4370getMouseT8wyACA()
            goto L_0x0087
        L_0x0073:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4371getStylusT8wyACA()
            goto L_0x0087
        L_0x007a:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4372getTouchT8wyACA()
            goto L_0x0087
        L_0x0081:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4373getUnknownT8wyACA()
        L_0x0087:
            r16 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r5 = r26.getHistorySize()
            r9 = 0
        L_0x0093:
            if (r9 >= r5) goto L_0x00db
            float r14 = r2.getHistoricalX(r3, r9)
            float r4 = r2.getHistoricalY(r3, r9)
            boolean r17 = java.lang.Float.isInfinite(r14)
            if (r17 != 0) goto L_0x00ac
            boolean r17 = java.lang.Float.isNaN(r14)
            if (r17 != 0) goto L_0x00ac
            r17 = 1
            goto L_0x00ae
        L_0x00ac:
            r17 = 0
        L_0x00ae:
            if (r17 == 0) goto L_0x00d7
            boolean r17 = java.lang.Float.isInfinite(r4)
            if (r17 != 0) goto L_0x00bf
            boolean r17 = java.lang.Float.isNaN(r4)
            if (r17 != 0) goto L_0x00bf
            r17 = 1
            goto L_0x00c1
        L_0x00bf:
            r17 = 0
        L_0x00c1:
            if (r17 == 0) goto L_0x00d7
            androidx.compose.ui.input.pointer.HistoricalChange r8 = new androidx.compose.ui.input.pointer.HistoricalChange
            long r19 = r2.getHistoricalEventTime(r9)
            long r21 = androidx.compose.ui.geometry.OffsetKt.Offset(r14, r4)
            r23 = 0
            r18 = r8
            r18.<init>(r19, r21, r23)
            r1.add(r8)
        L_0x00d7:
            int r9 = r9 + 1
            r4 = 1
            goto L_0x0093
        L_0x00db:
            int r4 = r26.getActionMasked()
            r5 = 8
            if (r4 != r5) goto L_0x00f7
            r4 = 10
            float r4 = r2.getAxisValue(r4)
            r5 = 9
            float r5 = r2.getAxisValue(r5)
            float r5 = -r5
            r8 = 0
            float r5 = r5 + r8
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            goto L_0x00fd
        L_0x00f7:
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r4.m2692getZeroF1C5BW0()
        L_0x00fd:
            r19 = r4
            android.util.SparseBooleanArray r4 = r0.canHover
            int r3 = r26.getPointerId(r27)
            r5 = 0
            boolean r17 = r4.get(r3, r5)
            androidx.compose.ui.input.pointer.PointerInputEventData r3 = new androidx.compose.ui.input.pointer.PointerInputEventData
            r5 = r3
            long r8 = r26.getEventTime()
            r21 = 0
            r14 = r28
            r18 = r1
            r5.<init>(r6, r8, r10, r12, r14, r15, r16, r17, r18, r19, r21)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.MotionEventAdapter.createPointerInputEventData(androidx.compose.ui.input.pointer.PositionCalculator, android.view.MotionEvent, int, boolean):androidx.compose.ui.input.pointer.PointerInputEventData");
    }

    /* renamed from: getComposePointerId-_I2yYro  reason: not valid java name */
    private final long m4239getComposePointerId_I2yYro(int i11) {
        long j11;
        int indexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(i11);
        if (indexOfKey >= 0) {
            j11 = this.motionEventToComposePointerIdMap.valueAt(indexOfKey);
        } else {
            j11 = this.nextId;
            this.nextId = 1 + j11;
            this.motionEventToComposePointerIdMap.put(i11, j11);
        }
        return PointerId.m4289constructorimpl(j11);
    }

    @VisibleForTesting
    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i11) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (motionEvent.getPointerId(i12) == i11) {
                return true;
            }
        }
        return false;
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.canHover.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.canHover.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int keyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, keyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.canHover.delete(keyAt);
                }
            }
        }
    }

    @Nullable
    public final PointerInputEvent convertToPointerInputEvent$ui_release(@NotNull MotionEvent motionEvent, @NotNull PositionCalculator positionCalculator) {
        boolean z11;
        boolean z12;
        int i11;
        boolean z13;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3) {
            this.motionEventToComposePointerIdMap.clear();
            this.canHover.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        if (actionMasked == 10 || actionMasked == 7 || actionMasked == 9) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (actionMasked == 8) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11) {
            this.canHover.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked == 1) {
            i11 = 0;
        } else if (actionMasked != 6) {
            i11 = -1;
        } else {
            i11 = motionEvent.getActionIndex();
        }
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        for (int i12 = 0; i12 < pointerCount; i12++) {
            List<PointerInputEventData> list = this.pointers;
            if (z11 || i12 == i11 || (z12 && motionEvent.getButtonState() == 0)) {
                z13 = false;
            } else {
                z13 = true;
            }
            list.add(createPointerInputEventData(positionCalculator, motionEvent, i12, z13));
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int i11) {
        this.canHover.delete(i11);
        this.motionEventToComposePointerIdMap.delete(i11);
    }

    @NotNull
    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }
}
