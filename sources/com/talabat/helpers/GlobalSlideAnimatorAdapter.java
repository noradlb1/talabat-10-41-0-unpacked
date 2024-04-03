package com.talabat.helpers;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class GlobalSlideAnimatorAdapter<T extends RecyclerView.ViewHolder> extends AnimatorAdapter<T> {
    private static final String TRANSLATION_X = "translationX";
    private static final String TRANSLATION_Y = "translationY";
    private int animationDirection;

    public GlobalSlideAnimatorAdapter(RecyclerView.Adapter<T> adapter, RecyclerView recyclerView) {
        super(adapter, recyclerView);
    }

    @NonNull
    public Animator[] getAnimators(@NonNull View view) {
        Animator[] animatorArr;
        int i11 = this.animationDirection;
        if (i11 == 0) {
            animatorArr = new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) this.f60774i.getLayoutManager().getWidth(), 0.0f})};
        } else if (i11 == 1) {
            animatorArr = new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) (0 - this.f60774i.getLayoutManager().getWidth()), 0.0f})};
        } else if (i11 == 2) {
            animatorArr = new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (this.f60774i.getMeasuredHeight() >> 1), 0.0f})};
        } else if (i11 == 3) {
            animatorArr = new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{((float) this.f60774i.getHeight()) - ((float) this.f60774i.getLayoutManager().getDecoratedTop(view)), 0.0f})};
        } else if (i11 != 4) {
            return null;
        } else {
            return new Animator[0];
        }
        return animatorArr;
    }

    public void setAnimationDirection(int i11) {
        this.animationDirection = i11;
    }
}
