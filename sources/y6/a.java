package y6;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return CrashHandler.Companion.m8980sendExceptionReports$lambda2((InstrumentData) obj, (InstrumentData) obj2);
    }
}
