package org.mockito.internal.util.reflection;

import datamodels.TypesAliasesKt;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Checks;

public abstract class GenericMetadataSupport {

    /* renamed from: a  reason: collision with root package name */
    public Map<TypeVariable<?>, Type> f63269a = new HashMap();

    public interface BoundedType extends Type {
        Type firstBound();

        Type[] interfaceBounds();
    }

    public static class FromClassGenericMetadataSupport extends GenericMetadataSupport {
        private final Class<?> clazz;

        public FromClassGenericMetadataSupport(Class<?> cls) {
            this.clazz = cls;
            d(cls.getTypeParameters());
            c(cls);
        }

        public Class<?> rawType() {
            return this.clazz;
        }
    }

    public static class FromParameterizedTypeGenericMetadataSupport extends GenericMetadataSupport {
        private final ParameterizedType parameterizedType;

        public FromParameterizedTypeGenericMetadataSupport(ParameterizedType parameterizedType2) {
            this.parameterizedType = parameterizedType2;
            readActualTypeParameters();
        }

        private void readActualTypeParameters() {
            c(this.parameterizedType);
        }

        public Class<?> rawType() {
            return (Class) this.parameterizedType.getRawType();
        }
    }

    public static class GenericArrayReturnType extends GenericMetadataSupport {
        private final int arity;
        private final GenericMetadataSupport genericArrayType;

        public GenericArrayReturnType(GenericMetadataSupport genericMetadataSupport, int i11) {
            this.genericArrayType = genericMetadataSupport;
            this.arity = i11;
        }

