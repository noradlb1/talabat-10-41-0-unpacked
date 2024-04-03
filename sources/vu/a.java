package vu;

import com.talabat.splash.data.remote.worker.DownloadWorker;
import java.io.File;
import java.io.FileFilter;

public final /* synthetic */ class a implements FileFilter {
    public final boolean accept(File file) {
        return DownloadWorker.m10909deleteFilesAndRemoveEntry$lambda1(file);
    }
}
