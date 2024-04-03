package q3;

import com.braze.IBraze;
import com.braze.models.outgoing.BrazeProperties;
import java.math.BigDecimal;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

public final /* synthetic */ class c {
    @Deprecated(message = "Use {@link #getDeviceId()} for equivalent functionality. Deprecated since May 2021", replaceWith = @ReplaceWith(expression = "deviceId", imports = {}))
    public static String a(IBraze iBraze) {
        return iBraze.getDeviceId();
    }

    public static /* synthetic */ void b(IBraze iBraze, String str, String str2, BigDecimal bigDecimal, int i11, BrazeProperties brazeProperties, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 8) != 0) {
                i11 = 1;
            }
            int i13 = i11;
            if ((i12 & 16) != 0) {
                brazeProperties = null;
            }
            iBraze.logPurchase(str, str2, bigDecimal, i13, brazeProperties);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPurchase");
    }
}
