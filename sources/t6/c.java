package t6;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import org.json.JSONObject;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONObject f34686b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34687c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewOnClickListener f34688d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f34689e;

    public /* synthetic */ c(JSONObject jSONObject, String str, ViewOnClickListener viewOnClickListener, String str2) {
        this.f34686b = jSONObject;
        this.f34687c = str;
        this.f34688d = viewOnClickListener;
        this.f34689e = str2;
    }

    public final void run() {
        ViewOnClickListener.m8930predictAndProcess$lambda0(this.f34686b, this.f34687c, this.f34688d, this.f34689e);
    }
}
