package w6;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class g implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return InstrumentUtility.m8974listAnrReportFiles$lambda1(file, str);
    }
}
