package tracking.deeplink;

import android.content.Context;
import android.net.Uri;

public interface IDeepLinkPresenter {
    void appLinkRecived(Uri uri, Context context);

    void deepLinkRecived(String str);

    void redirectToDeepLink();

    void setDeepLinkStatusListener(DeepLinkStatusListener deepLinkStatusListener);

    void talabatWebReceived(String str);
}
