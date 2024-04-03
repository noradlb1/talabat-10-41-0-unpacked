package com.rd.animation.controller;

import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.Value;
import com.rd.animation.type.BaseAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.WormAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.utils.CoordinatesUtils;

public class AnimationController {
    private Indicator indicator;
    private boolean isInteractive;
    private ValueController.UpdateListener listener;
    private float progress;
    private BaseAnimation runningAnimation;
    private ValueController valueController;

    /* renamed from: com.rd.animation.controller.AnimationController$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52887a;

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
                f52887a = r0
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.COLOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SCALE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.WORM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.FILL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SLIDE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.THIN_WORM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.DROP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SWAP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f52887a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.rd.animation.type.AnimationType r1 = com.rd.animation.type.AnimationType.SCALE_DOWN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.animation.controller.AnimationController.AnonymousClass1.<clinit>():void");
        }
    }

    public AnimationController(@NonNull Indicator indicator2, @NonNull ValueController.UpdateListener updateListener) {
        this.valueController = new ValueController(updateListener);
        this.listener = updateListener;
        this.indicator = indicator2;
    }

    private void animate() {
        switch (AnonymousClass1.f52887a[this.indicator.getAnimationType().ordinal()]) {
            case 1:
                this.listener.onValueUpdated((Value) null);
                return;
            case 2:
                colorAnimation();
                return;
            case 3:
                scaleAnimation();
                return;
            case 4:
                wormAnimation();
                return;
            case 5:
                fillAnimation();
                return;
            case 6:
                slideAnimation();
                return;
            case 7:
                thinWormAnimation();
                return;
            case 8:
                dropAnimation();
                return;
            case 9:
                swapAnimation();
                return;
            case 10:
                scaleDownAnimation();
                return;
            default:
                return;
        }
    }

    private void colorAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        BaseAnimation duration = this.valueController.color().with(unselectedColor, selectedColor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void dropAnimation() {
        int i11;
        int i12;
        if (this.indicator.isInteractiveAnimation()) {
            i11 = this.indicator.getSelectedPosition();
        } else {
            i11 = this.indicator.getLastSelectedPosition();
        }
        if (this.indicator.isInteractiveAnimation()) {
            i12 = this.indicator.getSelectingPosition();
        } else {
            i12 = this.indicator.getSelectedPosition();
        }
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, i11);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, i12);
        int paddingTop = this.indicator.getPaddingTop();
        int paddingLeft = this.indicator.getPaddingLeft();
        if (this.indicator.getOrientation() != Orientation.HORIZONTAL) {
            paddingTop = paddingLeft;
        }
        int radius = this.indicator.getRadius();
        DropAnimation with = this.valueController.drop().duration(this.indicator.getAnimationDuration()).with(coordinate, coordinate2, (radius * 3) + paddingTop, radius + paddingTop, radius);
        if (this.isInteractive) {
            with.progress(this.progress);
        } else {
            with.start();
        }
        this.runningAnimation = with;
    }

    private void fillAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        int stroke = this.indicator.getStroke();
        BaseAnimation duration = this.valueController.fill().with(unselectedColor, selectedColor, radius, stroke).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void scaleAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        float scaleFactor = this.indicator.getScaleFactor();
        BaseAnimation duration = this.valueController.scale().with(unselectedColor, selectedColor, radius, scaleFactor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void scaleDownAnimation() {
        int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        int radius = this.indicator.getRadius();
        float scaleFactor = this.indicator.getScaleFactor();
        BaseAnimation duration = this.valueController.scaleDown().with(unselectedColor, selectedColor, radius, scaleFactor).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void slideAnimation() {
        int i11;
        int i12;
        if (this.indicator.isInteractiveAnimation()) {
            i11 = this.indicator.getSelectedPosition();
        } else {
            i11 = this.indicator.getLastSelectedPosition();
        }
        if (this.indicator.isInteractiveAnimation()) {
            i12 = this.indicator.getSelectingPosition();
        } else {
            i12 = this.indicator.getSelectedPosition();
        }
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, i11);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, i12);
        BaseAnimation duration = this.valueController.slide().with(coordinate, coordinate2).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void swapAnimation() {
        int i11;
        int i12;
        if (this.indicator.isInteractiveAnimation()) {
            i11 = this.indicator.getSelectedPosition();
        } else {
            i11 = this.indicator.getLastSelectedPosition();
        }
        if (this.indicator.isInteractiveAnimation()) {
            i12 = this.indicator.getSelectingPosition();
        } else {
            i12 = this.indicator.getSelectedPosition();
        }
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, i11);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, i12);
        BaseAnimation duration = this.valueController.swap().with(coordinate, coordinate2).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void thinWormAnimation() {
        int i11;
        int i12;
        boolean z11;
        if (this.indicator.isInteractiveAnimation()) {
            i11 = this.indicator.getSelectedPosition();
        } else {
            i11 = this.indicator.getLastSelectedPosition();
        }
        if (this.indicator.isInteractiveAnimation()) {
            i12 = this.indicator.getSelectingPosition();
        } else {
            i12 = this.indicator.getSelectedPosition();
        }
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, i11);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, i12);
        if (i12 > i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        int radius = this.indicator.getRadius();
        WormAnimation duration = this.valueController.thinWorm().with(coordinate, coordinate2, radius, z11).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    private void wormAnimation() {
        int i11;
        int i12;
        boolean z11;
        if (this.indicator.isInteractiveAnimation()) {
            i11 = this.indicator.getSelectedPosition();
        } else {
            i11 = this.indicator.getLastSelectedPosition();
        }
        if (this.indicator.isInteractiveAnimation()) {
            i12 = this.indicator.getSelectingPosition();
        } else {
            i12 = this.indicator.getSelectedPosition();
        }
        int coordinate = CoordinatesUtils.getCoordinate(this.indicator, i11);
        int coordinate2 = CoordinatesUtils.getCoordinate(this.indicator, i12);
        if (i12 > i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        int radius = this.indicator.getRadius();
        WormAnimation duration = this.valueController.worm().with(coordinate, coordinate2, radius, z11).duration(this.indicator.getAnimationDuration());
        if (this.isInteractive) {
            duration.progress(this.progress);
        } else {
            duration.start();
        }
        this.runningAnimation = duration;
    }

    public void basic() {
        this.isInteractive = false;
        this.progress = 0.0f;
        animate();
    }

    public void end() {
        BaseAnimation baseAnimation = this.runningAnimation;
        if (baseAnimation != null) {
            baseAnimation.end();
        }
    }

    public void interactive(float f11) {
        this.isInteractive = true;
        this.progress = f11;
        animate();
    }
}
