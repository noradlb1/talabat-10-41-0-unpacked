package androidx.constraintlayout.motion.widget;

interface ProxyInterface {
    int designAccess(int i11, String str, Object obj, float[] fArr, int i12, float[] fArr2, int i13);

    float getKeyFramePosition(Object obj, int i11, float f11, float f12);

    Object getKeyframeAtLocation(Object obj, float f11, float f12);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f11, float f12, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i11, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i11, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i11, int i12, float f11, float f12);

    void setToolPosition(float f11);
}
