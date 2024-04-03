package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class zzdk {
    @NotNull
    public static final zzdk zza = new zzdk();
    @NotNull
    private static final List zzb = zzc(CollectionsKt__CollectionsKt.listOf("www.recaptcha.net", "www.gstatic.com/recaptcha"));

    private zzdk() {
    }

    public static final boolean zza(@NotNull Uri uri) {
        if (TextUtils.isEmpty(uri.toString()) || !Intrinsics.areEqual((Object) "https", (Object) uri.getScheme()) || TextUtils.isEmpty(uri.getHost()) || !zzb(uri.toString())) {
            return false;
        }
        return true;
    }

    private static final boolean zzb(String str) {
        List<String> list = zzb;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String startsWith$default : list) {
            if (StringsKt__StringsJVMKt.startsWith$default(str, startsWith$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private static final List zzc(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("https://" + ((String) it.next()) + "/");
        }
        return arrayList;
    }
}
