package io.flutter.plugins.firebase.core;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tekartik.sqflite.Constant;
import com.visa.checkout.Profile;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yz.k;
import yz.l;
import yz.m;
import yz.n;
import yz.o;
import yz.p;

public class GeneratedAndroidFirebaseCore {

    public interface FirebaseAppHostApi {

        /* renamed from: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseAppHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> a() {
                return FirebaseAppHostApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(FirebaseAppHostApi firebaseAppHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    String str = (String) arrayList.get(0);
                    if (str != null) {
                        Boolean bool = (Boolean) arrayList.get(1);
                        if (bool != null) {
                            firebaseAppHostApi.setAutomaticDataCollectionEnabled(str, bool, new Result<Void>(hashMap, reply) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Map f14294a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BasicMessageChannel.Reply f14295b;

                                {
                                    this.f14294a = r1;
                                    this.f14295b = r2;
                                }

                                public void error(Throwable th2) {
                                    this.f14294a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                                    this.f14295b.reply(this.f14294a);
                                }

                                public void success(Void voidR) {
                                    this.f14294a.put("result", (Object) null);
                                    this.f14295b.reply(this.f14294a);
                                }
                            });
                            return;
                        }
                        throw new NullPointerException("enabledArg unexpectedly null.");
                    }
                    throw new NullPointerException("appNameArg unexpectedly null.");
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void c(FirebaseAppHostApi firebaseAppHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    String str = (String) arrayList.get(0);
                    if (str != null) {
                        Boolean bool = (Boolean) arrayList.get(1);
                        if (bool != null) {
                            firebaseAppHostApi.setAutomaticResourceManagementEnabled(str, bool, new Result<Void>(hashMap, reply) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Map f14296a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BasicMessageChannel.Reply f14297b;

                                {
                                    this.f14296a = r1;
                                    this.f14297b = r2;
                                }

                                public void error(Throwable th2) {
                                    this.f14296a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                                    this.f14297b.reply(this.f14296a);
                                }

                                public void success(Void voidR) {
                                    this.f14296a.put("result", (Object) null);
                                    this.f14297b.reply(this.f14296a);
                                }
                            });
                            return;
                        }
                        throw new NullPointerException("enabledArg unexpectedly null.");
                    }
                    throw new NullPointerException("appNameArg unexpectedly null.");
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void d(FirebaseAppHostApi firebaseAppHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    String str = (String) ((ArrayList) obj).get(0);
                    if (str != null) {
                        firebaseAppHostApi.delete(str, new Result<Void>(hashMap, reply) {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Map f14298a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ BasicMessageChannel.Reply f14299b;

                            {
                                this.f14298a = r1;
                                this.f14299b = r2;
                            }

                            public void error(Throwable th2) {
                                this.f14298a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                                this.f14299b.reply(this.f14298a);
                            }

                            public void success(Void voidR) {
                                this.f14298a.put("result", (Object) null);
                                this.f14299b.reply(this.f14298a);
                            }
                        });
                        return;
                    }
                    throw new NullPointerException("appNameArg unexpectedly null.");
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static void e(BinaryMessenger binaryMessenger, FirebaseAppHostApi firebaseAppHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", a());
                if (firebaseAppHostApi != null) {
                    basicMessageChannel.setMessageHandler(new k(firebaseAppHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", a());
                if (firebaseAppHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new l(firebaseAppHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseAppHostApi.delete", a());
                if (firebaseAppHostApi != null) {
                    basicMessageChannel3.setMessageHandler(new m(firebaseAppHostApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void delete(@NonNull String str, Result<Void> result);

        void setAutomaticDataCollectionEnabled(@NonNull String str, @NonNull Boolean bool, Result<Void> result);

        void setAutomaticResourceManagementEnabled(@NonNull String str, @NonNull Boolean bool, Result<Void> result);
    }

    public static class FirebaseAppHostApiCodec extends StandardMessageCodec {
        public static final FirebaseAppHostApiCodec INSTANCE = new FirebaseAppHostApiCodec();

        private FirebaseAppHostApiCodec() {
        }
    }

    public interface FirebaseCoreHostApi {

        /* renamed from: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore$FirebaseCoreHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> a() {
                return FirebaseCoreHostApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    String str = (String) arrayList.get(0);
                    if (str != null) {
                        PigeonFirebaseOptions pigeonFirebaseOptions = (PigeonFirebaseOptions) arrayList.get(1);
                        if (pigeonFirebaseOptions != null) {
                            firebaseCoreHostApi.initializeApp(str, pigeonFirebaseOptions, new Result<PigeonInitializeResponse>(hashMap, reply) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Map f14300a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BasicMessageChannel.Reply f14301b;

                                {
                                    this.f14300a = r1;
                                    this.f14301b = r2;
                                }

                                public void error(Throwable th2) {
                                    this.f14300a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                                    this.f14301b.reply(this.f14300a);
                                }

                                public void success(PigeonInitializeResponse pigeonInitializeResponse) {
                                    this.f14300a.put("result", pigeonInitializeResponse);
                                    this.f14301b.reply(this.f14300a);
                                }
                            });
                            return;
                        }
                        throw new NullPointerException("initializeAppRequestArg unexpectedly null.");
                    }
                    throw new NullPointerException("appNameArg unexpectedly null.");
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void c(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    firebaseCoreHostApi.initializeCore(new Result<List<PigeonInitializeResponse>>(hashMap, reply) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Map f14302a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ BasicMessageChannel.Reply f14303b;

                        {
                            this.f14302a = r1;
                            this.f14303b = r2;
                        }

                        public void error(Throwable th2) {
                            this.f14302a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                            this.f14303b.reply(this.f14302a);
                        }

                        public void success(List<PigeonInitializeResponse> list) {
                            this.f14302a.put("result", list);
                            this.f14303b.reply(this.f14302a);
                        }
                    });
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void d(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    firebaseCoreHostApi.optionsFromResource(new Result<PigeonFirebaseOptions>(hashMap, reply) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Map f14304a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ BasicMessageChannel.Reply f14305b;

                        {
                            this.f14304a = r1;
                            this.f14305b = r2;
                        }

                        public void error(Throwable th2) {
                            this.f14304a.put("error", GeneratedAndroidFirebaseCore.wrapError(th2));
                            this.f14305b.reply(this.f14304a);
                        }

                        public void success(PigeonFirebaseOptions pigeonFirebaseOptions) {
                            this.f14304a.put("result", pigeonFirebaseOptions);
                            this.f14305b.reply(this.f14304a);
                        }
                    });
                } catch (Error | RuntimeException e11) {
                    hashMap.put("error", GeneratedAndroidFirebaseCore.wrapError(e11));
                    reply.reply(hashMap);
                }
            }

            public static void e(BinaryMessenger binaryMessenger, FirebaseCoreHostApi firebaseCoreHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeApp", a());
                if (firebaseCoreHostApi != null) {
                    basicMessageChannel.setMessageHandler(new n(firebaseCoreHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeCore", a());
                if (firebaseCoreHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new o(firebaseCoreHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.FirebaseCoreHostApi.optionsFromResource", a());
                if (firebaseCoreHostApi != null) {
                    basicMessageChannel3.setMessageHandler(new p(firebaseCoreHostApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void initializeApp(@NonNull String str, @NonNull PigeonFirebaseOptions pigeonFirebaseOptions, Result<PigeonInitializeResponse> result);

        void initializeCore(Result<List<PigeonInitializeResponse>> result);

        void optionsFromResource(Result<PigeonFirebaseOptions> result);
    }

    public static class FirebaseCoreHostApiCodec extends StandardMessageCodec {
        public static final FirebaseCoreHostApiCodec INSTANCE = new FirebaseCoreHostApiCodec();

        private FirebaseCoreHostApiCodec() {
        }

        public Object e(byte b11, ByteBuffer byteBuffer) {
            if (b11 == Byte.MIN_VALUE) {
                return PigeonFirebaseOptions.a((Map) d(byteBuffer));
            }
            if (b11 != -127) {
                return super.e(b11, byteBuffer);
            }
            return PigeonInitializeResponse.a((Map) d(byteBuffer));
        }

        public void n(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof PigeonFirebaseOptions) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((PigeonFirebaseOptions) obj).b());
            } else if (obj instanceof PigeonInitializeResponse) {
                byteArrayOutputStream.write(129);
                n(byteArrayOutputStream, ((PigeonInitializeResponse) obj).b());
            } else {
                super.n(byteArrayOutputStream, obj);
            }
        }
    }

    public static class PigeonFirebaseOptions {
        @Nullable
        private String androidClientId;
        @NonNull
        private String apiKey;
        @Nullable
        private String appGroupId;
        @NonNull
        private String appId;
        @Nullable
        private String authDomain;
        @Nullable
        private String databaseURL;
        @Nullable
        private String deepLinkURLScheme;
        @Nullable
        private String iosBundleId;
        @Nullable
        private String iosClientId;
        @Nullable
        private String measurementId;
        @NonNull
        private String messagingSenderId;
        @NonNull
        private String projectId;
        @Nullable
        private String storageBucket;
        @Nullable
        private String trackingId;

        public static final class Builder {
            @Nullable
            private String androidClientId;
            @Nullable
            private String apiKey;
            @Nullable
            private String appGroupId;
            @Nullable
            private String appId;
            @Nullable
            private String authDomain;
            @Nullable
            private String databaseURL;
            @Nullable
            private String deepLinkURLScheme;
            @Nullable
            private String iosBundleId;
            @Nullable
            private String iosClientId;
            @Nullable
            private String measurementId;
            @Nullable
            private String messagingSenderId;
            @Nullable
            private String projectId;
            @Nullable
            private String storageBucket;
            @Nullable
            private String trackingId;

            @NonNull
            public PigeonFirebaseOptions build() {
                PigeonFirebaseOptions pigeonFirebaseOptions = new PigeonFirebaseOptions();
                pigeonFirebaseOptions.setApiKey(this.apiKey);
                pigeonFirebaseOptions.setAppId(this.appId);
                pigeonFirebaseOptions.setMessagingSenderId(this.messagingSenderId);
                pigeonFirebaseOptions.setProjectId(this.projectId);
                pigeonFirebaseOptions.setAuthDomain(this.authDomain);
                pigeonFirebaseOptions.setDatabaseURL(this.databaseURL);
                pigeonFirebaseOptions.setStorageBucket(this.storageBucket);
                pigeonFirebaseOptions.setMeasurementId(this.measurementId);
                pigeonFirebaseOptions.setTrackingId(this.trackingId);
                pigeonFirebaseOptions.setDeepLinkURLScheme(this.deepLinkURLScheme);
                pigeonFirebaseOptions.setAndroidClientId(this.androidClientId);
                pigeonFirebaseOptions.setIosClientId(this.iosClientId);
                pigeonFirebaseOptions.setIosBundleId(this.iosBundleId);
                pigeonFirebaseOptions.setAppGroupId(this.appGroupId);
                return pigeonFirebaseOptions;
            }

            @NonNull
            public Builder setAndroidClientId(@Nullable String str) {
                this.androidClientId = str;
                return this;
            }

            @NonNull
            public Builder setApiKey(@NonNull String str) {
                this.apiKey = str;
                return this;
            }

            @NonNull
            public Builder setAppGroupId(@Nullable String str) {
                this.appGroupId = str;
                return this;
            }

            @NonNull
            public Builder setAppId(@NonNull String str) {
                this.appId = str;
                return this;
            }

            @NonNull
            public Builder setAuthDomain(@Nullable String str) {
                this.authDomain = str;
                return this;
            }

            @NonNull
            public Builder setDatabaseURL(@Nullable String str) {
                this.databaseURL = str;
                return this;
            }

            @NonNull
            public Builder setDeepLinkURLScheme(@Nullable String str) {
                this.deepLinkURLScheme = str;
                return this;
            }

            @NonNull
            public Builder setIosBundleId(@Nullable String str) {
                this.iosBundleId = str;
                return this;
            }

            @NonNull
            public Builder setIosClientId(@Nullable String str) {
                this.iosClientId = str;
                return this;
            }

            @NonNull
            public Builder setMeasurementId(@Nullable String str) {
                this.measurementId = str;
                return this;
            }

            @NonNull
            public Builder setMessagingSenderId(@NonNull String str) {
                this.messagingSenderId = str;
                return this;
            }

            @NonNull
            public Builder setProjectId(@NonNull String str) {
                this.projectId = str;
                return this;
            }

            @NonNull
            public Builder setStorageBucket(@Nullable String str) {
                this.storageBucket = str;
                return this;
            }

            @NonNull
            public Builder setTrackingId(@Nullable String str) {
                this.trackingId = str;
                return this;
            }
        }

        private PigeonFirebaseOptions() {
        }

        @NonNull
        public static PigeonFirebaseOptions a(@NonNull Map<String, Object> map) {
            PigeonFirebaseOptions pigeonFirebaseOptions = new PigeonFirebaseOptions();
            pigeonFirebaseOptions.setApiKey((String) map.get(Profile.API_KEY));
            pigeonFirebaseOptions.setAppId((String) map.get("appId"));
            pigeonFirebaseOptions.setMessagingSenderId((String) map.get("messagingSenderId"));
            pigeonFirebaseOptions.setProjectId((String) map.get("projectId"));
            pigeonFirebaseOptions.setAuthDomain((String) map.get("authDomain"));
            pigeonFirebaseOptions.setDatabaseURL((String) map.get("databaseURL"));
            pigeonFirebaseOptions.setStorageBucket((String) map.get("storageBucket"));
            pigeonFirebaseOptions.setMeasurementId((String) map.get("measurementId"));
            pigeonFirebaseOptions.setTrackingId((String) map.get("trackingId"));
            pigeonFirebaseOptions.setDeepLinkURLScheme((String) map.get("deepLinkURLScheme"));
            pigeonFirebaseOptions.setAndroidClientId((String) map.get("androidClientId"));
            pigeonFirebaseOptions.setIosClientId((String) map.get("iosClientId"));
            pigeonFirebaseOptions.setIosBundleId((String) map.get("iosBundleId"));
            pigeonFirebaseOptions.setAppGroupId((String) map.get("appGroupId"));
            return pigeonFirebaseOptions;
        }

        @NonNull
        public Map<String, Object> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(Profile.API_KEY, this.apiKey);
            hashMap.put("appId", this.appId);
            hashMap.put("messagingSenderId", this.messagingSenderId);
            hashMap.put("projectId", this.projectId);
            hashMap.put("authDomain", this.authDomain);
            hashMap.put("databaseURL", this.databaseURL);
            hashMap.put("storageBucket", this.storageBucket);
            hashMap.put("measurementId", this.measurementId);
            hashMap.put("trackingId", this.trackingId);
            hashMap.put("deepLinkURLScheme", this.deepLinkURLScheme);
            hashMap.put("androidClientId", this.androidClientId);
            hashMap.put("iosClientId", this.iosClientId);
            hashMap.put("iosBundleId", this.iosBundleId);
            hashMap.put("appGroupId", this.appGroupId);
            return hashMap;
        }

        @Nullable
        public String getAndroidClientId() {
            return this.androidClientId;
        }

        @NonNull
        public String getApiKey() {
            return this.apiKey;
        }

        @Nullable
        public String getAppGroupId() {
            return this.appGroupId;
        }

        @NonNull
        public String getAppId() {
            return this.appId;
        }

        @Nullable
        public String getAuthDomain() {
            return this.authDomain;
        }

        @Nullable
        public String getDatabaseURL() {
            return this.databaseURL;
        }

        @Nullable
        public String getDeepLinkURLScheme() {
            return this.deepLinkURLScheme;
        }

        @Nullable
        public String getIosBundleId() {
            return this.iosBundleId;
        }

        @Nullable
        public String getIosClientId() {
            return this.iosClientId;
        }

        @Nullable
        public String getMeasurementId() {
            return this.measurementId;
        }

        @NonNull
        public String getMessagingSenderId() {
            return this.messagingSenderId;
        }

        @NonNull
        public String getProjectId() {
            return this.projectId;
        }

        @Nullable
        public String getStorageBucket() {
            return this.storageBucket;
        }

        @Nullable
        public String getTrackingId() {
            return this.trackingId;
        }

        public void setAndroidClientId(@Nullable String str) {
            this.androidClientId = str;
        }

        public void setApiKey(@NonNull String str) {
            if (str != null) {
                this.apiKey = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
        }

        public void setAppGroupId(@Nullable String str) {
            this.appGroupId = str;
        }

        public void setAppId(@NonNull String str) {
            if (str != null) {
                this.appId = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }

        public void setAuthDomain(@Nullable String str) {
            this.authDomain = str;
        }

        public void setDatabaseURL(@Nullable String str) {
            this.databaseURL = str;
        }

        public void setDeepLinkURLScheme(@Nullable String str) {
            this.deepLinkURLScheme = str;
        }

        public void setIosBundleId(@Nullable String str) {
            this.iosBundleId = str;
        }

        public void setIosClientId(@Nullable String str) {
            this.iosClientId = str;
        }

        public void setMeasurementId(@Nullable String str) {
            this.measurementId = str;
        }

        public void setMessagingSenderId(@NonNull String str) {
            if (str != null) {
                this.messagingSenderId = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
        }

        public void setProjectId(@NonNull String str) {
            if (str != null) {
                this.projectId = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"projectId\" is null.");
        }

        public void setStorageBucket(@Nullable String str) {
            this.storageBucket = str;
        }

        public void setTrackingId(@Nullable String str) {
            this.trackingId = str;
        }
    }

    public static class PigeonInitializeResponse {
        @Nullable
        private Boolean isAutomaticDataCollectionEnabled;
        @NonNull

        /* renamed from: name  reason: collision with root package name */
        private String f14306name;
        @NonNull
        private PigeonFirebaseOptions options;
        @NonNull
        private Map<String, Object> pluginConstants;

