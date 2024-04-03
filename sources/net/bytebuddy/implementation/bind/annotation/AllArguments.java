package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AllArguments {

    public enum Assignment {
        STRICT(true),
        SLACK(false);
        
        private final boolean strict;

        private Assignment(boolean z11) {
            this.strict = z11;
        }

        public boolean a() {
            return this.strict;
        }
    }

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<AllArguments> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape INCLUDE_SELF = null;
        private static final MethodDescription.InDefinedShape NULL_IF_EMPTY = null;
        private static final MethodDescription.InDefinedShape VALUE = null;

        /* access modifiers changed from: public */
        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
            VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
            INCLUDE_SELF = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSelf"))).getOnly();
            NULL_IF_EMPTY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfEmpty"))).getOnly();
        }

        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<AllArguments> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            TypeDescription.Generic generic;
            int i11;
            int i12;
            List<TypeDescription.Generic> list;
            if (parameterDescription.getType().represents(Object.class)) {
                generic = TypeDescription.Generic.OBJECT;
            } else if (parameterDescription.getType().isArray()) {
                generic = parameterDescription.getType().getComponentType();
            } else {
                throw new IllegalStateException("Expected an array type for all argument annotation on " + methodDescription);
            }
            Class<Boolean> cls = Boolean.class;
            if (methodDescription.isStatic() || !((Boolean) loadable.getValue(INCLUDE_SELF).resolve(cls)).booleanValue()) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            if (i11 == 0 && methodDescription.getParameters().isEmpty() && ((Boolean) loadable.getValue(NULL_IF_EMPTY).resolve(cls)).booleanValue()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
            }
            ArrayList arrayList = new ArrayList(methodDescription.getParameters().size() + i11);
            if (methodDescription.isStatic() || i11 != 0) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            if (i11 != 0) {
                list = CompoundList.of(target.getInstrumentedType().asGenericType(), methodDescription.getParameters().asTypeList());
            } else {
                list = methodDescription.getParameters().asTypeList();
            }
            for (TypeDescription.Generic generic2 : list) {
                StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.of(generic2).loadFrom(i12), assigner.assign(generic2, generic, typing));
                if (compound.isValid()) {
                    arrayList.add(compound);
                } else if (((Assignment) loadable.getValue(VALUE).load(AllArguments.class.getClassLoader()).resolve(Assignment.class)).a()) {
                    return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                }
                i12 += generic2.getStackSize().getSize();
            }
            return new MethodDelegationBinder.ParameterBinding.Anonymous(ArrayFactory.forType(generic).withValues(arrayList));
        }

        public Class<AllArguments> getHandledType() {
            return AllArguments.class;
        }
    }

    boolean includeSelf() default false;

    boolean nullIfEmpty() default false;

    Assignment value() default Assignment.STRICT;
}
