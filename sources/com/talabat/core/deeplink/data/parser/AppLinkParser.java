package com.talabat.core.deeplink.data.parser;

import android.net.Uri;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import dagger.Reusable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/deeplink/data/parser/AppLinkParser;", "Lcom/talabat/core/deeplink/data/parser/LinkParser;", "()V", "extractPath", "", "", "", "uri", "Landroid/net/Uri;", "extractScreenNameFromPath", "segments", "parse", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "parseParameters", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class AppLinkParser implements LinkParser {
    private final Map<Integer, String> extractPath(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "uri.pathSegments");
        Iterable iterable = pathSegments;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i11), (String) next));
            i11 = i12;
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    private final String extractScreenNameFromPath(Map<Integer, String> map) {
        T t11;
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            t11 = null;
        } else {
            t11 = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Map.Entry) t11).getKey()).intValue();
                do {
                    T next = it.next();
                    int intValue2 = ((Number) ((Map.Entry) next).getKey()).intValue();
                    if (intValue < intValue2) {
                        t11 = next;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) t11;
        if (entry != null) {
            return (String) entry.getValue();
        }
        return null;
    }

    private final Map<String, String> parseParameters(Uri uri) {
        Pair pair;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(queryParameterNames, 10)), 16));
        for (T next : queryParameterNames) {
            linkedHashMap.put(next, uri.getQueryParameter((String) next));
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                pair = TuplesKt.to(str, str2);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    @NotNull
    public ParsedLinkModel parse(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Map<String, String> parseParameters = parseParameters(uri);
        Map<Integer, String> extractPath = extractPath(uri);
        String extractScreenNameFromPath = extractScreenNameFromPath(extractPath);
        if (extractScreenNameFromPath == null) {
            extractScreenNameFromPath = uri.toString();
            Intrinsics.checkNotNullExpressionValue(extractScreenNameFromPath, "uri.toString()");
        }
        return new ParsedLinkModel.AppLink(extractScreenNameFromPath, parseParameters, extractPath);
    }
}