        public static final class Builder {
            @Nullable
            private Boolean isAutomaticDataCollectionEnabled;
            @Nullable

            /* renamed from: name  reason: collision with root package name */
            private String f14307name;
            @Nullable
            private PigeonFirebaseOptions options;
            @Nullable
            private Map<String, Object> pluginConstants;

            @NonNull
            public PigeonInitializeResponse build() {
                PigeonInitializeResponse pigeonInitializeResponse = new PigeonInitializeResponse();
                pigeonInitializeResponse.setName(this.f14307name);
                pigeonInitializeResponse.setOptions(this.options);
                pigeonInitializeResponse.setIsAutomaticDataCollectionEnabled(this.isAutomaticDataCollectionEnabled);
                pigeonInitializeResponse.setPluginConstants(this.pluginConstants);
                return pigeonInitializeResponse;
            }

            @NonNull
            public Builder setIsAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
                this.isAutomaticDataCollectionEnabled = bool;
                return this;
            }

            @NonNull
            public Builder setName(@NonNull String str) {
                this.f14307name = str;
                return this;
            }

            @NonNull
            public Builder setOptions(@NonNull PigeonFirebaseOptions pigeonFirebaseOptions) {
                this.options = pigeonFirebaseOptions;
                return this;
            }

            @NonNull
            public Builder setPluginConstants(@NonNull Map<String, Object> map) {
                this.pluginConstants = map;
                return this;
            }
        }

