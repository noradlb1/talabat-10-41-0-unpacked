package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import org.jetbrains.annotations.NotNull;

public final class TypeAttributesKt {
    @NotNull
    public static final TypeAttributes replaceAnnotations(@NotNull TypeAttributes typeAttributes, @NotNull Annotations annotations) {
        TypeAttributes remove;
        Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(typeAttributes) == annotations) {
            return typeAttributes;
        }
        AnnotationsTypeAttribute annotationsAttribute = AnnotationsTypeAttributeKt.getAnnotationsAttribute(typeAttributes);
        if (!(annotationsAttribute == null || (remove = typeAttributes.remove(annotationsAttribute)) == null)) {
            typeAttributes = remove;
        }
        if (annotations.iterator().hasNext() || !annotations.isEmpty()) {
            return typeAttributes.plus(new AnnotationsTypeAttribute(annotations));
        }
        return typeAttributes;
    }

    @NotNull
    public static final TypeAttributes toDefaultAttributes(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, annotations, (TypeConstructor) null, (DeclarationDescriptor) null, 6, (Object) null);
    }
}
