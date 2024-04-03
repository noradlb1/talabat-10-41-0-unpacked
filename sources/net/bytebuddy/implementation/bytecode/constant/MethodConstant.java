package net.bytebuddy.implementation.bytecode.constant;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.PrivilegedMemberLookupAction;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;

public abstract class MethodConstant extends StackManipulation.AbstractBase {

    /* renamed from: c  reason: collision with root package name */
    public static final MethodDescription.InDefinedShape f27336c = doPrivileged();

    /* renamed from: b  reason: collision with root package name */
    public final MethodDescription.InDefinedShape f27337b;

    public static class CachedConstructor implements StackManipulation {
        private static final TypeDescription CONSTRUCTOR_TYPE = TypeDescription.ForLoadedType.of(Constructor.class);
        private final StackManipulation constructorConstant;

        public CachedConstructor(StackManipulation stackManipulation) {
            this.constructorConstant = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.constructorConstant, CONSTRUCTOR_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.constructorConstant.equals(((CachedConstructor) obj).constructorConstant);
        }

        public int hashCode() {
            return this.constructorConstant.hashCode();
        }

        public boolean isValid() {
            return this.constructorConstant.isValid();
        }
    }

    public static class CachedMethod implements StackManipulation {
        private static final TypeDescription METHOD_TYPE = TypeDescription.ForLoadedType.of(Method.class);
        private final StackManipulation methodConstant;

        public CachedMethod(StackManipulation stackManipulation) {
            this.methodConstant = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.methodConstant, METHOD_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodConstant.equals(((CachedMethod) obj).methodConstant);
        }

        public int hashCode() {
            return this.methodConstant.hashCode();
        }

        public boolean isValid() {
            return this.methodConstant.isValid();
        }
    }

    public interface CanCache extends StackManipulation {
        StackManipulation cached();
    }

    public enum CanCacheIllegal implements CanCache {
        INSTANCE;

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackManipulation.Illegal.INSTANCE.apply(methodVisitor, context);
        }

        public StackManipulation cached() {
            return StackManipulation.Illegal.INSTANCE;
        }

