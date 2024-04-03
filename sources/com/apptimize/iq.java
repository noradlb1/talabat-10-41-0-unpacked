package com.apptimize;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class iq {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f43071a;

    public static class a {
        @SuppressLint({"NewApi"})
        public static Drawable a(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }
    }

    private iq(Rect rect) {
        this.f43071a = rect;
    }

    public static iq b(JSONObject jSONObject) throws JSONException {
        return new iq(d(jSONObject));
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (this.f43071a != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", this.f43071a.left);
            jSONObject2.put(TtmlNode.RIGHT, this.f43071a.right);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, this.f43071a.top);
            jSONObject2.put("bottom", this.f43071a.bottom);
            jSONObject.put("capInsets", (Object) jSONObject2);
        }
    }

    private Drawable d(Drawable drawable) {
        if (this.f43071a == null) {
            return drawable;
        }
        Rect rect = this.f43071a;
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(JSONObject jSONObject) throws JSONException {
        c(jSONObject);
    }

    public static iq a(Drawable drawable) {
        if (!(drawable instanceof InsetDrawable)) {
            return new iq((Rect) null);
        }
        Rect rect = new Rect();
        ((InsetDrawable) drawable).getPadding(rect);
        return new iq(rect);
    }

    public static Drawable b(Drawable drawable) {
        return drawable instanceof InsetDrawable ? a.a((InsetDrawable) drawable) : drawable;
    }

    private static Rect d(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("capInsets")) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("capInsets");
        Rect rect = new Rect();
        rect.left = jSONObject2.getInt("left");
        rect.right = jSONObject2.getInt(TtmlNode.RIGHT);
        rect.top = jSONObject2.getInt(ViewHierarchyConstants.DIMENSION_TOP_KEY);
        rect.bottom = jSONObject2.getInt("bottom");
        return rect;
    }

    public Drawable c(Drawable drawable) {
        return d(drawable);
    }
}
