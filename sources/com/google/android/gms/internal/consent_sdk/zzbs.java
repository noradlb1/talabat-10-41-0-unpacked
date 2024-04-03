package com.google.android.gms.internal.consent_sdk;

import android.util.JsonWriter;
import java.io.IOException;

public enum zzbs {
    DEBUG_PARAM_UNKNOWN,
    ALWAYS_SHOW,
    GEO_OVERRIDE_EEA,
    GEO_OVERRIDE_NON_EEA;

    public final void zza(JsonWriter jsonWriter) throws IOException {
        int i11 = zzbq.zzb[ordinal()];
        if (i11 == 1) {
            jsonWriter.value("DEBUG_PARAM_UNKNOWN");
        } else if (i11 == 2) {
            jsonWriter.value("ALWAYS_SHOW");
        } else if (i11 == 3) {
            jsonWriter.value("GEO_OVERRIDE_EEA");
        } else if (i11 == 4) {
            jsonWriter.value("GEO_OVERRIDE_NON_EEA");
        }
    }
}
