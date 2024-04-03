package com.checkout.logging;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.checkout.BuildConfig;
import com.checkout.base.model.Environment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0004H&J,\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/checkout/logging/Logger;", "T", "", "log", "", "event", "(Ljava/lang/Object;)V", "logOnce", "resetSession", "setup", "context", "Landroid/content/Context;", "environment", "Lcom/checkout/base/model/Environment;", "identifier", "", "version", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Logger<T> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setup$default(Logger logger, Context context, Environment environment, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str = BuildConfig.PRODUCT_IDENTIFIER;
                }
                if ((i11 & 8) != 0) {
                    str2 = "4.0.2";
                }
                logger.setup(context, environment, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setup");
        }
    }

    void log(T t11);

    void logOnce(T t11);

    void resetSession();

    void setup(@NotNull Context context, @NotNull Environment environment, @NotNull String str, @NotNull String str2);
}
