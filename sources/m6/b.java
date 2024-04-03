package m6;

import android.view.View;
import com.facebook.appevents.aam.MetadataViewObserver;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f34558b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MetadataViewObserver f34559c;

    public /* synthetic */ b(View view, MetadataViewObserver metadataViewObserver) {
        this.f34558b = view;
        this.f34559c = metadataViewObserver;
    }

    public final void run() {
        MetadataViewObserver.m8900process$lambda0(this.f34558b, this.f34559c);
    }
}
