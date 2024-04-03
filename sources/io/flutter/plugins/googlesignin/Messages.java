package io.flutter.plugins.googlesignin;

import a00.j;
import a00.k;
import a00.l;
import a00.m;
import a00.n;
import a00.o;
import a00.p;
import a00.q;
import a00.r;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface GoogleSignInApi {

        /* renamed from: io.flutter.plugins.googlesignin.Messages$GoogleSignInApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @NonNull
            public static MessageCodec<Object> a() {
                return GoogleSignInApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    googleSignInApi.init((InitParams) ((ArrayList) obj).get(0));
                    arrayList.add(0, (Object) null);
                } catch (Throwable th2) {
                    arrayList = Messages.a(th2);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void e(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList arrayList = (ArrayList) obj;
                googleSignInApi.getAccessToken((String) arrayList.get(0), (Boolean) arrayList.get(1), new Result<String>(new ArrayList(), reply) {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ArrayList f14352a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BasicMessageChannel.Reply f14353b;

                    {
                        this.f14352a = r1;
                        this.f14353b = r2;
                    }

                    public void error(Throwable th2) {
                        this.f14353b.reply(Messages.a(th2));
                    }

                    public void success(String str) {
                        this.f14352a.add(0, str);
                        this.f14353b.reply(this.f14352a);
                    }
                });
            }

            public static /* synthetic */ void h(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    arrayList.add(0, googleSignInApi.isSignedIn());
                } catch (Throwable th2) {
                    arrayList = Messages.a(th2);
                }
                reply.reply(arrayList);
            }

            public static void k(@NonNull BinaryMessenger binaryMessenger, @Nullable GoogleSignInApi googleSignInApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.init", a());
                if (googleSignInApi != null) {
                    basicMessageChannel.setMessageHandler(new j(googleSignInApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.signInSilently", a());
                if (googleSignInApi != null) {
                    basicMessageChannel2.setMessageHandler(new k(googleSignInApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.signIn", a());
                if (googleSignInApi != null) {
                    basicMessageChannel3.setMessageHandler(new l(googleSignInApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.getAccessToken", a());
                if (googleSignInApi != null) {
                    basicMessageChannel4.setMessageHandler(new m(googleSignInApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.signOut", a());
                if (googleSignInApi != null) {
                    basicMessageChannel5.setMessageHandler(new n(googleSignInApi));
                } else {
                    basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.disconnect", a());
                if (googleSignInApi != null) {
                    basicMessageChannel6.setMessageHandler(new o(googleSignInApi));
                } else {
                    basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.isSignedIn", a());
                if (googleSignInApi != null) {
                    basicMessageChannel7.setMessageHandler(new p(googleSignInApi));
                } else {
                    basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.clearAuthCache", a());
                if (googleSignInApi != null) {
                    basicMessageChannel8.setMessageHandler(new q(googleSignInApi));
                } else {
                    basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.GoogleSignInApi.requestScopes", a());
                if (googleSignInApi != null) {
                    basicMessageChannel9.setMessageHandler(new r(googleSignInApi));
                } else {
                    basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void clearAuthCache(@NonNull String str, @NonNull Result<Void> result);

        void disconnect(@NonNull Result<Void> result);

        void getAccessToken(@NonNull String str, @NonNull Boolean bool, @NonNull Result<String> result);

        void init(@NonNull InitParams initParams);

        @NonNull
        Boolean isSignedIn();

        void requestScopes(@NonNull List<String> list, @NonNull Result<Boolean> result);

        void signIn(@NonNull Result<UserData> result);

        void signInSilently(@NonNull Result<UserData> result);

        void signOut(@NonNull Result<Void> result);
    }

    public static class GoogleSignInApiCodec extends StandardMessageCodec {
        public static final GoogleSignInApiCodec INSTANCE = new GoogleSignInApiCodec();

        private GoogleSignInApiCodec() {
        }

        public Object e(byte b11, @NonNull ByteBuffer byteBuffer) {
            if (b11 == Byte.MIN_VALUE) {
                return InitParams.a((ArrayList) d(byteBuffer));
            }
            if (b11 != -127) {
                return super.e(b11, byteBuffer);
            }
            return UserData.a((ArrayList) d(byteBuffer));
        }

        public void n(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof InitParams) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((InitParams) obj).b());
            } else if (obj instanceof UserData) {
                byteArrayOutputStream.write(129);
                n(byteArrayOutputStream, ((UserData) obj).b());
            } else {
                super.n(byteArrayOutputStream, obj);
            }
        }
    }

    public static final class InitParams {
        @Nullable
        private String clientId;
        @NonNull
        private Boolean forceCodeForRefreshToken;
        @Nullable
        private String hostedDomain;
        @NonNull
        private List<String> scopes;
        @Nullable
        private String serverClientId;
        @NonNull
        private SignInType signInType;

        public static final class Builder {
            @Nullable
            private String clientId;
            @Nullable
            private Boolean forceCodeForRefreshToken;
            @Nullable
            private String hostedDomain;
            @Nullable
            private List<String> scopes;
            @Nullable
            private String serverClientId;
            @Nullable
            private SignInType signInType;

            @NonNull
            public InitParams build() {
                InitParams initParams = new InitParams();
                initParams.setScopes(this.scopes);
                initParams.setSignInType(this.signInType);
                initParams.setHostedDomain(this.hostedDomain);
                initParams.setClientId(this.clientId);
                initParams.setServerClientId(this.serverClientId);
                initParams.setForceCodeForRefreshToken(this.forceCodeForRefreshToken);
                return initParams;
            }

            @NonNull
            public Builder setClientId(@Nullable String str) {
                this.clientId = str;
                return this;
            }

            @NonNull
            public Builder setForceCodeForRefreshToken(@NonNull Boolean bool) {
                this.forceCodeForRefreshToken = bool;
                return this;
            }

            @NonNull
            public Builder setHostedDomain(@Nullable String str) {
                this.hostedDomain = str;
                return this;
            }

            @NonNull
            public Builder setScopes(@NonNull List<String> list) {
                this.scopes = list;
                return this;
            }

            @NonNull
            public Builder setServerClientId(@Nullable String str) {
                this.serverClientId = str;
                return this;
            }

            @NonNull
            public Builder setSignInType(@NonNull SignInType signInType2) {
                this.signInType = signInType2;
                return this;
            }
        }

        @NonNull
        public static InitParams a(@NonNull ArrayList<Object> arrayList) {
            SignInType signInType2;
            InitParams initParams = new InitParams();
            initParams.setScopes((List) arrayList.get(0));
            Object obj = arrayList.get(1);
            if (obj == null) {
                signInType2 = null;
            } else {
                signInType2 = SignInType.values()[((Integer) obj).intValue()];
            }
            initParams.setSignInType(signInType2);
            initParams.setHostedDomain((String) arrayList.get(2));
            initParams.setClientId((String) arrayList.get(3));
            initParams.setServerClientId((String) arrayList.get(4));
            initParams.setForceCodeForRefreshToken((Boolean) arrayList.get(5));
            return initParams;
        }

        @NonNull
        public ArrayList<Object> b() {
            Integer num;
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.scopes);
            SignInType signInType2 = this.signInType;
            if (signInType2 == null) {
                num = null;
            } else {
                num = Integer.valueOf(signInType2.f14362b);
            }
            arrayList.add(num);
            arrayList.add(this.hostedDomain);
            arrayList.add(this.clientId);
            arrayList.add(this.serverClientId);
            arrayList.add(this.forceCodeForRefreshToken);
            return arrayList;
        }

        @Nullable
        public String getClientId() {
            return this.clientId;
        }

        @NonNull
        public Boolean getForceCodeForRefreshToken() {
            return this.forceCodeForRefreshToken;
        }

        @Nullable
        public String getHostedDomain() {
            return this.hostedDomain;
        }

        @NonNull
        public List<String> getScopes() {
            return this.scopes;
        }

        @Nullable
        public String getServerClientId() {
            return this.serverClientId;
        }

        @NonNull
        public SignInType getSignInType() {
            return this.signInType;
        }

        public void setClientId(@Nullable String str) {
            this.clientId = str;
        }

        public void setForceCodeForRefreshToken(@NonNull Boolean bool) {
            if (bool != null) {
                this.forceCodeForRefreshToken = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
        }

        public void setHostedDomain(@Nullable String str) {
            this.hostedDomain = str;
        }

        public void setScopes(@NonNull List<String> list) {
            if (list != null) {
                this.scopes = list;
                return;
            }
            throw new IllegalStateException("Nonnull field \"scopes\" is null.");
        }

        public void setServerClientId(@Nullable String str) {
            this.serverClientId = str;
        }

        public void setSignInType(@NonNull SignInType signInType2) {
            if (signInType2 != null) {
                this.signInType = signInType2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"signInType\" is null.");
        }
    }

    public interface Result<T> {
        void error(@NonNull Throwable th2);

        void success(T t11);
    }

    public enum SignInType {
        STANDARD(0),
        GAMES(1);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f14362b;

        private SignInType(int i11) {
            this.f14362b = i11;
        }
    }

    public static final class UserData {
        @Nullable
        private String displayName;
        @NonNull
        private String email;
        @NonNull

        /* renamed from: id  reason: collision with root package name */
        private String f14363id;
        @Nullable
        private String idToken;
        @Nullable
        private String photoUrl;
        @Nullable
        private String serverAuthCode;

        public static final class Builder {
            @Nullable
            private String displayName;
            @Nullable
            private String email;
            @Nullable

            /* renamed from: id  reason: collision with root package name */
            private String f14364id;
            @Nullable
            private String idToken;
            @Nullable
            private String photoUrl;
            @Nullable
            private String serverAuthCode;

            @NonNull
            public UserData build() {
                UserData userData = new UserData();
                userData.setDisplayName(this.displayName);
                userData.setEmail(this.email);
                userData.setId(this.f14364id);
                userData.setPhotoUrl(this.photoUrl);
                userData.setIdToken(this.idToken);
                userData.setServerAuthCode(this.serverAuthCode);
                return userData;
            }

            @NonNull
            public Builder setDisplayName(@Nullable String str) {
                this.displayName = str;
                return this;
            }

            @NonNull
            public Builder setEmail(@NonNull String str) {
                this.email = str;
                return this;
            }

            @NonNull
            public Builder setId(@NonNull String str) {
                this.f14364id = str;
                return this;
            }

            @NonNull
            public Builder setIdToken(@Nullable String str) {
                this.idToken = str;
                return this;
            }

            @NonNull
            public Builder setPhotoUrl(@Nullable String str) {
                this.photoUrl = str;
                return this;
            }

            @NonNull
            public Builder setServerAuthCode(@Nullable String str) {
                this.serverAuthCode = str;
                return this;
            }
        }

        @NonNull
        public static UserData a(@NonNull ArrayList<Object> arrayList) {
            UserData userData = new UserData();
            userData.setDisplayName((String) arrayList.get(0));
            userData.setEmail((String) arrayList.get(1));
            userData.setId((String) arrayList.get(2));
            userData.setPhotoUrl((String) arrayList.get(3));
            userData.setIdToken((String) arrayList.get(4));
            userData.setServerAuthCode((String) arrayList.get(5));
            return userData;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.displayName);
            arrayList.add(this.email);
            arrayList.add(this.f14363id);
            arrayList.add(this.photoUrl);
            arrayList.add(this.idToken);
            arrayList.add(this.serverAuthCode);
            return arrayList;
        }

        @Nullable
        public String getDisplayName() {
            return this.displayName;
        }

        @NonNull
        public String getEmail() {
            return this.email;
        }

        @NonNull
        public String getId() {
            return this.f14363id;
        }

        @Nullable
        public String getIdToken() {
            return this.idToken;
        }

        @Nullable
        public String getPhotoUrl() {
            return this.photoUrl;
        }

        @Nullable
        public String getServerAuthCode() {
            return this.serverAuthCode;
        }

        public void setDisplayName(@Nullable String str) {
            this.displayName = str;
        }

        public void setEmail(@NonNull String str) {
            if (str != null) {
                this.email = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"email\" is null.");
        }

        public void setId(@NonNull String str) {
            if (str != null) {
                this.f14363id = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"id\" is null.");
        }

        public void setIdToken(@Nullable String str) {
            this.idToken = str;
        }

        public void setPhotoUrl(@Nullable String str) {
            this.photoUrl = str;
        }

        public void setServerAuthCode(@Nullable String str) {
            this.serverAuthCode = str;
        }
    }

    @NonNull
    public static ArrayList<Object> a(@NonNull Throwable th2) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th2 instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th2;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th2.toString());
            arrayList.add(th2.getClass().getSimpleName());
            arrayList.add("Cause: " + th2.getCause() + ", Stacktrace: " + Log.getStackTraceString(th2));
        }
        return arrayList;
    }
}
