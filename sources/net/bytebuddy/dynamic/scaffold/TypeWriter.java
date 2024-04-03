package net.bytebuddy.dynamic.scaffold;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.dynamic.scaffold.inline.RebaseImplementationTarget;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.jar.asm.commons.SimpleRemapper;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import net.bytebuddy.utility.visitor.FramePaddingMethodVisitor;
import net.bytebuddy.utility.visitor.MetadataAwareClassVisitor;

public interface TypeWriter<T> {
    public static final String DUMP_PROPERTY = "net.bytebuddy.dump";

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class Default<S> implements TypeWriter<S> {
        private static final boolean ACCESS_CONTROLLER;
        /* access modifiers changed from: private */
        public static final String NO_REFERENCE = null;

        /* renamed from: u  reason: collision with root package name */
        public static final String f27206u;

        /* renamed from: a  reason: collision with root package name */
        public final TypeDescription f27207a;

        /* renamed from: b  reason: collision with root package name */
        public final ClassFileVersion f27208b;

        /* renamed from: c  reason: collision with root package name */
        public final FieldPool f27209c;

        /* renamed from: d  reason: collision with root package name */
        public final RecordComponentPool f27210d;

        /* renamed from: e  reason: collision with root package name */
        public final List<? extends DynamicType> f27211e;

        /* renamed from: f  reason: collision with root package name */
        public final FieldList<FieldDescription.InDefinedShape> f27212f;

        /* renamed from: g  reason: collision with root package name */
        public final MethodList<?> f27213g;

        /* renamed from: h  reason: collision with root package name */
        public final MethodList<?> f27214h;

        /* renamed from: i  reason: collision with root package name */
        public final RecordComponentList<RecordComponentDescription.InDefinedShape> f27215i;

        /* renamed from: j  reason: collision with root package name */
        public final LoadedTypeInitializer f27216j;

        /* renamed from: k  reason: collision with root package name */
        public final TypeInitializer f27217k;

        /* renamed from: l  reason: collision with root package name */
        public final TypeAttributeAppender f27218l;

        /* renamed from: m  reason: collision with root package name */
        public final AsmVisitorWrapper f27219m;

        /* renamed from: n  reason: collision with root package name */
        public final AnnotationValueFilter.Factory f27220n;

        /* renamed from: o  reason: collision with root package name */
        public final AnnotationRetention f27221o;

        /* renamed from: p  reason: collision with root package name */
        public final AuxiliaryType.NamingStrategy f27222p;

        /* renamed from: q  reason: collision with root package name */
        public final Implementation.Context.Factory f27223q;

        /* renamed from: r  reason: collision with root package name */
        public final TypeValidation f27224r;

        /* renamed from: s  reason: collision with root package name */
        public final ClassWriterStrategy f27225s;

        /* renamed from: t  reason: collision with root package name */
        public final TypePool f27226t;

        @HashCodeAndEqualsPlugin.Enhance
        public static class ClassDumpAction implements PrivilegedExceptionAction<Void> {
            private static final Void NOTHING = null;
            private final byte[] binaryRepresentation;
            private final TypeDescription instrumentedType;
            private final boolean original;
            private final long suffix;
            private final String target;

            public interface Dispatcher {

                public enum Disabled implements Dispatcher {
                    INSTANCE;

                    public void dump(TypeDescription typeDescription, boolean z11, byte[] bArr) {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Dispatcher {
                    private final String folder;
                    private final long timestamp;

                    public Enabled(String str, long j11) {
                        this.folder = str;
                        this.timestamp = j11;
                    }

                    public void dump(TypeDescription typeDescription, boolean z11, byte[] bArr) {
                        try {
                            Object unused = Default.doPrivileged(new ClassDumpAction(this.folder, typeDescription, z11, this.timestamp, bArr));
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Enabled enabled = (Enabled) obj;
                        return this.timestamp == enabled.timestamp && this.folder.equals(enabled.folder);
                    }

                    public int hashCode() {
                        long j11 = this.timestamp;
                        return (((getClass().hashCode() * 31) + this.folder.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)));
                    }
                }

                void dump(TypeDescription typeDescription, boolean z11, byte[] bArr);
            }

            public ClassDumpAction(String str, TypeDescription typeDescription, boolean z11, long j11, byte[] bArr) {
                this.target = str;
                this.instrumentedType = typeDescription;
                this.original = z11;
                this.suffix = j11;
                this.binaryRepresentation = bArr;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ClassDumpAction classDumpAction = (ClassDumpAction) obj;
                return this.original == classDumpAction.original && this.suffix == classDumpAction.suffix && this.target.equals(classDumpAction.target) && this.instrumentedType.equals(classDumpAction.instrumentedType) && Arrays.equals(this.binaryRepresentation, classDumpAction.binaryRepresentation);
            }

            public int hashCode() {
                long j11 = this.suffix;
                return (((((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + (this.original ? 1 : 0)) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            public Void run() throws Exception {
                String str = this.target;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.instrumentedType.getName());
                sb2.append(this.original ? "-original." : RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                sb2.append(this.suffix);
                sb2.append(".class");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str, sb2.toString()));
                try {
                    fileOutputStream.write(this.binaryRepresentation);
                    return NOTHING;
                } finally {
                    fileOutputStream.close();
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForCreation<U> extends Default<U> {
            private final MethodPool methodPool;

            public ForCreation(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, MethodPool methodPool2, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.methodPool = methodPool2;
            }

            public Default<U>.UnresolvedType c(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                TypeDescription typeDescription;
                String str;
                String str2;
                int mergeWriter = this.f27219m.mergeWriter(0);
                ClassWriter resolve = this.f27225s.resolve(mergeWriter, this.f27226t);
                Implementation.Context.Factory factory = this.f27223q;
                TypeDescription typeDescription2 = this.f27207a;
                AuxiliaryType.NamingStrategy namingStrategy = this.f27222p;
                ClassFileVersion classFileVersion = this.f27208b;
                Implementation.Context.ExtractableView make = factory.make(typeDescription2, namingStrategy, typeInitializer, classFileVersion, classFileVersion);
                ClassVisitor wrap = this.f27219m.wrap(this.f27207a, ValidatingClassVisitor.b(resolve, this.f27224r), make, this.f27226t, this.f27212f, this.f27213g, mergeWriter, this.f27219m.mergeReader(0));
                int minorMajorVersion = this.f27208b.getMinorMajorVersion();
                TypeDescription typeDescription3 = this.f27207a;
                int actualModifiers = typeDescription3.getActualModifiers(!typeDescription3.isInterface());
                String internalName = this.f27207a.getInternalName();
                String genericSignature = this.f27207a.getGenericSignature();
                if (this.f27207a.getSuperClass() == null) {
                    typeDescription = TypeDescription.OBJECT;
                } else {
                    typeDescription = this.f27207a.getSuperClass().asErasure();
                }
                wrap.visit(minorMajorVersion, actualModifiers, internalName, genericSignature, typeDescription.getInternalName(), this.f27207a.getInterfaces().asErasures().toInternalNames());
                if (!this.f27207a.isNestHost()) {
                    wrap.visitNestHost(this.f27207a.getNestHost().getInternalName());
                }
                MethodDescription.InDefinedShape enclosingMethod = this.f27207a.getEnclosingMethod();
                if (enclosingMethod != null) {
                    wrap.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                } else if (this.f27207a.isLocalType() || this.f27207a.isAnonymousType()) {
                    wrap.visitOuterClass(this.f27207a.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                }
                TypeAttributeAppender typeAttributeAppender = this.f27218l;
                TypeDescription typeDescription4 = this.f27207a;
                typeAttributeAppender.apply(wrap, typeDescription4, this.f27220n.on(typeDescription4));
                if (this.f27207a.isNestHost()) {
                    for (TypeDescription internalName2 : (TypeList) this.f27207a.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is((Object) this.f27207a)))) {
                        wrap.visitNestMember(internalName2.getInternalName());
                    }
                }
                for (TypeDescription internalName3 : this.f27207a.getPermittedSubtypes()) {
                    wrap.visitPermittedSubclass(internalName3.getInternalName());
                }
                TypeDescription declaringType = this.f27207a.getDeclaringType();
                if (declaringType != null) {
                    wrap.visitInnerClass(this.f27207a.getInternalName(), declaringType.getInternalName(), this.f27207a.getSimpleName(), this.f27207a.getModifiers());
                } else if (this.f27207a.isLocalType()) {
                    wrap.visitInnerClass(this.f27207a.getInternalName(), Default.NO_REFERENCE, this.f27207a.getSimpleName(), this.f27207a.getModifiers());
                } else if (this.f27207a.isAnonymousType()) {
                    wrap.visitInnerClass(this.f27207a.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, this.f27207a.getModifiers());
                }
                for (TypeDescription typeDescription5 : this.f27207a.getDeclaredTypes()) {
                    String internalName4 = typeDescription5.getInternalName();
                    if (typeDescription5.isMemberType()) {
                        str = this.f27207a.getInternalName();
                    } else {
                        str = Default.NO_REFERENCE;
                    }
                    if (typeDescription5.isAnonymousType()) {
                        str2 = Default.NO_REFERENCE;
                    } else {
                        str2 = typeDescription5.getSimpleName();
                    }
                    wrap.visitInnerClass(internalName4, str, str2, typeDescription5.getModifiers());
                }
                for (RecordComponentDescription target : this.f27215i) {
                    this.f27210d.target(target).apply(wrap, this.f27220n);
                }
                for (FieldDescription target2 : this.f27212f) {
                    this.f27209c.target(target2).apply(wrap, this.f27220n);
                }
                Iterator<E> it = this.f27214h.iterator();
                while (it.hasNext()) {
                    this.methodPool.target((MethodDescription) it.next()).apply(wrap, make, this.f27220n);
                }
                make.drain(new TypeInitializer.Drain.Default(this.f27207a, this.methodPool, this.f27220n), wrap, this.f27220n);
                wrap.visitEnd();
                return new UnresolvedType(resolve.toByteArray(), make.getAuxiliaryTypes());
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodPool.equals(((ForCreation) obj).methodPool);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.methodPool.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForInlining<U> extends Default<U> {
            /* access modifiers changed from: private */
            public static final AnnotationVisitor IGNORE_ANNOTATION = null;
            /* access modifiers changed from: private */
            public static final FieldVisitor IGNORE_FIELD = null;
            /* access modifiers changed from: private */
            public static final MethodVisitor IGNORE_METHOD = null;
            /* access modifiers changed from: private */
            public static final RecordComponentVisitor IGNORE_RECORD_COMPONENT = null;

            /* renamed from: v  reason: collision with root package name */
            public final TypeDescription f27227v;

            /* renamed from: w  reason: collision with root package name */
            public final ClassFileLocator f27228w;

            public static class ContextRegistry {
                private Implementation.Context.ExtractableView implementationContext;

                @SuppressFBWarnings(justification = "Lazy value definition is intended", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public List<DynamicType> getAuxiliaryTypes() {
                    return this.implementationContext.getAuxiliaryTypes();
                }

                public void setImplementationContext(Implementation.Context.ExtractableView extractableView) {
                    this.implementationContext = extractableView;
                }
            }

            public static class WithDecorationOnly<V> extends ForInlining<V> {

                @SuppressFBWarnings(justification = "Field access order is implied by ASM", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public class DecorationClassVisitor extends MetadataAwareClassVisitor implements TypeInitializer.Drain {
                    private final ContextRegistry contextRegistry;
                    private Implementation.Context.ExtractableView implementationContext;
                    private final int readerFlags;
                    private final int writerFlags;

                    public DecorationClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry2, int i11, int i12) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.contextRegistry = contextRegistry2;
                        this.writerFlags = i11;
                        this.readerFlags = i12;
                    }

                    public void a() {
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        TypeAttributeAppender typeAttributeAppender = withDecorationOnly.f27218l;
                        ClassVisitor classVisitor = this.f27354c;
                        TypeDescription typeDescription = withDecorationOnly.f27207a;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withDecorationOnly.f27220n.on(typeDescription));
                    }

                    public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                    }

                    public AnnotationVisitor d(String str, boolean z11) {
                        if (WithDecorationOnly.this.f27221o.isEnabled()) {
                            return this.f27354c.visitAnnotation(str, z11);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    public void f() {
                        this.implementationContext.drain(this, this.f27354c, WithDecorationOnly.this.f27220n);
                        this.f27354c.visitEnd();
                    }

                    public AnnotationVisitor o(int i11, TypePath typePath, String str, boolean z11) {
                        if (WithDecorationOnly.this.f27221o.isEnabled()) {
                            return this.f27354c.visitTypeAnnotation(i11, typePath, str, z11);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
                        ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i11);
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        Implementation.Context.ExtractableView make = withDecorationOnly.f27223q.make(withDecorationOnly.f27207a, withDecorationOnly.f27222p, withDecorationOnly.f27217k, ofMinorMajor, withDecorationOnly.f27208b);
                        this.implementationContext = make;
                        this.contextRegistry.setImplementationContext(make);
                        WithDecorationOnly withDecorationOnly2 = WithDecorationOnly.this;
                        ClassVisitor wrap = withDecorationOnly2.f27219m.wrap(withDecorationOnly2.f27207a, this.f27354c, this.implementationContext, withDecorationOnly2.f27226t, withDecorationOnly2.f27212f, withDecorationOnly2.f27213g, this.writerFlags, this.readerFlags);
                        this.f27354c = wrap;
                        wrap.visit(i11, i12, str, str2, str3, strArr);
                    }
                }

                public static class LazyFieldList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                    private final TypeDescription instrumentedType;

                    public LazyFieldList(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    public int size() {
                        return this.instrumentedType.getDeclaredFields().size();
                    }

                    public FieldDescription.InDefinedShape get(int i11) {
                        return (FieldDescription.InDefinedShape) this.instrumentedType.getDeclaredFields().get(i11);
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public WithDecorationOnly(net.bytebuddy.description.type.TypeDescription r24, net.bytebuddy.ClassFileVersion r25, java.util.List<? extends net.bytebuddy.dynamic.DynamicType> r26, net.bytebuddy.description.method.MethodList<?> r27, net.bytebuddy.implementation.attribute.TypeAttributeAppender r28, net.bytebuddy.asm.AsmVisitorWrapper r29, net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory r30, net.bytebuddy.implementation.attribute.AnnotationRetention r31, net.bytebuddy.implementation.auxiliary.AuxiliaryType.NamingStrategy r32, net.bytebuddy.implementation.Implementation.Context.Factory r33, net.bytebuddy.dynamic.scaffold.TypeValidation r34, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy r35, net.bytebuddy.pool.TypePool r36, net.bytebuddy.dynamic.ClassFileLocator r37) {
                    /*
                        r23 = this;
                        r0 = r23
                        r1 = r24
                        r21 = r24
                        r2 = r25
                        r5 = r26
                        r7 = r27
                        r12 = r28
                        r13 = r29
                        r14 = r30
                        r15 = r31
                        r16 = r32
                        r17 = r33
                        r18 = r34
                        r19 = r35
                        r20 = r36
                        r22 = r37
                        net.bytebuddy.dynamic.scaffold.TypeWriter$FieldPool$Disabled r3 = net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Disabled.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeWriter$RecordComponentPool$Disabled r4 = net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Disabled.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeWriter$Default$ForInlining$WithDecorationOnly$LazyFieldList r8 = new net.bytebuddy.dynamic.scaffold.TypeWriter$Default$ForInlining$WithDecorationOnly$LazyFieldList
                        r6 = r8
                        r9 = r24
                        r8.<init>(r9)
                        net.bytebuddy.description.method.MethodList$Empty r9 = new net.bytebuddy.description.method.MethodList$Empty
                        r8 = r9
                        r9.<init>()
                        net.bytebuddy.description.type.RecordComponentList$Empty r10 = new net.bytebuddy.description.type.RecordComponentList$Empty
                        r9 = r10
                        r10.<init>()
                        net.bytebuddy.implementation.LoadedTypeInitializer$NoOp r10 = net.bytebuddy.implementation.LoadedTypeInitializer.NoOp.INSTANCE
                        net.bytebuddy.dynamic.scaffold.TypeInitializer$None r11 = net.bytebuddy.dynamic.scaffold.TypeInitializer.None.INSTANCE
                        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithDecorationOnly.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.ClassFileVersion, java.util.List, net.bytebuddy.description.method.MethodList, net.bytebuddy.implementation.attribute.TypeAttributeAppender, net.bytebuddy.asm.AsmVisitorWrapper, net.bytebuddy.implementation.attribute.AnnotationValueFilter$Factory, net.bytebuddy.implementation.attribute.AnnotationRetention, net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy, net.bytebuddy.implementation.Implementation$Context$Factory, net.bytebuddy.dynamic.scaffold.TypeValidation, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy, net.bytebuddy.pool.TypePool, net.bytebuddy.dynamic.ClassFileLocator):void");
                }

                public ClassVisitor h(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i11, int i12) {
                    if (!typeInitializer.isDefined()) {
                        return new DecorationClassVisitor(classVisitor, contextRegistry, i11, i12);
                    }
                    throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithFullProcessing<V> extends ForInlining<V> {
                /* access modifiers changed from: private */
                public final Implementation.Target.Factory implementationTargetFactory;
                /* access modifiers changed from: private */
                public final MethodRebaseResolver methodRebaseResolver;
                /* access modifiers changed from: private */
                public final MethodRegistry.Prepared methodRegistry;

                public interface InitializationHandler {

                    public static abstract class Appending extends MethodVisitor implements InitializationHandler, TypeInitializer.Drain {

                        /* renamed from: d  reason: collision with root package name */
                        public final TypeDescription f27230d;

                        /* renamed from: e  reason: collision with root package name */
                        public final MethodPool.Record f27231e;

                        /* renamed from: f  reason: collision with root package name */
                        public final AnnotationValueFilter.Factory f27232f;

                        /* renamed from: g  reason: collision with root package name */
                        public final FrameWriter f27233g;

                        /* renamed from: h  reason: collision with root package name */
                        public int f27234h;

                        /* renamed from: i  reason: collision with root package name */
                        public int f27235i;

                        public interface FrameWriter {
                            public static final Object[] EMPTY = new Object[0];

                            public static class Active implements FrameWriter {
                                private int currentLocalVariableLength;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                    int i11 = this.currentLocalVariableLength;
                                    if (i11 == 0) {
                                        Object[] objArr = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                                    } else if (i11 > 3) {
                                        Object[] objArr2 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(0, objArr2.length, objArr2, objArr2.length, objArr2);
                                    } else {
                                        Object[] objArr3 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(2, i11, objArr3, objArr3.length, objArr3);
                                    }
                                    this.currentLocalVariableLength = 0;
                                }

                                public void onFrame(int i11, int i12) {
                                    if (i11 == -1 || i11 == 0) {
                                        this.currentLocalVariableLength = i12;
                                    } else if (i11 == 1) {
                                        this.currentLocalVariableLength += i12;
                                    } else if (i11 == 2) {
                                        this.currentLocalVariableLength -= i12;
                                    } else if (i11 != 3 && i11 != 4) {
                                        throw new IllegalStateException("Unexpected frame type: " + i11);
                                    }
                                }
                            }

                            public enum Expanding implements FrameWriter {
                                INSTANCE;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                    Object[] objArr = FrameWriter.EMPTY;
                                    methodVisitor.visitFrame(-1, objArr.length, objArr, objArr.length, objArr);
                                }

                                public void onFrame(int i11, int i12) {
                                }
                            }

                            public enum NoOp implements FrameWriter {
                                INSTANCE;

                                public void emitFrame(MethodVisitor methodVisitor) {
                                }

                                public void onFrame(int i11, int i12) {
                                }
                            }

                            void emitFrame(MethodVisitor methodVisitor);

                            void onFrame(int i11, int i12);
                        }

                        public static abstract class WithDrain extends Appending {

                            /* renamed from: j  reason: collision with root package name */
                            public final Label f27236j = new Label();

                            /* renamed from: k  reason: collision with root package name */
                            public final Label f27237k = new Label();

                            public static class WithActiveRecord extends WithDrain {
                                private final Label label = new Label();

                                public WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                                    super(methodVisitor, typeDescription, record, factory, z11, z12);
                                }

                                public void d(Implementation.Context context) {
                                    this.f27400c.visitLabel(this.label);
                                    this.f27233g.emitFrame(this.f27400c);
                                    ByteCodeAppender.Size applyCode = this.f27231e.applyCode(this.f27400c, context);
                                    this.f27234h = Math.max(this.f27234h, applyCode.getOperandStackSize());
                                    this.f27235i = Math.max(this.f27235i, applyCode.getLocalVariableSize());
                                }

                                public void visitInsn(int i11) {
                                    if (i11 == 177) {
                                        this.f27400c.visitJumpInsn(Opcodes.GOTO, this.label);
                                    } else {
                                        super.visitInsn(i11);
                                    }
                                }
                            }

                            public static class WithoutActiveRecord extends WithDrain {
                                public WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                                    super(methodVisitor, typeDescription, record, factory, z11, z12);
                                }

                                public void d(Implementation.Context context) {
                                }
                            }

                            public WithDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                                super(new FramePaddingMethodVisitor(methodVisitor), typeDescription, record, factory, z11, z12);
                            }

                            public void b(Implementation.Context context) {
                                this.f27400c.visitJumpInsn(Opcodes.GOTO, this.f27237k);
                                d(context);
                            }

                            public void c() {
                                this.f27400c.visitJumpInsn(Opcodes.GOTO, this.f27236j);
                                this.f27400c.visitLabel(this.f27237k);
                                this.f27233g.emitFrame(this.f27400c);
                            }

                            public abstract void d(Implementation.Context context);

                            public void visitEnd() {
                                this.f27400c.visitLabel(this.f27236j);
                                this.f27233g.emitFrame(this.f27400c);
                            }
                        }

                        public static abstract class WithoutDrain extends Appending {

                            public static class WithActiveRecord extends WithoutDrain {
                                private final Label label = new Label();

                                public WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                                    super(methodVisitor, typeDescription, record, factory, z11, z12);
                                }

                                public void b(Implementation.Context context) {
                                    this.f27400c.visitLabel(this.label);
                                    this.f27233g.emitFrame(this.f27400c);
                                    ByteCodeAppender.Size applyCode = this.f27231e.applyCode(this.f27400c, context);
                                    this.f27234h = Math.max(this.f27234h, applyCode.getOperandStackSize());
                                    this.f27235i = Math.max(this.f27235i, applyCode.getLocalVariableSize());
                                }

                                public void visitInsn(int i11) {
                                    if (i11 == 177) {
                                        this.f27400c.visitJumpInsn(Opcodes.GOTO, this.label);
                                    } else {
                                        super.visitInsn(i11);
                                    }
                                }
                            }

                            public static class WithoutActiveRecord extends WithoutDrain {
                                public WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory) {
                                    super(methodVisitor, typeDescription, record, factory, false, false);
                                }

                                public void b(Implementation.Context context) {
                                }
                            }

                            public WithoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                                super(methodVisitor, typeDescription, record, factory, z11, z12);
                            }

                            public void c() {
                            }

                            public void visitEnd() {
                            }
                        }

                        public Appending(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.f27230d = typeDescription;
                            this.f27231e = record;
                            this.f27232f = factory;
                            if (!z11) {
                                this.f27233g = FrameWriter.NoOp.INSTANCE;
                            } else if (z12) {
                                this.f27233g = FrameWriter.Expanding.INSTANCE;
                            } else {
                                this.f27233g = new FrameWriter.Active();
                            }
                        }

                        public static InitializationHandler a(boolean z11, MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z12, boolean z13) {
                            if (z11) {
                                return withDrain(methodVisitor, typeDescription, methodPool, factory, z12, z13);
                            }
                            return withoutDrain(methodVisitor, typeDescription, methodPool, factory, z12, z13);
                        }

                        private static WithDrain withDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                            MethodPool.Record target = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            if (target.getSort().isImplemented()) {
                                return new WithDrain.WithActiveRecord(methodVisitor, typeDescription, target, factory, z11, z12);
                            }
                            return new WithDrain.WithoutActiveRecord(methodVisitor, typeDescription, target, factory, z11, z12);
                        }

                        private static WithoutDrain withoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z11, boolean z12) {
                            MethodPool.Record target = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            if (target.getSort().isImplemented()) {
                                return new WithoutDrain.WithActiveRecord(methodVisitor, typeDescription, target, factory, z11, z12);
                            }
                            return new WithoutDrain.WithoutActiveRecord(methodVisitor, typeDescription, target, factory);
                        }

                        public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                            ByteCodeAppender.Size apply = typeInitializer.apply(this.f27400c, context, new MethodDescription.Latent.TypeInitializer(this.f27230d));
                            this.f27234h = Math.max(this.f27234h, apply.getOperandStackSize());
                            this.f27235i = Math.max(this.f27235i, apply.getLocalVariableSize());
                            b(context);
                        }

                        public abstract void b(Implementation.Context context);

                        public abstract void c();

                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.f27232f);
                            this.f27400c.visitMaxs(this.f27234h, this.f27235i);
                            this.f27400c.visitEnd();
                        }

                        public void visitCode() {
                            this.f27231e.applyAttributes(this.f27400c, this.f27232f);
                            super.visitCode();
                            c();
                        }

                        public abstract void visitEnd();

                        public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                            super.visitFrame(i11, i12, objArr, i13, objArr2);
                            this.f27233g.onFrame(i11, i12);
                        }

                        public void visitMaxs(int i11, int i12) {
                            this.f27234h = i11;
                            this.f27235i = i12;
                        }
                    }

                    public static class Creating extends TypeInitializer.Drain.Default implements InitializationHandler {
                        public Creating(TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory) {
                            super(typeDescription, methodPool, factory);
                        }

                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.f27205d);
                        }
                    }

