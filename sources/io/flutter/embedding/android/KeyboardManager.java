package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.InputConnectionAdaptor;
import java.util.HashSet;

public class KeyboardManager implements InputConnectionAdaptor.KeyboardDelegate {
    private static final String TAG = "KeyboardManager";

    /* renamed from: a  reason: collision with root package name */
    public final Responder[] f14156a;
    private final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    private final ViewDelegate viewDelegate;

    public static class CharacterCombiner {
        private int combiningCharacter = 0;

        public Character a(int i11) {
            boolean z11;
            char c11 = (char) i11;
            if ((Integer.MIN_VALUE & i11) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i12 = i11 & Integer.MAX_VALUE;
                int i13 = this.combiningCharacter;
                if (i13 != 0) {
                    this.combiningCharacter = KeyCharacterMap.getDeadChar(i13, i12);
                } else {
                    this.combiningCharacter = i12;
                }
            } else {
                int i14 = this.combiningCharacter;
                if (i14 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i14, i11);
                    if (deadChar > 0) {
                        c11 = (char) deadChar;
                    }
                    this.combiningCharacter = 0;
                }
            }
            return Character.valueOf(c11);
        }
    }

    public class PerEventCallbackBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final KeyEvent f14157a;

        /* renamed from: b  reason: collision with root package name */
        public int f14158b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14159c = false;

        public class Callback implements Responder.OnKeyEventHandledCallback {

            /* renamed from: a  reason: collision with root package name */
            public boolean f14161a;

            private Callback() {
                this.f14161a = false;
            }

            public void onKeyEventHandled(boolean z11) {
                if (!this.f14161a) {
                    this.f14161a = true;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    int i11 = perEventCallbackBuilder.f14158b - 1;
                    perEventCallbackBuilder.f14158b = i11;
                    boolean z12 = z11 | perEventCallbackBuilder.f14159c;
                    perEventCallbackBuilder.f14159c = z12;
                    if (i11 == 0 && !z12) {
                        KeyboardManager.this.onUnhandled(perEventCallbackBuilder.f14157a);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        public PerEventCallbackBuilder(@NonNull KeyEvent keyEvent) {
            this.f14158b = KeyboardManager.this.f14156a.length;
            this.f14157a = keyEvent;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public interface Responder {

        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(boolean z11);
        }

        void handleEvent(@NonNull KeyEvent keyEvent, @NonNull OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public interface ViewDelegate {
        BinaryMessenger getBinaryMessenger();

        boolean onTextInputKeyEvent(@NonNull KeyEvent keyEvent);

        void redispatch(@NonNull KeyEvent keyEvent);
    }

    public KeyboardManager(@NonNull ViewDelegate viewDelegate2) {
        this.viewDelegate = viewDelegate2;
        this.f14156a = new Responder[]{new KeyEmbedderResponder(viewDelegate2.getBinaryMessenger()), new KeyChannelResponder(new KeyEventChannel(viewDelegate2.getBinaryMessenger()))};
    }

    /* access modifiers changed from: private */
    public void onUnhandled(@NonNull KeyEvent keyEvent) {
        ViewDelegate viewDelegate2 = this.viewDelegate;
        if (viewDelegate2 != null && !viewDelegate2.onTextInputKeyEvent(keyEvent)) {
            this.redispatchedEvents.add(keyEvent);
            this.viewDelegate.redispatch(keyEvent);
            if (this.redispatchedEvents.remove(keyEvent)) {
                Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public boolean handleEvent(@NonNull KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.f14156a.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.f14156a) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        onUnhandled(keyEvent);
        return true;
    }
}
