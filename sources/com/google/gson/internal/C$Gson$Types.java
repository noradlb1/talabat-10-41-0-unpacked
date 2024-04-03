package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.gson.internal.$Gson$Types  reason: invalid class name */
public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType) || !C$Gson$Types.equals(this, (GenericArrayType) obj)) {
                return false;
            }
            return true;
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type type3;
            boolean z11;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z12 = true;
                if (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (type == null && !z11) {
                    z12 = false;
                }
                C$Gson$Preconditions.checkArgument(z12);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = C$Gson$Types.canonicalize(type);
            }
            this.ownerType = type3;
            this.rawType = C$Gson$Types.canonicalize(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                C$Gson$Preconditions.checkNotNull(this.typeArguments[i11]);
                C$Gson$Types.checkNotPrimitive(this.typeArguments[i11]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i11] = C$Gson$Types.canonicalize(typeArr3[i11]);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType) || !C$Gson$Types.equals(this, (ParameterizedType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return C$Gson$Types.typeToString(this.rawType);
            }
            StringBuilder sb2 = new StringBuilder((length + 1) * 30);
            sb2.append(C$Gson$Types.typeToString(this.rawType));
            sb2.append("<");
            sb2.append(C$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i11 = 1; i11 < length; i11++) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(C$Gson$Types.typeToString(this.typeArguments[i11]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z11;
            boolean z12;
            boolean z13 = true;
            if (typeArr2.length <= 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            C$Gson$Preconditions.checkArgument(z11);
            if (typeArr.length == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            C$Gson$Preconditions.checkArgument(z12);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                Class<Object> cls = Object.class;
                C$Gson$Preconditions.checkArgument(typeArr[0] != cls ? false : z13);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = cls;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(typeArr[0]);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType) || !C$Gson$Types.equals(this, (WildcardType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return C$Gson$Types.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            int i11;
            Type type = this.lowerBound;
            if (type != null) {
                i11 = type.hashCode() + 31;
            } else {
                i11 = 1;
            }
            return i11 ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + C$Gson$Types.typeToString(this.lowerBound);
            } else if (this.upperBound == Object.class) {
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
            } else {
                return "? extends " + C$Gson$Types.typeToString(this.upperBound);
            }
        }
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x001d
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x001a
            com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl r0 = new com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl
            java.lang.Class r3 = r3.getComponentType()
            java.lang.reflect.Type r3 = canonicalize(r3)
            r0.<init>(r3)
            r3 = r0
        L_0x001a:
            java.lang.reflect.Type r3 = (java.lang.reflect.Type) r3
            return r3
        L_0x001d:
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0035
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl r0 = new com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl
            java.lang.reflect.Type r1 = r3.getOwnerType()
            java.lang.reflect.Type r2 = r3.getRawType()
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0045
            java.lang.reflect.GenericArrayType r3 = (java.lang.reflect.GenericArrayType) r3
            com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl r0 = new com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl
            java.lang.reflect.Type r3 = r3.getGenericComponentType()
            r0.<init>(r3)
            return r0
        L_0x0045:
            boolean r0 = r3 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0059
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            com.google.gson.internal.$Gson$Types$WildcardTypeImpl r0 = new com.google.gson.internal.$Gson$Types$WildcardTypeImpl
            java.lang.reflect.Type[] r1 = r3.getUpperBounds()
            java.lang.reflect.Type[] r3 = r3.getLowerBounds()
            r0.<init>(r1, r3)
            return r0
        L_0x0059:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.C$Gson$Types.canonicalize(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static void checkNotPrimitive(Type type) {
        C$Gson$Preconditions.checkArgument(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return false;
            }
            return true;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                return false;
            }
            return true;
        }
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type supertype = getSupertype(type, cls, Collection.class);
        if (supertype instanceof WildcardType) {
            supertype = ((WildcardType) supertype).getUpperBounds()[0];
        }
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType) supertype).getActualTypeArguments()[0];
        }
        return Object.class;
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

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            Class<String> cls2 = String.class;
            return new Type[]{cls2, cls2};
        }
        Type supertype = getSupertype(type, cls, Map.class);
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType) supertype).getActualTypeArguments();
        }
        Class<Object> cls3 = Object.class;
        return new Type[]{cls3, cls3};
    }

    public static Class<?> getRawType(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
        }
    }

    public static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, getGenericSupertype(type, cls, cls2));
    }

    public static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (obj.equals(objArr[i11])) {
                return i11;
            }
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return resolve(type, cls, type2, new HashMap());
    }

    public static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    public static WildcardType subtypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new WildcardTypeImpl(typeArr, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new WildcardTypeImpl(new Type[]{Object.class}, typeArr);
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: java.lang.reflect.ParameterizedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: java.lang.reflect.GenericArrayType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type resolve(java.lang.reflect.Type r9, java.lang.Class<?> r10, java.lang.reflect.Type r11, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r12) {
        /*
            r0 = 0
        L_0x0001:
            boolean r1 = r11 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L_0x0027
            r1 = r11
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1
            java.lang.Object r2 = r12.get(r1)
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            if (r2 == 0) goto L_0x0017
            java.lang.Class r9 = java.lang.Void.TYPE
            if (r2 != r9) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r11 = r2
        L_0x0016:
            return r11
        L_0x0017:
            java.lang.Class r11 = java.lang.Void.TYPE
            r12.put(r1, r11)
            if (r0 != 0) goto L_0x001f
            r0 = r1
        L_0x001f:
            java.lang.reflect.Type r11 = resolveTypeVariable(r9, r10, r1)
            if (r11 != r1) goto L_0x0001
            goto L_0x00dc
        L_0x0027:
            boolean r1 = r11 instanceof java.lang.Class
            if (r1 == 0) goto L_0x004c
            r1 = r11
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r2 = r1.isArray()
            if (r2 == 0) goto L_0x004c
            java.lang.Class r11 = r1.getComponentType()
            java.lang.reflect.Type r9 = resolve(r9, r10, r11, r12)
            boolean r10 = equal(r11, r9)
            if (r10 == 0) goto L_0x0045
            r11 = r1
            goto L_0x00dc
        L_0x0045:
            java.lang.reflect.GenericArrayType r9 = arrayOf(r9)
        L_0x0049:
            r11 = r9
            goto L_0x00dc
        L_0x004c:
            boolean r1 = r11 instanceof java.lang.reflect.GenericArrayType
            if (r1 == 0) goto L_0x0067
            java.lang.reflect.GenericArrayType r11 = (java.lang.reflect.GenericArrayType) r11
            java.lang.reflect.Type r1 = r11.getGenericComponentType()
            java.lang.reflect.Type r9 = resolve(r9, r10, r1, r12)
            boolean r10 = equal(r1, r9)
            if (r10 == 0) goto L_0x0062
            goto L_0x00dc
        L_0x0062:
            java.lang.reflect.GenericArrayType r9 = arrayOf(r9)
            goto L_0x0049
        L_0x0067:
            boolean r1 = r11 instanceof java.lang.reflect.ParameterizedType
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x00ab
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r1 = r11.getOwnerType()
            java.lang.reflect.Type r4 = resolve(r9, r10, r1, r12)
            boolean r1 = equal(r4, r1)
            r1 = r1 ^ r3
            java.lang.reflect.Type[] r5 = r11.getActualTypeArguments()
            int r6 = r5.length
        L_0x0081:
            if (r2 >= r6) goto L_0x00a0
            r7 = r5[r2]
            java.lang.reflect.Type r7 = resolve(r9, r10, r7, r12)
            r8 = r5[r2]
            boolean r8 = equal(r7, r8)
            if (r8 != 0) goto L_0x009d
            if (r1 != 0) goto L_0x009b
            java.lang.Object r1 = r5.clone()
            r5 = r1
            java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
            r1 = r3
        L_0x009b:
            r5[r2] = r7
        L_0x009d:
            int r2 = r2 + 1
            goto L_0x0081
        L_0x00a0:
            if (r1 == 0) goto L_0x00dc
            java.lang.reflect.Type r9 = r11.getRawType()
            java.lang.reflect.ParameterizedType r9 = newParameterizedTypeWithOwner(r4, r9, r5)
            goto L_0x0049
        L_0x00ab:
            boolean r1 = r11 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L_0x00dc
            java.lang.reflect.WildcardType r11 = (java.lang.reflect.WildcardType) r11
            java.lang.reflect.Type[] r1 = r11.getLowerBounds()
            java.lang.reflect.Type[] r4 = r11.getUpperBounds()
            int r5 = r1.length
            if (r5 != r3) goto L_0x00cb
            r3 = r1[r2]
            java.lang.reflect.Type r9 = resolve(r9, r10, r3, r12)
            r10 = r1[r2]
            if (r9 == r10) goto L_0x00dc
            java.lang.reflect.WildcardType r11 = supertypeOf(r9)
            goto L_0x00dc
        L_0x00cb:
            int r1 = r4.length
            if (r1 != r3) goto L_0x00dc
            r1 = r4[r2]
            java.lang.reflect.Type r9 = resolve(r9, r10, r1, r12)     // Catch:{ all -> 0x00e2 }
            r10 = r4[r2]
            if (r9 == r10) goto L_0x00dc
            java.lang.reflect.WildcardType r11 = subtypeOf(r9)
        L_0x00dc:
            if (r0 == 0) goto L_0x00e1
            r12.put(r0, r11)
        L_0x00e1:
            return r11
        L_0x00e2:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.C$Gson$Types.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Map):java.lang.reflect.Type");
    }
}
