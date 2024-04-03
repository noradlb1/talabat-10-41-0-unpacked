package ko;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager;
import java.io.File;

public final /* synthetic */ class a implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f62217a;

    public /* synthetic */ a(byte[] bArr) {
        this.f62217a = bArr;
    }

    public final boolean write(File file) {
        return TMartGrowthFileManager.m10297saveFile$lambda4(this.f62217a, file);
    }
}
