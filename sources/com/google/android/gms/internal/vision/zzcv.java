package com.google.android.gms.internal.vision;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzcv {
    public static String zza(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i11 = 0;
        for (int i12 = 0; i12 < objArr.length; i12++) {
            objArr[i12] = zzc(objArr[i12]);
        }
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i13 = 0;
        while (i11 < objArr.length && (indexOf = valueOf.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT, i13)) != -1) {
            sb2.append(valueOf, i13, indexOf);
            sb2.append(objArr[i11]);
            i13 = indexOf + 2;
            i11++;
        }
        sb2.append(valueOf, i13, valueOf.length());
        if (i11 < objArr.length) {
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

    private static String zzc(@NullableDecl Object obj) {
        String str;
        try {
            return String.valueOf(obj);
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
                str = "Exception during lenientFormat for ".concat(valueOf);
            } else {
                str = new String("Exception during lenientFormat for ");
            }
            logger.logp(level, "com.google.common.base.Strings", "lenientToString", str, e11);
            String name3 = e11.getClass().getName();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 9 + name3.length());
            sb4.append("<");
            sb4.append(sb3);
            sb4.append(" threw ");
            sb4.append(name3);
            sb4.append(">");
            return sb4.toString();
        }
    }

    public static String zzk(@NullableDecl String str) {
        return zzcp.zzk(str);
    }
}
