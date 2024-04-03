package com.apptimize;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

public class id implements jj<JSONObject, im> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43012a = "id";

    /* renamed from: b  reason: collision with root package name */
    private ih f43013b;

    public id(ih ihVar) {
        this.f43013b = ihVar;
    }

    /* renamed from: a */
    public JSONObject b(im imVar) throws JSONException {
        BitmapDrawable a11 = imVar.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BindingAdaptersKt.QUERY_SIZE, (Object) new JSONObject(a11) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BitmapDrawable f43014a;

            {
                this.f43014a = r3;
                put("width", r3.getIntrinsicWidth());
                put("height", r3.getIntrinsicHeight());
            }
        });
        jSONObject.put("scale", (double) this.f43013b.a().getDisplayMetrics().density);
        try {
            jSONObject.put("uri", (Object) this.f43013b.a((Drawable) a11).toString());
            return jSONObject;
        } catch (URISyntaxException unused) {
            throw new JSONException("Unexpected URISyntaxException");
        }
    }

    public Class<im> b() {
        return im.class;
    }

    public im a(JSONObject jSONObject) throws JSONException, hk {
        try {
            URI uri = new URI(jSONObject.getString("uri"));
            Drawable a11 = this.f43013b.a(uri);
            if (a11 instanceof BitmapDrawable) {
                return new im((iq) null, (BitmapDrawable) a11);
            }
            if (a11 == null) {
                throw new hk("URI not in cache: " + uri);
            }
            throw new hk("Unexpectedly cached wrong image type for " + uri + ": " + a11);
        } catch (URISyntaxException unused) {
            throw new JSONException("Unexpected URISyntaxException");
        }
    }

    public Class<JSONObject> a() {
        return JSONObject.class;
    }
}