                    void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView);
                }

                public static class OpenedClassRemapper extends ClassRemapper {
                    public OpenedClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
                        super(OpenedClassReader.ASM_API, classVisitor, remapper);
                    }
                }

                @SuppressFBWarnings(justification = "Field access order is implied by ASM", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public class RedefinitionClassVisitor extends MetadataAwareClassVisitor {
                    private final ContextRegistry contextRegistry;
                    private final LinkedHashMap<String, FieldDescription> declarableFields = new LinkedHashMap<>();
                    private final LinkedHashMap<String, MethodDescription> declarableMethods;
                    private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents;
                    private final LinkedHashMap<String, TypeDescription> declaredTypes;
                    /* access modifiers changed from: private */
                    public Implementation.Context.ExtractableView implementationContext;
                    private InitializationHandler initializationHandler;
                    private MethodPool methodPool;
                    private final Set<String> nestMembers;
                    private final Set<String> permittedSubclasses;
                    private final int readerFlags;
                    private boolean retainDeprecationModifiers;
                    private final TypeInitializer typeInitializer;
                    private final int writerFlags;

                    public class AttributeObtainingFieldVisitor extends FieldVisitor {
                        private final FieldPool.Record record;

                        public AttributeObtainingFieldVisitor(FieldVisitor fieldVisitor, FieldPool.Record record2) {
                            super(OpenedClassReader.ASM_API, fieldVisitor);
                            this.record = record2;
                        }

                        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitAnnotation(str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitEnd() {
                            this.record.apply(this.f27379b, WithFullProcessing.this.f27220n);
                            super.visitEnd();
                        }

                        public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitTypeAnnotation(i11, typePath, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class AttributeObtainingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;

                        public AttributeObtainingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record2) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record2;
                            record2.applyHead(methodVisitor);
                        }

                        public void visitAnnotableParameterCount(int i11, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                super.visitAnnotableParameterCount(i11, z11);
                            }
                        }

                        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitAnnotation(str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitCode() {
                            this.f27400c = ForInlining.IGNORE_METHOD;
                        }

                        public void visitEnd() {
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.f27220n);
                            this.actualMethodVisitor.visitEnd();
                        }

                        public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitParameterAnnotation(i11, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitTypeAnnotation(i11, typePath, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class AttributeObtainingRecordComponentVisitor extends RecordComponentVisitor {
                        private final RecordComponentPool.Record record;

                        public AttributeObtainingRecordComponentVisitor(RecordComponentVisitor recordComponentVisitor, RecordComponentPool.Record record2) {
                            super(OpenedClassReader.ASM_API, recordComponentVisitor);
                            this.record = record2;
                        }

                        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitAnnotation(str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitEnd() {
                            this.record.apply(getDelegate(), WithFullProcessing.this.f27220n);
                            super.visitEnd();
                        }

                        public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitTypeAnnotation(i11, typePath, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class CodePreservingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;
                        private final MethodRebaseResolver.Resolution resolution;

                        public CodePreservingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record2, MethodRebaseResolver.Resolution resolution2) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record2;
                            this.resolution = resolution2;
                            record2.applyHead(methodVisitor);
                        }

                        public void visitAnnotableParameterCount(int i11, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                super.visitAnnotableParameterCount(i11, z11);
                            }
                        }

                        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitAnnotation(str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public void visitCode() {
                            MethodVisitor methodVisitor;
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.f27220n);
                            this.actualMethodVisitor.visitEnd();
                            if (this.resolution.isRebased()) {
                                methodVisitor = RedefinitionClassVisitor.this.f27354c.visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution.getResolvedMethod().getInternalName(), this.resolution.getResolvedMethod().getDescriptor(), this.resolution.getResolvedMethod().getGenericSignature(), this.resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            } else {
                                methodVisitor = ForInlining.IGNORE_METHOD;
                            }
                            this.f27400c = methodVisitor;
                            super.visitCode();
                        }

                        public void visitMaxs(int i11, int i12) {
                            super.visitMaxs(i11, Math.max(i12, this.resolution.getResolvedMethod().getStackSize()));
                        }

                        public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitParameterAnnotation(i11, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            if (WithFullProcessing.this.f27221o.isEnabled()) {
                                return super.visitTypeAnnotation(i11, typePath, str, z11);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public RedefinitionClassVisitor(ClassVisitor classVisitor, TypeInitializer typeInitializer2, ContextRegistry contextRegistry2, int i11, int i12) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.typeInitializer = typeInitializer2;
                        this.contextRegistry = contextRegistry2;
                        this.writerFlags = i11;
                        this.readerFlags = i12;
                        for (FieldDescription fieldDescription : WithFullProcessing.this.f27212f) {
                            LinkedHashMap<String, FieldDescription> linkedHashMap = this.declarableFields;
                            linkedHashMap.put(fieldDescription.getInternalName() + fieldDescription.getDescriptor(), fieldDescription);
                        }
                        this.declarableMethods = new LinkedHashMap<>();
                        Iterator<E> it = WithFullProcessing.this.f27214h.iterator();
                        while (it.hasNext()) {
                            MethodDescription methodDescription = (MethodDescription) it.next();
                            LinkedHashMap<String, MethodDescription> linkedHashMap2 = this.declarableMethods;
                            linkedHashMap2.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
                        }
                        this.declarableRecordComponents = new LinkedHashMap<>();
                        for (RecordComponentDescription recordComponentDescription : WithFullProcessing.this.f27215i) {
                            this.declarableRecordComponents.put(recordComponentDescription.getActualName(), recordComponentDescription);
                        }
                        if (WithFullProcessing.this.f27207a.isNestHost()) {
                            this.nestMembers = new LinkedHashSet();
                            for (TypeDescription internalName : (TypeList) WithFullProcessing.this.f27207a.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is((Object) WithFullProcessing.this.f27207a)))) {
                                this.nestMembers.add(internalName.getInternalName());
                            }
                        } else {
                            this.nestMembers = Collections.emptySet();
                        }
                        this.declaredTypes = new LinkedHashMap<>();
                        for (TypeDescription typeDescription : WithFullProcessing.this.f27207a.getDeclaredTypes()) {
                            this.declaredTypes.put(typeDescription.getInternalName(), typeDescription);
                        }
                        if (WithFullProcessing.this.f27207a.isSealed()) {
                            this.permittedSubclasses = new LinkedHashSet();
                            for (TypeDescription internalName2 : WithFullProcessing.this.f27207a.getPermittedSubtypes()) {
                                this.permittedSubclasses.add(internalName2.getInternalName());
                            }
                            return;
                        }
                        this.permittedSubclasses = null;
                    }

                    private int resolveDeprecationModifiers(int i11) {
                        return (!this.retainDeprecationModifiers || (i11 & 131072) == 0) ? 0 : 131072;
                    }

                    public void a() {
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        TypeAttributeAppender typeAttributeAppender = withFullProcessing.f27218l;
                        ClassVisitor classVisitor = this.f27354c;
                        TypeDescription typeDescription = withFullProcessing.f27207a;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withFullProcessing.f27220n.on(typeDescription));
                    }

                    public void b() {
                        if (!WithFullProcessing.this.f27207a.isNestHost()) {
                            this.f27354c.visitNestHost(WithFullProcessing.this.f27207a.getNestHost().getInternalName());
                        }
                    }

                    public void c() {
                        MethodDescription.InDefinedShape enclosingMethod = WithFullProcessing.this.f27207a.getEnclosingMethod();
                        if (enclosingMethod != null) {
                            this.f27354c.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                        } else if (WithFullProcessing.this.f27207a.isLocalType() || WithFullProcessing.this.f27207a.isAnonymousType()) {
                            this.f27354c.visitOuterClass(WithFullProcessing.this.f27207a.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                        }
                    }

                    public AnnotationVisitor d(String str, boolean z11) {
                        if (WithFullProcessing.this.f27221o.isEnabled()) {
                            return this.f27354c.visitAnnotation(str, z11);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    public void f() {
                        String str;
                        String str2;
                        for (String visitNestMember : this.nestMembers) {
                            this.f27354c.visitNestMember(visitNestMember);
                        }
                        Set<String> set = this.permittedSubclasses;
                        if (set != null) {
                            for (String visitPermittedSubclass : set) {
                                this.f27354c.visitPermittedSubclass(visitPermittedSubclass);
                            }
                        }
                        TypeDescription declaringType = WithFullProcessing.this.f27207a.getDeclaringType();
                        if (declaringType != null) {
                            this.f27354c.visitInnerClass(WithFullProcessing.this.f27207a.getInternalName(), declaringType.getInternalName(), WithFullProcessing.this.f27207a.getSimpleName(), WithFullProcessing.this.f27207a.getModifiers());
                        } else if (WithFullProcessing.this.f27207a.isLocalType()) {
                            this.f27354c.visitInnerClass(WithFullProcessing.this.f27207a.getInternalName(), Default.NO_REFERENCE, WithFullProcessing.this.f27207a.getSimpleName(), WithFullProcessing.this.f27207a.getModifiers());
                        } else if (WithFullProcessing.this.f27207a.isAnonymousType()) {
                            this.f27354c.visitInnerClass(WithFullProcessing.this.f27207a.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, WithFullProcessing.this.f27207a.getModifiers());
                        }
                        for (TypeDescription next : this.declaredTypes.values()) {
                            ClassVisitor classVisitor = this.f27354c;
                            String internalName = next.getInternalName();
                            if (next.isMemberType()) {
                                str = WithFullProcessing.this.f27207a.getInternalName();
                            } else {
                                str = Default.NO_REFERENCE;
                            }
                            if (next.isAnonymousType()) {
                                str2 = Default.NO_REFERENCE;
                            } else {
                                str2 = next.getSimpleName();
                            }
                            classVisitor.visitInnerClass(internalName, str, str2, next.getModifiers());
                        }
                        for (RecordComponentDescription target : this.declarableRecordComponents.values()) {
                            WithFullProcessing.this.f27210d.target(target).apply(this.f27354c, WithFullProcessing.this.f27220n);
                        }
                        for (FieldDescription target2 : this.declarableFields.values()) {
                            WithFullProcessing.this.f27209c.target(target2).apply(this.f27354c, WithFullProcessing.this.f27220n);
                        }
                        for (MethodDescription target3 : this.declarableMethods.values()) {
                            this.methodPool.target(target3).apply(this.f27354c, this.implementationContext, WithFullProcessing.this.f27220n);
                        }
                        this.initializationHandler.complete(this.f27354c, this.implementationContext);
                        this.f27354c.visitEnd();
                    }

                    public FieldVisitor g(int i11, String str, String str2, String str3, Object obj) {
                        LinkedHashMap<String, FieldDescription> linkedHashMap = this.declarableFields;
                        FieldDescription remove = linkedHashMap.remove(str + str2);
                        if (remove != null) {
                            FieldPool.Record target = WithFullProcessing.this.f27209c.target(remove);
                            if (!target.isImplicit()) {
                                return r(target, obj, i11, str3);
                            }
                        }
                        return this.f27354c.visitField(i11, str, str2, str3, obj);
                    }

                    public void h(String str, String str2, String str3, int i11) {
                        String str4;
                        String str5;
                        if (!str.equals(WithFullProcessing.this.f27207a.getInternalName())) {
                            TypeDescription remove = this.declaredTypes.remove(str);
                            if (remove == null) {
                                this.f27354c.visitInnerClass(str, str2, str3, i11);
                                return;
                            }
                            ClassVisitor classVisitor = this.f27354c;
                            if (remove.isMemberType() || (str2 != null && str3 == null && remove.isAnonymousType())) {
                                str4 = WithFullProcessing.this.f27207a.getInternalName();
                            } else {
                                str4 = Default.NO_REFERENCE;
                            }
                            if (remove.isAnonymousType()) {
                                str5 = Default.NO_REFERENCE;
                            } else {
                                str5 = remove.getSimpleName();
                            }
                            classVisitor.visitInnerClass(str, str4, str5, remove.getModifiers());
                        }
                    }

                    public MethodVisitor i(int i11, String str, String str2, String str3, String[] strArr) {
                        String str4;
                        boolean z11;
                        boolean z12;
                        int i12 = i11;
                        String str5 = str;
                        boolean z13 = true;
                        if (str5.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            MethodVisitor visitMethod = this.f27354c.visitMethod(i11, str, str2, str3, strArr);
                            if (visitMethod == null) {
                                return ForInlining.IGNORE_METHOD;
                            }
                            boolean isEnabled = this.implementationContext.isEnabled();
                            WithFullProcessing withFullProcessing = WithFullProcessing.this;
                            TypeDescription typeDescription = withFullProcessing.f27207a;
                            MethodPool methodPool2 = this.methodPool;
                            AnnotationValueFilter.Factory factory = withFullProcessing.f27220n;
                            if ((this.writerFlags & 2) != 0 || !this.implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                            if ((this.readerFlags & 8) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            InitializationHandler a11 = InitializationHandler.Appending.a(isEnabled, visitMethod, typeDescription, methodPool2, factory, z11, z12);
                            this.initializationHandler = a11;
                            return (MethodVisitor) a11;
                        }
                        MethodDescription remove = this.declarableMethods.remove(str5 + str2);
                        if (remove == null) {
                            return this.f27354c.visitMethod(i11, str, str2, str3, strArr);
                        }
                        if ((i12 & 1024) != 0) {
                            str4 = str3;
                        } else {
                            str4 = str3;
                            z13 = false;
                        }
                        return s(remove, z13, i12, str4);
                    }

                    public void j(String str) {
                        b();
                    }

                    public void k(String str) {
                        if (WithFullProcessing.this.f27207a.isNestHost() && this.nestMembers.remove(str)) {
                            this.f27354c.visitNestMember(str);
                        }
                    }

                    public void l(String str, String str2, String str3) {
                        try {
                            c();
                        } catch (Throwable unused) {
                            this.f27354c.visitOuterClass(str, str2, str3);
                        }
                    }

                    public void m(String str) {
                        Set<String> set = this.permittedSubclasses;
                        if (set != null && set.remove(str)) {
                            this.f27354c.visitPermittedSubclass(str);
                        }
                    }

                    public RecordComponentVisitor n(String str, String str2, String str3) {
                        RecordComponentDescription remove = this.declarableRecordComponents.remove(str);
                        if (remove != null) {
                            RecordComponentPool.Record target = WithFullProcessing.this.f27210d.target(remove);
                            if (!target.isImplicit()) {
                                return t(target, str3);
                            }
                        }
                        return this.f27354c.visitRecordComponent(str, str2, str3);
                    }

                    public AnnotationVisitor o(int i11, TypePath typePath, String str, boolean z11) {
                        if (WithFullProcessing.this.f27221o.isEnabled()) {
                            return this.f27354c.visitTypeAnnotation(i11, typePath, str, z11);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    public FieldVisitor r(FieldPool.Record record, Object obj, int i11, String str) {
                        FieldDescription field = record.getField();
                        ClassVisitor classVisitor = this.f27354c;
                        int actualModifiers = field.getActualModifiers() | resolveDeprecationModifiers(i11);
                        String internalName = field.getInternalName();
                        String descriptor = field.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = field.getGenericSignature();
                        }
                        FieldVisitor visitField = classVisitor.visitField(actualModifiers, internalName, descriptor, str, record.resolveDefault(obj));
                        if (visitField == null) {
                            return ForInlining.IGNORE_FIELD;
                        }
                        return new AttributeObtainingFieldVisitor(visitField, record);
                    }

                    public MethodVisitor s(MethodDescription methodDescription, boolean z11, int i11, String str) {
                        String str2;
                        String str3;
                        String str4;
                        int i12 = i11;
                        MethodDescription methodDescription2 = methodDescription;
                        MethodPool.Record target = this.methodPool.target(methodDescription);
                        if (!target.getSort().isDefined()) {
                            ClassVisitor classVisitor = this.f27354c;
                            int actualModifiers = methodDescription.getActualModifiers() | resolveDeprecationModifiers(i12);
                            String internalName = methodDescription.getInternalName();
                            String descriptor = methodDescription.getDescriptor();
                            if (TypeDescription.AbstractBase.RAW_TYPES) {
                                str4 = str;
                            } else {
                                str4 = methodDescription.getGenericSignature();
                            }
                            return classVisitor.visitMethod(actualModifiers, internalName, descriptor, str4, methodDescription.getExceptionTypes().asErasures().toInternalNames());
                        }
                        MethodDescription method = target.getMethod();
                        ClassVisitor classVisitor2 = this.f27354c;
                        int resolve = ModifierContributor.Resolver.of(Collections.singleton(target.getVisibility())).resolve(method.getActualModifiers(target.getSort().isImplemented())) | resolveDeprecationModifiers(i12);
                        String internalName2 = method.getInternalName();
                        String descriptor2 = method.getDescriptor();
                        boolean z12 = TypeDescription.AbstractBase.RAW_TYPES;
                        if (z12) {
                            str2 = str;
                        } else {
                            str2 = method.getGenericSignature();
                        }
                        MethodVisitor visitMethod = classVisitor2.visitMethod(resolve, internalName2, descriptor2, str2, method.getExceptionTypes().asErasures().toInternalNames());
                        if (visitMethod == null) {
                            return ForInlining.IGNORE_METHOD;
                        }
                        if (z11) {
                            return new AttributeObtainingMethodVisitor(visitMethod, target);
                        }
                        if (!methodDescription.isNative()) {
                            return new CodePreservingMethodVisitor(visitMethod, target, WithFullProcessing.this.methodRebaseResolver.resolve((MethodDescription.InDefinedShape) method.asDefined()));
                        }
                        MethodRebaseResolver.Resolution resolve2 = WithFullProcessing.this.methodRebaseResolver.resolve((MethodDescription.InDefinedShape) method.asDefined());
                        if (resolve2.isRebased()) {
                            int actualModifiers2 = resolve2.getResolvedMethod().getActualModifiers() | resolveDeprecationModifiers(i12);
                            String internalName3 = resolve2.getResolvedMethod().getInternalName();
                            String descriptor3 = resolve2.getResolvedMethod().getDescriptor();
                            if (z12) {
                                str3 = str;
                            } else {
                                str3 = method.getGenericSignature();
                            }
                            MethodVisitor visitMethod2 = super.visitMethod(actualModifiers2, internalName3, descriptor3, str3, resolve2.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            if (visitMethod2 != null) {
                                visitMethod2.visitEnd();
                            }
                        }
                        return new AttributeObtainingMethodVisitor(visitMethod, target);
                    }

                    public RecordComponentVisitor t(RecordComponentPool.Record record, String str) {
                        RecordComponentDescription recordComponent = record.getRecordComponent();
                        ClassVisitor classVisitor = this.f27354c;
                        String actualName = recordComponent.getActualName();
                        String descriptor = recordComponent.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = recordComponent.getGenericSignature();
                        }
                        RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(actualName, descriptor, str);
                        if (visitRecordComponent == null) {
                            return ForInlining.IGNORE_RECORD_COMPONENT;
                        }
                        return new AttributeObtainingRecordComponentVisitor(visitRecordComponent, record);
                    }

                    public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
                        boolean z11;
                        String str4;
                        String str5;
                        int i13 = i12;
                        ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i11);
                        MethodRegistry.Compiled compile = WithFullProcessing.this.methodRegistry.compile(WithFullProcessing.this.implementationTargetFactory, ofMinorMajor);
                        this.methodPool = compile;
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        this.initializationHandler = new InitializationHandler.Creating(withFullProcessing.f27207a, compile, withFullProcessing.f27220n);
                        WithFullProcessing withFullProcessing2 = WithFullProcessing.this;
                        this.implementationContext = withFullProcessing2.f27223q.make(withFullProcessing2.f27207a, withFullProcessing2.f27222p, this.typeInitializer, ofMinorMajor, withFullProcessing2.f27208b);
                        this.retainDeprecationModifiers = ofMinorMajor.isLessThan(ClassFileVersion.JAVA_V5);
                        this.contextRegistry.setImplementationContext(this.implementationContext);
                        WithFullProcessing withFullProcessing3 = WithFullProcessing.this;
                        ClassVisitor wrap = withFullProcessing3.f27219m.wrap(withFullProcessing3.f27207a, this.f27354c, this.implementationContext, withFullProcessing3.f27226t, withFullProcessing3.f27212f, withFullProcessing3.f27213g, this.writerFlags, this.readerFlags);
                        this.f27354c = wrap;
                        TypeDescription typeDescription = WithFullProcessing.this.f27207a;
                        int i14 = 0;
                        if ((i13 & 32) == 0 || typeDescription.isInterface()) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        int actualModifiers = typeDescription.getActualModifiers(z11) | resolveDeprecationModifiers(i13);
                        if ((i13 & 16) != 0 && WithFullProcessing.this.f27207a.isAnonymousType()) {
                            i14 = 16;
                        }
                        int i15 = actualModifiers | i14;
                        String internalName = WithFullProcessing.this.f27207a.getInternalName();
                        if (TypeDescription.AbstractBase.RAW_TYPES) {
                            str4 = str2;
                        } else {
                            str4 = WithFullProcessing.this.f27207a.getGenericSignature();
                        }
                        if (WithFullProcessing.this.f27207a.getSuperClass() != null) {
                            str5 = WithFullProcessing.this.f27207a.getSuperClass().asErasure().getInternalName();
                        } else if (WithFullProcessing.this.f27207a.isInterface()) {
                            str5 = TypeDescription.OBJECT.getInternalName();
                        } else {
                            str5 = Default.NO_REFERENCE;
                        }
                        wrap.visit(i11, i15, internalName, str4, str5, WithFullProcessing.this.f27207a.getInterfaces().asErasures().toInternalNames());
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WithFullProcessing(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator, MethodRegistry.Prepared prepared, Implementation.Target.Factory factory3, MethodRebaseResolver methodRebaseResolver2) {
                    super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription2, classFileLocator);
                    this.methodRegistry = prepared;
                    this.implementationTargetFactory = factory3;
                    this.methodRebaseResolver = methodRebaseResolver2;
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
                    WithFullProcessing withFullProcessing = (WithFullProcessing) obj;
                    return this.methodRegistry.equals(withFullProcessing.methodRegistry) && this.implementationTargetFactory.equals(withFullProcessing.implementationTargetFactory) && this.methodRebaseResolver.equals(withFullProcessing.methodRebaseResolver);
                }

                public ClassVisitor h(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i11, int i12) {
                    RedefinitionClassVisitor redefinitionClassVisitor = new RedefinitionClassVisitor(classVisitor, typeInitializer, contextRegistry, i11, i12);
                    if (this.f27227v.getName().equals(this.f27207a.getName())) {
                        return redefinitionClassVisitor;
                    }
                    return new OpenedClassRemapper(redefinitionClassVisitor, new SimpleRemapper(this.f27227v.getInternalName(), this.f27207a.getInternalName()));
                }

                public int hashCode() {
                    return (((((super.hashCode() * 31) + this.methodRegistry.hashCode()) * 31) + this.implementationTargetFactory.hashCode()) * 31) + this.methodRebaseResolver.hashCode();
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ForInlining(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.f27227v = typeDescription2;
                this.f27228w = classFileLocator;
            }

            public Default<U>.UnresolvedType c(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                try {
                    int mergeWriter = this.f27219m.mergeWriter(0);
                    int mergeReader = this.f27219m.mergeReader(0);
                    byte[] resolve = this.f27228w.locate(this.f27227v.getName()).resolve();
                    dispatcher.dump(this.f27207a, true, resolve);
                    ClassReader of2 = OpenedClassReader.of(resolve);
                    ClassWriter resolve2 = this.f27225s.resolve(mergeWriter, this.f27226t, of2);
                    ContextRegistry contextRegistry = new ContextRegistry();
                    of2.accept(h(ValidatingClassVisitor.b(resolve2, this.f27224r), typeInitializer, contextRegistry, mergeWriter, mergeReader), mergeReader);
                    return new UnresolvedType(resolve2.toByteArray(), contextRegistry.getAuxiliaryTypes());
                } catch (IOException e11) {
                    throw new RuntimeException("The class file could not be written", e11);
                }
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
                ForInlining forInlining = (ForInlining) obj;
                return this.f27227v.equals(forInlining.f27227v) && this.f27228w.equals(forInlining.f27228w);
            }

            public abstract ClassVisitor h(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i11, int i12);

            public int hashCode() {
                return (((super.hashCode() * 31) + this.f27227v.hashCode()) * 31) + this.f27228w.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class UnresolvedType {
            private final List<? extends DynamicType> auxiliaryTypes;
            private final byte[] binaryRepresentation;

            public UnresolvedType(byte[] bArr, List<? extends DynamicType> list) {
                this.binaryRepresentation = bArr;
                this.auxiliaryTypes = list;
            }

            public byte[] a() {
                return this.binaryRepresentation;
            }

            public DynamicType.Unloaded<S> b(TypeResolutionStrategy.Resolved resolved) {
                Default defaultR = Default.this;
                return new DynamicType.Default.Unloaded(defaultR.f27207a, this.binaryRepresentation, defaultR.f27216j, CompoundList.of(defaultR.f27211e, this.auxiliaryTypes), resolved);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UnresolvedType unresolvedType = (UnresolvedType) obj;
                return Arrays.equals(this.binaryRepresentation, unresolvedType.binaryRepresentation) && this.auxiliaryTypes.equals(unresolvedType.auxiliaryTypes) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + this.auxiliaryTypes.hashCode()) * 31) + Default.this.hashCode();
            }
        }

        public static class ValidatingClassVisitor extends ClassVisitor {
            private static final FieldVisitor IGNORE_FIELD = null;
            private static final MethodVisitor IGNORE_METHOD = null;
            private static final String NO_PARAMETERS = "()";
            private static final String RETURNS_VOID = "V";
            private static final String STRING_DESCRIPTOR = "Ljava/lang/String;";
            /* access modifiers changed from: private */
            public Constraint constraint;

            public interface Constraint {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Compound implements Constraint {
                    private final List<Constraint> constraints = new ArrayList();

                    public Compound(List<? extends Constraint> list) {
                        for (Constraint constraint : list) {
                            if (constraint instanceof Compound) {
                                this.constraints.addAll(((Compound) constraint).constraints);
                            } else {
                                this.constraints.add(constraint);
                            }
                        }
                    }

                    public void assertAnnotation() {
                        for (Constraint assertAnnotation : this.constraints) {
                            assertAnnotation.assertAnnotation();
                        }
                    }

                    public void assertDefaultMethodCall() {
                        for (Constraint assertDefaultMethodCall : this.constraints) {
                            assertDefaultMethodCall.assertDefaultMethodCall();
                        }
                    }

                    public void assertDefaultValue(String str) {
                        for (Constraint assertDefaultValue : this.constraints) {
                            assertDefaultValue.assertDefaultValue(str);
                        }
                    }

                    public void assertDynamicValueInConstantPool() {
                        for (Constraint assertDynamicValueInConstantPool : this.constraints) {
                            assertDynamicValueInConstantPool.assertDynamicValueInConstantPool();
                        }
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                        for (Constraint assertField : this.constraints) {
                            assertField.assertField(str, z11, z12, z13, z14);
                        }
                    }

                    public void assertHandleInConstantPool() {
                        for (Constraint assertHandleInConstantPool : this.constraints) {
                            assertHandleInConstantPool.assertHandleInConstantPool();
                        }
                    }

                    public void assertInvokeDynamic() {
                        for (Constraint assertInvokeDynamic : this.constraints) {
                            assertInvokeDynamic.assertInvokeDynamic();
                        }
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        for (Constraint assertMethod : this.constraints) {
                            assertMethod.assertMethod(str, z11, z12, z13, z14, z15, z16, z17, z18);
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                        for (Constraint assertMethodTypeInConstantPool : this.constraints) {
                            assertMethodTypeInConstantPool.assertMethodTypeInConstantPool();
                        }
                    }

                    public void assertNestMate() {
                        for (Constraint assertNestMate : this.constraints) {
                            assertNestMate.assertNestMate();
                        }
                    }

                    public void assertPermittedSubclass() {
                        for (Constraint assertPermittedSubclass : this.constraints) {
                            assertPermittedSubclass.assertPermittedSubclass();
                        }
                    }

                    public void assertRecord() {
                        for (Constraint assertRecord : this.constraints) {
                            assertRecord.assertRecord();
                        }
                    }

                    public void assertSubRoutine() {
                        for (Constraint assertSubRoutine : this.constraints) {
                            assertSubRoutine.assertSubRoutine();
                        }
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                        for (Constraint assertType : this.constraints) {
                            assertType.assertType(i11, z11, z12);
                        }
                    }

                    public void assertTypeAnnotation() {
                        for (Constraint assertTypeAnnotation : this.constraints) {
                            assertTypeAnnotation.assertTypeAnnotation();
                        }
                    }

                    public void assertTypeInConstantPool() {
                        for (Constraint assertTypeInConstantPool : this.constraints) {
                            assertTypeInConstantPool.assertTypeInConstantPool();
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.constraints.equals(((Compound) obj).constraints);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.constraints.hashCode();
                    }
                }

                public enum ForAnnotation implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    private ForAnnotation(boolean z11) {
                        this.classic = z11;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                        if (!z12 || !z11 || !z13) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + str + "' for interface type");
                        }
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (z16) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        } else if (this.classic && !z15) {
                            throw new IllegalStateException("Cannot define non-virtual method '" + str + "' for a pre-Java 8 annotation type");
                        } else if (!z14 && z17) {
                            throw new IllegalStateException("Cannot define method '" + str + "' with the given signature as an annotation type method");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                        if ((i11 & 512) == 0) {
                            throw new IllegalStateException("Cannot define annotation type without interface modifier");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForClass implements Constraint {
                    MANIFEST(true),
                    ABSTRACT(false);
                    
                    private final boolean manifestType;

                    private ForClass(boolean z11) {
                        this.manifestType = z11;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException("Cannot define default value for '" + str + "' for non-annotation type");
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        if (z11 && this.manifestType) {
                            throw new IllegalStateException("Cannot define abstract method '" + str + "' for non-abstract class");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForClassFileVersion implements Constraint {
                    private final ClassFileVersion classFileVersion;

                    public ForClassFileVersion(ClassFileVersion classFileVersion2) {
                        this.classFileVersion = classFileVersion2;
                    }

                    public void assertAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertDefaultMethodCall() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) {
                            throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                        if (z14 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic field '" + str + "' for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertHandleInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertInvokeDynamic() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        if (z18 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic method '" + str + "' for class file version " + this.classFileVersion);
                        } else if (!z15 && z11) {
                            throw new IllegalStateException("Cannot define static or non-virtual method '" + str + "' to be abstract");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertNestMate() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertPermittedSubclass() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17)) {
                            throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertRecord() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) {
                            throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertSubRoutine() {
                        if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                        if ((i11 & 8192) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion);
                        } else if (z12 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertTypeAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);
                        }
                    }

                    public void assertTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((ForClassFileVersion) obj).classFileVersion);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
                    }
                }

                public enum ForInterface implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    private ForInterface(boolean z11) {
                        this.classic = z11;
                    }

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException("Cannot define default value for '" + str + "' for non-annotation type");
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                        if (!z12 || !z11 || !z13) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + str + "' for interface type");
                        }
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (!z16) {
                            boolean z19 = this.classic;
                            if (z19 && !z12) {
                                throw new IllegalStateException("Cannot define non-public method '" + str + "' for interface type");
                            } else if (z19 && !z15) {
                                throw new IllegalStateException("Cannot define non-virtual method '" + str + "' for a pre-Java 8 interface type");
                            } else if (z19 && !z11) {
                                throw new IllegalStateException("Cannot define default method '" + str + "' for pre-Java 8 interface type");
                            }
                        } else {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        }
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForPackageType implements Constraint {
                    INSTANCE;

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                        throw new IllegalStateException("Cannot define a field for a package description type");
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                        throw new IllegalStateException("Cannot define a method for a package description type");
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                        if (i11 != 5632) {
                            throw new IllegalStateException("A package description type must define 5632 as modifier");
                        } else if (z11) {
                            throw new IllegalStateException("Cannot implement interface for package type");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForRecord implements Constraint {
                    INSTANCE;

                    public void assertAnnotation() {
                    }

                    public void assertDefaultMethodCall() {
                    }

                    public void assertDefaultValue(String str) {
                    }

                    public void assertDynamicValueInConstantPool() {
                    }

                    public void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14) {
                    }

                    public void assertHandleInConstantPool() {
                    }

                    public void assertInvokeDynamic() {
                    }

                    public void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
                    }

                    public void assertMethodTypeInConstantPool() {
                    }

                    public void assertNestMate() {
                    }

                    public void assertPermittedSubclass() {
                    }

                    public void assertRecord() {
                    }

                    public void assertSubRoutine() {
                    }

                    public void assertType(int i11, boolean z11, boolean z12) {
                        if ((i11 & 1024) != 0) {
                            throw new IllegalStateException("Cannot define a record class as abstract");
                        }
                    }

                    public void assertTypeAnnotation() {
                    }

                    public void assertTypeInConstantPool() {
                    }
                }

                void assertAnnotation();

                void assertDefaultMethodCall();

                void assertDefaultValue(String str);

                void assertDynamicValueInConstantPool();

                void assertField(String str, boolean z11, boolean z12, boolean z13, boolean z14);

                void assertHandleInConstantPool();

                void assertInvokeDynamic();

                void assertMethod(String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18);

                void assertMethodTypeInConstantPool();

                void assertNestMate();

                void assertPermittedSubclass();

                void assertRecord();

                void assertSubRoutine();

                void assertType(int i11, boolean z11, boolean z12);

                void assertTypeAnnotation();

                void assertTypeInConstantPool();
            }

            public class ValidatingFieldVisitor extends FieldVisitor {
                public ValidatingFieldVisitor(FieldVisitor fieldVisitor) {
                    super(OpenedClassReader.ASM_API, fieldVisitor);
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z11);
                }
            }

            public class ValidatingMethodVisitor extends MethodVisitor {

                /* renamed from: name  reason: collision with root package name */
                private final String f27246name;

                public ValidatingMethodVisitor(MethodVisitor methodVisitor, String str) {
                    super(OpenedClassReader.ASM_API, methodVisitor);
                    this.f27246name = str;
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z11);
                }

                public AnnotationVisitor visitAnnotationDefault() {
                    ValidatingClassVisitor.this.constraint.assertDefaultValue(this.f27246name);
                    return super.visitAnnotationDefault();
                }

                public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                    ValidatingClassVisitor.this.constraint.assertInvokeDynamic();
                    for (Object obj : objArr) {
                        if (obj instanceof ConstantDynamic) {
                            ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                        }
                    }
                    super.visitInvokeDynamicInsn(str, str2, handle, objArr);
                }

                public void visitJumpInsn(int i11, Label label) {
                    if (i11 == 168) {
                        ValidatingClassVisitor.this.constraint.assertSubRoutine();
                    }
                    super.visitJumpInsn(i11, label);
                }

                @SuppressFBWarnings(justification = "Fall through to default case is intentional", value = {"SF_SWITCH_NO_DEFAULT"})
                public void visitLdcInsn(Object obj) {
                    if (obj instanceof Type) {
                        switch (((Type) obj).getSort()) {
                            case 9:
                            case 10:
                                ValidatingClassVisitor.this.constraint.assertTypeInConstantPool();
                                break;
                            case 11:
                                ValidatingClassVisitor.this.constraint.assertMethodTypeInConstantPool();
                                break;
                        }
                    } else if (obj instanceof Handle) {
                        ValidatingClassVisitor.this.constraint.assertHandleInConstantPool();
                    } else if (obj instanceof ConstantDynamic) {
                        ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                    }
                    super.visitLdcInsn(obj);
                }

                public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
                    if (z11 && i11 == 183) {
                        ValidatingClassVisitor.this.constraint.assertDefaultMethodCall();
                    }
                    super.visitMethodInsn(i11, str, str2, str3, z11);
                }
            }

            public ValidatingClassVisitor(ClassVisitor classVisitor) {
                super(OpenedClassReader.ASM_API, classVisitor);
            }

            public static ClassVisitor b(ClassVisitor classVisitor, TypeValidation typeValidation) {
                return typeValidation.isEnabled() ? new ValidatingClassVisitor(classVisitor) : classVisitor;
            }

            public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
                boolean z11;
                boolean z12;
                Constraint.ForInterface forInterface;
                Constraint.ForAnnotation forAnnotation;
                ClassFileVersion ofMinorMajor = ClassFileVersion.ofMinorMajor(i11);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Constraint.ForClassFileVersion(ofMinorMajor));
                if (str.endsWith("/package-info")) {
                    arrayList.add(Constraint.ForPackageType.INSTANCE);
                } else if ((i12 & 8192) != 0) {
                    if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V5)) {
                        if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8)) {
                            forAnnotation = Constraint.ForAnnotation.JAVA_8;
                        } else {
                            forAnnotation = Constraint.ForAnnotation.CLASSIC;
                        }
                        arrayList.add(forAnnotation);
                    } else {
                        throw new IllegalStateException("Cannot define an annotation type for class file version " + ofMinorMajor);
                    }
                } else if ((i12 & 512) != 0) {
                    if (ofMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8)) {
                        forInterface = Constraint.ForInterface.JAVA_8;
                    } else {
                        forInterface = Constraint.ForInterface.CLASSIC;
                    }
                    arrayList.add(forInterface);
                } else if ((i12 & 1024) != 0) {
                    arrayList.add(Constraint.ForClass.ABSTRACT);
                } else {
                    arrayList.add(Constraint.ForClass.MANIFEST);
                }
                boolean z13 = true;
                if ((65536 & i12) != 0) {
                    arrayList.add(Constraint.ForRecord.INSTANCE);
                    z11 = true;
                } else {
                    z11 = false;
                }
                Constraint.Compound compound = new Constraint.Compound(arrayList);
                this.constraint = compound;
                if (strArr != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (str2 == null) {
                    z13 = false;
                }
                compound.assertType(i12, z12, z13);
                if (z11) {
                    this.constraint.assertRecord();
                }
                super.visit(i11, i12, str, str2, str3, strArr);
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                this.constraint.assertAnnotation();
                return super.visitAnnotation(str, z11);
            }

            public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                Class cls;
                int i12;
                int i13;
                if (obj != null) {
                    char charAt = str2.charAt(0);
                    Class<Integer> cls2 = Integer.class;
                    if (charAt != 'F') {
                        if (!(charAt == 'S' || charAt == 'Z' || charAt == 'I')) {
                            if (charAt != 'J') {
                                switch (charAt) {
                                    case 'B':
                                    case 'C':
                                        break;
                                    case 'D':
                                        cls = Double.class;
                                        break;
                                    default:
                                        if (str2.equals(STRING_DESCRIPTOR)) {
                                            cls = String.class;
                                            break;
                                        } else {
                                            throw new IllegalStateException("Cannot define a default value for type of field " + str);
                                        }
                                }
                            } else {
                                cls = Long.class;
                            }
                        }
                        cls = cls2;
                    } else {
                        cls = Float.class;
                    }
                    if (!cls.isInstance(obj)) {
                        throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                    } else if (cls == cls2) {
                        char charAt2 = str2.charAt(0);
                        if (charAt2 != 'B') {
                            if (charAt2 == 'C') {
                                i12 = 65535;
                            } else if (charAt2 == 'S') {
                                i13 = -32768;
                                i12 = Advice.MethodSizeHandler.UNDEFINED_SIZE;
                            } else if (charAt2 != 'Z') {
                                i13 = Integer.MIN_VALUE;
                                i12 = Integer.MAX_VALUE;
                            } else {
                                i12 = 1;
                            }
                            i13 = 0;
                        } else {
                            i13 = -128;
                            i12 = 127;
                        }
                        int intValue = ((Integer) obj).intValue();
                        if (intValue < i13 || intValue > i12) {
                            throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                        }
                    }
                }
                Constraint constraint2 = this.constraint;
                if ((i11 & 1) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i11 & 8) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i11 & 16) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (str3 != null) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                constraint2.assertField(str, z11, z12, z13, z14);
                FieldVisitor visitField = super.visitField(i11, str, str2, str3, obj);
                if (visitField == null) {
                    return IGNORE_FIELD;
                }
                return new ValidatingFieldVisitor(visitField);
            }

            public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                boolean z15;
                boolean z16;
                boolean z17;
                int i12 = i11;
                String str4 = str;
                String str5 = str2;
                Constraint constraint2 = this.constraint;
                if ((i12 & 1024) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i12 & 1) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((i12 & 2) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if ((i12 & 8) != 0) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (str4.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) || str4.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) || (i12 & 10) != 0) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                boolean equals = str4.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
                if (!str5.startsWith(NO_PARAMETERS) || str5.endsWith("V")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (str3 != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                constraint2.assertMethod(str, z11, z12, z13, z14, z15, equals, z16, z17);
                MethodVisitor visitMethod = super.visitMethod(i11, str, str2, str3, strArr);
                if (visitMethod == null) {
                    return IGNORE_METHOD;
                }
                return new ValidatingMethodVisitor(visitMethod, str4);
            }

            public void visitNestHost(String str) {
                this.constraint.assertNestMate();
                super.visitNestHost(str);
            }

            public void visitNestMember(String str) {
                this.constraint.assertNestMate();
                super.visitNestMember(str);
            }

            public void visitPermittedSubclass(String str) {
                this.constraint.assertPermittedSubclass();
                super.visitPermittedSubclass(str);
            }

            public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                this.constraint.assertTypeAnnotation();
                return super.visitTypeAnnotation(i11, typePath, str, z11);
            }
        }

        static {
            boolean z11 = false;
            String str = null;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z11 = true;
            }
            try {
                str = (String) doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (RuntimeException unused3) {
            }
            f27206u = str;
            ACCESS_CONTROLLER = z11;
            str = (String) doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            f27206u = str;
        }

        public Default(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            this.f27207a = typeDescription;
            this.f27208b = classFileVersion;
            this.f27209c = fieldPool;
            this.f27210d = recordComponentPool;
            this.f27211e = list;
            this.f27212f = fieldList;
            this.f27213g = methodList;
            this.f27214h = methodList2;
            this.f27215i = recordComponentList;
            this.f27216j = loadedTypeInitializer;
            this.f27217k = typeInitializer;
            this.f27218l = typeAttributeAppender;
            this.f27219m = asmVisitorWrapper;
            this.f27222p = namingStrategy;
            this.f27220n = factory;
            this.f27221o = annotationRetention;
            this.f27223q = factory2;
            this.f27224r = typeValidation;
            this.f27225s = classWriterStrategy;
            this.f27226t = typePool;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static <U> TypeWriter<U> forCreation(MethodRegistry.Compiled compiled, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            FieldPool fieldPool2 = fieldPool;
            RecordComponentPool recordComponentPool2 = recordComponentPool;
            ClassFileVersion classFileVersion2 = classFileVersion;
            return new ForCreation(compiled.getInstrumentedType(), classFileVersion2, fieldPool2, compiled, recordComponentPool2, list, compiled.getInstrumentedType().getDeclaredFields(), compiled.getMethods(), compiled.getInstrumentedMethods(), compiled.getInstrumentedType().getRecordComponents(), compiled.getLoadedTypeInitializer(), compiled.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
        }

        public static <U> TypeWriter<U> forDecoration(TypeDescription typeDescription, ClassFileVersion classFileVersion, List<? extends DynamicType> list, List<? extends MethodDescription> list2, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, ClassFileLocator classFileLocator) {
            return new ForInlining.WithDecorationOnly(typeDescription, classFileVersion, list, new MethodList.Explicit(list2), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, classFileLocator);
        }

        public static <U> TypeWriter<U> forRebasing(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodRebaseResolver methodRebaseResolver) {
            FieldPool fieldPool2 = fieldPool;
            RecordComponentPool recordComponentPool2 = recordComponentPool;
            TypeAttributeAppender typeAttributeAppender2 = typeAttributeAppender;
            AsmVisitorWrapper asmVisitorWrapper2 = asmVisitorWrapper;
            ClassFileVersion classFileVersion2 = classFileVersion;
            AnnotationValueFilter.Factory factory3 = factory;
            AnnotationRetention annotationRetention2 = annotationRetention;
            AuxiliaryType.NamingStrategy namingStrategy2 = namingStrategy;
            Implementation.Context.Factory factory4 = factory2;
            TypeValidation typeValidation2 = typeValidation;
            ClassWriterStrategy classWriterStrategy2 = classWriterStrategy;
            TypePool typePool2 = typePool;
            TypeDescription typeDescription2 = typeDescription;
            ClassFileLocator classFileLocator2 = classFileLocator;
            TypeDescription instrumentedType = prepared.getInstrumentedType();
            List<S> of2 = CompoundList.of(list, (List<? extends DynamicType>) methodRebaseResolver.getAuxiliaryTypes());
            FieldList<FieldDescription.InDefinedShape> declaredFields = prepared.getInstrumentedType().getDeclaredFields();
            MethodList<?> methods = prepared.getMethods();
            MethodList<?> instrumentedMethods = prepared.getInstrumentedMethods();
            RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents = prepared.getInstrumentedType().getRecordComponents();
            LoadedTypeInitializer loadedTypeInitializer = prepared.getLoadedTypeInitializer();
            TypeInitializer typeInitializer = prepared.getTypeInitializer();
            RebaseImplementationTarget.Factory factory5 = r0;
            RebaseImplementationTarget.Factory factory6 = new RebaseImplementationTarget.Factory(methodRebaseResolver);
            return new ForInlining.WithFullProcessing(instrumentedType, classFileVersion2, fieldPool2, recordComponentPool2, of2, declaredFields, methods, instrumentedMethods, recordComponents, loadedTypeInitializer, typeInitializer, typeAttributeAppender2, asmVisitorWrapper2, factory3, annotationRetention2, namingStrategy2, factory4, typeValidation2, classWriterStrategy2, typePool2, typeDescription2, classFileLocator2, prepared, factory5, methodRebaseResolver);
        }

        public static <U> TypeWriter<U> forRedefinition(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            List<? extends DynamicType> list2 = list;
            FieldPool fieldPool2 = fieldPool;
            RecordComponentPool recordComponentPool2 = recordComponentPool;
            TypeAttributeAppender typeAttributeAppender2 = typeAttributeAppender;
            AsmVisitorWrapper asmVisitorWrapper2 = asmVisitorWrapper;
            ClassFileVersion classFileVersion2 = classFileVersion;
            AnnotationValueFilter.Factory factory3 = factory;
            AnnotationRetention annotationRetention2 = annotationRetention;
            AuxiliaryType.NamingStrategy namingStrategy2 = namingStrategy;
            Implementation.Context.Factory factory4 = factory2;
            TypeValidation typeValidation2 = typeValidation;
            ClassWriterStrategy classWriterStrategy2 = classWriterStrategy;
            TypePool typePool2 = typePool;
            TypeDescription typeDescription2 = typeDescription;
            ClassFileLocator classFileLocator2 = classFileLocator;
            return new ForInlining.WithFullProcessing(prepared.getInstrumentedType(), classFileVersion2, fieldPool2, recordComponentPool2, list2, prepared.getInstrumentedType().getDeclaredFields(), prepared.getMethods(), prepared.getInstrumentedMethods(), prepared.getInstrumentedType().getRecordComponents(), prepared.getLoadedTypeInitializer(), prepared.getTypeInitializer(), typeAttributeAppender2, asmVisitorWrapper2, factory3, annotationRetention2, namingStrategy2, factory4, typeValidation2, classWriterStrategy2, typePool2, typeDescription2, classFileLocator2, prepared, SubclassImplementationTarget.Factory.LEVEL_TYPE, MethodRebaseResolver.Disabled.INSTANCE);
        }

        public abstract Default<S>.UnresolvedType c(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.f27221o.equals(defaultR.f27221o) && this.f27224r.equals(defaultR.f27224r) && this.f27207a.equals(defaultR.f27207a) && this.f27208b.equals(defaultR.f27208b) && this.f27209c.equals(defaultR.f27209c) && this.f27210d.equals(defaultR.f27210d) && this.f27211e.equals(defaultR.f27211e) && this.f27212f.equals(defaultR.f27212f) && this.f27213g.equals(defaultR.f27213g) && this.f27214h.equals(defaultR.f27214h) && this.f27215i.equals(defaultR.f27215i) && this.f27216j.equals(defaultR.f27216j) && this.f27217k.equals(defaultR.f27217k) && this.f27218l.equals(defaultR.f27218l) && this.f27219m.equals(defaultR.f27219m) && this.f27220n.equals(defaultR.f27220n) && this.f27222p.equals(defaultR.f27222p) && this.f27223q.equals(defaultR.f27223q) && this.f27225s.equals(defaultR.f27225s) && this.f27226t.equals(defaultR.f27226t);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.f27207a.hashCode()) * 31) + this.f27208b.hashCode()) * 31) + this.f27209c.hashCode()) * 31) + this.f27210d.hashCode()) * 31) + this.f27211e.hashCode()) * 31) + this.f27212f.hashCode()) * 31) + this.f27213g.hashCode()) * 31) + this.f27214h.hashCode()) * 31) + this.f27215i.hashCode()) * 31) + this.f27216j.hashCode()) * 31) + this.f27217k.hashCode()) * 31) + this.f27218l.hashCode()) * 31) + this.f27219m.hashCode()) * 31) + this.f27220n.hashCode()) * 31) + this.f27221o.hashCode()) * 31) + this.f27222p.hashCode()) * 31) + this.f27223q.hashCode()) * 31) + this.f27224r.hashCode()) * 31) + this.f27225s.hashCode()) * 31) + this.f27226t.hashCode();
        }

        @SuppressFBWarnings(justification = "Setting a debugging property should never change the program outcome", value = {"REC_CATCH_EXCEPTION"})
        public DynamicType.Unloaded<S> make(TypeResolutionStrategy.Resolved resolved) {
            ClassDumpAction.Dispatcher dispatcher;
            String str = f27206u;
            if (str == null) {
                dispatcher = ClassDumpAction.Dispatcher.Disabled.INSTANCE;
            } else {
                dispatcher = new ClassDumpAction.Dispatcher.Enabled(str, System.currentTimeMillis());
            }
            Default<S>.UnresolvedType c11 = c(resolved.injectedInto(this.f27217k), dispatcher);
            dispatcher.dump(this.f27207a, false, c11.a());
            return c11.b(resolved);
        }

        /* access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction) throws Exception {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedExceptionAction) : privilegedExceptionAction.run();
        }
    }

    public interface MethodPool {

        public interface Record {

            @HashCodeAndEqualsPlugin.Enhance
            public static class AccessBridgeWrapper implements Record {
                private final MethodAttributeAppender attributeAppender;
                private final MethodDescription bridgeTarget;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final Record delegate;
                private final TypeDescription instrumentedType;

                public static class AccessorBridge extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final MethodDescription.TypeToken bridgeType;
                    private final TypeDescription instrumentedType;

                    public AccessorBridge(MethodDescription methodDescription, MethodDescription.TypeToken typeToken, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.bridgeType = typeToken;
                        this.instrumentedType = typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    public AnnotationValue<?, ?> getDefaultValue() {
                        return AnnotationValue.UNDEFINED;
                    }

                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes().accept(TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
                    }

                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    public int getModifiers() {
                        return (this.bridgeTarget.getModifiers() | 64 | 4096) & -1281;
                    }

                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.bridgeType.getParameterTypes());
                    }

                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeType.getReturnType().asGenericType();
                    }

                    public TypeList.Generic getTypeVariables() {
                        return new TypeList.Generic.Empty();
                    }

                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                public static class BridgeTarget extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription instrumentedType;

                    public BridgeTarget(MethodDescription methodDescription, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.instrumentedType = typeDescription;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return this.bridgeTarget.getDeclaredAnnotations();
                    }

                    public AnnotationValue<?, ?> getDefaultValue() {
                        return this.bridgeTarget.getDefaultValue();
                    }

                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes();
                    }

                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    public int getModifiers() {
                        return this.bridgeTarget.getModifiers();
                    }

                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.ForTokens(this, this.bridgeTarget.getParameters().asTokenList(ElementMatchers.is((Object) this.instrumentedType)));
                    }

                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeTarget.getReturnType();
                    }

                    public TypeList.Generic getTypeVariables() {
                        return this.bridgeTarget.getTypeVariables();
                    }

                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                public AccessBridgeWrapper(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    this.delegate = record;
                    this.instrumentedType = typeDescription;
                    this.bridgeTarget = methodDescription;
                    this.bridgeTypes = set;
                    this.attributeAppender = methodAttributeAppender;
                }

                public static Record of(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    HashSet hashSet = new HashSet();
                    for (MethodDescription.TypeToken next : set) {
                        if (methodDescription.isBridgeCompatible(next)) {
                            hashSet.add(next);
                        }
                    }
                    if (hashSet.isEmpty()) {
                        return record;
                    }
                    if (!typeDescription.isInterface() || record.getSort().isImplemented()) {
                        return new AccessBridgeWrapper(record, typeDescription, methodDescription, hashSet, methodAttributeAppender);
                    }
                    return record;
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    StackManipulation stackManipulation;
                    this.delegate.apply(classVisitor, context, factory);
                    for (MethodDescription.TypeToken accessorBridge : this.bridgeTypes) {
                        AccessorBridge accessorBridge2 = new AccessorBridge(this.bridgeTarget, accessorBridge, this.instrumentedType);
                        BridgeTarget bridgeTarget2 = new BridgeTarget(this.bridgeTarget, this.instrumentedType);
                        MethodVisitor visitMethod = classVisitor.visitMethod(accessorBridge2.getActualModifiers(true, getVisibility()), accessorBridge2.getInternalName(), accessorBridge2.getDescriptor(), NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE, accessorBridge2.getExceptionTypes().asErasures().toInternalNames());
                        if (visitMethod != null) {
                            this.attributeAppender.apply(visitMethod, accessorBridge2, factory.on(this.instrumentedType));
                            visitMethod.visitCode();
                            StackManipulation[] stackManipulationArr = new StackManipulation[4];
                            stackManipulationArr[0] = MethodVariableAccess.allArgumentsOf(accessorBridge2).asBridgeOf(bridgeTarget2).prependThisReference();
                            stackManipulationArr[1] = MethodInvocation.invoke((MethodDescription.InDefinedShape) bridgeTarget2).virtual(this.instrumentedType);
                            if (bridgeTarget2.getReturnType().asErasure().isAssignableTo(accessorBridge2.getReturnType().asErasure())) {
                                stackManipulation = StackManipulation.Trivial.INSTANCE;
                            } else {
                                stackManipulation = TypeCasting.to(accessorBridge2.getReturnType().asErasure());
                            }
                            stackManipulationArr[2] = stackManipulation;
                            stackManipulationArr[3] = MethodReturn.of(accessorBridge2.getReturnType());
                            ByteCodeAppender.Size apply = new ByteCodeAppender.Simple(stackManipulationArr).apply(visitMethod, context, accessorBridge2);
                            visitMethod.visitMaxs(apply.getOperandStackSize(), apply.getLocalVariableSize());
                            visitMethod.visitEnd();
                        }
                    }
                }

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyAttributes(methodVisitor, factory);
                }

                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyBody(methodVisitor, context, factory);
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    return this.delegate.applyCode(methodVisitor, context);
                }

                public void applyHead(MethodVisitor methodVisitor) {
                    this.delegate.applyHead(methodVisitor);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AccessBridgeWrapper accessBridgeWrapper = (AccessBridgeWrapper) obj;
                    return this.delegate.equals(accessBridgeWrapper.delegate) && this.instrumentedType.equals(accessBridgeWrapper.instrumentedType) && this.bridgeTarget.equals(accessBridgeWrapper.bridgeTarget) && this.bridgeTypes.equals(accessBridgeWrapper.bridgeTypes) && this.attributeAppender.equals(accessBridgeWrapper.attributeAppender);
                }

                public MethodDescription getMethod() {
                    return this.bridgeTarget;
                }

                public Sort getSort() {
                    return this.delegate.getSort();
                }

                public Visibility getVisibility() {
                    return this.delegate.getVisibility();
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeTypes.hashCode()) * 31) + this.attributeAppender.hashCode();
                }

                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    return new AccessBridgeWrapper(this.delegate.prepend(byteCodeAppender), this.instrumentedType, this.bridgeTarget, this.bridgeTypes, this.attributeAppender);
                }
            }

            public static abstract class ForDefinedMethod implements Record {

                @HashCodeAndEqualsPlugin.Enhance
                public static class OfVisibilityBridge extends ForDefinedMethod implements ByteCodeAppender {
                    private final MethodAttributeAppender attributeAppender;
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription bridgeType;
                    private final MethodDescription visibilityBridge;

                    public static class VisibilityBridge extends MethodDescription.InDefinedShape.AbstractBase {
                        private final MethodDescription bridgeTarget;
                        private final TypeDescription instrumentedType;

                        public VisibilityBridge(TypeDescription typeDescription, MethodDescription methodDescription) {
                            this.instrumentedType = typeDescription;
                            this.bridgeTarget = methodDescription;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return this.bridgeTarget.getDeclaredAnnotations();
                        }

                        public AnnotationValue<?, ?> getDefaultValue() {
                            return AnnotationValue.UNDEFINED;
                        }

                        public TypeList.Generic getExceptionTypes() {
                            return this.bridgeTarget.getExceptionTypes().asRawTypes();
                        }

                        public String getInternalName() {
                            return this.bridgeTarget.getName();
                        }

                        public int getModifiers() {
                            return (this.bridgeTarget.getModifiers() | 4096 | 64) & -257;
                        }

                        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                            return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.bridgeTarget.getParameters().asTypeList().asRawTypes());
                        }

                        public TypeDescription.Generic getReturnType() {
                            return this.bridgeTarget.getReturnType().asRawType();
                        }

                        public TypeList.Generic getTypeVariables() {
                            return new TypeList.Generic.Empty();
                        }

                        public TypeDescription getDeclaringType() {
                            return this.instrumentedType;
                        }
                    }

                    public OfVisibilityBridge(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDescription typeDescription, MethodAttributeAppender methodAttributeAppender) {
                        this.visibilityBridge = methodDescription;
                        this.bridgeTarget = methodDescription2;
                        this.bridgeType = typeDescription;
                        this.attributeAppender = methodAttributeAppender;
                    }

                    public static Record of(TypeDescription typeDescription, MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender) {
                        TypeDefinition typeDefinition = null;
                        if (methodDescription.isDefaultMethod()) {
                            TypeDescription asErasure = methodDescription.getDeclaringType().asErasure();
                            for (TypeDescription typeDescription2 : (TypeList) typeDescription.getInterfaces().asErasures().filter(ElementMatchers.isSubTypeOf(asErasure))) {
                                if (typeDefinition == null || asErasure.isAssignableTo(typeDefinition.asErasure())) {
                                    typeDefinition = typeDescription2;
                                }
                            }
                        }
                        if (typeDefinition == null) {
                            typeDefinition = typeDescription.getSuperClass();
                        }
                        return new OfVisibilityBridge(new VisibilityBridge(typeDescription, methodDescription), methodDescription, typeDefinition.asErasure(), methodAttributeAppender);
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        return new ByteCodeAppender.Simple(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), MethodInvocation.invoke(this.bridgeTarget).special(this.bridgeType), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.attributeAppender;
                        MethodDescription methodDescription = this.visibilityBridge;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return apply(methodVisitor, context, this.visibilityBridge);
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
                        OfVisibilityBridge ofVisibilityBridge = (OfVisibilityBridge) obj;
                        return this.visibilityBridge.equals(ofVisibilityBridge.visibilityBridge) && this.bridgeTarget.equals(ofVisibilityBridge.bridgeTarget) && this.bridgeType.equals(ofVisibilityBridge.bridgeType) && this.attributeAppender.equals(ofVisibilityBridge.attributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.visibilityBridge;
                    }

                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    public Visibility getVisibility() {
                        return this.bridgeTarget.getVisibility();
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.visibilityBridge.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeType.hashCode()) * 31) + this.attributeAppender.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.visibilityBridge, new ByteCodeAppender.Compound(this, byteCodeAppender), this.attributeAppender, this.bridgeTarget.getVisibility());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithAnnotationDefaultValue extends ForDefinedMethod {
                    private final AnnotationValue<?, ?> annotationValue;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;

                    public WithAnnotationDefaultValue(MethodDescription methodDescription2, AnnotationValue<?, ?> annotationValue2, MethodAttributeAppender methodAttributeAppender2) {
                        this.methodDescription = methodDescription2;
                        this.annotationValue = annotationValue2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        throw new IllegalStateException("Cannot apply attributes for default value on " + this.methodDescription);
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for default value on " + this.methodDescription);
                    }

                    public void applyHead(MethodVisitor methodVisitor) {
                        if (this.methodDescription.isDefaultValue(this.annotationValue)) {
                            AnnotationVisitor visitAnnotationDefault = methodVisitor.visitAnnotationDefault();
                            AnnotationAppender.Default.apply(visitAnnotationDefault, this.methodDescription.getReturnType().asErasure(), AnnotationAppender.NO_NAME, this.annotationValue.resolve());
                            visitAnnotationDefault.visitEnd();
                            return;
                        }
                        throw new IllegalStateException("Cannot set " + this.annotationValue + " as default for " + this.methodDescription);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithAnnotationDefaultValue withAnnotationDefaultValue = (WithAnnotationDefaultValue) obj;
                        return this.methodDescription.equals(withAnnotationDefaultValue.methodDescription) && this.annotationValue.equals(withAnnotationDefaultValue.annotationValue) && this.methodAttributeAppender.equals(withAnnotationDefaultValue.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    public Visibility getVisibility() {
                        return this.methodDescription.getVisibility();
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.annotationValue.hashCode()) * 31) + this.methodAttributeAppender.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for default value on " + this.methodDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithBody extends ForDefinedMethod {
                    private final ByteCodeAppender byteCodeAppender;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithBody(MethodDescription methodDescription2, ByteCodeAppender byteCodeAppender2) {
                        this(methodDescription2, byteCodeAppender2, MethodAttributeAppender.NoOp.INSTANCE, methodDescription2.getVisibility());
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size applyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(applyCode.getOperandStackSize(), applyCode.getLocalVariableSize());
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return this.byteCodeAppender.apply(methodVisitor, context, this.methodDescription);
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
                        WithBody withBody = (WithBody) obj;
                        return this.visibility.equals(withBody.visibility) && this.methodDescription.equals(withBody.methodDescription) && this.byteCodeAppender.equals(withBody.byteCodeAppender) && this.methodAttributeAppender.equals(withBody.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.byteCodeAppender.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender2) {
                        return new WithBody(this.methodDescription, new ByteCodeAppender.Compound(byteCodeAppender2, this.byteCodeAppender), this.methodAttributeAppender, this.visibility);
                    }

                    public WithBody(MethodDescription methodDescription2, ByteCodeAppender byteCodeAppender2, MethodAttributeAppender methodAttributeAppender2, Visibility visibility2) {
                        this.methodDescription = methodDescription2;
                        this.byteCodeAppender = byteCodeAppender2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                        this.visibility = visibility2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithoutBody extends ForDefinedMethod {
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithoutBody(MethodDescription methodDescription2, MethodAttributeAppender methodAttributeAppender2, Visibility visibility2) {
                        this.methodDescription = methodDescription2;
                        this.methodAttributeAppender = methodAttributeAppender2;
                        this.visibility = visibility2;
                    }

                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender2 = this.methodAttributeAppender;
                        MethodDescription methodDescription2 = this.methodDescription;
                        methodAttributeAppender2.apply(methodVisitor, methodDescription2, factory.on(methodDescription2));
                    }

                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                    }

                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for abstract method on " + this.methodDescription);
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
                        WithoutBody withoutBody = (WithoutBody) obj;
                        return this.visibility.equals(withoutBody.visibility) && this.methodDescription.equals(withoutBody.methodDescription) && this.methodAttributeAppender.equals(withoutBody.methodAttributeAppender);
                    }

                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for abstract method on " + this.methodDescription);
                    }
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    MethodVisitor visitMethod = classVisitor.visitMethod(getMethod().getActualModifiers(getSort().isImplemented(), getVisibility()), getMethod().getInternalName(), getMethod().getDescriptor(), getMethod().getGenericSignature(), getMethod().getExceptionTypes().asErasures().toInternalNames());
                    if (visitMethod != null) {
                        ParameterList<?> parameters = getMethod().getParameters();
                        if (parameters.hasExplicitMetaData()) {
                            Iterator<E> it = parameters.iterator();
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                visitMethod.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                            }
                        }
                        applyHead(visitMethod);
                        applyBody(visitMethod, context, factory);
                        visitMethod.visitEnd();
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForNonImplementedMethod implements Record {
                private final MethodDescription methodDescription;

                public ForNonImplementedMethod(MethodDescription methodDescription2) {
                    this.methodDescription = methodDescription2;
                }

                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                }

                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("Cannot apply body for non-implemented method on " + this.methodDescription);
                }

                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    throw new IllegalStateException("Cannot apply code for non-implemented method on " + this.methodDescription);
                }

                public void applyHead(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Cannot apply head for non-implemented method on " + this.methodDescription);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForNonImplementedMethod) obj).methodDescription);
                }

                public MethodDescription getMethod() {
                    return this.methodDescription;
                }

                public Sort getSort() {
                    return Sort.SKIPPED;
                }

                public Visibility getVisibility() {
                    return this.methodDescription.getVisibility();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                }

                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    MethodDescription methodDescription2 = this.methodDescription;
                    return new ForDefinedMethod.WithBody(methodDescription2, new ByteCodeAppender.Compound(byteCodeAppender, new ByteCodeAppender.Simple(DefaultValue.of(methodDescription2.getReturnType()), MethodReturn.of(this.methodDescription.getReturnType()))));
                }
            }

            public enum Sort {
                SKIPPED(false, false),
                DEFINED(true, false),
                IMPLEMENTED(true, true);
                
                private final boolean define;
                private final boolean implement;

                private Sort(boolean z11, boolean z12) {
                    this.define = z11;
                    this.implement = z12;
                }

                public boolean isDefined() {
                    return this.define;
                }

                public boolean isImplemented() {
                    return this.implement;
                }
            }

            void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory);

            void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context);

            void applyHead(MethodVisitor methodVisitor);

            MethodDescription getMethod();

            Sort getSort();

            Visibility getVisibility();

            Record prepend(ByteCodeAppender byteCodeAppender);
        }

        Record target(MethodDescription methodDescription);
    }

    DynamicType.Unloaded<T> make(TypeResolutionStrategy.Resolved resolved);

    public interface RecordComponentPool {

        public enum Disabled implements RecordComponentPool {
            INSTANCE;

            public Record target(RecordComponentDescription recordComponentDescription) {
                throw new IllegalStateException("Cannot look up record component from disabled pool");
            }
        }

        Record target(RecordComponentDescription recordComponentDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory);

            RecordComponentDescription getRecordComponent();

            RecordComponentAttributeAppender getRecordComponentAppender();

            boolean isImplicit();

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitRecordComponent implements Record {
                private final RecordComponentAttributeAppender attributeAppender;
                private final RecordComponentDescription recordComponentDescription;

                public ForExplicitRecordComponent(RecordComponentAttributeAppender recordComponentAttributeAppender, RecordComponentDescription recordComponentDescription2) {
                    this.attributeAppender = recordComponentAttributeAppender;
                    this.recordComponentDescription = recordComponentDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (visitRecordComponent != null) {
                        RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                        RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                        recordComponentAttributeAppender.apply(visitRecordComponent, recordComponentDescription2, factory.on(recordComponentDescription2));
                        visitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForExplicitRecordComponent forExplicitRecordComponent = (ForExplicitRecordComponent) obj;
                    return this.attributeAppender.equals(forExplicitRecordComponent.attributeAppender) && this.recordComponentDescription.equals(forExplicitRecordComponent.recordComponentDescription);
                }

                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31) + this.recordComponentDescription.hashCode();
                }

                public boolean isImplicit() {
                    return false;
                }

                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                    RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                    recordComponentAttributeAppender.apply(recordComponentVisitor, recordComponentDescription2, factory.on(recordComponentDescription2));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitRecordComponent implements Record {
                private final RecordComponentDescription recordComponentDescription;

                public ForImplicitRecordComponent(RecordComponentDescription recordComponentDescription2) {
                    this.recordComponentDescription = recordComponentDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (visitRecordComponent != null) {
                        RecordComponentAttributeAppender.ForInstrumentedRecordComponent forInstrumentedRecordComponent = RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE;
                        RecordComponentDescription recordComponentDescription2 = this.recordComponentDescription;
                        forInstrumentedRecordComponent.apply(visitRecordComponent, recordComponentDescription2, factory.on(recordComponentDescription2));
                        visitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.recordComponentDescription.equals(((ForImplicitRecordComponent) obj).recordComponentDescription);
                }

                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.recordComponentDescription.hashCode();
                }

                public boolean isImplicit() {
                    return true;
                }

                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }

    public interface FieldPool {

        public enum Disabled implements FieldPool {
            INSTANCE;

            public Record target(FieldDescription fieldDescription) {
                throw new IllegalStateException("Cannot look up field from disabled pool");
            }
        }

        Record target(FieldDescription fieldDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory);

            FieldDescription getField();

            FieldAttributeAppender getFieldAppender();

            boolean isImplicit();

            Object resolveDefault(Object obj);

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitField implements Record {
                private final FieldAttributeAppender attributeAppender;
                private final Object defaultValue;
                private final FieldDescription fieldDescription;

                public ForExplicitField(FieldAttributeAppender fieldAttributeAppender, Object obj, FieldDescription fieldDescription2) {
                    this.attributeAppender = fieldAttributeAppender;
                    this.defaultValue = obj;
                    this.fieldDescription = fieldDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor visitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), resolveDefault(FieldDescription.NO_DEFAULT_VALUE));
                    if (visitField != null) {
                        FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                        FieldDescription fieldDescription2 = this.fieldDescription;
                        fieldAttributeAppender.apply(visitField, fieldDescription2, factory.on(fieldDescription2));
                        visitField.visitEnd();
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForExplicitField forExplicitField = (ForExplicitField) obj;
                    return this.attributeAppender.equals(forExplicitField.attributeAppender) && this.defaultValue.equals(forExplicitField.defaultValue) && this.fieldDescription.equals(forExplicitField.fieldDescription);
                }

                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                public FieldAttributeAppender getFieldAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31) + this.defaultValue.hashCode()) * 31) + this.fieldDescription.hashCode();
                }

                public boolean isImplicit() {
                    return false;
                }

                public Object resolveDefault(Object obj) {
                    Object obj2 = this.defaultValue;
                    return obj2 == null ? obj : obj2;
                }

                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                    FieldDescription fieldDescription2 = this.fieldDescription;
                    fieldAttributeAppender.apply(fieldVisitor, fieldDescription2, factory.on(fieldDescription2));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitField implements Record {
                private final FieldDescription fieldDescription;

                public ForImplicitField(FieldDescription fieldDescription2) {
                    this.fieldDescription = fieldDescription2;
                }

                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor visitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (visitField != null) {
                        FieldAttributeAppender.ForInstrumentedField forInstrumentedField = FieldAttributeAppender.ForInstrumentedField.INSTANCE;
                        FieldDescription fieldDescription2 = this.fieldDescription;
                        forInstrumentedField.apply(visitField, fieldDescription2, factory.on(fieldDescription2));
                        visitField.visitEnd();
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForImplicitField) obj).fieldDescription);
                }

                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                public FieldAttributeAppender getFieldAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public boolean isImplicit() {
                    return true;
                }

                public Object resolveDefault(Object obj) {
                    throw new IllegalStateException("An implicit field record does not expose a default value: " + this);
                }

                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }
}
