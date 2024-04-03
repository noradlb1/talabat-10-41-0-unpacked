package net.bytebuddy.implementation;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
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
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
public abstract class FieldAccessor implements Implementation {

    /* renamed from: b  reason: collision with root package name */
    public final FieldLocation f27253b;

    /* renamed from: c  reason: collision with root package name */
    public final Assigner f27254c;

    /* renamed from: d  reason: collision with root package name */
    public final Assigner.Typing f27255d;

    public interface AssignerConfigurable extends PropertyConfigurable {
        PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    public interface FieldLocation {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Absolute implements FieldLocation, Prepared {
            private final FieldDescription fieldDescription;

            public Absolute(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Absolute) obj).fieldDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public Prepared prepare(TypeDescription typeDescription) {
                if (!this.fieldDescription.isStatic() && !typeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) {
                    throw new IllegalStateException(this.fieldDescription + " is not declared by " + typeDescription);
                } else if (this.fieldDescription.isAccessibleTo(typeDescription)) {
                    return this;
                } else {
                    throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                }
            }

            public FieldDescription resolve(MethodDescription methodDescription) {
                return this.fieldDescription;
            }

            public FieldLocation with(FieldLocator.Factory factory) {
                throw new IllegalStateException("Cannot specify a field locator factory for an absolute field location");
            }
        }

        public interface Prepared {
            FieldDescription resolve(MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Relative implements FieldLocation {
            private final FieldLocator.Factory fieldLocatorFactory;
            private final FieldNameExtractor fieldNameExtractor;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Prepared implements Prepared {
                private final FieldLocator fieldLocator;
                private final FieldNameExtractor fieldNameExtractor;

                public Prepared(FieldNameExtractor fieldNameExtractor2, FieldLocator fieldLocator2) {
                    this.fieldNameExtractor = fieldNameExtractor2;
                    this.fieldLocator = fieldLocator2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Prepared prepared = (Prepared) obj;
                    return this.fieldNameExtractor.equals(prepared.fieldNameExtractor) && this.fieldLocator.equals(prepared.fieldLocator);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fieldNameExtractor.hashCode()) * 31) + this.fieldLocator.hashCode();
                }

                public FieldDescription resolve(MethodDescription methodDescription) {
                    FieldLocator.Resolution locate = this.fieldLocator.locate(this.fieldNameExtractor.resolve(methodDescription));
                    if (locate.isResolved()) {
                        return locate.getField();
                    }
                    throw new IllegalStateException("Cannot resolve field for " + methodDescription + " using " + this.fieldLocator);
                }
            }

            public Relative(FieldNameExtractor fieldNameExtractor2) {
                this(fieldNameExtractor2, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Relative relative = (Relative) obj;
                return this.fieldNameExtractor.equals(relative.fieldNameExtractor) && this.fieldLocatorFactory.equals(relative.fieldLocatorFactory);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldNameExtractor.hashCode()) * 31) + this.fieldLocatorFactory.hashCode();
            }

            public Prepared prepare(TypeDescription typeDescription) {
                return new Prepared(this.fieldNameExtractor, this.fieldLocatorFactory.make(typeDescription));
            }

            public FieldLocation with(FieldLocator.Factory factory) {
                return new Relative(this.fieldNameExtractor, factory);
            }

            private Relative(FieldNameExtractor fieldNameExtractor2, FieldLocator.Factory factory) {
                this.fieldNameExtractor = fieldNameExtractor2;
                this.fieldLocatorFactory = factory;
            }
        }

        Prepared prepare(TypeDescription typeDescription);

