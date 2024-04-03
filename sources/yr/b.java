package yr;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterWebViewActivity f63075a;

    public /* synthetic */ b(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity) {
        this.f63075a = globalHelpCenterWebViewActivity;
    }

    public final void onActivityResult(Object obj) {
        GlobalHelpCenterWebViewActivity.m10622initializeResultLauncher$lambda0(this.f63075a, (ActivityResult) obj);
    }
}
