package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    @NonNull
    protected final GoogleApiManager zaa;
    private final Context zab;
    @Nullable
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    @KeepForSdk
    public static class Settings {
        @NonNull
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        @NonNull
        public final StatusExceptionMapper zaa;
        @NonNull
        public final Looper zab;

        @KeepForSdk
        public static class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;

            @NonNull
            @KeepForSdk
            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            @NonNull
            @KeepForSdk
            @CanIgnoreReturnValue
            public Builder setLooper(@NonNull Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            @NonNull
            @KeepForSdk
            @CanIgnoreReturnValue
            public Builder setMapper(@NonNull StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    @MainThread
    @KeepForSdk
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o11, @NonNull Settings settings) {
        this((Context) activity, activity, (Api) api, (Api.ApiOptions) o11, settings);
    }

    private final BaseImplementation.ApiMethodImpl zad(int i11, @NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.zau(this, i11, apiMethodImpl);
        return apiMethodImpl;
    }

    private final Task zae(int i11, @NonNull TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, i11, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    @NonNull
    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    @NonNull
    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) == null) {
            Api.ApiOptions apiOptions2 = this.zae;
            if (apiOptions2 instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount();
            } else {
                account = null;
            }
        } else {
            account = googleSignInAccount.getAccount();
        }
        builder.zab(account);
        Api.ApiOptions apiOptions3 = this.zae;
        if (apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
            GoogleSignInAccount googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).getGoogleSignInAccount();
            if (googleSignInAccount2 == null) {
                set = Collections.emptySet();
            } else {
                set = googleSignInAccount2.getRequestedScopes();
            }
        } else {
            set = Collections.emptySet();
        }
        builder.zaa(set);
        builder.zac(this.zab.getClass().getName());
        builder.setRealClientPackageName(this.zab.getPackageName());
        return builder;
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        return this.zaa.zan(this);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@NonNull T t11) {
        zad(2, t11);
        return t11;
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@NonNull T t11) {
        zad(0, t11);
        return t11;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@NonNull T t11, @NonNull U u11) {
        Preconditions.checkNotNull(t11);
        Preconditions.checkNotNull(u11);
        Preconditions.checkNotNull(t11.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u11.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t11.getListenerKey(), u11.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zao(this, t11, u11, zad.zaa);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@NonNull T t11) {
        zad(1, t11);
        return t11;
    }

    @NonNull
    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    @NonNull
    @KeepForSdk
    public O getApiOptions() {
        return this.zae;
    }

    @NonNull
    @KeepForSdk
    public Context getApplicationContext() {
        return this.zab;
    }

    @KeepForSdk
    @Nullable
    public String getContextAttributionTag() {
        return this.zac;
    }

    @KeepForSdk
    @Deprecated
    @Nullable
    public String getContextFeatureId() {
        return this.zac;
    }

    @NonNull
    @KeepForSdk
    public Looper getLooper() {
        return this.zag;
    }

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@NonNull L l11, @NonNull String str) {
        return ListenerHolders.createListenerHolder(l11, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    @WorkerThread
    public final Api.Client zab(Looper looper, zabq zabq) {
        Looper looper2 = looper;
        Api.Client buildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zad.zaa())).buildClient(this.zab, looper2, createClientSettingsBuilder().build(), this.zae, (GoogleApiClient.ConnectionCallbacks) zabq, (GoogleApiClient.OnConnectionFailedListener) zabq);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zac(contextAttributionTag);
        }
        return buildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.app.Activity r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.setLooper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.app.Activity) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return zae(2, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return zae(0, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> listenerKey, int i11) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zap(this, listenerKey, i11);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return zae(1, taskApiCall);
    }

    private GoogleApi(@NonNull Context context, @Nullable Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = (Context) Preconditions.checkNotNull(context.getApplicationContext(), "The provided context did not have an application context.");
        String str = null;
        if (PlatformVersion.isAtLeastR()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.zac = str;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.zab;
        ApiKey sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, str);
        this.zaf = sharedApiKey;
        this.zai = new zabv(this);
        GoogleApiManager zak = GoogleApiManager.zak(this.zab);
        this.zaa = zak;
        this.zah = zak.zaa();
        this.zaj = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.zad(activity, zak, sharedApiKey);
        }
        zak.zaz(this);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@NonNull RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zao(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull android.os.Looper r5, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r6) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setLooper(r5)
            r0.setMapper(r6)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, android.os.Looper, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o11, @NonNull Settings settings) {
        this(context, (Activity) null, (Api) api, (Api.ApiOptions) o11, settings);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }
}
