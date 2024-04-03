package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    @NotNull
    public static final TypeMappingConfigurationImpl INSTANCE = new TypeMappingConfigurationImpl();

    private TypeMappingConfigurationImpl() {
    }

    @NotNull
    public KotlinType commonSupertype(@NotNull Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt___CollectionsKt.joinToString$default(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
    }

    @Nullable
    public String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        return TypeMappingConfiguration.DefaultImpls.getPredefinedFullInternalNameForClass(this, classDescriptor);
    }

    @Nullable
    public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    @Nullable
    public JvmType getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    @Nullable
    public KotlinType preprocessType(@NotNull KotlinType kotlinType) {
        return TypeMappingConfiguration.DefaultImpls.preprocessType(this, kotlinType);
    }

    public void processErrorType(@NotNull KotlinType kotlinType, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
    }
}
