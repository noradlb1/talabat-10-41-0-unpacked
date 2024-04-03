package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface AdditionalClassPartsProvider {

    public static final class None implements AdditionalClassPartsProvider {
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
        }

        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @NotNull
        public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name2, @NotNull ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @NotNull
        public Collection<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @NotNull
        public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name2, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor);
}