        FieldLocation with(FieldLocator.Factory factory);
    }

    public interface FieldNameExtractor {

        public enum ForBeanProperty implements FieldNameExtractor {
            INSTANCE;

            public String resolve(MethodDescription methodDescription) {
                int i11;
                String internalName = methodDescription.getInternalName();
                if (internalName.startsWith("get") || internalName.startsWith("set")) {
                    i11 = 3;
                } else if (internalName.startsWith("is")) {
                    i11 = 2;
                } else {
                    throw new IllegalArgumentException(methodDescription + " does not follow Java bean naming conventions");
                }
                String substring = internalName.substring(i11);
                if (substring.length() != 0) {
                    return Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                }
                throw new IllegalArgumentException(methodDescription + " does not specify a bean name");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFixedValue implements FieldNameExtractor {

            /* renamed from: name  reason: collision with root package name */
            private final String f27256name;

            public ForFixedValue(String str) {
                this.f27256name = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.f27256name.equals(((ForFixedValue) obj).f27256name);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.f27256name.hashCode();
            }

            public String resolve(MethodDescription methodDescription) {
                return this.f27256name;
            }
        }

        String resolve(MethodDescription methodDescription);
    }

    public static class ForImplicitProperty extends FieldAccessor implements OwnerTypeLocatable {

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;

            public Appender(FieldLocation.Prepared prepared) {
                this.fieldLocation = prepared;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                StackManipulation.Compound compound;
                if (methodDescription.isMethod()) {
                    FieldDescription resolve = this.fieldLocation.resolve(methodDescription);
                    if (resolve.isStatic() || !methodDescription.isStatic()) {
                        if (resolve.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        if (!methodDescription.getReturnType().represents(Void.TYPE)) {
                            compound = new StackManipulation.Compound(stackManipulation, FieldAccess.forField(resolve).read(), ForImplicitProperty.this.f27254c.assign(resolve.getType(), methodDescription.getReturnType(), ForImplicitProperty.this.f27255d), MethodReturn.of(methodDescription.getReturnType()));
                        } else if (!methodDescription.getReturnType().represents(Void.TYPE) || methodDescription.getParameters().size() != 1) {
                            throw new IllegalArgumentException("Method " + methodDescription + " is no bean accessor");
                        } else if (!resolve.isFinal() || !methodDescription.isMethod()) {
                            compound = new StackManipulation.Compound(stackManipulation, MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(0)), ForImplicitProperty.this.f27254c.assign(((ParameterDescription) methodDescription.getParameters().get(0)).getType(), resolve.getType(), ForImplicitProperty.this.f27255d), FieldAccess.forField(resolve).write(), MethodReturn.VOID);
                        } else {
                            throw new IllegalStateException("Cannot set final field " + resolve + " from " + methodDescription);
                        }
                        if (compound.isValid()) {
                            return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                        }
                        throw new IllegalStateException("Cannot set or get value of " + methodDescription + " using " + resolve);
                    }
                    throw new IllegalStateException("Cannot set instance field " + resolve + " from " + methodDescription);
                }
                throw new IllegalArgumentException(methodDescription + " does not describe a field getter or setter");
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldLocation.equals(appender.fieldLocation) && ForImplicitProperty.this.equals(ForImplicitProperty.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldLocation.hashCode()) * 31) + ForImplicitProperty.this.hashCode();
            }
        }

        public ForImplicitProperty(FieldLocation fieldLocation) {
            this(fieldLocation, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(this.f27253b.prepare(target.getInstrumentedType()));
        }

        public AssignerConfigurable in(Class<?> cls) {
            return in(TypeDescription.ForLoadedType.of(cls));
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation.Composable setsArgumentAt(int i11) {
            if (i11 >= 0) {
                return new ForSetter.OfParameterValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING, i11);
            }
            throw new IllegalArgumentException("A parameter index cannot be negative: " + i11);
        }

        public Implementation.Composable setsDefaultValue() {
            return new ForSetter.OfDefaultValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING);
        }

        public Implementation.Composable setsFieldValueOf(Field field) {
            return setsFieldValueOf((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public Implementation.Composable setsReference(Object obj) {
            return setsReference(obj, "fixedFieldValue$" + RandomString.hashOf(obj.getClass().hashCode() ^ obj.hashCode()));
        }

        public Implementation.Composable setsValue(Object obj) {
            if (obj == null) {
                return setsDefaultValue();
            }
            Class<?> cls = obj.getClass();
            Class<String> cls2 = String.class;
            if (cls == cls2) {
                return setsValue((StackManipulation) new TextConstant((String) obj), (Type) cls2);
            }
            Class<Class> cls3 = Class.class;
            if (cls == cls3) {
                return setsValue(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)), (Type) cls3);
            }
            if (cls == Boolean.class) {
                return setsValue(IntegerConstant.forValue(((Boolean) obj).booleanValue()), (Type) Boolean.TYPE);
            }
            if (cls == Byte.class) {
                return setsValue(IntegerConstant.forValue((int) ((Byte) obj).byteValue()), (Type) Byte.TYPE);
            }
            if (cls == Short.class) {
                return setsValue(IntegerConstant.forValue((int) ((Short) obj).shortValue()), (Type) Short.TYPE);
            }
            if (cls == Character.class) {
                return setsValue(IntegerConstant.forValue((int) ((Character) obj).charValue()), (Type) Character.TYPE);
            }
            if (cls == Integer.class) {
                return setsValue(IntegerConstant.forValue(((Integer) obj).intValue()), (Type) Integer.TYPE);
            }
            if (cls == Long.class) {
                return setsValue(LongConstant.forValue(((Long) obj).longValue()), (Type) Long.TYPE);
            }
            if (cls == Float.class) {
                return setsValue(FloatConstant.forValue(((Float) obj).floatValue()), (Type) Float.TYPE);
            }
            if (cls == Double.class) {
                return setsValue(DoubleConstant.forValue(((Double) obj).doubleValue()), (Type) Double.TYPE);
            }
            if (JavaType.METHOD_HANDLE.getTypeStub().isAssignableFrom(cls)) {
                return setsValue((StackManipulation) new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)), (Type) cls);
            }
            if (JavaType.METHOD_TYPE.getTypeStub().represents(cls)) {
                return setsValue((StackManipulation) new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)), (Type) cls);
            }
            return setsReference(obj);
        }

        public PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForImplicitProperty(this.f27253b, assigner, typing);
        }

        private ForImplicitProperty(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing) {
            super(fieldLocation, assigner, typing);
        }

        public AssignerConfigurable in(TypeDescription typeDescription) {
            return in((FieldLocator.Factory) new FieldLocator.ForExactType.Factory(typeDescription));
        }

        public Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription) {
            return new ForSetter.OfFieldValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Absolute(fieldDescription));
        }

        public Implementation.Composable setsReference(Object obj, String str) {
            return new ForSetter.OfReferenceValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING, obj, str);
        }

        public AssignerConfigurable in(FieldLocator.Factory factory) {
            return new ForImplicitProperty(this.f27253b.with(factory), this.f27254c, this.f27255d);
        }

        public Implementation.Composable setsFieldValueOf(String str) {
            return setsFieldValueOf((FieldNameExtractor) new FieldNameExtractor.ForFixedValue(str));
        }

        public Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor) {
            return new ForSetter.OfFieldValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Relative(fieldNameExtractor));
        }

        public Implementation.Composable setsValue(TypeDescription typeDescription) {
            return setsValue(ClassConstant.of(typeDescription), (Type) Class.class);
        }

        public Implementation.Composable setsValue(JavaConstant javaConstant) {
            return setsValue((StackManipulation) new JavaConstantValue(javaConstant), javaConstant.getTypeDescription().asGenericType());
        }

        public Implementation.Composable setsValue(StackManipulation stackManipulation, Type type) {
            return setsValue(stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return new ForSetter.OfConstantValue(this.f27253b, this.f27254c, this.f27255d, ForSetter.TerminationHandler.RETURNING, generic, stackManipulation);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class ForSetter<T> extends FieldAccessor implements Implementation.Composable {
        /* access modifiers changed from: private */
        public final TerminationHandler terminationHandler;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;
            private final T initialized;
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription, T t11, FieldLocation.Prepared prepared) {
                this.instrumentedType = typeDescription;
                this.initialized = t11;
                this.fieldLocation = prepared;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                FieldDescription resolve = this.fieldLocation.resolve(methodDescription);
                if (!resolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot set instance field " + resolve + " from " + methodDescription);
                } else if (!resolve.isFinal() || !methodDescription.isMethod()) {
                    StackManipulation c11 = ForSetter.this.c(this.initialized, resolve, this.instrumentedType, methodDescription);
                    if (c11.isValid()) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[4];
                        if (methodDescription.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        stackManipulationArr[0] = stackManipulation;
                        stackManipulationArr[1] = c11;
                        stackManipulationArr[2] = FieldAccess.forField(resolve).write();
                        stackManipulationArr[3] = ForSetter.this.terminationHandler.a(methodDescription);
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }
                    throw new IllegalStateException("Set value cannot be assigned to " + resolve);
                } else {
                    throw new IllegalStateException("Cannot set final field " + resolve + " from " + methodDescription);
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.instrumentedType.equals(appender.instrumentedType) && this.initialized.equals(appender.initialized) && this.fieldLocation.equals(appender.fieldLocation) && ForSetter.this.equals(ForSetter.this);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.initialized.hashCode()) * 31) + this.fieldLocation.hashCode()) * 31) + ForSetter.this.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfConstantValue extends ForSetter<Void> {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic typeDescription;

            public OfConstantValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, TypeDescription.Generic generic, StackManipulation stackManipulation2) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.typeDescription = generic;
                this.stackManipulation = stackManipulation2;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfConstantValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), implementation);
            }

            /* renamed from: d */
            public Void b(TypeDescription typeDescription2) {
                return null;
            }

            /* renamed from: e */
            public StackManipulation c(Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription2, MethodDescription methodDescription) {
                return new StackManipulation.Compound(this.stackManipulation, this.f27254c.assign(this.typeDescription, fieldDescription.getType(), this.f27255d));
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfConstantValue ofConstantValue = (OfConstantValue) obj;
                return this.typeDescription.equals(ofConstantValue.typeDescription) && this.stackManipulation.equals(ofConstantValue.stackManipulation);
            }

            public int hashCode() {
                return (((super.hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.stackManipulation.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfConstantValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), composable);
            }
        }

        public static class OfDefaultValue extends ForSetter<Void> {
            public OfDefaultValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler) {
                super(fieldLocation, assigner, typing, terminationHandler);
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfDefaultValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL), implementation);
            }

            /* renamed from: d */
            public Void b(TypeDescription typeDescription) {
                return null;
            }

            /* renamed from: e */
            public StackManipulation c(Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                return DefaultValue.of(fieldDescription.getType());
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfDefaultValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL), composable);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfFieldValue extends ForSetter<FieldLocation.Prepared> {
            private final FieldLocation target;

            public OfFieldValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, FieldLocation fieldLocation2) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.target = fieldLocation2;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfFieldValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.target), implementation);
            }

            /* renamed from: d */
            public FieldLocation.Prepared b(TypeDescription typeDescription) {
                return this.target.prepare(typeDescription);
            }

            /* renamed from: e */
            public StackManipulation c(FieldLocation.Prepared prepared, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                FieldDescription resolve = prepared.resolve(methodDescription);
                if (resolve.isStatic() || !methodDescription.isStatic()) {
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (resolve.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(resolve).read();
                    stackManipulationArr[2] = this.f27254c.assign(resolve.getType(), fieldDescription.getType(), this.f27255d);
                    return new StackManipulation.Compound(stackManipulationArr);
                }
                throw new IllegalStateException("Cannot set instance field " + fieldDescription + " from " + methodDescription);
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((OfFieldValue) obj).target);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.target.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfFieldValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.target), composable);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfParameterValue extends ForSetter<Void> {
            private final int index;

            public OfParameterValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, int i11) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.index = i11;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfParameterValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.index), implementation);
            }

            /* renamed from: d */
            public Void b(TypeDescription typeDescription) {
                return null;
            }

            /* renamed from: e */
            public StackManipulation c(Void voidR, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (methodDescription.getParameters().size() > this.index) {
                    return new StackManipulation.Compound(MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(this.index)), this.f27254c.assign(((ParameterDescription) methodDescription.getParameters().get(this.index)).getType(), fieldDescription.getType(), this.f27255d));
                }
                throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.index == ((OfParameterValue) obj).index;
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.index;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfParameterValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.index), composable);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfReferenceValue extends ForSetter<FieldDescription.InDefinedShape> {

            /* renamed from: name  reason: collision with root package name */
            private final String f27259name;
            private final Object value;

            public OfReferenceValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, Object obj, String str) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.value = obj;
                this.f27259name = str;
            }

            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfReferenceValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.value, this.f27259name), implementation);
            }

            /* renamed from: d */
            public FieldDescription.InDefinedShape b(TypeDescription typeDescription) {
                return (FieldDescription.InDefinedShape) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.f27259name))).getOnly();
            }

            /* renamed from: e */
            public StackManipulation c(FieldDescription.InDefinedShape inDefinedShape, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (!fieldDescription.isFinal() || !methodDescription.isMethod()) {
                    return new StackManipulation.Compound(FieldAccess.forField(inDefinedShape).read(), this.f27254c.assign(TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType(), fieldDescription.getType(), this.f27255d));
                }
                throw new IllegalArgumentException("Cannot set final field " + fieldDescription + " from " + methodDescription);
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfReferenceValue ofReferenceValue = (OfReferenceValue) obj;
                return this.f27259name.equals(ofReferenceValue.f27259name) && this.value.equals(ofReferenceValue.value);
            }

            public int hashCode() {
                return (((super.hashCode() * 31) + this.value.hashCode()) * 31) + this.f27259name.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                if (((FieldList) instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.f27259name).and(ElementMatchers.fieldType(this.value.getClass())))).isEmpty()) {
                    return instrumentedType.withField(new FieldDescription.Token(this.f27259name, 4105, TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType())).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.f27259name, this.value));
                }
                throw new IllegalStateException("Field with name " + this.f27259name + " and type " + this.value.getClass() + " already declared by " + instrumentedType);
            }

            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable((Implementation) new OfReferenceValue(this.f27253b, this.f27254c, this.f27255d, TerminationHandler.NON_OPERATIONAL, this.value, this.f27259name), composable);
            }
        }

        public enum TerminationHandler {
            RETURNING {
                public StackManipulation a(MethodDescription methodDescription) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return MethodReturn.VOID;
                    }
                    throw new IllegalStateException("Cannot implement setter with return value for " + methodDescription);
                }
            },
            NON_OPERATIONAL {
                public StackManipulation a(MethodDescription methodDescription) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            };

            public abstract StackManipulation a(MethodDescription methodDescription);
        }

        public ForSetter(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler2) {
            super(fieldLocation, assigner, typing);
            this.terminationHandler = terminationHandler2;
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType(), b(target.getInstrumentedType()), this.f27253b.prepare(target.getInstrumentedType()));
        }

        public abstract T b(TypeDescription typeDescription);

        public abstract StackManipulation c(T t11, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription);

        public boolean equals(Object obj) {
            if (!FieldAccessor.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.terminationHandler.equals(((ForSetter) obj).terminationHandler);
        }

        public int hashCode() {
            return (FieldAccessor.super.hashCode() * 31) + this.terminationHandler.hashCode();
        }
    }

    public interface OwnerTypeLocatable extends AssignerConfigurable {
        AssignerConfigurable in(Class<?> cls);

        AssignerConfigurable in(TypeDescription typeDescription);

        AssignerConfigurable in(FieldLocator.Factory factory);
    }

    public interface PropertyConfigurable extends Implementation {
        Implementation.Composable setsArgumentAt(int i11);

        Implementation.Composable setsDefaultValue();

        Implementation.Composable setsFieldValueOf(String str);

        Implementation.Composable setsFieldValueOf(Field field);

        Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription);

        Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor);

        Implementation.Composable setsReference(Object obj);

        Implementation.Composable setsReference(Object obj, String str);

        Implementation.Composable setsValue(Object obj);

        Implementation.Composable setsValue(TypeDescription typeDescription);

        Implementation.Composable setsValue(StackManipulation stackManipulation, Type type);

        Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic);

        Implementation.Composable setsValue(JavaConstant javaConstant);
    }

    public FieldAccessor(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing) {
        this.f27253b = fieldLocation;
        this.f27254c = assigner;
        this.f27255d = typing;
    }

    public static OwnerTypeLocatable of(FieldNameExtractor fieldNameExtractor) {
        return new ForImplicitProperty(new FieldLocation.Relative(fieldNameExtractor));
    }

    public static OwnerTypeLocatable ofBeanProperty() {
        return of((FieldNameExtractor) FieldNameExtractor.ForBeanProperty.INSTANCE);
    }

    public static OwnerTypeLocatable ofField(String str) {
        return of((FieldNameExtractor) new FieldNameExtractor.ForFixedValue(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FieldAccessor fieldAccessor = (FieldAccessor) obj;
        return this.f27255d.equals(fieldAccessor.f27255d) && this.f27253b.equals(fieldAccessor.f27253b) && this.f27254c.equals(fieldAccessor.f27254c);
    }

    public int hashCode() {
        return (((((getClass().hashCode() * 31) + this.f27253b.hashCode()) * 31) + this.f27254c.hashCode()) * 31) + this.f27255d.hashCode();
    }

    public static AssignerConfigurable of(Field field) {
        return of((FieldDescription) new FieldDescription.ForLoadedField(field));
    }

    public static AssignerConfigurable of(FieldDescription fieldDescription) {
        return new ForImplicitProperty(new FieldLocation.Absolute(fieldDescription));
    }
}
