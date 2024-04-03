package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.profileinstaller.ProfileInstaller;
import i2.b;

public class ProfileInstallReceiver extends BroadcastReceiver {
    @NonNull
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    @NonNull
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        public ResultDiagnostics() {
        }

        public void onDiagnosticReceived(int i11, @Nullable Object obj) {
            ProfileInstaller.f37392a.onDiagnosticReceived(i11, obj);
        }

        public void onResultReceived(int i11, @Nullable Object obj) {
            ProfileInstaller.f37392a.onResultReceived(i11, obj);
            ProfileInstallReceiver.this.setResultCode(i11);
        }
    }

    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_INSTALL_PROFILE.equals(action)) {
                ProfileInstaller.g(context, new b(), new ResultDiagnostics(), true);
            } else if (ACTION_SKIP_FILE.equals(action)) {
                String string = intent.getExtras().getString(EXTRA_SKIP_FILE_OPERATION);
                if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(string)) {
                    ProfileInstaller.h(context, new b(), new ResultDiagnostics());
                } else if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(string)) {
                    ProfileInstaller.c(context, new b(), new ResultDiagnostics());
                }
            }
        }
    }
}
