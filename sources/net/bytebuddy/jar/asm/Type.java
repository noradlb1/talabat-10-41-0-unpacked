package net.bytebuddy.jar.asm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;

public final class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE = new Type(1, PRIMITIVE_DESCRIPTORS, 1, 2);
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE = new Type(3, PRIMITIVE_DESCRIPTORS, 3, 4);
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE = new Type(2, PRIMITIVE_DESCRIPTORS, 2, 3);
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE = new Type(8, PRIMITIVE_DESCRIPTORS, 8, 9);
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE = new Type(6, PRIMITIVE_DESCRIPTORS, 6, 7);
    public static final int INT = 5;
    private static final int INTERNAL = 12;
    public static final Type INT_TYPE = new Type(5, PRIMITIVE_DESCRIPTORS, 5, 6);
    public static final int LONG = 7;
    public static final Type LONG_TYPE = new Type(7, PRIMITIVE_DESCRIPTORS, 7, 8);
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    private static final String PRIMITIVE_DESCRIPTORS = "VZCBSIFJD";
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE = new Type(4, PRIMITIVE_DESCRIPTORS, 4, 5);
    public static final int VOID = 0;
    public static final Type VOID_TYPE = new Type(0, PRIMITIVE_DESCRIPTORS, 0, 1);
    private final int sort;
    private final int valueBegin;
    private final String valueBuffer;
    private final int valueEnd;

    private Type(int i11, String str, int i12, int i13) {
        this.sort = i11;
        this.valueBuffer = str;
        this.valueBegin = i12;
        this.valueEnd = i13;
    }

    public static int a(String str) {
        int i11 = 1;
        while (str.charAt(i11) != ')') {
            while (str.charAt(i11) == '[') {
                i11++;
            }
            int i12 = i11 + 1;
            if (str.charAt(i11) == 'L') {
                i11 = Math.max(i12, str.indexOf(59, i12) + 1);
            } else {
                i11 = i12;
            }
        }
        return i11 + 1;
    }

    private void appendDescriptor(StringBuilder sb2) {
        int i11 = this.sort;
        if (i11 == 10) {
            sb2.append(this.valueBuffer, this.valueBegin - 1, this.valueEnd + 1);
        } else if (i11 == 12) {
            sb2.append('L');
            sb2.append(this.valueBuffer, this.valueBegin, this.valueEnd);
            sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } else {
            sb2.append(this.valueBuffer, this.valueBegin, this.valueEnd);
        }
    }

    public static String getConstructorDescriptor(Constructor<?> constructor) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Class appendDescriptor : constructor.getParameterTypes()) {
            appendDescriptor(appendDescriptor, sb2);
        }
        sb2.append(")V");
        return sb2.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Type appendDescriptor : typeArr) {
            appendDescriptor.appendDescriptor(sb2);
        }
        sb2.append(')');
        type.appendDescriptor(sb2);
        return sb2.toString();
    }

    public static Type getMethodType(String str) {
        return new Type(11, str, 0, str.length());
    }

    public static Type getObjectType(String str) {
        int i11;
        if (str.charAt(0) == '[') {
            i11 = 9;
        } else {
            i11 = 12;
        }
        return new Type(i11, str, 0, str.length());
    }

    public static Type getType(String str) {
        return getTypeInternal(str, 0, str.length());
    }

    private static Type getTypeInternal(String str, int i11, int i12) {
        char charAt = str.charAt(i11);
        if (charAt == '(') {
            return new Type(11, str, i11, i12);
        }
        if (charAt == 'F') {
            return FLOAT_TYPE;
        }
        if (charAt == 'L') {
            return new Type(10, str, i11 + 1, i12 - 1);
        }
        if (charAt == 'S') {
            return SHORT_TYPE;
        }
        if (charAt == 'V') {
            return VOID_TYPE;
        }
        if (charAt == 'I') {
            return INT_TYPE;
        }
        if (charAt == 'J') {
            return LONG_TYPE;
        }
        if (charAt == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (charAt == '[') {
            return new Type(9, str, i11, i12);
        }
        switch (charAt) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        int i11 = this.sort;
        int i12 = 10;
        if (i11 == 12) {
            i11 = 10;
        }
        int i13 = type.sort;
        if (i13 != 12) {
            i12 = i13;
        }
        if (i11 != i12) {
            return false;
        }
        int i14 = this.valueBegin;
        int i15 = this.valueEnd;
        int i16 = type.valueBegin;
        if (i15 - i14 != type.valueEnd - i16) {
            return false;
        }
        while (i14 < i15) {
            if (this.valueBuffer.charAt(i14) != type.valueBuffer.charAt(i16)) {
                return false;
            }
            i14++;
            i16++;
        }
        return true;
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return TypedValues.Custom.S_BOOLEAN;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return TypedValues.Custom.S_FLOAT;
            case 7:
                return Constants.LONG;
            case 8:
                return "double";
            case 9:
                StringBuilder sb2 = new StringBuilder(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return sb2.toString();
            case 10:
            case 12:
                return this.valueBuffer.substring(this.valueBegin, this.valueEnd).replace('/', '.');
            default:
                throw new AssertionError();
        }
    }

    public String getDescriptor() {
        int i11 = this.sort;
        if (i11 == 10) {
            return this.valueBuffer.substring(this.valueBegin - 1, this.valueEnd + 1);
        }
        if (i11 != 12) {
            return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
        }
        return 'L' + this.valueBuffer.substring(this.valueBegin, this.valueEnd) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }

    public int getDimensions() {
        int i11 = 1;
        while (this.valueBuffer.charAt(this.valueBegin + i11) == '[') {
            i11++;
        }
        return i11;
    }

    public Type getElementType() {
        return getTypeInternal(this.valueBuffer, this.valueBegin + getDimensions(), this.valueEnd);
    }

    public String getInternalName() {
        return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
    }

    public int getOpcode(int i11) {
        if (i11 == 46 || i11 == 79) {
            switch (this.sort) {
                case 0:
                case 11:
                    throw new UnsupportedOperationException();
                case 1:
                case 3:
                    return i11 + 5;
                case 2:
                    return i11 + 6;
                case 4:
                    return i11 + 7;
                case 5:
                    return i11;
                case 6:
                    return i11 + 2;
                case 7:
                    return i11 + 1;
                case 8:
                    return i11 + 3;
                case 9:
                case 10:
                case 12:
                    return i11 + 4;
                default:
                    throw new AssertionError();
            }
        } else {
            switch (this.sort) {
                case 0:
                    if (i11 == 172) {
                        return Opcodes.RETURN;
                    }
                    throw new UnsupportedOperationException();
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return i11;
                case 6:
                    return i11 + 2;
                case 7:
                    return i11 + 1;
                case 8:
                    return i11 + 3;
                case 9:
                case 10:
                case 12:
                    if (i11 == 21 || i11 == 54 || i11 == 172) {
                        return i11 + 4;
                    }
                    throw new UnsupportedOperationException();
                case 11:
                    throw new UnsupportedOperationException();
                default:
                    throw new AssertionError();
            }
        }
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getSize() {
        switch (this.sort) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 12:
                return 1;
            case 7:
            case 8:
                return 2;
            default:
                throw new AssertionError();
        }
    }

    public int getSort() {
        int i11 = this.sort;
        if (i11 == 12) {
            return 10;
        }
        return i11;
    }

    public int hashCode() {
        int i11;
        int i12 = this.sort;
        if (i12 == 12) {
            i11 = 10;
        } else {
            i11 = i12;
        }
        int i13 = i11 * 13;
        if (i12 >= 9) {
            int i14 = this.valueEnd;
            for (int i15 = this.valueBegin; i15 < i14; i15++) {
                i13 = (i13 + this.valueBuffer.charAt(i15)) * 17;
            }
        }
        return i13;
    }

    public String toString() {
        return getDescriptor();
    }

    public static Type[] getArgumentTypes(String str) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (str.charAt(i13) != ')') {
            while (str.charAt(i13) == '[') {
                i13++;
            }
            int i14 = i13 + 1;
            i13 = str.charAt(i13) == 'L' ? Math.max(i14, str.indexOf(59, i14) + 1) : i14;
            i12++;
        }
        Type[] typeArr = new Type[i12];
        int i15 = 1;
        while (str.charAt(i15) != ')') {
            int i16 = i15;
            while (str.charAt(i16) == '[') {
                i16++;
            }
            int i17 = i16 + 1;
            if (str.charAt(i16) == 'L') {
                i17 = Math.max(i17, str.indexOf(59, i17) + 1);
            }
            typeArr[i11] = getTypeInternal(str, i15, i17);
            i11++;
            i15 = i17;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i11 = 1;
        char charAt = str.charAt(1);
        int i12 = 1;
        int i13 = 1;
        while (charAt != ')') {
            if (charAt == 'J' || charAt == 'D') {
                i12++;
                i13 += 2;
            } else {
                while (str.charAt(i12) == '[') {
                    i12++;
                }
                int i14 = i12 + 1;
                if (str.charAt(i12) == 'L') {
                    i14 = Math.max(i14, str.indexOf(59, i14) + 1);
                }
                i13++;
                i12 = i14;
            }
            charAt = str.charAt(i12);
        }
        char charAt2 = str.charAt(i12 + 1);
        if (charAt2 == 'V') {
            return i13 << 2;
        }
        if (charAt2 == 'J' || charAt2 == 'D') {
            i11 = 2;
        }
        return (i13 << 2) | i11;
    }

    public static String getInternalName(Class<?> cls) {
        return cls.getName().replace('.', '/');
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getReturnType(String str) {
        return getTypeInternal(str, a(str), str.length());
    }

    public static Type getType(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return getType(getDescriptor(cls));
        }
        if (cls == Integer.TYPE) {
            return INT_TYPE;
        }
        if (cls == Void.TYPE) {
            return VOID_TYPE;
        }
        if (cls == Boolean.TYPE) {
            return BOOLEAN_TYPE;
        }
        if (cls == Byte.TYPE) {
            return BYTE_TYPE;
        }
        if (cls == Character.TYPE) {
            return CHAR_TYPE;
        }
        if (cls == Short.TYPE) {
            return SHORT_TYPE;
        }
        if (cls == Double.TYPE) {
            return DOUBLE_TYPE;
        }
        if (cls == Float.TYPE) {
            return FLOAT_TYPE;
        }
        if (cls == Long.TYPE) {
            return LONG_TYPE;
        }
        throw new AssertionError();
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    private static void appendDescriptor(Class<?> cls, StringBuilder sb2) {
        char c11;
        while (cls.isArray()) {
            sb2.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                c11 = 'I';
            } else if (cls == Void.TYPE) {
                c11 = 'V';
            } else if (cls == Boolean.TYPE) {
                c11 = 'Z';
            } else if (cls == Byte.TYPE) {
                c11 = 'B';
            } else if (cls == Character.TYPE) {
                c11 = 'C';
            } else if (cls == Short.TYPE) {
                c11 = 'S';
            } else if (cls == Double.TYPE) {
                c11 = 'D';
            } else if (cls == Float.TYPE) {
                c11 = 'F';
            } else if (cls == Long.TYPE) {
                c11 = 'J';
            } else {
                throw new AssertionError();
            }
            sb2.append(c11);
            return;
        }
        sb2.append('L');
        sb2.append(getInternalName(cls));
        sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public static String getDescriptor(Class<?> cls) {
        StringBuilder sb2 = new StringBuilder();
        appendDescriptor(cls, sb2);
        return sb2.toString();
    }

    public static String getMethodDescriptor(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Class appendDescriptor : method.getParameterTypes()) {
            appendDescriptor(appendDescriptor, sb2);
        }
        sb2.append(')');
        appendDescriptor(method.getReturnType(), sb2);
        return sb2.toString();
    }

    public static Type[] getArgumentTypes(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType((Class<?>) parameterTypes[length]);
        }
        return typeArr;
    }

    public static Type getType(Constructor<?> constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }
}
