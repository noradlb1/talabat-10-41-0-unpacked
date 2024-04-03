package tracking;

import android.os.Build;
import com.talabat.helpers.GlobalDataModel;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"EMPTY_VALUE", "", "getUserId", "getUserTimestamp", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TrackingHelperKt {
    @NotNull
    public static final String EMPTY_VALUE = "N/A";

    @NotNull
    public static final String getUserId() {
        String str = GlobalDataModel.encryptedUserId;
        return str.length() == 0 ? "N/A" : str;
    }

    @NotNull
    public static final String getUserTimestamp() {
        if (Build.VERSION.SDK_INT >= 26) {
            String format = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z", Locale.ENGLISH));
            Intrinsics.checkNotNullExpressionValue(format, "{\n        val formatter …).format(formatter)\n    }");
            return format;
        }
        String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z", Locale.ENGLISH).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format2, "{\n        val formatter …tter.format(Date())\n    }");
        return format2;
    }
}
