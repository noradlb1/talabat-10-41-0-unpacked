package com.braze.brazeplugin;

import android.app.Application;
import android.content.Context;
import com.braze.Braze;
import com.braze.BrazeActivityLifecycleCallbackListener;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r3.e;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/braze/brazeplugin/IntegrationInitializer;", "", "()V", "contentCardsUpdatedSubscriber", "Lcom/braze/events/IEventSubscriber;", "Lcom/braze/events/ContentCardsUpdatedEvent;", "isUninitialized", "", "()Z", "setUninitialized", "(Z)V", "initializePlugin", "", "application", "Landroid/app/Application;", "config", "Lcom/braze/brazeplugin/FlutterCachedConfiguration;", "initializePlugin$braze_plugin_release", "subscribeToContentCardsUpdatedEvent", "ctx", "Landroid/content/Context;", "BrazeInAppMessageManagerListener", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntegrationInitializer {
    @NotNull
    public static final IntegrationInitializer INSTANCE = new IntegrationInitializer();
    @Nullable
    private static IEventSubscriber<ContentCardsUpdatedEvent> contentCardsUpdatedSubscriber;
    private static boolean isUninitialized = true;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/braze/brazeplugin/IntegrationInitializer$BrazeInAppMessageManagerListener;", "Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageManagerListener;", "defaultInAppMessageOperation", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "(Lcom/braze/ui/inappmessage/InAppMessageOperation;)V", "getDefaultInAppMessageOperation", "()Lcom/braze/ui/inappmessage/InAppMessageOperation;", "beforeInAppMessageDisplayed", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BrazeInAppMessageManagerListener extends DefaultInAppMessageManagerListener {
        @NotNull
        private final InAppMessageOperation defaultInAppMessageOperation;

        public BrazeInAppMessageManagerListener(@NotNull InAppMessageOperation inAppMessageOperation) {
            Intrinsics.checkNotNullParameter(inAppMessageOperation, "defaultInAppMessageOperation");
            this.defaultInAppMessageOperation = inAppMessageOperation;
        }

        @NotNull
        public InAppMessageOperation beforeInAppMessageDisplayed(@NotNull IInAppMessage iInAppMessage) {
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            super.beforeInAppMessageDisplayed(iInAppMessage);
            BrazePlugin.Companion.processInAppMessage(iInAppMessage);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new IntegrationInitializer$BrazeInAppMessageManagerListener$beforeInAppMessageDisplayed$1(this), 7, (Object) null);
            return this.defaultInAppMessageOperation;
        }

        @NotNull
        public final InAppMessageOperation getDefaultInAppMessageOperation() {
            return this.defaultInAppMessageOperation;
        }
    }

    private IntegrationInitializer() {
    }

    private final void subscribeToContentCardsUpdatedEvent(Context context) {
        Braze.Companion companion = Braze.Companion;
        companion.getInstance(context).removeSingleSubscription(contentCardsUpdatedSubscriber, ContentCardsUpdatedEvent.class);
        e eVar = new e();
        contentCardsUpdatedSubscriber = eVar;
        companion.getInstance(context).subscribeToContentCardsUpdates(eVar);
        companion.getInstance(context).requestContentCardsRefresh(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToContentCardsUpdatedEvent$lambda-0  reason: not valid java name */
    public static final void m9199subscribeToContentCardsUpdatedEvent$lambda0(ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "it");
        BrazePlugin.Companion.processContentCards(contentCardsUpdatedEvent.getAllCards());
    }

    public final void initializePlugin$braze_plugin_release(@NotNull Application application, @NotNull FlutterCachedConfiguration flutterCachedConfiguration) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(flutterCachedConfiguration, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        application.registerActivityLifecycleCallbacks(new BrazeActivityLifecycleCallbackListener(false, false, (Set) null, (Set) null, 15, (DefaultConstructorMarker) null));
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "ctx");
        subscribeToContentCardsUpdatedEvent(applicationContext);
        BrazeInAppMessageManager.Companion.getInstance().setCustomInAppMessageManagerListener(new BrazeInAppMessageManagerListener(flutterCachedConfiguration.automaticIntegrationInAppMessageOperation()));
        isUninitialized = false;
    }

    public final boolean isUninitialized() {
        return isUninitialized;
    }

    public final void setUninitialized(boolean z11) {
        isUninitialized = z11;
    }
}
