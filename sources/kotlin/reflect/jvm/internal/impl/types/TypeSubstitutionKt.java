package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class TypeSubstitutionKt {
    @NotNull
    public static final SimpleType asSimpleType(@NotNull KotlinType kotlinType) {
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof SimpleType) {
            simpleType = (SimpleType) unwrap;
        } else {
            simpleType = null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(("This is should be simple type: " + kotlinType).toString());
    }

    @NotNull
    @JvmOverloads
    public static final KotlinType replace(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeProjection> list, @NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return replace$default(kotlinType, list, annotations, (List) null, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final KotlinType replace(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeProjection> list, @NotNull Annotations annotations, @NotNull List<? extends TypeProjection> list2) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == kotlinType.getArguments()) && annotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        TypeAttributes attributes = kotlinType.getAttributes();
        if ((annotations instanceof FilteredAnnotations) && annotations.isEmpty()) {
            annotations = Annotations.Companion.getEMPTY();
        }
        TypeAttributes replaceAnnotations = TypeAttributesKt.replaceAnnotations(attributes, annotations);
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return KotlinTypeFactory.flexibleType(replace(flexibleType.getLowerBound(), list, replaceAnnotations), replace(flexibleType.getUpperBound(), list2, replaceAnnotations));
        } else if (unwrap instanceof SimpleType) {
            return replace((SimpleType) unwrap, list, replaceAnnotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List<TypeProjection> list, Annotations annotations, List<TypeProjection> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i11 & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i11 & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List<TypeProjection> list, TypeAttributes typeAttributes, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i11 & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return replace(simpleType, (List<? extends TypeProjection>) list, typeAttributes);
    }

    @NotNull
    @JvmOverloads
    public static final SimpleType replace(@NotNull SimpleType simpleType, @NotNull List<? extends TypeProjection> list, @NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        if (list.isEmpty() && typeAttributes == simpleType.getAttributes()) {
            return simpleType;
        }
        if (list.isEmpty()) {
            return simpleType.replaceAttributes(typeAttributes);
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, simpleType.getConstructor(), (List) list, simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }
}
