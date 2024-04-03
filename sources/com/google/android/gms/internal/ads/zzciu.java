package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;

public final /* synthetic */ class zzciu implements zzcix {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzciu(String str) {
        this.zza = str;
    }

    public final void zza(JsonWriter jsonWriter) {
        String str = this.zza;
        int i11 = zzciy.zza;
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }
}
