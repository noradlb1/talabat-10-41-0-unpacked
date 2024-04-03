package mz;

import com.uxcam.internals.gc;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class s implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return gc.a(file, str);
    }
}
