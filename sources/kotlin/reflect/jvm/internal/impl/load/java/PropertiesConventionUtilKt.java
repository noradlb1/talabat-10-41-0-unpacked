package kotlin.reflect.jvm.internal.impl.load.java;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PropertiesConventionUtilKt {
    public static /* synthetic */ Name a(Name name2, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name2, str, z11, str2);
    }

    @NotNull
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        String asString = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        if (JvmAbi.isGetterName(asString)) {
            return CollectionsKt__CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name2));
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name2);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name2);
    }

    @Nullable
    public static final Name propertyNameByGetMethodName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Name a11 = a(name2, "get", false, (String) null, 12, (Object) null);
        if (a11 == null) {
            return a(name2, "is", false, (String) null, 8, (Object) null);
        }
        return a11;
    }

    @Nullable
    public static final Name propertyNameBySetMethodName(@NotNull Name name2, boolean z11) {
        String str;
        Intrinsics.checkNotNullParameter(name2, HexAttribute.HEX_ATTR_METHOD_NAME);
        if (z11) {
            str = "is";
        } else {
            str = null;
        }
        return a(name2, "set", false, str, 4, (Object) null);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name2, String str, boolean z11, String str2) {
        if (name2.isSpecial()) {
            return null;
        }
        String identifier = name2.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "methodName.identifier");
        boolean z12 = false;
        if (!StringsKt__StringsJVMKt.startsWith$default(identifier, str, false, 2, (Object) null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            z12 = true;
        }
        if (z12) {
            return null;
        }
        if (str2 != null) {
            return Name.identifier(str2 + StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str));
        } else if (!z11) {
            return name2;
        } else {
            String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str), true);
            if (!Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                return null;
            }
            return Name.identifier(decapitalizeSmartForCompiler);
        }
    }

    @NotNull
    public static final List<Name> propertyNamesBySetMethodName(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, HexAttribute.HEX_ATTR_METHOD_NAME);
        return CollectionsKt__CollectionsKt.listOfNotNull((T[]) new Name[]{propertyNameBySetMethodName(name2, false), propertyNameBySetMethodName(name2, true)});
    }
}
