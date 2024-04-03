package com.talabat.core.network.network.interceptors;

import android.util.Base64;
import com.talabat.core.network.network.TalabatNetworkModuleSafetyIntegrator;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafetyInterceptor$installationPath$2 extends Lambda implements Function0<String> {
    public static final SafetyInterceptor$installationPath$2 INSTANCE = new SafetyInterceptor$installationPath$2();

    public SafetyInterceptor$installationPath$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        try {
            byte[] bytes = TalabatNetworkModuleSafetyIntegrator.INSTANCE.getAppInstallationPath().invoke().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            if (encodeToString == null) {
                return "";
            }
            return encodeToString;
        } catch (Exception e11) {
            LogManager.error$default(e11, (String) null, 2, (Object) null);
            return "";
        }
    }
}
