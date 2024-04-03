package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClassDescriptor extends ModuleAwareClassDescriptor {

    /* renamed from: b  reason: collision with root package name */
    public final NotNullLazyValue<SimpleType> f24496b;

    /* renamed from: name  reason: collision with root package name */
    private final Name f24497name;
    private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;
    private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        int i12 = i11;
        String str = (i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5 || i12 == 6 || i12 == 9 || i12 == 12 || i12 == 14 || i12 == 16 || i12 == 17 || i12 == 19 || i12 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5 || i12 == 6 || i12 == 9 || i12 == 12 || i12 == 14 || i12 == 16 || i12 == 17 || i12 == 19 || i12 == 20) ? 2 : 3)];
        switch (i12) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i12 == 2) {
            objArr[1] = "getName";
        } else if (i12 == 3) {
            objArr[1] = "getOriginal";
        } else if (i12 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i12 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i12 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i12 == 9 || i12 == 12 || i12 == 14 || i12 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i12 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i12 == 19) {
            objArr[1] = "substitute";
        } else if (i12 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i12) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String format = String.format(str, objArr);
        throw ((i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5 || i12 == 6 || i12 == 9 || i12 == 12 || i12 == 14 || i12 == 16 || i12 == 17 || i12 == 19 || i12 == 20) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public AbstractClassDescriptor(@NotNull StorageManager storageManager, @NotNull Name name2) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        if (name2 == null) {
            $$$reportNull$$$0(1);
        }
        this.f24497name = name2;
        this.f24496b = storageManager.createLazyValue(new Function0<SimpleType>() {
            public SimpleType invoke() {
                AbstractClassDescriptor abstractClassDescriptor = AbstractClassDescriptor.this;
                return TypeUtils.makeUnsubstitutedType((ClassifierDescriptor) abstractClassDescriptor, abstractClassDescriptor.getUnsubstitutedMemberScope(), (Function1<KotlinTypeRefiner, SimpleType>) new Function1<KotlinTypeRefiner, SimpleType>() {
                    public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                        ClassifierDescriptor refineDescriptor = kotlinTypeRefiner.refineDescriptor(AbstractClassDescriptor.this);
                        if (refineDescriptor == null) {
                            return (SimpleType) AbstractClassDescriptor.this.f24496b.invoke();
                        }
                        if (refineDescriptor instanceof TypeAliasDescriptor) {
                            return KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) refineDescriptor, TypeUtils.getDefaultTypeProjections(refineDescriptor.getTypeConstructor().getParameters()));
                        }
                        if (refineDescriptor instanceof ModuleAwareClassDescriptor) {
                            return TypeUtils.makeUnsubstitutedType(refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner), ((ModuleAwareClassDescriptor) refineDescriptor).getUnsubstitutedMemberScope(kotlinTypeRefiner), (Function1<KotlinTypeRefiner, SimpleType>) this);
                        }
                        return refineDescriptor.getDefaultType();
                    }
                });
            }
        });
        this.unsubstitutedInnerClassesScope = storageManager.createLazyValue(new Function0<MemberScope>() {
            public MemberScope invoke() {
                return new InnerClassesScopeWrapper(AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
            }
        });
        this.thisAsReceiverParameter = storageManager.createLazyValue(new Function0<ReceiverParameterDescriptor>() {
            public ReceiverParameterDescriptor invoke() {
                return new LazyClassReceiverParameterDescriptor(AbstractClassDescriptor.this);
            }
        });
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d11) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d11);
    }

    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(6);
        }
        return emptyList;
    }

    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType = (SimpleType) this.f24496b.invoke();
        if (simpleType == null) {
            $$$reportNull$$$0(20);
        }
        return simpleType;
    }

    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(10);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(11);
        }
        if (typeSubstitution.isEmpty()) {
            MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(kotlinTypeRefiner);
            if (unsubstitutedMemberScope == null) {
                $$$reportNull$$$0(12);
            }
            return unsubstitutedMemberScope;
        }
        return new SubstitutingScope(getUnsubstitutedMemberScope(kotlinTypeRefiner), TypeSubstitutor.create(typeSubstitution));
    }

    @NotNull
    public Name getName() {
        Name name2 = this.f24497name;
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        return name2;
    }

    @NotNull
    public ClassDescriptor getOriginal() {
        return this;
    }

    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) this.thisAsReceiverParameter.invoke();
        if (receiverParameterDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        return receiverParameterDescriptor;
    }

    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = (MemberScope) this.unsubstitutedInnerClassesScope.invoke();
        if (memberScope == null) {
            $$$reportNull$$$0(4);
        }
        return memberScope;
    }

    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(17);
        }
        return unsubstitutedMemberScope;
    }

    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(18);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new LazySubstitutingClassDescriptor(this, typeSubstitutor);
    }

    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(15);
        }
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            $$$reportNull$$$0(16);
        }
        return memberScope;
    }
}
