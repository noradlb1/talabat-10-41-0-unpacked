package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.NonNull;

class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    private AnimatorUtils() {
    }

    public static void a(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void b(@NonNull Animator animator) {
        animator.pause();
    }

    public static void c(@NonNull Animator animator) {
        animator.resume();
    }
}
