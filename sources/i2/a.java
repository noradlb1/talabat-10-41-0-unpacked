package i2;

import androidx.profileinstaller.DeviceProfileWriter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f44340b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44341c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f44342d;

    public /* synthetic */ a(DeviceProfileWriter deviceProfileWriter, int i11, Object obj) {
        this.f44340b = deviceProfileWriter;
        this.f44341c = i11;
        this.f44342d = obj;
    }

    public final void run() {
        this.f44340b.lambda$result$0(this.f44341c, this.f44342d);
    }
}
