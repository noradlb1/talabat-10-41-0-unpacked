package kotlin.reflect.jvm.internal.impl.types;

public abstract class TypeProjectionBase implements TypeProjection {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeProjection)) {
            return false;
        }
        TypeProjection typeProjection = (TypeProjection) obj;
        if (isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int hashCode = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType())) {
            return (hashCode * 31) + 19;
        }
        int i12 = hashCode * 31;
        if (isStarProjection()) {
            i11 = 17;
        } else {
            i11 = getType().hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        if (isStarProjection()) {
            return "*";
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
