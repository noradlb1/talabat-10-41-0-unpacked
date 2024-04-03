package b7;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.DeviceAuthDialog;

public final /* synthetic */ class e implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f29330a;

    public /* synthetic */ e(DeviceAuthDialog deviceAuthDialog) {
        this.f29330a = deviceAuthDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m8987_get_pollRequest_$lambda5(this.f29330a, graphResponse);
    }
}