        public boolean isValid() {
            return false;
        }
    }

    public static class ForConstructor extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_CONSTRUCTOR;
        private static final MethodDescription.InDefinedShape GET_DECLARED_CONSTRUCTOR;

        static {
            Class<Class[]> cls = Class[].class;
            Class<Class> cls2 = Class.class;
            try {
                GET_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(cls2.getMethod("getConstructor", new Class[]{cls}));
                GET_DECLARED_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(cls2.getMethod(TypeProxy.SilentConstruction.Appender.GET_DECLARED_CONSTRUCTOR_METHOD_NAME, new Class[]{cls}));
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Could not locate Class::getDeclaredConstructor", e11);
            }
        }

        public ForConstructor(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        public MethodDescription.InDefinedShape a() {
            return this.f27337b.isPublic() ? GET_CONSTRUCTOR : GET_DECLARED_CONSTRUCTOR;
        }

        public StackManipulation b() {
            return StackManipulation.Trivial.INSTANCE;
        }

        public StackManipulation cached() {
            return new CachedConstructor(this);
        }
    }

    public static class ForMethod extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_DECLARED_METHOD;
        private static final MethodDescription.InDefinedShape GET_METHOD;

        static {
            Class<Class[]> cls = Class[].class;
            Class<String> cls2 = String.class;
            Class<Class> cls3 = Class.class;
            try {
                GET_METHOD = new MethodDescription.ForLoadedMethod(cls3.getMethod("getMethod", new Class[]{cls2, cls}));
                GET_DECLARED_METHOD = new MethodDescription.ForLoadedMethod(cls3.getMethod("getDeclaredMethod", new Class[]{cls2, cls}));
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Could not locate method lookup", e11);
            }
        }

        public ForMethod(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        public MethodDescription.InDefinedShape a() {
            return this.f27337b.isPublic() ? GET_METHOD : GET_DECLARED_METHOD;
        }

        public StackManipulation b() {
            return new TextConstant(this.f27337b.getInternalName());
        }

        public StackManipulation cached() {
            return new CachedMethod(this);
        }
    }

    public static class PrivilegedLookup implements StackManipulation, CanCache {
        private final MethodDescription.InDefinedShape methodDescription;
        private final StackManipulation methodName;

        public PrivilegedLookup(MethodDescription.InDefinedShape inDefinedShape, StackManipulation stackManipulation) {
            this.methodDescription = inDefinedShape;
            this.methodName = stackManipulation;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Class cls;
            TypeDescription register = context.register(PrivilegedMemberLookupAction.of(this.methodDescription));
            StackManipulation[] stackManipulationArr = new StackManipulation[8];
            stackManipulationArr[0] = TypeCreation.of(register);
            stackManipulationArr[1] = Duplication.SINGLE;
            stackManipulationArr[2] = ClassConstant.of(this.methodDescription.getDeclaringType());
            stackManipulationArr[3] = this.methodName;
            stackManipulationArr[4] = ArrayFactory.forType(TypeDescription.Generic.CLASS).withValues(MethodConstant.c(this.methodDescription.getParameters().asTypeList().asErasures()));
            stackManipulationArr[5] = MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) register.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly());
            stackManipulationArr[6] = MethodInvocation.invoke(MethodConstant.f27336c);
            if (this.methodDescription.isConstructor()) {
                cls = Constructor.class;
            } else {
                cls = Method.class;
            }
            stackManipulationArr[7] = TypeCasting.to(TypeDescription.ForLoadedType.of(cls));
            return new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context);
        }

        public StackManipulation cached() {
            return this.methodDescription.isConstructor() ? new CachedConstructor(this) : new CachedMethod(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodDescription.equals(((PrivilegedLookup) obj).methodDescription);
        }

        public int hashCode() {
            return this.methodDescription.hashCode();
        }

        public boolean isValid() {
            return this.methodName.isValid();
        }
    }

    public MethodConstant(MethodDescription.InDefinedShape inDefinedShape) {
        this.f27337b = inDefinedShape;
    }

    public static List<StackManipulation> c(List<TypeDescription> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeDescription of2 : list) {
            arrayList.add(ClassConstant.of(of2));
        }
        return arrayList;
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but be nulled out", value = {"REC_CATCH_EXCEPTION"})
    private static MethodDescription.InDefinedShape doPrivileged() {
        try {
            MethodDescription.ForLoadedMethod forLoadedMethod = new MethodDescription.ForLoadedMethod(Class.forName("java.security.AccessController").getMethod("doPrivileged", new Class[]{PrivilegedExceptionAction.class}));
            try {
                if (!Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"))) {
                    return null;
                }
            } catch (SecurityException unused) {
            }
            return forLoadedMethod;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static CanCache of(MethodDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isTypeInitializer()) {
            return CanCacheIllegal.INSTANCE;
        }
        if (inDefinedShape.isConstructor()) {
            return new ForConstructor(inDefinedShape);
        }
        return new ForMethod(inDefinedShape);
    }

    public static CanCache ofPrivileged(MethodDescription.InDefinedShape inDefinedShape) {
        if (f27336c == null) {
            return of(inDefinedShape);
        }
        if (inDefinedShape.isTypeInitializer()) {
            return CanCacheIllegal.INSTANCE;
        }
        if (inDefinedShape.isConstructor()) {
            return new ForConstructor(inDefinedShape).d();
        }
        return new ForMethod(inDefinedShape).d();
    }

    public abstract MethodDescription.InDefinedShape a();

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        return new StackManipulation.Compound(ClassConstant.of(this.f27337b.getDeclaringType()), b(), ArrayFactory.forType(TypeDescription.Generic.CLASS).withValues(c(this.f27337b.getParameters().asTypeList().asErasures())), MethodInvocation.invoke(a())).apply(methodVisitor, context);
    }

    public abstract StackManipulation b();

    public CanCache d() {
        return new PrivilegedLookup(this.f27337b, b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f27337b.equals(((MethodConstant) obj).f27337b);
    }

    public int hashCode() {
        return this.f27337b.hashCode();
    }
}
