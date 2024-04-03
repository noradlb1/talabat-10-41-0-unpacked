package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class TypeEnhancementUtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d7, code lost:
        if (r6 != false) goto L_0x00d9;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeQualifiersForOverride(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r6, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r7, boolean r8, boolean r9, boolean r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "superQualifiers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r7.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = getNullabilityForErrors(r2)
            if (r2 == 0) goto L_0x0015
            r0.add(r2)
            goto L_0x0015
        L_0x002b:
            java.util.Set r0 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = getNullabilityForErrors(r6)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = select(r0, r1, r8)
            if (r0 != 0) goto L_0x0065
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r7.iterator()
        L_0x0042:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r3
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r3.getNullability()
            if (r3 == 0) goto L_0x0042
            r1.add(r3)
            goto L_0x0042
        L_0x0058:
            java.util.Set r1 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = r6.getNullability()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = select(r1, r2, r8)
            goto L_0x0066
        L_0x0065:
            r1 = r0
        L_0x0066:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r7.iterator()
        L_0x006f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r4
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r4 = r4.getMutability()
            if (r4 == 0) goto L_0x006f
            r2.add(r4)
            goto L_0x006f
        L_0x0085:
            java.util.Set r2 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r5 = r6.getMutability()
            java.lang.Object r8 = select(r2, r3, r4, r5, r8)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r8
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x00ab
            if (r10 != 0) goto L_0x00a7
            if (r9 == 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            if (r1 != r9) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r9 = r4
            goto L_0x00a8
        L_0x00a7:
            r9 = r3
        L_0x00a8:
            if (r9 != 0) goto L_0x00ab
            r2 = r1
        L_0x00ab:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r2 != r9) goto L_0x00db
            boolean r6 = r6.getDefinitelyNotNull()
            if (r6 != 0) goto L_0x00d9
            r6 = r7
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00c0
        L_0x00be:
            r6 = r4
            goto L_0x00d7
        L_0x00c0:
            java.util.Iterator r6 = r7.iterator()
        L_0x00c4:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00be
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r7 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r7
            boolean r7 = r7.getDefinitelyNotNull()
            if (r7 == 0) goto L_0x00c4
            r6 = r3
        L_0x00d7:
            if (r6 == 0) goto L_0x00db
        L_0x00d9:
            r6 = r3
            goto L_0x00dc
        L_0x00db:
            r6 = r4
        L_0x00dc:
            if (r2 == 0) goto L_0x00e1
            if (r0 == r1) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r3 = r4
        L_0x00e2:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            r7.<init>(r2, r8, r6, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers, java.util.Collection, boolean, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final boolean hasEnhancedNullability(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }

    private static final <T> T select(Set<? extends T> set, T t11, T t12, T t13, boolean z11) {
        Set<? extends T> set2;
        if (z11) {
            T t14 = set.contains(t11) ? t11 : set.contains(t12) ? t12 : null;
            if (!Intrinsics.areEqual((Object) t14, (Object) t11) || !Intrinsics.areEqual((Object) t13, (Object) t12)) {
                return t13 == null ? t14 : t13;
            }
            return null;
        }
        if (!(t13 == null || (set2 = CollectionsKt___CollectionsKt.toSet(SetsKt___SetsKt.plus(set, t13))) == null)) {
            set = set2;
        }
        return CollectionsKt___CollectionsKt.singleOrNull(set);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z11) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z11);
    }
}
