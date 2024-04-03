package androidx.constraintlayout.core.motion.utils;

public interface StopEngine {
    String debug(String str, float f11);

    float getInterpolation(float f11);

    float getVelocity();

    float getVelocity(float f11);

    boolean isStopped();
}
