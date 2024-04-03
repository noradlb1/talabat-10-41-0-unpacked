package kotlin.reflect.jvm.internal.impl.renderer;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class RenderingUtilsKt {
    @NotNull
    public static final String render(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "<this>");
        if (shouldBeEscaped(name2)) {
            StringBuilder sb2 = new StringBuilder();
            String asString = name2.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString()");
            sb2.append('`' + asString);
            sb2.append('`');
            return sb2.toString();
        }
        String asString2 = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString()");
        return asString2;
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> list) {
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        for (Name next : list) {
            if (sb2.length() > 0) {
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            }
            sb2.append(render(next));
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    private static final boolean shouldBeEscaped(Name name2) {
        boolean z11;
        boolean z12;
        String asString = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString()");
        if (KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            return true;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= asString.length()) {
                z11 = false;
                break;
            }
            char charAt = asString.charAt(i11);
            if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }
}
