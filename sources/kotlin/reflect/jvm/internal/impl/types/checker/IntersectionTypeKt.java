package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class IntersectionTypeKt {
    @NotNull
    public static final UnwrappedType intersectTypes(@NotNull List<? extends UnwrappedType> list) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        } else if (size == 1) {
            return (UnwrappedType) CollectionsKt___CollectionsKt.single(list);
        } else {
            Iterable<UnwrappedType> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            boolean z11 = false;
            boolean z12 = false;
            for (UnwrappedType unwrappedType : iterable) {
                if (z11 || KotlinTypeKt.isError(unwrappedType)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (unwrappedType instanceof SimpleType) {
                    simpleType = (SimpleType) unwrappedType;
                } else if (!(unwrappedType instanceof FlexibleType)) {
                    throw new NoWhenBranchMatchedException();
                } else if (DynamicTypesKt.isDynamic(unwrappedType)) {
                    return unwrappedType;
                } else {
                    simpleType = ((FlexibleType) unwrappedType).getLowerBound();
                    z12 = true;
                }
                arrayList.add(simpleType);
            }
            if (z11) {
                return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, list.toString());
            } else if (!z12) {
                return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (UnwrappedType upperIfFlexible : iterable) {
                    arrayList2.add(FlexibleTypesKt.upperIfFlexible(upperIfFlexible));
                }
                TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                return KotlinTypeFactory.flexibleType(typeIntersector.intersectTypes$descriptors(arrayList), typeIntersector.intersectTypes$descriptors(arrayList2));
            }
        }
    }
}
