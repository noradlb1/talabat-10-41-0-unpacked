package net.bytebuddy.implementation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
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
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
public class InvokeDynamic implements Implementation.Composable {

    /* renamed from: b  reason: collision with root package name */
    public final MethodDescription.InDefinedShape f27286b;

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends JavaConstant> f27287c;

    /* renamed from: d  reason: collision with root package name */
    public final InvocationProvider f27288d;

    /* renamed from: e  reason: collision with root package name */
    public final TerminationHandler f27289e;

    /* renamed from: f  reason: collision with root package name */
    public final Assigner f27290f;

    /* renamed from: g  reason: collision with root package name */
    public final Assigner.Typing f27291g;

    public static abstract class AbstractDelegator extends InvokeDynamic {
        public AbstractDelegator(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing) {
            super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
        }

        public abstract InvokeDynamic a();

        public Implementation andThen(Implementation implementation) {
            return a().andThen(implementation);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return a().appender(target);
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return a().prepare(instrumentedType);
        }

        public InvokeDynamic withArgument(int... iArr) {
            return a().withArgument(iArr);
        }

        public Implementation.Composable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return a().withAssigner(assigner, typing);
        }

        public InvokeDynamic withBooleanValue(boolean... zArr) {
            return a().withBooleanValue(zArr);
        }

        public InvokeDynamic withByteValue(byte... bArr) {
            return a().withByteValue(bArr);
        }

        public InvokeDynamic withCharacterValue(char... cArr) {
            return a().withCharacterValue(cArr);
        }

        public InvokeDynamic withDoubleValue(double... dArr) {
            return a().withDoubleValue(dArr);
        }

        public InvokeDynamic withEnumeration(EnumerationDescription... enumerationDescriptionArr) {
            return a().withEnumeration(enumerationDescriptionArr);
        }

        public InvokeDynamic withField(String... strArr) {
            return a().withField(strArr);
        }

        public InvokeDynamic withFloatValue(float... fArr) {
            return a().withFloatValue(fArr);
        }

        public InvokeDynamic withImplicitAndMethodArguments() {
            return a().withImplicitAndMethodArguments();
        }

        public InvokeDynamic withInstance(JavaConstant... javaConstantArr) {
            return a().withInstance(javaConstantArr);
        }

        public InvokeDynamic withIntegerValue(int... iArr) {
            return a().withIntegerValue(iArr);
        }

        public InvokeDynamic withLongValue(long... jArr) {
            return a().withLongValue(jArr);
        }

        public InvokeDynamic withMethodArguments() {
            return a().withMethodArguments();
        }

        public InvokeDynamic withNullValue(Class<?>... clsArr) {
            return a().withNullValue(clsArr);
        }

        public WithImplicitType withReference(Object obj) {
            return a().withReference(obj);
        }

        public InvokeDynamic withShortValue(short... sArr) {
            return a().withShortValue(sArr);
        }

        public InvokeDynamic withThis(Class<?>... clsArr) {
            return a().withThis(clsArr);
        }

        public InvokeDynamic withType(TypeDescription... typeDescriptionArr) {
            return a().withType(typeDescriptionArr);
        }

        public InvokeDynamic withValue(Object... objArr) {
            return a().withValue(objArr);
        }

        public WithImplicitType withArgument(int i11) {
            return a().withArgument(i11);
        }

        public InvokeDynamic withField(FieldLocator.Factory factory, String... strArr) {
            return a().withField(factory, strArr);
        }

        public InvokeDynamic withNullValue(TypeDescription... typeDescriptionArr) {
            return a().withNullValue(typeDescriptionArr);
        }

        public InvokeDynamic withReference(Object... objArr) {
            return a().withReference(objArr);
        }

        public InvokeDynamic withThis(TypeDescription... typeDescriptionArr) {
            return a().withThis(typeDescriptionArr);
        }

        public WithImplicitType withField(String str) {
            return a().withField(str);
        }

