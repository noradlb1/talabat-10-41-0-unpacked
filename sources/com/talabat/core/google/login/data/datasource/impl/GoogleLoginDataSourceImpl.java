package com.talabat.core.google.login.data.datasource.impl;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.google.login.data.GoogleLoginException;
import com.talabat.core.google.login.data.GoogleLoginInitializeException;
import com.talabat.core.google.login.data.GoogleLoginNotInitializedException;
import com.talabat.core.google.login.data.GoogleLogoutException;
import com.talabat.core.google.login.data.datasource.GoogleLoginDataSource;
import com.talabat.core.google.login.data.dto.GoogleLoginDto;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yg.a;
import yg.b;
import yg.c;
import yg.d;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/google/login/data/datasource/impl/GoogleLoginDataSourceImpl;", "Lcom/talabat/core/google/login/data/datasource/GoogleLoginDataSource;", "context", "Landroid/content/Context;", "googleLoginActivityIntegration", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "(Landroid/content/Context;Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;)V", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "initialize", "", "requestIdToken", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/google/login/data/dto/GoogleLoginDto;", "requestCode", "", "logout", "Lio/reactivex/Completable;", "toGoogleLoginDto", "googleLoginActivityResult", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success;", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleLoginDataSourceImpl implements GoogleLoginDataSource {
    @NotNull
    private final Context context;
    @NotNull
    private final GoogleLoginActivityIntegration googleLoginActivityIntegration;
    private GoogleSignInClient googleSignInClient;

    @Inject
    public GoogleLoginDataSourceImpl(@NotNull @ApplicationContext Context context2, @NotNull GoogleLoginActivityIntegration googleLoginActivityIntegration2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(googleLoginActivityIntegration2, "googleLoginActivityIntegration");
        this.context = context2;
        this.googleLoginActivityIntegration = googleLoginActivityIntegration2;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.Unit] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: login$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9597login$lambda4(com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl r3, int r4, io.reactivex.SingleEmitter r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "emitter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.google.android.gms.auth.api.signin.GoogleSignInClient r0 = r3.googleSignInClient
            if (r0 == 0) goto L_0x0059
            com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration r0 = r3.googleLoginActivityIntegration
            android.app.Activity r0 = r0.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.auth.api.signin.GoogleSignInClient r2 = r3.googleSignInClient
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "googleSignInClient"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            android.content.Intent r1 = r1.getSignInIntent()
            r0.startActivityForResult(r1, r4)
            com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration r4 = r3.googleLoginActivityIntegration
            io.reactivex.processors.PublishProcessor r4 = r4.getGoogleSignInAccountProcessor()
            yg.e r0 = new yg.e
            r0.<init>(r3)
            io.reactivex.Flowable r3 = r4.map(r0)
            yg.f r4 = new yg.f
            r4.<init>(r5)
            if.f r0 = new if.f
            r0.<init>(r5)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r4, r0)
            r5.setDisposable(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x004c:
            if (r1 != 0) goto L_0x0063
            com.talabat.core.google.login.data.GoogleLoginCallingActivityNotSetException r3 = new com.talabat.core.google.login.data.GoogleLoginCallingActivityNotSetException
            java.lang.String r4 = "Please make sure you set the caller activity to GoogleActivityIntegration"
            r3.<init>(r4)
            r5.onError(r3)
            goto L_0x0063
        L_0x0059:
            com.talabat.core.google.login.data.GoogleLoginNotInitializedException r3 = new com.talabat.core.google.login.data.GoogleLoginNotInitializedException
            java.lang.String r4 = "Please make sure you invoke initialize() before trying to logIn"
            r3.<init>(r4)
            r5.onError(r3)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl.m9597login$lambda4(com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl, int, io.reactivex.SingleEmitter):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final GoogleLoginDto m9598login$lambda4$lambda3$lambda2(GoogleLoginDataSourceImpl googleLoginDataSourceImpl, GoogleLoginActivityIntegration.GoogleLoginActivityResult googleLoginActivityResult) {
        Intrinsics.checkNotNullParameter(googleLoginDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(googleLoginActivityResult, "it");
        if (googleLoginActivityResult instanceof GoogleLoginActivityIntegration.GoogleLoginActivityResult.Error) {
            throw new GoogleLoginException(((GoogleLoginActivityIntegration.GoogleLoginActivityResult.Error) googleLoginActivityResult).getCause());
        } else if (googleLoginActivityResult instanceof GoogleLoginActivityIntegration.GoogleLoginActivityResult.Success) {
            return googleLoginDataSourceImpl.toGoogleLoginDto((GoogleLoginActivityIntegration.GoogleLoginActivityResult.Success) googleLoginActivityResult);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-7  reason: not valid java name */
    public static final void m9599logout$lambda7(GoogleLoginDataSourceImpl googleLoginDataSourceImpl, CompletableEmitter completableEmitter) {
        Intrinsics.checkNotNullParameter(googleLoginDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(completableEmitter, "emitter");
        GoogleSignInClient googleSignInClient2 = googleLoginDataSourceImpl.googleSignInClient;
        if (googleSignInClient2 != null) {
            if (googleSignInClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
                googleSignInClient2 = null;
            }
            googleSignInClient2.signOut().addOnSuccessListener(new b(completableEmitter)).addOnFailureListener(new c(completableEmitter));
            return;
        }
        completableEmitter.onError(new GoogleLoginNotInitializedException("Please make sure you invoke initialize() before trying to logOut"));
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-7$lambda-5  reason: not valid java name */
    public static final void m9600logout$lambda7$lambda5(CompletableEmitter completableEmitter, Void voidR) {
        Intrinsics.checkNotNullParameter(completableEmitter, "$emitter");
        completableEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-7$lambda-6  reason: not valid java name */
    public static final void m9601logout$lambda7$lambda6(CompletableEmitter completableEmitter, Exception exc) {
        Intrinsics.checkNotNullParameter(completableEmitter, "$emitter");
        Intrinsics.checkNotNullParameter(exc, "it");
        completableEmitter.onError(new GoogleLogoutException(exc));
    }

    private final GoogleLoginDto toGoogleLoginDto(GoogleLoginActivityIntegration.GoogleLoginActivityResult.Success success) {
        return new GoogleLoginDto(success.getId(), success.getIdToken(), success.getEmail(), success.getGivenName(), success.getFamilyName());
    }

    public void initialize(@NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "requestIdToken");
        try {
            Result.Companion companion = Result.Companion;
            GoogleSignInClient client = GoogleSignIn.getClient(this.context, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(str).build());
            Intrinsics.checkNotNullExpressionValue(client, "getClient(\n             …   .build()\n            )");
            this.googleSignInClient = client;
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            throw new GoogleLoginInitializeException(r42);
        }
    }

    @NotNull
    public Single<GoogleLoginDto> login(int i11) {
        Single<GoogleLoginDto> create = Single.create(new a(this, i11));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …        )\n        )\n    }");
        return create;
    }

    @NotNull
    public Completable logout() {
        Completable create = Completable.create(new d(this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …        )\n        )\n    }");
        return create;
    }
}
