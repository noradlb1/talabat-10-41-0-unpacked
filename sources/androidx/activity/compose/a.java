package androidx.activity.compose;

import androidx.activity.result.ActivityResultCallback;
import androidx.compose.runtime.State;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ State f491a;

    public /* synthetic */ a(State state) {
        this.f491a = state;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultRegistryKt$rememberLauncherForActivityResult$1.m3invoke$lambda0(this.f491a, obj);
    }
}
