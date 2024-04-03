package r4;

import androidx.activity.result.ActivityResultCallback;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigatorImpl;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageSelectionNavigatorImpl f34648a;

    public /* synthetic */ b(ImageSelectionNavigatorImpl imageSelectionNavigatorImpl) {
        this.f34648a = imageSelectionNavigatorImpl;
    }

    public final void onActivityResult(Object obj) {
        ImageSelectionNavigatorImpl.m8163cameraResultLauncher$lambda2(this.f34648a, (Boolean) obj);
    }
}
