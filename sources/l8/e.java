package l8;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;

public final /* synthetic */ class e {
    static {
        Predicate<String> predicate = HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        if ((!lowerCase.contains("text") || lowerCase.contains(MimeTypes.TEXT_VTT)) && !lowerCase.contains("html") && !lowerCase.contains("xml")) {
            return true;
        }
        return false;
    }
}
