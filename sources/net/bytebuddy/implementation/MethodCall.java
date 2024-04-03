package net.bytebuddy.implementation;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@HashCodeAndEqualsPlugin.Enhance
public class MethodCall implements Implementation.Composable {

    /* renamed from: b  reason: collision with root package name */
    public final MethodLocator.Factory f27298b;

    /* renamed from: c  reason: collision with root package name */
    public final TargetHandler.Factory f27299c;

    /* renamed from: d  reason: collision with root package name */
    public final List<ArgumentLoader.Factory> f27300d;

    /* renamed from: e  reason: collision with root package name */
    public final MethodInvoker.Factory f27301e;

    /* renamed from: f  reason: collision with root package name */
    public final TerminationHandler.Factory f27302f;

    /* renamed from: g  reason: collision with root package name */
    public final Assigner f27303g;

    /* renamed from: h  reason: collision with root package name */
    public final Assigner.Typing f27304h;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class Appender implements ByteCodeAppender {
        private final List<ArgumentLoader.ArgumentProvider> argumentProviders;
        private final Implementation.Target implementationTarget;
        private final MethodInvoker methodInvoker;
        private final MethodLocator methodLocator;
        /* access modifiers changed from: private */
        public final TargetHandler targetHandler;
        private final TerminationHandler terminationHandler;

        public Appender(Implementation.Target target, TerminationHandler terminationHandler2) {
            this.implementationTarget = target;
            this.methodLocator = MethodCall.this.f27298b.make(target.getInstrumentedType());
            this.argumentProviders = new ArrayList(MethodCall.this.f27300d.size());
            for (ArgumentLoader.Factory make : MethodCall.this.f27300d) {
                this.argumentProviders.add(make.make(target));
            }
            this.methodInvoker = MethodCall.this.f27301e.make(target.getInstrumentedType());
            this.targetHandler = MethodCall.this.f27299c.make(target);
            this.terminationHandler = terminationHandler2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            TargetHandler.Resolved resolve = this.targetHandler.resolve(methodDescription);
            return new ByteCodeAppender.Size(new StackManipulation.Compound(this.terminationHandler.prepare(), c(methodDescription, b(methodDescription, resolve), resolve)).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }

        public MethodDescription b(MethodDescription methodDescription, TargetHandler.Resolved resolved) {
            return this.methodLocator.resolve(resolved.getTypeDescription(), methodDescription);
        }

        public StackManipulation c(MethodDescription methodDescription, MethodDescription methodDescription2, TargetHandler.Resolved resolved) {
            ArrayList<ArgumentLoader> arrayList = new ArrayList<>();
            for (ArgumentLoader.ArgumentProvider resolve : this.argumentProviders) {
                arrayList.addAll(resolve.resolve(methodDescription, methodDescription2));
            }
            ParameterList<?> parameters = methodDescription2.getParameters();
            if (parameters.size() == arrayList.size()) {
                Iterator<E> it = parameters.iterator();
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (ArgumentLoader stackManipulation : arrayList) {
                    MethodCall methodCall = MethodCall.this;
                    arrayList2.add(stackManipulation.toStackManipulation((ParameterDescription) it.next(), methodCall.f27303g, methodCall.f27304h));
                }
                MethodCall methodCall2 = MethodCall.this;
                TerminationHandler terminationHandler2 = this.terminationHandler;
                MethodCall methodCall3 = MethodCall.this;
                return new StackManipulation.Compound(resolved.toStackManipulation(methodDescription2, methodCall2.f27303g, methodCall2.f27304h), new StackManipulation.Compound((List<? extends StackManipulation>) arrayList2), this.methodInvoker.toStackManipulation(methodDescription2, this.implementationTarget), terminationHandler2.toStackManipulation(methodDescription2, methodDescription, methodCall3.f27303g, methodCall3.f27304h));
            }
            throw new IllegalStateException(methodDescription2 + " does not accept " + arrayList.size() + " arguments");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.implementationTarget.equals(appender.implementationTarget) && this.methodLocator.equals(appender.methodLocator) && this.argumentProviders.equals(appender.argumentProviders) && this.methodInvoker.equals(appender.methodInvoker) && this.targetHandler.equals(appender.targetHandler) && this.terminationHandler.equals(appender.terminationHandler) && MethodCall.this.equals(MethodCall.this);
        }

        public int hashCode() {
            return (((((((((((((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + this.methodLocator.hashCode()) * 31) + this.argumentProviders.hashCode()) * 31) + this.methodInvoker.hashCode()) * 31) + this.targetHandler.hashCode()) * 31) + this.terminationHandler.hashCode()) * 31) + MethodCall.this.hashCode();
        }
    }

    public interface ArgumentLoader {

        public interface ArgumentProvider {
            List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2);
        }

        public interface Factory extends InstrumentedType.Prepareable {
            ArgumentProvider make(Implementation.Target target);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForField implements ArgumentLoader {
            private final FieldDescription fieldDescription;
            private final MethodDescription instrumentedMethod;

            @HashCodeAndEqualsPlugin.Enhance
            public static class ArgumentProvider implements ArgumentProvider {
                private final FieldDescription fieldDescription;

                public ArgumentProvider(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ArgumentProvider) obj).fieldDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    return Collections.singletonList(new ForField(this.fieldDescription, methodDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final FieldLocator.Factory fieldLocatorFactory;

                /* renamed from: name  reason: collision with root package name */
                private final String f27306name;

                public Factory(String str, FieldLocator.Factory factory) {
                    this.f27306name = str;
                    this.fieldLocatorFactory = factory;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.f27306name.equals(factory.f27306name) && this.fieldLocatorFactory.equals(factory.fieldLocatorFactory);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27306name.hashCode()) * 31) + this.fieldLocatorFactory.hashCode();
                }

                public ArgumentProvider make(Implementation.Target target) {
                    FieldLocator.Resolution locate = this.fieldLocatorFactory.make(target.getInstrumentedType()).locate(this.f27306name);
                    if (locate.isResolved()) {
                        return new ArgumentProvider(locate.getField());
                    }
                    throw new IllegalStateException("Could not locate field '" + this.f27306name + "' on " + target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public ForField(FieldDescription fieldDescription2, MethodDescription methodDescription) {
                this.fieldDescription = fieldDescription2;
                this.instrumentedMethod = methodDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.fieldDescription.equals(forField.fieldDescription) && this.instrumentedMethod.equals(forField.instrumentedMethod);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.instrumentedMethod.hashCode();
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation stackManipulation;
                if (this.fieldDescription.isStatic() || !this.instrumentedMethod.isStatic()) {
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (this.fieldDescription.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                    stackManipulationArr[2] = assigner.assign(this.fieldDescription.getType(), parameterDescription.getType(), typing);
                    StackManipulation.Compound compound = new StackManipulation.Compound(stackManipulationArr);
                    if (compound.isValid()) {
                        return compound;
                    }
                    throw new IllegalStateException("Cannot assign " + this.fieldDescription + " to " + parameterDescription);
                }
                throw new IllegalStateException("Cannot access non-static " + this.fieldDescription + " from " + this.instrumentedMethod);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstance implements ArgumentLoader, ArgumentProvider {
            private final FieldDescription fieldDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private static final String FIELD_PREFIX = "methodCall";
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)

                /* renamed from: name  reason: collision with root package name */
                private final String f27307name = ("methodCall$" + RandomString.make());
                private final Object value;

                public Factory(Object obj) {
                    this.value = obj;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value.equals(((Factory) obj).value);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value.hashCode();
                }

                public ArgumentProvider make(Implementation.Target target) {
                    return new ForInstance((FieldDescription) ((FieldList) target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named(this.f27307name))).getOnly());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType.withField(new FieldDescription.Token(this.f27307name, 4105, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass()))).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.f27307name, this.value));
                }
            }

            public ForInstance(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForInstance) obj).fieldDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                return Collections.singletonList(this);
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation.Compound compound = new StackManipulation.Compound(FieldAccess.forField(this.fieldDescription).read(), assigner.assign(this.fieldDescription.getType(), parameterDescription.getType(), typing));
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign " + this.fieldDescription.getType() + " to " + parameterDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstrumentedType implements ArgumentLoader, ArgumentProvider {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public ArgumentProvider make(Implementation.Target target) {
                    return new ForInstrumentedType(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public ForInstrumentedType(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForInstrumentedType) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                return Collections.singletonList(this);
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation.Compound compound = new StackManipulation.Compound(ClassConstant.of(this.instrumentedType), assigner.assign(TypeDescription.Generic.CLASS, parameterDescription.getType(), typing));
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign Class value to " + parameterDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodCall implements ArgumentLoader {
            private final Appender appender;
            private final MethodDescription instrumentedMethod;
            private final MethodDescription methodDescription;
            private final TargetHandler.Resolved targetHandler;

            @HashCodeAndEqualsPlugin.Enhance
            public static class ArgumentProvider implements ArgumentProvider {
                private final Appender appender;

                public ArgumentProvider(Appender appender2) {
                    this.appender = appender2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.appender.equals(((ArgumentProvider) obj).appender);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.appender.hashCode();
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    TargetHandler.Resolved resolve = this.appender.targetHandler.resolve(methodDescription);
                    Appender appender2 = this.appender;
                    return Collections.singletonList(new ForMethodCall(appender2, appender2.b(methodDescription, resolve), methodDescription, resolve));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final MethodCall methodCall;

                public Factory(MethodCall methodCall2) {
                    this.methodCall = methodCall2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodCall.equals(((Factory) obj).methodCall);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodCall.hashCode();
                }

                public ArgumentProvider make(Implementation.Target target) {
                    MethodCall methodCall2 = this.methodCall;
                    methodCall2.getClass();
                    return new ArgumentProvider(new Appender(target, TerminationHandler.Simple.IGNORING));
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return this.methodCall.prepare(instrumentedType);
                }
            }

            public ForMethodCall(Appender appender2, MethodDescription methodDescription2, MethodDescription methodDescription3, TargetHandler.Resolved resolved) {
                this.appender = appender2;
                this.methodDescription = methodDescription2;
                this.instrumentedMethod = methodDescription3;
                this.targetHandler = resolved;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodCall forMethodCall = (ForMethodCall) obj;
                return this.appender.equals(forMethodCall.appender) && this.methodDescription.equals(forMethodCall.methodDescription) && this.instrumentedMethod.equals(forMethodCall.instrumentedMethod) && this.targetHandler.equals(forMethodCall.targetHandler);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.appender.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.instrumentedMethod.hashCode()) * 31) + this.targetHandler.hashCode();
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                TypeDescription.Generic generic;
                StackManipulation[] stackManipulationArr = new StackManipulation[2];
                stackManipulationArr[0] = this.appender.c(this.instrumentedMethod, this.methodDescription, this.targetHandler);
                if (this.methodDescription.isConstructor()) {
                    generic = this.methodDescription.getDeclaringType().asGenericType();
                } else {
                    generic = this.methodDescription.getReturnType();
                }
                stackManipulationArr[1] = assigner.assign(generic, parameterDescription.getType(), typing);
                StackManipulation.Compound compound = new StackManipulation.Compound(stackManipulationArr);
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign return type of " + this.methodDescription + " to " + parameterDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodParameter implements ArgumentLoader {
            private final int index;
            private final MethodDescription instrumentedMethod;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory, ArgumentProvider {
                private final int index;

                public Factory(int i11) {
                    this.index = i11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((Factory) obj).index;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.index;
                }

                public ArgumentProvider make(Implementation.Target target) {
                    return this;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    if (this.index < methodDescription.getParameters().size()) {
                        return Collections.singletonList(new ForMethodParameter(this.index, methodDescription));
                    }
                    throw new IllegalStateException(methodDescription + " does not have a parameter with index " + this.index + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + methodDescription.getParameters().size() + " defined");
                }
            }

            public enum OfInstrumentedMethod implements Factory, ArgumentProvider {
                INSTANCE;

                public ArgumentProvider make(Implementation.Target target) {
                    return this;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    Iterator<E> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ForMethodParameter(((ParameterDescription) it.next()).getIndex(), methodDescription));
                    }
                    return arrayList;
                }
            }

            public ForMethodParameter(int i11, MethodDescription methodDescription) {
                this.index = i11;
                this.instrumentedMethod = methodDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodParameter forMethodParameter = (ForMethodParameter) obj;
                return this.index == forMethodParameter.index && this.instrumentedMethod.equals(forMethodParameter.instrumentedMethod);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.index) * 31) + this.instrumentedMethod.hashCode();
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                ParameterDescription parameterDescription2 = (ParameterDescription) this.instrumentedMethod.getParameters().get(this.index);
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription2), assigner.assign(parameterDescription2.getType(), parameterDescription.getType(), typing));
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign " + parameterDescription2 + " to " + parameterDescription + " for " + this.instrumentedMethod);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodParameterArray implements ArgumentLoader {
            private final ParameterList<?> parameters;

