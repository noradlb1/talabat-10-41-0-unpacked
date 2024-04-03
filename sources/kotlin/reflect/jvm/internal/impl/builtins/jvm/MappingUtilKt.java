package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class MappingUtilKt {
    @NotNull
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        Intrinsics.checkNotNullParameter(classDescriptor, "from");
        Intrinsics.checkNotNullParameter(classDescriptor2, "to");
        classDescriptor.getDeclaredTypeParameters().size();
        classDescriptor2.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        Iterable<TypeParameterDescriptor> iterable = declaredTypeParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeConstructor : iterable) {
            arrayList.add(typeConstructor.getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        Iterable<TypeParameterDescriptor> iterable2 = declaredTypeParameters2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (TypeParameterDescriptor defaultType : iterable2) {
            SimpleType defaultType2 = defaultType.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType2, "it.defaultType");
            arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType2));
        }
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.zip(arrayList, arrayList2)), false, 2, (Object) null);
    }
}
