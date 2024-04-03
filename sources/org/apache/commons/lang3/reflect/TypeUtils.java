package org.apache.commons.lang3.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class TypeUtils {
    public static final WildcardType WILDCARD_ALL = wildcardType().withUpperBounds(Object.class).build();

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof GenericArrayType) && TypeUtils.equals((GenericArrayType) this, (Type) (GenericArrayType) obj));
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode() | 1072;
        }

        public String toString() {
            return TypeUtils.toString(this);
        }

        private GenericArrayTypeImpl(Type type) {
            this.componentType = type;
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Class<?> raw;
        private final Type[] typeArguments;
        private final Type useOwner;

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof ParameterizedType) && TypeUtils.equals((ParameterizedType) this, (Type) (ParameterizedType) obj));
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getOwnerType() {
            return this.useOwner;
        }

        public Type getRawType() {
            return this.raw;
        }

        public int hashCode() {
            return ((((this.raw.hashCode() | 1136) << 4) | ObjectUtils.hashCode(this.useOwner)) << 8) | Arrays.hashCode(this.typeArguments);
        }

        public String toString() {
            return TypeUtils.toString(this);
        }

        private ParameterizedTypeImpl(Class<?> cls, Type type, Type[] typeArr) {
            this.raw = cls;
            this.useOwner = type;
            this.typeArguments = typeArr;
        }
    }

    public static class WildcardTypeBuilder implements Builder<WildcardType> {
        private Type[] lowerBounds;
        private Type[] upperBounds;

        public WildcardTypeBuilder withLowerBounds(Type... typeArr) {
            this.lowerBounds = typeArr;
            return this;
        }

        public WildcardTypeBuilder withUpperBounds(Type... typeArr) {
            this.upperBounds = typeArr;
            return this;
        }

        private WildcardTypeBuilder() {
        }

        public WildcardType build() {
            return new WildcardTypeImpl(this.upperBounds, this.lowerBounds);
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private static final Type[] EMPTY_BOUNDS = new Type[0];
        private final Type[] lowerBounds;
        private final Type[] upperBounds;

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof WildcardType) && TypeUtils.equals((WildcardType) this, (Type) (WildcardType) obj));
        }

        public Type[] getLowerBounds() {
            return (Type[]) this.lowerBounds.clone();
        }

        public Type[] getUpperBounds() {
            return (Type[]) this.upperBounds.clone();
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.upperBounds) | 18688) << 8) | Arrays.hashCode(this.lowerBounds);
        }

        public String toString() {
            return TypeUtils.toString(this);
        }

        private WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Type[] typeArr3 = EMPTY_BOUNDS;
            this.upperBounds = (Type[]) ObjectUtils.defaultIfNull(typeArr, typeArr3);
            this.lowerBounds = (Type[]) ObjectUtils.defaultIfNull(typeArr2, typeArr3);
        }
    }

    private static StringBuilder appendAllTo(StringBuilder sb2, String str, Type... typeArr) {
        Validate.notEmpty((T[]) Validate.noNullElements((T[]) typeArr));
        if (typeArr.length > 0) {
            sb2.append(toString(typeArr[0]));
            for (int i11 = 1; i11 < typeArr.length; i11++) {
                sb2.append(str);
                sb2.append(toString(typeArr[i11]));
            }
        }
        return sb2;
    }

    private static String classToString(Class<?> cls) {
        StringBuilder sb2 = new StringBuilder();
        if (cls.getEnclosingClass() != null) {
            sb2.append(classToString(cls.getEnclosingClass()));
            sb2.append('.');
            sb2.append(cls.getSimpleName());
        } else {
            sb2.append(cls.getName());
        }
        if (cls.getTypeParameters().length > 0) {
            sb2.append(Typography.less);
            appendAllTo(sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, cls.getTypeParameters());
            sb2.append(Typography.greater);
        }
        return sb2.toString();
    }

    public static boolean containsTypeVariables(Type type) {
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            if (((Class) type).getTypeParameters().length > 0) {
                return true;
            }
            return false;
        } else if (type instanceof ParameterizedType) {
            for (Type containsTypeVariables : ((ParameterizedType) type).getActualTypeArguments()) {
                if (containsTypeVariables(containsTypeVariables)) {
                    return true;
                }
            }
            return false;
        } else if (!(type instanceof WildcardType)) {
            return false;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            if (containsTypeVariables(getImplicitLowerBounds(wildcardType)[0]) || containsTypeVariables(getImplicitUpperBounds(wildcardType)[0])) {
                return true;
            }
            return false;
        }
    }

    public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType parameterizedType) {
        Validate.notNull(cls, "cls is null", new Object[0]);
        Validate.notNull(parameterizedType, "superType is null", new Object[0]);
        Class<?> rawType = getRawType(parameterizedType);
        if (!isAssignable((Type) cls, rawType)) {
            return null;
        }
        if (cls.equals(rawType)) {
            return getTypeArguments(parameterizedType, rawType, (Map<TypeVariable<?>, Type>) null);
        }
        Type closestParentType = getClosestParentType(cls, rawType);
        if (closestParentType instanceof Class) {
            return determineTypeArguments((Class) closestParentType, parameterizedType);
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) closestParentType;
        Map<TypeVariable<?>, Type> determineTypeArguments = determineTypeArguments(getRawType(parameterizedType2), parameterizedType);
        mapTypeVariablesToArguments(cls, parameterizedType2, determineTypeArguments);
        return determineTypeArguments;
    }

    public static boolean equals(Type type, Type type2) {
        if (ObjectUtils.equals(type, type2)) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return equals((ParameterizedType) type, type2);
        }
        if (type instanceof GenericArrayType) {
            return equals((GenericArrayType) type, type2);
        }
        if (type instanceof WildcardType) {
            return equals((WildcardType) type, type2);
        }
        return false;
    }

    private static Type[] extractTypeArgumentsFrom(Map<TypeVariable<?>, Type> map, TypeVariable<?>[] typeVariableArr) {
        Type[] typeArr = new Type[typeVariableArr.length];
        int length = typeVariableArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            TypeVariable<?> typeVariable = typeVariableArr[i11];
            Validate.isTrue(map.containsKey(typeVariable), "missing argument mapping for %s", toString(typeVariable));
            typeArr[i12] = map.get(typeVariable);
            i11++;
            i12++;
        }
        return typeArr;
    }

    public static GenericArrayType genericArrayType(Type type) {
        return new GenericArrayTypeImpl((Type) Validate.notNull(type, "componentType is null", new Object[0]));
    }

    private static String genericArrayTypeToString(GenericArrayType genericArrayType) {
        return String.format("%s[]", new Object[]{toString(genericArrayType.getGenericComponentType())});
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return cls.getComponentType();
            }
            return null;
        } else if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        } else {
            return null;
        }
    }

    private static Type getClosestParentType(Class<?> cls, Class<?> cls2) {
        Class<?> cls3;
        if (cls2.isInterface()) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                if (type2 instanceof ParameterizedType) {
                    cls3 = getRawType((ParameterizedType) type2);
                } else if (type2 instanceof Class) {
                    cls3 = (Class) type2;
                } else {
                    throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                }
                if (isAssignable((Type) cls3, cls2) && isAssignable(type, (Type) cls3)) {
                    type = type2;
                }
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
        Validate.notNull(typeVariable, "typeVariable is null", new Object[0]);
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length != 0) {
            return normalizeUpperBounds(bounds);
        }
        return new Type[]{Object.class};
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
        Validate.notNull(wildcardType, "wildcardType is null", new Object[0]);
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds;
        }
        return new Type[]{null};
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
        Validate.notNull(wildcardType, "wildcardType is null", new Object[0]);
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 0) {
            return normalizeUpperBounds(upperBounds);
        }
        return new Type[]{Object.class};
    }

    private static Class<?> getRawType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType) {
        return getTypeArguments(parameterizedType, getRawType(parameterizedType), (Map<TypeVariable<?>, Type>) null);
    }

    public static boolean isArrayType(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static boolean isAssignable(Type type, Type type2) {
        return isAssignable(type, type2, (Map<TypeVariable<?>, Type>) null);
    }

    public static boolean isInstance(Object obj, Type type) {
        if (type == null) {
            return false;
        }
        return obj == null ? !(type instanceof Class) || !((Class) type).isPrimitive() : isAssignable((Type) obj.getClass(), type, (Map<TypeVariable<?>, Type>) null);
    }

    private static <T> void mapTypeVariablesToArguments(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            mapTypeVariablesToArguments(cls, (ParameterizedType) ownerType, map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = getRawType(parameterizedType).getTypeParameters();
        List asList = Arrays.asList(cls.getTypeParameters());
        for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
            TypeVariable typeVariable = typeParameters[i11];
            Type type = actualTypeArguments[i11];
            if (asList.contains(type) && map.containsKey(typeVariable)) {
                map.put((TypeVariable) type, map.get(typeVariable));
            }
        }
    }

    public static Type[] normalizeUpperBounds(Type[] typeArr) {
        boolean z11;
        Validate.notNull(typeArr, "null value specified for bounds array", new Object[0]);
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    Type type2 = typeArr[i11];
                    if (type != type2 && isAssignable(type2, type, (Map<TypeVariable<?>, Type>) null)) {
                        z11 = true;
                        break;
                    }
                    i11++;
                } else {
                    z11 = false;
                    break;
                }
            }
            if (!z11) {
                hashSet.add(type);
            }
        }
        return (Type[]) hashSet.toArray(new Type[hashSet.size()]);
    }

    public static final ParameterizedType parameterize(Class<?> cls, Type... typeArr) {
        return parameterizeWithOwner((Type) null, cls, typeArr);
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Type... typeArr) {
        Validate.notNull(cls, "raw class is null", new Object[0]);
        if (cls.getEnclosingClass() == null) {
            Validate.isTrue(type == null, "no owner allowed for top-level %s", cls);
            type = null;
        } else if (type == null) {
            type = cls.getEnclosingClass();
        } else {
            Validate.isTrue(isAssignable(type, cls.getEnclosingClass()), "%s is invalid owner type for parameterized %s", type, cls);
        }
        Validate.noNullElements((T[]) typeArr, "null type argument at index %s", new Object[0]);
        Validate.isTrue(cls.getTypeParameters().length == typeArr.length, "invalid number of type parameters specified: expected %s, got %s", Integer.valueOf(cls.getTypeParameters().length), Integer.valueOf(typeArr.length));
        return new ParameterizedTypeImpl(cls, type, typeArr);
    }

    private static String parameterizedTypeToString(ParameterizedType parameterizedType) {
        StringBuilder sb2 = new StringBuilder();
        Type ownerType = parameterizedType.getOwnerType();
        Class cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (ownerType == null) {
            sb2.append(cls.getName());
        } else {
            if (ownerType instanceof Class) {
                sb2.append(((Class) ownerType).getName());
            } else {
                sb2.append(ownerType.toString());
            }
            sb2.append('.');
            sb2.append(cls.getSimpleName());
        }
        sb2.append(Typography.less);
        appendAllTo(sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, actualTypeArguments).append(Typography.greater);
        return sb2.toString();
    }

    private static Type substituteTypeVariables(Type type, Map<TypeVariable<?>, Type> map) {
        if (!(type instanceof TypeVariable) || map == null) {
            return type;
        }
        Type type2 = map.get(type);
        if (type2 != null) {
            return type2;
        }
        throw new IllegalArgumentException("missing assignment type for type variable " + type);
    }

    public static String toLongString(TypeVariable<?> typeVariable) {
        Validate.notNull(typeVariable, "var is null", new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class<?> cls = (Class) genericDeclaration;
            while (cls.getEnclosingClass() != null) {
                sb2.insert(0, cls.getSimpleName()).insert(0, '.');
                cls = cls.getEnclosingClass();
            }
            sb2.insert(0, cls.getName());
        } else if (genericDeclaration instanceof Type) {
            sb2.append(toString((Type) genericDeclaration));
        } else {
            sb2.append(genericDeclaration);
        }
        sb2.append(AbstractJsonLexerKt.COLON);
        sb2.append(typeVariableToString(typeVariable));
        return sb2.toString();
    }

    public static String toString(Type type) {
        Validate.notNull(type);
        if (type instanceof Class) {
            return classToString((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return parameterizedTypeToString((ParameterizedType) type);
        }
        if (type instanceof WildcardType) {
            return wildcardTypeToString((WildcardType) type);
        }
        if (type instanceof TypeVariable) {
            return typeVariableToString((TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return genericArrayTypeToString((GenericArrayType) type);
        }
        throw new IllegalArgumentException(ObjectUtils.identityToString(type));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (java.lang.Object.class.equals(r1[0]) == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String typeVariableToString(java.lang.reflect.TypeVariable<?> r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = r4.getName()
            r0.<init>(r1)
            java.lang.reflect.Type[] r1 = r4.getBounds()
            int r2 = r1.length
            if (r2 <= 0) goto L_0x002d
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L_0x001f
            r2 = 0
            r1 = r1[r2]
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x002d
        L_0x001f:
            java.lang.String r1 = " extends "
            r0.append(r1)
            java.lang.String r1 = " & "
            java.lang.reflect.Type[] r4 = r4.getBounds()
            appendAllTo(r0, r1, r4)
        L_0x002d:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.TypeUtils.typeVariableToString(java.lang.reflect.TypeVariable):java.lang.String");
    }

    public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> map) {
        Validate.notNull(map, "typeVarAssigns is null", new Object[0]);
        for (Map.Entry next : map.entrySet()) {
            Type type = (Type) next.getValue();
            Type[] implicitBounds = getImplicitBounds((TypeVariable) next.getKey());
            int length = implicitBounds.length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    if (!isAssignable(type, substituteTypeVariables(implicitBounds[i11], map), map)) {
                        return false;
                    }
                    i11++;
                }
            }
        }
        return true;
    }

    private static Type[] unrollBounds(Map<TypeVariable<?>, Type> map, Type[] typeArr) {
        int i11 = 0;
        while (i11 < typeArr.length) {
            Type unrollVariables = unrollVariables(map, typeArr[i11]);
            if (unrollVariables == null) {
                typeArr = (Type[]) ArrayUtils.remove((T[]) typeArr, i11);
                i11--;
            } else {
                typeArr[i11] = unrollVariables;
            }
            i11++;
        }
        return typeArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.reflect.Type} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.reflect.TypeVariable<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type unrollVariableAssignments(java.lang.reflect.TypeVariable<?> r2, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r3) {
        /*
        L_0x0000:
            java.lang.Object r0 = r3.get(r2)
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L_0x0014
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0014
            r2 = r0
            java.lang.reflect.TypeVariable r2 = (java.lang.reflect.TypeVariable) r2
            goto L_0x0000
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.TypeUtils.unrollVariableAssignments(java.lang.reflect.TypeVariable, java.util.Map):java.lang.reflect.Type");
    }

    public static Type unrollVariables(HashMap hashMap, Type type) {
        if (hashMap == null) {
            hashMap = Collections.emptyMap();
        }
        if (containsTypeVariables(type)) {
            if (type instanceof TypeVariable) {
                return unrollVariables(hashMap, hashMap.get(type));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getOwnerType() != null) {
                    HashMap hashMap2 = new HashMap(hashMap);
                    hashMap2.putAll(getTypeArguments(parameterizedType));
                    hashMap = hashMap2;
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                    Type unrollVariables = unrollVariables(hashMap, actualTypeArguments[i11]);
                    if (unrollVariables != null) {
                        actualTypeArguments[i11] = unrollVariables;
                    }
                }
                return parameterizeWithOwner(parameterizedType.getOwnerType(), (Class<?>) (Class) parameterizedType.getRawType(), actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType().withUpperBounds(unrollBounds(hashMap, wildcardType.getUpperBounds())).withLowerBounds(unrollBounds(hashMap, wildcardType.getLowerBounds())).build();
            }
        }
        return type;
    }

    public static WildcardTypeBuilder wildcardType() {
        return new WildcardTypeBuilder();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        if (java.lang.Object.class.equals(r4[0]) == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String wildcardTypeToString(java.lang.reflect.WildcardType r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 63
            r0.append(r1)
            java.lang.reflect.Type[] r1 = r4.getLowerBounds()
            java.lang.reflect.Type[] r4 = r4.getUpperBounds()
            int r2 = r1.length
            java.lang.String r3 = " & "
            if (r2 <= 0) goto L_0x0020
            java.lang.String r4 = " super "
            r0.append(r4)
            appendAllTo(r0, r3, r1)
            goto L_0x0037
        L_0x0020:
            int r1 = r4.length
            r2 = 1
            if (r1 != r2) goto L_0x002f
            r1 = 0
            r1 = r4[r1]
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0037
        L_0x002f:
            java.lang.String r1 = " extends "
            r0.append(r1)
            appendAllTo(r0, r3, r4)
        L_0x0037:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.TypeUtils.wildcardTypeToString(java.lang.reflect.WildcardType):java.lang.String");
    }

    public static <T> Typed<T> wrap(final Type type) {
        return new Typed<T>() {
            public Type getType() {
                return type;
            }
        };
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls) {
        return getTypeArguments(type, cls, (Map<TypeVariable<?>, Type>) null);
    }

    private static boolean isAssignable(Type type, Type type2, Map<TypeVariable<?>, Type> map) {
        if (type2 == null || (type2 instanceof Class)) {
            return isAssignable(type, (Class<?>) (Class) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return isAssignable(type, (ParameterizedType) type2, map);
        }
        if (type2 instanceof GenericArrayType) {
            return isAssignable(type, (GenericArrayType) type2, map);
        }
        if (type2 instanceof WildcardType) {
            return isAssignable(type, (WildcardType) type2, map);
        }
        if (type2 instanceof TypeVariable) {
            return isAssignable(type, (TypeVariable<?>) (TypeVariable) type2, map);
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    public static final ParameterizedType parameterize(Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Validate.notNull(cls, "raw class is null", new Object[0]);
        Validate.notNull(map, "typeArgMappings is null", new Object[0]);
        return parameterizeWithOwner((Type) null, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
    }

    public static <T> Typed<T> wrap(Class<T> cls) {
        return wrap((Type) cls);
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        if (type instanceof Class) {
            return getTypeArguments((Class<?>) (Class) type, cls, map);
        }
        if (type instanceof ParameterizedType) {
            return getTypeArguments((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return getTypeArguments(genericComponentType, cls, map);
        }
        int i11 = 0;
        if (type instanceof WildcardType) {
            Type[] implicitUpperBounds = getImplicitUpperBounds((WildcardType) type);
            int length = implicitUpperBounds.length;
            while (i11 < length) {
                Type type2 = implicitUpperBounds[i11];
                if (isAssignable(type2, cls)) {
                    return getTypeArguments(type2, cls, map);
                }
                i11++;
            }
            return null;
        } else if (type instanceof TypeVariable) {
            Type[] implicitBounds = getImplicitBounds((TypeVariable) type);
            int length2 = implicitBounds.length;
            while (i11 < length2) {
                Type type3 = implicitBounds[i11];
                if (isAssignable(type3, cls)) {
                    return getTypeArguments(type3, cls, map);
                }
                i11++;
            }
            return null;
        } else {
            throw new IllegalStateException("found an unhandled type: " + type);
        }
    }

    public static Class<?> getRawType(Type type, Type type2) {
        Map<TypeVariable<?>, Type> typeArguments;
        Type type3;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawType((ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            if (type2 == null) {
                return null;
            }
            GenericDeclaration genericDeclaration = ((TypeVariable) type).getGenericDeclaration();
            if (!(genericDeclaration instanceof Class) || (typeArguments = getTypeArguments(type2, (Class) genericDeclaration)) == null || (type3 = typeArguments.get(type)) == null) {
                return null;
            }
            return getRawType(type3, type2);
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType(), type2), 0).getClass();
        } else {
            if (type instanceof WildcardType) {
                return null;
            }
            throw new IllegalArgumentException("unknown type: " + type);
        }
    }

    /* access modifiers changed from: private */
    public static boolean equals(ParameterizedType parameterizedType, Type type) {
        if (!(type instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) type;
        if (!equals(parameterizedType.getRawType(), parameterizedType2.getRawType()) || !equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
            return false;
        }
        return equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Validate.notNull(cls, "raw class is null", new Object[0]);
        Validate.notNull(map, "typeArgMappings is null", new Object[0]);
        return parameterizeWithOwner(type, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
    }

    /* access modifiers changed from: private */
    public static boolean equals(GenericArrayType genericArrayType, Type type) {
        return (type instanceof GenericArrayType) && equals(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType());
    }

    /* access modifiers changed from: private */
    public static boolean equals(WildcardType wildcardType, Type type) {
        if (!(type instanceof WildcardType)) {
            return true;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        if (!equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()) || !equals(getImplicitUpperBounds(wildcardType), getImplicitUpperBounds(wildcardType2))) {
            return false;
        }
        return true;
    }

    private static boolean isAssignable(Type type, Class<?> cls) {
        if (type == null) {
            return cls == null || !cls.isPrimitive();
        }
        if (cls == null) {
            return false;
        }
        if (cls.equals(type)) {
            return true;
        }
        if (type instanceof Class) {
            return ClassUtils.isAssignable((Class<?>) (Class) type, cls);
        }
        if (type instanceof ParameterizedType) {
            return isAssignable((Type) getRawType((ParameterizedType) type), cls);
        }
        if (type instanceof TypeVariable) {
            for (Type isAssignable : ((TypeVariable) type).getBounds()) {
                if (isAssignable(isAssignable, cls)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (cls.equals(Object.class)) {
                return true;
            }
            if (!cls.isArray() || !isAssignable(((GenericArrayType) type).getGenericComponentType(), cls.getComponentType())) {
                return false;
            }
            return true;
        } else if (type instanceof WildcardType) {
            return false;
        } else {
            throw new IllegalStateException("found an unhandled type: " + type);
        }
    }

    private static boolean equals(Type[] typeArr, Type[] typeArr2) {
        if (typeArr.length != typeArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            if (!equals(typeArr[i11], typeArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Map<TypeVariable<?>, Type> map2;
        Class<?> rawType = getRawType(parameterizedType);
        if (!isAssignable((Type) rawType, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            map2 = getTypeArguments(parameterizedType2, getRawType(parameterizedType2), map);
        } else {
            map2 = map == null ? new HashMap<>() : new HashMap<>(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = rawType.getTypeParameters();
        for (int i11 = 0; i11 < typeParameters.length; i11++) {
            Type type = actualTypeArguments[i11];
            TypeVariable typeVariable = typeParameters[i11];
            if (map2.containsKey(type)) {
                type = map2.get(type);
            }
            map2.put(typeVariable, type);
        }
        if (cls.equals(rawType)) {
            return map2;
        }
        return getTypeArguments(getClosestParentType(rawType, cls), cls, map2);
    }

    private static boolean isAssignable(Type type, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (parameterizedType == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> rawType = getRawType(parameterizedType);
        Map<TypeVariable<?>, Type> typeArguments = getTypeArguments(type, rawType, (Map<TypeVariable<?>, Type>) null);
        if (typeArguments == null) {
            return false;
        }
        if (typeArguments.isEmpty()) {
            return true;
        }
        Map<TypeVariable<?>, Type> typeArguments2 = getTypeArguments(parameterizedType, rawType, map);
        for (TypeVariable next : typeArguments2.keySet()) {
            Type unrollVariableAssignments = unrollVariableAssignments(next, typeArguments2);
            Type unrollVariableAssignments2 = unrollVariableAssignments(next, typeArguments);
            if (unrollVariableAssignments2 != null && !unrollVariableAssignments.equals(unrollVariableAssignments2)) {
                if (!(unrollVariableAssignments instanceof WildcardType) || !isAssignable(unrollVariableAssignments2, unrollVariableAssignments, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> cls, Class<?> cls2, Map<TypeVariable<?>, Type> map) {
        if (!isAssignable((Type) cls, cls2)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                return new HashMap();
            }
            cls = ClassUtils.primitiveToWrapper(cls);
        }
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        if (cls2.equals(cls)) {
            return hashMap;
        }
        return getTypeArguments(getClosestParentType(cls, cls2), cls2, (Map<TypeVariable<?>, Type>) hashMap);
    }

    private static boolean isAssignable(Type type, GenericArrayType genericArrayType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (genericArrayType == null) {
            return false;
        }
        if (genericArrayType.equals(type)) {
            return true;
        }
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray() || !isAssignable((Type) cls.getComponentType(), genericComponentType, map)) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            return isAssignable(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
        } else {
            if (type instanceof WildcardType) {
                for (Type isAssignable : getImplicitUpperBounds((WildcardType) type)) {
                    if (isAssignable(isAssignable, (Type) genericArrayType)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof TypeVariable) {
                for (Type isAssignable2 : getImplicitBounds((TypeVariable) type)) {
                    if (isAssignable(isAssignable2, (Type) genericArrayType)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof ParameterizedType) {
                return false;
            } else {
                throw new IllegalStateException("found an unhandled type: " + type);
            }
        }
    }

    private static boolean isAssignable(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (wildcardType == null) {
            return false;
        }
        if (wildcardType.equals(type)) {
            return true;
        }
        Type[] implicitUpperBounds = getImplicitUpperBounds(wildcardType);
        Type[] implicitLowerBounds = getImplicitLowerBounds(wildcardType);
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] implicitUpperBounds2 = getImplicitUpperBounds(wildcardType2);
            Type[] implicitLowerBounds2 = getImplicitLowerBounds(wildcardType2);
            for (Type substituteTypeVariables : implicitUpperBounds) {
                Type substituteTypeVariables2 = substituteTypeVariables(substituteTypeVariables, map);
                for (Type isAssignable : implicitUpperBounds2) {
                    if (!isAssignable(isAssignable, substituteTypeVariables2, map)) {
                        return false;
                    }
                }
            }
            for (Type substituteTypeVariables3 : implicitLowerBounds) {
                Type substituteTypeVariables4 = substituteTypeVariables(substituteTypeVariables3, map);
                for (Type isAssignable2 : implicitLowerBounds2) {
                    if (!isAssignable(substituteTypeVariables4, isAssignable2, map)) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (Type substituteTypeVariables5 : implicitUpperBounds) {
            if (!isAssignable(type, substituteTypeVariables(substituteTypeVariables5, map), map)) {
                return false;
            }
        }
        for (Type substituteTypeVariables6 : implicitLowerBounds) {
            if (!isAssignable(substituteTypeVariables(substituteTypeVariables6, map), type, map)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAssignable(Type type, TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type isAssignable : getImplicitBounds((TypeVariable) type)) {
                if (isAssignable(isAssignable, typeVariable, map)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }
}
