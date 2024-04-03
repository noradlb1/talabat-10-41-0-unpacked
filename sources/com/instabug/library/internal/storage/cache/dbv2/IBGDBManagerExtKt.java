package com.instabug.library.internal.storage.cache.dbv2;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IBGDBManagerExtKt {

    public static final class a extends Lambda implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f51034a = new a();

        public a() {
            super(1);
        }

        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(Object obj) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    @NotNull
    public static final String and(@NotNull String str, @Nullable String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str2 == null || (str3 = Intrinsics.stringPlus("And ", str2)) == null) {
            str3 = "";
        }
        return Intrinsics.stringPlus(str, str3);
    }

    @NotNull
    public static final List<IBGWhereArg> asArgs(@NotNull List<String> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String iBGWhereArg : list) {
            arrayList.add(new IBGWhereArg(iBGWhereArg, z11));
        }
        return arrayList;
    }

    public static /* synthetic */ List asArgs$default(List list, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return asArgs(list, z11);
    }

    @NotNull
    public static final List<IBGWhereArg> getArgs(@NotNull Pair<String, ? extends List<? extends IBGWhereArg>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return (List) pair.getSecond();
    }

    @NotNull
    public static final String getSelection(@NotNull Pair<String, ? extends List<? extends IBGWhereArg>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.getFirst();
    }

    @NotNull
    public static final <T> String joinToArgs(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, "(", ")", 0, (CharSequence) null, a.f51034a, 25, (Object) null);
    }

    public static final int kDelete(@NotNull IBGDbManager iBGDbManager, @NotNull String str, @Nullable String str2, @Nullable List<? extends IBGWhereArg> list) {
        Intrinsics.checkNotNullParameter(iBGDbManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "table");
        return iBGDbManager.delete(str, str2, list);
    }

    public static /* synthetic */ int kDelete$default(IBGDbManager iBGDbManager, String str, String str2, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            list = null;
        }
        return kDelete(iBGDbManager, str, str2, list);
    }

    @Nullable
    public static final IBGCursor kQuery(@NotNull IBGDbManager iBGDbManager, @NotNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Pair<String, ? extends List<? extends IBGWhereArg>> pair) {
        String str6;
        IBGDbManager iBGDbManager2 = iBGDbManager;
        Intrinsics.checkNotNullParameter(iBGDbManager, "<this>");
        String str7 = str;
        Intrinsics.checkNotNullParameter(str, "table");
        List<IBGWhereArg> list = null;
        if (pair == null) {
            str6 = null;
        } else {
            str6 = getSelection(pair);
        }
        if (pair != null) {
            list = getArgs(pair);
        }
        return iBGDbManager.query(str, strArr, str6, list, str2, str3, str4, str5);
    }

    public static /* synthetic */ IBGCursor kQuery$default(IBGDbManager iBGDbManager, String str, String[] strArr, String str2, String str3, String str4, String str5, Pair pair, int i11, Object obj) {
        Pair pair2 = null;
        String[] strArr2 = (i11 & 2) != 0 ? null : strArr;
        String str6 = (i11 & 4) != 0 ? null : str2;
        String str7 = (i11 & 8) != 0 ? null : str3;
        String str8 = (i11 & 16) != 0 ? null : str4;
        String str9 = (i11 & 32) != 0 ? null : str5;
        if ((i11 & 64) == 0) {
            pair2 = pair;
        }
        return kQuery(iBGDbManager, str, strArr2, str6, str7, str8, str9, pair2);
    }
}
