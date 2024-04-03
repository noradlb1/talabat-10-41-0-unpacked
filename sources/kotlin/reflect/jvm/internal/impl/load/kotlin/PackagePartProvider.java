package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface PackagePartProvider {

    public static final class Empty implements PackagePartProvider {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @NotNull
        public List<String> findPackageParts(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "packageFqName");
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @NotNull
    List<String> findPackageParts(@NotNull String str);
}