            public enum ForInstrumentedMethod implements Factory, ArgumentProvider {
                INSTANCE;

                public ArgumentProvider make(Implementation.Target target) {
                    return this;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    return Collections.singletonList(new ForMethodParameterArray(methodDescription.getParameters()));
                }
            }

            public ForMethodParameterArray(ParameterList<?> parameterList) {
                this.parameters = parameterList;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.parameters.equals(((ForMethodParameterArray) obj).parameters);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.parameters.hashCode();
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                TypeDescription.Generic generic;
                if (parameterDescription.getType().represents(Object.class)) {
                    generic = TypeDescription.Generic.OBJECT;
                } else if (parameterDescription.getType().isArray()) {
                    generic = parameterDescription.getType().getComponentType();
                } else {
                    throw new IllegalStateException("Cannot set method parameter array for non-array type: " + parameterDescription);
                }
                ArrayList arrayList = new ArrayList(this.parameters.size());
                Iterator<E> it = this.parameters.iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription2 = (ParameterDescription) it.next();
                    StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription2), assigner.assign(parameterDescription2.getType(), generic, typing));
                    if (compound.isValid()) {
                        arrayList.add(compound);
                    } else {
                        throw new IllegalStateException("Cannot assign " + parameterDescription2 + " to " + generic);
                    }
                }
                return new StackManipulation.Compound(ArrayFactory.forType(generic).withValues(arrayList));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodParameterArrayElement implements ArgumentLoader {
            private final int index;
            private final ParameterDescription parameterDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfInvokedMethod implements Factory, ArgumentProvider {
                private final int index;

                public OfInvokedMethod(int i11) {
                    this.index = i11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((OfInvokedMethod) obj).index;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.index;
                }

                public ArgumentProvider make(Implementation.Target target) {
                    return this;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    if (methodDescription.getParameters().size() <= this.index) {
                        throw new IllegalStateException(methodDescription + " does not declare a parameter with index " + this.index + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + methodDescription.getParameters().size() + " defined");
                    } else if (((ParameterDescription) methodDescription.getParameters().get(this.index)).getType().isArray()) {
                        ArrayList arrayList = new ArrayList(methodDescription2.getParameters().size());
                        for (int i11 = 0; i11 < methodDescription2.getParameters().size(); i11++) {
                            arrayList.add(new ForMethodParameterArrayElement((ParameterDescription) methodDescription.getParameters().get(this.index), i11));
                        }
                        return arrayList;
                    } else {
                        throw new IllegalStateException("Cannot access an item from non-array parameter " + methodDescription.getParameters().get(this.index) + " at index " + this.index);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfParameter implements Factory, ArgumentProvider {
                private final int arrayIndex;
                private final int index;

                public OfParameter(int i11, int i12) {
                    this.index = i11;
                    this.arrayIndex = i12;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfParameter ofParameter = (OfParameter) obj;
                    return this.index == ofParameter.index && this.arrayIndex == ofParameter.arrayIndex;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.arrayIndex;
                }

                public ArgumentProvider make(Implementation.Target target) {
                    return this;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                    if (methodDescription.getParameters().size() <= this.index) {
                        throw new IllegalStateException(methodDescription + " does not declare a parameter with index " + this.index + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + methodDescription.getParameters().size() + " defined");
                    } else if (((ParameterDescription) methodDescription.getParameters().get(this.index)).getType().isArray()) {
                        return Collections.singletonList(new ForMethodParameterArrayElement((ParameterDescription) methodDescription.getParameters().get(this.index), this.arrayIndex));
                    } else {
                        throw new IllegalStateException("Cannot access an item from non-array parameter " + methodDescription.getParameters().get(this.index) + " at index " + this.index);
                    }
                }
            }

            public ForMethodParameterArrayElement(ParameterDescription parameterDescription2, int i11) {
                this.parameterDescription = parameterDescription2;
                this.index = i11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodParameterArrayElement forMethodParameterArrayElement = (ForMethodParameterArrayElement) obj;
                return this.index == forMethodParameterArrayElement.index && this.parameterDescription.equals(forMethodParameterArrayElement.parameterDescription);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.parameterDescription.hashCode()) * 31) + this.index;
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription2, Assigner assigner, Assigner.Typing typing) {
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(this.parameterDescription), IntegerConstant.forValue(this.index), ArrayAccess.of(this.parameterDescription.getType().getComponentType()).load(), assigner.assign(this.parameterDescription.getType().getComponentType(), parameterDescription2.getType(), typing));
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign " + this.parameterDescription.getType().getComponentType() + " to " + parameterDescription2);
            }
        }

        public enum ForNullConstant implements ArgumentLoader, ArgumentProvider, Factory {
            INSTANCE;

            public ArgumentProvider make(Implementation.Target target) {
                return this;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                return Collections.singletonList(this);
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                if (!parameterDescription.getType().isPrimitive()) {
                    return NullConstant.INSTANCE;
                }
                throw new IllegalStateException("Cannot assign null to " + parameterDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStackManipulation implements ArgumentLoader, ArgumentProvider, Factory {
            private final StackManipulation stackManipulation;
            private final TypeDefinition typeDefinition;

            public ForStackManipulation(StackManipulation stackManipulation2, Type type) {
                this(stackManipulation2, (TypeDefinition) TypeDefinition.Sort.describe(type));
            }

            public static Factory of(Object obj) {
                if (obj == null) {
                    return ForNullConstant.INSTANCE;
                }
                if (obj instanceof Boolean) {
                    return new ForStackManipulation(IntegerConstant.forValue(((Boolean) obj).booleanValue()), (Type) Boolean.TYPE);
                }
                if (obj instanceof Byte) {
                    return new ForStackManipulation(IntegerConstant.forValue((int) ((Byte) obj).byteValue()), (Type) Byte.TYPE);
                }
                if (obj instanceof Short) {
                    return new ForStackManipulation(IntegerConstant.forValue((int) ((Short) obj).shortValue()), (Type) Short.TYPE);
                }
                if (obj instanceof Character) {
                    return new ForStackManipulation(IntegerConstant.forValue((int) ((Character) obj).charValue()), (Type) Character.TYPE);
                }
                if (obj instanceof Integer) {
                    return new ForStackManipulation(IntegerConstant.forValue(((Integer) obj).intValue()), (Type) Integer.TYPE);
                }
                if (obj instanceof Long) {
                    return new ForStackManipulation(LongConstant.forValue(((Long) obj).longValue()), (Type) Long.TYPE);
                }
                if (obj instanceof Float) {
                    return new ForStackManipulation(FloatConstant.forValue(((Float) obj).floatValue()), (Type) Float.TYPE);
                }
                if (obj instanceof Double) {
                    return new ForStackManipulation(DoubleConstant.forValue(((Double) obj).doubleValue()), (Type) Double.TYPE);
                }
                if (obj instanceof String) {
                    return new ForStackManipulation((StackManipulation) new TextConstant((String) obj), (Type) String.class);
                }
                Class<Class> cls = Class.class;
                if (obj instanceof Class) {
                    return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)), (Type) cls);
                }
                if (obj instanceof TypeDescription) {
                    return new ForStackManipulation(ClassConstant.of((TypeDescription) obj), (Type) cls);
                }
                if (obj instanceof Enum) {
                    EnumerationDescription.ForLoadedEnumeration forLoadedEnumeration = new EnumerationDescription.ForLoadedEnumeration((Enum) obj);
                    return new ForStackManipulation(FieldAccess.forEnumeration(forLoadedEnumeration), (TypeDefinition) forLoadedEnumeration.getEnumerationType());
                } else if (obj instanceof EnumerationDescription) {
                    EnumerationDescription enumerationDescription = (EnumerationDescription) obj;
                    return new ForStackManipulation(FieldAccess.forEnumeration(enumerationDescription), (TypeDefinition) enumerationDescription.getEnumerationType());
                } else {
                    JavaType javaType = JavaType.METHOD_HANDLE;
                    if (javaType.isInstance(obj)) {
                        return new ForStackManipulation((StackManipulation) new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)), (TypeDefinition) javaType.getTypeStub());
                    }
                    JavaType javaType2 = JavaType.METHOD_TYPE;
                    if (javaType2.isInstance(obj)) {
                        return new ForStackManipulation((StackManipulation) new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)), (TypeDefinition) javaType2.getTypeStub());
                    }
                    if (!(obj instanceof JavaConstant)) {
                        return new ForInstance.Factory(obj);
                    }
                    JavaConstant javaConstant = (JavaConstant) obj;
                    return new ForStackManipulation((StackManipulation) new JavaConstantValue(javaConstant), (TypeDefinition) javaConstant.getTypeDescription());
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                return this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDefinition.equals(forStackManipulation.typeDefinition);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDefinition.hashCode();
            }

            public ArgumentProvider make(Implementation.Target target) {
                return this;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                return Collections.singletonList(this);
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation assign = assigner.assign(this.typeDefinition.asGenericType(), parameterDescription.getType(), typing);
                if (assign.isValid()) {
                    return new StackManipulation.Compound(this.stackManipulation, assign);
                }
                throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.typeDefinition);
            }

            public ForStackManipulation(StackManipulation stackManipulation2, TypeDefinition typeDefinition2) {
                this.stackManipulation = stackManipulation2;
                this.typeDefinition = typeDefinition2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThisReference implements ArgumentLoader, ArgumentProvider {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public ArgumentProvider make(Implementation.Target target) {
                    return new ForThisReference(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public ForThisReference(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForThisReference) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public List<ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription2) {
                if (!methodDescription.isStatic()) {
                    return Collections.singletonList(this);
                }
                throw new IllegalStateException(methodDescription + " is static and cannot supply an invoker instance");
            }

            public StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.loadThis(), assigner.assign(this.instrumentedType.asGenericType(), parameterDescription.getType(), typing));
                if (compound.isValid()) {
                    return compound;
                }
                throw new IllegalStateException("Cannot assign " + this.instrumentedType + " to " + parameterDescription);
            }
        }

        StackManipulation toStackManipulation(ParameterDescription parameterDescription, Assigner assigner, Assigner.Typing typing);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class FieldSetting implements Implementation.Composable {
        private final MethodCall methodCall;

        public enum Appender implements ByteCodeAppender {
            INSTANCE;

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                if (methodDescription.getReturnType().represents(Void.TYPE)) {
                    return new ByteCodeAppender.Size(MethodReturn.VOID.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }
                throw new IllegalStateException("Instrumented method " + methodDescription + " does not return void for field setting method call");
            }
        }

        public FieldSetting(MethodCall methodCall2) {
            this.methodCall = methodCall2;
        }

        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(this.methodCall, implementation);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new ByteCodeAppender.Compound(this.methodCall.appender(target), Appender.INSTANCE);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodCall.equals(((FieldSetting) obj).methodCall);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.methodCall.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return this.methodCall.prepare(instrumentedType);
        }

        public Implementation.Composable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new FieldSetting((MethodCall) this.methodCall.withAssigner(assigner, typing));
        }

        public Implementation.Composable andThen(Implementation.Composable composable) {
            return new Implementation.Compound.Composable((Implementation) this.methodCall, composable);
        }
    }

    public interface MethodInvoker {

        public interface Factory {
            MethodInvoker make(TypeDescription typeDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForContextualInvocation implements MethodInvoker {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public MethodInvoker make(TypeDescription typeDescription) {
                    return new ForContextualInvocation(typeDescription);
                }
            }

            public ForContextualInvocation(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForContextualInvocation) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target) {
                if (methodDescription.isVirtual() && !methodDescription.isInvokableOn(this.instrumentedType)) {
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.instrumentedType);
                } else if (methodDescription.isVirtual()) {
                    return MethodInvocation.invoke(methodDescription).virtual(this.instrumentedType);
                } else {
                    return MethodInvocation.invoke(methodDescription);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDefaultMethodInvocation implements MethodInvoker {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public MethodInvoker make(TypeDescription typeDescription) {
                    return new ForDefaultMethodInvocation(typeDescription);
                }
            }

            public ForDefaultMethodInvocation(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForDefaultMethodInvocation) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target) {
                if (methodDescription.isInvokableOn(this.instrumentedType)) {
                    Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = target.invokeDefault(methodDescription.asSignatureToken(), methodDescription.getDeclaringType().asErasure()).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                    if (withCheckedCompatibilityTo.isValid()) {
                        return withCheckedCompatibilityTo;
                    }
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.instrumentedType);
                }
                throw new IllegalStateException("Cannot invoke " + methodDescription + " as default method of " + this.instrumentedType);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSuperMethodInvocation implements MethodInvoker {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public MethodInvoker make(TypeDescription typeDescription) {
                    if (typeDescription.getSuperClass() != null) {
                        return new ForSuperMethodInvocation(typeDescription);
                    }
                    throw new IllegalStateException("Cannot invoke super method for " + typeDescription);
                }
            }

            public ForSuperMethodInvocation(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForSuperMethodInvocation) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target) {
                if (methodDescription.isInvokableOn(target.getOriginType().asErasure())) {
                    Implementation.SpecialMethodInvocation withCheckedCompatibilityTo = target.invokeDominant(methodDescription.asSignatureToken()).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                    if (withCheckedCompatibilityTo.isValid()) {
                        return withCheckedCompatibilityTo;
                    }
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " as a super method");
                }
                throw new IllegalStateException("Cannot invoke " + methodDescription + " as super method of " + this.instrumentedType);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForVirtualInvocation implements MethodInvoker {
            private final TypeDescription typeDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final TypeDescription typeDescription;

                public Factory(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Factory) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public MethodInvoker make(TypeDescription typeDescription2) {
                    if (this.typeDescription.asErasure().isAccessibleTo(typeDescription2)) {
                        return new ForVirtualInvocation(this.typeDescription);
                    }
                    throw new IllegalStateException(this.typeDescription + " is not accessible to " + typeDescription2);
                }
            }

            public enum WithImplicitType implements MethodInvoker, Factory {
                INSTANCE;

                public MethodInvoker make(TypeDescription typeDescription) {
                    return this;
                }

                public StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target) {
                    if (methodDescription.isAccessibleTo(target.getInstrumentedType()) && methodDescription.isVirtual()) {
                        return MethodInvocation.invoke(methodDescription);
                    }
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " virtually");
                }
            }

            public ForVirtualInvocation(TypeDescription typeDescription2) {
                this.typeDescription = typeDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForVirtualInvocation) obj).typeDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target) {
                if (methodDescription.isInvokableOn(this.typeDescription)) {
                    return MethodInvocation.invoke(methodDescription).virtual(this.typeDescription);
                }
                throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.typeDescription);
            }
        }

        StackManipulation toStackManipulation(MethodDescription methodDescription, Implementation.Target target);
    }

    public interface MethodLocator {

        public interface Factory {
            MethodLocator make(TypeDescription typeDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatcher implements MethodLocator {
            private final TypeDescription instrumentedType;
            private final ElementMatcher<? super MethodDescription> matcher;
            private final MethodGraph.Compiler methodGraphCompiler;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final ElementMatcher<? super MethodDescription> matcher;
                private final MethodGraph.Compiler methodGraphCompiler;

                public Factory(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
                    this.matcher = elementMatcher;
                    this.methodGraphCompiler = compiler;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.matcher.equals(factory.matcher) && this.methodGraphCompiler.equals(factory.methodGraphCompiler);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.methodGraphCompiler.hashCode();
                }

                public MethodLocator make(TypeDescription typeDescription) {
                    return new ForElementMatcher(typeDescription, this.matcher, this.methodGraphCompiler);
                }
            }

            public ForElementMatcher(TypeDescription typeDescription, ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
                this.instrumentedType = typeDescription;
                this.matcher = elementMatcher;
                this.methodGraphCompiler = compiler;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatcher forElementMatcher = (ForElementMatcher) obj;
                return this.instrumentedType.equals(forElementMatcher.instrumentedType) && this.matcher.equals(forElementMatcher.matcher) && this.methodGraphCompiler.equals(forElementMatcher.methodGraphCompiler);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.matcher.hashCode()) * 31) + this.methodGraphCompiler.hashCode();
            }

            public MethodDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                List of2 = CompoundList.of(this.instrumentedType.getSuperClass().getDeclaredMethods().filter(ElementMatchers.isConstructor().and(this.matcher)), this.instrumentedType.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isVirtual()).and(this.matcher)), this.methodGraphCompiler.compile((TypeDefinition) typeDescription, this.instrumentedType).listNodes().asMethodList().filter(this.matcher));
                if (of2.size() == 1) {
                    return (MethodDescription) of2.get(0);
                }
                throw new IllegalStateException(this.instrumentedType + " does not define exactly one virtual method or constructor for " + this.matcher + " but contained " + of2.size() + " candidates: " + of2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExplicitMethod implements MethodLocator, Factory {
            private final MethodDescription methodDescription;

            public ForExplicitMethod(MethodDescription methodDescription2) {
                this.methodDescription = methodDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForExplicitMethod) obj).methodDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }

            public MethodLocator make(TypeDescription typeDescription) {
                return this;
            }

            public MethodDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription2) {
                return this.methodDescription;
            }
        }

        public enum ForInstrumentedMethod implements MethodLocator, Factory {
            INSTANCE;

            public MethodLocator make(TypeDescription typeDescription) {
                return this;
            }

            public MethodDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                return methodDescription;
            }
        }

        MethodDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);
    }

    public interface TargetHandler {

        public interface Factory extends InstrumentedType.Prepareable {
            TargetHandler make(Implementation.Target target);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstructingInvocation implements TargetHandler, Resolved {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public TargetHandler make(Implementation.Target target) {
                    return new ForConstructingInvocation(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public ForConstructingInvocation(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForConstructingInvocation) obj).instrumentedType);
            }

            public TypeDescription getTypeDescription() {
                return this.instrumentedType;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public Resolved resolve(MethodDescription methodDescription) {
                return this;
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                return new StackManipulation.Compound(TypeCreation.of(methodDescription.getDeclaringType().asErasure()), Duplication.SINGLE);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForField implements TargetHandler, Resolved {
            private final FieldDescription fieldDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final Location location;

                public Factory(Location location2) {
                    this.location = location2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.location.equals(((Factory) obj).location);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.location.hashCode();
                }

                public TargetHandler make(Implementation.Target target) {
                    FieldDescription resolve = this.location.resolve(target.getInstrumentedType());
                    if (resolve.isStatic() || target.getInstrumentedType().isAssignableTo(resolve.getDeclaringType().asErasure())) {
                        return new ForField(resolve);
                    }
                    throw new IllegalStateException("Cannot access " + resolve + " from " + target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public interface Location {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForExplicitField implements Location {
                    private final FieldDescription fieldDescription;

                    public ForExplicitField(FieldDescription fieldDescription2) {
                        this.fieldDescription = fieldDescription2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForExplicitField) obj).fieldDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription) {
                        return this.fieldDescription;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForImplicitField implements Location {
                    private final FieldLocator.Factory fieldLocatorFactory;

                    /* renamed from: name  reason: collision with root package name */
                    private final String f27308name;

                    public ForImplicitField(String str, FieldLocator.Factory factory) {
                        this.f27308name = str;
                        this.fieldLocatorFactory = factory;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForImplicitField forImplicitField = (ForImplicitField) obj;
                        return this.f27308name.equals(forImplicitField.f27308name) && this.fieldLocatorFactory.equals(forImplicitField.fieldLocatorFactory);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.f27308name.hashCode()) * 31) + this.fieldLocatorFactory.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription) {
                        FieldLocator.Resolution locate = this.fieldLocatorFactory.make(typeDescription).locate(this.f27308name);
                        if (locate.isResolved()) {
                            return locate.getField();
                        }
                        throw new IllegalStateException("Could not locate field name " + this.f27308name + " on " + typeDescription);
                    }
                }

                FieldDescription resolve(TypeDescription typeDescription);
            }

            public ForField(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForField) obj).fieldDescription);
            }

            public TypeDescription getTypeDescription() {
                return this.fieldDescription.getType().asErasure();
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public Resolved resolve(MethodDescription methodDescription) {
                return this;
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation stackManipulation;
                if (!methodDescription.isMethod() || !methodDescription.isVirtual() || !methodDescription.isVisibleTo(this.fieldDescription.getType().asErasure())) {
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.fieldDescription);
                }
                StackManipulation assign = assigner.assign(this.fieldDescription.getType(), methodDescription.getDeclaringType().asGenericType(), typing);
                if (assign.isValid()) {
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (methodDescription.isStatic() || this.fieldDescription.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                    stackManipulationArr[2] = assign;
                    return new StackManipulation.Compound(stackManipulationArr);
                }
                throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.fieldDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodCall implements TargetHandler {
            private final Appender appender;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final MethodCall methodCall;

                public Factory(MethodCall methodCall2) {
                    this.methodCall = methodCall2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodCall.equals(((Factory) obj).methodCall);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodCall.hashCode();
                }

                public TargetHandler make(Implementation.Target target) {
                    MethodCall methodCall2 = this.methodCall;
                    methodCall2.getClass();
                    return new ForMethodCall(new Appender(target, TerminationHandler.Simple.IGNORING));
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return this.methodCall.prepare(instrumentedType);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved implements Resolved {
                private final Appender appender;
                private final MethodDescription instrumentedMethod;
                private final MethodDescription methodDescription;
                private final Resolved targetHandler;

                public Resolved(Appender appender2, MethodDescription methodDescription2, MethodDescription methodDescription3, Resolved resolved) {
                    this.appender = appender2;
                    this.methodDescription = methodDescription2;
                    this.instrumentedMethod = methodDescription3;
                    this.targetHandler = resolved;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Resolved resolved = (Resolved) obj;
                    return this.appender.equals(resolved.appender) && this.methodDescription.equals(resolved.methodDescription) && this.instrumentedMethod.equals(resolved.instrumentedMethod) && this.targetHandler.equals(resolved.targetHandler);
                }

                public TypeDescription getTypeDescription() {
                    if (this.methodDescription.isConstructor()) {
                        return this.methodDescription.getDeclaringType().asErasure();
                    }
                    return this.methodDescription.getReturnType().asErasure();
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.appender.hashCode()) * 31) + this.methodDescription.hashCode()) * 31) + this.instrumentedMethod.hashCode()) * 31) + this.targetHandler.hashCode();
                }

                public StackManipulation toStackManipulation(MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing) {
                    TypeDescription.Generic generic;
                    Object obj;
                    if (this.methodDescription.isConstructor()) {
                        generic = this.methodDescription.getDeclaringType().asGenericType();
                    } else {
                        generic = this.methodDescription.getReturnType();
                    }
                    StackManipulation assign = assigner.assign(generic, methodDescription2.getDeclaringType().asGenericType(), typing);
                    if (!assign.isValid()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Cannot invoke ");
                        sb2.append(methodDescription2);
                        sb2.append(" on ");
                        if (this.methodDescription.isConstructor()) {
                            obj = this.methodDescription.getDeclaringType();
                        } else {
                            obj = this.methodDescription.getReturnType();
                        }
                        sb2.append(obj);
                        throw new IllegalStateException(sb2.toString());
                    }
                    return new StackManipulation.Compound(this.appender.c(this.instrumentedMethod, this.methodDescription, this.targetHandler), assign);
                }
            }

            public ForMethodCall(Appender appender2) {
                this.appender = appender2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.appender.equals(((ForMethodCall) obj).appender);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.appender.hashCode();
            }

            public Resolved resolve(MethodDescription methodDescription) {
                Resolved resolve = this.appender.targetHandler.resolve(methodDescription);
                Appender appender2 = this.appender;
                return new Resolved(appender2, appender2.b(methodDescription, resolve), methodDescription, resolve);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodParameter implements TargetHandler, Factory {
            private final int index;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved implements Resolved {
                private final ParameterDescription parameterDescription;

                public Resolved(ParameterDescription parameterDescription2) {
                    this.parameterDescription = parameterDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterDescription.equals(((Resolved) obj).parameterDescription);
                }

                public TypeDescription getTypeDescription() {
                    return this.parameterDescription.getType().asErasure();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parameterDescription.hashCode();
                }

                public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    StackManipulation assign = assigner.assign(this.parameterDescription.getType(), methodDescription.getDeclaringType().asGenericType(), typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(MethodVariableAccess.load(this.parameterDescription), assign);
                    }
                    throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.parameterDescription.getType());
                }
            }

            public ForMethodParameter(int i11) {
                this.index = i11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.index == ((ForMethodParameter) obj).index;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.index;
            }

            public TargetHandler make(Implementation.Target target) {
                return this;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Resolved resolve(MethodDescription methodDescription) {
                if (this.index < methodDescription.getParameters().size()) {
                    return new Resolved((ParameterDescription) methodDescription.getParameters().get(this.index));
                }
                throw new IllegalArgumentException(methodDescription + " does not have a parameter with index " + this.index);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSelfOrStaticInvocation implements TargetHandler {
            private final TypeDescription instrumentedType;

            public enum Factory implements Factory {
                INSTANCE;

                public TargetHandler make(Implementation.Target target) {
                    return new ForSelfOrStaticInvocation(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved implements Resolved {
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;

                public Resolved(TypeDescription typeDescription, MethodDescription methodDescription) {
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Resolved resolved = (Resolved) obj;
                    return this.instrumentedType.equals(resolved.instrumentedType) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                }

                public TypeDescription getTypeDescription() {
                    return this.instrumentedType;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                }

                public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    StackManipulation stackManipulation;
                    StackManipulation stackManipulation2;
                    if (this.instrumentedMethod.isStatic() && !methodDescription.isStatic() && !methodDescription.isConstructor()) {
                        throw new IllegalStateException("Cannot invoke " + methodDescription + " from " + this.instrumentedMethod);
                    } else if (!methodDescription.isConstructor() || (this.instrumentedMethod.isConstructor() && (this.instrumentedType.equals(methodDescription.getDeclaringType().asErasure()) || this.instrumentedType.getSuperClass().asErasure().equals(methodDescription.getDeclaringType().asErasure())))) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[2];
                        if (methodDescription.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        stackManipulationArr[0] = stackManipulation;
                        if (methodDescription.isConstructor()) {
                            stackManipulation2 = Duplication.SINGLE;
                        } else {
                            stackManipulation2 = StackManipulation.Trivial.INSTANCE;
                        }
                        stackManipulationArr[1] = stackManipulation2;
                        return new StackManipulation.Compound(stackManipulationArr);
                    } else {
                        throw new IllegalStateException("Cannot invoke " + methodDescription + " from " + this.instrumentedMethod + " in " + this.instrumentedType);
                    }
                }
            }

            public ForSelfOrStaticInvocation(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ForSelfOrStaticInvocation) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            public Resolved resolve(MethodDescription methodDescription) {
                return new Resolved(this.instrumentedType, methodDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForValue implements TargetHandler, Resolved {
            private final FieldDescription.InDefinedShape fieldDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private static final String FIELD_PREFIX = "invocationTarget";
                private final TypeDescription.Generic fieldType;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)

                /* renamed from: name  reason: collision with root package name */
                private final String f27309name = ("invocationTarget$" + RandomString.make());
                private final Object target;

                public Factory(Object obj, TypeDescription.Generic generic) {
                    this.target = obj;
                    this.fieldType = generic;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.target.equals(factory.target) && this.fieldType.equals(factory.fieldType);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.fieldType.hashCode();
                }

                public TargetHandler make(Implementation.Target target2) {
                    return new ForValue((FieldDescription.InDefinedShape) ((FieldList) target2.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named(this.f27309name))).getOnly());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType.withField(new FieldDescription.Token(this.f27309name, 4169, this.fieldType)).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.f27309name, this.target));
                }
            }

            public ForValue(FieldDescription.InDefinedShape inDefinedShape) {
                this.fieldDescription = inDefinedShape;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForValue) obj).fieldDescription);
            }

            public TypeDescription getTypeDescription() {
                return this.fieldDescription.getType().asErasure();
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public Resolved resolve(MethodDescription methodDescription) {
                return this;
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation assign = assigner.assign(this.fieldDescription.getType(), methodDescription.getDeclaringType().asGenericType(), typing);
                if (assign.isValid()) {
                    return new StackManipulation.Compound(FieldAccess.forField(this.fieldDescription).read(), assign);
                }
                throw new IllegalStateException("Cannot invoke " + methodDescription + " on " + this.fieldDescription);
            }
        }

        public interface Resolved {
            TypeDescription getTypeDescription();

            StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements TargetHandler, Factory, Resolved {
            private final StackManipulation stackManipulation;
            private final TypeDescription typeDescription;

            public Simple(TypeDescription typeDescription2, StackManipulation stackManipulation2) {
                this.typeDescription = typeDescription2;
                this.stackManipulation = stackManipulation2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Simple simple = (Simple) obj;
                return this.typeDescription.equals(simple.typeDescription) && this.stackManipulation.equals(simple.stackManipulation);
            }

            public TypeDescription getTypeDescription() {
                return this.typeDescription;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.stackManipulation.hashCode();
            }

            public TargetHandler make(Implementation.Target target) {
                return this;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Resolved resolve(MethodDescription methodDescription) {
                return this;
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                return this.stackManipulation;
            }
        }

        Resolved resolve(MethodDescription methodDescription);
    }

    public interface TerminationHandler {

        public interface Factory {
            TerminationHandler make(TypeDescription typeDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class FieldSetting implements TerminationHandler {
            private final FieldDescription fieldDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements Factory {
                private final FieldDescription fieldDescription;

                public Explicit(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Explicit) obj).fieldDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public TerminationHandler make(TypeDescription typeDescription) {
                    if (!this.fieldDescription.isStatic() && !typeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) {
                        throw new IllegalStateException("Cannot set " + this.fieldDescription + " from " + typeDescription);
                    } else if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return new FieldSetting(this.fieldDescription);
                    } else {
                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Implicit implements Factory {
                private final ElementMatcher<? super FieldDescription> matcher;

                public Implicit(ElementMatcher<? super FieldDescription> elementMatcher) {
                    this.matcher = elementMatcher;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Implicit) obj).matcher);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matcher.hashCode();
                }

                public TerminationHandler make(TypeDescription typeDescription) {
                    TypeDefinition typeDefinition = typeDescription;
                    do {
                        FieldList fieldList = (FieldList) typeDefinition.getDeclaredFields().filter(ElementMatchers.isVisibleTo(typeDescription).and(this.matcher));
                        if (fieldList.size() == 1) {
                            return new FieldSetting((FieldDescription) fieldList.getOnly());
                        }
                        if (fieldList.size() != 2) {
                            typeDefinition = typeDefinition.getSuperClass();
                        } else {
                            throw new IllegalStateException(this.matcher + " is ambiguous and resolved: " + fieldList);
                        }
                    } while (typeDefinition != null);
                    throw new IllegalStateException(this.matcher + " does not locate any accessible fields for " + typeDescription);
                }
            }

            public FieldSetting(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldSetting) obj).fieldDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public StackManipulation prepare() {
                if (this.fieldDescription.isStatic()) {
                    return StackManipulation.Trivial.INSTANCE;
                }
                return MethodVariableAccess.loadThis();
            }

            public StackManipulation toStackManipulation(MethodDescription methodDescription, MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing) {
                TypeDescription.Generic generic;
                if (methodDescription.isConstructor()) {
                    generic = methodDescription.getDeclaringType().asGenericType();
                } else {
                    generic = methodDescription.getReturnType();
                }
                StackManipulation assign = assigner.assign(generic, this.fieldDescription.getType(), typing);
                if (assign.isValid()) {
                    return new StackManipulation.Compound(assign, FieldAccess.forField(this.fieldDescription).write());
                }
                throw new IllegalStateException("Cannot assign result of " + methodDescription + " to " + this.fieldDescription);
            }
        }

        public enum Simple implements TerminationHandler, Factory {
            RETURNING {
                public StackManipulation toStackManipulation(MethodDescription methodDescription, MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing) {
                    TypeDescription.Generic generic;
                    if (methodDescription.isConstructor()) {
                        generic = methodDescription.getDeclaringType().asGenericType();
                    } else {
                        generic = methodDescription.getReturnType();
                    }
                    StackManipulation assign = assigner.assign(generic, methodDescription2.getReturnType(), typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(assign, MethodReturn.of(methodDescription2.getReturnType()));
                    }
                    throw new IllegalStateException("Cannot return " + methodDescription.getReturnType() + " from " + methodDescription2);
                }
            },
            DROPPING {
                public StackManipulation toStackManipulation(MethodDescription methodDescription, MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing) {
                    TypeDefinition typeDefinition;
                    if (methodDescription.isConstructor()) {
                        typeDefinition = methodDescription.getDeclaringType();
                    } else {
                        typeDefinition = methodDescription.getReturnType();
                    }
                    return Removal.of(typeDefinition);
                }
            },
            IGNORING {
                public StackManipulation toStackManipulation(MethodDescription methodDescription, MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            };

            public TerminationHandler make(TypeDescription typeDescription) {
                return this;
            }

            public StackManipulation prepare() {
                return StackManipulation.Trivial.INSTANCE;
            }
        }

        StackManipulation prepare();

        StackManipulation toStackManipulation(MethodDescription methodDescription, MethodDescription methodDescription2, Assigner assigner, Assigner.Typing typing);
    }

    public static class WithoutSpecifiedTarget extends MethodCall {
        public WithoutSpecifiedTarget(MethodLocator.Factory factory) {
            super(factory, TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, Collections.emptyList(), MethodInvoker.ForContextualInvocation.Factory.INSTANCE, TerminationHandler.Simple.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public MethodCall on(Object obj) {
            return on(obj, obj.getClass());
        }

        public MethodCall onArgument(int i11) {
            if (i11 >= 0) {
                return new MethodCall(this.f27298b, new TargetHandler.ForMethodParameter(i11), this.f27300d, MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
            }
            throw new IllegalArgumentException("An argument index cannot be negative: " + i11);
        }

        public MethodCall onDefault() {
            return new MethodCall(this.f27298b, TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, this.f27300d, MethodInvoker.ForDefaultMethodInvocation.Factory.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
        }

        public MethodCall onField(String str) {
            return onField(str, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
        }

        public MethodCall onMethodCall(MethodCall methodCall) {
            return new MethodCall(this.f27298b, new TargetHandler.ForMethodCall.Factory(methodCall), this.f27300d, MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
        }

        public MethodCall onSuper() {
            return new MethodCall(this.f27298b, TargetHandler.ForSelfOrStaticInvocation.Factory.INSTANCE, this.f27300d, MethodInvoker.ForSuperMethodInvocation.Factory.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
        }

        public <T> MethodCall on(T t11, Class<? super T> cls) {
            return new MethodCall(this.f27298b, new TargetHandler.ForValue.Factory(t11, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls)), this.f27300d, new MethodInvoker.ForVirtualInvocation.Factory(TypeDescription.ForLoadedType.of(cls)), this.f27302f, this.f27303g, this.f27304h);
        }

        public MethodCall onField(String str, FieldLocator.Factory factory) {
            return new MethodCall(this.f27298b, new TargetHandler.ForField.Factory(new TargetHandler.ForField.Location.ForImplicitField(str, factory)), this.f27300d, MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
        }

        public MethodCall onField(Field field) {
            return onField((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public MethodCall onField(FieldDescription fieldDescription) {
            return new MethodCall(this.f27298b, new TargetHandler.ForField.Factory(new TargetHandler.ForField.Location.ForExplicitField(fieldDescription)), this.f27300d, MethodInvoker.ForVirtualInvocation.WithImplicitType.INSTANCE, this.f27302f, this.f27303g, this.f27304h);
        }

        public MethodCall on(StackManipulation stackManipulation, Class<?> cls) {
            return on(stackManipulation, TypeDescription.ForLoadedType.of(cls));
        }

        public MethodCall on(StackManipulation stackManipulation, TypeDescription typeDescription) {
            return new MethodCall(this.f27298b, new TargetHandler.Simple(typeDescription, stackManipulation), this.f27300d, new MethodInvoker.ForVirtualInvocation.Factory(typeDescription), this.f27302f, this.f27303g, this.f27304h);
        }
    }

    public MethodCall(MethodLocator.Factory factory, TargetHandler.Factory factory2, List<ArgumentLoader.Factory> list, MethodInvoker.Factory factory3, TerminationHandler.Factory factory4, Assigner assigner, Assigner.Typing typing) {
        this.f27298b = factory;
        this.f27299c = factory2;
        this.f27300d = list;
        this.f27301e = factory3;
        this.f27302f = factory4;
        this.f27303g = assigner;
        this.f27304h = typing;
    }

    public static Implementation.Composable call(Callable<?> callable) {
        Class<Callable> cls = Callable.class;
        try {
            return invoke(cls.getMethod(NotificationCompat.CATEGORY_CALL, new Class[0])).on(callable, cls).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC);
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException("Could not locate Callable::call method", e11);
        }
    }

    public static MethodCall construct(Constructor<?> constructor) {
        return construct((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
    }

    public static WithoutSpecifiedTarget invoke(Method method) {
        return invoke((MethodDescription) new MethodDescription.ForLoadedMethod(method));
    }

    public static WithoutSpecifiedTarget invokeSelf() {
        return new WithoutSpecifiedTarget(MethodLocator.ForInstrumentedMethod.INSTANCE);
    }

    public static MethodCall invokeSuper() {
        return invokeSelf().onSuper();
    }

    public static Implementation.Composable run(Runnable runnable) {
        Class<Runnable> cls = Runnable.class;
        try {
            return invoke(cls.getMethod("run", new Class[0])).on(runnable, cls).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC);
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException("Could not locate Runnable::run method", e11);
        }
    }

    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(new MethodCall(this.f27298b, this.f27299c, this.f27300d, this.f27301e, TerminationHandler.Simple.DROPPING, this.f27303g, this.f27304h), implementation);
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(target, this.f27302f.make(target.getInstrumentedType()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MethodCall methodCall = (MethodCall) obj;
        return this.f27304h.equals(methodCall.f27304h) && this.f27298b.equals(methodCall.f27298b) && this.f27299c.equals(methodCall.f27299c) && this.f27300d.equals(methodCall.f27300d) && this.f27301e.equals(methodCall.f27301e) && this.f27302f.equals(methodCall.f27302f) && this.f27303g.equals(methodCall.f27303g);
    }

    public int hashCode() {
        return (((((((((((((getClass().hashCode() * 31) + this.f27298b.hashCode()) * 31) + this.f27299c.hashCode()) * 31) + this.f27300d.hashCode()) * 31) + this.f27301e.hashCode()) * 31) + this.f27302f.hashCode()) * 31) + this.f27303g.hashCode()) * 31) + this.f27304h.hashCode();
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        for (ArgumentLoader.Factory prepare : this.f27300d) {
            instrumentedType = prepare.prepare(instrumentedType);
        }
        return this.f27299c.prepare(instrumentedType);
    }

    public FieldSetting setsField(Field field) {
        return setsField((FieldDescription) new FieldDescription.ForLoadedField(field));
    }

    public MethodCall with(Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object of2 : objArr) {
            arrayList.add(ArgumentLoader.ForStackManipulation.of(of2));
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public MethodCall withAllArguments() {
        return with(ArgumentLoader.ForMethodParameter.OfInstrumentedMethod.INSTANCE);
    }

    public MethodCall withArgument(int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = iArr[i11];
            if (i12 >= 0) {
                arrayList.add(new ArgumentLoader.ForMethodParameter.Factory(i12));
                i11++;
            } else {
                throw new IllegalArgumentException("Negative index: " + i12);
            }
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public MethodCall withArgumentArray() {
        return with(ArgumentLoader.ForMethodParameterArray.ForInstrumentedMethod.INSTANCE);
    }

    public MethodCall withArgumentArrayElements(int i11) {
        if (i11 >= 0) {
            return with(new ArgumentLoader.ForMethodParameterArrayElement.OfInvokedMethod(i11));
        }
        throw new IllegalArgumentException("A parameter index cannot be negative: " + i11);
    }

    public Implementation.Composable withAssigner(Assigner assigner, Assigner.Typing typing) {
        return new MethodCall(this.f27298b, this.f27299c, this.f27300d, this.f27301e, this.f27302f, assigner, typing);
    }

    public MethodCall withField(String... strArr) {
        return withField(FieldLocator.ForClassHierarchy.Factory.INSTANCE, strArr);
    }

    public MethodCall withMethodCall(MethodCall methodCall) {
        return with(new ArgumentLoader.ForMethodCall.Factory(methodCall));
    }

    public MethodCall withOwnType() {
        return with(ArgumentLoader.ForInstrumentedType.Factory.INSTANCE);
    }

    public MethodCall withReference(Object... objArr) {
        Object obj;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                obj = ArgumentLoader.ForNullConstant.INSTANCE;
            } else {
                obj = new ArgumentLoader.ForInstance.Factory(obj2);
            }
            arrayList.add(obj);
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public MethodCall withThis() {
        return with(ArgumentLoader.ForThisReference.Factory.INSTANCE);
    }

    public static MethodCall construct(MethodDescription methodDescription) {
        if (methodDescription.isConstructor()) {
            return new MethodCall(new MethodLocator.ForExplicitMethod(methodDescription), TargetHandler.ForConstructingInvocation.Factory.INSTANCE, Collections.emptyList(), MethodInvoker.ForContextualInvocation.Factory.INSTANCE, TerminationHandler.Simple.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }
        throw new IllegalArgumentException("Not a constructor: " + methodDescription);
    }

    public static WithoutSpecifiedTarget invoke(Constructor<?> constructor) {
        return invoke((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
    }

    public Implementation.Composable andThen(Implementation.Composable composable) {
        return new Implementation.Compound.Composable((Implementation) new MethodCall(this.f27298b, this.f27299c, this.f27300d, this.f27301e, TerminationHandler.Simple.DROPPING, this.f27303g, this.f27304h), composable);
    }

    public FieldSetting setsField(FieldDescription fieldDescription) {
        return new FieldSetting(new MethodCall(this.f27298b, this.f27299c, this.f27300d, this.f27301e, new TerminationHandler.FieldSetting.Explicit(fieldDescription), this.f27303g, this.f27304h));
    }

    public MethodCall withField(FieldLocator.Factory factory, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String factory2 : strArr) {
            arrayList.add(new ArgumentLoader.ForField.Factory(factory2, factory));
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public static WithoutSpecifiedTarget invoke(MethodDescription methodDescription) {
        return invoke((MethodLocator.Factory) new MethodLocator.ForExplicitMethod(methodDescription));
    }

    public FieldSetting setsField(ElementMatcher<? super FieldDescription> elementMatcher) {
        return new FieldSetting(new MethodCall(this.f27298b, this.f27299c, this.f27300d, this.f27301e, new TerminationHandler.FieldSetting.Implicit(elementMatcher), this.f27303g, this.f27304h));
    }

    public MethodCall withArgumentArrayElements(int i11, int i12) {
        return withArgumentArrayElements(i11, 0, i12);
    }

    public static WithoutSpecifiedTarget invoke(ElementMatcher<? super MethodDescription> elementMatcher) {
        return invoke(elementMatcher, MethodGraph.Compiler.DEFAULT);
    }

    public MethodCall withArgumentArrayElements(int i11, int i12, int i13) {
        if (i11 < 0) {
            throw new IllegalArgumentException("A parameter index cannot be negative: " + i11);
        } else if (i12 < 0) {
            throw new IllegalArgumentException("An array index cannot be negative: " + i12);
        } else if (i13 == 0) {
            return this;
        } else {
            if (i13 >= 0) {
                ArrayList arrayList = new ArrayList(i13);
                for (int i14 = 0; i14 < i13; i14++) {
                    arrayList.add(new ArgumentLoader.ForMethodParameterArrayElement.OfParameter(i11, i12 + i14));
                }
                return with((List<? extends ArgumentLoader.Factory>) arrayList);
            }
            throw new IllegalArgumentException("Size cannot be negative: " + i13);
        }
    }

    public static WithoutSpecifiedTarget invoke(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
        return invoke((MethodLocator.Factory) new MethodLocator.ForElementMatcher.Factory(elementMatcher, compiler));
    }

    public MethodCall with(TypeDescription... typeDescriptionArr) {
        ArrayList arrayList = new ArrayList(typeDescriptionArr.length);
        for (TypeDescription of2 : typeDescriptionArr) {
            arrayList.add(new ArgumentLoader.ForStackManipulation(ClassConstant.of(of2), (Type) Class.class));
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public static WithoutSpecifiedTarget invoke(MethodLocator.Factory factory) {
        return new WithoutSpecifiedTarget(factory);
    }

    public MethodCall with(EnumerationDescription... enumerationDescriptionArr) {
        ArrayList arrayList = new ArrayList(enumerationDescriptionArr.length);
        for (EnumerationDescription enumerationDescription : enumerationDescriptionArr) {
            arrayList.add(new ArgumentLoader.ForStackManipulation(FieldAccess.forEnumeration(enumerationDescription), (TypeDefinition) enumerationDescription.getEnumerationType()));
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public MethodCall with(JavaConstant... javaConstantArr) {
        ArrayList arrayList = new ArrayList(javaConstantArr.length);
        for (JavaConstant javaConstant : javaConstantArr) {
            arrayList.add(new ArgumentLoader.ForStackManipulation((StackManipulation) new JavaConstantValue(javaConstant), (TypeDefinition) javaConstant.getTypeDescription()));
        }
        return with((List<? extends ArgumentLoader.Factory>) arrayList);
    }

    public MethodCall with(StackManipulation stackManipulation, Type type) {
        return with(stackManipulation, (TypeDefinition) TypeDefinition.Sort.describe(type));
    }

    public MethodCall with(StackManipulation stackManipulation, TypeDefinition typeDefinition) {
        return with(new ArgumentLoader.ForStackManipulation(stackManipulation, typeDefinition));
    }

    public MethodCall with(ArgumentLoader.Factory... factoryArr) {
        return with((List<? extends ArgumentLoader.Factory>) Arrays.asList(factoryArr));
    }

    public MethodCall with(List<? extends ArgumentLoader.Factory> list) {
        return new MethodCall(this.f27298b, this.f27299c, CompoundList.of(this.f27300d, (List<ArgumentLoader.Factory>) list), this.f27301e, this.f27302f, this.f27303g, this.f27304h);
    }
}
