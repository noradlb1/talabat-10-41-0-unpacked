package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CharSequence a(Context context, ServiceInfo serviceInfo) {
            Set a11 = serviceInfo.getNamedContentLocales();
            if (a11.isEmpty()) {
                return null;
            }
            String[] strArr = new String[a11.size()];
            int i11 = 0;
            for (Locale languageTag : serviceInfo.getNamedContentLocales()) {
                strArr[i11] = languageTag.toLanguageTag();
                i11++;
            }
            Locale a12 = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (a12 == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(a12);
        }
    }

    private MbmsHelper() {
    }

    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(context, serviceInfo);
        }
        return null;
    }
}
