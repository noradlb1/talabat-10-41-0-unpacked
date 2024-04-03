package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";

    /* renamed from: f  reason: collision with root package name */
    public float f10888f;

    /* renamed from: g  reason: collision with root package name */
    public int f10889g;

    /* renamed from: h  reason: collision with root package name */
    public int f10890h;

    /* renamed from: i  reason: collision with root package name */
    public int f10891i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f10892j;

    /* renamed from: k  reason: collision with root package name */
    public RectF f10893k;

    /* renamed from: l  reason: collision with root package name */
    public HashMap<String, Method> f10894l;
    /* access modifiers changed from: private */
    public String mCross = null;
    private int mCurveFit = -1;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    /* access modifiers changed from: private */
    public float mFireThreshold;
    /* access modifiers changed from: private */
    public String mNegativeCross;
    /* access modifiers changed from: private */
    public String mPositiveCross;
    /* access modifiers changed from: private */
    public boolean mPostLayout;
    /* access modifiers changed from: private */
    public int mTriggerCollisionId;
    private View mTriggerCollisionView;
    /* access modifiers changed from: private */
    public int mTriggerID;
    /* access modifiers changed from: private */
    public int mTriggerReceiver;

    public static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static final int VT_CROSS = 12;
        private static final int VT_NEGATIVE_CROSS = 13;
        private static final int VT_POSITIVE_CROSS = 14;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        private Loader() {
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (mAttrMap.get(index)) {
                    case 1:
                        String unused = keyTrigger.mNegativeCross = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = keyTrigger.mPositiveCross = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = keyTrigger.mCross = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.f10888f = typedArray.getFloat(index, keyTrigger.f10888f);
                        break;
                    case 6:
                        int unused4 = keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        break;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.f10872b = typedArray.getResourceId(index, keyTrigger.f10872b);
                                break;
                            } else {
                                keyTrigger.f10873c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.f10872b);
                            keyTrigger.f10872b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTrigger.f10873c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.f10871a);
                        keyTrigger.f10871a = integer;
                        float unused5 = keyTrigger.mFireThreshold = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        break;
                    case 10:
                        boolean unused7 = keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        break;
                    case 11:
                        int unused8 = keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                    case 12:
                        keyTrigger.f10891i = typedArray.getResourceId(index, keyTrigger.f10891i);
                        break;
                    case 13:
                        keyTrigger.f10889g = typedArray.getResourceId(index, keyTrigger.f10889g);
                        break;
                    case 14:
                        keyTrigger.f10890h = typedArray.getResourceId(index, keyTrigger.f10890h);
                        break;
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        int i11 = Key.UNSET;
        this.mTriggerReceiver = i11;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i11;
        this.mTriggerCollisionId = i11;
        this.mTriggerCollisionView = null;
        this.f10888f = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.f10889g = i11;
        this.f10890h = i11;
        this.f10891i = i11;
        this.f10892j = new RectF();
        this.f10893k = new RectF();
        this.f10894l = new HashMap<>();
        this.f10874d = 5;
        this.f10875e = new HashMap<>();
    }

    private void fire(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                fireCustom(str, view);
                return;
            }
            if (this.f10894l.containsKey(str)) {
                method = this.f10894l.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.f10894l.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.f10894l.put(str, (Object) null);
                    Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
    }

    private void fireCustom(String str, View view) {
        boolean z11;
        ConstraintAttribute constraintAttribute;
        if (str.length() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.f10875e.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z11 || lowerCase.matches(str)) && (constraintAttribute = this.f10875e.get(next)) != null) {
                constraintAttribute.applyCustom(view);
            }
        }
    }

    private void setUpRect(RectF rectF, View view, boolean z11) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z11) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.mTriggerCollisionId
            int r1 = androidx.constraintlayout.motion.widget.Key.UNSET
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.mTriggerCollisionView
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.mTriggerCollisionId
            android.view.View r0 = r0.findViewById(r1)
            r9.mTriggerCollisionView = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.f10892j
            android.view.View r1 = r9.mTriggerCollisionView
            boolean r4 = r9.mPostLayout
            r9.setUpRect(r0, r1, r4)
            android.graphics.RectF r0 = r9.f10893k
            boolean r1 = r9.mPostLayout
            r9.setUpRect(r0, r11, r1)
            android.graphics.RectF r0 = r9.f10892j
            android.graphics.RectF r1 = r9.f10893k
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.mFireCrossReset
            if (r0 == 0) goto L_0x003c
            r9.mFireCrossReset = r3
            r0 = r2
            goto L_0x003d
        L_0x003c:
            r0 = r3
        L_0x003d:
            boolean r1 = r9.mFirePositiveReset
            if (r1 == 0) goto L_0x0045
            r9.mFirePositiveReset = r3
            r1 = r2
            goto L_0x0046
        L_0x0045:
            r1 = r3
        L_0x0046:
            r9.mFireNegativeReset = r2
            r4 = r1
            r1 = r3
            goto L_0x00e0
        L_0x004c:
            boolean r0 = r9.mFireCrossReset
            if (r0 != 0) goto L_0x0054
            r9.mFireCrossReset = r2
            r0 = r2
            goto L_0x0055
        L_0x0054:
            r0 = r3
        L_0x0055:
            boolean r1 = r9.mFireNegativeReset
            if (r1 == 0) goto L_0x005d
            r9.mFireNegativeReset = r3
            r1 = r2
            goto L_0x005e
        L_0x005d:
            r1 = r3
        L_0x005e:
            r9.mFirePositiveReset = r2
            goto L_0x00df
        L_0x0062:
            boolean r0 = r9.mFireCrossReset
            r1 = 0
            if (r0 == 0) goto L_0x0077
            float r0 = r9.mFireThreshold
            float r4 = r10 - r0
            float r5 = r9.mFireLastPos
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0087
            r9.mFireCrossReset = r3
            r0 = r2
            goto L_0x0088
        L_0x0077:
            float r0 = r9.mFireThreshold
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.f10888f
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r9.mFireCrossReset = r2
        L_0x0087:
            r0 = r3
        L_0x0088:
            boolean r4 = r9.mFireNegativeReset
            if (r4 == 0) goto L_0x00a0
            float r4 = r9.mFireThreshold
            float r5 = r10 - r4
            float r6 = r9.mFireLastPos
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            r9.mFireNegativeReset = r3
            r4 = r2
            goto L_0x00b1
        L_0x00a0:
            float r4 = r9.mFireThreshold
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.f10888f
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b0
            r9.mFireNegativeReset = r2
        L_0x00b0:
            r4 = r3
        L_0x00b1:
            boolean r5 = r9.mFirePositiveReset
            if (r5 == 0) goto L_0x00ce
            float r5 = r9.mFireThreshold
            float r6 = r10 - r5
            float r7 = r9.mFireLastPos
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00c9
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c9
            r9.mFirePositiveReset = r3
            r1 = r2
            goto L_0x00ca
        L_0x00c9:
            r1 = r3
        L_0x00ca:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x00e0
        L_0x00ce:
            float r1 = r9.mFireThreshold
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.f10888f
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00de
            r9.mFirePositiveReset = r2
        L_0x00de:
            r1 = r4
        L_0x00df:
            r4 = r3
        L_0x00e0:
            r9.mFireLastPos = r10
            if (r1 != 0) goto L_0x00e8
            if (r0 != 0) goto L_0x00e8
            if (r4 == 0) goto L_0x00f3
        L_0x00e8:
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.mTriggerID
            r5.fireTrigger(r6, r4, r10)
        L_0x00f3:
            int r10 = r9.mTriggerReceiver
            int r5 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r10 != r5) goto L_0x00fb
            r10 = r11
            goto L_0x0107
        L_0x00fb:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r5 = r9.mTriggerReceiver
            android.view.View r10 = r10.findViewById(r5)
        L_0x0107:
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = r9.mNegativeCross
            if (r1 == 0) goto L_0x0110
            r9.fire(r1, r10)
        L_0x0110:
            int r1 = r9.f10889g
            int r5 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r5) goto L_0x0125
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r5 = r9.f10889g
            android.view.View[] r6 = new android.view.View[r2]
            r6[r3] = r10
            r1.viewTransition(r5, r6)
        L_0x0125:
            if (r4 == 0) goto L_0x0143
            java.lang.String r1 = r9.mPositiveCross
            if (r1 == 0) goto L_0x012e
            r9.fire(r1, r10)
        L_0x012e:
            int r1 = r9.f10890h
            int r4 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r4) goto L_0x0143
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r4 = r9.f10890h
            android.view.View[] r5 = new android.view.View[r2]
            r5[r3] = r10
            r1.viewTransition(r4, r5)
        L_0x0143:
            if (r0 == 0) goto L_0x0161
            java.lang.String r0 = r9.mCross
            if (r0 == 0) goto L_0x014c
            r9.fire(r0, r10)
        L_0x014c:
            int r0 = r9.f10891i
            int r1 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r0 == r1) goto L_0x0161
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.f10891i
            android.view.View[] r1 = new android.view.View[r2]
            r1[r3] = r10
            r11.viewTransition(r0, r1)
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    public Key copy(Key key) {
        super.copy(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.mCurveFit = keyTrigger.mCurveFit;
        this.mCross = keyTrigger.mCross;
        this.mTriggerReceiver = keyTrigger.mTriggerReceiver;
        this.mNegativeCross = keyTrigger.mNegativeCross;
        this.mPositiveCross = keyTrigger.mPositiveCross;
        this.mTriggerID = keyTrigger.mTriggerID;
        this.mTriggerCollisionId = keyTrigger.mTriggerCollisionId;
        this.mTriggerCollisionView = keyTrigger.mTriggerCollisionView;
        this.f10888f = keyTrigger.f10888f;
        this.mFireCrossReset = keyTrigger.mFireCrossReset;
        this.mFireNegativeReset = keyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = keyTrigger.mFirePositiveReset;
        this.mFireThreshold = keyTrigger.mFireThreshold;
        this.mFireLastPos = keyTrigger.mFireLastPos;
        this.mPostLayout = keyTrigger.mPostLayout;
        this.f10892j = keyTrigger.f10892j;
        this.f10893k = keyTrigger.f10893k;
        this.f10894l = keyTrigger.f10894l;
        return this;
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    public void setValue(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    c11 = 0;
                    break;
                }
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    c11 = 1;
                    break;
                }
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    c11 = 2;
                    break;
                }
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    c11 = 3;
                    break;
                }
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    c11 = 4;
                    break;
                }
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    c11 = 5;
                    break;
                }
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    c11 = 6;
                    break;
                }
                break;
            case 64397344:
                if (str.equals("CROSS")) {
                    c11 = 7;
                    break;
                }
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    c11 = 9;
                    break;
                }
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.mPositiveCross = obj.toString();
                return;
            case 1:
                this.f10890h = d(obj);
                return;
            case 2:
                this.mTriggerCollisionId = d(obj);
                return;
            case 3:
                this.mTriggerID = d(obj);
                return;
            case 4:
                this.mNegativeCross = obj.toString();
                return;
            case 5:
                this.mTriggerCollisionView = (View) obj;
                return;
            case 6:
                this.f10889g = d(obj);
                return;
            case 7:
                this.mCross = obj.toString();
                return;
            case 8:
                this.f10888f = c(obj);
                return;
            case 9:
                this.f10891i = d(obj);
                return;
            case 10:
                this.mPostLayout = b(obj);
                return;
            case 11:
                this.mTriggerReceiver = d(obj);
                return;
            default:
                return;
        }
    }

    public Key clone() {
        return new KeyTrigger().copy(this);
    }
}
