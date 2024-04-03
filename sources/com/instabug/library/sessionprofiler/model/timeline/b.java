package com.instabug.library.sessionprofiler.model.timeline;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.library.util.DeviceStateProvider;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends f {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51868b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51869c;

    public static Queue d(JSONArray jSONArray) throws JSONException {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            concurrentLinkedQueue.add(a(jSONArray.getJSONObject(i11)));
        }
        return concurrentLinkedQueue;
    }

    public void a(@Nullable String str) {
        this.f51869c = str;
    }

    public void b(@Nullable String str) {
        this.f51868b = str;
    }

    private static b a(@NonNull Context context, @NonNull ConnectivityManager connectivityManager, @NonNull b bVar) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            bVar.b("no_connection");
        } else if (activeNetworkInfo.getType() == 1) {
            bVar.b("WiFi");
        } else if (activeNetworkInfo.getType() == 0) {
            bVar.a(DeviceStateProvider.getCarrier(context));
            bVar.b(activeNetworkInfo.getSubtypeName());
        }
        return bVar;
    }

    public static b b(@NonNull Context context) {
        b bVar = new b();
        if (context == null) {
            bVar.b("no_connection");
            return bVar;
        }
        ConnectivityManager a11 = a(context);
        if (a11 == null) {
            bVar.b("no_connection");
            return bVar;
        } else if (Build.VERSION.SDK_INT >= 29) {
            return a(a(a11), bVar);
        } else {
            return a(context, a11, bVar);
        }
    }

    @RequiresApi(29)
    @NonNull
    private static b a(@Nullable NetworkCapabilities networkCapabilities, @NonNull b bVar) {
        if (networkCapabilities == null) {
            bVar.b("no_connection");
            return bVar;
        }
        if (networkCapabilities.hasTransport(0)) {
            bVar.b("Cellular");
        } else if (networkCapabilities.hasTransport(1)) {
            bVar.b("WiFi");
        } else {
            bVar.b("no_connection");
        }
        return bVar;
    }

    public JSONObject b() throws JSONException {
        JSONObject c11 = c(this.f51868b);
        String str = this.f51869c;
        if (str != null) {
            c11.put("name", (Object) str);
        }
        return c11;
    }

    @RequiresApi(29)
    @Nullable
    private static NetworkCapabilities a(@Nullable ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
    }

    @Nullable
    private static ConnectivityManager a(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static b a(JSONObject jSONObject) throws JSONException {
        b bVar = new b();
        bVar.a(jSONObject.getDouble("t"));
        bVar.b(jSONObject.getString("v"));
        if (jSONObject.has("name")) {
            bVar.a(jSONObject.getString("name"));
        }
        return bVar;
    }
}
