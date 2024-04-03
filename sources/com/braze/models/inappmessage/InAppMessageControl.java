package com.braze.models.inappmessage;

import bo.app.b2;
import bo.app.j;
import bo.app.x1;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageControl;", "Lcom/braze/models/inappmessage/InAppMessageBase;", "", "logImpression", "Ljava/util/concurrent/atomic/AtomicBoolean;", "controlImpressionLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "messageType", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/b2;", "brazeManager", "<init>", "(Lorg/json/JSONObject;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class InAppMessageControl extends InAppMessageBase {
    private final AtomicBoolean controlImpressionLogged = new AtomicBoolean(false);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43784b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Control impression already logged for this in-app message. Ignoring.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43785b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger Id not found (this is expected for test sends). Not logging in-app message control impression.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43786b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message control impression because the BrazeManager is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43787b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging control in-app message impression event";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageControl(JSONObject jSONObject, b2 b2Var) {
        super(jSONObject, b2Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
    }

    public MessageType getMessageType() {
        return MessageType.CONTROL;
    }

    public boolean logImpression() {
        boolean z11;
        x1 x1Var;
        if (this.controlImpressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43784b, 6, (Object) null);
            return false;
        }
        String triggerId = getTriggerId();
        if (triggerId == null || triggerId.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43785b, 6, (Object) null);
            return false;
        } else if (getBrazeManager() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f43786b, 6, (Object) null);
            return false;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) d.f43787b, 6, (Object) null);
            String triggerId2 = getTriggerId();
            if (triggerId2 == null) {
                x1Var = null;
            } else {
                x1Var = j.f38653h.h(triggerId2);
            }
            if (x1Var != null) {
                b2 brazeManager = getBrazeManager();
                if (brazeManager != null) {
                    brazeManager.a(x1Var);
                }
                this.controlImpressionLogged.set(true);
            }
            return true;
        }
    }
}
