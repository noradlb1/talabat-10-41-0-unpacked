package net.bytebuddy.implementation.bind.annotation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.Default;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import net.bytebuddy.implementation.bind.annotation.Empty;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.StubValue;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.This;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

@HashCodeAndEqualsPlugin.Enhance
public class TargetMethodAnnotationDrivenBinder implements MethodDelegationBinder {
    private final DelegationProcessor delegationProcessor;

    @HashCodeAndEqualsPlugin.Enhance
    public static class DelegationProcessor {
        private final Map<? extends TypeDescription, ? extends ParameterBinder<?>> parameterBinders;

        public interface Handler {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Bound<T extends Annotation> implements Handler {
                private final AnnotationDescription.Loadable<T> annotation;
                private final ParameterBinder<T> parameterBinder;
                private final ParameterDescription target;
                private final Assigner.Typing typing;

                public Bound(ParameterDescription parameterDescription, ParameterBinder<T> parameterBinder2, AnnotationDescription.Loadable<T> loadable, Assigner.Typing typing2) {
                    this.target = parameterDescription;
                    this.parameterBinder = parameterBinder2;
                    this.annotation = loadable;
                    this.typing = typing2;
                }

                public static Handler a(ParameterDescription parameterDescription, ParameterBinder<?> parameterBinder2, AnnotationDescription annotationDescription, Assigner.Typing typing2) {
                    return new Bound(parameterDescription, parameterBinder2, annotationDescription.prepare(parameterBinder2.getHandledType()), typing2);
                }

