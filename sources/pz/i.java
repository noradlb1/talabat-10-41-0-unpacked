package pz;

import io.flutter.embedding.android.KeyEmbedderResponder;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class i implements BinaryMessenger.BinaryReply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f24070a;

    public /* synthetic */ i(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f24070a = onKeyEventHandledCallback;
    }

    public final void reply(ByteBuffer byteBuffer) {
        KeyEmbedderResponder.lambda$sendKeyEvent$2(this.f24070a, byteBuffer);
    }
}
