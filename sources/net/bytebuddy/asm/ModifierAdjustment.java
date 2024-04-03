package net.bytebuddy.asm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
public class ModifierAdjustment extends AsmVisitorWrapper.AbstractBase {
    private final List<Adjustment<FieldDescription.InDefinedShape>> fieldAdjustments;
    private final List<Adjustment<MethodDescription>> methodAdjustments;
    private final List<Adjustment<TypeDescription>> typeAdjustments;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Adjustment<T> implements ElementMatcher<T> {
        private final ElementMatcher<? super T> matcher;
        private final ModifierContributor.Resolver<?> resolver;

        public Adjustment(ElementMatcher<? super T> elementMatcher, ModifierContributor.Resolver<?> resolver2) {
            this.matcher = elementMatcher;
            this.resolver = resolver2;
        }

        public int a(int i11) {
            return this.resolver.resolve(i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Adjustment adjustment = (Adjustment) obj;
            return this.matcher.equals(adjustment.matcher) && this.resolver.equals(adjustment.resolver);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.resolver.hashCode();
        }

        public boolean matches(T t11) {
            return this.matcher.matches(t11);
        }
    }

    public static class ModifierAdjustingClassVisitor extends ClassVisitor {
        private final List<Adjustment<FieldDescription.InDefinedShape>> fieldAdjustments;
        private final Map<String, FieldDescription.InDefinedShape> fields;
        private final TypeDescription instrumentedType;
        private final List<Adjustment<MethodDescription>> methodAdjustments;
        private final Map<String, MethodDescription> methods;
        private final List<Adjustment<TypeDescription>> typeAdjustments;

        public ModifierAdjustingClassVisitor(ClassVisitor classVisitor, List<Adjustment<TypeDescription>> list, List<Adjustment<FieldDescription.InDefinedShape>> list2, List<Adjustment<MethodDescription>> list3, TypeDescription typeDescription, Map<String, FieldDescription.InDefinedShape> map, Map<String, MethodDescription> map2) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.typeAdjustments = list;
            this.fieldAdjustments = list2;
            this.methodAdjustments = list3;
            this.instrumentedType = typeDescription;
            this.fields = map;
            this.methods = map2;
        }

        public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
            Iterator<Adjustment<TypeDescription>> it = this.typeAdjustments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Adjustment next = it.next();
                if (next.matches(this.instrumentedType)) {
                    i12 = next.a(i12);
                    break;
                }
            }
            super.visit(i11, i12, str, str2, str3, strArr);
        }

        public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
            Map<String, FieldDescription.InDefinedShape> map = this.fields;
            FieldDescription.InDefinedShape inDefinedShape = map.get(str + str2);
            if (inDefinedShape != null) {
                Iterator<Adjustment<FieldDescription.InDefinedShape>> it = this.fieldAdjustments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Adjustment next = it.next();
                    if (next.matches(inDefinedShape)) {
                        i11 = next.a(i11);
                        break;
                    }
                }
            }
            return super.visitField(i11, str, str2, str3, obj);
        }

        public void visitInnerClass(String str, String str2, String str3, int i11) {
            if (this.instrumentedType.getInternalName().equals(str)) {
                Iterator<Adjustment<TypeDescription>> it = this.typeAdjustments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Adjustment next = it.next();
                    if (next.matches(this.instrumentedType)) {
                        i11 = next.a(i11);
                        break;
                    }
                }
            }
            super.visitInnerClass(str, str2, str3, i11);
        }

        public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
            Map<String, MethodDescription> map = this.methods;
            MethodDescription methodDescription = map.get(str + str2);
            if (methodDescription != null) {
                Iterator<Adjustment<MethodDescription>> it = this.methodAdjustments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Adjustment next = it.next();
                    if (next.matches(methodDescription)) {
                        i11 = next.a(i11);
                        break;
                    }
                }
            }
            return super.visitMethod(i11, str, str2, str3, strArr);
        }
    }

    public ModifierAdjustment() {
        this(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ModifierAdjustment modifierAdjustment = (ModifierAdjustment) obj;
        return this.typeAdjustments.equals(modifierAdjustment.typeAdjustments) && this.fieldAdjustments.equals(modifierAdjustment.fieldAdjustments) && this.methodAdjustments.equals(modifierAdjustment.methodAdjustments);
    }

    public int hashCode() {
        return (((((getClass().hashCode() * 31) + this.typeAdjustments.hashCode()) * 31) + this.fieldAdjustments.hashCode()) * 31) + this.methodAdjustments.hashCode();
    }

    public ModifierAdjustment withConstructorModifiers(ModifierContributor.ForMethod... forMethodArr) {
        return withConstructorModifiers((List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withFieldModifiers(ModifierContributor.ForField... forFieldArr) {
        return withFieldModifiers((List<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
    }

    public ModifierAdjustment withInvokableModifiers(ModifierContributor.ForMethod... forMethodArr) {
        return withInvokableModifiers((List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withMethodModifiers(ModifierContributor.ForMethod... forMethodArr) {
        return withMethodModifiers((List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withTypeModifiers(ModifierContributor.ForType... forTypeArr) {
        return withTypeModifiers((List<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
    }

    public ModifierAdjustment withConstructorModifiers(List<? extends ModifierContributor.ForMethod> list) {
        return withConstructorModifiers((ElementMatcher<? super MethodDescription>) ElementMatchers.any(), list);
    }

    public ModifierAdjustment withFieldModifiers(List<? extends ModifierContributor.ForField> list) {
        return withFieldModifiers((ElementMatcher<? super FieldDescription.InDefinedShape>) ElementMatchers.any(), list);
    }

    public ModifierAdjustment withInvokableModifiers(List<? extends ModifierContributor.ForMethod> list) {
        return withInvokableModifiers((ElementMatcher<? super MethodDescription>) ElementMatchers.any(), list);
    }

    public ModifierAdjustment withMethodModifiers(List<? extends ModifierContributor.ForMethod> list) {
        return withMethodModifiers((ElementMatcher<? super MethodDescription>) ElementMatchers.any(), list);
    }

    public ModifierAdjustment withTypeModifiers(List<? extends ModifierContributor.ForType> list) {
        return withTypeModifiers((ElementMatcher<? super TypeDescription>) ElementMatchers.any(), list);
    }

    public ModifierAdjustingClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
        HashMap hashMap = new HashMap();
        for (FieldDescription.InDefinedShape inDefinedShape : fieldList) {
            hashMap.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
        }
        HashMap hashMap2 = new HashMap();
        TypeDescription typeDescription2 = typeDescription;
        for (S s11 : CompoundList.of(methodList, new MethodDescription.Latent.TypeInitializer(typeDescription))) {
            hashMap2.put(s11.getInternalName() + s11.getDescriptor(), s11);
        }
        return new ModifierAdjustingClassVisitor(classVisitor, this.typeAdjustments, this.fieldAdjustments, this.methodAdjustments, typeDescription, hashMap, hashMap2);
    }

    public ModifierAdjustment withConstructorModifiers(ElementMatcher<? super MethodDescription> elementMatcher, ModifierContributor.ForMethod... forMethodArr) {
        return withConstructorModifiers(elementMatcher, (List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withFieldModifiers(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ModifierContributor.ForField... forFieldArr) {
        return withFieldModifiers(elementMatcher, (List<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
    }

    public ModifierAdjustment withInvokableModifiers(ElementMatcher<? super MethodDescription> elementMatcher, ModifierContributor.ForMethod... forMethodArr) {
        return withInvokableModifiers(elementMatcher, (List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withMethodModifiers(ElementMatcher<? super MethodDescription> elementMatcher, ModifierContributor.ForMethod... forMethodArr) {
        return withMethodModifiers(elementMatcher, (List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
    }

    public ModifierAdjustment withTypeModifiers(ElementMatcher<? super TypeDescription> elementMatcher, ModifierContributor.ForType... forTypeArr) {
        return withTypeModifiers(elementMatcher, (List<? extends ModifierContributor.ForType>) Arrays.asList(forTypeArr));
    }

    public ModifierAdjustment withConstructorModifiers(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends ModifierContributor.ForMethod> list) {
        return withInvokableModifiers((ElementMatcher<? super MethodDescription>) ElementMatchers.isConstructor().and(elementMatcher), list);
    }

    public ModifierAdjustment withFieldModifiers(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, List<? extends ModifierContributor.ForField> list) {
        return new ModifierAdjustment(this.typeAdjustments, CompoundList.of(new Adjustment(elementMatcher, ModifierContributor.Resolver.of(list)), this.fieldAdjustments), this.methodAdjustments);
    }

    public ModifierAdjustment withInvokableModifiers(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends ModifierContributor.ForMethod> list) {
        return new ModifierAdjustment(this.typeAdjustments, this.fieldAdjustments, CompoundList.of(new Adjustment(elementMatcher, ModifierContributor.Resolver.of(list)), this.methodAdjustments));
    }

    public ModifierAdjustment withMethodModifiers(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends ModifierContributor.ForMethod> list) {
        return withInvokableModifiers((ElementMatcher<? super MethodDescription>) ElementMatchers.isMethod().and(elementMatcher), list);
    }

    public ModifierAdjustment withTypeModifiers(ElementMatcher<? super TypeDescription> elementMatcher, List<? extends ModifierContributor.ForType> list) {
        return new ModifierAdjustment(CompoundList.of(new Adjustment(elementMatcher, ModifierContributor.Resolver.of(list)), this.typeAdjustments), this.fieldAdjustments, this.methodAdjustments);
    }

    public ModifierAdjustment(List<Adjustment<TypeDescription>> list, List<Adjustment<FieldDescription.InDefinedShape>> list2, List<Adjustment<MethodDescription>> list3) {
        this.typeAdjustments = list;
        this.fieldAdjustments = list2;
        this.methodAdjustments = list3;
    }
}
