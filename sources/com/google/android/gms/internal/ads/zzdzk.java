package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public final class zzdzk {
    private final Clock zza;

    public zzdzk(Clock clock) {
        this.zza = clock;
    }

    public final void zza(List<Object> list, String str, String str2, Object... objArr) {
        String str3;
        String str4;
        if (zzbmz.zza.zze().booleanValue()) {
            long currentTimeMillis = this.zza.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(currentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                for (Object obj : list) {
                    jsonWriter.value(obj.toString());
                }
                jsonWriter.endArray();
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginArray();
                for (Object obj2 : objArr) {
                    if (obj2 != null) {
                        str4 = obj2.toString();
                    } else {
                        str4 = null;
                    }
                    jsonWriter.value(str4);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e11) {
                zzciz.zzh("unable to log", e11);
            }
            String valueOf = String.valueOf(stringWriter.toString());
            if (valueOf.length() != 0) {
                str3 = "AD-DBG ".concat(valueOf);
            } else {
                str3 = new String("AD-DBG ");
            }
            zzciz.zzi(str3);
        }
    }
}
