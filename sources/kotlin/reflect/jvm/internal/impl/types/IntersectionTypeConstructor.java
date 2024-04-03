package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    @Nullable
    private KotlinType alternative;
    private final int hashCode;
    @NotNull
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(@NotNull Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = IntersectionTypeConstructor$makeDebugNameForIntersectionType$1.INSTANCE;
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    @NotNull
    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @NotNull
    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt__CollectionsKt.emptyList(), false, createScopeForKotlinType(), new IntersectionTypeConstructor$createType$1(this));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.intersectedTypes, (Object) ((IntersectionTypeConstructor) obj).intersectedTypes);
    }

    @Nullable
    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterato…xt().constructor.builtIns");
        return builtIns;
    }

    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public final String makeDebugNameForIntersectionType(@NotNull Function1<? super KotlinType, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "getProperTypeRelatedToStringify");
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sortedWith(this.intersectedTypes, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(function1)), " & ", "{", "}", 0, (CharSequence) null, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$3(function1), 24, (Object) null);
    }

    @NotNull
    public final IntersectionTypeConstructor setAlternative(@Nullable KotlinType kotlinType) {
        return new IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    @NotNull
    public String toString() {
        return makeDebugNameForIntersectionType$default(this, (Function1) null, 1, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v7, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor refine(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r5) {
        /*
            r4 = this;
            java.lang.String r0 = "kotlinTypeRefiner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Collection r0 = r4.getSupertypes()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x001b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0030
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.refine(r5)
            r1.add(r2)
            r2 = 1
            goto L_0x001b
        L_0x0030:
            r0 = 0
            if (r2 != 0) goto L_0x0034
            goto L_0x0047
        L_0x0034:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r4.getAlternativeType()
            if (r2 == 0) goto L_0x003e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r2.refine(r5)
        L_0x003e:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r5 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r5.<init>(r1)
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = r5.setAlternative(r0)
        L_0x0047:
            if (r0 != 0) goto L_0x004a
            r0 = r4
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor");
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }
}
