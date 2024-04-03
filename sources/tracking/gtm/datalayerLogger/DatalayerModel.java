package tracking.gtm.datalayerLogger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ltracking/gtm/datalayerLogger/DatalayerModel;", "", "()V", "KEY", "", "getKEY", "()Ljava/lang/String;", "PASSWORD", "getPASSWORD", "TYPE", "getTYPE", "TYPE_DISABLE", "getTYPE_DISABLE", "TYPE_ENABLE", "getTYPE_ENABLE", "USERNAME", "getUSERNAME", "isLoggingEnabled", "", "()Z", "setLoggingEnabled", "(Z)V", "loggingKey", "getLoggingKey", "setLoggingKey", "(Ljava/lang/String;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DatalayerModel {
    @NotNull
    public static final DatalayerModel INSTANCE = new DatalayerModel();
    @NotNull
    private static final String KEY = "key";
    @NotNull
    private static final String PASSWORD = "xxx";
    @NotNull
    private static final String TYPE = "type";
    @NotNull
    private static final String TYPE_DISABLE = "disable";
    @NotNull
    private static final String TYPE_ENABLE = "enable";
    @NotNull
    private static final String USERNAME = "un";
    private static boolean isLoggingEnabled;
    @NotNull
    private static String loggingKey = new String();

    private DatalayerModel() {
    }

    @NotNull
    public final String getKEY() {
        return KEY;
    }

    @NotNull
    public final String getLoggingKey() {
        return loggingKey;
    }

    @NotNull
    public final String getPASSWORD() {
        return PASSWORD;
    }

    @NotNull
    public final String getTYPE() {
        return TYPE;
    }

    @NotNull
    public final String getTYPE_DISABLE() {
        return TYPE_DISABLE;
    }

    @NotNull
    public final String getTYPE_ENABLE() {
        return TYPE_ENABLE;
    }

    @NotNull
    public final String getUSERNAME() {
        return USERNAME;
    }

    public final boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    public final void setLoggingEnabled(boolean z11) {
        isLoggingEnabled = z11;
    }

    public final void setLoggingKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        loggingKey = str;
    }
}
