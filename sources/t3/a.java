package t3;

import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.inappmessage.IInAppMessage;
import java.util.Map;

public final /* synthetic */ class a {
    public static Map a(IInAppMessage iInAppMessage) {
        return MapsKt__MapsKt.emptyMap();
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void e(IInAppMessage iInAppMessage, ClickAction clickAction, Uri uri, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                uri = null;
            }
            iInAppMessage.setClickBehavior(clickAction, uri);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setClickBehavior");
    }
}
