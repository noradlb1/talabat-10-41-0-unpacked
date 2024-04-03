package z7;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class f implements MetadataOutput {
    public final void onMetadata(Metadata metadata) {
        DownloadHelper.lambda$getRendererCapabilities$1(metadata);
    }
}
