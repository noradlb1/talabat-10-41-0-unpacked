package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    @NotNull
    private final NotNullLazyValue<Supertypes> supertypes;

    public final class ModuleViewTypeConstructor implements TypeConstructor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbstractTypeConstructor f24932a;
        /* access modifiers changed from: private */
        @NotNull
        public final KotlinTypeRefiner kotlinTypeRefiner;
        @NotNull
        private final Lazy refinedSupertypes$delegate;

        public ModuleViewTypeConstructor(@NotNull AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner2) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            this.f24932a = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner2;
            this.refinedSupertypes$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, abstractTypeConstructor));
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public boolean equals(@Nullable Object obj) {
            return this.f24932a.equals(obj);
        }

        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.f24932a.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.f24932a.getDeclarationDescriptor();
        }

        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.f24932a.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f24932a.hashCode();
        }

        public boolean isDenotable() {
            return this.f24932a.isDenotable();
        }

        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner2) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            return this.f24932a.refine(kotlinTypeRefiner2);
        }

        @NotNull
        public String toString() {
            return this.f24932a.toString();
        }

        @NotNull
        public List<KotlinType> getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    public static final class Supertypes {
        @NotNull
        private final Collection<KotlinType> allSupertypes;
        @NotNull
        private List<? extends KotlinType> supertypesWithoutCycles = CollectionsKt__CollectionsJVMKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());

        public Supertypes(@NotNull Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(collection, "allSupertypes");
            this.allSupertypes = collection;
        }

        @NotNull
        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        @NotNull
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    /* access modifiers changed from: private */
    public final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z11) {
        AbstractTypeConstructor abstractTypeConstructor;
        List plus;
        if (typeConstructor instanceof AbstractTypeConstructor) {
            abstractTypeConstructor = (AbstractTypeConstructor) typeConstructor;
        } else {
            abstractTypeConstructor = null;
        }
        if (abstractTypeConstructor != null && (plus = CollectionsKt___CollectionsKt.plus(((Supertypes) abstractTypeConstructor.supertypes.invoke()).getAllSupertypes(), abstractTypeConstructor.e(z11))) != null) {
            return plus;
        }
        Collection<KotlinType> supertypes2 = typeConstructor.getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes2, "supertypes");
        return supertypes2;
    }

    @NotNull
    public abstract Collection<KotlinType> c();

    @Nullable
    public KotlinType d() {
        return null;
    }

    @NotNull
    public Collection<KotlinType> e(boolean z11) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public boolean f() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    @NotNull
    public abstract SupertypeLoopChecker g();

    @NotNull
    public List<KotlinType> h(@NotNull List<KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "supertypes");
        return list;
    }

    public void i(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    public void j(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    @NotNull
    public List<KotlinType> getSupertypes() {
        return ((Supertypes) this.supertypes.invoke()).getSupertypesWithoutCycles();
    }
}
