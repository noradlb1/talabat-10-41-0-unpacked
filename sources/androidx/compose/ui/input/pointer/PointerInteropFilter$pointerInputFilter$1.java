package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J-\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "dispatchToView", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onCancel", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "reset", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointerInteropFilter f9787b;
    /* access modifiers changed from: private */
    @NotNull
    public PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;

    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.f9787b = pointerInteropFilter;
    }

    private final void dispatchToView(PointerEvent pointerEvent) {
        boolean z11;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = false;
                break;
            } else if (changes.get(i11).isConsumed()) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates$ui_release();
                if (layoutCoordinates$ui_release != null) {
                    PointerInteropUtils_androidKt.m4352toCancelMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release.m4475localToRootMKHz9U(Offset.Companion.m2692getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(this.f9787b));
                } else {
                    throw new IllegalStateException("layoutCoordinates not set".toString());
                }
            }
            this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
            return;
        }
        LayoutCoordinates layoutCoordinates$ui_release2 = getLayoutCoordinates$ui_release();
        if (layoutCoordinates$ui_release2 != null) {
            PointerInteropUtils_androidKt.m4353toMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release2.m4475localToRootMKHz9U(Offset.Companion.m2692getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$3(this, this.f9787b));
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                int size2 = changes.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    changes.get(i12).consume();
                }
                InternalPointerEvent internalPointerEvent$ui_release = pointerEvent.getInternalPointerEvent$ui_release();
                if (internalPointerEvent$ui_release != null) {
                    internalPointerEvent$ui_release.setSuppressMovementConsumption(!this.f9787b.getDisallowIntercept$ui_release());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.f9787b.setDisallowIntercept$ui_release(false);
    }

    public boolean getShareWithSiblings() {
        return true;
    }

    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(SystemClock.uptimeMillis(), new PointerInteropFilter$pointerInputFilter$1$onCancel$1(this.f9787b));
            reset();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4351onPointerEventH0pRuoY(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEvent r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEventPass r7, long r8) {
        /*
            r5 = this;
            java.lang.String r8 = "pointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            java.lang.String r8 = "pass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.util.List r8 = r6.getChanges()
            androidx.compose.ui.input.pointer.PointerInteropFilter r9 = r5.f9787b
            boolean r9 = r9.getDisallowIntercept$ui_release()
            r0 = 0
            r1 = 1
            if (r9 != 0) goto L_0x0042
            int r9 = r8.size()
            r2 = r0
        L_0x001d:
            if (r2 >= r9) goto L_0x003c
            java.lang.Object r3 = r8.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r3)
            if (r4 != 0) goto L_0x0034
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r3 = r0
            goto L_0x0035
        L_0x0034:
            r3 = r1
        L_0x0035:
            if (r3 == 0) goto L_0x0039
            r9 = r1
            goto L_0x003d
        L_0x0039:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x003c:
            r9 = r0
        L_0x003d:
            if (r9 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r9 = r0
            goto L_0x0043
        L_0x0042:
            r9 = r1
        L_0x0043:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r2 = r5.state
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r3 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r2 == r3) goto L_0x005b
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r7 != r2) goto L_0x0052
            if (r9 == 0) goto L_0x0052
            r5.dispatchToView(r6)
        L_0x0052:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r7 != r2) goto L_0x005b
            if (r9 != 0) goto L_0x005b
            r5.dispatchToView(r6)
        L_0x005b:
            androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r7 != r6) goto L_0x007c
            int r6 = r8.size()
            r7 = r0
        L_0x0064:
            if (r7 >= r6) goto L_0x0076
            java.lang.Object r9 = r8.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r9 != 0) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            int r7 = r7 + 1
            goto L_0x0064
        L_0x0076:
            r0 = r1
        L_0x0077:
            if (r0 == 0) goto L_0x007c
            r5.reset()
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.m4351onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent, androidx.compose.ui.input.pointer.PointerEventPass, long):void");
    }
}
