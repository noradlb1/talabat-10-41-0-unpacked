package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    private final NotNullLazyValue<SimpleType> defaultType;
    private final int index;
    private final boolean reified;
    private final StorageManager storageManager;
    private final NotNullLazyValue<TypeConstructor> typeConstructor;
    private final Variance variance;

    public class TypeParameterTypeConstructor extends AbstractTypeConstructor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbstractTypeParameterDescriptor f24511a;
        private final SupertypeLoopChecker supertypeLoopChecker;

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            String str = (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5 || i11 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5 || i11 == 8) ? 2 : 3)];
            switch (i11) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i11 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i11 == 2) {
                objArr[1] = "getParameters";
            } else if (i11 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i11 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i11 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i11 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i11) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5 || i11 == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TypeParameterTypeConstructor(@NotNull AbstractTypeParameterDescriptor abstractTypeParameterDescriptor, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker2) {
            super(storageManager);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            this.f24511a = abstractTypeParameterDescriptor;
            this.supertypeLoopChecker = supertypeLoopChecker2;
        }

        public boolean b(@NotNull ClassifierDescriptor classifierDescriptor) {
            if (classifierDescriptor == null) {
                $$$reportNull$$$0(9);
            }
            if (!(classifierDescriptor instanceof TypeParameterDescriptor) || !DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent(this.f24511a, (TypeParameterDescriptor) classifierDescriptor, true)) {
                return false;
            }
            return true;
        }

        @NotNull
        public Collection<KotlinType> c() {
            List<KotlinType> b11 = this.f24511a.b();
            if (b11 == null) {
                $$$reportNull$$$0(1);
            }
            return b11;
        }

        @Nullable
        public KotlinType d() {
            return ErrorUtils.createErrorType(ErrorTypeKind.CYCLIC_UPPER_BOUNDS, new String[0]);
        }

        @NotNull
        public SupertypeLoopChecker g() {
            SupertypeLoopChecker supertypeLoopChecker2 = this.supertypeLoopChecker;
            if (supertypeLoopChecker2 == null) {
                $$$reportNull$$$0(5);
            }
            return supertypeLoopChecker2;
        }

        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(this.f24511a);
            if (builtIns == null) {
                $$$reportNull$$$0(4);
            }
            return builtIns;
        }

        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = this.f24511a;
            if (abstractTypeParameterDescriptor == null) {
                $$$reportNull$$$0(3);
            }
            return abstractTypeParameterDescriptor;
        }

        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> emptyList = Collections.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(2);
            }
            return emptyList;
        }

        @NotNull
        public List<KotlinType> h(@NotNull List<KotlinType> list) {
            if (list == null) {
                $$$reportNull$$$0(7);
            }
            List<KotlinType> a11 = this.f24511a.a(list);
            if (a11 == null) {
                $$$reportNull$$$0(8);
            }
            return a11;
        }

        public boolean isDenotable() {
            return true;
        }

        public void j(@NotNull KotlinType kotlinType) {
            if (kotlinType == null) {
                $$$reportNull$$$0(6);
            }
            this.f24511a.reportSupertypeLoopError(kotlinType);
        }

        public String toString() {
            return this.f24511a.getName().toString();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str;
        int i12;
        Throwable th2;
        switch (i11) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i11) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i12 = 2;
                break;
            default:
                i12 = 3;
                break;
        }
        Object[] objArr = new Object[i12];
        switch (i11) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = Param.BOUNDS;
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i11) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
        }
        switch (i11) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        switch (i11) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                th2 = new IllegalStateException(format);
                break;
            default:
                th2 = new IllegalArgumentException(format);
                break;
        }
        throw th2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeParameterDescriptor(@NotNull final StorageManager storageManager2, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull final Name name2, @NotNull Variance variance2, boolean z11, int i11, @NotNull SourceElement sourceElement, @NotNull final SupertypeLoopChecker supertypeLoopChecker) {
        super(declarationDescriptor, annotations, name2, sourceElement);
        if (storageManager2 == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
        if (name2 == null) {
            $$$reportNull$$$0(3);
        }
        if (variance2 == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (supertypeLoopChecker == null) {
            $$$reportNull$$$0(6);
        }
        this.variance = variance2;
        this.reified = z11;
        this.index = i11;
        this.typeConstructor = storageManager2.createLazyValue(new Function0<TypeConstructor>() {
            public TypeConstructor invoke() {
                return new TypeParameterTypeConstructor(AbstractTypeParameterDescriptor.this, storageManager2, supertypeLoopChecker);
            }
        });
        this.defaultType = storageManager2.createLazyValue(new Function0<SimpleType>() {
            public SimpleType invoke() {
                return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), AbstractTypeParameterDescriptor.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(new Function0<MemberScope>() {
                    public MemberScope invoke() {
                        return TypeIntersectionScope.create("Scope for type parameter " + name2.asString(), AbstractTypeParameterDescriptor.this.getUpperBounds());
                    }
                }));
            }
        });
        this.storageManager = storageManager2;
    }

    @NotNull
    public List<KotlinType> a(@NotNull List<KotlinType> list) {
        if (list == null) {
            $$$reportNull$$$0(12);
        }
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        return list;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d11);
    }

    @NotNull
    public abstract List<KotlinType> b();

    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType = (SimpleType) this.defaultType.invoke();
        if (simpleType == null) {
            $$$reportNull$$$0(10);
        }
        return simpleType;
    }

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public StorageManager getStorageManager() {
        StorageManager storageManager2 = this.storageManager;
        if (storageManager2 == null) {
            $$$reportNull$$$0(14);
        }
        return storageManager2;
    }

    @NotNull
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = (TypeConstructor) this.typeConstructor.invoke();
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(9);
        }
        return typeConstructor2;
    }

    @NotNull
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> supertypes = ((TypeParameterTypeConstructor) getTypeConstructor()).getSupertypes();
        if (supertypes == null) {
            $$$reportNull$$$0(8);
        }
        return supertypes;
    }

    @NotNull
    public Variance getVariance() {
        Variance variance2 = this.variance;
        if (variance2 == null) {
            $$$reportNull$$$0(7);
        }
        return variance2;
    }

    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    public boolean isReified() {
        return this.reified;
    }

    public abstract void reportSupertypeLoopError(@NotNull KotlinType kotlinType);

    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.getOriginal();
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(11);
        }
        return typeParameterDescriptor;
    }
}
