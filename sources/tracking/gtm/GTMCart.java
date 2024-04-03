package tracking.gtm;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Ltracking/gtm/GTMCart;", "", "()V", "talabatFirebaseWrapper", "Ltracking/gtm/TalabatFirebaseWrapper;", "getTalabatFirebaseWrapper", "()Ltracking/gtm/TalabatFirebaseWrapper;", "setTalabatFirebaseWrapper", "(Ltracking/gtm/TalabatFirebaseWrapper;)V", "cartClicked", "", "screenName", "", "screenType", "shopId", "shopName", "shopClickOrigin", "shopType", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GTMCart {
    @NotNull
    public static final GTMCart INSTANCE = new GTMCart();
    @NotNull
    private static TalabatFirebaseWrapper talabatFirebaseWrapper = new TalabatFirebaseWrapper();

    private GTMCart() {
    }

    public final void cartClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "shopId");
        Intrinsics.checkNotNullParameter(str4, "shopName");
        Intrinsics.checkNotNullParameter(str5, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(str6, "shopType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(TalabatGTMCommon.INSTANCE.addLocationProperties());
        linkedHashMap.put("screenType", str2);
        linkedHashMap.put("screenName", str);
        linkedHashMap.put("shopID", str3);
        linkedHashMap.put("shopName", str4);
        linkedHashMap.put("shopClickOrigin", str5);
        linkedHashMap.put("shopType", str6);
        talabatFirebaseWrapper.dispatchEvent("cart_clicked", linkedHashMap);
    }

    @NotNull
    public final TalabatFirebaseWrapper getTalabatFirebaseWrapper() {
        return talabatFirebaseWrapper;
    }

    public final void setTalabatFirebaseWrapper(@NotNull TalabatFirebaseWrapper talabatFirebaseWrapper2) {
        Intrinsics.checkNotNullParameter(talabatFirebaseWrapper2, "<set-?>");
        talabatFirebaseWrapper = talabatFirebaseWrapper2;
    }
}
