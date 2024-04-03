package dd;

import com.instabug.library.internal.storage.DiskUtils;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class a implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return DiskUtils.lambda$deleteAllStateFiles$0(file, str);
    }
}
