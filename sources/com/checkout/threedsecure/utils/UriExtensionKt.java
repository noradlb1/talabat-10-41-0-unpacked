package com.checkout.threedsecure.utils;

import android.net.Uri;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\r"}, d2 = {"checkBase", "", "expected", "Landroid/net/Uri;", "target", "checkQuery", "getBase", "", "uri", "getQueryParameters", "", "matches", "targetUri", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UriExtensionKt {
    private static final boolean checkBase(Uri uri, Uri uri2) {
        return Intrinsics.areEqual((Object) getBase(uri), (Object) getBase(uri2));
    }

    private static final boolean checkQuery(Uri uri, Uri uri2) {
        Set<String> queryParameters = getQueryParameters(uri);
        Set<String> queryParameters2 = getQueryParameters(uri2);
        for (String contains : queryParameters) {
            if (!queryParameters2.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    private static final String getBase(Uri uri) {
        String query = uri.getQuery();
        if (query == null) {
            query = "";
        }
        if (StringsKt__StringsJVMKt.isBlank(query)) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return uri2;
        }
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
        return StringsKt__StringsJVMKt.replace$default(uri3, TypeDescription.Generic.OfWildcardType.SYMBOL + query, "", false, 4, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.toSet((r6 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, new java.lang.String[]{com.huawei.hms.framework.common.ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (java.lang.Object) null)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.Set<java.lang.String> getQueryParameters(android.net.Uri r6) {
        /*
            java.lang.String r0 = r6.getQuery()
            if (r0 == 0) goto L_0x001e
            java.lang.String r6 = "&"
            java.lang.String[] r1 = new java.lang.String[]{r6}
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.util.List r6 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            if (r6 == 0) goto L_0x001e
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r6 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r6)
            if (r6 != 0) goto L_0x0022
        L_0x001e:
            java.util.Set r6 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x0022:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.threedsecure.utils.UriExtensionKt.getQueryParameters(android.net.Uri):java.util.Set");
    }

    public static final boolean matches(@Nullable Uri uri, @Nullable Uri uri2) {
        return uri != null && uri2 != null && checkBase(uri, uri2) && checkQuery(uri, uri2);
    }
}
