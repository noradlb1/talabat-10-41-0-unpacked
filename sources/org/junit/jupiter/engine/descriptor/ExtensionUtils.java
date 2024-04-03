package org.junit.jupiter.engine.descriptor;

import d30.o0;
import d30.p0;
import d30.q0;
import d30.r0;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.DesugarArrays;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import x20.i;

final class ExtensionUtils {
    private static final Comparator<Field> orderComparator = Comparator.CC.comparingInt(new v());

    private ExtensionUtils() {
    }

    /* access modifiers changed from: private */
    public static int getOrder(Field field) {
        return ((Integer) AnnotationUtils.findAnnotation((AnnotatedElement) field, Order.class).map(new i()).orElse(1073741823)).intValue();
    }

    public static MutableExtensionRegistry i(MutableExtensionRegistry mutableExtensionRegistry, AnnotatedElement annotatedElement) {
        Preconditions.notNull(mutableExtensionRegistry, "Parent ExtensionRegistry must not be null");
        Preconditions.notNull(annotatedElement, "AnnotatedElement must not be null");
        return MutableExtensionRegistry.createRegistryFrom(mutableExtensionRegistry, streamExtensionTypes(annotatedElement));
    }

    public static void j(ExtensionRegistrar extensionRegistrar, Class<?> cls) {
        k(extensionRegistrar, ReflectionUtils.getDeclaredConstructor(cls));
    }

    public static void k(ExtensionRegistrar extensionRegistrar, Executable executable) {
        Preconditions.notNull(extensionRegistrar, "ExtensionRegistrar must not be null");
        Preconditions.notNull(executable, "Executable must not be null");
        Stream flatMap = DesugarArrays.stream((T[]) executable.getParameters()).map(new q(new AtomicInteger())).flatMap(new r());
        Objects.requireNonNull(extensionRegistrar);
        flatMap.forEach(new q0(extensionRegistrar));
    }

    public static void l(ExtensionRegistrar extensionRegistrar, Class<?> cls, Object obj) {
        Predicate predicate;
        Preconditions.notNull(extensionRegistrar, "ExtensionRegistrar must not be null");
        Preconditions.notNull(cls, "Class must not be null");
        if (obj == null) {
            new r0
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r0v6 ? I:d30.r0) =  call: d30.r0.<init>():void type: CONSTRUCTOR in method: org.junit.jupiter.engine.descriptor.ExtensionUtils.l(org.junit.jupiter.engine.extension.ExtensionRegistrar, java.lang.Class, java.lang.Object):void, dex: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v6 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                java.lang.String r0 = "ExtensionRegistrar must not be null"
                org.junit.platform.commons.util.Preconditions.notNull(r2, (java.lang.String) r0)
                java.lang.String r0 = "Class must not be null"
                org.junit.platform.commons.util.Preconditions.notNull(r3, (java.lang.String) r0)
                if (r4 != 0) goto L_0x0012
                d30.r0 r0 = new d30.r0
                r0.<init>()
                goto L_0x0017
            L_0x0012:
                d30.s0 r0 = new d30.s0
                r0.<init>()
            L_0x0017:
                org.junit.platform.commons.util.ReflectionUtils$HierarchyTraversalMode r1 = org.junit.platform.commons.util.ReflectionUtils.HierarchyTraversalMode.TOP_DOWN
                java.util.List r3 = org.junit.platform.commons.util.ReflectionUtils.findFields(r3, r0, r1)
                j$.util.stream.Stream r3 = j$.util.Collection.EL.stream(r3)
                java.util.Comparator<java.lang.reflect.Field> r0 = orderComparator
                j$.util.stream.Stream r3 = r3.sorted(r0)
                org.junit.jupiter.engine.descriptor.u r0 = new org.junit.jupiter.engine.descriptor.u
                r0.<init>(r2, r4)
                r3.forEach(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.descriptor.ExtensionUtils.l(org.junit.jupiter.engine.extension.ExtensionRegistrar, java.lang.Class, java.lang.Object):void");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String lambda$registerExtensionsFromFields$0(Field field, Object obj) {
            String str;
            Object[] objArr = new Object[3];
            objArr[0] = field;
            if (obj != null) {
                str = obj.getClass().getName();
            } else {
                str = null;
            }
            objArr[1] = str;
            objArr[2] = Extension.class.getName();
            return String.format("Failed to register extension via @RegisterExtension field [%s]: field value's type [%s] must implement an [%s] API.", objArr);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$registerExtensionsFromFields$3(Field field, boolean z11, List list, ExtensionRegistrar extensionRegistrar, Object obj) {
            Preconditions.condition(obj instanceof Extension, (Supplier<String>) new o(field, obj));
            if (z11) {
                Iterable.EL.forEach(list, new p(obj.getClass(), field));
            }
            extensionRegistrar.registerExtension((Extension) obj, field);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$registerExtensionsFromFields$4(ExtensionRegistrar extensionRegistrar, Object obj, Field field) {
            List list = (List) streamExtensionTypes((AnnotatedElement) field).collect(Collectors.toList());
            boolean z11 = !list.isEmpty();
            boolean isAnnotated = AnnotationUtils.isAnnotated((AnnotatedElement) field, (Class<? extends Annotation>) RegisterExtension.class);
            if (z11) {
                Objects.requireNonNull(extensionRegistrar);
                Iterable.EL.forEach(list, new q0(extensionRegistrar));
            }
            if (isAnnotated) {
                ReflectionUtils.tryToReadFieldValue(field, obj).ifSuccess(new t(field, z11, list, extensionRegistrar));
            }
        }

        private static Stream<Class<? extends Extension>> streamExtensionTypes(AnnotatedElement annotatedElement) {
            return streamExtensionTypes((List<ExtendWith>) AnnotationUtils.findRepeatableAnnotations(annotatedElement, ExtendWith.class));
        }

        /* access modifiers changed from: private */
        public static Stream<Class<? extends Extension>> streamExtensionTypes(List<ExtendWith> list) {
            return Collection.EL.stream(list).map(new o0()).flatMap(new p0());
        }
    }
