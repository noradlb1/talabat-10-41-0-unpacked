package com.talabat.helpers;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAnimator {
    private static final int DEFAULT_ANIMATION_DELAY_MILLIS = 100;
    private static final int DEFAULT_ANIMATION_DURATION_MILLIS = 300;
    private static final int INITIAL_DELAY_MILLIS = 150;
    private int mAnimationDelayMillis = 100;
    private int mAnimationDurationMillis = 300;
    private long mAnimationStartMillis;
    @NonNull
    private final SparseArray<Animator> mAnimators = new SparseArray<>();
    private int mFirstAnimatedPosition;
    private int mInitialDelayMillis = 150;
    private int mLastAnimatedPosition;
    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mShouldAnimate = true;

    public ViewAnimator(@NonNull RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mAnimationStartMillis = -1;
        this.mFirstAnimatedPosition = -1;
        this.mLastAnimatedPosition = -1;
    }

    private void animateView(int i11, @NonNull View view, @NonNull Animator[] animatorArr) {
        if (this.mAnimationStartMillis == -1) {
            this.mAnimationStartMillis = SystemClock.uptimeMillis();
        }
        ViewCompat.setAlpha(view, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorArr);
        animatorSet.setStartDelay((long) calculateAnimationDelay(i11));
        animatorSet.setDuration((long) this.mAnimationDurationMillis);
        animatorSet.start();
        this.mAnimators.put(view.hashCode(), animatorSet);
    }

    @SuppressLint({"NewApi"})
    private int calculateAnimationDelay(int i11) {
        int i12;
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        int i13 = this.mLastAnimatedPosition;
        if (i13 > findLastCompletelyVisibleItemPosition) {
            findLastCompletelyVisibleItemPosition = i13;
        }
        int i14 = this.mFirstAnimatedPosition;
        if ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1 < (i11 - 1) - i14) {
            i12 = this.mAnimationDelayMillis;
            if (this.mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i12 += this.mAnimationDelayMillis * (i11 % ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).getSpanCount());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Delay[");
                sb2.append(i11);
                sb2.append("]=*");
                sb2.append(findLastCompletelyVisibleItemPosition);
                sb2.append("|");
                sb2.append(findFirstCompletelyVisibleItemPosition);
                sb2.append("|");
            }
        } else {
            i12 = Math.max(0, (int) ((-SystemClock.uptimeMillis()) + this.mAnimationStartMillis + ((long) this.mInitialDelayMillis) + ((long) ((i11 - i14) * this.mAnimationDelayMillis))));
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Delay[");
        sb3.append(i11);
        sb3.append("]=");
        sb3.append(i12);
        sb3.append("|");
        sb3.append(findLastCompletelyVisibleItemPosition);
        sb3.append("|");
        sb3.append(findFirstCompletelyVisibleItemPosition);
        sb3.append("|");
        return i12;
    }

    public void animateViewIfNecessary(int i11, @NonNull View view, @NonNull Animator[] animatorArr) {
        if (this.mShouldAnimate && i11 > this.mLastAnimatedPosition) {
            if (this.mFirstAnimatedPosition == -1) {
                this.mFirstAnimatedPosition = i11;
            }
            animateView(i11, view, animatorArr);
            this.mLastAnimatedPosition = i11;
        }
    }

    public void cancelExistingAnimation(@NonNull View view) {
        int hashCode = view.hashCode();
        Animator animator = this.mAnimators.get(hashCode);
        if (animator != null) {
            animator.end();
            this.mAnimators.remove(hashCode);
        }
    }

    public void disableAnimations() {
        this.mShouldAnimate = false;
    }

    public void enableAnimations() {
        this.mShouldAnimate = true;
    }
}
