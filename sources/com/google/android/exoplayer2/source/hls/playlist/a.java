package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle f35034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f35035c;

    public /* synthetic */ a(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.f35034b = mediaPlaylistBundle;
        this.f35035c = uri;
    }

    public final void run() {
        this.f35034b.lambda$loadPlaylistInternal$0(this.f35035c);
    }
}
