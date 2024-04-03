package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaClassFinder {

    public static final class DefaultImpls {
        public static /* synthetic */ JavaPackage findPackage$default(JavaClassFinder javaClassFinder, FqName fqName, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = true;
                }
                return javaClassFinder.findPackage(fqName, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
        }
    }

    @Nullable
    JavaClass findClass(@NotNull Request request);

    @Nullable
    JavaPackage findPackage(@NotNull FqName fqName, boolean z11);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull FqName fqName);

    public static final class Request {
        @NotNull
        private final ClassId classId;
        @Nullable
        private final JavaClass outerClass;
        @Nullable
        private final byte[] previouslyFoundClassFileContent;

        public Request(@NotNull ClassId classId2, @Nullable byte[] bArr, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            this.classId = classId2;
            this.previouslyFoundClassFileContent = bArr;
            this.outerClass = javaClass;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.classId, (Object) request.classId) && Intrinsics.areEqual((Object) this.previouslyFoundClassFileContent, (Object) request.previouslyFoundClassFileContent) && Intrinsics.areEqual((Object) this.outerClass, (Object) request.outerClass);
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            int hashCode = this.classId.hashCode() * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int i11 = 0;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.outerClass;
            if (javaClass != null) {
                i11 = javaClass.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Request(ClassId classId2, byte[] bArr, JavaClass javaClass, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId2, (i11 & 2) != 0 ? null : bArr, (i11 & 4) != 0 ? null : javaClass);
        }
    }
}
