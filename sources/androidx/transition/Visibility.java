package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37828a = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        public DisappearListener(View view, int i11, boolean z11) {
            this.mView = view;
            this.mFinalVisibility = i11;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z11;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.f37828a) {
                ViewUtils.i(this.mView, this.mFinalVisibility);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z11) {
            ViewGroup viewGroup;
            if (this.mSuppressLayout && this.mLayoutSuppressed != z11 && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z11;
                ViewGroupUtils.c(viewGroup, z11);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f37828a = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f37828a) {
                ViewUtils.i(this.mView, this.mFinalVisibility);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f37828a) {
                ViewUtils.i(this.mView, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            suppressLayout(false);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            suppressLayout(true);
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37829a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37830b;

        /* renamed from: c  reason: collision with root package name */
        public int f37831c;

        /* renamed from: d  reason: collision with root package name */
        public int f37832d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f37833e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f37834f;
    }

    public Visibility() {
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f37829a = false;
        visibilityInfo.f37830b = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.f37831c = -1;
            visibilityInfo.f37833e = null;
        } else {
            visibilityInfo.f37831c = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.f37833e = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.f37832d = -1;
            visibilityInfo.f37834f = null;
        } else {
            visibilityInfo.f37832d = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.f37834f = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i11 = visibilityInfo.f37831c;
            int i12 = visibilityInfo.f37832d;
            if (i11 == i12 && visibilityInfo.f37833e == visibilityInfo.f37834f) {
                return visibilityInfo;
            }
            if (i11 != i12) {
                if (i11 == 0) {
                    visibilityInfo.f37830b = false;
                    visibilityInfo.f37829a = true;
                } else if (i12 == 0) {
                    visibilityInfo.f37830b = true;
                    visibilityInfo.f37829a = true;
                }
            } else if (visibilityInfo.f37834f == null) {
                visibilityInfo.f37830b = false;
                visibilityInfo.f37829a = true;
            } else if (visibilityInfo.f37833e == null) {
                visibilityInfo.f37830b = true;
                visibilityInfo.f37829a = true;
            }
        } else if (transitionValues == null && visibilityInfo.f37832d == 0) {
            visibilityInfo.f37830b = true;
            visibilityInfo.f37829a = true;
        } else if (transitionValues2 == null && visibilityInfo.f37831c == 0) {
            visibilityInfo.f37830b = false;
            visibilityInfo.f37829a = true;
        }
        return visibilityInfo;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f37829a) {
            return null;
        }
        if (visibilityChangeInfo.f37833e == null && visibilityChangeInfo.f37834f == null) {
            return null;
        }
        if (visibilityChangeInfo.f37830b) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.f37831c, transitionValues2, visibilityChangeInfo.f37832d);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.f37831c, transitionValues2, visibilityChangeInfo.f37832d);
    }

    public int getMode() {
        return this.mMode;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f37829a) {
            return false;
        }
        if (visibilityChangeInfo.f37831c == 0 || visibilityChangeInfo.f37832d == 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.values.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    @Nullable
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    @Nullable
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i11, TransitionValues transitionValues2, int i12) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f37829a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    @Nullable
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.mCanRemoveViews != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r18, androidx.transition.TransitionValues r19, int r20, androidx.transition.TransitionValues r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.mMode
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.view
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.view
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = r12
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = r11
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = r11
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r12
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.TransitionValues r14 = r0.getTransitionValues(r13, r12)
            androidx.transition.TransitionValues r15 = r0.getMatchedTransitionValues(r13, r12)
            androidx.transition.Visibility$VisibilityInfo r14 = r0.getVisibilityChangeInfo(r14, r15)
            boolean r14 = r14.f37829a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = androidx.transition.TransitionUtils.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.mCanRemoveViews
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = r11
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = r11
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.values
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            androidx.transition.ViewGroupOverlayImpl r4 = androidx.transition.ViewGroupUtils.b(r18)
            r4.add(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.onDisappear(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            androidx.transition.ViewGroupOverlayImpl r1 = androidx.transition.ViewGroupUtils.b(r18)
            r1.remove(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            androidx.transition.Visibility$1 r3 = new androidx.transition.Visibility$1
            r3.<init>(r1, r10, r5)
            r0.addListener(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            androidx.transition.ViewUtils.i(r8, r11)
            android.animation.Animator r1 = r0.onDisappear(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            androidx.transition.Visibility$DisappearListener r2 = new androidx.transition.Visibility$DisappearListener
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            androidx.transition.AnimatorUtils.a(r1, r2)
            r0.addListener(r2)
            goto L_0x0106
        L_0x0103:
            androidx.transition.ViewUtils.i(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void setMode(int i11) {
        if ((i11 & -4) == 0) {
            this.mMode = i11;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37784e);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }
}
