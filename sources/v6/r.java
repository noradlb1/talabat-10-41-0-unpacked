package v6;

import com.facebook.internal.Utility;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class r implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return Utility.m8963refreshBestGuessNumberOfCPUCores$lambda4(file, str);
    }
}
