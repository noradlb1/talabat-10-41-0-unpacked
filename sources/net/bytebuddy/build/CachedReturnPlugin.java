package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
public class CachedReturnPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ADVICE_INFIX = "$";
    private static final MethodDescription.InDefinedShape ENHANCE_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
    private static final String NAME_INFIX = "_";
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final Map<TypeDescription, TypeDescription> adviceByType;
    private final ClassFileLocator classFileLocator;
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final RandomString randomString = new RandomString();

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CacheField {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class CacheFieldOffsetMapping implements Advice.OffsetMapping {

        /* renamed from: name  reason: collision with root package name */
        private final String f27088name;

        public CacheFieldOffsetMapping(String str) {
            this.f27088name = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f27088name.equals(((CacheFieldOffsetMapping) obj).f27088name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.f27088name.hashCode();
        }

        public Advice.OffsetMapping.Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Advice.ArgumentHandler argumentHandler, Advice.OffsetMapping.Sort sort) {
            return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.f27088name))).getOnly());
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
        String value() default "";
    }

    class Object {
        private Object() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$boolean  reason: invalid class name */
    class Cboolean {
        private Cboolean() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$byte  reason: invalid class name */
    class Cbyte {
        private Cbyte() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$char  reason: invalid class name */
    class Cchar {
        private Cchar() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$double  reason: invalid class name */
    class Cdouble {
        private Cdouble() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$float  reason: invalid class name */
    class Cfloat {
        private Cfloat() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$int  reason: invalid class name */
    class Cint {
        private Cint() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$long  reason: invalid class name */
    class Clong {
        private Clong() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    @SuppressFBWarnings(justification = "Name is chosen to optimize for simple lookup", value = {"NM_CLASS_NAMING_CONVENTION"})
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$short  reason: invalid class name */
    class Cshort {
        private Cshort() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }
    }

    public CachedReturnPlugin() {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        Class<CachedReturnPlugin> cls = CachedReturnPlugin.class;
        ClassFileLocator of2 = ClassFileLocator.ForClassLoader.of(cls.getClassLoader());
        this.classFileLocator = of2;
        TypePool of3 = TypePool.Default.of(of2);
        this.adviceByType = new HashMap();
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Object.class};
        for (int i11 = 0; i11 < 9; i11++) {
            Class cls2 = clsArr[i11];
            Map<TypeDescription, TypeDescription> map = this.adviceByType;
            TypeDescription of4 = TypeDescription.ForLoadedType.of(cls2);
            map.put(of4, of3.describe(cls.getName() + ADVICE_INFIX + cls2.getSimpleName()).resolve());
        }
    }

    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator2) {
        Ownership ownership;
        FieldPersistence fieldPersistence;
        TypeDescription typeDescription2;
        Class<Enhance> cls = Enhance.class;
        DynamicType.Builder<T> builder2 = builder;
        for (MethodDescription.InDefinedShape inDefinedShape : (MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isBridge()).and(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) cls)))) {
            if (inDefinedShape.isAbstract()) {
                throw new IllegalStateException("Cannot cache the value of an abstract method: " + inDefinedShape);
            } else if (!inDefinedShape.getParameters().isEmpty()) {
                throw new IllegalStateException("Cannot cache the value of a method with parameters: " + inDefinedShape);
            } else if (!inDefinedShape.getReturnType().represents(Void.TYPE)) {
                String str = (String) inDefinedShape.getDeclaredAnnotations().ofType(cls).getValue(ENHANCE_VALUE).resolve(String.class);
                if (str.length() == 0) {
                    str = inDefinedShape.getName() + "_" + this.randomString.nextString();
                }
                TypeDescription asErasure = inDefinedShape.getReturnType().asErasure();
                ModifierContributor.ForField[] forFieldArr = new ModifierContributor.ForField[4];
                if (inDefinedShape.isStatic()) {
                    ownership = Ownership.STATIC;
                } else {
                    ownership = Ownership.MEMBER;
                }
                forFieldArr[0] = ownership;
                if (inDefinedShape.isStatic()) {
                    fieldPersistence = FieldPersistence.PLAIN;
                } else {
                    fieldPersistence = FieldPersistence.TRANSIENT;
                }
                forFieldArr[1] = fieldPersistence;
                forFieldArr[2] = Visibility.PRIVATE;
                forFieldArr[3] = SyntheticState.SYNTHETIC;
                DynamicType.Builder.FieldDefinition.Optional.Valuable<?> defineField = builder2.defineField(str, (TypeDefinition) asErasure, forFieldArr);
                Advice.WithCustomMapping bind = Advice.withCustomMapping().bind(CacheField.class, (Advice.OffsetMapping) new CacheFieldOffsetMapping(str));
                Map<TypeDescription, TypeDescription> map = this.adviceByType;
                if (inDefinedShape.getReturnType().isPrimitive()) {
                    typeDescription2 = inDefinedShape.getReturnType().asErasure();
                } else {
                    typeDescription2 = TypeDescription.OBJECT;
                }
                builder2 = defineField.visit(bind.to(map.get(typeDescription2), this.classFileLocator).on(ElementMatchers.is(inDefinedShape)));
            } else {
                throw new IllegalStateException("Cannot cache void result for " + inDefinedShape);
            }
        }
        return builder2;
    }

    public void close() {
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.classFileLocator.equals(((CachedReturnPlugin) obj).classFileLocator);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.classFileLocator.hashCode();
    }

    public Plugin make() {
        return this;
    }
}
