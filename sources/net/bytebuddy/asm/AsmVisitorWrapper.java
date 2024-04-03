package net.bytebuddy.asm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
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

public interface AsmVisitorWrapper {
    public static final int NO_FLAGS = 0;

    public static abstract class AbstractBase implements AsmVisitorWrapper {
        public int mergeReader(int i11) {
            return i11;
        }

        public int mergeWriter(int i11) {
            return i11;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements AsmVisitorWrapper {
        private final List<AsmVisitorWrapper> asmVisitorWrappers;

        public Compound(AsmVisitorWrapper... asmVisitorWrapperArr) {
            this((List<? extends AsmVisitorWrapper>) Arrays.asList(asmVisitorWrapperArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.asmVisitorWrappers.equals(((Compound) obj).asmVisitorWrappers);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.asmVisitorWrappers.hashCode();
        }

        public int mergeReader(int i11) {
            for (AsmVisitorWrapper mergeReader : this.asmVisitorWrappers) {
                i11 = mergeReader.mergeReader(i11);
            }
            return i11;
        }

        public int mergeWriter(int i11) {
            for (AsmVisitorWrapper mergeWriter : this.asmVisitorWrappers) {
                i11 = mergeWriter.mergeWriter(i11);
            }
            return i11;
        }

        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
            ClassVisitor classVisitor2 = classVisitor;
            for (AsmVisitorWrapper wrap : this.asmVisitorWrappers) {
                classVisitor2 = wrap.wrap(typeDescription, classVisitor2, context, typePool, fieldList, methodList, i11, i12);
            }
            return classVisitor2;
        }

        public Compound(List<? extends AsmVisitorWrapper> list) {
            this.asmVisitorWrappers = new ArrayList();
            for (AsmVisitorWrapper asmVisitorWrapper : list) {
                if (asmVisitorWrapper instanceof Compound) {
                    this.asmVisitorWrappers.addAll(((Compound) asmVisitorWrapper).asmVisitorWrappers);
                } else if (!(asmVisitorWrapper instanceof NoOp)) {
                    this.asmVisitorWrappers.add(asmVisitorWrapper);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDeclaredFields extends AbstractBase {
        /* access modifiers changed from: private */
        public final List<Entry> entries;

        public class DispatchingVisitor extends ClassVisitor {
            private final Map<String, FieldDescription.InDefinedShape> fields;
            private final TypeDescription instrumentedType;

            public DispatchingVisitor(ClassVisitor classVisitor, TypeDescription typeDescription, Map<String, FieldDescription.InDefinedShape> map) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.instrumentedType = typeDescription;
                this.fields = map;
            }

            public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
                FieldVisitor visitField = super.visitField(i11, str, str2, str3, obj);
                Map<String, FieldDescription.InDefinedShape> map = this.fields;
                FieldDescription.InDefinedShape inDefinedShape = map.get(str + str2);
                if (!(visitField == null || inDefinedShape == null)) {
                    for (Entry entry : ForDeclaredFields.this.entries) {
                        if (entry.matches(inDefinedShape)) {
                            visitField = entry.wrap(this.instrumentedType, inDefinedShape, visitField);
                        }
                    }
                }
                return visitField;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements ElementMatcher<FieldDescription.InDefinedShape>, FieldVisitorWrapper {
            private final List<? extends FieldVisitorWrapper> fieldVisitorWrappers;
            private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;

            public Entry(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, List<? extends FieldVisitorWrapper> list) {
                this.matcher = elementMatcher;
                this.fieldVisitorWrappers = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.fieldVisitorWrappers.equals(entry.fieldVisitorWrappers);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.fieldVisitorWrappers.hashCode();
            }

            public FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor) {
                for (FieldVisitorWrapper wrap : this.fieldVisitorWrappers) {
                    fieldVisitor = wrap.wrap(typeDescription, inDefinedShape, fieldVisitor);
                }
                return fieldVisitor;
            }

            public boolean matches(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape != null && this.matcher.matches(inDefinedShape);
            }
        }

        public interface FieldVisitorWrapper {
            FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor);
        }

        public ForDeclaredFields() {
            this(Collections.emptyList());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.entries.equals(((ForDeclaredFields) obj).entries);
        }

        public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, FieldVisitorWrapper... fieldVisitorWrapperArr) {
            return field(elementMatcher, (List<? extends FieldVisitorWrapper>) Arrays.asList(fieldVisitorWrapperArr));
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.entries.hashCode();
        }

        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
            HashMap hashMap = new HashMap();
            for (FieldDescription.InDefinedShape inDefinedShape : fieldList) {
                hashMap.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
            }
            return new DispatchingVisitor(classVisitor, typeDescription, hashMap);
        }

        public ForDeclaredFields(List<Entry> list) {
            this.entries = list;
        }

        public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, List<? extends FieldVisitorWrapper> list) {
            return new ForDeclaredFields(CompoundList.of(this.entries, new Entry(elementMatcher, list)));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDeclaredMethods implements AsmVisitorWrapper {
        /* access modifiers changed from: private */
        public final List<Entry> entries;
        private final int readerFlags;
        private final int writerFlags;

        public class DispatchingVisitor extends ClassVisitor {
            private final Implementation.Context implementationContext;
            private final TypeDescription instrumentedType;
            private final Map<String, MethodDescription> methods;
            private final int readerFlags;
            private final TypePool typePool;
            private final int writerFlags;

            public DispatchingVisitor(ClassVisitor classVisitor, TypeDescription typeDescription, Implementation.Context context, TypePool typePool2, Map<String, MethodDescription> map, int i11, int i12) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.instrumentedType = typeDescription;
                this.implementationContext = context;
                this.typePool = typePool2;
                this.methods = map;
                this.writerFlags = i11;
                this.readerFlags = i12;
            }

            public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
                MethodVisitor visitMethod = super.visitMethod(i11, str, str2, str3, strArr);
                Map<String, MethodDescription> map = this.methods;
                MethodDescription methodDescription = map.get(str + str2);
                if (visitMethod == null || methodDescription == null) {
                    return visitMethod;
                }
                MethodVisitor methodVisitor = visitMethod;
                for (Entry entry : ForDeclaredMethods.this.entries) {
                    if (entry.matches(methodDescription)) {
                        methodVisitor = entry.wrap(this.instrumentedType, methodDescription, methodVisitor, this.implementationContext, this.typePool, this.writerFlags, this.readerFlags);
                    }
                }
                return methodVisitor;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements ElementMatcher<MethodDescription>, MethodVisitorWrapper {
            private final ElementMatcher<? super MethodDescription> matcher;
            private final List<? extends MethodVisitorWrapper> methodVisitorWrappers;

            public Entry(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
                this.matcher = elementMatcher;
                this.methodVisitorWrappers = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.methodVisitorWrappers.equals(entry.methodVisitorWrappers);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.methodVisitorWrappers.hashCode();
            }

            public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
                MethodVisitor methodVisitor2 = methodVisitor;
                for (MethodVisitorWrapper wrap : this.methodVisitorWrappers) {
                    methodVisitor2 = wrap.wrap(typeDescription, methodDescription, methodVisitor2, context, typePool, i11, i12);
                }
                return methodVisitor2;
            }

            public boolean matches(MethodDescription methodDescription) {
                return methodDescription != null && this.matcher.matches(methodDescription);
            }
        }

        public interface MethodVisitorWrapper {
            MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12);
        }

        public ForDeclaredMethods() {
            this(Collections.emptyList(), 0, 0);
        }

        public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return constructor(elementMatcher, (List<? extends MethodVisitorWrapper>) Arrays.asList(methodVisitorWrapperArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForDeclaredMethods forDeclaredMethods = (ForDeclaredMethods) obj;
            return this.writerFlags == forDeclaredMethods.writerFlags && this.readerFlags == forDeclaredMethods.readerFlags && this.entries.equals(forDeclaredMethods.entries);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.entries.hashCode()) * 31) + this.writerFlags) * 31) + this.readerFlags;
        }

