package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import z0.a;

public class ViewTransition {
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    private static final int SPLINE_STRING = -1;
    private static String TAG = "ViewTransition";
    private static final int UNSET = -1;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";

    /* renamed from: a  reason: collision with root package name */
    public int f11023a;

    /* renamed from: b  reason: collision with root package name */
    public KeyFrames f11024b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintSet.Constraint f11025c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11026d;
    private int mClearsTag = -1;
    private int mDefaultInterpolator = 0;
    private int mDefaultInterpolatorID = -1;
    private String mDefaultInterpolatorString = null;
    private boolean mDisabled = false;
    private int mDuration = -1;
    private int mId;
    private int mIfTagNotSet = -1;
    private int mIfTagSet = -1;
    private int mOnStateTransition = -1;
    private int mPathMotionArc = 0;
    private int mSetsTag = -1;
    private int mSharedValueCurrent = -1;
    private int mSharedValueID = -1;
    private int mSharedValueTarget = -1;
    private int mTargetId;
    private String mTargetString;
    private int mUpDuration = -1;

    public static class Animate {

        /* renamed from: a  reason: collision with root package name */
        public long f11029a;

        /* renamed from: b  reason: collision with root package name */
        public MotionController f11030b;

        /* renamed from: c  reason: collision with root package name */
        public int f11031c;

        /* renamed from: d  reason: collision with root package name */
        public int f11032d;

        /* renamed from: e  reason: collision with root package name */
        public KeyCache f11033e = new KeyCache();

        /* renamed from: f  reason: collision with root package name */
        public ViewTransitionController f11034f;

        /* renamed from: g  reason: collision with root package name */
        public Interpolator f11035g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f11036h = false;

        /* renamed from: i  reason: collision with root package name */
        public float f11037i;

        /* renamed from: j  reason: collision with root package name */
        public float f11038j;

        /* renamed from: k  reason: collision with root package name */
        public long f11039k;

        /* renamed from: l  reason: collision with root package name */
        public Rect f11040l = new Rect();

        /* renamed from: m  reason: collision with root package name */
        public boolean f11041m = false;
        private final int mClearsTag;
        private final int mSetsTag;

        public Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i11, int i12, int i13, Interpolator interpolator, int i14, int i15) {
            float f11;
            this.f11034f = viewTransitionController;
            this.f11030b = motionController;
            this.f11031c = i11;
            this.f11032d = i12;
            long nanoTime = System.nanoTime();
            this.f11029a = nanoTime;
            this.f11039k = nanoTime;
            this.f11034f.b(this);
            this.f11035g = interpolator;
            this.mSetsTag = i14;
            this.mClearsTag = i15;
            if (i13 == 3) {
                this.f11041m = true;
            }
            if (i11 == 0) {
                f11 = Float.MAX_VALUE;
            } else {
                f11 = 1.0f / ((float) i11);
            }
            this.f11038j = f11;
            a();
        }

        public void a() {
            if (this.f11036h) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            float f11;
            long nanoTime = System.nanoTime();
            this.f11039k = nanoTime;
            float f12 = this.f11037i + (((float) (((double) (nanoTime - this.f11039k)) * 1.0E-6d)) * this.f11038j);
            this.f11037i = f12;
            if (f12 >= 1.0f) {
                this.f11037i = 1.0f;
            }
            Interpolator interpolator = this.f11035g;
            if (interpolator == null) {
                f11 = this.f11037i;
            } else {
                f11 = interpolator.getInterpolation(this.f11037i);
            }
            float f13 = f11;
            MotionController motionController = this.f11030b;
            boolean n11 = motionController.n(motionController.f10905b, f13, nanoTime, this.f11033e);
            if (this.f11037i >= 1.0f) {
                if (this.mSetsTag != -1) {
                    this.f11030b.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.f11030b.getView().setTag(this.mClearsTag, (Object) null);
                }
                if (!this.f11041m) {
                    this.f11034f.h(this);
                }
            }
            if (this.f11037i < 1.0f || n11) {
                this.f11034f.f();
            }
        }

