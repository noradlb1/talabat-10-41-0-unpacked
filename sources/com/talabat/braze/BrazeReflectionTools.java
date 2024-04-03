package com.talabat.braze;

import android.content.Context;
import androidx.annotation.NonNull;
import com.braze.Braze;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class BrazeReflectionTools {
    public static void clearBrazeSdkAuthenticationErrorEventSubscribers(@NonNull Context context) {
        try {
            Braze instance = Braze.getInstance(context.getApplicationContext());
            Field declaredField = instance.getClass().getDeclaredField("externalIEventMessenger");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(instance);
            Field declaredField2 = obj.getClass().getDeclaredField("b");
            declaredField2.setAccessible(true);
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) ((ConcurrentMap) declaredField2.get(obj)).get(BrazeSdkAuthenticationErrorEvent.class);
            if (copyOnWriteArraySet != null) {
                copyOnWriteArraySet.clear();
            }
        } catch (Throwable unused) {
        }
    }
}
