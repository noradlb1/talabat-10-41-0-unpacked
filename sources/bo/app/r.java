package bo.app;

import com.appboy.enums.SdkFlavor;
import com.braze.Braze;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0011\b\u0004\u0012\u0006\u0010a\u001a\u00020]¢\u0006\u0004\bb\u0010cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\rH\u0016J\u0010\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\t\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\n\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001e\u0010%\"\u0004\b\t\u0010&R$\u0010'\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001bR$\u0010*\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001bR$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b\t\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b\t\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b)\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b,\u0010B\"\u0004\b\t\u0010CR$\u0010D\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010\u001a\"\u0004\b6\u0010\u001bR$\u0010F\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0018\u001a\u0004\b\t\u0010\u001a\"\u0004\b\t\u0010\u001bR0\u0010J\u001a\u0010\u0012\u0004\u0012\u00020H\u0018\u00010Gj\u0004\u0018\u0001`I8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\b\t\u0010NR\u0014\u0010R\u001a\u00020O8VX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010SR\u001a\u0010U\u001a\u00020\u000f8\u0016XD¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\b!\u0010SR\u001c\u0010\\\u001a\u0004\u0018\u00010W8VX\u0004¢\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u0014\u0010`\u001a\u00020]8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006d"}, d2 = {"Lbo/app/r;", "Lbo/app/q4;", "Lbo/app/c2;", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/q2;", "responseError", "", "a", "b", "", "", "Lcom/braze/communication/MutableHttpHeaders;", "existingHeaders", "", "toString", "", "requestInitiationTime", "Ljava/lang/Long;", "j", "()Ljava/lang/Long;", "(Ljava/lang/Long;)V", "deviceId", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "apiKey", "n", "f", "sdkVersion", "s", "g", "Lbo/app/j0;", "device", "Lbo/app/j0;", "()Lbo/app/j0;", "(Lbo/app/j0;)V", "hostAppVersion", "q", "c", "hostAppSemanticVersionCode", "p", "e", "Lcom/appboy/enums/SdkFlavor;", "sdkFlavor", "Lcom/appboy/enums/SdkFlavor;", "r", "()Lcom/appboy/enums/SdkFlavor;", "(Lcom/appboy/enums/SdkFlavor;)V", "Lbo/app/b4;", "outboundUser", "Lbo/app/b4;", "d", "()Lbo/app/b4;", "(Lbo/app/b4;)V", "Lbo/app/a4;", "outboundRespondWith", "Lbo/app/a4;", "()Lbo/app/a4;", "setOutboundRespondWith", "(Lbo/app/a4;)V", "Lbo/app/k;", "customEvents", "Lbo/app/k;", "()Lbo/app/k;", "(Lbo/app/k;)V", "sdkAuthSignature", "k", "userId", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "Lcom/braze/enums/MetadataTags;", "sdkMetadata", "Ljava/util/EnumSet;", "i", "()Ljava/util/EnumSet;", "(Ljava/util/EnumSet;)V", "Lbo/app/w1;", "m", "()Lbo/app/w1;", "backoffStateProvider", "()Z", "containsNoNewData", "doesSendOptionalData", "Z", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "getPayload$annotations", "()V", "payload", "Lbo/app/v4;", "h", "()Lbo/app/v4;", "target", "requestTarget", "<init>", "(Lbo/app/v4;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class r extends q4 implements c2 {

    /* renamed from: q  reason: collision with root package name */
    public static final a f39231q = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private Long f39232b;

    /* renamed from: c  reason: collision with root package name */
    private String f39233c;

    /* renamed from: d  reason: collision with root package name */
    private String f39234d;

    /* renamed from: e  reason: collision with root package name */
    private String f39235e;

    /* renamed from: f  reason: collision with root package name */
    private j0 f39236f;

    /* renamed from: g  reason: collision with root package name */
    private String f39237g;

    /* renamed from: h  reason: collision with root package name */
    private String f39238h;

    /* renamed from: i  reason: collision with root package name */
    private SdkFlavor f39239i;

    /* renamed from: j  reason: collision with root package name */
    private b4 f39240j;

    /* renamed from: k  reason: collision with root package name */
    private a4 f39241k;

    /* renamed from: l  reason: collision with root package name */
    private k f39242l;

    /* renamed from: m  reason: collision with root package name */
    private String f39243m;

    /* renamed from: n  reason: collision with root package name */
    private String f39244n;

    /* renamed from: o  reason: collision with root package name */
    private EnumSet<BrazeSdkMetadata> f39245o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f39246p;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\t\u0010\u0004\u0012\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\f\u0010\u0004\u0012\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u0012\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004¨\u0006\u001d"}, d2 = {"Lbo/app/r$a;", "", "", "API_KEY_REQUEST_PARAMETER_KEY", "Ljava/lang/String;", "ATTRIBUTES_OBJECT_KEY", "", "BACKOFF_DURATION", "J", "BRAZE_API_KEY_REQUEST_HEADER", "getBRAZE_API_KEY_REQUEST_HEADER$annotations", "()V", "BRAZE_DATA_REQUEST_HEADER", "getBRAZE_DATA_REQUEST_HEADER$annotations", "BRAZE_REQUEST_HEADER_ENABLED_VALUE", "getBRAZE_REQUEST_HEADER_ENABLED_VALUE$annotations", "BRAZE_SDK_AUTH_TOKEN_HEADER", "getBRAZE_SDK_AUTH_TOKEN_HEADER$annotations", "DEVICE_ID_REQUEST_PARAMETER_KEY", "DEVICE_KEY", "EVENTS_ARRAY_KEY", "HOST_APP_SEMANTIC_VERSION_CODE_KEY", "HOST_APP_VERSION_PARAMETER_KEY", "REQUEST_INITIATION_TIMESTAMP_REQUEST_PARAMETER_KEY", "RESPOND_WITH_KEY", "SDK_FLAVOR_KEY", "SDK_METADATA_KEY", "SDK_VERSION_REQUEST_PARAMETER_KEY", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f39247b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger dispatch completed. Alerting subscribers.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39248b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f39248b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Error occurred while executing Braze request: ", this.f39248b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39249b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "******************************************************************";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39250b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                        !! WARNING !!                         **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39251b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**  The current API key/endpoint combination is invalid. This   **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f39252b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "** is potentially an integration error. Please ensure that your **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39253b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**     API key AND custom endpoint information are correct.     **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f39254b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(r rVar) {
            super(0);
            this.f39254b = rVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus(">> API key    : ", this.f39254b.n());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f39255b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(r rVar) {
            super(0);
            this.f39255b = rVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus(">> Request Uri: ", this.f39255b.h());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f39256b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "******************************************************************";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f39257b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(v4 v4Var) {
        super(v4Var);
        Intrinsics.checkNotNullParameter(v4Var, "requestTarget");
    }

    public void a(Long l11) {
        this.f39232b = l11;
    }

    public boolean a(q2 q2Var) {
        Intrinsics.checkNotNullParameter(q2Var, "responseError");
        return false;
    }

    public void b(String str) {
        this.f39233c = str;
    }

    public void c(String str) {
        this.f39237g = str;
    }

    public b4 d() {
        return this.f39240j;
    }

    public void e(String str) {
        this.f39238h = str;
    }

    public void f(String str) {
        this.f39234d = str;
    }

    public void g(String str) {
        this.f39235e = str;
    }

    public v4 h() {
        return new v4(Braze.Companion.getApiEndpoint(this.f39225a.a()));
    }

    public EnumSet<BrazeSdkMetadata> i() {
        return this.f39245o;
    }

    public Long j() {
        return this.f39232b;
    }

    public String k() {
        return this.f39243m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b7 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c7 A[Catch:{ JSONException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8 A[Catch:{ JSONException -> 0x00d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject l() {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r9.o()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "device_id"
            java.lang.String r2 = r9.o()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0014:
            java.lang.Long r1 = r9.j()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = "time"
            java.lang.Long r2 = r9.j()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0023:
            java.lang.String r1 = r9.n()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "api_key"
            java.lang.String r2 = r9.n()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0032:
            java.lang.String r1 = r9.s()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = "sdk_version"
            java.lang.String r2 = r9.s()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0041:
            java.lang.String r1 = r9.q()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "app_version"
            java.lang.String r2 = r9.q()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0050:
            java.lang.String r1 = r9.p()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x005f
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)     // Catch:{ JSONException -> 0x00d4 }
            if (r1 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r1 = 0
            goto L_0x0060
        L_0x005f:
            r1 = 1
        L_0x0060:
            if (r1 != 0) goto L_0x006b
            java.lang.String r1 = "app_version_code"
            java.lang.String r2 = r9.p()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00d4 }
        L_0x006b:
            bo.app.j0 r1 = r9.f()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 != 0) goto L_0x0072
            goto L_0x0081
        L_0x0072:
            boolean r2 = r1.e()     // Catch:{ JSONException -> 0x00d4 }
            if (r2 != 0) goto L_0x0081
            java.lang.String r2 = "device"
            org.json.JSONObject r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0081:
            bo.app.b4 r1 = r9.d()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 != 0) goto L_0x0088
            goto L_0x0097
        L_0x0088:
            boolean r2 = r1.e()     // Catch:{ JSONException -> 0x00d4 }
            if (r2 != 0) goto L_0x0097
            java.lang.String r2 = "attributes"
            org.json.JSONArray r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d4 }
        L_0x0097:
            bo.app.k r1 = r9.e()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 != 0) goto L_0x009e
            goto L_0x00b1
        L_0x009e:
            boolean r2 = r1.e()     // Catch:{ JSONException -> 0x00d4 }
            if (r2 != 0) goto L_0x00b1
            java.lang.String r2 = "events"
            java.util.Set r1 = r1.b()     // Catch:{ JSONException -> 0x00d4 }
            org.json.JSONArray r1 = com.braze.support.JsonUtils.constructJsonArray(r1)     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d4 }
        L_0x00b1:
            com.appboy.enums.SdkFlavor r1 = r9.r()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c1
        L_0x00b8:
            java.lang.String r2 = "sdk_flavor"
            java.lang.String r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d4 }
        L_0x00c1:
            java.util.EnumSet r1 = r9.i()     // Catch:{ JSONException -> 0x00d4 }
            if (r1 != 0) goto L_0x00c8
            goto L_0x00d3
        L_0x00c8:
            java.lang.String r2 = "sdk_metadata"
            com.braze.enums.BrazeSdkMetadata$a r3 = com.braze.enums.BrazeSdkMetadata.Companion     // Catch:{ JSONException -> 0x00d4 }
            org.json.JSONArray r1 = r3.a(r1)     // Catch:{ JSONException -> 0x00d4 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00d4 }
        L_0x00d3:
            return r0
        L_0x00d4:
            r0 = move-exception
            r4 = r0
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.r$l r6 = bo.app.r.l.f39257b
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.r.l():org.json.JSONObject");
    }

    public w1 m() {
        return new d1((int) TimeUnit.MINUTES.toMillis(5), 0, 2, (DefaultConstructorMarker) null);
    }

    public String n() {
        return this.f39234d;
    }

    public String o() {
        return this.f39233c;
    }

    public String p() {
        return this.f39238h;
    }

    public String q() {
        return this.f39237g;
    }

    public SdkFlavor r() {
        return this.f39239i;
    }

    public String s() {
        return this.f39235e;
    }

    public String toString() {
        return JsonUtils.getPrettyPrintedString(l());
    }

    public void a(j0 j0Var) {
        this.f39236f = j0Var;
    }

    public boolean b() {
        ArrayList<i2> arrayList = new ArrayList<>();
        arrayList.add(f());
        arrayList.add(d());
        arrayList.add(e());
        for (i2 i2Var : arrayList) {
            if (i2Var != null && !i2Var.e()) {
                return false;
            }
        }
        return true;
    }

    public a4 c() {
        return this.f39241k;
    }

    public void d(String str) {
        this.f39243m = str;
    }

    public k e() {
        return this.f39242l;
    }

    public j0 f() {
        return this.f39236f;
    }

    public boolean g() {
        return this.f39246p;
    }

    public void a(SdkFlavor sdkFlavor) {
        this.f39239i = sdkFlavor;
    }

    public void a(b4 b4Var) {
        this.f39240j = b4Var;
    }

    public void a(k kVar) {
        this.f39242l = kVar;
    }

    public String a() {
        return this.f39244n;
    }

    public void a(String str) {
        this.f39244n = str;
    }

    public void a(EnumSet<BrazeSdkMetadata> enumSet) {
        this.f39245o = enumSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r0.y() == true) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(bo.app.j2 r11) {
        /*
            r10 = this;
            java.lang.String r0 = "internalPublisher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            bo.app.a4 r0 = r10.c()
            if (r0 != 0) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            boolean r0 = r0.y()
            r1 = 1
            if (r0 != r1) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x002e
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.r$b r7 = bo.app.r.b.f39247b
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 7
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            bo.app.e6 r0 = new bo.app.e6
            r0.<init>(r10)
            java.lang.Class<bo.app.e6> r1 = bo.app.e6.class
            r11.a(r0, r1)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.r.b(bo.app.j2):void");
    }

    public void a(j2 j2Var, j2 j2Var2, q2 q2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(q2Var, "responseError");
        String a11 = q2Var.a();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new c(a11), 6, (Object) null);
        if (q2Var instanceof k3) {
            j2Var.a(q2Var, k3.class);
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority2 = priority;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) d.f39249b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) e.f39250b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) f.f39251b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) g.f39252b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) h.f39253b, 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) new i(this), 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) new j(this), 6, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, false, (Function0) k.f39256b, 6, (Object) null);
        }
        if (q2Var instanceof x4) {
            j2Var2.a(new BrazeSdkAuthenticationErrorEvent((x4) q2Var), BrazeSdkAuthenticationErrorEvent.class);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r0.y() == true) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(bo.app.j2 r3) {
        /*
            r2 = this;
            java.lang.String r0 = "internalPublisher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            bo.app.a4 r0 = r2.c()
            if (r0 != 0) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            boolean r0 = r0.y()
            r1 = 1
            if (r0 != r1) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x0021
            bo.app.f6 r0 = new bo.app.f6
            r0.<init>(r2)
            java.lang.Class<bo.app.f6> r1 = bo.app.f6.class
            r3.a(r0, r1)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.r.a(bo.app.j2):void");
    }

    public void a(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        map.put("X-Braze-Api-Key", n());
        String k11 = k();
        if (!(k11 == null || k11.length() == 0)) {
            map.put("X-Braze-Auth-Signature", k());
        }
    }
}
