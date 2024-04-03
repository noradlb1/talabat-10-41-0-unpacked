package net.bytebuddy.description.type;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import datamodels.TypesAliasesKt;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public interface TypeDescription extends TypeDefinition, ByteCodeElement, TypeVariableSource {
    public static final TypeList.Generic ARRAY_INTERFACES = new TypeList.Generic.ForLoadedTypes(Cloneable.class, Serializable.class);
    public static final TypeDescription CLASS = new ForLoadedType(Class.class);
    public static final TypeDescription OBJECT = new ForLoadedType(Object.class);
    public static final TypeDescription STRING = new ForLoadedType(String.class);
    public static final TypeDescription THROWABLE = new ForLoadedType(Throwable.class);
    public static final TypeDescription UNDEFINED = null;
    public static final TypeDescription VOID = new ForLoadedType(Void.TYPE);

    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements TypeDescription {
        private static final boolean ACCESS_CONTROLLER;
        public static final boolean RAW_TYPES;
        private transient /* synthetic */ int hashCode;

        public static abstract class OfSimpleType extends AbstractBase {

            public static abstract class WithDelegation extends OfSimpleType {
                public abstract TypeDescription a();

                public int getActualModifiers(boolean z11) {
                    return a().getActualModifiers(z11);
                }

                public ClassFileVersion getClassFileVersion() {
                    return a().getClassFileVersion();
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return a().getDeclaredAnnotations();
                }

                public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                    return a().getDeclaredFields();
                }

                public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                    return a().getDeclaredMethods();
                }

                public TypeList getDeclaredTypes() {
                    return a().getDeclaredTypes();
                }

                public MethodDescription.InDefinedShape getEnclosingMethod() {
                    return a().getEnclosingMethod();
                }

                public TypeDescription getEnclosingType() {
                    return a().getEnclosingType();
                }

                public String getGenericSignature() {
                    return a().getGenericSignature();
                }

                public TypeList.Generic getInterfaces() {
                    return a().getInterfaces();
                }

                public int getModifiers() {
                    return a().getModifiers();
                }

                public TypeDescription getNestHost() {
                    return a().getNestHost();
                }

                public TypeList getNestMembers() {
                    return a().getNestMembers();
                }

                public PackageDescription getPackage() {
                    return a().getPackage();
                }

                public TypeList getPermittedSubtypes() {
                    return a().getPermittedSubtypes();
                }

                public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                    return a().getRecordComponents();
                }

                public Generic getSuperClass() {
                    return a().getSuperClass();
                }

                public TypeList.Generic getTypeVariables() {
                    return a().getTypeVariables();
                }

                public boolean isAnonymousType() {
                    return a().isAnonymousType();
                }

                public boolean isLocalType() {
                    return a().isLocalType();
                }

                public boolean isRecord() {
                    return a().isRecord();
                }

                public boolean isSealed() {
                    return a().isSealed();
                }

                public TypeDescription getDeclaringType() {
                    return a().getDeclaringType();
                }
            }

            public String getCanonicalName() {
                if (isAnonymousType() || isLocalType()) {
                    return NamedElement.NO_NAME;
                }
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType != null) {
                    if (internalName.startsWith(enclosingType.getInternalName() + "$")) {
                        return enclosingType.getCanonicalName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + internalName.substring(enclosingType.getInternalName().length() + 1);
                    }
                }
                return getName();
            }

            public String getDescriptor() {
                return "L" + getInternalName() + TypesAliasesKt.separator;
            }

            public String getSimpleName() {
                int i11;
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType != null) {
                    if (internalName.startsWith(enclosingType.getInternalName() + "$")) {
                        i11 = enclosingType.getInternalName().length();
                        i11++;
                        if (i11 >= internalName.length() || Character.isLetter(internalName.charAt(i11))) {
                            return internalName.substring(i11);
                        }
                        i11++;
                        return internalName.substring(i11);
                    }
                }
                i11 = internalName.lastIndexOf(47);
                if (i11 == -1) {
                    return internalName;
                }
                return internalName.substring(i11);
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public TypeDescription getComponentType() {
                return TypeDescription.UNDEFINED;
            }
        }

        static {
            boolean z11 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
            try {
                z11 = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(TypeDefinition.RAW_TYPES_PROPERTY)));
            } catch (Exception unused3) {
            }
            RAW_TYPES = z11;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        private static boolean isAssignable(TypeDescription typeDescription, TypeDescription typeDescription2) {
            if (typeDescription.equals(typeDescription2)) {
                return true;
            }
            Class<Object> cls = Object.class;
            if (typeDescription2.isArray()) {
                if (typeDescription.isArray()) {
                    return isAssignable(typeDescription.getComponentType(), typeDescription2.getComponentType());
                }
                if (typeDescription.represents(cls) || TypeDescription.ARRAY_INTERFACES.contains(typeDescription.asGenericType())) {
                    return true;
                }
                return false;
            } else if (typeDescription.represents(cls)) {
                return !typeDescription2.isPrimitive();
            } else {
                Generic superClass = typeDescription2.getSuperClass();
                if (superClass != null && typeDescription.isAssignableFrom(superClass.asErasure())) {
                    return true;
                }
                if (typeDescription.isInterface()) {
                    for (TypeDescription isAssignableFrom : typeDescription2.getInterfaces().asErasures()) {
                        if (typeDescription.isAssignableFrom(isAssignableFrom)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onType(this);
        }

        public TypeDescription asBoxed() {
            if (represents(Boolean.TYPE)) {
                return ForLoadedType.of(Boolean.class);
            }
            if (represents(Byte.TYPE)) {
                return ForLoadedType.of(Byte.class);
            }
            if (represents(Short.TYPE)) {
                return ForLoadedType.of(Short.class);
            }
            if (represents(Character.TYPE)) {
                return ForLoadedType.of(Character.class);
            }
            if (represents(Integer.TYPE)) {
                return ForLoadedType.of(Integer.class);
            }
            if (represents(Long.TYPE)) {
                return ForLoadedType.of(Long.class);
            }
            if (represents(Float.TYPE)) {
                return ForLoadedType.of(Float.class);
            }
            if (represents(Double.TYPE)) {
                return ForLoadedType.of(Double.class);
            }
            return this;
        }

        public TypeDescription asErasure() {
            return this;
        }

        public Generic asGenericType() {
            return new Generic.OfNonGenericType.ForErasure(this);
        }

        public TypeDescription asUnboxed() {
            if (represents(Boolean.class)) {
                return ForLoadedType.of(Boolean.TYPE);
            }
            if (represents(Byte.class)) {
                return ForLoadedType.of(Byte.TYPE);
            }
            if (represents(Short.class)) {
                return ForLoadedType.of(Short.TYPE);
            }
            if (represents(Character.class)) {
                return ForLoadedType.of(Character.TYPE);
            }
            if (represents(Integer.class)) {
                return ForLoadedType.of(Integer.TYPE);
            }
            if (represents(Long.class)) {
                return ForLoadedType.of(Long.TYPE);
            }
            if (represents(Float.class)) {
                return ForLoadedType.of(Float.TYPE);
            }
            if (represents(Double.class)) {
                return ForLoadedType.of(Double.TYPE);
            }
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypeDefinition)) {
                return false;
            }
            TypeDefinition typeDefinition = (TypeDefinition) obj;
            if (!typeDefinition.getSort().isNonGeneric() || !getName().equals(typeDefinition.asErasure().getName())) {
                return false;
            }
            return true;
        }

        public int getActualModifiers(boolean z11) {
            int i11;
            int i12;
            int modifiers = getModifiers();
            int i13 = 0;
            if (getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Deprecated.class)) {
                i11 = 131072;
            } else {
                i11 = 0;
            }
            int i14 = modifiers | i11;
            if (isRecord()) {
                i12 = 65536;
            } else {
                i12 = 0;
            }
            int i15 = i14 | i12;
            if (z11) {
                i13 = 32;
            }
            int i16 = i15 | i13;
            if (isPrivate()) {
                return i16 & -11;
            }
            if (isProtected()) {
                return (i16 & -13) | 1;
            }
            return i16 & -9;
        }

        public String getActualName() {
            if (!isArray()) {
                return getName();
            }
            TypeDescription typeDescription = this;
            int i11 = 0;
            do {
                i11++;
                typeDescription = typeDescription.getComponentType();
            } while (typeDescription.isArray());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(typeDescription.getActualName());
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return sb2.toString();
        }

        public ClassFileVersion getClassFileVersion() {
            return null;
        }

        public Object getDefaultValue() {
            if (represents(Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (represents(Byte.TYPE)) {
                return (byte) 0;
            }
            if (represents(Short.TYPE)) {
                return (short) 0;
            }
            if (represents(Character.TYPE)) {
                return 0;
            }
            if (represents(Integer.TYPE)) {
                return 0;
            }
            if (represents(Long.TYPE)) {
                return 0L;
            }
            if (represents(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (represents(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            return null;
        }

        public TypeVariableSource getEnclosingSource() {
            MethodDescription.InDefinedShape enclosingMethod = getEnclosingMethod();
            if (enclosingMethod != null) {
                return enclosingMethod;
            }
            if (isStatic()) {
                return TypeVariableSource.UNDEFINED;
            }
            return getEnclosingType();
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[Catch:{ GenericSignatureFormatError -> 0x00b4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac A[Catch:{ GenericSignatureFormatError -> 0x00b4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1 A[Catch:{ GenericSignatureFormatError -> 0x00b4 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getGenericSignature() {
            /*
                r8 = this;
                net.bytebuddy.jar.asm.signature.SignatureWriter r0 = new net.bytebuddy.jar.asm.signature.SignatureWriter     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r0.<init>()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeList$Generic r1 = r8.getTypeVariables()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r2 = 0
                r3 = r2
            L_0x000f:
                boolean r4 = r1.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r5 = 1
                if (r4 == 0) goto L_0x0055
                java.lang.Object r3 = r1.next()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription$Generic r3 = (net.bytebuddy.description.type.TypeDescription.Generic) r3     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                java.lang.String r4 = r3.getSymbol()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r0.visitFormalTypeParameter(r4)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeList$Generic r3 = r3.getUpperBounds()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
            L_0x002b:
                boolean r4 = r3.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r4 == 0) goto L_0x0053
                java.lang.Object r4 = r3.next()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription$Generic r4 = (net.bytebuddy.description.type.TypeDescription.Generic) r4     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription r7 = r4.asErasure()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                boolean r7 = r7.isInterface()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r7 == 0) goto L_0x0048
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitInterfaceBound()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                goto L_0x004c
            L_0x0048:
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitClassBound()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
            L_0x004c:
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r4.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                goto L_0x002b
            L_0x0053:
                r3 = r5
                goto L_0x000f
            L_0x0055:
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r8.getSuperClass()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r1 != 0) goto L_0x005d
                net.bytebuddy.description.type.TypeDescription$Generic r1 = net.bytebuddy.description.type.TypeDescription.Generic.OBJECT     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
            L_0x005d:
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r4 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r6 = r0.visitSuperclass()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r4.<init>(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r1.accept(r4)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r3 != 0) goto L_0x0078
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r1.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r1 != 0) goto L_0x0076
                goto L_0x0078
            L_0x0076:
                r1 = r2
                goto L_0x0079
            L_0x0078:
                r1 = r5
            L_0x0079:
                net.bytebuddy.description.type.TypeList$Generic r3 = r8.getInterfaces()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
            L_0x0081:
                boolean r4 = r3.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r4 == 0) goto L_0x00aa
                java.lang.Object r4 = r3.next()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription$Generic r4 = (net.bytebuddy.description.type.TypeDescription.Generic) r4     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitInterface()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                r4.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r1 != 0) goto L_0x00a8
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r4.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                if (r1 != 0) goto L_0x00a6
                goto L_0x00a8
            L_0x00a6:
                r1 = r2
                goto L_0x0081
            L_0x00a8:
                r1 = r5
                goto L_0x0081
            L_0x00aa:
                if (r1 == 0) goto L_0x00b1
                java.lang.String r0 = r0.toString()     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
                goto L_0x00b3
            L_0x00b1:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE     // Catch:{ GenericSignatureFormatError -> 0x00b4 }
            L_0x00b3:
                return r0
            L_0x00b4:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.AbstractBase.getGenericSignature():java.lang.String");
        }

        public AnnotationList getInheritedAnnotations() {
            Generic superClass = getSuperClass();
            AnnotationList<AnnotationDescription> declaredAnnotations = getDeclaredAnnotations();
            if (superClass == null) {
                return declaredAnnotations;
            }
            HashSet hashSet = new HashSet();
            for (AnnotationDescription annotationType : declaredAnnotations) {
                hashSet.add(annotationType.getAnnotationType());
            }
            return new AnnotationList.Explicit((List<? extends AnnotationDescription>) CompoundList.of(declaredAnnotations, (AnnotationList<AnnotationDescription>) superClass.asErasure().getInheritedAnnotations().inherited(hashSet)));
        }

        public int getInnerClassCount() {
            TypeDescription declaringType;
            if (!isStatic() && (declaringType = getDeclaringType()) != null) {
                return declaringType.getInnerClassCount() + 1;
            }
            return 0;
        }

        public String getInternalName() {
            return getName().replace('.', '/');
        }

        public TypeDefinition.Sort getSort() {
            return TypeDefinition.Sort.NON_GENERIC;
        }

        public String getTypeName() {
            return getName();
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getName().hashCode();
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public boolean isAccessibleTo(TypeDescription typeDescription) {
            if (isPrimitive() || (!isArray() ? isPublic() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription))) {
                return true;
            }
            return false;
        }

        public boolean isAnnotationReturnType() {
            if (!isPrimitive() && !represents(String.class)) {
                Class<Enum> cls = Enum.class;
                if (!isAssignableTo((Class<?>) cls) || represents(cls)) {
                    Class<Annotation> cls2 = Annotation.class;
                    if ((!isAssignableTo((Class<?>) cls2) || represents(cls2)) && !represents(Class.class) && (!isArray() || getComponentType().isArray() || !getComponentType().isAnnotationReturnType())) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isAnnotationValue(Object obj) {
            if ((represents(Class.class) && (obj instanceof TypeDescription)) || (((obj instanceof AnnotationDescription) && ((AnnotationDescription) obj).getAnnotationType().equals(this)) || (((obj instanceof EnumerationDescription) && ((EnumerationDescription) obj).getEnumerationType().equals(this)) || ((represents(String.class) && (obj instanceof String)) || ((represents(Boolean.TYPE) && (obj instanceof Boolean)) || ((represents(Byte.TYPE) && (obj instanceof Byte)) || ((represents(Short.TYPE) && (obj instanceof Short)) || ((represents(Character.TYPE) && (obj instanceof Character)) || ((represents(Integer.TYPE) && (obj instanceof Integer)) || ((represents(Long.TYPE) && (obj instanceof Long)) || ((represents(Float.TYPE) && (obj instanceof Float)) || ((represents(Double.TYPE) && (obj instanceof Double)) || ((represents(String[].class) && (obj instanceof String[])) || ((represents(boolean[].class) && (obj instanceof boolean[])) || ((represents(byte[].class) && (obj instanceof byte[])) || ((represents(short[].class) && (obj instanceof short[])) || ((represents(char[].class) && (obj instanceof char[])) || ((represents(int[].class) && (obj instanceof int[])) || ((represents(long[].class) && (obj instanceof long[])) || ((represents(float[].class) && (obj instanceof float[])) || ((represents(double[].class) && (obj instanceof double[])) || (represents(Class[].class) && (obj instanceof TypeDescription[]))))))))))))))))))))))) {
                return true;
            }
            if (isAssignableTo((Class<?>) Annotation[].class) && (obj instanceof AnnotationDescription[])) {
                for (AnnotationDescription annotationType : (AnnotationDescription[]) obj) {
                    if (!annotationType.getAnnotationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            } else if (!isAssignableTo((Class<?>) Enum[].class) || !(obj instanceof EnumerationDescription[])) {
                return false;
            } else {
                for (EnumerationDescription enumerationType : (EnumerationDescription[]) obj) {
                    if (!enumerationType.getEnumerationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
        }

        public boolean isAssignableFrom(Class<?> cls) {
            return isAssignableFrom(ForLoadedType.of(cls));
        }

        public boolean isAssignableTo(Class<?> cls) {
            return isAssignableTo(ForLoadedType.of(cls));
        }

        public boolean isCompileTimeConstant() {
            if (represents(Integer.TYPE) || represents(Long.TYPE) || represents(Float.TYPE) || represents(Double.TYPE) || represents(String.class) || represents(Class.class) || equals(JavaType.METHOD_TYPE.getTypeStub()) || equals(JavaType.METHOD_HANDLE.getTypeStub())) {
                return true;
            }
            return false;
        }

        public boolean isGenerified() {
            if (!getTypeVariables().isEmpty()) {
                return true;
            }
            if (isStatic()) {
                return false;
            }
            TypeDescription declaringType = getDeclaringType();
            if (declaringType == null || !declaringType.isGenerified()) {
                return false;
            }
            return true;
        }

        public boolean isInHierarchyWith(Class<?> cls) {
            return isAssignableTo(cls) || isAssignableFrom(cls);
        }

        public boolean isInferrable() {
            return false;
        }

        public boolean isInnerClass() {
            return !isStatic() && isNestedClass();
        }

        public boolean isInstance(Object obj) {
            return isAssignableFrom(obj.getClass());
        }

        public boolean isMemberType() {
            return !isLocalType() && !isAnonymousType() && getDeclaringType() != null;
        }

        public boolean isNestHost() {
            return equals(getNestHost());
        }

        public boolean isNestMateOf(Class<?> cls) {
            return isNestMateOf(ForLoadedType.of(cls));
        }

        public boolean isNestedClass() {
            return getDeclaringType() != null;
        }

        public boolean isPackageType() {
            return getSimpleName().equals(PackageDescription.PACKAGE_CLASS_NAME);
        }

        public boolean isPrimitiveWrapper() {
            if (represents(Boolean.class) || represents(Byte.class) || represents(Short.class) || represents(Character.class) || represents(Integer.class) || represents(Long.class) || represents(Float.class) || represents(Double.class)) {
                return true;
            }
            return false;
        }

        public boolean isSamePackage(TypeDescription typeDescription) {
            PackageDescription packageDescription = getPackage();
            PackageDescription packageDescription2 = typeDescription.getPackage();
            if (packageDescription != null && packageDescription2 != null) {
                return packageDescription.equals(packageDescription2);
            }
            if (packageDescription == packageDescription2) {
                return true;
            }
            return false;
        }

        public boolean isSealed() {
            return !isPrimitive() && !isArray() && !getPermittedSubtypes().isEmpty();
        }

        public boolean isVisibleTo(TypeDescription typeDescription) {
            if (isPrimitive() || (!isArray() ? isPublic() || isProtected() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription))) {
                return true;
            }
            return false;
        }

        public Iterator<TypeDefinition> iterator() {
            return new TypeDefinition.SuperClassIterator(this);
        }

        @SuppressFBWarnings(justification = "Fits equality contract for type definitions", value = {"EC_UNRELATED_CLASS_AND_INTERFACE"})
        public boolean represents(Type type) {
            return equals(TypeDefinition.Sort.describe(type));
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            if (isPrimitive()) {
                str = "";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(isInterface() ? "interface" : "class");
                sb3.append(" ");
                str = sb3.toString();
            }
            sb2.append(str);
            sb2.append(getName());
            return sb2.toString();
        }

        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return isAssignable(this, typeDescription);
        }

        public boolean isAssignableTo(TypeDescription typeDescription) {
            return isAssignable(typeDescription, this);
        }

        public boolean isInHierarchyWith(TypeDescription typeDescription) {
            return isAssignableTo(typeDescription) || isAssignableFrom(typeDescription);
        }

        public boolean isNestMateOf(TypeDescription typeDescription) {
            return getNestHost().equals(typeDescription.getNestHost());
        }

        public boolean isAnnotationValue() {
            return isPrimitive() || represents(String.class) || isAssignableTo((Class<?>) TypeDescription.class) || isAssignableTo((Class<?>) AnnotationDescription.class) || isAssignableTo((Class<?>) EnumerationDescription.class) || (isArray() && !getComponentType().isArray() && getComponentType().isAnnotationValue());
        }
    }

    public static class ArrayProjection extends AbstractBase {
        private static final int ARRAY_EXCLUDED = 8712;
        private static final int ARRAY_IMPLIED = 1040;
        private final int arity;
        private final TypeDescription componentType;

        public ArrayProjection(TypeDescription typeDescription, int i11) {
            this.componentType = typeDescription;
            this.arity = i11;
        }

        public static TypeDescription of(TypeDescription typeDescription) {
            return of(typeDescription, 1);
        }

        public String getCanonicalName() {
            String canonicalName = this.componentType.getCanonicalName();
            if (canonicalName == null) {
                return NamedElement.NO_NAME;
            }
            StringBuilder sb2 = new StringBuilder(canonicalName);
            for (int i11 = 0; i11 < this.arity; i11++) {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return sb2.toString();
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < this.arity; i11++) {
                sb2.append('[');
            }
            sb2.append(this.componentType.getDescriptor());
            return sb2.toString();
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        public AnnotationList getInheritedAnnotations() {
            return new AnnotationList.Empty();
        }

        public TypeList.Generic getInterfaces() {
            return TypeDescription.ARRAY_INTERFACES;
        }

        public int getModifiers() {
            return (getComponentType().getModifiers() & -8713) | ARRAY_IMPLIED;
        }

        public String getName() {
            String descriptor = this.componentType.getDescriptor();
            StringBuilder sb2 = new StringBuilder(descriptor.length() + this.arity);
            for (int i11 = 0; i11 < this.arity; i11++) {
                sb2.append('[');
            }
            for (int i12 = 0; i12 < descriptor.length(); i12++) {
                char charAt = descriptor.charAt(i12);
                if (charAt == '/') {
                    charAt = '.';
                }
                sb2.append(charAt);
            }
            return sb2.toString();
        }

        public TypeDescription getNestHost() {
            return this;
        }

        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        public PackageDescription getPackage() {
            return PackageDescription.UNDEFINED;
        }

        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        public String getSimpleName() {
            StringBuilder sb2 = new StringBuilder(this.componentType.getSimpleName());
            for (int i11 = 0; i11 < this.arity; i11++) {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return sb2.toString();
        }

        public StackSize getStackSize() {
            return StackSize.SINGLE;
        }

        public Generic getSuperClass() {
            return Generic.OBJECT;
        }

        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        public boolean isAnonymousType() {
            return false;
        }

        public boolean isArray() {
            return true;
        }

        public boolean isLocalType() {
            return false;
        }

        public boolean isMemberType() {
            return false;
        }

        public boolean isPrimitive() {
            return false;
        }

        public boolean isRecord() {
            return false;
        }

        public static TypeDescription of(TypeDescription typeDescription, int i11) {
            if (i11 >= 0) {
                while (typeDescription.isArray()) {
                    typeDescription = typeDescription.getComponentType();
                    i11++;
                }
                return i11 == 0 ? typeDescription : new ArrayProjection(typeDescription, i11);
            }
            throw new IllegalArgumentException("Arrays cannot have a negative arity");
        }

        public TypeDescription getComponentType() {
            int i11 = this.arity;
            return i11 == 1 ? this.componentType : new ArrayProjection(this.componentType, i11 - 1);
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }
    }

    @SuppressFBWarnings(justification = "Field is only used as a cache store and is implicitly recomputed", value = {"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    public static class ForLoadedType extends AbstractBase implements Serializable {
        private static final boolean ACCESS_CONTROLLER;
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        @SuppressFBWarnings(justification = "This collection is not exposed.", value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"})
        private static final Map<Class<?>, TypeDescription> TYPE_CACHE;
        private static final long serialVersionUID = 1;
        private transient /* synthetic */ ClassFileVersion classFileVersion;
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ FieldList declaredFields;
        private transient /* synthetic */ MethodList declaredMethods;
        private final Class<?> type;

        @JavaDispatcher.Defaults
        @JavaDispatcher.Proxied("java.lang.Class")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("getAnnotatedInterfaces")
            AnnotatedElement[] getAnnotatedInterfaces(Class<?> cls);

            @JavaDispatcher.Proxied("getAnnotatedSuperclass")
            AnnotatedElement getAnnotatedSuperclass(Class<?> cls);

            @JavaDispatcher.Proxied("getNestHost")
            Class<?> getNestHost(Class<?> cls);

            @JavaDispatcher.Proxied("getNestMembers")
            Class<?>[] getNestMembers(Class<?> cls);

            @JavaDispatcher.Proxied("getPermittedSubclasses")
            Class<?>[] getPermittedSubclasses(Class<?> cls);

            @JavaDispatcher.Proxied("getRecordComponents")
            Object[] getRecordComponents(Class<?> cls);

            @JavaDispatcher.Proxied("isNestmateOf")
            boolean isNestmateOf(Class<?> cls, Class<?> cls2);

            @JavaDispatcher.Proxied("isRecord")
            boolean isRecord(Class<?> cls);

            @JavaDispatcher.Proxied("isSealed")
            boolean isSealed(Class<?> cls);
        }

        static {
            boolean z11 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z11 = true;
            }
            HashMap hashMap = new HashMap();
            TYPE_CACHE = hashMap;
            Class<TargetType> cls = TargetType.class;
            hashMap.put(cls, new ForLoadedType(cls));
            Class<Object> cls2 = Object.class;
            hashMap.put(cls2, new ForLoadedType(cls2));
            Class<String> cls3 = String.class;
            hashMap.put(cls3, new ForLoadedType(cls3));
            Class<Boolean> cls4 = Boolean.class;
            hashMap.put(cls4, new ForLoadedType(cls4));
            Class<Byte> cls5 = Byte.class;
            hashMap.put(cls5, new ForLoadedType(cls5));
            Class<Short> cls6 = Short.class;
            hashMap.put(cls6, new ForLoadedType(cls6));
            Class<Character> cls7 = Character.class;
            hashMap.put(cls7, new ForLoadedType(cls7));
            Class<Integer> cls8 = Integer.class;
            hashMap.put(cls8, new ForLoadedType(cls8));
            Class<Long> cls9 = Long.class;
            hashMap.put(cls9, new ForLoadedType(cls9));
            Class<Float> cls10 = Float.class;
            hashMap.put(cls10, new ForLoadedType(cls10));
            Class<Double> cls11 = Double.class;
            hashMap.put(cls11, new ForLoadedType(cls11));
            Class cls12 = Void.TYPE;
            hashMap.put(cls12, new ForLoadedType(cls12));
            Class cls13 = Boolean.TYPE;
            hashMap.put(cls13, new ForLoadedType(cls13));
            Class cls14 = Byte.TYPE;
            hashMap.put(cls14, new ForLoadedType(cls14));
            Class cls15 = Short.TYPE;
            hashMap.put(cls15, new ForLoadedType(cls15));
            Class cls16 = Character.TYPE;
            hashMap.put(cls16, new ForLoadedType(cls16));
            Class cls17 = Integer.TYPE;
            hashMap.put(cls17, new ForLoadedType(cls17));
            Class cls18 = Long.TYPE;
            hashMap.put(cls18, new ForLoadedType(cls18));
            Class cls19 = Float.TYPE;
            hashMap.put(cls19, new ForLoadedType(cls19));
            Class cls20 = Double.TYPE;
            hashMap.put(cls20, new ForLoadedType(cls20));
            ACCESS_CONTROLLER = z11;
            HashMap hashMap2 = new HashMap();
            TYPE_CACHE = hashMap2;
            Class<TargetType> cls21 = TargetType.class;
            hashMap2.put(cls21, new ForLoadedType(cls21));
            Class<Object> cls22 = Object.class;
            hashMap2.put(cls22, new ForLoadedType(cls22));
            Class<String> cls32 = String.class;
            hashMap2.put(cls32, new ForLoadedType(cls32));
            Class<Boolean> cls42 = Boolean.class;
            hashMap2.put(cls42, new ForLoadedType(cls42));
            Class<Byte> cls52 = Byte.class;
            hashMap2.put(cls52, new ForLoadedType(cls52));
            Class<Short> cls62 = Short.class;
            hashMap2.put(cls62, new ForLoadedType(cls62));
            Class<Character> cls72 = Character.class;
            hashMap2.put(cls72, new ForLoadedType(cls72));
            Class<Integer> cls82 = Integer.class;
            hashMap2.put(cls82, new ForLoadedType(cls82));
            Class<Long> cls92 = Long.class;
            hashMap2.put(cls92, new ForLoadedType(cls92));
            Class<Float> cls102 = Float.class;
            hashMap2.put(cls102, new ForLoadedType(cls102));
            Class<Double> cls112 = Double.class;
            hashMap2.put(cls112, new ForLoadedType(cls112));
            Class cls122 = Void.TYPE;
            hashMap2.put(cls122, new ForLoadedType(cls122));
            Class cls132 = Boolean.TYPE;
            hashMap2.put(cls132, new ForLoadedType(cls132));
            Class cls142 = Byte.TYPE;
            hashMap2.put(cls142, new ForLoadedType(cls142));
            Class cls152 = Short.TYPE;
            hashMap2.put(cls152, new ForLoadedType(cls152));
            Class cls162 = Character.TYPE;
            hashMap2.put(cls162, new ForLoadedType(cls162));
            Class cls172 = Integer.TYPE;
            hashMap2.put(cls172, new ForLoadedType(cls172));
            Class cls182 = Long.TYPE;
            hashMap2.put(cls182, new ForLoadedType(cls182));
            Class cls192 = Float.TYPE;
            hashMap2.put(cls192, new ForLoadedType(cls192));
            Class cls202 = Double.TYPE;
            hashMap2.put(cls202, new ForLoadedType(cls202));
        }

        public ForLoadedType(Class<?> cls) {
            this.type = cls;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static String getName(Class<?> cls) {
            String name2 = cls.getName();
            int indexOf = name2.indexOf(47);
            return indexOf == -1 ? name2 : name2.substring(0, indexOf);
        }

        public static TypeDescription of(Class<?> cls) {
            TypeDescription typeDescription = TYPE_CACHE.get(cls);
            if (typeDescription == null) {
                return new ForLoadedType(cls);
            }
            return typeDescription;
        }

        public Generic asGenericType() {
            return Generic.OfNonGenericType.ForLoadedType.of(this.type);
        }

        public String getCanonicalName() {
            String canonicalName = this.type.getCanonicalName();
            if (canonicalName == null) {
                return NamedElement.NO_NAME;
            }
            int indexOf = canonicalName.indexOf(47);
            if (indexOf == -1) {
                return canonicalName;
            }
            StringBuilder sb2 = new StringBuilder(canonicalName.substring(0, indexOf));
            for (Class<?> cls = this.type; cls.isArray(); cls = cls.getComponentType()) {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return sb2.toString();
        }

        @CachedReturnPlugin.Enhance("classFileVersion")
        public ClassFileVersion getClassFileVersion() {
            ClassFileVersion classFileVersion2 = null;
            if (this.classFileVersion == null) {
                try {
                    classFileVersion2 = ClassFileVersion.of(this.type);
                } catch (Throwable unused) {
                }
            }
            if (classFileVersion2 == null) {
                return this.classFileVersion;
            }
            this.classFileVersion = classFileVersion2;
            return classFileVersion2;
        }

        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(this.type.getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @CachedReturnPlugin.Enhance("declaredFields")
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            FieldList.ForLoadedFields forLoadedFields = this.declaredFields != null ? null : new FieldList.ForLoadedFields(this.type.getDeclaredFields());
            if (forLoadedFields == null) {
                return this.declaredFields;
            }
            this.declaredFields = forLoadedFields;
            return forLoadedFields;
        }

        @CachedReturnPlugin.Enhance("declaredMethods")
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            MethodList.ForLoadedMethods forLoadedMethods = this.declaredMethods != null ? null : new MethodList.ForLoadedMethods(this.type);
            if (forLoadedMethods == null) {
                return this.declaredMethods;
            }
            this.declaredMethods = forLoadedMethods;
            return forLoadedMethods;
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.ForLoadedTypes((Class<?>[]) this.type.getDeclaredClasses());
        }

        public String getDescriptor() {
            String name2 = this.type.getName();
            int indexOf = name2.indexOf(47);
            if (indexOf == -1) {
                return net.bytebuddy.jar.asm.Type.getDescriptor(this.type);
            }
            return "L" + name2.substring(0, indexOf).replace('.', '/') + TypesAliasesKt.separator;
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            Method enclosingMethod = this.type.getEnclosingMethod();
            Constructor<?> enclosingConstructor = this.type.getEnclosingConstructor();
            if (enclosingMethod != null) {
                return new MethodDescription.ForLoadedMethod(enclosingMethod);
            }
            if (enclosingConstructor != null) {
                return new MethodDescription.ForLoadedConstructor(enclosingConstructor);
            }
            return MethodDescription.UNDEFINED;
        }

        public TypeDescription getEnclosingType() {
            Class<?> enclosingClass = this.type.getEnclosingClass();
            if (enclosingClass == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(enclosingClass);
        }

        public TypeList.Generic getInterfaces() {
            if (AbstractBase.RAW_TYPES) {
                if (isArray()) {
                    return TypeDescription.ARRAY_INTERFACES;
                }
                return new TypeList.Generic.ForLoadedTypes((Type[]) this.type.getInterfaces());
            } else if (isArray()) {
                return TypeDescription.ARRAY_INTERFACES;
            } else {
                return new TypeList.Generic.OfLoadedInterfaceTypes(this.type);
            }
        }

        public int getModifiers() {
            return this.type.getModifiers();
        }

        public TypeDescription getNestHost() {
            Class<?> nestHost = DISPATCHER.getNestHost(this.type);
            if (nestHost == null) {
                return this;
            }
            return of(nestHost);
        }

        public TypeList getNestMembers() {
            Class[] nestMembers = DISPATCHER.getNestMembers(this.type);
            if (nestMembers.length == 0) {
                nestMembers = new Class[]{this.type};
            }
            return new TypeList.ForLoadedTypes((Class<?>[]) nestMembers);
        }

        public PackageDescription getPackage() {
            if (this.type.isArray() || this.type.isPrimitive()) {
                return PackageDescription.UNDEFINED;
            }
            Package packageR = this.type.getPackage();
            if (packageR != null) {
                return new PackageDescription.ForLoadedPackage(packageR);
            }
            String name2 = this.type.getName();
            int lastIndexOf = name2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return new PackageDescription.Simple("");
            }
            return new PackageDescription.Simple(name2.substring(0, lastIndexOf));
        }

        public TypeList getPermittedSubtypes() {
            Class[] permittedSubclasses = DISPATCHER.getPermittedSubclasses(this.type);
            if (permittedSubclasses == null) {
                return new TypeList.Empty();
            }
            return new TypeList.ForLoadedTypes((Class<?>[]) permittedSubclasses);
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            Object[] recordComponents = DISPATCHER.getRecordComponents(this.type);
            if (recordComponents == null) {
                return new RecordComponentList.Empty();
            }
            return new RecordComponentList.ForLoadedRecordComponents(recordComponents);
        }

        public String getSimpleName() {
            String simpleName = this.type.getSimpleName();
            int indexOf = simpleName.indexOf(47);
            if (indexOf == -1) {
                return simpleName;
            }
            StringBuilder sb2 = new StringBuilder(simpleName.substring(0, indexOf));
            for (Class<?> cls = this.type; cls.isArray(); cls = cls.getComponentType()) {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return sb2.toString();
        }

        public StackSize getStackSize() {
            return StackSize.of(this.type);
        }

        public Generic getSuperClass() {
            if (AbstractBase.RAW_TYPES) {
                if (this.type.getSuperclass() == null) {
                    return Generic.UNDEFINED;
                }
                return Generic.OfNonGenericType.ForLoadedType.of(this.type.getSuperclass());
            } else if (this.type.getSuperclass() == null) {
                return Generic.UNDEFINED;
            } else {
                return new Generic.LazyProjection.ForLoadedSuperClass(this.type);
            }
        }

        public TypeList.Generic getTypeVariables() {
            if (AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.Empty();
            }
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of(this.type);
        }

        public boolean isAnnotation() {
            return this.type.isAnnotation();
        }

        public boolean isAnonymousType() {
            return this.type.isAnonymousClass();
        }

        public boolean isArray() {
            return this.type.isArray();
        }

        public boolean isAssignableFrom(Class<?> cls) {
            return this.type.isAssignableFrom(cls) || super.isAssignableFrom(cls);
        }

        public boolean isAssignableTo(Class<?> cls) {
            return cls.isAssignableFrom(this.type) || super.isAssignableTo(cls);
        }

        public boolean isInHierarchyWith(Class<?> cls) {
            return cls.isAssignableFrom(this.type) || this.type.isAssignableFrom(cls) || super.isInHierarchyWith(cls);
        }

        public boolean isLocalType() {
            return this.type.isLocalClass();
        }

        public boolean isMemberType() {
            return this.type.isMemberClass();
        }

        public boolean isNestHost() {
            Class<?> nestHost = DISPATCHER.getNestHost(this.type);
            if (nestHost == null || nestHost == this.type) {
                return true;
            }
            return false;
        }

        public boolean isNestMateOf(Class<?> cls) {
            return DISPATCHER.isNestmateOf(this.type, cls) || super.isNestMateOf(of(cls));
        }

        public boolean isPrimitive() {
            return this.type.isPrimitive();
        }

        public boolean isRecord() {
            return DISPATCHER.isRecord(this.type);
        }

        public boolean isSealed() {
            return DISPATCHER.isSealed(this.type);
        }

        public boolean represents(Type type2) {
            return type2 == this.type || super.represents(type2);
        }

        public TypeDescription getComponentType() {
            Class<?> componentType = this.type.getComponentType();
            if (componentType == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(componentType);
        }

        public TypeDescription getDeclaringType() {
            Class<?> declaringClass = this.type.getDeclaringClass();
            if (declaringClass == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(declaringClass);
        }

        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && this.type.isAssignableFrom(((ForLoadedType) typeDescription).type)) || super.isAssignableFrom(typeDescription);
        }

        public boolean isAssignableTo(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && ((ForLoadedType) typeDescription).type.isAssignableFrom(this.type)) || super.isAssignableTo(typeDescription);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            if (r3.type.isAssignableFrom(r0.type) == false) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isInHierarchyWith(net.bytebuddy.description.type.TypeDescription r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof net.bytebuddy.description.type.TypeDescription.ForLoadedType
                if (r0 == 0) goto L_0x001b
                r0 = r4
                net.bytebuddy.description.type.TypeDescription$ForLoadedType r0 = (net.bytebuddy.description.type.TypeDescription.ForLoadedType) r0
                java.lang.Class<?> r1 = r0.type
                java.lang.Class<?> r2 = r3.type
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 != 0) goto L_0x0021
                java.lang.Class<?> r1 = r3.type
                java.lang.Class<?> r0 = r0.type
                boolean r0 = r1.isAssignableFrom(r0)
                if (r0 != 0) goto L_0x0021
            L_0x001b:
                boolean r4 = super.isInHierarchyWith((net.bytebuddy.description.type.TypeDescription) r4)
                if (r4 == 0) goto L_0x0023
            L_0x0021:
                r4 = 1
                goto L_0x0024
            L_0x0023:
                r4 = 0
            L_0x0024:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.ForLoadedType.isInHierarchyWith(net.bytebuddy.description.type.TypeDescription):boolean");
        }

        public boolean isNestMateOf(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && DISPATCHER.isNestmateOf(this.type, ((ForLoadedType) typeDescription).type)) || super.isNestMateOf(typeDescription);
        }

        public String getName() {
            return getName(this.type);
        }
    }

    public static class ForPackageDescription extends AbstractBase.OfSimpleType {
        private final PackageDescription packageDescription;

        public ForPackageDescription(PackageDescription packageDescription2) {
            this.packageDescription = packageDescription2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.packageDescription.getDeclaredAnnotations();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Empty();
        }

        public int getModifiers() {
            return PackageDescription.PACKAGE_MODIFIERS;
        }

        public String getName() {
            return this.packageDescription.getName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + PackageDescription.PACKAGE_CLASS_NAME;
        }

        public TypeDescription getNestHost() {
            return this;
        }

        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        public PackageDescription getPackage() {
            return this.packageDescription;
        }

        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        public Generic getSuperClass() {
            return Generic.OBJECT;
        }

        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        public boolean isAnonymousType() {
            return false;
        }

        public boolean isLocalType() {
            return false;
        }

        public boolean isRecord() {
            return false;
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }
    }

    public interface Generic extends TypeDefinition, AnnotationSource {
        public static final Generic ANNOTATION = new OfNonGenericType.ForLoadedType(Annotation.class);
        public static final Generic CLASS = new OfNonGenericType.ForLoadedType(Class.class);
        public static final Generic OBJECT = new OfNonGenericType.ForLoadedType(Object.class);
        public static final Generic UNDEFINED = null;
        public static final Generic VOID = new OfNonGenericType.ForLoadedType(Void.TYPE);

        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Generic {
            public Generic asGenericType() {
                return this;
            }

            public Generic asRawType() {
                return asErasure().asGenericType();
            }

            public int getModifiers() {
                return asErasure().getModifiers();
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }
        }

        public interface AnnotationReader {

            public static abstract class Delegator implements AnnotationReader {
                private static final boolean ACCESS_CONTROLLER;

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class Chained extends Delegator {

                    /* renamed from: b  reason: collision with root package name */
                    public final AnnotationReader f27120b;

                    public Chained(AnnotationReader annotationReader) {
                        this.f27120b = annotationReader;
                    }

                    public abstract AnnotatedElement b(AnnotatedElement annotatedElement);

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.f27120b.equals(((Chained) obj).f27120b);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.f27120b.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        return b(this.f27120b.resolve());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedExecutableExceptionType extends Delegator {

                    /* renamed from: b  reason: collision with root package name */
                    public static final Dispatcher f27121b = ((Dispatcher) Delegator.a(JavaDispatcher.of(Dispatcher.class)));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    public interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedExceptionTypes")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedExceptionTypes(Object obj);
                    }

                    public ForLoadedExecutableExceptionType(AccessibleObject accessibleObject, int i11) {
                        this.executable = accessibleObject;
                        this.index = i11;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedExecutableExceptionType forLoadedExecutableExceptionType = (ForLoadedExecutableExceptionType) obj;
                        return this.index == forLoadedExecutableExceptionType.index && this.executable.equals(forLoadedExecutableExceptionType.executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedExceptionTypes = f27121b.getAnnotatedExceptionTypes(this.executable);
                        if (annotatedExceptionTypes.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedExceptionTypes[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedExecutableParameterType extends Delegator {

                    /* renamed from: b  reason: collision with root package name */
                    public static final Dispatcher f27122b = ((Dispatcher) Delegator.a(JavaDispatcher.of(Dispatcher.class)));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    public interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedParameterTypes")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedParameterTypes(Object obj);
                    }

                    public ForLoadedExecutableParameterType(AccessibleObject accessibleObject, int i11) {
                        this.executable = accessibleObject;
                        this.index = i11;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedExecutableParameterType forLoadedExecutableParameterType = (ForLoadedExecutableParameterType) obj;
                        return this.index == forLoadedExecutableParameterType.index && this.executable.equals(forLoadedExecutableParameterType.executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedParameterTypes = f27122b.getAnnotatedParameterTypes(this.executable);
                        if (annotatedParameterTypes.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedParameterTypes[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedField extends Delegator {

                    /* renamed from: b  reason: collision with root package name */
                    public static final Dispatcher f27123b = ((Dispatcher) Delegator.a(JavaDispatcher.of(Dispatcher.class)));
                    private final Field field;

                    @JavaDispatcher.Proxied("java.lang.reflect.Field")
                    public interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedType")
                        @JavaDispatcher.Defaults
                        AnnotatedElement getAnnotatedType(Field field);
                    }

                    public ForLoadedField(Field field2) {
                        this.field = field2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.field.equals(((ForLoadedField) obj).field);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.field.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedType = f27123b.getAnnotatedType(this.field);
                        if (annotatedType == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedType;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedInterface extends Delegator {
                    private final int index;
                    private final Class<?> type;

                    public ForLoadedInterface(Class<?> cls, int i11) {
                        this.type = cls;
                        this.index = i11;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedInterface forLoadedInterface = (ForLoadedInterface) obj;
                        return this.index == forLoadedInterface.index && this.type.equals(forLoadedInterface.type);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedInterfaces = ForLoadedType.DISPATCHER.getAnnotatedInterfaces(this.type);
                        if (annotatedInterfaces.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedInterfaces[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedMethodReturnType extends Delegator {

                    /* renamed from: b  reason: collision with root package name */
                    public static final Dispatcher f27124b = ((Dispatcher) Delegator.a(JavaDispatcher.of(Dispatcher.class)));
                    private final Method method;

                    @JavaDispatcher.Proxied("java.lang.reflect.Method")
                    public interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedReturnType")
                        @JavaDispatcher.Defaults
                        AnnotatedElement getAnnotatedReturnType(Method method);
                    }

                    public ForLoadedMethodReturnType(Method method2) {
                        this.method = method2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethodReturnType) obj).method);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.method.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedReturnType = f27124b.getAnnotatedReturnType(this.method);
                        if (annotatedReturnType == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedReturnType;
                    }
                }

                public static class ForLoadedRecordComponent extends Delegator {
                    private final Object recordComponent;

                    public ForLoadedRecordComponent(Object obj) {
                        this.recordComponent = obj;
                    }

                    public AnnotatedElement resolve() {
                        return RecordComponentDescription.ForLoadedRecordComponent.f27117b.getAnnotatedType(this.recordComponent);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedSuperClass extends Delegator {
                    private final Class<?> type;

                    public ForLoadedSuperClass(Class<?> cls) {
                        this.type = cls;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.type.equals(((ForLoadedSuperClass) obj).type);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.type.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedSuperclass = ForLoadedType.DISPATCHER.getAnnotatedSuperclass(this.type);
                        if (annotatedSuperclass == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedSuperclass;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLoadedTypeVariable extends Delegator {
                    private final TypeVariable<?> typeVariable;

                    public ForLoadedTypeVariable(TypeVariable<?> typeVariable2) {
                        this.typeVariable = typeVariable2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForLoadedTypeVariable) obj).typeVariable);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                    }

                    public AnnotationReader ofTypeVariableBoundType(int i11) {
                        return new ForTypeVariableBoundType.OfFormalTypeVariable(this.typeVariable, i11);
                    }

                    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.reflect.TypeVariable<?>, java.lang.reflect.AnnotatedElement] */
                    @SuppressFBWarnings(justification = "Cast is required for JVMs before Java 8", value = {"BC_VACUOUS_INSTANCEOF"})
                    public AnnotatedElement resolve() {
                        ? r02 = this.typeVariable;
                        return r02 instanceof AnnotatedElement ? r02 : NoOp.INSTANCE;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple extends Delegator {
                    private final AnnotatedElement annotatedElement;

                    public Simple(AnnotatedElement annotatedElement2) {
                        this.annotatedElement = annotatedElement2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.annotatedElement.equals(((Simple) obj).annotatedElement);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.annotatedElement.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        return this.annotatedElement;
                    }
                }

                static {
                    boolean z11 = false;
                    try {
                        Class.forName("java.security.AccessController", false, (ClassLoader) null);
                        ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                        return;
                    } catch (ClassNotFoundException unused) {
                    } catch (SecurityException unused2) {
                        z11 = true;
                    }
                    ACCESS_CONTROLLER = z11;
                }

                @AccessControllerPlugin.Enhance
                public static <T> T a(PrivilegedAction<T> privilegedAction) {
                    if (ACCESS_CONTROLLER) {
                        return AccessController.doPrivileged(privilegedAction);
                    }
                    return privilegedAction.run();
                }

                public AnnotationList asList() {
                    return new AnnotationList.ForLoadedAnnotations(resolve().getDeclaredAnnotations());
                }

                public AnnotationReader ofComponentType() {
                    return new ForComponentType(this);
                }

                public AnnotationReader ofOuterClass() {
                    return new ForOwnerType(this);
                }

                public AnnotationReader ofOwnerType() {
                    return new ForOwnerType(this);
                }

                public AnnotationReader ofTypeArgument(int i11) {
                    return new ForTypeArgument(this, i11);
                }

                public AnnotationReader ofTypeVariableBoundType(int i11) {
                    return new ForTypeVariableBoundType(this, i11);
                }

                public AnnotationReader ofWildcardLowerBoundType(int i11) {
                    return new ForWildcardLowerBoundType(this, i11);
                }

                public AnnotationReader ofWildcardUpperBoundType(int i11) {
                    return new ForWildcardUpperBoundType(this, i11);
                }
            }

            public static class ForComponentType extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = ((AnnotatedParameterizedType) Delegator.a(JavaDispatcher.of(AnnotatedParameterizedType.class)));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedArrayType")
                public interface AnnotatedParameterizedType {
                    @JavaDispatcher.Proxied("getAnnotatedGenericComponentType")
                    AnnotatedElement getAnnotatedGenericComponentType(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                public ForComponentType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    AnnotatedParameterizedType annotatedParameterizedType = ANNOTATED_PARAMETERIZED_TYPE;
                    if (!annotatedParameterizedType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedParameterizedType.getAnnotatedGenericComponentType(annotatedElement);
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            public static class ForOwnerType extends Delegator.Chained {
                private static final AnnotatedType ANNOTATED_TYPE = ((AnnotatedType) Delegator.a(JavaDispatcher.of(AnnotatedType.class)));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedType")
                public interface AnnotatedType {
                    @JavaDispatcher.Proxied("getAnnotatedOwnerType")
                    @JavaDispatcher.Defaults
                    AnnotatedElement getAnnotatedOwnerType(AnnotatedElement annotatedElement);
                }

                public ForOwnerType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    try {
                        AnnotatedElement annotatedOwnerType = ANNOTATED_TYPE.getAnnotatedOwnerType(annotatedElement);
                        if (annotatedOwnerType == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedOwnerType;
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeArgument extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = ((AnnotatedParameterizedType) Delegator.a(JavaDispatcher.of(AnnotatedParameterizedType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedParameterizedType")
                public interface AnnotatedParameterizedType {
                    @JavaDispatcher.Proxied("getAnnotatedActualTypeArguments")
                    AnnotatedElement[] getAnnotatedActualTypeArguments(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                public ForTypeArgument(AnnotationReader annotationReader, int i11) {
                    super(annotationReader);
                    this.index = i11;
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    AnnotatedParameterizedType annotatedParameterizedType = ANNOTATED_PARAMETERIZED_TYPE;
                    if (!annotatedParameterizedType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedParameterizedType.getAnnotatedActualTypeArguments(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeArgument) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeVariableBoundType extends Delegator.Chained {
                private static final AnnotatedTypeVariable ANNOTATED_TYPE_VARIABLE = ((AnnotatedTypeVariable) Delegator.a(JavaDispatcher.of(AnnotatedTypeVariable.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedTypeVariable")
                public interface AnnotatedTypeVariable {
                    @JavaDispatcher.Proxied("getAnnotatedBounds")
                    AnnotatedElement[] getAnnotatedBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class OfFormalTypeVariable extends Delegator {
                    private static final FormalTypeVariable TYPE_VARIABLE = ((FormalTypeVariable) Delegator.a(JavaDispatcher.of(FormalTypeVariable.class)));
                    private final int index;
                    private final TypeVariable<?> typeVariable;

                    @JavaDispatcher.Proxied("java.lang.reflect.TypeVariable")
                    public interface FormalTypeVariable {
                        @JavaDispatcher.Proxied("getAnnotatedBounds")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedBounds(Object obj);
                    }

                    public OfFormalTypeVariable(TypeVariable<?> typeVariable2, int i11) {
                        this.typeVariable = typeVariable2;
                        this.index = i11;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfFormalTypeVariable ofFormalTypeVariable = (OfFormalTypeVariable) obj;
                        return this.index == ofFormalTypeVariable.index && this.typeVariable.equals(ofFormalTypeVariable.typeVariable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        try {
                            AnnotatedElement[] annotatedBounds = TYPE_VARIABLE.getAnnotatedBounds(this.typeVariable);
                            if (annotatedBounds.length == 0) {
                                return NoOp.INSTANCE;
                            }
                            return annotatedBounds[this.index];
                        } catch (ClassCastException unused) {
                            return NoOp.INSTANCE;
                        }
                    }
                }

                public ForTypeVariableBoundType(AnnotationReader annotationReader, int i11) {
                    super(annotationReader);
                    this.index = i11;
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    AnnotatedTypeVariable annotatedTypeVariable = ANNOTATED_TYPE_VARIABLE;
                    if (!annotatedTypeVariable.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedTypeVariable.getAnnotatedBounds(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeVariableBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForWildcardLowerBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = ((AnnotatedWildcardType) Delegator.a(JavaDispatcher.of(AnnotatedWildcardType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                public interface AnnotatedWildcardType {
                    @JavaDispatcher.Proxied("getAnnotatedLowerBounds")
                    AnnotatedElement[] getAnnotatedLowerBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                public ForWildcardLowerBoundType(AnnotationReader annotationReader, int i11) {
                    super(annotationReader);
                    this.index = i11;
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    AnnotatedWildcardType annotatedWildcardType = ANNOTATED_WILDCARD_TYPE;
                    if (!annotatedWildcardType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedWildcardType.getAnnotatedLowerBounds(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardLowerBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForWildcardUpperBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = ((AnnotatedWildcardType) Delegator.a(JavaDispatcher.of(AnnotatedWildcardType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                public interface AnnotatedWildcardType {
                    @JavaDispatcher.Proxied("getAnnotatedUpperBounds")
                    AnnotatedElement[] getAnnotatedUpperBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                public ForWildcardUpperBoundType(AnnotationReader annotationReader, int i11) {
                    super(annotationReader);
                    this.index = i11;
                }

                public AnnotatedElement b(AnnotatedElement annotatedElement) {
                    AnnotatedWildcardType annotatedWildcardType = ANNOTATED_WILDCARD_TYPE;
                    if (!annotatedWildcardType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        AnnotatedElement[] annotatedUpperBounds = annotatedWildcardType.getAnnotatedUpperBounds(annotatedElement);
                        if (annotatedUpperBounds.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedUpperBounds[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardUpperBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }
            }

            public enum NoOp implements AnnotationReader, AnnotatedElement {
                INSTANCE;

                public AnnotationList asList() {
                    return new AnnotationList.Empty();
                }

                public <T extends Annotation> T getAnnotation(Class<T> cls) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public Annotation[] getAnnotations() {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public Annotation[] getDeclaredAnnotations() {
                    return new Annotation[0];
                }

                public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public AnnotationReader ofComponentType() {
                    return this;
                }

                public AnnotationReader ofOuterClass() {
                    return this;
                }

                public AnnotationReader ofOwnerType() {
                    return this;
                }

                public AnnotationReader ofTypeArgument(int i11) {
                    return this;
                }

                public AnnotationReader ofTypeVariableBoundType(int i11) {
                    return this;
                }

                public AnnotationReader ofWildcardLowerBoundType(int i11) {
                    return this;
                }

                public AnnotationReader ofWildcardUpperBoundType(int i11) {
                    return this;
                }

                public AnnotatedElement resolve() {
                    return this;
                }
            }

            AnnotationList asList();

            AnnotationReader ofComponentType();

            AnnotationReader ofOuterClass();

            AnnotationReader ofOwnerType();

            AnnotationReader ofTypeArgument(int i11);

            AnnotationReader ofTypeVariableBoundType(int i11);

            AnnotationReader ofWildcardLowerBoundType(int i11);

            AnnotationReader ofWildcardUpperBoundType(int i11);

            AnnotatedElement resolve();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class Builder {
            private static final Type UNDEFINED = null;

            /* renamed from: a  reason: collision with root package name */
            public final List<? extends AnnotationDescription> f27125a;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGenericArrayType extends Builder {
                private final Generic componentType;

                public OfGenericArrayType(Generic generic) {
                    this(generic, Collections.emptyList());
                }

                public Builder a(List<? extends AnnotationDescription> list) {
                    return new OfGenericArrayType(this.componentType, CompoundList.of(this.f27125a, list));
                }

                public Generic b() {
                    return new OfGenericArray.Latent(this.componentType, new AnnotationSource.Explicit(this.f27125a));
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfGenericArrayType) obj).componentType);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.componentType.hashCode();
                }

                public OfGenericArrayType(Generic generic, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.componentType = generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfNonGenericType extends Builder {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Generic ownerType;
                private final TypeDescription typeDescription;

                public OfNonGenericType(TypeDescription typeDescription2) {
                    this(typeDescription2, typeDescription2.getDeclaringType());
                }

                public Builder a(List<? extends AnnotationDescription> list) {
                    return new OfNonGenericType(this.typeDescription, this.ownerType, CompoundList.of(this.f27125a, list));
                }

                public Generic b() {
                    if (!this.typeDescription.represents(Void.TYPE) || this.f27125a.isEmpty()) {
                        return new OfNonGenericType.Latent(this.typeDescription, this.ownerType, (AnnotationSource) new AnnotationSource.Explicit(this.f27125a));
                    }
                    throw new IllegalArgumentException("The void non-type cannot be annotated");
                }

                /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[RETURN] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean equals(java.lang.Object r5) {
                    /*
                        r4 = this;
                        boolean r0 = super.equals(r5)
                        r1 = 0
                        if (r0 != 0) goto L_0x0008
                        return r1
                    L_0x0008:
                        r0 = 1
                        if (r4 != r5) goto L_0x000c
                        return r0
                    L_0x000c:
                        if (r5 != 0) goto L_0x000f
                        return r1
                    L_0x000f:
                        java.lang.Class r2 = r4.getClass()
                        java.lang.Class r3 = r5.getClass()
                        if (r2 == r3) goto L_0x001a
                        return r1
                    L_0x001a:
                        net.bytebuddy.description.type.TypeDescription r2 = r4.typeDescription
                        net.bytebuddy.description.type.TypeDescription$Generic$Builder$OfNonGenericType r5 = (net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType) r5
                        net.bytebuddy.description.type.TypeDescription r3 = r5.typeDescription
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0027
                        return r1
                    L_0x0027:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.ownerType
                        net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.ownerType
                        if (r5 == 0) goto L_0x0036
                        if (r2 == 0) goto L_0x0038
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0039
                        return r1
                    L_0x0036:
                        if (r2 == 0) goto L_0x0039
                    L_0x0038:
                        return r1
                    L_0x0039:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = ((super.hashCode() * 31) + this.typeDescription.hashCode()) * 31;
                    Generic generic = this.ownerType;
                    return generic != null ? hashCode + generic.hashCode() : hashCode;
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public OfNonGenericType(net.bytebuddy.description.type.TypeDescription r1, net.bytebuddy.description.type.TypeDescription r2) {
                    /*
                        r0 = this;
                        if (r2 != 0) goto L_0x0005
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                        goto L_0x0009
                    L_0x0005:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.asGenericType()
                    L_0x0009:
                        r0.<init>((net.bytebuddy.description.type.TypeDescription) r1, (net.bytebuddy.description.type.TypeDescription.Generic) r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDescription):void");
                }

                public OfNonGenericType(TypeDescription typeDescription2, Generic generic) {
                    this(typeDescription2, generic, Collections.emptyList());
                }

                public OfNonGenericType(TypeDescription typeDescription2, Generic generic, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.ownerType = generic;
                    this.typeDescription = typeDescription2;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfParameterizedType extends Builder {
                private final Generic ownerType;
                private final List<? extends Generic> parameterTypes;
                private final TypeDescription rawType;

                public OfParameterizedType(TypeDescription typeDescription, Generic generic, List<? extends Generic> list) {
                    this(typeDescription, generic, list, Collections.emptyList());
                }

                public Builder a(List<? extends AnnotationDescription> list) {
                    return new OfParameterizedType(this.rawType, this.ownerType, this.parameterTypes, CompoundList.of(this.f27125a, list));
                }

                public Generic b() {
                    return new OfParameterizedType.Latent(this.rawType, this.ownerType, this.parameterTypes, new AnnotationSource.Explicit(this.f27125a));
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
                    OfParameterizedType ofParameterizedType = (OfParameterizedType) obj;
                    return this.rawType.equals(ofParameterizedType.rawType) && this.ownerType.equals(ofParameterizedType.ownerType) && this.parameterTypes.equals(ofParameterizedType.parameterTypes);
                }

                public int hashCode() {
                    return (((((super.hashCode() * 31) + this.rawType.hashCode()) * 31) + this.ownerType.hashCode()) * 31) + this.parameterTypes.hashCode();
                }

                public OfParameterizedType(TypeDescription typeDescription, Generic generic, List<? extends Generic> list, List<? extends AnnotationDescription> list2) {
                    super(list2);
                    this.rawType = typeDescription;
                    this.ownerType = generic;
                    this.parameterTypes = list;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfTypeVariable extends Builder {
                private final String symbol;

                public OfTypeVariable(String str) {
                    this(str, Collections.emptyList());
                }

                public Builder a(List<? extends AnnotationDescription> list) {
                    return new OfTypeVariable(this.symbol, CompoundList.of(this.f27125a, list));
                }

                public Generic b() {
                    return new OfTypeVariable.Symbolic(this.symbol, new AnnotationSource.Explicit(this.f27125a));
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.symbol.equals(((OfTypeVariable) obj).symbol);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.symbol.hashCode();
                }

                public OfTypeVariable(String str, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.symbol = str;
                }
            }

            public enum Visitor implements Visitor<Builder> {
                INSTANCE;

                public Builder onGenericArray(Generic generic) {
                    return new OfGenericArrayType(generic.getComponentType(), generic.getDeclaredAnnotations());
                }

                public Builder onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return ((Builder) generic.getComponentType().accept(this)).asArray().annotate((Collection<? extends AnnotationDescription>) generic.getDeclaredAnnotations());
                    }
                    return new OfNonGenericType(generic.asErasure(), generic.getOwnerType(), generic.getDeclaredAnnotations());
                }

                public Builder onParameterizedType(Generic generic) {
                    return new OfParameterizedType(generic.asErasure(), generic.getOwnerType(), generic.getTypeArguments(), generic.getDeclaredAnnotations());
                }

                public Builder onTypeVariable(Generic generic) {
                    return new OfTypeVariable(generic.getSymbol(), generic.getDeclaredAnnotations());
                }

                public Builder onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot resolve wildcard type " + generic + " to builder");
                }
            }

            public Builder(List<? extends AnnotationDescription> list) {
                this.f27125a = list;
            }

            public static Builder of(Type type) {
                return of(TypeDefinition.Sort.describe(type));
            }

            public static Builder parameterizedType(Class<?> cls, Type... typeArr) {
                return parameterizedType(cls, (List<? extends Type>) Arrays.asList(typeArr));
            }

            public static Builder rawType(Class<?> cls) {
                return rawType(ForLoadedType.of(cls));
            }

            public static Builder typeVariable(String str) {
                return new OfTypeVariable(str);
            }

            public static Generic unboundWildcard() {
                return unboundWildcard((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public abstract Builder a(List<? extends AnnotationDescription> list);

            public Builder annotate(Annotation... annotationArr) {
                return annotate((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Builder asArray() {
                return asArray(1);
            }

            public Generic asWildcardLowerBound() {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public Generic asWildcardUpperBound() {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public abstract Generic b();

            public Generic build() {
                return b();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.f27125a.equals(((Builder) obj).f27125a);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.f27125a.hashCode();
            }

            public static Builder of(Generic generic) {
                return (Builder) generic.accept(Visitor.INSTANCE);
            }

            public static Builder parameterizedType(Class<?> cls, List<? extends Type> list) {
                return parameterizedType(cls, UNDEFINED, list);
            }

            public static Builder rawType(TypeDescription typeDescription) {
                return new OfNonGenericType(typeDescription);
            }

            public static Generic unboundWildcard(Annotation... annotationArr) {
                return unboundWildcard((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Builder annotate(List<? extends Annotation> list) {
                return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder asArray(int i11) {
                if (i11 >= 1) {
                    Generic build = build();
                    while (true) {
                        i11--;
                        if (i11 <= 0) {
                            return new OfGenericArrayType(build);
                        }
                        build = new OfGenericArray.Latent(build, AnnotationSource.Empty.INSTANCE);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot define an array of a non-positive arity: " + i11);
                }
            }

            public Generic asWildcardLowerBound(Annotation... annotationArr) {
                return asWildcardLowerBound((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Generic asWildcardUpperBound(Annotation... annotationArr) {
                return asWildcardUpperBound((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Generic build(Annotation... annotationArr) {
                return build((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public static Builder parameterizedType(Class<?> cls, Type type, List<? extends Type> list) {
                Generic generic;
                TypeDescription of2 = ForLoadedType.of(cls);
                if (type == null) {
                    generic = null;
                } else {
                    generic = TypeDefinition.Sort.describe(type);
                }
                return parameterizedType(of2, generic, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public static Builder rawType(Class<?> cls, Generic generic) {
                return rawType(ForLoadedType.of(cls), generic);
            }

            public static Generic unboundWildcard(List<? extends Annotation> list) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder annotate(AnnotationDescription... annotationDescriptionArr) {
                return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic asWildcardLowerBound(List<? extends Annotation> list) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Generic asWildcardUpperBound(List<? extends Annotation> list) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Generic build(List<? extends Annotation> list) {
                return build((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public static Builder rawType(TypeDescription typeDescription, Generic generic) {
                TypeDescription declaringType = typeDescription.getDeclaringType();
                if (declaringType == null && generic != null) {
                    throw new IllegalArgumentException(typeDescription + " does not have a declaring type: " + generic);
                } else if (declaringType == null || (generic != null && declaringType.equals(generic.asErasure()))) {
                    return new OfNonGenericType(typeDescription, generic);
                } else {
                    throw new IllegalArgumentException(generic + " is not the declaring type of " + typeDescription);
                }
            }

            public static Generic unboundWildcard(AnnotationDescription... annotationDescriptionArr) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Builder annotate(Collection<? extends AnnotationDescription> collection) {
                return a(new ArrayList(collection));
            }

            public Generic asWildcardLowerBound(AnnotationDescription... annotationDescriptionArr) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic asWildcardUpperBound(AnnotationDescription... annotationDescriptionArr) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic build(AnnotationDescription... annotationDescriptionArr) {
                return build((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public static Generic unboundWildcard(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.unbounded(new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic asWildcardLowerBound(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.boundedBelow(build(), new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic asWildcardUpperBound(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.boundedAbove(build(), new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic build(Collection<? extends AnnotationDescription> collection) {
                return a(new ArrayList(collection)).b();
            }

            public static Builder parameterizedType(TypeDescription typeDescription, TypeDefinition... typeDefinitionArr) {
                return parameterizedType(typeDescription, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public static Builder parameterizedType(TypeDescription typeDescription, Collection<? extends TypeDefinition> collection) {
                return parameterizedType(typeDescription, Generic.UNDEFINED, collection);
            }

            public static Builder parameterizedType(TypeDescription typeDescription, Generic generic, Collection<? extends TypeDefinition> collection) {
                TypeDescription declaringType = typeDescription.getDeclaringType();
                if (generic == null && declaringType != null && typeDescription.isStatic()) {
                    generic = declaringType.asGenericType();
                }
                if (!typeDescription.represents(TargetType.class)) {
                    if (!typeDescription.isGenerified()) {
                        throw new IllegalArgumentException(typeDescription + " is not a parameterized type");
                    } else if (generic == null && declaringType != null && !typeDescription.isStatic()) {
                        throw new IllegalArgumentException(typeDescription + " requires an owner type");
                    } else if (generic != null && !generic.asErasure().equals(declaringType)) {
                        throw new IllegalArgumentException(generic + " does not represent required owner for " + typeDescription);
                    } else if (generic != null && (typeDescription.isStatic() ^ generic.getSort().isNonGeneric())) {
                        throw new IllegalArgumentException(generic + " does not define the correct parameters for owning " + typeDescription);
                    } else if (typeDescription.getTypeVariables().size() != collection.size()) {
                        throw new IllegalArgumentException(collection + " does not contain number of required parameters for " + typeDescription);
                    }
                }
                return new OfParameterizedType(typeDescription, generic, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection)));
            }
        }

        public static abstract class LazyProjection extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedFieldType extends WithEagerNavigation.OfAnnotatedElement {
                private final Field field;
                private transient /* synthetic */ Generic resolved;

                public ForLoadedFieldType(Field field2) {
                    this.field = field2;
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic a11 = this.resolved != null ? null : TypeDefinition.Sort.a(this.field.getGenericType(), b());
                    if (a11 == null) {
                        return this.resolved;
                    }
                    this.resolved = a11;
                    return a11;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.field.getType());
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedField(this.field);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static class ForLoadedReturnType extends WithEagerNavigation.OfAnnotatedElement {
                private final Method method;
                private transient /* synthetic */ Generic resolved;

                public ForLoadedReturnType(Method method2) {
                    this.method = method2;
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic a11 = this.resolved != null ? null : TypeDefinition.Sort.a(this.method.getGenericReturnType(), b());
                    if (a11 == null) {
                        return this.resolved;
                    }
                    this.resolved = a11;
                    return a11;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.method.getReturnType());
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedMethodReturnType(this.method);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static class ForLoadedSuperClass extends WithLazyNavigation.OfAnnotatedElement {
                private transient /* synthetic */ Generic resolved;
                private final Class<?> type;

                public ForLoadedSuperClass(Class<?> cls) {
                    this.type = cls;
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        Type genericSuperclass = this.type.getGenericSuperclass();
                        if (genericSuperclass == null) {
                            generic = Generic.UNDEFINED;
                        } else {
                            generic = TypeDefinition.Sort.a(genericSuperclass, b());
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                public TypeDescription asErasure() {
                    Class<? super Object> superclass = this.type.getSuperclass();
                    if (superclass == null) {
                        return TypeDescription.UNDEFINED;
                    }
                    return ForLoadedType.of(superclass);
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedSuperClass(this.type);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static class OfConstructorParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Constructor<?> constructor;
                private transient /* synthetic */ Generic delegate;
                private final Class<?>[] erasure;
                private final int index;

                @SuppressFBWarnings(justification = "The array is never exposed outside of the class", value = {"EI_EXPOSE_REP2"})
                public OfConstructorParameter(Constructor<?> constructor2, int i11, Class<?>[] clsArr) {
                    this.constructor = constructor2;
                    this.index = i11;
                    this.erasure = clsArr;
                }

                @CachedReturnPlugin.Enhance("delegate")
                public Generic a() {
                    Generic generic;
                    if (this.delegate != null) {
                        generic = null;
                    } else {
                        Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
                        Class<?>[] clsArr = this.erasure;
                        if (clsArr.length == genericParameterTypes.length) {
                            generic = TypeDefinition.Sort.a(genericParameterTypes[this.index], b());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.of(clsArr[this.index]);
                        }
                    }
                    if (generic == null) {
                        return this.delegate;
                    }
                    this.delegate = generic;
                    return generic;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.erasure[this.index]);
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.constructor, this.index);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static class OfMethodParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Class<?>[] erasure;
                private final int index;
                private final Method method;
                private transient /* synthetic */ Generic resolved;

                @SuppressFBWarnings(justification = "The array is never exposed outside of the class", value = {"EI_EXPOSE_REP2"})
                public OfMethodParameter(Method method2, int i11, Class<?>[] clsArr) {
                    this.method = method2;
                    this.index = i11;
                    this.erasure = clsArr;
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                        Class<?>[] clsArr = this.erasure;
                        if (clsArr.length == genericParameterTypes.length) {
                            generic = TypeDefinition.Sort.a(genericParameterTypes[this.index], b());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.of(clsArr[this.index]);
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.erasure[this.index]);
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.method, this.index);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static class OfRecordComponent extends WithEagerNavigation.OfAnnotatedElement {
                private final Object recordComponent;
                private transient /* synthetic */ Generic resolved;

                public OfRecordComponent(Object obj) {
                    this.recordComponent = obj;
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic a11 = this.resolved != null ? null : TypeDefinition.Sort.a(RecordComponentDescription.ForLoadedRecordComponent.f27117b.getGenericType(this.recordComponent), b());
                    if (a11 == null) {
                        return this.resolved;
                    }
                    this.resolved = a11;
                    return a11;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(RecordComponentDescription.ForLoadedRecordComponent.f27117b.getType(this.recordComponent));
                }

                public AnnotationReader b() {
                    return new AnnotationReader.Delegator.ForLoadedRecordComponent(this.recordComponent);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }
            }

            public static abstract class WithEagerNavigation extends LazyProjection {

                public static abstract class OfAnnotatedElement extends WithEagerNavigation {
                    public abstract AnnotationReader b();

                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return b().asList();
                    }
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public TypeList.Generic getInterfaces() {
                    return a().getInterfaces();
                }

                public Generic getSuperClass() {
                    return a().getSuperClass();
                }

                public Iterator<TypeDefinition> iterator() {
                    return a().iterator();
                }
            }

            public static abstract class WithLazyNavigation extends LazyProjection {

                public static class LazyInterfaceList extends TypeList.Generic.AbstractBase {
                    private final LazyProjection delegate;
                    private final TypeList.Generic rawInterfaces;

                    public LazyInterfaceList(LazyProjection lazyProjection, TypeList.Generic generic) {
                        this.delegate = lazyProjection;
                        this.rawInterfaces = generic;
                    }

                    public static TypeList.Generic c(LazyProjection lazyProjection) {
                        return new LazyInterfaceList(lazyProjection, lazyProjection.asErasure().getInterfaces());
                    }

                    public int size() {
                        return this.rawInterfaces.size();
                    }

                    public Generic get(int i11) {
                        return new LazyInterfaceType(this.delegate, i11, (Generic) this.rawInterfaces.get(i11));
                    }
                }

                public static class LazyInterfaceType extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private final int index;
                    private final Generic rawInterface;
                    private transient /* synthetic */ Generic resolved;

                    public LazyInterfaceType(LazyProjection lazyProjection, int i11, Generic generic) {
                        this.delegate = lazyProjection;
                        this.index = i11;
                        this.rawInterface = generic;
                    }

                    @CachedReturnPlugin.Enhance("resolved")
                    public Generic a() {
                        Generic generic = this.resolved != null ? null : (Generic) this.delegate.a().getInterfaces().get(this.index);
                        if (generic == null) {
                            return this.resolved;
                        }
                        this.resolved = generic;
                        return generic;
                    }

                    public TypeDescription asErasure() {
                        return this.rawInterface.asErasure();
                    }

                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return a().getDeclaredAnnotations();
                    }
                }

                public static class LazySuperClass extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private transient /* synthetic */ Generic resolved;

                    public LazySuperClass(LazyProjection lazyProjection) {
                        this.delegate = lazyProjection;
                    }

                    public static Generic b(LazyProjection lazyProjection) {
                        return lazyProjection.asErasure().getSuperClass() == null ? Generic.UNDEFINED : new LazySuperClass(lazyProjection);
                    }

                    @CachedReturnPlugin.Enhance("resolved")
                    public Generic a() {
                        Generic superClass = this.resolved != null ? null : this.delegate.a().getSuperClass();
                        if (superClass == null) {
                            return this.resolved;
                        }
                        this.resolved = superClass;
                        return superClass;
                    }

                    public TypeDescription asErasure() {
                        return this.delegate.asErasure().getSuperClass().asErasure();
                    }

                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return a().getDeclaredAnnotations();
                    }
                }

                public static abstract class OfAnnotatedElement extends WithLazyNavigation {
                    public abstract AnnotationReader b();

                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return b().asList();
                    }
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public TypeList.Generic getInterfaces() {
                    return LazyInterfaceList.c(this);
                }

                public Generic getSuperClass() {
                    return LazySuperClass.b(this);
                }

                public Iterator<TypeDefinition> iterator() {
                    return new TypeDefinition.SuperClassIterator(this);
                }
            }

            public static class WithResolvedErasure extends WithEagerNavigation {
                private final AnnotationSource annotationSource;
                private final Generic delegate;
                private transient /* synthetic */ Generic resolved;
                private final Visitor<? extends Generic> visitor;

                public WithResolvedErasure(Generic generic, Visitor<? extends Generic> visitor2) {
                    this(generic, visitor2, generic);
                }

                @CachedReturnPlugin.Enhance("resolved")
                public Generic a() {
                    Generic generic = this.resolved != null ? null : (Generic) this.delegate.accept(this.visitor);
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                public TypeDescription asErasure() {
                    return this.delegate.asErasure();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public WithResolvedErasure(Generic generic, Visitor<? extends Generic> visitor2, AnnotationSource annotationSource2) {
                    this.delegate = generic;
                    this.visitor = visitor2;
                    this.annotationSource = annotationSource2;
                }
            }

            public abstract Generic a();

            public <T> T accept(Visitor<T> visitor) {
                return a().accept(visitor);
            }

            public boolean equals(Object obj) {
                return this == obj || ((obj instanceof TypeDefinition) && a().equals(obj));
            }

            public Generic findBindingOf(Generic generic) {
                return a().findBindingOf(generic);
            }

            public String getActualName() {
                return a().getActualName();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return a().getDeclaredFields();
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return a().getDeclaredMethods();
            }

            public TypeList.Generic getLowerBounds() {
                return a().getLowerBounds();
            }

            public Generic getOwnerType() {
                return a().getOwnerType();
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return a().getRecordComponents();
            }

            public TypeDefinition.Sort getSort() {
                return a().getSort();
            }

            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            public String getSymbol() {
                return a().getSymbol();
            }

            public TypeList.Generic getTypeArguments() {
                return a().getTypeArguments();
            }

            public String getTypeName() {
                return a().getTypeName();
            }

            public TypeVariableSource getTypeVariableSource() {
                return a().getTypeVariableSource();
            }

            public TypeList.Generic getUpperBounds() {
                return a().getUpperBounds();
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : a().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return asErasure().isArray();
            }

            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public boolean represents(Type type) {
                return a().represents(type);
            }

            public String toString() {
                return a().toString();
            }

            public Generic getComponentType() {
                return a().getComponentType();
            }
        }

        public static abstract class OfGenericArray extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfGenericArray {
                private final AnnotationReader annotationReader;
                private final GenericArrayType genericArrayType;

                public ForLoadedType(GenericArrayType genericArrayType2) {
                    this(genericArrayType2, AnnotationReader.NoOp.INSTANCE);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public boolean represents(Type type) {
                    return this.genericArrayType == type || super.represents(type);
                }

                public ForLoadedType(GenericArrayType genericArrayType2, AnnotationReader annotationReader2) {
                    this.genericArrayType = genericArrayType2;
                    this.annotationReader = annotationReader2;
                }

                public Generic getComponentType() {
                    return TypeDefinition.Sort.a(this.genericArrayType.getGenericComponentType(), this.annotationReader.ofComponentType());
                }
            }

            public static class Latent extends OfGenericArray {
                private final AnnotationSource annotationSource;
                private final Generic componentType;

                public Latent(Generic generic, AnnotationSource annotationSource2) {
                    this.componentType = generic;
                    this.annotationSource = annotationSource2;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public Generic getComponentType() {
                    return this.componentType;
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                if (getSort().isNonGeneric()) {
                    return visitor.onNonGenericType(this);
                }
                return visitor.onGenericArray(this);
            }

            public TypeDescription asErasure() {
                return ArrayProjection.of(getComponentType().asErasure(), 1);
            }

            @SuppressFBWarnings(justification = "Type check is performed by erasure implementation", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (getSort().isNonGeneric()) {
                    return asErasure().equals(obj);
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isGenericArray() || !getComponentType().equals(generic.getComponentType())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            public String getActualName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getActualName();
                }
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.Empty();
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.Empty();
            }

            public TypeList.Generic getInterfaces() {
                return TypeDescription.ARRAY_INTERFACES;
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A generic array type does not imply lower type bounds: " + this);
            }

            public Generic getOwnerType() {
                return Generic.UNDEFINED;
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.Empty();
            }

            public TypeDefinition.Sort getSort() {
                return getComponentType().getSort().isNonGeneric() ? TypeDefinition.Sort.NON_GENERIC : TypeDefinition.Sort.GENERIC_ARRAY;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            public Generic getSuperClass() {
                return Generic.OBJECT;
            }

            public String getSymbol() {
                throw new IllegalStateException("A generic array type does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            public String getTypeName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getTypeName();
                }
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A generic array type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A generic array type does not imply upper type bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i11;
                if (this.hashCode != 0) {
                    i11 = 0;
                } else if (getSort().isNonGeneric()) {
                    i11 = asErasure().hashCode();
                } else {
                    i11 = getComponentType().hashCode();
                }
                if (i11 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i11;
                return i11;
            }

            public boolean isArray() {
                return true;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            public String toString() {
                if (getSort().isNonGeneric()) {
                    return asErasure().toString();
                }
                return getComponentType().getTypeName() + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        }

        public static abstract class OfNonGenericType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                public ForErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return declaringType.asGenericType();
                }

                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return componentType.asGenericType();
                }
            }

            public static class ForLoadedType extends OfNonGenericType {
                @SuppressFBWarnings(justification = "This collection is not exposed.", value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"})
                private static final Map<Class<?>, Generic> TYPE_CACHE;
                private final AnnotationReader annotationReader;
                private final Class<?> type;

                static {
                    HashMap hashMap = new HashMap();
                    TYPE_CACHE = hashMap;
                    Class<TargetType> cls = TargetType.class;
                    hashMap.put(cls, new ForLoadedType(cls));
                    Class<Object> cls2 = Object.class;
                    hashMap.put(cls2, new ForLoadedType(cls2));
                    Class<String> cls3 = String.class;
                    hashMap.put(cls3, new ForLoadedType(cls3));
                    Class<Boolean> cls4 = Boolean.class;
                    hashMap.put(cls4, new ForLoadedType(cls4));
                    Class<Byte> cls5 = Byte.class;
                    hashMap.put(cls5, new ForLoadedType(cls5));
                    Class<Short> cls6 = Short.class;
                    hashMap.put(cls6, new ForLoadedType(cls6));
                    Class<Character> cls7 = Character.class;
                    hashMap.put(cls7, new ForLoadedType(cls7));
                    Class<Integer> cls8 = Integer.class;
                    hashMap.put(cls8, new ForLoadedType(cls8));
                    Class<Long> cls9 = Long.class;
                    hashMap.put(cls9, new ForLoadedType(cls9));
                    Class<Float> cls10 = Float.class;
                    hashMap.put(cls10, new ForLoadedType(cls10));
                    Class<Double> cls11 = Double.class;
                    hashMap.put(cls11, new ForLoadedType(cls11));
                    Class cls12 = Void.TYPE;
                    hashMap.put(cls12, new ForLoadedType(cls12));
                    Class cls13 = Boolean.TYPE;
                    hashMap.put(cls13, new ForLoadedType(cls13));
                    Class cls14 = Byte.TYPE;
                    hashMap.put(cls14, new ForLoadedType(cls14));
                    Class cls15 = Short.TYPE;
                    hashMap.put(cls15, new ForLoadedType(cls15));
                    Class cls16 = Character.TYPE;
                    hashMap.put(cls16, new ForLoadedType(cls16));
                    Class cls17 = Integer.TYPE;
                    hashMap.put(cls17, new ForLoadedType(cls17));
                    Class cls18 = Long.TYPE;
                    hashMap.put(cls18, new ForLoadedType(cls18));
                    Class cls19 = Float.TYPE;
                    hashMap.put(cls19, new ForLoadedType(cls19));
                    Class cls20 = Double.TYPE;
                    hashMap.put(cls20, new ForLoadedType(cls20));
                }

                public ForLoadedType(Class<?> cls) {
                    this(cls, AnnotationReader.NoOp.INSTANCE);
                }

                public static Generic of(Class<?> cls) {
                    Generic generic = TYPE_CACHE.get(cls);
                    if (generic == null) {
                        return new ForLoadedType(cls);
                    }
                    return generic;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.type);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public Generic getOwnerType() {
                    Class<?> declaringClass = this.type.getDeclaringClass();
                    if (declaringClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new ForLoadedType(declaringClass, this.annotationReader.ofOuterClass());
                }

                public boolean represents(Type type2) {
                    return this.type == type2 || super.represents(type2);
                }

                public ForLoadedType(Class<?> cls, AnnotationReader annotationReader2) {
                    this.type = cls;
                    this.annotationReader = annotationReader2;
                }

                public Generic getComponentType() {
                    Class<?> componentType = this.type.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return new ForLoadedType(componentType, this.annotationReader.ofComponentType());
                }
            }

            public static class ForReifiedErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                public ForReifiedErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public static Generic of(TypeDescription typeDescription2) {
                    return typeDescription2.isGenerified() ? new ForReifiedErasure(typeDescription2) : new ForErasure(typeDescription2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, this.typeDescription.getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, this.typeDescription.getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.typeDescription.getInterfaces(), Visitor.Reifying.INHERITING);
                }

                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(declaringType);
                }

                public Generic getSuperClass() {
                    Generic superClass = this.typeDescription.getSuperClass();
                    if (superClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(componentType);
                }
            }

            public static class Latent extends OfNonGenericType {
                private final AnnotationSource annotationSource;
                private final Generic declaringType;
                private final TypeDescription typeDescription;

                public Latent(TypeDescription typeDescription2, AnnotationSource annotationSource2) {
                    this(typeDescription2, typeDescription2.getDeclaringType(), annotationSource2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public Generic getOwnerType() {
                    return this.declaringType;
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private Latent(net.bytebuddy.description.type.TypeDescription r1, net.bytebuddy.description.type.TypeDescription r2, net.bytebuddy.description.annotation.AnnotationSource r3) {
                    /*
                        r0 = this;
                        if (r2 != 0) goto L_0x0005
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                        goto L_0x0009
                    L_0x0005:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.asGenericType()
                    L_0x0009:
                        r0.<init>((net.bytebuddy.description.type.TypeDescription) r1, (net.bytebuddy.description.type.TypeDescription.Generic) r2, (net.bytebuddy.description.annotation.AnnotationSource) r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType.Latent.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.annotation.AnnotationSource):void");
                }

                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return componentType.asGenericType();
                }

                public Latent(TypeDescription typeDescription2, Generic generic, AnnotationSource annotationSource2) {
                    this.typeDescription = typeDescription2;
                    this.declaringType = generic;
                    this.annotationSource = annotationSource2;
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onNonGenericType(this);
            }

            @SuppressFBWarnings(justification = "Type check is performed by erasure implementation", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
            public boolean equals(Object obj) {
                return this == obj || asErasure().equals(obj);
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            public String getActualName() {
                return asErasure().getActualName();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                FieldList<FieldDescription.InDefinedShape> declaredFields = asErasure.getDeclaredFields();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new FieldList.TypeSubstituting(this, declaredFields, visitor);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                MethodList<MethodDescription.InDefinedShape> declaredMethods = asErasure.getDeclaredMethods();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new MethodList.TypeSubstituting(this, declaredMethods, visitor);
            }

            public TypeList.Generic getInterfaces() {
                TypeDescription asErasure = asErasure();
                if (AbstractBase.RAW_TYPES) {
                    return asErasure.getInterfaces();
                }
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(asErasure.getInterfaces(), new Visitor.ForRawType(asErasure));
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A non-generic type does not imply lower type bounds: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents = asErasure.getRecordComponents();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new RecordComponentList.TypeSubstituting(this, recordComponents, visitor);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.NON_GENERIC;
            }

            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            public Generic getSuperClass() {
                TypeDescription asErasure = asErasure();
                Generic superClass = asErasure.getSuperClass();
                if (AbstractBase.RAW_TYPES) {
                    return superClass;
                }
                if (superClass == null) {
                    return Generic.UNDEFINED;
                }
                return new LazyProjection.WithResolvedErasure(superClass, new Visitor.ForRawType(asErasure), AnnotationSource.Empty.INSTANCE);
            }

            public String getSymbol() {
                throw new IllegalStateException("A non-generic type does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return asErasure().getTypeName();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A non-generic type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A non-generic type does not imply upper type bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : asErasure().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return asErasure().isArray();
            }

            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            public boolean represents(Type type) {
                return asErasure().represents(type);
            }

            public String toString() {
                return asErasure().toString();
            }
        }

        public static abstract class OfParameterizedType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForGenerifiedErasure extends OfParameterizedType {
                private final TypeDescription typeDescription;

                public ForGenerifiedErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public static Generic of(TypeDescription typeDescription2) {
                    return typeDescription2.isGenerified() ? new ForGenerifiedErasure(typeDescription2) : new OfNonGenericType.ForErasure(typeDescription2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(declaringType);
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.typeDescription.getTypeVariables(), Visitor.AnnotationStripper.INSTANCE);
                }
            }

            public static class ForLoadedType extends OfParameterizedType {
                private final AnnotationReader annotationReader;
                private final ParameterizedType parameterizedType;

                public static class ParameterArgumentTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] argumentType;

                    public ParameterArgumentTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.argumentType = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.argumentType.length;
                    }

                    public Generic get(int i11) {
                        return TypeDefinition.Sort.a(this.argumentType[i11], this.annotationReader.ofTypeArgument(i11));
                    }
                }

                public ForLoadedType(ParameterizedType parameterizedType2) {
                    this(parameterizedType2, AnnotationReader.NoOp.INSTANCE);
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of((Class) this.parameterizedType.getRawType());
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public Generic getOwnerType() {
                    Type ownerType = this.parameterizedType.getOwnerType();
                    if (ownerType == null) {
                        return Generic.UNDEFINED;
                    }
                    return TypeDefinition.Sort.a(ownerType, this.annotationReader.ofOwnerType());
                }

                public TypeList.Generic getTypeArguments() {
                    return new ParameterArgumentTypeList(this.parameterizedType.getActualTypeArguments(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.parameterizedType == type || super.represents(type);
                }

                public ForLoadedType(ParameterizedType parameterizedType2, AnnotationReader annotationReader2) {
                    this.parameterizedType = parameterizedType2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class ForReifiedType extends OfParameterizedType {
                private final Generic parameterizedType;

                public ForReifiedType(Generic generic) {
                    this.parameterizedType = generic;
                }

                public TypeDescription asErasure() {
                    return this.parameterizedType.asErasure();
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, super.getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, super.getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(super.getInterfaces(), Visitor.Reifying.INHERITING);
                }

                public Generic getOwnerType() {
                    Generic ownerType = this.parameterizedType.getOwnerType();
                    if (ownerType == null) {
                        return Generic.UNDEFINED;
                    }
                    return (Generic) ownerType.accept(Visitor.Reifying.INHERITING);
                }

                public Generic getSuperClass() {
                    Generic superClass = super.getSuperClass();
                    if (superClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.parameterizedType.getTypeArguments(), Visitor.TypeErasing.INSTANCE);
                }
            }

            public static class Latent extends OfParameterizedType {
                private final AnnotationSource annotationSource;
                private final Generic ownerType;
                private final List<? extends Generic> parameters;
                private final TypeDescription rawType;

                public Latent(TypeDescription typeDescription, Generic generic, List<? extends Generic> list, AnnotationSource annotationSource2) {
                    this.rawType = typeDescription;
                    this.ownerType = generic;
                    this.parameters = list;
                    this.annotationSource = annotationSource2;
                }

                public TypeDescription asErasure() {
                    return this.rawType;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public Generic getOwnerType() {
                    return this.ownerType;
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.parameters);
                }
            }

            public enum RenderingDelegate {
                FOR_LEGACY_VM {
                    public void a(StringBuilder sb2, TypeDescription typeDescription, Generic generic) {
                        String str;
                        if (generic != null) {
                            sb2.append(generic.getTypeName());
                            sb2.append('.');
                            if (generic.getSort().isParameterized()) {
                                str = typeDescription.getSimpleName();
                            } else {
                                str = typeDescription.getName();
                            }
                            sb2.append(str);
                            return;
                        }
                        sb2.append(typeDescription.getName());
                    }
                },
                FOR_JAVA_8_CAPABLE_VM {
                    public void a(StringBuilder sb2, TypeDescription typeDescription, Generic generic) {
                        if (generic != null) {
                            sb2.append(generic.getTypeName());
                            sb2.append('$');
                            if (generic.getSort().isParameterized()) {
                                String name2 = typeDescription.getName();
                                sb2.append(name2.replace(generic.asErasure().getName() + "$", ""));
                                return;
                            }
                            sb2.append(typeDescription.getSimpleName());
                            return;
                        }
                        sb2.append(typeDescription.getName());
                    }
                };
                

                /* renamed from: b  reason: collision with root package name */
                public static final RenderingDelegate f27126b = null;

                public abstract void a(StringBuilder sb2, TypeDescription typeDescription, Generic generic);
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onParameterizedType(this);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isParameterized()) {
                    return false;
                }
                Generic ownerType = getOwnerType();
                Generic ownerType2 = generic.getOwnerType();
                if (!asErasure().equals(generic.asErasure()) || ((ownerType == null && ownerType2 != null) || ((ownerType != null && !ownerType.equals(ownerType2)) || !getTypeArguments().equals(generic.getTypeArguments())))) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:4:0x001c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.description.type.TypeDescription.Generic findBindingOf(net.bytebuddy.description.type.TypeDescription.Generic r7) {
                /*
                    r6 = this;
                    r0 = r6
                L_0x0001:
                    net.bytebuddy.description.type.TypeList$Generic r1 = r0.getTypeArguments()
                    net.bytebuddy.description.type.TypeDescription r2 = r0.asErasure()
                    net.bytebuddy.description.type.TypeList$Generic r2 = r2.getTypeVariables()
                    r3 = 0
                L_0x000e:
                    int r4 = r1.size()
                    int r5 = r2.size()
                    int r4 = java.lang.Math.min(r4, r5)
                    if (r3 >= r4) goto L_0x0030
                    java.lang.Object r4 = r2.get(r3)
                    boolean r4 = r7.equals(r4)
                    if (r4 == 0) goto L_0x002d
                    java.lang.Object r7 = r1.get(r3)
                    net.bytebuddy.description.type.TypeDescription$Generic r7 = (net.bytebuddy.description.type.TypeDescription.Generic) r7
                    return r7
                L_0x002d:
                    int r3 = r3 + 1
                    goto L_0x000e
                L_0x0030:
                    net.bytebuddy.description.type.TypeDescription$Generic r0 = r0.getOwnerType()
                    if (r0 == 0) goto L_0x0040
                    net.bytebuddy.description.type.TypeDefinition$Sort r1 = r0.getSort()
                    boolean r1 = r1.isParameterized()
                    if (r1 != 0) goto L_0x0001
                L_0x0040:
                    net.bytebuddy.description.type.TypeDescription$Generic r7 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType.findBindingOf(net.bytebuddy.description.type.TypeDescription$Generic):net.bytebuddy.description.type.TypeDescription$Generic");
            }

            public String getActualName() {
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.TypeSubstituting(this, asErasure().getDeclaredFields(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.TypeSubstituting(this, asErasure().getDeclaredMethods(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeList.Generic getInterfaces() {
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(asErasure().getInterfaces(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A parameterized type does not imply lower bounds: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.TypeSubstituting(this, asErasure().getRecordComponents(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.PARAMETERIZED;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            public Generic getSuperClass() {
                Generic superClass = asErasure().getSuperClass();
                if (superClass == null) {
                    return Generic.UNDEFINED;
                }
                return new LazyProjection.WithResolvedErasure(superClass, new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public String getSymbol() {
                throw new IllegalStateException("A parameterized type does not imply a symbol: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A parameterized type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A parameterized type does not imply upper bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i11;
                int i12;
                if (this.hashCode != 0) {
                    i11 = 0;
                } else {
                    int i13 = 1;
                    for (Generic hashCode2 : getTypeArguments()) {
                        i13 = (i13 * 31) + hashCode2.hashCode();
                    }
                    Generic ownerType = getOwnerType();
                    if (ownerType == null) {
                        i12 = asErasure().hashCode();
                    } else {
                        i12 = ownerType.hashCode();
                    }
                    i11 = i12 ^ i13;
                }
                if (i11 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i11;
                return i11;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                RenderingDelegate.f27126b.a(sb2, asErasure(), getOwnerType());
                TypeList.Generic<Generic> typeArguments = getTypeArguments();
                if (!typeArguments.isEmpty()) {
                    sb2.append(Typography.less);
                    boolean z11 = false;
                    for (Generic generic : typeArguments) {
                        if (z11) {
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                        }
                        sb2.append(generic.getTypeName());
                        z11 = true;
                    }
                    sb2.append(Typography.greater);
                }
                return sb2.toString();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A parameterized type does not imply a component type: " + this);
            }
        }

        public static abstract class OfTypeVariable extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfTypeVariable {
                private final AnnotationReader annotationReader;
                private final TypeVariable<?> typeVariable;

                public static class TypeVariableBoundList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] bound;

                    public TypeVariableBoundList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.bound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.bound.length;
                    }

                    public Generic get(int i11) {
                        return TypeDefinition.Sort.a(this.bound[i11], this.annotationReader.ofTypeVariableBoundType(i11));
                    }
                }

                public ForLoadedType(TypeVariable<?> typeVariable2) {
                    this(typeVariable2, AnnotationReader.NoOp.INSTANCE);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public String getSymbol() {
                    return this.typeVariable.getName();
                }

                public TypeVariableSource getTypeVariableSource() {
                    Object genericDeclaration = this.typeVariable.getGenericDeclaration();
                    if (genericDeclaration instanceof Class) {
                        return ForLoadedType.of((Class) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Method) {
                        return new MethodDescription.ForLoadedMethod((Method) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Constructor) {
                        return new MethodDescription.ForLoadedConstructor((Constructor) genericDeclaration);
                    }
                    throw new IllegalStateException("Unknown declaration: " + genericDeclaration);
                }

                public TypeList.Generic getUpperBounds() {
                    return new TypeVariableBoundList(this.typeVariable.getBounds(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.typeVariable == type || super.represents(type);
                }

                public ForLoadedType(TypeVariable<?> typeVariable2, AnnotationReader annotationReader2) {
                    this.typeVariable = typeVariable2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class Symbolic extends AbstractBase {
                private final AnnotationSource annotationSource;
                private final String symbol;

                public Symbolic(String str, AnnotationSource annotationSource2) {
                    this.symbol = str;
                    this.annotationSource = annotationSource2;
                }

                public <T> T accept(Visitor<T> visitor) {
                    return visitor.onTypeVariable(this);
                }

                public TypeDescription asErasure() {
                    throw new IllegalStateException("A symbolic type variable does not imply an erasure: " + this);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Generic)) {
                        return false;
                    }
                    Generic generic = (Generic) obj;
                    if (!generic.getSort().isTypeVariable() || !getSymbol().equals(generic.getSymbol())) {
                        return false;
                    }
                    return true;
                }

                public Generic findBindingOf(Generic generic) {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                public String getActualName() {
                    return getSymbol();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    throw new IllegalStateException("A symbolic type variable does not imply field definitions: " + this);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    throw new IllegalStateException("A symbolic type variable does not imply method definitions: " + this);
                }

                public TypeList.Generic getInterfaces() {
                    throw new IllegalStateException("A symbolic type variable does not imply an interface type definition: " + this);
                }

                public TypeList.Generic getLowerBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply lower bounds: " + this);
                }

                public Generic getOwnerType() {
                    throw new IllegalStateException("A symbolic type variable does not imply an owner type: " + this);
                }

                public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                    throw new IllegalStateException("A symbolic type variable does not imply record component definitions: " + this);
                }

                public TypeDefinition.Sort getSort() {
                    return TypeDefinition.Sort.VARIABLE_SYMBOLIC;
                }

                public StackSize getStackSize() {
                    return StackSize.SINGLE;
                }

                public Generic getSuperClass() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                public String getSymbol() {
                    return this.symbol;
                }

                public TypeList.Generic getTypeArguments() {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                public String getTypeName() {
                    return toString();
                }

                public TypeVariableSource getTypeVariableSource() {
                    throw new IllegalStateException("A symbolic type variable does not imply a variable source: " + this);
                }

                public TypeList.Generic getUpperBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply an upper type bound: " + this);
                }

                public int hashCode() {
                    return this.symbol.hashCode();
                }

                public boolean isArray() {
                    return false;
                }

                public boolean isPrimitive() {
                    return false;
                }

                public boolean isRecord() {
                    return false;
                }

                public Iterator<TypeDefinition> iterator() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                public boolean represents(Type type) {
                    type.getClass();
                    return false;
                }

                public String toString() {
                    return getSymbol();
                }

                public Generic getComponentType() {
                    throw new IllegalStateException("A symbolic type variable does not imply a component type: " + this);
                }
            }

            public static class WithAnnotationOverlay extends OfTypeVariable {
                private final AnnotationSource annotationSource;
                private final Generic typeVariable;

                public WithAnnotationOverlay(Generic generic, AnnotationSource annotationSource2) {
                    this.typeVariable = generic;
                    this.annotationSource = annotationSource2;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public String getSymbol() {
                    return this.typeVariable.getSymbol();
                }

                public TypeVariableSource getTypeVariableSource() {
                    return this.typeVariable.getTypeVariableSource();
                }

                public TypeList.Generic getUpperBounds() {
                    return this.typeVariable.getUpperBounds();
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onTypeVariable(this);
            }

            public TypeDescription asErasure() {
                TypeList.Generic upperBounds = getUpperBounds();
                if (upperBounds.isEmpty()) {
                    return TypeDescription.OBJECT;
                }
                return ((Generic) upperBounds.get(0)).asErasure();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isTypeVariable() || !getSymbol().equals(generic.getSymbol()) || !getTypeVariableSource().equals(generic.getTypeVariableSource())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            public String getActualName() {
                return getSymbol();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A type variable does not imply field definitions: " + this);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A type variable does not imply method definitions: " + this);
            }

            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A type variable does not imply an interface type definition: " + this);
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A type variable does not imply lower bounds: " + this);
            }

            public Generic getOwnerType() {
                throw new IllegalStateException("A type variable does not imply an owner type: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A type variable does not imply record component definitions: " + this);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.VARIABLE;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            public Generic getSuperClass() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : getTypeVariableSource().hashCode() ^ getSymbol().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                return getSymbol();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A type variable does not imply a component type: " + this);
            }
        }

        public static abstract class OfWildcardType extends AbstractBase {
            public static final String SYMBOL = "?";
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfWildcardType {
                private final AnnotationReader annotationReader;
                private final WildcardType wildcardType;

                public static class WildcardLowerBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] lowerBound;

                    public WildcardLowerBoundTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.lowerBound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.lowerBound.length;
                    }

                    public Generic get(int i11) {
                        return TypeDefinition.Sort.a(this.lowerBound[i11], this.annotationReader.ofWildcardLowerBoundType(i11));
                    }
                }

                public static class WildcardUpperBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] upperBound;

                    public WildcardUpperBoundTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.upperBound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.upperBound.length;
                    }

                    public Generic get(int i11) {
                        return TypeDefinition.Sort.a(this.upperBound[i11], this.annotationReader.ofWildcardUpperBoundType(i11));
                    }
                }

                public ForLoadedType(WildcardType wildcardType2) {
                    this(wildcardType2, AnnotationReader.NoOp.INSTANCE);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public TypeList.Generic getLowerBounds() {
                    return new WildcardLowerBoundTypeList(this.wildcardType.getLowerBounds(), this.annotationReader);
                }

                public TypeList.Generic getUpperBounds() {
                    return new WildcardUpperBoundTypeList(this.wildcardType.getUpperBounds(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.wildcardType == type || super.represents(type);
                }

                public ForLoadedType(WildcardType wildcardType2, AnnotationReader annotationReader2) {
                    this.wildcardType = wildcardType2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class Latent extends OfWildcardType {
                private final AnnotationSource annotationSource;
                private final List<? extends Generic> lowerBounds;
                private final List<? extends Generic> upperBounds;

                public Latent(List<? extends Generic> list, List<? extends Generic> list2, AnnotationSource annotationSource2) {
                    this.upperBounds = list;
                    this.lowerBounds = list2;
                    this.annotationSource = annotationSource2;
                }

                public static Generic boundedAbove(Generic generic, AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(generic), Collections.emptyList(), annotationSource2);
                }

                public static Generic boundedBelow(Generic generic, AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(Generic.OBJECT), Collections.singletonList(generic), annotationSource2);
                }

                public static Generic unbounded(AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(Generic.OBJECT), Collections.emptyList(), annotationSource2);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public TypeList.Generic getLowerBounds() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.lowerBounds);
                }

                public TypeList.Generic getUpperBounds() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.upperBounds);
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onWildcard(this);
            }

            public TypeDescription asErasure() {
                throw new IllegalStateException("A wildcard does not represent an erasable type: " + this);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isWildcard() || !getUpperBounds().equals(generic.getUpperBounds()) || !getLowerBounds().equals(generic.getLowerBounds())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            public String getActualName() {
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A wildcard does not imply field definitions: " + this);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A wildcard does not imply method definitions: " + this);
            }

            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A wildcard does not imply an interface type definition: " + this);
            }

            public Generic getOwnerType() {
                throw new IllegalStateException("A wildcard does not imply an owner type: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A wildcard does not imply record component definitions: " + this);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.WILDCARD;
            }

            public StackSize getStackSize() {
                throw new IllegalStateException("A wildcard does not imply an operand stack size: " + this);
            }

            public Generic getSuperClass() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            public String getSymbol() {
                throw new IllegalStateException("A wildcard does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A wildcard does not imply a type variable source: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i11;
                if (this.hashCode != 0) {
                    i11 = 0;
                } else {
                    int i12 = 1;
                    int i13 = 1;
                    for (Generic hashCode2 : getLowerBounds()) {
                        i13 = (i13 * 31) + hashCode2.hashCode();
                    }
                    for (Generic hashCode3 : getUpperBounds()) {
                        i12 = (i12 * 31) + hashCode3.hashCode();
                    }
                    i11 = i13 ^ i12;
                }
                if (i11 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i11;
                return i11;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder(SYMBOL);
                TypeList.Generic lowerBounds = getLowerBounds();
                if (!lowerBounds.isEmpty()) {
                    sb2.append(" super ");
                } else {
                    lowerBounds = getUpperBounds();
                    if (((Generic) lowerBounds.getOnly()).equals(Generic.OBJECT)) {
                        return SYMBOL;
                    }
                    sb2.append(" extends ");
                }
                sb2.append(((Generic) lowerBounds.getOnly()).getTypeName());
                return sb2.toString();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A wildcard does not imply a component type: " + this);
            }
        }

        public interface Visitor<T> {

            public enum AnnotationStripper implements Visitor<Generic> {
                INSTANCE;

                public static class NonAnnotatedTypeVariable extends OfTypeVariable {
                    private final Generic typeVariable;

                    public NonAnnotatedTypeVariable(Generic generic) {
                        this.typeVariable = generic;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    public String getSymbol() {
                        return this.typeVariable.getSymbol();
                    }

                    public TypeVariableSource getTypeVariableSource() {
                        return this.typeVariable.getTypeVariableSource();
                    }

                    public TypeList.Generic getUpperBounds() {
                        return this.typeVariable.getUpperBounds();
                    }
                }

                public Generic onGenericArray(Generic generic) {
                    return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                public Generic onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return new OfGenericArray.Latent(onNonGenericType(generic.getComponentType()), AnnotationSource.Empty.INSTANCE);
                    }
                    return new OfNonGenericType.Latent(generic.asErasure(), AnnotationSource.Empty.INSTANCE);
                }

                public Generic onParameterizedType(Generic generic) {
                    Generic generic2;
                    Generic ownerType = generic.getOwnerType();
                    TypeDescription asErasure = generic.asErasure();
                    if (ownerType == null) {
                        generic2 = Generic.UNDEFINED;
                    } else {
                        generic2 = (Generic) ownerType.accept(this);
                    }
                    return new OfParameterizedType.Latent(asErasure, generic2, generic.getTypeArguments().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                public Generic onTypeVariable(Generic generic) {
                    return new NonAnnotatedTypeVariable(generic);
                }

                public Generic onWildcard(Generic generic) {
                    return new OfWildcardType.Latent(generic.getUpperBounds().accept(this), generic.getLowerBounds().accept(this), AnnotationSource.Empty.INSTANCE);
                }
            }

            public enum Assigner implements Visitor<Dispatcher> {
                INSTANCE;

                public interface Dispatcher {

                    public static abstract class AbstractBase implements Dispatcher, Visitor<Boolean> {
                        public boolean isAssignableFrom(Generic generic) {
                            return ((Boolean) generic.accept(this)).booleanValue();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForGenericArray extends AbstractBase {
                        private final Generic genericArray;

                        public ForGenericArray(Generic generic) {
                            this.genericArray = generic;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.genericArray.equals(((ForGenericArray) obj).genericArray);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.genericArray.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.valueOf(((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(generic.getComponentType()));
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.valueOf(generic.isArray() && ((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(generic.getComponentType()));
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForNonGenericType extends AbstractBase {
                        private final TypeDescription typeDescription;

                        public ForNonGenericType(TypeDescription typeDescription2) {
                            this.typeDescription = typeDescription2;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForNonGenericType) obj).typeDescription);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            boolean z11;
                            if (this.typeDescription.isArray()) {
                                z11 = ((Boolean) generic.getComponentType().accept(new ForNonGenericType(this.typeDescription.getComponentType()))).booleanValue();
                            } else {
                                z11 = this.typeDescription.represents(Object.class) || TypeDescription.ARRAY_INTERFACES.contains(this.typeDescription.asGenericType());
                            }
                            return Boolean.valueOf(z11);
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.valueOf(this.typeDescription.isAssignableFrom(generic.asErasure()));
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            if (this.typeDescription.equals(generic.asErasure())) {
                                return Boolean.TRUE;
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.valueOf(this.typeDescription.represents(Object.class));
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForParameterizedType extends AbstractBase {
                        private final Generic parameterizedType;

                        public enum ParameterAssigner implements Visitor<Dispatcher> {
                            INSTANCE;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class ContravariantBinding implements Dispatcher {
                                private final Generic lowerBound;

                                public ContravariantBinding(Generic generic) {
                                    this.lowerBound = generic;
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.lowerBound.equals(((ContravariantBinding) obj).lowerBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.lowerBound.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    if (generic.getSort().isWildcard()) {
                                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                                        if (lowerBounds.isEmpty() || !((Dispatcher) ((Generic) lowerBounds.getOnly()).accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) {
                                            return false;
                                        }
                                        return true;
                                    } else if (generic.getSort().isWildcard() || ((Dispatcher) generic.accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class CovariantBinding implements Dispatcher {
                                private final Generic upperBound;

                                public CovariantBinding(Generic generic) {
                                    this.upperBound = generic;
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.upperBound.equals(((CovariantBinding) obj).upperBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.upperBound.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    if (!generic.getSort().isWildcard()) {
                                        return ((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom(generic);
                                    }
                                    if (!generic.getLowerBounds().isEmpty() || !((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom((Generic) generic.getUpperBounds().getOnly())) {
                                        return false;
                                    }
                                    return true;
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class InvariantBinding implements Dispatcher {
                                private final Generic typeDescription;

                                public InvariantBinding(Generic generic) {
                                    this.typeDescription = generic;
                                }

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((InvariantBinding) obj).typeDescription);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    return generic.equals(this.typeDescription);
                                }
                            }

                            public Dispatcher onGenericArray(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onNonGenericType(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onParameterizedType(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onTypeVariable(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onWildcard(Generic generic) {
                                TypeList.Generic lowerBounds = generic.getLowerBounds();
                                if (lowerBounds.isEmpty()) {
                                    return new CovariantBinding((Generic) generic.getUpperBounds().getOnly());
                                }
                                return new ContravariantBinding((Generic) lowerBounds.getOnly());
                            }
                        }

                        public ForParameterizedType(Generic generic) {
                            this.parameterizedType = generic;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForParameterizedType) obj).parameterizedType);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            if (this.parameterizedType.asErasure().equals(generic.asErasure())) {
                                return Boolean.TRUE;
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            if (this.parameterizedType.asErasure().equals(generic.asErasure())) {
                                Generic ownerType = this.parameterizedType.getOwnerType();
                                Generic ownerType2 = generic.getOwnerType();
                                if (ownerType != null && ownerType2 != null && !((Dispatcher) ownerType.accept(Assigner.INSTANCE)).isAssignableFrom(ownerType2)) {
                                    return Boolean.FALSE;
                                }
                                TypeList.Generic typeArguments = this.parameterizedType.getTypeArguments();
                                TypeList.Generic typeArguments2 = generic.getTypeArguments();
                                if (typeArguments.size() == typeArguments2.size()) {
                                    for (int i11 = 0; i11 < typeArguments.size(); i11++) {
                                        if (!((Dispatcher) ((Generic) typeArguments.get(i11)).accept(ParameterAssigner.INSTANCE)).isAssignableFrom((Generic) typeArguments2.get(i11))) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.TRUE;
                                }
                                throw new IllegalArgumentException("Incompatible generic types: " + generic + " and " + this.parameterizedType);
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForTypeVariable extends AbstractBase {
                        private final Generic typeVariable;

                        public ForTypeVariable(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForTypeVariable) obj).typeVariable);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            if (generic.equals(this.typeVariable)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    boolean isAssignableFrom(Generic generic);
                }

                public Dispatcher onGenericArray(Generic generic) {
                    return new Dispatcher.ForGenericArray(generic);
                }

                public Dispatcher onNonGenericType(Generic generic) {
                    return new Dispatcher.ForNonGenericType(generic.asErasure());
                }

                public Dispatcher onParameterizedType(Generic generic) {
                    return new Dispatcher.ForParameterizedType(generic);
                }

                public Dispatcher onTypeVariable(Generic generic) {
                    return new Dispatcher.ForTypeVariable(generic);
                }

                public Dispatcher onWildcard(Generic generic) {
                    throw new IllegalArgumentException("A wildcard is not a first level type: " + this);
                }
            }

            public static class ForRawType implements Visitor<Generic> {
                private final TypeDescription declaringType;

                public ForRawType(TypeDescription typeDescription) {
                    this.declaringType = typeDescription;
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic;
                }

                public Generic onGenericArray(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onParameterizedType(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalStateException("Did not expect wildcard on top-level: " + generic);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForSignatureVisitor implements Visitor<SignatureVisitor> {
                private static final int ONLY_CHARACTER = 0;

                /* renamed from: b  reason: collision with root package name */
                public final SignatureVisitor f27127b;

                public static class OfTypeArgument extends ForSignatureVisitor {
                    public OfTypeArgument(SignatureVisitor signatureVisitor) {
                        super(signatureVisitor);
                    }

                    public SignatureVisitor onGenericArray(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.f27127b;
                    }

                    public SignatureVisitor onNonGenericType(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.f27127b;
                    }

                    public SignatureVisitor onParameterizedType(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.f27127b;
                    }

                    public SignatureVisitor onTypeVariable(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.f27127b;
                    }

                    public SignatureVisitor onWildcard(Generic generic) {
                        TypeList.Generic upperBounds = generic.getUpperBounds();
                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                        if (lowerBounds.isEmpty() && ((Generic) upperBounds.getOnly()).represents(Object.class)) {
                            this.f27127b.visitTypeArgument();
                        } else if (!lowerBounds.isEmpty()) {
                            ((Generic) lowerBounds.getOnly()).accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.SUPER)));
                        } else {
                            ((Generic) upperBounds.getOnly()).accept(new ForSignatureVisitor(this.f27127b.visitTypeArgument(SignatureVisitor.EXTENDS)));
                        }
                        return this.f27127b;
                    }
                }

                public ForSignatureVisitor(SignatureVisitor signatureVisitor) {
                    this.f27127b = signatureVisitor;
                }

                private void onOwnableType(Generic generic) {
                    Generic ownerType = generic.getOwnerType();
                    if (ownerType == null || !ownerType.getSort().isParameterized()) {
                        this.f27127b.visitClassType(generic.asErasure().getInternalName());
                    } else {
                        onOwnableType(ownerType);
                        this.f27127b.visitInnerClassType(generic.asErasure().getSimpleName());
                    }
                    for (Generic accept : generic.getTypeArguments()) {
                        accept.accept(new OfTypeArgument(this.f27127b));
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.f27127b.equals(((ForSignatureVisitor) obj).f27127b);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.f27127b.hashCode();
                }

                public SignatureVisitor onGenericArray(Generic generic) {
                    generic.getComponentType().accept(new ForSignatureVisitor(this.f27127b.visitArrayType()));
                    return this.f27127b;
                }

                public SignatureVisitor onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        generic.getComponentType().accept(new ForSignatureVisitor(this.f27127b.visitArrayType()));
                    } else if (generic.isPrimitive()) {
                        this.f27127b.visitBaseType(generic.asErasure().getDescriptor().charAt(0));
                    } else {
                        this.f27127b.visitClassType(generic.asErasure().getInternalName());
                        this.f27127b.visitEnd();
                    }
                    return this.f27127b;
                }

                public SignatureVisitor onParameterizedType(Generic generic) {
                    onOwnableType(generic);
                    this.f27127b.visitEnd();
                    return this.f27127b;
                }

                public SignatureVisitor onTypeVariable(Generic generic) {
                    this.f27127b.visitTypeVariable(generic.getSymbol());
                    return this.f27127b;
                }

                public SignatureVisitor onWildcard(Generic generic) {
                    throw new IllegalStateException("Unexpected wildcard: " + generic);
                }
            }

            public enum NoOp implements Visitor<Generic> {
                INSTANCE;

                public Generic onGenericArray(Generic generic) {
                    return generic;
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic;
                }

                public Generic onParameterizedType(Generic generic) {
                    return generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    return generic;
                }

                public Generic onWildcard(Generic generic) {
                    return generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Reducing implements Visitor<TypeDescription> {
                private final TypeDescription declaringType;
                private final List<? extends TypeVariableToken> typeVariableTokens;

                public Reducing(TypeDescription typeDescription, TypeVariableToken... typeVariableTokenArr) {
                    this(typeDescription, (List<? extends TypeVariableToken>) Arrays.asList(typeVariableTokenArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Reducing reducing = (Reducing) obj;
                    return this.declaringType.equals(reducing.declaringType) && this.typeVariableTokens.equals(reducing.typeVariableTokens);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                }

                public Reducing(TypeDescription typeDescription, List<? extends TypeVariableToken> list) {
                    this.declaringType = typeDescription;
                    this.typeVariableTokens = list;
                }

                public TypeDescription onGenericArray(Generic generic) {
                    Generic generic2 = generic;
                    int i11 = 0;
                    do {
                        generic2 = generic2.getComponentType();
                        i11++;
                    } while (generic2.isArray());
                    if (!generic2.getSort().isTypeVariable()) {
                        return TargetType.resolve(generic.asErasure(), this.declaringType);
                    }
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (generic2.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return ArrayProjection.of((TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this), i11);
                        }
                    }
                    return TargetType.resolve(ArrayProjection.of(this.declaringType.findVariable(generic2.getSymbol()).asErasure(), i11), this.declaringType);
                }

                public TypeDescription onNonGenericType(Generic generic) {
                    return TargetType.resolve(generic.asErasure(), this.declaringType);
                }

                public TypeDescription onParameterizedType(Generic generic) {
                    return TargetType.resolve(generic.asErasure(), this.declaringType);
                }

                public TypeDescription onTypeVariable(Generic generic) {
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (generic.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return (TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this);
                        }
                    }
                    return TargetType.resolve(this.declaringType.findVariable(generic.getSymbol()).asErasure(), this.declaringType);
                }

                public TypeDescription onWildcard(Generic generic) {
                    throw new IllegalStateException("A wildcard cannot be a top-level type: " + generic);
                }
            }

            public enum Reifying implements Visitor<Generic> {
                INITIATING {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public Generic onParameterizedType(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }
                },
                INHERITING {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onParameterizedType(Generic generic) {
                        return new OfParameterizedType.ForReifiedType(generic);
                    }
                };

                public Generic onGenericArray(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a generic array: " + generic);
                }

                public Generic onNonGenericType(Generic generic) {
                    TypeDescription asErasure = generic.asErasure();
                    return asErasure.isGenerified() ? new OfNonGenericType.ForReifiedErasure(asErasure) : generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a type variable: " + generic);
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a wildcard: " + generic);
                }
            }

            public static abstract class Substitutor implements Visitor<Generic> {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForAttachment extends Substitutor {
                    private final TypeDescription declaringType;
                    private final TypeVariableSource typeVariableSource;

                    public ForAttachment(TypeDefinition typeDefinition, TypeVariableSource typeVariableSource2) {
                        this(typeDefinition.asErasure(), typeVariableSource2);
                    }

                    public static ForAttachment of(TypeDescription typeDescription) {
                        return new ForAttachment(typeDescription, (TypeVariableSource) typeDescription);
                    }

                    public Generic a(Generic generic) {
                        return generic.represents(TargetType.class) ? new OfNonGenericType.Latent(this.declaringType, generic) : generic;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForAttachment forAttachment = (ForAttachment) obj;
                        return this.declaringType.equals(forAttachment.declaringType) && this.typeVariableSource.equals(forAttachment.typeVariableSource);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableSource.hashCode();
                    }

                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public ForAttachment(TypeDescription typeDescription, TypeVariableSource typeVariableSource2) {
                        this.declaringType = typeDescription;
                        this.typeVariableSource = typeVariableSource2;
                    }

                    public static ForAttachment of(FieldDescription fieldDescription) {
                        return new ForAttachment(fieldDescription.getDeclaringType(), (TypeVariableSource) fieldDescription.getDeclaringType().asErasure());
                    }

                    public Generic onTypeVariable(Generic generic) {
                        Generic findVariable = this.typeVariableSource.findVariable(generic.getSymbol());
                        if (findVariable != null) {
                            return new OfTypeVariable.WithAnnotationOverlay(findVariable, generic);
                        }
                        throw new IllegalArgumentException("Cannot attach undefined variable: " + generic);
                    }

                    public static ForAttachment of(MethodDescription methodDescription) {
                        return new ForAttachment(methodDescription.getDeclaringType(), (TypeVariableSource) methodDescription);
                    }

                    public static ForAttachment of(ParameterDescription parameterDescription) {
                        return new ForAttachment(parameterDescription.getDeclaringMethod().getDeclaringType(), (TypeVariableSource) parameterDescription.getDeclaringMethod());
                    }

                    public static ForAttachment of(RecordComponentDescription recordComponentDescription) {
                        return new ForAttachment(recordComponentDescription.getDeclaringType(), (TypeVariableSource) recordComponentDescription.getDeclaringType().asErasure());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForDetachment extends Substitutor {
                    private final ElementMatcher<? super TypeDescription> typeMatcher;

                    public ForDetachment(ElementMatcher<? super TypeDescription> elementMatcher) {
                        this.typeMatcher = elementMatcher;
                    }

                    public static Visitor<Generic> of(TypeDefinition typeDefinition) {
                        return new ForDetachment(ElementMatchers.is((Object) typeDefinition));
                    }

                    public Generic a(Generic generic) {
                        if (this.typeMatcher.matches(generic.asErasure())) {
                            return new OfNonGenericType.Latent(TargetType.DESCRIPTION, generic.getOwnerType(), (AnnotationSource) generic);
                        }
                        return generic;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeMatcher.equals(((ForDetachment) obj).typeMatcher);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeMatcher.hashCode();
                    }

                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return new OfTypeVariable.Symbolic(generic.getSymbol(), generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTokenNormalization extends Substitutor {
                    private final TypeDescription typeDescription;

                    public ForTokenNormalization(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public Generic a(Generic generic) {
                        return generic.represents(TargetType.class) ? new OfNonGenericType.Latent(this.typeDescription, generic) : generic;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForTokenNormalization) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                    }

                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return new OfTypeVariable.Symbolic(generic.getSymbol(), generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTypeVariableBinding extends WithoutTypeSubstitution {
                    /* access modifiers changed from: private */
                    public final Generic parameterizedType;

                    public class RetainedMethodTypeVariable extends OfTypeVariable {
                        private final Generic typeVariable;

                        public RetainedMethodTypeVariable(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return this.typeVariable.getDeclaredAnnotations();
                        }

                        public String getSymbol() {
                            return this.typeVariable.getSymbol();
                        }

                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariable.getTypeVariableSource();
                        }

                        public TypeList.Generic getUpperBounds() {
                            return this.typeVariable.getUpperBounds().accept(ForTypeVariableBinding.this);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class TypeVariableSubstitutor implements TypeVariableSource.Visitor<Generic> {
                        private final Generic typeVariable;

                        public TypeVariableSubstitutor(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeVariableSubstitutor typeVariableSubstitutor = (TypeVariableSubstitutor) obj;
                            return this.typeVariable.equals(typeVariableSubstitutor.typeVariable) && ForTypeVariableBinding.this.equals(ForTypeVariableBinding.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + ForTypeVariableBinding.this.hashCode();
                        }

                        public Generic onMethod(MethodDescription.InDefinedShape inDefinedShape) {
                            return new RetainedMethodTypeVariable(this.typeVariable);
                        }

                        public Generic onType(TypeDescription typeDescription) {
                            Generic findBindingOf = ForTypeVariableBinding.this.parameterizedType.findBindingOf(this.typeVariable);
                            return findBindingOf == null ? this.typeVariable.asRawType() : findBindingOf;
                        }
                    }

                    public ForTypeVariableBinding(Generic generic) {
                        this.parameterizedType = generic;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForTypeVariableBinding) obj).parameterizedType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return (Generic) generic.getTypeVariableSource().accept(new TypeVariableSubstitutor(generic));
                    }
                }

                public static abstract class WithoutTypeSubstitution extends Substitutor {
                    public Generic a(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public Generic onNonGenericType(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }
                }

                public abstract Generic a(Generic generic);

                public Generic onGenericArray(Generic generic) {
                    return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), generic);
                }

                public Generic onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), generic);
                    }
                    return a(generic);
                }

                public Generic onParameterizedType(Generic generic) {
                    Generic generic2;
                    Generic ownerType = generic.getOwnerType();
                    ArrayList arrayList = new ArrayList(generic.getTypeArguments().size());
                    for (Generic accept : generic.getTypeArguments()) {
                        arrayList.add(accept.accept(this));
                    }
                    TypeDescription asErasure = ((Generic) generic.asRawType().accept(this)).asErasure();
                    if (ownerType == null) {
                        generic2 = Generic.UNDEFINED;
                    } else {
                        generic2 = (Generic) ownerType.accept(this);
                    }
                    return new OfParameterizedType.Latent(asErasure, generic2, arrayList, generic);
                }

                public Generic onWildcard(Generic generic) {
                    return new OfWildcardType.Latent(generic.getUpperBounds().accept(this), generic.getLowerBounds().accept(this), generic);
                }
            }

            public enum TypeErasing implements Visitor<Generic> {
                INSTANCE;

                public Generic onGenericArray(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onParameterizedType(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onTypeVariable(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot erase a wildcard type: " + generic);
                }
            }

            public enum Validator implements Visitor<Boolean> {
                SUPER_CLASS(false, false, false, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(super.onNonGenericType(generic).booleanValue() && !generic.isInterface());
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.valueOf(!generic.isInterface());
                    }
                },
                INTERFACE(false, false, false, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(super.onNonGenericType(generic).booleanValue() && generic.isInterface());
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.valueOf(generic.isInterface());
                    }
                },
                TYPE_VARIABLE(false, false, true, false),
                FIELD(true, true, true, false),
                METHOD_RETURN(true, true, true, true),
                METHOD_PARAMETER(true, true, true, false),
                EXCEPTION(false, false, true, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(generic.asErasure().isAssignableTo((Class<?>) Throwable.class));
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.FALSE;
                    }

                    public Boolean onTypeVariable(Generic generic) {
                        for (Generic accept : generic.getUpperBounds()) {
                            if (((Boolean) accept.accept(this)).booleanValue()) {
                                return Boolean.TRUE;
                            }
                        }
                        return Boolean.FALSE;
                    }
                },
                RECEIVER(false, false, false, false);
                
                private final boolean acceptsArray;
                private final boolean acceptsPrimitive;
                private final boolean acceptsVariable;
                private final boolean acceptsVoid;

                public enum ForTypeAnnotations implements Visitor<Boolean> {
                    INSTANCE;
                    
                    private final ElementType typeParameter;
                    private final ElementType typeUse;

                    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private boolean isValid(net.bytebuddy.description.type.TypeDescription.Generic r5) {
                        /*
                            r4 = this;
                            java.util.HashSet r0 = new java.util.HashSet
                            r0.<init>()
                            net.bytebuddy.description.annotation.AnnotationList r5 = r5.getDeclaredAnnotations()
                            java.util.Iterator r5 = r5.iterator()
                        L_0x000d:
                            boolean r1 = r5.hasNext()
                            if (r1 == 0) goto L_0x0031
                            java.lang.Object r1 = r5.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r1 = (net.bytebuddy.description.annotation.AnnotationDescription) r1
                            java.util.Set r2 = r1.getElementTypes()
                            java.lang.annotation.ElementType r3 = r4.typeUse
                            boolean r2 = r2.contains(r3)
                            if (r2 == 0) goto L_0x002f
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r1 = r0.add(r1)
                            if (r1 != 0) goto L_0x000d
                        L_0x002f:
                            r5 = 0
                            return r5
                        L_0x0031:
                            r5 = 1
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.isValid(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public static boolean ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription.Generic r4) {
                        /*
                            java.util.HashSet r0 = new java.util.HashSet
                            r0.<init>()
                            net.bytebuddy.description.annotation.AnnotationList r4 = r4.getDeclaredAnnotations()
                            java.util.Iterator r4 = r4.iterator()
                        L_0x000d:
                            boolean r1 = r4.hasNext()
                            if (r1 == 0) goto L_0x0033
                            java.lang.Object r1 = r4.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r1 = (net.bytebuddy.description.annotation.AnnotationDescription) r1
                            java.util.Set r2 = r1.getElementTypes()
                            net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r3 = INSTANCE
                            java.lang.annotation.ElementType r3 = r3.typeParameter
                            boolean r2 = r2.contains(r3)
                            if (r2 == 0) goto L_0x0031
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r1 = r0.add(r1)
                            if (r1 != 0) goto L_0x000d
                        L_0x0031:
                            r4 = 0
                            return r4
                        L_0x0033:
                            r4 = 1
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }

                    public Boolean onGenericArray(Generic generic) {
                        return Boolean.valueOf(isValid(generic) && ((Boolean) generic.getComponentType().accept(this)).booleanValue());
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(isValid(generic) && (!generic.isArray() || ((Boolean) generic.getComponentType().accept(this)).booleanValue()));
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        if (!isValid(generic)) {
                            return Boolean.FALSE;
                        }
                        Generic ownerType = generic.getOwnerType();
                        if (ownerType != null && !((Boolean) ownerType.accept(this)).booleanValue()) {
                            return Boolean.FALSE;
                        }
                        for (Generic accept : generic.getTypeArguments()) {
                            if (!((Boolean) accept.accept(this)).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        return Boolean.TRUE;
                    }

                    public Boolean onTypeVariable(Generic generic) {
                        return Boolean.valueOf(isValid(generic));
                    }

                    public Boolean onWildcard(Generic generic) {
                        if (!isValid(generic)) {
                            return Boolean.FALSE;
                        }
                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                        if (lowerBounds.isEmpty()) {
                            lowerBounds = generic.getUpperBounds();
                        }
                        return (Boolean) ((Generic) lowerBounds.getOnly()).accept(this);
                    }
                }

                private Validator(boolean z11, boolean z12, boolean z13, boolean z14) {
                    this.acceptsArray = z11;
                    this.acceptsPrimitive = z12;
                    this.acceptsVariable = z13;
                    this.acceptsVoid = z14;
                }

                public Boolean onGenericArray(Generic generic) {
                    return Boolean.valueOf(this.acceptsArray);
                }

                public Boolean onNonGenericType(Generic generic) {
                    return Boolean.valueOf((this.acceptsArray || !generic.isArray()) && (this.acceptsPrimitive || !generic.isPrimitive()) && (this.acceptsVoid || !generic.represents(Void.TYPE)));
                }

                public Boolean onParameterizedType(Generic generic) {
                    return Boolean.TRUE;
                }

                public Boolean onTypeVariable(Generic generic) {
                    return Boolean.valueOf(this.acceptsVariable);
                }

                public Boolean onWildcard(Generic generic) {
                    return Boolean.FALSE;
                }
            }

            T onGenericArray(Generic generic);

            T onNonGenericType(Generic generic);

            T onParameterizedType(Generic generic);

            T onTypeVariable(Generic generic);

            T onWildcard(Generic generic);
        }

        <T> T accept(Visitor<T> visitor);

        Generic asRawType();

        Generic findBindingOf(Generic generic);

        Generic getComponentType();

        FieldList<FieldDescription.InGenericShape> getDeclaredFields();

        MethodList<MethodDescription.InGenericShape> getDeclaredMethods();

        TypeList.Generic getLowerBounds();

        Generic getOwnerType();

        RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents();

        String getSymbol();

        TypeList.Generic getTypeArguments();

        TypeVariableSource getTypeVariableSource();

        TypeList.Generic getUpperBounds();
    }

    public static class Latent extends AbstractBase.OfSimpleType {
        private final List<? extends Generic> interfaces;
        private final int modifiers;

        /* renamed from: name  reason: collision with root package name */
        private final String f27130name;
        private final Generic superClass;

        public Latent(String str, int i11, Generic generic, Generic... genericArr) {
            this(str, i11, generic, (List<? extends Generic>) Arrays.asList(genericArr));
        }

        public AnnotationList getDeclaredAnnotations() {
            throw new IllegalStateException("Cannot resolve declared annotations of a latent type description: " + this);
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            throw new IllegalStateException("Cannot resolve declared fields of a latent type description: " + this);
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            throw new IllegalStateException("Cannot resolve declared methods of a latent type description: " + this);
        }

        public TypeList getDeclaredTypes() {
            throw new IllegalStateException("Cannot resolve inner types of a latent type description: " + this);
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            throw new IllegalStateException("Cannot resolve enclosing method of a latent type description: " + this);
        }

        public TypeDescription getEnclosingType() {
            throw new IllegalStateException("Cannot resolve enclosing type of a latent type description: " + this);
        }

        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.interfaces);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.f27130name;
        }

        public TypeDescription getNestHost() {
            throw new IllegalStateException("Cannot resolve nest host of a latent type description: " + this);
        }

        public TypeList getNestMembers() {
            throw new IllegalStateException("Cannot resolve nest mates of a latent type description: " + this);
        }

        public PackageDescription getPackage() {
            String str;
            String name2 = getName();
            int lastIndexOf = name2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str = "";
            } else {
                str = name2.substring(0, lastIndexOf);
            }
            return new PackageDescription.Simple(str);
        }

        public TypeList getPermittedSubtypes() {
            throw new IllegalStateException("Cannot resolve permitted subclasses of a latent type description: " + this);
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            throw new IllegalStateException("Cannot resolve record components of a latent type description: " + this);
        }

        public Generic getSuperClass() {
            return this.superClass;
        }

        public TypeList.Generic getTypeVariables() {
            throw new IllegalStateException("Cannot resolve type variables of a latent type description: " + this);
        }

        public boolean isAnonymousType() {
            throw new IllegalStateException("Cannot resolve anonymous type property of a latent type description: " + this);
        }

        public boolean isLocalType() {
            throw new IllegalStateException("Cannot resolve local class property of a latent type description: " + this);
        }

        public boolean isRecord() {
            throw new IllegalStateException("Cannot resolve record attribute of a latent type description: " + this);
        }

        public Latent(String str, int i11, Generic generic, List<? extends Generic> list) {
            this.f27130name = str;
            this.modifiers = i11;
            this.superClass = generic;
            this.interfaces = list;
        }

        public TypeDescription getDeclaringType() {
            throw new IllegalStateException("Cannot resolve declared type of a latent type description: " + this);
        }
    }

    public static class SuperTypeLoading extends AbstractBase {
        private final ClassLoader classLoader;
        private final ClassLoadingDelegate classLoadingDelegate;
        private final TypeDescription delegate;

        public interface ClassLoadingDelegate {

            public enum Simple implements ClassLoadingDelegate {
                INSTANCE;

                public Class<?> load(String str, ClassLoader classLoader) throws ClassNotFoundException {
                    return Class.forName(str, false, classLoader);
                }
            }

            Class<?> load(String str, ClassLoader classLoader) throws ClassNotFoundException;
        }

        public static class ClassLoadingTypeList extends TypeList.Generic.AbstractBase {
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;
            private final TypeList.Generic delegate;

            public ClassLoadingTypeList(TypeList.Generic generic, ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
                this.delegate = generic;
                this.classLoader = classLoader2;
                this.classLoadingDelegate = classLoadingDelegate2;
            }

            public int size() {
                return this.delegate.size();
            }

            public Generic get(int i11) {
                return new ClassLoadingTypeProjection((Generic) this.delegate.get(i11), this.classLoader, this.classLoadingDelegate);
            }
        }

        public static class ClassLoadingTypeProjection extends Generic.LazyProjection {
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;
            private final Generic delegate;
            private transient /* synthetic */ TypeDescription erasure;
            private transient /* synthetic */ TypeList.Generic interfaces;
            private transient /* synthetic */ Generic superClass;

            public ClassLoadingTypeProjection(Generic generic, ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
                this.delegate = generic;
                this.classLoader = classLoader2;
                this.classLoadingDelegate = classLoadingDelegate2;
            }

            public Generic a() {
                return this.delegate;
            }

            @CachedReturnPlugin.Enhance("erasure")
            public TypeDescription asErasure() {
                TypeDescription typeDescription;
                if (this.erasure != null) {
                    typeDescription = null;
                } else {
                    try {
                        typeDescription = ForLoadedType.of(this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader));
                    } catch (ClassNotFoundException unused) {
                        typeDescription = this.delegate.asErasure();
                    }
                }
                if (typeDescription == null) {
                    return this.erasure;
                }
                this.erasure = typeDescription;
                return typeDescription;
            }

            public AnnotationList getDeclaredAnnotations() {
                return this.delegate.getDeclaredAnnotations();
            }

            @CachedReturnPlugin.Enhance("interfaces")
            public TypeList.Generic getInterfaces() {
                TypeList.Generic generic;
                if (this.interfaces != null) {
                    generic = null;
                } else {
                    generic = this.delegate.getInterfaces();
                    try {
                        generic = new ClassLoadingTypeList(generic, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (generic == null) {
                    return this.interfaces;
                }
                this.interfaces = generic;
                return generic;
            }

            @CachedReturnPlugin.Enhance("superClass")
            public Generic getSuperClass() {
                Generic generic;
                if (this.superClass != null) {
                    generic = null;
                } else {
                    generic = this.delegate.getSuperClass();
                    if (generic == null) {
                        generic = Generic.UNDEFINED;
                    } else {
                        try {
                            generic = new ClassLoadingTypeProjection(generic, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                }
                if (generic == null) {
                    return this.superClass;
                }
                this.superClass = generic;
                return generic;
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }
        }

        public SuperTypeLoading(TypeDescription typeDescription, ClassLoader classLoader2) {
            this(typeDescription, classLoader2, ClassLoadingDelegate.Simple.INSTANCE);
        }

        public String getCanonicalName() {
            return this.delegate.getCanonicalName();
        }

        public ClassFileVersion getClassFileVersion() {
            return this.delegate.getClassFileVersion();
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.delegate.getDeclaredAnnotations();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return this.delegate.getDeclaredFields();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return this.delegate.getDeclaredMethods();
        }

        public TypeList getDeclaredTypes() {
            return this.delegate.getDeclaredTypes();
        }

        public String getDescriptor() {
            return this.delegate.getDescriptor();
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.delegate.getEnclosingMethod();
        }

        public TypeDescription getEnclosingType() {
            return this.delegate.getEnclosingType();
        }

        public TypeList.Generic getInterfaces() {
            return new ClassLoadingTypeList(this.delegate.getInterfaces(), this.classLoader, this.classLoadingDelegate);
        }

        public int getModifiers() {
            return this.delegate.getModifiers();
        }

        public String getName() {
            return this.delegate.getName();
        }

        public TypeDescription getNestHost() {
            return this.delegate.getNestHost();
        }

        public TypeList getNestMembers() {
            return this.delegate.getNestMembers();
        }

        public PackageDescription getPackage() {
            return this.delegate.getPackage();
        }

        public TypeList getPermittedSubtypes() {
            return this.delegate.getPermittedSubtypes();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return this.delegate.getRecordComponents();
        }

        public String getSimpleName() {
            return this.delegate.getSimpleName();
        }

        public StackSize getStackSize() {
            return this.delegate.getStackSize();
        }

        public Generic getSuperClass() {
            Generic superClass = this.delegate.getSuperClass();
            if (superClass == null) {
                return Generic.UNDEFINED;
            }
            return new ClassLoadingTypeProjection(superClass, this.classLoader, this.classLoadingDelegate);
        }

        public TypeList.Generic getTypeVariables() {
            return this.delegate.getTypeVariables();
        }

        public boolean isAnonymousType() {
            return this.delegate.isAnonymousType();
        }

        public boolean isArray() {
            return this.delegate.isArray();
        }

        public boolean isLocalType() {
            return this.delegate.isLocalType();
        }

        public boolean isPrimitive() {
            return this.delegate.isPrimitive();
        }

        public boolean isRecord() {
            return this.delegate.isRecord();
        }

        public boolean isSealed() {
            return this.delegate.isSealed();
        }

        public SuperTypeLoading(TypeDescription typeDescription, ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
            this.delegate = typeDescription;
            this.classLoader = classLoader2;
            this.classLoadingDelegate = classLoadingDelegate2;
        }

        public TypeDescription getComponentType() {
            return this.delegate.getComponentType();
        }

        public TypeDescription getDeclaringType() {
            return this.delegate.getDeclaringType();
        }
    }

    TypeDescription asBoxed();

    TypeDescription asUnboxed();

    int getActualModifiers(boolean z11);

    String getCanonicalName();

    ClassFileVersion getClassFileVersion();

    TypeDescription getComponentType();

    FieldList<FieldDescription.InDefinedShape> getDeclaredFields();

    MethodList<MethodDescription.InDefinedShape> getDeclaredMethods();

    TypeList getDeclaredTypes();

    TypeDescription getDeclaringType();

    Object getDefaultValue();

    MethodDescription.InDefinedShape getEnclosingMethod();

    TypeDescription getEnclosingType();

    AnnotationList getInheritedAnnotations();

    int getInnerClassCount();

    TypeDescription getNestHost();

    TypeList getNestMembers();

    PackageDescription getPackage();

    TypeList getPermittedSubtypes();

    RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents();

    String getSimpleName();

    boolean isAnnotationReturnType();

    boolean isAnnotationValue();

    boolean isAnnotationValue(Object obj);

    boolean isAnonymousType();

    boolean isAssignableFrom(Class<?> cls);

    boolean isAssignableFrom(TypeDescription typeDescription);

    boolean isAssignableTo(Class<?> cls);

    boolean isAssignableTo(TypeDescription typeDescription);

    boolean isCompileTimeConstant();

    boolean isInHierarchyWith(Class<?> cls);

    boolean isInHierarchyWith(TypeDescription typeDescription);

    boolean isInnerClass();

    boolean isInstance(Object obj);

    boolean isLocalType();

    boolean isMemberType();

    boolean isNestHost();

    boolean isNestMateOf(Class<?> cls);

    boolean isNestMateOf(TypeDescription typeDescription);

    boolean isNestedClass();

    boolean isPackageType();

    boolean isPrimitiveWrapper();

    boolean isSamePackage(TypeDescription typeDescription);

    boolean isSealed();
}
