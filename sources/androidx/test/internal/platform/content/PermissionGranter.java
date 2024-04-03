package androidx.test.internal.platform.content;

import androidx.annotation.NonNull;

public interface PermissionGranter {
    void addPermissions(@NonNull String... strArr);

    void requestPermissions();
}
