package com.talabat.core.google.login.data.impl;

import android.app.Activity;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import io.reactivex.processors.PublishProcessor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/google/login/data/impl/GoogleLoginActivityIntegrationImpl;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "googleSignInAccountProcessor", "Lio/reactivex/processors/PublishProcessor;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult;", "getGoogleSignInAccountProcessor", "()Lio/reactivex/processors/PublishProcessor;", "onActivityResult", "", "data", "Landroid/content/Intent;", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleLoginActivityIntegrationImpl implements GoogleLoginActivityIntegration {
    @Nullable
    private Activity activity;
    @NotNull
    private final PublishProcessor<GoogleLoginActivityIntegration.GoogleLoginActivityResult> googleSignInAccountProcessor;

    @Inject
    public GoogleLoginActivityIntegrationImpl() {
        PublishProcessor<GoogleLoginActivityIntegration.GoogleLoginActivityResult> create = PublishProcessor.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.googleSignInAccountProcessor = create;
    }

    @Nullable
    public Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public PublishProcessor<GoogleLoginActivityIntegration.GoogleLoginActivityResult> getGoogleSignInAccountProcessor() {
        return this.googleSignInAccountProcessor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(@org.jetbrains.annotations.NotNull android.content.Intent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0018 }
            com.google.android.gms.tasks.Task r9 = com.google.android.gms.auth.api.signin.GoogleSignIn.getSignedInAccountFromIntent(r9)     // Catch:{ all -> 0x0018 }
            java.lang.Class<com.google.android.gms.common.api.ApiException> r0 = com.google.android.gms.common.api.ApiException.class
            java.lang.Object r9 = r9.getResult(r0)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r9     // Catch:{ all -> 0x0018 }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0018 }
            goto L_0x0023
        L_0x0018:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0023:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r9)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x006c
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r9     // Catch:{ all -> 0x0065 }
            com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success r0 = new com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = r9.getId()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0037
            r3 = r1
            goto L_0x0038
        L_0x0037:
            r3 = r2
        L_0x0038:
            java.lang.String r2 = r9.getIdToken()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0040
            r4 = r1
            goto L_0x0041
        L_0x0040:
            r4 = r2
        L_0x0041:
            java.lang.String r2 = r9.getEmail()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0049
            r5 = r1
            goto L_0x004a
        L_0x0049:
            r5 = r2
        L_0x004a:
            java.lang.String r2 = r9.getGivenName()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0052
            r6 = r1
            goto L_0x0053
        L_0x0052:
            r6 = r2
        L_0x0053:
            java.lang.String r9 = r9.getFamilyName()     // Catch:{ all -> 0x0065 }
            if (r9 != 0) goto L_0x005b
            r7 = r1
            goto L_0x005c
        L_0x005b:
            r7 = r9
        L_0x005c:
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0065 }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0065 }
            goto L_0x0070
        L_0x0065:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
        L_0x006c:
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0070:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r9)
            if (r0 == 0) goto L_0x0080
            r0 = r9
            com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success r0 = (com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration.GoogleLoginActivityResult.Success) r0
            io.reactivex.processors.PublishProcessor r2 = r8.getGoogleSignInAccountProcessor()
            r2.offer(r0)
        L_0x0080:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r9 == 0) goto L_0x009a
            io.reactivex.processors.PublishProcessor r0 = r8.getGoogleSignInAccountProcessor()
            com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration$GoogleLoginActivityResult$Error r2 = new com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration$GoogleLoginActivityResult$Error
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r1 = r9
        L_0x0094:
            r2.<init>(r1)
            r0.offer(r2)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.google.login.data.impl.GoogleLoginActivityIntegrationImpl.onActivityResult(android.content.Intent):void");
    }

    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }
}
