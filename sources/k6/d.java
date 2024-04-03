package k6;

import com.facebook.FacebookException;
import com.facebook.internal.FeatureManager;

public final /* synthetic */ class d implements FeatureManager.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f34509a;

    public /* synthetic */ d(String str) {
        this.f34509a = str;
    }

    public final void onCompleted(boolean z11) {
        FacebookException.m8860_init_$lambda0(this.f34509a, z11);
    }
}
