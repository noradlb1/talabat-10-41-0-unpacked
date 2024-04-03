package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.huawei.hms.flutter.map.constants.Param;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() {
        public Path getPath(float f11, float f12, float f13, float f14) {
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f13, f14);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    private long mStartDelay = -1;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    public static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f37794a;

        /* renamed from: b  reason: collision with root package name */
        public String f37795b;

        /* renamed from: c  reason: collision with root package name */
        public TransitionValues f37796c;

        /* renamed from: d  reason: collision with root package name */
        public WindowIdImpl f37797d;

        /* renamed from: e  reason: collision with root package name */
        public Transition f37798e;

        public AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f37794a = view;
            this.f37795b = str;
            this.f37796c = transitionValues;
            this.f37797d = windowIdImpl;
            this.f37798e = transition;
        }
    }

    public static class ArrayListManager {
        private ArrayListManager() {
        }

        public static <T> ArrayList<T> a(ArrayList<T> arrayList, T t11) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t11)) {
                arrayList.add(t11);
            }
            return arrayList;
        }

        public static <T> ArrayList<T> b(ArrayList<T> arrayList, T t11) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t11);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    public Transition() {
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i11 = 0; i11 < arrayMap.size(); i11++) {
            TransitionValues valueAt = arrayMap.valueAt(i11);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i12 = 0; i12 < arrayMap2.size(); i12++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i12);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f37813a.put(view, transitionValues);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (transitionValuesMaps.f37814b.indexOfKey(id2) >= 0) {
                transitionValuesMaps.f37814b.put(id2, (Object) null);
            } else {
                transitionValuesMaps.f37814b.put(id2, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.f37816d.containsKey(transitionName)) {
                transitionValuesMaps.f37816d.put(transitionName, null);
            } else {
                transitionValuesMaps.f37816d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f37815c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = transitionValuesMaps.f37815c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        transitionValuesMaps.f37815c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                transitionValuesMaps.f37815c.put(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i11) {
        int i12 = iArr[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            if (iArr[i13] == i12) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z11) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i11 = 0;
                        while (i11 < size) {
                            if (!this.mTargetTypeExcludes.get(i11).isInstance(view)) {
                                i11++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z11) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.f37812a.add(this);
                        capturePropagationValues(transitionValues);
                        if (z11) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i12 = 0;
                                    while (i12 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i12).isInstance(view)) {
                                            i12++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                                    captureHierarchy(viewGroup.getChildAt(i13), z11);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i11, boolean z11) {
        if (i11 <= 0) {
            return arrayList;
        }
        if (z11) {
            return ArrayListManager.a(arrayList, Integer.valueOf(i11));
        }
        return ArrayListManager.b(arrayList, Integer.valueOf(i11));
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t11, boolean z11) {
        if (t11 == null) {
            return arrayList;
        }
        if (z11) {
            return ArrayListManager.a(arrayList, t11);
        }
        return ArrayListManager.b(arrayList, t11);
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z11) {
        if (cls == null) {
            return arrayList;
        }
        if (z11) {
            return ArrayListManager.a(arrayList, cls);
        }
        return ArrayListManager.b(arrayList, cls);
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z11) {
        if (view == null) {
            return arrayList;
        }
        if (z11) {
            return ArrayListManager.a(arrayList, view);
        }
        return ArrayListManager.b(arrayList, view);
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int i11) {
        return i11 >= 1 && i11 <= 4;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            View valueAt = sparseArray.valueAt(i11);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i11))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.view)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            View valueAt = longSparseArray.valueAt(i11);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i11))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i11 = 0; i11 < size; i11++) {
            View valueAt = arrayMap3.valueAt(i11);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i11))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) transitionValuesMaps.f37813a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) transitionValuesMaps2.f37813a);
        int i11 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i11 < iArr.length) {
                int i12 = iArr[i11];
                if (i12 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i12 == 2) {
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.f37816d, transitionValuesMaps2.f37816d);
                } else if (i12 == 3) {
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.f37814b, transitionValuesMaps2.f37814b);
                } else if (i12 == 4) {
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.f37815c, transitionValuesMaps2.f37815c);
                }
                i11++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i11] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i11] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i11] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i11] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i11);
                i11--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i11++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    Transition.this.mCurrentAnimators.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.mCurrentAnimators.add(animator);
                }
            });
            animate(animator);
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.mTargets.add(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((TransitionListener) arrayList2.get(i11)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.mPropagation != null && !transitionValues.values.isEmpty() && (propagationProperties = this.mPropagation.getPropagationProperties()) != null) {
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= propagationProperties.length) {
                    z11 = true;
                    break;
                } else if (!transitionValues.values.containsKey(propagationProperties[i11])) {
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                this.mPropagation.captureValues(transitionValues);
            }
        }
    }

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    public void captureValues(ViewGroup viewGroup, boolean z11) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z11);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i11 = 0; i11 < this.mTargetIds.size(); i11++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i11).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z11) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f37812a.add(this);
                    capturePropagationValues(transitionValues);
                    if (z11) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i12 = 0; i12 < this.mTargets.size(); i12++) {
                View view = this.mTargets.get(i12);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z11) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.f37812a.add(this);
                capturePropagationValues(transitionValues2);
                if (z11) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z11);
        }
        if (!z11 && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i13 = 0; i13 < size; i13++) {
                arrayList3.add(this.mStartValues.f37816d.remove(this.mNameOverrides.keyAt(i13)));
            }
            for (int i14 = 0; i14 < size; i14++) {
                View view2 = (View) arrayList3.get(i14);
                if (view2 != null) {
                    this.mStartValues.f37816d.put(this.mNameOverrides.valueAt(i14), view2);
                }
            }
        }
    }

    public void clearValues(boolean z11) {
        if (z11) {
            this.mStartValues.f37813a.clear();
            this.mStartValues.f37814b.clear();
            this.mStartValues.f37815c.clear();
            return;
        }
        this.mEndValues.f37813a.clear();
        this.mEndValues.f37814b.clear();
        this.mEndValues.f37815c.clear();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i11;
        boolean z11;
        Animator createAnimator;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j11 = Long.MAX_VALUE;
        int i12 = 0;
        while (i12 < size) {
            TransitionValues transitionValues3 = arrayList.get(i12);
            TransitionValues transitionValues4 = arrayList2.get(i12);
            if (transitionValues3 != null && !transitionValues3.f37812a.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f37812a.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null)) {
                if (transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (createAnimator = createAnimator(viewGroup2, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            Animator animator3 = createAnimator;
                            i11 = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.f37813a.get(view);
                            if (transitionValues5 != null) {
                                int i13 = 0;
                                while (i13 < transitionProperties.length) {
                                    Map<String, Object> map = transitionValues2.values;
                                    String str = transitionProperties[i13];
                                    map.put(str, transitionValues5.values.get(str));
                                    i13++;
                                    ArrayList<TransitionValues> arrayList3 = arrayList2;
                                    transitionProperties = transitionProperties;
                                }
                            }
                            int size2 = runningAnimators.size();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i14));
                                if (animationInfo.f37796c != null && animationInfo.f37794a == view && animationInfo.f37795b.equals(getName()) && animationInfo.f37796c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i14++;
                            }
                        } else {
                            i11 = size;
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i11 = size;
                        view = transitionValues3.view;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.mPropagation;
                        if (transitionPropagation != null) {
                            long startDelay = transitionPropagation.getStartDelay(viewGroup2, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                            j11 = Math.min(startDelay, j11);
                        }
                        runningAnimators.put(animator, new AnimationInfo(view, getName(), this, ViewUtils.d(viewGroup), transitionValues));
                        this.mAnimators.add(animator);
                        j11 = j11;
                    }
                    i12++;
                    size = i11;
                }
            }
            i11 = size;
            i12++;
            size = i11;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i15));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i15)) - j11) + animator4.getStartDelay());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int i11 = this.mNumInstances - 1;
        this.mNumInstances = i11;
        if (i11 == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i12 = 0; i12 < size; i12++) {
                    ((TransitionListener) arrayList2.get(i12)).onTransitionEnd(this);
                }
            }
            for (int i13 = 0; i13 < this.mStartValues.f37815c.size(); i13++) {
                View valueAt = this.mStartValues.f37815c.valueAt(i13);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i14 = 0; i14 < this.mEndValues.f37815c.size(); i14++) {
                View valueAt2 = this.mEndValues.f37815c.valueAt(i14);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z11) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z11) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z11);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            WindowIdImpl d11 = ViewUtils.d(viewGroup);
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) runningAnimators);
            runningAnimators.clear();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(i11);
                if (!(animationInfo.f37794a == null || d11 == null || !d11.equals(animationInfo.f37797d))) {
                    ((Animator) arrayMap.keyAt(i11)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionValues getMatchedTransitionValues(View view, boolean z11) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z11);
        }
        if (z11) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i11);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            return null;
        }
        if (z11) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i11);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z11) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z11);
        }
        if (z11) {
            transitionValuesMaps = this.mStartValues;
        } else {
            transitionValuesMaps = this.mEndValues;
        }
        return transitionValuesMaps.f37813a.get(view);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i11 = 0;
            while (i11 < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i11])) {
                    i11++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.values.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (this.mTargetTypeExcludes.get(i11).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id2)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i12 = 0; i12 < this.mTargetTypes.size(); i12++) {
                if (this.mTargetTypes.get(i12).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        if (!this.mEnded) {
            for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                AnimatorUtils.b(this.mCurrentAnimators.get(size));
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((TransitionListener) arrayList2.get(i11)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        boolean z11;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl d11 = ViewUtils.d(viewGroup);
        for (int i11 = size - 1; i11 >= 0; i11--) {
            Animator keyAt = runningAnimators.keyAt(i11);
            if (!(keyAt == null || (animationInfo = runningAnimators.get(keyAt)) == null || animationInfo.f37794a == null || !d11.equals(animationInfo.f37797d))) {
                TransitionValues transitionValues = animationInfo.f37796c;
                View view = animationInfo.f37794a;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues2 == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f37813a.get(view);
                }
                if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.f37798e.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.mTargets.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                    AnimatorUtils.c(this.mCurrentAnimators.get(size));
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((TransitionListener) arrayList2.get(i11)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z11) {
        this.mCanRemoveViews = z11;
    }

    @NonNull
    public Transition setDuration(long j11) {
        this.mDuration = j11;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i11 = 0;
        while (i11 < iArr.length) {
            if (!isValidMatch(iArr[i11])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i11)) {
                i11++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    @NonNull
    public Transition setStartDelay(long j11) {
        this.mStartDelay = j11;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((TransitionListener) arrayList2.get(i11)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i11) {
        if (i11 != 0) {
            this.mTargetIds.add(Integer.valueOf(i11));
        }
        return this;
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i11, boolean z11) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i11, z11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i11, boolean z11) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i11, z11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i11) {
        if (i11 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i11));
        }
        return this;
    }

    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i11 = 0; i11 < this.mTargetIds.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                str3 = str3 + this.mTargetIds.get(i11);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i12 = 0; i12 < this.mTargets.size(); i12++) {
                if (i12 > 0) {
                    str3 = str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                str3 = str3 + this.mTargets.get(i12);
            }
        }
        return str3 + ")";
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z11) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z11);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z11) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z11) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z11);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37782c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, Param.INTERPOLATOR, 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
