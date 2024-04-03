package com.instabug.library.ui.custom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 14)
public class MaterialMenuDrawable extends Drawable implements MaterialMenu, Animatable {
    private static final float ARROW_BOT_LINE_ANGLE = 225.0f;
    private static final float ARROW_MID_LINE_ANGLE = 180.0f;
    private static final float ARROW_TOP_LINE_ANGLE = 135.0f;
    private static final int BASE_CIRCLE_RADIUS = 18;
    private static final int BASE_DRAWABLE_HEIGHT = 40;
    private static final int BASE_DRAWABLE_WIDTH = 40;
    private static final int BASE_ICON_WIDTH = 20;
    private static final float CHECK_BOTTOM_ANGLE = -90.0f;
    private static final float CHECK_MIDDLE_ANGLE = 135.0f;
    private static final int DEFAULT_CIRCLE_ALPHA = 200;
    public static final int DEFAULT_COLOR = -1;
    public static final int DEFAULT_SCALE = 1;
    public static final int DEFAULT_TRANSFORM_DURATION = 800;
    public static final boolean DEFAULT_VISIBLE = true;
    private static final float TRANSFORMATION_END = 2.0f;
    private static final float TRANSFORMATION_MID = 1.0f;
    private static final float TRANSFORMATION_START = 0.0f;
    private static final float X_BOT_LINE_ANGLE = -44.0f;
    private static final float X_ROTATION_ANGLE = 90.0f;
    private static final float X_TOP_LINE_ANGLE = 44.0f;
    /* access modifiers changed from: private */
    @Nullable
    public IconState animatingIconState;
    private AnimationState animationState;
    @Nullable
    private Animator.AnimatorListener animatorListener;
    /* access modifiers changed from: private */
    public final Paint circlePaint;
    /* access modifiers changed from: private */
    public final float circleRadius;
    /* access modifiers changed from: private */
    public IconState currentIconState;
    /* access modifiers changed from: private */
    public final float dip1;
    private final float dip2;
    private final float dip3;
    private final float dip4;
    private final float dip8;
    private final float diph;
    /* access modifiers changed from: private */
    public final int height;
    private final Paint iconPaint;
    /* access modifiers changed from: private */
    public final float iconWidth;
    private final Object lock;
    private MaterialMenuState materialMenuState;
    /* access modifiers changed from: private */
    public boolean rtlEnabled;
    private final float sidePadding;
    /* access modifiers changed from: private */
    public final Stroke stroke;
    /* access modifiers changed from: private */
    public final float strokeWidth;
    private final float topPadding;
    /* access modifiers changed from: private */
    public ObjectAnimator transformation;
    private Property<MaterialMenuDrawable, Float> transformationProperty;
    /* access modifiers changed from: private */
    public boolean transformationRunning;
    private float transformationValue;
    /* access modifiers changed from: private */
    public boolean visible;
    /* access modifiers changed from: private */
    public final int width;

    /* renamed from: com.instabug.library.ui.custom.MaterialMenuDrawable$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51961a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f51962b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f51963c;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0092 */
        static {
            /*
                com.instabug.library.ui.custom.MaterialMenuDrawable$IconState[] r0 = com.instabug.library.ui.custom.MaterialMenuDrawable.IconState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51963c = r0
                r1 = 1
                com.instabug.library.ui.custom.MaterialMenuDrawable$IconState r2 = com.instabug.library.ui.custom.MaterialMenuDrawable.IconState.BURGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f51963c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.ui.custom.MaterialMenuDrawable$IconState r3 = com.instabug.library.ui.custom.MaterialMenuDrawable.IconState.ARROW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f51963c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$IconState r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.IconState.X     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f51963c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$IconState r5 = com.instabug.library.ui.custom.MaterialMenuDrawable.IconState.CHECK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.instabug.library.ui.custom.MaterialMenuDrawable$Stroke[] r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.Stroke.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f51962b = r4
                com.instabug.library.ui.custom.MaterialMenuDrawable$Stroke r5 = com.instabug.library.ui.custom.MaterialMenuDrawable.Stroke.REGULAR     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f51962b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.instabug.library.ui.custom.MaterialMenuDrawable$Stroke r5 = com.instabug.library.ui.custom.MaterialMenuDrawable.Stroke.THIN     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = f51962b     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$Stroke r5 = com.instabug.library.ui.custom.MaterialMenuDrawable.Stroke.EXTRA_THIN     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState[] r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f51961a = r4
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r5 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_ARROW     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r1 = f51961a     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_X     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = f51961a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.ARROW_X     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f51961a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.ARROW_CHECK     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f51961a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_CHECK     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f51961a     // Catch:{ NoSuchFieldError -> 0x009d }
                com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.X_CHECK     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.AnonymousClass3.<clinit>():void");
        }
    }

    public enum AnimationState {
        BURGER_ARROW,
        BURGER_X,
        ARROW_X,
        ARROW_CHECK,
        BURGER_CHECK,
        X_CHECK;

        @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
        public IconState getFirstState() {
            switch (AnonymousClass3.f51961a[ordinal()]) {
                case 1:
                    return IconState.BURGER;
                case 2:
                    return IconState.BURGER;
                case 3:
                    return IconState.ARROW;
                case 4:
                    return IconState.ARROW;
                case 5:
                    return IconState.BURGER;
                case 6:
                    return IconState.X;
                default:
                    return null;
            }
        }

        @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
        public IconState getSecondState() {
            switch (AnonymousClass3.f51961a[ordinal()]) {
                case 1:
                    return IconState.ARROW;
                case 2:
                    return IconState.X;
                case 3:
                    return IconState.X;
                case 4:
                    return IconState.CHECK;
                case 5:
                    return IconState.CHECK;
                case 6:
                    return IconState.CHECK;
                default:
                    return null;
            }
        }
    }

    public enum IconState {
        BURGER,
        ARROW,
        X,
        CHECK
    }

    public final class MaterialMenuState extends Drawable.ConstantState {
        /* access modifiers changed from: private */
        public int changingConfigurations;

        public int getChangingConfigurations() {
            return this.changingConfigurations;
        }

        public Drawable newDrawable() {
            IconState iconState;
            MaterialMenuDrawable materialMenuDrawable = new MaterialMenuDrawable(MaterialMenuDrawable.this.circlePaint.getColor(), MaterialMenuDrawable.this.stroke, MaterialMenuDrawable.this.transformation.getDuration(), MaterialMenuDrawable.this.width, MaterialMenuDrawable.this.height, MaterialMenuDrawable.this.iconWidth, MaterialMenuDrawable.this.circleRadius, MaterialMenuDrawable.this.strokeWidth, MaterialMenuDrawable.this.dip1);
            if (MaterialMenuDrawable.this.animatingIconState != null) {
                iconState = MaterialMenuDrawable.this.animatingIconState;
            } else {
                iconState = MaterialMenuDrawable.this.currentIconState;
            }
            materialMenuDrawable.setIconState(iconState);
            materialMenuDrawable.setVisible(MaterialMenuDrawable.this.visible);
            materialMenuDrawable.setRTLEnabled(MaterialMenuDrawable.this.rtlEnabled);
            return materialMenuDrawable;
        }

        private MaterialMenuState() {
        }
    }

