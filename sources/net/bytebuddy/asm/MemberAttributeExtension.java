package net.bytebuddy.asm;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
public abstract class MemberAttributeExtension<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AnnotationValueFilter.Factory f27074b;

    /* renamed from: c  reason: collision with root package name */
    public final T f27075c;

    public static class ForField extends MemberAttributeExtension<FieldAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper {

        public static class FieldAttributeVisitor extends FieldVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private final FieldAttributeAppender fieldAttributeAppender;
            private final FieldDescription fieldDescription;

            public void visitEnd() {
                this.fieldAttributeAppender.apply(this.f27379b, this.fieldDescription, this.annotationValueFilter);
                super.visitEnd();
            }

            private FieldAttributeVisitor(FieldVisitor fieldVisitor, FieldDescription fieldDescription2, FieldAttributeAppender fieldAttributeAppender2, AnnotationValueFilter annotationValueFilter2) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
                this.fieldDescription = fieldDescription2;
                this.fieldAttributeAppender = fieldAttributeAppender2;
                this.annotationValueFilter = annotationValueFilter2;
            }
        }

        public ForField() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForField annotate(Annotation... annotationArr) {
            return annotate((List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForField attribute(FieldAttributeAppender.Factory factory) {
            return new ForField(this.f27074b, new FieldAttributeAppender.Factory.Compound((FieldAttributeAppender.Factory) this.f27075c, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredFields().field(elementMatcher, this);
        }

        public FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor) {
            return new FieldAttributeVisitor(fieldVisitor, inDefinedShape, ((FieldAttributeAppender.Factory) this.f27075c).make(typeDescription), this.f27074b.on((FieldDescription) inDefinedShape));
        }

        public ForField(AnnotationValueFilter.Factory factory) {
            this(factory, FieldAttributeAppender.NoOp.INSTANCE);
        }

        public ForField annotate(List<? extends Annotation> list) {
            return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForField(AnnotationValueFilter.Factory factory, FieldAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForField annotate(AnnotationDescription... annotationDescriptionArr) {
            return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForField annotate(Collection<? extends AnnotationDescription> collection) {
            return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
        }
    }

    public static class ForMethod extends MemberAttributeExtension<MethodAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {

        public static class AttributeAppendingMethodVisitor extends MethodVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private boolean applicable;
            private final MethodAttributeAppender methodAttributeAppender;
            private final MethodDescription methodDescription;

            public void visitCode() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.f27400c, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitCode();
            }

            public void visitEnd() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.f27400c, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitEnd();
            }

            private AttributeAppendingMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription2, MethodAttributeAppender methodAttributeAppender2, AnnotationValueFilter annotationValueFilter2) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.methodDescription = methodDescription2;
                this.methodAttributeAppender = methodAttributeAppender2;
                this.annotationValueFilter = annotationValueFilter2;
                this.applicable = true;
            }
        }

        public ForMethod() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForMethod annotateMethod(Annotation... annotationArr) {
            return annotateMethod((List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForMethod annotateParameter(int i11, Annotation... annotationArr) {
            return annotateParameter(i11, (List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForMethod attribute(MethodAttributeAppender.Factory factory) {
            return new ForMethod(this.f27074b, new MethodAttributeAppender.Factory.Compound((MethodAttributeAppender.Factory) this.f27075c, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super MethodDescription> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
        }

        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
            return new AttributeAppendingMethodVisitor(methodVisitor, methodDescription, ((MethodAttributeAppender.Factory) this.f27075c).make(typeDescription), this.f27074b.on(methodDescription));
        }

        public ForMethod(AnnotationValueFilter.Factory factory) {
            this(factory, MethodAttributeAppender.NoOp.INSTANCE);
        }

        public ForMethod annotateMethod(List<? extends Annotation> list) {
            return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForMethod annotateParameter(int i11, List<? extends Annotation> list) {
            return annotateParameter(i11, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForMethod(AnnotationValueFilter.Factory factory, MethodAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForMethod annotateMethod(AnnotationDescription... annotationDescriptionArr) {
            return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateParameter(int i11, AnnotationDescription... annotationDescriptionArr) {
            return annotateParameter(i11, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateMethod(Collection<? extends AnnotationDescription> collection) {
            return attribute(new MethodAttributeAppender.Explicit(new ArrayList(collection)));
        }

        public ForMethod annotateParameter(int i11, Collection<? extends AnnotationDescription> collection) {
            if (i11 >= 0) {
                return attribute(new MethodAttributeAppender.Explicit(i11, (List<? extends AnnotationDescription>) new ArrayList(collection)));
            }
            throw new IllegalArgumentException("Parameter index cannot be negative: " + i11);
        }
    }

    public MemberAttributeExtension(AnnotationValueFilter.Factory factory, T t11) {
        this.f27074b = factory;
        this.f27075c = t11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberAttributeExtension memberAttributeExtension = (MemberAttributeExtension) obj;
        return this.f27074b.equals(memberAttributeExtension.f27074b) && this.f27075c.equals(memberAttributeExtension.f27075c);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.f27074b.hashCode()) * 31) + this.f27075c.hashCode();
    }
}
