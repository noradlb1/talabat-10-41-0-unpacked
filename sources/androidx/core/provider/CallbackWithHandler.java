package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {
    @NonNull
    private final FontsContractCompat.FontRequestCallback mCallback;
    @NonNull
    private final Handler mCallbackHandler;

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(final int i11) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post(new Runnable() {
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i11);
            }
        });
    }

    private void onTypefaceRetrieved(@NonNull final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post(new Runnable() {
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        });
    }

    public void a(@NonNull FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            onTypefaceRetrieved(typefaceResult.f11387a);
        } else {
            onTypefaceRequestFailed(typefaceResult.f11388b);
        }
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = CalleeHandler.a();
    }
}
