package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersector {
    @NotNull
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    public enum ResultNullability {
        ;

        public static final class ACCEPT_NULL extends ResultNullability {
            public ACCEPT_NULL(String str, int i11) {
                super(str, i11, (DefaultConstructorMarker) null);
            }

            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return a(unwrappedType);
            }
        }

        public static final class NOT_NULL extends ResultNullability {
            public NOT_NULL(String str, int i11) {
                super(str, i11, (DefaultConstructorMarker) null);
            }

            @NotNull
            public NOT_NULL combine(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return this;
            }
        }

        public static final class START extends ResultNullability {
            public START(String str, int i11) {
                super(str, i11, (DefaultConstructorMarker) null);
            }

            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return a(unwrappedType);
            }
        }

        public static final class UNKNOWN extends ResultNullability {
            public UNKNOWN(String str, int i11) {
                super(str, i11, (DefaultConstructorMarker) null);
            }

            @NotNull
            public ResultNullability combine(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                ResultNullability a11 = a(unwrappedType);
                if (a11 == ResultNullability.ACCEPT_NULL) {
                    return this;
                }
                return a11;
            }
        }

        @NotNull
        public final ResultNullability a(@NotNull UnwrappedType unwrappedType) {
            Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            if ((unwrappedType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) unwrappedType).getOriginal() instanceof StubTypeForBuilderInference)) {
                return NOT_NULL;
            }
            if (unwrappedType instanceof StubTypeForBuilderInference) {
                return UNKNOWN;
            }
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }

        @NotNull
        public abstract ResultNullability combine(@NotNull UnwrappedType unwrappedType);
    }

    private TypeIntersector() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            boolean r2 = r0.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x0022
            goto L_0x0051
        L_0x0022:
            java.util.Iterator r2 = r0.iterator()
        L_0x0026:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r4
            r5 = 1
            if (r4 == r1) goto L_0x004d
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.Object r4 = r9.invoke(r4, r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x004d
            r4 = r5
            goto L_0x004e
        L_0x004d:
            r4 = r3
        L_0x004e:
            if (r4 == 0) goto L_0x0026
            r3 = r5
        L_0x0051:
            if (r3 == 0) goto L_0x000e
            r8.remove()
            goto L_0x000e
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.filterTypes(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(set);
        }
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection<SimpleType> filterTypes = filterTypes(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        filterTypes.isEmpty();
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
        if (findIntersectionType != null) {
            return findIntersectionType;
        }
        Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        filterTypes2.isEmpty();
        if (filterTypes2.size() < 2) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(filterTypes2);
        }
        return new IntersectionTypeConstructor(set).createType();
    }

    /* access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        if (!newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) || newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final SimpleType intersectTypes$descriptors(@NotNull List<? extends SimpleType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<UnwrappedType> arrayList = new ArrayList<>();
        for (SimpleType simpleType : list) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> supertypes = simpleType.getConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                Iterable<KotlinType> iterable = supertypes;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (KotlinType kotlinType : iterable) {
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(kotlinType);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (UnwrappedType combine : arrayList) {
            resultNullability = resultNullability.combine(combine);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SimpleType simpleType2 = (SimpleType) it.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (simpleType2 instanceof NewCapturedType) {
                    simpleType2 = SpecialTypesKt.withNotNullProjection((NewCapturedType) simpleType2);
                }
                simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(simpleType2, false, 1, (Object) null);
            }
            linkedHashSet.add(simpleType2);
        }
        Iterable<SimpleType> iterable2 = list;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (SimpleType attributes : iterable2) {
            arrayList3.add(attributes.getAttributes());
        }
        Iterator it2 = arrayList3.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = ((TypeAttributes) next).intersect((TypeAttributes) it2.next());
            }
            return intersectTypesWithoutIntersectionType(linkedHashSet).replaceAttributes((TypeAttributes) next);
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
