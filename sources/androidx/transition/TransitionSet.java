package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f37804b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37805c = false;
    private int mChangeFlags = 0;
    private boolean mPlayTogether = true;
    private ArrayList<Transition> mTransitions = new ArrayList<>();

    public static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public TransitionSet f37808a;

        public TransitionSetListener(TransitionSet transitionSet) {
            this.f37808a = transitionSet;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f37808a;
            int i11 = transitionSet.f37804b - 1;
            transitionSet.f37804b = i11;
            if (i11 == 0) {
                transitionSet.f37805c = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.f37808a;
            if (!transitionSet.f37805c) {
                transitionSet.start();
                this.f37808a.f37805c = true;
            }
        }
    }

    public TransitionSet() {
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.f37804b = this.mTransitions.size();
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j11 = this.mDuration;
        if (j11 >= 0) {
            transition.setDuration(j11);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).cancel();
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.f37812a.add(next);
                }
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).capturePropagationValues(transitionValues);
        }
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.f37812a.add(next);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            Transition transition = this.mTransitions.get(i11);
            if (startDelay > 0 && (this.mPlayTogether || i11 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z11) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).excludeTarget(view, z11);
        }
        return super.excludeTarget(view, z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ^ true ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i11) {
        if (i11 < 0 || i11 >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i11);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).pause(view);
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).resume(view);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (!this.mPlayTogether) {
            for (int i11 = 1; i11 < this.mTransitions.size(); i11++) {
                final Transition transition = this.mTransitions.get(i11);
                this.mTransitions.get(i11 - 1).addListener(new TransitionListenerAdapter() {
                    public void onTransitionEnd(@NonNull Transition transition) {
                        transition.runAnimators();
                        transition.removeListener(this);
                    }
                });
            }
            Transition transition2 = this.mTransitions.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    public void setCanRemoveViews(boolean z11) {
        super.setCanRemoveViews(z11);
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).setCanRemoveViews(z11);
        }
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).setEpicenterCallback(epicenterCallback);
        }
    }

    @NonNull
    public TransitionSet setOrdering(int i11) {
        if (i11 == 0) {
            this.mPlayTogether = true;
        } else if (i11 == 1) {
            this.mPlayTogether = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i11);
        }
        return this;
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
                this.mTransitions.get(i11).setPathMotion(pathMotion);
            }
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTransitions.get(i11).setPropagation(transitionPropagation);
        }
    }

    public String toString(String str) {
        String transition = super.toString(str);
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(transition);
            sb2.append(StringUtils.LF);
            sb2.append(this.mTransitions.get(i11).toString(str + "  "));
            transition = sb2.toString();
        }
        return transition;
    }

    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i11 = 0; i11 < size; i11++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i11).clone());
        }
        return transitionSet;
    }

    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @NonNull
    public TransitionSet setDuration(long j11) {
        ArrayList<Transition> arrayList;
        super.setDuration(j11);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mTransitions.get(i11).setDuration(j11);
            }
        }
        return this;
    }

    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mTransitions.get(i11).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet setStartDelay(long j11) {
        return (TransitionSet) super.setStartDelay(j11);
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z11) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).excludeTarget(str, z11);
        }
        return super.excludeTarget(str, z11);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @NonNull
    public TransitionSet removeTarget(@IdRes int i11) {
        for (int i12 = 0; i12 < this.mTransitions.size(); i12++) {
            this.mTransitions.get(i12).removeTarget(i11);
        }
        return (TransitionSet) super.removeTarget(i11);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37788i);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @NonNull
    public Transition excludeTarget(int i11, boolean z11) {
        for (int i12 = 0; i12 < this.mTransitions.size(); i12++) {
            this.mTransitions.get(i12).excludeTarget(i11, z11);
        }
        return super.excludeTarget(i11, z11);
    }

    @NonNull
    public TransitionSet addTarget(@IdRes int i11) {
        for (int i12 = 0; i12 < this.mTransitions.size(); i12++) {
            this.mTransitions.get(i12).addTarget(i11);
        }
        return (TransitionSet) super.addTarget(i11);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z11) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).excludeTarget(cls, z11);
        }
        return super.excludeTarget(cls, z11);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
