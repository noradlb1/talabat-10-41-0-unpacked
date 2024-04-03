package com.facebook.internal;

import android.app.Activity;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.VisibleForTesting;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 @*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0002@AB\u0017\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0014\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\u000f\b\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u001e\u0010!\u001a\u0018\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0017H\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010'\u001a\u00020(H\u0004J\u001f\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020.H$J\u0012\u00101\u001a\u0002022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u00103\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000105H\u0016J&\u00103\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u0001052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u00106\u001a\u0002022\u0006\u0010\u0010\u001a\u0002072\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000105H$J\u0010\u00108\u001a\u0002022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0015\u00109\u001a\u0002022\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010:J\u001d\u0010;\u001a\u0002022\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0017X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\fR\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase;", "CONTENT", "RESULT", "Lcom/facebook/FacebookDialog;", "activity", "Landroid/app/Activity;", "requestCode", "", "(Landroid/app/Activity;I)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;I)V", "(I)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager$facebook_common_release", "()Lcom/facebook/CallbackManager;", "setCallbackManager$facebook_common_release", "(Lcom/facebook/CallbackManager;)V", "modeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "orderedModeHandlers", "getOrderedModeHandlers", "()Ljava/util/List;", "value", "getRequestCode", "()I", "setRequestCode", "requestCodeField", "cachedModeHandlers", "canShow", "", "content", "(Ljava/lang/Object;)Z", "canShowImpl", "mode", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createActivityResultContractForShowingDialog", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createAppCallForMode", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "createBaseAppCall", "memorizeCallbackManager", "", "registerCallback", "callback", "Lcom/facebook/FacebookCallback;", "registerCallbackImpl", "Lcom/facebook/internal/CallbackManagerImpl;", "setCallbackManager", "show", "(Ljava/lang/Object;)V", "showImpl", "(Ljava/lang/Object;Ljava/lang/Object;)V", "startActivityForResult", "intent", "Landroid/content/Intent;", "Companion", "ModeHandler", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    @NotNull
    @JvmField
    public static final Object BASE_AUTOMATIC_MODE = new Object();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FacebookDialog";
    @Nullable
    private final Activity activity;
    @Nullable
    private CallbackManager callbackManager;
    @Nullable
    private final FragmentWrapper fragmentWrapper;
    @Nullable
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$Companion;", "", "()V", "BASE_AUTOMATIC_MODE", "TAG", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "", "(Lcom/facebook/internal/FacebookDialogBase;)V", "mode", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "(Ljava/lang/Object;Z)Z", "createAppCall", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public abstract class ModeHandler {
        @NotNull
        private Object mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

        public ModeHandler(FacebookDialogBase facebookDialogBase) {
            Intrinsics.checkNotNullParameter(facebookDialogBase, "this$0");
            this.this$0 = facebookDialogBase;
        }

        public abstract boolean canShow(CONTENT content, boolean z11);

        @Nullable
        public abstract AppCall createAppCall(CONTENT content);

        @NotNull
        public Object getMode() {
            return this.mode;
        }

        public void setMode(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }
    }

    public FacebookDialogBase(@NotNull Activity activity2, int i11) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        this.fragmentWrapper = null;
        this.requestCodeField = i11;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
    }

    /* access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z11;
        AppCall appCall;
        if (obj == BASE_AUTOMATIC_MODE) {
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                appCall = null;
                break;
            }
            ModeHandler next = it.next();
            if (!z11) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, true)) {
                try {
                    appCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e11) {
                    AppCall createBaseAppCall = createBaseAppCall();
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    DialogPresenter.setupAppCallForValidationError(createBaseAppCall, e11);
                    appCall = createBaseAppCall;
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        AppCall createBaseAppCall2 = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall2);
        return createBaseAppCall2;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager2) {
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(CONTENT content, @NotNull Object obj) {
        boolean z11;
        Intrinsics.checkNotNullParameter(obj, SessionsConfigParameter.SYNC_MODE);
        if (obj == BASE_AUTOMATIC_MODE) {
            z11 = true;
        } else {
            z11 = false;
        }
        for (ModeHandler next : cachedModeHandlers()) {
            if (!z11) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@Nullable CallbackManager callbackManager2, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, SessionsConfigParameter.SYNC_MODE);
        return new FacebookDialogBase$createActivityResultContractForShowingDialog$1(this, obj, callbackManager2);
    }

    @NotNull
    public abstract AppCall createBaseAppCall();

    @Nullable
    public final Activity getActivityContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
        if (fragmentWrapper2 == null) {
            return null;
        }
        return fragmentWrapper2.getActivity();
    }

    @VisibleForTesting(otherwise = 2)
    @Nullable
    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    @NotNull
    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    public void registerCallback(@NotNull CallbackManager callbackManager2, @NotNull FacebookCallback<RESULT> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        if (callbackManager2 instanceof CallbackManagerImpl) {
            memorizeCallbackManager(callbackManager2);
            registerCallbackImpl((CallbackManagerImpl) callbackManager2, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public abstract void registerCallbackImpl(@NotNull CallbackManagerImpl callbackManagerImpl, @NotNull FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(@Nullable CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setCallbackManager$facebook_common_release(@Nullable CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setRequestCode(int i11) {
        if (!FacebookSdk.isFacebookRequestCode(i11)) {
            this.requestCodeField = i11;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i11 + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    public void showImpl(CONTENT content, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, SessionsConfigParameter.SYNC_MODE);
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode == null) {
            Log.e(TAG, "No code path should ever result in a null appCall");
            if (!(!FacebookSdk.isDebugEnabled())) {
                throw new IllegalStateException("No code path should ever result in a null appCall".toString());
            }
        } else if (getActivityContext() instanceof ActivityResultRegistryOwner) {
            Activity activityContext = getActivityContext();
            if (activityContext != null) {
                DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) activityContext).getActivityResultRegistry();
                Intrinsics.checkNotNullExpressionValue(activityResultRegistry, "registryOwner.activityResultRegistry");
                DialogPresenter.present(createAppCallForMode, activityResultRegistry, this.callbackManager);
                createAppCallForMode.setPending();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
        } else {
            FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
            if (fragmentWrapper2 != null) {
                DialogPresenter.present(createAppCallForMode, fragmentWrapper2);
                return;
            }
            Activity activity2 = this.activity;
            if (activity2 != null) {
                DialogPresenter.present(createAppCallForMode, activity2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startActivityForResult(@org.jetbrains.annotations.NotNull android.content.Intent r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.app.Activity r0 = r3.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L_0x0020
            com.facebook.internal.DialogPresenter r1 = com.facebook.internal.DialogPresenter.INSTANCE
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.CallbackManager r1 = r3.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r4, r5)
            goto L_0x002d
        L_0x0020:
            if (r0 == 0) goto L_0x0026
            r0.startActivityForResult(r4, r5)
            goto L_0x002d
        L_0x0026:
            com.facebook.internal.FragmentWrapper r0 = r3.fragmentWrapper
            if (r0 == 0) goto L_0x002f
            r0.startActivityForResult(r4, r5)
        L_0x002d:
            r4 = 0
            goto L_0x0031
        L_0x002f:
            java.lang.String r4 = "Failed to find Activity or Fragment to startActivityForResult "
        L_0x0031:
            if (r4 == 0) goto L_0x0048
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "this.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 6
            r5.log((com.facebook.LoggingBehavior) r0, (int) r2, (java.lang.String) r1, (java.lang.String) r4)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    @NotNull
    public ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@Nullable CallbackManager callbackManager2) {
        return createActivityResultContractForShowingDialog(callbackManager2, BASE_AUTOMATIC_MODE);
    }

    public void registerCallback(@NotNull CallbackManager callbackManager2, @NotNull FacebookCallback<RESULT> facebookCallback, int i11) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        memorizeCallbackManager(callbackManager2);
        setRequestCode(i11);
        registerCallback(callbackManager2, facebookCallback);
    }

    public FacebookDialogBase(@NotNull FragmentWrapper fragmentWrapper2, int i11) {
        Intrinsics.checkNotNullParameter(fragmentWrapper2, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper2;
        this.activity = null;
        this.requestCodeField = i11;
        if (fragmentWrapper2.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }

    public FacebookDialogBase(int i11) {
        this.requestCodeField = i11;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
