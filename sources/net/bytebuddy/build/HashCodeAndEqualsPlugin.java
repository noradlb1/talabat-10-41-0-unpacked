package net.bytebuddy.build;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.EqualsMethod;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

@Enhance
public class HashCodeAndEqualsPlugin implements Plugin, Plugin.Factory {
    private static final MethodDescription.InDefinedShape ENHANCE_INCLUDE_SYNTHETIC_FIELDS;
    private static final MethodDescription.InDefinedShape ENHANCE_INVOKE_SUPER;
    private static final MethodDescription.InDefinedShape ENHANCE_PERMIT_SUBCLASS_EQUALITY;
    private static final MethodDescription.InDefinedShape ENHANCE_SIMPLE_COMPARISON_FIRST;
    private static final MethodDescription.InDefinedShape ENHANCE_USE_TYPE_HASH_CONSTANT;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SORTED_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Sorted.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape VALUE_HANDLING_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ValueHandling.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());

    public enum AnnotationOrderComparator implements Comparator<FieldDescription.InDefinedShape> {
        INSTANCE;

        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            int i11;
            Class<Sorted> cls = Sorted.class;
            AnnotationDescription.Loadable<Sorted> ofType = inDefinedShape.getDeclaredAnnotations().ofType(cls);
            AnnotationDescription.Loadable<Sorted> ofType2 = inDefinedShape2.getDeclaredAnnotations().ofType(cls);
            Class<Integer> cls2 = Integer.class;
            int intValue = ofType == null ? 0 : ((Integer) ofType.getValue(HashCodeAndEqualsPlugin.SORTED_VALUE).resolve(cls2)).intValue();
            if (ofType2 == null) {
                i11 = 0;
            } else {
                i11 = ((Integer) ofType2.getValue(HashCodeAndEqualsPlugin.SORTED_VALUE).resolve(cls2)).intValue();
            }
            if (intValue > i11) {
                return -1;
            }
            if (intValue < i11) {
                return 1;
            }
            return 0;
        }
    }

    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {

        public enum InvokeSuper {
            IF_DECLARED {
                public EqualsMethod a(TypeDescription typeDescription) {
                    TypeDefinition superClass = typeDescription.getSuperClass();
                    while (superClass != null && !superClass.represents(Object.class)) {
                        if (superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                            return EqualsMethod.requiringSuperClassEquality();
                        }
                        MethodList methodList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.isHashCode());
                        if (methodList.isEmpty()) {
                            superClass = superClass.getSuperClass().asErasure();
                        } else if (((MethodDescription) methodList.getOnly()).isAbstract()) {
                            return EqualsMethod.isolated();
                        } else {
                            return EqualsMethod.requiringSuperClassEquality();
                        }
                    }
                    return EqualsMethod.isolated();
                }

                public HashCodeMethod b(TypeDescription typeDescription, boolean z11, boolean z12) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    while (superClass != null && !superClass.represents(Object.class)) {
                        if (superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                            return HashCodeMethod.usingSuperClassOffset();
                        }
                        MethodList methodList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.isHashCode());
                        if (methodList.isEmpty()) {
                            superClass = superClass.getSuperClass();
                        } else if (!((MethodDescription) methodList.getOnly()).isAbstract()) {
                            return HashCodeMethod.usingSuperClassOffset();
                        } else {
                            if (z11) {
                                return HashCodeMethod.usingTypeHashOffset(!z12);
                            }
                            return HashCodeMethod.usingDefaultOffset();
                        }
                    }
                    if (z11) {
                        return HashCodeMethod.usingTypeHashOffset(!z12);
                    }
                    return HashCodeMethod.usingDefaultOffset();
                }
            },
            IF_ANNOTATED {
                public EqualsMethod a(TypeDescription typeDescription) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    if (superClass == null || !superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                        return EqualsMethod.isolated();
                    }
                    return EqualsMethod.requiringSuperClassEquality();
                }

                public HashCodeMethod b(TypeDescription typeDescription, boolean z11, boolean z12) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    if (superClass != null && superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                        return HashCodeMethod.usingSuperClassOffset();
                    }
                    if (z11) {
                        return HashCodeMethod.usingTypeHashOffset(!z12);
                    }
                    return HashCodeMethod.usingDefaultOffset();
                }
            },
            ALWAYS {
                public EqualsMethod a(TypeDescription typeDescription) {
                    return EqualsMethod.requiringSuperClassEquality();
                }

                public HashCodeMethod b(TypeDescription typeDescription, boolean z11, boolean z12) {
                    return HashCodeMethod.usingSuperClassOffset();
                }
            },
            NEVER {
                public EqualsMethod a(TypeDescription typeDescription) {
                    return EqualsMethod.isolated();
                }

                public HashCodeMethod b(TypeDescription typeDescription, boolean z11, boolean z12) {
                    return z11 ? HashCodeMethod.usingTypeHashOffset(!z12) : HashCodeMethod.usingDefaultOffset();
                }
            };

            public abstract EqualsMethod a(TypeDescription typeDescription);

            public abstract HashCodeMethod b(TypeDescription typeDescription, boolean z11, boolean z12);
        }

        boolean includeSyntheticFields() default false;

        InvokeSuper invokeSuper() default InvokeSuper.IF_DECLARED;

        boolean permitSubclassEquality() default false;

        boolean simpleComparisonsFirst() default true;

        boolean useTypeHashConstant() default true;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Sorted {
        public static final int DEFAULT = 0;

        int value();
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValueHandling {

        public enum Sort {
            IGNORE,
            REVERSE_NULLABILITY
        }

        Sort value();
    }

    @Enhance
    public static class ValueMatcher implements ElementMatcher<FieldDescription> {
        private final ValueHandling.Sort sort;

        public ValueMatcher(ValueHandling.Sort sort2) {
            this.sort = sort2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.sort.equals(((ValueMatcher) obj).sort);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.sort.hashCode();
        }

        public boolean matches(FieldDescription fieldDescription) {
            Class<ValueHandling> cls = ValueHandling.class;
            AnnotationDescription.Loadable<ValueHandling> ofType = fieldDescription.getDeclaredAnnotations().ofType(cls);
            return ofType != null && ofType.getValue(HashCodeAndEqualsPlugin.VALUE_HANDLING_VALUE).load(cls.getClassLoader()).resolve(ValueHandling.Sort.class) == this.sort;
        }
    }

    @Enhance
    public static class WithNonNullableFields extends HashCodeAndEqualsPlugin {
        public ElementMatcher<FieldDescription> c(ElementMatcher<FieldDescription> elementMatcher) {
            return ElementMatchers.not(elementMatcher);
        }

        public boolean equals(Object obj) {
            if (!HashCodeAndEqualsPlugin.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return HashCodeAndEqualsPlugin.super.hashCode();
        }

        public /* bridge */ /* synthetic */ boolean matches(Object obj) {
            return HashCodeAndEqualsPlugin.super.matches((TypeDescription) obj);
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods();
        ENHANCE_INVOKE_SUPER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("invokeSuper"))).getOnly();
        ENHANCE_SIMPLE_COMPARISON_FIRST = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("simpleComparisonsFirst"))).getOnly();
        ENHANCE_INCLUDE_SYNTHETIC_FIELDS = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSyntheticFields"))).getOnly();
        ENHANCE_PERMIT_SUBCLASS_EQUALITY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("permitSubclassEquality"))).getOnly();
        ENHANCE_USE_TYPE_HASH_CONSTANT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("useTypeHashConstant"))).getOnly();
    }

    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ElementMatcher.Junction junction;
        ElementMatcher.Junction junction2;
        Class<Enhance> cls = Enhance.class;
        AnnotationDescription.Loadable<Enhance> ofType = typeDescription.getDeclaredAnnotations().ofType(cls);
        Class<Enhance.InvokeSuper> cls2 = Enhance.InvokeSuper.class;
        Class<Boolean> cls3 = Boolean.class;
        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<?> receiverTypeDefinition = builder;
        if (((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isHashCode())).isEmpty()) {
            DynamicType.Builder.MethodDefinition.ImplementationDefinition<?> method = builder.method(ElementMatchers.isHashCode());
            HashCodeMethod b11 = ((Enhance.InvokeSuper) ofType.getValue(ENHANCE_INVOKE_SUPER).load(cls.getClassLoader()).resolve(cls2)).b(typeDescription, ((Boolean) ofType.getValue(ENHANCE_USE_TYPE_HASH_CONSTANT).resolve(cls3)).booleanValue(), ((Boolean) ofType.getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(cls3)).booleanValue());
            if (((Boolean) ofType.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(cls3)).booleanValue()) {
                junction2 = ElementMatchers.none();
            } else {
                junction2 = ElementMatchers.isSynthetic();
            }
            receiverTypeDefinition = method.intercept(b11.withIgnoredFields(junction2).withIgnoredFields(new ValueMatcher(ValueHandling.Sort.IGNORE)).withNonNullableFields(c(new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))));
        }
        if (!((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isEquals())).isEmpty()) {
            return receiverTypeDefinition;
        }
        EqualsMethod a11 = ((Enhance.InvokeSuper) ofType.getValue(ENHANCE_INVOKE_SUPER).load(cls.getClassLoader()).resolve(cls2)).a(typeDescription);
        if (((Boolean) ofType.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(cls3)).booleanValue()) {
            junction = ElementMatchers.none();
        } else {
            junction = ElementMatchers.isSynthetic();
        }
        EqualsMethod withFieldOrder = a11.withIgnoredFields(junction).withIgnoredFields(new ValueMatcher(ValueHandling.Sort.IGNORE)).withNonNullableFields(c(new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))).withFieldOrder(AnnotationOrderComparator.INSTANCE);
        EqualsMethod equalsMethod = withFieldOrder;
        if (((Boolean) ofType.getValue(ENHANCE_SIMPLE_COMPARISON_FIRST).resolve(cls3)).booleanValue()) {
            equalsMethod = withFieldOrder.withPrimitiveTypedFieldsFirst().withEnumerationTypedFieldsFirst().withPrimitiveWrapperTypedFieldsFirst().withStringTypedFieldsFirst();
        }
        DynamicType.Builder.MethodDefinition.ImplementationDefinition<T> method2 = receiverTypeDefinition.method(ElementMatchers.isEquals());
        Implementation implementation = equalsMethod;
        if (((Boolean) ofType.getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(cls3)).booleanValue()) {
            implementation = equalsMethod.withSubclassEquality();
        }
        return method2.intercept(implementation);
    }

    public ElementMatcher<FieldDescription> c(ElementMatcher<FieldDescription> elementMatcher) {
        return elementMatcher;
    }

    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public Plugin make() {
        return this;
    }

    public boolean matches(TypeDescription typeDescription) {
        return typeDescription.getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class);
    }
}
