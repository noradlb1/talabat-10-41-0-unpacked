package com.talabat.core.deeplink.data.parser;

import android.net.Uri;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/deeplink/data/parser/DeepLinkParser;", "Lcom/talabat/core/deeplink/data/parser/LinkParser;", "()V", "parse", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "uri", "Landroid/net/Uri;", "parseParameters", "", "", "Companion", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkParser implements LinkParser {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String QUERY_PARAMETER_SCREEN = "s";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/deeplink/data/parser/DeepLinkParser$Companion;", "", "()V", "QUERY_PARAMETER_SCREEN", "", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
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
        String str = parseParameters.get("s");
        if (str != null) {
            return new ParsedLinkModel.DeepLink(str, parseParameters);
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return new ParsedLinkModel.DeepLink(uri2, MapsKt__MapsKt.emptyMap());
    }
}