        private PigeonInitializeResponse() {
        }

        @NonNull
        public static PigeonInitializeResponse a(@NonNull Map<String, Object> map) {
            PigeonFirebaseOptions pigeonFirebaseOptions;
            PigeonInitializeResponse pigeonInitializeResponse = new PigeonInitializeResponse();
            pigeonInitializeResponse.setName((String) map.get("name"));
            Object obj = map.get("options");
            if (obj == null) {
                pigeonFirebaseOptions = null;
            } else {
                pigeonFirebaseOptions = PigeonFirebaseOptions.a((Map) obj);
            }
            pigeonInitializeResponse.setOptions(pigeonFirebaseOptions);
            pigeonInitializeResponse.setIsAutomaticDataCollectionEnabled((Boolean) map.get("isAutomaticDataCollectionEnabled"));
            pigeonInitializeResponse.setPluginConstants((Map) map.get("pluginConstants"));
            return pigeonInitializeResponse;
        }

        @NonNull
        public Map<String, Object> b() {
            Map<String, Object> map;
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.f14306name);
            PigeonFirebaseOptions pigeonFirebaseOptions = this.options;
            if (pigeonFirebaseOptions == null) {
                map = null;
            } else {
                map = pigeonFirebaseOptions.b();
            }
            hashMap.put("options", map);
            hashMap.put("isAutomaticDataCollectionEnabled", this.isAutomaticDataCollectionEnabled);
            hashMap.put("pluginConstants", this.pluginConstants);
            return hashMap;
        }

        @Nullable
        public Boolean getIsAutomaticDataCollectionEnabled() {
            return this.isAutomaticDataCollectionEnabled;
        }

        @NonNull
        public String getName() {
            return this.f14306name;
        }

        @NonNull
        public PigeonFirebaseOptions getOptions() {
            return this.options;
        }

        @NonNull
        public Map<String, Object> getPluginConstants() {
            return this.pluginConstants;
        }

        public void setIsAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
            this.isAutomaticDataCollectionEnabled = bool;
        }

        public void setName(@NonNull String str) {
            if (str != null) {
                this.f14306name = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"name\" is null.");
        }

        public void setOptions(@NonNull PigeonFirebaseOptions pigeonFirebaseOptions) {
            if (pigeonFirebaseOptions != null) {
                this.options = pigeonFirebaseOptions;
                return;
            }
            throw new IllegalStateException("Nonnull field \"options\" is null.");
        }

        public void setPluginConstants(@NonNull Map<String, Object> map) {
            if (map != null) {
                this.pluginConstants = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
        }
    }

    public interface Result<T> {
        void error(Throwable th2);

        void success(T t11);
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> wrapError(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th2.toString());
        hashMap.put(Constant.PARAM_ERROR_CODE, th2.getClass().getSimpleName());
        hashMap.put("details", "Cause: " + th2.getCause() + ", Stacktrace: " + Log.getStackTraceString(th2));
        return hashMap;
    }
}
