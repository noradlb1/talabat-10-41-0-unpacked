package db;

import com.huawei.location.lite.common.log.logwrite.LogWrite;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class a implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return LogWrite.lambda$getExistedFiles$0(file, str);
    }
}
