package com.squareup.moshi;

import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import net.bytebuddy.utility.JavaConstant;

@CheckReturnValue
public final class Types {
    private Types() {
    }

    public static Type a(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        if (type instanceof Class) {
            return ((Class) type).getComponentType();
        }
        return null;
    }

    public static GenericArrayType arrayOf(Type type) {
        return new Util.GenericArrayTypeImpl(type);
    }

    public static <T extends Annotation> T b(final Class<T> cls) {
        if (!cls.isAnnotation()) {
            throw new IllegalArgumentException(cls + " must be an annotation.");
        } else if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            throw new IllegalArgumentException(cls + " must have @JsonQualifier.");
        } else if (cls.getDeclaredMethods().length == 0) {
            return (Annotation) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    String name2 = method.getName();
                    name2.hashCode();
                    char c11 = 65535;
                    switch (name2.hashCode()) {
                        case -1776922004:
                            if (name2.equals("toString")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -1295482945:
                            if (name2.equals("equals")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 147696667:
                            if (name2.equals("hashCode")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 1444986633:
                            if (name2.equals("annotationType")) {
                                c11 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            return "@" + cls.getName() + "()";
                        case 1:
                            return Boolean.valueOf(cls.isInstance(objArr[0]));
                        case 2:
                            return 0;
                        case 3:
                            return cls;
                        default:
                            return method.invoke(obj, objArr);
                    }
                }
            });
        } else {
            throw new IllegalArgumentException(cls + " must not declare methods.");
        }
    }

    public static Type c(Type type) {
        Class<?> rawType = getRawType(type);
        return Util.resolve(type, rawType, rawType.getGenericSuperclass());
    }

    public static Type collectionElementType(Type type, Class<?> cls) {
        Type d11 = d(type, cls, Collection.class);
        if (d11 instanceof WildcardType) {
            d11 = ((WildcardType) d11).getUpperBounds()[0];
        }
        if (d11 instanceof ParameterizedType) {
            return ((ParameterizedType) d11).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type d(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return Util.resolve(type, cls, Util.getGenericSupertype(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static Type[] e(Type type, Class<?> cls) {
        if (type == Properties.class) {
            Class<String> cls2 = String.class;
            return new Type[]{cls2, cls2};
        }
        Type d11 = d(type, cls, Map.class);
        if (d11 instanceof ParameterizedType) {
            return ((ParameterizedType) d11).getActualTypeArguments();
        }
        Class<Object> cls3 = Object.class;
        return new Type[]{cls3, cls3};
    }

    public static boolean equals(@Nullable Type type, @Nullable Type type2) {
        Type[] typeArr;
        Type[] typeArr2;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            if (type2 instanceof GenericArrayType) {
                return equals(((Class) type).getComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return type.equals(type2);
        } else if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (parameterizedType instanceof Util.ParameterizedTypeImpl) {
                typeArr = ((Util.ParameterizedTypeImpl) parameterizedType).typeArguments;
            } else {
                typeArr = parameterizedType.getActualTypeArguments();
            }
            if (parameterizedType2 instanceof Util.ParameterizedTypeImpl) {
                typeArr2 = ((Util.ParameterizedTypeImpl) parameterizedType2).typeArguments;
            } else {
                typeArr2 = parameterizedType2.getActualTypeArguments();
            }
            if (!equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(typeArr, typeArr2)) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof Class) {
                return equals(((Class) type2).getComponentType(), ((GenericArrayType) type).getGenericComponentType());
            }
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

    public static String generatedJsonAdapterName(Class<?> cls) {
        if (cls.getAnnotation(JsonClass.class) != null) {
            return generatedJsonAdapterName(cls.getName());
        }
        throw new IllegalArgumentException("Class does not have a JsonClass annotation: " + cls);
    }

    @Deprecated
    public static Set<? extends Annotation> getFieldJsonQualifierAnnotations(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
            LinkedHashSet linkedHashSet = new LinkedHashSet(declaredAnnotations.length);
            for (Annotation annotation : declaredAnnotations) {
                if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                    linkedHashSet.add(annotation);
                }
            }
            return Collections.unmodifiableSet(linkedHashSet);
        } catch (NoSuchFieldException e11) {
            throw new IllegalArgumentException("Could not access field " + str + " on class " + cls.getCanonicalName(), e11);
        }
    }

    public static Class<?> getRawType(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
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

    public static ParameterizedType newParameterizedType(Type type, Type... typeArr) {
        if (typeArr.length != 0) {
            return new Util.ParameterizedTypeImpl((Type) null, type, typeArr);
        }
        throw new IllegalArgumentException("Missing type arguments for " + type);
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        if (typeArr.length != 0) {
            return new Util.ParameterizedTypeImpl(type, type2, typeArr);
        }
        throw new IllegalArgumentException("Missing type arguments for " + type2);
    }

    @Nullable
    public static Set<? extends Annotation> nextAnnotations(Set<? extends Annotation> set, Class<? extends Annotation> cls) {
        if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            throw new IllegalArgumentException(cls + " is not a JsonQualifier.");
        } else if (set.isEmpty()) {
            return null;
        } else {
            for (Annotation annotation : set) {
                if (cls.equals(annotation.annotationType())) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(set);
                    linkedHashSet.remove(annotation);
                    return Collections.unmodifiableSet(linkedHashSet);
                }
            }
            return null;
        }
    }

    public static WildcardType subtypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new Util.WildcardTypeImpl(typeArr, Util.EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new Util.WildcardTypeImpl(new Type[]{Object.class}, typeArr);
    }

    public static String generatedJsonAdapterName(String str) {
        return str.replace("$", JavaConstant.Dynamic.DEFAULT_NAME) + "JsonAdapter";
    }
}
