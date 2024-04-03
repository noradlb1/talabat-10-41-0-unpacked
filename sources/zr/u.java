package zr;

import android.net.Uri;
import com.adjust.sdk.OnDeeplinkResponseListener;
import com.talabat.helpers.TalabatApplication;

public final /* synthetic */ class u implements OnDeeplinkResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TalabatApplication f63119a;

    public /* synthetic */ u(TalabatApplication talabatApplication) {
        this.f63119a = talabatApplication;
    }

    public final boolean launchReceivedDeeplink(Uri uri) {
        return TalabatApplication.m10627createAdjust$lambda8(this.f63119a, uri);
    }
}
