package io.flutter.plugins.googlesignin;

import a00.c;
import a00.d;
import a00.e;
import a00.f;
import a00.g;
import a00.h;
import a00.i;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.visa.checkout.Profile;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class GoogleSignInPlugin implements FlutterPlugin, ActivityAware {
    private ActivityPluginBinding activityPluginBinding;
    private Delegate delegate;
    @Nullable
    private BinaryMessenger messenger;

    /* renamed from: io.flutter.plugins.googlesignin.GoogleSignInPlugin$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14338a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.plugins.googlesignin.Messages$SignInType[] r0 = io.flutter.plugins.googlesignin.Messages.SignInType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14338a = r0
                io.flutter.plugins.googlesignin.Messages$SignInType r1 = io.flutter.plugins.googlesignin.Messages.SignInType.GAMES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14338a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.plugins.googlesignin.Messages$SignInType r1 = io.flutter.plugins.googlesignin.Messages.SignInType.STANDARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlesignin.GoogleSignInPlugin.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Delegate implements IDelegate, PluginRegistry.ActivityResultListener, Messages.GoogleSignInApi {
        private static final String DEFAULT_GAMES_SIGN_IN = "SignInOption.games";
        private static final String DEFAULT_SIGN_IN = "SignInOption.standard";
        private static final String ERROR_FAILURE_TO_RECOVER_AUTH = "failed_to_recover_auth";
        private static final String ERROR_REASON_EXCEPTION = "exception";
        private static final String ERROR_REASON_NETWORK_ERROR = "network_error";
        private static final String ERROR_REASON_SIGN_IN_CANCELED = "sign_in_canceled";
        private static final String ERROR_REASON_SIGN_IN_FAILED = "sign_in_failed";
        private static final String ERROR_REASON_SIGN_IN_REQUIRED = "sign_in_required";
        private static final String ERROR_REASON_STATUS = "status";
        private static final String ERROR_USER_RECOVERABLE_AUTH = "user_recoverable_auth";
        private static final int REQUEST_CODE_RECOVER_AUTH = 53294;
        private static final int REQUEST_CODE_SIGNIN = 53293;
        @Nullable
        private Activity activity;
        private final BackgroundTaskRunner backgroundTaskRunner = new BackgroundTaskRunner(1);
        @NonNull
        private final Context context;
        private final GoogleSignInWrapper googleSignInWrapper;
        private PendingOperation pendingOperation;
        private PluginRegistry.Registrar registrar;
        private List<String> requestedScopes;
        private GoogleSignInClient signInClient;

        public static class PendingOperation {
            @NonNull

            /* renamed from: a  reason: collision with root package name */
            public final String f14341a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public final Messages.Result<Messages.UserData> f14342b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            public final Messages.Result<Void> f14343c;
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public final Messages.Result<Boolean> f14344d;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            public final Messages.Result<String> f14345e;
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            public final Object f14346f;

            public PendingOperation(@NonNull String str, @Nullable Messages.Result<Messages.UserData> result, @Nullable Messages.Result<Void> result2, @Nullable Messages.Result<Boolean> result3, @Nullable Messages.Result<String> result4, @Nullable Object obj) {
                this.f14341a = str;
                this.f14342b = result;
                this.f14343c = result2;
                this.f14344d = result3;
                this.f14345e = result4;
                this.f14346f = obj;
            }
        }

        public Delegate(@NonNull Context context2, @NonNull GoogleSignInWrapper googleSignInWrapper2) {
            this.context = context2;
            this.googleSignInWrapper = googleSignInWrapper2;
        }

        private void checkAndSetPendingAccessTokenOperation(String str, Messages.Result<String> result, @NonNull Object obj) {
            checkAndSetPendingStringOperation(str, result, obj);
        }

        private void checkAndSetPendingBoolOperation(String str, @NonNull Messages.Result<Boolean> result) {
            checkAndSetPendingOperation(str, (Messages.Result<Messages.UserData>) null, (Messages.Result<Void>) null, result, (Messages.Result<String>) null, (Object) null);
        }

        private void checkAndSetPendingOperation(String str, Messages.Result<Messages.UserData> result, Messages.Result<Void> result2, Messages.Result<Boolean> result3, Messages.Result<String> result4, Object obj) {
            if (this.pendingOperation == null) {
                this.pendingOperation = new PendingOperation(str, result, result2, result3, result4, obj);
                return;
            }
            throw new IllegalStateException("Concurrent operations detected: " + this.pendingOperation.f14341a + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str);
        }

        private void checkAndSetPendingSignInOperation(String str, @NonNull Messages.Result<Messages.UserData> result) {
            checkAndSetPendingOperation(str, result, (Messages.Result<Void>) null, (Messages.Result<Boolean>) null, (Messages.Result<String>) null, (Object) null);
        }

        private void checkAndSetPendingStringOperation(String str, @NonNull Messages.Result<String> result, @Nullable Object obj) {
            checkAndSetPendingOperation(str, (Messages.Result<Messages.UserData>) null, (Messages.Result<Void>) null, (Messages.Result<Boolean>) null, result, obj);
        }

        private void checkAndSetPendingVoidOperation(String str, @NonNull Messages.Result<Void> result) {
            checkAndSetPendingOperation(str, (Messages.Result<Messages.UserData>) null, result, (Messages.Result<Boolean>) null, (Messages.Result<String>) null, (Object) null);
        }

        private String errorCodeForStatus(int i11) {
            return i11 != 4 ? i11 != 7 ? i11 != 12501 ? ERROR_REASON_SIGN_IN_FAILED : ERROR_REASON_SIGN_IN_CANCELED : ERROR_REASON_NETWORK_ERROR : ERROR_REASON_SIGN_IN_REQUIRED;
        }

        private void finishWithBoolean(Boolean bool) {
            Messages.Result<Boolean> result = this.pendingOperation.f14344d;
            Objects.requireNonNull(result);
            result.success(bool);
            this.pendingOperation = null;
        }

        private void finishWithError(String str, String str2) {
            PendingOperation pendingOperation2 = this.pendingOperation;
            Messages.Result result = pendingOperation2.f14342b;
            if (result == null && (result = pendingOperation2.f14344d) == null && (result = pendingOperation2.f14345e) == null) {
                result = pendingOperation2.f14343c;
            }
            Objects.requireNonNull(result);
            result.error(new Messages.FlutterError(str, str2, (Object) null));
            this.pendingOperation = null;
        }

        private void finishWithSuccess() {
            Messages.Result<Void> result = this.pendingOperation.f14343c;
            Objects.requireNonNull(result);
            result.success(null);
            this.pendingOperation = null;
        }

        private void finishWithUserData(Messages.UserData userData) {
            Messages.Result<Messages.UserData> result = this.pendingOperation.f14342b;
            Objects.requireNonNull(result);
            result.success(userData);
            this.pendingOperation = null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Void lambda$clearAuthCache$2(String str) throws Exception {
            GoogleAuthUtil.clearToken(this.context, str);
            return null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$clearAuthCache$3(Messages.Result result, Future future) {
            String str;
            try {
                result.success((Void) future.get());
            } catch (ExecutionException e11) {
                Throwable cause = e11.getCause();
                if (cause == null) {
                    str = null;
                } else {
                    str = cause.getMessage();
                }
                result.error(new Messages.FlutterError("exception", str, (Object) null));
            } catch (InterruptedException e12) {
                result.error(new Messages.FlutterError("exception", e12.getMessage(), (Object) null));
                Thread.currentThread().interrupt();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$disconnect$1(Task task) {
            if (task.isSuccessful()) {
                finishWithSuccess();
            } else {
                finishWithError("status", "Failed to disconnect.");
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$getAccessToken$4(String str) throws Exception {
            Account account = new Account(str, "com.google");
            return GoogleAuthUtil.getToken(this.context, account, "oauth2:" + Joiner.on(' ').join((Iterable<? extends Object>) this.requestedScopes));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$getAccessToken$5(Messages.Result result, Boolean bool, String str, Future future) {
            String str2;
            try {
                result.success((String) future.get());
            } catch (ExecutionException e11) {
                if (!(e11.getCause() instanceof UserRecoverableAuthException)) {
                    Throwable cause = e11.getCause();
                    if (cause == null) {
                        str2 = null;
                    } else {
                        str2 = cause.getMessage();
                    }
                    result.error(new Messages.FlutterError("exception", str2, (Object) null));
                } else if (!bool.booleanValue() || this.pendingOperation != null) {
                    result.error(new Messages.FlutterError(ERROR_USER_RECOVERABLE_AUTH, e11.getLocalizedMessage(), (Object) null));
                } else {
                    Activity activity2 = getActivity();
                    if (activity2 == null) {
                        result.error(new Messages.FlutterError(ERROR_USER_RECOVERABLE_AUTH, "Cannot recover auth because app is not in foreground. " + e11.getLocalizedMessage(), (Object) null));
                        return;
                    }
                    checkAndSetPendingAccessTokenOperation("getTokens", result, str);
                    activity2.startActivityForResult(((UserRecoverableAuthException) e11.getCause()).getIntent(), REQUEST_CODE_RECOVER_AUTH);
                }
            } catch (InterruptedException e12) {
                result.error(new Messages.FlutterError("exception", e12.getMessage(), (Object) null));
                Thread.currentThread().interrupt();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$signOut$0(Task task) {
            if (task.isSuccessful()) {
                finishWithSuccess();
            } else {
                finishWithError("status", "Failed to signout.");
            }
        }

        private void onSignInAccount(GoogleSignInAccount googleSignInAccount) {
            Messages.UserData.Builder displayName = new Messages.UserData.Builder().setEmail(googleSignInAccount.getEmail()).setId(googleSignInAccount.getId()).setIdToken(googleSignInAccount.getIdToken()).setServerAuthCode(googleSignInAccount.getServerAuthCode()).setDisplayName(googleSignInAccount.getDisplayName());
            if (googleSignInAccount.getPhotoUrl() != null) {
                displayName.setPhotoUrl(googleSignInAccount.getPhotoUrl().toString());
            }
            finishWithUserData(displayName.build());
        }

        /* access modifiers changed from: private */
        public void onSignInResult(Task<GoogleSignInAccount> task) {
            try {
                onSignInAccount(task.getResult(ApiException.class));
            } catch (ApiException e11) {
                finishWithError(errorCodeForStatus(e11.getStatusCode()), e11.toString());
            } catch (RuntimeExecutionException e12) {
                finishWithError("exception", e12.toString());
            }
        }

        public void clearAuthCache(@NonNull String str, @NonNull Messages.Result<Void> result) {
            this.backgroundTaskRunner.runInBackground(new e(this, str), new f(result));
        }

        public void disconnect(@NonNull Messages.Result<Void> result) {
            checkAndSetPendingVoidOperation("disconnect", result);
            this.signInClient.revokeAccess().addOnCompleteListener(new d(this));
        }

        public void getAccessToken(@NonNull String str, @NonNull Boolean bool, @NonNull Messages.Result<String> result) {
            this.backgroundTaskRunner.runInBackground(new g(this, str), new h(this, result, bool, str));
        }

        @Nullable
        public Activity getActivity() {
            PluginRegistry.Registrar registrar2 = this.registrar;
            return registrar2 != null ? registrar2.activity() : this.activity;
        }

        public void getTokens(@NonNull MethodChannel.Result result, @NonNull String str, boolean z11) {
            getAccessToken(str, Boolean.valueOf(z11), new ErrorConvertingMethodChannelResult<String>(result) {
                public void success(String str) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("accessToken", str);
                    this.f14347a.success(hashMap);
                }
            });
        }

        public void init(@NonNull Messages.InitParams initParams) {
            GoogleSignInOptions.Builder builder;
            int identifier;
            try {
                int i11 = AnonymousClass1.f14338a[initParams.getSignInType().ordinal()];
                if (i11 == 1) {
                    builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
                } else if (i11 == 2) {
                    builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail();
                } else {
                    throw new IllegalStateException("Unknown signInOption");
                }
                String serverClientId = initParams.getServerClientId();
                if (!Strings.isNullOrEmpty(initParams.getClientId()) && Strings.isNullOrEmpty(serverClientId)) {
                    Log.w("google_sign_in", "clientId is not supported on Android and is interpreted as serverClientId. Use serverClientId instead to suppress this warning.");
                    serverClientId = initParams.getClientId();
                }
                if (Strings.isNullOrEmpty(serverClientId) && (identifier = this.context.getResources().getIdentifier("default_web_client_id", TypedValues.Custom.S_STRING, this.context.getPackageName())) != 0) {
                    serverClientId = this.context.getString(identifier);
                }
                if (!Strings.isNullOrEmpty(serverClientId)) {
                    builder.requestIdToken(serverClientId);
                    builder.requestServerAuthCode(serverClientId, initParams.getForceCodeForRefreshToken().booleanValue());
                }
                List<String> scopes = initParams.getScopes();
                this.requestedScopes = scopes;
                for (String scope : scopes) {
                    builder.requestScopes(new Scope(scope), new Scope[0]);
                }
                if (!Strings.isNullOrEmpty(initParams.getHostedDomain())) {
                    builder.setHostedDomain(initParams.getHostedDomain());
                }
                this.signInClient = this.googleSignInWrapper.a(this.context, builder.build());
            } catch (Exception e11) {
                throw new Messages.FlutterError("exception", e11.getMessage(), (Object) null);
            }
        }

        @NonNull
        public Boolean isSignedIn() {
            return Boolean.valueOf(GoogleSignIn.getLastSignedInAccount(this.context) != null);
        }

        public boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
            PendingOperation pendingOperation2 = this.pendingOperation;
            boolean z11 = false;
            if (pendingOperation2 == null) {
                return false;
            }
            switch (i11) {
                case REQUEST_CODE_SIGNIN /*53293*/:
                    if (intent != null) {
                        onSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
                    } else {
                        finishWithError(ERROR_REASON_SIGN_IN_FAILED, "Signin failed");
                    }
                    return true;
                case REQUEST_CODE_RECOVER_AUTH /*53294*/:
                    if (i12 == -1) {
                        Messages.Result<String> result = pendingOperation2.f14345e;
                        Objects.requireNonNull(result);
                        Object obj = this.pendingOperation.f14346f;
                        Objects.requireNonNull(obj);
                        this.pendingOperation = null;
                        getAccessToken((String) obj, Boolean.FALSE, result);
                    } else {
                        finishWithError(ERROR_FAILURE_TO_RECOVER_AUTH, "Failed attempt to recover authentication");
                    }
                    return true;
                case 53295:
                    if (i12 == -1) {
                        z11 = true;
                    }
                    finishWithBoolean(Boolean.valueOf(z11));
                    return true;
                default:
                    return false;
            }
        }

        public void requestScopes(@NonNull List<String> list, @NonNull Messages.Result<Boolean> result) {
            checkAndSetPendingBoolOperation("requestScopes", result);
            GoogleSignInAccount b11 = this.googleSignInWrapper.b(this.context);
            if (b11 == null) {
                finishWithError(ERROR_REASON_SIGN_IN_REQUIRED, "No account to grant scopes.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String scope : list) {
                Scope scope2 = new Scope(scope);
                if (!this.googleSignInWrapper.c(b11, scope2)) {
                    arrayList.add(scope2);
                }
            }
            if (arrayList.isEmpty()) {
                finishWithBoolean(Boolean.TRUE);
            } else {
                this.googleSignInWrapper.d(getActivity(), 53295, b11, (Scope[]) arrayList.toArray(new Scope[0]));
            }
        }

        public void setActivity(@Nullable Activity activity2) {
            this.activity = activity2;
        }

        public void setUpRegistrar(@NonNull PluginRegistry.Registrar registrar2) {
            this.registrar = registrar2;
            registrar2.addActivityResultListener(this);
        }

        public void signIn(@NonNull Messages.Result<Messages.UserData> result) {
            if (getActivity() != null) {
                checkAndSetPendingSignInOperation("signIn", result);
                getActivity().startActivityForResult(this.signInClient.getSignInIntent(), REQUEST_CODE_SIGNIN);
                return;
            }
            throw new IllegalStateException("signIn needs a foreground activity");
        }

        public void signInSilently(@NonNull Messages.Result<Messages.UserData> result) {
            checkAndSetPendingSignInOperation("signInSilently", result);
            Task<GoogleSignInAccount> silentSignIn = this.signInClient.silentSignIn();
            if (silentSignIn.isComplete()) {
                onSignInResult(silentSignIn);
            } else {
                silentSignIn.addOnCompleteListener(new i(this));
            }
        }

        public void signOut(@NonNull Messages.Result<Void> result) {
            checkAndSetPendingVoidOperation("signOut", result);
            this.signInClient.signOut().addOnCompleteListener(new c(this));
        }

        public void isSignedIn(@NonNull MethodChannel.Result result) {
            result.success(isSignedIn());
        }

        public void clearAuthCache(@NonNull MethodChannel.Result result, @NonNull String str) {
            clearAuthCache(str, (Messages.Result<Void>) new VoidMethodChannelResult(result));
        }

        public void disconnect(@NonNull MethodChannel.Result result) {
            signOut((Messages.Result<Void>) new VoidMethodChannelResult(result));
        }

        public void signOut(@NonNull MethodChannel.Result result) {
            signOut((Messages.Result<Void>) new VoidMethodChannelResult(result));
        }

        public void signIn(@NonNull MethodChannel.Result result) {
            signIn((Messages.Result<Messages.UserData>) new UserDataMethodChannelResult(result));
        }

        public void signInSilently(@NonNull MethodChannel.Result result) {
            signInSilently((Messages.Result<Messages.UserData>) new UserDataMethodChannelResult(result));
        }

        public void requestScopes(@NonNull MethodChannel.Result result, @NonNull List<String> list) {
            requestScopes(list, (Messages.Result<Boolean>) new ErrorConvertingMethodChannelResult<Boolean>(result) {
                public void success(Boolean bool) {
                    this.f14347a.success(bool);
                }
            });
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[Catch:{ FlutterError -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[Catch:{ FlutterError -> 0x0063 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void init(@androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r4, @androidx.annotation.NonNull java.lang.String r5, @androidx.annotation.NonNull java.util.List<java.lang.String> r6, @androidx.annotation.Nullable java.lang.String r7, @androidx.annotation.Nullable java.lang.String r8, @androidx.annotation.Nullable java.lang.String r9, boolean r10) {
            /*
                r3 = this;
                int r0 = r5.hashCode()     // Catch:{ FlutterError -> 0x0063 }
                r1 = 849126666(0x329ca50a, float:1.8235841E-8)
                r2 = 1
                if (r0 == r1) goto L_0x001a
                r1 = 2056100820(0x7a8d9bd4, float:3.676372E35)
                if (r0 == r1) goto L_0x0010
                goto L_0x0024
            L_0x0010:
                java.lang.String r0 = "SignInOption.standard"
                boolean r5 = r5.equals(r0)     // Catch:{ FlutterError -> 0x0063 }
                if (r5 == 0) goto L_0x0024
                r5 = r2
                goto L_0x0025
            L_0x001a:
                java.lang.String r0 = "SignInOption.games"
                boolean r5 = r5.equals(r0)     // Catch:{ FlutterError -> 0x0063 }
                if (r5 == 0) goto L_0x0024
                r5 = 0
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                if (r5 == 0) goto L_0x0034
                if (r5 != r2) goto L_0x002c
                io.flutter.plugins.googlesignin.Messages$SignInType r5 = io.flutter.plugins.googlesignin.Messages.SignInType.STANDARD     // Catch:{ FlutterError -> 0x0063 }
                goto L_0x0036
            L_0x002c:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ FlutterError -> 0x0063 }
                java.lang.String r6 = "Unknown signInOption"
                r5.<init>(r6)     // Catch:{ FlutterError -> 0x0063 }
                throw r5     // Catch:{ FlutterError -> 0x0063 }
            L_0x0034:
                io.flutter.plugins.googlesignin.Messages$SignInType r5 = io.flutter.plugins.googlesignin.Messages.SignInType.GAMES     // Catch:{ FlutterError -> 0x0063 }
            L_0x0036:
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r0 = new io.flutter.plugins.googlesignin.Messages$InitParams$Builder     // Catch:{ FlutterError -> 0x0063 }
                r0.<init>()     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r0.setSignInType(r5)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r5.setScopes(r6)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r5.setHostedDomain(r7)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r5.setClientId(r8)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r5.setServerClientId(r9)     // Catch:{ FlutterError -> 0x0063 }
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r10)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams$Builder r5 = r5.setForceCodeForRefreshToken(r6)     // Catch:{ FlutterError -> 0x0063 }
                io.flutter.plugins.googlesignin.Messages$InitParams r5 = r5.build()     // Catch:{ FlutterError -> 0x0063 }
                r3.init(r5)     // Catch:{ FlutterError -> 0x0063 }
                r5 = 0
                r4.success(r5)     // Catch:{ FlutterError -> 0x0063 }
                goto L_0x006f
            L_0x0063:
                r5 = move-exception
                java.lang.String r6 = r5.code
                java.lang.String r7 = r5.getMessage()
                java.lang.Object r5 = r5.details
                r4.error(r6, r7, r5)
            L_0x006f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlesignin.GoogleSignInPlugin.Delegate.init(io.flutter.plugin.common.MethodChannel$Result, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, boolean):void");
        }
    }

    public static abstract class ErrorConvertingMethodChannelResult<T> implements Messages.Result<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f14347a;

        public ErrorConvertingMethodChannelResult(@NonNull MethodChannel.Result result) {
            this.f14347a = result;
        }

        public void error(@NonNull Throwable th2) {
            if (th2 instanceof Messages.FlutterError) {
                Messages.FlutterError flutterError = (Messages.FlutterError) th2;
                this.f14347a.error(flutterError.code, flutterError.getMessage(), flutterError.details);
                return;
            }
            this.f14347a.error("exception", th2.getMessage(), (Object) null);
        }
    }

    public interface IDelegate {
        void clearAuthCache(@NonNull MethodChannel.Result result, @NonNull String str);

        void disconnect(@NonNull MethodChannel.Result result);

        void getTokens(@NonNull MethodChannel.Result result, @NonNull String str, boolean z11);

        void init(@NonNull MethodChannel.Result result, @NonNull String str, @NonNull List<String> list, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11);

        void isSignedIn(@NonNull MethodChannel.Result result);

        void requestScopes(@NonNull MethodChannel.Result result, @NonNull List<String> list);

        void signIn(@NonNull MethodChannel.Result result);

        void signInSilently(@NonNull MethodChannel.Result result);

        void signOut(@NonNull MethodChannel.Result result);
    }

    public static class UserDataMethodChannelResult extends ErrorConvertingMethodChannelResult<Messages.UserData> {
        public UserDataMethodChannelResult(MethodChannel.Result result) {
            super(result);
        }

        public void success(Messages.UserData userData) {
            HashMap hashMap = new HashMap();
            hashMap.put("email", userData.getEmail());
            hashMap.put("id", userData.getId());
            hashMap.put("idToken", userData.getIdToken());
            hashMap.put("serverAuthCode", userData.getServerAuthCode());
            hashMap.put(Profile.DISPLAY_NAME, userData.getDisplayName());
            if (userData.getPhotoUrl() != null) {
                hashMap.put("photoUrl", userData.getPhotoUrl());
            }
            this.f14347a.success(hashMap);
        }
    }

    public static class VoidMethodChannelResult extends ErrorConvertingMethodChannelResult<Void> {
        public VoidMethodChannelResult(MethodChannel.Result result) {
            super(result);
        }

        public void success(Void voidR) {
            this.f14347a.success((Object) null);
        }
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding2) {
        this.activityPluginBinding = activityPluginBinding2;
        activityPluginBinding2.addActivityResultListener(this.delegate);
        this.delegate.setActivity(activityPluginBinding2.getActivity());
    }

    private void dispose() {
        this.delegate = null;
        BinaryMessenger binaryMessenger = this.messenger;
        if (binaryMessenger != null) {
            Messages.GoogleSignInApi.CC.k(binaryMessenger, (Messages.GoogleSignInApi) null);
            this.messenger = null;
        }
    }

    private void disposeActivity() {
        this.activityPluginBinding.removeActivityResultListener(this.delegate);
        this.delegate.setActivity((Activity) null);
        this.activityPluginBinding = null;
    }

    public static void registerWith(@NonNull PluginRegistry.Registrar registrar) {
        GoogleSignInPlugin googleSignInPlugin = new GoogleSignInPlugin();
        googleSignInPlugin.initInstance(registrar.messenger(), registrar.context(), new GoogleSignInWrapper());
        googleSignInPlugin.setUpRegistrar(registrar);
    }

    @VisibleForTesting
    public void initInstance(@NonNull BinaryMessenger binaryMessenger, @NonNull Context context, @NonNull GoogleSignInWrapper googleSignInWrapper) {
        this.messenger = binaryMessenger;
        Delegate delegate2 = new Delegate(context, googleSignInWrapper);
        this.delegate = delegate2;
        Messages.GoogleSignInApi.CC.k(binaryMessenger, delegate2);
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding2) {
        attachToActivity(activityPluginBinding2);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext(), new GoogleSignInWrapper());
    }

    public void onDetachedFromActivity() {
        disposeActivity();
    }

    public void onDetachedFromActivityForConfigChanges() {
        disposeActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        dispose();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding2) {
        attachToActivity(activityPluginBinding2);
    }

    @VisibleForTesting
    public void setUpRegistrar(@NonNull PluginRegistry.Registrar registrar) {
        this.delegate.setUpRegistrar(registrar);
    }
}