        public void c() {
            float f11;
            long nanoTime = System.nanoTime();
            this.f11039k = nanoTime;
            float f12 = this.f11037i - (((float) (((double) (nanoTime - this.f11039k)) * 1.0E-6d)) * this.f11038j);
            this.f11037i = f12;
            if (f12 < 0.0f) {
                this.f11037i = 0.0f;
            }
            Interpolator interpolator = this.f11035g;
            if (interpolator == null) {
                f11 = this.f11037i;
            } else {
                f11 = interpolator.getInterpolation(this.f11037i);
            }
            float f13 = f11;
            MotionController motionController = this.f11030b;
            boolean n11 = motionController.n(motionController.f10905b, f13, nanoTime, this.f11033e);
            if (this.f11037i <= 0.0f) {
                if (this.mSetsTag != -1) {
                    this.f11030b.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.f11030b.getView().setTag(this.mClearsTag, (Object) null);
                }
                this.f11034f.h(this);
            }
            if (this.f11037i > 0.0f || n11) {
                this.f11034f.f();
            }
        }

        public void d(boolean z11) {
            int i11;
            float f11;
            this.f11036h = z11;
            if (z11 && (i11 = this.f11032d) != -1) {
                if (i11 == 0) {
                    f11 = Float.MAX_VALUE;
                } else {
                    f11 = 1.0f / ((float) i11);
                }
                this.f11038j = f11;
            }
            this.f11034f.f();
            this.f11039k = System.nanoTime();
        }

        public void reactTo(int i11, float f11, float f12) {
            if (i11 != 1) {
                if (i11 == 2) {
                    this.f11030b.getView().getHitRect(this.f11040l);
                    if (!this.f11040l.contains((int) f11, (int) f12) && !this.f11036h) {
                        d(true);
                    }
                }
            } else if (!this.f11036h) {
                d(true);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewTransition(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.mOnStateTransition = r0
            r1 = 0
            r9.mDisabled = r1
            r9.mPathMotionArc = r1
            r9.mDuration = r0
            r9.mUpDuration = r0
            r9.mDefaultInterpolator = r1
            r2 = 0
            r9.mDefaultInterpolatorString = r2
            r9.mDefaultInterpolatorID = r0
            r9.mSetsTag = r0
            r9.mClearsTag = r0
            r9.mIfTagSet = r0
            r9.mIfTagNotSet = r0
            r9.mSharedValueTarget = r0
            r9.mSharedValueID = r0
            r9.mSharedValueCurrent = r0
            r9.f11026d = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x002a:
            r3 = 1
            if (r2 == r3) goto L_0x00eb
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0042
            if (r2 == r5) goto L_0x0037
            goto L_0x00dc
        L_0x0037:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r2 == 0) goto L_0x00dc
            return
        L_0x0042:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x0075;
                case -1239391468: goto L_0x006b;
                case 61998586: goto L_0x0063;
                case 366511058: goto L_0x0059;
                case 1791837707: goto L_0x004f;
                default: goto L_0x004e;
            }     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x004e:
            goto L_0x007f
        L_0x004f:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r5
            goto L_0x0080
        L_0x0059:
            java.lang.String r4 = "CustomMethod"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r8
            goto L_0x0080
        L_0x0063:
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r1
            goto L_0x0080
        L_0x006b:
            java.lang.String r4 = "KeyFrameSet"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r3
            goto L_0x0080
        L_0x0075:
            java.lang.String r4 = "ConstraintOverride"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r6
            goto L_0x0080
        L_0x007f:
            r4 = r0
        L_0x0080:
            if (r4 == 0) goto L_0x00d9
            if (r4 == r3) goto L_0x00d1
            if (r4 == r6) goto L_0x00ca
            if (r4 == r5) goto L_0x00c2
            if (r4 == r8) goto L_0x00c2
            java.lang.String r3 = TAG     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r5 = androidx.constraintlayout.motion.widget.Debug.getLoc()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r5 = " unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            android.util.Log.e(r3, r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r2 = TAG     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r4 = ".xml:"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            int r4 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            android.util.Log.e(r2, r3)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00c2:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.f11025c     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00ca:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.buildDelta(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r9.f11025c = r2     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00d1:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r9.f11024b = r2     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00d9:
            r9.parseViewTransitionTags(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x00dc:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x002a
        L_0x00e2:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00eb
        L_0x00e7:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$applyTransition$0(View[] viewArr) {
        if (this.mSetsTag != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.mClearsTag != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.mClearsTag, (Object) null);
            }
        }
    }

