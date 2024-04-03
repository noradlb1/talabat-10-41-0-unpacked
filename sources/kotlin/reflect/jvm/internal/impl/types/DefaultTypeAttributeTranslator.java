package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DefaultTypeAttributeTranslator implements TypeAttributeTranslator {
    @NotNull
    public static final DefaultTypeAttributeTranslator INSTANCE = new DefaultTypeAttributeTranslator();

    private DefaultTypeAttributeTranslator() {
    }

    @NotNull
    public TypeAttributes toAttributes(@NotNull Annotations annotations, @Nullable TypeConstructor typeConstructor, @Nullable DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (annotations.isEmpty()) {
            return TypeAttributes.Companion.getEmpty();
        }
        return TypeAttributes.Companion.create(CollectionsKt__CollectionsJVMKt.listOf(new AnnotationsTypeAttribute(annotations)));
    }
}
