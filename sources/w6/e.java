package w6;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class e implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return InstrumentUtility.m8976listExceptionReportFiles$lambda3(file, str);
    }
}