        public WithImplicitType withField(String str, FieldLocator.Factory factory) {
            return a().withField(str, factory);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class Appender implements ByteCodeAppender {
        private final TypeDescription instrumentedType;

        public Appender(TypeDescription typeDescription) {
            this.instrumentedType = typeDescription;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            InvocationProvider.Target make = InvokeDynamic.this.f27288d.make(methodDescription);
            TypeDescription typeDescription = this.instrumentedType;
            InvokeDynamic invokeDynamic = InvokeDynamic.this;
            InvocationProvider.Target.Resolved resolve = make.resolve(typeDescription, invokeDynamic.f27290f, invokeDynamic.f27291g);
            TerminationHandler terminationHandler = InvokeDynamic.this.f27289e;
            TypeDescription returnType = resolve.getReturnType();
            InvokeDynamic invokeDynamic2 = InvokeDynamic.this;
            return new ByteCodeAppender.Size(new StackManipulation.Compound(resolve.getStackManipulation(), MethodInvocation.invoke(InvokeDynamic.this.f27286b).dynamic(resolve.getInternalName(), resolve.getReturnType(), resolve.getParameterTypes(), InvokeDynamic.this.f27287c), terminationHandler.a(methodDescription, returnType, invokeDynamic2.f27290f, invokeDynamic2.f27291g)).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.instrumentedType.equals(appender.instrumentedType) && InvokeDynamic.this.equals(InvokeDynamic.this);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + InvokeDynamic.this.hashCode();
        }
    }

    public interface InvocationProvider {

        public interface ArgumentProvider {

            public enum ConstantPoolWrapper {
                BOOLEAN(Boolean.TYPE, Boolean.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(IntegerConstant.forValue(((Boolean) obj).booleanValue()));
                    }
                },
                BYTE(Byte.TYPE, Byte.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(IntegerConstant.forValue((int) ((Byte) obj).byteValue()));
                    }
                },
                SHORT(Short.TYPE, Short.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(IntegerConstant.forValue((int) ((Short) obj).shortValue()));
                    }
                },
                CHARACTER(Character.TYPE, Character.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(IntegerConstant.forValue((int) ((Character) obj).charValue()));
                    }
                },
                INTEGER(Integer.TYPE, Integer.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(IntegerConstant.forValue(((Integer) obj).intValue()));
                    }
                },
                LONG(Long.TYPE, Long.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(LongConstant.forValue(((Long) obj).longValue()));
                    }
                },
                FLOAT(Float.TYPE, Float.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(FloatConstant.forValue(((Float) obj).floatValue()));
                    }
                },
                DOUBLE(Double.TYPE, Double.class) {
                    public ArgumentProvider c(Object obj) {
                        return new WrappingArgumentProvider(DoubleConstant.forValue(((Double) obj).doubleValue()));
                    }
                };
                
                /* access modifiers changed from: private */
                public final TypeDescription primitiveType;
                /* access modifiers changed from: private */
                public final TypeDescription wrapperType;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class WrappingArgumentProvider implements ArgumentProvider {
                    private final StackManipulation stackManipulation;

                    public WrappingArgumentProvider(StackManipulation stackManipulation2) {
                        this.stackManipulation = stackManipulation2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WrappingArgumentProvider wrappingArgumentProvider = (WrappingArgumentProvider) obj;
                        return ConstantPoolWrapper.this.equals(ConstantPoolWrapper.this) && this.stackManipulation.equals(wrappingArgumentProvider.stackManipulation);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + ConstantPoolWrapper.this.hashCode();
                    }

                    public InstrumentedType prepare(InstrumentedType instrumentedType) {
                        return instrumentedType;
                    }

                    public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                        return new Resolved.Simple((StackManipulation) new StackManipulation.Compound(this.stackManipulation, assigner.assign(ConstantPoolWrapper.this.primitiveType.asGenericType(), ConstantPoolWrapper.this.wrapperType.asGenericType(), typing)), ConstantPoolWrapper.this.wrapperType);
                    }
                }

                public static ArgumentProvider of(Object obj) {
                    if (obj instanceof Boolean) {
                        return BOOLEAN.c(obj);
                    }
                    if (obj instanceof Byte) {
                        return BYTE.c(obj);
                    }
                    if (obj instanceof Short) {
                        return SHORT.c(obj);
                    }
                    if (obj instanceof Character) {
                        return CHARACTER.c(obj);
                    }
                    if (obj instanceof Integer) {
                        return INTEGER.c(obj);
                    }
                    if (obj instanceof Long) {
                        return LONG.c(obj);
                    }
                    if (obj instanceof Float) {
                        return FLOAT.c(obj);
                    }
                    if (obj instanceof Double) {
                        return DOUBLE.c(obj);
                    }
                    if (obj instanceof String) {
                        return new ForStringConstant((String) obj);
                    }
                    if (obj instanceof Class) {
                        return new ForClassConstant(TypeDescription.ForLoadedType.of((Class) obj));
                    }
                    if (obj instanceof TypeDescription) {
                        return new ForClassConstant((TypeDescription) obj);
                    }
                    if (obj instanceof Enum) {
                        return new ForEnumerationValue(new EnumerationDescription.ForLoadedEnumeration((Enum) obj));
                    }
                    if (obj instanceof EnumerationDescription) {
                        return new ForEnumerationValue((EnumerationDescription) obj);
                    }
                    if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                        return new ForJavaConstant(JavaConstant.MethodHandle.ofLoaded(obj));
                    }
                    if (JavaType.METHOD_TYPE.isInstance(obj)) {
                        return new ForJavaConstant(JavaConstant.MethodType.ofLoaded(obj));
                    }
                    if (obj instanceof JavaConstant) {
                        return new ForJavaConstant((JavaConstant) obj);
                    }
                    return ForInstance.a(obj);
                }

                public abstract ArgumentProvider c(Object obj);

                private ConstantPoolWrapper(Class<?> cls, Class<?> cls2) {
                    this.primitiveType = TypeDescription.ForLoadedType.of(cls);
                    this.wrapperType = TypeDescription.ForLoadedType.of(cls2);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForBooleanConstant implements ArgumentProvider {
                private final boolean value;

                public ForBooleanConstant(boolean z11) {
                    this.value = z11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForBooleanConstant) obj).value;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + (this.value ? 1 : 0);
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(Boolean.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForByteConstant implements ArgumentProvider {
                private final byte value;

                public ForByteConstant(byte b11) {
                    this.value = b11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForByteConstant) obj).value;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(IntegerConstant.forValue((int) this.value), TypeDescription.ForLoadedType.of(Byte.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForCharacterConstant implements ArgumentProvider {
                private final char value;

                public ForCharacterConstant(char c11) {
                    this.value = c11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForCharacterConstant) obj).value;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(IntegerConstant.forValue((int) this.value), TypeDescription.ForLoadedType.of(Character.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForClassConstant implements ArgumentProvider {
                private final TypeDescription typeDescription;

                public ForClassConstant(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForClassConstant) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(ClassConstant.of(this.typeDescription), TypeDescription.CLASS);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForDoubleConstant implements ArgumentProvider {
                private final double value;

                public ForDoubleConstant(double d11) {
                    this.value = d11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && Double.compare(this.value, ((ForDoubleConstant) obj).value) == 0;
                }

                public int hashCode() {
                    long doubleToLongBits = Double.doubleToLongBits(this.value);
                    return (getClass().hashCode() * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(DoubleConstant.forValue(this.value), TypeDescription.ForLoadedType.of(Double.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForEnumerationValue implements ArgumentProvider {
                private final EnumerationDescription enumerationDescription;

                public ForEnumerationValue(EnumerationDescription enumerationDescription2) {
                    this.enumerationDescription = enumerationDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.enumerationDescription.equals(((ForEnumerationValue) obj).enumerationDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.enumerationDescription.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(FieldAccess.forEnumeration(this.enumerationDescription), this.enumerationDescription.getEnumerationType());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForField implements ArgumentProvider {

                /* renamed from: b  reason: collision with root package name */
                public final String f27294b;

                /* renamed from: c  reason: collision with root package name */
                public final FieldLocator.Factory f27295c;

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends ForField {
                    private final TypeDescription typeDescription;

                    public WithExplicitType(String str, FieldLocator.Factory factory, TypeDescription typeDescription2) {
                        super(str, factory);
                        this.typeDescription = typeDescription2;
                    }

                    public Resolved a(StackManipulation stackManipulation, TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
                        StackManipulation assign = assigner.assign(generic, this.typeDescription.asGenericType(), typing);
                        if (assign.isValid()) {
                            return new Resolved.Simple((StackManipulation) new StackManipulation.Compound(stackManipulation, assign), this.typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + this.typeDescription);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((WithExplicitType) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.typeDescription.hashCode();
                    }
                }

                public ForField(String str, FieldLocator.Factory factory) {
                    this.f27294b = str;
                    this.f27295c = factory;
                }

                public Resolved a(StackManipulation stackManipulation, TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(stackManipulation, generic.asErasure());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.f27294b.equals(forField.f27294b) && this.f27295c.equals(forField.f27295c);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27294b.hashCode()) * 31) + this.f27295c.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    StackManipulation stackManipulation;
                    FieldLocator.Resolution locate = this.f27295c.make(typeDescription).locate(this.f27294b);
                    if (!locate.isResolved()) {
                        throw new IllegalStateException("Cannot find a field " + this.f27294b + " for " + typeDescription);
                    } else if (locate.getField().isStatic() || !methodDescription.isStatic()) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[2];
                        if (locate.getField().isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = MethodVariableAccess.loadThis();
                        }
                        stackManipulationArr[0] = stackManipulation;
                        stackManipulationArr[1] = FieldAccess.forField(locate.getField()).read();
                        return a(new StackManipulation.Compound(stackManipulationArr), locate.getField().getType(), assigner, typing);
                    } else {
                        throw new IllegalStateException("Cannot access non-static " + locate.getField() + " from " + methodDescription);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFloatConstant implements ArgumentProvider {
                private final float value;

                public ForFloatConstant(float f11) {
                    this.value = f11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && Float.compare(this.value, ((ForFloatConstant) obj).value) == 0;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + Float.floatToIntBits(this.value);
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(FloatConstant.forValue(this.value), TypeDescription.ForLoadedType.of(Float.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForInstance implements ArgumentProvider {
                private static final String FIELD_PREFIX = "invokeDynamic";
                private final TypeDescription fieldType;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)

                /* renamed from: name  reason: collision with root package name */
                private final String f27296name = ("invokeDynamic$" + RandomString.make());
                private final Object value;

                public ForInstance(Object obj, TypeDescription typeDescription) {
                    this.value = obj;
                    this.fieldType = typeDescription;
                }

                public static ArgumentProvider a(Object obj) {
                    return new ForInstance(obj, TypeDescription.ForLoadedType.of(obj.getClass()));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForInstance forInstance = (ForInstance) obj;
                    return this.value.equals(forInstance.value) && this.fieldType.equals(forInstance.fieldType);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.value.hashCode()) * 31) + this.fieldType.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType.withField(new FieldDescription.Token(this.f27296name, 4169, this.fieldType.asGenericType())).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.f27296name, this.value));
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    FieldDescription fieldDescription = (FieldDescription) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.f27296name))).getOnly();
                    StackManipulation assign = assigner.assign(fieldDescription.getType(), this.fieldType.asGenericType(), typing);
                    if (assign.isValid()) {
                        return new Resolved.Simple((StackManipulation) new StackManipulation.Compound(FieldAccess.forField(fieldDescription).read(), assign), fieldDescription.getType().asErasure());
                    }
                    throw new IllegalStateException("Cannot assign " + fieldDescription + " to " + this.fieldType);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForIntegerConstant implements ArgumentProvider {
                private final int value;

                public ForIntegerConstant(int i11) {
                    this.value = i11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForIntegerConstant) obj).value;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(IntegerConstant.forValue(this.value), TypeDescription.ForLoadedType.of(Integer.TYPE));
                }
            }

            public enum ForInterceptedMethodInstanceAndParameters implements ArgumentProvider {
                INSTANCE;

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    List list;
                    StackManipulation prependThisReference = MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference();
                    if (methodDescription.isStatic()) {
                        list = methodDescription.getParameters().asTypeList().asErasures();
                    } else {
                        list = CompoundList.of(methodDescription.getDeclaringType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
                    }
                    return new Resolved.Simple(prependThisReference, (List<TypeDescription>) list);
                }
            }

            public enum ForInterceptedMethodParameters implements ArgumentProvider {
                INSTANCE;

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple((StackManipulation) MethodVariableAccess.allArgumentsOf(methodDescription), (List<TypeDescription>) methodDescription.getParameters().asTypeList().asErasures());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForJavaConstant implements ArgumentProvider {
                private final JavaConstant javaConstant;

                public ForJavaConstant(JavaConstant javaConstant2) {
                    this.javaConstant = javaConstant2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.javaConstant.equals(((ForJavaConstant) obj).javaConstant);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.javaConstant.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple((StackManipulation) new JavaConstantValue(this.javaConstant), this.javaConstant.getTypeDescription());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForLongConstant implements ArgumentProvider {
                private final long value;

                public ForLongConstant(long j11) {
                    this.value = j11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForLongConstant) obj).value;
                }

                public int hashCode() {
                    long j11 = this.value;
                    return (getClass().hashCode() * 31) + ((int) (j11 ^ (j11 >>> 32)));
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(LongConstant.forValue(this.value), TypeDescription.ForLoadedType.of(Long.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMethodParameter implements ArgumentProvider {

                /* renamed from: b  reason: collision with root package name */
                public final int f27297b;

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends ForMethodParameter {
                    private final TypeDescription typeDescription;

                    public WithExplicitType(int i11, TypeDescription typeDescription2) {
                        super(i11);
                        this.typeDescription = typeDescription2;
                    }

                    public Resolved a(StackManipulation stackManipulation, TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
                        StackManipulation assign = assigner.assign(generic, this.typeDescription.asGenericType(), typing);
                        if (assign.isValid()) {
                            return new Resolved.Simple((StackManipulation) new StackManipulation.Compound(stackManipulation, assign), this.typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + this.typeDescription);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((WithExplicitType) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.typeDescription.hashCode();
                    }
                }

                public ForMethodParameter(int i11) {
                    this.f27297b = i11;
                }

                public Resolved a(StackManipulation stackManipulation, TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(stackManipulation, generic.asErasure());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.f27297b == ((ForMethodParameter) obj).f27297b;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.f27297b;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    ParameterList<?> parameters = methodDescription.getParameters();
                    if (this.f27297b < parameters.size()) {
                        return a(MethodVariableAccess.load((ParameterDescription) parameters.get(this.f27297b)), ((ParameterDescription) parameters.get(this.f27297b)).getType(), assigner, typing);
                    }
                    throw new IllegalStateException("No parameter " + this.f27297b + " for " + methodDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForNullValue implements ArgumentProvider {
                private final TypeDescription typeDescription;

                public ForNullValue(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForNullValue) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple((StackManipulation) NullConstant.INSTANCE, this.typeDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForShortConstant implements ArgumentProvider {
                private final short value;

                public ForShortConstant(short s11) {
                    this.value = s11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((ForShortConstant) obj).value;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value;
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple(IntegerConstant.forValue((int) this.value), TypeDescription.ForLoadedType.of(Short.TYPE));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStringConstant implements ArgumentProvider {
                private final String value;

                public ForStringConstant(String str) {
                    this.value = str;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value.equals(((ForStringConstant) obj).value);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.value.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    return new Resolved.Simple((StackManipulation) new TextConstant(this.value), TypeDescription.STRING);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForThisInstance implements ArgumentProvider {
                private final TypeDescription typeDescription;

                public ForThisInstance(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForThisInstance) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                public Resolved resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing) {
                    if (methodDescription.isStatic()) {
                        throw new IllegalStateException("Cannot get this instance from static method: " + methodDescription);
                    } else if (typeDescription2.isAssignableTo(this.typeDescription)) {
                        return new Resolved.Simple(MethodVariableAccess.loadThis(), this.typeDescription);
                    } else {
                        throw new IllegalStateException(typeDescription2 + " is not assignable to " + typeDescription2);
                    }
                }
            }

            public interface Resolved {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements Resolved {
                    private final List<TypeDescription> loadedTypes;
                    private final StackManipulation stackManipulation;

                    public Simple(StackManipulation stackManipulation2, TypeDescription typeDescription) {
                        this(stackManipulation2, (List<TypeDescription>) Collections.singletonList(typeDescription));
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.stackManipulation.equals(simple.stackManipulation) && this.loadedTypes.equals(simple.loadedTypes);
                    }

                    public StackManipulation getLoadInstruction() {
                        return this.stackManipulation;
                    }

                    public List<TypeDescription> getLoadedTypes() {
                        return this.loadedTypes;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.loadedTypes.hashCode();
                    }

                    public Simple(StackManipulation stackManipulation2, List<TypeDescription> list) {
                        this.stackManipulation = stackManipulation2;
                        this.loadedTypes = list;
                    }
                }

                StackManipulation getLoadInstruction();

                List<TypeDescription> getLoadedTypes();
            }

            InstrumentedType prepare(InstrumentedType instrumentedType);

            Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Assigner.Typing typing);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Default implements InvocationProvider {
            private final List<ArgumentProvider> argumentProviders;
            private final NameProvider nameProvider;
            private final ReturnTypeProvider returnTypeProvider;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Target implements Target {
                private final List<ArgumentProvider> argumentProviders;
                private final MethodDescription instrumentedMethod;
                private final String internalName;
                private final TypeDescription returnType;

                public Target(String str, TypeDescription typeDescription, List<ArgumentProvider> list, MethodDescription methodDescription) {
                    this.internalName = str;
                    this.returnType = typeDescription;
                    this.argumentProviders = list;
                    this.instrumentedMethod = methodDescription;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Target target = (Target) obj;
                    return this.internalName.equals(target.internalName) && this.returnType.equals(target.returnType) && this.argumentProviders.equals(target.argumentProviders) && this.instrumentedMethod.equals(target.instrumentedMethod);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.internalName.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.argumentProviders.hashCode()) * 31) + this.instrumentedMethod.hashCode();
                }

                public Target.Resolved resolve(TypeDescription typeDescription, Assigner assigner, Assigner.Typing typing) {
                    StackManipulation[] stackManipulationArr = new StackManipulation[this.argumentProviders.size()];
                    ArrayList arrayList = new ArrayList();
                    int i11 = 0;
                    for (ArgumentProvider resolve : this.argumentProviders) {
                        ArgumentProvider.Resolved resolve2 = resolve.resolve(typeDescription, this.instrumentedMethod, assigner, typing);
                        arrayList.addAll(resolve2.getLoadedTypes());
                        stackManipulationArr[i11] = resolve2.getLoadInstruction();
                        i11++;
                    }
                    return new Target.Resolved.Simple(new StackManipulation.Compound(stackManipulationArr), this.internalName, this.returnType, arrayList);
                }
            }

            public Default() {
                this(NameProvider.ForInterceptedMethod.INSTANCE, ReturnTypeProvider.ForInterceptedMethod.INSTANCE, Collections.singletonList(ArgumentProvider.ForInterceptedMethodInstanceAndParameters.INSTANCE));
            }

            public InvocationProvider appendArgument(ArgumentProvider argumentProvider) {
                return new Default(this.nameProvider, this.returnTypeProvider, CompoundList.of(this.argumentProviders, argumentProvider));
            }

            public InvocationProvider appendArguments(List<ArgumentProvider> list) {
                return new Default(this.nameProvider, this.returnTypeProvider, CompoundList.of(this.argumentProviders, list));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default defaultR = (Default) obj;
                return this.nameProvider.equals(defaultR.nameProvider) && this.returnTypeProvider.equals(defaultR.returnTypeProvider) && this.argumentProviders.equals(defaultR.argumentProviders);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.nameProvider.hashCode()) * 31) + this.returnTypeProvider.hashCode()) * 31) + this.argumentProviders.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                for (ArgumentProvider prepare : this.argumentProviders) {
                    instrumentedType = prepare.prepare(instrumentedType);
                }
                return instrumentedType;
            }

            public InvocationProvider withNameProvider(NameProvider nameProvider2) {
                return new Default(nameProvider2, this.returnTypeProvider, this.argumentProviders);
            }

            public InvocationProvider withReturnTypeProvider(ReturnTypeProvider returnTypeProvider2) {
                return new Default(this.nameProvider, returnTypeProvider2, this.argumentProviders);
            }

            public InvocationProvider withoutArguments() {
                return new Default(this.nameProvider, this.returnTypeProvider, Collections.emptyList());
            }

            public Target make(MethodDescription methodDescription) {
                return new Target(this.nameProvider.resolve(methodDescription), this.returnTypeProvider.resolve(methodDescription), this.argumentProviders, methodDescription);
            }

            public Default(NameProvider nameProvider2, ReturnTypeProvider returnTypeProvider2, List<ArgumentProvider> list) {
                this.nameProvider = nameProvider2;
                this.returnTypeProvider = returnTypeProvider2;
                this.argumentProviders = list;
            }
        }

        public interface NameProvider {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitName implements NameProvider {
                private final String internalName;

                public ForExplicitName(String str) {
                    this.internalName = str;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.internalName.equals(((ForExplicitName) obj).internalName);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.internalName.hashCode();
                }

                public String resolve(MethodDescription methodDescription) {
                    return this.internalName;
                }
            }

            public enum ForInterceptedMethod implements NameProvider {
                INSTANCE;

                public String resolve(MethodDescription methodDescription) {
                    return methodDescription.getInternalName();
                }
            }

            String resolve(MethodDescription methodDescription);
        }

        public interface ReturnTypeProvider {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitType implements ReturnTypeProvider {
                private final TypeDescription typeDescription;

                public ForExplicitType(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForExplicitType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public TypeDescription resolve(MethodDescription methodDescription) {
                    return this.typeDescription;
                }
            }

            public enum ForInterceptedMethod implements ReturnTypeProvider {
                INSTANCE;

                public TypeDescription resolve(MethodDescription methodDescription) {
                    return methodDescription.getReturnType().asErasure();
                }
            }

            TypeDescription resolve(MethodDescription methodDescription);
        }

        public interface Target {

            public interface Resolved {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements Resolved {
                    private final String internalName;
                    private final List<TypeDescription> parameterTypes;
                    private final TypeDescription returnType;
                    private final StackManipulation stackManipulation;

                    public Simple(StackManipulation stackManipulation2, String str, TypeDescription typeDescription, List<TypeDescription> list) {
                        this.stackManipulation = stackManipulation2;
                        this.internalName = str;
                        this.returnType = typeDescription;
                        this.parameterTypes = list;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.internalName.equals(simple.internalName) && this.stackManipulation.equals(simple.stackManipulation) && this.returnType.equals(simple.returnType) && this.parameterTypes.equals(simple.parameterTypes);
                    }

                    public String getInternalName() {
                        return this.internalName;
                    }

                    public List<TypeDescription> getParameterTypes() {
                        return this.parameterTypes;
                    }

                    public TypeDescription getReturnType() {
                        return this.returnType;
                    }

                    public StackManipulation getStackManipulation() {
                        return this.stackManipulation;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.internalName.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.parameterTypes.hashCode();
                    }
                }

                String getInternalName();

                List<TypeDescription> getParameterTypes();

                TypeDescription getReturnType();

                StackManipulation getStackManipulation();
            }

            Resolved resolve(TypeDescription typeDescription, Assigner assigner, Assigner.Typing typing);
        }

        InvocationProvider appendArgument(ArgumentProvider argumentProvider);

        InvocationProvider appendArguments(List<ArgumentProvider> list);

        Target make(MethodDescription methodDescription);

        InstrumentedType prepare(InstrumentedType instrumentedType);

        InvocationProvider withNameProvider(NameProvider nameProvider);

        InvocationProvider withReturnTypeProvider(ReturnTypeProvider returnTypeProvider);

        InvocationProvider withoutArguments();
    }

    public enum TerminationHandler {
        RETURNING {
            public StackManipulation a(MethodDescription methodDescription, TypeDescription typeDescription, Assigner assigner, Assigner.Typing typing) {
                StackManipulation assign = assigner.assign(typeDescription.asGenericType(), methodDescription.getReturnType(), typing);
                if (assign.isValid()) {
                    return new StackManipulation.Compound(assign, MethodReturn.of(methodDescription.getReturnType()));
                }
                throw new IllegalStateException("Cannot return " + typeDescription + " from " + methodDescription);
            }
        },
        DROPPING {
            public StackManipulation a(MethodDescription methodDescription, TypeDescription typeDescription, Assigner assigner, Assigner.Typing typing) {
                return Removal.of(typeDescription);
            }
        };

        public abstract StackManipulation a(MethodDescription methodDescription, TypeDescription typeDescription, Assigner assigner, Assigner.Typing typing);
    }

    public static class WithImplicitArguments extends AbstractDelegator {
        public WithImplicitArguments(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing) {
            super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
        }

        public InvokeDynamic a() {
            return withoutArguments();
        }

        public /* bridge */ /* synthetic */ Implementation andThen(Implementation implementation) {
            return super.andThen(implementation);
        }

        public /* bridge */ /* synthetic */ ByteCodeAppender appender(Implementation.Target target) {
            return super.appender(target);
        }

        public /* bridge */ /* synthetic */ InstrumentedType prepare(InstrumentedType instrumentedType) {
            return super.prepare(instrumentedType);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withArgument(int i11) {
            return super.withArgument(i11);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withBooleanValue(boolean[] zArr) {
            return super.withBooleanValue(zArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withByteValue(byte[] bArr) {
            return super.withByteValue(bArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withCharacterValue(char[] cArr) {
            return super.withCharacterValue(cArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withDoubleValue(double[] dArr) {
            return super.withDoubleValue(dArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withEnumeration(EnumerationDescription[] enumerationDescriptionArr) {
            return super.withEnumeration(enumerationDescriptionArr);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withField(String str) {
            return super.withField(str);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withFloatValue(float[] fArr) {
            return super.withFloatValue(fArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withImplicitAndMethodArguments() {
            return super.withImplicitAndMethodArguments();
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withInstance(JavaConstant[] javaConstantArr) {
            return super.withInstance(javaConstantArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withIntegerValue(int[] iArr) {
            return super.withIntegerValue(iArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withLongValue(long[] jArr) {
            return super.withLongValue(jArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withMethodArguments() {
            return super.withMethodArguments();
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withNullValue(Class[] clsArr) {
            return super.withNullValue((Class<?>[]) clsArr);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withReference(Object obj) {
            return super.withReference(obj);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withShortValue(short[] sArr) {
            return super.withShortValue(sArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withThis(Class[] clsArr) {
            return super.withThis((Class<?>[]) clsArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withType(TypeDescription[] typeDescriptionArr) {
            return super.withType(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withValue(Object[] objArr) {
            return super.withValue(objArr);
        }

        public InvokeDynamic withoutArguments() {
            return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.withoutArguments(), this.f27289e, this.f27290f, this.f27291g);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withArgument(int[] iArr) {
            return super.withArgument(iArr);
        }

        public WithImplicitArguments withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new WithImplicitArguments(this.f27286b, this.f27287c, this.f27288d, this.f27289e, assigner, typing);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withField(String str, FieldLocator.Factory factory) {
            return super.withField(str, factory);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withNullValue(TypeDescription[] typeDescriptionArr) {
            return super.withNullValue(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withReference(Object[] objArr) {
            return super.withReference(objArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withThis(TypeDescription[] typeDescriptionArr) {
            return super.withThis(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withField(FieldLocator.Factory factory, String[] strArr) {
            return super.withField(factory, strArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withField(String[] strArr) {
            return super.withField(strArr);
        }
    }

    public static class WithImplicitTarget extends WithImplicitArguments {
        public WithImplicitTarget(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing) {
            super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
        }

        public WithImplicitArguments invoke(Class<?> cls) {
            return invoke(TypeDescription.ForLoadedType.of(cls));
        }

        public WithImplicitArguments invoke(TypeDescription typeDescription) {
            return new WithImplicitArguments(this.f27286b, this.f27287c, this.f27288d.withReturnTypeProvider(new InvocationProvider.ReturnTypeProvider.ForExplicitType(typeDescription)), this.f27289e, this.f27290f, this.f27291g);
        }

        public WithImplicitArguments invoke(String str) {
            return new WithImplicitArguments(this.f27286b, this.f27287c, this.f27288d.withNameProvider(new InvocationProvider.NameProvider.ForExplicitName(str)), this.f27289e, this.f27290f, this.f27291g);
        }

        public WithImplicitArguments invoke(String str, Class<?> cls) {
            return invoke(str, TypeDescription.ForLoadedType.of(cls));
        }

        public WithImplicitArguments invoke(String str, TypeDescription typeDescription) {
            return new WithImplicitArguments(this.f27286b, this.f27287c, this.f27288d.withNameProvider(new InvocationProvider.NameProvider.ForExplicitName(str)).withReturnTypeProvider(new InvocationProvider.ReturnTypeProvider.ForExplicitType(typeDescription)), this.f27289e, this.f27290f, this.f27291g);
        }
    }

    public static abstract class WithImplicitType extends AbstractDelegator {

        @SuppressFBWarnings(justification = "Super type implementation covers use case", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
        public static class OfArgument extends WithImplicitType {
            private final int index;

            public OfArgument(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing, int i11) {
                super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
                this.index = i11;
            }

            public InvokeDynamic a() {
                return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(new InvocationProvider.ArgumentProvider.ForMethodParameter(this.index)), this.f27289e, this.f27290f, this.f27291g);
            }

            public InvokeDynamic as(TypeDescription typeDescription) {
                return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(new InvocationProvider.ArgumentProvider.ForMethodParameter.WithExplicitType(this.index, typeDescription)), this.f27289e, this.f27290f, this.f27291g);
            }
        }

        @SuppressFBWarnings(justification = "Super type implementation covers use case", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
        public static class OfField extends WithImplicitType {
            private final FieldLocator.Factory fieldLocatorFactory;
            private final String fieldName;

            public OfField(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing, String str, FieldLocator.Factory factory) {
                super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
                this.fieldName = str;
                this.fieldLocatorFactory = factory;
            }

            public InvokeDynamic a() {
                return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(new InvocationProvider.ArgumentProvider.ForField(this.fieldName, this.fieldLocatorFactory)), this.f27289e, this.f27290f, this.f27291g);
            }

            public InvokeDynamic as(TypeDescription typeDescription) {
                return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(new InvocationProvider.ArgumentProvider.ForField.WithExplicitType(this.fieldName, this.fieldLocatorFactory, typeDescription)), this.f27289e, this.f27290f, this.f27291g);
            }
        }

        @SuppressFBWarnings(justification = "Super type implementation covers use case", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
        public static class OfInstance extends WithImplicitType {
            private final InvocationProvider.ArgumentProvider argumentProvider;
            private final Object value;

            public OfInstance(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing, Object obj) {
                super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
                this.value = obj;
                this.argumentProvider = InvocationProvider.ArgumentProvider.ForInstance.a(obj);
            }

            public InvokeDynamic a() {
                return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(this.argumentProvider), this.f27289e, this.f27290f, this.f27291g);
            }

            public InvokeDynamic as(TypeDescription typeDescription) {
                if (typeDescription.asBoxed().isInstance(this.value)) {
                    return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(new InvocationProvider.ArgumentProvider.ForInstance(this.value, typeDescription)), this.f27289e, this.f27290f, this.f27291g);
                }
                throw new IllegalArgumentException(this.value + " is not of type " + typeDescription);
            }
        }

        public WithImplicitType(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing) {
            super(inDefinedShape, list, invocationProvider, terminationHandler, assigner, typing);
        }

        public /* bridge */ /* synthetic */ Implementation andThen(Implementation implementation) {
            return super.andThen(implementation);
        }

        public /* bridge */ /* synthetic */ ByteCodeAppender appender(Implementation.Target target) {
            return super.appender(target);
        }

        public InvokeDynamic as(Class<?> cls) {
            return as(TypeDescription.ForLoadedType.of(cls));
        }

        public abstract InvokeDynamic as(TypeDescription typeDescription);

        public /* bridge */ /* synthetic */ InstrumentedType prepare(InstrumentedType instrumentedType) {
            return super.prepare(instrumentedType);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withArgument(int i11) {
            return super.withArgument(i11);
        }

        public /* bridge */ /* synthetic */ Implementation.Composable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return super.withAssigner(assigner, typing);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withBooleanValue(boolean[] zArr) {
            return super.withBooleanValue(zArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withByteValue(byte[] bArr) {
            return super.withByteValue(bArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withCharacterValue(char[] cArr) {
            return super.withCharacterValue(cArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withDoubleValue(double[] dArr) {
            return super.withDoubleValue(dArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withEnumeration(EnumerationDescription[] enumerationDescriptionArr) {
            return super.withEnumeration(enumerationDescriptionArr);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withField(String str) {
            return super.withField(str);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withFloatValue(float[] fArr) {
            return super.withFloatValue(fArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withImplicitAndMethodArguments() {
            return super.withImplicitAndMethodArguments();
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withInstance(JavaConstant[] javaConstantArr) {
            return super.withInstance(javaConstantArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withIntegerValue(int[] iArr) {
            return super.withIntegerValue(iArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withLongValue(long[] jArr) {
            return super.withLongValue(jArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withMethodArguments() {
            return super.withMethodArguments();
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withNullValue(Class[] clsArr) {
            return super.withNullValue((Class<?>[]) clsArr);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withReference(Object obj) {
            return super.withReference(obj);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withShortValue(short[] sArr) {
            return super.withShortValue(sArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withThis(Class[] clsArr) {
            return super.withThis((Class<?>[]) clsArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withType(TypeDescription[] typeDescriptionArr) {
            return super.withType(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withValue(Object[] objArr) {
            return super.withValue(objArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withArgument(int[] iArr) {
            return super.withArgument(iArr);
        }

        public /* bridge */ /* synthetic */ WithImplicitType withField(String str, FieldLocator.Factory factory) {
            return super.withField(str, factory);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withNullValue(TypeDescription[] typeDescriptionArr) {
            return super.withNullValue(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withReference(Object[] objArr) {
            return super.withReference(objArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withThis(TypeDescription[] typeDescriptionArr) {
            return super.withThis(typeDescriptionArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withField(FieldLocator.Factory factory, String[] strArr) {
            return super.withField(factory, strArr);
        }

        public /* bridge */ /* synthetic */ InvokeDynamic withField(String[] strArr) {
            return super.withField(strArr);
        }
    }

    public InvokeDynamic(MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list, InvocationProvider invocationProvider, TerminationHandler terminationHandler, Assigner assigner, Assigner.Typing typing) {
        this.f27286b = inDefinedShape;
        this.f27287c = list;
        this.f27288d = invocationProvider;
        this.f27289e = terminationHandler;
        this.f27290f = assigner;
        this.f27291g = typing;
    }

    public static WithImplicitTarget bootstrap(Method method, Object... objArr) {
        return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), objArr);
    }

    public static WithImplicitArguments lambda(Method method, Type type) {
        return lambda((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), (TypeDefinition) TypeDefinition.Sort.describe(type));
    }

    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d, TerminationHandler.DROPPING, this.f27290f, this.f27291g), implementation);
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(target.getInstrumentedType());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InvokeDynamic invokeDynamic = (InvokeDynamic) obj;
        return this.f27289e.equals(invokeDynamic.f27289e) && this.f27291g.equals(invokeDynamic.f27291g) && this.f27286b.equals(invokeDynamic.f27286b) && this.f27287c.equals(invokeDynamic.f27287c) && this.f27288d.equals(invokeDynamic.f27288d) && this.f27290f.equals(invokeDynamic.f27290f);
    }

    public int hashCode() {
        return (((((((((((getClass().hashCode() * 31) + this.f27286b.hashCode()) * 31) + this.f27287c.hashCode()) * 31) + this.f27288d.hashCode()) * 31) + this.f27289e.hashCode()) * 31) + this.f27290f.hashCode()) * 31) + this.f27291g.hashCode();
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.f27288d.prepare(instrumentedType);
    }

    public InvokeDynamic withArgument(int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = iArr[i11];
            if (i12 >= 0) {
                arrayList.add(new InvocationProvider.ArgumentProvider.ForMethodParameter(i12));
                i11++;
            } else {
                throw new IllegalArgumentException("Method parameter indices cannot be negative: " + i12);
            }
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public Implementation.Composable withAssigner(Assigner assigner, Assigner.Typing typing) {
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d, this.f27289e, assigner, typing);
    }

    public InvokeDynamic withBooleanValue(boolean... zArr) {
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean forBooleanConstant : zArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForBooleanConstant(forBooleanConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withByteValue(byte... bArr) {
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte forByteConstant : bArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForByteConstant(forByteConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withCharacterValue(char... cArr) {
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char forCharacterConstant : cArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForCharacterConstant(forCharacterConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withDoubleValue(double... dArr) {
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double forDoubleConstant : dArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForDoubleConstant(forDoubleConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withEnumeration(EnumerationDescription... enumerationDescriptionArr) {
        ArrayList arrayList = new ArrayList(enumerationDescriptionArr.length);
        for (EnumerationDescription forEnumerationValue : enumerationDescriptionArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForEnumerationValue(forEnumerationValue));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withField(String... strArr) {
        return withField((FieldLocator.Factory) FieldLocator.ForClassHierarchy.Factory.INSTANCE, strArr);
    }

    public InvokeDynamic withFloatValue(float... fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float forFloatConstant : fArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForFloatConstant(forFloatConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withImplicitAndMethodArguments() {
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(InvocationProvider.ArgumentProvider.ForInterceptedMethodInstanceAndParameters.INSTANCE), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withInstance(JavaConstant... javaConstantArr) {
        ArrayList arrayList = new ArrayList(javaConstantArr.length);
        for (JavaConstant forJavaConstant : javaConstantArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForJavaConstant(forJavaConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withIntegerValue(int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int forIntegerConstant : iArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForIntegerConstant(forIntegerConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withLongValue(long... jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long forLongConstant : jArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForLongConstant(forLongConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withMethodArguments() {
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArgument(InvocationProvider.ArgumentProvider.ForInterceptedMethodParameters.INSTANCE), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withNullValue(Class<?>... clsArr) {
        return withNullValue((TypeDescription[]) new TypeList.ForLoadedTypes(clsArr).toArray(new TypeDescription[0]));
    }

    public WithImplicitType withReference(Object obj) {
        return new WithImplicitType.OfInstance(this.f27286b, this.f27287c, this.f27288d, this.f27289e, this.f27290f, this.f27291g, obj);
    }

    public InvokeDynamic withShortValue(short... sArr) {
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short forShortConstant : sArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForShortConstant(forShortConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withThis(Class<?>... clsArr) {
        return withThis((TypeDescription[]) new TypeList.ForLoadedTypes(clsArr).toArray(new TypeDescription[0]));
    }

    public InvokeDynamic withType(TypeDescription... typeDescriptionArr) {
        ArrayList arrayList = new ArrayList(typeDescriptionArr.length);
        for (TypeDescription forClassConstant : typeDescriptionArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForClassConstant(forClassConstant));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withValue(Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object of2 : objArr) {
            arrayList.add(InvocationProvider.ArgumentProvider.ConstantPoolWrapper.of(of2));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public static WithImplicitTarget bootstrap(Method method, List<?> list) {
        return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
    }

    public static WithImplicitArguments lambda(Method method, Type type, MethodGraph.Compiler compiler) {
        return lambda((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), (TypeDefinition) TypeDefinition.Sort.describe(type), compiler);
    }

    public Implementation.Composable andThen(Implementation.Composable composable) {
        return new Implementation.Compound.Composable((Implementation) new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d, TerminationHandler.DROPPING, this.f27290f, this.f27291g), composable);
    }

    public InvokeDynamic withField(FieldLocator.Factory factory, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String forField : strArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForField(forField, factory));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withNullValue(TypeDescription... typeDescriptionArr) {
        ArrayList arrayList = new ArrayList(typeDescriptionArr.length);
        int length = typeDescriptionArr.length;
        int i11 = 0;
        while (i11 < length) {
            TypeDescription typeDescription = typeDescriptionArr[i11];
            if (!typeDescription.isPrimitive()) {
                arrayList.add(new InvocationProvider.ArgumentProvider.ForNullValue(typeDescription));
                i11++;
            } else {
                throw new IllegalArgumentException("Cannot assign null to primitive type: " + typeDescription);
            }
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withReference(Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object a11 : objArr) {
            arrayList.add(InvocationProvider.ArgumentProvider.ForInstance.a(a11));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public InvokeDynamic withThis(TypeDescription... typeDescriptionArr) {
        ArrayList arrayList = new ArrayList(typeDescriptionArr.length);
        for (TypeDescription forThisInstance : typeDescriptionArr) {
            arrayList.add(new InvocationProvider.ArgumentProvider.ForThisInstance(forThisInstance));
        }
        return new InvokeDynamic(this.f27286b, this.f27287c, this.f27288d.appendArguments(arrayList), this.f27289e, this.f27290f, this.f27291g);
    }

    public static WithImplicitTarget bootstrap(Constructor<?> constructor, Object... objArr) {
        return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), objArr);
    }

    public static WithImplicitArguments lambda(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
        return lambda(inDefinedShape, typeDefinition, MethodGraph.Compiler.Default.forJavaHierarchy());
    }

    public static WithImplicitTarget bootstrap(Constructor<?> constructor, List<?> list) {
        return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
    }

    public static WithImplicitArguments lambda(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition, MethodGraph.Compiler compiler) {
        TypeDefinition typeDefinition2 = typeDefinition;
        if (typeDefinition.isInterface()) {
            MethodList methodList = (MethodList) compiler.compile(typeDefinition2).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
            if (methodList.size() == 1) {
                TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OBJECT, new TypeDescription.Generic[0]);
                List emptyList = Collections.emptyList();
                TypeDescription.Generic asGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                JavaType javaType = JavaType.METHOD_TYPE;
                return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.Latent(latent, "metafactory", 9, emptyList, asGenericType, Arrays.asList(new ParameterDescription.Token[]{new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(TypeDescription.STRING.asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())}), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.of((MethodDescription) methodList.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.of((MethodDescription) methodList.getOnly())).invoke(methodList.asDefined().getOnly().getInternalName());
            }
            throw new IllegalArgumentException(typeDefinition2 + " does not define exactly one abstract method: " + methodList);
        }
        throw new IllegalArgumentException(typeDefinition2 + " is not an interface type");
    }

    public static WithImplicitTarget bootstrap(MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
        return bootstrap(inDefinedShape, (List<?>) Arrays.asList(objArr));
    }

    public static WithImplicitTarget bootstrap(MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
        List<JavaConstant> wrap = JavaConstant.Simple.wrap(list);
        if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of(wrap))) {
            return new WithImplicitTarget(inDefinedShape, wrap, new InvocationProvider.Default(), TerminationHandler.RETURNING, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }
        throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + wrap);
    }

    public WithImplicitType withArgument(int i11) {
        if (i11 >= 0) {
            return new WithImplicitType.OfArgument(this.f27286b, this.f27287c, this.f27288d, this.f27289e, this.f27290f, this.f27291g, i11);
        }
        throw new IllegalArgumentException("Method parameter indices cannot be negative: " + i11);
    }

    public WithImplicitType withField(String str) {
        return withField(str, (FieldLocator.Factory) FieldLocator.ForClassHierarchy.Factory.INSTANCE);
    }

    public WithImplicitType withField(String str, FieldLocator.Factory factory) {
        return new WithImplicitType.OfField(this.f27286b, this.f27287c, this.f27288d, this.f27289e, this.f27290f, this.f27291g, str, factory);
    }
}