        public Class<?> rawType() {
            Class<?> rawType = this.genericArrayType.rawType();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < this.arity; i11++) {
                sb2.append("[");
            }
            try {
                sb2.append("L");
                sb2.append(rawType.getName());
                sb2.append(TypesAliasesKt.separator);
                return Class.forName(sb2.toString(), false, rawType.getClassLoader());
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("This was not supposed to happen.", e11);
            }
        }
    }

    public static class NotGenericReturnTypeSupport extends GenericMetadataSupport {
        private final Class<?> returnType;

        public NotGenericReturnTypeSupport(GenericMetadataSupport genericMetadataSupport, Type type) {
            Class<?> cls = (Class) type;
            this.returnType = cls;
            this.f63269a = genericMetadataSupport.f63269a;
            c(cls);
        }

        public Class<?> rawType() {
            return this.returnType;
        }
    }

    public static class ParameterizedReturnType extends GenericMetadataSupport {
        private final ParameterizedType parameterizedType;
        private final TypeVariable<?>[] typeParameters;

        public ParameterizedReturnType(GenericMetadataSupport genericMetadataSupport, TypeVariable<?>[] typeVariableArr, ParameterizedType parameterizedType2) {
            this.parameterizedType = parameterizedType2;
            this.typeParameters = typeVariableArr;
            this.f63269a = genericMetadataSupport.f63269a;
            readTypeParameters();
            readTypeVariables();
        }

        private void readTypeParameters() {
            d(this.typeParameters);
        }

        private void readTypeVariables() {
            e(this.parameterizedType);
        }

        public Class<?> rawType() {
            return (Class) this.parameterizedType.getRawType();
        }
    }

    public static class TypeVarBoundedType implements BoundedType {
        /* access modifiers changed from: private */
        public final TypeVariable<?> typeVariable;

        public TypeVarBoundedType(TypeVariable<?> typeVariable2) {
            this.typeVariable = typeVariable2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.typeVariable.equals(((TypeVarBoundedType) obj).typeVariable);
        }

        public Type firstBound() {
            return this.typeVariable.getBounds()[0];
        }

        public int hashCode() {
            return this.typeVariable.hashCode();
        }

        public Type[] interfaceBounds() {
            Type[] typeArr = new Type[(this.typeVariable.getBounds().length - 1)];
            System.arraycopy(this.typeVariable.getBounds(), 1, typeArr, 0, this.typeVariable.getBounds().length - 1);
            return typeArr;
        }

        public String toString() {
            return "{firstBound=" + firstBound() + ", interfaceBounds=" + Arrays.deepToString(interfaceBounds()) + AbstractJsonLexerKt.END_OBJ;
        }

        public TypeVariable<?> typeVariable() {
            return this.typeVariable;
        }
    }

    public static class TypeVariableReturnType extends GenericMetadataSupport {
        private List<Type> extraInterfaces;
        private Class<?> rawType;
        private final TypeVariable<?>[] typeParameters;
        private final TypeVariable<?> typeVariable;

        public TypeVariableReturnType(GenericMetadataSupport genericMetadataSupport, TypeVariable<?>[] typeVariableArr, TypeVariable<?> typeVariable2) {
            this.typeParameters = typeVariableArr;
            this.typeVariable = typeVariable2;
            this.f63269a = genericMetadataSupport.f63269a;
            readTypeParameters();
            readTypeVariables();
        }

        private Type extractActualBoundedTypeOf(Type type) {
            if (type instanceof TypeVariable) {
                return extractActualBoundedTypeOf(this.f63269a.get(type));
            }
            if (!(type instanceof BoundedType)) {
                return type;
            }
            Type extractActualBoundedTypeOf = extractActualBoundedTypeOf(((BoundedType) type).firstBound());
            if (!(extractActualBoundedTypeOf instanceof BoundedType)) {
                return type;
            }
            return extractActualBoundedTypeOf;
        }

        private void readTypeParameters() {
            d(this.typeParameters);
        }

        private void readTypeVariables() {
            for (Type e11 : this.typeVariable.getBounds()) {
                e(e11);
            }
            d(new TypeVariable[]{this.typeVariable});
            e(b(this.typeVariable));
        }

        public List<Type> extraInterfaces() {
            List<Type> list = this.extraInterfaces;
            if (list != null) {
                return list;
            }
            Type extractActualBoundedTypeOf = extractActualBoundedTypeOf(this.typeVariable);
            if (extractActualBoundedTypeOf instanceof BoundedType) {
                List<Type> asList = Arrays.asList(((BoundedType) extractActualBoundedTypeOf).interfaceBounds());
                this.extraInterfaces = asList;
                return asList;
            } else if (extractActualBoundedTypeOf instanceof ParameterizedType) {
                List<Type> singletonList = Collections.singletonList(extractActualBoundedTypeOf);
                this.extraInterfaces = singletonList;
                return singletonList;
            } else if (extractActualBoundedTypeOf instanceof Class) {
                List<Type> emptyList = Collections.emptyList();
                this.extraInterfaces = emptyList;
                return emptyList;
            } else {
                throw new MockitoException("Cannot extract extra-interfaces from '" + this.typeVariable + "' : '" + extractActualBoundedTypeOf + "'");
            }
        }

        public Class<?>[] rawExtraInterfaces() {
            List<Type> extraInterfaces2 = extraInterfaces();
            ArrayList arrayList = new ArrayList();
            for (Type a11 : extraInterfaces2) {
                Class<?> a12 = a(a11);
                if (!rawType().equals(a12)) {
                    arrayList.add(a12);
                }
            }
            return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
        }

        public Class<?> rawType() {
            if (this.rawType == null) {
                this.rawType = a(this.typeVariable);
            }
            return this.rawType;
        }
    }

    public static class WildCardBoundedType implements BoundedType {
        private final WildcardType wildcard;

        public WildCardBoundedType(WildcardType wildcardType) {
            this.wildcard = wildcardType;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.wildcard.equals(((TypeVarBoundedType) obj).typeVariable);
        }

        public Type firstBound() {
            Type[] lowerBounds = this.wildcard.getLowerBounds();
            Type[] upperBounds = this.wildcard.getUpperBounds();
            if (lowerBounds.length != 0) {
                return lowerBounds[0];
            }
            return upperBounds[0];
        }

        public int hashCode() {
            return this.wildcard.hashCode();
        }

        public Type[] interfaceBounds() {
            return new Type[0];
        }

        public String toString() {
            return "{firstBound=" + firstBound() + ", interfaceBounds=[]}";
        }

        public WildcardType wildCard() {
            return this.wildcard;
        }
    }

    private BoundedType boundsOf(TypeVariable<?> typeVariable) {
        if (typeVariable.getBounds()[0] instanceof TypeVariable) {
            return boundsOf((TypeVariable<?>) (TypeVariable) typeVariable.getBounds()[0]);
        }
        return new TypeVarBoundedType(typeVariable);
    }

    public static GenericMetadataSupport inferFrom(Type type) {
        Checks.checkNotNull(type, "type");
        if (type instanceof Class) {
            return new FromClassGenericMetadataSupport((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return new FromParameterizedTypeGenericMetadataSupport((ParameterizedType) type);
        }
        throw new MockitoException("Type meta-data for this Type (" + type.getClass().getCanonicalName() + ") is not supported : " + type);
    }

    private void registerTypeVariableIfNotPresent(TypeVariable<?> typeVariable) {
        if (!this.f63269a.containsKey(typeVariable)) {
            this.f63269a.put(typeVariable, boundsOf(typeVariable));
        }
    }

    private GenericMetadataSupport resolveGenericType(Type type, Method method) {
        if (type instanceof Class) {
            return new NotGenericReturnTypeSupport(this, type);
        }
        if (type instanceof ParameterizedType) {
            return new ParameterizedReturnType(this, method.getTypeParameters(), (ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            return new TypeVariableReturnType(this, method.getTypeParameters(), (TypeVariable) type);
        }
        throw new MockitoException("Ouch, it shouldn't happen, type '" + type.getClass().getCanonicalName() + "' on method : '" + method.toGenericString() + "' is not supported : " + type);
    }

    public Class<?> a(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof BoundedType) {
            return a(((BoundedType) type).firstBound());
        }
        if (type instanceof TypeVariable) {
            return a(this.f63269a.get(type));
        }
        throw new MockitoException("Raw extraction not supported for : '" + type + "'");
    }

    public Map<TypeVariable<?>, Type> actualTypeArguments() {
        TypeVariable[] typeParameters = rawType().getTypeParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TypeVariable typeVariable : typeParameters) {
            linkedHashMap.put(typeVariable, b(typeVariable));
        }
        return linkedHashMap;
    }

    public Type b(TypeVariable<?> typeVariable) {
        Type type = this.f63269a.get(typeVariable);
        if (type instanceof TypeVariable) {
            return b((TypeVariable) type);
        }
        return type;
    }

    public void c(Type type) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(type);
        while (!linkedList.isEmpty()) {
            Type type2 = (Type) linkedList.poll();
            if (type2 != null && !hashSet.contains(type2)) {
                e(type2);
                hashSet.add(type2);
                Class<?> a11 = a(type2);
                linkedList.add(a11.getGenericSuperclass());
                linkedList.addAll(Arrays.asList(a11.getGenericInterfaces()));
            }
        }
    }

    public void d(TypeVariable<?>[] typeVariableArr) {
        for (TypeVariable<?> registerTypeVariableIfNotPresent : typeVariableArr) {
            registerTypeVariableIfNotPresent(registerTypeVariableIfNotPresent);
        }
    }

    public void e(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                TypeVariable typeVariable = typeParameters[i11];
                Type type2 = actualTypeArguments[i11];
                if (type2 instanceof TypeVariable) {
                    registerTypeVariableIfNotPresent((TypeVariable) type2);
                    if (this.f63269a.containsKey(typeVariable)) {
                    }
                }
                if (type2 instanceof WildcardType) {
                    this.f63269a.put(typeVariable, boundsOf((WildcardType) type2));
                } else if (typeVariable != type2) {
                    this.f63269a.put(typeVariable, type2);
                }
            }
        }
    }

    public List<Type> extraInterfaces() {
        return Collections.emptyList();
    }

    public boolean hasRawExtraInterfaces() {
        return rawExtraInterfaces().length > 0;
    }

    public Class<?>[] rawExtraInterfaces() {
        return new Class[0];
    }

    public abstract Class<?> rawType();

    public GenericMetadataSupport resolveGenericReturnType(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        int i11 = 0;
        while (genericReturnType instanceof GenericArrayType) {
            i11++;
            genericReturnType = ((GenericArrayType) genericReturnType).getGenericComponentType();
        }
        GenericMetadataSupport resolveGenericType = resolveGenericType(genericReturnType, method);
        if (i11 == 0) {
            return resolveGenericType;
        }
        return new GenericArrayReturnType(resolveGenericType, i11);
    }

    private BoundedType boundsOf(WildcardType wildcardType) {
        WildCardBoundedType wildCardBoundedType = new WildCardBoundedType(wildcardType);
        return wildCardBoundedType.firstBound() instanceof TypeVariable ? boundsOf((TypeVariable<?>) (TypeVariable) wildCardBoundedType.firstBound()) : wildCardBoundedType;
    }
}
