package com.rd.draw.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.Drawer;
import com.rd.utils.CoordinatesUtils;

public class DrawController {
    private Drawer drawer;
    private Indicator indicator;
    private ClickListener listener;
    private Value value;

    /* renamed from: com.rd.draw.controller.DrawController$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52918a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.rd.animation.type.AnimationType[] r0 = com.rd.animation.type.AnimationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52918a = r0
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.COLOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SCALE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.WORM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SLIDE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.FILL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.THIN_WORM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.DROP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SWAP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f52918a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SCALE_DOWN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.draw.controller.DrawController.AnonymousClass1.<clinit>():void");
        }
    }

    public interface ClickListener {
        void onIndicatorClicked(int i11);
    }

    public DrawController(@NonNull Indicator indicator2) {
        this.indicator = indicator2;
        this.drawer = new Drawer(indicator2);
    }

    private void drawIndicator(@NonNull Canvas canvas, int i11, int i12, int i13) {
        boolean z11;
        boolean isInteractiveAnimation = this.indicator.isInteractiveAnimation();
        int selectedPosition = this.indicator.getSelectedPosition();
        int selectingPosition = this.indicator.getSelectingPosition();
        int lastSelectedPosition = this.indicator.getLastSelectedPosition();
        boolean z12 = true;
        if (isInteractiveAnimation || !(i11 == selectedPosition || i11 == lastSelectedPosition)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!isInteractiveAnimation || !(i11 == selectedPosition || i11 == selectingPosition)) {
            z12 = false;
        }
        boolean z13 = z11 | z12;
        this.drawer.setup(i11, i12, i13);
        if (this.value == null || !z13) {
            this.drawer.drawBasic(canvas, z13);
        } else {
            drawWithAnimation(canvas);
        }
    }

    private void drawWithAnimation(@NonNull Canvas canvas) {
        switch (AnonymousClass1.f52918a[this.indicator.getAnimationType().ordinal()]) {
            case 1:
                this.drawer.drawBasic(canvas, true);
                return;
            case 2:
                this.drawer.drawColor(canvas, this.value);
                return;
            case 3:
                this.drawer.drawScale(canvas, this.value);
                return;
            case 4:
                this.drawer.drawWorm(canvas, this.value);
                return;
            case 5:
                this.drawer.drawSlide(canvas, this.value);
                return;
            case 6:
                this.drawer.drawFill(canvas, this.value);
                return;
            case 7:
                this.drawer.drawThinWorm(canvas, this.value);
                return;
            case 8:
                this.drawer.drawDrop(canvas, this.value);
                return;
            case 9:
                this.drawer.drawSwap(canvas, this.value);
                return;
            case 10:
                this.drawer.drawScaleDown(canvas, this.value);
                return;
            default:
                return;
        }
    }

    private void onIndicatorTouched(float f11, float f12) {
        int position;
        if (this.listener != null && (position = CoordinatesUtils.getPosition(this.indicator, f11, f12)) >= 0) {
            this.listener.onIndicatorClicked(position);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        int count = this.indicator.getCount();
        for (int i11 = 0; i11 < count; i11++) {
            drawIndicator(canvas, i11, CoordinatesUtils.getXCoordinate(this.indicator, i11), CoordinatesUtils.getYCoordinate(this.indicator, i11));
        }
    }

    public void setClickListener(@Nullable ClickListener clickListener) {
        this.listener = clickListener;
    }

    public void touch(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            onIndicatorTouched(motionEvent.getX(), motionEvent.getY());
        }
    }

    public void updateValue(@Nullable Value value2) {
        this.value = value2;
    }
}
