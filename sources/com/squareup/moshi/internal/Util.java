package com.squareup.moshi.internal;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Util {
    @Nullable
    public static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = DefaultConstructorMarker.class;
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
    @Nullable
    private static final Class<? extends Annotation> METADATA;
    public static final Set<Annotation> NO_ANNOTATIONS = Collections.emptySet();
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = Util.canonicalize(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Types.equals(this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Util.f(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        @Nullable
        private final Type ownerType;
        private final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || Types.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = Util.canonicalize(type);
            }
            this.ownerType = type3;
            this.rawType = Util.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i11 = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i11 < typeArr2.length) {
                    Type type4 = typeArr2[i11];
                    type4.getClass();
                    Util.a(type4);
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[i11] = Util.canonicalize(typeArr3[i11]);
                    i11++;
                } else {
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Types.equals(this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Nullable
        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ Util.c(this.ownerType);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb2.append(Util.f(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb2.toString();
            }
            sb2.append("<");
            sb2.append(Util.f(this.typeArguments[0]));
            for (int i11 = 1; i11 < this.typeArguments.length; i11++) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(Util.f(this.typeArguments[i11]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        @Nullable
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                Type type = typeArr2[0];
                type.getClass();
                Util.a(type);
                Class<Object> cls = Object.class;
                if (typeArr[0] == cls) {
                    this.lowerBound = Util.canonicalize(typeArr2[0]);
                    this.upperBound = cls;
                    return;
                }
                throw new IllegalArgumentException();
            } else {
                Type type2 = typeArr[0];
                type2.getClass();
                Util.a(type2);
                this.lowerBound = null;
                this.upperBound = Util.canonicalize(typeArr[0]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Types.equals(this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return Util.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + Util.f(this.lowerBound);
            } else if (this.upperBound == Object.class) {
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
            } else {
                return "? extends " + Util.f(this.upperBound);
            }
        }
    }

    static {
        Class<?> cls;
        try {
            cls = Class.forName(getKotlinMetadataClassName());
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        METADATA = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        linkedHashMap.put(Boolean.TYPE, Boolean.class);
        linkedHashMap.put(Byte.TYPE, Byte.class);
        linkedHashMap.put(Character.TYPE, Character.class);
        linkedHashMap.put(Double.TYPE, Double.class);
        linkedHashMap.put(Float.TYPE, Float.class);
        linkedHashMap.put(Integer.TYPE, Integer.class);
        linkedHashMap.put(Long.TYPE, Long.class);
        linkedHashMap.put(Short.TYPE, Short.class);
        linkedHashMap.put(Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(linkedHashMap);
    }

    private Util() {
    }

    public static void a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    @Nullable
    public static Class<?> b(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static <T> Class<T> boxIfPrimitive(Class<T> cls) {
        Class<T> cls2 = PRIMITIVE_TO_WRAPPER_TYPE.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static int c(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type instanceof GenericArrayTypeImpl) {
                return type;
            }
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else if (!(type instanceof WildcardType) || (type instanceof WildcardTypeImpl)) {
            return type;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static int d(Object[] objArr, Object obj) {
        for (int i11 = 0; i11 < objArr.length; i11++) {
            if (obj.equals(objArr[i11])) {
                return i11;
            }
        }
        throw new NoSuchElementException();
    }

    public static Type e(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> b11 = b(typeVariable);
        if (b11 == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, b11);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[d(b11.getTypeParameters(), typeVariable)];
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static <T> Constructor<T> findConstructor(Class<T> cls) {
        for (Constructor<T> constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0 && parameterTypes[parameterTypes.length - 1].equals(DEFAULT_CONSTRUCTOR_MARKER)) {
                return constructor;
            }
        }
        throw new IllegalStateException("No defaults constructor found for " + cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        throw rethrowCause(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        throw new java.lang.RuntimeException("Failed to instantiate the generated JsonAdapter for " + r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        throw new java.lang.RuntimeException("Failed to access the generated JsonAdapter for " + r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00af, code lost:
        if ((r8 instanceof java.lang.reflect.ParameterizedType) != false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00df, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter constructor for '" + r8 + "'. Suspiciously, the type was not parameterized but the target class '" + r2.getCanonicalName() + "' is generic. Consider using Types#newParameterizedType() to define these missing type variables.", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f6, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter constructor for " + r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f7, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010e, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter class for " + r8, r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076 A[ExcHandler: InvocationTargetException (r7v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[ExcHandler: InstantiationException (r7v4 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094 A[ExcHandler: IllegalAccessException (r7v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f7 A[ExcHandler: ClassNotFoundException (r7v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:15:0x0046=Splitter:B:15:0x0046} */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.squareup.moshi.JsonAdapter<?> generatedAdapter(com.squareup.moshi.Moshi r7, java.lang.reflect.Type r8, java.lang.Class<?> r9) {
        /*
            java.lang.Class<java.lang.reflect.Type[]> r0 = java.lang.reflect.Type[].class
            java.lang.Class<com.squareup.moshi.JsonClass> r1 = com.squareup.moshi.JsonClass.class
            java.lang.annotation.Annotation r1 = r9.getAnnotation(r1)
            com.squareup.moshi.JsonClass r1 = (com.squareup.moshi.JsonClass) r1
            r2 = 0
            if (r1 == 0) goto L_0x010f
            boolean r1 = r1.generateAdapter()
            if (r1 != 0) goto L_0x0015
            goto L_0x010f
        L_0x0015:
            java.lang.String r1 = r9.getName()
            java.lang.String r1 = com.squareup.moshi.Types.generatedJsonAdapterName((java.lang.String) r1)
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r3 = 1
            java.lang.Class r2 = java.lang.Class.forName(r1, r3, r9)     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            boolean r9 = r8 instanceof java.lang.reflect.ParameterizedType     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Class<com.squareup.moshi.Moshi> r1 = com.squareup.moshi.Moshi.class
            r4 = 0
            if (r9 == 0) goto L_0x0053
            r9 = r8
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Type[] r9 = r9.getActualTypeArguments()     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r6[r4] = r1     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r6[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = r2.getDeclaredConstructor(r6)     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r5[r4] = r7     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r5[r3] = r9     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            goto L_0x0068
        L_0x0046:
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r7[r4] = r0     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = r2.getDeclaredConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r5[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            goto L_0x0068
        L_0x0053:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0060, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r9[r4] = r1     // Catch:{ NoSuchMethodException -> 0x0060, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = r2.getDeclaredConstructor(r9)     // Catch:{ NoSuchMethodException -> 0x0060, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x0060, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            r5[r4] = r7     // Catch:{ NoSuchMethodException -> 0x0060, ClassNotFoundException -> 0x00f7, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            goto L_0x0068
        L_0x0060:
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = r2.getDeclaredConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
        L_0x0068:
            r1.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            java.lang.Object r7 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            com.squareup.moshi.JsonAdapter r7 = (com.squareup.moshi.JsonAdapter) r7     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            com.squareup.moshi.JsonAdapter r7 = r7.nullSafe()     // Catch:{ ClassNotFoundException -> 0x00f7, NoSuchMethodException -> 0x00ac, IllegalAccessException -> 0x0094, InstantiationException -> 0x007c, InvocationTargetException -> 0x0076 }
            return r7
        L_0x0076:
            r7 = move-exception
            java.lang.RuntimeException r7 = rethrowCause(r7)
            throw r7
        L_0x007c:
            r7 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to instantiate the generated JsonAdapter for "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7)
            throw r9
        L_0x0094:
            r7 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to access the generated JsonAdapter for "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7)
            throw r9
        L_0x00ac:
            r7 = move-exception
            boolean r9 = r8 instanceof java.lang.reflect.ParameterizedType
            if (r9 != 0) goto L_0x00e0
            java.lang.reflect.TypeVariable[] r9 = r2.getTypeParameters()
            int r9 = r9.length
            if (r9 == 0) goto L_0x00e0
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for '"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = "'. Suspiciously, the type was not parameterized but the target class '"
            r0.append(r8)
            java.lang.String r8 = r2.getCanonicalName()
            r0.append(r8)
            java.lang.String r8 = "' is generic. Consider using Types#newParameterizedType() to define these missing type variables."
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7)
            throw r9
        L_0x00e0:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7)
            throw r9
        L_0x00f7:
            r7 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter class for "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8, r7)
            throw r9
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.generatedAdapter(com.squareup.moshi.Moshi, java.lang.reflect.Type, java.lang.Class):com.squareup.moshi.JsonAdapter");
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i11 = 0; i11 < length; i11++) {
                Class<?> cls3 = interfaces[i11];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i11];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i11], interfaces[i11], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    public static boolean hasNullable(Annotation[] annotationArr) {
        for (Annotation annotationType : annotationArr) {
            if (annotationType.annotationType().getSimpleName().equals("Nullable")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnnotationPresent(Set<? extends Annotation> set, Class<? extends Annotation> cls) {
        if (set.isEmpty()) {
            return false;
        }
        for (Annotation annotationType : set) {
            if (annotationType.annotationType() == cls) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKotlin(Class<?> cls) {
        Class<? extends Annotation> cls2 = METADATA;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static boolean isPlatformType(Class<?> cls) {
        String name2 = cls.getName();
        if (name2.startsWith("android.") || name2.startsWith("androidx.") || name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("kotlin.") || name2.startsWith("kotlinx.") || name2.startsWith("scala.")) {
            return true;
        }
        return false;
    }

    public static Set<? extends Annotation> jsonAnnotations(AnnotatedElement annotatedElement) {
        return jsonAnnotations(annotatedElement.getAnnotations());
    }

    public static String jsonName(String str, AnnotatedElement annotatedElement) {
        return jsonName(str, (Json) annotatedElement.getAnnotation(Json.class));
    }

    public static <T> Constructor<T> lookupDefaultsConstructor(Class<T> cls) {
        if (DEFAULT_CONSTRUCTOR_MARKER != null) {
            Constructor<T> findConstructor = findConstructor(cls);
            findConstructor.setAccessible(true);
            return findConstructor;
        }
        throw new IllegalStateException("DefaultConstructorMarker not on classpath. Make sure the Kotlin stdlib is on the classpath.");
    }

    public static JsonDataException missingProperty(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Required value '%s' missing at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Required value '%s' (JSON name '%s') missing at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static Type removeSubtypeWildcard(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return resolve(type, cls, type2, new LinkedHashSet());
    }

    public static RuntimeException rethrowCause(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        } else if (targetException instanceof Error) {
            throw ((Error) targetException);
        } else {
            throw new RuntimeException(targetException);
        }
    }

    public static String typeAnnotatedWithAnnotations(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public static boolean typesMatch(Type type, Type type2) {
        return Types.equals(type, type2);
    }

    public static JsonDataException unexpectedNull(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Non-null value '%s' was null at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Non-null value '%s' (JSON name '%s') was null at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : NO_ANNOTATIONS;
    }

    public static String jsonName(String str, @Nullable Json json) {
        if (json == null) {
            return str;
        }
        String name2 = json.name();
        return Json.UNSET_NAME.equals(name2) ? str : name2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.reflect.WildcardType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type resolve(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable<?>> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0018
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto L_0x000e
            return r10
        L_0x000e:
            r11.add(r0)
            java.lang.reflect.Type r10 = e(r8, r9, r0)
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x0018:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0035
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x0035
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            java.lang.reflect.GenericArrayType r0 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x0034:
            return r0
        L_0x0035:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x004b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            java.lang.reflect.GenericArrayType r10 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x004a:
            return r10
        L_0x004b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = resolve(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x005f
            r0 = r1
            goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x0065:
            if (r2 >= r5) goto L_0x0080
            r6 = r4[r2]
            java.lang.reflect.Type r6 = resolve(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x007d
            if (r0 != 0) goto L_0x007b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r1
        L_0x007b:
            r4[r2] = r6
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0080:
            if (r0 == 0) goto L_0x008c
            com.squareup.moshi.internal.Util$ParameterizedTypeImpl r8 = new com.squareup.moshi.internal.Util$ParameterizedTypeImpl
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            r10 = r8
        L_0x008c:
            return r10
        L_0x008d:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00bf
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x00ad
            r1 = r0[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.supertypeOf(r8)
            return r8
        L_0x00ad:
            int r0 = r3.length
            if (r0 != r1) goto L_0x00bf
            r0 = r3[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)     // Catch:{ all -> 0x00c0 }
            r9 = r3[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.subtypeOf(r8)
            return r8
        L_0x00bf:
            return r10
        L_0x00c0:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }
}
