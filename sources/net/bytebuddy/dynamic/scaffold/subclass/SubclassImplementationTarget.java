package net.bytebuddy.dynamic.scaffold.subclass;

import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;

@HashCodeAndEqualsPlugin.Enhance
public class SubclassImplementationTarget extends Implementation.Target.AbstractBase {

    /* renamed from: d  reason: collision with root package name */
    public final OriginTypeResolver f27249d;

    public enum Factory implements Implementation.Target.Factory {
        SUPER_CLASS(OriginTypeResolver.SUPER_CLASS),
        LEVEL_TYPE(OriginTypeResolver.LEVEL_TYPE);
        
        private final OriginTypeResolver originTypeResolver;

        private Factory(OriginTypeResolver originTypeResolver2) {
            this.originTypeResolver = originTypeResolver2;
        }

        public Implementation.Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion) {
            return new SubclassImplementationTarget(typeDescription, linked, Implementation.Target.AbstractBase.DefaultMethodInvocation.of(classFileVersion), this.originTypeResolver);
        }
    }

    public enum OriginTypeResolver {
        SUPER_CLASS {
            public TypeDefinition a(TypeDescription typeDescription) {
                return typeDescription.getSuperClass();
            }
        },
        LEVEL_TYPE {
            public TypeDefinition a(TypeDescription typeDescription) {
                return typeDescription;
            }
        };

        public abstract TypeDefinition a(TypeDescription typeDescription);
    }

    public SubclassImplementationTarget(TypeDescription typeDescription, MethodGraph.Linked linked, Implementation.Target.AbstractBase.DefaultMethodInvocation defaultMethodInvocation, OriginTypeResolver originTypeResolver) {
        super(typeDescription, linked, defaultMethodInvocation);
        this.f27249d = originTypeResolver;
    }

    private Implementation.SpecialMethodInvocation invokeConstructor(MethodDescription.SignatureToken signatureToken) {
        FilterableList filterableList;
        TypeDescription.Generic superClass = this.f27275a.getSuperClass();
        if (superClass == null) {
            filterableList = new MethodList.Empty();
        } else {
            filterableList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.hasSignature(signatureToken).and(ElementMatchers.isVisibleTo(this.f27275a)));
        }
        if (filterableList.size() == 1) {
            return Implementation.SpecialMethodInvocation.Simple.of((MethodDescription) filterableList.getOnly(), this.f27275a.getSuperClass().asErasure());
        }
        return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    private Implementation.SpecialMethodInvocation invokeMethod(MethodDescription.SignatureToken signatureToken) {
        MethodGraph.Node locate = this.f27276b.getSuperClassGraph().locate(signatureToken);
        if (locate.getSort().isUnique()) {
            return Implementation.SpecialMethodInvocation.Simple.of(locate.getRepresentative(), this.f27275a.getSuperClass().asErasure());
        }
        return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f27249d.equals(((SubclassImplementationTarget) obj).f27249d);
    }

    public TypeDefinition getOriginType() {
        return this.f27249d.a(this.f27275a);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.f27249d.hashCode();
    }

    public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken) {
        if (signatureToken.getName().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            return invokeConstructor(signatureToken);
        }
        return invokeMethod(signatureToken);
    }
}
