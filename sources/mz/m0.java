package mz;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class m0 implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.endsWith(".usid");
    }
}
