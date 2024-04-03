package kotlin.reflect.jvm.internal.impl.types;

import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractTypeChecker {
    @NotNull
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && !typeSystemContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        if (m7572checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker) && m7572checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (m7573checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker, simpleTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker2) && (m7571checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, simpleTypeMarker) || m7573checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker2, simpleTypeMarker, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isCapturedIntegerLiteralType  reason: not valid java name */
    private static final boolean m7570checkSubtypeForIntegerLiteralType$lambda7$isCapturedIntegerLiteralType(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        if (!(simpleTypeMarker instanceof CapturedTypeMarker)) {
            return false;
        }
        TypeArgumentMarker projection = typeSystemContext.projection(typeSystemContext.typeConstructor((CapturedTypeMarker) simpleTypeMarker));
        if (typeSystemContext.isStarProjection(projection) || !typeSystemContext.isIntegerLiteralType(typeSystemContext.upperBoundIfFlexible(typeSystemContext.getType(projection)))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isIntegerLiteralTypeInIntersectionComponents  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m7571checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4) {
        /*
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r4 = r3.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r4)
            boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker
            r1 = 0
            if (r0 == 0) goto L_0x0044
            java.util.Collection r4 = r3.supertypes(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r0 = r4 instanceof java.util.Collection
            r2 = 1
            if (r0 == 0) goto L_0x001f
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001f
        L_0x001d:
            r3 = r1
            goto L_0x0041
        L_0x001f:
            java.util.Iterator r4 = r4.iterator()
        L_0x0023:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r3.asSimpleType(r0)
            if (r0 == 0) goto L_0x003d
            boolean r0 = r3.isIntegerLiteralType(r0)
            if (r0 != r2) goto L_0x003d
            r0 = r2
            goto L_0x003e
        L_0x003d:
            r0 = r1
        L_0x003e:
            if (r0 == 0) goto L_0x0023
            r3 = r2
        L_0x0041:
            if (r3 == 0) goto L_0x0044
            r1 = r2
        L_0x0044:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m7571checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):boolean");
    }

    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isIntegerLiteralTypeOrCapturedOne  reason: not valid java name */
    private static final boolean m7572checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        return typeSystemContext.isIntegerLiteralType(simpleTypeMarker) || m7570checkSubtypeForIntegerLiteralType$lambda7$isCapturedIntegerLiteralType(typeSystemContext, simpleTypeMarker);
    }

    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isTypeInIntegerLiteralType  reason: not valid java name */
    private static final boolean m7573checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(TypeSystemContext typeSystemContext, TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z11) {
        boolean z12;
        Iterable<KotlinTypeMarker> possibleIntegerTypes = typeSystemContext.possibleIntegerTypes(simpleTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && ((Collection) possibleIntegerTypes).isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
            if (Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(kotlinTypeMarker), (Object) typeSystemContext.typeConstructor(simpleTypeMarker2)) || (z11 && isSubtypeOf$default(INSTANCE, typeCheckerState, simpleTypeMarker2, kotlinTypeMarker, false, 8, (Object) null))) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0131, code lost:
        if (r10 == false) goto L_0x014c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Boolean checkSubtypeForSpecialCases(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r15, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r16, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r17) {
        /*
            r14 = this;
            r7 = r16
            r8 = r17
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r9 = r15.getTypeSystemContext()
            boolean r0 = r9.isError(r7)
            r10 = 0
            if (r0 != 0) goto L_0x0157
            boolean r0 = r9.isError(r8)
            if (r0 == 0) goto L_0x0017
            goto L_0x0157
        L_0x0017:
            boolean r0 = r9.isStubTypeForBuilderInference(r7)
            r11 = 1
            if (r0 == 0) goto L_0x0038
            boolean r0 = r9.isStubTypeForBuilderInference(r8)
            if (r0 == 0) goto L_0x0038
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            boolean r0 = r0.isStubTypeSubtypeOfAnother(r9, r7, r8)
            if (r0 != 0) goto L_0x0032
            boolean r0 = r15.isStubTypeEqualsToAnything()
            if (r0 == 0) goto L_0x0033
        L_0x0032:
            r10 = r11
        L_0x0033:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            return r0
        L_0x0038:
            boolean r0 = r9.isStubType(r7)
            if (r0 != 0) goto L_0x014d
            boolean r0 = r9.isStubType(r8)
            if (r0 == 0) goto L_0x0046
            goto L_0x014d
        L_0x0046:
            kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker r0 = r9.asDefinitelyNotNullType(r8)
            if (r0 == 0) goto L_0x0052
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r9.original(r0)
            if (r0 != 0) goto L_0x0053
        L_0x0052:
            r0 = r8
        L_0x0053:
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker r0 = r9.asCapturedType(r0)
            r12 = 0
            if (r0 == 0) goto L_0x005f
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r9.lowerType(r0)
            goto L_0x0060
        L_0x005f:
            r1 = r12
        L_0x0060:
            if (r0 == 0) goto L_0x00b2
            if (r1 == 0) goto L_0x00b2
            boolean r2 = r9.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8)
            if (r2 == 0) goto L_0x0071
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r9.withNullability((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1, (boolean) r11)
        L_0x006e:
            r13 = r15
            r3 = r1
            goto L_0x007c
        L_0x0071:
            boolean r2 = r9.isDefinitelyNotNullType(r8)
            if (r2 == 0) goto L_0x006e
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = r9.makeDefinitelyNotNullOrNotNull(r1)
            goto L_0x006e
        L_0x007c:
            kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$LowerCapturedTypePolicy r0 = r15.getLowerCapturedTypePolicy(r7, r0)
            int[] r1 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r11) goto L_0x00a0
            r1 = 2
            if (r0 == r1) goto L_0x008e
            goto L_0x00b3
        L_0x008e:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            r4 = 0
            r5 = 8
            r6 = 0
            r1 = r15
            r2 = r16
            boolean r0 = isSubtypeOf$default(r0, r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x00b3
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x00a0:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            r4 = 0
            r5 = 8
            r6 = 0
            r1 = r15
            r2 = r16
            boolean r0 = isSubtypeOf$default(r0, r1, r2, r3, r4, r5, r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x00b2:
            r13 = r15
        L_0x00b3:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8)
            boolean r1 = r9.isIntersection(r0)
            if (r1 == 0) goto L_0x00fa
            r9.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8)
            java.util.Collection r0 = r9.supertypes(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00d5
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d5
        L_0x00d3:
            r10 = r11
            goto L_0x00f5
        L_0x00d5:
            java.util.Iterator r8 = r0.iterator()
        L_0x00d9:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00d3
            java.lang.Object r0 = r8.next()
            r3 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            r4 = 0
            r5 = 8
            r6 = 0
            r1 = r15
            r2 = r16
            boolean r0 = isSubtypeOf$default(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x00d9
        L_0x00f5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            return r0
        L_0x00fa:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r7)
            boolean r1 = r7 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r1 != 0) goto L_0x0133
            boolean r1 = r9.isIntersection(r0)
            if (r1 == 0) goto L_0x014c
            java.util.Collection r0 = r9.supertypes(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x011d
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x011d
        L_0x011b:
            r10 = r11
            goto L_0x0131
        L_0x011d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0121:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x011b
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r1 != 0) goto L_0x0121
        L_0x0131:
            if (r10 == 0) goto L_0x014c
        L_0x0133:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r1 = r15.getTypeSystemContext()
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = r0.getTypeParameterForArgumentInBaseIfItEqualToTarget(r1, r8, r7)
            if (r0 == 0) goto L_0x014c
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r1 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8)
            boolean r0 = r9.hasRecursiveBounds(r0, r1)
            if (r0 == 0) goto L_0x014c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x014c:
            return r12
        L_0x014d:
            r13 = r15
            boolean r0 = r15.isStubTypeEqualsToAnything()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x0157:
            r13 = r15
            boolean r0 = r15.isErrorTypeEqualsToAnything()
            if (r0 == 0) goto L_0x0161
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0161:
            boolean r0 = r9.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r7)
            if (r0 == 0) goto L_0x0170
            boolean r0 = r9.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8)
            if (r0 != 0) goto L_0x0170
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L_0x0170:
            kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker r0 = kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r1 = r9.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r7, (boolean) r10)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2 = r9.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8, (boolean) r10)
            boolean r0 = r0.strictEqualTypes(r9, r1, r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.checkSubtypeForSpecialCases(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):java.lang.Boolean");
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker) && typeSystemContext.isClassType(simpleTypeMarker)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (!typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            SmartList smartList = new SmartList();
            typeCheckerState.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
            Intrinsics.checkNotNull(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
            Intrinsics.checkNotNull(supertypesSet);
            supertypesDeque.push(simpleTypeMarker);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "current");
                    if (supertypesSet.add(pop)) {
                        SimpleTypeMarker captureFromArguments = typeSystemContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                        if (captureFromArguments == null) {
                            captureFromArguments = pop;
                        }
                        if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(captureFromArguments), typeConstructorMarker)) {
                            smartList.add(captureFromArguments);
                            supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                        } else if (typeSystemContext.argumentsCount(captureFromArguments) == 0) {
                            supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                        } else {
                            supertypesPolicy = typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(captureFromArguments);
                        }
                        if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy = null;
                        }
                        if (supertypesPolicy != null) {
                            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                            for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                                supertypesDeque.add(supertypesPolicy.transformType(typeCheckerState, transformType));
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                }
            }
            typeCheckerState.clear();
            return smartList;
        } else if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            SimpleTypeMarker captureFromArguments2 = typeSystemContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
            if (captureFromArguments2 != null) {
                simpleTypeMarker = captureFromArguments2;
            }
            return CollectionsKt__CollectionsJVMKt.listOf(simpleTypeMarker);
        }
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeCheckerState, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z11) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForSpecialCases = abstractTypeChecker.checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        if (checkSubtypeForSpecialCases != null) {
            boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
            typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z11);
            return booleanValue;
        }
        Boolean addSubtypeConstraint = typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z11);
        if (addSubtypeConstraint != null) {
            return addSubtypeConstraint.booleanValue();
        }
        return abstractTypeChecker.isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        KotlinTypeMarker type;
        int argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        int i11 = 0;
        while (true) {
            TypeArgumentMarker typeArgumentMarker = null;
            if (i11 >= argumentsCount) {
                return null;
            }
            TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i11);
            boolean z11 = true;
            if (!typeSystemContext.isStarProjection(argument)) {
                typeArgumentMarker = argument;
            }
            if (!(typeArgumentMarker == null || (type = typeSystemContext.getType(typeArgumentMarker)) == null)) {
                if (!typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) || !typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2))) {
                    z11 = false;
                }
                if (!Intrinsics.areEqual((Object) type, (Object) kotlinTypeMarker2) && (!z11 || !Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(type), (Object) typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                    TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                    if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                        return typeParameterForArgumentInBaseIfItEqualToTarget;
                    }
                }
            }
            i11++;
        }
        return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i11);
    }

    private final boolean hasNothingSupertype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (typeSystemContext.isClassType(pop)) {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            SimpleTypeMarker transformType2 = supertypesPolicy.transformType(typeCheckerState, transformType);
                            if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(transformType2))) {
                                typeCheckerState.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType2);
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        if (!typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) || typeSystemContext.isDynamic(kotlinTypeMarker) || typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) || typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) || !Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), (Object) typeSystemContext.typeConstructor(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)))) {
            return false;
        }
        return true;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        SimpleTypeMarker simpleTypeMarker4;
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker);
        if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
            simpleTypeMarker3 = simpleTypeMarker;
        }
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType2 = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
        if (asDefinitelyNotNullType2 == null || (simpleTypeMarker4 = typeSystemContext.original(asDefinitelyNotNullType2)) == null) {
            simpleTypeMarker4 = simpleTypeMarker2;
        }
        if (typeSystemContext.typeConstructor(simpleTypeMarker3) != typeSystemContext.typeConstructor(simpleTypeMarker4)) {
            return false;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) && typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            return false;
        }
        if (!typeSystemContext.isMarkedNullable(simpleTypeMarker) || typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z11);
    }

    private final boolean isSubtypeOfForSingleClassifierType(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z11;
        KotlinTypeMarker type;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker3 = simpleTypeMarker;
        SimpleTypeMarker simpleTypeMarker4 = simpleTypeMarker2;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker3) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker3))) {
                boolean isAllowedTypeVariable = typeCheckerState.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker4)) {
                boolean isAllowedTypeVariable2 = typeCheckerState2.isAllowedTypeVariable(simpleTypeMarker4);
            }
        }
        boolean z12 = false;
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState2, simpleTypeMarker3, simpleTypeMarker4)) {
            return false;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForIntegerLiteralType = abstractTypeChecker.checkSubtypeForIntegerLiteralType(typeCheckerState2, typeSystemContext.lowerBoundIfFlexible(simpleTypeMarker3), typeSystemContext.upperBoundIfFlexible(simpleTypeMarker4));
        if (checkSubtypeForIntegerLiteralType != null) {
            boolean booleanValue = checkSubtypeForIntegerLiteralType.booleanValue();
            TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, simpleTypeMarker, simpleTypeMarker2, false, 4, (Object) null);
            return booleanValue;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker4);
        boolean z13 = true;
        if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker3), typeConstructor) && typeSystemContext.parametersCount(typeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(simpleTypeMarker4))) {
            return true;
        }
        Iterable<SimpleTypeMarker> findCorrespondingSupertypes = abstractTypeChecker.findCorrespondingSupertypes(typeCheckerState2, simpleTypeMarker3, typeConstructor);
        int i11 = 10;
        ArrayList<SimpleTypeMarker> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(findCorrespondingSupertypes, 10));
        for (SimpleTypeMarker simpleTypeMarker5 : findCorrespondingSupertypes) {
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(typeCheckerState2.prepareType(simpleTypeMarker5));
            if (asSimpleType != null) {
                simpleTypeMarker5 = asSimpleType;
            }
            arrayList.add(simpleTypeMarker5);
        }
        int size = arrayList.size();
        if (size == 0) {
            return INSTANCE.hasNothingSupertype(typeCheckerState2, simpleTypeMarker3);
        }
        if (size == 1) {
            return INSTANCE.isSubtypeForSameConstructor(typeCheckerState2, typeSystemContext.asArgumentList((SimpleTypeMarker) CollectionsKt___CollectionsKt.first(arrayList)), simpleTypeMarker4);
        }
        ArgumentList argumentList = new ArgumentList(typeSystemContext.parametersCount(typeConstructor));
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        int i12 = 0;
        boolean z14 = false;
        while (i12 < parametersCount) {
            if (z14 || typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i12)) != TypeVariance.OUT) {
                z14 = z13;
            } else {
                z14 = z12;
            }
            if (!z14) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, i11));
                for (SimpleTypeMarker simpleTypeMarker6 : arrayList) {
                    TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(simpleTypeMarker6, i12);
                    if (argumentOrNull != null) {
                        if (typeSystemContext.getVariance(argumentOrNull) == TypeVariance.INV) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            argumentOrNull = null;
                        }
                        if (!(argumentOrNull == null || (type = typeSystemContext.getType(argumentOrNull)) == null)) {
                            arrayList2.add(type);
                        }
                    }
                    throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker6 + ", subType: " + simpleTypeMarker3 + ", superType: " + simpleTypeMarker4).toString());
                }
                argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes(arrayList2)));
            }
            i12++;
            z12 = false;
            z13 = true;
            i11 = 10;
        }
        if (z14 || !INSTANCE.isSubtypeForSameConstructor(typeCheckerState2, argumentList, simpleTypeMarker4)) {
            return typeCheckerState2.runForkingPoint(new AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(arrayList, typeCheckerState2, typeSystemContext, simpleTypeMarker4));
        }
        return true;
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker;
        TypeParameterMarker typeParameter;
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (!(asSimpleType instanceof CapturedTypeMarker)) {
            return false;
        }
        CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asSimpleType;
        if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
            return false;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
        if (typeConstructor instanceof TypeVariableTypeConstructorMarker) {
            typeVariableTypeConstructorMarker = (TypeVariableTypeConstructorMarker) typeConstructor;
        } else {
            typeVariableTypeConstructorMarker = null;
        }
        if (typeVariableTypeConstructorMarker == null || (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) {
            return false;
        }
        return true;
    }

    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState typeCheckerState, List<? extends SimpleTypeMarker> list) {
        boolean z11;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = typeSystemContext.asArgumentList((SimpleTypeMarker) next);
            int size = typeSystemContext.size(asArgumentList);
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                if (typeSystemContext.asFlexibleType(typeSystemContext.getType(typeSystemContext.get(asArgumentList, i11))) == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    z12 = false;
                    break;
                }
                i11++;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return list;
    }

    @Nullable
    public final TypeVariance effectiveVariance(@NotNull TypeVariance typeVariance, @NotNull TypeVariance typeVariance2) {
        Intrinsics.checkNotNullParameter(typeVariance, "declared");
        Intrinsics.checkNotNullParameter(typeVariance2, "useSite");
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean equalTypes(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "a");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "b");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker2)) {
            KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
            KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
            SimpleTypeMarker lowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(prepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(prepareType), typeSystemContext.typeConstructor(prepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (typeSystemContext.hasFlexibleNullability(prepareType) || typeSystemContext.hasFlexibleNullability(prepareType2) || typeSystemContext.isMarkedNullable(lowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(prepareType2))) {
                    return true;
                }
                return false;
            }
        }
        if (!isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, (Object) null) || !isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker2, kotlinTypeMarker, false, 8, (Object) null)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<SimpleTypeMarker> findCorrespondingSupertypes(@NotNull TypeCheckerState typeCheckerState, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "superConstructor");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isClassType(simpleTypeMarker)) {
            return INSTANCE.collectAndFilter(typeCheckerState, simpleTypeMarker, typeConstructorMarker);
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker) && !typeSystemContext.isIntegerLiteralTypeConstructor(typeConstructorMarker)) {
            return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, simpleTypeMarker, typeConstructorMarker);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList<>();
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (typeSystemContext.isClassType(pop)) {
                        smartList.add(pop);
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            supertypesDeque.add(supertypesPolicy.transformType(typeCheckerState, transformType));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        typeCheckerState.clear();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker2 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(simpleTypeMarker2, "it");
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(typeCheckerState, simpleTypeMarker2, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(@NotNull TypeCheckerState typeCheckerState, @NotNull TypeArgumentListMarker typeArgumentListMarker, @NotNull SimpleTypeMarker simpleTypeMarker) {
        boolean z11;
        boolean z12;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        TypeArgumentListMarker typeArgumentListMarker2 = typeArgumentListMarker;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "<this>");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker2, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker2);
        int size = typeSystemContext.size(typeArgumentListMarker2);
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        if (size != parametersCount || size != typeSystemContext.argumentsCount(simpleTypeMarker2)) {
            return false;
        }
        for (int i11 = 0; i11 < parametersCount; i11++) {
            TypeArgumentMarker argument = typeSystemContext.getArgument(simpleTypeMarker2, i11);
            if (!typeSystemContext.isStarProjection(argument)) {
                KotlinTypeMarker type = typeSystemContext.getType(argument);
                TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(typeArgumentListMarker2, i11);
                typeSystemContext.getVariance(typeArgumentMarker);
                TypeVariance typeVariance = TypeVariance.INV;
                KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                AbstractTypeChecker abstractTypeChecker = INSTANCE;
                TypeVariance effectiveVariance = abstractTypeChecker.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i11)), typeSystemContext.getVariance(argument));
                if (effectiveVariance == null) {
                    return typeCheckerState.isErrorTypeEqualsToAnything();
                }
                if (effectiveVariance != typeVariance || (!abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructor) && !abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructor))) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    continue;
                } else if (typeCheckerState.argumentsDepth <= 100) {
                    typeCheckerState2.argumentsDepth = typeCheckerState.argumentsDepth + 1;
                    int i12 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                    if (i12 == 1) {
                        z12 = abstractTypeChecker.equalTypes(typeCheckerState2, type2, type);
                    } else if (i12 == 2) {
                        z12 = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type2, type, false, 8, (Object) null);
                    } else if (i12 == 3) {
                        z12 = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type, type2, false, 8, (Object) null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    typeCheckerState2.argumentsDepth = typeCheckerState.argumentsDepth - 1;
                    if (!z12) {
                        return false;
                    }
                } else {
                    throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                }
            }
        }
        return true;
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return isSubtypeOf$default(this, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, (Object) null);
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2, boolean z11) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (!typeCheckerState.customIsSubtypeOf(kotlinTypeMarker, kotlinTypeMarker2)) {
            return false;
        }
        return completeIsSubTypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z11);
    }
}
