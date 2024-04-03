package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractSignatureParts<TAnnotation> {

    public static final class TypeAndDefaultQualifiers {
        @Nullable
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        @Nullable
        private final KotlinTypeMarker type;
        @Nullable
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(@Nullable KotlinTypeMarker kotlinTypeMarker, @Nullable JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, @Nullable TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        @Nullable
        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        @Nullable
        public final KotlinTypeMarker getType() {
            return this.type;
        }

        @Nullable
        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }

    /* access modifiers changed from: private */
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        boolean z11;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            if (enhancedForWarnings != null) {
                nullabilityQualifier = getNullabilityQualifier(enhancedForWarnings);
            } else {
                nullabilityQualifier = null;
            }
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (javaToKotlinClassMap.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (javaToKotlinClassMap.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        boolean z12 = false;
        if (getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (nullabilityQualifier != nullabilityQualifier2) {
            z12 = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z11, z12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0130, code lost:
        if (r0 != false) goto L_0x0135;
     */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers r12) {
        /*
            r11 = this;
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = r12.getType()
            r1 = 0
            if (r0 != 0) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r0 = r11.getTypeSystem()
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r2 = r12.getTypeParameterForArgument()
            if (r2 == 0) goto L_0x0016
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r0 = r0.getVariance((kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker) r2)
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r2 = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.IN
            if (r0 != r2) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers$Companion r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r12 = r12.getNONE()
            return r12
        L_0x0022:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = r12.getTypeParameterForArgument()
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x002c
            r0 = r2
            goto L_0x002d
        L_0x002c:
            r0 = r3
        L_0x002d:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r12.getType()
            if (r4 == 0) goto L_0x0039
            java.lang.Iterable r4 = r11.getAnnotations(r4)
            if (r4 != 0) goto L_0x003f
        L_0x0039:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
        L_0x003f:
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r5 = r11.getTypeSystem()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = r12.getType()
            if (r6 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r6 = r5.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6)
            if (r6 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r5 = r5.getTypeParameterClassifier(r6)
            goto L_0x0055
        L_0x0054:
            r5 = r1
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r6 = r11.getContainerApplicabilityType()
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r7 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS
            if (r6 != r7) goto L_0x005f
            r6 = r2
            goto L_0x0060
        L_0x005f:
            r6 = r3
        L_0x0060:
            if (r0 != 0) goto L_0x0063
            goto L_0x00b3
        L_0x0063:
            if (r6 != 0) goto L_0x00a9
            boolean r7 = r11.getEnableImprovementsInStrictMode()
            if (r7 == 0) goto L_0x00a9
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = r12.getType()
            if (r7 == 0) goto L_0x0079
            boolean r7 = r11.isArrayOrPrimitiveArray(r7)
            if (r7 != r2) goto L_0x0079
            r7 = r2
            goto L_0x007a
        L_0x0079:
            r7 = r3
        L_0x007a:
            if (r7 == 0) goto L_0x00a9
            java.lang.Iterable r7 = r11.getContainerAnnotations()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0089:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00a2
            java.lang.Object r9 = r7.next()
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r10 = r11.getAnnotationTypeQualifierResolver()
            boolean r10 = r10.isTypeUseAnnotation(r9)
            r10 = r10 ^ r2
            if (r10 == 0) goto L_0x0089
            r8.add(r9)
            goto L_0x0089
        L_0x00a2:
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r8, r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            goto L_0x00b3
        L_0x00a9:
            java.lang.Iterable r7 = r11.getContainerAnnotations()
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r7, r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
        L_0x00b3:
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r7 = r11.getAnnotationTypeQualifierResolver()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r7 = r7.extractMutability(r4)
            kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver r8 = r11.getAnnotationTypeQualifierResolver()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1 r9 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1
            r9.<init>(r11)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r4 = r8.extractNullability(r4, r9)
            if (r4 == 0) goto L_0x00e4
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = r4.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = r4.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r1 != r6) goto L_0x00db
            if (r5 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r2 = r3
        L_0x00dc:
            boolean r1 = r4.isForWarningOnly()
            r12.<init>(r0, r7, r2, r1)
            return r12
        L_0x00e4:
            if (r0 != 0) goto L_0x00ec
            if (r6 == 0) goto L_0x00e9
            goto L_0x00ec
        L_0x00e9:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE
            goto L_0x00f0
        L_0x00ec:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = r11.getContainerApplicabilityType()
        L_0x00f0:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r4 = r12.getDefaultQualifiers()
            if (r4 == 0) goto L_0x00fb
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r0 = r4.get(r0)
            goto L_0x00fc
        L_0x00fb:
            r0 = r1
        L_0x00fc:
            if (r5 == 0) goto L_0x0103
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r4 = r11.getBoundsNullability(r5)
            goto L_0x0104
        L_0x0103:
            r4 = r1
        L_0x0104:
            r6 = 2
            if (r4 == 0) goto L_0x010f
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r4, r8, r3, r6, r1)
            if (r8 != 0) goto L_0x0117
        L_0x010f:
            if (r0 == 0) goto L_0x0116
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = r0.getNullabilityQualifier()
            goto L_0x0117
        L_0x0116:
            r8 = r1
        L_0x0117:
            if (r4 == 0) goto L_0x011e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r4.getQualifier()
            goto L_0x011f
        L_0x011e:
            r4 = r1
        L_0x011f:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r4 == r9) goto L_0x0135
            if (r5 == 0) goto L_0x0133
            if (r0 == 0) goto L_0x012f
            boolean r0 = r0.getDefinitelyNotNull()
            if (r0 != r2) goto L_0x012f
            r0 = r2
            goto L_0x0130
        L_0x012f:
            r0 = r3
        L_0x0130:
            if (r0 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r0 = r3
            goto L_0x0136
        L_0x0135:
            r0 = r2
        L_0x0136:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r12 = r12.getTypeParameterForArgument()
            if (r12 == 0) goto L_0x0151
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = r11.getBoundsNullability(r12)
            if (r12 == 0) goto L_0x0151
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r12.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            if (r4 != r5) goto L_0x0152
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r12, r4, r3, r6, r1)
            goto L_0x0152
        L_0x0151:
            r12 = r1
        L_0x0152:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r12 = r11.mostSpecific(r12, r8)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            if (r12 == 0) goto L_0x015e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = r12.getQualifier()
        L_0x015e:
            if (r12 == 0) goto L_0x0167
            boolean r12 = r12.isForWarningOnly()
            if (r12 != r2) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r2 = r3
        L_0x0168:
            r4.<init>(r1, r7, r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
    }

    private final <T> void flattenTree(T t11, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t11);
        Iterable<Object> iterable = (Iterable) function1.invoke(t11);
        if (iterable != null) {
            for (Object flattenTree : iterable) {
                flattenTree(flattenTree, list, function1);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ee A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00c5 A[EDGE_INSN: B:86:0x00c5->B:55:0x00c5 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getBoundsNullability(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r9) {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r0 = r8.getTypeSystem()
            boolean r1 = r8.isFromJava(r9)
            r2 = 0
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            java.util.List r9 = r0.getUpperBounds(r9)
            r1 = r9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0024
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0024
        L_0x0022:
            r6 = r5
            goto L_0x003b
        L_0x0024:
            java.util.Iterator r6 = r1.iterator()
        L_0x0028:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0022
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r7
            boolean r7 = r0.isError(r7)
            if (r7 != 0) goto L_0x0028
            r6 = r4
        L_0x003b:
            if (r6 == 0) goto L_0x003e
            return r2
        L_0x003e:
            if (r3 == 0) goto L_0x004b
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x004b
        L_0x0049:
            r6 = r4
            goto L_0x0067
        L_0x004b:
            java.util.Iterator r6 = r1.iterator()
        L_0x004f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0049
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r7
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = r8.getNullabilityQualifier(r7)
            if (r7 == 0) goto L_0x0063
            r7 = r5
            goto L_0x0064
        L_0x0063:
            r7 = r4
        L_0x0064:
            if (r7 == 0) goto L_0x004f
            r6 = r5
        L_0x0067:
            if (r6 == 0) goto L_0x006b
            r2 = r9
            goto L_0x00b5
        L_0x006b:
            if (r3 == 0) goto L_0x0078
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0078
        L_0x0076:
            r3 = r4
            goto L_0x0094
        L_0x0078:
            java.util.Iterator r3 = r1.iterator()
        L_0x007c:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0076
            java.lang.Object r6 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = r8.getEnhancedForWarnings(r6)
            if (r6 == 0) goto L_0x0090
            r6 = r5
            goto L_0x0091
        L_0x0090:
            r6 = r4
        L_0x0091:
            if (r6 == 0) goto L_0x007c
            r3 = r5
        L_0x0094:
            if (r3 == 0) goto L_0x00ee
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x009f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00b5
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = r8.getEnhancedForWarnings(r3)
            if (r3 == 0) goto L_0x009f
            r2.add(r3)
            goto L_0x009f
        L_0x00b5:
            r1 = r2
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x00c7
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00c7
        L_0x00c5:
            r0 = r5
            goto L_0x00de
        L_0x00c7:
            java.util.Iterator r1 = r1.iterator()
        L_0x00cb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c5
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            boolean r3 = r0.isNullableType(r3)
            if (r3 != 0) goto L_0x00cb
            r0 = r4
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00e5
        L_0x00e3:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
        L_0x00e5:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            if (r2 == r9) goto L_0x00ea
            r4 = r5
        L_0x00ea:
            r1.<init>(r0, r4)
            return r1
        L_0x00ee:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.getBoundsNullability(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (!typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NOT_NULL;
        }
        return null;
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        if (nullabilityQualifierWithMigrationStatus == null) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus2 == null) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() && !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) {
            return nullabilityQualifierWithMigrationStatus;
        }
        return nullabilityQualifierWithMigrationStatus2;
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), (TypeParameterMarker) null), new AbstractSignatureParts$toIndexed$1$1(this, getTypeSystem()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r10 != false) goto L_0x006b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiers(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> r11, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "overrides"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r0 = r9.toIndexed(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r11, r2)
            r1.<init>(r2)
            java.util.Iterator r2 = r11.iterator()
        L_0x001d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0031
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            java.util.List r3 = r9.toIndexed(r3)
            r1.add(r3)
            goto L_0x001d
        L_0x0031:
            boolean r2 = r9.getForceOnlyHeadTypeConstructor()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x006b
            boolean r2 = r9.isCovariant()
            if (r2 == 0) goto L_0x0069
            boolean r2 = r11 instanceof java.util.Collection
            if (r2 == 0) goto L_0x004e
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x004e
        L_0x004c:
            r10 = r3
            goto L_0x0066
        L_0x004e:
            java.util.Iterator r11 = r11.iterator()
        L_0x0052:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r11.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            boolean r2 = r9.isEqual(r10, r2)
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0052
            r10 = r4
        L_0x0066:
            if (r10 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r10 = r3
            goto L_0x006c
        L_0x006b:
            r10 = r4
        L_0x006c:
            if (r10 == 0) goto L_0x0070
            r10 = r4
            goto L_0x0074
        L_0x0070:
            int r10 = r0.size()
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r10]
            r2 = r3
        L_0x0077:
            if (r2 >= r10) goto L_0x00d1
            java.lang.Object r5 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = r9.extractQualifiersFromAnnotations(r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r1.iterator()
        L_0x008c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b2
            java.lang.Object r8 = r7.next()
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r8, r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r8
            if (r8 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r8 = r8.getType()
            if (r8 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r8 = r9.extractQualifiers(r8)
            goto L_0x00ac
        L_0x00ab:
            r8 = 0
        L_0x00ac:
            if (r8 == 0) goto L_0x008c
            r6.add(r8)
            goto L_0x008c
        L_0x00b2:
            if (r2 != 0) goto L_0x00bc
            boolean r7 = r9.isCovariant()
            if (r7 == 0) goto L_0x00bc
            r7 = r4
            goto L_0x00bd
        L_0x00bc:
            r7 = r3
        L_0x00bd:
            if (r2 != 0) goto L_0x00c7
            boolean r8 = r9.getContainerIsVarargParameter()
            if (r8 == 0) goto L_0x00c7
            r8 = r4
            goto L_0x00c8
        L_0x00c7:
            r8 = r3
        L_0x00c8:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(r5, r6, r7, r8, r13)
            r11[r2] = r5
            int r2 = r2 + 1
            goto L_0x0077
        L_0x00d1:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1 r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
            r10.<init>(r12, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo, boolean):kotlin.jvm.functions.Function1");
    }

    @NotNull
    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    @NotNull
    public abstract Iterable<TAnnotation> getAnnotations(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract Iterable<TAnnotation> getContainerAnnotations();

    @NotNull
    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    @Nullable
    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    @Nullable
    public abstract KotlinTypeMarker getEnhancedForWarnings(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean getForceWarning(@NotNull TAnnotation tannotation);

    @Nullable
    public abstract FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    @NotNull
    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(@NotNull TypeParameterMarker typeParameterMarker);

    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return false;
    }

    private final <T> List<T> flattenTree(T t11, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        flattenTree(t11, arrayList, function1);
        return arrayList;
    }
}
