package kotlin.reflect.full;

import com.tekartik.sqflite.Constant;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KClassifiers")
public final class KClassifiers {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final SimpleType createKotlinType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<KTypeProjection> list, boolean z11) {
        KotlinType kotlinType;
        int i11;
        Object obj;
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i12 = 0;
        for (Object next : iterable) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KTypeProjection kTypeProjection = (KTypeProjection) next;
            KTypeImpl kTypeImpl = (KTypeImpl) kTypeProjection.getType();
            if (kTypeImpl != null) {
                kotlinType = kTypeImpl.getType();
            } else {
                kotlinType = null;
            }
            KVariance variance = kTypeProjection.getVariance();
            if (variance == null) {
                i11 = -1;
            } else {
                i11 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
            }
            if (i11 == -1) {
                TypeParameterDescriptor typeParameterDescriptor = parameters.get(i12);
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameters[index]");
                obj = new StarProjectionImpl(typeParameterDescriptor);
            } else if (i11 == 1) {
                Variance variance2 = Variance.INVARIANT;
                Intrinsics.checkNotNull(kotlinType);
                obj = new TypeProjectionImpl(variance2, kotlinType);
            } else if (i11 == 2) {
                Variance variance3 = Variance.IN_VARIANCE;
                Intrinsics.checkNotNull(kotlinType);
                obj = new TypeProjectionImpl(variance3, kotlinType);
            } else if (i11 == 3) {
                Variance variance4 = Variance.OUT_VARIANCE;
                Intrinsics.checkNotNull(kotlinType);
                obj = new TypeProjectionImpl(variance4, kotlinType);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
            i12 = i13;
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, (List) arrayList, z11, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final KType createType(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> list, boolean z11, @NotNull List<? extends Annotation> list2) {
        KClassifierImpl kClassifierImpl;
        ClassifierDescriptor descriptor;
        TypeAttributes typeAttributes;
        Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "annotations");
        if (kClassifier instanceof KClassifierImpl) {
            kClassifierImpl = (KClassifierImpl) kClassifier;
        } else {
            kClassifierImpl = null;
        }
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + ')');
        }
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        if (parameters.size() == list.size()) {
            if (list2.isEmpty()) {
                typeAttributes = TypeAttributes.Companion.getEmpty();
            } else {
                typeAttributes = TypeAttributes.Companion.getEmpty();
            }
            return new KTypeImpl(createKotlinType(typeAttributes, typeConstructor, list, z11), (Function0) null, 2, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean z11, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z11, list2);
    }

    @NotNull
    public static final KType getStarProjectedType(@NotNull KClassifier kClassifier) {
        KClassifierImpl kClassifierImpl;
        ClassifierDescriptor descriptor;
        Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        if (kClassifier instanceof KClassifierImpl) {
            kClassifierImpl = (KClassifierImpl) kClassifier;
        } else {
            kClassifierImpl = null;
        }
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            return createType$default(kClassifier, (List) null, false, (List) null, 7, (Object) null);
        }
        List<TypeParameterDescriptor> parameters = descriptor.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "descriptor.typeConstructor.parameters");
        if (parameters.isEmpty()) {
            return createType$default(kClassifier, (List) null, false, (List) null, 7, (Object) null);
        }
        Iterable<TypeParameterDescriptor> iterable = parameters;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            arrayList.add(KTypeProjection.Companion.getSTAR());
        }
        return createType$default(kClassifier, arrayList, false, (List) null, 6, (Object) null);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier kClassifier) {
    }
}
