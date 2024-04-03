package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;

final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    @NotNull
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmTypeFactoryImpl() {
    }

    @NotNull
    public JvmType boxType(@NotNull JvmType jvmType) {
        Intrinsics.checkNotNullParameter(jvmType, "possiblyPrimitiveType");
        if (!(jvmType instanceof JvmType.Primitive)) {
            return jvmType;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) jvmType;
        if (primitive.getJvmPrimitiveType() == null) {
            return jvmType;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return createObjectType(internalName);
    }

    @NotNull
    public JvmType createFromString(@NotNull String str) {
        JvmPrimitiveType jvmPrimitiveType;
        JvmType object;
        Intrinsics.checkNotNullParameter(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i11];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i11++;
        }
        if (jvmPrimitiveType != null) {
            return new JvmType.Primitive(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new JvmType.Primitive((JvmPrimitiveType) null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            object = new JvmType.Array(createFromString(substring));
        } else {
            if (charAt == 'L') {
                boolean endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, false, 2, (Object) null);
            }
            String substring2 = str.substring(1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            object = new JvmType.Object(substring2);
        }
        return object;
    }

    @NotNull
    public JvmType.Object createObjectType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        return new JvmType.Object(str);
    }

    @NotNull
    public JvmType createPrimitiveType(@NotNull PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return JvmType.Companion.getCHAR$descriptors_jvm();
            case 3:
                return JvmType.Companion.getBYTE$descriptors_jvm();
            case 4:
                return JvmType.Companion.getSHORT$descriptors_jvm();
            case 5:
                return JvmType.Companion.getINT$descriptors_jvm();
            case 6:
                return JvmType.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return JvmType.Companion.getLONG$descriptors_jvm();
            case 8:
                return JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public JvmType getJavaLangClassType() {
        return createObjectType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
    }

    @NotNull
    public String toString(@NotNull JvmType jvmType) {
        String desc;
        Intrinsics.checkNotNullParameter(jvmType, "type");
        if (jvmType instanceof JvmType.Array) {
            return '[' + toString(((JvmType.Array) jvmType).getElementType());
        } else if (jvmType instanceof JvmType.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((JvmType.Primitive) jvmType).getJvmPrimitiveType();
            if (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            return desc;
        } else if (jvmType instanceof JvmType.Object) {
            return 'L' + ((JvmType.Object) jvmType).getInternalName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
