package a2;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f35595b;

    public /* synthetic */ h(FragmentManager fragmentManager) {
        this.f35595b = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f35595b.lambda$new$2((MultiWindowModeChangedInfo) obj);
    }
}