    private void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.ViewTransition_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    this.mTargetId = resourceId;
                    if (resourceId == -1) {
                        this.mTargetString = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = obtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = obtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.mDisabled = obtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.mDuration = obtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.mUpDuration = obtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f11023a = obtainStyledAttributes.getInt(index, this.f11023a);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i12 = obtainStyledAttributes.peekValue(index).type;
                if (i12 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId2;
                    if (resourceId2 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (i12 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.mSetsTag = obtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.mClearsTag = obtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = obtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = obtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = obtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = obtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void updateTransition(MotionScene.Transition transition, View view) {
        int i11 = this.mDuration;
        if (i11 != -1) {
            transition.setDuration(i11);
        }
        transition.setPathMotionArc(this.mPathMotionArc);
        transition.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int id2 = view.getId();
        KeyFrames keyFrames = this.f11024b;
        if (keyFrames != null) {
            ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator<Key> it = keyFramesForView.iterator();
            while (it.hasNext()) {
                keyFrames2.addKey(it.next().clone().setViewId(id2));
            }
            transition.addKeyFrame(keyFrames2);
        }
    }

    public void b(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.q(view);
        this.f11024b.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.mDuration, System.nanoTime());
        ViewTransitionController viewTransitionController2 = viewTransitionController;
        MotionController motionController2 = motionController;
        new Animate(viewTransitionController2, motionController2, this.mDuration, this.mUpDuration, this.mOnStateTransition, f(motionLayout.getContext()), this.mSetsTag, this.mClearsTag);
    }

    public void c(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i11, ConstraintSet constraintSet, View... viewArr) {
        if (!this.mDisabled) {
            int i12 = this.f11023a;
            if (i12 == 2) {
                b(viewTransitionController, motionLayout, viewArr[0]);
                return;
            }
            if (i12 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i13 : constraintSetIds) {
                    if (i13 != i11) {
                        ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i13);
                        for (View id2 : viewArr) {
                            ConstraintSet.Constraint constraint = constraintSet2.getConstraint(id2.getId());
                            ConstraintSet.Constraint constraint2 = this.f11025c;
                            if (constraint2 != null) {
                                constraint2.applyDelta(constraint);
                                constraint.mCustomConstraints.putAll(this.f11025c.mCustomConstraints);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(constraintSet);
            for (View id3 : viewArr) {
                ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(id3.getId());
                ConstraintSet.Constraint constraint4 = this.f11025c;
                if (constraint4 != null) {
                    constraint4.applyDelta(constraint3);
                    constraint3.mCustomConstraints.putAll(this.f11025c.mCustomConstraints);
                }
            }
            motionLayout.updateState(i11, constraintSet3);
            int i14 = R.id.view_transition;
            motionLayout.updateState(i14, constraintSet);
            motionLayout.setState(i14, -1, -1);
            MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.f10916b, i14, i11);
            for (View updateTransition : viewArr) {
                updateTransition(transition, updateTransition);
            }
            motionLayout.setTransition(transition);
            motionLayout.transitionToEnd(new a(this, viewArr));
        }
    }

    public boolean d(View view) {
        boolean z11;
        boolean z12;
        int i11 = this.mIfTagSet;
        if (i11 != -1 && view.getTag(i11) == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        int i12 = this.mIfTagNotSet;
        if (i12 == -1 || view.getTag(i12) == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    public int e() {
        return this.mId;
    }

    public Interpolator f(Context context) {
        int i11 = this.mDefaultInterpolator;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
        }
        if (i11 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f11) {
                    return (float) interpolator.get((double) f11);
                }
            };
        } else if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i11 == 1) {
                return new AccelerateInterpolator();
            }
            if (i11 == 2) {
                return new DecelerateInterpolator();
            }
            if (i11 == 4) {
                return new BounceInterpolator();
            }
            if (i11 == 5) {
                return new OvershootInterpolator();
            }
            if (i11 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public boolean g() {
        return !this.mDisabled;
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    public boolean h(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        if (this.mTargetString != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.mTargetString)) {
            return true;
        }
        return false;
    }

    public void i(boolean z11) {
        this.mDisabled = !z11;
    }

    public boolean j(int i11) {
        int i12 = this.mOnStateTransition;
        return i12 == 1 ? i11 == 0 : i12 == 2 ? i11 == 1 : i12 == 3 && i11 == 0;
    }

    public void setSharedValue(int i11) {
        this.mSharedValueTarget = i11;
    }

    public void setSharedValueCurrent(int i11) {
        this.mSharedValueCurrent = i11;
    }

    public void setSharedValueID(int i11) {
        this.mSharedValueID = i11;
    }

    public void setStateTransition(int i11) {
        this.mOnStateTransition = i11;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.f11026d, this.mId) + ")";
    }
}
