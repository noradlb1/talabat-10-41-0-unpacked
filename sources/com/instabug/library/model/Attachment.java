package com.instabug.library.model;

import android.annotation.SuppressLint;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Attachment implements Cacheable, Serializable {
    private static final String KEY_ENCRYPTED = "isEncrypted";
    @Nullable
    private AttachmentState attachmentState;
    @Nullable
    private String duration;

    /* renamed from: id  reason: collision with root package name */
    private long f51499id = -1;
    private boolean isEncrypted = false;
    private boolean isVideoEncoded = false;
    @Nullable
    private String localPath;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f51500name;
    private boolean shouldAnimate = true;
    @Nullable
    private Type type;
    @Nullable
    private String url;

    public enum AttachmentState {
        OFFLINE,
        SYNCED,
        NOT_AVAILABLE
    }

    public enum Type {
        MAIN_SCREENSHOT("main-screenshot"),
        AUDIO(MimeTypes.BASE_TYPE_AUDIO),
        EXTRA_IMAGE("extra_image"),
        EXTRA_VIDEO("extra_video"),
        GALLERY_IMAGE("image_gallery"),
        GALLERY_VIDEO("video_gallery"),
        ATTACHMENT_FILE("attachment-file"),
        VIEW_HIERARCHY("view-hierarchy-v2"),
        NOT_AVAILABLE("not-available"),
        VISUAL_USER_STEPS("user-repro-steps-v2"),
        AUTO_SCREEN_RECORDING_VIDEO("auto-screen-recording-v2");
        
        private static final Map<String, Type> lookup = null;

        /* renamed from: name  reason: collision with root package name */
        private final String f51501name;

        /* access modifiers changed from: public */
        static {
            int i11;
            lookup = new HashMap();
            for (Type type : values()) {
                lookup.put(type.f51501name, type);
            }
        }

        private Type(String str) {
            this.f51501name = str;
        }

        public static Type get(String str) {
            Type type = lookup.get(str);
            if (type == null) {
                return NOT_AVAILABLE;
            }
            return type;
        }

        @NonNull
        public String toString() {
            return this.f51501name;
        }
    }

    public Attachment() {
        setType(Type.NOT_AVAILABLE);
        setAttachmentState(AttachmentState.NOT_AVAILABLE);
    }

    public static List<Attachment> fromJson(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Attachment attachment = new Attachment();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            attachment.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(attachment);
        }
        return arrayList;
    }

    public static JSONArray toJson(List<Attachment> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < list.size(); i11++) {
            jSONArray.put((Object) new JSONObject(list.get(i11).toJson()));
        }
        return jSONArray;
    }

    @SuppressLint({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) obj;
        if (!String.valueOf(attachment.getName()).equals(String.valueOf(getName())) || !String.valueOf(attachment.getLocalPath()).equals(String.valueOf(getLocalPath())) || !String.valueOf(attachment.getUrl()).equals(String.valueOf(getUrl())) || attachment.getType() != getType() || attachment.getAttachmentState() != getAttachmentState() || attachment.isVideoEncoded() != isVideoEncoded() || !String.valueOf(attachment.getDuration()).equals(String.valueOf(getDuration()))) {
            return false;
        }
        return true;
    }

    @Nullable
    public AttachmentState getAttachmentState() {
        return this.attachmentState;
    }

    @Nullable
    public String getDuration() {
        return this.duration;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String getFileType() {
        String str;
        String mimeTypeFromExtension;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getName());
        if (getType() == null) {
            str = "";
        } else {
            str = getType().toString();
        }
        if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("") || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl)) == null || mimeTypeFromExtension.equals("")) {
            return str;
        }
        return mimeTypeFromExtension;
    }

    public long getId() {
        return this.f51499id;
    }

    @Nullable
    public String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public String getName() {
        return this.f51500name;
    }

    @Nullable
    public Type getType() {
        return this.type;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        if (getName() != null) {
            return getName().hashCode();
        }
        return -1;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isVideoEncoded() {
        return this.isVideoEncoded;
    }

    public Attachment setAttachmentState(AttachmentState attachmentState2) {
        this.attachmentState = attachmentState2;
        return this;
    }

    public void setDuration(@Nullable String str) {
        this.duration = str;
    }

    public void setEncrypted(boolean z11) {
        this.isEncrypted = z11;
    }

    public void setId(long j11) {
        this.f51499id = j11;
    }

    public Attachment setLocalPath(@Nullable String str) {
        this.localPath = str;
        return this;
    }

    public Attachment setName(@Nullable String str) {
        this.f51500name = str;
        return this;
    }

    public void setShouldAnimate(boolean z11) {
        this.shouldAnimate = z11;
    }

    public Attachment setType(Type type2) {
        this.type = type2;
        return this;
    }

    public Attachment setUrl(String str) {
        this.url = str;
        return this;
    }

    public Attachment setVideoEncoded(boolean z11) {
        this.isVideoEncoded = z11;
        return this;
    }

    public boolean shouldAnimate() {
        return this.shouldAnimate;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public String toString() {
        return "Name: " + getName() + ", Local Path: " + getLocalPath() + ", Type: " + getType() + ", Duration: " + getDuration() + ", Url: " + getUrl() + ", Attachment State: " + getAttachmentState();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object) getName()).put(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, (Object) getLocalPath()).put("url", (Object) getUrl()).put(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED, isVideoEncoded()).put(KEY_ENCRYPTED, isEncrypted()).put("duration", (Object) getDuration());
        if (getType() != null) {
            jSONObject.put("type", (Object) getType().toString());
        }
        if (getAttachmentState() != null) {
            jSONObject.put(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE, (Object) getAttachmentState().toString());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("name")) {
            setName(jSONObject.getString("name"));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH)) {
            setLocalPath(jSONObject.getString(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH));
        }
        if (jSONObject.has("url")) {
            setUrl(jSONObject.getString("url"));
        }
        if (jSONObject.has("type")) {
            setType(Type.get(jSONObject.getString("type")));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE)) {
            setAttachmentState(AttachmentState.valueOf(jSONObject.getString(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE)));
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED)) {
            setVideoEncoded(jSONObject.getBoolean(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED));
        }
        if (jSONObject.has("duration")) {
            setDuration(jSONObject.getString("duration"));
        }
        if (jSONObject.has(KEY_ENCRYPTED)) {
            setEncrypted(jSONObject.getBoolean(KEY_ENCRYPTED));
        }
    }
}
