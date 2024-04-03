package net.bytebuddy.dynamic.scaffold.inline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.CompoundList;

@HashCodeAndEqualsPlugin.Enhance
public class RebaseImplementationTarget extends Implementation.Target.AbstractBase {
    private final Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> rebaseableMethods;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Factory implements Implementation.Target.Factory {
        private final MethodRebaseResolver methodRebaseResolver;

        public Factory(MethodRebaseResolver methodRebaseResolver2) {
            this.methodRebaseResolver = methodRebaseResolver2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodRebaseResolver.equals(((Factory) obj).methodRebaseResolver);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.methodRebaseResolver.hashCode();
        }

        public Implementation.Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion) {
            return RebaseImplementationTarget.a(typeDescription, linked, classFileVersion, this.methodRebaseResolver);
        }
    }

    public static class RebasedMethodInvocation extends Implementation.SpecialMethodInvocation.AbstractBase {
        private final TypeDescription instrumentedType;
        private final MethodDescription methodDescription;
        private final TypeList prependedParameters;
        private final StackManipulation stackManipulation;

        public RebasedMethodInvocation(MethodDescription methodDescription2, TypeDescription typeDescription, StackManipulation stackManipulation2, TypeList typeList) {
            this.methodDescription = methodDescription2;
            this.instrumentedType = typeDescription;
            this.stackManipulation = stackManipulation2;
            this.prependedParameters = typeList;
        }

        public static Implementation.SpecialMethodInvocation a(MethodDescription methodDescription2, TypeDescription typeDescription, TypeList typeList) {
            StackManipulation stackManipulation2;
            if (methodDescription2.isStatic()) {
                stackManipulation2 = MethodInvocation.invoke(methodDescription2);
            } else {
                stackManipulation2 = MethodInvocation.invoke(methodDescription2).special(typeDescription);
            }
            if (!stackManipulation2.isValid()) {
                return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
            }
            ArrayList arrayList = new ArrayList(typeList.size() + 1);
            Iterator it = typeList.iterator();
            while (it.hasNext()) {
                arrayList.add(DefaultValue.of((TypeDescription) it.next()));
            }
            arrayList.add(stackManipulation2);
            return new RebasedMethodInvocation(methodDescription2, typeDescription, new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), typeList);
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return this.stackManipulation.apply(methodVisitor, context);
        }

        public MethodDescription getMethodDescription() {
            return this.methodDescription;
        }

        public TypeDescription getTypeDescription() {
            return this.instrumentedType;
        }

        public Implementation.SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
            if (this.methodDescription.asTypeToken().equals(new MethodDescription.TypeToken(typeToken.getReturnType(), CompoundList.of(typeToken.getParameterTypes(), (List<TypeDescription>) this.prependedParameters)))) {
                return this;
            }
            return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
        }
    }

    public RebaseImplementationTarget(TypeDescription typeDescription, MethodGraph.Linked linked, Implementation.Target.AbstractBase.DefaultMethodInvocation defaultMethodInvocation, Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> map) {
        super(typeDescription, linked, defaultMethodInvocation);
        this.rebaseableMethods = map;
    }

    public static Implementation.Target a(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion, MethodRebaseResolver methodRebaseResolver) {
        return new RebaseImplementationTarget(typeDescription, linked, Implementation.Target.AbstractBase.DefaultMethodInvocation.of(classFileVersion), methodRebaseResolver.asTokenMap());
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.rebaseableMethods.equals(((RebaseImplementationTarget) obj).rebaseableMethods);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.rebaseableMethods.hashCode();
    }

    public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken) {
        MethodRebaseResolver.Resolution resolution = this.rebaseableMethods.get(signatureToken);
        if (resolution == null) {
            return invokeSuper(this.f27276b.getSuperClassGraph().locate(signatureToken));
        }
        return invokeSuper(resolution);
    }

    public TypeDescription getOriginType() {
        return this.f27275a;
    }

    private Implementation.SpecialMethodInvocation invokeSuper(MethodGraph.Node node) {
        return node.getSort().isResolved() ? Implementation.SpecialMethodInvocation.Simple.of(node.getRepresentative(), this.f27275a.getSuperClass().asErasure()) : Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    private Implementation.SpecialMethodInvocation invokeSuper(MethodRebaseResolver.Resolution resolution) {
        if (resolution.isRebased()) {
            return RebasedMethodInvocation.a(resolution.getResolvedMethod(), this.f27275a, resolution.getPrependedParameters());
        }
        return Implementation.SpecialMethodInvocation.Simple.of(resolution.getResolvedMethod(), this.f27275a);
    }
}
