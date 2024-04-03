package com.talabat.helpers;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.authentication.token.domain.model.Token;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$2$6 extends Lambda implements Function0<String> {
    final /* synthetic */ Function0<Token> $tokenResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$2$6(Function0<Token> function0) {
        super(0);
        this.$tokenResult = function0;
    }

    @NotNull
    public final String invoke() {
        String str;
        try {
            String tokenType = this.$tokenResult.invoke().getTokenType();
            boolean z11 = true;
            if (tokenType.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                char charAt = tokenType.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    str = CharsKt__CharJVMKt.titlecase(charAt, locale);
                } else {
                    str = String.valueOf(charAt);
                }
                sb2.append(str);
                String substring = tokenType.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                tokenType = sb2.toString();
            }
            if (tokenType.length() != 0) {
                z11 = false;
            }
            if (z11) {
                return "Bearer";
            }
            return tokenType;
        } catch (Throwable unused) {
            return "Bearer";
        }
    }
}
