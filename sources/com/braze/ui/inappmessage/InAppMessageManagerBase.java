package com.braze.ui.inappmessage;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RestrictTo;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageAnimationFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlFullViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageModalViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageSlideupViewFactory;
import com.braze.ui.inappmessage.factories.DefaultInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.DefaultHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\\\u0010)J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00078\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u001e\u0010*\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u000e¢\u0006\f\n\u0004\b&\u0010'\u0012\u0004\b(\u0010)R\u001e\u0010/\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u000e¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010)R\u0014\u00101\u001a\u0002008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u00106R\u0018\u0010B\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010>R\u0018\u0010D\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u00104R\u0018\u0010F\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010>R\u0014\u0010H\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010!R\u0014\u0010J\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010!R\u0016\u0010M\u001a\u0004\u0018\u00010%8VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010P\u001a\u0004\u0018\u00010+8VX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010\u000e\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010RR\u0014\u0010\u0012\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010\u001a\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010\u0015\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\u00078WX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010!¨\u0006]"}, d2 = {"Lcom/braze/ui/inappmessage/InAppMessageManagerBase;", "", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessage", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "getDefaultInAppMessageViewFactory", "getInAppMessageViewFactory", "", "backButtonDismissesInAppMessageView", "", "setBackButtonDismissesInAppMessageView", "doesDismiss", "setClickOutsideModalViewDismissInAppMessageView", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "inAppMessageManagerListener", "setCustomInAppMessageManagerListener", "setCustomControlInAppMessageManagerListener", "Lcom/braze/ui/inappmessage/listeners/IHtmlInAppMessageActionListener;", "htmlInAppMessageActionListener", "setCustomHtmlInAppMessageActionListener", "Lcom/braze/ui/inappmessage/IInAppMessageAnimationFactory;", "inAppMessageAnimationFactory", "setCustomInAppMessageAnimationFactory", "inAppMessageViewFactory", "setCustomInAppMessageViewFactory", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapperFactory;", "inAppMessageViewWrapperFactory", "setCustomInAppMessageViewWrapperFactory", "doesClickOutsideModalViewDismissInAppMessageViewField", "Z", "shouldSkip", "shouldNextUnregisterBeSkipped", "getShouldNextUnregisterBeSkipped", "()Z", "setShouldNextUnregisterBeSkipped", "(Z)V", "doesBackButtonDismissInAppMessageViewField", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getMActivity$annotations", "()V", "mActivity", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getMApplicationContext$annotations", "mApplicationContext", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "inAppMessageWebViewClientListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "defaultHtmlInAppMessageActionListener", "Lcom/braze/ui/inappmessage/listeners/IHtmlInAppMessageActionListener;", "inAppMessageSlideupViewFactory", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "inAppMessageModalViewFactory", "inAppMessageFullViewFactory", "inAppMessageHtmlFullViewFactory", "inAppMessageHtmlViewFactory", "inAppMessageAnimationFactoryField", "Lcom/braze/ui/inappmessage/IInAppMessageAnimationFactory;", "defaultInAppMessageManagerListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "defaultInAppMessageViewWrapperFactory", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapperFactory;", "customInAppMessageViewFactory", "customInAppMessageAnimationFactory", "customInAppMessageManagerListener", "customInAppMessageViewWrapperFactory", "customHtmlInAppMessageActionListener", "customControlInAppMessageManagerListener", "getDoesClickOutsideModalViewDismissInAppMessageView", "doesClickOutsideModalViewDismissInAppMessageView", "getDoesBackButtonDismissInAppMessageView", "doesBackButtonDismissInAppMessageView", "getActivity", "()Landroid/app/Activity;", "activity", "getApplicationContext", "()Landroid/content/Context;", "applicationContext", "getInAppMessageManagerListener", "()Lcom/braze/ui/inappmessage/listeners/IInAppMessageManagerListener;", "getControlInAppMessageManagerListener", "controlInAppMessageManagerListener", "getHtmlInAppMessageActionListener", "()Lcom/braze/ui/inappmessage/listeners/IHtmlInAppMessageActionListener;", "getInAppMessageViewWrapperFactory", "()Lcom/braze/ui/inappmessage/IInAppMessageViewWrapperFactory;", "getInAppMessageAnimationFactory", "()Lcom/braze/ui/inappmessage/IInAppMessageAnimationFactory;", "isActivitySet", "<init>", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0})
public class InAppMessageManagerBase {
    @Nullable
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public Activity f44092a;
    @Nullable
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public Context f44093b;
    @Nullable
    private IInAppMessageManagerListener customControlInAppMessageManagerListener;
    @Nullable
    private IHtmlInAppMessageActionListener customHtmlInAppMessageActionListener;
    @Nullable
    private IInAppMessageAnimationFactory customInAppMessageAnimationFactory;
    @Nullable
    private IInAppMessageManagerListener customInAppMessageManagerListener;
    @Nullable
    private IInAppMessageViewFactory customInAppMessageViewFactory;
    @Nullable
    private IInAppMessageViewWrapperFactory customInAppMessageViewWrapperFactory;
    @NotNull
    private final IHtmlInAppMessageActionListener defaultHtmlInAppMessageActionListener;
    @NotNull
    private final IInAppMessageManagerListener defaultInAppMessageManagerListener;
    @NotNull
    private final IInAppMessageViewWrapperFactory defaultInAppMessageViewWrapperFactory;
    private boolean doesBackButtonDismissInAppMessageViewField = true;
    private boolean doesClickOutsideModalViewDismissInAppMessageViewField;
    @NotNull
    private final IInAppMessageAnimationFactory inAppMessageAnimationFactoryField;
    @NotNull
    private final IInAppMessageViewFactory inAppMessageFullViewFactory;
    @NotNull
    private final IInAppMessageViewFactory inAppMessageHtmlFullViewFactory;
    @NotNull
    private final IInAppMessageViewFactory inAppMessageHtmlViewFactory;
    @NotNull
    private final IInAppMessageViewFactory inAppMessageModalViewFactory;
    @NotNull
    private final IInAppMessageViewFactory inAppMessageSlideupViewFactory;
    @NotNull
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;
    private boolean shouldNextUnregisterBeSkipped;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.SLIDEUP.ordinal()] = 1;
            iArr[MessageType.MODAL.ordinal()] = 2;
            iArr[MessageType.FULL.ordinal()] = 3;
            iArr[MessageType.HTML_FULL.ordinal()] = 4;
            iArr[MessageType.HTML.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InAppMessageManagerBase() {
        DefaultInAppMessageWebViewClientListener defaultInAppMessageWebViewClientListener = new DefaultInAppMessageWebViewClientListener();
        this.inAppMessageWebViewClientListener = defaultInAppMessageWebViewClientListener;
        this.defaultHtmlInAppMessageActionListener = new DefaultHtmlInAppMessageActionListener();
        this.inAppMessageSlideupViewFactory = new DefaultInAppMessageSlideupViewFactory();
        this.inAppMessageModalViewFactory = new DefaultInAppMessageModalViewFactory();
        this.inAppMessageFullViewFactory = new DefaultInAppMessageFullViewFactory();
        this.inAppMessageHtmlFullViewFactory = new DefaultInAppMessageHtmlFullViewFactory(defaultInAppMessageWebViewClientListener);
        this.inAppMessageHtmlViewFactory = new DefaultInAppMessageHtmlViewFactory(defaultInAppMessageWebViewClientListener);
        this.inAppMessageAnimationFactoryField = new DefaultInAppMessageAnimationFactory();
        this.defaultInAppMessageManagerListener = new DefaultInAppMessageManagerListener();
        this.defaultInAppMessageViewWrapperFactory = new DefaultInAppMessageViewWrapperFactory();
    }

    @Nullable
    public Activity getActivity() {
        return this.f44092a;
    }

    @Nullable
    public Context getApplicationContext() {
        return this.f44093b;
    }

    @NotNull
    public IInAppMessageManagerListener getControlInAppMessageManagerListener() {
        IInAppMessageManagerListener iInAppMessageManagerListener = this.customControlInAppMessageManagerListener;
        return iInAppMessageManagerListener == null ? this.defaultInAppMessageManagerListener : iInAppMessageManagerListener;
    }

    @Nullable
    public IInAppMessageViewFactory getDefaultInAppMessageViewFactory(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        int i11 = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i11 == 1) {
            return this.inAppMessageSlideupViewFactory;
        }
        if (i11 == 2) {
            return this.inAppMessageModalViewFactory;
        }
        if (i11 == 3) {
            return this.inAppMessageFullViewFactory;
        }
        if (i11 == 4) {
            return this.inAppMessageHtmlFullViewFactory;
        }
        if (i11 == 5) {
            return this.inAppMessageHtmlViewFactory;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageManagerBase$getDefaultInAppMessageViewFactory$1(iInAppMessage), 6, (Object) null);
        return null;
    }

    public boolean getDoesBackButtonDismissInAppMessageView() {
        return this.doesBackButtonDismissInAppMessageViewField;
    }

    public boolean getDoesClickOutsideModalViewDismissInAppMessageView() {
        return this.doesClickOutsideModalViewDismissInAppMessageViewField;
    }

    @NotNull
    public IHtmlInAppMessageActionListener getHtmlInAppMessageActionListener() {
        IHtmlInAppMessageActionListener iHtmlInAppMessageActionListener = this.customHtmlInAppMessageActionListener;
        return iHtmlInAppMessageActionListener == null ? this.defaultHtmlInAppMessageActionListener : iHtmlInAppMessageActionListener;
    }

    @NotNull
    public IInAppMessageAnimationFactory getInAppMessageAnimationFactory() {
        IInAppMessageAnimationFactory iInAppMessageAnimationFactory = this.customInAppMessageAnimationFactory;
        return iInAppMessageAnimationFactory == null ? this.inAppMessageAnimationFactoryField : iInAppMessageAnimationFactory;
    }

    @NotNull
    public IInAppMessageManagerListener getInAppMessageManagerListener() {
        IInAppMessageManagerListener iInAppMessageManagerListener = this.customInAppMessageManagerListener;
        return iInAppMessageManagerListener == null ? this.defaultInAppMessageManagerListener : iInAppMessageManagerListener;
    }

    @Nullable
    public IInAppMessageViewFactory getInAppMessageViewFactory(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        IInAppMessageViewFactory iInAppMessageViewFactory = this.customInAppMessageViewFactory;
        if (iInAppMessageViewFactory == null) {
            return getDefaultInAppMessageViewFactory(iInAppMessage);
        }
        return iInAppMessageViewFactory;
    }

    @NotNull
    public IInAppMessageViewWrapperFactory getInAppMessageViewWrapperFactory() {
        IInAppMessageViewWrapperFactory iInAppMessageViewWrapperFactory = this.customInAppMessageViewWrapperFactory;
        return iInAppMessageViewWrapperFactory == null ? this.defaultInAppMessageViewWrapperFactory : iInAppMessageViewWrapperFactory;
    }

    public boolean getShouldNextUnregisterBeSkipped() {
        return this.shouldNextUnregisterBeSkipped;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public boolean isActivitySet() {
        return getActivity() != null;
    }

    public void setBackButtonDismissesInAppMessageView(boolean z11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageManagerBase$setBackButtonDismissesInAppMessageView$1(z11), 7, (Object) null);
        this.doesBackButtonDismissInAppMessageViewField = z11;
    }

    public void setClickOutsideModalViewDismissInAppMessageView(boolean z11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageManagerBase$setClickOutsideModalViewDismissInAppMessageView$1(z11), 7, (Object) null);
        this.doesClickOutsideModalViewDismissInAppMessageViewField = z11;
    }

    public void setCustomControlInAppMessageManagerListener(@Nullable IInAppMessageManagerListener iInAppMessageManagerListener) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomControlInAppMessageManagerListener$1.INSTANCE, 7, (Object) null);
        this.customControlInAppMessageManagerListener = iInAppMessageManagerListener;
    }

    public void setCustomHtmlInAppMessageActionListener(@Nullable IHtmlInAppMessageActionListener iHtmlInAppMessageActionListener) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomHtmlInAppMessageActionListener$1.INSTANCE, 7, (Object) null);
        this.customHtmlInAppMessageActionListener = iHtmlInAppMessageActionListener;
    }

    public void setCustomInAppMessageAnimationFactory(@Nullable IInAppMessageAnimationFactory iInAppMessageAnimationFactory) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomInAppMessageAnimationFactory$1.INSTANCE, 7, (Object) null);
        this.customInAppMessageAnimationFactory = iInAppMessageAnimationFactory;
    }

    public void setCustomInAppMessageManagerListener(@Nullable IInAppMessageManagerListener iInAppMessageManagerListener) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomInAppMessageManagerListener$1.INSTANCE, 7, (Object) null);
        this.customInAppMessageManagerListener = iInAppMessageManagerListener;
    }

    public void setCustomInAppMessageViewFactory(@Nullable IInAppMessageViewFactory iInAppMessageViewFactory) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomInAppMessageViewFactory$1.INSTANCE, 7, (Object) null);
        this.customInAppMessageViewFactory = iInAppMessageViewFactory;
    }

    public void setCustomInAppMessageViewWrapperFactory(@Nullable IInAppMessageViewWrapperFactory iInAppMessageViewWrapperFactory) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageManagerBase$setCustomInAppMessageViewWrapperFactory$1.INSTANCE, 7, (Object) null);
        this.customInAppMessageViewWrapperFactory = iInAppMessageViewWrapperFactory;
    }

    public void setShouldNextUnregisterBeSkipped(boolean z11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageManagerBase$shouldNextUnregisterBeSkipped$1(z11), 7, (Object) null);
        this.shouldNextUnregisterBeSkipped = z11;
    }
}
