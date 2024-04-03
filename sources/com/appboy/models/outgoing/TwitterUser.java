package com.appboy.models.outgoing;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014BU\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/appboy/models/outgoing/TwitterUser;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "forJsonPut", "", "twitterUserId", "I", "", "twitterHandle", "Ljava/lang/String;", "name", "description", "followers", "Ljava/lang/Integer;", "following", "tweets", "profileImageUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class TwitterUser implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String DESCRIPTION_KEY = "description";
    private static final String FOLLOWERS_COUNT_KEY = "followers_count";
    private static final String FOLLOWING_COUNT_KEY = "friends_count";
    private static final String HANDLE_KEY = "screen_name";
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String PROFILE_IMAGE_URL_KEY = "profile_image_url";
    private static final String STATUS_UPDATES_COUNT_KEY = "statuses_count";
    private final String description;
    private final Integer followers;
    private final Integer following;

    /* renamed from: name  reason: collision with root package name */
    private final String f40747name;
    private final String profileImageUrl;
    private final Integer tweets;
    private final String twitterHandle;
    private final int twitterUserId;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/appboy/models/outgoing/TwitterUser$a;", "", "", "DESCRIPTION_KEY", "Ljava/lang/String;", "FOLLOWERS_COUNT_KEY", "FOLLOWING_COUNT_KEY", "HANDLE_KEY", "ID_KEY", "NAME_KEY", "PROFILE_IMAGE_URL_KEY", "STATUS_UPDATES_COUNT_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f40748b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating twitter user Json.";
        }
    }

    public TwitterUser(int i11, String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4) {
        this.twitterUserId = i11;
        this.twitterHandle = str;
        this.f40747name = str2;
        this.description = str3;
        this.followers = num;
        this.following = num2;
        this.tweets = num3;
        this.profileImageUrl = str4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A[Catch:{ JSONException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022 A[Catch:{ JSONException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[Catch:{ JSONException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[Catch:{ JSONException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0045 A[Catch:{ JSONException -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0059 A[Catch:{ JSONException -> 0x007d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r10.twitterHandle     // Catch:{ JSONException -> 0x007d }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0014
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r1 = r2
            goto L_0x0015
        L_0x0014:
            r1 = r3
        L_0x0015:
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = "screen_name"
            java.lang.String r4 = r10.twitterHandle     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x007d }
        L_0x001e:
            java.lang.String r1 = r10.f40747name     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x002b
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r1 = r2
            goto L_0x002c
        L_0x002b:
            r1 = r3
        L_0x002c:
            if (r1 != 0) goto L_0x0035
            java.lang.String r1 = "name"
            java.lang.String r4 = r10.f40747name     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x007d }
        L_0x0035:
            java.lang.String r1 = r10.description     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0042
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r1 = r2
            goto L_0x0043
        L_0x0042:
            r1 = r3
        L_0x0043:
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "description"
            java.lang.String r4 = r10.description     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x007d }
        L_0x004c:
            java.lang.String r1 = r10.profileImageUrl     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0056
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x007d }
            if (r1 == 0) goto L_0x0057
        L_0x0056:
            r2 = r3
        L_0x0057:
            if (r2 != 0) goto L_0x0060
            java.lang.String r1 = "profile_image_url"
            java.lang.String r2 = r10.profileImageUrl     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x007d }
        L_0x0060:
            java.lang.String r1 = "id"
            int r2 = r10.twitterUserId     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (int) r2)     // Catch:{ JSONException -> 0x007d }
            java.lang.String r1 = "followers_count"
            java.lang.Integer r2 = r10.followers     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x007d }
            java.lang.String r1 = "friends_count"
            java.lang.Integer r2 = r10.following     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x007d }
            java.lang.String r1 = "statuses_count"
            java.lang.Integer r2 = r10.tweets     // Catch:{ JSONException -> 0x007d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x007d }
            goto L_0x008c
        L_0x007d:
            r1 = move-exception
            r5 = r1
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            com.appboy.models.outgoing.TwitterUser$b r7 = com.appboy.models.outgoing.TwitterUser.b.f40748b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appboy.models.outgoing.TwitterUser.forJsonPut():org.json.JSONObject");
    }
}
