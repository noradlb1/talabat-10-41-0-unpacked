package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {
    @GuardedBy("lock")
    private MediaItem.DrmConfiguration drmConfiguration;
    @Nullable
    private DataSource.Factory drmHttpDataSourceFactory;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private DrmSessionManager manager;
    @Nullable
    private String userAgent;

    @RequiresApi(18)
    private DrmSessionManager createManager(MediaItem.DrmConfiguration drmConfiguration2) {
        String str;
        DataSource.Factory factory = this.drmHttpDataSourceFactory;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().setUserAgent(this.userAgent);
        }
        Uri uri = drmConfiguration2.licenseUri;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(str, drmConfiguration2.forceDefaultLicenseUri, factory);
        UnmodifiableIterator<Map.Entry<String, String>> it = drmConfiguration2.licenseRequestHeaders.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            httpMediaDrmCallback.setKeyRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        DefaultDrmSessionManager build = new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(drmConfiguration2.scheme, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(drmConfiguration2.multiSession).setPlayClearSamplesWithoutKeys(drmConfiguration2.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Ints.toArray(drmConfiguration2.forcedSessionTrackTypes)).build(httpMediaDrmCallback);
        build.setMode(0, drmConfiguration2.getKeySetId());
        return build;
    }

    public DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.checkNotNull(mediaItem.localConfiguration);
        MediaItem.DrmConfiguration drmConfiguration2 = mediaItem.localConfiguration.drmConfiguration;
        if (drmConfiguration2 == null || Util.SDK_INT < 18) {
            return DrmSessionManager.DRM_UNSUPPORTED;
        }
        synchronized (this.lock) {
            if (!Util.areEqual(drmConfiguration2, this.drmConfiguration)) {
                this.drmConfiguration = drmConfiguration2;
                this.manager = createManager(drmConfiguration2);
            }
            drmSessionManager = (DrmSessionManager) Assertions.checkNotNull(this.manager);
        }
        return drmSessionManager;
    }

    public void setDrmHttpDataSourceFactory(@Nullable DataSource.Factory factory) {
        this.drmHttpDataSourceFactory = factory;
    }

    @Deprecated
    public void setDrmUserAgent(@Nullable String str) {
        this.userAgent = str;
    }
}
