package pz;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public final /* synthetic */ class h implements KeyEventChannel.EventResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f24069a;

    public /* synthetic */ h(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f24069a = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z11) {
        this.f24069a.onKeyEventHandled(z11);
    }
}
