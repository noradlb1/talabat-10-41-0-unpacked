package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzfdo {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzfdo(int i11, int i12, boolean z11) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = z11;
    }

    public static List<zzfdo> zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i11 = 0;
            int i12 = 0;
            boolean z11 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i11 = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i12 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z11 = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzfdo(i11, i12, z11));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
