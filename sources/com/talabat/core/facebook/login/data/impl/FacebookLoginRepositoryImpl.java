package com.talabat.core.facebook.login.data.impl;

import com.talabat.core.facebook.login.data.datasource.FacebookLoginDataSource;
import com.talabat.core.facebook.login.data.dto.FacebookLoginDataRequestDto;
import com.talabat.core.facebook.login.data.dto.FacebookLoginResultDto;
import com.talabat.core.facebook.login.domain.FacebookPermission;
import com.talabat.core.facebook.login.domain.FacebookProfileData;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.observability.ObservabilityManager;
import ig.a;
import ig.b;
import ig.c;
import ig.d;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/facebook/login/data/impl/FacebookLoginRepositoryImpl;", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "facebookLoginDataSource", "Lcom/talabat/core/facebook/login/data/datasource/FacebookLoginDataSource;", "(Lcom/talabat/core/facebook/login/data/datasource/FacebookLoginDataSource;)V", "initialize", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$LoginResult;", "facebookPermissions", "", "Lcom/talabat/core/facebook/login/domain/FacebookPermission;", "logout", "observe", "action", "", "throwable", "", "requestData", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$DataResult;", "data", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginRepositoryImpl implements FacebookLoginRepository {
    @NotNull
    private final FacebookLoginDataSource facebookLoginDataSource;

    @Inject
    public FacebookLoginRepositoryImpl(@NotNull FacebookLoginDataSource facebookLoginDataSource2) {
        Intrinsics.checkNotNullParameter(facebookLoginDataSource2, "facebookLoginDataSource");
        this.facebookLoginDataSource = facebookLoginDataSource2;
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-0  reason: not valid java name */
    public static final FacebookLoginRepository.LoginResult m9582login$lambda0(FacebookLoginResultDto facebookLoginResultDto) {
        Intrinsics.checkNotNullParameter(facebookLoginResultDto, "it");
        return new FacebookLoginRepository.LoginResult(facebookLoginResultDto.getUserId(), facebookLoginResultDto.getToken());
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-1  reason: not valid java name */
    public static final void m9583login$lambda1(FacebookLoginRepositoryImpl facebookLoginRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(facebookLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        facebookLoginRepositoryImpl.observe("LogIn", th2);
    }

    private final void observe(String str, Throwable th2) {
        String str2 = "FacebookErrorOn" + str;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario(str2, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-2  reason: not valid java name */
    public static final FacebookLoginRepository.DataResult m9584requestData$lambda2(FacebookLoginDataRequestDto facebookLoginDataRequestDto) {
        Intrinsics.checkNotNullParameter(facebookLoginDataRequestDto, "it");
        return new FacebookLoginRepository.DataResult(facebookLoginDataRequestDto.getData());
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-3  reason: not valid java name */
    public static final void m9585requestData$lambda3(FacebookLoginRepositoryImpl facebookLoginRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(facebookLoginRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        facebookLoginRepositoryImpl.observe("RequestData", th2);
    }

    public void initialize() {
        this.facebookLoginDataSource.initialize();
    }

    @NotNull
    public Single<FacebookLoginRepository.LoginResult> login(@NotNull List<? extends FacebookPermission> list) {
        Intrinsics.checkNotNullParameter(list, "facebookPermissions");
        Single<R> doOnError = this.facebookLoginDataSource.login(list).map(new c()).doOnError(new d(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "facebookLoginDataSource\n…LogIn\", throwable = it) }");
        return doOnError;
    }

    public void logout() {
        this.facebookLoginDataSource.logout();
    }

    @NotNull
    public Single<FacebookLoginRepository.DataResult> requestData(@NotNull List<? extends FacebookProfileData> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        Single<R> doOnError = this.facebookLoginDataSource.requestData(list).map(new a()).doOnError(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "facebookLoginDataSource\n…tData\", throwable = it) }");
        return doOnError;
    }
}
