package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private boolean DEBUG_DESKTOP = false;

    /* renamed from: a  reason: collision with root package name */
    public StateSet f11009a = null;

    /* renamed from: b  reason: collision with root package name */
    public Transition f11010b = null;

    /* renamed from: c  reason: collision with root package name */
    public final ViewTransitionController f11011c;

    /* renamed from: d  reason: collision with root package name */
    public float f11012d;

    /* renamed from: e  reason: collision with root package name */
    public float f11013e;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    /* access modifiers changed from: private */
    public int mDefaultDuration = 400;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch = false;
    private MotionEvent mLastTouchDown;
    /* access modifiers changed from: private */
    public int mLayoutDuringTransition = 0;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private MotionLayout.MotionTracker mVelocityTracker;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.f11011c = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int i11;
        if (str.contains("/")) {
            i11 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + i11);
            }
        } else {
            i11 = -1;
        }
        if (i11 != -1) {
            return i11;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        return i11;
    }

    private int getIndex(Transition transition) {
        int o11 = transition.mId;
        if (o11 != -1) {
            for (int i11 = 0; i11 < this.mTransitionList.size(); i11++) {
                if (this.mTransitionList.get(i11).mId == o11) {
                    return i11;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    private int getRealID(int i11) {
        int stateGetConstraintID;
        StateSet stateSet = this.f11009a;
        if (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i11, -1, -1)) == -1) {
            return i11;
        }
        return stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i11) {
        int i12 = this.mDeriveMap.get(i11);
        int size = this.mDeriveMap.size();
        while (i12 > 0) {
            if (i12 == i11) {
                return true;
            }
            int i13 = size - 1;
            if (size < 0) {
                return true;
            }
            i12 = this.mDeriveMap.get(i12);
            size = i13;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            int r1 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r2 = 0
        L_0x000d:
            r3 = 1
            if (r1 == r3) goto L_0x016c
            if (r1 == 0) goto L_0x015a
            r4 = 2
            if (r1 == r4) goto L_0x0017
            goto L_0x015d
        L_0x0017:
            java.lang.String r1 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            boolean r5 = r8.DEBUG_DESKTOP     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r5 == 0) goto L_0x0035
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r6.append(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x0035:
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r6 = -1
            switch(r5) {
                case -1349929691: goto L_0x009a;
                case -1239391468: goto L_0x008f;
                case -687739768: goto L_0x0085;
                case 61998586: goto L_0x007a;
                case 269306229: goto L_0x0071;
                case 312750793: goto L_0x0067;
                case 327855227: goto L_0x005d;
                case 793277014: goto L_0x0053;
                case 1382829617: goto L_0x0049;
                case 1942574248: goto L_0x003f;
                default: goto L_0x003d;
            }     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x003d:
            goto L_0x00a4
        L_0x003f:
            java.lang.String r3 = "include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 6
            goto L_0x00a5
        L_0x0049:
            java.lang.String r3 = "StateSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 4
            goto L_0x00a5
        L_0x0053:
            java.lang.String r3 = "MotionScene"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 0
            goto L_0x00a5
        L_0x005d:
            java.lang.String r3 = "OnSwipe"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = r4
            goto L_0x00a5
        L_0x0067:
            java.lang.String r3 = "OnClick"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 3
            goto L_0x00a5
        L_0x0071:
            java.lang.String r4 = "Transition"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x007a:
            java.lang.String r3 = "ViewTransition"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 9
            goto L_0x00a5
        L_0x0085:
            java.lang.String r3 = "Include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 7
            goto L_0x00a5
        L_0x008f:
            java.lang.String r3 = "KeyFrameSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 8
            goto L_0x00a5
        L_0x009a:
            java.lang.String r3 = "ConstraintSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x00a4
            r3 = 5
            goto L_0x00a5
        L_0x00a4:
            r3 = r6
        L_0x00a5:
            switch(r3) {
                case 0: goto L_0x0156;
                case 1: goto L_0x0115;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00b6;
                case 9: goto L_0x00aa;
                default: goto L_0x00a8;
            }     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x00a8:
            goto L_0x015d
        L_0x00aa:
            androidx.constraintlayout.motion.widget.ViewTransition r1 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r3 = r8.f11011c     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r3.add(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00b6:
            androidx.constraintlayout.motion.widget.KeyFrames r1 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r2 == 0) goto L_0x015d
            java.util.ArrayList r3 = r2.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r3.add(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00c6:
            r8.parseInclude((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00cb:
            r8.parseConstraintSet(r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00d0:
            androidx.constraintlayout.widget.StateSet r1 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r8.f11009a = r1     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00d9:
            if (r2 == 0) goto L_0x015d
            r2.addOnClick((android.content.Context) r9, (org.xmlpull.v1.XmlPullParser) r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x00e0:
            if (r2 != 0) goto L_0x0108
            android.content.res.Resources r1 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r1 = r1.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r1 = ".xml:"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            java.lang.String r1 = ")"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x0108:
            if (r2 == 0) goto L_0x015d
            androidx.constraintlayout.motion.widget.TouchResponse r1 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r2.mTouchResponse = r1     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x0115:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mTransitionList     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.f11010b     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 != 0) goto L_0x013c
            boolean r1 = r2.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 != 0) goto L_0x013c
            r8.f11010b = r2     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r2.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x013c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.f11010b     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            boolean r3 = r8.mRtl     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.setRTL(r3)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x013c:
            boolean r1 = r2.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 == 0) goto L_0x015d
            int r1 = r2.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            if (r1 != r6) goto L_0x014b
            r8.mDefaultTransition = r2     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x0150
        L_0x014b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x0150:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mTransitionList     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x0156:
            r8.parseMotionSceneTags(r9, r0)     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x015d
        L_0x015a:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
        L_0x015d:
            int r1 = r0.next()     // Catch:{ XmlPullParserException -> 0x0168, IOException -> 0x0163 }
            goto L_0x000d
        L_0x0163:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x016c
        L_0x0168:
            r9 = move-exception
            r9.printStackTrace()
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseConstraintSet(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.setForceId(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L_0x0011:
            r7 = 1
            if (r4 >= r2) goto L_0x00e8
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.DEBUG_DESKTOP
            if (r10 == 0) goto L_0x0036
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "id string = "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L_0x0036:
            r8.hashCode()
            int r10 = r8.hashCode()
            r11 = 2
            switch(r10) {
                case -1496482599: goto L_0x0059;
                case -1153153640: goto L_0x004e;
                case 3355: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r8 = r3
            goto L_0x0063
        L_0x0043:
            java.lang.String r10 = "id"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r8 = r11
            goto L_0x0063
        L_0x004e:
            java.lang.String r10 = "constraintRotate"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            r8 = r7
            goto L_0x0063
        L_0x0059:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0062
            goto L_0x0041
        L_0x0062:
            r8 = r1
        L_0x0063:
            switch(r8) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x0081;
                case 2: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x00e4
        L_0x0068:
            int r5 = r13.getId(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.mConstraintSetIdMap
            java.lang.String r8 = stripID(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getName((android.content.Context) r14, (int) r5)
            r0.mIdString = r7
            goto L_0x00e4
        L_0x0081:
            int r8 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0089 }
            r0.mRotate = r8     // Catch:{ NumberFormatException -> 0x0089 }
            goto L_0x00e4
        L_0x0089:
            r9.hashCode()
            int r8 = r9.hashCode()
            r10 = 4
            r12 = 3
            switch(r8) {
                case -768416914: goto L_0x00c3;
                case 3317767: goto L_0x00b8;
                case 3387192: goto L_0x00ad;
                case 108511772: goto L_0x00a2;
                case 1954540437: goto L_0x0097;
                default: goto L_0x0095;
            }
        L_0x0095:
            r8 = r3
            goto L_0x00cd
        L_0x0097:
            java.lang.String r8 = "x_right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00a0
            goto L_0x0095
        L_0x00a0:
            r8 = r10
            goto L_0x00cd
        L_0x00a2:
            java.lang.String r8 = "right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00ab
            goto L_0x0095
        L_0x00ab:
            r8 = r12
            goto L_0x00cd
        L_0x00ad:
            java.lang.String r8 = "none"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00b6
            goto L_0x0095
        L_0x00b6:
            r8 = r11
            goto L_0x00cd
        L_0x00b8:
            java.lang.String r8 = "left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00c1
            goto L_0x0095
        L_0x00c1:
            r8 = r7
            goto L_0x00cd
        L_0x00c3:
            java.lang.String r8 = "x_left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00cc
            goto L_0x0095
        L_0x00cc:
            r8 = r1
        L_0x00cd:
            switch(r8) {
                case 0: goto L_0x00dd;
                case 1: goto L_0x00da;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00d1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            goto L_0x00e4
        L_0x00d1:
            r0.mRotate = r12
            goto L_0x00e4
        L_0x00d4:
            r0.mRotate = r7
            goto L_0x00e4
        L_0x00d7:
            r0.mRotate = r1
            goto L_0x00e4
        L_0x00da:
            r0.mRotate = r11
            goto L_0x00e4
        L_0x00dd:
            r0.mRotate = r10
            goto L_0x00e4
        L_0x00e0:
            int r6 = r13.getId(r14, r9)
        L_0x00e4:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x00e8:
            if (r5 == r3) goto L_0x0102
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.mMotionLayout
            int r1 = r1.f10927m
            if (r1 == 0) goto L_0x00f3
            r0.setValidateOnParse(r7)
        L_0x00f3:
            r0.load((android.content.Context) r14, (org.xmlpull.v1.XmlPullParser) r15)
            if (r6 == r3) goto L_0x00fd
            android.util.SparseIntArray r14 = r13.mDeriveMap
            r14.put(r5, r6)
        L_0x00fd:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.mConstraintSetMap
            r14.put(r5, r0)
        L_0x0102:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i12 = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i12;
                if (i12 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i11, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i11);
        constraintSet.derivedState = constraintSet.mIdString;
        int i12 = this.mDeriveMap.get(i11);
        if (i12 > 0) {
            readConstraintChain(i12, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i12);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i12));
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback((ConstraintLayout) motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.f11009a
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.stateGetConstraintID(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.f11009a
            int r2 = r2.stateGetConstraintID(r8, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.f11010b
            if (r3 == 0) goto L_0x002b
            int r3 = r3.mConstraintSetEnd
            if (r3 != r8) goto L_0x002b
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.f11010b
            int r3 = r3.mConstraintSetStart
            if (r3 != r7) goto L_0x002b
            return
        L_0x002b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0031:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r2) goto L_0x0049
            int r5 = r4.mConstraintSetStart
            if (r5 == r0) goto L_0x0055
        L_0x0049:
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0031
            int r5 = r4.mConstraintSetStart
            if (r5 != r7) goto L_0x0031
        L_0x0055:
            r6.f11010b = r4
            if (r4 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r4.mTouchResponse
            if (r7 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.f11010b
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r7.mTouchResponse
            boolean r8 = r6.mRtl
            r7.setRTL(r8)
        L_0x006a:
            return
        L_0x006b:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mAbstractTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0073:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0073
            r7 = r4
            goto L_0x0073
        L_0x0087:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            int unused = r8.mConstraintSetStart = r0
            int unused = r8.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x0099
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.mTransitionList
            r7.add(r8)
        L_0x0099:
            r6.f11010b = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.A(int, int):void");
    }

    public void B() {
        Transition transition = this.f11010b;
        if (transition != null && transition.mTouchResponse != null) {
            this.f11010b.mTouchResponse.o();
        }
    }

    public boolean C() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return true;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i11) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                Iterator it2 = next.mOnClicks.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.mOnClicks.size() > 0) {
                Iterator it4 = next2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.mOnClicks.size() > 0) {
                Iterator it6 = next3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i11, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.mOnClicks.size() > 0) {
                Iterator it8 = next4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i11, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i11, MotionController motionController) {
        return this.f11011c.d(i11, motionController);
    }

    public Transition bestTransitionFor(int i11, float f11, float f12, MotionEvent motionEvent) {
        RectF b11;
        float f13;
        int i12 = i11;
        float f14 = f11;
        float f15 = f12;
        if (i12 == -1) {
            return this.f11010b;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i11);
        RectF rectF = new RectF();
        float f16 = 0.0f;
        Transition transition = null;
        for (Transition next : transitionsWithState) {
            if (!next.mDisable && next.mTouchResponse != null) {
                next.mTouchResponse.setRTL(this.mRtl);
                RectF f17 = next.mTouchResponse.f(this.mMotionLayout, rectF);
                if ((f17 == null || motionEvent == null || f17.contains(motionEvent.getX(), motionEvent.getY())) && ((b11 = next.mTouchResponse.b(this.mMotionLayout, rectF)) == null || motionEvent == null || b11.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a11 = next.mTouchResponse.a(f14, f15);
                    if (next.mTouchResponse.f11020c && motionEvent != null) {
                        float x11 = motionEvent.getX() - next.mTouchResponse.f11018a;
                        float y11 = motionEvent.getY() - next.mTouchResponse.f11019b;
                        a11 = ((float) (Math.atan2((double) (f15 + y11), (double) (f14 + x11)) - Math.atan2((double) x11, (double) y11))) * 10.0f;
                    }
                    if (next.mConstraintSetEnd == i12) {
                        f13 = -1.0f;
                    } else {
                        f13 = 1.1f;
                    }
                    float f18 = a11 * f13;
                    if (f18 > f16) {
                        transition = next;
                        f16 = f18;
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z11) {
        this.mDisableAutoTransition = z11;
    }

    public void enableViewTransition(int i11, boolean z11) {
        this.f11011c.e(i11, z11);
    }

    public boolean f(MotionLayout motionLayout, int i11) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0 && ((transition = this.f11010b) != next || !transition.isTransitionFlag(2))) {
                if (i11 == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.B(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.I();
                    }
                    return true;
                } else if (i11 == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.B(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.I();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int g() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.f11010b.mTouchResponse.getAutoCompleteMode();
    }

    public int gatPathMotionArc() {
        Transition transition = this.f11010b;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            printStream.println("id " + str);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.mConstraintSetMap.size());
        }
        for (int i11 = 0; i11 < this.mConstraintSetMap.size(); i11++) {
            int keyAt = this.mConstraintSetMap.keyAt(i11);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream3 = System.out;
                printStream3.println("Id for <" + i11 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = this.mConstraintSetMap.keyAt(i11);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.f11010b;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    public Interpolator getInterpolator() {
        int g11 = this.f11010b.mDefaultInterpolator;
        if (g11 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.f11010b.mDefaultInterpolatorID);
        }
        if (g11 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.f11010b.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f11) {
                    return (float) interpolator.get((double) f11);
                }
            };
        } else if (g11 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (g11 == 1) {
                return new AccelerateInterpolator();
            }
            if (g11 == 2) {
                return new DecelerateInterpolator();
            }
            if (g11 == 4) {
                return new BounceInterpolator();
            }
            if (g11 == 5) {
                return new OvershootInterpolator();
            }
            if (g11 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.f11010b;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it = transition2.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator it2 = transition.mKeyFramesList.iterator();
        while (it2.hasNext()) {
            ((KeyFrames) it2.next()).addFrames(motionController);
        }
    }

    public float getPathPercent(View view, int i11) {
        return 0.0f;
    }

    public float getStaggered() {
        Transition transition = this.f11010b;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    public Transition getTransitionById(int i11) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i11) {
                return next;
            }
        }
        return null;
    }

    public List<Transition> getTransitionsWithState(int i11) {
        int realID = getRealID(i11);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ConstraintSet h(int i11) {
        return i(i11, -1, -1);
    }

    public ConstraintSet i(int i11, int i12, int i13) {
        int stateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            printStream.println("id " + i11);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.mConstraintSetMap.size());
        }
        StateSet stateSet = this.f11009a;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i11, i12, i13)) == -1)) {
            i11 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i11) != null) {
            return this.mConstraintSetMap.get(i11);
        }
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i11) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public boolean isViewTransitionEnabled(int i11) {
        return this.f11011c.g(i11);
    }

    public int j() {
        Transition transition = this.f11010b;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Key k(Context context, int i11, int i12, int i13) {
        Transition transition = this.f11010b;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            Iterator<Integer> it2 = keyFrames.getKeys().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Integer next = it2.next();
                    if (i12 == next.intValue()) {
                        Iterator<Key> it3 = keyFrames.getKeyFramesForView(next.intValue()).iterator();
                        while (it3.hasNext()) {
                            Key next2 = it3.next();
                            if (next2.f10871a == i13 && next2.f10874d == i11) {
                                return next2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public float l() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.c();
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i11) {
        for (Map.Entry next : this.mConstraintSetIdMap.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null && num.intValue() == i11) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    public float m() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.getMaxVelocity();
    }

    public boolean n() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.f11010b.mTouchResponse.d();
    }

    public float o(float f11, float f12) {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.e(f11, f12);
    }

    public int p() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.f11010b.mTouchResponse.getSpringBoundary();
    }

    public float q() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.getSpringDamping();
    }

    public float r() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.getSpringMass();
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public float s() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.getSpringStiffness();
    }

    public void setConstraintSet(int i11, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i11, constraintSet);
    }

    public void setDuration(int i11) {
        Transition transition = this.f11010b;
        if (transition != null) {
            transition.setDuration(i11);
        } else {
            this.mDefaultDuration = i11;
        }
    }

    public void setKeyframe(View view, int i11, String str, Object obj) {
        Transition transition = this.f11010b;
        if (transition != null) {
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
                while (it2.hasNext()) {
                    if (it2.next().f10871a == i11) {
                        if (obj != null) {
                            ((Float) obj).floatValue();
                        }
                        str.equalsIgnoreCase("app:PerpendicularPath_percent");
                    }
                }
            }
        }
    }

    public void setRtl(boolean z11) {
        this.mRtl = z11;
        Transition transition = this.f11010b;
        if (transition != null && transition.mTouchResponse != null) {
            this.f11010b.mTouchResponse.setRTL(this.mRtl);
        }
    }

    public void setTransition(Transition transition) {
        this.f11010b = transition;
        if (transition != null && transition.mTouchResponse != null) {
            this.f11010b.mTouchResponse.setRTL(this.mRtl);
        }
    }

    public float t() {
        Transition transition = this.f11010b;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.f11010b.mTouchResponse.getSpringStopThreshold();
    }

    public int u() {
        Transition transition = this.f11010b;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public boolean v(View view, int i11) {
        Transition transition = this.f11010b;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f10871a == i11) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.f10916b == this;
    }

    public void viewTransition(int i11, View... viewArr) {
        this.f11011c.j(i11, viewArr);
    }

    public void w(float f11, float f12) {
        Transition transition = this.f11010b;
        if (transition != null && transition.mTouchResponse != null) {
            this.f11010b.mTouchResponse.k(f11, f12);
        }
    }

    public void x(float f11, float f12) {
        Transition transition = this.f11010b;
        if (transition != null && transition.mTouchResponse != null) {
            this.f11010b.mTouchResponse.l(f11, f12);
        }
    }

    public void y(MotionEvent motionEvent, int i11, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.H();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i11 != -1) {
            int action = motionEvent.getAction();
            boolean z11 = false;
            if (action == 0) {
                this.f11012d = motionEvent.getRawX();
                this.f11013e = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.f11010b.mTouchResponse != null) {
                    RectF b11 = this.f11010b.mTouchResponse.b(this.mMotionLayout, rectF);
                    if (b11 == null || b11.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        RectF f11 = this.f11010b.mTouchResponse.f(this.mMotionLayout, rectF);
                        if (f11 == null || f11.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        this.f11010b.mTouchResponse.m(this.f11012d, this.f11013e);
                        return;
                    }
                    this.mLastTouchDown = null;
                    this.mIgnoreTouch = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.f11013e;
                float rawX = motionEvent.getRawX() - this.f11012d;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.mLastTouchDown) != null) {
                    Transition bestTransitionFor = bestTransitionFor(i11, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF f12 = this.f11010b.mTouchResponse.f(this.mMotionLayout, rectF);
                        if (f12 != null && !f12.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z11 = true;
                        }
                        this.mMotionOutsideRegion = z11;
                        this.f11010b.mTouchResponse.n(this.f11012d, this.f11013e);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.mIgnoreTouch) {
            Transition transition = this.f11010b;
            if (!(transition == null || transition.mTouchResponse == null || this.mMotionOutsideRegion)) {
                this.f11010b.mTouchResponse.i(motionEvent, this.mVelocityTracker, i11, this);
            }
            this.f11012d = motionEvent.getRawX();
            this.f11013e = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
                motionTracker.recycle();
                this.mVelocityTracker = null;
                int i12 = motionLayout.f10920f;
                if (i12 != -1) {
                    f(motionLayout, i12);
                }
            }
        }
    }

    public void z(MotionLayout motionLayout) {
        int i11 = 0;
        while (i11 < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i11);
            if (hasCycleDependency(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            } else {
                readConstraintChain(keyAt, motionLayout);
                i11++;
            }
        }
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        /* access modifiers changed from: private */
        public int mAutoTransition = 0;
        /* access modifiers changed from: private */
        public int mConstraintSetEnd = -1;
        /* access modifiers changed from: private */
        public int mConstraintSetStart = -1;
        /* access modifiers changed from: private */
        public int mDefaultInterpolator = 0;
        /* access modifiers changed from: private */
        public int mDefaultInterpolatorID = -1;
        /* access modifiers changed from: private */
        public String mDefaultInterpolatorString = null;
        /* access modifiers changed from: private */
        public boolean mDisable = false;
        /* access modifiers changed from: private */
        public int mDuration = 400;
        /* access modifiers changed from: private */
        public int mId = -1;
        /* access modifiers changed from: private */
        public boolean mIsAbstract = false;
        /* access modifiers changed from: private */
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        private int mLayoutDuringTransition = 0;
        /* access modifiers changed from: private */
        public final MotionScene mMotionScene;
        /* access modifiers changed from: private */
        public ArrayList<TransitionOnClick> mOnClicks = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mPathMotionArc = -1;
        /* access modifiers changed from: private */
        public float mStagger = 0.0f;
        /* access modifiers changed from: private */
        public TouchResponse mTouchResponse = null;
        private int mTransitionFlags = 0;

        public Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i12 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i13 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i13;
                    if (i13 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i11, int i12) {
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (it.hasNext()) {
                TransitionOnClick next = it.next();
                if (next.f11016b == i11) {
                    next.f11017c = i12;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i11, i12));
        }

        public String debugString(Context context) {
            String str;
            if (this.mConstraintSetStart == -1) {
                str = "null";
            } else {
                str = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return str + " -> null";
            }
            return str + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i11) {
            return (i11 & this.mTransitionFlags) != 0;
        }

        public void removeOnClick(int i11) {
            TransitionOnClick transitionOnClick;
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    transitionOnClick = null;
                    break;
                }
                transitionOnClick = it.next();
                if (transitionOnClick.f11016b == i11) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i11) {
            this.mAutoTransition = i11;
        }

        public void setDuration(int i11) {
            this.mDuration = Math.max(i11, 8);
        }

        public void setEnable(boolean z11) {
            setEnabled(z11);
        }

        public void setEnabled(boolean z11) {
            this.mDisable = !z11;
        }

        public void setInterpolatorInfo(int i11, String str, int i12) {
            this.mDefaultInterpolator = i11;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i12;
        }

        public void setLayoutDuringTransition(int i11) {
            this.mLayoutDuringTransition = i11;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            this.mTouchResponse = onSwipe == null ? null : new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
        }

        public void setOnTouchUp(int i11) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i11);
            }
        }

        public void setPathMotionArc(int i11) {
            this.mPathMotionArc = i11;
        }

        public void setStagger(float f11) {
            this.mStagger = f11;
        }

        public void setTransitionFlag(int i11) {
            this.mTransitionFlags = i11;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;

            /* renamed from: b  reason: collision with root package name */
            public int f11016b;

            /* renamed from: c  reason: collision with root package name */
            public int f11017c;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f11016b = -1;
                this.f11017c = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i11 = 0; i11 < indexCount; i11++) {
                    int index = obtainStyledAttributes.getIndex(i11);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f11016b = obtainStyledAttributes.getResourceId(index, this.f11016b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f11017c = obtainStyledAttributes.getInt(index, this.f11017c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public boolean a(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int a11 = transition2.mConstraintSetEnd;
                int c11 = this.mTransition.mConstraintSetStart;
                if (c11 != -1) {
                    int i11 = motionLayout.f10920f;
                    if (i11 == c11 || i11 == a11) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.f10920f != a11) {
                    return true;
                } else {
                    return false;
                }
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i11, Transition transition) {
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                int i12 = this.f11016b;
                View view = motionLayout;
                if (i12 != -1) {
                    view = motionLayout.findViewById(i12);
                }
                if (view == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.f11016b);
                    return;
                }
                int c11 = transition.mConstraintSetStart;
                int a11 = transition.mConstraintSetEnd;
                if (c11 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i13 = this.f11017c;
                boolean z15 = false;
                if ((i13 & 1) == 0 || i11 != c11) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if ((i13 & 256) == 0 || i11 != c11) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                boolean z16 = z11 | z12;
                if ((i13 & 1) == 0 || i11 != c11) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                boolean z17 = z13 | z16;
                if ((i13 & 16) == 0 || i11 != a11) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                boolean z18 = z17 | z14;
                if ((i13 & 4096) != 0 && i11 == a11) {
                    z15 = true;
                }
                if (z18 || z15) {
                    view.setOnClickListener(this);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
            /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r8 = r8.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.mMotionLayout
                    boolean r0 = r8.isInteractionEnabled()
                    if (r0 != 0) goto L_0x0011
                    return
                L_0x0011:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetStart
                    r1 = -1
                    if (r0 != r1) goto L_0x004a
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002a
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetEnd
                    r8.transitionToState(r0)
                    return
                L_0x002a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r2 = r2.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r7.mTransition
                    r1.<init>(r2, r3)
                    int unused = r1.mConstraintSetStart = r0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    int r0 = r0.mConstraintSetEnd
                    int unused = r1.mConstraintSetEnd = r0
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r1)
                    r8.transitionToEnd()
                    return
                L_0x004a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r0 = r0.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r0.f11010b
                    int r1 = r7.f11017c
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0061
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x005f
                    goto L_0x0061
                L_0x005f:
                    r2 = r3
                    goto L_0x0062
                L_0x0061:
                    r2 = r4
                L_0x0062:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006d
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006b
                    goto L_0x006d
                L_0x006b:
                    r1 = r3
                    goto L_0x006e
                L_0x006d:
                    r1 = r4
                L_0x006e:
                    if (r2 == 0) goto L_0x0074
                    if (r1 == 0) goto L_0x0074
                    r5 = r4
                    goto L_0x0075
                L_0x0074:
                    r5 = r3
                L_0x0075:
                    if (r5 == 0) goto L_0x009c
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r7.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r5 = r5.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r5.f11010b
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r7.mTransition
                    if (r5 == r6) goto L_0x0086
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r6)
                L_0x0086:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x009d
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x009b
                    goto L_0x009d
                L_0x009b:
                    r1 = r3
                L_0x009c:
                    r3 = r2
                L_0x009d:
                    boolean r0 = r7.a(r0, r8)
                    if (r0 == 0) goto L_0x00e8
                    if (r3 == 0) goto L_0x00b3
                    int r0 = r7.f11017c
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00b3
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToEnd()
                    goto L_0x00e8
                L_0x00b3:
                    if (r1 == 0) goto L_0x00c4
                    int r0 = r7.f11017c
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00c4
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToStart()
                    goto L_0x00e8
                L_0x00c4:
                    if (r3 == 0) goto L_0x00d7
                    int r0 = r7.f11017c
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d7
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 1065353216(0x3f800000, float:1.0)
                    r8.setProgress(r0)
                    goto L_0x00e8
                L_0x00d7:
                    if (r1 == 0) goto L_0x00e8
                    int r0 = r7.f11017c
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e8
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.mTransition
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 0
                    r8.setProgress(r0)
                L_0x00e8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick.onClick(android.view.View):void");
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i11 = this.f11016b;
                if (i11 != -1) {
                    View findViewById = motionLayout.findViewById(i11);
                    if (findViewById == null) {
                        Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.f11016b);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public TransitionOnClick(Transition transition, int i11, int i12) {
                this.mTransition = transition;
                this.f11016b = i11;
                this.f11017c = i12;
            }
        }

        public Transition(int i11, MotionScene motionScene, int i12, int i13) {
            this.mId = i11;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i12;
            this.mConstraintSetEnd = i13;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    /* access modifiers changed from: private */
    public int parseInclude(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name2 = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name2)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
            return -1;
        } catch (IOException e12) {
            e12.printStackTrace();
            return -1;
        }
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i11) {
        this.mMotionLayout = motionLayout;
        this.f11011c = new ViewTransitionController(motionLayout);
        load(context, i11);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i12 = R.id.motion_base;
        sparseArray.put(i12, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i12));
    }
}
