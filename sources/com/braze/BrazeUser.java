package com.braze;

import bo.app.b2;
import bo.app.e5;
import bo.app.l2;
import bo.app.t5;
import bo.app.t6;
import bo.app.x1;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.enums.NotificationSubscriptionType;
import com.appboy.models.outgoing.AttributionData;
import com.appboy.models.outgoing.FacebookUser;
import com.appboy.models.outgoing.TwitterUser;
import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.ValidationUtils;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010L\u001a\u00020\u0002\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\b^\u0010_J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0002J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0010J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020)J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020*J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020+J\u0016\u0010,\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J\u0016\u0010-\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002J%\u00100\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020.¢\u0006\u0004\b0\u00101J\u000e\u00102\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002J\u0016\u00104\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u00103\u001a\u00020*J\u001a\u00106\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u0010H\u0007J\u000e\u00107\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002J\u0010\u0010:\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u000108J\u0010\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010;J\u0010\u0010@\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010>J5\u0010F\u001a\u00020E2\u0006\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020+2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+¢\u0006\u0004\bF\u0010GJ\u001e\u0010H\u001a\u00020E2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020+J\u000e\u0010I\u001a\u00020E2\u0006\u0010&\u001a\u00020\u0002J\u0016\u0010J\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0001J\u0016\u0010K\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u00103\u001a\u00020*R\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR$\u0010Q\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00028F@FX\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006`"}, d2 = {"Lcom/braze/BrazeUser;", "", "", "alias", "label", "", "addAlias", "firstName", "setFirstName", "lastName", "setLastName", "email", "setEmail", "Lcom/appboy/enums/Gender;", "gender", "setGender", "", "year", "Lcom/appboy/enums/Month;", "month", "day", "setDateOfBirth", "country", "setCountry", "homeCity", "setHomeCity", "language", "setLanguage", "Lcom/appboy/enums/NotificationSubscriptionType;", "emailNotificationSubscriptionType", "setEmailNotificationSubscriptionType", "pushNotificationSubscriptionType", "setPushNotificationSubscriptionType", "subscriptionGroupId", "addToSubscriptionGroup", "removeFromSubscriptionGroup", "phoneNumber", "setPhoneNumber", "key", "value", "setCustomUserAttribute", "", "", "", "addToCustomAttributeArray", "removeFromCustomAttributeArray", "", "values", "setCustomAttributeArray", "(Ljava/lang/String;[Ljava/lang/String;)Z", "setCustomUserAttributeToNow", "secondsFromEpoch", "setCustomUserAttributeToSecondsFromEpoch", "incrementValue", "incrementCustomUserAttribute", "unsetCustomUserAttribute", "Lcom/appboy/models/outgoing/FacebookUser;", "facebookUserData", "setFacebookData", "Lcom/appboy/models/outgoing/TwitterUser;", "twitterUserData", "setTwitterData", "Lcom/appboy/models/outgoing/AttributionData;", "attributionData", "setAttributionData", "latitude", "longitude", "altitude", "accuracy", "", "setLastKnownLocation", "(DDLjava/lang/Double;Ljava/lang/Double;)V", "setLocationCustomAttribute", "unsetLocationCustomAttribute", "setCustomAttribute", "setCustomAttributeToSecondsFromEpoch", "internalUserId", "Ljava/lang/String;", "Ljava/util/concurrent/locks/ReentrantLock;", "userIdLock", "Ljava/util/concurrent/locks/ReentrantLock;", "userId", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "Lbo/app/t6;", "userCache", "Lbo/app/b2;", "brazeManager", "Lbo/app/l2;", "locationManager", "Lbo/app/e5;", "serverConfigStorageProvider", "<init>", "(Lbo/app/t6;Lbo/app/b2;Ljava/lang/String;Lbo/app/l2;Lbo/app/e5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeUser {
    private final b2 brazeManager;
    private volatile String internalUserId;
    private final l2 locationManager;
    private final e5 serverConfigStorageProvider;
    private final t6 userCache;
    private final ReentrantLock userIdLock = new ReentrantLock();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43544b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid alias parameter: alias is required to be non-null and non-empty. Not adding alias.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43545g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f43546h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(String str, long j11) {
            super(0);
            this.f43545g = str;
            this.f43546h = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute " + this.f43545g + " to " + this.f43546h + " seconds from epoch.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43547g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a1(String str) {
            super(0);
            this.f43547g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unset custom attribute " + this.f43547g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43548b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid label parameter: label is required to be non-null and non-empty. Not adding alias.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43549g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Month f43550h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43551i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(int i11, Month month, int i12) {
            super(0);
            this.f43549g = i11;
            this.f43550h = month;
            this.f43551i = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set date of birth to: " + this.f43549g + SignatureVisitor.SUPER + this.f43550h.getValue() + SignatureVisitor.SUPER + this.f43551i;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b1 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b1 f43552b = new b1();

        public b1() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom location attribute key was invalid. Not setting attribute.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43553g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f43553g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set alias: ", this.f43553g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c0 f43554b = new c0();

        public c0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid email parameter: email is required to be non-empty. Not setting email.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43555g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c1(String str) {
            super(0);
            this.f43555g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unset custom location attribute with key '" + this.f43555g + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43556b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key was invalid. Not adding to attribute array.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43557g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(String str) {
            super(0);
            this.f43557g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Email address is not valid: ", this.f43557g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d1 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43558g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d1(String str) {
            super(0);
            this.f43558g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("User object user id set to: ", this.f43558g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43559g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f43559g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add custom attribute with key '" + this.f43559g + "'.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43560g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(String str) {
            super(0);
            this.f43560g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set email to: ", this.f43560g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43561b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not adding user to subscription group.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NotificationSubscriptionType f43562g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(NotificationSubscriptionType notificationSubscriptionType) {
            super(0);
            this.f43562g = notificationSubscriptionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set email notification subscription to: ", this.f43562g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43563g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f43563g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to add user to subscription group ", this.f43563g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g0 f43564b = new g0();

        public g0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set Facebook user data.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43565g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43566h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, int i11) {
            super(0);
            this.f43565g = str;
            this.f43566h = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to increment custom attribute " + this.f43565g + " by " + this.f43566h + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h0 f43567b = new h0();

        public h0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid first name parameter: first name is required to be non-empty. Not setting first name.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43568b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key was invalid. Not removing from attribute array.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43569g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(String str) {
            super(0);
            this.f43569g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set first name to: ", this.f43569g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43570g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(0);
            this.f43570g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to remove custom attribute with key '" + this.f43570g + "'.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Gender f43571g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(Gender gender) {
            super(0);
            this.f43571g = gender;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set gender to: ", this.f43571g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43572b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not removing user from subscription group.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k0 f43573b = new k0();

        public k0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid home city parameter: home city is required to be non-blank. Not setting home city.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43574g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(0);
            this.f43574g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to remove user from subscription group ", this.f43574g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43575g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l0(String str) {
            super(0);
            this.f43575g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set home city to: ", this.f43575g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f43576b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set attribution data.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m0 f43577b = new m0();

        public m0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid language parameter: language is required to be non-empty. Not setting language.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f43578b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid country parameter: country is required to be non-blank. Not setting country.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43579g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(String str) {
            super(0);
            this.f43579g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set language to: ", this.f43579g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43580g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str) {
            super(0);
            this.f43580g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set country to: ", this.f43580g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o0 f43581b = new o0();

        public o0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to manually set location.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f43582b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p0 f43583b = new p0();

        public p0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid last name parameter: last name is required to be non-empty. Not setting last name.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f43584g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(Object obj) {
            super(0);
            this.f43584g = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error parsing date ", this.f43584g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43585g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(String str) {
            super(0);
            this.f43585g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set last name to: ", this.f43585g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43586g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f43587h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(String str, Object obj) {
            super(0);
            this.f43586g = str;
            this.f43587h = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not add unsupported custom attribute type with key: " + this.f43586g + " and value: " + this.f43587h;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r0 f43588b = new r0();

        public r0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom location attribute key was invalid. Not setting attribute.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43589g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(String str) {
            super(0);
            this.f43589g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute array with key: '" + this.f43589g + "'.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f43590g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f43591h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(double d11, double d12) {
            super(0);
            this.f43590g = d11;
            this.f43591h = d12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot set custom location attribute due with invalid latitude '" + this.f43590g + " and longitude '" + this.f43591h + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43592g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(String str) {
            super(0);
            this.f43592g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom boolean attribute " + this.f43592g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43593g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f43594h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ double f43595i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(String str, double d11, double d12) {
            super(0);
            this.f43593g = str;
            this.f43594h = d11;
            this.f43595i = d12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom location attribute with key '" + this.f43593g + "' and latitude '" + this.f43594h + "' and longitude '" + this.f43595i + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43596g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(String str) {
            super(0);
            this.f43596g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom integer attribute " + this.f43596g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final u0 f43597b = new u0();

        public u0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invalid phone number parameter: phone number is required to be non-empty. Not setting phone number.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43598g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(String str) {
            super(0);
            this.f43598g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom float attribute " + this.f43598g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43599g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(String str) {
            super(0);
            this.f43599g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Phone number contains invalid characters (allowed are digits, spaces, or any of the following +.-()): ", this.f43599g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43600g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(String str) {
            super(0);
            this.f43600g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom long attribute " + this.f43600g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43601g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(String str) {
            super(0);
            this.f43601g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set phone number to: ", this.f43601g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43602g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(String str) {
            super(0);
            this.f43602g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom string attribute " + this.f43602g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x0 extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NotificationSubscriptionType f43603g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x0(NotificationSubscriptionType notificationSubscriptionType) {
            super(0);
            this.f43603g = notificationSubscriptionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to set push notification subscription to: ", this.f43603g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43604g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(String str) {
            super(0);
            this.f43604g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom double attribute " + this.f43604g + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final y0 f43605b = new y0();

        public y0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set Twitter user data.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43606g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(String str) {
            super(0);
            this.f43606g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set custom attribute " + this.f43606g + " to now.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final z0 f43607b = new z0();

        public z0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    public BrazeUser(t6 t6Var, b2 b2Var, String str, l2 l2Var, e5 e5Var) {
        Intrinsics.checkNotNullParameter(t6Var, "userCache");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(str, "internalUserId");
        Intrinsics.checkNotNullParameter(l2Var, "locationManager");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        this.userCache = t6Var;
        this.brazeManager = b2Var;
        this.internalUserId = str;
        this.locationManager = l2Var;
        this.serverConfigStorageProvider = e5Var;
    }

    public static /* synthetic */ boolean incrementCustomUserAttribute$default(BrazeUser brazeUser, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        return brazeUser.incrementCustomUserAttribute(str, i11);
    }

    public static /* synthetic */ void setLastKnownLocation$default(BrazeUser brazeUser, double d11, double d12, Double d13, Double d14, int i11, Object obj) {
        brazeUser.setLastKnownLocation(d11, d12, (i11 & 4) != 0 ? null : d13, (i11 & 8) != 0 ? null : d14);
    }

    public final boolean addAlias(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "alias");
        Intrinsics.checkNotNullParameter(str2, "label");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f43544b, 6, (Object) null);
            return false;
        } else if (StringsKt__StringsJVMKt.isBlank(str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43548b, 6, (Object) null);
            return false;
        } else {
            try {
                x1 g11 = bo.app.j.f38653h.g(str, str2);
                if (g11 == null) {
                    return false;
                }
                return this.brazeManager.a(g11);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new c(str), 4, (Object) null);
                return false;
            }
        }
    }

    public final boolean addToCustomAttributeArray(String str, String str2) {
        x1 a11;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            if (!bo.app.c0.a(str, this.serverConfigStorageProvider.b())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f43556b, 6, (Object) null);
                return false;
            } else if (bo.app.c0.a(str2) && (a11 = bo.app.j.f38653h.a(ValidationUtils.ensureBrazeFieldLength(str), ValidationUtils.ensureBrazeFieldLength(str2))) != null) {
                return this.brazeManager.a(a11);
            } else {
                return false;
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new e(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean addToSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        try {
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) f.f43561b, 6, (Object) null);
                return false;
            }
            x1 a11 = bo.app.j.f38653h.a(str, t5.SUBSCRIBED);
            if (a11 == null) {
                return true;
            }
            this.brazeManager.a(a11);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new g(str), 4, (Object) null);
            return false;
        }
    }

    public final String getUserId() {
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            return this.internalUserId;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean incrementCustomUserAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return incrementCustomUserAttribute$default(this, str, 0, 2, (Object) null);
    }

    public final boolean incrementCustomUserAttribute(String str, int i11) {
        x1 a11;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (bo.app.c0.a(str, this.serverConfigStorageProvider.b()) && (a11 = bo.app.j.f38653h.a(ValidationUtils.ensureBrazeFieldLength(str), i11)) != null) {
                return this.brazeManager.a(a11);
            }
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new h(str, i11), 4, (Object) null);
            return false;
        }
    }

    public final boolean removeFromCustomAttributeArray(String str, String str2) {
        x1 f11;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            if (!bo.app.c0.a(str, this.serverConfigStorageProvider.b())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) i.f43568b, 6, (Object) null);
                return false;
            } else if (bo.app.c0.a(str2) && (f11 = bo.app.j.f38653h.f(ValidationUtils.ensureBrazeFieldLength(str), ValidationUtils.ensureBrazeFieldLength(str2))) != null) {
                return this.brazeManager.a(f11);
            } else {
                return false;
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new j(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean removeFromSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        try {
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) k.f43572b, 6, (Object) null);
                return false;
            }
            x1 a11 = bo.app.j.f38653h.a(str, t5.UNSUBSCRIBED);
            if (a11 == null) {
                return true;
            }
            this.brazeManager.a(a11);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new l(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setAttributionData(AttributionData attributionData) {
        try {
            this.userCache.a(attributionData);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) m.f43576b, 4, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0025 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setCountry(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0025 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0025 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0025 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$n r8 = com.braze.BrazeUser.n.f43578b     // Catch:{ Exception -> 0x0025 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x001f:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0025 }
            r2.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$o r7 = new com.braze.BrazeUser$o
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setCountry(java.lang.String):boolean");
    }

    public final boolean setCustomAttribute(String str, Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        if (!bo.app.c0.a(str, this.serverConfigStorageProvider.b())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) p.f43582b, 6, (Object) null);
            return false;
        }
        String ensureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength(str);
        boolean z14 = true;
        if (obj instanceof Boolean) {
            z11 = true;
        } else {
            z11 = obj instanceof Integer;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = obj instanceof Float;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = obj instanceof Long;
        }
        if (!z13) {
            z14 = obj instanceof Double;
        }
        if (z14) {
            return this.userCache.a(ensureBrazeFieldLength, obj);
        }
        if (obj instanceof String) {
            return this.userCache.a(ensureBrazeFieldLength, (Object) ValidationUtils.ensureBrazeFieldLength((String) obj));
        } else if (obj instanceof Date) {
            try {
                return this.userCache.a(ensureBrazeFieldLength, (Object) DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null));
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new q(obj), 4, (Object) null);
                return false;
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new r(str, obj), 6, (Object) null);
            return false;
        }
    }

    public final boolean setCustomAttributeArray(String str, String[] strArr) {
        x1 a11;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(strArr, "values");
        try {
            if (bo.app.c0.a(str, this.serverConfigStorageProvider.b()) && (a11 = bo.app.j.f38653h.a(ValidationUtils.ensureBrazeFieldLength(str), bo.app.c0.a(strArr))) != null) {
                return this.brazeManager.a(a11);
            }
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new s(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomAttributeToSecondsFromEpoch(String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        return setCustomAttribute(str, DateTimeUtils.createDate(j11));
    }

    public final boolean setCustomUserAttribute(String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute(str, Boolean.valueOf(z11));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new t(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttributeToNow(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(str, DateTimeUtils.nowInSeconds());
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new z(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttributeToSecondsFromEpoch(String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttributeToSecondsFromEpoch(str, j11);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new a0(str, j11), 4, (Object) null);
            return false;
        }
    }

    public final boolean setDateOfBirth(int i11, Month month, int i12) {
        Intrinsics.checkNotNullParameter(month, "month");
        try {
            return this.userCache.b(DateTimeUtils.formatDate$default(DateTimeUtils.createDate$default(i11, month.getValue(), i12, 0, 0, 0, 56, (Object) null), BrazeDateFormat.SHORT, (TimeZone) null, 2, (Object) null));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new b0(i11, month, i12), 4, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0079 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setEmail(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0079 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0079 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0079 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$c0 r8 = com.braze.BrazeUser.c0.f43554b     // Catch:{ Exception -> 0x0079 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0079 }
            return r1
        L_0x001f:
            if (r12 != 0) goto L_0x0023
            r0 = 0
            goto L_0x0058
        L_0x0023:
            int r2 = r12.length()     // Catch:{ Exception -> 0x0079 }
            int r2 = r2 - r0
            r3 = r1
            r4 = r3
        L_0x002a:
            if (r3 > r2) goto L_0x004f
            if (r4 != 0) goto L_0x0030
            r5 = r3
            goto L_0x0031
        L_0x0030:
            r5 = r2
        L_0x0031:
            char r5 = r12.charAt(r5)     // Catch:{ Exception -> 0x0079 }
            r6 = 32
            int r5 = kotlin.jvm.internal.Intrinsics.compare((int) r5, (int) r6)     // Catch:{ Exception -> 0x0079 }
            if (r5 > 0) goto L_0x003f
            r5 = r0
            goto L_0x0040
        L_0x003f:
            r5 = r1
        L_0x0040:
            if (r4 != 0) goto L_0x0049
            if (r5 != 0) goto L_0x0046
            r4 = r0
            goto L_0x002a
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0049:
            if (r5 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            int r2 = r2 + -1
            goto L_0x002a
        L_0x004f:
            int r2 = r2 + r0
            java.lang.CharSequence r0 = r12.subSequence(r3, r2)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0079 }
        L_0x0058:
            if (r0 == 0) goto L_0x0072
            boolean r2 = com.braze.support.ValidationUtils.isValidEmailAddress(r0)     // Catch:{ Exception -> 0x0079 }
            if (r2 == 0) goto L_0x0061
            goto L_0x0072
        L_0x0061:
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0079 }
            r5 = 0
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$d0 r8 = new com.braze.BrazeUser$d0     // Catch:{ Exception -> 0x0079 }
            r8.<init>(r12)     // Catch:{ Exception -> 0x0079 }
            r9 = 7
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0078
        L_0x0072:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0079 }
            boolean r1 = r2.c(r0)     // Catch:{ Exception -> 0x0079 }
        L_0x0078:
            return r1
        L_0x0079:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$e0 r7 = new com.braze.BrazeUser$e0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setEmail(java.lang.String):boolean");
    }

    public final boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType notificationSubscriptionType) {
        Intrinsics.checkNotNullParameter(notificationSubscriptionType, "emailNotificationSubscriptionType");
        try {
            this.userCache.a(notificationSubscriptionType);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new f0(notificationSubscriptionType), 4, (Object) null);
            return false;
        }
    }

    public final boolean setFacebookData(FacebookUser facebookUser) {
        try {
            this.userCache.a(facebookUser);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) g0.f43564b, 4, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0025 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setFirstName(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0025 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0025 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0025 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$h0 r8 = com.braze.BrazeUser.h0.f43567b     // Catch:{ Exception -> 0x0025 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x001f:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0025 }
            r2.d(r12)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$i0 r7 = new com.braze.BrazeUser$i0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setFirstName(java.lang.String):boolean");
    }

    public final boolean setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        try {
            this.userCache.a(gender);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new j0(gender), 4, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0025 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setHomeCity(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0025 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0025 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0025 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$k0 r8 = com.braze.BrazeUser.k0.f43573b     // Catch:{ Exception -> 0x0025 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x001f:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0025 }
            r2.e(r12)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$l0 r7 = new com.braze.BrazeUser$l0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setHomeCity(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0025 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setLanguage(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0025 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0025 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0025 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$m0 r8 = com.braze.BrazeUser.m0.f43577b     // Catch:{ Exception -> 0x0025 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x001f:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0025 }
            r2.f(r12)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$n0 r7 = new com.braze.BrazeUser$n0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setLanguage(java.lang.String):boolean");
    }

    public final void setLastKnownLocation(double d11, double d12, Double d13, Double d14) {
        try {
            this.locationManager.a(new bo.app.n(d11, d12, d13, d14));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) o0.f43581b, 4, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0025 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setLastName(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x0025 }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0025 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0025 }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$p0 r8 = com.braze.BrazeUser.p0.f43583b     // Catch:{ Exception -> 0x0025 }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x001f:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x0025 }
            r2.g(r12)     // Catch:{ Exception -> 0x0025 }
            return r0
        L_0x0025:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$q0 r7 = new com.braze.BrazeUser$q0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setLastName(java.lang.String):boolean");
    }

    public final void setLocationCustomAttribute(String str, double d11, double d12) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "key");
        try {
            if (!bo.app.c0.a(str2, this.serverConfigStorageProvider.b())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) r0.f43588b, 6, (Object) null);
            } else if (!ValidationUtils.isValidLocation(d11, d12)) {
                try {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new s0(d11, d12), 6, (Object) null);
                } catch (Exception e11) {
                    e = e11;
                    double d13 = d11;
                    double d14 = d12;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e, false, (Function0) new t0(str, d11, d12), 4, (Object) null);
                }
            } else {
                double d15 = d11;
                double d16 = d12;
                x1 a11 = bo.app.j.f38653h.a(ValidationUtils.ensureBrazeFieldLength(str), d11, d12);
                if (a11 != null) {
                    this.brazeManager.a(a11);
                }
            }
        } catch (Exception e12) {
            e = e12;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e, false, (Function0) new t0(str, d11, d12), 4, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010 A[Catch:{ Exception -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean setPhoneNumber(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0005
            goto L_0x000d
        L_0x0005:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r12)     // Catch:{ Exception -> 0x007a }
            if (r2 != r0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001f
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x007a }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x007a }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$u0 r8 = com.braze.BrazeUser.u0.f43597b     // Catch:{ Exception -> 0x007a }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x007a }
            return r1
        L_0x001f:
            if (r12 != 0) goto L_0x0023
            r0 = 0
            goto L_0x0058
        L_0x0023:
            int r2 = r12.length()     // Catch:{ Exception -> 0x007a }
            int r2 = r2 - r0
            r3 = r1
            r4 = r3
        L_0x002a:
            if (r3 > r2) goto L_0x004f
            if (r4 != 0) goto L_0x0030
            r5 = r3
            goto L_0x0031
        L_0x0030:
            r5 = r2
        L_0x0031:
            char r5 = r12.charAt(r5)     // Catch:{ Exception -> 0x007a }
            r6 = 32
            int r5 = kotlin.jvm.internal.Intrinsics.compare((int) r5, (int) r6)     // Catch:{ Exception -> 0x007a }
            if (r5 > 0) goto L_0x003f
            r5 = r0
            goto L_0x0040
        L_0x003f:
            r5 = r1
        L_0x0040:
            if (r4 != 0) goto L_0x0049
            if (r5 != 0) goto L_0x0046
            r4 = r0
            goto L_0x002a
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0049:
            if (r5 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            int r2 = r2 + -1
            goto L_0x002a
        L_0x004f:
            int r2 = r2 + r0
            java.lang.CharSequence r0 = r12.subSequence(r3, r2)     // Catch:{ Exception -> 0x007a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x007a }
        L_0x0058:
            if (r0 == 0) goto L_0x0073
            boolean r2 = com.braze.support.ValidationUtils.isValidPhoneNumber(r0)     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x0061
            goto L_0x0073
        L_0x0061:
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x007a }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x007a }
            r6 = 0
            r7 = 0
            com.braze.BrazeUser$v0 r8 = new com.braze.BrazeUser$v0     // Catch:{ Exception -> 0x007a }
            r8.<init>(r0)     // Catch:{ Exception -> 0x007a }
            r9 = 6
            r10 = 0
            r4 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x007a }
            return r1
        L_0x0073:
            bo.app.t6 r2 = r11.userCache     // Catch:{ Exception -> 0x007a }
            boolean r12 = r2.h(r0)     // Catch:{ Exception -> 0x007a }
            return r12
        L_0x007a:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            com.braze.BrazeUser$w0 r7 = new com.braze.BrazeUser$w0
            r7.<init>(r12)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.BrazeUser.setPhoneNumber(java.lang.String):boolean");
    }

    public final boolean setPushNotificationSubscriptionType(NotificationSubscriptionType notificationSubscriptionType) {
        Intrinsics.checkNotNullParameter(notificationSubscriptionType, "pushNotificationSubscriptionType");
        try {
            this.userCache.b(notificationSubscriptionType);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new x0(notificationSubscriptionType), 4, (Object) null);
            return false;
        }
    }

    public final boolean setTwitterData(TwitterUser twitterUser) {
        try {
            this.userCache.a(twitterUser);
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) y0.f43605b, 4, (Object) null);
            return false;
        }
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d1(str), 6, (Object) null);
        ReentrantLock reentrantLock = this.userIdLock;
        reentrantLock.lock();
        try {
            if (!Intrinsics.areEqual((Object) this.internalUserId, (Object) "")) {
                if (!Intrinsics.areEqual((Object) this.internalUserId, (Object) str)) {
                    throw new IllegalArgumentException("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [" + this.internalUserId + "], tried to change to: [" + str + AbstractJsonLexerKt.END_LIST);
                }
            }
            this.internalUserId = str;
            this.userCache.i(str);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean unsetCustomUserAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (bo.app.c0.a(str, this.serverConfigStorageProvider.b())) {
                return this.userCache.j(str);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) z0.f43607b, 6, (Object) null);
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new a1(str), 4, (Object) null);
            return false;
        }
    }

    public final void unsetLocationCustomAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            if (!bo.app.c0.a(str, this.serverConfigStorageProvider.b())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b1.f43552b, 6, (Object) null);
                return;
            }
            x1 k11 = bo.app.j.f38653h.k(ValidationUtils.ensureBrazeFieldLength(str));
            if (k11 != null) {
                this.brazeManager.a(k11);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new c1(str), 4, (Object) null);
        }
    }

    public final boolean setCustomUserAttribute(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute(str, Integer.valueOf(i11));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new u(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute(str, Float.valueOf(f11));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new v(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute(str, Long.valueOf(j11));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new w(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        try {
            return setCustomAttribute(str, str2);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new x(str), 4, (Object) null);
            return false;
        }
    }

    public final boolean setCustomUserAttribute(String str, double d11) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return setCustomAttribute(str, Double.valueOf(d11));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new y(str), 4, (Object) null);
            return false;
        }
    }
}
