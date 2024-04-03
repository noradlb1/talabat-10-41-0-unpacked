package com.google.android.gms.maps.model;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzf;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Instrumented
public abstract class UrlTileProvider implements TileProvider {
    private final int zza;
    private final int zzb;

    public UrlTileProvider(int i11, int i12) {
        this.zza = i11;
        this.zzb = i12;
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final Tile getTile(int i11, int i12, int i13) {
        URL tileUrl = getTileUrl(i11, i12, i13);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            zzf.zzb(4352);
            int i14 = this.zza;
            int i15 = this.zzb;
            InputStream inputStream = URLConnectionInstrumentation.openConnection(tileUrl.openConnection()).getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Preconditions.checkNotNull(inputStream, "from must not be null.");
            Preconditions.checkNotNull(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    Tile tile = new Tile(i14, i15, byteArrayOutputStream.toByteArray());
                    zzf.zza();
                    return tile;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
            zzf.zza();
            return null;
        } catch (Throwable th2) {
            zzf.zza();
            throw th2;
        }
    }

    @Nullable
    public abstract URL getTileUrl(int i11, int i12, int i13);
}
