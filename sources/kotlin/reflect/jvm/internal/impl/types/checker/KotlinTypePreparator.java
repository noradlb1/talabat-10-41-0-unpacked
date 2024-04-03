package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    public static final class Default extends KotlinTypePreparator {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: kotlin.reflect.jvm.internal.impl.types.UnwrappedType} */
    /* JADX WARNING: type inference failed for: r5v3, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType r17) {
        /*
            r16 = this;
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r17.getConstructor()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
            r2 = 1
            r3 = 0
            r4 = 10
            r5 = 0
            if (r1 == 0) goto L_0x0087
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl r0 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) r0
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r1 = r0.getProjection()
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r1.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r6 != r7) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            if (r2 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r1 = r5
        L_0x0021:
            if (r1 == 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            if (r1 == 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r1.unwrap()
        L_0x002d:
            r9 = r5
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r1 = r0.getNewTypeConstructor()
            if (r1 != 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r11 = r0.getProjection()
            java.util.Collection r1 = r0.getSupertypes()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r12 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r4)
            r12.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r2.unwrap()
            r12.add(r2)
            goto L_0x004b
        L_0x005f:
            r13 = 0
            r14 = 4
            r15 = 0
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            r0.setNewTypeConstructor(r1)
        L_0x006b:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r1 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r7 = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r8 = r0.getNewTypeConstructor()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r10 = r17.getAttributes()
            boolean r11 = r17.isMarkedNullable()
            r12 = 0
            r13 = 32
            r14 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            return r1
        L_0x0087:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
            if (r1 == 0) goto L_0x00d3
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) r0
            java.util.Collection r0 = r0.getSupertypes()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r4)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x00a0:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00bd
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            boolean r4 = r17.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r2, r4)
            java.lang.String r4 = "makeNullableAsSpecified(it, type.isMarkedNullable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r1.add(r2)
            goto L_0x00a0
        L_0x00bd:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r0.<init>(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r1 = r17.getAttributes()
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r4 = r17.getMemberScope()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r1, r0, r2, r3, r4)
            return r0
        L_0x00d3:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r1 == 0) goto L_0x0126
            boolean r1 = r17.isMarkedNullable()
            if (r1 == 0) goto L_0x0126
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            java.util.Collection r1 = r0.getSupertypes()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r4)
            r6.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x00f2:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0107
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r3)
            r6.add(r3)
            r3 = r2
            goto L_0x00f2
        L_0x0107:
            if (r3 != 0) goto L_0x010a
            goto L_0x011d
        L_0x010a:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.getAlternativeType()
            if (r1 == 0) goto L_0x0114
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r1)
        L_0x0114:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r1.<init>(r6)
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r5 = r1.setAlternative(r5)
        L_0x011d:
            if (r5 != 0) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r0 = r5
        L_0x0121:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.createType()
            return r0
        L_0x0126:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    @NotNull
    public UnwrappedType prepareType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
            if (unwrap instanceof SimpleType) {
                unwrappedType = transformToNewType((SimpleType) unwrap);
            } else if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrap;
                SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
                SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
                if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                    unwrappedType = unwrap;
                } else {
                    unwrappedType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap, new KotlinTypePreparator$prepareType$1(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
