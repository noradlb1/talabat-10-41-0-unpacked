package net.bytebuddy.asm;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;

@HashCodeAndEqualsPlugin.Enhance
public class MemberSubstitution implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
    private final MethodGraph.Compiler methodGraphCompiler;
    private final Replacement.Factory replacementFactory;
    private final boolean strict;
    private final TypePoolResolver typePoolResolver;

    /* renamed from: net.bytebuddy.asm.MemberSubstitution$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27076a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType[] r0 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27076a = r0
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType r1 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.VIRTUAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27076a     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.asm.MemberSubstitution$Replacement$InvocationType r1 = net.bytebuddy.asm.MemberSubstitution.Replacement.InvocationType.SUPER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.AnonymousClass1.<clinit>():void");
        }
    }

    public interface Replacement {

        public interface Binding {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved implements Binding {
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;
                private final Substitution substitution;
                private final ByteCodeElement target;
                private final TypeDescription targetType;

                public Resolved(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, ByteCodeElement byteCodeElement, Substitution substitution2) {
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                    this.targetType = typeDescription2;
                    this.target = byteCodeElement;
                    this.substitution = substitution2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Resolved resolved = (Resolved) obj;
                    return this.instrumentedType.equals(resolved.instrumentedType) && this.instrumentedMethod.equals(resolved.instrumentedMethod) && this.targetType.equals(resolved.targetType) && this.target.equals(resolved.target) && this.substitution.equals(resolved.substitution);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.instrumentedMethod.hashCode()) * 31) + this.targetType.hashCode()) * 31) + this.target.hashCode()) * 31) + this.substitution.hashCode();
                }

                public boolean isBound() {
                    return true;
                }

                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                    return this.substitution.resolve(this.targetType, this.target, generic, generic2, i11);
                }
            }

            public enum Unresolved implements Binding {
                INSTANCE;

                public boolean isBound() {
                    return false;
                }

                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                    throw new IllegalStateException("Cannot resolve unresolved binding");
                }
            }

            boolean isBound();

            StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, int i11);
        }

        public interface Factory {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factories.hashCode();
                }

                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    ArrayList arrayList = new ArrayList();
                    for (Factory make : this.factories) {
                        arrayList.add(make.make(typeDescription, methodDescription, typePool));
                    }
                    return new ForFirstBinding(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        public enum InvocationType {
            VIRTUAL,
            SUPER,
            OTHER;

            public static InvocationType b(int i11, MethodDescription methodDescription) {
                if (i11 != 182) {
                    if (i11 != 183) {
                        if (i11 != 185) {
                            return OTHER;
                        }
                    } else if (methodDescription.isVirtual()) {
                        return SUPER;
                    } else {
                        return OTHER;
                    }
                }
                return VIRTUAL;
            }

            public boolean a(boolean z11, boolean z12) {
                int i11 = AnonymousClass1.f27076a[ordinal()];
                if (i11 == 1) {
                    return z11;
                }
                if (i11 != 2) {
                    return true;
                }
                return z12;
            }
        }

        public enum NoOp implements Replacement, Factory {
            INSTANCE;

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z11) {
                return Binding.Unresolved.INSTANCE;
            }

            public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return Binding.Unresolved.INSTANCE;
            }
        }

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z11);

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType);

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements Replacement {
            private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final boolean matchFieldRead;
            private final boolean matchFieldWrite;
            private final ElementMatcher<? super MethodDescription> methodMatcher;
            private final Substitution substitution;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
                private final boolean includeSuperCalls;
                private final boolean includeVirtualCalls;
                private final boolean matchFieldRead;
                private final boolean matchFieldWrite;
                private final ElementMatcher<? super MethodDescription> methodMatcher;
                private final Substitution.Factory substitutionFactory;

                public Factory(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z11, boolean z12, boolean z13, boolean z14, Substitution.Factory factory) {
                    this.fieldMatcher = elementMatcher;
                    this.methodMatcher = elementMatcher2;
                    this.matchFieldRead = z11;
                    this.matchFieldWrite = z12;
                    this.includeVirtualCalls = z13;
                    this.includeSuperCalls = z14;
                    this.substitutionFactory = factory;
                }

                public static Factory a(ElementMatcher<? super ByteCodeElement> elementMatcher, Substitution.Factory factory) {
                    return new Factory(elementMatcher, elementMatcher, true, true, true, true, factory);
                }

                public static Factory b(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, boolean z11, boolean z12, Substitution.Factory factory) {
                    return new Factory(elementMatcher, ElementMatchers.none(), z11, z12, false, false, factory);
                }

                public static Factory c(ElementMatcher<? super MethodDescription> elementMatcher, boolean z11, boolean z12, Substitution.Factory factory) {
                    return new Factory(ElementMatchers.none(), elementMatcher, false, false, z11, z12, factory);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.matchFieldRead == factory.matchFieldRead && this.matchFieldWrite == factory.matchFieldWrite && this.includeVirtualCalls == factory.includeVirtualCalls && this.includeSuperCalls == factory.includeSuperCalls && this.fieldMatcher.equals(factory.fieldMatcher) && this.methodMatcher.equals(factory.methodMatcher) && this.substitutionFactory.equals(factory.substitutionFactory);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.fieldMatcher.hashCode()) * 31) + this.methodMatcher.hashCode()) * 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31) + this.substitutionFactory.hashCode();
                }

                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForElementMatchers(this.fieldMatcher, this.methodMatcher, this.matchFieldRead, this.matchFieldWrite, this.includeVirtualCalls, this.includeSuperCalls, this.substitutionFactory.make(typeDescription, methodDescription, typePool));
                }
            }

            public ForElementMatchers(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z11, boolean z12, boolean z13, boolean z14, Substitution substitution2) {
                this.fieldMatcher = elementMatcher;
                this.methodMatcher = elementMatcher2;
                this.matchFieldRead = z11;
                this.matchFieldWrite = z12;
                this.includeVirtualCalls = z13;
                this.includeSuperCalls = z14;
                this.substitution = substitution2;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z11) {
                if (!z11 ? this.matchFieldRead : this.matchFieldWrite) {
                    if (this.fieldMatcher.matches(inDefinedShape)) {
                        return new Binding.Resolved(typeDescription, methodDescription, inDefinedShape.getDeclaringType(), inDefinedShape, this.substitution);
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.matchFieldRead == forElementMatchers.matchFieldRead && this.matchFieldWrite == forElementMatchers.matchFieldWrite && this.includeVirtualCalls == forElementMatchers.includeVirtualCalls && this.includeSuperCalls == forElementMatchers.includeSuperCalls && this.fieldMatcher.equals(forElementMatchers.fieldMatcher) && this.methodMatcher.equals(forElementMatchers.methodMatcher) && this.substitution.equals(forElementMatchers.substitution);
            }

            public int hashCode() {
                return (((((((((((((getClass().hashCode() * 31) + this.fieldMatcher.hashCode()) * 31) + this.methodMatcher.hashCode()) * 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31) + this.substitution.hashCode();
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                if (!invocationType.a(this.includeVirtualCalls, this.includeSuperCalls) || !this.methodMatcher.matches(methodDescription2)) {
                    return Binding.Unresolved.INSTANCE;
                }
                return new Binding.Resolved(typeDescription, methodDescription, typeDescription2, methodDescription2, this.substitution);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFirstBinding implements Replacement {
            private final List<? extends Replacement> replacements;

            public ForFirstBinding(List<? extends Replacement> list) {
                this.replacements = list;
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, FieldDescription.InDefinedShape inDefinedShape, boolean z11) {
                for (Replacement bind : this.replacements) {
                    Binding bind2 = bind.bind(typeDescription, methodDescription, inDefinedShape, z11);
                    if (bind2.isBound()) {
                        return bind2;
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.replacements.equals(((ForFirstBinding) obj).replacements);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.replacements.hashCode();
            }

            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                for (Replacement bind : this.replacements) {
                    Binding bind2 = bind.bind(typeDescription, methodDescription, typeDescription2, methodDescription2, invocationType);
                    if (bind2.isBound()) {
                        return bind2;
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }
        }
    }

    public static class SubstitutingMethodVisitor extends LocalVariableAwareMethodVisitor {
        private final Implementation.Context implementationContext;
        private final MethodDescription instrumentedMethod;
        private final TypeDescription instrumentedType;
        /* access modifiers changed from: private */
        public int localVariableExtension = 0;
        private final MethodGraph.Compiler methodGraphCompiler;
        private final Replacement replacement;
        private int stackSizeBuffer = 0;
        private final boolean strict;
        private final TypePool typePool;
        private final boolean virtualPrivateCalls;

        public class LocalVariableTracingMethodVisitor extends MethodVisitor {
            public /* synthetic */ LocalVariableTracingMethodVisitor(SubstitutingMethodVisitor substitutingMethodVisitor, MethodVisitor methodVisitor, AnonymousClass1 r32) {
                this(methodVisitor);
            }

            @SuppressFBWarnings(justification = "No action required on default option.", value = {"SF_SWITCH_NO_DEFAULT"})
            public void visitVarInsn(int i11, int i12) {
                switch (i11) {
                    case 54:
                    case 56:
                    case 58:
                        SubstitutingMethodVisitor substitutingMethodVisitor = SubstitutingMethodVisitor.this;
                        int unused = substitutingMethodVisitor.localVariableExtension = Math.max(substitutingMethodVisitor.localVariableExtension, i12 + 1);
                        break;
                    case 55:
                    case 57:
                        SubstitutingMethodVisitor substitutingMethodVisitor2 = SubstitutingMethodVisitor.this;
                        int unused2 = substitutingMethodVisitor2.localVariableExtension = Math.max(substitutingMethodVisitor2.localVariableExtension, i12 + 2);
                        break;
                }
                super.visitVarInsn(i11, i12);
            }

            private LocalVariableTracingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }
        }

        public SubstitutingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription methodDescription, MethodGraph.Compiler compiler, boolean z11, Replacement replacement2, Implementation.Context context, TypePool typePool2, boolean z12) {
            super(methodVisitor, methodDescription);
            this.instrumentedType = typeDescription;
            this.instrumentedMethod = methodDescription;
            this.methodGraphCompiler = compiler;
            this.strict = z11;
            this.replacement = replacement2;
            this.implementationContext = context;
            this.typePool = typePool2;
            this.virtualPrivateCalls = z12;
        }

        public void visitFieldInsn(int i11, String str, String str2, String str3) {
            ElementMatcher.Junction junction;
            boolean z11;
            TypeDescription.Generic generic;
            TypeList.Generic generic2;
            TypePool.Resolution describe = this.typePool.describe(str.replace('/', '.'));
            if (describe.isResolved()) {
                FieldList<FieldDescription.InDefinedShape> declaredFields = describe.resolve().getDeclaredFields();
                if (this.strict) {
                    junction = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                } else {
                    junction = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                }
                FieldList fieldList = (FieldList) declaredFields.filter(junction);
                if (!fieldList.isEmpty()) {
                    Replacement replacement2 = this.replacement;
                    TypeDescription typeDescription = this.instrumentedType;
                    MethodDescription methodDescription = this.instrumentedMethod;
                    FieldDescription.InDefinedShape inDefinedShape = (FieldDescription.InDefinedShape) fieldList.getOnly();
                    if (i11 == 181 || i11 == 179) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Replacement.Binding bind = replacement2.bind(typeDescription, methodDescription, inDefinedShape, z11);
                    if (bind.isBound()) {
                        switch (i11) {
                            case Opcodes.GETSTATIC /*178*/:
                                generic2 = new TypeList.Generic.Empty();
                                generic = ((FieldDescription.InDefinedShape) fieldList.getOnly()).getType();
                                break;
                            case Opcodes.PUTSTATIC /*179*/:
                                generic2 = new TypeList.Generic.Explicit(((FieldDescription.InDefinedShape) fieldList.getOnly()).getType());
                                generic = TypeDescription.Generic.VOID;
                                break;
                            case 180:
                                generic2 = new TypeList.Generic.Explicit(((FieldDescription.InDefinedShape) fieldList.getOnly()).getDeclaringType());
                                generic = ((FieldDescription.InDefinedShape) fieldList.getOnly()).getType();
                                break;
                            case Opcodes.PUTFIELD /*181*/:
                                generic2 = new TypeList.Generic.Explicit(((FieldDescription.InDefinedShape) fieldList.getOnly()).getDeclaringType(), ((FieldDescription.InDefinedShape) fieldList.getOnly()).getType());
                                generic = TypeDescription.Generic.VOID;
                                break;
                            default:
                                throw new IllegalStateException("Unexpected opcode: " + i11);
                        }
                        this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bind.make(generic2, generic, getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.f27400c, (AnonymousClass1) null), this.implementationContext).getMaximalSize() - generic.getStackSize().getSize());
                        return;
                    }
                } else if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str.replace('/', '.') + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str2 + str3 + " using " + this.typePool);
                }
            } else if (this.strict) {
                throw new IllegalStateException("Could not resolve " + str.replace('/', '.') + " using " + this.typePool);
            }
            super.visitFieldInsn(i11, str, str2, str3);
        }

        public void visitMaxs(int i11, int i12) {
            super.visitMaxs(i11 + this.stackSizeBuffer, Math.max(this.localVariableExtension, i12));
        }

        public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
            MethodList methodList;
            TypeList.Generic generic;
            TypeDescription.Generic generic2;
            StackSize stackSize;
            ElementMatcher.Junction junction;
            ElementMatcher.Junction junction2;
            ElementMatcher.Junction junction3;
            ElementMatcher.Junction junction4;
            ElementMatcher.Junction junction5;
            int i12 = i11;
            String str4 = str;
            String str5 = str2;
            TypePool.Resolution describe = this.typePool.describe(str4.replace('/', '.'));
            if (describe.isResolved()) {
                if (i12 == 183 && str5.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction5 = ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction5 = ElementMatchers.failSafe(ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) declaredMethods.filter(junction5);
                } else if (i12 == 184 || i12 == 183) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods2 = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) declaredMethods2.filter(junction);
                } else if (this.virtualPrivateCalls) {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods3 = describe.resolve().getDeclaredMethods();
                    if (this.strict) {
                        junction3 = ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    } else {
                        junction3 = ElementMatchers.failSafe(ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                    }
                    methodList = (MethodList) declaredMethods3.filter(junction3);
                    if (methodList.isEmpty()) {
                        MethodList<?> asMethodList = this.methodGraphCompiler.compile((TypeDefinition) describe.resolve(), this.instrumentedType).listNodes().asMethodList();
                        if (this.strict) {
                            junction4 = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                        } else {
                            junction4 = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                        }
                        methodList = (MethodList) asMethodList.filter(junction4);
                    }
                } else {
                    MethodList<?> asMethodList2 = this.methodGraphCompiler.compile((TypeDefinition) describe.resolve(), this.instrumentedType).listNodes().asMethodList();
                    if (this.strict) {
                        junction2 = ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3));
                    } else {
                        junction2 = ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)));
                    }
                    methodList = (MethodList) asMethodList2.filter(junction2);
                }
                if (!methodList.isEmpty()) {
                    Replacement.Binding bind = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, describe.resolve(), (MethodDescription) methodList.getOnly(), Replacement.InvocationType.b(i12, (MethodDescription) methodList.getOnly()));
                    if (bind.isBound()) {
                        int i13 = this.stackSizeBuffer;
                        if (((MethodDescription) methodList.getOnly()).isStatic() || ((MethodDescription) methodList.getOnly()).isConstructor()) {
                            generic = ((MethodDescription) methodList.getOnly()).getParameters().asTypeList();
                        } else {
                            generic = new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(describe.resolve(), ((MethodDescription) methodList.getOnly()).getParameters().asTypeList()));
                        }
                        if (((MethodDescription) methodList.getOnly()).isConstructor()) {
                            generic2 = ((MethodDescription) methodList.getOnly()).getDeclaringType().asGenericType();
                        } else {
                            generic2 = ((MethodDescription) methodList.getOnly()).getReturnType();
                        }
                        int maximalSize = bind.make(generic, generic2, getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.f27400c, (AnonymousClass1) null), this.implementationContext).getMaximalSize();
                        if (((MethodDescription) methodList.getOnly()).isConstructor()) {
                            stackSize = StackSize.SINGLE;
                        } else {
                            stackSize = ((MethodDescription) methodList.getOnly()).getReturnType().getStackSize();
                        }
                        this.stackSizeBuffer = Math.max(i13, maximalSize - stackSize.getSize());
                        if (((MethodDescription) methodList.getOnly()).isConstructor()) {
                            int i14 = this.stackSizeBuffer;
                            Duplication duplication = Duplication.SINGLE;
                            TypeDescription typeDescription = TypeDescription.OBJECT;
                            Removal removal = Removal.SINGLE;
                            this.stackSizeBuffer = Math.max(i14, new StackManipulation.Compound(duplication.flipOver(typeDescription), removal, removal, duplication.flipOver(typeDescription), removal, removal).apply(this.f27400c, this.implementationContext).getMaximalSize() + StackSize.SINGLE.getSize());
                            return;
                        }
                        return;
                    }
                } else if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str4.replace('/', '.') + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str5 + str3 + " using " + this.typePool);
                }
                String str6 = str3;
            } else {
                String str7 = str3;
                if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str4.replace('/', '.') + " using " + this.typePool);
                }
            }
            super.visitMethodInsn(i11, str, str2, str3, z11);
        }
    }

    public interface Substitution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Chain implements Substitution {
            private final Assigner assigner;
            private final List<Step> steps;
            private final Assigner.Typing typing;

            public static class Factory implements Factory {
                private final Assigner assigner;
                private final List<Step.Factory> steps;
                private final Assigner.Typing typing;

                public Factory(Assigner assigner2, Assigner.Typing typing2, List<Step.Factory> list) {
                    this.assigner = assigner2;
                    this.typing = typing2;
                    this.steps = list;
                }

                public Factory executing(Step.Factory... factoryArr) {
                    return executing((List<? extends Step.Factory>) Arrays.asList(factoryArr));
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    if (this.steps.isEmpty()) {
                        return Stubbing.INSTANCE;
                    }
                    ArrayList arrayList = new ArrayList(this.steps.size());
                    for (Step.Factory make : this.steps) {
                        arrayList.add(make.make(this.assigner, this.typing, typeDescription, methodDescription));
                    }
                    return new Chain(this.assigner, this.typing, arrayList);
                }

                public Factory executing(List<? extends Step.Factory> list) {
                    return new Factory(this.assigner, this.typing, CompoundList.of(this.steps, (List<Step.Factory>) list));
                }
            }

            public interface Step {

                public interface Factory {
                    Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription);
                }

                public interface Resolution {
                    TypeDescription.Generic getResultType();

                    StackManipulation getStackManipulation();
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements Step, Resolution, Factory {
                    private final TypeDescription.Generic resultType;
                    private final StackManipulation stackManipulation;

                    public Simple(StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                        this.stackManipulation = stackManipulation2;
                        this.resultType = generic;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.stackManipulation.equals(simple.stackManipulation) && this.resultType.equals(simple.resultType);
                    }

                    public TypeDescription.Generic getResultType() {
                        return this.resultType;
                    }

                    public StackManipulation getStackManipulation() {
                        return this.stackManipulation;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.resultType.hashCode();
                    }

                    public Step make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    public Resolution resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, Map<Integer, Integer> map, int i11) {
                        if (typeDescription.represents(Void.TYPE)) {
                            return this;
                        }
                        return new Simple(new StackManipulation.Compound(Removal.of(typeDescription), this.stackManipulation), this.resultType);
                    }
                }

                Resolution resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, Map<Integer, Integer> map, int i11);
            }

            public Chain(Assigner assigner2, Assigner.Typing typing2, List<Step> list) {
                this.assigner = assigner2;
                this.typing = typing2;
                this.steps = list;
            }

            public static Factory with(Assigner assigner2, Assigner.Typing typing2) {
                return new Factory(assigner2, typing2, Collections.emptyList());
            }

            public static Factory withDefaultAssigner() {
                return with(Assigner.DEFAULT, Assigner.Typing.STATIC);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Chain chain = (Chain) obj;
                return this.typing.equals(chain.typing) && this.assigner.equals(chain.assigner) && this.steps.equals(chain.steps);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.assigner.hashCode()) * 31) + this.typing.hashCode()) * 31) + this.steps.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                int i12 = 2;
                int size = generic.size() + 1 + (this.steps.size() * 2);
                if (generic2.represents(Void.TYPE)) {
                    i12 = 0;
                }
                ArrayList arrayList = new ArrayList(size + i12);
                HashMap hashMap = new HashMap();
                for (int size2 = generic.size() - 1; size2 >= 0; size2--) {
                    arrayList.add(MethodVariableAccess.of((TypeDefinition) generic.get(size2)).storeAt(i11));
                    hashMap.put(Integer.valueOf(size2), Integer.valueOf(i11));
                    i11 += ((TypeDescription.Generic) generic.get(size2)).getStackSize().getSize();
                }
                arrayList.add(DefaultValue.of(generic2));
                TypeDescription.Generic generic3 = generic2;
                for (Step resolve : this.steps) {
                    Step.Resolution resolve2 = resolve.resolve(typeDescription, byteCodeElement, generic, generic3, hashMap, i11);
                    arrayList.add(resolve2.getStackManipulation());
                    generic3 = resolve2.getResultType();
                }
                arrayList.add(this.assigner.assign(generic3, generic2, this.typing));
                return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
            }
        }

        public interface Factory {
            Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFieldAccess implements Substitution {
            private final FieldResolver fieldResolver;
            private final TypeDescription instrumentedType;

            public interface FieldResolver {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForElementMatcher implements FieldResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super FieldDescription> matcher;

                    public ForElementMatcher(TypeDescription typeDescription, ElementMatcher<? super FieldDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForElementMatcher forElementMatcher = (ForElementMatcher) obj;
                        return this.instrumentedType.equals(forElementMatcher.instrumentedType) && this.matcher.equals(forElementMatcher.matcher);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.matcher.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + byteCodeElement);
                        } else if (((TypeDescription.Generic) generic.get(0)).isPrimitive() || ((TypeDescription.Generic) generic.get(0)).isArray()) {
                            throw new IllegalStateException("Cannot access field on primitive or array type for " + byteCodeElement);
                        } else {
                            TypeDefinition typeDefinition = (TypeDefinition) generic.get(0);
                            do {
                                FieldList fieldList = (FieldList) typeDefinition.getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic()).and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher));
                                if (fieldList.size() == 1) {
                                    return (FieldDescription) fieldList.getOnly();
                                }
                                if (fieldList.size() <= 1) {
                                    typeDefinition = typeDefinition.getSuperClass();
                                } else {
                                    throw new IllegalStateException("Ambiguous field location of " + fieldList);
                                }
                            } while (typeDefinition != null);
                            throw new IllegalStateException("Cannot locate field matching " + this.matcher + " on " + typeDescription);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements FieldResolver {
                    private final FieldDescription fieldDescription;

                    public Simple(FieldDescription fieldDescription2) {
                        this.fieldDescription = fieldDescription2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Simple) obj).fieldDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                    }

                    public FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.fieldDescription;
                    }
                }

                FieldDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenField implements Factory {
                private final FieldDescription fieldDescription;

                public OfGivenField(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((OfGivenField) obj).fieldDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.Simple(this.fieldDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedField implements Factory {
                private final ElementMatcher<? super FieldDescription> matcher;

                public OfMatchedField(ElementMatcher<? super FieldDescription> elementMatcher) {
                    this.matcher = elementMatcher;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((OfMatchedField) obj).matcher);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matcher.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.ForElementMatcher(typeDescription, this.matcher));
                }
            }

            public ForFieldAccess(TypeDescription typeDescription, FieldResolver fieldResolver2) {
                this.instrumentedType = typeDescription;
                this.fieldResolver = fieldResolver2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForFieldAccess forFieldAccess = (ForFieldAccess) obj;
                return this.instrumentedType.equals(forFieldAccess.instrumentedType) && this.fieldResolver.equals(forFieldAccess.fieldResolver);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.fieldResolver.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                int i12;
                FieldDescription resolve = this.fieldResolver.resolve(typeDescription, byteCodeElement, generic, generic2);
                if (!resolve.isAccessibleTo(this.instrumentedType)) {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + resolve);
                } else if (generic2.represents(Void.TYPE)) {
                    int size = generic.size();
                    if (resolve.isStatic()) {
                        i12 = 1;
                    } else {
                        i12 = 2;
                    }
                    if (size != i12) {
                        throw new IllegalStateException("Cannot set " + resolve + " with " + generic);
                    } else if (!resolve.isStatic() && !((TypeDescription.Generic) generic.get(0)).asErasure().isAssignableTo(resolve.getDeclaringType().asErasure())) {
                        throw new IllegalStateException("Cannot set " + resolve + " on " + generic.get(0));
                    } else if (((TypeDescription.Generic) generic.get(resolve.isStatic() ^ true ? 1 : 0)).asErasure().isAssignableTo(resolve.getType().asErasure())) {
                        return FieldAccess.forField(resolve).write();
                    } else {
                        throw new IllegalStateException("Cannot set " + resolve + " to " + generic.get(resolve.isStatic() ^ true ? 1 : 0));
                    }
                } else if (generic.size() != (true ^ resolve.isStatic())) {
                    throw new IllegalStateException("Cannot set " + resolve + " with " + generic);
                } else if (!resolve.isStatic() && !((TypeDescription.Generic) generic.get(0)).asErasure().isAssignableTo(resolve.getDeclaringType().asErasure())) {
                    throw new IllegalStateException("Cannot get " + resolve + " on " + generic.get(0));
                } else if (resolve.getType().asErasure().isAssignableTo(generic2.asErasure())) {
                    return FieldAccess.forField(resolve).read();
                } else {
                    throw new IllegalStateException("Cannot get " + resolve + " as " + generic2);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodInvocation implements Substitution {
            private static final int THIS_REFERENCE = 0;
            private final TypeDescription instrumentedType;
            private final MethodResolver methodResolver;

            public interface MethodResolver {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Matching implements MethodResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super MethodDescription> matcher;
                    private final MethodGraph.Compiler methodGraphCompiler;

                    public Matching(TypeDescription typeDescription, MethodGraph.Compiler compiler, ElementMatcher<? super MethodDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.methodGraphCompiler = compiler;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Matching matching = (Matching) obj;
                        return this.instrumentedType.equals(matching.instrumentedType) && this.methodGraphCompiler.equals(matching.methodGraphCompiler) && this.matcher.equals(matching.matcher);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.matcher.hashCode();
                    }

                    public MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + byteCodeElement);
                        } else if (((TypeDescription.Generic) generic.get(0)).isPrimitive() || ((TypeDescription.Generic) generic.get(0)).isArray()) {
                            throw new IllegalStateException("Cannot invoke method on primitive or array type for " + byteCodeElement);
                        } else {
                            TypeDefinition typeDefinition = (TypeDefinition) generic.get(0);
                            List of2 = CompoundList.of(this.methodGraphCompiler.compile(typeDefinition, this.instrumentedType).listNodes().asMethodList().filter(this.matcher), (FilterableList) typeDefinition.getDeclaredMethods().filter(ElementMatchers.isPrivate().and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher)));
                            if (of2.size() == 1) {
                                return (MethodDescription) of2.get(0);
                            }
                            throw new IllegalStateException("Not exactly one method that matches " + this.matcher + ": " + of2);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements MethodResolver {
                    private final MethodDescription methodDescription;

                    public Simple(MethodDescription methodDescription2) {
                        this.methodDescription = methodDescription2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Simple) obj).methodDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                    }

                    public MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.methodDescription;
                    }
                }

                MethodDescription resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenMethod implements Factory {
                private final MethodDescription methodDescription;

                public OfGivenMethod(MethodDescription methodDescription2) {
                    this.methodDescription = methodDescription2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((OfGivenMethod) obj).methodDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription2, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(this.methodDescription));
                }
            }

            public enum OfInstrumentedMethod implements Factory {
                INSTANCE;

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(methodDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedMethod implements Factory {
                private final ElementMatcher<? super MethodDescription> matcher;
                private final MethodGraph.Compiler methodGraphCompiler;

                public OfMatchedMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
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
                    OfMatchedMethod ofMatchedMethod = (OfMatchedMethod) obj;
                    return this.matcher.equals(ofMatchedMethod.matcher) && this.methodGraphCompiler.equals(ofMatchedMethod.methodGraphCompiler);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.methodGraphCompiler.hashCode();
                }

                public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Matching(typeDescription, this.methodGraphCompiler, this.matcher));
                }
            }

            public ForMethodInvocation(TypeDescription typeDescription, MethodResolver methodResolver2) {
                this.instrumentedType = typeDescription;
                this.methodResolver = methodResolver2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodInvocation forMethodInvocation = (ForMethodInvocation) obj;
                return this.instrumentedType.equals(forMethodInvocation.instrumentedType) && this.methodResolver.equals(forMethodInvocation.methodResolver);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.methodResolver.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                List list;
                MethodDescription resolve = this.methodResolver.resolve(typeDescription, byteCodeElement, generic, generic2);
                if (resolve.isAccessibleTo(this.instrumentedType)) {
                    if (resolve.isStatic()) {
                        list = resolve.getParameters().asTypeList();
                    } else {
                        list = new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(resolve.getDeclaringType(), resolve.getParameters().asTypeList()));
                    }
                    if (!resolve.getReturnType().asErasure().isAssignableTo(generic2.asErasure())) {
                        throw new IllegalStateException("Cannot assign return value of " + resolve + " to " + generic2);
                    } else if (list.size() == generic.size()) {
                        int i12 = 0;
                        while (i12 < list.size()) {
                            if (((TypeDescription.Generic) generic.get(i12)).asErasure().isAssignableTo(((TypeDescription.Generic) list.get(i12)).asErasure())) {
                                i12++;
                            } else {
                                throw new IllegalStateException("Cannot invoke " + resolve + " on parameter " + i12 + " of type " + generic.get(i12));
                            }
                        }
                        if (resolve.isVirtual()) {
                            return MethodInvocation.invoke(resolve).virtual(((TypeDescription.Generic) list.get(0)).asErasure());
                        }
                        return MethodInvocation.invoke(resolve);
                    } else {
                        throw new IllegalStateException("Cannot invoke " + resolve + " on " + generic.size() + " parameters");
                    }
                } else {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + resolve);
                }
            }
        }

        public enum Stubbing implements Substitution, Factory {
            INSTANCE;

            public Substitution make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            public StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, int i11) {
                ArrayList arrayList = new ArrayList(generic.size());
                for (int size = generic.size() - 1; size >= 0; size--) {
                    arrayList.add(Removal.of((TypeDefinition) generic.get(size)));
                }
                return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(arrayList, DefaultValue.of(generic2.asErasure())));
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, ByteCodeElement byteCodeElement, TypeList.Generic generic, TypeDescription.Generic generic2, int i11);
    }

    public interface TypePoolResolver {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForClassFileLocator implements TypePoolResolver {
            private final ClassFileLocator classFileLocator;
            private final TypePool.Default.ReaderMode readerMode;

            public ForClassFileLocator(ClassFileLocator classFileLocator2) {
                this(classFileLocator2, TypePool.Default.ReaderMode.FAST);
            }

            public static TypePoolResolver of(ClassLoader classLoader) {
                return new ForClassFileLocator(ClassFileLocator.ForClassLoader.of(classLoader));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForClassFileLocator forClassFileLocator = (ForClassFileLocator) obj;
                return this.readerMode.equals(forClassFileLocator.readerMode) && this.classFileLocator.equals(forClassFileLocator.classFileLocator);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.classFileLocator.hashCode()) * 31) + this.readerMode.hashCode();
            }

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return new TypePool.Default(new TypePool.CacheProvider.Simple(), this.classFileLocator, this.readerMode, typePool);
            }

            public ForClassFileLocator(ClassFileLocator classFileLocator2, TypePool.Default.ReaderMode readerMode2) {
                this.classFileLocator = classFileLocator2;
                this.readerMode = readerMode2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExplicitPool implements TypePoolResolver {
            private final TypePool typePool;

            public ForExplicitPool(TypePool typePool2) {
                this.typePool = typePool2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typePool.equals(((ForExplicitPool) obj).typePool);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typePool.hashCode();
            }

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool2) {
                return this.typePool;
            }
        }

        public enum OfImplicitPool implements TypePoolResolver {
            INSTANCE;

            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return typePool;
            }
        }

        TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class WithoutSpecification {

        /* renamed from: a  reason: collision with root package name */
        public final MethodGraph.Compiler f27078a;

        /* renamed from: b  reason: collision with root package name */
        public final TypePoolResolver f27079b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f27080c;

        /* renamed from: d  reason: collision with root package name */
        public final Replacement.Factory f27081d;

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedByteCodeElement extends WithoutSpecification {
            private final ElementMatcher<? super ByteCodeElement> matcher;

            public ForMatchedByteCodeElement(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory, ElementMatcher<? super ByteCodeElement> elementMatcher) {
                super(compiler, typePoolResolver, z11, factory);
                this.matcher = elementMatcher;
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ForMatchedByteCodeElement) obj).matcher);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.matcher.hashCode();
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.f27078a, this.f27079b, this.f27080c, new Replacement.Factory.Compound(this.f27081d, Replacement.ForElementMatchers.Factory.a(this.matcher, factory)));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedField extends WithoutSpecification {
            private final boolean matchRead;
            private final boolean matchWrite;
            private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;

            public ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
                this(compiler, typePoolResolver, z11, factory, elementMatcher, true, true);
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
                ForMatchedField forMatchedField = (ForMatchedField) obj;
                return this.matchRead == forMatchedField.matchRead && this.matchWrite == forMatchedField.matchWrite && this.matcher.equals(forMatchedField.matcher);
            }

            public int hashCode() {
                return (((((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.matchRead ? 1 : 0)) * 31) + (this.matchWrite ? 1 : 0);
            }

            public WithoutSpecification onRead() {
                return new ForMatchedField(this.f27078a, this.f27079b, this.f27080c, this.f27081d, this.matcher, true, false);
            }

            public WithoutSpecification onWrite() {
                return new ForMatchedField(this.f27078a, this.f27079b, this.f27080c, this.f27081d, this.matcher, false, true);
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.f27078a, this.f27079b, this.f27080c, new Replacement.Factory.Compound(this.f27081d, Replacement.ForElementMatchers.Factory.b(this.matcher, this.matchRead, this.matchWrite, factory)));
            }

            public ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, boolean z12, boolean z13) {
                super(compiler, typePoolResolver, z11, factory);
                this.matcher = elementMatcher;
                this.matchRead = z12;
                this.matchWrite = z13;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedMethod extends WithoutSpecification {
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final ElementMatcher<? super MethodDescription> matcher;

            public ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher) {
                this(compiler, typePoolResolver, z11, factory, elementMatcher, true, true);
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
                ForMatchedMethod forMatchedMethod = (ForMatchedMethod) obj;
                return this.includeVirtualCalls == forMatchedMethod.includeVirtualCalls && this.includeSuperCalls == forMatchedMethod.includeSuperCalls && this.matcher.equals(forMatchedMethod.matcher);
            }

            public int hashCode() {
                return (((((super.hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0);
            }

            public WithoutSpecification onSuperCall() {
                return new ForMatchedMethod(this.f27078a, this.f27079b, this.f27080c, this.f27081d, ElementMatchers.isVirtual().and(this.matcher), false, true);
            }

            public WithoutSpecification onVirtualCall() {
                return new ForMatchedMethod(this.f27078a, this.f27079b, this.f27080c, this.f27081d, ElementMatchers.isVirtual().and(this.matcher), true, false);
            }

            public MemberSubstitution replaceWith(Substitution.Factory factory) {
                return new MemberSubstitution(this.f27078a, this.f27079b, this.f27080c, new Replacement.Factory.Compound(this.f27081d, Replacement.ForElementMatchers.Factory.c(this.matcher, this.includeVirtualCalls, this.includeSuperCalls, factory)));
            }

            public ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher, boolean z12, boolean z13) {
                super(compiler, typePoolResolver, z11, factory);
                this.matcher = elementMatcher;
                this.includeVirtualCalls = z12;
                this.includeSuperCalls = z13;
            }
        }

        public WithoutSpecification(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z11, Replacement.Factory factory) {
            this.f27078a = compiler;
            this.f27079b = typePoolResolver;
            this.f27080c = z11;
            this.f27081d = factory;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithoutSpecification withoutSpecification = (WithoutSpecification) obj;
            return this.f27080c == withoutSpecification.f27080c && this.f27078a.equals(withoutSpecification.f27078a) && this.f27079b.equals(withoutSpecification.f27079b) && this.f27081d.equals(withoutSpecification.f27081d);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.f27078a.hashCode()) * 31) + this.f27079b.hashCode()) * 31) + (this.f27080c ? 1 : 0)) * 31) + this.f27081d.hashCode();
        }

        public MemberSubstitution replaceWith(Field field) {
            return replaceWith((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public abstract MemberSubstitution replaceWith(Substitution.Factory factory);

        public MemberSubstitution replaceWithChain(Substitution.Chain.Step.Factory... factoryArr) {
            return replaceWithChain((List<? extends Substitution.Chain.Step.Factory>) Arrays.asList(factoryArr));
        }

        public MemberSubstitution replaceWithField(ElementMatcher<? super FieldDescription> elementMatcher) {
            return replaceWith((Substitution.Factory) new Substitution.ForFieldAccess.OfMatchedField(elementMatcher));
        }

        public MemberSubstitution replaceWithInstrumentedMethod() {
            return replaceWith((Substitution.Factory) Substitution.ForMethodInvocation.OfInstrumentedMethod.INSTANCE);
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher) {
            return replaceWithMethod(elementMatcher, this.f27078a);
        }

        public MemberSubstitution stub() {
            return replaceWith((Substitution.Factory) Substitution.Stubbing.INSTANCE);
        }

        public MemberSubstitution replaceWith(FieldDescription fieldDescription) {
            return replaceWith((Substitution.Factory) new Substitution.ForFieldAccess.OfGivenField(fieldDescription));
        }

        public MemberSubstitution replaceWithChain(List<? extends Substitution.Chain.Step.Factory> list) {
            return replaceWith((Substitution.Factory) Substitution.Chain.withDefaultAssigner().executing(list));
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
            return replaceWith((Substitution.Factory) new Substitution.ForMethodInvocation.OfMatchedMethod(elementMatcher, compiler));
        }

        public MemberSubstitution replaceWith(Method method) {
            return replaceWith((MethodDescription) new MethodDescription.ForLoadedMethod(method));
        }

        public MemberSubstitution replaceWith(MethodDescription methodDescription) {
            if (methodDescription.isMethod()) {
                return replaceWith((Substitution.Factory) new Substitution.ForMethodInvocation.OfGivenMethod(methodDescription));
            }
            throw new IllegalArgumentException("Cannot use " + methodDescription + " as a replacement");
        }
    }

    public MemberSubstitution(boolean z11) {
        this(MethodGraph.Compiler.DEFAULT, TypePoolResolver.OfImplicitPool.INSTANCE, z11, Replacement.NoOp.INSTANCE);
    }

    public static MemberSubstitution relaxed() {
        return new MemberSubstitution(false);
    }

    public static MemberSubstitution strict() {
        return new MemberSubstitution(true);
    }

    public WithoutSpecification constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
        return invokable(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public WithoutSpecification element(ElementMatcher<? super ByteCodeElement> elementMatcher) {
        return new WithoutSpecification.ForMatchedByteCodeElement(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberSubstitution memberSubstitution = (MemberSubstitution) obj;
        return this.strict == memberSubstitution.strict && this.methodGraphCompiler.equals(memberSubstitution.methodGraphCompiler) && this.typePoolResolver.equals(memberSubstitution.typePoolResolver) && this.replacementFactory.equals(memberSubstitution.replacementFactory);
    }

    public WithoutSpecification.ForMatchedField field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new WithoutSpecification.ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.methodGraphCompiler.hashCode()) * 31) + (this.strict ? 1 : 0)) * 31) + this.typePoolResolver.hashCode()) * 31) + this.replacementFactory.hashCode();
    }

    public WithoutSpecification invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public WithoutSpecification.ForMatchedMethod method(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.replacementFactory, elementMatcher);
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    public MemberSubstitution with(MethodGraph.Compiler compiler) {
        return new MemberSubstitution(compiler, this.typePoolResolver, this.strict, this.replacementFactory);
    }

    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
        TypePool resolve = this.typePoolResolver.resolve(typeDescription, methodDescription, typePool);
        return new SubstitutingMethodVisitor(methodVisitor, typeDescription, methodDescription, this.methodGraphCompiler, this.strict, this.replacementFactory.make(typeDescription, methodDescription, resolve), context, resolve, context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11));
    }

    public MemberSubstitution(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver2, boolean z11, Replacement.Factory factory) {
        this.methodGraphCompiler = compiler;
        this.typePoolResolver = typePoolResolver2;
        this.strict = z11;
        this.replacementFactory = factory;
    }

    public MemberSubstitution with(TypePoolResolver typePoolResolver2) {
        return new MemberSubstitution(this.methodGraphCompiler, typePoolResolver2, this.strict, this.replacementFactory);
    }
}
