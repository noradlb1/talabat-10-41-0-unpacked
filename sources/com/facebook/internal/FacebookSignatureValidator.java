package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FacebookSignatureValidator;", "", "()V", "FBF_HASH", "", "FBI_HASH", "FBL_HASH", "FBR2_HASH", "FBR_HASH", "IGR_HASH", "MSR_HASH", "validAppSignatureHashes", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "validateSignature", "", "context", "Landroid/content/Context;", "packageName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookSignatureValidator {
    @NotNull
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    @NotNull
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    @NotNull
    private static final String FBL_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    @NotNull
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    @NotNull
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    @NotNull
    private static final String IGR_HASH = "c56fb7d591ba6704df047fd98f535372fea00211";
    @NotNull
    public static final FacebookSignatureValidator INSTANCE = new FacebookSignatureValidator();
    @NotNull
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    @NotNull
    private static final HashSet<String> validAppSignatureHashes = SetsKt__SetsKt.hashSetOf(FBR_HASH, FBR2_HASH, FBI_HASH, FBL_HASH, MSR_HASH, FBF_HASH, IGR_HASH);

    private FacebookSignatureValidator() {
    }

    @JvmStatic
    public static final boolean validateSignature(@NotNull Context context, @NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        String str2 = Build.BRAND;
        int i11 = context.getApplicationInfo().flags;
        Intrinsics.checkNotNullExpressionValue(str2, ScreenNames.SCREEN_TYPE_BRAND);
        if (StringsKt__StringsJVMKt.startsWith$default(str2, "generic", false, 2, (Object) null) && (i11 & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
            if (signatureArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return false;
            }
            Signature[] signatureArr2 = packageInfo.signatures;
            Intrinsics.checkNotNullExpressionValue(signatureArr2, "packageInfo.signatures");
            for (Signature byteArray : signatureArr2) {
                HashSet<String> hashSet = validAppSignatureHashes;
                Utility utility = Utility.INSTANCE;
                byte[] byteArray2 = byteArray.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray2, "it.toByteArray()");
                if (!CollectionsKt___CollectionsKt.contains(hashSet, Utility.sha1hash(byteArray2))) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
