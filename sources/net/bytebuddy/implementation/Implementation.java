package net.bytebuddy.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.RandomString;

public interface Implementation extends InstrumentedType.Prepareable {

    public interface Composable extends Implementation {
        Composable andThen(Composable composable);

        Implementation andThen(Implementation implementation);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements Implementation {
        /* access modifiers changed from: private */
        public final List<Implementation> implementations;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Composable implements Composable {
            /* access modifiers changed from: private */
            public final Composable composable;
            /* access modifiers changed from: private */
            public final List<Implementation> implementations;

            public Composable(Implementation implementation, Composable composable2) {
                this((List<? extends Implementation>) Collections.singletonList(implementation), composable2);
            }

            public Implementation andThen(Implementation implementation) {
                return new Compound((List<? extends Implementation>) CompoundList.of(this.implementations, this.composable.andThen(implementation)));
            }

            public ByteCodeAppender appender(Target target) {
                ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[(this.implementations.size() + 1)];
                int i11 = 0;
                for (Implementation appender : this.implementations) {
                    byteCodeAppenderArr[i11] = appender.appender(target);
                    i11++;
                }
                byteCodeAppenderArr[i11] = this.composable.appender(target);
                return new ByteCodeAppender.Compound(byteCodeAppenderArr);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Composable composable2 = (Composable) obj;
                return this.composable.equals(composable2.composable) && this.implementations.equals(composable2.implementations);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.composable.hashCode()) * 31) + this.implementations.hashCode();
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                for (Implementation prepare : this.implementations) {
                    instrumentedType = prepare.prepare(instrumentedType);
                }
                return this.composable.prepare(instrumentedType);
            }

            public Composable(List<? extends Implementation> list, Composable composable2) {
                this.implementations = new ArrayList();
                for (Implementation implementation : list) {
                    if (implementation instanceof Composable) {
                        Composable composable3 = (Composable) implementation;
                        this.implementations.addAll(composable3.implementations);
                        this.implementations.add(composable3.composable);
                    } else if (implementation instanceof Compound) {
                        this.implementations.addAll(((Compound) implementation).implementations);
                    } else {
                        this.implementations.add(implementation);
                    }
                }
                if (composable2 instanceof Composable) {
                    Composable composable4 = (Composable) composable2;
                    this.implementations.addAll(composable4.implementations);
                    this.composable = composable4.composable;
                    return;
                }
                this.composable = composable2;
            }

            public Composable andThen(Composable composable2) {
                return new Composable((List<? extends Implementation>) this.implementations, this.composable.andThen(composable2));
            }
        }

        public Compound(Implementation... implementationArr) {
            this((List<? extends Implementation>) Arrays.asList(implementationArr));
        }

