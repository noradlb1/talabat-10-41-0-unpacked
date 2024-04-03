package qa;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f50739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50740c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f50741d;

    public /* synthetic */ j(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        this.f50739b = biConsumer;
        this.f50740c = str;
        this.f50741d = configContainer;
    }

    public final void run() {
        this.f50739b.accept(this.f50740c, this.f50741d);
    }
}
