package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.common.util.IOUtils;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfdy {
    public final List<zzfdn> zza;
    public final zzfdq zzb;
    public final List<zzfdx> zzc;

    public zzfdy(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzfdn> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzfdq zzfdq = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzfdn(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzfdq = new zzfdq(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if (CustomerInfoLocalDataSourceImpl.KEY.equals(nextName3)) {
                            jSONObject = zzby.zzh(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzfdx(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList;
        this.zza = emptyList;
        this.zzb = zzfdq == null ? new zzfdq(new JsonReader(new StringReader("{}"))) : zzfdq;
    }

    public static zzfdy zza(Reader reader) throws zzfdr {
        try {
            zzfdy zzfdy = new zzfdy(new JsonReader(reader));
            IOUtils.closeQuietly((Closeable) reader);
            return zzfdy;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e11) {
            throw new zzfdr("unable to parse ServerResponse", e11);
        } catch (Throwable th2) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th2;
        }
    }
}