    public enum Stroke {
        REGULAR(3),
        THIN(2),
        EXTRA_THIN(1);
        
        /* access modifiers changed from: private */
        public final int strokeWidth;

        private Stroke(int i11) {
            this.strokeWidth = i11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x013a, code lost:
        r1.rotate(r13, r9, r11);
        r1.rotate(r8, r5, r6);
        r19.drawLine(r2, r6, r4, r6, r0.iconPaint);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x014a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0091, code lost:
        r4 = r3;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x00b6, code lost:
        r17 = r13;
        r13 = r8;
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00e7, code lost:
        r4 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawBottomLine(android.graphics.Canvas r19, float r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r19.restore()
            r19.save()
            int r3 = r0.width
            float r3 = (float) r3
            r4 = 1073741824(0x40000000, float:2.0)
            float r5 = r3 / r4
            float r6 = r0.dip3
            float r6 = r6 / r4
            float r5 = r5 + r6
            int r6 = r0.height
            float r6 = (float) r6
            float r7 = r0.topPadding
            float r6 = r6 - r7
            float r7 = r0.dip2
            float r6 = r6 - r7
            float r7 = r0.sidePadding
            float r3 = r3 - r7
            int[] r8 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnonymousClass3.f51961a
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r9 = r0.animationState
            int r9 = r9.ordinal()
            r8 = r8[r9]
            r9 = -1037041664(0xffffffffc2300000, float:-44.0)
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r12 = 1124532224(0x43070000, float:135.0)
            r13 = 0
            switch(r8) {
                case 1: goto L_0x010e;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00bd;
                case 4: goto L_0x0094;
                case 5: goto L_0x0078;
                case 6: goto L_0x0040;
                default: goto L_0x0039;
            }
        L_0x0039:
            r4 = r3
            r2 = r7
            r8 = r13
            r9 = r8
            r11 = r9
            goto L_0x013a
        L_0x0040:
            float r10 = r10 - r2
            float r13 = r10 * r11
            r8 = 1118961664(0x42b20000, float:89.0)
            float r8 = r8 * r2
            float r8 = r8 + r9
            float r9 = r0.sidePadding
            float r11 = r0.dip4
            float r12 = r9 + r11
            int r14 = r0.width
            float r14 = (float) r14
            float r14 = r14 / r4
            float r15 = r0.dip3
            float r14 = r14 + r15
            float r14 = r14 - r9
            float r14 = r14 - r11
            float r14 = r14 * r2
            float r9 = r12 + r14
            int r12 = r0.height
            float r12 = (float) r12
            float r14 = r0.topPadding
            float r16 = r12 - r14
            float r16 = r16 - r15
            float r4 = r12 / r4
            float r14 = r14 + r4
            float r14 = r14 - r12
            float r14 = r14 * r2
            float r2 = r16 + r14
            float r4 = r0.dip8
            float r12 = r0.dip1
            float r11 = r11 + r12
            float r11 = r11 * r10
            float r4 = r4 - r11
            float r7 = r7 + r4
            float r4 = r0.resolveStrokeModifier(r10)
            float r3 = r3 - r4
            r11 = r2
            goto L_0x0091
        L_0x0078:
            r8 = 1110704128(0x42340000, float:45.0)
            float r8 = r8 * r2
            int r9 = r0.width
            float r9 = (float) r9
            float r9 = r9 / r4
            float r10 = r0.dip3
            float r10 = r10 * r2
            float r9 = r9 + r10
            int r11 = r0.height
            float r11 = (float) r11
            float r11 = r11 / r4
            float r11 = r11 - r10
            float r4 = r0.dip8
            float r4 = r4 * r2
            float r7 = r7 + r4
            float r2 = r0.resolveStrokeModifier(r2)
            float r3 = r3 - r2
        L_0x0091:
            r4 = r3
            r2 = r7
            goto L_0x00b6
        L_0x0094:
            float r8 = r2 * r11
            float r8 = r8 + r12
            int r9 = r0.width
            float r9 = (float) r9
            float r9 = r9 / r4
            float r11 = r0.dip3
            float r11 = r11 * r2
            float r9 = r9 + r11
            int r12 = r0.height
            float r12 = (float) r12
            float r12 = r12 / r4
            float r12 = r12 - r11
            float r4 = r0.resolveStrokeModifier(r10)
            float r3 = r3 - r4
            float r4 = r0.dip3
            float r10 = r0.dip4
            float r11 = r0.dip1
            float r10 = r10 + r11
            float r10 = r10 * r2
            float r4 = r4 + r10
            float r7 = r7 + r4
            r4 = r3
            r2 = r7
            r11 = r12
        L_0x00b6:
            r17 = r13
            r13 = r8
            r8 = r17
            goto L_0x013a
        L_0x00bd:
            r8 = 1127546880(0x43350000, float:181.0)
            float r8 = r8 * r2
            float r13 = r8 + r12
            float r8 = r2 * r11
            int r9 = r0.width
            float r9 = (float) r9
            float r9 = r9 / r4
            float r10 = r0.sidePadding
            float r11 = r0.dip4
            float r10 = r10 + r11
            float r10 = r10 - r9
            float r10 = r10 * r2
            float r9 = r9 + r10
            int r10 = r0.height
            float r10 = (float) r10
            float r10 = r10 / r4
            float r4 = r0.topPadding
            float r4 = r10 - r4
            float r11 = r0.dip3
            float r4 = r4 - r11
            float r4 = r4 * r2
            float r4 = r4 + r10
            float r2 = r0.resolveStrokeModifier(r2)
            float r3 = r3 - r2
            float r2 = r0.dip3
            float r7 = r7 + r2
            r11 = r4
            r2 = r7
        L_0x00e7:
            r4 = r3
            goto L_0x013a
        L_0x00e9:
            boolean r4 = r18.isMorphingForward()
            if (r4 == 0) goto L_0x00f2
            float r4 = r2 * r11
            goto L_0x00f5
        L_0x00f2:
            r4 = 1119092736(0x42b40000, float:90.0)
            float r4 = r4 * r2
        L_0x00f5:
            r13 = r4
            float r4 = r2 * r9
            float r8 = r0.sidePadding
            float r9 = r0.dip4
            float r8 = r8 + r9
            int r9 = r0.height
            float r9 = (float) r9
            float r10 = r0.topPadding
            float r9 = r9 - r10
            float r10 = r0.dip3
            float r9 = r9 - r10
            float r10 = r10 * r2
            float r7 = r7 + r10
            r2 = r7
            r11 = r9
            r9 = r8
            r8 = r13
            r13 = r4
            goto L_0x00e7
        L_0x010e:
            boolean r3 = r18.isMorphingForward()
            if (r3 == 0) goto L_0x0117
            float r3 = r2 * r12
            goto L_0x011d
        L_0x0117:
            float r10 = r10 - r2
            r3 = 1130430464(0x43610000, float:225.0)
            float r10 = r10 * r3
            float r3 = r10 + r12
        L_0x011d:
            int r7 = r0.width
            float r7 = (float) r7
            float r8 = r7 / r4
            int r9 = r0.height
            float r9 = (float) r9
            float r9 = r9 / r4
            float r4 = r0.sidePadding
            float r7 = r7 - r4
            float r4 = r0.resolveStrokeModifier(r2)
            float r7 = r7 - r4
            float r4 = r0.sidePadding
            float r10 = r0.dip3
            float r10 = r10 * r2
            float r4 = r4 + r10
            r2 = r4
            r4 = r7
            r11 = r9
            r9 = r8
            r8 = r13
            r13 = r3
        L_0x013a:
            r1.rotate(r13, r9, r11)
            r1.rotate(r8, r5, r6)
            android.graphics.Paint r7 = r0.iconPaint
            r1 = r19
            r3 = r6
            r5 = r6
            r6 = r7
            r1.drawLine(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.drawBottomLine(android.graphics.Canvas, float):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009a, code lost:
        r9 = r0;
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009c, code lost:
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b6, code lost:
        r13.iconPaint.setAlpha(r4);
        r14.rotate(r8, r15, r2);
        r14.drawLine(r7, r10, r9, r10, r13.iconPaint);
        r13.iconPaint.setAlpha(255);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ca, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0030, code lost:
        r9 = r0;
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0064, code lost:
        r15 = r15 + r1;
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0066, code lost:
        r7 = r3;
        r4 = 255;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawMiddleLine(android.graphics.Canvas r14, float r15) {
        /*
            r13 = this;
            r14.restore()
            r14.save()
            int r0 = r13.width
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r2 = r0 / r1
            float r3 = r13.sidePadding
            float r4 = r13.topPadding
            float r5 = r13.dip3
            float r5 = r5 / r1
            r6 = 1084227584(0x40a00000, float:5.0)
            float r5 = r5 * r6
            float r10 = r4 + r5
            float r0 = r0 - r3
            int[] r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnonymousClass3.f51961a
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r5 = r13.animationState
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 1132396544(0x437f0000, float:255.0)
            r6 = 1124532224(0x43070000, float:135.0)
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r12 = 255(0xff, float:3.57E-43)
            switch(r4) {
                case 1: goto L_0x009e;
                case 2: goto L_0x0097;
                case 3: goto L_0x008f;
                case 4: goto L_0x0069;
                case 5: goto L_0x004e;
                case 6: goto L_0x0033;
                default: goto L_0x0030;
            }
        L_0x0030:
            r9 = r0
            r15 = r2
            goto L_0x0066
        L_0x0033:
            float r5 = r5 * r15
            int r4 = (int) r5
            float r8 = r15 * r6
            float r5 = r13.dip4
            float r6 = r13.dip3
            float r7 = r6 / r1
            float r5 = r5 + r7
            float r5 = r5 * r15
            float r3 = r3 + r5
            float r5 = r13.dip1
            float r15 = r15 * r5
            float r0 = r0 + r15
            int r15 = r13.width
            float r15 = (float) r15
            float r15 = r15 / r1
            float r15 = r15 + r6
            float r1 = r13.diph
            float r15 = r15 + r1
            r9 = r0
            goto L_0x009c
        L_0x004e:
            float r8 = r15 * r6
            float r4 = r13.dip4
            float r5 = r13.dip3
            float r6 = r5 / r1
            float r4 = r4 + r6
            float r4 = r4 * r15
            float r3 = r3 + r4
            float r4 = r13.dip1
            float r15 = r15 * r4
            float r0 = r0 + r15
            int r15 = r13.width
            float r15 = (float) r15
            float r15 = r15 / r1
            float r15 = r15 + r5
            float r1 = r13.diph
        L_0x0064:
            float r15 = r15 + r1
            r9 = r0
        L_0x0066:
            r7 = r3
            r4 = r12
            goto L_0x00b6
        L_0x0069:
            boolean r4 = r13.isMorphingForward()
            if (r4 == 0) goto L_0x0071
            float r6 = r6 * r15
            goto L_0x0075
        L_0x0071:
            float r4 = r7 - r15
            float r4 = r4 * r6
            float r6 = r6 - r4
        L_0x0075:
            r8 = r6
            float r4 = r13.dip3
            float r5 = r4 / r1
            float r6 = r13.dip4
            float r5 = r5 + r6
            float r7 = r7 - r15
            float r6 = r13.dip2
            float r7 = r7 * r6
            float r5 = r5 - r7
            float r3 = r3 + r5
            float r5 = r13.dip1
            float r15 = r15 * r5
            float r0 = r0 + r15
            int r15 = r13.width
            float r15 = (float) r15
            float r15 = r15 / r1
            float r15 = r15 + r4
            float r1 = r13.diph
            goto L_0x0064
        L_0x008f:
            float r7 = r7 - r15
            float r5 = r5 * r7
            int r4 = (int) r5
            float r15 = r13.dip2
            float r7 = r7 * r15
            float r3 = r3 + r7
            goto L_0x009a
        L_0x0097:
            float r7 = r7 - r15
            float r7 = r7 * r5
            int r4 = (int) r7
        L_0x009a:
            r9 = r0
            r15 = r2
        L_0x009c:
            r7 = r3
            goto L_0x00b6
        L_0x009e:
            boolean r4 = r13.isMorphingForward()
            r5 = 1127481344(0x43340000, float:180.0)
            if (r4 == 0) goto L_0x00a9
            float r5 = r5 * r15
            r8 = r5
            goto L_0x00ad
        L_0x00a9:
            float r7 = r7 - r15
            float r7 = r7 * r5
            float r7 = r7 + r5
            r8 = r7
        L_0x00ad:
            float r4 = r13.resolveStrokeModifier(r15)
            float r15 = r15 * r4
            float r15 = r15 / r1
            float r0 = r0 - r15
            goto L_0x0030
        L_0x00b6:
            android.graphics.Paint r0 = r13.iconPaint
            r0.setAlpha(r4)
            r14.rotate(r8, r15, r2)
            android.graphics.Paint r11 = r13.iconPaint
            r6 = r14
            r8 = r10
            r6.drawLine(r7, r8, r9, r10, r11)
            android.graphics.Paint r14 = r13.iconPaint
            r14.setAlpha(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.drawMiddleLine(android.graphics.Canvas, float):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00af, code lost:
        r15 = 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00d7, code lost:
        r13.iconPaint.setAlpha(r15);
        r14.rotate(r5, r11, r1);
        r14.rotate(r7, r2, r9);
        r14.drawLine(r6, r9, r8, r9, r13.iconPaint);
        r13.iconPaint.setAlpha(255);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ee, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0073, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00ad, code lost:
        r8 = r0;
        r6 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawTopLine(android.graphics.Canvas r14, float r15) {
        /*
            r13 = this;
            r14.save()
            int r0 = r13.width
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r2 = r0 / r1
            float r3 = r13.dip3
            float r3 = r3 / r1
            float r2 = r2 + r3
            float r3 = r13.topPadding
            float r4 = r13.dip2
            float r9 = r3 + r4
            float r3 = r13.sidePadding
            float r0 = r0 - r3
            int[] r4 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnonymousClass3.f51961a
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r5 = r13.animationState
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 1110441984(0x42300000, float:44.0)
            r6 = 1132396544(0x437f0000, float:255.0)
            r7 = 1119092736(0x42b40000, float:90.0)
            r8 = 1130430464(0x43610000, float:225.0)
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r12 = 255(0xff, float:3.57E-43)
            switch(r4) {
                case 1: goto L_0x00b1;
                case 2: goto L_0x009e;
                case 3: goto L_0x0076;
                case 4: goto L_0x005a;
                case 5: goto L_0x0050;
                case 6: goto L_0x0038;
                default: goto L_0x0031;
            }
        L_0x0031:
            r8 = r0
            r6 = r3
            r1 = r11
            r5 = r1
            r7 = r5
            goto L_0x00af
        L_0x0038:
            float r1 = r13.sidePadding
            float r4 = r13.dip4
            float r11 = r1 + r4
            float r1 = r13.topPadding
            float r4 = r13.dip3
            float r1 = r1 + r4
            float r10 = r10 - r15
            float r15 = r4 * r10
            float r15 = r4 - r15
            float r0 = r0 + r15
            float r3 = r3 + r4
            float r10 = r10 * r6
            int r15 = (int) r10
            r8 = r0
            r6 = r3
            goto L_0x00d7
        L_0x0050:
            float r10 = r10 - r15
            float r10 = r10 * r6
            int r15 = (int) r10
            r8 = r0
            r6 = r3
            r1 = r11
            r5 = r1
            r7 = r5
            goto L_0x00d7
        L_0x005a:
            float r15 = r10 - r15
            float r15 = r15 * r6
            int r15 = (int) r15
            int r4 = r13.width
            float r4 = (float) r4
            float r4 = r4 / r1
            int r5 = r13.height
            float r5 = (float) r5
            float r5 = r5 / r1
            float r1 = r13.resolveStrokeModifier(r10)
            float r0 = r0 - r1
            float r1 = r13.dip3
            float r3 = r3 + r1
            r6 = r3
            r1 = r5
            r5 = r8
            r7 = r11
            r8 = r0
        L_0x0073:
            r11 = r4
            goto L_0x00d7
        L_0x0076:
            r4 = -1019936768(0xffffffffc3350000, float:-181.0)
            float r4 = r4 * r15
            float r5 = r4 + r8
            float r7 = r7 * r15
            int r4 = r13.width
            float r4 = (float) r4
            float r4 = r4 / r1
            float r6 = r13.sidePadding
            float r8 = r13.dip4
            float r6 = r6 + r8
            float r6 = r6 - r4
            float r6 = r6 * r15
            float r11 = r4 + r6
            int r4 = r13.height
            float r4 = (float) r4
            float r4 = r4 / r1
            float r1 = r13.topPadding
            float r6 = r13.dip3
            float r1 = r1 + r6
            float r1 = r1 - r4
            float r1 = r1 * r15
            float r1 = r1 + r4
            float r15 = r13.resolveStrokeModifier(r15)
            float r0 = r0 - r15
            float r15 = r13.dip3
            float r3 = r3 + r15
            goto L_0x00ad
        L_0x009e:
            float r5 = r5 * r15
            float r7 = r7 * r15
            float r1 = r13.sidePadding
            float r4 = r13.dip4
            float r11 = r1 + r4
            float r1 = r13.topPadding
            float r4 = r13.dip3
            float r1 = r1 + r4
            float r4 = r4 * r15
            float r3 = r3 + r4
        L_0x00ad:
            r8 = r0
            r6 = r3
        L_0x00af:
            r15 = r12
            goto L_0x00d7
        L_0x00b1:
            boolean r4 = r13.isMorphingForward()
            if (r4 == 0) goto L_0x00ba
            float r8 = r8 * r15
            r5 = r8
            goto L_0x00c0
        L_0x00ba:
            float r10 = r10 - r15
            r4 = 1124532224(0x43070000, float:135.0)
            float r10 = r10 * r4
            float r10 = r10 + r8
            r5 = r10
        L_0x00c0:
            int r4 = r13.width
            float r4 = (float) r4
            float r4 = r4 / r1
            int r6 = r13.height
            float r6 = (float) r6
            float r6 = r6 / r1
            float r1 = r13.resolveStrokeModifier(r15)
            float r0 = r0 - r1
            float r1 = r13.dip3
            float r1 = r1 * r15
            float r3 = r3 + r1
            r8 = r0
            r1 = r6
            r7 = r11
            r15 = r12
            r6 = r3
            goto L_0x0073
        L_0x00d7:
            android.graphics.Paint r0 = r13.iconPaint
            r0.setAlpha(r15)
            r14.rotate(r5, r11, r1)
            r14.rotate(r7, r2, r9)
            android.graphics.Paint r10 = r13.iconPaint
            r5 = r14
            r7 = r9
            r5.drawLine(r6, r7, r8, r9, r10)
            android.graphics.Paint r14 = r13.iconPaint
            r14.setAlpha(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.drawTopLine(android.graphics.Canvas, float):void");
    }

    private void initAnimations(int i11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.transformationProperty, new float[]{0.0f});
        this.transformation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator(3.0f));
        this.transformation.setDuration((long) i11);
        this.transformation.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = MaterialMenuDrawable.this.transformationRunning = false;
                MaterialMenuDrawable materialMenuDrawable = MaterialMenuDrawable.this;
                materialMenuDrawable.setIconState(materialMenuDrawable.animatingIconState);
            }
        });
    }

    private void initPaint(int i11) {
        this.iconPaint.setAntiAlias(true);
        this.iconPaint.setStyle(Paint.Style.STROKE);
        this.iconPaint.setStrokeWidth(this.strokeWidth);
        this.iconPaint.setColor(i11);
        this.circlePaint.setAntiAlias(true);
        this.circlePaint.setStyle(Paint.Style.FILL);
        this.circlePaint.setColor(i11);
        this.circlePaint.setAlpha(200);
        setBounds(0, 0, this.width, this.height);
    }

    private boolean isMorphingForward() {
        return this.transformationValue <= 1.0f;
    }

    public static float o(Resources resources, float f11) {
        return TypedValue.applyDimension(1, f11, resources.getDisplayMetrics());
    }

    private float resolveStrokeModifier(float f11) {
        float f12;
        int i11 = AnonymousClass3.f51962b[this.stroke.ordinal()];
        if (i11 == 1) {
            AnimationState animationState2 = this.animationState;
            if (animationState2 == AnimationState.ARROW_X || animationState2 == AnimationState.X_CHECK) {
                float f13 = this.dip3;
                return f13 - (f11 * f13);
            }
            f12 = this.dip3;
        } else if (i11 == 2) {
            AnimationState animationState3 = this.animationState;
            if (animationState3 == AnimationState.ARROW_X || animationState3 == AnimationState.X_CHECK) {
                float f14 = this.dip3 + this.diph;
                return f14 - (f11 * f14);
            }
            f12 = this.dip3 + this.diph;
        } else if (i11 != 3) {
            return 0.0f;
        } else {
            AnimationState animationState4 = this.animationState;
            if (animationState4 == AnimationState.ARROW_X || animationState4 == AnimationState.X_CHECK) {
                return this.dip4 - ((this.dip3 + this.dip1) * f11);
            }
            f12 = this.dip4;
        }
        return f11 * f12;
    }

    private boolean resolveTransformation() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        IconState iconState = this.currentIconState;
        IconState iconState2 = IconState.BURGER;
        if (iconState == iconState2) {
            z11 = true;
        } else {
            z11 = false;
        }
        IconState iconState3 = IconState.ARROW;
        if (iconState == iconState3) {
            z12 = true;
        } else {
            z12 = false;
        }
        IconState iconState4 = IconState.X;
        if (iconState == iconState4) {
            z13 = true;
        } else {
            z13 = false;
        }
        IconState iconState5 = IconState.CHECK;
        if (iconState == iconState5) {
            z14 = true;
        } else {
            z14 = false;
        }
        IconState iconState6 = this.animatingIconState;
        if (iconState6 == iconState2) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (iconState6 == iconState3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (iconState6 == iconState4) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (iconState6 == iconState5) {
            z18 = true;
        } else {
            z18 = false;
        }
        if ((z11 && z16) || (z12 && z15)) {
            this.animationState = AnimationState.BURGER_ARROW;
            return z11;
        } else if ((z12 && z17) || (z13 && z16)) {
            this.animationState = AnimationState.ARROW_X;
            return z12;
        } else if ((z11 && z17) || (z13 && z15)) {
            this.animationState = AnimationState.BURGER_X;
            return z11;
        } else if ((z12 && z18) || (z14 && z16)) {
            this.animationState = AnimationState.ARROW_CHECK;
            return z12;
        } else if ((z11 && z18) || (z14 && z15)) {
            this.animationState = AnimationState.BURGER_CHECK;
            return z11;
        } else if ((!z13 || !z18) && (!z14 || !z17)) {
            throw new IllegalStateException(String.format("Animating from %s to %s is not supported", new Object[]{this.currentIconState, this.animatingIconState}));
        } else {
            this.animationState = AnimationState.X_CHECK;
            return z13;
        }
    }

    public void animateIconState(IconState iconState) {
        synchronized (this.lock) {
            if (this.transformationRunning) {
                this.transformation.end();
            }
            this.animatingIconState = iconState;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            boolean r1 = r5.visible     // Catch:{ all -> 0x003e }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x0009:
            float r1 = r5.transformationValue     // Catch:{ all -> 0x003e }
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            r3 = 1073741824(0x40000000, float:2.0)
            float r1 = r3 - r1
        L_0x0016:
            boolean r3 = r5.rtlEnabled     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x002c
            r6.save()     // Catch:{ all -> 0x003e }
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r6.scale(r3, r2, r4, r4)     // Catch:{ all -> 0x003e }
            int r2 = r5.getIntrinsicWidth()     // Catch:{ all -> 0x003e }
            int r2 = -r2
            float r2 = (float) r2     // Catch:{ all -> 0x003e }
            r6.translate(r2, r4)     // Catch:{ all -> 0x003e }
        L_0x002c:
            r5.drawTopLine(r6, r1)     // Catch:{ all -> 0x003e }
            r5.drawMiddleLine(r6, r1)     // Catch:{ all -> 0x003e }
            r5.drawBottomLine(r6, r1)     // Catch:{ all -> 0x003e }
            boolean r1 = r5.rtlEnabled     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x003c
            r6.restore()     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x003e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.draw(android.graphics.Canvas):void");
    }

    public Drawable.ConstantState getConstantState() {
        int unused = this.materialMenuState.changingConfigurations = getChangingConfigurations();
        return this.materialMenuState;
    }

    public IconState getIconState() {
        IconState iconState;
        synchronized (this.lock) {
            iconState = this.currentIconState;
        }
        return iconState;
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getOpacity() {
        return -2;
    }

    public Float getTransformationValue() {
        Float valueOf;
        synchronized (this.lock) {
            valueOf = Float.valueOf(this.transformationValue);
        }
        return valueOf;
    }

    public boolean isDrawableVisible() {
        return this.visible;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.lock) {
            z11 = this.transformationRunning;
        }
        return z11;
    }

    public Drawable mutate() {
        this.materialMenuState = new MaterialMenuState();
        return this;
    }

    public void setAlpha(int i11) {
        this.iconPaint.setAlpha(i11);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener2) {
        Animator.AnimatorListener animatorListener3 = this.animatorListener;
        if (animatorListener3 != null) {
            this.transformation.removeListener(animatorListener3);
        }
        if (animatorListener2 != null) {
            this.transformation.addListener(animatorListener2);
        }
        this.animatorListener = animatorListener2;
    }

    public void setColor(int i11) {
        this.iconPaint.setColor(i11);
        this.circlePaint.setColor(i11);
        invalidateSelf();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.iconPaint.setColorFilter(colorFilter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setIconState(@androidx.annotation.Nullable com.instabug.library.ui.custom.MaterialMenuDrawable.IconState r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.transformationRunning     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x000f
            android.animation.ObjectAnimator r1 = r4.transformation     // Catch:{ all -> 0x0052 }
            r1.cancel()     // Catch:{ all -> 0x0052 }
            r1 = 0
            r4.transformationRunning = r1     // Catch:{ all -> 0x0052 }
        L_0x000f:
            if (r5 == 0) goto L_0x0050
            com.instabug.library.ui.custom.MaterialMenuDrawable$IconState r1 = r4.currentIconState     // Catch:{ all -> 0x0052 }
            if (r1 != r5) goto L_0x0016
            goto L_0x0050
        L_0x0016:
            int[] r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnonymousClass3.f51963c     // Catch:{ all -> 0x0052 }
            int r2 = r5.ordinal()     // Catch:{ all -> 0x0052 }
            r1 = r1[r2]     // Catch:{ all -> 0x0052 }
            r2 = 1
            if (r1 == r2) goto L_0x0042
            r2 = 2
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r1 == r2) goto L_0x003b
            r2 = 3
            if (r1 == r2) goto L_0x0034
            r2 = 4
            if (r1 == r2) goto L_0x002d
            goto L_0x0049
        L_0x002d:
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_CHECK     // Catch:{ all -> 0x0052 }
            r4.animationState = r1     // Catch:{ all -> 0x0052 }
            r4.transformationValue = r3     // Catch:{ all -> 0x0052 }
            goto L_0x0049
        L_0x0034:
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_X     // Catch:{ all -> 0x0052 }
            r4.animationState = r1     // Catch:{ all -> 0x0052 }
            r4.transformationValue = r3     // Catch:{ all -> 0x0052 }
            goto L_0x0049
        L_0x003b:
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_ARROW     // Catch:{ all -> 0x0052 }
            r4.animationState = r1     // Catch:{ all -> 0x0052 }
            r4.transformationValue = r3     // Catch:{ all -> 0x0052 }
            goto L_0x0049
        L_0x0042:
            com.instabug.library.ui.custom.MaterialMenuDrawable$AnimationState r1 = com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState.BURGER_ARROW     // Catch:{ all -> 0x0052 }
            r4.animationState = r1     // Catch:{ all -> 0x0052 }
            r1 = 0
            r4.transformationValue = r1     // Catch:{ all -> 0x0052 }
        L_0x0049:
            r4.currentIconState = r5     // Catch:{ all -> 0x0052 }
            r4.invalidateSelf()     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return
        L_0x0052:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.MaterialMenuDrawable.setIconState(com.instabug.library.ui.custom.MaterialMenuDrawable$IconState):void");
    }

    public void setInterpolator(Interpolator interpolator) {
        this.transformation.setInterpolator(interpolator);
    }

    public void setRTLEnabled(boolean z11) {
        this.rtlEnabled = z11;
        invalidateSelf();
    }

    @RequiresApi(api = 11)
    public void setTransformationDuration(int i11) {
        this.transformation.setDuration((long) i11);
    }

    public IconState setTransformationOffset(AnimationState animationState2, float f11) {
        int i11;
        IconState iconState;
        IconState iconState2;
        IconState iconState3;
        boolean z11 = true;
        if (f11 < 0.0f || f11 > 2.0f) {
            throw new IllegalArgumentException(String.format("Value must be between %s and %s", new Object[]{Float.valueOf(0.0f), Float.valueOf(2.0f)}));
        }
        synchronized (this.lock) {
            this.animationState = animationState2;
            if (f11 >= 1.0f) {
                if (i11 != 0) {
                    z11 = false;
                }
            }
            if (z11) {
                iconState = animationState2.getFirstState();
            } else {
                iconState = animationState2.getSecondState();
            }
            this.currentIconState = iconState;
            if (z11) {
                iconState2 = animationState2.getSecondState();
            } else {
                iconState2 = animationState2.getFirstState();
            }
            this.animatingIconState = iconState2;
            setTransformationValue(Float.valueOf(f11));
            iconState3 = this.currentIconState;
        }
        return iconState3;
    }

    public void setTransformationValue(Float f11) {
        synchronized (this.lock) {
            this.transformationValue = f11.floatValue();
            invalidateSelf();
        }
    }

    public void setVisible(boolean z11) {
        this.visible = z11;
        invalidateSelf();
    }

    public void start() {
        float f11;
        synchronized (this.lock) {
            if (!this.transformationRunning) {
                IconState iconState = this.animatingIconState;
                if (!(iconState == null || iconState == this.currentIconState)) {
                    this.transformationRunning = true;
                    boolean resolveTransformation = resolveTransformation();
                    ObjectAnimator objectAnimator = this.transformation;
                    float[] fArr = new float[2];
                    float f12 = 1.0f;
                    if (resolveTransformation) {
                        f11 = 0.0f;
                    } else {
                        f11 = 1.0f;
                    }
                    fArr[0] = f11;
                    if (!resolveTransformation) {
                        f12 = 2.0f;
                    }
                    fArr[1] = f12;
                    objectAnimator.setFloatValues(fArr);
                    this.transformation.start();
                }
                invalidateSelf();
            }
        }
    }

    public void stop() {
        synchronized (this.lock) {
            if (!isRunning() || !this.transformation.isRunning()) {
                this.transformationRunning = false;
                invalidateSelf();
            } else {
                this.transformation.end();
            }
        }
    }

    public MaterialMenuDrawable(Context context, int i11, Stroke stroke2) {
        this(context, i11, stroke2, 1, 800);
    }

    public MaterialMenuDrawable(Context context, int i11, Stroke stroke2, int i12) {
        this(context, i11, stroke2, 1, i12);
    }

    public MaterialMenuDrawable(Context context, int i11, Stroke stroke2, int i12, int i13) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = 0.0f;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = new Property<MaterialMenuDrawable, Float>(Float.class, "transformation") {
            public Float get(MaterialMenuDrawable materialMenuDrawable) {
                return materialMenuDrawable.getTransformationValue();
            }

            public void set(MaterialMenuDrawable materialMenuDrawable, Float f11) {
                materialMenuDrawable.setTransformationValue(f11);
            }
        };
        Resources resources = context.getResources();
        float f11 = (float) i12;
        float o11 = o(resources, 1.0f) * f11;
        this.dip1 = o11;
        this.dip2 = o(resources, 2.0f) * f11;
        float o12 = o(resources, 3.0f) * f11;
        this.dip3 = o12;
        this.dip4 = o(resources, 4.0f) * f11;
        this.dip8 = o(resources, 8.0f) * f11;
        this.diph = o11 / 2.0f;
        this.stroke = stroke2;
        this.visible = true;
        int o13 = (int) (o(resources, 40.0f) * f11);
        this.width = o13;
        int o14 = (int) (o(resources, 40.0f) * f11);
        this.height = o14;
        float o15 = o(resources, 20.0f) * f11;
        this.iconWidth = o15;
        this.circleRadius = o(resources, 18.0f) * f11;
        this.strokeWidth = o(resources, (float) stroke2.strokeWidth) * f11;
        this.sidePadding = (((float) o13) - o15) / 2.0f;
        this.topPadding = (((float) o14) - (o12 * 5.0f)) / 2.0f;
        initPaint(i11);
        initAnimations(i13);
        this.materialMenuState = new MaterialMenuState();
    }

    private MaterialMenuDrawable(int i11, Stroke stroke2, long j11, int i12, int i13, float f11, float f12, float f13, float f14) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = 0.0f;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = new Property<MaterialMenuDrawable, Float>(Float.class, "transformation") {
            public Float get(MaterialMenuDrawable materialMenuDrawable) {
                return materialMenuDrawable.getTransformationValue();
            }

            public void set(MaterialMenuDrawable materialMenuDrawable, Float f11) {
                materialMenuDrawable.setTransformationValue(f11);
            }
        };
        this.dip1 = f14;
        this.dip2 = f14 * 2.0f;
        float f15 = 3.0f * f14;
        this.dip3 = f15;
        this.dip4 = 4.0f * f14;
        this.dip8 = 8.0f * f14;
        this.diph = f14 / 2.0f;
        this.stroke = stroke2;
        this.width = i12;
        this.height = i13;
        this.iconWidth = f11;
        this.circleRadius = f12;
        this.strokeWidth = f13;
        this.sidePadding = (((float) i12) - f11) / 2.0f;
        this.topPadding = (((float) i13) - (f15 * 5.0f)) / 2.0f;
        initPaint(i11);
        initAnimations((int) j11);
        this.materialMenuState = new MaterialMenuState();
    }
}
