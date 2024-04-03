package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(@NonNull PointF pointF, float f11, @NonNull PointF pointF2, float f12) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f11;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.mStartFraction, pathSegment.mStartFraction) != 0 || Float.compare(this.mEndFraction, pathSegment.mEndFraction) != 0 || !this.mStart.equals(pathSegment.mStart) || !this.mEnd.equals(pathSegment.mEnd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.mStart.hashCode() * 31;
        float f11 = this.mStartFraction;
        int i12 = 0;
        if (f11 != 0.0f) {
            i11 = Float.floatToIntBits(f11);
        } else {
            i11 = 0;
        }
        int hashCode2 = (((hashCode + i11) * 31) + this.mEnd.hashCode()) * 31;
        float f12 = this.mEndFraction;
        if (f12 != 0.0f) {
            i12 = Float.floatToIntBits(f12);
        }
        return hashCode2 + i12;
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + AbstractJsonLexerKt.END_OBJ;
    }
}
