package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassLiteralValue {
    private final int arrayNestedness;
    @NotNull
    private final ClassId classId;

    public ClassLiteralValue(@NotNull ClassId classId2, int i11) {
        Intrinsics.checkNotNullParameter(classId2, "classId");
        this.classId = classId2;
        this.arrayNestedness = i11;
    }

    @NotNull
    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) classLiteralValue.classId) && this.arrayNestedness == classLiteralValue.arrayNestedness;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i11 = this.arrayNestedness;
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("kotlin/Array<");
        }
        sb2.append(this.classId);
        int i13 = this.arrayNestedness;
        for (int i14 = 0; i14 < i13; i14++) {
            sb2.append(">");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
