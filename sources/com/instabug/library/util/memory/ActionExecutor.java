package com.instabug.library.util.memory;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.instabug.library.util.memory.predicate.Predicate;

public class ActionExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final Predicate[] f52070a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52071b;

    public ActionExecutor(Predicate... predicateArr) {
        this.f52070a = predicateArr;
    }

    private boolean a() {
        for (Predicate check : this.f52070a) {
            if (!check.check()) {
                return false;
            }
        }
        return true;
    }

    public void doAction(@NonNull Action action) {
        try {
            if (a()) {
                action.onAffirmed();
                return;
            }
            if (this.f52071b != null) {
                InstabugCore.reportError(new Exception(StringUtility.formatOOMExceptionMessage(this.f52071b)), StringUtility.formatOOMExceptionMessage(this.f52071b));
            }
            action.onDenied();
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error: " + th2.getMessage() + "while executing action: " + this.f52071b);
        }
    }

    public void doActionWithWarning(@NonNull String str, @NonNull Action action) {
        try {
            if (a()) {
                action.onAffirmed();
                return;
            }
            a(str);
            if (this.f52071b != null) {
                InstabugCore.reportError(new Exception(StringUtility.formatOOMExceptionMessage(this.f52071b)), StringUtility.formatOOMExceptionMessage(this.f52071b));
            }
            action.onDenied();
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error: " + th2.getMessage() + "while executing action: " + this.f52071b);
        }
    }

    public ActionExecutor forOperation(@Nullable String str) {
        this.f52071b = str;
        return this;
    }

    private void a(String str) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            InstabugSDKLogger.e("IBG-Core", "unable to show Warning Message due to null context");
        } else {
            Toast.makeText(applicationContext, str, 0).show();
        }
    }

    public void doAction(@NonNull Action action, @NonNull ThrowableAction throwableAction) {
        try {
            if (a()) {
                action.onAffirmed();
                return;
            }
            if (this.f52071b != null) {
                InstabugCore.reportError(new Exception(StringUtility.formatOOMExceptionMessage(this.f52071b)), StringUtility.formatOOMExceptionMessage(this.f52071b));
            }
            action.onDenied();
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error: " + th2.getMessage() + "while executing action: " + this.f52071b);
            throwableAction.onDetected(th2);
        }
    }

    public void doActionWithWarning(@NonNull String str, @NonNull Action action, @NonNull ThrowableAction throwableAction) {
        try {
            if (a()) {
                action.onAffirmed();
                return;
            }
            a(str);
            if (this.f52071b != null) {
                InstabugCore.reportError(new Exception(StringUtility.formatOOMExceptionMessage(this.f52071b)), StringUtility.formatOOMExceptionMessage(this.f52071b));
            }
            action.onDenied();
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Error: " + th2.getMessage() + "while executing action: " + this.f52071b);
            throwableAction.onDetected(th2);
        }
    }
}
