package com.talabat.core.google.login.data.impl;

import ah.a;
import ah.b;
import ah.c;
import ah.d;
import ah.e;
import ah.g;
import ah.h;
import com.talabat.core.google.login.data.datasource.GoogleLoginDataSource;
import com.talabat.core.google.login.data.dto.GoogleLoginDto;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.observability.ObservabilityManager;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p005if.f;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/google/login/data/impl/GoogleLoginRepositoryImpl;", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "googleLoginDataSource", "Lcom/talabat/core/google/login/data/datasource/GoogleLoginDataSource;", "(Lcom/talabat/core/google/login/data/datasource/GoogleLoginDataSource;)V", "initialize", "", "requestIdToken", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository$GoogleLoginResult;", "requestCode", "", "logout", "Lio/reactivex/Completable;", "trackUnexpected", "action", "throwable", "", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleLoginRepositoryImpl implements GoogleLoginRepository {
    @NotNull
    private final GoogleLoginDataSource googleLoginDataSource;

    @Inject
    public GoogleLoginRepositoryImpl(@NotNull GoogleLoginDataSource googleLoginDataSource2) {
        Intrinsics.checkNotNullParameter(googleLoginDataSource2, "googleLoginDataSource");
        this.googleLoginDataSource = googleLoginDataSource2;
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-4  reason: not valid java name */
    public static final void m9602login$lambda4(GoogleLoginRepositoryImpl googleLoginRepositoryImpl, int i11, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(googleLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        singleEmitter.setDisposable(googleLoginRepositoryImpl.googleLoginDataSource.login(i11).map(new c()).doOnError(new d(googleLoginRepositoryImpl)).subscribe(new e(singleEmitter), new f(singleEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-4$lambda-2  reason: not valid java name */
    public static final GoogleLoginRepository.GoogleLoginResult m9603login$lambda4$lambda2(GoogleLoginDto googleLoginDto) {
        Intrinsics.checkNotNullParameter(googleLoginDto, "it");
        return new GoogleLoginRepository.GoogleLoginResult(googleLoginDto.getId(), googleLoginDto.getIdToken(), googleLoginDto.getEmail(), googleLoginDto.getGivenName(), googleLoginDto.getFamilyName());
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-4$lambda-3  reason: not valid java name */
    public static final void m9604login$lambda4$lambda3(GoogleLoginRepositoryImpl googleLoginRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(googleLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        googleLoginRepositoryImpl.trackUnexpected("LogIn", th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-6  reason: not valid java name */
    public static final void m9605logout$lambda6(GoogleLoginRepositoryImpl googleLoginRepositoryImpl, CompletableEmitter completableEmitter) {
        Intrinsics.checkNotNullParameter(googleLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(completableEmitter, "it");
        completableEmitter.setDisposable(googleLoginRepositoryImpl.googleLoginDataSource.logout().doOnError(new ah.f(googleLoginRepositoryImpl)).subscribe(new g(completableEmitter), new h(completableEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-6$lambda-5  reason: not valid java name */
    public static final void m9606logout$lambda6$lambda5(GoogleLoginRepositoryImpl googleLoginRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(googleLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        googleLoginRepositoryImpl.trackUnexpected("LogOut", th2);
    }

    private final void trackUnexpected(String str, Throwable th2) {
        String str2 = "GoogleErrorOn" + str;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario(str2, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    public void initialize(@NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "requestIdToken");
        try {
            Result.Companion companion = Result.Companion;
            this.googleLoginDataSource.initialize(str);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            trackUnexpected("Initialize", r22);
            throw r22;
        }
    }

    @NotNull
    public Single<GoogleLoginRepository.GoogleLoginResult> login(int i11) {
        Single<GoogleLoginRepository.GoogleLoginResult> create = Single.create(new b(this, i11));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …:onError)\n        )\n    }");
        return create;
    }

    @NotNull
    public Completable logout() {
        Completable create = Completable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n        it.setD…:onError)\n        )\n    }");
        return create;
    }
}
