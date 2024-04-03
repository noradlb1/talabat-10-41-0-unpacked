package k;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;

public final /* synthetic */ class k {
    @NonNull
    public static TrustedWebActivityDisplayMode a(@NonNull Bundle bundle) {
        if (bundle.getInt(TrustedWebActivityDisplayMode.KEY_ID) != 1) {
            return new TrustedWebActivityDisplayMode.DefaultMode();
        }
        return TrustedWebActivityDisplayMode.ImmersiveMode.a(bundle);
    }
}
