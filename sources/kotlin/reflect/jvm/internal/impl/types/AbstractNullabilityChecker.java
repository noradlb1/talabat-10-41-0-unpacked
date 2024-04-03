package kotlin.reflect.jvm.internal.impl.types;

import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class AbstractNullabilityChecker {
    @NotNull
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!typeCheckerState.isStubTypeEqualsToAnything() || !typeSystemContext.isStubType(simpleTypeMarker)) {
            return typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker))) {
                boolean isAllowedTypeVariable = typeCheckerState.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker2)) {
                boolean isAllowedTypeVariable2 = typeCheckerState.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker2) || typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) || typeSystemContext.isNotNullTypeParameter(simpleTypeMarker)) {
            return true;
        }
        if ((simpleTypeMarker instanceof CapturedTypeMarker) && typeSystemContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) {
            return true;
        }
        AbstractNullabilityChecker abstractNullabilityChecker = INSTANCE;
        if (abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2) && !abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker2, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) && !typeSystemContext.isClassType(simpleTypeMarker)) {
            return abstractNullabilityChecker.hasPathByNotMarkedNullableNodes(typeCheckerState, simpleTypeMarker, typeSystemContext.typeConstructor(simpleTypeMarker2));
        }
        return false;
    }

    public final boolean hasNotNullSupertype(@NotNull TypeCheckerState typeCheckerState, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        boolean z11;
        TypeCheckerState.SupertypesPolicy supertypesPolicy2;
        boolean z12;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "type");
        TypeCheckerState.SupertypesPolicy supertypesPolicy3 = supertypesPolicy;
        Intrinsics.checkNotNullParameter(supertypesPolicy3, "supertypesPolicy");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if ((!typeSystemContext.isClassType(simpleTypeMarker2) || typeSystemContext.isMarkedNullable(simpleTypeMarker2)) && !typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            typeCheckerState.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
            Intrinsics.checkNotNull(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
            Intrinsics.checkNotNull(supertypesSet);
            supertypesDeque.push(simpleTypeMarker2);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "current");
                    if (supertypesSet.add(pop)) {
                        if (typeSystemContext.isMarkedNullable(pop)) {
                            supertypesPolicy2 = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                        } else {
                            supertypesPolicy2 = supertypesPolicy3;
                        }
                        if (!(!Intrinsics.areEqual((Object) supertypesPolicy2, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy2 = null;
                        }
                        if (supertypesPolicy2 == null) {
                            continue;
                        } else {
                            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                            for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                                SimpleTypeMarker transformType2 = supertypesPolicy2.transformType(typeCheckerState2, transformType);
                                if ((!typeSystemContext.isClassType(transformType2) || typeSystemContext.isMarkedNullable(transformType2)) && !typeSystemContext.isDefinitelyNotNullType(transformType2)) {
                                    z12 = false;
                                } else {
                                    z12 = true;
                                }
                                if (z12) {
                                    typeCheckerState.clear();
                                } else {
                                    supertypesDeque.add(transformType2);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                }
            }
            typeCheckerState.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(@NotNull TypeCheckerState typeCheckerState, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "start");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, TtmlNode.END);
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(typeCheckerState, simpleTypeMarker, typeConstructorMarker)) {
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
                    if (typeSystemContext.isMarkedNullable(pop)) {
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
                            if (INSTANCE.isApplicableAsEndNode(typeCheckerState, transformType2, typeConstructorMarker)) {
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

    public final boolean isPossibleSubtype(@NotNull TypeCheckerState typeCheckerState, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        return runIsPossibleSubtype(typeCheckerState, simpleTypeMarker, simpleTypeMarker2);
    }
}
