package com.braze.ui.inappmessage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageImmersiveBase;
import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer;
import com.braze.ui.inappmessage.views.IInAppMessageImmersiveView;
import com.braze.ui.inappmessage.views.IInAppMessageView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.support.ViewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.a;
import z3.b;
import z3.c;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\u0018\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u00100\u001a\u00020 H\u0016J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020 H\u0016J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020 H\u0016J\b\u0010;\u001a\u00020,H\u0016J\u0012\u0010<\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010=\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0004H\u0017R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R&\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006?"}, d2 = {"Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "Lcom/braze/ui/inappmessage/InAppMessageManagerBase;", "()V", "carryoverInAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "getCarryoverInAppMessage$annotations", "getCarryoverInAppMessage", "()Lcom/braze/models/inappmessage/IInAppMessage;", "setCarryoverInAppMessage", "(Lcom/braze/models/inappmessage/IInAppMessage;)V", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "displayingInAppMessage", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDisplayingInAppMessage$annotations", "inAppMessageEventMap", "", "Lcom/braze/events/InAppMessageEvent;", "getInAppMessageEventMap", "()Ljava/util/Map;", "inAppMessageEventSubscriber", "Lcom/braze/events/IEventSubscriber;", "inAppMessageStack", "Ljava/util/Stack;", "getInAppMessageStack$annotations", "getInAppMessageStack", "()Ljava/util/Stack;", "inAppMessageViewLifecycleListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "inAppMessageViewWrapper", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapper;", "isCurrentlyDisplayingInAppMessage", "", "()Z", "originalOrientation", "", "Ljava/lang/Integer;", "sdkDataWipeEventSubscriber", "Lcom/braze/events/SdkDataWipeEvent;", "unregisteredInAppMessage", "getUnregisteredInAppMessage$annotations", "getUnregisteredInAppMessage", "setUnregisteredInAppMessage", "addInAppMessage", "", "inAppMessage", "createInAppMessageEventSubscriber", "displayInAppMessage", "isCarryOver", "ensureSubscribedToInAppMessageEvents", "context", "Landroid/content/Context;", "getIsCurrentlyDisplayingInAppMessage", "hideCurrentlyDisplayingInAppMessage", "dismissed", "registerInAppMessageManager", "activity", "Landroid/app/Activity;", "requestDisplayInAppMessage", "resetAfterInAppMessageClose", "unregisterInAppMessageManager", "verifyOrientationStatus", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public class BrazeInAppMessageManager extends InAppMessageManagerBase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static volatile BrazeInAppMessageManager instance;
    /* access modifiers changed from: private */
    @NotNull
    public static final ReentrantLock instanceLock = new ReentrantLock();
    @Nullable
    private IInAppMessage carryoverInAppMessage;
    @Nullable
    private BrazeConfigurationProvider configurationProvider;
    @NotNull
    @JvmField
    public final AtomicBoolean displayingInAppMessage = new AtomicBoolean(false);
    @NotNull
    private final Map<IInAppMessage, InAppMessageEvent> inAppMessageEventMap = new LinkedHashMap();
    @Nullable
    private IEventSubscriber<InAppMessageEvent> inAppMessageEventSubscriber;
    @NotNull
    private final Stack<IInAppMessage> inAppMessageStack = new Stack<>();
    @NotNull
    private final IInAppMessageViewLifecycleListener inAppMessageViewLifecycleListener = new DefaultInAppMessageViewLifecycleListener();
    @Nullable
    private IInAppMessageViewWrapper inAppMessageViewWrapper;
    @Nullable
    private Integer originalOrientation;
    @Nullable
    private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;
    @Nullable
    private IInAppMessage unregisteredInAppMessage;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/braze/ui/inappmessage/BrazeInAppMessageManager$Companion;", "", "()V", "instance", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "instanceLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: finally extract failed */
        @JvmStatic
        @NotNull
        public final BrazeInAppMessageManager getInstance() {
            if (BrazeInAppMessageManager.instance != null) {
                BrazeInAppMessageManager access$getInstance$cp = BrazeInAppMessageManager.instance;
                if (access$getInstance$cp != null) {
                    return access$getInstance$cp;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
            }
            ReentrantLock access$getInstanceLock$cp = BrazeInAppMessageManager.instanceLock;
            access$getInstanceLock$cp.lock();
            try {
                if (BrazeInAppMessageManager.instance == null) {
                    BrazeInAppMessageManager.instance = new BrazeInAppMessageManager();
                }
                Unit unit = Unit.INSTANCE;
                access$getInstanceLock$cp.unlock();
                BrazeInAppMessageManager access$getInstance$cp2 = BrazeInAppMessageManager.instance;
                if (access$getInstance$cp2 != null) {
                    return access$getInstance$cp2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.braze.ui.inappmessage.BrazeInAppMessageManager");
            } catch (Throwable th2) {
                access$getInstanceLock$cp.unlock();
                throw th2;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppMessageOperation.values().length];
            iArr[InAppMessageOperation.DISPLAY_NOW.ordinal()] = 1;
            iArr[InAppMessageOperation.DISPLAY_LATER.ordinal()] = 2;
            iArr[InAppMessageOperation.DISCARD.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber() {
        return new c(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: createInAppMessageEventSubscriber$lambda-8  reason: not valid java name */
    public static final void m9206createInAppMessageEventSubscriber$lambda8(BrazeInAppMessageManager brazeInAppMessageManager, InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "event");
        IInAppMessage inAppMessage = inAppMessageEvent.getInAppMessage();
        brazeInAppMessageManager.inAppMessageEventMap.put(inAppMessage, inAppMessageEvent);
        brazeInAppMessageManager.addInAppMessage(inAppMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: displayInAppMessage$lambda-7  reason: not valid java name */
    public static final void m9207displayInAppMessage$lambda7(IInAppMessageViewWrapper iInAppMessageViewWrapper, BrazeInAppMessageManager brazeInAppMessageManager, Activity activity) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        if (iInAppMessageViewWrapper != null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeInAppMessageManager, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$14$1.INSTANCE, 7, (Object) null);
                iInAppMessageViewWrapper.open(activity);
            } catch (Exception e11) {
                BrazeInAppMessageManager brazeInAppMessageManager2 = brazeInAppMessageManager;
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeInAppMessageManager2, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$14$2.INSTANCE, 4, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ensureSubscribedToInAppMessageEvents$lambda-1  reason: not valid java name */
    public static final void m9208ensureSubscribedToInAppMessageEvents$lambda1(BrazeInAppMessageManager brazeInAppMessageManager, SdkDataWipeEvent sdkDataWipeEvent) {
        Intrinsics.checkNotNullParameter(brazeInAppMessageManager, "this$0");
        Intrinsics.checkNotNullParameter(sdkDataWipeEvent, "it");
        brazeInAppMessageManager.inAppMessageStack.clear();
        brazeInAppMessageManager.carryoverInAppMessage = null;
        brazeInAppMessageManager.unregisteredInAppMessage = null;
    }

    @VisibleForTesting
    public static /* synthetic */ void getCarryoverInAppMessage$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDisplayingInAppMessage$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getInAppMessageStack$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final BrazeInAppMessageManager getInstance() {
        return Companion.getInstance();
    }

    @VisibleForTesting
    public static /* synthetic */ void getUnregisteredInAppMessage$annotations() {
    }

    public void addInAppMessage(@Nullable IInAppMessage iInAppMessage) {
        if (iInAppMessage != null) {
            this.inAppMessageStack.push(iInAppMessage);
            requestDisplayInAppMessage();
        }
    }

    public void displayInAppMessage(@NotNull IInAppMessage iInAppMessage, boolean z11) {
        IInAppMessage iInAppMessage2;
        Throwable th2;
        View view;
        Activity activity;
        IInAppMessageViewWrapper iInAppMessageViewWrapper;
        IInAppMessageViewWrapper iInAppMessageViewWrapper2;
        IInAppMessage iInAppMessage3 = iInAppMessage;
        Intrinsics.checkNotNullParameter(iInAppMessage3, "inAppMessage");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeInAppMessageManager$displayInAppMessage$1(iInAppMessage3), 6, (Object) null);
        if (!this.displayingInAppMessage.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$2.INSTANCE, 7, (Object) null);
            this.inAppMessageStack.push(iInAppMessage3);
            return;
        }
        try {
            Activity activity2 = this.f44092a;
            if (activity2 != null) {
                if (!z11) {
                    try {
                        long expirationTimestamp = iInAppMessage.getExpirationTimestamp();
                        if (expirationTimestamp > 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis > expirationTimestamp) {
                                throw new Exception("In-app message is expired. Doing nothing. Expiration: " + expirationTimestamp + ". Current time: " + currentTimeMillis);
                            }
                        } else {
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$3.INSTANCE, 7, (Object) null);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        iInAppMessage2 = iInAppMessage3;
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new BrazeInAppMessageManager$displayInAppMessage$15(iInAppMessage2), 4, (Object) null);
                        resetAfterInAppMessageClose();
                    }
                } else {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$4.INSTANCE, 7, (Object) null);
                }
                if (!verifyOrientationStatus(iInAppMessage)) {
                    IInAppMessage iInAppMessage4 = iInAppMessage3;
                    throw new Exception("Current orientation did not match specified orientation for in-app message. Doing nothing.");
                } else if (iInAppMessage.isControl()) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$5.INSTANCE, 7, (Object) null);
                    iInAppMessage.logImpression();
                    resetAfterInAppMessageClose();
                } else if (BrazeActionUtils.containsInvalidBrazeAction(iInAppMessage)) {
                    InAppMessageEvent inAppMessageEvent = this.inAppMessageEventMap.get(iInAppMessage3);
                    BrazeLogger.Priority priority = BrazeLogger.Priority.I;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$6.INSTANCE, 6, (Object) null);
                    if (inAppMessageEvent != null) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$7.INSTANCE, 6, (Object) null);
                        Context applicationContext = activity2.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
                        BrazeInternal.retryInAppMessage(applicationContext, inAppMessageEvent);
                    }
                    resetAfterInAppMessageClose();
                } else {
                    if (BrazeActionUtils.containsAnyPushPermissionBrazeActions(iInAppMessage)) {
                        if (!PermissionUtils.wouldPushPermissionPromptDisplay(activity2)) {
                            InAppMessageEvent inAppMessageEvent2 = this.inAppMessageEventMap.get(iInAppMessage3);
                            BrazeLogger.Priority priority2 = BrazeLogger.Priority.I;
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority2, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$8.INSTANCE, 6, (Object) null);
                            if (inAppMessageEvent2 != null) {
                                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority2, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$9.INSTANCE, 6, (Object) null);
                                Context applicationContext2 = activity2.getApplicationContext();
                                Intrinsics.checkNotNullExpressionValue(applicationContext2, "activity.applicationContext");
                                BrazeInternal.retryInAppMessage(applicationContext2, inAppMessageEvent2);
                            }
                            resetAfterInAppMessageClose();
                            return;
                        }
                    }
                    IInAppMessageViewFactory inAppMessageViewFactory = getInAppMessageViewFactory(iInAppMessage);
                    if (inAppMessageViewFactory != null) {
                        View createInAppMessageView = inAppMessageViewFactory.createInAppMessageView(activity2, iInAppMessage3);
                        if (createInAppMessageView == null) {
                            iInAppMessage3.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
                            throw new Exception("The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
                        } else if (createInAppMessageView.getParent() == null) {
                            BrazeConfigurationProvider brazeConfigurationProvider = this.configurationProvider;
                            if (brazeConfigurationProvider != null) {
                                Animation openingAnimation = getInAppMessageAnimationFactory().getOpeningAnimation(iInAppMessage3);
                                Animation closingAnimation = getInAppMessageAnimationFactory().getClosingAnimation(iInAppMessage3);
                                IInAppMessageViewWrapperFactory inAppMessageViewWrapperFactory = getInAppMessageViewWrapperFactory();
                                if (createInAppMessageView instanceof IInAppMessageImmersiveView) {
                                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$10.INSTANCE, 7, (Object) null);
                                    IInAppMessageImmersiveView iInAppMessageImmersiveView = (IInAppMessageImmersiveView) createInAppMessageView;
                                    int size = ((InAppMessageImmersiveBase) iInAppMessage3).getMessageButtons().size();
                                    View view2 = createInAppMessageView;
                                    Activity activity3 = activity2;
                                    IInAppMessage iInAppMessage5 = iInAppMessage3;
                                    try {
                                        iInAppMessageViewWrapper = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(createInAppMessageView, iInAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider, openingAnimation, closingAnimation, iInAppMessageImmersiveView.getMessageClickableView(), iInAppMessageImmersiveView.getMessageButtonViews(size), iInAppMessageImmersiveView.getMessageCloseButtonView());
                                        IInAppMessage iInAppMessage6 = iInAppMessage5;
                                        activity = activity3;
                                        view = view2;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        iInAppMessage2 = iInAppMessage5;
                                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new BrazeInAppMessageManager$displayInAppMessage$15(iInAppMessage2), 4, (Object) null);
                                        resetAfterInAppMessageClose();
                                    }
                                } else {
                                    BrazeConfigurationProvider brazeConfigurationProvider2 = brazeConfigurationProvider;
                                    View view3 = createInAppMessageView;
                                    Activity activity4 = activity2;
                                    IInAppMessage iInAppMessage7 = iInAppMessage3;
                                    try {
                                        if (view3 instanceof IInAppMessageView) {
                                            iInAppMessage2 = iInAppMessage7;
                                            activity = activity4;
                                            view = view3;
                                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$11.INSTANCE, 7, (Object) null);
                                            iInAppMessageViewWrapper2 = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(view, iInAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider2, openingAnimation, closingAnimation, ((IInAppMessageView) view).getMessageClickableView());
                                        } else {
                                            IInAppMessage iInAppMessage8 = iInAppMessage7;
                                            activity = activity4;
                                            view = view3;
                                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$12.INSTANCE, 7, (Object) null);
                                            iInAppMessageViewWrapper2 = inAppMessageViewWrapperFactory.createInAppMessageViewWrapper(view, iInAppMessage, this.inAppMessageViewLifecycleListener, brazeConfigurationProvider2, openingAnimation, closingAnimation, view);
                                        }
                                        iInAppMessageViewWrapper = iInAppMessageViewWrapper2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th2 = th;
                                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new BrazeInAppMessageManager$displayInAppMessage$15(iInAppMessage2), 4, (Object) null);
                                        resetAfterInAppMessageClose();
                                    }
                                }
                                this.inAppMessageViewWrapper = iInAppMessageViewWrapper;
                                if (view instanceof InAppMessageHtmlBaseView) {
                                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$displayInAppMessage$13.INSTANCE, 7, (Object) null);
                                    ((InAppMessageHtmlBaseView) view).setHtmlPageFinishedListener(new b(iInAppMessageViewWrapper, this, activity));
                                } else if (iInAppMessageViewWrapper != null) {
                                    iInAppMessageViewWrapper.open(activity);
                                }
                            } else {
                                IInAppMessage iInAppMessage9 = iInAppMessage3;
                                throw new Exception("configurationProvider is null. The in-app message will not be displayed and will not beput back on the stack.");
                            }
                        } else {
                            iInAppMessage3.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
                            throw new Exception("The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
                        }
                    } else {
                        iInAppMessage3.logDisplayFailure(InAppMessageFailureType.DISPLAY_VIEW_GENERATION);
                        throw new Exception("ViewFactory from getInAppMessageViewFactory was null.");
                    }
                }
            } else {
                this.carryoverInAppMessage = iInAppMessage3;
                throw new Exception("No Activity is currently registered to receive in-app messages. Registering in-app message as carry-over in-app message. It will automatically be displayed when the next Activity registers to receive in-app messages.");
            }
        } catch (Throwable th6) {
            th = th6;
            iInAppMessage2 = iInAppMessage3;
            th2 = th;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new BrazeInAppMessageManager$displayInAppMessage$15(iInAppMessage2), 4, (Object) null);
            resetAfterInAppMessageClose();
        }
    }

    public void ensureSubscribedToInAppMessageEvents(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.inAppMessageEventSubscriber != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$1.INSTANCE, 7, (Object) null);
            Braze.Companion.getInstance(context).removeSingleSubscription(this.inAppMessageEventSubscriber, InAppMessageEvent.class);
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$2.INSTANCE, 7, (Object) null);
        IEventSubscriber<InAppMessageEvent> createInAppMessageEventSubscriber = createInAppMessageEventSubscriber();
        Braze.Companion companion = Braze.Companion;
        companion.getInstance(context).subscribeToNewInAppMessages(createInAppMessageEventSubscriber);
        this.inAppMessageEventSubscriber = createInAppMessageEventSubscriber;
        Class<SdkDataWipeEvent> cls = SdkDataWipeEvent.class;
        if (this.sdkDataWipeEventSubscriber != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$4.INSTANCE, 6, (Object) null);
            companion.getInstance(context).removeSingleSubscription(this.sdkDataWipeEventSubscriber, cls);
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BrazeInAppMessageManager$ensureSubscribedToInAppMessageEvents$5.INSTANCE, 6, (Object) null);
        a aVar = new a(this);
        companion.getInstance(context).addSingleSynchronousSubscription(aVar, cls);
        this.sdkDataWipeEventSubscriber = aVar;
    }

    @Nullable
    public final IInAppMessage getCarryoverInAppMessage() {
        return this.carryoverInAppMessage;
    }

    @NotNull
    public final Map<IInAppMessage, InAppMessageEvent> getInAppMessageEventMap() {
        return this.inAppMessageEventMap;
    }

    @NotNull
    public final Stack<IInAppMessage> getInAppMessageStack() {
        return this.inAppMessageStack;
    }

    public boolean getIsCurrentlyDisplayingInAppMessage() {
        return this.displayingInAppMessage.get();
    }

    @Nullable
    public final IInAppMessage getUnregisteredInAppMessage() {
        return this.unregisteredInAppMessage;
    }

    public void hideCurrentlyDisplayingInAppMessage(boolean z11) {
        setShouldNextUnregisterBeSkipped(false);
        IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
        if (iInAppMessageViewWrapper != null) {
            if (z11) {
                this.inAppMessageViewLifecycleListener.onDismissed(iInAppMessageViewWrapper.getInAppMessageView(), iInAppMessageViewWrapper.getInAppMessage());
            }
            iInAppMessageViewWrapper.close();
        }
    }

    public final boolean isCurrentlyDisplayingInAppMessage() {
        return this.displayingInAppMessage.get();
    }

    public void registerInAppMessageManager(@Nullable Activity activity) {
        BrazeConfigurationProvider brazeConfigurationProvider;
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$1.INSTANCE, 6, (Object) null);
            return;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeInAppMessageManager$registerInAppMessageManager$2(activity), 6, (Object) null);
        this.f44092a = activity;
        if (this.f44093b == null) {
            Context applicationContext = activity.getApplicationContext();
            this.f44093b = applicationContext;
            if (applicationContext == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$3.INSTANCE, 6, (Object) null);
                return;
            }
        }
        if (this.configurationProvider == null) {
            Context context = this.f44093b;
            if (context == null) {
                brazeConfigurationProvider = null;
            } else {
                brazeConfigurationProvider = new BrazeConfigurationProvider(context);
            }
            this.configurationProvider = brazeConfigurationProvider;
        }
        IInAppMessage iInAppMessage = this.carryoverInAppMessage;
        if (iInAppMessage != null) {
            if (iInAppMessage != null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$5$1.INSTANCE, 7, (Object) null);
                iInAppMessage.setAnimateIn(false);
                displayInAppMessage(iInAppMessage, true);
            }
            this.carryoverInAppMessage = null;
        } else {
            IInAppMessage iInAppMessage2 = this.unregisteredInAppMessage;
            if (iInAppMessage2 != null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$registerInAppMessageManager$6$1.INSTANCE, 7, (Object) null);
                addInAppMessage(iInAppMessage2);
                setUnregisteredInAppMessage((IInAppMessage) null);
            }
        }
        Context context2 = this.f44093b;
        if (context2 != null) {
            ensureSubscribedToInAppMessageEvents(context2);
        }
    }

    public boolean requestDisplayInAppMessage() {
        InAppMessageOperation inAppMessageOperation;
        try {
            if (this.f44092a == null) {
                if (!this.inAppMessageStack.empty()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$1.INSTANCE, 6, (Object) null);
                    this.unregisteredInAppMessage = this.inAppMessageStack.pop();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$2.INSTANCE, 7, (Object) null);
                }
                return false;
            } else if (this.displayingInAppMessage.get()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$3.INSTANCE, 7, (Object) null);
                return false;
            } else if (this.inAppMessageStack.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$4.INSTANCE, 7, (Object) null);
                return false;
            } else {
                IInAppMessage pop = this.inAppMessageStack.pop();
                if (!pop.isControl()) {
                    IInAppMessageManagerListener inAppMessageManagerListener = getInAppMessageManagerListener();
                    Intrinsics.checkNotNullExpressionValue(pop, "inAppMessage");
                    inAppMessageOperation = inAppMessageManagerListener.beforeInAppMessageDisplayed(pop);
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$inAppMessageOperation$1.INSTANCE, 7, (Object) null);
                    IInAppMessageManagerListener controlInAppMessageManagerListener = getControlInAppMessageManagerListener();
                    Intrinsics.checkNotNullExpressionValue(pop, "inAppMessage");
                    inAppMessageOperation = controlInAppMessageManagerListener.beforeInAppMessageDisplayed(pop);
                }
                int i11 = WhenMappings.$EnumSwitchMapping$0[inAppMessageOperation.ordinal()];
                if (i11 == 1) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$5.INSTANCE, 7, (Object) null);
                } else if (i11 == 2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$6.INSTANCE, 7, (Object) null);
                    this.inAppMessageStack.push(pop);
                    return false;
                } else if (i11 == 3) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$7.INSTANCE, 7, (Object) null);
                    return false;
                }
                BackgroundInAppMessagePreparer.prepareInAppMessageForDisplay(pop);
                return true;
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeInAppMessageManager$requestDisplayInAppMessage$8.INSTANCE, 4, (Object) null);
            return false;
        }
    }

    public void resetAfterInAppMessageClose() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BrazeInAppMessageManager$resetAfterInAppMessageClose$1.INSTANCE, 6, (Object) null);
        this.inAppMessageViewWrapper = null;
        Activity activity = this.f44092a;
        Integer num = this.originalOrientation;
        this.displayingInAppMessage.set(false);
        if (activity != null && num != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeInAppMessageManager$resetAfterInAppMessageClose$2(num), 7, (Object) null);
            ViewUtils.setActivityRequestedOrientation(activity, num.intValue());
            this.originalOrientation = null;
        }
    }

    public final void setCarryoverInAppMessage(@Nullable IInAppMessage iInAppMessage) {
        this.carryoverInAppMessage = iInAppMessage;
    }

    public final void setUnregisteredInAppMessage(@Nullable IInAppMessage iInAppMessage) {
        this.unregisteredInAppMessage = iInAppMessage;
    }

    public void unregisterInAppMessageManager(@Nullable Activity activity) {
        IInAppMessage iInAppMessage;
        if (getShouldNextUnregisterBeSkipped()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeInAppMessageManager$unregisterInAppMessageManager$1(activity), 7, (Object) null);
            setShouldNextUnregisterBeSkipped(false);
            return;
        }
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeInAppMessageManager$unregisterInAppMessageManager$2.INSTANCE, 6, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeInAppMessageManager$unregisterInAppMessageManager$3(activity), 6, (Object) null);
        }
        IInAppMessageViewWrapper iInAppMessageViewWrapper = this.inAppMessageViewWrapper;
        if (iInAppMessageViewWrapper != null) {
            View inAppMessageView = iInAppMessageViewWrapper.getInAppMessageView();
            if (inAppMessageView instanceof InAppMessageHtmlBaseView) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$unregisterInAppMessageManager$4.INSTANCE, 7, (Object) null);
                ((InAppMessageHtmlBaseView) inAppMessageView).setHtmlPageFinishedListener((IWebViewClientStateListener) null);
            }
            ViewUtils.removeViewFromParent(inAppMessageView);
            if (iInAppMessageViewWrapper.isAnimatingClose()) {
                this.inAppMessageViewLifecycleListener.afterClosed(iInAppMessageViewWrapper.getInAppMessage());
                iInAppMessage = null;
            } else {
                iInAppMessage = iInAppMessageViewWrapper.getInAppMessage();
            }
            this.carryoverInAppMessage = iInAppMessage;
            this.inAppMessageViewWrapper = null;
        } else {
            this.carryoverInAppMessage = null;
        }
        this.f44092a = null;
        this.displayingInAppMessage.set(false);
    }

    @VisibleForTesting
    @SuppressLint({"InlinedApi"})
    public boolean verifyOrientationStatus(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Activity activity = this.f44092a;
        Orientation orientation = iInAppMessage.getOrientation();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$1.INSTANCE, 6, (Object) null);
        } else if (ViewUtils.isRunningOnTablet(activity)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$2.INSTANCE, 7, (Object) null);
        } else if (orientation == Orientation.ANY) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$3.INSTANCE, 7, (Object) null);
        } else if (!ViewUtils.isCurrentOrientationValid(activity.getResources().getConfiguration().orientation, orientation)) {
            return false;
        } else {
            if (this.originalOrientation != null) {
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) BrazeInAppMessageManager$verifyOrientationStatus$4.INSTANCE, 7, (Object) null);
            this.originalOrientation = Integer.valueOf(activity.getRequestedOrientation());
            ViewUtils.setActivityRequestedOrientation(activity, 14);
            return true;
        }
        return true;
    }
}
