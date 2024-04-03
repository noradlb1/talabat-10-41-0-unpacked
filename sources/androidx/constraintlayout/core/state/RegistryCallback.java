package androidx.constraintlayout.core.state;

public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i11, int i12);

    void onNewMotionScene(String str);

    void onProgress(float f11);

    void setDrawDebug(int i11);

    void setLayoutInformationMode(int i11);
}
