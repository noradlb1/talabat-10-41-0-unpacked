package com.google.android.gms.internal.measurement;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzil {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            length = objArr.length;
            if (i12 >= length) {
                break;
            }
            Object obj = objArr[i12];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e11) {
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), e11);
                    str2 = "<" + str3 + " threw " + e11.getClass().getName() + ">";
                }
            }
            objArr[i12] = str2;
            i12++;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length * 16));
        int i13 = 0;
        while (true) {
            length2 = objArr.length;
            if (i11 >= length2 || (indexOf = str.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT, i13)) == -1) {
                sb2.append(str, i13, str.length());
            } else {
                sb2.append(str, i13, indexOf);
                sb2.append(objArr[i11]);
                i13 = indexOf + 2;
                i11++;
            }
        }
        sb2.append(str, i13, str.length());
        if (i11 < length2) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i14 = i11 + 1; i14 < objArr.length; i14++) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(objArr[i14]);
            }
            sb2.append(AbstractJsonLexerKt.END_LIST);
        }
        return sb2.toString();
    }
}
