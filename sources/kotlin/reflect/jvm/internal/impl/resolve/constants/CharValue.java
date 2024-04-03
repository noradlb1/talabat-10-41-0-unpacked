package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;

public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c11) {
        super(Character.valueOf(c11));
    }

    private final String getPrintablePart(char c11) {
        if (c11 == 8) {
            return "\\b";
        }
        if (c11 == 9) {
            return "\\t";
        }
        if (c11 == 10) {
            return "\\n";
        }
        if (c11 == 12) {
            return "\\f";
        }
        if (c11 == 13) {
            return "\\r";
        }
        if (isPrintableUnicode(c11)) {
            return String.valueOf(c11);
        }
        return TypeDescription.Generic.OfWildcardType.SYMBOL;
    }

    private final boolean isPrintableUnicode(char c11) {
        byte type = (byte) Character.getType(c11);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) getValue()).charValue()), getPrintablePart(((Character) getValue()).charValue())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType charType = moduleDescriptor.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }
}
