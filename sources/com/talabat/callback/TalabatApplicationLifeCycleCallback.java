package com.talabat.callback;

import com.braze.BrazeActivityLifecycleCallbackListener;
import com.talabat.CartScreen;
import com.talabat.CheckOutScreen;
import com.talabat.adscreen.AdScreen;
import com.talabat.splash.presentation.ui.SplashActivity;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/callback/TalabatApplicationLifeCycleCallback;", "Lcom/braze/BrazeActivityLifecycleCallbackListener;", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplicationLifeCycleCallback extends BrazeActivityLifecycleCallbackListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final HashSet<Class<?>> brazeRestrictedInAppMessagesActivities;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/callback/TalabatApplicationLifeCycleCallback$Companion;", "", "()V", "brazeRestrictedInAppMessagesActivities", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lkotlin/collections/HashSet;", "getBrazeRestrictedInAppMessagesActivities", "()Ljava/util/HashSet;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashSet<Class<?>> getBrazeRestrictedInAppMessagesActivities() {
            return TalabatApplicationLifeCycleCallback.brazeRestrictedInAppMessagesActivities;
        }
    }

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        hashSet.add(SplashActivity.class);
        hashSet.add(AdScreen.class);
        hashSet.add(CartScreen.class);
        hashSet.add(CheckOutScreen.class);
        brazeRestrictedInAppMessagesActivities = hashSet;
    }

    public TalabatApplicationLifeCycleCallback() {
        super((Set) brazeRestrictedInAppMessagesActivities, (Set) null, 2, (DefaultConstructorMarker) null);
    }
}
