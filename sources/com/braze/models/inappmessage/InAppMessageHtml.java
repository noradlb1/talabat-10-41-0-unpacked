package com.braze.models.inappmessage;

import bo.app.b2;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 $2\u00020\u0001:\u0001%B\t\b\u0016¢\u0006\u0004\b\u001d\u0010\u001eB\u0019\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001d\u0010\"B1\b\u0012\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u001d\u0010#J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageHtml;", "Lcom/braze/models/inappmessage/InAppMessageHtmlBase;", "", "", "remotePathToLocalAssetMap", "", "setLocalPrefetchedAssetPaths", "getLocalPrefetchedAssetPaths", "", "getRemoteAssetPathsForPrefetch", "Lorg/json/JSONObject;", "forJsonPut", "messageFields", "Lorg/json/JSONObject;", "getMessageFields", "()Lorg/json/JSONObject;", "setMessageFields", "(Lorg/json/JSONObject;)V", "Ljava/util/Map;", "assetUrls", "Ljava/util/List;", "getAssetUrls", "()Ljava/util/List;", "setAssetUrls", "(Ljava/util/List;)V", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "messageType", "<init>", "()V", "jsonObject", "Lbo/app/b2;", "brazeManager", "(Lorg/json/JSONObject;Lbo/app/b2;)V", "(Lorg/json/JSONObject;Lbo/app/b2;Lorg/json/JSONObject;Ljava/util/List;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class InAppMessageHtml extends InAppMessageHtmlBase {
    private static final String ASSET_URLS_KEY = "asset_urls";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String MESSAGE_FIELDS_KEY = "message_fields";
    private List<String> assetUrls;
    private JSONObject messageFields;
    private Map<String, String> remotePathToLocalAssetMap;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageHtml$a;", "", "", "ASSET_URLS_KEY", "Ljava/lang/String;", "MESSAGE_FIELDS_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InAppMessageHtml() {
        this.remotePathToLocalAssetMap = MapsKt__MapsKt.emptyMap();
        this.assetUrls = CollectionsKt__CollectionsKt.emptyList();
        this.messageFields = new JSONObject();
        this.assetUrls = CollectionsKt__CollectionsKt.emptyList();
    }

    public final List<String> getAssetUrls() {
        return this.assetUrls;
    }

    public Map<String, String> getLocalPrefetchedAssetPaths() {
        return this.remotePathToLocalAssetMap;
    }

    public final JSONObject getMessageFields() {
        return this.messageFields;
    }

    public MessageType getMessageType() {
        return MessageType.HTML;
    }

    public List<String> getRemoteAssetPathsForPrefetch() {
        return this.assetUrls;
    }

    public final void setAssetUrls(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.assetUrls = list;
    }

    public void setLocalPrefetchedAssetPaths(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remotePathToLocalAssetMap");
        this.remotePathToLocalAssetMap = map;
    }

    public final void setMessageFields(JSONObject jSONObject) {
        this.messageFields = jSONObject;
    }

    public JSONObject forJsonPut() {
        JSONObject jsonObject = getJsonObject();
        if (jsonObject == null) {
            jsonObject = super.forJsonPut();
            try {
                jsonObject.put("type", (Object) getMessageType().name());
            } catch (JSONException unused) {
            }
        }
        return jsonObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessageHtml(JSONObject jSONObject, b2 b2Var) {
        this(jSONObject, b2Var, jSONObject.optJSONObject(MESSAGE_FIELDS_KEY), JsonUtils.convertStringJsonArrayToList(jSONObject.optJSONArray(ASSET_URLS_KEY)));
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
    }

    private InAppMessageHtml(JSONObject jSONObject, b2 b2Var, JSONObject jSONObject2, List<String> list) {
        super(jSONObject, b2Var);
        this.remotePathToLocalAssetMap = MapsKt__MapsKt.emptyMap();
        List unused = CollectionsKt__CollectionsKt.emptyList();
        this.messageFields = jSONObject2;
        this.assetUrls = list;
    }
}
