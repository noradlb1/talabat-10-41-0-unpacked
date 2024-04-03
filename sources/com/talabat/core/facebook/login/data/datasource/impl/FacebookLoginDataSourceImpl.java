package com.talabat.core.facebook.login.data.datasource.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistryOwner;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.facebook.login.data.FacebookAccessTokenNotFoundException;
import com.talabat.core.facebook.login.data.FacebookAccessTokenProvider;
import com.talabat.core.facebook.login.data.FacebookLoginActivityNotSetException;
import com.talabat.core.facebook.login.data.FacebookLoginCancelledException;
import com.talabat.core.facebook.login.data.FacebookLoginException;
import com.talabat.core.facebook.login.data.FacebookLoginRequestException;
import com.talabat.core.facebook.login.data.FacebookLoginUnknownException;
import com.talabat.core.facebook.login.data.datasource.FacebookLoginDataSource;
import com.talabat.core.facebook.login.data.datasource.GraphRequestFactory;
import com.talabat.core.facebook.login.data.dto.FacebookLoginDataRequestDto;
import com.talabat.core.facebook.login.data.dto.FacebookLoginResultDto;
import com.talabat.core.facebook.login.domain.FacebookPermission;
import com.talabat.core.facebook.login.domain.FacebookProfileData;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import gg.a;
import gg.b;
import gg.c;
import gg.d;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u0001:\u0002 !B9\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0016J(\u0010\u001c\u001a\u00020\u0010*\u00020\u001d2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/core/facebook/login/data/datasource/impl/FacebookLoginDataSourceImpl;", "Lcom/talabat/core/facebook/login/data/datasource/FacebookLoginDataSource;", "context", "Landroid/content/Context;", "callbackManager", "Lcom/facebook/CallbackManager;", "loginManager", "Lcom/facebook/login/LoginManager;", "accessTokenProvider", "Lcom/talabat/core/facebook/login/data/FacebookAccessTokenProvider;", "graphRequestFactory", "Lcom/talabat/core/facebook/login/data/datasource/GraphRequestFactory;", "facebookLoginActivityIntegration", "Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "(Landroid/content/Context;Lcom/facebook/CallbackManager;Lcom/facebook/login/LoginManager;Lcom/talabat/core/facebook/login/data/FacebookAccessTokenProvider;Lcom/talabat/core/facebook/login/data/datasource/GraphRequestFactory;Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;)V", "initialize", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/facebook/login/data/dto/FacebookLoginResultDto;", "facebookPermissions", "", "Lcom/talabat/core/facebook/login/domain/FacebookPermission;", "logout", "requestData", "Lcom/talabat/core/facebook/login/data/dto/FacebookLoginDataRequestDto;", "data", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "performLogin", "Landroidx/activity/ComponentActivity;", "emitter", "Lio/reactivex/SingleEmitter;", "Companion", "FacebookLoginResultCallback", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginDataSourceImpl implements FacebookLoginDataSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String REQUEST_FIELDS_KEY = "fields";
    @NotNull
    private final FacebookAccessTokenProvider accessTokenProvider;
    @NotNull
    private final CallbackManager callbackManager;
    @NotNull
    private final Context context;
    @NotNull
    private final FacebookLoginActivityIntegration facebookLoginActivityIntegration;
    @NotNull
    private final GraphRequestFactory graphRequestFactory;
    @NotNull
    private final LoginManager loginManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/facebook/login/data/datasource/impl/FacebookLoginDataSourceImpl$Companion;", "", "()V", "REQUEST_FIELDS_KEY", "", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/facebook/login/data/datasource/impl/FacebookLoginDataSourceImpl$FacebookLoginResultCallback;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/talabat/core/facebook/login/data/dto/FacebookLoginResultDto;", "(Lio/reactivex/SingleEmitter;)V", "onCancel", "", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "result", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FacebookLoginResultCallback implements FacebookCallback<LoginResult> {
        @NotNull
        private final SingleEmitter<FacebookLoginResultDto> emitter;

        public FacebookLoginResultCallback(@NotNull SingleEmitter<FacebookLoginResultDto> singleEmitter) {
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            this.emitter = singleEmitter;
        }

        public void onCancel() {
            this.emitter.onError(new FacebookLoginCancelledException());
        }

        public void onError(@NotNull FacebookException facebookException) {
            Intrinsics.checkNotNullParameter(facebookException, "error");
            this.emitter.onError(new FacebookLoginException(facebookException));
        }

        public void onSuccess(@NotNull LoginResult loginResult) {
            Intrinsics.checkNotNullParameter(loginResult, "result");
            this.emitter.onSuccess(new FacebookLoginResultDto(loginResult.getAccessToken().getUserId(), loginResult.getAccessToken().getToken()));
        }
    }

    @Inject
    public FacebookLoginDataSourceImpl(@NotNull @ApplicationContext Context context2, @NotNull CallbackManager callbackManager2, @NotNull LoginManager loginManager2, @NotNull FacebookAccessTokenProvider facebookAccessTokenProvider, @NotNull GraphRequestFactory graphRequestFactory2, @NotNull FacebookLoginActivityIntegration facebookLoginActivityIntegration2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(loginManager2, "loginManager");
        Intrinsics.checkNotNullParameter(facebookAccessTokenProvider, "accessTokenProvider");
        Intrinsics.checkNotNullParameter(graphRequestFactory2, "graphRequestFactory");
        Intrinsics.checkNotNullParameter(facebookLoginActivityIntegration2, "facebookLoginActivityIntegration");
        this.context = context2;
        this.callbackManager = callbackManager2;
        this.loginManager = loginManager2;
        this.accessTokenProvider = facebookAccessTokenProvider;
        this.graphRequestFactory = graphRequestFactory2;
        this.facebookLoginActivityIntegration = facebookLoginActivityIntegration2;
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-0  reason: not valid java name */
    public static final void m9578login$lambda0(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl, List list, SingleEmitter singleEmitter) {
        ComponentActivity componentActivity;
        Intrinsics.checkNotNullParameter(facebookLoginDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "$facebookPermissions");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        if (facebookLoginDataSourceImpl.accessTokenProvider.isCurrentAccessTokenActive()) {
            facebookLoginDataSourceImpl.loginManager.logOut();
        }
        Activity activity = facebookLoginDataSourceImpl.facebookLoginActivityIntegration.getActivity();
        Unit unit = null;
        if (activity instanceof ComponentActivity) {
            componentActivity = (ComponentActivity) activity;
        } else {
            componentActivity = null;
        }
        if (componentActivity != null) {
            facebookLoginDataSourceImpl.performLogin(componentActivity, list, singleEmitter);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new FacebookLoginActivityNotSetException("Please set a " + Reflection.getOrCreateKotlinClass(ComponentActivity.class).getSimpleName() + " to " + Reflection.getOrCreateKotlinClass(FacebookLoginActivityIntegration.class).getSimpleName());
        }
    }

    private final void performLogin(ComponentActivity componentActivity, List<? extends FacebookPermission> list, SingleEmitter<FacebookLoginResultDto> singleEmitter) {
        this.loginManager.registerCallback(this.callbackManager, new FacebookLoginResultCallback(singleEmitter));
        singleEmitter.setCancellable(new b(this));
        LoginManager loginManager2 = this.loginManager;
        CallbackManager callbackManager2 = this.callbackManager;
        Iterable<FacebookPermission> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (FacebookPermission value : iterable) {
            arrayList.add(value.getValue());
        }
        loginManager2.logIn((ActivityResultRegistryOwner) componentActivity, callbackManager2, (Collection<String>) arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: performLogin$lambda-1  reason: not valid java name */
    public static final void m9579performLogin$lambda1(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl) {
        Intrinsics.checkNotNullParameter(facebookLoginDataSourceImpl, "this$0");
        facebookLoginDataSourceImpl.loginManager.unregisterCallback(facebookLoginDataSourceImpl.callbackManager);
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-8  reason: not valid java name */
    public static final void m9580requestData$lambda8(FacebookLoginDataSourceImpl facebookLoginDataSourceImpl, List list, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(facebookLoginDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "$data");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        AccessToken accessTokenOrNull = facebookLoginDataSourceImpl.accessTokenProvider.getAccessTokenOrNull();
        if (accessTokenOrNull != null) {
            GraphRequest createRequest = facebookLoginDataSourceImpl.graphRequestFactory.createRequest(accessTokenOrNull, new a(singleEmitter, list, facebookLoginDataSourceImpl));
            Bundle bundle = new Bundle();
            bundle.putString("fields", CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FacebookLoginDataSourceImpl$requestData$1$1$1$1.INSTANCE, 30, (Object) null));
            createRequest.setParameters(bundle);
            if (createRequest.executeAsync() != null) {
                return;
            }
        }
        singleEmitter.onError(new FacebookAccessTokenNotFoundException());
        Unit unit = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-8$lambda-7$lambda-5  reason: not valid java name */
    public static final void m9581requestData$lambda8$lambda7$lambda5(SingleEmitter singleEmitter, List list, FacebookLoginDataSourceImpl facebookLoginDataSourceImpl, JSONObject jSONObject, GraphResponse graphResponse) {
        FacebookRequestError facebookRequestError;
        int i11;
        Integer num;
        Object obj;
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        Intrinsics.checkNotNullParameter(list, "$data");
        Intrinsics.checkNotNullParameter(facebookLoginDataSourceImpl, "this$0");
        String str = null;
        if (jSONObject != null) {
            Iterable iterable = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (Object next : iterable) {
                FacebookProfileData facebookProfileData = (FacebookProfileData) next;
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m6329constructorimpl(jSONObject.get(facebookProfileData.getKey()).toString());
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m6335isFailureimpl(obj)) {
                    obj = null;
                }
                linkedHashMap.put(next, (String) obj);
            }
            singleEmitter.onSuccess(new FacebookLoginDataRequestDto(linkedHashMap));
            return;
        }
        if (graphResponse != null) {
            facebookRequestError = graphResponse.getError();
        } else {
            facebookRequestError = null;
        }
        if (facebookRequestError != null) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                i11 = error.getRequestStatusCode();
            } else {
                i11 = -1;
            }
            FacebookRequestError error2 = graphResponse.getError();
            if (error2 != null) {
                num = Integer.valueOf(error2.getErrorCode());
            } else {
                num = null;
            }
            FacebookRequestError error3 = graphResponse.getError();
            if (error3 != null) {
                str = error3.getErrorType();
            }
            singleEmitter.onError(new FacebookLoginRequestException(i11, num, str));
            return;
        }
        singleEmitter.onError(new FacebookLoginUnknownException());
    }

    public void initialize() {
        FacebookSdk.sdkInitialize(this.context);
    }

    @NotNull
    public Single<FacebookLoginResultDto> login(@NotNull List<? extends FacebookPermission> list) {
        Intrinsics.checkNotNullParameter(list, "facebookPermissions");
        Single<FacebookLoginResultDto> create = Single.create(new c(this, list));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …pleName}\"\n        )\n    }");
        return create;
    }

    public void logout() {
        this.loginManager.logOut();
    }

    @NotNull
    public Single<FacebookLoginDataRequestDto> requestData(@NotNull List<? extends FacebookProfileData> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        Single<FacebookLoginDataRequestDto> create = Single.create(new d(this, list));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …otFoundException())\n    }");
        return create;
    }
}
