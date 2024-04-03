package io.flutter.plugins.webviewflutter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e00.a2;
import e00.b0;
import e00.b2;
import e00.c;
import e00.c2;
import e00.d;
import e00.d2;
import e00.e;
import e00.e2;
import e00.f;
import e00.f0;
import e00.f2;
import e00.g;
import e00.g0;
import e00.g2;
import e00.h0;
import e00.h2;
import e00.i0;
import e00.i2;
import e00.j;
import e00.j0;
import e00.j2;
import e00.k0;
import e00.k2;
import e00.l0;
import e00.l1;
import e00.l2;
import e00.m;
import e00.m0;
import e00.m1;
import e00.m2;
import e00.n0;
import e00.n1;
import e00.n2;
import e00.o1;
import e00.o2;
import e00.p1;
import e00.p2;
import e00.q;
import e00.q1;
import e00.q2;
import e00.r1;
import e00.r2;
import e00.s2;
import e00.t2;
import e00.u2;
import e00.v;
import e00.v1;
import e00.v2;
import e00.w1;
import e00.x1;
import e00.y;
import e00.y1;
import e00.z1;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GeneratedAndroidWebView {

    public static final class ConsoleMessage {
        @NonNull
        private ConsoleMessageLevel level;
        @NonNull
        private Long lineNumber;
        @NonNull
        private String message;
        @NonNull
        private String sourceId;

        public static final class Builder {
            @Nullable
            private ConsoleMessageLevel level;
            @Nullable
            private Long lineNumber;
            @Nullable
            private String message;
            @Nullable
            private String sourceId;

            @NonNull
            public ConsoleMessage build() {
                ConsoleMessage consoleMessage = new ConsoleMessage();
                consoleMessage.setLineNumber(this.lineNumber);
                consoleMessage.setMessage(this.message);
                consoleMessage.setLevel(this.level);
                consoleMessage.setSourceId(this.sourceId);
                return consoleMessage;
            }

            @NonNull
            public Builder setLevel(@NonNull ConsoleMessageLevel consoleMessageLevel) {
                this.level = consoleMessageLevel;
                return this;
            }

            @NonNull
            public Builder setLineNumber(@NonNull Long l11) {
                this.lineNumber = l11;
                return this;
            }

            @NonNull
            public Builder setMessage(@NonNull String str) {
                this.message = str;
                return this;
            }

            @NonNull
            public Builder setSourceId(@NonNull String str) {
                this.sourceId = str;
                return this;
            }
        }

        @NonNull
        public static ConsoleMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            ConsoleMessage consoleMessage = new ConsoleMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            consoleMessage.setLineNumber(l11);
            consoleMessage.setMessage((String) arrayList.get(1));
            consoleMessage.setLevel(ConsoleMessageLevel.values()[((Integer) arrayList.get(2)).intValue()]);
            consoleMessage.setSourceId((String) arrayList.get(3));
            return consoleMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            Integer num;
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.lineNumber);
            arrayList.add(this.message);
            ConsoleMessageLevel consoleMessageLevel = this.level;
            if (consoleMessageLevel == null) {
                num = null;
            } else {
                num = Integer.valueOf(consoleMessageLevel.f14414b);
            }
            arrayList.add(num);
            arrayList.add(this.sourceId);
            return arrayList;
        }

        @NonNull
        public ConsoleMessageLevel getLevel() {
            return this.level;
        }

        @NonNull
        public Long getLineNumber() {
            return this.lineNumber;
        }

        @NonNull
        public String getMessage() {
            return this.message;
        }

        @NonNull
        public String getSourceId() {
            return this.sourceId;
        }

        public void setLevel(@NonNull ConsoleMessageLevel consoleMessageLevel) {
            if (consoleMessageLevel != null) {
                this.level = consoleMessageLevel;
                return;
            }
            throw new IllegalStateException("Nonnull field \"level\" is null.");
        }

        public void setLineNumber(@NonNull Long l11) {
            if (l11 != null) {
                this.lineNumber = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"lineNumber\" is null.");
        }

        public void setMessage(@NonNull String str) {
            if (str != null) {
                this.message = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"message\" is null.");
        }

        public void setSourceId(@NonNull String str) {
            if (str != null) {
                this.sourceId = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"sourceId\" is null.");
        }
    }

    public enum ConsoleMessageLevel {
        DEBUG(0),
        ERROR(1),
        LOG(2),
        TIP(3),
        WARNING(4),
        UNKNOWN(5);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f14414b;

        private ConsoleMessageLevel(int i11) {
            this.f14414b = i11;
        }
    }

    public interface CookieManagerHostApi {

        /* renamed from: io.flutter.plugins.webviewflutter.GeneratedAndroidWebView$CookieManagerHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @NonNull
            public static MessageCodec<Object> a() {
                return new StandardMessageCodec();
            }

            public static /* synthetic */ void b(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                cookieManagerHostApi.attachInstance(l11);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void c(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                String str2 = (String) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                cookieManagerHostApi.setCookie(l11, str, str2);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void d(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList arrayList = new ArrayList();
                Number number = (Number) ((ArrayList) obj).get(0);
                AnonymousClass1 r12 = new Result<Boolean>(arrayList, reply) {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ArrayList f14415a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BasicMessageChannel.Reply f14416b;

                    {
                        this.f14415a = r1;
                        this.f14416b = r2;
                    }

                    public void error(Throwable th2) {
                        this.f14416b.reply(GeneratedAndroidWebView.a(th2));
                    }

                    public void success(Boolean bool) {
                        this.f14415a.add(0, bool);
                        this.f14416b.reply(this.f14415a);
                    }
                };
                if (number == null) {
                    l11 = null;
                } else {
                    l11 = Long.valueOf(number.longValue());
                }
                cookieManagerHostApi.removeAllCookies(l11, r12);
            }

            public static /* synthetic */ void e(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                Boolean bool = (Boolean) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                cookieManagerHostApi.setAcceptThirdPartyCookies(l11, l12, bool);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static void f(@NonNull BinaryMessenger binaryMessenger, @Nullable CookieManagerHostApi cookieManagerHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.attachInstance", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel.setMessageHandler(new c(cookieManagerHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.setCookie", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new d(cookieManagerHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.removeAllCookies", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel3.setMessageHandler(new e(cookieManagerHostApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.setAcceptThirdPartyCookies", a());
                if (cookieManagerHostApi != null) {
                    basicMessageChannel4.setMessageHandler(new f(cookieManagerHostApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }
        }

        void attachInstance(@NonNull Long l11);

        void removeAllCookies(@NonNull Long l11, @NonNull Result<Boolean> result);

        void setAcceptThirdPartyCookies(@NonNull Long l11, @NonNull Long l12, @NonNull Boolean bool);

        void setCookie(@NonNull Long l11, @NonNull String str, @NonNull String str2);
    }

    public static class CustomViewCallbackFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public CustomViewCallbackFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallbackFlutterApi.create", b()).send(new ArrayList(Collections.singletonList(l11)), new g(reply));
        }
    }

    public interface CustomViewCallbackHostApi {
        void onCustomViewHidden(@NonNull Long l11);
    }

    public static class DownloadListenerFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public DownloadListenerFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void onDownloadStart(@NonNull Long l11, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull Long l12, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.DownloadListenerFlutterApi.onDownloadStart", b()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, str, str2, str3, str4, l12})), new j(reply));
        }
    }

    public interface DownloadListenerHostApi {
        void create(@NonNull Long l11);
    }

    public enum FileChooserMode {
        OPEN(0),
        OPEN_MULTIPLE(1),
        SAVE(2);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f14417b;

        private FileChooserMode(int i11) {
            this.f14417b = i11;
        }
    }

    public static class FileChooserParamsFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public FileChooserParamsFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull Boolean bool, @NonNull List<String> list, @NonNull FileChooserMode fileChooserMode, @Nullable String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FileChooserParamsFlutterApi.create", b()).send(new ArrayList(Arrays.asList(new Object[]{l11, bool, list, Integer.valueOf(fileChooserMode.f14417b), str})), new m(reply));
        }
    }

    public interface FlutterAssetManagerHostApi {
        @NonNull
        String getAssetFilePathByName(@NonNull String str);

        @NonNull
        List<String> list(@NonNull String str);
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public static class GeolocationPermissionsCallbackFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public GeolocationPermissionsCallbackFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallbackFlutterApi.create", b()).send(new ArrayList(Collections.singletonList(l11)), new q(reply));
        }
    }

    public interface GeolocationPermissionsCallbackHostApi {
        void invoke(@NonNull Long l11, @NonNull String str, @NonNull Boolean bool, @NonNull Boolean bool2);
    }

    public interface InstanceManagerHostApi {
        void clear();
    }

    public static class JavaObjectFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public JavaObjectFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void dispose(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaObjectFlutterApi.dispose", b()).send(new ArrayList(Collections.singletonList(l11)), new v(reply));
        }
    }

    public interface JavaObjectHostApi {
        void dispose(@NonNull Long l11);
    }

    public static class JavaScriptChannelFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public JavaScriptChannelFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void postMessage(@NonNull Long l11, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannelFlutterApi.postMessage", b()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, str})), new y(reply));
        }
    }

    public interface JavaScriptChannelHostApi {
        void create(@NonNull Long l11, @NonNull String str);
    }

    public static class PermissionRequestFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public PermissionRequestFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull List<String> list, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequestFlutterApi.create", b()).send(new ArrayList(Arrays.asList(new Object[]{l11, list})), new b0(reply));
        }
    }

    public interface PermissionRequestHostApi {
        void deny(@NonNull Long l11);

        void grant(@NonNull Long l11, @NonNull List<String> list);
    }

    public interface Result<T> {
        void error(@NonNull Throwable th2);

        void success(T t11);
    }

    public static class ViewFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public ViewFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.ViewFlutterApi.create", b()).send(new ArrayList(Collections.singletonList(l11)), new f0(reply));
        }
    }

    public static class WebChromeClientFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public WebChromeClientFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> i() {
            return WebChromeClientFlutterApiCodec.INSTANCE;
        }

        public void onConsoleMessage(@NonNull Long l11, @NonNull ConsoleMessage consoleMessage, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onConsoleMessage", i()).send(new ArrayList(Arrays.asList(new Object[]{l11, consoleMessage})), new n0(reply));
        }

        public void onGeolocationPermissionsHidePrompt(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsHidePrompt", i()).send(new ArrayList(Collections.singletonList(l11)), new j0(reply));
        }

        public void onGeolocationPermissionsShowPrompt(@NonNull Long l11, @NonNull Long l12, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsShowPrompt", i()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, str})), new h0(reply));
        }

        public void onHideCustomView(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onHideCustomView", i()).send(new ArrayList(Collections.singletonList(l11)), new i0(reply));
        }

        public void onPermissionRequest(@NonNull Long l11, @NonNull Long l12, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onPermissionRequest", i()).send(new ArrayList(Arrays.asList(new Long[]{l11, l12})), new g0(reply));
        }

        public void onProgressChanged(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onProgressChanged", i()).send(new ArrayList(Arrays.asList(new Long[]{l11, l12, l13})), new k0(reply));
        }

        public void onShowCustomView(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowCustomView", i()).send(new ArrayList(Arrays.asList(new Long[]{l11, l12, l13})), new m0(reply));
        }

        public void onShowFileChooser(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13, @NonNull Reply<List<String>> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowFileChooser", i()).send(new ArrayList(Arrays.asList(new Long[]{l11, l12, l13})), new l0(reply));
        }
    }

    public static class WebChromeClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebChromeClientFlutterApiCodec INSTANCE = new WebChromeClientFlutterApiCodec();

        private WebChromeClientFlutterApiCodec() {
        }

        public Object e(byte b11, @NonNull ByteBuffer byteBuffer) {
            if (b11 != Byte.MIN_VALUE) {
                return super.e(b11, byteBuffer);
            }
            return ConsoleMessage.a((ArrayList) d(byteBuffer));
        }

        public void n(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof ConsoleMessage) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((ConsoleMessage) obj).b());
                return;
            }
            super.n(byteArrayOutputStream, obj);
        }
    }

    public interface WebChromeClientHostApi {
        void create(@NonNull Long l11);

        void setSynchronousReturnValueForOnConsoleMessage(@NonNull Long l11, @NonNull Boolean bool);

        void setSynchronousReturnValueForOnShowFileChooser(@NonNull Long l11, @NonNull Boolean bool);
    }

    public static final class WebResourceErrorData {
        @NonNull
        private String description;
        @NonNull
        private Long errorCode;

        public static final class Builder {
            @Nullable
            private String description;
            @Nullable
            private Long errorCode;

            @NonNull
            public WebResourceErrorData build() {
                WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
                webResourceErrorData.setErrorCode(this.errorCode);
                webResourceErrorData.setDescription(this.description);
                return webResourceErrorData;
            }

            @NonNull
            public Builder setDescription(@NonNull String str) {
                this.description = str;
                return this;
            }

            @NonNull
            public Builder setErrorCode(@NonNull Long l11) {
                this.errorCode = l11;
                return this;
            }
        }

        @NonNull
        public static WebResourceErrorData a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            webResourceErrorData.setErrorCode(l11);
            webResourceErrorData.setDescription((String) arrayList.get(1));
            return webResourceErrorData;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.errorCode);
            arrayList.add(this.description);
            return arrayList;
        }

        @NonNull
        public String getDescription() {
            return this.description;
        }

        @NonNull
        public Long getErrorCode() {
            return this.errorCode;
        }

        public void setDescription(@NonNull String str) {
            if (str != null) {
                this.description = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"description\" is null.");
        }

        public void setErrorCode(@NonNull Long l11) {
            if (l11 != null) {
                this.errorCode = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"errorCode\" is null.");
        }
    }

    public static final class WebResourceRequestData {
        @NonNull
        private Boolean hasGesture;
        @NonNull
        private Boolean isForMainFrame;
        @Nullable
        private Boolean isRedirect;
        @NonNull
        private String method;
        @NonNull
        private Map<String, String> requestHeaders;
        @NonNull
        private String url;

        public static final class Builder {
            @Nullable
            private Boolean hasGesture;
            @Nullable
            private Boolean isForMainFrame;
            @Nullable
            private Boolean isRedirect;
            @Nullable
            private String method;
            @Nullable
            private Map<String, String> requestHeaders;
            @Nullable
            private String url;

            @NonNull
            public WebResourceRequestData build() {
                WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
                webResourceRequestData.setUrl(this.url);
                webResourceRequestData.setIsForMainFrame(this.isForMainFrame);
                webResourceRequestData.setIsRedirect(this.isRedirect);
                webResourceRequestData.setHasGesture(this.hasGesture);
                webResourceRequestData.setMethod(this.method);
                webResourceRequestData.setRequestHeaders(this.requestHeaders);
                return webResourceRequestData;
            }

            @NonNull
            public Builder setHasGesture(@NonNull Boolean bool) {
                this.hasGesture = bool;
                return this;
            }

            @NonNull
            public Builder setIsForMainFrame(@NonNull Boolean bool) {
                this.isForMainFrame = bool;
                return this;
            }

            @NonNull
            public Builder setIsRedirect(@Nullable Boolean bool) {
                this.isRedirect = bool;
                return this;
            }

            @NonNull
            public Builder setMethod(@NonNull String str) {
                this.method = str;
                return this;
            }

            @NonNull
            public Builder setRequestHeaders(@NonNull Map<String, String> map) {
                this.requestHeaders = map;
                return this;
            }

            @NonNull
            public Builder setUrl(@NonNull String str) {
                this.url = str;
                return this;
            }
        }

        @NonNull
        public static WebResourceRequestData a(@NonNull ArrayList<Object> arrayList) {
            WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
            webResourceRequestData.setUrl((String) arrayList.get(0));
            webResourceRequestData.setIsForMainFrame((Boolean) arrayList.get(1));
            webResourceRequestData.setIsRedirect((Boolean) arrayList.get(2));
            webResourceRequestData.setHasGesture((Boolean) arrayList.get(3));
            webResourceRequestData.setMethod((String) arrayList.get(4));
            webResourceRequestData.setRequestHeaders((Map) arrayList.get(5));
            return webResourceRequestData;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.url);
            arrayList.add(this.isForMainFrame);
            arrayList.add(this.isRedirect);
            arrayList.add(this.hasGesture);
            arrayList.add(this.method);
            arrayList.add(this.requestHeaders);
            return arrayList;
        }

        @NonNull
        public Boolean getHasGesture() {
            return this.hasGesture;
        }

        @NonNull
        public Boolean getIsForMainFrame() {
            return this.isForMainFrame;
        }

        @Nullable
        public Boolean getIsRedirect() {
            return this.isRedirect;
        }

        @NonNull
        public String getMethod() {
            return this.method;
        }

        @NonNull
        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        @NonNull
        public String getUrl() {
            return this.url;
        }

        public void setHasGesture(@NonNull Boolean bool) {
            if (bool != null) {
                this.hasGesture = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"hasGesture\" is null.");
        }

        public void setIsForMainFrame(@NonNull Boolean bool) {
            if (bool != null) {
                this.isForMainFrame = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isForMainFrame\" is null.");
        }

        public void setIsRedirect(@Nullable Boolean bool) {
            this.isRedirect = bool;
        }

        public void setMethod(@NonNull String str) {
            if (str != null) {
                this.method = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"method\" is null.");
        }

        public void setRequestHeaders(@NonNull Map<String, String> map) {
            if (map != null) {
                this.requestHeaders = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"requestHeaders\" is null.");
        }

        public void setUrl(@NonNull String str) {
            if (str != null) {
                this.url = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"url\" is null.");
        }
    }

    public interface WebSettingsHostApi {
        void create(@NonNull Long l11, @NonNull Long l12);

        @NonNull
        String getUserAgentString(@NonNull Long l11);

        void setAllowFileAccess(@NonNull Long l11, @NonNull Boolean bool);

        void setBuiltInZoomControls(@NonNull Long l11, @NonNull Boolean bool);

        void setDisplayZoomControls(@NonNull Long l11, @NonNull Boolean bool);

        void setDomStorageEnabled(@NonNull Long l11, @NonNull Boolean bool);

        void setJavaScriptCanOpenWindowsAutomatically(@NonNull Long l11, @NonNull Boolean bool);

        void setJavaScriptEnabled(@NonNull Long l11, @NonNull Boolean bool);

        void setLoadWithOverviewMode(@NonNull Long l11, @NonNull Boolean bool);

        void setMediaPlaybackRequiresUserGesture(@NonNull Long l11, @NonNull Boolean bool);

        void setSupportMultipleWindows(@NonNull Long l11, @NonNull Boolean bool);

        void setSupportZoom(@NonNull Long l11, @NonNull Boolean bool);

        void setTextZoom(@NonNull Long l11, @NonNull Long l12);

        void setUseWideViewPort(@NonNull Long l11, @NonNull Boolean bool);

        void setUserAgentString(@NonNull Long l11, @Nullable String str);
    }

    public interface WebStorageHostApi {
        void create(@NonNull Long l11);

        void deleteAllData(@NonNull Long l11);
    }

    public static class WebViewClientFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public WebViewClientFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> h() {
            return WebViewClientFlutterApiCodec.INSTANCE;
        }

        public void doUpdateVisitedHistory(@NonNull Long l11, @NonNull Long l12, @NonNull String str, @NonNull Boolean bool, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.doUpdateVisitedHistory", h()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, str, bool})), new q1(reply));
        }

        public void onPageFinished(@NonNull Long l11, @NonNull Long l12, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onPageFinished", h()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, str})), new p1(reply));
        }

        public void onPageStarted(@NonNull Long l11, @NonNull Long l12, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onPageStarted", h()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, str})), new n1(reply));
        }

        public void onReceivedError(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13, @NonNull String str, @NonNull String str2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedError", h()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, l13, str, str2})), new r1(reply));
        }

        public void onReceivedRequestError(@NonNull Long l11, @NonNull Long l12, @NonNull WebResourceRequestData webResourceRequestData, @NonNull WebResourceErrorData webResourceErrorData, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedRequestError", h()).send(new ArrayList(Arrays.asList(new Object[]{l11, l12, webResourceRequestData, webResourceErrorData})), new l1(reply));
        }

        public void requestLoading(@NonNull Long l11, @NonNull Long l12, @NonNull WebResourceRequestData webResourceRequestData, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.requestLoading", h()).send(new ArrayList(Arrays.asList(new Object[]{l11, l12, webResourceRequestData})), new m1(reply));
        }

        public void urlLoading(@NonNull Long l11, @NonNull Long l12, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.urlLoading", h()).send(new ArrayList(Arrays.asList(new Serializable[]{l11, l12, str})), new o1(reply));
        }
    }

    public static class WebViewClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebViewClientFlutterApiCodec INSTANCE = new WebViewClientFlutterApiCodec();

        private WebViewClientFlutterApiCodec() {
        }

        public Object e(byte b11, @NonNull ByteBuffer byteBuffer) {
            if (b11 == Byte.MIN_VALUE) {
                return WebResourceErrorData.a((ArrayList) d(byteBuffer));
            }
            if (b11 != -127) {
                return super.e(b11, byteBuffer);
            }
            return WebResourceRequestData.a((ArrayList) d(byteBuffer));
        }

        public void n(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof WebResourceErrorData) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((WebResourceErrorData) obj).b());
            } else if (obj instanceof WebResourceRequestData) {
                byteArrayOutputStream.write(129);
                n(byteArrayOutputStream, ((WebResourceRequestData) obj).b());
            } else {
                super.n(byteArrayOutputStream, obj);
            }
        }
    }

    public interface WebViewClientHostApi {
        void create(@NonNull Long l11);

        void setSynchronousReturnValueForShouldOverrideUrlLoading(@NonNull Long l11, @NonNull Boolean bool);
    }

    public static class WebViewFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t11);
        }

        public WebViewFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> b() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l11, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewFlutterApi.create", b()).send(new ArrayList(Collections.singletonList(l11)), new v1(reply));
        }
    }

    public interface WebViewHostApi {

        /* renamed from: io.flutter.plugins.webviewflutter.GeneratedAndroidWebView$WebViewHostApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void A(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.goForward(l11);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static void B(@NonNull BinaryMessenger binaryMessenger, @Nullable WebViewHostApi webViewHostApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.create", a());
                if (webViewHostApi != null) {
                    basicMessageChannel.setMessageHandler(new w1(webViewHostApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadData", a());
                if (webViewHostApi != null) {
                    basicMessageChannel2.setMessageHandler(new y1(webViewHostApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadDataWithBaseUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel3.setMessageHandler(new f2(webViewHostApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel4.setMessageHandler(new g2(webViewHostApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.postUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel5.setMessageHandler(new i2(webViewHostApi));
                } else {
                    basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getUrl", a());
                if (webViewHostApi != null) {
                    basicMessageChannel6.setMessageHandler(new j2(webViewHostApi));
                } else {
                    basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.canGoBack", a());
                if (webViewHostApi != null) {
                    basicMessageChannel7.setMessageHandler(new k2(webViewHostApi));
                } else {
                    basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.canGoForward", a());
                if (webViewHostApi != null) {
                    basicMessageChannel8.setMessageHandler(new l2(webViewHostApi));
                } else {
                    basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.goBack", a());
                if (webViewHostApi != null) {
                    basicMessageChannel9.setMessageHandler(new m2(webViewHostApi));
                } else {
                    basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.goForward", a());
                if (webViewHostApi != null) {
                    basicMessageChannel10.setMessageHandler(new n2(webViewHostApi));
                } else {
                    basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.reload", a());
                if (webViewHostApi != null) {
                    basicMessageChannel11.setMessageHandler(new h2(webViewHostApi));
                } else {
                    basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.clearCache", a());
                if (webViewHostApi != null) {
                    basicMessageChannel12.setMessageHandler(new o2(webViewHostApi));
                } else {
                    basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.evaluateJavascript", a());
                if (webViewHostApi != null) {
                    basicMessageChannel13.setMessageHandler(new p2(webViewHostApi));
                } else {
                    basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getTitle", a());
                if (webViewHostApi != null) {
                    basicMessageChannel14.setMessageHandler(new q2(webViewHostApi));
                } else {
                    basicMessageChannel14.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.scrollTo", a());
                if (webViewHostApi != null) {
                    basicMessageChannel15.setMessageHandler(new r2(webViewHostApi));
                } else {
                    basicMessageChannel15.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.scrollBy", a());
                if (webViewHostApi != null) {
                    basicMessageChannel16.setMessageHandler(new s2(webViewHostApi));
                } else {
                    basicMessageChannel16.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollX", a());
                if (webViewHostApi != null) {
                    basicMessageChannel17.setMessageHandler(new t2(webViewHostApi));
                } else {
                    basicMessageChannel17.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollY", a());
                if (webViewHostApi != null) {
                    basicMessageChannel18.setMessageHandler(new u2(webViewHostApi));
                } else {
                    basicMessageChannel18.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollPosition", a());
                if (webViewHostApi != null) {
                    basicMessageChannel19.setMessageHandler(new v2(webViewHostApi));
                } else {
                    basicMessageChannel19.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebContentsDebuggingEnabled", a());
                if (webViewHostApi != null) {
                    basicMessageChannel20.setMessageHandler(new x1(webViewHostApi));
                } else {
                    basicMessageChannel20.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebViewClient", a());
                if (webViewHostApi != null) {
                    basicMessageChannel21.setMessageHandler(new z1(webViewHostApi));
                } else {
                    basicMessageChannel21.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.addJavaScriptChannel", a());
                if (webViewHostApi != null) {
                    basicMessageChannel22.setMessageHandler(new a2(webViewHostApi));
                } else {
                    basicMessageChannel22.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.removeJavaScriptChannel", a());
                if (webViewHostApi != null) {
                    basicMessageChannel23.setMessageHandler(new b2(webViewHostApi));
                } else {
                    basicMessageChannel23.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel24 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setDownloadListener", a());
                if (webViewHostApi != null) {
                    basicMessageChannel24.setMessageHandler(new c2(webViewHostApi));
                } else {
                    basicMessageChannel24.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel25 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebChromeClient", a());
                if (webViewHostApi != null) {
                    basicMessageChannel25.setMessageHandler(new d2(webViewHostApi));
                } else {
                    basicMessageChannel25.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel26 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setBackgroundColor", a());
                if (webViewHostApi != null) {
                    basicMessageChannel26.setMessageHandler(new e2(webViewHostApi));
                } else {
                    basicMessageChannel26.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }

            @NonNull
            public static MessageCodec<Object> a() {
                return WebViewHostApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.create(l11);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void c(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                String str2 = (String) arrayList2.get(2);
                String str3 = (String) arrayList2.get(3);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.loadData(l11, str, str2, str3);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void d(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.reload(l11);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void e(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Boolean bool = (Boolean) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.clearCache(l11, bool);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void f(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                AnonymousClass1 r22 = new Result<String>(arrayList, reply) {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ArrayList f14418a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BasicMessageChannel.Reply f14419b;

                    {
                        this.f14418a = r1;
                        this.f14419b = r2;
                    }

                    public void error(Throwable th2) {
                        this.f14419b.reply(GeneratedAndroidWebView.a(th2));
                    }

                    public void success(String str) {
                        this.f14418a.add(0, str);
                        this.f14419b.reply(this.f14418a);
                    }
                };
                if (number == null) {
                    l11 = null;
                } else {
                    l11 = Long.valueOf(number.longValue());
                }
                webViewHostApi.evaluateJavascript(l11, str, r22);
            }

            public static /* synthetic */ void g(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.getTitle(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void h(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                Long l13;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                Number number3 = (Number) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                if (number3 == null) {
                    l13 = null;
                } else {
                    l13 = Long.valueOf(number3.longValue());
                }
                webViewHostApi.scrollTo(l11, l12, l13);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void i(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                Long l13;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                Number number3 = (Number) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                if (number3 == null) {
                    l13 = null;
                } else {
                    l13 = Long.valueOf(number3.longValue());
                }
                webViewHostApi.scrollBy(l11, l12, l13);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void j(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.getScrollX(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void k(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.getScrollY(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void l(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.getScrollPosition(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void m(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    webViewHostApi.setWebContentsDebuggingEnabled((Boolean) ((ArrayList) obj).get(0));
                    arrayList.add(0, (Object) null);
                } catch (Throwable th2) {
                    arrayList = GeneratedAndroidWebView.a(th2);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void n(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                String str2 = (String) arrayList2.get(2);
                String str3 = (String) arrayList2.get(3);
                String str4 = (String) arrayList2.get(4);
                String str5 = (String) arrayList2.get(5);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.loadDataWithBaseUrl(l11, str, str2, str3, str4, str5);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void o(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.setWebViewClient(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void p(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.addJavaScriptChannel(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void q(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.removeJavaScriptChannel(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void r(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.setDownloadListener(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void s(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.setWebChromeClient(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void t(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                Long l12;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                Number number2 = (Number) arrayList2.get(1);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                if (number2 == null) {
                    l12 = null;
                } else {
                    l12 = Long.valueOf(number2.longValue());
                }
                webViewHostApi.setBackgroundColor(l11, l12);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void u(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                Map map = (Map) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.loadUrl(l11, str, map);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void v(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                Number number = (Number) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                byte[] bArr = (byte[]) arrayList2.get(2);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.postUrl(l11, str, bArr);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }

            public static /* synthetic */ void w(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.getUrl(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void x(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.canGoBack(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void y(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                arrayList.add(0, webViewHostApi.canGoForward(l11));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void z(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l11;
                ArrayList<Object> arrayList = new ArrayList<>();
                Number number = (Number) ((ArrayList) obj).get(0);
                if (number == null) {
                    l11 = null;
                } else {
                    try {
                        l11 = Long.valueOf(number.longValue());
                    } catch (Throwable th2) {
                        arrayList = GeneratedAndroidWebView.a(th2);
                    }
                }
                webViewHostApi.goBack(l11);
                arrayList.add(0, (Object) null);
                reply.reply(arrayList);
            }
        }

        void addJavaScriptChannel(@NonNull Long l11, @NonNull Long l12);

        @NonNull
        Boolean canGoBack(@NonNull Long l11);

        @NonNull
        Boolean canGoForward(@NonNull Long l11);

        void clearCache(@NonNull Long l11, @NonNull Boolean bool);

        void create(@NonNull Long l11);

        void evaluateJavascript(@NonNull Long l11, @NonNull String str, @NonNull Result<String> result);

        @NonNull
        WebViewPoint getScrollPosition(@NonNull Long l11);

        @NonNull
        Long getScrollX(@NonNull Long l11);

        @NonNull
        Long getScrollY(@NonNull Long l11);

        @Nullable
        String getTitle(@NonNull Long l11);

        @Nullable
        String getUrl(@NonNull Long l11);

        void goBack(@NonNull Long l11);

        void goForward(@NonNull Long l11);

        void loadData(@NonNull Long l11, @NonNull String str, @Nullable String str2, @Nullable String str3);

        void loadDataWithBaseUrl(@NonNull Long l11, @Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

        void loadUrl(@NonNull Long l11, @NonNull String str, @NonNull Map<String, String> map);

        void postUrl(@NonNull Long l11, @NonNull String str, @NonNull byte[] bArr);

        void reload(@NonNull Long l11);

        void removeJavaScriptChannel(@NonNull Long l11, @NonNull Long l12);

        void scrollBy(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13);

        void scrollTo(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13);

        void setBackgroundColor(@NonNull Long l11, @NonNull Long l12);

        void setDownloadListener(@NonNull Long l11, @Nullable Long l12);

        void setWebChromeClient(@NonNull Long l11, @Nullable Long l12);

        void setWebContentsDebuggingEnabled(@NonNull Boolean bool);

        void setWebViewClient(@NonNull Long l11, @NonNull Long l12);
    }

    public static class WebViewHostApiCodec extends StandardMessageCodec {
        public static final WebViewHostApiCodec INSTANCE = new WebViewHostApiCodec();

        private WebViewHostApiCodec() {
        }

        public Object e(byte b11, @NonNull ByteBuffer byteBuffer) {
            if (b11 != Byte.MIN_VALUE) {
                return super.e(b11, byteBuffer);
            }
            return WebViewPoint.a((ArrayList) d(byteBuffer));
        }

        public void n(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof WebViewPoint) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((WebViewPoint) obj).b());
                return;
            }
            super.n(byteArrayOutputStream, obj);
        }
    }

    public static final class WebViewPoint {
        @NonNull

        /* renamed from: x  reason: collision with root package name */
        private Long f14420x;
        @NonNull

        /* renamed from: y  reason: collision with root package name */
        private Long f14421y;

        public static final class Builder {
            @Nullable

            /* renamed from: x  reason: collision with root package name */
            private Long f14422x;
            @Nullable

            /* renamed from: y  reason: collision with root package name */
            private Long f14423y;

            @NonNull
            public WebViewPoint build() {
                WebViewPoint webViewPoint = new WebViewPoint();
                webViewPoint.setX(this.f14422x);
                webViewPoint.setY(this.f14423y);
                return webViewPoint;
            }

            @NonNull
            public Builder setX(@NonNull Long l11) {
                this.f14422x = l11;
                return this;
            }

            @NonNull
            public Builder setY(@NonNull Long l11) {
                this.f14423y = l11;
                return this;
            }
        }

        @NonNull
        public static WebViewPoint a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            long j12;
            WebViewPoint webViewPoint = new WebViewPoint();
            Object obj = arrayList.get(0);
            Long l12 = null;
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j12 = (long) ((Integer) obj).intValue();
                } else {
                    j12 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j12);
            }
            webViewPoint.setX(l11);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                if (obj2 instanceof Integer) {
                    j11 = (long) ((Integer) obj2).intValue();
                } else {
                    j11 = ((Long) obj2).longValue();
                }
                l12 = Long.valueOf(j11);
            }
            webViewPoint.setY(l12);
            return webViewPoint;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f14420x);
            arrayList.add(this.f14421y);
            return arrayList;
        }

        @NonNull
        public Long getX() {
            return this.f14420x;
        }

        @NonNull
        public Long getY() {
            return this.f14421y;
        }

        public void setX(@NonNull Long l11) {
            if (l11 != null) {
                this.f14420x = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"x\" is null.");
        }

        public void setY(@NonNull Long l11) {
            if (l11 != null) {
                this.f14421y = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"y\" is null.");
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
