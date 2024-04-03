package net.bytebuddy;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import datamodels.TypesAliasesKt;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.DecoratingDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.RedefinitionDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

@HashCodeAndEqualsPlugin.Enhance
public class ByteBuddy {
    private static final String BYTE_BUDDY_DEFAULT_PREFIX = "ByteBuddy";
    private static final String BYTE_BUDDY_DEFAULT_SUFFIX = "auxiliary";

    /* renamed from: a  reason: collision with root package name */
    public final ClassFileVersion f26907a;

    /* renamed from: b  reason: collision with root package name */
    public final NamingStrategy f26908b;

    /* renamed from: c  reason: collision with root package name */
    public final AuxiliaryType.NamingStrategy f26909c;

    /* renamed from: d  reason: collision with root package name */
    public final AnnotationValueFilter.Factory f26910d;

    /* renamed from: e  reason: collision with root package name */
    public final AnnotationRetention f26911e;

    /* renamed from: f  reason: collision with root package name */
    public final Implementation.Context.Factory f26912f;

    /* renamed from: g  reason: collision with root package name */
    public final MethodGraph.Compiler f26913g;

    /* renamed from: h  reason: collision with root package name */
    public final InstrumentedType.Factory f26914h;

    /* renamed from: i  reason: collision with root package name */
    public final LatentMatcher<? super MethodDescription> f26915i;

    /* renamed from: j  reason: collision with root package name */
    public final TypeValidation f26916j;

    /* renamed from: k  reason: collision with root package name */
    public final VisibilityBridgeStrategy f26917k;

    /* renamed from: l  reason: collision with root package name */
    public final ClassWriterStrategy f26918l;

    @HashCodeAndEqualsPlugin.Enhance
    public static class EnumerationImplementation implements Implementation {
        private static final int ENUM_FIELD_MODIFIERS = 25;
        private static final String ENUM_VALUES = "$VALUES";
        private final List<String> values;

        @HashCodeAndEqualsPlugin.Enhance
        public static class InitializationAppender implements ByteCodeAppender {
            private final List<String> values;

