package io.flutter.embedding.android;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import pz.h;

public class KeyChannelResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyChannelResponder";
    @NonNull
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();
    @NonNull
    private final KeyEventChannel keyEventChannel;

    public KeyChannelResponder(@NonNull KeyEventChannel keyEventChannel2) {
        this.keyEventChannel = keyEventChannel2;
    }

    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        int action = keyEvent.getAction();
        boolean z11 = false;
        if (action == 0 || action == 1) {
            KeyEventChannel.FlutterKeyEvent flutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, this.characterCombiner.a(keyEvent.getUnicodeChar()));
            if (action != 0) {
                z11 = true;
            }
            this.keyEventChannel.sendFlutterKeyEvent(flutterKeyEvent, z11, new h(onKeyEventHandledCallback));
            return;
        }
        onKeyEventHandledCallback.onKeyEventHandled(false);
    }
}
