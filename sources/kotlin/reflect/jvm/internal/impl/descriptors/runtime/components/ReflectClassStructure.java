package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

final class ReflectClassStructure {
    @NotNull
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i11 = 0;
        while (cls.isArray()) {
            i11++;
            cls = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            ClassId classId = ReflectClassUtilKt.getClassId(cls);
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
            FqName asSingleFqName = classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "javaClassId.asSingleFqName()");
            ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
            if (mapJavaToKotlin != null) {
                classId = mapJavaToKotlin;
            }
            return new ClassLiteralValue(classId, i11);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Void.TYPE)) {
            ClassId classId2 = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new ClassLiteralValue(classId2, i11);
        } else {
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
            if (i11 > 0) {
                ClassId classId3 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(primitiveType.arrayTypeFqName)");
                return new ClassLiteralValue(classId3, i11 - 1);
            }
            ClassId classId4 = ClassId.topLevel(primitiveType.getTypeFqName());
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(primitiveType.typeFqName)");
            return new ClassLiteralValue(classId4, i11);
        }
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        int i11;
        Constructor[] constructorArr;
        boolean z11;
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i12 = 0;
        while (i12 < length) {
            Constructor constructor = declaredConstructors[i12];
            Name name2 = SpecialNames.INIT;
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(name2, signatureSerializer.constructorDesc(constructor));
            if (visitMethod == null) {
                constructorArr = declaredConstructors;
                i11 = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "constructor.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "parameterAnnotations");
                if (parameterAnnotations.length == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i13 = 0; i13 < length3; i13++) {
                        Annotation[] annotationArr = parameterAnnotations[i13];
                        Intrinsics.checkNotNullExpressionValue(annotationArr, "annotations");
                        int length4 = annotationArr.length;
                        int i14 = 0;
                        while (i14 < length4) {
                            Annotation annotation2 = annotationArr[i14];
                            Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            Constructor[] constructorArr2 = declaredConstructors;
                            int i15 = length;
                            ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                            int i16 = length2;
                            Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i13 + length2, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                            }
                            i14++;
                            declaredConstructors = constructorArr2;
                            length = i15;
                            length2 = i16;
                        }
                        Constructor[] constructorArr3 = declaredConstructors;
                        int i17 = length;
                        int i18 = length2;
                    }
                }
                constructorArr = declaredConstructors;
                i11 = length;
                visitMethod.visitEnd();
            }
            i12++;
            declaredConstructors = constructorArr;
            length = i11;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(field.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(field, "field");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), (Object) null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "field.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i11 = 0;
        while (i11 < length) {
            Method method = declaredMethods[i11];
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(method, "method");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitMethod == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i12 = 0; i12 < length2; i12++) {
                    Annotation[] annotationArr2 = annotationArr[i12];
                    Intrinsics.checkNotNullExpressionValue(annotationArr2, "annotations");
                    int length3 = annotationArr2.length;
                    int i13 = 0;
                    while (i13 < length3) {
                        Annotation annotation2 = annotationArr2[i13];
                        Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Method[] methodArr2 = declaredMethods;
                        Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i12, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                        i13++;
                        declaredMethods = methodArr2;
                    }
                    Method[] methodArr3 = declaredMethods;
                }
                methodArr = declaredMethods;
                visitMethod.visitEnd();
            }
            i11++;
            declaredMethods = methodArr;
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            INSTANCE.processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name2, Object obj) {
        Class<?> cls = obj.getClass();
        Class<Class> cls2 = Class.class;
        if (Intrinsics.areEqual((Object) cls, (Object) cls2)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            annotationArgumentVisitor.visitClassLiteral(name2, classLiteralValue((Class) obj));
        } else if (ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT.contains(cls)) {
            annotationArgumentVisitor.visit(name2, obj);
        } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            Intrinsics.checkNotNullExpressionValue(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            ClassId classId = ReflectClassUtilKt.getClassId(cls);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            Name identifier = Name.identifier(((Enum) obj).name());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier((value as Enum<*>).name)");
            annotationArgumentVisitor.visitEnum(name2, classId, identifier);
        } else {
            Class<Annotation> cls3 = Annotation.class;
            if (cls3.isAssignableFrom(cls)) {
                Class[] interfaces = cls.getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                Class cls4 = (Class) ArraysKt___ArraysKt.single((T[]) interfaces);
                Intrinsics.checkNotNullExpressionValue(cls4, "annotationClass");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name2, ReflectClassUtilKt.getClassId(cls4));
                if (visitAnnotation != null) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Annotation");
                    processAnnotationArguments(visitAnnotation, (Annotation) obj, cls4);
                }
            } else if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name2);
                if (visitArray != null) {
                    Class<?> componentType = cls.getComponentType();
                    int i11 = 0;
                    if (componentType.isEnum()) {
                        Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                        ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                        Object[] objArr = (Object[]) obj;
                        int length = objArr.length;
                        while (i11 < length) {
                            Object obj2 = objArr[i11];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                            Name identifier2 = Name.identifier(((Enum) obj2).name());
                            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier((element as Enum<*>).name)");
                            visitArray.visitEnum(classId2, identifier2);
                            i11++;
                        }
                    } else if (Intrinsics.areEqual((Object) componentType, (Object) cls2)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                        Object[] objArr2 = (Object[]) obj;
                        int length2 = objArr2.length;
                        while (i11 < length2) {
                            Object obj3 = objArr2[i11];
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                            visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                            i11++;
                        }
                    } else if (cls3.isAssignableFrom(componentType)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                        Object[] objArr3 = (Object[]) obj;
                        int length3 = objArr3.length;
                        while (i11 < length3) {
                            Object obj4 = objArr3[i11];
                            Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation2 = visitArray.visitAnnotation(ReflectClassUtilKt.getClassId(componentType));
                            if (visitAnnotation2 != null) {
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                                processAnnotationArguments(visitAnnotation2, (Annotation) obj4, componentType);
                            }
                            i11++;
                        }
                    } else {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                        Object[] objArr4 = (Object[]) obj;
                        int length4 = objArr4.length;
                        while (i11 < length4) {
                            visitArray.visit(objArr4[i11]);
                            i11++;
                        }
                    }
                    visitArray.visitEnd();
                }
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            }
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(invoke);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void loadClassAnnotations(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
            processAnnotation(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public final void visitMembers(@NotNull Class<?> cls, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        loadMethodAnnotations(cls, memberVisitor);
        loadConstructorAnnotations(cls, memberVisitor);
        loadFieldAnnotations(cls, memberVisitor);
    }
}
