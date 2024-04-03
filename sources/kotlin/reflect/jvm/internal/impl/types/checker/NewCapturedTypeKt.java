package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedTypeKt {
    private static final List<TypeProjection> captureArguments(UnwrappedType unwrappedType, CaptureStatus captureStatus) {
        UnwrappedType unwrappedType2;
        boolean z11;
        if (unwrappedType.getArguments().size() != unwrappedType.getConstructor().getParameters().size()) {
            return null;
        }
        List<TypeProjection> arguments = unwrappedType.getArguments();
        Iterable iterable = arguments;
        boolean z12 = true;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TypeProjection) it.next()).getProjectionKind() == Variance.INVARIANT) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (!z11) {
                        z12 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z12) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = unwrappedType.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
        Iterable<Pair> zip = CollectionsKt___CollectionsKt.zip(iterable, parameters);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            TypeProjection typeProjection = (TypeProjection) pair.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                if (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) {
                    unwrappedType2 = null;
                } else {
                    unwrappedType2 = typeProjection.getType().unwrap();
                }
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrappedType2, typeProjection, typeParameterDescriptor));
            }
            arrayList.add(typeProjection);
        }
        TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), arrayList).buildSubstitutor();
        int size = arguments.size();
        for (int i11 = 0; i11 < size; i11++) {
            TypeProjection typeProjection2 = arguments.get(i11);
            TypeProjection typeProjection3 = (TypeProjection) arrayList.get(i11);
            if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                List<KotlinType> upperBounds = unwrappedType.getConstructor().getParameters().get(i11).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "type.constructor.parameters[index].upperBounds");
                ArrayList arrayList2 = new ArrayList();
                for (KotlinType safeSubstitute : upperBounds) {
                    arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) buildSubstitutor.safeSubstitute(safeSubstitute, Variance.INVARIANT).unwrap()));
                }
                if (!typeProjection2.isStarProjection() && typeProjection2.getProjectionKind() == Variance.OUT_VARIANCE) {
                    arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) typeProjection2.getType().unwrap()));
                }
                KotlinType type = typeProjection3.getType();
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                ((NewCapturedType) type).getConstructor().initializeSupertypes(arrayList2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final SimpleType captureFromArguments(@NotNull SimpleType simpleType, @NotNull CaptureStatus captureStatus) {
        Intrinsics.checkNotNullParameter(simpleType, "type");
        Intrinsics.checkNotNullParameter(captureStatus, "status");
        List<TypeProjection> captureArguments = captureArguments(simpleType, captureStatus);
        if (captureArguments != null) {
            return replaceArguments(simpleType, captureArguments);
        }
        return null;
    }

    private static final SimpleType replaceArguments(UnwrappedType unwrappedType, List<? extends TypeProjection> list) {
        return KotlinTypeFactory.simpleType$default(unwrappedType.getAttributes(), unwrappedType.getConstructor(), (List) list, unwrappedType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }
}
