package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebMessageCompat;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

public class WebMessagePayloadAdapter implements WebMessagePayloadBoundaryInterface {
    @NonNull
    private final WebMessageCompat mMessageCompat;

    public WebMessagePayloadAdapter(@NonNull WebMessageCompat webMessageCompat) {
        this.mMessageCompat = webMessageCompat;
    }

    @NonNull
    public byte[] getAsArrayBuffer() {
        return this.mMessageCompat.getArrayBuffer();
    }

    @Nullable
    public String getAsString() {
        return this.mMessageCompat.getData();
    }

    @NonNull
    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public int getType() {
        int type = this.mMessageCompat.getType();
        if (type == 0) {
            return 0;
        }
        if (type == 1) {
            return 1;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
