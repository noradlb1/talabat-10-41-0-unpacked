package db;

import com.huawei.location.lite.common.log.logwrite.LogWrite;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class b implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return LogWrite.lambda$getExistedFiles$1(file, str);
    }
}
