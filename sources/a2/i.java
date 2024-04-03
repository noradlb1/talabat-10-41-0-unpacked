package a2;

import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f35596b;

    public /* synthetic */ i(FragmentManager fragmentManager) {
        this.f35596b = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f35596b.lambda$new$3((PictureInPictureModeChangedInfo) obj);
    }
}
