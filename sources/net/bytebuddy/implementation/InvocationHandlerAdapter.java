package net.bytebuddy.implementation;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
public abstract class InvocationHandlerAdapter implements Implementation.Composable {
    private static final boolean CACHED = true;
    private static final boolean DROPPING = false;
    /* access modifiers changed from: private */
    public static final TypeDescription.Generic INVOCATION_HANDLER_TYPE = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(InvocationHandler.class);
    private static final boolean PRIVILEGED = true;
    private static final boolean RETURNING = true;
    private static final boolean UNCACHED = false;
    private static final boolean UNPRIVILEGED = false;

    /* renamed from: b  reason: collision with root package name */
    public final String f27278b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f27279c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f27280d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f27281e;

    /* renamed from: f  reason: collision with root package name */
    public final Assigner f27282f;

    public interface AssignerConfigurable extends Implementation.Composable {
        Implementation.Composable withAssigner(Assigner assigner);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForField extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private final FieldLocator.Factory fieldLocatorFactory;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldDescription fieldDescription;

            public Appender(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation stackManipulation;
                ForField forField = ForField.this;
                if (this.fieldDescription.isStatic()) {
                    stackManipulation = StackManipulation.Trivial.INSTANCE;
                } else {
                    stackManipulation = MethodVariableAccess.loadThis();
                }
                return forField.b(methodVisitor, context, methodDescription, stackManipulation, this.fieldDescription);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldDescription.equals(appender.fieldDescription) && ForField.this.equals(ForField.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + ForField.this.hashCode();
            }
        }

