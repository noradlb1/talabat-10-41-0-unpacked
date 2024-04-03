package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float[] a(Path path, float f11) {
            return path.approximate(f11);
        }
    }

    private PathUtils() {
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f11) {
        float[] a11 = Api26Impl.a(path, f11);
        int length = a11.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 1; i11 < length; i11++) {
            int i12 = i11 * 3;
            int i13 = (i11 - 1) * 3;
            float f12 = a11[i12];
            float f13 = a11[i12 + 1];
            float f14 = a11[i12 + 2];
            float f15 = a11[i13];
            float f16 = a11[i13 + 1];
            float f17 = a11[i13 + 2];
            if (!(f12 == f15 || (f13 == f16 && f14 == f17))) {
                arrayList.add(new PathSegment(new PointF(f16, f17), f15, new PointF(f13, f14), f12));
            }
        }
        return arrayList;
    }
}
