package kotlin.reflect.jvm.internal.impl.load.java;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;
    @NotNull
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    @NotNull
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames = new ConcurrentHashMap<>();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        JAVA_APPLICABILITY_TYPES = linkedHashMap;
    }

    public AbstractAnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState2) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState2, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState2;
    }

    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> set) {
        if (set.contains(AnnotationQualifierApplicabilityType.TYPE_USE)) {
            return SetsKt___SetsKt.plus(SetsKt___SetsKt.minus(ArraysKt___ArraysKt.toSet((T[]) AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), set);
        }
        return set;
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation tannotation) {
        NullabilityQualifierWithMigrationStatus extractNullability;
        JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation = resolveQualifierBuiltInDefaultAnnotation(tannotation);
        if (resolveQualifierBuiltInDefaultAnnotation != null) {
            return resolveQualifierBuiltInDefaultAnnotation;
        }
        Pair resolveTypeQualifierDefaultAnnotation = resolveTypeQualifierDefaultAnnotation(tannotation);
        if (resolveTypeQualifierDefaultAnnotation == null) {
            return null;
        }
        Object component1 = resolveTypeQualifierDefaultAnnotation.component1();
        Set set = (Set) resolveTypeQualifierDefaultAnnotation.component2();
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (resolveJsr305CustomState == null) {
            resolveJsr305CustomState = resolveJsr305AnnotationState(component1);
        }
        if (!resolveJsr305CustomState.isIgnore() && (extractNullability = extractNullability(component1, AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1.INSTANCE)) != null) {
            return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(extractNullability, (NullabilityQualifier) null, resolveJsr305CustomState.isWarning(), 1, (Object) null), set, false, 4, (DefaultConstructorMarker) null);
        }
        return null;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        NullabilityQualifierWithMigrationStatus knownNullability;
        NullabilityQualifierWithMigrationStatus knownNullability2 = knownNullability(tannotation, function1.invoke(tannotation).booleanValue());
        if (knownNullability2 != null) {
            return knownNullability2;
        }
        Object resolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(tannotation);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = resolveJsr305AnnotationState(tannotation);
        if (!resolveJsr305AnnotationState.isIgnore() && (knownNullability = knownNullability(resolveTypeQualifierAnnotation, function1.invoke(resolveTypeQualifierAnnotation).booleanValue())) != null) {
            return NullabilityQualifierWithMigrationStatus.copy$default(knownNullability, (NullabilityQualifier) null, resolveJsr305AnnotationState.isWarning(), 1, (Object) null);
        }
        return null;
    }

    private final TAnnotation findAnnotation(TAnnotation tannotation, FqName fqName) {
        for (TAnnotation next : getMetaAnnotations(tannotation)) {
            if (Intrinsics.areEqual((Object) getFqName(next), (Object) fqName)) {
                return next;
            }
        }
        return null;
    }

    private final boolean hasAnnotation(TAnnotation tannotation, FqName fqName) {
        Iterable<Object> metaAnnotations = getMetaAnnotations(tannotation);
        if ((metaAnnotations instanceof Collection) && ((Collection) metaAnnotations).isEmpty()) {
            return false;
        }
        for (Object fqName2 : metaAnnotations) {
            if (Intrinsics.areEqual((Object) getFqName(fqName2), (Object) fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        if (r6.equals("ALWAYS") != false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r6.equals("NEVER") == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (r6.equals("MAYBE") == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r6, boolean r7) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r5.getFqName(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState r2 = r5.javaTypeEnhancementState
            kotlin.jvm.functions.Function1 r2 = r2.getGetReportLevelForAnnotation()
            java.lang.Object r2 = r2.invoke(r0)
            kotlin.reflect.jvm.internal.impl.load.java.ReportLevel r2 = (kotlin.reflect.jvm.internal.impl.load.java.ReportLevel) r2
            boolean r3 = r2.isIgnore()
            if (r3 == 0) goto L_0x001b
            return r1
        L_0x001b:
            java.util.List r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L_0x002a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00d3
        L_0x002a:
            java.util.List r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L_0x0038
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L_0x00d3
        L_0x0038:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJSPECIFY_NULLABLE()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0046
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00d3
        L_0x0046:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L_0x00d3
        L_0x0054:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00a0
            java.lang.Iterable r6 = r5.enumArguments(r6, r4)
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x009d
            int r0 = r6.hashCode()
            switch(r0) {
                case 73135176: goto L_0x0090;
                case 74175084: goto L_0x0087;
                case 433141802: goto L_0x007b;
                case 1933739535: goto L_0x0072;
                default: goto L_0x0071;
            }
        L_0x0071:
            goto L_0x009c
        L_0x0072:
            java.lang.String r0 = "ALWAYS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x009c
            goto L_0x009d
        L_0x007b:
            java.lang.String r0 = "UNKNOWN"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0084
            goto L_0x009c
        L_0x0084:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            goto L_0x00d3
        L_0x0087:
            java.lang.String r0 = "NEVER"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0099
            goto L_0x009c
        L_0x0090:
            java.lang.String r0 = "MAYBE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0099
            goto L_0x009c
        L_0x0099:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00d3
        L_0x009c:
            return r1
        L_0x009d:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L_0x00d3
        L_0x00a0:
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00ad
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            goto L_0x00d3
        L_0x00ad:
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00ba
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L_0x00d3
        L_0x00ba:
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00c7
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            goto L_0x00d3
        L_0x00c7:
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00e2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            boolean r1 = r2.isWarning()
            if (r1 != 0) goto L_0x00dd
            if (r7 == 0) goto L_0x00de
        L_0x00dd:
            r4 = 1
        L_0x00de:
            r0.<init>(r6, r4)
            return r0
        L_0x00e2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver.knownNullability(java.lang.Object, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation tannotation) {
        FqName fqName = getFqName(tannotation);
        if (fqName == null || !AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(fqName)) {
            return resolveJsr305AnnotationState(tannotation);
        }
        return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation tannotation) {
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (resolveJsr305CustomState != null) {
            return resolveJsr305CustomState;
        }
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation tannotation) {
        Iterable<String> enumArguments;
        String str;
        ReportLevel reportLevel = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        Object findAnnotation = findAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (findAnnotation == null || (enumArguments = enumArguments(findAnnotation, false)) == null || (str = (String) CollectionsKt___CollectionsKt.firstOrNull(enumArguments)) == null) {
            return null;
        }
        ReportLevel migrationLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (migrationLevel != null) {
            return migrationLevel;
        }
        int hashCode = str.hashCode();
        if (hashCode != -2137067054) {
            if (hashCode != -1838656823) {
                if (hashCode == 2656902 && str.equals("WARN")) {
                    return ReportLevel.WARN;
                }
                return null;
            } else if (!str.equals("STRICT")) {
                return null;
            } else {
                return ReportLevel.STRICT;
            }
        } else if (!str.equals("IGNORE")) {
            return null;
        } else {
            return ReportLevel.IGNORE;
        }
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation tannotation) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        boolean z11;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(tannotation))) == null) {
            return null;
        }
        ReportLevel resolveDefaultAnnotationState = resolveDefaultAnnotationState(tannotation);
        if (resolveDefaultAnnotationState != ReportLevel.IGNORE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            resolveDefaultAnnotationState = null;
        }
        if (resolveDefaultAnnotationState == null) {
            return null;
        }
        return JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), (NullabilityQualifier) null, resolveDefaultAnnotationState.isWarning(), 1, (Object) null), (Collection) null, false, 6, (Object) null);
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation tannotation) {
        Object findAnnotation;
        Object obj;
        boolean z11;
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() || (findAnnotation = findAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME())) == null) {
            return null;
        }
        Iterator it = getMetaAnnotations(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (resolveTypeQualifierAnnotation(obj) != null) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        if (obj == null) {
            return null;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : enumArguments) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = JAVA_APPLICABILITY_TYPES.get(str);
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new Pair<>(obj, allIfTypeUse(linkedHashSet));
    }

    @NotNull
    public abstract Iterable<String> enumArguments(@NotNull TAnnotation tannotation, boolean z11);

    @Nullable
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(@Nullable JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, @NotNull Iterable<? extends TAnnotation> iterable) {
        EnumMap enumMap;
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;
        Intrinsics.checkNotNullParameter(iterable, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return javaTypeQualifiersByElementType;
        }
        ArrayList<JavaDefaultQualifiers> arrayList = new ArrayList<>();
        for (Object extractDefaultQualifiers : iterable) {
            JavaDefaultQualifiers extractDefaultQualifiers2 = extractDefaultQualifiers(extractDefaultQualifiers);
            if (extractDefaultQualifiers2 != null) {
                arrayList.add(extractDefaultQualifiers2);
            }
        }
        if (arrayList.isEmpty()) {
            return javaTypeQualifiersByElementType;
        }
        if (javaTypeQualifiersByElementType == null || (defaultQualifiers = javaTypeQualifiersByElementType.getDefaultQualifiers()) == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        } else {
            enumMap = new EnumMap(defaultQualifiers);
        }
        boolean z11 = false;
        for (JavaDefaultQualifiers javaDefaultQualifiers : arrayList) {
            for (AnnotationQualifierApplicabilityType put : javaDefaultQualifiers.getQualifierApplicabilityTypes()) {
                enumMap.put(put, javaDefaultQualifiers);
                z11 = true;
            }
        }
        if (!z11) {
            return javaTypeQualifiersByElementType;
        }
        return new JavaTypeQualifiersByElementType(enumMap);
    }

    @Nullable
    public final MutabilityQualifier extractMutability(@NotNull Iterable<? extends TAnnotation> iterable) {
        MutabilityQualifier mutabilityQualifier;
        Intrinsics.checkNotNullParameter(iterable, "annotations");
        MutabilityQualifier mutabilityQualifier2 = null;
        for (Object fqName : iterable) {
            FqName fqName2 = getFqName(fqName);
            if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(fqName2)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(fqName2)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }

    @Nullable
    public abstract FqName getFqName(@NotNull TAnnotation tannotation);

    @NotNull
    public abstract Object getKey(@NotNull TAnnotation tannotation);

    @NotNull
    public abstract Iterable<TAnnotation> getMetaAnnotations(@NotNull TAnnotation tannotation);

    public final boolean isTypeUseAnnotation(@NotNull TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "annotation");
        Object findAnnotation = findAnnotation(tannotation, StandardNames.FqNames.target);
        if (findAnnotation == null) {
            return false;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, false);
        if ((enumArguments instanceof Collection) && ((Collection) enumArguments).isEmpty()) {
            return false;
        }
        for (String areEqual : enumArguments) {
            if (Intrinsics.areEqual((Object) areEqual, (Object) KotlinTarget.TYPE.name())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final TAnnotation resolveTypeQualifierAnnotation(@NotNull TAnnotation tannotation) {
        TAnnotation tannotation2;
        Intrinsics.checkNotNullParameter(tannotation, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            return null;
        }
        if (CollectionsKt___CollectionsKt.contains(AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES(), getFqName(tannotation)) || hasAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_FQNAME())) {
            return tannotation;
        }
        if (!hasAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.resolvedNicknames;
        Object key = getKey(tannotation);
        TAnnotation tannotation3 = concurrentHashMap.get(key);
        if (tannotation3 != null) {
            return tannotation3;
        }
        Iterator it = getMetaAnnotations(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = resolveTypeQualifierAnnotation(it.next());
            if (tannotation2 != null) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        TAnnotation putIfAbsent = concurrentHashMap.putIfAbsent(key, tannotation2);
        if (putIfAbsent == null) {
            return tannotation2;
        }
        return putIfAbsent;
    }

    @Nullable
    public final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull Iterable<? extends TAnnotation> iterable, @NotNull Function1<? super TAnnotation, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "annotations");
        Intrinsics.checkNotNullParameter(function1, "forceWarning");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        for (Object extractNullability : iterable) {
            NullabilityQualifierWithMigrationStatus extractNullability2 = extractNullability(extractNullability, function1);
            if (nullabilityQualifierWithMigrationStatus != null) {
                if (extractNullability2 != null && !Intrinsics.areEqual((Object) extractNullability2, (Object) nullabilityQualifierWithMigrationStatus)) {
                    if (!extractNullability2.isForWarningOnly() || nullabilityQualifierWithMigrationStatus.isForWarningOnly()) {
                        if (extractNullability2.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus.isForWarningOnly()) {
                            return null;
                        }
                    }
                }
            }
            nullabilityQualifierWithMigrationStatus = extractNullability2;
        }
        return nullabilityQualifierWithMigrationStatus;
    }
}