        public ForField(String str, boolean z11, boolean z12, boolean z13, Assigner assigner, FieldLocator.Factory factory) {
            super(str, z11, z12, z13, assigner);
            this.fieldLocatorFactory = factory;
        }

        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForField(this.f27278b, this.f27279c, this.f27280d, false, this.f27282f, this.fieldLocatorFactory), implementation);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            FieldLocator.Resolution locate = this.fieldLocatorFactory.make(target.getInstrumentedType()).locate(this.f27278b);
            if (!locate.isResolved()) {
                throw new IllegalStateException("Could not find a field named '" + this.f27278b + "' for " + target.getInstrumentedType());
            } else if (locate.getField().getType().asErasure().isAssignableTo((Class<?>) InvocationHandler.class)) {
                return new Appender(locate.getField());
            } else {
                throw new IllegalStateException("Field " + locate.getField() + " does not declare a type that is assignable to invocation handler");
            }
        }

        public boolean equals(Object obj) {
            if (!InvocationHandlerAdapter.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fieldLocatorFactory.equals(((ForField) obj).fieldLocatorFactory);
        }

        public int hashCode() {
            return (InvocationHandlerAdapter.super.hashCode() * 31) + this.fieldLocatorFactory.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public AssignerConfigurable withPrivilegedLookup() {
            return new ForField(this.f27278b, this.f27279c, true, this.f27281e, this.f27282f, this.fieldLocatorFactory);
        }

        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForField(this.f27278b, false, this.f27280d, this.f27281e, this.f27282f, this.fieldLocatorFactory);
        }

        public Implementation.Composable andThen(Implementation.Composable composable) {
            return new Implementation.Compound.Composable((Implementation) new ForField(this.f27278b, this.f27279c, this.f27280d, false, this.f27282f, this.fieldLocatorFactory), composable);
        }

        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForField(this.f27278b, this.f27279c, this.f27280d, this.f27281e, assigner, this.fieldLocatorFactory);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForInstance extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private static final String PREFIX = "invocationHandler";

        /* renamed from: g  reason: collision with root package name */
        public final InvocationHandler f27284g;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForInstance.this.b(methodVisitor, context, methodDescription, StackManipulation.Trivial.INSTANCE, (FieldDescription) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(ForInstance.this.f27278b).and(ElementMatchers.genericFieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE)))).getOnly());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.instrumentedType.equals(appender.instrumentedType) && ForInstance.this.equals(ForInstance.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + ForInstance.this.hashCode();
            }
        }

        public ForInstance(String str, boolean z11, boolean z12, boolean z13, Assigner assigner, InvocationHandler invocationHandler) {
            super(str, z11, z12, z13, assigner);
            this.f27284g = invocationHandler;
        }

        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForInstance(this.f27278b, this.f27279c, this.f27280d, false, this.f27282f, this.f27284g), implementation);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public boolean equals(Object obj) {
            if (!InvocationHandlerAdapter.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f27284g.equals(((ForInstance) obj).f27284g);
        }

        public int hashCode() {
            return (InvocationHandlerAdapter.super.hashCode() * 31) + this.f27284g.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            if (((FieldList) instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.f27278b).and(ElementMatchers.fieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure())))).isEmpty()) {
                return instrumentedType.withField(new FieldDescription.Token(this.f27278b, 4169, InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE)).withInitializer((LoadedTypeInitializer) new LoadedTypeInitializer.ForStaticField(this.f27278b, this.f27284g));
            }
            throw new IllegalStateException("Field with name " + this.f27278b + " and type " + InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure() + " already declared by " + instrumentedType);
        }

        public AssignerConfigurable withPrivilegedLookup() {
            return new ForInstance(this.f27278b, this.f27279c, true, this.f27281e, this.f27282f, this.f27284g);
        }

        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForInstance(this.f27278b, false, this.f27280d, this.f27281e, this.f27282f, this.f27284g);
        }

        public Implementation.Composable andThen(Implementation.Composable composable) {
            return new Implementation.Compound.Composable((Implementation) new ForInstance(this.f27278b, this.f27279c, this.f27280d, false, this.f27282f, this.f27284g), composable);
        }

        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForInstance(this.f27278b, this.f27279c, this.f27280d, this.f27281e, assigner, this.f27284g);
        }
    }

    public interface WithoutPrivilegeConfiguration extends AssignerConfigurable {
        AssignerConfigurable withPrivilegedLookup();
    }

    public InvocationHandlerAdapter(String str, boolean z11, boolean z12, boolean z13, Assigner assigner) {
        this.f27278b = str;
        this.f27279c = z11;
        this.f27280d = z12;
        this.f27281e = z13;
        this.f27282f = assigner;
    }

    private List<StackManipulation> argumentValuesOf(MethodDescription methodDescription) {
        TypeList.Generic<TypeDescription.Generic> asTypeList = methodDescription.getParameters().asTypeList();
        ArrayList arrayList = new ArrayList(asTypeList.size());
        int i11 = 1;
        for (TypeDescription.Generic generic : asTypeList) {
            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(i11), this.f27282f.assign(generic, TypeDescription.Generic.OBJECT, Assigner.Typing.STATIC)));
            i11 += generic.getStackSize().getSize();
        }
        return arrayList;
    }

    public static InvocationHandlerAdapter of(InvocationHandler invocationHandler) {
        return of(invocationHandler, "invocationHandler$" + RandomString.hashOf(invocationHandler.getClass().hashCode() ^ invocationHandler.hashCode()));
    }

    public static InvocationHandlerAdapter toField(String str) {
        return toField(str, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
    }

    public ByteCodeAppender.Size b(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription, StackManipulation stackManipulation, FieldDescription fieldDescription) {
        MethodConstant.CanCache canCache;
        StackManipulation stackManipulation2;
        StackManipulation stackManipulation3;
        if (methodDescription.isStatic() || methodDescription.isConstructor()) {
            throw new IllegalStateException("It is not possible to apply an invocation handler onto the static method or constructor " + methodDescription);
        }
        if (this.f27280d) {
            canCache = MethodConstant.ofPrivileged((MethodDescription.InDefinedShape) methodDescription.asDefined());
        } else {
            canCache = MethodConstant.of((MethodDescription.InDefinedShape) methodDescription.asDefined());
        }
        StackManipulation[] stackManipulationArr = new StackManipulation[7];
        stackManipulationArr[0] = stackManipulation;
        stackManipulationArr[1] = FieldAccess.forField(fieldDescription).read();
        stackManipulationArr[2] = MethodVariableAccess.loadThis();
        StackManipulation stackManipulation4 = canCache;
        if (this.f27279c) {
            stackManipulation4 = canCache.cached();
        }
        stackManipulationArr[3] = stackManipulation4;
        if (methodDescription.getParameters().isEmpty()) {
            stackManipulation2 = NullConstant.INSTANCE;
        } else {
            stackManipulation2 = ArrayFactory.forType(TypeDescription.Generic.OBJECT).withValues(argumentValuesOf(methodDescription));
        }
        stackManipulationArr[4] = stackManipulation2;
        stackManipulationArr[5] = MethodInvocation.invoke((MethodDescription) ((MethodList) INVOCATION_HANDLER_TYPE.getDeclaredMethods().filter(ElementMatchers.isAbstract())).getOnly());
        if (this.f27281e) {
            stackManipulation3 = new StackManipulation.Compound(this.f27282f.assign(TypeDescription.Generic.OBJECT, methodDescription.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.of(methodDescription.getReturnType()));
        } else {
            stackManipulation3 = Removal.SINGLE;
        }
        stackManipulationArr[6] = stackManipulation3;
        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InvocationHandlerAdapter invocationHandlerAdapter = (InvocationHandlerAdapter) obj;
        return this.f27279c == invocationHandlerAdapter.f27279c && this.f27280d == invocationHandlerAdapter.f27280d && this.f27281e == invocationHandlerAdapter.f27281e && this.f27278b.equals(invocationHandlerAdapter.f27278b) && this.f27282f.equals(invocationHandlerAdapter.f27282f);
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.f27278b.hashCode()) * 31) + (this.f27279c ? 1 : 0)) * 31) + (this.f27280d ? 1 : 0)) * 31) + (this.f27281e ? 1 : 0)) * 31) + this.f27282f.hashCode();
    }

    public abstract Implementation withAssigner(Assigner assigner);

    public abstract AssignerConfigurable withPrivilegedLookup();

    public abstract WithoutPrivilegeConfiguration withoutMethodCache();

    public static InvocationHandlerAdapter of(InvocationHandler invocationHandler, String str) {
        return new ForInstance(str, true, false, true, Assigner.DEFAULT, invocationHandler);
    }

    public static InvocationHandlerAdapter toField(String str, FieldLocator.Factory factory) {
        return new ForField(str, true, false, true, Assigner.DEFAULT, factory);
    }
}
