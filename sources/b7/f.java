package b7;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.DeviceAuthDialog;

public final /* synthetic */ class f implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f29331a;

    public /* synthetic */ f(DeviceAuthDialog deviceAuthDialog) {
        this.f29331a = deviceAuthDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m8993startLogin$lambda1(this.f29331a, graphResponse);
    }
}
