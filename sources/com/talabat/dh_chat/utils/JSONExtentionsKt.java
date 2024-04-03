package com.talabat.dh_chat.utils;

import androidx.autofill.HintConstants;
import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.contract.model.ChatDetails;
import com.deliveryhero.contract.model.ChatPushData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005*\u00020\u0007\u001a\u0018\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005*\u00020\b\u001a\u0018\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005*\u00020\t\u001a\u0018\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005*\u00020\n\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u000b\u001a\u0018\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005*\u00020\f\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\r¨\u0006\u000e"}, d2 = {"toList", "", "", "Lorg/json/JSONArray;", "toMap", "", "", "Lcom/deliveryhero/chatui/data/event/Event;", "Lcom/deliveryhero/chatui/data/event/Event$Call;", "Lcom/deliveryhero/chatui/data/event/Event$QuickReplyMessageSent;", "Lcom/deliveryhero/chatui/data/event/Event$Translation;", "Lcom/deliveryhero/contract/model/ChatDetails;", "Lcom/deliveryhero/contract/model/ChatPushData;", "Lorg/json/JSONObject;", "dh_chat_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JSONExtentionsKt {
    @NotNull
    public static final List<Object> toList(@NotNull JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = jSONArray.get(i11);
            Intrinsics.checkNotNullExpressionValue(obj, "this[i]");
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            Intrinsics.checkNotNullExpressionValue(obj, "this.get(key)");
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            linkedHashMap.put(next, obj);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, String> toMap(@NotNull ChatPushData chatPushData) {
        Intrinsics.checkNotNullParameter(chatPushData, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("channelID", chatPushData.getChannelID()), TuplesKt.to("country", chatPushData.getCountry()), TuplesKt.to("message", chatPushData.getMessage()), TuplesKt.to("orderID", chatPushData.getOrderID()), TuplesKt.to("pushAlert", chatPushData.getPushAlert()), TuplesKt.to("pushID", chatPushData.getPushID()), TuplesKt.to("senderName", chatPushData.getSenderName()));
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull ChatDetails chatDetails) {
        Intrinsics.checkNotNullParameter(chatDetails, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", chatDetails.getId()), TuplesKt.to("unreadCount", Integer.valueOf(chatDetails.getUnreadCount())), TuplesKt.to("hasUnRepliedMessage", Boolean.valueOf(chatDetails.getHasUnRepliedMessage())));
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", event.getName()));
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull Event.QuickReplyMessageSent quickReplyMessageSent) {
        Intrinsics.checkNotNullParameter(quickReplyMessageSent, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("name", quickReplyMessageSent.getName()), TuplesKt.to("selectedReply", quickReplyMessageSent.getSelectedReply()));
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull Event.Translation translation) {
        Intrinsics.checkNotNullParameter(translation, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("name", translation.getName()), TuplesKt.to("enable", Boolean.valueOf(translation.getEnable())));
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull Event.Call call) {
        Intrinsics.checkNotNullParameter(call, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("name", call.getName()), TuplesKt.to(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, call.getPhoneNumber()));
    }
}