        public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return invokable(elementMatcher, (List<? extends MethodVisitorWrapper>) Arrays.asList(methodVisitorWrapperArr));
        }

        public int mergeReader(int i11) {
            return i11 | this.readerFlags;
        }

        public int mergeWriter(int i11) {
            return i11 | this.writerFlags;
        }

        public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return method(elementMatcher, (List<? extends MethodVisitorWrapper>) Arrays.asList(methodVisitorWrapperArr));
        }

        public ForDeclaredMethods readerFlags(int i11) {
            return new ForDeclaredMethods(this.entries, this.writerFlags, i11 | this.readerFlags);
        }

        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
            HashMap hashMap = new HashMap();
            TypeDescription typeDescription2 = typeDescription;
            for (S s11 : CompoundList.of(methodList, new MethodDescription.Latent.TypeInitializer(typeDescription))) {
                hashMap.put(s11.getInternalName() + s11.getDescriptor(), s11);
            }
            return new DispatchingVisitor(classVisitor, typeDescription, context, typePool, hashMap, i11, i12);
        }

        public ForDeclaredMethods writerFlags(int i11) {
            return new ForDeclaredMethods(this.entries, i11 | this.writerFlags, this.readerFlags);
        }

        public ForDeclaredMethods(List<Entry> list, int i11, int i12) {
            this.entries = list;
            this.writerFlags = i11;
            this.readerFlags = i12;
        }

        public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return invokable((ElementMatcher<? super MethodDescription>) ElementMatchers.isConstructor().and(elementMatcher), list);
        }

        public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return new ForDeclaredMethods(CompoundList.of(this.entries, new Entry(elementMatcher, list)), this.writerFlags, this.readerFlags);
        }

        public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return invokable((ElementMatcher<? super MethodDescription>) ElementMatchers.isMethod().and(elementMatcher), list);
        }
    }

    public enum NoOp implements AsmVisitorWrapper {
        INSTANCE;

        public int mergeReader(int i11) {
            return i11;
        }

        public int mergeWriter(int i11) {
            return i11;
        }

        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
            return classVisitor;
        }
    }

    int mergeReader(int i11);

    int mergeWriter(int i11);

    ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12);
}
