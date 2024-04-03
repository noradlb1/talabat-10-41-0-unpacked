package com.talabat.helpers;

import android.animation.Animator;
import androidx.annotation.NonNull;

public class AnimatorUtil {
    private AnimatorUtil() {
    }

    @NonNull
    public static Animator[] concatAnimators(@NonNull Animator[] animatorArr, @NonNull Animator animator) {
        int length = animatorArr.length + 1;
        Animator[] animatorArr2 = new Animator[length];
        int i11 = 0;
        for (Animator animator2 : animatorArr) {
            animatorArr2[i11] = animator2;
            i11++;
        }
        animatorArr2[length - 1] = animator;
        return animatorArr2;
    }
}
