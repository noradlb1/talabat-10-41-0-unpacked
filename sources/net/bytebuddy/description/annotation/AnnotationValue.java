package net.bytebuddy.description.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public interface AnnotationValue<T, S> {
    public static final AnnotationValue<?, ?> UNDEFINED = null;

    public static abstract class AbstractBase<U, V> implements AnnotationValue<U, V> {
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape) {
            return filter(inDefinedShape, inDefinedShape.getReturnType());
        }

        public <W> W resolve(Class<? extends W> cls) {
            return cls.cast(resolve());
        }
    }

    public static class ForAnnotationDescription<U extends Annotation> extends AbstractBase<AnnotationDescription, U> {
        private final AnnotationDescription annotationDescription;

        public static class Loaded<V extends Annotation> extends Loaded.AbstractBase<V> {
            private final V annotation;

            public Loaded(V v11) {
                this.annotation = v11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                if (!loaded.getState().isResolved() || !this.annotation.equals(loaded.resolve())) {
                    return false;
                }
                return true;
            }

            public State getState() {
                return State.RESOLVED;
            }

            public int hashCode() {
                return this.annotation.hashCode();
            }

            public boolean represents(Object obj) {
                return this.annotation.equals(obj);
            }

            public String toString() {
                return this.annotation.toString();
            }

            public V resolve() {
                return this.annotation;
            }
        }

        public ForAnnotationDescription(AnnotationDescription annotationDescription2) {
            this.annotationDescription = annotationDescription2;
        }

        public static <V extends Annotation> AnnotationValue<AnnotationDescription, V> of(TypeDescription typeDescription, Map<String, ? extends AnnotationValue<?, ?>> map) {
            return new ForAnnotationDescription(new AnnotationDescription.Latent(typeDescription, map));
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof AnnotationValue) && this.annotationDescription.equals(((AnnotationValue) obj).resolve()));
        }

        public AnnotationValue<AnnotationDescription, U> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            String str;
            if (typeDefinition.asErasure().equals(this.annotationDescription.getAnnotationType())) {
                return this;
            }
            if (inDefinedShape.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.ANNOTATION);
            } else {
                str = this.annotationDescription.toString();
            }
            return new ForMismatchedType(inDefinedShape, str);
        }

        public Sort getSort() {
            return Sort.ANNOTATION;
        }

        public State getState() {
            return State.RESOLVED;
        }

        public int hashCode() {
            return this.annotationDescription.hashCode();
        }

        public Loaded<U> load(ClassLoader classLoader) {
            try {
                AnnotationDescription annotationDescription2 = this.annotationDescription;
                return new Loaded(annotationDescription2.prepare(Class.forName(annotationDescription2.getAnnotationType().getName(), false, classLoader)).load());
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.annotationDescription.getAnnotationType().getName(), e11);
            }
        }

        public String toString() {
            return this.annotationDescription.toString();
        }

        public AnnotationDescription resolve() {
            return this.annotationDescription;
        }
    }

    public static class ForConstant<U> extends AbstractBase<U, U> {
        private transient /* synthetic */ int hashCode;
        private final PropertyDelegate propertyDelegate;
        private final U value;

        public static class Loaded<V> extends Loaded.AbstractBase<V> {
            private transient /* synthetic */ int hashCode;
            private final PropertyDelegate propertyDelegate;
            private final V value;

            public Loaded(V v11, PropertyDelegate propertyDelegate2) {
                this.value = v11;
                this.propertyDelegate = propertyDelegate2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                if (!loaded.getState().isResolved() || !this.propertyDelegate.equals(this.value, loaded.resolve())) {
                    return false;
                }
                return true;
            }

            public State getState() {
                return State.RESOLVED;
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : this.propertyDelegate.hashCode(this.value);
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean represents(Object obj) {
                return this.propertyDelegate.equals(this.value, obj);
            }

            public V resolve() {
                return this.propertyDelegate.copy(this.value);
            }

            public String toString() {
                return this.propertyDelegate.toString(this.value);
            }
        }

        public interface PropertyDelegate {

            public enum ForArrayType implements PropertyDelegate {
                BOOLEAN {
                    public Object a(Object obj) {
                        return ((boolean[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.BOOLEAN.toString(Boolean.valueOf(Array.getBoolean(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof boolean[]) && Arrays.equals((boolean[]) obj, (boolean[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((boolean[]) obj);
                    }
                },
                BYTE {
                    public Object a(Object obj) {
                        return ((byte[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.BYTE.toString(Byte.valueOf(Array.getByte(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof byte[]) && Arrays.equals((byte[]) obj, (byte[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((byte[]) obj);
                    }
                },
                SHORT {
                    public Object a(Object obj) {
                        return ((short[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.SHORT.toString(Short.valueOf(Array.getShort(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof short[]) && Arrays.equals((short[]) obj, (short[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((short[]) obj);
                    }
                },
                CHARACTER {
                    public Object a(Object obj) {
                        return ((char[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.CHARACTER.toString(Character.valueOf(Array.getChar(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof char[]) && Arrays.equals((char[]) obj, (char[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((char[]) obj);
                    }
                },
                INTEGER {
                    public Object a(Object obj) {
                        return ((int[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.INTEGER.toString(Integer.valueOf(Array.getInt(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof int[]) && Arrays.equals((int[]) obj, (int[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((int[]) obj);
                    }
                },
                LONG {
                    public Object a(Object obj) {
                        return ((long[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.LONG.toString(Long.valueOf(Array.getLong(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof long[]) && Arrays.equals((long[]) obj, (long[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((long[]) obj);
                    }
                },
                FLOAT {
                    public Object a(Object obj) {
                        return ((float[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.FLOAT.toString(Float.valueOf(Array.getFloat(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof float[]) && Arrays.equals((float[]) obj, (float[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((float[]) obj);
                    }
                },
                DOUBLE {
                    public Object a(Object obj) {
                        return ((double[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.DOUBLE.toString(Double.valueOf(Array.getDouble(obj, i11)));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof double[]) && Arrays.equals((double[]) obj, (double[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((double[]) obj);
                    }
                },
                STRING {
                    public Object a(Object obj) {
                        return ((String[]) obj).clone();
                    }

                    public String b(Object obj, int i11) {
                        return ForNonArrayType.STRING.toString(Array.get(obj, i11));
                    }

                    public boolean equals(Object obj, Object obj2) {
                        return (obj2 instanceof String[]) && Arrays.equals((String[]) obj, (String[]) obj2);
                    }

                    public int hashCode(Object obj) {
                        return Arrays.hashCode((String[]) obj);
                    }
                };

                public abstract Object a(Object obj);

                public abstract String b(Object obj, int i11);

                public <S> S copy(S s11) {
                    return a(s11);
                }

                public String toString(Object obj) {
                    ArrayList arrayList = new ArrayList(Array.getLength(obj));
                    for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
                        arrayList.add(b(obj, i11));
                    }
                    return RenderingDispatcher.CURRENT.toSourceString((List<?>) arrayList);
                }
            }

            public enum ForNonArrayType implements PropertyDelegate {
                BOOLEAN {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Boolean) obj).booleanValue());
                    }
                },
                BYTE {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Byte) obj).byteValue());
                    }
                },
                SHORT {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Short) obj).shortValue());
                    }
                },
                CHARACTER {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Character) obj).charValue());
                    }
                },
                INTEGER {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Integer) obj).intValue());
                    }
                },
                LONG {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Long) obj).longValue());
                    }
                },
                FLOAT {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Float) obj).floatValue());
                    }
                },
                DOUBLE {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Double) obj).doubleValue());
                    }
                },
                STRING {
                    public String toString(Object obj) {
                        return RenderingDispatcher.CURRENT.toSourceString((String) obj);
                    }
                };

                public <S> S copy(S s11) {
                    return s11;
                }

                public boolean equals(Object obj, Object obj2) {
                    return obj.equals(obj2);
                }

                public int hashCode(Object obj) {
                    return obj.hashCode();
                }
            }

            <S> S copy(S s11);

            boolean equals(Object obj, Object obj2);

            int hashCode(Object obj);

            String toString(Object obj);
        }

        public ForConstant(U u11, PropertyDelegate propertyDelegate2) {
            this.value = u11;
            this.propertyDelegate = propertyDelegate2;
        }

        public static AnnotationValue<Boolean, Boolean> of(boolean z11) {
            return new ForConstant(Boolean.valueOf(z11), PropertyDelegate.ForNonArrayType.BOOLEAN);
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof AnnotationValue) && this.propertyDelegate.equals(this.value, ((AnnotationValue) obj).resolve()));
        }

        public AnnotationValue<U, U> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            if (typeDefinition.asErasure().asBoxed().represents(this.value.getClass())) {
                return this;
            }
            if (this.value.getClass().isArray()) {
                return new ForMismatchedType(inDefinedShape, RenderingDispatcher.CURRENT.toArrayErrorString(Sort.of(TypeDescription.ForLoadedType.of(this.value.getClass().getComponentType()))));
            }
            if (this.value instanceof Enum) {
                return new ForMismatchedType(inDefinedShape, this.value.getClass().getName() + '.' + ((Enum) this.value).name());
            }
            return new ForMismatchedType(inDefinedShape, RenderingDispatcher.CURRENT.toTypeErrorString(this.value.getClass()) + '[' + this.value + AbstractJsonLexerKt.END_LIST);
        }

        public Sort getSort() {
            return Sort.of(TypeDescription.ForLoadedType.of(this.value.getClass()).asUnboxed());
        }

        public State getState() {
            return State.RESOLVED;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : this.propertyDelegate.hashCode(this.value);
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public Loaded<U> load(ClassLoader classLoader) {
            return new Loaded(this.value, this.propertyDelegate);
        }

        public U resolve() {
            return this.value;
        }

        public String toString() {
            return this.propertyDelegate.toString(this.value);
        }

        public static AnnotationValue<Byte, Byte> of(byte b11) {
            return new ForConstant(Byte.valueOf(b11), PropertyDelegate.ForNonArrayType.BYTE);
        }

        public static AnnotationValue<Short, Short> of(short s11) {
            return new ForConstant(Short.valueOf(s11), PropertyDelegate.ForNonArrayType.SHORT);
        }

        public static AnnotationValue<Character, Character> of(char c11) {
            return new ForConstant(Character.valueOf(c11), PropertyDelegate.ForNonArrayType.CHARACTER);
        }

        public static AnnotationValue<Integer, Integer> of(int i11) {
            return new ForConstant(Integer.valueOf(i11), PropertyDelegate.ForNonArrayType.INTEGER);
        }

        public static AnnotationValue<Long, Long> of(long j11) {
            return new ForConstant(Long.valueOf(j11), PropertyDelegate.ForNonArrayType.LONG);
        }

        public static AnnotationValue<Float, Float> of(float f11) {
            return new ForConstant(Float.valueOf(f11), PropertyDelegate.ForNonArrayType.FLOAT);
        }

        public static AnnotationValue<Double, Double> of(double d11) {
            return new ForConstant(Double.valueOf(d11), PropertyDelegate.ForNonArrayType.DOUBLE);
        }

        public static AnnotationValue<String, String> of(String str) {
            return new ForConstant(str, PropertyDelegate.ForNonArrayType.STRING);
        }

        public static AnnotationValue<boolean[], boolean[]> of(boolean... zArr) {
            return new ForConstant(zArr, PropertyDelegate.ForArrayType.BOOLEAN);
        }

        public static AnnotationValue<byte[], byte[]> of(byte... bArr) {
            return new ForConstant(bArr, PropertyDelegate.ForArrayType.BYTE);
        }

        public static AnnotationValue<short[], short[]> of(short... sArr) {
            return new ForConstant(sArr, PropertyDelegate.ForArrayType.SHORT);
        }

        public static AnnotationValue<char[], char[]> of(char... cArr) {
            return new ForConstant(cArr, PropertyDelegate.ForArrayType.CHARACTER);
        }

        public static AnnotationValue<int[], int[]> of(int... iArr) {
            return new ForConstant(iArr, PropertyDelegate.ForArrayType.INTEGER);
        }

        public static AnnotationValue<long[], long[]> of(long... jArr) {
            return new ForConstant(jArr, PropertyDelegate.ForArrayType.LONG);
        }

        public static AnnotationValue<float[], float[]> of(float... fArr) {
            return new ForConstant(fArr, PropertyDelegate.ForArrayType.FLOAT);
        }

        public static AnnotationValue<double[], double[]> of(double... dArr) {
            return new ForConstant(dArr, PropertyDelegate.ForArrayType.DOUBLE);
        }

        public static AnnotationValue<String[], String[]> of(String... strArr) {
            return new ForConstant(strArr, PropertyDelegate.ForArrayType.STRING);
        }

        public static AnnotationValue<?, ?> of(Object obj) {
            if (obj instanceof Boolean) {
                return of(((Boolean) obj).booleanValue());
            }
            if (obj instanceof Byte) {
                return of(((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return of(((Short) obj).shortValue());
            }
            if (obj instanceof Character) {
                return of(((Character) obj).charValue());
            }
            if (obj instanceof Integer) {
                return of(((Integer) obj).intValue());
            }
            if (obj instanceof Long) {
                return of(((Long) obj).longValue());
            }
            if (obj instanceof Float) {
                return of(((Float) obj).floatValue());
            }
            if (obj instanceof Double) {
                return of(((Double) obj).doubleValue());
            }
            if (obj instanceof String) {
                return of((String) obj);
            }
            if (obj instanceof boolean[]) {
                return of((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return of((byte[]) obj);
            }
            if (obj instanceof short[]) {
                return of((short[]) obj);
            }
            if (obj instanceof char[]) {
                return of((char[]) obj);
            }
            if (obj instanceof int[]) {
                return of((int[]) obj);
            }
            if (obj instanceof long[]) {
                return of((long[]) obj);
            }
            if (obj instanceof float[]) {
                return of((float[]) obj);
            }
            if (obj instanceof double[]) {
                return of((double[]) obj);
            }
            if (obj instanceof String[]) {
                return of((String[]) obj);
            }
            throw new IllegalArgumentException("Not a constant annotation value: " + obj);
        }
    }

    public static class ForEnumerationDescription<U extends Enum<U>> extends AbstractBase<EnumerationDescription, U> {
        private final EnumerationDescription enumerationDescription;

        public static class Loaded<V extends Enum<V>> extends Loaded.AbstractBase<V> {
            private final V enumeration;

            public static class WithIncompatibleRuntimeType extends Loaded.AbstractBase<Enum<?>> {
                private final Class<?> type;

                public WithIncompatibleRuntimeType(Class<?> cls) {
                    this.type = cls;
                }

                public State getState() {
                    return State.UNRESOLVED;
                }

                public boolean represents(Object obj) {
                    return false;
                }

                public Enum<?> resolve() {
                    throw new IncompatibleClassChangeError("Not an enumeration type: " + this.type.toString());
                }
            }

            public Loaded(V v11) {
                this.enumeration = v11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                if (!loaded.getState().isResolved() || !this.enumeration.equals(loaded.resolve())) {
                    return false;
                }
                return true;
            }

            public State getState() {
                return State.RESOLVED;
            }

            public int hashCode() {
                return this.enumeration.hashCode();
            }

            public boolean represents(Object obj) {
                return this.enumeration.equals(obj);
            }

            public String toString() {
                return this.enumeration.toString();
            }

            public V resolve() {
                return this.enumeration;
            }
        }

        public static class WithUnknownConstant<U extends Enum<U>> extends AbstractBase<EnumerationDescription, U> {
            private final TypeDescription typeDescription;
            private final String value;

            public static class Loaded extends Loaded.AbstractBase.ForUnresolvedProperty<Enum<?>> {
                private final Class<? extends Enum<?>> enumType;
                private final String value;

                public Loaded(Class<? extends Enum<?>> cls, String str) {
                    this.enumType = cls;
                    this.value = str;
                }

                public String toString() {
                    return this.value + " /* Warning: constant not present! */";
                }

                public Enum<?> resolve() {
                    throw new EnumConstantNotPresentException(this.enumType, this.value);
                }
            }

            public WithUnknownConstant(TypeDescription typeDescription2, String str) {
                this.typeDescription = typeDescription2;
                this.value = str;
            }

            public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
                return this;
            }

            public Sort getSort() {
                return Sort.NONE;
            }

            public State getState() {
                return State.UNRESOLVED;
            }

            public Loaded<U> load(ClassLoader classLoader) {
                try {
                    return new Loaded(Class.forName(this.typeDescription.getName(), false, classLoader), this.value);
                } catch (ClassNotFoundException e11) {
                    return new ForMissingType.Loaded(this.typeDescription.getName(), e11);
                }
            }

            public String toString() {
                return this.value + " /* Warning: constant not present! */";
            }

            public EnumerationDescription resolve() {
                throw new IllegalStateException(this.typeDescription + " does not declare enumeration constant " + this.value);
            }
        }

        public ForEnumerationDescription(EnumerationDescription enumerationDescription2) {
            this.enumerationDescription = enumerationDescription2;
        }

        public static <V extends Enum<V>> AnnotationValue<EnumerationDescription, V> of(EnumerationDescription enumerationDescription2) {
            return new ForEnumerationDescription(enumerationDescription2);
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof AnnotationValue) && this.enumerationDescription.equals(((AnnotationValue) obj).resolve()));
        }

        public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            String str;
            if (typeDefinition.asErasure().equals(this.enumerationDescription.getEnumerationType())) {
                return this;
            }
            if (inDefinedShape.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.ENUMERATION);
            } else {
                str = this.enumerationDescription.getEnumerationType().getName() + '.' + this.enumerationDescription.getValue();
            }
            return new ForMismatchedType(inDefinedShape, str);
        }

        public Sort getSort() {
            return Sort.ENUMERATION;
        }

        public State getState() {
            return State.RESOLVED;
        }

        public int hashCode() {
            return this.enumerationDescription.hashCode();
        }

        public Loaded<U> load(ClassLoader classLoader) {
            try {
                EnumerationDescription enumerationDescription2 = this.enumerationDescription;
                return new Loaded(enumerationDescription2.load(Class.forName(enumerationDescription2.getEnumerationType().getName(), false, classLoader)));
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.enumerationDescription.getEnumerationType().getName(), e11);
            }
        }

        public String toString() {
            return this.enumerationDescription.toString();
        }

        public EnumerationDescription resolve() {
            return this.enumerationDescription;
        }
    }

    public static class ForIncompatibleType<U, V> extends AbstractBase<U, V> {
        private final TypeDescription typeDescription;

        public static class Loaded<W> extends Loaded.AbstractBase.ForUnresolvedProperty<W> {
            private final Class<?> type;

            public Loaded(Class<?> cls) {
                this.type = cls;
            }

            public W resolve() {
                throw new IncompatibleClassChangeError(this.type.toString());
            }

            public String toString() {
                return "/* Warning type incompatibility! \"" + this.type.getName() + "\" */";
            }
        }

        public ForIncompatibleType(TypeDescription typeDescription2) {
            this.typeDescription = typeDescription2;
        }

        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            return this;
        }

        public Sort getSort() {
            return Sort.NONE;
        }

        public State getState() {
            return State.UNRESOLVED;
        }

        public Loaded<V> load(ClassLoader classLoader) {
            try {
                return new Loaded(Class.forName(this.typeDescription.getName(), false, classLoader));
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), e11);
            }
        }

        public U resolve() {
            throw new IllegalStateException("Property is defined with an incompatible runtime type: " + this.typeDescription);
        }

        public String toString() {
            return "/* Warning type incompatibility! \"" + this.typeDescription.getName() + "\" */";
        }
    }

    public static class ForMismatchedType<U, V> extends AbstractBase<U, V> {
        private final MethodDescription.InDefinedShape property;
        private final String value;

        public static class Loaded<W> extends Loaded.AbstractBase.ForUnresolvedProperty<W> {
            private final Method property;
            private final String value;

            public Loaded(Method method, String str) {
                this.property = method;
                this.value = str;
            }

            public W resolve() {
                throw new AnnotationTypeMismatchException(this.property, this.value);
            }

            public String toString() {
                return "/* Warning type mismatch! \"" + this.value + "\" */";
            }
        }

        public ForMismatchedType(MethodDescription.InDefinedShape inDefinedShape, String str) {
            this.property = inDefinedShape;
            this.value = str;
        }

        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            return new ForMismatchedType(inDefinedShape, this.value);
        }

        public Sort getSort() {
            return Sort.NONE;
        }

        public State getState() {
            return State.UNRESOLVED;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
            return new net.bytebuddy.description.annotation.AnnotationValue.ForIncompatibleType.Loaded(r4);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0023 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.description.annotation.AnnotationValue.Loaded<V> load(java.lang.ClassLoader r4) {
            /*
                r3 = this;
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = r3.property     // Catch:{ ClassNotFoundException -> 0x0029 }
                net.bytebuddy.description.type.TypeDescription r0 = r0.getDeclaringType()     // Catch:{ ClassNotFoundException -> 0x0029 }
                java.lang.String r0 = r0.getName()     // Catch:{ ClassNotFoundException -> 0x0029 }
                r1 = 0
                java.lang.Class r4 = java.lang.Class.forName(r0, r1, r4)     // Catch:{ ClassNotFoundException -> 0x0029 }
                net.bytebuddy.description.annotation.AnnotationValue$ForMismatchedType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForMismatchedType$Loaded     // Catch:{ NoSuchMethodException -> 0x0023 }
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = r3.property     // Catch:{ NoSuchMethodException -> 0x0023 }
                java.lang.String r2 = r2.getName()     // Catch:{ NoSuchMethodException -> 0x0023 }
                java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0023 }
                java.lang.reflect.Method r1 = r4.getMethod(r2, r1)     // Catch:{ NoSuchMethodException -> 0x0023 }
                java.lang.String r2 = r3.value     // Catch:{ NoSuchMethodException -> 0x0023 }
                r0.<init>(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0023 }
                return r0
            L_0x0023:
                net.bytebuddy.description.annotation.AnnotationValue$ForIncompatibleType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForIncompatibleType$Loaded     // Catch:{ ClassNotFoundException -> 0x0029 }
                r0.<init>(r4)     // Catch:{ ClassNotFoundException -> 0x0029 }
                return r0
            L_0x0029:
                r4 = move-exception
                net.bytebuddy.description.annotation.AnnotationValue$ForMissingType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForMissingType$Loaded
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = r3.property
                net.bytebuddy.description.type.TypeDescription r1 = r1.getDeclaringType()
                java.lang.String r1 = r1.getName()
                r0.<init>(r1, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.annotation.AnnotationValue.ForMismatchedType.load(java.lang.ClassLoader):net.bytebuddy.description.annotation.AnnotationValue$Loaded");
        }

        public U resolve() {
            throw new IllegalStateException(this.value + " cannot be used as value for " + this.property);
        }

        public String toString() {
            return "/* Warning type mismatch! \"" + this.value + "\" */";
        }
    }

    public static class ForMissingType<U, V> extends AbstractBase<U, V> {
        private final String typeName;

        public static class Loaded<U> extends Loaded.AbstractBase.ForUnresolvedProperty<U> {
            private final ClassNotFoundException exception;
            private final String typeName;

            public Loaded(String str, ClassNotFoundException classNotFoundException) {
                this.typeName = str;
                this.exception = classNotFoundException;
            }

            public U resolve() {
                throw new TypeNotPresentException(this.typeName, this.exception);
            }

            public String toString() {
                return this.typeName + ".class /* Warning: type not present! */";
            }
        }

        public ForMissingType(String str) {
            this.typeName = str;
        }

        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            return this;
        }

        public Sort getSort() {
            return Sort.NONE;
        }

        public State getState() {
            return State.UNRESOLVED;
        }

        public Loaded<V> load(ClassLoader classLoader) {
            return new Loaded(this.typeName, new ClassNotFoundException(this.typeName));
        }

        public U resolve() {
            throw new IllegalStateException("Type not found: " + this.typeName);
        }

        public String toString() {
            return this.typeName + ".class /* Warning: type not present! */";
        }
    }

    public static class ForMissingValue<U, V> extends AbstractBase<U, V> {
        private final String property;
        private final TypeDescription typeDescription;

        public static class Loaded<W> extends Loaded.AbstractBase<W> {
            private final String property;
            private final Class<? extends Annotation> type;

            public Loaded(Class<? extends Annotation> cls, String str) {
                this.type = cls;
                this.property = str;
            }

            public State getState() {
                return State.UNDEFINED;
            }

            public boolean represents(Object obj) {
                return false;
            }

            public W resolve() {
                throw new IncompleteAnnotationException(this.type, this.property);
            }
        }

        public ForMissingValue(TypeDescription typeDescription2, String str) {
            this.typeDescription = typeDescription2;
            this.property = str;
        }

        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            return this;
        }

        public Sort getSort() {
            return Sort.NONE;
        }

        public State getState() {
            return State.UNDEFINED;
        }

        public Loaded<V> load(ClassLoader classLoader) {
            try {
                Class<?> cls = Class.forName(this.typeDescription.getName(), false, classLoader);
                if (cls.isAnnotation()) {
                    return new Loaded(cls, this.property);
                }
                return new ForIncompatibleType.Loaded(cls);
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), e11);
            }
        }

        public U resolve() {
            throw new IllegalStateException(this.typeDescription + " does not define " + this.property);
        }
    }

    public static class ForTypeDescription<U extends Class<U>> extends AbstractBase<TypeDescription, U> {
        private static final boolean NO_INITIALIZATION = false;
        private static final Map<TypeDescription, Class<?>> PRIMITIVE_TYPES = new HashMap();
        private final TypeDescription typeDescription;

        public static class Loaded<U extends Class<U>> extends Loaded.AbstractBase<U> {
            private final U type;

            public Loaded(U u11) {
                this.type = u11;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                if (!loaded.getState().isResolved() || !this.type.equals(loaded.resolve())) {
                    return false;
                }
                return true;
            }

            public State getState() {
                return State.RESOLVED;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public boolean represents(Object obj) {
                return this.type.equals(obj);
            }

            public String toString() {
                return RenderingDispatcher.CURRENT.toSourceString(TypeDescription.ForLoadedType.of(this.type));
            }

            public U resolve() {
                return this.type;
            }
        }

        static {
            Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            for (int i11 = 0; i11 < 9; i11++) {
                Class cls = clsArr[i11];
                PRIMITIVE_TYPES.put(TypeDescription.ForLoadedType.of(cls), cls);
            }
        }

        public ForTypeDescription(TypeDescription typeDescription2) {
            this.typeDescription = typeDescription2;
        }

        public static <V extends Class<V>> AnnotationValue<TypeDescription, V> of(TypeDescription typeDescription2) {
            return new ForTypeDescription(typeDescription2);
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof AnnotationValue) && this.typeDescription.equals(((AnnotationValue) obj).resolve()));
        }

        public AnnotationValue<TypeDescription, U> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            String str;
            Class<Class> cls = Class.class;
            if (typeDefinition.asErasure().represents(cls)) {
                return this;
            }
            if (inDefinedShape.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.TYPE);
            } else {
                str = cls.getName() + '[' + this.typeDescription.getName() + AbstractJsonLexerKt.END_LIST;
            }
            return new ForMismatchedType(inDefinedShape, str);
        }

        public Sort getSort() {
            return Sort.TYPE;
        }

        public State getState() {
            return State.RESOLVED;
        }

        public int hashCode() {
            return this.typeDescription.hashCode();
        }

        public Loaded<U> load(ClassLoader classLoader) {
            Class<?> cls;
            try {
                if (this.typeDescription.isPrimitive()) {
                    cls = PRIMITIVE_TYPES.get(this.typeDescription);
                } else {
                    cls = Class.forName(this.typeDescription.getName(), false, classLoader);
                }
                return new Loaded(cls);
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), e11);
            }
        }

        public String toString() {
            return RenderingDispatcher.CURRENT.toSourceString(this.typeDescription);
        }

        public TypeDescription resolve() {
            return this.typeDescription;
        }
    }

    public interface Loaded<U> {

        public static abstract class AbstractBase<W> implements Loaded<W> {

            public static abstract class ForUnresolvedProperty<Z> extends AbstractBase<Z> {
                public State getState() {
                    return State.UNRESOLVED;
                }

                public boolean represents(Object obj) {
                    return false;
                }
            }

            public <X> X resolve(Class<? extends X> cls) {
                return cls.cast(resolve());
            }
        }

        State getState();

        boolean represents(Object obj);

        U resolve();

        <V> V resolve(Class<? extends V> cls);
    }

    public enum RenderingDispatcher {
        LEGACY_VM('[', AbstractJsonLexerKt.END_LIST, true) {
            public String toSourceString(char c11) {
                return Character.toString(c11);
            }

            public String toSourceString(String str) {
                return str;
            }

            public String toSourceString(long j11) {
                return Long.toString(j11);
            }

            public String toSourceString(float f11) {
                return Float.toString(f11);
            }

            public String toSourceString(double d11) {
                return Double.toString(d11);
            }

            public String toSourceString(TypeDescription typeDescription) {
                return typeDescription.toString();
            }
        },
        JAVA_9_CAPABLE_VM(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ, true) {
            public String toSourceString(char c11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\'');
                if (c11 == '\'') {
                    sb2.append("\\'");
                } else {
                    sb2.append(c11);
                }
                sb2.append('\'');
                return sb2.toString();
            }

            public String toSourceString(long j11) {
                if (Math.abs(j11) <= 2147483647L) {
                    return String.valueOf(j11);
                }
                return j11 + "L";
            }

            public String toSourceString(float f11) {
                if (Math.abs(f11) <= Float.MAX_VALUE) {
                    return f11 + "f";
                } else if (Float.isInfinite(f11)) {
                    return f11 < 0.0f ? "-1.0f/0.0f" : "1.0f/0.0f";
                } else {
                    return "0.0f/0.0f";
                }
            }

            public String toSourceString(double d11) {
                if (Math.abs(d11) <= Double.MAX_VALUE) {
                    return Double.toString(d11);
                }
                if (Double.isInfinite(d11)) {
                    return d11 < 0.0d ? "-1.0/0.0" : "1.0/0.0";
                }
                return "0.0/0.0";
            }

            public String toSourceString(String str) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\"");
                if (str.indexOf(34) != -1) {
                    str = str.replace("\"", "\\\"");
                }
                sb2.append(str);
                sb2.append("\"");
                return sb2.toString();
            }

            public String toSourceString(TypeDescription typeDescription) {
                return typeDescription.getActualName() + ".class";
            }
        },
        JAVA_14_CAPABLE_VM(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ, r3.isLessThan(r4)) {
            public String toSourceString(byte b11) {
                return "(byte)0x" + Integer.toHexString(b11 & 255);
            }

            public String toSourceString(char c11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\'');
                if (c11 == '\'') {
                    sb2.append("\\'");
                } else {
                    sb2.append(c11);
                }
                sb2.append('\'');
                return sb2.toString();
            }

            public String toSourceString(long j11) {
                return j11 + "L";
            }

            public String toSourceString(float f11) {
                if (Math.abs(f11) <= Float.MAX_VALUE) {
                    return f11 + "f";
                } else if (Float.isInfinite(f11)) {
                    return f11 < 0.0f ? "-1.0f/0.0f" : "1.0f/0.0f";
                } else {
                    return "0.0f/0.0f";
                }
            }

            public String toSourceString(double d11) {
                if (Math.abs(d11) <= Double.MAX_VALUE) {
                    return Double.toString(d11);
                }
                if (Double.isInfinite(d11)) {
                    return d11 < 0.0d ? "-1.0/0.0" : "1.0/0.0";
                }
                return "0.0/0.0";
            }

            public String toSourceString(String str) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\"");
                if (str.indexOf(34) != -1) {
                    str = str.replace("\"", "\\\"");
                }
                sb2.append(str);
                sb2.append("\"");
                return sb2.toString();
            }

            public String toSourceString(TypeDescription typeDescription) {
                return typeDescription.getActualName() + ".class";
            }
        },
        JAVA_17_CAPABLE_VM(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ, ClassFileVersion.ofThisVm(r2).isLessThan(r4)) {
            public String toSourceString(byte b11) {
                return "(byte)0x" + Integer.toHexString(b11 & 255);
            }

            public String toTypeErrorString(Class<?> cls) {
                return cls.getName();
            }

            public String toSourceString(char c11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\'');
                if (c11 == '\'') {
                    sb2.append("\\'");
                } else {
                    sb2.append(c11);
                }
                sb2.append('\'');
                return sb2.toString();
            }

            public String toSourceString(long j11) {
                return j11 + "L";
            }

            public String toSourceString(float f11) {
                if (Math.abs(f11) <= Float.MAX_VALUE) {
                    return f11 + "f";
                } else if (Float.isInfinite(f11)) {
                    return f11 < 0.0f ? "-1.0f/0.0f" : "1.0f/0.0f";
                } else {
                    return "0.0f/0.0f";
                }
            }

            public String toSourceString(double d11) {
                if (Math.abs(d11) <= Double.MAX_VALUE) {
                    return Double.toString(d11);
                }
                if (Double.isInfinite(d11)) {
                    return d11 < 0.0d ? "-1.0/0.0" : "1.0/0.0";
                }
                return "0.0/0.0";
            }

            public String toSourceString(String str) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\"");
                if (str.indexOf(34) != -1) {
                    str = str.replace("\"", "\\\"");
                }
                sb2.append(str);
                sb2.append("\"");
                return sb2.toString();
            }

            public String toSourceString(TypeDescription typeDescription) {
                return typeDescription.getActualName() + ".class";
            }
        };
        
        private static final String ARRAY_PREFIX = "Array with component tag: ";
        public static final RenderingDispatcher CURRENT = null;
        private final char closingBrace;
        private final boolean componentAsInteger;
        private final char openingBrace;

        /* access modifiers changed from: public */
        static {
            AnonymousClass1 r02;
            AnonymousClass2 r72;
            ClassFileVersion classFileVersion;
            ClassFileVersion classFileVersion2;
            AnonymousClass3 r13;
            AnonymousClass4 r73;
            ClassFileVersion ofThisVm = ClassFileVersion.ofThisVm(classFileVersion);
            if (ofThisVm.isAtLeast(classFileVersion2)) {
                CURRENT = r73;
            } else if (ofThisVm.isAtLeast(ClassFileVersion.JAVA_V14)) {
                CURRENT = r13;
            } else if (ofThisVm.isAtLeast(ClassFileVersion.JAVA_V9)) {
                CURRENT = r72;
            } else {
                CURRENT = r02;
            }
        }

        public String toArrayErrorString(Sort sort) {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ARRAY_PREFIX);
            if (this.componentAsInteger || !sort.isDefined()) {
                str = Integer.toString(sort.a());
            } else {
                str = Character.toString((char) sort.a());
            }
            sb2.append(str);
            return sb2.toString();
        }

        public abstract String toSourceString(char c11);

        public abstract String toSourceString(double d11);

        public abstract String toSourceString(float f11);

        public abstract String toSourceString(long j11);

        public abstract String toSourceString(String str);

        public abstract String toSourceString(TypeDescription typeDescription);

        public String toSourceString(boolean z11) {
            return Boolean.toString(z11);
        }

        public String toTypeErrorString(Class<?> cls) {
            return cls.toString();
        }

        private RenderingDispatcher(char c11, char c12, boolean z11) {
            this.openingBrace = c11;
            this.closingBrace = c12;
            this.componentAsInteger = z11;
        }

        public String toSourceString(byte b11) {
            return Byte.toString(b11);
        }

        public String toSourceString(short s11) {
            return Short.toString(s11);
        }

        public String toSourceString(int i11) {
            return Integer.toString(i11);
        }

        public String toSourceString(List<?> list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.openingBrace);
            boolean z11 = true;
            for (Object next : list) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next);
            }
            sb2.append(this.closingBrace);
            return sb2.toString();
        }
    }

    public enum Sort {
        BOOLEAN(90),
        BYTE(66),
        SHORT(83),
        CHARACTER(67),
        INTEGER(73),
        LONG(74),
        FLOAT(70),
        DOUBLE(68),
        STRING(115),
        TYPE(99),
        ENUMERATION(101),
        ANNOTATION(64),
        ARRAY(91),
        NONE(0);
        
        private final int tag;

        private Sort(int i11) {
            this.tag = i11;
        }

        public static Sort of(TypeDefinition typeDefinition) {
            if (typeDefinition.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDefinition.represents(Byte.TYPE)) {
                return BYTE;
            }
            if (typeDefinition.represents(Short.TYPE)) {
                return SHORT;
            }
            if (typeDefinition.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDefinition.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDefinition.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDefinition.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDefinition.represents(Double.TYPE)) {
                return DOUBLE;
            }
            if (typeDefinition.represents(String.class)) {
                return STRING;
            }
            if (typeDefinition.represents(Class.class)) {
                return TYPE;
            }
            if (typeDefinition.isEnum()) {
                return ENUMERATION;
            }
            if (typeDefinition.isAnnotation()) {
                return ANNOTATION;
            }
            if (typeDefinition.isArray()) {
                return ARRAY;
            }
            return NONE;
        }

        public int a() {
            return this.tag;
        }

        public boolean isDefined() {
            return this != NONE;
        }
    }

    public enum State {
        UNDEFINED,
        UNRESOLVED,
        RESOLVED;

        public boolean isDefined() {
            return this != UNDEFINED;
        }

        public boolean isResolved() {
            return this == RESOLVED;
        }
    }

    AnnotationValue<T, S> filter(MethodDescription.InDefinedShape inDefinedShape);

    AnnotationValue<T, S> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition);

    Sort getSort();

    State getState();

    Loaded<S> load(ClassLoader classLoader);

    T resolve();

    <W> W resolve(Class<? extends W> cls);

    public static class ForDescriptionArray<U, V> extends AbstractBase<U, V> {
        private final TypeDescription componentType;
        private transient /* synthetic */ int hashCode;
        private final Class<?> unloadedComponentType;
        private final List<? extends AnnotationValue<?, ?>> values;

        public static class Loaded<W> extends Loaded.AbstractBase<W> {
            private final Class<W> componentType;
            private transient /* synthetic */ int hashCode;
            private final List<Loaded<?>> values;

            public Loaded(Class<W> cls, List<Loaded<?>> list) {
                this.componentType = cls;
                this.values = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                if (!loaded.getState().isResolved()) {
                    return false;
                }
                Object resolve = loaded.resolve();
                if (!(resolve instanceof Object[])) {
                    return false;
                }
                Object[] objArr = (Object[]) resolve;
                if (this.values.size() != objArr.length) {
                    return false;
                }
                Iterator<Loaded<?>> it = this.values.iterator();
                for (Object obj2 : objArr) {
                    Loaded next = it.next();
                    if (!next.getState().isResolved() || !next.resolve().equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }

            public State getState() {
                for (Loaded<?> state : this.values) {
                    if (!state.getState().isResolved()) {
                        return State.UNRESOLVED;
                    }
                }
                return State.RESOLVED;
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i11;
                if (this.hashCode != 0) {
                    i11 = 0;
                } else {
                    int i12 = 1;
                    for (Loaded<?> hashCode2 : this.values) {
                        i12 = (i12 * 31) + hashCode2.hashCode();
                    }
                    i11 = i12;
                }
                if (i11 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i11;
                return i11;
            }

            public boolean represents(Object obj) {
                if (!(obj instanceof Object[]) || obj.getClass().getComponentType() != this.componentType) {
                    return false;
                }
                Object[] objArr = (Object[]) obj;
                if (this.values.size() != objArr.length) {
                    return false;
                }
                Iterator<Loaded<?>> it = this.values.iterator();
                for (Object represents : objArr) {
                    if (!it.next().represents(represents)) {
                        return false;
                    }
                }
                return true;
            }

            public W resolve() {
                W newInstance = Array.newInstance(this.componentType, this.values.size());
                int i11 = 0;
                for (Loaded<?> resolve : this.values) {
                    Array.set(newInstance, i11, resolve.resolve());
                    i11++;
                }
                return newInstance;
            }

            public String toString() {
                return RenderingDispatcher.CURRENT.toSourceString((List<?>) this.values);
            }
        }

        public ForDescriptionArray(Class<?> cls, TypeDescription typeDescription, List<? extends AnnotationValue<?, ?>> list) {
            this.unloadedComponentType = cls;
            this.componentType = typeDescription;
            this.values = list;
        }

        public static <W extends Enum<W>> AnnotationValue<EnumerationDescription[], W[]> of(TypeDescription typeDescription, EnumerationDescription[] enumerationDescriptionArr) {
            ArrayList arrayList = new ArrayList(enumerationDescriptionArr.length);
            int length = enumerationDescriptionArr.length;
            int i11 = 0;
            while (i11 < length) {
                EnumerationDescription enumerationDescription = enumerationDescriptionArr[i11];
                if (enumerationDescription.getEnumerationType().equals(typeDescription)) {
                    arrayList.add(ForEnumerationDescription.of(enumerationDescription));
                    i11++;
                } else {
                    throw new IllegalArgumentException(enumerationDescription + " is not of " + typeDescription);
                }
            }
            return new ForDescriptionArray(EnumerationDescription.class, typeDescription, arrayList);
        }

        public boolean equals(Object obj) {
            Object resolve;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnnotationValue) || (resolve = ((AnnotationValue) obj).resolve()) == null || !resolve.getClass().isArray() || this.values.size() != Array.getLength(resolve)) {
                return false;
            }
            Iterator<? extends AnnotationValue<?, ?>> it = this.values.iterator();
            for (int i11 = 0; i11 < this.values.size(); i11++) {
                if (!((AnnotationValue) it.next()).resolve().equals(Array.get(resolve, i11))) {
                    return false;
                }
            }
            return true;
        }

        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
            if (!typeDefinition.isArray() || !typeDefinition.getComponentType().asErasure().equals(this.componentType)) {
                return new ForMismatchedType(inDefinedShape, RenderingDispatcher.CURRENT.toArrayErrorString(Sort.of(this.componentType)));
            }
            for (AnnotationValue filter : this.values) {
                AnnotationValue<U, V> filter2 = filter.filter(inDefinedShape, typeDefinition.getComponentType());
                if (filter2.getState() != State.RESOLVED) {
                    return filter2;
                }
            }
            return this;
        }

        public Sort getSort() {
            return Sort.ARRAY;
        }

        public State getState() {
            return State.RESOLVED;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i11;
            if (this.hashCode != 0) {
                i11 = 0;
            } else {
                int i12 = 1;
                for (AnnotationValue hashCode2 : this.values) {
                    i12 = (i12 * 31) + hashCode2.hashCode();
                }
                i11 = i12;
            }
            if (i11 == 0) {
                return this.hashCode;
            }
            this.hashCode = i11;
            return i11;
        }

        public Loaded<V> load(ClassLoader classLoader) {
            ArrayList arrayList = new ArrayList(this.values.size());
            for (AnnotationValue load : this.values) {
                arrayList.add(load.load(classLoader));
            }
            try {
                return new Loaded(Class.forName(this.componentType.getName(), false, classLoader), arrayList);
            } catch (ClassNotFoundException e11) {
                return new ForMissingType.Loaded(this.componentType.getName(), e11);
            }
        }

        public U resolve() {
            U newInstance = Array.newInstance(this.unloadedComponentType, this.values.size());
            int i11 = 0;
            for (AnnotationValue resolve : this.values) {
                Array.set(newInstance, i11, resolve.resolve());
                i11++;
            }
            return newInstance;
        }

        public String toString() {
            return RenderingDispatcher.CURRENT.toSourceString((List<?>) this.values);
        }

        public static <W extends Annotation> AnnotationValue<AnnotationDescription[], W[]> of(TypeDescription typeDescription, AnnotationDescription[] annotationDescriptionArr) {
            ArrayList arrayList = new ArrayList(annotationDescriptionArr.length);
            int length = annotationDescriptionArr.length;
            int i11 = 0;
            while (i11 < length) {
                AnnotationDescription annotationDescription = annotationDescriptionArr[i11];
                if (annotationDescription.getAnnotationType().equals(typeDescription)) {
                    arrayList.add(new ForAnnotationDescription(annotationDescription));
                    i11++;
                } else {
                    throw new IllegalArgumentException(annotationDescription + " is not of " + typeDescription);
                }
            }
            return new ForDescriptionArray(AnnotationDescription.class, typeDescription, arrayList);
        }

        public static AnnotationValue<TypeDescription[], Class<?>[]> of(TypeDescription[] typeDescriptionArr) {
            ArrayList arrayList = new ArrayList(typeDescriptionArr.length);
            for (TypeDescription of2 : typeDescriptionArr) {
                arrayList.add(ForTypeDescription.of(of2));
            }
            return new ForDescriptionArray(TypeDescription.class, TypeDescription.CLASS, arrayList);
        }
    }
}
