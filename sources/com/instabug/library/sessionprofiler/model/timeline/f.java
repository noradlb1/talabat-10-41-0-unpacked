package com.instabug.library.sessionprofiler.model.timeline;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private double f51879a;

    public void a(double d11) {
        this.f51879a = d11;
    }

    public abstract JSONObject b() throws JSONException;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONObject c(@Nullable Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", this.f51879a);
        jSONObject.put("v", obj);
        return jSONObject;
    }

    public static JSONArray a(Collection collection) throws JSONException {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        JSONArray jSONArray = new JSONArray();
        if (collection instanceof ConcurrentLinkedQueue) {
            concurrentLinkedQueue = (ConcurrentLinkedQueue) collection;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue(collection);
        }
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null) {
                jSONArray.put((Object) fVar.b());
            }
        }
        return jSONArray;
    }
}
