package com.android.volley;

import androidx.test.espresso.IdlingResource;
import com.talabat.helpers.TalabatVolley;
import com.talabat.talabatcore.logger.LogManager;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/volley/VolleyIdlingResource;", "Landroidx/test/espresso/IdlingResource;", "resourceName", "", "(Ljava/lang/String;)V", "mCurrentRequests", "Ljava/lang/reflect/Field;", "mVolleyRequestQueue", "Lcom/android/volley/RequestQueue;", "resourceCallback", "Landroidx/test/espresso/IdlingResource$ResourceCallback;", "getName", "isIdleNow", "", "registerIdleTransitionCallback", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VolleyIdlingResource implements IdlingResource {
    @NotNull
    private final Field mCurrentRequests;
    @NotNull
    private final RequestQueue mVolleyRequestQueue;
    @Nullable
    private volatile IdlingResource.ResourceCallback resourceCallback;
    @NotNull
    private final String resourceName;

    public VolleyIdlingResource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resourceName");
        this.resourceName = str;
        Field declaredField = RequestQueue.class.getDeclaredField("mCurrentRequests");
        Intrinsics.checkNotNullExpressionValue(declaredField, "RequestQueue::class.java…Field(\"mCurrentRequests\")");
        this.mCurrentRequests = declaredField;
        RequestQueue requestQueue = TalabatVolley.getRequestQueue();
        Intrinsics.checkNotNullExpressionValue(requestQueue, "getRequestQueue()");
        this.mVolleyRequestQueue = requestQueue;
        declaredField.setAccessible(true);
    }

    @NotNull
    public String getName() {
        return this.resourceName;
    }

    public boolean isIdleNow() {
        boolean z11;
        try {
            Object obj = this.mCurrentRequests.get(this.mVolleyRequestQueue);
            if (obj != null) {
                int size = ((Set) obj).size();
                if (size == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    LogManager.debug("Volley is idle now! with: " + size);
                    IdlingResource.ResourceCallback resourceCallback2 = this.resourceCallback;
                    if (resourceCallback2 != null) {
                        resourceCallback2.onTransitionToIdle();
                    }
                } else {
                    LogManager.debug("Not idle... " + size);
                }
                return z11;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<*>");
        } catch (Exception e11) {
            LogManager.error$default(e11, (String) null, 2, (Object) null);
            return true;
        }
    }

    public void registerIdleTransitionCallback(@NotNull IdlingResource.ResourceCallback resourceCallback2) {
        Intrinsics.checkNotNullParameter(resourceCallback2, "resourceCallback");
        this.resourceCallback = resourceCallback2;
    }
}
