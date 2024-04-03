package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove = -1;
    private float motionEffectAlpha = 0.1f;
    private int motionEffectEnd = 50;
    private int motionEffectStart = 49;
    private boolean motionEffectStrictMove = true;
    private int motionEffectTranslationX = 0;
    private int motionEffectTranslationY = 0;
    private int viewTransitionId = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i12 = obtainStyledAttributes.getInt(index, this.motionEffectStart);
                    this.motionEffectStart = i12;
                    this.motionEffectStart = Math.max(Math.min(i12, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i13 = obtainStyledAttributes.getInt(index, this.motionEffectEnd);
                    this.motionEffectEnd = i13;
                    this.motionEffectEnd = Math.max(Math.min(i13, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.motionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.motionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.motionEffectAlpha = obtainStyledAttributes.getFloat(index, this.motionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.motionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.motionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i14 = this.motionEffectStart;
            int i15 = this.motionEffectEnd;
            if (i14 == i15) {
                if (i14 > 0) {
                    this.motionEffectStart = i14 - 1;
                } else {
                    this.motionEffectEnd = i15 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017d, code lost:
        if (r14 == 0.0f) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0191, code lost:
        if (r14 == 0.0f) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a1, code lost:
        if (r15 == 0.0f) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b1, code lost:
        if (r15 == 0.0f) goto L_0x0180;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r22, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            android.view.ViewParent r2 = r21.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.d(r2)
            if (r2 != 0) goto L_0x0022
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getLoc()
            r1.append(r2)
            java.lang.String r2 = " views = null"
            r1.append(r2)
            return
        L_0x0022:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.setValue(r6, r5)
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setValue(r6, r5)
            int r5 = r0.motionEffectStart
            r3.setFramePosition(r5)
            int r5 = r0.motionEffectEnd
            r4.setFramePosition(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.motionEffectStart
            r5.setFramePosition(r6)
            r6 = 0
            r5.setType(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.setValue(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.setValue(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.motionEffectEnd
            r7.setFramePosition(r10)
            r7.setType(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.setValue(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.setValue(r9, r8)
            int r8 = r0.motionEffectTranslationX
            r9 = 0
            if (r8 <= 0) goto L_0x00b3
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.motionEffectTranslationX
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            r8.setFramePosition(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            int r12 = r12 - r10
            r11.setFramePosition(r12)
            goto L_0x00b5
        L_0x00b3:
            r8 = r9
            r11 = r8
        L_0x00b5:
            int r12 = r0.motionEffectTranslationY
            if (r12 <= 0) goto L_0x00e1
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.motionEffectTranslationY
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            r9.setFramePosition(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            int r13 = r13 - r10
            r12.setFramePosition(r13)
            goto L_0x00e2
        L_0x00e1:
            r12 = r9
        L_0x00e2:
            int r13 = r0.fadeMove
            r15 = -1
            r17 = 0
            if (r13 != r15) goto L_0x014b
            r13 = 4
            int[] r15 = new int[r13]
            r13 = r6
        L_0x00ed:
            int r14 = r2.length
            if (r13 >= r14) goto L_0x013a
            r14 = r2[r13]
            java.lang.Object r14 = r1.get(r14)
            androidx.constraintlayout.motion.widget.MotionController r14 = (androidx.constraintlayout.motion.widget.MotionController) r14
            if (r14 != 0) goto L_0x00fb
            goto L_0x0137
        L_0x00fb:
            float r19 = r14.getFinalX()
            float r20 = r14.getStartX()
            float r19 = r19 - r20
            float r20 = r14.getFinalY()
            float r14 = r14.getStartY()
            float r20 = r20 - r14
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0118
            r14 = r15[r10]
            int r14 = r14 + r10
            r15[r10] = r14
        L_0x0118:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x0121
            r14 = r15[r6]
            int r14 = r14 + r10
            r15[r6] = r14
        L_0x0121:
            int r14 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x012c
            r14 = 3
            r18 = r15[r14]
            int r18 = r18 + 1
            r15[r14] = r18
        L_0x012c:
            int r14 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0137
            r14 = 2
            r16 = r15[r14]
            int r16 = r16 + 1
            r15[r14] = r16
        L_0x0137:
            int r13 = r13 + 1
            goto L_0x00ed
        L_0x013a:
            r13 = r15[r6]
            r14 = r13
            r13 = r6
            r6 = r10
        L_0x013f:
            r10 = 4
            if (r6 >= r10) goto L_0x014b
            r10 = r15[r6]
            if (r14 >= r10) goto L_0x0148
            r13 = r6
            r14 = r10
        L_0x0148:
            int r6 = r6 + 1
            goto L_0x013f
        L_0x014b:
            r6 = 0
        L_0x014c:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01ea
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x015e
        L_0x0159:
            r1 = r22
            r15 = -1
            goto L_0x01e4
        L_0x015e:
            float r14 = r10.getFinalX()
            float r15 = r10.getStartX()
            float r14 = r14 - r15
            float r15 = r10.getFinalY()
            float r20 = r10.getStartY()
            float r15 = r15 - r20
            if (r13 != 0) goto L_0x0184
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0182
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x017f
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0182
        L_0x017f:
            r1 = 3
        L_0x0180:
            r14 = 0
            goto L_0x01b5
        L_0x0182:
            r1 = 3
            goto L_0x01b4
        L_0x0184:
            r1 = 1
            if (r13 != r1) goto L_0x0194
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0182
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x017f
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0182
            goto L_0x017f
        L_0x0194:
            r1 = 2
            if (r13 != r1) goto L_0x01a4
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0182
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x017f
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0182
            goto L_0x017f
        L_0x01a4:
            r1 = 3
            if (r13 != r1) goto L_0x01b4
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01b4
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x0180
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01b4
            goto L_0x0180
        L_0x01b4:
            r14 = 1
        L_0x01b5:
            if (r14 == 0) goto L_0x0159
            int r14 = r0.viewTransitionId
            r15 = -1
            if (r14 != r15) goto L_0x01df
            r10.addKey(r3)
            r10.addKey(r4)
            r10.addKey(r5)
            r10.addKey(r7)
            int r14 = r0.motionEffectTranslationX
            if (r14 <= 0) goto L_0x01d2
            r10.addKey(r8)
            r10.addKey(r11)
        L_0x01d2:
            int r14 = r0.motionEffectTranslationY
            if (r14 <= 0) goto L_0x01dc
            r10.addKey(r9)
            r10.addKey(r12)
        L_0x01dc:
            r1 = r22
            goto L_0x01e4
        L_0x01df:
            r1 = r22
            r1.applyViewTransition(r14, r10)
        L_0x01e4:
            int r6 = r6 + 1
            r1 = r23
            goto L_0x014c
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
