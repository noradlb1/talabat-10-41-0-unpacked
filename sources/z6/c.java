package z6;

import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class c implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return ErrorReportHandler.m8982listErrorReportFiles$lambda3(file, str);
    }
}
