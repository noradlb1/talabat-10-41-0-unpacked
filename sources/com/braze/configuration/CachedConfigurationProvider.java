package com.braze.configuration;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appboy.support.PackageUtils;
import com.braze.support.BrazeLogger;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\b\u0017\u0018\u0000 02\u00020\u0001:\u000212B%\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006J\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0004J$\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0004J$\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0004J$\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J$\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0007R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R%\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/braze/configuration/CachedConfigurationProvider;", "", "", "key", "Lcom/braze/configuration/CachedConfigurationProvider$b;", "resourceType", "", "getResourceIdentifier", "getFallbackConfigKey", "primaryKey", "", "defaultValue", "getBooleanValue", "getStringValue", "getIntValue", "getColorValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getStringSetValue", "getDrawableValue", "type", "getRuntimeConfigurationValue", "getResourceConfigurationValue", "getConfigurationValue", "readResourceValue", "resourceId", "getValueFromResources", "Landroid/content/Context;", "context", "Landroid/content/Context;", "shouldUseConfigurationCache", "Z", "Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "runtimeAppConfigurationProvider", "Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "getRuntimeAppConfigurationProvider", "()Lcom/braze/configuration/RuntimeAppConfigurationProvider;", "setRuntimeAppConfigurationProvider", "(Lcom/braze/configuration/RuntimeAppConfigurationProvider;)V", "", "configurationCache", "Ljava/util/Map;", "getConfigurationCache", "()Ljava/util/Map;", "resourcePackageName", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;ZLcom/braze/configuration/RuntimeAppConfigurationProvider;)V", "Companion", "a", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class CachedConfigurationProvider {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final int MISSING_RESOURCE_IDENTIFIER = 0;
    private final Map<String, Object> configurationCache;
    private Context context;
    private final String resourcePackageName;
    private RuntimeAppConfigurationProvider runtimeAppConfigurationProvider;
    private boolean shouldUseConfigurationCache;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/braze/configuration/CachedConfigurationProvider$a;", "", "", "MISSING_RESOURCE_IDENTIFIER", "I", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/braze/configuration/CachedConfigurationProvider$b;", "", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public enum b {
        INTEGER(TypedValues.Custom.S_INT),
        COLOR("color"),
        BOOLEAN("bool"),
        STRING(TypedValues.Custom.S_STRING),
        DRAWABLE_IDENTIFIER("drawable"),
        STRING_ARRAY("array");
        

        /* renamed from: b  reason: collision with root package name */
        private final String f43704b;

        private b(String str) {
            this.f43704b = str;
        }

        public final String b() {
            return this.f43704b;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43705a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.BOOLEAN.ordinal()] = 1;
            iArr[b.STRING.ordinal()] = 2;
            iArr[b.STRING_ARRAY.ordinal()] = 3;
            iArr[b.INTEGER.ordinal()] = 4;
            iArr[b.COLOR.ordinal()] = 5;
            iArr[b.DRAWABLE_IDENTIFIER.ordinal()] = 6;
            f43705a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f43707h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, Object obj) {
            super(0);
            this.f43706g = str;
            this.f43707h = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using resources value for key: '" + this.f43706g + "' and value: '" + this.f43707h + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43708g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f43709h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, Object obj) {
            super(0);
            this.f43708g = str;
            this.f43709h = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using runtime override value for key: '" + this.f43708g + "' and value: '" + this.f43709h + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43710g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f43711h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, Object obj) {
            super(0);
            this.f43710g = str;
            this.f43711h = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Primary key '" + this.f43710g + "' had no identifier. No secondary key to read resource value. Returning default value: '" + this.f43711h + '\'';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f43712b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception retrieving resource value";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f43713g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43714h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Object f43715i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(b bVar, String str, Object obj) {
            super(0);
            this.f43713g = bVar;
            this.f43714h = str;
            this.f43715i = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to find the xml " + this.f43713g + " configuration value with primary key '" + this.f43714h + "'.Using default value '" + this.f43715i + "'.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CachedConfigurationProvider(Context context2) {
        this(context2, false, (RuntimeAppConfigurationProvider) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CachedConfigurationProvider(Context context2, boolean z11) {
        this(context2, z11, (RuntimeAppConfigurationProvider) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    public CachedConfigurationProvider(Context context2, boolean z11, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(runtimeAppConfigurationProvider2, "runtimeAppConfigurationProvider");
        this.context = context2;
        this.shouldUseConfigurationCache = z11;
        this.runtimeAppConfigurationProvider = runtimeAppConfigurationProvider2;
        Map<String, Object> synchronizedMap = DesugarCollections.synchronizedMap(new HashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(HashMap())");
        this.configurationCache = synchronizedMap;
        String resourcePackageName2 = PackageUtils.getResourcePackageName(this.context);
        Intrinsics.checkNotNullExpressionValue(resourcePackageName2, "getResourcePackageName(context)");
        this.resourcePackageName = resourcePackageName2;
    }

    private final String getFallbackConfigKey(String str) {
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "braze", false, 2, (Object) null)) {
            return StringsKt__StringsJVMKt.replace$default(str, "braze", "appboy", false, 4, (Object) null);
        }
        return null;
    }

    private final int getResourceIdentifier(String str, b bVar) {
        if (str == null) {
            return 0;
        }
        return this.context.getResources().getIdentifier(str, bVar.b(), this.resourcePackageName);
    }

    public final boolean getBooleanValue(String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.BOOLEAN, str, Boolean.valueOf(z11));
        if (configurationValue != null) {
            return ((Boolean) configurationValue).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final Integer getColorValue(String str) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        return (Integer) getConfigurationValue(b.COLOR, str, (Object) null);
    }

    public final Map<String, Object> getConfigurationCache() {
        return this.configurationCache;
    }

    public final Object getConfigurationValue(b bVar, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        if (this.shouldUseConfigurationCache && this.configurationCache.containsKey(str)) {
            return this.configurationCache.get(str);
        }
        if (this.runtimeAppConfigurationProvider.containsKey(str)) {
            return getRuntimeConfigurationValue(bVar, str, obj);
        }
        return getResourceConfigurationValue(bVar, str, obj);
    }

    public final int getDrawableValue(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.DRAWABLE_IDENTIFIER, str, Integer.valueOf(i11));
        if (configurationValue != null) {
            return ((Integer) configurationValue).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int getIntValue(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.INTEGER, str, Integer.valueOf(i11));
        if (configurationValue != null) {
            return ((Integer) configurationValue).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final Object getResourceConfigurationValue(b bVar, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        Object readResourceValue = readResourceValue(bVar, str, obj);
        this.configurationCache.put(str, readResourceValue);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str, readResourceValue), 7, (Object) null);
        return readResourceValue;
    }

    public final RuntimeAppConfigurationProvider getRuntimeAppConfigurationProvider() {
        return this.runtimeAppConfigurationProvider;
    }

    public final Object getRuntimeConfigurationValue(b bVar, String str, Object obj) {
        Object obj2;
        int i11;
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        switch (c.f43705a[bVar.ordinal()]) {
            case 1:
                RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2 = this.runtimeAppConfigurationProvider;
                if (obj != null) {
                    obj2 = Boolean.valueOf(runtimeAppConfigurationProvider2.getBooleanValue(str, ((Boolean) obj).booleanValue()));
                    break;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            case 2:
                obj2 = this.runtimeAppConfigurationProvider.getStringValue(str, (String) obj);
                break;
            case 3:
                RuntimeAppConfigurationProvider runtimeAppConfigurationProvider3 = this.runtimeAppConfigurationProvider;
                if (obj != null) {
                    obj2 = runtimeAppConfigurationProvider3.getStringSetValue(str, (Set) obj);
                    break;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String?>");
                }
            case 4:
            case 5:
                if (obj == null) {
                    i11 = this.runtimeAppConfigurationProvider.getIntValue(str, 0);
                } else {
                    i11 = this.runtimeAppConfigurationProvider.getIntValue(str, ((Integer) obj).intValue());
                }
                obj2 = Integer.valueOf(i11);
                break;
            case 6:
                obj2 = Integer.valueOf(getResourceIdentifier(this.runtimeAppConfigurationProvider.getStringValue(str, ""), b.DRAWABLE_IDENTIFIER));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.configurationCache.put(str, obj2);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(str, obj2), 7, (Object) null);
        return obj2;
    }

    public final Set<String> getStringSetValue(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        Object configurationValue = getConfigurationValue(b.STRING_ARRAY, str, set);
        if (configurationValue == null) {
            return set;
        }
        return (Set) configurationValue;
    }

    public final String getStringValue(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "primaryKey");
        return (String) getConfigurationValue(b.STRING, str, str2);
    }

    public final Object getValueFromResources(b bVar, int i11) {
        Intrinsics.checkNotNullParameter(bVar, "type");
        Resources resources = this.context.getResources();
        switch (c.f43705a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(resources.getBoolean(i11));
            case 2:
                String string = resources.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(resourceId)");
                return string;
            case 3:
                String[] stringArray = resources.getStringArray(i11);
                Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(resourceId)");
                return new HashSet(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(stringArray, stringArray.length)));
            case 4:
                return Integer.valueOf(resources.getInteger(i11));
            case 5:
                return Integer.valueOf(resources.getColor(i11));
            case 6:
                return Integer.valueOf(i11);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Object readResourceValue(b bVar, String str, Object obj) {
        b bVar2 = bVar;
        String str2 = str;
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(bVar, "type");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            int resourceIdentifier = getResourceIdentifier(str, bVar);
            if (resourceIdentifier != 0) {
                return getValueFromResources(bVar, resourceIdentifier);
            }
            String fallbackConfigKey = getFallbackConfigKey(str);
            if (fallbackConfigKey == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(str, obj2), 7, (Object) null);
                return obj2;
            }
            int resourceIdentifier2 = getResourceIdentifier(fallbackConfigKey, bVar);
            if (resourceIdentifier2 != 0) {
                return getValueFromResources(bVar, resourceIdentifier2);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(bVar, str, obj2), 7, (Object) null);
            return obj2;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) g.f43712b, 4, (Object) null);
        }
    }

    public final void setRuntimeAppConfigurationProvider(RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2) {
        Intrinsics.checkNotNullParameter(runtimeAppConfigurationProvider2, "<set-?>");
        this.runtimeAppConfigurationProvider = runtimeAppConfigurationProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CachedConfigurationProvider(Context context2, boolean z11, RuntimeAppConfigurationProvider runtimeAppConfigurationProvider2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? new RuntimeAppConfigurationProvider(context2) : runtimeAppConfigurationProvider2);
    }
}
