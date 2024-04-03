package fa;

import com.google.android.datatransport.Transformer;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

public final /* synthetic */ class n implements Transformer {
    public final Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}
