package tracking.gtm.datalayerLogger;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.firebaseauth.TalabatFirebaseAuth;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltracking/gtm/datalayerLogger/DatalayerLoggerImpl;", "Ltracking/gtm/datalayerLogger/DatalayerLogger;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getLoggerKey", "", "getUserName", "initialise", "", "isForDisabling", "", "type", "isLoggingEnabled", "removeLogging", "setLogger", "talabatFirebaseAuth", "Ltracking/firebaseauth/TalabatFirebaseAuth;", "key", "userName", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DatalayerLoggerImpl implements DatalayerLogger {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String DATALAYERSHAREDPREFERENCEKEY = "datalayerKey";
    /* access modifiers changed from: private */
    @NotNull
    public static final String EMAILSHAREDPREFERENCEKEY = "datalayerlogger_email";
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltracking/gtm/datalayerLogger/DatalayerLoggerImpl$Companion;", "", "()V", "DATALAYERSHAREDPREFERENCEKEY", "", "getDATALAYERSHAREDPREFERENCEKEY", "()Ljava/lang/String;", "EMAILSHAREDPREFERENCEKEY", "getEMAILSHAREDPREFERENCEKEY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getDATALAYERSHAREDPREFERENCEKEY() {
            return DatalayerLoggerImpl.DATALAYERSHAREDPREFERENCEKEY;
        }

        @NotNull
        public final String getEMAILSHAREDPREFERENCEKEY() {
            return DatalayerLoggerImpl.EMAILSHAREDPREFERENCEKEY;
        }
    }

    public DatalayerLoggerImpl(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
        DatalayerModel.INSTANCE.setLoggingEnabled(false);
    }

    @NotNull
    public String getLoggerKey() {
        return DatalayerModel.INSTANCE.getLoggingKey();
    }

    @NotNull
    public String getUserName() {
        String string = this.sharedPreferences.getString(EMAILSHAREDPREFERENCEKEY, "");
        return string == null ? "" : string;
    }

    public void initialise() {
        boolean z11;
        String str = "";
        String string = this.sharedPreferences.getString(DATALAYERSHAREDPREFERENCEKEY, str);
        DatalayerModel datalayerModel = DatalayerModel.INSTANCE;
        if (string != null) {
            str = string;
        }
        datalayerModel.setLoggingKey(str);
        if (string == null || StringsKt__StringsJVMKt.isBlank(string)) {
            z11 = true;
        } else {
            z11 = false;
        }
        datalayerModel.setLoggingEnabled(!z11);
    }

    public boolean isForDisabling(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return str.equals(DatalayerModel.INSTANCE.getTYPE_DISABLE());
    }

    public boolean isLoggingEnabled() {
        return DatalayerModel.INSTANCE.isLoggingEnabled();
    }

    public void removeLogging() {
        DatalayerModel datalayerModel = DatalayerModel.INSTANCE;
        datalayerModel.setLoggingEnabled(false);
        datalayerModel.setLoggingKey("");
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(DATALAYERSHAREDPREFERENCEKEY, "");
        edit.apply();
    }

    public void setLogger(@NotNull TalabatFirebaseAuth talabatFirebaseAuth, @NotNull String str, @NotNull String str2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(talabatFirebaseAuth, "talabatFirebaseAuth");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "userName");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            DatalayerModel datalayerModel = DatalayerModel.INSTANCE;
            datalayerModel.setLoggingEnabled(true);
            datalayerModel.setLoggingKey(str);
            talabatFirebaseAuth.signInWithEmailLink(str2);
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            edit.putString(DATALAYERSHAREDPREFERENCEKEY, str);
            edit.putString(EMAILSHAREDPREFERENCEKEY, str2);
            edit.apply();
            return;
        }
        DatalayerModel datalayerModel2 = DatalayerModel.INSTANCE;
        datalayerModel2.setLoggingEnabled(false);
        datalayerModel2.setLoggingKey("");
    }
}
