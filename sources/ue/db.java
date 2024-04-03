package ue;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.MenuSearchActivity;

public final /* synthetic */ class db implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuSearchActivity f57491a;

    public /* synthetic */ db(MenuSearchActivity menuSearchActivity) {
        this.f57491a = menuSearchActivity;
    }

    public final void onActivityResult(Object obj) {
        this.f57491a.lambda$onCreate$0((ActivityResult) obj);
    }
}
