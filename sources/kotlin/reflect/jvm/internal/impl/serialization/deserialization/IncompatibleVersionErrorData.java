package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    @NotNull
    private final ClassId classId;
    private final T expectedVersion;
    @NotNull
    private final String filePath;

    public IncompatibleVersionErrorData(T t11, T t12, @NotNull String str, @NotNull ClassId classId2) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(classId2, "classId");
        this.actualVersion = t11;
        this.expectedVersion = t12;
        this.filePath = str;
        this.classId = classId2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.actualVersion, (Object) incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual((Object) this.expectedVersion, (Object) incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual((Object) this.filePath, (Object) incompatibleVersionErrorData.filePath) && Intrinsics.areEqual((Object) this.classId, (Object) incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t11 = this.actualVersion;
        int i11 = 0;
        int hashCode = (t11 == null ? 0 : t11.hashCode()) * 31;
        T t12 = this.expectedVersion;
        if (t12 != null) {
            i11 = t12.hashCode();
        }
        return ((((hashCode + i11) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}
