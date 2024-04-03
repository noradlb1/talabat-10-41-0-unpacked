package com.appboy.models.outgoing;

import com.appboy.enums.Gender;
import com.braze.models.IPutIntoJson;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001c2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001dBo\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/appboy/models/outgoing/FacebookUser;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "forJsonPut", "", "facebookId", "Ljava/lang/String;", "firstName", "lastName", "email", "bio", "cityName", "Lcom/appboy/enums/Gender;", "gender", "Lcom/appboy/enums/Gender;", "", "numberOfFriends", "Ljava/lang/Integer;", "", "likes", "Ljava/util/Collection;", "birthday", "Lorg/json/JSONArray;", "getLikesArray", "()Lorg/json/JSONArray;", "likesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/appboy/enums/Gender;Ljava/lang/Integer;Ljava/util/Collection;Ljava/lang/String;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class FacebookUser implements IPutIntoJson<JSONObject> {
    private static final String BIO_KEY = "bio";
    private static final String BIRTHDAY_KEY = "birthday";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String EMAIL_KEY = "email";
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String FRIENDS_COUNT_KEY = "num_friends";
    private static final String GENDER_KEY = "gender";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LIKES_KEY = "likes";
    private static final String LIKE_INNER_KEY = "name";
    private static final String LOCATION_INNER_KEY = "name";
    private static final String LOCATION_OUTER_OBJECT_KEY = "location";
    private final String bio;
    private final String birthday;
    private final String cityName;
    private final String email;
    private final String facebookId;
    private final String firstName;
    private final Gender gender;
    private final String lastName;
    private final Collection<String> likes;
    private final Integer numberOfFriends;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/appboy/models/outgoing/FacebookUser$a;", "", "", "BIO_KEY", "Ljava/lang/String;", "BIRTHDAY_KEY", "EMAIL_KEY", "FIRST_NAME_KEY", "FRIENDS_COUNT_KEY", "GENDER_KEY", "ID_KEY", "LAST_NAME_KEY", "LIKES_KEY", "LIKE_INNER_KEY", "LOCATION_INNER_KEY", "LOCATION_OUTER_OBJECT_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f40746b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating facebook user Json.";
        }
    }

    public FacebookUser(String str, String str2, String str3, String str4, String str5, String str6, Gender gender2, Integer num, Collection<String> collection, String str7) {
        Intrinsics.checkNotNullParameter(str, "facebookId");
        this.facebookId = str;
        this.firstName = str2;
        this.lastName = str3;
        this.email = str4;
        this.bio = str5;
        this.cityName = str6;
        this.gender = gender2;
        this.numberOfFriends = num;
        this.likes = collection;
        this.birthday = str7;
    }

    private final JSONArray getLikesArray() {
        JSONArray jSONArray = new JSONArray();
        Collection<String> collection = this.likes;
        if (collection != null) {
            for (String put : collection) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", (Object) put);
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006c A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0077 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0083 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008e A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0098 A[Catch:{ JSONException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ad A[Catch:{ JSONException -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r10.facebookId     // Catch:{ JSONException -> 0x00d1 }
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = "id"
            java.lang.String r3 = r10.facebookId     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x00d1 }
        L_0x0016:
            java.lang.String r1 = r10.firstName     // Catch:{ JSONException -> 0x00d1 }
            r3 = 0
            if (r1 == 0) goto L_0x0024
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r1 = r3
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = "first_name"
            java.lang.String r4 = r10.firstName     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x00d1 }
        L_0x002e:
            java.lang.String r1 = r10.lastName     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x003b
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r1 = r3
            goto L_0x003c
        L_0x003b:
            r1 = r2
        L_0x003c:
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = "last_name"
            java.lang.String r4 = r10.lastName     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x00d1 }
        L_0x0045:
            java.lang.String r1 = r10.email     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0052
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r1 = r3
            goto L_0x0053
        L_0x0052:
            r1 = r2
        L_0x0053:
            if (r1 != 0) goto L_0x005c
            java.lang.String r1 = "email"
            java.lang.String r4 = r10.email     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x00d1 }
        L_0x005c:
            java.lang.String r1 = r10.bio     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0069
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r1 = r3
            goto L_0x006a
        L_0x0069:
            r1 = r2
        L_0x006a:
            if (r1 != 0) goto L_0x0073
            java.lang.String r1 = "bio"
            java.lang.String r4 = r10.bio     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x00d1 }
        L_0x0073:
            java.lang.String r1 = r10.birthday     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0080
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r1 = r3
            goto L_0x0081
        L_0x0080:
            r1 = r2
        L_0x0081:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = "birthday"
            java.lang.String r4 = r10.birthday     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x00d1 }
        L_0x008a:
            java.lang.String r1 = r10.cityName     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0096
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r2 = r3
        L_0x0096:
            if (r2 != 0) goto L_0x00a9
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d1 }
            r1.<init>()     // Catch:{ JSONException -> 0x00d1 }
            java.lang.String r2 = "name"
            java.lang.String r3 = r10.cityName     // Catch:{ JSONException -> 0x00d1 }
            r1.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x00d1 }
            java.lang.String r2 = "location"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d1 }
        L_0x00a9:
            com.appboy.enums.Gender r1 = r10.gender     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x00b6
            java.lang.String r2 = "gender"
            java.lang.String r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d1 }
        L_0x00b6:
            java.lang.String r1 = "num_friends"
            java.lang.Integer r2 = r10.numberOfFriends     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d1 }
            java.util.Collection<java.lang.String> r1 = r10.likes     // Catch:{ JSONException -> 0x00d1 }
            if (r1 == 0) goto L_0x00e0
            boolean r1 = r1.isEmpty()     // Catch:{ JSONException -> 0x00d1 }
            if (r1 != 0) goto L_0x00e0
            java.lang.String r1 = "likes"
            org.json.JSONArray r2 = r10.getLikesArray()     // Catch:{ JSONException -> 0x00d1 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d1 }
            goto L_0x00e0
        L_0x00d1:
            r1 = move-exception
            r5 = r1
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            com.appboy.models.outgoing.FacebookUser$b r7 = com.appboy.models.outgoing.FacebookUser.b.f40746b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appboy.models.outgoing.FacebookUser.forJsonPut():org.json.JSONObject");
    }
}
