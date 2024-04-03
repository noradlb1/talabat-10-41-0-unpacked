package com.talabat.firebase;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u00030\u0006j\u0006\u0012\u0002\b\u0003`\u0007¨\u0006\b"}, d2 = {"putListOfMapElements", "", "Landroid/os/Bundle;", "key", "", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "com_talabat_ThirdPartyLibs_Firebase_Firebase"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FirebaseKt {
    public static final void putListOfMapElements(@NotNull Bundle bundle, @NotNull String str, @NotNull ArrayList<?> arrayList) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(arrayList, "value");
        boolean z11 = true;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!(it.next() instanceof Map)) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z11) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Bundle bundle2 = new Bundle();
                for (Map.Entry entry : ((Map) it2.next()).entrySet()) {
                    bundle2.putString(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
                arrayList2.add(bundle2);
            }
            bundle.putParcelableArrayList(str, arrayList2);
            return;
        }
        bundle.putString(str, arrayList.toString());
    }
}