                public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target2, Assigner assigner) {
                    return this.parameterBinder.bind(this.annotation, methodDescription, this.target, target2, assigner, this.typing);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Bound bound = (Bound) obj;
                    return this.typing.equals(bound.typing) && this.target.equals(bound.target) && this.parameterBinder.equals(bound.parameterBinder) && this.annotation.equals(bound.annotation);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.parameterBinder.hashCode()) * 31) + this.annotation.hashCode()) * 31) + this.typing.hashCode();
                }

                public boolean isBound() {
                    return true;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unbound implements Handler {
                private final ParameterDescription target;
                private final Assigner.Typing typing;

                public static class DefaultArgument implements Argument {
                    private static final String BINDING_MECHANIC = "bindingMechanic";
                    private static final String VALUE = "value";
                    private final int parameterIndex;

                    public DefaultArgument(int i11) {
                        this.parameterIndex = i11;
                    }

                    public Class<Argument> annotationType() {
                        return Argument.class;
                    }

                    public Argument.BindingMechanic bindingMechanic() {
                        return Argument.BindingMechanic.UNIQUE;
                    }

                    public boolean equals(Object obj) {
                        return this == obj || ((obj instanceof Argument) && this.parameterIndex == ((Argument) obj).value());
                    }

                    public int hashCode() {
                        return (Argument.BindingMechanic.UNIQUE.hashCode() ^ 1957906263) + (1335633679 ^ this.parameterIndex);
                    }

                    public String toString() {
                        return "@" + Argument.class.getName() + "(bindingMechanic=" + Argument.BindingMechanic.UNIQUE.toString() + ", value=" + this.parameterIndex + ")";
                    }

                    public int value() {
                        return this.parameterIndex;
                    }
                }

                public Unbound(ParameterDescription parameterDescription, Assigner.Typing typing2) {
                    this.target = parameterDescription;
                    this.typing = typing2;
                }

                public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target2, Assigner assigner) {
                    return Argument.Binder.INSTANCE.bind(AnnotationDescription.ForLoadedAnnotation.of(new DefaultArgument(this.target.getIndex())), methodDescription, this.target, target2, assigner, this.typing);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Unbound unbound = (Unbound) obj;
                    return this.typing.equals(unbound.typing) && this.target.equals(unbound.target);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.typing.hashCode();
                }

                public boolean isBound() {
                    return false;
                }
            }

            MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target, Assigner assigner);

            boolean isBound();
        }

        public DelegationProcessor(Map<? extends TypeDescription, ? extends ParameterBinder<?>> map) {
            this.parameterBinders = map;
        }

        public static DelegationProcessor a(List<? extends ParameterBinder<?>> list) {
            HashMap hashMap = new HashMap();
            for (ParameterBinder parameterBinder : list) {
                if (hashMap.put(TypeDescription.ForLoadedType.of(parameterBinder.getHandledType()), parameterBinder) != null) {
                    throw new IllegalArgumentException("Attempt to bind two handlers to " + parameterBinder.getHandledType());
                }
            }
            return new DelegationProcessor(hashMap);
        }

        public Handler b(ParameterDescription parameterDescription) {
            Assigner.Typing check = RuntimeType.Verifier.check(parameterDescription);
            Handler unbound = new Handler.Unbound(parameterDescription, check);
            for (AnnotationDescription annotationDescription : parameterDescription.getDeclaredAnnotations()) {
                ParameterBinder parameterBinder = (ParameterBinder) this.parameterBinders.get(annotationDescription.getAnnotationType());
                if (parameterBinder != null && unbound.isBound()) {
                    throw new IllegalStateException("Ambiguous binding for parameter annotated with two handled annotation types");
                } else if (parameterBinder != null) {
                    unbound = Handler.Bound.a(parameterDescription, parameterBinder, annotationDescription, check);
                }
            }
            return unbound;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.parameterBinders.equals(((DelegationProcessor) obj).parameterBinders);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.parameterBinders.hashCode();
        }
    }

    @SuppressFBWarnings(justification = "Safe initialization is implied", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
    public interface ParameterBinder<T extends Annotation> {
        public static final List<ParameterBinder<?>> DEFAULTS = Collections.unmodifiableList(Arrays.asList(new ParameterBinder[]{Argument.Binder.INSTANCE, AllArguments.Binder.INSTANCE, Origin.Binder.INSTANCE, This.Binder.INSTANCE, Super.Binder.INSTANCE, Default.Binder.INSTANCE, SuperCall.Binder.INSTANCE, DefaultCall.Binder.INSTANCE, SuperMethod.Binder.INSTANCE, DefaultMethod.Binder.INSTANCE, FieldValue.Binder.INSTANCE, StubValue.Binder.INSTANCE, Empty.Binder.INSTANCE}));

        public static abstract class ForFieldBinding<S extends Annotation> implements ParameterBinder<S> {
            private static FieldLocator.Resolution resolveAccessor(FieldLocator fieldLocator, MethodDescription methodDescription) {
                String str;
                int i11 = 3;
                if (ElementMatchers.isSetter().matches(methodDescription)) {
                    str = methodDescription.getInternalName().substring(3);
                } else if (!ElementMatchers.isGetter().matches(methodDescription)) {
                    return FieldLocator.Resolution.Illegal.INSTANCE;
                } else {
                    String internalName = methodDescription.getInternalName();
                    if (methodDescription.getInternalName().startsWith("is")) {
                        i11 = 2;
                    }
                    str = internalName.substring(i11);
                }
                return fieldLocator.locate(Character.toLowerCase(str.charAt(0)) + str.substring(1));
            }

            public abstract MethodDelegationBinder.ParameterBinding<?> a(FieldDescription fieldDescription, AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner);

            public abstract TypeDescription b(AnnotationDescription.Loadable<S> loadable);

            public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
                FieldLocator fieldLocator;
                FieldLocator.Resolution resolution;
                if (!b(loadable).represents(Void.TYPE)) {
                    if (b(loadable).isPrimitive() || b(loadable).isArray()) {
                        throw new IllegalStateException("A primitive type or array type cannot declare a field: " + methodDescription);
                    } else if (!target.getInstrumentedType().isAssignableTo(b(loadable))) {
                        return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                    }
                }
                if (b(loadable).represents(Void.TYPE)) {
                    fieldLocator = new FieldLocator.ForClassHierarchy(target.getInstrumentedType());
                } else {
                    fieldLocator = new FieldLocator.ForExactType(b(loadable), target.getInstrumentedType());
                }
                if (c(loadable).equals("")) {
                    resolution = resolveAccessor(fieldLocator, methodDescription);
                } else {
                    resolution = fieldLocator.locate(c(loadable));
                }
                if (!resolution.isResolved() || (methodDescription.isStatic() && !resolution.getField().isStatic())) {
                    return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                }
                return a(resolution.getField(), loadable, methodDescription, parameterDescription, target, assigner);
            }

            public abstract String c(AnnotationDescription.Loadable<S> loadable);
        }

        public static abstract class ForFixedValue<S extends Annotation> implements ParameterBinder<S> {

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfConstant<U extends Annotation> extends ForFixedValue<U> {
                private final Class<U> type;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Object value;

                public OfConstant(Class<U> cls, Object obj) {
                    this.type = cls;
                    this.value = obj;
                }

                public static <V extends Annotation> ParameterBinder<V> of(Class<V> cls, Object obj) {
                    return new OfConstant(cls, obj);
                }

                public Object a(AnnotationDescription.Loadable<U> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription) {
                    return this.value;
                }

                /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[RETURN] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean equals(java.lang.Object r5) {
                    /*
                        r4 = this;
                        r0 = 1
                        if (r4 != r5) goto L_0x0004
                        return r0
                    L_0x0004:
                        r1 = 0
                        if (r5 != 0) goto L_0x0008
                        return r1
                    L_0x0008:
                        java.lang.Class r2 = r4.getClass()
                        java.lang.Class r3 = r5.getClass()
                        if (r2 == r3) goto L_0x0013
                        return r1
                    L_0x0013:
                        java.lang.Class<U> r2 = r4.type
                        net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder$ParameterBinder$ForFixedValue$OfConstant r5 = (net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFixedValue.OfConstant) r5
                        java.lang.Class<U> r3 = r5.type
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0020
                        return r1
                    L_0x0020:
                        java.lang.Object r2 = r4.value
                        java.lang.Object r5 = r5.value
                        if (r5 == 0) goto L_0x002f
                        if (r2 == 0) goto L_0x0031
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0032
                        return r1
                    L_0x002f:
                        if (r2 == 0) goto L_0x0032
                    L_0x0031:
                        return r1
                    L_0x0032:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFixedValue.OfConstant.equals(java.lang.Object):boolean");
                }

                public Class<U> getHandledType() {
                    return this.type;
                }

                public int hashCode() {
                    int hashCode = ((getClass().hashCode() * 31) + this.type.hashCode()) * 31;
                    Object obj = this.value;
                    return obj != null ? hashCode + obj.hashCode() : hashCode;
                }
            }

            public abstract Object a(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription);

            public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
                TypeDescription typeDescription;
                StackManipulation stackManipulation;
                StackManipulation javaConstantValue;
                TypeDescription typeDescription2;
                JavaConstantValue javaConstantValue2;
                Object a11 = a(loadable, methodDescription, parameterDescription);
                if (a11 == null) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(DefaultValue.of(parameterDescription.getType()));
                }
                if (a11 instanceof Boolean) {
                    stackManipulation = IntegerConstant.forValue(((Boolean) a11).booleanValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Boolean.TYPE);
                } else if (a11 instanceof Byte) {
                    stackManipulation = IntegerConstant.forValue((int) ((Byte) a11).byteValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Byte.TYPE);
                } else if (a11 instanceof Short) {
                    stackManipulation = IntegerConstant.forValue((int) ((Short) a11).shortValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Short.TYPE);
                } else if (a11 instanceof Character) {
                    stackManipulation = IntegerConstant.forValue((int) ((Character) a11).charValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Character.TYPE);
                } else if (a11 instanceof Integer) {
                    stackManipulation = IntegerConstant.forValue(((Integer) a11).intValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Integer.TYPE);
                } else if (a11 instanceof Long) {
                    stackManipulation = LongConstant.forValue(((Long) a11).longValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Long.TYPE);
                } else if (a11 instanceof Float) {
                    stackManipulation = FloatConstant.forValue(((Float) a11).floatValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Float.TYPE);
                } else if (a11 instanceof Double) {
                    stackManipulation = DoubleConstant.forValue(((Double) a11).doubleValue());
                    typeDescription = TypeDescription.ForLoadedType.of(Double.TYPE);
                } else {
                    if (a11 instanceof String) {
                        javaConstantValue = new TextConstant((String) a11);
                        typeDescription2 = TypeDescription.STRING;
                    } else if (a11 instanceof Class) {
                        stackManipulation = ClassConstant.of(TypeDescription.ForLoadedType.of((Class) a11));
                        typeDescription = TypeDescription.CLASS;
                    } else if (a11 instanceof TypeDescription) {
                        stackManipulation = ClassConstant.of((TypeDescription) a11);
                        typeDescription = TypeDescription.CLASS;
                    } else if (a11 instanceof Enum) {
                        Enum enumR = (Enum) a11;
                        javaConstantValue = FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumR));
                        typeDescription2 = TypeDescription.ForLoadedType.of(enumR.getDeclaringClass());
                    } else if (a11 instanceof EnumerationDescription) {
                        EnumerationDescription enumerationDescription = (EnumerationDescription) a11;
                        javaConstantValue = FieldAccess.forEnumeration(enumerationDescription);
                        typeDescription2 = enumerationDescription.getEnumerationType();
                    } else {
                        JavaType javaType = JavaType.METHOD_HANDLE;
                        if (javaType.isInstance(a11)) {
                            javaConstantValue2 = new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(a11));
                            typeDescription = javaType.getTypeStub();
                        } else if (a11 instanceof JavaConstant.MethodHandle) {
                            javaConstantValue2 = new JavaConstantValue((JavaConstant.MethodHandle) a11);
                            typeDescription = javaType.getTypeStub();
                        } else if (JavaType.METHOD_TYPE.isInstance(a11)) {
                            javaConstantValue2 = new JavaConstantValue(JavaConstant.MethodType.ofLoaded(a11));
                            typeDescription = javaType.getTypeStub();
                        } else if (a11 instanceof JavaConstant) {
                            JavaConstant javaConstant = (JavaConstant) a11;
                            javaConstantValue = new JavaConstantValue(javaConstant);
                            typeDescription2 = javaConstant.getTypeDescription();
                        } else {
                            throw new IllegalStateException("Not able to save in class's constant pool: " + a11);
                        }
                        stackManipulation = javaConstantValue2;
                    }
                    StackManipulation stackManipulation2 = javaConstantValue;
                    typeDescription = typeDescription2;
                    stackManipulation = stackManipulation2;
                }
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new StackManipulation.Compound(stackManipulation, assigner.assign(typeDescription.asGenericType(), parameterDescription.getType(), typing)));
            }
        }

        MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<T> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing);

        Class<T> getHandledType();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Record implements MethodDelegationBinder.Record {
        private final MethodDescription candidate;
        private final List<DelegationProcessor.Handler> handlers;
        private final Assigner.Typing typing;

        public Record(MethodDescription methodDescription, List<DelegationProcessor.Handler> list, Assigner.Typing typing2) {
            this.candidate = methodDescription;
            this.handlers = list;
            this.typing = typing2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodBinding bind(net.bytebuddy.implementation.Implementation.Target r4, net.bytebuddy.description.method.MethodDescription r5, net.bytebuddy.implementation.bind.MethodDelegationBinder.TerminationHandler r6, net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodInvoker r7, net.bytebuddy.implementation.bytecode.assign.Assigner r8) {
            /*
                r3 = this;
                net.bytebuddy.description.method.MethodDescription r0 = r3.candidate
                net.bytebuddy.description.type.TypeDescription r1 = r4.getInstrumentedType()
                boolean r0 = r0.isAccessibleTo(r1)
                if (r0 != 0) goto L_0x000f
                net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding$Illegal r4 = net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodBinding.Illegal.INSTANCE
                return r4
            L_0x000f:
                net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r0 = r3.typing
                net.bytebuddy.description.method.MethodDescription r1 = r3.candidate
                net.bytebuddy.implementation.bytecode.StackManipulation r6 = r6.resolve(r8, r0, r5, r1)
                boolean r0 = r6.isValid()
                if (r0 != 0) goto L_0x0020
                net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding$Illegal r4 = net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodBinding.Illegal.INSTANCE
                return r4
            L_0x0020:
                net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding$Builder r0 = new net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding$Builder
                net.bytebuddy.description.method.MethodDescription r1 = r3.candidate
                r0.<init>(r7, r1)
                java.util.List<net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder$DelegationProcessor$Handler> r7 = r3.handlers
                java.util.Iterator r7 = r7.iterator()
            L_0x002d:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L_0x004c
                java.lang.Object r1 = r7.next()
                net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder$DelegationProcessor$Handler r1 = (net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler) r1
                net.bytebuddy.implementation.bind.MethodDelegationBinder$ParameterBinding r1 = r1.bind(r5, r4, r8)
                boolean r2 = r1.isValid()
                if (r2 == 0) goto L_0x0049
                boolean r1 = r0.append(r1)
                if (r1 != 0) goto L_0x002d
            L_0x0049:
                net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding$Illegal r4 = net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodBinding.Illegal.INSTANCE
                return r4
            L_0x004c:
                net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding r4 = r0.build(r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.Record.bind(net.bytebuddy.implementation.Implementation$Target, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.implementation.bind.MethodDelegationBinder$TerminationHandler, net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodInvoker, net.bytebuddy.implementation.bytecode.assign.Assigner):net.bytebuddy.implementation.bind.MethodDelegationBinder$MethodBinding");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Record record = (Record) obj;
            return this.typing.equals(record.typing) && this.candidate.equals(record.candidate) && this.handlers.equals(record.handlers);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.candidate.hashCode()) * 31) + this.handlers.hashCode()) * 31) + this.typing.hashCode();
        }

        public String toString() {
            return this.candidate.toString();
        }
    }

    public TargetMethodAnnotationDrivenBinder(DelegationProcessor delegationProcessor2) {
        this.delegationProcessor = delegationProcessor2;
    }

    public static MethodDelegationBinder of(List<? extends ParameterBinder<?>> list) {
        return new TargetMethodAnnotationDrivenBinder(DelegationProcessor.a(list));
    }

    public MethodDelegationBinder.Record compile(MethodDescription methodDescription) {
        if (IgnoreForBinding.Verifier.check(methodDescription)) {
            return MethodDelegationBinder.Record.Illegal.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
        Iterator<E> it = methodDescription.getParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(this.delegationProcessor.b((ParameterDescription) it.next()));
        }
        return new Record(methodDescription, arrayList, RuntimeType.Verifier.check(methodDescription));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.delegationProcessor.equals(((TargetMethodAnnotationDrivenBinder) obj).delegationProcessor);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.delegationProcessor.hashCode();
    }
}
