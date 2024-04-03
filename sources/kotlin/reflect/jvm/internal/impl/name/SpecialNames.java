package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialNames {
    @NotNull
    @JvmField
    public static final Name ANONYMOUS;
    @NotNull
    @JvmField
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    @NotNull
    @JvmField
    public static final Name DESTRUCT;
    @NotNull
    @JvmField
    public static final Name IMPLICIT_SET_PARAMETER;
    @NotNull
    @JvmField
    public static final Name INIT;
    @NotNull
    public static final SpecialNames INSTANCE = new SpecialNames();
    @NotNull
    @JvmField
    public static final Name ITERATOR;
    @NotNull
    @JvmField
    public static final Name LOCAL;
    @NotNull
    @JvmField
    public static final Name NO_NAME_PROVIDED;
    @NotNull
    @JvmField
    public static final Name ROOT_PACKAGE;
    @NotNull
    @JvmField
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
    @NotNull
    @JvmField
    public static final Name THIS;
    @NotNull
    @JvmField
    public static final Name UNARY;
    @NotNull
    @JvmField
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;

    static {
        Name special = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = special;
        Name special2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(special2, "special(\"<root package>\")");
        ROOT_PACKAGE = special2;
        Name identifier = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = identifier;
        Name identifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = identifier2;
        Name special3 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(special3, "special(ANONYMOUS_STRING)");
        ANONYMOUS = special3;
        Name special4 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(special4, "special(\"<unary>\")");
        UNARY = special4;
        Name special5 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(special5, "special(\"<this>\")");
        THIS = special5;
        Name special6 = Name.special(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
        Intrinsics.checkNotNullExpressionValue(special6, "special(\"<init>\")");
        INIT = special6;
        Name special7 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(special7, "special(\"<iterator>\")");
        ITERATOR = special7;
        Name special8 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(special8, "special(\"<destruct>\")");
        DESTRUCT = special8;
        Name special9 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special9, "special(\"<local>\")");
        LOCAL = special9;
        Name special10 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(special10, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = special10;
        Name special11 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(special11, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = special11;
    }

    private SpecialNames() {
    }

    @JvmStatic
    @NotNull
    public static final Name safeIdentifier(@Nullable Name name2) {
        return (name2 == null || name2.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name2;
    }

    public final boolean isSafeIdentifier(@NotNull Name name2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(name2, "name");
        String asString = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        if (asString.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || name2.isSpecial()) {
            return false;
        }
        return true;
    }
}
