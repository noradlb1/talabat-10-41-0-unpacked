package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;

    /* renamed from: a  reason: collision with root package name */
    public float f11018a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public float f11019b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11020c = false;
    private float[] mAnchorDpDt = new float[2];
    private int mAutoCompleteMode = 0;
    private float mDragScale = 1.0f;
    private boolean mDragStarted = false;
    private float mDragThreshold = 10.0f;
    private int mFlags = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo = -1;
    private float mMaxAcceleration = 1.2f;
    private float mMaxVelocity = 4.0f;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop = true;
    private int mOnTouchUp = 0;
    private int mRotationCenterId = -1;
    private int mSpringBoundary = 0;
    private float mSpringDamping = 10.0f;
    private float mSpringMass = 1.0f;
    private float mSpringStiffness = Float.NaN;
    private float mSpringStopThreshold = Float.NaN;
    private int[] mTempLoc = new int[2];
    private int mTouchAnchorId = -1;
    private int mTouchAnchorSide = 0;
    private float mTouchAnchorX = 0.5f;
    private float mTouchAnchorY = 0.5f;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private int mTouchRegionId = -1;
    private int mTouchSide = 0;

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i12 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i12;
                float[] fArr = TOUCH_SIDES[i12];
                this.mTouchAnchorX = fArr[0];
                this.mTouchAnchorY = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i13 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i13;
                float[][] fArr2 = TOUCH_DIRECTION;
                if (i13 < fArr2.length) {
                    float[] fArr3 = fArr2[i13];
                    this.mTouchDirectionX = fArr3[0];
                    this.mTouchDirectionY = fArr3[1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.f11020c = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = typedArray.getResourceId(index, this.mRotationCenterId);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.mSpringDamping = typedArray.getFloat(index, this.mSpringDamping);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.mSpringMass = typedArray.getFloat(index, this.mSpringMass);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.mSpringStiffness = typedArray.getFloat(index, this.mSpringStiffness);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.mSpringStopThreshold = typedArray.getFloat(index, this.mSpringStopThreshold);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.mSpringBoundary = typedArray.getInt(index, this.mSpringBoundary);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.mAutoCompleteMode = typedArray.getInt(index, this.mAutoCompleteMode);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public float a(float f11, float f12) {
        return (f11 * this.mTouchDirectionX) + (f12 * this.mTouchDirectionY);
    }

    public RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i11 = this.mLimitBoundsTo;
        if (i11 == -1 || (findViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public float c() {
        return this.mMaxAcceleration;
    }

    public boolean d() {
        return this.mMoveWhenScrollAtTop;
    }

    public float e(float f11, float f12) {
        this.mMotionLayout.D(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f13 = this.mTouchDirectionX;
        if (f13 != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f11 * f13) / fArr[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f12 * this.mTouchDirectionY) / fArr2[1];
    }

    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i11 = this.mTouchRegionId;
        if (i11 == -1 || (findViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public int g() {
        return this.mTouchRegionId;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public boolean h() {
        return this.mDragStarted;
    }

    public void i(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i11, MotionScene motionScene) {
        float f11;
        float f12;
        int i12;
        float f13;
        float f14;
        float f15;
        boolean z11;
        MotionLayout.MotionTracker motionTracker2 = motionTracker;
        if (this.f11020c) {
            j(motionEvent, motionTracker, i11, motionScene);
            return;
        }
        motionTracker2.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            motionTracker2.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i13 = this.mTouchAnchorId;
            if (i13 != -1) {
                this.mMotionLayout.D(i13, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = (float) Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f16 = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f17 = fArr2[0];
            float f18 = fArr2[1];
            if (f16 != 0.0f) {
                f11 = xVelocity / f17;
            } else {
                f11 = yVelocity / f18;
            }
            if (!Float.isNaN(f11)) {
                f12 = (f11 / 3.0f) + progress;
            } else {
                f12 = progress;
            }
            if (f12 != 0.0f && f12 != 1.0f && (i12 = this.mOnTouchUp) != 3) {
                if (((double) f12) < 0.5d) {
                    f13 = 0.0f;
                } else {
                    f13 = 1.0f;
                }
                if (i12 == 6) {
                    if (progress + f11 < 0.0f) {
                        f11 = Math.abs(f11);
                    }
                    f13 = 1.0f;
                }
                if (this.mOnTouchUp == 7) {
                    if (progress + f11 > 1.0f) {
                        f11 = -Math.abs(f11);
                    }
                    f13 = 0.0f;
                }
                this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, f13, f11);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                }
            } else if (0.0f >= f12 || 1.0f <= f12) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.mLastTouchY;
            float rawX = motionEvent.getRawX() - this.mLastTouchX;
            if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                float progress2 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress2);
                }
                int i14 = this.mTouchAnchorId;
                if (i14 != -1) {
                    this.mMotionLayout.D(i14, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float min2 = (float) Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    float[] fArr3 = this.mAnchorDpDt;
                    fArr3[1] = this.mTouchDirectionY * min2;
                    fArr3[0] = min2 * this.mTouchDirectionX;
                }
                float f19 = this.mTouchDirectionX;
                float[] fArr4 = this.mAnchorDpDt;
                if (((double) Math.abs(((f19 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale)) < 0.01d) {
                    float[] fArr5 = this.mAnchorDpDt;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.mTouchDirectionX != 0.0f) {
                    f14 = rawX / this.mAnchorDpDt[0];
                } else {
                    f14 = rawY / this.mAnchorDpDt[1];
                }
                float max = Math.max(Math.min(progress2 + f14, 1.0f), 0.0f);
                if (this.mOnTouchUp == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.mOnTouchUp == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.mMotionLayout.getProgress();
                if (max != progress3) {
                    int i15 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i15 == 0 || progress3 == 1.0f) {
                        MotionLayout motionLayout = this.mMotionLayout;
                        if (i15 == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        motionLayout.A(z11);
                    }
                    this.mMotionLayout.setProgress(max);
                    motionTracker2.computeCurrentVelocity(1000);
                    float xVelocity2 = motionTracker.getXVelocity();
                    float yVelocity2 = motionTracker.getYVelocity();
                    if (this.mTouchDirectionX != 0.0f) {
                        f15 = xVelocity2 / this.mAnchorDpDt[0];
                    } else {
                        f15 = yVelocity2 / this.mAnchorDpDt[1];
                    }
                    this.mMotionLayout.f10919e = f15;
                } else {
                    this.mMotionLayout.f10919e = 0.0f;
                }
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x031f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r25, int r26, androidx.constraintlayout.motion.widget.MotionScene r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r2 = r24
            r1.addMovement(r2)
            int r3 = r24.getAction()
            r4 = 0
            if (r3 == 0) goto L_0x0332
            r5 = 1135869952(0x43b40000, float:360.0)
            r6 = -1
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1
            if (r3 == r10) goto L_0x01c1
            r11 = 2
            if (r3 == r11) goto L_0x001d
            goto L_0x0340
        L_0x001d:
            r24.getRawY()
            r24.getRawX()
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.mRotationCenterId
            if (r12 == r6) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            android.view.View r3 = r3.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int[] r12 = r0.mTempLoc
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.mTempLoc
            r11 = r11[r4]
            float r11 = (float) r11
            int r12 = r3.getLeft()
            int r13 = r3.getRight()
            int r12 = r12 + r13
            float r12 = (float) r12
            float r12 = r12 / r9
            float r11 = r11 + r12
            int[] r12 = r0.mTempLoc
            r12 = r12[r10]
            float r12 = (float) r12
            int r13 = r3.getTop()
            int r3 = r3.getBottom()
            int r13 = r13 + r3
            float r3 = (float) r13
            float r3 = r3 / r9
            float r3 = r3 + r12
            r22 = r11
            r11 = r3
            r3 = r22
            goto L_0x00b3
        L_0x006c:
            int r12 = r0.mTouchAnchorId
            if (r12 == r6) goto L_0x00b3
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionController r12 = r13.F(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.mMotionLayout
            int r12 = r12.getAnimateRelativeTo()
            android.view.View r12 = r13.findViewById(r12)
            if (r12 != 0) goto L_0x008a
            java.lang.String r9 = "TouchResponse"
            java.lang.String r12 = "could not find view to animate to"
            android.util.Log.e(r9, r12)
            goto L_0x00b3
        L_0x008a:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            int[] r11 = r0.mTempLoc
            r3.getLocationOnScreen(r11)
            int[] r3 = r0.mTempLoc
            r3 = r3[r4]
            float r3 = (float) r3
            int r11 = r12.getLeft()
            int r13 = r12.getRight()
            int r11 = r11 + r13
            float r11 = (float) r11
            float r11 = r11 / r9
            float r3 = r3 + r11
            int[] r11 = r0.mTempLoc
            r11 = r11[r10]
            float r11 = (float) r11
            int r13 = r12.getTop()
            int r12 = r12.getBottom()
            int r13 = r13 + r12
            float r12 = (float) r13
            float r12 = r12 / r9
            float r11 = r11 + r12
        L_0x00b3:
            float r9 = r24.getRawX()
            float r9 = r9 - r3
            float r12 = r24.getRawY()
            float r12 = r12 - r11
            float r13 = r24.getRawY()
            float r13 = r13 - r11
            double r13 = (double) r13
            float r15 = r24.getRawX()
            float r15 = r15 - r3
            r27 = r9
            double r8 = (double) r15
            double r8 = java.lang.Math.atan2(r13, r8)
            float r13 = r0.mLastTouchY
            float r13 = r13 - r11
            double r13 = (double) r13
            float r11 = r0.mLastTouchX
            float r11 = r11 - r3
            double r6 = (double) r11
            double r6 = java.lang.Math.atan2(r13, r6)
            double r6 = r8 - r6
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r6 = r6 * r13
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r6 = r6 / r13
            float r6 = (float) r6
            r7 = 1134886912(0x43a50000, float:330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f2
            float r6 = r6 - r5
            goto L_0x00f9
        L_0x00f2:
            r7 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f9
            float r6 = r6 + r5
        L_0x00f9:
            float r7 = java.lang.Math.abs(r6)
            double r13 = (double) r7
            r16 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r7 > 0) goto L_0x010b
            boolean r7 = r0.mDragStarted
            if (r7 == 0) goto L_0x0340
        L_0x010b:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.mMotionLayout
            float r7 = r7.getProgress()
            boolean r11 = r0.mDragStarted
            if (r11 != 0) goto L_0x011c
            r0.mDragStarted = r10
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            r11.setProgress(r7)
        L_0x011c:
            int r11 = r0.mTouchAnchorId
            r3 = -1
            if (r11 == r3) goto L_0x0145
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            float r5 = r0.mTouchAnchorX
            float r13 = r0.mTouchAnchorY
            float[] r14 = r0.mAnchorDpDt
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r13
            r21 = r14
            r16.D(r17, r18, r19, r20, r21)
            float[] r3 = r0.mAnchorDpDt
            r5 = r3[r10]
            double r13 = (double) r5
            double r13 = java.lang.Math.toDegrees(r13)
            float r5 = (float) r13
            r3[r10] = r5
            goto L_0x0149
        L_0x0145:
            float[] r3 = r0.mAnchorDpDt
            r3[r10] = r5
        L_0x0149:
            float r3 = r0.mDragScale
            float r6 = r6 * r3
            float[] r3 = r0.mAnchorDpDt
            r3 = r3[r10]
            float r6 = r6 / r3
            float r7 = r7 + r6
            r3 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r7, r3)
            r6 = 0
            float r5 = java.lang.Math.max(r5, r6)
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.mMotionLayout
            float r7 = r7.getProgress()
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x01ae
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0177
        L_0x016f:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            if (r6 != 0) goto L_0x0174
            r4 = r10
        L_0x0174:
            r3.A(r4)
        L_0x0177:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            r3.setProgress(r5)
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            float r3 = r25.getXVelocity()
            float r1 = r25.getYVelocity()
            double r4 = (double) r1
            double r6 = (double) r3
            double r10 = java.lang.Math.hypot(r4, r6)
            double r3 = java.lang.Math.atan2(r4, r6)
            double r3 = r3 - r8
            double r3 = java.lang.Math.sin(r3)
            double r10 = r10 * r3
            r9 = r27
            double r3 = (double) r9
            double r5 = (double) r12
            double r3 = java.lang.Math.hypot(r3, r5)
            double r10 = r10 / r3
            float r1 = (float) r10
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            double r4 = (double) r1
            double r4 = java.lang.Math.toDegrees(r4)
            float r1 = (float) r4
            r3.f10919e = r1
            goto L_0x01b3
        L_0x01ae:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.mMotionLayout
            r3 = 0
            r1.f10919e = r3
        L_0x01b3:
            float r1 = r24.getRawX()
            r0.mLastTouchX = r1
            float r1 = r24.getRawY()
            r0.mLastTouchY = r1
            goto L_0x0340
        L_0x01c1:
            r0.mDragStarted = r4
            r6 = 16
            r1.computeCurrentVelocity(r6)
            float r6 = r25.getXVelocity()
            float r1 = r25.getYVelocity()
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.mMotionLayout
            float r7 = r7.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.mMotionLayout
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r8 = r8 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.mRotationCenterId
            r3 = -1
            if (r12 == r3) goto L_0x021c
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.mMotionLayout
            android.view.View r8 = r8.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int[] r12 = r0.mTempLoc
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.mTempLoc
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.mTempLoc
            r11 = r11[r10]
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
        L_0x0216:
            int r12 = r12 + r8
            float r8 = (float) r12
            float r8 = r8 / r9
            float r11 = r11 + r8
            r8 = r4
            goto L_0x0257
        L_0x021c:
            int r12 = r0.mTouchAnchorId
            r3 = -1
            if (r12 == r3) goto L_0x0257
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionController r8 = r8.F(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int r8 = r8.getAnimateRelativeTo()
            android.view.View r8 = r11.findViewById(r8)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.mMotionLayout
            int[] r12 = r0.mTempLoc
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.mTempLoc
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.mTempLoc
            r11 = r11[r10]
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
            goto L_0x0216
        L_0x0257:
            float r4 = r24.getRawX()
            float r4 = r4 - r8
            float r2 = r24.getRawY()
            float r2 = r2 - r11
            double r8 = (double) r2
            double r11 = (double) r4
            double r8 = java.lang.Math.atan2(r8, r11)
            double r8 = java.lang.Math.toDegrees(r8)
            int r11 = r0.mTouchAnchorId
            r3 = -1
            if (r11 == r3) goto L_0x0294
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            float r5 = r0.mTouchAnchorX
            float r12 = r0.mTouchAnchorY
            float[] r13 = r0.mAnchorDpDt
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r12
            r21 = r13
            r16.D(r17, r18, r19, r20, r21)
            float[] r3 = r0.mAnchorDpDt
            r5 = r3[r10]
            double r11 = (double) r5
            double r11 = java.lang.Math.toDegrees(r11)
            float r5 = (float) r11
            r3[r10] = r5
            goto L_0x0298
        L_0x0294:
            float[] r3 = r0.mAnchorDpDt
            r3[r10] = r5
        L_0x0298:
            float r1 = r1 + r2
            double r1 = (double) r1
            float r6 = r6 + r4
            double r3 = (double) r6
            double r1 = java.lang.Math.atan2(r1, r3)
            double r1 = java.lang.Math.toDegrees(r1)
            double r1 = r1 - r8
            float r1 = (float) r1
            r2 = 1115291648(0x427a0000, float:62.5)
            float r1 = r1 * r2
            boolean r2 = java.lang.Float.isNaN(r1)
            r3 = 1077936128(0x40400000, float:3.0)
            if (r2 != 0) goto L_0x02bd
            float r2 = r1 * r3
            float r4 = r0.mDragScale
            float r2 = r2 * r4
            float[] r4 = r0.mAnchorDpDt
            r4 = r4[r10]
            float r2 = r2 / r4
            float r2 = r2 + r7
            goto L_0x02be
        L_0x02bd:
            r2 = r7
        L_0x02be:
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x031f
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x031f
            int r4 = r0.mOnTouchUp
            r5 = 3
            if (r4 == r5) goto L_0x031f
            float r5 = r0.mDragScale
            float r1 = r1 * r5
            float[] r5 = r0.mAnchorDpDt
            r5 = r5[r10]
            float r1 = r1 / r5
            double r5 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x02df
            r2 = 0
            goto L_0x02e1
        L_0x02df:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02e1:
            r5 = 6
            if (r4 != r5) goto L_0x02f1
            float r2 = r7 + r1
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x02ef
            float r1 = java.lang.Math.abs(r1)
        L_0x02ef:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02f1:
            int r4 = r0.mOnTouchUp
            r5 = 7
            if (r4 != r5) goto L_0x0304
            float r2 = r7 + r1
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0303
            float r1 = java.lang.Math.abs(r1)
            float r1 = -r1
        L_0x0303:
            r2 = 0
        L_0x0304:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r0.mMotionLayout
            int r5 = r0.mOnTouchUp
            float r1 = r1 * r3
            r4.touchAnimateTo(r5, r2, r1)
            r1 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0317
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0340
        L_0x0317:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r1.setState(r2)
            goto L_0x0340
        L_0x031f:
            r1 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x032a
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0340
        L_0x032a:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r1.setState(r2)
            goto L_0x0340
        L_0x0332:
            float r1 = r24.getRawX()
            r0.mLastTouchX = r1
            float r1 = r24.getRawY()
            r0.mLastTouchY = r1
            r0.mDragStarted = r4
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.j(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    public void k(float f11, float f12) {
        float f13;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.D(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f14 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (((double) Math.abs((f14 * fArr[0]) + (this.mTouchDirectionY * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f15 = this.mTouchDirectionX;
        if (f15 != 0.0f) {
            f13 = (f11 * f15) / this.mAnchorDpDt[0];
        } else {
            f13 = (f12 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f13, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    public void l(float f11, float f12) {
        float f13;
        boolean z11;
        boolean z12 = false;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.D(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f14 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f15 = fArr[0];
        float f16 = this.mTouchDirectionY;
        float f17 = fArr[1];
        float f18 = 0.0f;
        if (f14 != 0.0f) {
            f13 = (f11 * f14) / f15;
        } else {
            f13 = (f12 * f16) / f17;
        }
        if (!Float.isNaN(f13)) {
            progress += f13 / 3.0f;
        }
        if (progress != 0.0f) {
            if (progress != 1.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i11 = this.mOnTouchUp;
            if (i11 != 3) {
                z12 = true;
            }
            if (z12 && z11) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (((double) progress) >= 0.5d) {
                    f18 = 1.0f;
                }
                motionLayout.touchAnimateTo(i11, f18, f13);
            }
        }
    }

    public void m(float f11, float f12) {
        this.mLastTouchX = f11;
        this.mLastTouchY = f12;
    }

    public void n(float f11, float f12) {
        this.mLastTouchX = f11;
        this.mLastTouchY = f12;
        this.mDragStarted = false;
    }

    public void o() {
        View view;
        int i11 = this.mTouchAnchorId;
        if (i11 != -1) {
            view = this.mMotionLayout.findViewById(i11);
            if (view == null) {
                Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                public void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
                }
            });
        }
    }

    public void setAnchorId(int i11) {
        this.mTouchAnchorId = i11;
    }

    public void setMaxAcceleration(float f11) {
        this.mMaxAcceleration = f11;
    }

    public void setMaxVelocity(float f11) {
        this.mMaxVelocity = f11;
    }

    public void setRTL(boolean z11) {
        if (z11) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = fArr5[0];
        this.mTouchAnchorY = fArr5[1];
        int i11 = this.mTouchSide;
        float[][] fArr6 = TOUCH_DIRECTION;
        if (i11 < fArr6.length) {
            float[] fArr7 = fArr6[i11];
            this.mTouchDirectionX = fArr7[0];
            this.mTouchDirectionY = fArr7[1];
        }
    }

    public void setTouchAnchorLocation(float f11, float f12) {
        this.mTouchAnchorX = f11;
        this.mTouchAnchorY = f12;
    }

    public void setTouchUpMode(int i11) {
        this.mOnTouchUp = i11;
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX)) {
            return "rotation";
        }
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }

    public TouchResponse(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.mMotionLayout = motionLayout;
        this.mTouchAnchorId = onSwipe.getTouchAnchorId();
        int touchAnchorSide = onSwipe.getTouchAnchorSide();
        this.mTouchAnchorSide = touchAnchorSide;
        if (touchAnchorSide != -1) {
            float[] fArr = TOUCH_SIDES[touchAnchorSide];
            this.mTouchAnchorX = fArr[0];
            this.mTouchAnchorY = fArr[1];
        }
        int dragDirection = onSwipe.getDragDirection();
        this.mTouchSide = dragDirection;
        float[][] fArr2 = TOUCH_DIRECTION;
        if (dragDirection < fArr2.length) {
            float[] fArr3 = fArr2[dragDirection];
            this.mTouchDirectionX = fArr3[0];
            this.mTouchDirectionY = fArr3[1];
        } else {
            this.mTouchDirectionY = Float.NaN;
            this.mTouchDirectionX = Float.NaN;
            this.f11020c = true;
        }
        this.mMaxVelocity = onSwipe.getMaxVelocity();
        this.mMaxAcceleration = onSwipe.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = onSwipe.getMoveWhenScrollAtTop();
        this.mDragScale = onSwipe.getDragScale();
        this.mDragThreshold = onSwipe.getDragThreshold();
        this.mTouchRegionId = onSwipe.getTouchRegionId();
        this.mOnTouchUp = onSwipe.getOnTouchUp();
        this.mFlags = onSwipe.getNestedScrollFlags();
        this.mLimitBoundsTo = onSwipe.getLimitBoundsTo();
        this.mRotationCenterId = onSwipe.getRotationCenterId();
        this.mSpringBoundary = onSwipe.getSpringBoundary();
        this.mSpringDamping = onSwipe.getSpringDamping();
        this.mSpringMass = onSwipe.getSpringMass();
        this.mSpringStiffness = onSwipe.getSpringStiffness();
        this.mSpringStopThreshold = onSwipe.getSpringStopThreshold();
        this.mAutoCompleteMode = onSwipe.getAutoCompleteMode();
    }
}
