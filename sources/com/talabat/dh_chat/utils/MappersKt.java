package com.talabat.dh_chat.utils;

import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, d2 = {"parseDeliveryInfo", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "json", "Lorg/json/JSONObject;", "parseTranslations", "Lcom/deliveryhero/contract/model/Translations;", "parseUserInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "dh_chat_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MappersKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.lang.Number} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.deliveryhero.contract.model.DeliveryInfo parseDeliveryInfo(@org.jetbrains.annotations.NotNull org.json.JSONObject r13) throws java.lang.Exception {
        /*
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "id"
            java.lang.Object r1 = r13.get(r0)
            boolean r2 = r1 instanceof java.lang.Long
            r3 = 0
            if (r2 == 0) goto L_0x0013
            java.lang.Long r1 = (java.lang.Long) r1
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            if (r1 != 0) goto L_0x0023
            java.lang.Object r0 = r13.get(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0022
            r1 = r0
            java.lang.Integer r1 = (java.lang.Integer) r1
            goto L_0x0023
        L_0x0022:
            r1 = r3
        L_0x0023:
            if (r1 == 0) goto L_0x002e
            long r0 = r1.longValue()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x002f
        L_0x002e:
            r0 = r3
        L_0x002f:
            java.lang.String r1 = "code"
            java.lang.Object r1 = r13.opt(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x003d
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x003e
        L_0x003d:
            r7 = r3
        L_0x003e:
            java.lang.String r1 = "amount"
            java.lang.Object r1 = r13.opt(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x004c
            java.lang.String r1 = (java.lang.String) r1
            r8 = r1
            goto L_0x004d
        L_0x004c:
            r8 = r3
        L_0x004d:
            java.lang.String r1 = "address"
            java.lang.Object r1 = r13.opt(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x005b
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            goto L_0x005c
        L_0x005b:
            r9 = r3
        L_0x005c:
            java.lang.String r1 = "comments"
            java.lang.Object r1 = r13.opt(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x006a
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            goto L_0x006b
        L_0x006a:
            r10 = r3
        L_0x006b:
            java.lang.String r1 = "customer"
            java.lang.Object r1 = r13.opt(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0079
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            goto L_0x007a
        L_0x0079:
            r11 = r3
        L_0x007a:
            java.lang.String r1 = "phoneNumber"
            java.lang.Object r13 = r13.opt(r1)
            boolean r1 = r13 instanceof java.lang.String
            if (r1 == 0) goto L_0x0087
            r3 = r13
            java.lang.String r3 = (java.lang.String) r3
        L_0x0087:
            r12 = r3
            com.deliveryhero.contract.model.DeliveryInfo r13 = new com.deliveryhero.contract.model.DeliveryInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r5 = r0.longValue()
            r4 = r13
            r4.<init>(r5, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.dh_chat.utils.MappersKt.parseDeliveryInfo(org.json.JSONObject):com.deliveryhero.contract.model.DeliveryInfo");
    }

    @NotNull
    public static final Translations parseTranslations(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return Translations.DISABLED.INSTANCE;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("supportedTranslations");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "json.getJSONArray(\"supportedTranslations\")");
        Iterable<Object> list = JSONExtentionsKt.toList(jSONArray);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Object obj : list) {
            arrayList.add(obj.toString());
        }
        String string = jSONObject.getString("preferredLanguage");
        boolean z11 = jSONObject.getBoolean("showOriginalWithTranslated");
        Intrinsics.checkNotNullExpressionValue(string, "preferredLanguage");
        return new Translations.ENABLED(arrayList, string, z11);
    }

    @NotNull
    public static final UserInfo parseUserInfo(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String string = jSONObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"id\")");
        String string2 = jSONObject.getString("dhAuthToken");
        Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"dhAuthToken\")");
        return new UserInfo(string, string2);
    }
}
