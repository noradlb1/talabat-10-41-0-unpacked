package b7;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f29324a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29325b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Date f29326c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Date f29327d;

    public /* synthetic */ b(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2) {
        this.f29324a = deviceAuthDialog;
        this.f29325b = str;
        this.f29326c = date;
        this.f29327d = date2;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m8989onSuccess$lambda10(this.f29324a, this.f29325b, this.f29326c, this.f29327d, graphResponse);
    }
}
