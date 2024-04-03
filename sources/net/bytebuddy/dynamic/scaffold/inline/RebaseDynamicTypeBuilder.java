package net.bytebuddy.dynamic.scaffold.inline;

import java.util.HashSet;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;

@HashCodeAndEqualsPlugin.Enhance
public class RebaseDynamicTypeBuilder<T> extends AbstractInliningDynamicTypeBuilder<T> {
    private final MethodNameTransformer methodNameTransformer;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RebaseDynamicTypeBuilder(net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName r22, net.bytebuddy.ClassFileVersion r23, net.bytebuddy.implementation.auxiliary.AuxiliaryType.NamingStrategy r24, net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory r25, net.bytebuddy.implementation.attribute.AnnotationRetention r26, net.bytebuddy.implementation.Implementation.Context.Factory r27, net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler r28, net.bytebuddy.dynamic.scaffold.TypeValidation r29, net.bytebuddy.dynamic.VisibilityBridgeStrategy r30, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy r31, net.bytebuddy.matcher.LatentMatcher<? super net.bytebuddy.description.method.MethodDescription> r32, net.bytebuddy.description.type.TypeDescription r33, net.bytebuddy.dynamic.ClassFileLocator r34, net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer r35) {
        /*
            r21 = this;
            net.bytebuddy.dynamic.scaffold.FieldRegistry$Default r2 = new net.bytebuddy.dynamic.scaffold.FieldRegistry$Default
            r2.<init>()
            net.bytebuddy.dynamic.scaffold.MethodRegistry$Default r3 = new net.bytebuddy.dynamic.scaffold.MethodRegistry$Default
            r3.<init>()
            net.bytebuddy.dynamic.scaffold.RecordComponentRegistry$Default r4 = new net.bytebuddy.dynamic.scaffold.RecordComponentRegistry$Default
            r4.<init>()
            boolean r0 = r26.isEnabled()
            if (r0 == 0) goto L_0x001d
            net.bytebuddy.implementation.attribute.TypeAttributeAppender$ForInstrumentedType$Differentiating r0 = new net.bytebuddy.implementation.attribute.TypeAttributeAppender$ForInstrumentedType$Differentiating
            r15 = r33
            r0.<init>(r15)
            goto L_0x0021
        L_0x001d:
            r15 = r33
            net.bytebuddy.implementation.attribute.TypeAttributeAppender$ForInstrumentedType r0 = net.bytebuddy.implementation.attribute.TypeAttributeAppender.ForInstrumentedType.INSTANCE
        L_0x0021:
            r5 = r0
            net.bytebuddy.asm.AsmVisitorWrapper$NoOp r6 = net.bytebuddy.asm.AsmVisitorWrapper.NoOp.INSTANCE
            java.util.List r17 = java.util.Collections.emptyList()
            r0 = r21
            r1 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            r16 = r32
            r18 = r33
            r19 = r34
            r20 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder.<init>(net.bytebuddy.dynamic.scaffold.InstrumentedType$WithFlexibleName, net.bytebuddy.ClassFileVersion, net.bytebuddy.implementation.auxiliary.AuxiliaryType$NamingStrategy, net.bytebuddy.implementation.attribute.AnnotationValueFilter$Factory, net.bytebuddy.implementation.attribute.AnnotationRetention, net.bytebuddy.implementation.Implementation$Context$Factory, net.bytebuddy.dynamic.scaffold.MethodGraph$Compiler, net.bytebuddy.dynamic.scaffold.TypeValidation, net.bytebuddy.dynamic.VisibilityBridgeStrategy, net.bytebuddy.dynamic.scaffold.ClassWriterStrategy, net.bytebuddy.matcher.LatentMatcher, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.dynamic.ClassFileLocator, net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer):void");
    }

    public DynamicType.Builder<T> a(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
        return new RebaseDynamicTypeBuilder(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, latentMatcher, list, this.f27247r, this.f27248s, this.methodNameTransformer);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.methodNameTransformer.equals(((RebaseDynamicTypeBuilder) obj).methodNameTransformer);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.methodNameTransformer.hashCode();
    }

    public DynamicType.Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
        TypePool typePool2 = typePool;
        MethodRegistry.Prepared prepare = this.f27134c.prepare(this.f27132a, this.f27143l, this.f27144m, this.f27145n, InliningImplementationMatcher.a(this.f27147p, this.f27247r));
        MethodRegistry.Prepared prepared = prepare;
        HashSet hashSet = new HashSet(this.f27247r.getDeclaredMethods().asSignatureTokenList(ElementMatchers.is((Object) this.f27247r), this.f27132a));
        hashSet.retainAll(prepare.getInstrumentedMethods().asSignatureTokenList());
        MethodRebaseResolver make = MethodRebaseResolver.Default.make(prepare.getInstrumentedType(), hashSet, this.f27138g, this.f27139h, this.methodNameTransformer);
        return TypeWriter.Default.forRebasing(prepared, this.f27148q, this.f27133b.compile(prepare.getInstrumentedType()), this.f27135d.compile(prepare.getInstrumentedType()), this.f27136e, this.f27137f, this.f27138g, this.f27140i, this.f27141j, this.f27139h, this.f27142k, this.f27144m, this.f27146o, typePool2, this.f27247r, this.f27248s, make).make(typeResolutionStrategy.resolve());
    }

    public RebaseDynamicTypeBuilder(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list, TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer2) {
        super(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, classWriterStrategy, latentMatcher, list, typeDescription, classFileLocator);
        this.methodNameTransformer = methodNameTransformer2;
    }
}
