package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f11, float f12, float f13, float f14);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
