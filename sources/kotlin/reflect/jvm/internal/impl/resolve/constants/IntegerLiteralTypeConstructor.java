package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final ModuleDescriptor module;
    @NotNull
    private final Set<KotlinType> possibleTypes;
    @NotNull
    private final Lazy supertypes$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final SimpleType type;
    /* access modifiers changed from: private */
    public final long value;

    private IntegerLiteralTypeConstructor(long j11, ModuleDescriptor moduleDescriptor, Set<? extends KotlinType> set) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt__LazyJVMKt.lazy(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.value = j11;
        this.module = moduleDescriptor;
        this.possibleTypes = set;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j11, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, moduleDescriptor, set);
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean isContainsOnlyUnsignedTypes() {
        Iterable<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((allSignedLiteralTypes instanceof Collection) && ((Collection) allSignedLiteralTypes).isEmpty()) {
            return true;
        }
        for (KotlinType contains : allSignedLiteralTypes) {
            if (!(!this.possibleTypes.contains(contains))) {
                return false;
            }
        }
        return true;
    }

    private final String valueToString() {
        return '[' + CollectionsKt___CollectionsKt.joinToString$default(this.possibleTypes, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30, (Object) null) + AbstractJsonLexerKt.END_LIST;
    }

    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
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
    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    @NotNull
    /* renamed from: getSupertypes  reason: collision with other method in class */
    public Collection<KotlinType> m7569getSupertypes() {
        return getSupertypes();
    }

    public static final class Companion {

        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    Companion companion = IntegerLiteralTypeConstructor.Companion;
                    next = companion.fold((SimpleType) next, (SimpleType) it.next(), mode);
                }
                return (SimpleType) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType simpleType, SimpleType simpleType2, Mode mode) {
            if (simpleType == null || simpleType2 == null) {
                return null;
            }
            TypeConstructor constructor = simpleType.getConstructor();
            TypeConstructor constructor2 = simpleType2.getConstructor();
            boolean z11 = constructor instanceof IntegerLiteralTypeConstructor;
            if (z11 && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                return fold((IntegerLiteralTypeConstructor) constructor, (IntegerLiteralTypeConstructor) constructor2, mode);
            }
            if (z11) {
                return fold((IntegerLiteralTypeConstructor) constructor, simpleType2);
            }
            if (constructor2 instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) constructor2, simpleType);
            }
            return null;
        }

        @Nullable
        public final SimpleType findIntersectionType(@NotNull Collection<? extends SimpleType> collection) {
            Intrinsics.checkNotNullParameter(collection, "types");
            return findCommonSuperTypeOrIntersectionType(collection, Mode.INTERSECTION_TYPE);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set set;
            int i11 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i11 == 1) {
                set = CollectionsKt___CollectionsKt.intersect(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else if (i11 == 2) {
                set = CollectionsKt___CollectionsKt.union(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.value, integerLiteralTypeConstructor.module, set, (DefaultConstructorMarker) null), false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, SimpleType simpleType) {
            if (integerLiteralTypeConstructor.getPossibleTypes().contains(simpleType)) {
                return simpleType;
            }
            return null;
        }
    }
}
