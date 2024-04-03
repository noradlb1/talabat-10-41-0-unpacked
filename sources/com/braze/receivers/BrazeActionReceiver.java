package com.braze.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import bo.app.a2;
import bo.app.n;
import bo.app.o1;
import com.braze.BrazeInternal;
import com.braze.support.BrazeLogger;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationResult;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/receivers/BrazeActionReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeActionReceiver extends BroadcastReceiver {

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/braze/receivers/BrazeActionReceiver$a;", "", "", "b", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "applicationContext", "Landroid/content/Intent;", "Landroid/content/Intent;", "intent", "", "c", "Ljava/lang/String;", "action", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "d", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        public static final C0042a f43871d = new C0042a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final Context f43872a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Intent f43873b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f43874c;

        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcom/braze/receivers/BrazeActionReceiver$a$a;", "", "Landroid/content/Context;", "applicationContext", "Landroid/location/Location;", "location", "", "a", "Lcom/google/android/gms/location/LocationResult;", "locationResult", "Lcom/google/android/gms/location/GeofencingEvent;", "geofenceEvent", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
        /* renamed from: com.braze.receivers.BrazeActionReceiver$a$a  reason: collision with other inner class name */
        public static final class C0042a {

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: com.braze.receivers.BrazeActionReceiver$a$a$a  reason: collision with other inner class name */
            public static final class C0043a extends Lambda implements Function0<String> {

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f43875g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0043a(int i11) {
                    super(0);
                    this.f43875g = i11;
                }

                /* renamed from: a */
                public final String invoke() {
                    return Intrinsics.stringPlus("Location Services error: ", Integer.valueOf(this.f43875g));
                }
            }

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: com.braze.receivers.BrazeActionReceiver$a$a$b */
            public static final class b extends Lambda implements Function0<String> {

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f43876g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public b(int i11) {
                    super(0);
                    this.f43876g = i11;
                }

                /* renamed from: a */
                public final String invoke() {
                    return Intrinsics.stringPlus("Unsupported transition type received: ", Integer.valueOf(this.f43876g));
                }
            }

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: com.braze.receivers.BrazeActionReceiver$a$a$c */
            public static final class c extends Lambda implements Function0<String> {

                /* renamed from: b  reason: collision with root package name */
                public static final c f43877b = new c();

                public c() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Exception while processing location result";
                }
            }

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: com.braze.receivers.BrazeActionReceiver$a$a$d */
            public static final class d extends Lambda implements Function0<String> {

                /* renamed from: b  reason: collision with root package name */
                public static final d f43878b = new d();

                public d() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Exception while processing single location update";
                }
            }

            private C0042a() {
            }

            public /* synthetic */ C0042a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* access modifiers changed from: private */
            public final boolean a(Context context, Location location) {
                try {
                    BrazeInternal.logLocationRecordedEvent(context, new n(location));
                    return true;
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f43878b, 4, (Object) null);
                    return false;
                }
            }

            public final boolean a(Context context, LocationResult locationResult) {
                Intrinsics.checkNotNullParameter(context, "applicationContext");
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                try {
                    Location lastLocation = locationResult.getLastLocation();
                    Intrinsics.checkNotNullExpressionValue(lastLocation, "locationResult.lastLocation");
                    BrazeInternal.requestGeofenceRefresh(context, (a2) new n(lastLocation));
                    return true;
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f43877b, 4, (Object) null);
                    return false;
                }
            }

            public final boolean a(Context context, GeofencingEvent geofencingEvent) {
                Intrinsics.checkNotNullParameter(context, "applicationContext");
                Intrinsics.checkNotNullParameter(geofencingEvent, "geofenceEvent");
                if (geofencingEvent.hasError()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new C0043a(geofencingEvent.getErrorCode()), 6, (Object) null);
                    return false;
                }
                int geofenceTransition = geofencingEvent.getGeofenceTransition();
                List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
                Intrinsics.checkNotNullExpressionValue(triggeringGeofences, "geofenceEvent.triggeringGeofences");
                if (1 == geofenceTransition) {
                    for (Geofence requestId : triggeringGeofences) {
                        String requestId2 = requestId.getRequestId();
                        Intrinsics.checkNotNullExpressionValue(requestId2, "geofence.requestId");
                        BrazeInternal.recordGeofenceTransition(context, requestId2, o1.ENTER);
                    }
                } else if (2 == geofenceTransition) {
                    for (Geofence requestId3 : triggeringGeofences) {
                        String requestId4 = requestId3.getRequestId();
                        Intrinsics.checkNotNullExpressionValue(requestId4, "geofence.requestId");
                        BrazeInternal.recordGeofenceTransition(context, requestId4, o1.EXIT);
                    }
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(geofenceTransition), 6, (Object) null);
                    return false;
                }
                return true;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43879g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar) {
                super(0);
                this.f43879g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Received intent with action ", this.f43879g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f43880b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received intent with null action. Doing nothing.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43881g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(a aVar) {
                super(0);
                this.f43881g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActionReceiver received intent with location result: ", this.f43881g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43882g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(a aVar) {
                super(0);
                this.f43882g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActionReceiver received intent without location result: ", this.f43882g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43883g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(a aVar) {
                super(0);
                this.f43883g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActionReceiver received intent with geofence transition: ", this.f43883g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43884g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(a aVar) {
                super(0);
                this.f43884g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActionReceiver received intent with single location update: ", this.f43884g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43885g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(a aVar) {
                super(0);
                this.f43885g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Unknown intent received in BrazeActionReceiver with action: ", this.f43885g.f43874c);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f43886g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(a aVar) {
                super(0);
                this.f43886g = aVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception while performing the BrazeActionReceiver work. Action: " + this.f43886g.f43874c + " Intent: " + this.f43886g.f43873b;
            }
        }

        public a(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            this.f43872a = context;
            this.f43873b = intent;
            this.f43874c = intent.getAction();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: android.location.Location} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a() {
            /*
                r10 = this;
                com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.receivers.BrazeActionReceiver$a$b r5 = new com.braze.receivers.BrazeActionReceiver$a$b
                r5.<init>(r10)
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 7
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                java.lang.String r0 = r10.f43874c
                r9 = 0
                if (r0 == 0) goto L_0x0101
                int r1 = r0.hashCode()
                r2 = -1382373484(0xffffffffad9aa794, float:-1.7582193E-11)
                if (r1 == r2) goto L_0x00ac
                r2 = 94647129(0x5a43359, float:1.5441348E-35)
                if (r1 == r2) goto L_0x0059
                r2 = 1794335912(0x6af364a8, float:1.47122155E26)
                if (r1 == r2) goto L_0x002b
                goto L_0x00b4
            L_0x002b:
                java.lang.String r1 = "com.appboy.action.receiver.BRAZE_GEOFENCE_UPDATE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0035
                goto L_0x00b4
            L_0x0035:
                com.braze.receivers.BrazeActionReceiver$a$f r5 = new com.braze.receivers.BrazeActionReceiver$a$f
                r5.<init>(r10)
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 7
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                com.braze.receivers.BrazeActionReceiver$a$a r0 = f43871d
                android.content.Context r1 = r10.f43872a
                android.content.Intent r2 = r10.f43873b
                com.google.android.gms.location.GeofencingEvent r2 = com.google.android.gms.location.GeofencingEvent.fromIntent(r2)
                java.lang.String r3 = "fromIntent(intent)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                boolean r9 = r0.a((android.content.Context) r1, (com.google.android.gms.location.GeofencingEvent) r2)
                goto L_0x010d
            L_0x0059:
                java.lang.String r1 = "com.appboy.action.receiver.SINGLE_LOCATION_UPDATE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0062
                goto L_0x00b4
            L_0x0062:
                com.braze.receivers.BrazeActionReceiver$a$g r5 = new com.braze.receivers.BrazeActionReceiver$a$g
                r5.<init>(r10)
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 7
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 33
                java.lang.String r3 = "location"
                if (r0 < r1) goto L_0x008c
                android.content.Intent r0 = r10.f43873b
                android.os.Bundle r0 = r0.getExtras()
                if (r0 != 0) goto L_0x0082
                goto L_0x009b
            L_0x0082:
                java.lang.Class<android.location.Location> r1 = android.location.Location.class
                java.lang.Object r0 = r0.getParcelable(r3, r1)
                r2 = r0
                android.location.Location r2 = (android.location.Location) r2
                goto L_0x009b
            L_0x008c:
                android.content.Intent r0 = r10.f43873b
                android.os.Bundle r0 = r0.getExtras()
                if (r0 != 0) goto L_0x0095
                goto L_0x0099
            L_0x0095:
                java.lang.Object r2 = r0.get(r3)
            L_0x0099:
                android.location.Location r2 = (android.location.Location) r2
            L_0x009b:
                if (r2 != 0) goto L_0x009f
                goto L_0x010d
            L_0x009f:
                com.braze.receivers.BrazeActionReceiver$a$a r0 = f43871d
                android.content.Context r1 = r10.f43872a
                boolean r0 = r0.a((android.content.Context) r1, (android.location.Location) r2)
                r1 = 1
                if (r0 != r1) goto L_0x010d
                r9 = r1
                goto L_0x010d
            L_0x00ac:
                java.lang.String r1 = "com.appboy.action.receiver.BRAZE_GEOFENCE_LOCATION_UPDATE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x00c5
            L_0x00b4:
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
                com.braze.receivers.BrazeActionReceiver$a$h r5 = new com.braze.receivers.BrazeActionReceiver$a$h
                r5.<init>(r10)
                r3 = 0
                r4 = 0
                r6 = 6
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                goto L_0x010d
            L_0x00c5:
                android.content.Intent r0 = r10.f43873b
                boolean r0 = com.google.android.gms.location.LocationResult.hasResult(r0)
                if (r0 == 0) goto L_0x00f0
                com.braze.receivers.BrazeActionReceiver$a$d r5 = new com.braze.receivers.BrazeActionReceiver$a$d
                r5.<init>(r10)
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 7
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                com.braze.receivers.BrazeActionReceiver$a$a r0 = f43871d
                android.content.Context r1 = r10.f43872a
                android.content.Intent r2 = r10.f43873b
                com.google.android.gms.location.LocationResult r2 = com.google.android.gms.location.LocationResult.extractResult(r2)
                java.lang.String r3 = "extractResult(intent)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                boolean r9 = r0.a((android.content.Context) r1, (com.google.android.gms.location.LocationResult) r2)
                goto L_0x0100
            L_0x00f0:
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
                com.braze.receivers.BrazeActionReceiver$a$e r5 = new com.braze.receivers.BrazeActionReceiver$a$e
                r5.<init>(r10)
                r3 = 0
                r4 = 0
                r6 = 6
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            L_0x0100:
                return r9
            L_0x0101:
                com.braze.receivers.BrazeActionReceiver$a$c r5 = com.braze.receivers.BrazeActionReceiver.a.c.f43880b
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 7
                r7 = 0
                r0 = r8
                r1 = r10
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            L_0x010d:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.receivers.BrazeActionReceiver.a.a():boolean");
        }

        public final void b() {
            try {
                a();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new i(this), 4, (Object) null);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43887b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "BrazeActionReceiver received null intent. Doing nothing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f43888b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "BrazeActionReceiver received null context. Doing nothing.";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.receivers.BrazeActionReceiver$onReceive$3", f = "BrazeActionReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43889h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f43890i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f43891j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, BroadcastReceiver.PendingResult pendingResult, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f43890i = aVar;
            this.f43891j = pendingResult;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.f43890i, this.f43891j, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43889h == 0) {
                ResultKt.throwOnFailure(obj);
                this.f43890i.b();
                this.f43891j.finish();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43887b, 6, (Object) null);
        } else if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f43888b, 6, (Object) null);
        } else {
            Context applicationContext = context.getApplicationContext();
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new d(new a(applicationContext, intent), goAsync, (Continuation<? super d>) null), 2, (Object) null);
        }
    }
}
