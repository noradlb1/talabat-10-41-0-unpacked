package d7;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ShareInternalUtility;

public final /* synthetic */ class a implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34415a;

    public /* synthetic */ a(int i11) {
        this.f34415a = i11;
    }

    public final boolean onActivityResult(int i11, Intent intent) {
        return ShareInternalUtility.m9013registerStaticShareCallback$lambda0(this.f34415a, i11, intent);
    }
}
