package com.talabat.firebase;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xp.a;
import xp.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nJD\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2,\u0010\u000e\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0010j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b`\u00110\u000fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/firebase/Firebase;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "logEvent", "", "eventName", "", "attributes", "", "pushToDatabase", "referenceKey", "dataKey", "data", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setUserId", "userId", "com_talabat_ThirdPartyLibs_Firebase_Firebase"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Firebase {
    @NotNull
    private final Context context;

    public Firebase(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* renamed from: pushToDatabase$lambda-1  reason: not valid java name */
    public static final void m10441pushToDatabase$lambda1(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        Log.e("Datalayer", "", exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: pushToDatabase$lambda-2  reason: not valid java name */
    public static final void m10442pushToDatabase$lambda2(Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        task.isSuccessful();
    }

    public final void logEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof ArrayList) {
                FirebaseKt.putListOfMapElements(bundle, (String) next.getKey(), (ArrayList) value);
            } else {
                bundle.putString((String) next.getKey(), String.valueOf(value));
            }
        }
        FirebaseAnalytics.getInstance(this.context).logEvent(str, bundle);
    }

    public final void pushToDatabase(@NotNull String str, @NotNull String str2, @NotNull List<? extends HashMap<String, String>> list) {
        Intrinsics.checkNotNullParameter(str, "referenceKey");
        Intrinsics.checkNotNullParameter(str2, Credential.DK);
        Intrinsics.checkNotNullParameter(list, "data");
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        DatabaseReference reference = instance.getReference(str);
        Intrinsics.checkNotNullExpressionValue(reference, "firebaseDatabase.getReference(referenceKey)");
        HashMap hashMap = new HashMap();
        hashMap.put(str2, list);
        reference.push().setValue(hashMap).addOnFailureListener(new a()).addOnCompleteListener(new b());
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        FirebaseAnalytics.getInstance(this.context).setUserId(str);
    }
}
