package r4;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigatorImpl;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageSelectionNavigatorImpl f34647a;

    public /* synthetic */ a(ImageSelectionNavigatorImpl imageSelectionNavigatorImpl) {
        this.f34647a = imageSelectionNavigatorImpl;
    }

    public final void onActivityResult(Object obj) {
        ImageSelectionNavigatorImpl.m8164galleryResultLauncher$lambda1(this.f34647a, (Uri) obj);
    }
}
