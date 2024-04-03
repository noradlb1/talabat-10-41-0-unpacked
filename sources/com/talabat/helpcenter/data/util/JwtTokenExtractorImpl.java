package com.talabat.helpcenter.data.util;

import com.talabat.helpcenter.domain.util.JwtTokenExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/helpcenter/data/util/JwtTokenExtractorImpl;", "Lcom/talabat/helpcenter/domain/util/JwtTokenExtractor;", "()V", "extractToken", "", "url", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenExtractorImpl implements JwtTokenExtractor {
    @NotNull
    public String extractToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String queryParameter = HttpUrl.Companion.get(StringsKt__StringsJVMKt.replace$default(str, "#?", TypeDescription.Generic.OfWildcardType.SYMBOL, false, 4, (Object) null)).queryParameter("verification_token");
        if (queryParameter == null) {
            return "";
        }
        return queryParameter;
    }
}
