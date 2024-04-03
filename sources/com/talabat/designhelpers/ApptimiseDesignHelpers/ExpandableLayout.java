package com.talabat.designhelpers.ApptimiseDesignHelpers;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ExpandableLayout {
    public static final int DEFAULT_DURATION = 300;
    public static final boolean DEFAULT_EXPANDED = false;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    void collapse(long j11, @Nullable TimeInterpolator timeInterpolator);

    void expand();

    void expand(long j11, @Nullable TimeInterpolator timeInterpolator);

    boolean isExpanded();

    void setDuration(int i11);

    void setExpanded(boolean z11);

    void setInterpolator(@NonNull TimeInterpolator timeInterpolator);

    void setListener(@NonNull ExpandableLayoutListener expandableLayoutListener);

    void setNonCollapsible();

    void toggle();

    void toggle(long j11, @Nullable TimeInterpolator timeInterpolator);
}
