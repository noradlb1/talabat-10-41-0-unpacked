package com.talabat.core.facebook.login.data.integration;

import android.app.Activity;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/facebook/login/data/integration/FacebookLoginActivityIntegrationImpl;", "Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "()V", "value", "Landroid/app/Activity;", "activity", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "activityHolder", "Ljava/lang/ref/WeakReference;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginActivityIntegrationImpl implements FacebookLoginActivityIntegration {
    @Nullable
    private WeakReference<Activity> activityHolder;

    @Nullable
    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.activityHolder;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setActivity(@Nullable Activity activity) {
        this.activityHolder = new WeakReference<>(activity);
    }
}
