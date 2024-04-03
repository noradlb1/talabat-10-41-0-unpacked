package com.google.android.libraries.places.internal;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzfr {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        String str3;
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
                    String name2 = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(name2.length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name2);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb3);
                    if (valueOf.length() != 0) {
                        str3 = "Exception during lenientFormat for ".concat(valueOf);
                    } else {
                        str3 = new String("Exception during lenientFormat for ");
                    }
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", str3, e11);
                    String name3 = e11.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 9 + name3.length());
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name3);
                    sb4.append(">");
                    str2 = sb4.toString();
                }
            }
            objArr[i12] = str2;
            i12++;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + (length * 16));
        int i13 = 0;
        while (true) {
            length2 = objArr.length;
            if (i11 >= length2 || (indexOf = str.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT, i13)) == -1) {
                sb5.append(str, i13, str.length());
            } else {
                sb5.append(str, i13, indexOf);
                sb5.append(objArr[i11]);
                i13 = indexOf + 2;
                i11++;
            }
        }
        sb5.append(str, i13, str.length());
        if (i11 < length2) {
            sb5.append(" [");
            sb5.append(objArr[i11]);
            for (int i14 = i11 + 1; i14 < objArr.length; i14++) {
                sb5.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb5.append(objArr[i14]);
            }
            sb5.append(AbstractJsonLexerKt.END_LIST);
        }
        return sb5.toString();
    }

    public static String zzb(@CheckForNull String str) {
        return zzfl.zza(str);
    }
}