        public ByteCodeAppender appender(Target target) {
            ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[this.implementations.size()];
            int i11 = 0;
            for (Implementation appender : this.implementations) {
                byteCodeAppenderArr[i11] = appender.appender(target);
                i11++;
            }
            return new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.implementations.equals(((Compound) obj).implementations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.implementations.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (Implementation prepare : this.implementations) {
                instrumentedType = prepare.prepare(instrumentedType);
            }
            return instrumentedType;
        }

        public Compound(List<? extends Implementation> list) {
            this.implementations = new ArrayList();
            for (Implementation implementation : list) {
                if (implementation instanceof Composable) {
                    Composable composable = (Composable) implementation;
                    this.implementations.addAll(composable.implementations);
                    this.implementations.add(composable.composable);
                } else if (implementation instanceof Compound) {
                    this.implementations.addAll(((Compound) implementation).implementations);
                } else {
                    this.implementations.add(implementation);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements Implementation {
        private static final int NO_ADDITIONAL_VARIABLES = 0;
        private final ByteCodeAppender byteCodeAppender;

        public interface Dispatcher {
            StackManipulation apply(Target target, MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDispatcher implements Implementation {
            /* access modifiers changed from: private */
            public final int additionalVariableLength;
            /* access modifiers changed from: private */
            public final Dispatcher dispatcher;
            private final InstrumentedType.Prepareable prepareable;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Appender implements ByteCodeAppender {
                private final Target implementationTarget;

                public Appender(Target target) {
                    this.implementationTarget = target;
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(ForDispatcher.this.dispatcher.apply(this.implementationTarget, methodDescription).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize() + ForDispatcher.this.additionalVariableLength);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Appender appender = (Appender) obj;
                    return this.implementationTarget.equals(appender.implementationTarget) && ForDispatcher.this.equals(ForDispatcher.this);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + ForDispatcher.this.hashCode();
                }
            }

            public ForDispatcher(Dispatcher dispatcher2, InstrumentedType.Prepareable prepareable2, int i11) {
                this.dispatcher = dispatcher2;
                this.prepareable = prepareable2;
                this.additionalVariableLength = i11;
            }

            public ByteCodeAppender appender(Target target) {
                return new Appender(target);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDispatcher forDispatcher = (ForDispatcher) obj;
                return this.additionalVariableLength == forDispatcher.additionalVariableLength && this.dispatcher.equals(forDispatcher.dispatcher) && this.prepareable.equals(forDispatcher.prepareable);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.dispatcher.hashCode()) * 31) + this.prepareable.hashCode()) * 31) + this.additionalVariableLength;
            }

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return this.prepareable.prepare(instrumentedType);
            }
        }

        public Simple(ByteCodeAppender... byteCodeAppenderArr) {
            this.byteCodeAppender = new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public static Implementation of(Dispatcher dispatcher) {
            return of(dispatcher, 0);
        }

        public ByteCodeAppender appender(Target target) {
            return this.byteCodeAppender;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Simple) obj).byteCodeAppender);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.byteCodeAppender.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public static Implementation of(Dispatcher dispatcher, int i11) {
            return of(dispatcher, InstrumentedType.Prepareable.NoOp.INSTANCE, i11);
        }

        public Simple(StackManipulation... stackManipulationArr) {
            this.byteCodeAppender = new ByteCodeAppender.Simple(stackManipulationArr);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable) {
            return of(dispatcher, prepareable, 0);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable, int i11) {
            if (i11 >= 0) {
                return new ForDispatcher(dispatcher, prepareable, i11);
            }
            throw new IllegalArgumentException("Additional variable length cannot be negative: " + i11);
        }
    }

    public interface SpecialMethodInvocation extends StackManipulation {

