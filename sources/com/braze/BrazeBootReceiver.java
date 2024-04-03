package com.braze;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bo.app.r1;
import com.braze.support.BrazeLogger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0017\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/braze/BrazeBootReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "handleIncomingIntent", "<init>", "()V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class BrazeBootReceiver extends BroadcastReceiver {
    private static final String BOOT_COMPLETE_ACTION = "android.intent.action.BOOT_COMPLETED";
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/braze/BrazeBootReceiver$a;", "", "", "BOOT_COMPLETE_ACTION", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f43541g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Intent intent) {
            super(0);
            this.f43541g = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Received broadcast message. Message: ", this.f43541g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43542b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Boot complete intent received. Initializing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f43543g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Intent intent) {
            super(0);
            this.f43543g = intent;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unknown intent " + this.f43543g + " received. Doing nothing.";
        }
    }

    public final boolean handleIncomingIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.I;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new b(intent), 6, (Object) null);
        if (Intrinsics.areEqual((Object) BOOT_COMPLETE_ACTION, (Object) intent.getAction())) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) c.f43542b, 6, (Object) null);
            r1.a(context);
            Braze.Companion.getInstance(context);
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new d(intent), 6, (Object) null);
        return false;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        handleIncomingIntent(context, intent);
    }
}
