package d7;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ShareInternalUtility;

public final /* synthetic */ class b implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34416a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookCallback f34417b;

    public /* synthetic */ b(int i11, FacebookCallback facebookCallback) {
        this.f34416a = i11;
        this.f34417b = facebookCallback;
    }

    public final boolean onActivityResult(int i11, Intent intent) {
        return ShareInternalUtility.m9012registerSharerCallback$lambda1(this.f34416a, this.f34417b, i11, intent);
    }
}
