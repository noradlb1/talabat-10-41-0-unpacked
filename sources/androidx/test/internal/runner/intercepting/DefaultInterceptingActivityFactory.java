package androidx.test.internal.runner.intercepting;

import android.app.Activity;
import android.content.Intent;
import androidx.test.runner.intercepting.InterceptingActivityFactory;

public final class DefaultInterceptingActivityFactory implements InterceptingActivityFactory {
    public Activity create(ClassLoader classLoader, String str, Intent intent) {
        throw new UnsupportedOperationException();
    }

    public boolean shouldIntercept(ClassLoader classLoader, String str, Intent intent) {
        return false;
    }
}