            public InitializationAppender(List<String> list) {
                this.values = list;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                TypeDescription asErasure = methodDescription.getDeclaringType().asErasure();
                MethodDescription methodDescription2 = (MethodDescription) ((MethodList) asErasure.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class, Integer.TYPE})))).getOnly();
                StackManipulation stackManipulation = StackManipulation.Trivial.INSTANCE;
                ArrayList<FieldDescription> arrayList = new ArrayList<>(this.values.size());
                int i11 = 0;
                for (String next : this.values) {
                    FieldDescription fieldDescription = (FieldDescription) ((FieldList) asErasure.getDeclaredFields().filter(ElementMatchers.named(next))).getOnly();
                    StackManipulation compound = new StackManipulation.Compound(stackManipulation, TypeCreation.of(asErasure), Duplication.SINGLE, new TextConstant(next), IntegerConstant.forValue(i11), MethodInvocation.invoke(methodDescription2), FieldAccess.forField(fieldDescription).write());
                    arrayList.add(fieldDescription);
                    i11++;
                    stackManipulation = compound;
                }
                ArrayList arrayList2 = new ArrayList(this.values.size());
                for (FieldDescription forField : arrayList) {
                    arrayList2.add(FieldAccess.forField(forField).read());
                }
                return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, ArrayFactory.forType(asErasure.asGenericType()).withValues(arrayList2), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) asErasure.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES))).getOnly()).write()).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.values.equals(((InitializationAppender) obj).values);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.values.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ValuesMethodAppender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public ValuesMethodAppender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                FieldDescription fieldDescription = (FieldDescription) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES))).getOnly();
                return new ByteCodeAppender.Size(new StackManipulation.Compound(FieldAccess.forField(fieldDescription).read(), MethodInvocation.invoke((MethodDescription) ((MethodList) TypeDescription.Generic.OBJECT.getDeclaredMethods().filter(ElementMatchers.named("clone"))).getOnly()).virtual(fieldDescription.getType().asErasure()), TypeCasting.to(fieldDescription.getType().asErasure()), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ValuesMethodAppender) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }
        }

        public EnumerationImplementation(List<String> list) {
            this.values = list;
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            return new ValuesMethodAppender(target.getInstrumentedType());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.values.equals(((EnumerationImplementation) obj).values);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.values.hashCode();
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (String token : this.values) {
                instrumentedType = instrumentedType.withField(new FieldDescription.Token(token, 16409, TargetType.DESCRIPTION.asGenericType()));
            }
            return instrumentedType.withField(new FieldDescription.Token(ENUM_VALUES, 4121, TypeDescription.ArrayProjection.of(TargetType.DESCRIPTION).asGenericType())).withInitializer((ByteCodeAppender) new InitializationAppender(this.values));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public enum RecordConstructorStrategy implements ConstructorStrategy, Implementation {
        INSTANCE;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                int i11 = 1;
                if (methodDescription.isMethod()) {
                    return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(methodDescription.getName()))).getOnly()).read(), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                }
                ArrayList arrayList = new ArrayList((this.instrumentedType.getRecordComponents().size() * 3) + 2);
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.RECORD.getTypeStub(), new MethodDescription.Token(1))));
                for (RecordComponentDescription.InDefinedShape inDefinedShape : this.instrumentedType.getRecordComponents()) {
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(MethodVariableAccess.of(inDefinedShape.getType()).loadFrom(i11));
                    arrayList.add(FieldAccess.forField((FieldDescription.InDefinedShape) ((FieldList) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName()))).getOnly()).write());
                    i11 += inDefinedShape.getType().getStackSize().getSize();
                }
                arrayList.add(MethodReturn.VOID);
                return new ByteCodeAppender.Simple((List<? extends StackManipulation>) arrayList).apply(methodVisitor, context, methodDescription);
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

        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(typeDescription.getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : typeDescription.getRecordComponents()) {
                arrayList.add(new ParameterDescription.Token(inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.CONSTRUCTOR)), inDefinedShape.getActualName(), 0));
            }
            return Collections.singletonList(new MethodDescription.Token(MethodDescription.CONSTRUCTOR_INTERNAL_NAME, 1, Collections.emptyList(), TypeDescription.Generic.VOID, arrayList, Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
        }

        public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
            return methodRegistry.prepend(new LatentMatcher.Resolved(ElementMatchers.isConstructor().and(ElementMatchers.takesGenericArguments((List<? extends TypeDefinition>) typeDescription.getRecordComponents().asTypeList()))), new MethodRegistry.Handler.ForImplementation(this), MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER, Transformer.NoOp.make());
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (RecordComponentDescription.InDefinedShape inDefinedShape : instrumentedType.getRecordComponents()) {
                instrumentedType = instrumentedType.withField(new FieldDescription.Token(inDefinedShape.getActualName(), 18, inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.FIELD)))).withMethod(new MethodDescription.Token(inDefinedShape.getActualName(), 1, Collections.emptyList(), inDefinedShape.getType(), Collections.emptyList(), Collections.emptyList(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.METHOD)), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
            }
            return instrumentedType;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public enum RecordObjectMethod implements Implementation {
        HASH_CODE("hashCode", r12, Integer.TYPE, new Class[0]),
        EQUALS("equals", MethodVariableAccess.REFERENCE.loadFrom(1), Boolean.TYPE, Object.class),
        TO_STRING("toString", r12, String.class, new Class[0]);
        
        private final List<? extends TypeDescription> arguments;

        /* renamed from: name  reason: collision with root package name */
        private final String f26919name;
        private final TypeDescription returnType;
        private final StackManipulation stackManipulation;

        private RecordObjectMethod(String str, StackManipulation stackManipulation2, Class<?> cls, Class<?>... clsArr) {
            this.f26919name = str;
            this.stackManipulation = stackManipulation2;
            this.returnType = TypeDescription.ForLoadedType.of(cls);
            this.arguments = new TypeList.ForLoadedTypes(clsArr);
        }

        public ByteCodeAppender appender(Implementation.Target target) {
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList = new ArrayList(target.getInstrumentedType().getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : target.getInstrumentedType().getRecordComponents()) {
                if (sb2.length() > 0) {
                    sb2.append(TypesAliasesKt.separator);
                }
                sb2.append(inDefinedShape.getActualName());
                arrayList.add(JavaConstant.MethodHandle.ofGetter((FieldDescription.InDefinedShape) ((FieldList) target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName()))).getOnly()));
            }
            TypeDescription typeStub = JavaType.OBJECT_METHODS.getTypeStub();
            TypeDescription.Generic generic = TypeDescription.Generic.OBJECT;
            TypeDescription typeDescription = TypeDescription.STRING;
            return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), this.stackManipulation, MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("bootstrap", 9, generic, Arrays.asList(new TypeDescription.Generic[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType(), typeDescription.asGenericType(), JavaType.TYPE_DESCRIPTOR.getTypeStub().asGenericType(), TypeDescription.CLASS.asGenericType(), typeDescription.asGenericType(), TypeDescription.ArrayProjection.of(JavaType.METHOD_HANDLE.getTypeStub()).asGenericType()})))).dynamic(this.f26919name, this.returnType, CompoundList.of(target.getInstrumentedType(), this.arguments), CompoundList.of(Arrays.asList(new JavaConstant[]{JavaConstant.Simple.of(target.getInstrumentedType()), JavaConstant.Simple.ofLoaded(sb2.toString())}), (List) arrayList)), MethodReturn.of(this.returnType));
        }

        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    public ByteBuddy() {
        this(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5));
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls) {
        return decorate(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ByteBuddy byteBuddy = (ByteBuddy) obj;
        return this.f26911e.equals(byteBuddy.f26911e) && this.f26916j.equals(byteBuddy.f26916j) && this.f26907a.equals(byteBuddy.f26907a) && this.f26908b.equals(byteBuddy.f26908b) && this.f26909c.equals(byteBuddy.f26909c) && this.f26910d.equals(byteBuddy.f26910d) && this.f26912f.equals(byteBuddy.f26912f) && this.f26913g.equals(byteBuddy.f26913g) && this.f26914h.equals(byteBuddy.f26914h) && this.f26915i.equals(byteBuddy.f26915i) && this.f26917k.equals(byteBuddy.f26917k) && this.f26918l.equals(byteBuddy.f26918l);
    }

    public int hashCode() {
        return (((((((((((((((((((((((getClass().hashCode() * 31) + this.f26907a.hashCode()) * 31) + this.f26908b.hashCode()) * 31) + this.f26909c.hashCode()) * 31) + this.f26910d.hashCode()) * 31) + this.f26911e.hashCode()) * 31) + this.f26912f.hashCode()) * 31) + this.f26913g.hashCode()) * 31) + this.f26914h.hashCode()) * 31) + this.f26915i.hashCode()) * 31) + this.f26916j.hashCode()) * 31) + this.f26917k.hashCode()) * 31) + this.f26918l.hashCode();
    }

    public ByteBuddy ignore(ElementMatcher<? super MethodDescription> elementMatcher) {
        return ignore((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher));
    }

    public DynamicType.Builder<? extends Annotation> makeAnnotation() {
        InstrumentedType.Factory factory = this.f26914h;
        NamingStrategy namingStrategy = this.f26908b;
        TypeDescription.Generic generic = TypeDescription.Generic.ANNOTATION;
        return new SubclassDynamicTypeBuilder(factory.subclass(namingStrategy.subclass(generic), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.ANNOTATION).resolve(), TypeDescription.Generic.OBJECT).withInterfaces(new TypeList.Generic.Explicit(generic)), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(String... strArr) {
        return makeEnumeration((Collection<? extends String>) Arrays.asList(strArr));
    }

    public DynamicType.Builder<?> makeInterface() {
        return makeInterface((Collection<? extends TypeDefinition>) Collections.emptyList());
    }

    public DynamicType.Builder<?> makePackage(String str) {
        InstrumentedType.Factory factory = this.f26914h;
        return new SubclassDynamicTypeBuilder(factory.subclass(str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + PackageDescription.PACKAGE_CLASS_NAME, PackageDescription.PACKAGE_MODIFIERS, TypeDescription.Generic.OBJECT), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<?> makeRecord() {
        String name2 = JavaType.RECORD.getTypeStub().getName();
        TypeDescription.Generic generic = TypeDescription.Generic.OBJECT;
        TypeDescription.Generic asGenericType = InstrumentedType.Default.of(name2, generic, Visibility.PUBLIC).withMethod(new MethodDescription.Token(4)).withMethod(new MethodDescription.Token("hashCode", 1025, TypeDescription.ForLoadedType.of(Integer.TYPE).asGenericType())).withMethod(new MethodDescription.Token("equals", 1025, TypeDescription.ForLoadedType.of(Boolean.TYPE).asGenericType(), Collections.singletonList(generic))).withMethod(new MethodDescription.Token("toString", 1025, TypeDescription.ForLoadedType.of(String.class).asGenericType())).asGenericType();
        return new SubclassDynamicTypeBuilder(this.f26914h.subclass(this.f26908b.subclass(asGenericType), 17, asGenericType).withRecord(true), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, RecordConstructorStrategy.INSTANCE).method(ElementMatchers.isHashCode()).intercept(RecordObjectMethod.HASH_CODE).method(ElementMatchers.isEquals()).intercept(RecordObjectMethod.EQUALS).method(ElementMatchers.isToString()).intercept(RecordObjectMethod.TO_STRING);
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls) {
        return rebase(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls) {
        return redefine(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls) {
        return subclass((TypeDefinition) TypeDescription.ForLoadedType.of(cls));
    }

    public ByteBuddy with(ClassFileVersion classFileVersion) {
        return new ByteBuddy(classFileVersion, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public ByteBuddy(ClassFileVersion classFileVersion) {
        this(classFileVersion, new NamingStrategy.SuffixingRandom(BYTE_BUDDY_DEFAULT_PREFIX), new AuxiliaryType.NamingStrategy.SuffixingRandom(BYTE_BUDDY_DEFAULT_SUFFIX), AnnotationValueFilter.Default.APPEND_DEFAULTS, AnnotationRetention.ENABLED, Implementation.Context.Default.Factory.INSTANCE, MethodGraph.Compiler.DEFAULT, InstrumentedType.Factory.Default.MODIFIABLE, TypeValidation.ENABLED, VisibilityBridgeStrategy.Default.ALWAYS, ClassWriterStrategy.Default.CONSTANT_POOL_RETAINING, new LatentMatcher.Resolved(ElementMatchers.isSynthetic().or(ElementMatchers.isDefaultFinalizer())));
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls, ClassFileLocator classFileLocator) {
        return decorate(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public ByteBuddy ignore(LatentMatcher<? super MethodDescription> latentMatcher) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, latentMatcher);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(Collection<? extends String> collection) {
        if (!collection.isEmpty()) {
            Class<TargetType> cls = TargetType.class;
            TypeDescription.Generic build = TypeDescription.Generic.Builder.parameterizedType((Class<?>) Enum.class, cls).build();
            InstrumentedType.Factory factory = this.f26914h;
            String subclass = this.f26908b.subclass(build);
            Visibility visibility = Visibility.PUBLIC;
            InstrumentedType.WithFlexibleName subclass2 = factory.subclass(subclass, ModifierContributor.Resolver.of(visibility, TypeManifestation.FINAL, EnumerationState.ENUMERATION).resolve(), build);
            ClassFileVersion classFileVersion = this.f26907a;
            AuxiliaryType.NamingStrategy namingStrategy = this.f26909c;
            AnnotationValueFilter.Factory factory2 = this.f26910d;
            AnnotationRetention annotationRetention = this.f26911e;
            Implementation.Context.Factory factory3 = this.f26912f;
            MethodGraph.Compiler compiler = this.f26913g;
            TypeValidation typeValidation = this.f26916j;
            VisibilityBridgeStrategy visibilityBridgeStrategy = this.f26917k;
            ClassWriterStrategy classWriterStrategy = this.f26918l;
            LatentMatcher<? super MethodDescription> latentMatcher = this.f26915i;
            SubclassDynamicTypeBuilder subclassDynamicTypeBuilder = r5;
            SubclassDynamicTypeBuilder subclassDynamicTypeBuilder2 = new SubclassDynamicTypeBuilder(subclass2, classFileVersion, namingStrategy, factory2, annotationRetention, factory3, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, latentMatcher, ConstructorStrategy.Default.NO_CONSTRUCTORS);
            Class<String> cls2 = String.class;
            DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition intercept = subclassDynamicTypeBuilder.defineConstructor(Visibility.PRIVATE).withParameters(cls2, Integer.TYPE).intercept(SuperMethodCall.INSTANCE);
            Ownership ownership = Ownership.STATIC;
            return intercept.defineMethod("valueOf", (Type) cls, visibility, ownership).withParameters(cls2).intercept(MethodCall.invoke((MethodDescription) ((MethodList) build.getDeclaredMethods().filter(ElementMatchers.named("valueOf").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{Class.class, cls2})))).getOnly()).withOwnType().withArgument(0).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).defineMethod("values", (Type) TargetType[].class, visibility, ownership).intercept(new EnumerationImplementation(new ArrayList(collection)));
        }
        throw new IllegalArgumentException("Require at least one enumeration constant");
    }

    public <T> DynamicType.Builder<T> makeInterface(Class<T> cls) {
        return makeInterface((List<? extends Type>) Collections.singletonList(cls));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls, ClassFileLocator classFileLocator) {
        return redefine(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls, ConstructorStrategy constructorStrategy) {
        return subclass((TypeDefinition) TypeDescription.ForLoadedType.of(cls), constructorStrategy);
    }

    public ByteBuddy with(NamingStrategy namingStrategy) {
        return new ByteBuddy(this.f26907a, namingStrategy, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public <T> DynamicType.Builder<T> decorate(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        if (typeDescription.isArray() || typeDescription.isPrimitive()) {
            throw new IllegalArgumentException("Cannot decorate array or primitive type: " + typeDescription);
        }
        return new DecoratingDynamicTypeBuilder(typeDescription, this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26918l, this.f26915i, classFileLocator);
    }

    public DynamicType.Builder<?> makeInterface(Type... typeArr) {
        return makeInterface((List<? extends Type>) Arrays.asList(typeArr));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator, methodNameTransformer);
    }

    public <T> DynamicType.Builder<T> redefine(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        TypeDescription typeDescription2 = typeDescription;
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RedefinitionDynamicTypeBuilder(this.f26914h.represent(typeDescription2), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, typeDescription, classFileLocator);
        }
        throw new IllegalArgumentException("Cannot redefine array or primitive type: " + typeDescription2);
    }

    public DynamicType.Builder<?> subclass(Type type) {
        return subclass((TypeDefinition) TypeDefinition.Sort.describe(type));
    }

    public ByteBuddy with(AuxiliaryType.NamingStrategy namingStrategy) {
        return new ByteBuddy(this.f26907a, this.f26908b, namingStrategy, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public DynamicType.Builder<?> makeInterface(List<? extends Type> list) {
        return makeInterface((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return rebase(typeDescription, classFileLocator, MethodNameTransformer.Suffixing.withRandomSuffix());
    }

    public DynamicType.Builder<?> subclass(Type type, ConstructorStrategy constructorStrategy) {
        return subclass((TypeDefinition) TypeDefinition.Sort.describe(type), constructorStrategy);
    }

    public ByteBuddy with(AnnotationValueFilter.Factory factory) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, factory, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public ByteBuddy(ClassFileVersion classFileVersion, NamingStrategy namingStrategy, AuxiliaryType.NamingStrategy namingStrategy2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, InstrumentedType.Factory factory3, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher) {
        this.f26907a = classFileVersion;
        this.f26908b = namingStrategy;
        this.f26909c = namingStrategy2;
        this.f26910d = factory;
        this.f26911e = annotationRetention;
        this.f26912f = factory2;
        this.f26913g = compiler;
        this.f26914h = factory3;
        this.f26916j = typeValidation;
        this.f26917k = visibilityBridgeStrategy;
        this.f26918l = classWriterStrategy;
        this.f26915i = latentMatcher;
    }

    public DynamicType.Builder<?> makeInterface(TypeDefinition... typeDefinitionArr) {
        return makeInterface((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        TypeDescription typeDescription2 = typeDescription;
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RebaseDynamicTypeBuilder(this.f26914h.represent(typeDescription2), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, typeDescription, classFileLocator, methodNameTransformer);
        }
        throw new IllegalArgumentException("Cannot rebase array or primitive type: " + typeDescription2);
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition) {
        return subclass(typeDefinition, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING);
    }

    public ByteBuddy with(AnnotationRetention annotationRetention) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, annotationRetention, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public DynamicType.Builder<?> makeInterface(Collection<? extends TypeDefinition> collection) {
        return subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).implement(collection).modifiers(TypeManifestation.INTERFACE, Visibility.PUBLIC);
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition, ConstructorStrategy constructorStrategy) {
        TypeList.Generic generic;
        TypeDescription.Generic generic2;
        TypeDefinition typeDefinition2 = typeDefinition;
        if (typeDefinition.isPrimitive() || typeDefinition.isArray() || typeDefinition.isFinal()) {
            throw new IllegalArgumentException("Cannot subclass primitive, array or final types: " + typeDefinition2);
        }
        if (typeDefinition.isInterface()) {
            generic2 = TypeDescription.Generic.OBJECT;
            generic = new TypeList.Generic.Explicit(typeDefinition2);
        } else {
            generic2 = typeDefinition.asGenericType();
            generic = new TypeList.Generic.Empty();
        }
        return new SubclassDynamicTypeBuilder(this.f26914h.subclass(this.f26908b.subclass(typeDefinition.asGenericType()), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.PLAIN).resolve(typeDefinition.getModifiers()), generic2).withInterfaces(generic), this.f26907a, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26916j, this.f26917k, this.f26918l, this.f26915i, constructorStrategy);
    }

    public ByteBuddy with(Implementation.Context.Factory factory) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, factory, this.f26913g, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public ByteBuddy with(MethodGraph.Compiler compiler) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, compiler, this.f26914h, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public DynamicType.Builder<?> rebase(Package packageR, ClassFileLocator classFileLocator) {
        return rebase((PackageDescription) new PackageDescription.ForLoadedPackage(packageR), classFileLocator);
    }

    public ByteBuddy with(InstrumentedType.Factory factory) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, factory, this.f26916j, this.f26917k, this.f26918l, this.f26915i);
    }

    public DynamicType.Builder<?> rebase(PackageDescription packageDescription, ClassFileLocator classFileLocator) {
        return rebase((TypeDescription) new TypeDescription.ForPackageDescription(packageDescription), classFileLocator);
    }

    public ByteBuddy with(TypeValidation typeValidation) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, typeValidation, this.f26917k, this.f26918l, this.f26915i);
    }

    public ByteBuddy with(VisibilityBridgeStrategy visibilityBridgeStrategy) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, visibilityBridgeStrategy, this.f26918l, this.f26915i);
    }

    public ByteBuddy with(ClassWriterStrategy classWriterStrategy) {
        return new ByteBuddy(this.f26907a, this.f26908b, this.f26909c, this.f26910d, this.f26911e, this.f26912f, this.f26913g, this.f26914h, this.f26916j, this.f26917k, classWriterStrategy, this.f26915i);
    }
}
