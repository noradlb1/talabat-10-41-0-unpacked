package com.talabat.core.facebook.login.domain.integration;

import android.app.Activity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "com_talabat_core_social-login_facebook_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FacebookLoginActivityIntegration {
    @Nullable
    Activity getActivity();

    void setActivity(@Nullable Activity activity);
}
