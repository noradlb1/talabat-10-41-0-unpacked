package androidx.dynamicanimation.animation;

interface Force {
    float getAcceleration(float f11, float f12);

    boolean isAtEquilibrium(float f11, float f12);
}
