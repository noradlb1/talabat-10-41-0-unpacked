package com.instabug.library.user;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserEvent {
    private static final String EVENT = "event";
    private static final String PARAMS = "params";
    private static final String TIMESTAMP = "timestamp";
    private long date;
    @Nullable
    private String eventIdentifier;
    @NonNull
    private final List<UserEventParam> params = new ArrayList();

    @NonNull
    public static JSONArray keysAsJsonArray(@NonNull List<UserEvent> list) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (UserEvent next : list) {
            if (next.getEventIdentifier() != null) {
                linkedHashSet.add(next.getEventIdentifier());
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : linkedHashSet) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    public UserEvent addParam(UserEventParam userEventParam) {
        this.params.add(userEventParam);
        return this;
    }

    @SuppressLint({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof UserEvent)) {
            UserEvent userEvent = (UserEvent) obj;
            if (String.valueOf(userEvent.getEventIdentifier()).equals(String.valueOf(getEventIdentifier())) && String.valueOf(userEvent.getDate()).equals(String.valueOf(getDate())) && userEvent.getParams().size() == getParams().size()) {
                for (int i11 = 0; i11 < this.params.size(); i11++) {
                    if (!userEvent.getParams().get(i11).equals(getParams().get(i11))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public long getDate() {
        return this.date;
    }

    @Nullable
    public String getEventIdentifier() {
        return this.eventIdentifier;
    }

    @NonNull
    public List<UserEventParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        if (getEventIdentifier() == null) {
            return -1;
        }
        return (getDate() + ": " + getEventIdentifier()).hashCode();
    }

    public UserEvent setDate(long j11) {
        this.date = j11;
        return this;
    }

    public UserEvent setEventIdentifier(String str) {
        this.eventIdentifier = str;
        return this;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", (Object) getEventIdentifier());
        jSONObject.put("timestamp", getDate());
        JSONObject jSONObject2 = new JSONObject();
        for (UserEventParam next : getParams()) {
            if (!(next == null || next.getKey() == null)) {
                jSONObject2.put(next.getKey(), (Object) next.getValue());
            }
        }
        jSONObject.put("params", (Object) jSONObject2);
        return jSONObject;
    }

    public static JSONArray toJson(List<UserEvent> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (UserEvent json : list) {
            jSONArray.put((Object) json.toJson());
        }
        return jSONArray;
    }
}
