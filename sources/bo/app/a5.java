package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.support.StringUtils;
import com.visa.checkout.Profile;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004J&\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¨\u0006\u0011"}, d2 = {"Lbo/app/a5;", "", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "Lcom/braze/enums/MetadataTags;", "sdkMetadata", "", "a", "newSdkMetadata", "b", "Landroid/content/Context;", "context", "", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class a5 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f38277b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f38278a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/a5$a;", "", "", "DATA_KEY", "Ljava/lang/String;", "STORAGE_PREFIX", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.braze.storage.sdk_metadata_cache", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f38278a = sharedPreferences;
    }

    public final void a(EnumSet<BrazeSdkMetadata> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "sdkMetadata");
        this.f38278a.edit().putStringSet("tags", u0.a(enumSet)).apply();
    }

    public final EnumSet<BrazeSdkMetadata> b(EnumSet<BrazeSdkMetadata> enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "newSdkMetadata");
        if (Intrinsics.areEqual((Object) u0.a(enumSet), (Object) this.f38278a.getStringSet("tags", SetsKt__SetsKt.emptySet()))) {
            return null;
        }
        return enumSet;
    }
}
