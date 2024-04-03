package net.bytebuddy.implementation;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
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
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
public abstract class FixedValue implements Implementation {

    /* renamed from: b  reason: collision with root package name */
    public final Assigner f27260b;

    /* renamed from: c  reason: collision with root package name */
    public final Assigner.Typing f27261c;

    public interface AssignerConfigurable extends Implementation {
        Implementation withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForArgument extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final int index;

        public ForArgument(int i11) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, i11);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.getParameters().size() > this.index) {
                ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(this.index);
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription), this.f27260b.assign(parameterDescription.getType(), methodDescription.getReturnType(), this.f27261c), MethodReturn.of(methodDescription.getReturnType()));
                if (compound.isValid()) {
                    return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }
                throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + parameterDescription);
            }
            throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
        }

        public boolean equals(Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.index == ((ForArgument) obj).index;
        }

        public int hashCode() {
            return (FixedValue.super.hashCode() * 31) + this.index;
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForArgument(assigner, typing, this.index);
        }

        private ForArgument(Assigner assigner, Assigner.Typing typing, int i11) {
            super(assigner, typing);
            this.index = i11;
        }
    }

    public enum ForNullValue implements Implementation, ByteCodeAppender {
        INSTANCE;

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (!methodDescription.getReturnType().isPrimitive()) {
                return new ByteCodeAppender.Simple(NullConstant.INSTANCE, MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
            }
            throw new IllegalStateException("Cannot return null from " + methodDescription);
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    public static class ForOriginType extends FixedValue implements AssignerConfigurable {

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final TypeDescription originType;

            public Appender(TypeDescription typeDescription) {
                this.originType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForOriginType.this.a(methodVisitor, context, methodDescription, TypeDescription.CLASS.asGenericType(), ClassConstant.of(this.originType));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.originType.equals(appender.originType) && ForOriginType.this.equals(ForOriginType.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.originType.hashCode()) * 31) + ForOriginType.this.hashCode();
            }
        }

        public ForOriginType() {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getOriginType().asErasure());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForOriginType(assigner, typing);
        }

        private ForOriginType(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForPoolValue extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final TypeDescription loadedType;
        private final StackManipulation valueLoadInstruction;

        public ForPoolValue(StackManipulation stackManipulation, Class<?> cls) {
            this(stackManipulation, TypeDescription.ForLoadedType.of(cls));
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return a(methodVisitor, context, methodDescription, this.loadedType.asGenericType(), this.valueLoadInstruction);
        }

        public boolean equals(Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForPoolValue forPoolValue = (ForPoolValue) obj;
            return this.valueLoadInstruction.equals(forPoolValue.valueLoadInstruction) && this.loadedType.equals(forPoolValue.loadedType);
        }

        public int hashCode() {
            return (((FixedValue.super.hashCode() * 31) + this.valueLoadInstruction.hashCode()) * 31) + this.loadedType.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForPoolValue(assigner, typing, this.valueLoadInstruction, this.loadedType);
        }

        public ForPoolValue(StackManipulation stackManipulation, TypeDescription typeDescription) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, stackManipulation, typeDescription);
        }

        private ForPoolValue(Assigner assigner, Assigner.Typing typing, StackManipulation stackManipulation, TypeDescription typeDescription) {
            super(assigner, typing);
            this.valueLoadInstruction = stackManipulation;
            this.loadedType = typeDescription;
        }
    }

    public static class ForThisValue extends FixedValue implements AssignerConfigurable {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                if (methodDescription.isStatic() || !this.instrumentedType.isAssignableTo(methodDescription.getReturnType().asErasure())) {
                    throw new IllegalStateException("Cannot return 'this' from " + methodDescription);
                }
                return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }
        }

        public ForThisValue() {
            super(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForThisValue(assigner, typing);
        }

        private ForThisValue(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForValue extends FixedValue implements AssignerConfigurable {
        private static final String PREFIX = "value";
        /* access modifiers changed from: private */
        public final String fieldName;
        /* access modifiers changed from: private */
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        public final TypeDescription.Generic fieldType;
        private final Object value;

        @HashCodeAndEqualsPlugin.Enhance
        public class StaticFieldByteCodeAppender implements ByteCodeAppender {
            private final StackManipulation fieldGetAccess;

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                ForValue forValue = ForValue.this;
                return forValue.a(methodVisitor, context, methodDescription, forValue.fieldType, this.fieldGetAccess);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldGetAccess.equals(((StaticFieldByteCodeAppender) obj).fieldGetAccess);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldGetAccess.hashCode();
            }

            private StaticFieldByteCodeAppender(TypeDescription typeDescription) {
                this.fieldGetAccess = FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(ForValue.this.fieldName))).getOnly()).read();
            }
        }

        public ForValue(Object obj) {
            this("value$" + RandomString.hashOf(obj.getClass().hashCode() ^ obj.hashCode()), obj);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new StaticFieldByteCodeAppender(target.getInstrumentedType());
        }

        public boolean equals(Object obj) {
            if (!FixedValue.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForValue forValue = (ForValue) obj;
            return this.fieldName.equals(forValue.fieldName) && this.value.equals(forValue.value);
        }

        public int hashCode() {
            return (((FixedValue.super.hashCode() * 31) + this.fieldName.hashCode()) * 31) + this.value.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            if (((FieldList) instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(this.fieldType.asErasure())))).isEmpty()) {
                return instrumentedType.withField(new FieldDescription.Token(this.fieldName, 4169, this.fieldType)).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.fieldName, this.value));
            }
            throw new IllegalStateException("Field with name " + this.fieldName + " and type " + this.fieldType.asErasure() + " already declared by " + instrumentedType);
        }

        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForValue(assigner, typing, this.fieldName, this.value);
        }

        public ForValue(String str, Object obj) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, str, obj);
        }

        private ForValue(Assigner assigner, Assigner.Typing typing, String str, Object obj) {
            super(assigner, typing);
            this.fieldName = str;
            this.value = obj;
            this.fieldType = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(obj.getClass());
        }
    }

    public FixedValue(Assigner assigner, Assigner.Typing typing) {
        this.f27260b = assigner;
        this.f27261c = typing;
    }

    public static AssignerConfigurable argument(int i11) {
        if (i11 >= 0) {
            return new ForArgument(i11);
        }
        throw new IllegalArgumentException("Argument index cannot be negative: " + i11);
    }

    public static Implementation nullValue() {
        return ForNullValue.INSTANCE;
    }

    public static AssignerConfigurable originType() {
        return new ForOriginType();
    }

    public static AssignerConfigurable reference(Object obj) {
        return new ForValue(obj);
    }

    public static AssignerConfigurable self() {
        return new ForThisValue();
    }

    public static AssignerConfigurable value(Object obj) {
        if (obj instanceof JavaConstant) {
            return value((JavaConstant) obj);
        }
        if (obj instanceof TypeDescription) {
            return value((TypeDescription) obj);
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return new ForPoolValue((StackManipulation) new TextConstant((String) obj), TypeDescription.STRING);
        }
        if (cls == Class.class) {
            return new ForPoolValue(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)), TypeDescription.CLASS);
        }
        if (cls == Boolean.class) {
            return new ForPoolValue(IntegerConstant.forValue(((Boolean) obj).booleanValue()), (Class<?>) Boolean.TYPE);
        }
        if (cls == Byte.class) {
            return new ForPoolValue(IntegerConstant.forValue((int) ((Byte) obj).byteValue()), (Class<?>) Byte.TYPE);
        }
        if (cls == Short.class) {
            return new ForPoolValue(IntegerConstant.forValue((int) ((Short) obj).shortValue()), (Class<?>) Short.TYPE);
        }
        if (cls == Character.class) {
            return new ForPoolValue(IntegerConstant.forValue((int) ((Character) obj).charValue()), (Class<?>) Character.TYPE);
        }
        if (cls == Integer.class) {
            return new ForPoolValue(IntegerConstant.forValue(((Integer) obj).intValue()), (Class<?>) Integer.TYPE);
        }
        if (cls == Long.class) {
            return new ForPoolValue(LongConstant.forValue(((Long) obj).longValue()), (Class<?>) Long.TYPE);
        }
        if (cls == Float.class) {
            return new ForPoolValue(FloatConstant.forValue(((Float) obj).floatValue()), (Class<?>) Float.TYPE);
        }
        if (cls == Double.class) {
            return new ForPoolValue(DoubleConstant.forValue(((Double) obj).doubleValue()), (Class<?>) Double.TYPE);
        }
        if (JavaType.METHOD_HANDLE.getTypeStub().isAssignableFrom(cls)) {
            return new ForPoolValue((StackManipulation) new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)), cls);
        }
        if (JavaType.METHOD_TYPE.getTypeStub().represents(cls)) {
            return new ForPoolValue((StackManipulation) new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)), cls);
        }
        return reference(obj);
    }

    public ByteCodeAppender.Size a(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription, TypeDescription.Generic generic, StackManipulation stackManipulation) {
        StackManipulation assign = this.f27260b.assign(generic, methodDescription.getReturnType(), this.f27261c);
        if (assign.isValid()) {
            return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, assign, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }
        throw new IllegalArgumentException("Cannot return value of type " + generic + " for " + methodDescription);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FixedValue fixedValue = (FixedValue) obj;
        return this.f27261c.equals(fixedValue.f27261c) && this.f27260b.equals(fixedValue.f27260b);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.f27260b.hashCode()) * 31) + this.f27261c.hashCode();
    }

    public static AssignerConfigurable reference(Object obj, String str) {
        return new ForValue(str, obj);
    }

    public static AssignerConfigurable value(TypeDescription typeDescription) {
        return new ForPoolValue(ClassConstant.of(typeDescription), TypeDescription.CLASS);
    }

    public static AssignerConfigurable value(JavaConstant javaConstant) {
        return new ForPoolValue((StackManipulation) new JavaConstantValue(javaConstant), javaConstant.getTypeDescription());
    }
}
