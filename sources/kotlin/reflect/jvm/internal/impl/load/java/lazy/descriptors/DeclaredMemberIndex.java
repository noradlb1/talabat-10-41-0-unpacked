package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeclaredMemberIndex {

    public static final class Empty implements DeclaredMemberIndex {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Nullable
        public JavaField findFieldByName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return null;
        }

        @Nullable
        public JavaRecordComponent findRecordComponentByName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return null;
        }

        @NotNull
        public Set<Name> getFieldNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public Set<Name> getMethodNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public Set<Name> getRecordComponentNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public List<JavaMethod> findMethodsByName(@NotNull Name name2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @Nullable
    JavaField findFieldByName(@NotNull Name name2);

    @NotNull
    Collection<JavaMethod> findMethodsByName(@NotNull Name name2);

    @Nullable
    JavaRecordComponent findRecordComponentByName(@NotNull Name name2);

    @NotNull
    Set<Name> getFieldNames();

    @NotNull
    Set<Name> getMethodNames();

    @NotNull
    Set<Name> getRecordComponentNames();
}