        public static abstract class AbstractBase extends StackManipulation.AbstractBase implements SpecialMethodInvocation {
            private transient /* synthetic */ int hashCode;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SpecialMethodInvocation)) {
                    return false;
                }
                SpecialMethodInvocation specialMethodInvocation = (SpecialMethodInvocation) obj;
                if (!getMethodDescription().asSignatureToken().equals(specialMethodInvocation.getMethodDescription().asSignatureToken()) || !getTypeDescription().equals(specialMethodInvocation.getTypeDescription())) {
                    return false;
                }
                return true;
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : (getMethodDescription().asSignatureToken().hashCode() * 31) + getTypeDescription().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }
        }

        public enum Illegal implements SpecialMethodInvocation {
            INSTANCE;

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                throw new IllegalStateException("Cannot implement an undefined method");
            }

            public MethodDescription getMethodDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            public TypeDescription getTypeDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            public boolean isValid() {
                return false;
            }

            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                return this;
            }
        }

        public static class Simple extends AbstractBase {
            private final MethodDescription methodDescription;
            private final StackManipulation stackManipulation;
            private final TypeDescription typeDescription;

            public Simple(MethodDescription methodDescription2, TypeDescription typeDescription2, StackManipulation stackManipulation2) {
                this.methodDescription = methodDescription2;
                this.typeDescription = typeDescription2;
                this.stackManipulation = stackManipulation2;
            }

            public static SpecialMethodInvocation of(MethodDescription methodDescription2, TypeDescription typeDescription2) {
                StackManipulation special = MethodInvocation.invoke(methodDescription2).special(typeDescription2);
                if (special.isValid()) {
                    return new Simple(methodDescription2, typeDescription2, special);
                }
                return Illegal.INSTANCE;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                return this.stackManipulation.apply(methodVisitor, context);
            }

            public MethodDescription getMethodDescription() {
                return this.methodDescription;
            }

            public TypeDescription getTypeDescription() {
                return this.typeDescription;
            }

            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                if (this.methodDescription.asTypeToken().equals(typeToken)) {
                    return this;
                }
                return Illegal.INSTANCE;
            }
        }

        MethodDescription getMethodDescription();

        TypeDescription getTypeDescription();

        SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken);
    }

    ByteCodeAppender appender(Target target);

    public interface Context extends MethodAccessorFactory {

        public static class Disabled extends ExtractableView.AbstractBase {

            public enum Factory implements Factory {
                INSTANCE;

                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    if (!typeInitializer.isDefined()) {
                        return new Disabled(typeDescription, classFileVersion);
                    }
                    throw new IllegalStateException("Cannot define type initializer which was explicitly disabled: " + typeInitializer);
                }
            }

            public Disabled(TypeDescription typeDescription, ClassFileVersion classFileVersion) {
                super(typeDescription, classFileVersion);
            }

            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                throw new IllegalStateException("Field values caching was disabled: " + typeDescription);
            }

            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                drain.apply(classVisitor, TypeInitializer.None.INSTANCE, this);
            }

            public List<DynamicType> getAuxiliaryTypes() {
                return Collections.emptyList();
            }

            public boolean isEnabled() {
                return false;
            }

            public TypeDescription register(AuxiliaryType auxiliaryType) {
                throw new IllegalStateException("Registration of auxiliary types was disabled: " + auxiliaryType);
            }

            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of method accessors was disabled: " + specialMethodInvocation.getMethodDescription());
            }

            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }

            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }
        }

        public interface ExtractableView extends Context {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements ExtractableView {

                /* renamed from: b  reason: collision with root package name */
                public final TypeDescription f27272b;

                /* renamed from: c  reason: collision with root package name */
                public final ClassFileVersion f27273c;

                public AbstractBase(TypeDescription typeDescription, ClassFileVersion classFileVersion) {
                    this.f27272b = typeDescription;
                    this.f27273c = classFileVersion;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.f27272b.equals(abstractBase.f27272b) && this.f27273c.equals(abstractBase.f27273c);
                }

                public ClassFileVersion getClassFileVersion() {
                    return this.f27273c;
                }

                public TypeDescription getInstrumentedType() {
                    return this.f27272b;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27272b.hashCode()) * 31) + this.f27273c.hashCode();
                }
            }

            void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            List<DynamicType> getAuxiliaryTypes();

            boolean isEnabled();
        }

        public interface Factory {
            ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2);
        }

        FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription);

        ClassFileVersion getClassFileVersion();

        TypeDescription getInstrumentedType();

        TypeDescription register(AuxiliaryType auxiliaryType);

        public static class Default extends ExtractableView.AbstractBase {
            public static final String ACCESSOR_METHOD_SUFFIX = "accessor";
            public static final String FIELD_CACHE_PREFIX = "cachedValue";
            private final ClassFileVersion auxiliaryClassFileVersion;
            private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
            private final Map<AuxiliaryType, DynamicType> auxiliaryTypes = new HashMap();
            private boolean fieldCacheCanAppendEntries = true;
            private final Map<SpecialMethodInvocation, DelegationRecord> registeredAccessorMethods = new HashMap();
            private final Map<FieldCacheEntry, FieldDescription.InDefinedShape> registeredFieldCacheEntries = new HashMap();
            private final Set<FieldDescription.InDefinedShape> registeredFieldCacheFields = new HashSet();
            private final Map<FieldDescription, DelegationRecord> registeredGetters = new HashMap();
            private final Map<FieldDescription, DelegationRecord> registeredSetters = new HashMap();
            private final String suffix = RandomString.make();
            private final TypeInitializer typeInitializer;

            public static abstract class AbstractPropertyAccessorMethod extends MethodDescription.InDefinedShape.AbstractBase {
                public abstract int a();

                public int getModifiers() {
                    return a() | 4096 | (getDeclaringType().isInterface() ? 1 : 16);
                }
            }

            public static class AccessorMethod extends AbstractPropertyAccessorMethod {
                private final TypeDescription instrumentedType;
                private final MethodDescription methodDescription;

                /* renamed from: name  reason: collision with root package name */
                private final String f27266name;

                public AccessorMethod(TypeDescription typeDescription, MethodDescription methodDescription2, TypeDescription typeDescription2, String str) {
                    String str2;
                    this.instrumentedType = typeDescription;
                    this.methodDescription = methodDescription2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(methodDescription2.getInternalName());
                    sb2.append("$");
                    sb2.append(Default.ACCESSOR_METHOD_SUFFIX);
                    sb2.append("$");
                    sb2.append(str);
                    if (typeDescription2.isInterface()) {
                        str2 = "$" + RandomString.hashOf(typeDescription2.hashCode());
                    } else {
                        str2 = "";
                    }
                    sb2.append(str2);
                    this.f27266name = sb2.toString();
                }

                public int a() {
                    return this.methodDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return this.f27266name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.methodDescription.getParameters().asTypeList().asRawTypes());
                }

                public TypeDescription.Generic getReturnType() {
                    return this.methodDescription.getReturnType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            public static class CacheValueField extends FieldDescription.InDefinedShape.AbstractBase {
                private final TypeDescription.Generic fieldType;
                private final TypeDescription instrumentedType;

                /* renamed from: name  reason: collision with root package name */
                private final String f27267name;

                public CacheValueField(TypeDescription typeDescription, TypeDescription.Generic generic, String str, int i11) {
                    this.instrumentedType = typeDescription;
                    this.fieldType = generic;
                    this.f27267name = "cachedValue$" + str + "$" + RandomString.hashOf(i11);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public int getModifiers() {
                    return (this.instrumentedType.isInterface() ? 1 : 2) | 4120;
                }

                public String getName() {
                    return this.f27267name;
                }

                public TypeDescription.Generic getType() {
                    return this.fieldType;
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class DelegationRecord extends TypeWriter.MethodPool.Record.ForDefinedMethod implements ByteCodeAppender {

                /* renamed from: b  reason: collision with root package name */
                public final MethodDescription.InDefinedShape f27268b;

                /* renamed from: c  reason: collision with root package name */
                public final Visibility f27269c;

                public DelegationRecord(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility) {
                    this.f27268b = inDefinedShape;
                    this.f27269c = visibility;
                }

                public abstract DelegationRecord a(MethodAccessorFactory.AccessType accessType);

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                public void applyBody(MethodVisitor methodVisitor, Context context, AnnotationValueFilter.Factory factory) {
                    methodVisitor.visitCode();
                    ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                    methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Context context) {
                    return apply(methodVisitor, context, getMethod());
                }

                public void applyHead(MethodVisitor methodVisitor) {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    DelegationRecord delegationRecord = (DelegationRecord) obj;
                    return this.f27269c.equals(delegationRecord.f27269c) && this.f27268b.equals(delegationRecord.f27268b);
                }

                public TypeWriter.MethodPool.Record.Sort getSort() {
                    return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
                }

                public Visibility getVisibility() {
                    return this.f27269c;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27268b.hashCode()) * 31) + this.f27269c.hashCode();
                }

                public TypeWriter.MethodPool.Record prepend(ByteCodeAppender byteCodeAppender) {
                    throw new UnsupportedOperationException("Cannot prepend code to a delegation for " + this.f27268b);
                }

                public MethodDescription.InDefinedShape getMethod() {
                    return this.f27268b;
                }
            }

            public enum Factory implements Factory {
                INSTANCE;

                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    return new Default(typeDescription, classFileVersion, namingStrategy, typeInitializer, classFileVersion2);
                }
            }

            public static class FieldCacheEntry implements StackManipulation {
                private final TypeDescription fieldType;
                private final StackManipulation fieldValue;

                public FieldCacheEntry(StackManipulation stackManipulation, TypeDescription typeDescription) {
                    this.fieldValue = stackManipulation;
                    this.fieldType = typeDescription;
                }

                public ByteCodeAppender a(FieldDescription fieldDescription) {
                    return new ByteCodeAppender.Simple(this, FieldAccess.forField(fieldDescription).write());
                }

                public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                    return this.fieldValue.apply(methodVisitor, context);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    FieldCacheEntry fieldCacheEntry = (FieldCacheEntry) obj;
                    if (!this.fieldValue.equals(fieldCacheEntry.fieldValue) || !this.fieldType.equals(fieldCacheEntry.fieldType)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return (this.fieldValue.hashCode() * 31) + this.fieldType.hashCode();
                }

                public boolean isValid() {
                    return this.fieldValue.isValid();
                }
            }

            public static class FieldGetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;

                /* renamed from: name  reason: collision with root package name */
                private final String f27270name;

                public FieldGetter(TypeDescription typeDescription, FieldDescription fieldDescription2, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription2;
                    this.f27270name = fieldDescription2.getName() + "$" + Default.ACCESSOR_METHOD_SUFFIX + "$" + str;
                }

                public int a() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return new TypeList.Generic.Empty();
                }

                public String getInternalName() {
                    return this.f27270name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Empty();
                }

                public TypeDescription.Generic getReturnType() {
                    return this.fieldDescription.getType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class FieldGetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                public FieldGetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription2) {
                    this(new FieldGetter(typeDescription, fieldDescription2, str), accessType.getVisibility(), fieldDescription2);
                }

                public DelegationRecord a(MethodAccessorFactory.AccessType accessType) {
                    return new FieldGetterDelegation(this.f27268b, this.f27269c.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    StackManipulation stackManipulation;
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (this.fieldDescription.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                    stackManipulationArr[2] = MethodReturn.of(this.fieldDescription.getType());
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldGetterDelegation) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                private FieldGetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription2) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription2;
                }
            }

            public static class FieldSetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;

                /* renamed from: name  reason: collision with root package name */
                private final String f27271name;

                public FieldSetter(TypeDescription typeDescription, FieldDescription fieldDescription2, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription2;
                    this.f27271name = fieldDescription2.getName() + "$" + Default.ACCESSOR_METHOD_SUFFIX + "$" + str;
                }

                public int a() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return new TypeList.Generic.Empty();
                }

                public String getInternalName() {
                    return this.f27271name;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) Collections.singletonList(this.fieldDescription.getType().asRawType()));
                }

                public TypeDescription.Generic getReturnType() {
                    return TypeDescription.Generic.VOID;
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class FieldSetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                public FieldSetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription2) {
                    this(new FieldSetter(typeDescription, fieldDescription2, str), accessType.getVisibility(), fieldDescription2);
                }

                public DelegationRecord a(MethodAccessorFactory.AccessType accessType) {
                    return new FieldSetterDelegation(this.f27268b, this.f27269c.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldSetterDelegation) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }

                private FieldSetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription2) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription2;
                }
            }

            public Default(TypeDescription typeDescription, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer2, ClassFileVersion classFileVersion2) {
                super(typeDescription, classFileVersion);
                this.auxiliaryTypeNamingStrategy = namingStrategy;
                this.typeInitializer = typeInitializer2;
                this.auxiliaryClassFileVersion = classFileVersion2;
            }

            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                FieldCacheEntry fieldCacheEntry = new FieldCacheEntry(stackManipulation, typeDescription);
                FieldDescription.InDefinedShape inDefinedShape = this.registeredFieldCacheEntries.get(fieldCacheEntry);
                if (inDefinedShape != null) {
                    return inDefinedShape;
                }
                if (this.fieldCacheCanAppendEntries) {
                    int hashCode = stackManipulation.hashCode();
                    while (true) {
                        int i11 = hashCode + 1;
                        CacheValueField cacheValueField = new CacheValueField(this.f27272b, typeDescription.asGenericType(), this.suffix, hashCode);
                        if (this.registeredFieldCacheFields.add(cacheValueField)) {
                            this.registeredFieldCacheEntries.put(fieldCacheEntry, cacheValueField);
                            return cacheValueField;
                        }
                        hashCode = i11;
                    }
                } else {
                    throw new IllegalStateException("Cached values cannot be registered after defining the type initializer for " + this.f27272b);
                }
            }

            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                this.fieldCacheCanAppendEntries = false;
                TypeInitializer typeInitializer2 = this.typeInitializer;
                for (Map.Entry next : this.registeredFieldCacheEntries.entrySet()) {
                    FieldVisitor visitField = classVisitor.visitField(((FieldDescription.InDefinedShape) next.getValue()).getModifiers(), ((FieldDescription.InDefinedShape) next.getValue()).getInternalName(), ((FieldDescription.InDefinedShape) next.getValue()).getDescriptor(), ((FieldDescription.InDefinedShape) next.getValue()).getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (visitField != null) {
                        visitField.visitEnd();
                        typeInitializer2 = typeInitializer2.expandWith(((FieldCacheEntry) next.getKey()).a((FieldDescription) next.getValue()));
                    }
                }
                drain.apply(classVisitor, typeInitializer2, this);
                for (DelegationRecord apply : this.registeredAccessorMethods.values()) {
                    apply.apply(classVisitor, this, factory);
                }
                for (DelegationRecord apply2 : this.registeredGetters.values()) {
                    apply2.apply(classVisitor, this, factory);
                }
                for (DelegationRecord apply3 : this.registeredSetters.values()) {
                    apply3.apply(classVisitor, this, factory);
                }
            }

            public List<DynamicType> getAuxiliaryTypes() {
                return new ArrayList(this.auxiliaryTypes.values());
            }

            public boolean isEnabled() {
                return true;
            }

            public TypeDescription register(AuxiliaryType auxiliaryType) {
                DynamicType dynamicType = this.auxiliaryTypes.get(auxiliaryType);
                if (dynamicType == null) {
                    dynamicType = auxiliaryType.make(this.auxiliaryTypeNamingStrategy.name(this.f27272b), this.auxiliaryClassFileVersion, this);
                    this.auxiliaryTypes.put(auxiliaryType, dynamicType);
                }
                return dynamicType.getTypeDescription();
            }

            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredAccessorMethods.get(specialMethodInvocation);
                if (delegationRecord2 == null) {
                    delegationRecord = new AccessorMethodDelegation(this.f27272b, this.suffix, accessType, specialMethodInvocation);
                } else {
                    delegationRecord = delegationRecord2.a(accessType);
                }
                this.registeredAccessorMethods.put(specialMethodInvocation, delegationRecord);
                return delegationRecord.getMethod();
            }

            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredGetters.get(fieldDescription);
                if (delegationRecord2 == null) {
                    delegationRecord = new FieldGetterDelegation(this.f27272b, this.suffix, accessType, fieldDescription);
                } else {
                    delegationRecord = delegationRecord2.a(accessType);
                }
                this.registeredGetters.put(fieldDescription, delegationRecord);
                return delegationRecord.getMethod();
            }

            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord;
                DelegationRecord delegationRecord2 = this.registeredSetters.get(fieldDescription);
                if (delegationRecord2 == null) {
                    delegationRecord = new FieldSetterDelegation(this.f27272b, this.suffix, accessType, fieldDescription);
                } else {
                    delegationRecord = delegationRecord2.a(accessType);
                }
                this.registeredSetters.put(fieldDescription, delegationRecord);
                return delegationRecord.getMethod();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class AccessorMethodDelegation extends DelegationRecord {
                private final StackManipulation accessorMethodInvocation;

                public AccessorMethodDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, SpecialMethodInvocation specialMethodInvocation) {
                    this(new AccessorMethod(typeDescription, specialMethodInvocation.getMethodDescription(), specialMethodInvocation.getTypeDescription(), str), accessType.getVisibility(), specialMethodInvocation);
                }

                public DelegationRecord a(MethodAccessorFactory.AccessType accessType) {
                    return new AccessorMethodDelegation(this.f27268b, this.f27269c.expandTo(accessType.getVisibility()), this.accessorMethodInvocation);
                }

                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), this.accessorMethodInvocation, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.accessorMethodInvocation.equals(((AccessorMethodDelegation) obj).accessorMethodInvocation);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.accessorMethodInvocation.hashCode();
                }

                private AccessorMethodDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, StackManipulation stackManipulation) {
                    super(inDefinedShape, visibility);
                    this.accessorMethodInvocation = stackManipulation;
                }
            }
        }
    }

    public interface Target {

        public interface Factory {
            Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion);
        }

        TypeDescription getInstrumentedType();

        TypeDefinition getOriginType();

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription);

        SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class AbstractBase implements Target {

            /* renamed from: a  reason: collision with root package name */
            public final TypeDescription f27275a;

            /* renamed from: b  reason: collision with root package name */
            public final MethodGraph.Linked f27276b;

            /* renamed from: c  reason: collision with root package name */
            public final DefaultMethodInvocation f27277c;

            public enum DefaultMethodInvocation {
                ENABLED {
                    public SpecialMethodInvocation a(MethodGraph.Node node, TypeDescription typeDescription) {
                        if (node.getSort().isUnique()) {
                            return SpecialMethodInvocation.Simple.of(node.getRepresentative(), typeDescription);
                        }
                        return SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                },
                DISABLED {
                    public SpecialMethodInvocation a(MethodGraph.Node node, TypeDescription typeDescription) {
                        return SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                };

                public static DefaultMethodInvocation of(ClassFileVersion classFileVersion) {
                    return classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? ENABLED : DISABLED;
                }

                public abstract SpecialMethodInvocation a(MethodGraph.Node node, TypeDescription typeDescription);
            }

            public AbstractBase(TypeDescription typeDescription, MethodGraph.Linked linked, DefaultMethodInvocation defaultMethodInvocation) {
                this.f27275a = typeDescription;
                this.f27276b = linked;
                this.f27277c = defaultMethodInvocation;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                AbstractBase abstractBase = (AbstractBase) obj;
                return this.f27277c.equals(abstractBase.f27277c) && this.f27275a.equals(abstractBase.f27275a) && this.f27276b.equals(abstractBase.f27276b);
            }

            public TypeDescription getInstrumentedType() {
                return this.f27275a;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.f27275a.hashCode()) * 31) + this.f27276b.hashCode()) * 31) + this.f27277c.hashCode();
            }

            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation specialMethodInvocation = SpecialMethodInvocation.Illegal.INSTANCE;
                for (TypeDescription invokeDefault : this.f27275a.getInterfaces().asErasures()) {
                    SpecialMethodInvocation withCheckedCompatibilityTo = invokeDefault(signatureToken, invokeDefault).withCheckedCompatibilityTo(signatureToken.asTypeToken());
                    if (withCheckedCompatibilityTo.isValid()) {
                        if (specialMethodInvocation.isValid()) {
                            return SpecialMethodInvocation.Illegal.INSTANCE;
                        }
                        specialMethodInvocation = withCheckedCompatibilityTo;
                    }
                }
                return specialMethodInvocation;
            }

            public SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation invokeSuper = invokeSuper(signatureToken);
                if (invokeSuper.isValid()) {
                    return invokeSuper;
                }
                return invokeDefault(signatureToken);
            }

            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription) {
                return this.f27277c.a(this.f27276b.getInterfaceGraph(typeDescription).locate(signatureToken), typeDescription);
            }
        }
    }
}
