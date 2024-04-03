package androidx.core.widget;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface AutoSizeableTextView {
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = (Build.VERSION.SDK_INT >= 27);

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i11, int i12, int i13, int i14) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i11) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i11);
}
