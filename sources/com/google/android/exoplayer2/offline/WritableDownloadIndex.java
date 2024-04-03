package com.google.android.exoplayer2.offline;

import androidx.annotation.WorkerThread;
import java.io.IOException;

@WorkerThread
public interface WritableDownloadIndex extends DownloadIndex {
    void putDownload(Download download) throws IOException;

    void removeDownload(String str) throws IOException;

    void setDownloadingStatesToQueued() throws IOException;

    void setStatesToRemoving() throws IOException;

    void setStopReason(int i11) throws IOException;

    void setStopReason(String str, int i11) throws IOException;
}
