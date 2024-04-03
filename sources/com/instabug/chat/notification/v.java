package com.instabug.chat.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.R;
import com.instabug.chat.f;
import com.instabug.chat.model.h;
import com.instabug.chat.model.k;
import com.instabug.chat.model.n;
import com.instabug.chat.settings.a;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.chat.util.b;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class v {

    /* renamed from: e  reason: collision with root package name */
    private static v f46140e;

    /* renamed from: a  reason: collision with root package name */
    private int f46141a;

    /* renamed from: b  reason: collision with root package name */
    private final s f46142b = new s();

    /* renamed from: c  reason: collision with root package name */
    private InstabugAppData f46143c;

    /* renamed from: d  reason: collision with root package name */
    private List f46144d;

    private v() {
    }

    private int a(List list) {
        ArrayList<k> arrayList = new ArrayList<>(list);
        String d11 = ((k) list.get(0)).d();
        Collections.sort(arrayList, new h(1));
        int i11 = 1;
        for (k d12 : arrayList) {
            String d13 = d12.d();
            if (d13 != null && !d13.equals(d11)) {
                i11++;
                d11 = d13;
            }
        }
        return i11 == 1 ? 0 : 1;
    }

    @RequiresApi(api = 26)
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private NotificationChannel a(String str, String str2, Uri uri) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 4);
        if (a.k()) {
            notificationChannel.setSound(uri, (AudioAttributes) null);
        } else {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        }
        return notificationChannel;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private n a(@Nullable Context context, int i11, k kVar) {
        n nVar;
        String str;
        if (i11 != 1) {
            nVar = new n();
            nVar.b(a(context, 0, this.f46144d));
            str = a(0, kVar.n());
        } else {
            nVar = new n();
            nVar.b(a(context, 1, this.f46144d));
            str = a(1, kVar.n());
        }
        nVar.c(str);
        nVar.a(kVar.m());
        return nVar;
    }

    public static v a() {
        if (f46140e == null) {
            f46140e = new v();
        }
        return f46140e;
    }

    private String a(int i11, String str) {
        if (i11 != 0) {
            return i11 != 1 ? "" : b.a();
        }
        return str + " (" + b.a() + ")";
    }

    @Nullable
    private String a(@Nullable Context context, int i11, List list) {
        String n11;
        if (i11 == 0) {
            return ((k) list.get(list.size() - 1)).c();
        }
        if (i11 != 1 || context == null || (n11 = ((k) list.get(list.size() - 1)).n()) == null) {
            return "";
        }
        String[] split = n11.split(" ");
        return String.format(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.CHATS_MULTIPLE_MESSAGE_NOTIFICATION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.instabug_str_notifications_body, context)), new Object[]{Integer.valueOf(list.size()), split[0]});
    }

    private void a(Activity activity, List list) {
        if (InstabugCore.isFeatureEnabled(Feature.REPLIES)) {
            WeakReference weakReference = new WeakReference(activity);
            k kVar = (k) list.get(list.size() - 1);
            this.f46142b.a(weakReference, a(Instabug.getApplicationContext(), this.f46141a, kVar), new u(this, kVar));
            PresentationManager.getInstance().setNotificationShowing(true);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(Context context, Intent intent, @Nullable CharSequence charSequence) {
        if (f.c()) {
            int d11 = a.d();
            if (d11 == -1 || d11 == 0) {
                d11 = this.f46143c.getAppIcon();
            }
            String f11 = a.f() != null ? a.f() : "ibg-replies-channel";
            if (!a.k()) {
                f11 = f11 + "-silent";
            }
            int i11 = Build.VERSION.SDK_INT;
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, f11).setSmallIcon(d11).setContentTitle(this.f46143c.getAppName()).setContentText(charSequence).setAutoCancel(true).setContentIntent(activity);
            contentIntent.setPriority(1);
            contentIntent.setVibrate(new long[0]);
            if (a.k()) {
                contentIntent.setSound(defaultUri);
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                if (i11 >= 26) {
                    notificationManager.createNotificationChannel(a(f11, this.f46143c.getAppName(), defaultUri));
                }
                notificationManager.notify(0, contentIntent.build());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Intent intent;
        Context applicationContext = Instabug.getApplicationContext();
        if (this.f46141a != 1) {
            List list = this.f46144d;
            k kVar = (k) list.get(list.size() - 1);
            if (applicationContext != null) {
                intent = com.instabug.chat.ui.a.a(applicationContext, kVar.d());
                intent.addFlags(268435456);
            } else {
                return;
            }
        } else if (applicationContext != null) {
            intent = com.instabug.chat.ui.a.a(applicationContext);
        } else {
            return;
        }
        applicationContext.startActivity(intent);
    }

    private boolean c() {
        return InstabugCore.getStartedActivitiesCount() > 0;
    }

    /* access modifiers changed from: private */
    public void d() {
        PresentationManager.getInstance().setNotificationShowing(false);
        PresentationManager.getInstance().notifyActivityChanged();
    }

    public void a(@Nullable Context context) {
        if (context != null) {
            ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(0);
        }
    }

    public void a(Context context, List list) {
        Intent intent;
        String str;
        this.f46143c = new InstabugAppData(context);
        int a11 = a(list);
        this.f46141a = a11;
        this.f46144d = list;
        if (a11 == 0) {
            String a12 = a(context, 0, list);
            intent = com.instabug.chat.ui.a.a(context, ((k) list.get(list.size() - 1)).d());
            str = a12;
        } else if (a11 != 1) {
            str = "";
            intent = null;
        } else {
            str = a(context, 1, list);
            intent = com.instabug.chat.ui.a.a(context);
        }
        if (c() || intent == null) {
            Activity targetActivity = context instanceof Activity ? (Activity) context : InstabugCore.getTargetActivity();
            if (InstabugCore.isForegroundBusy()) {
                ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
                if (chatPlugin == null || chatPlugin.getState() != 1 || targetActivity == null) {
                    if (intent == null) {
                        return;
                    }
                }
            } else if (targetActivity == null) {
                return;
            }
            a(targetActivity, list);
            return;
        }
        a(context, intent, (CharSequence) str);
    }

    public boolean a(Bundle bundle) {
        String str;
        try {
            String string = bundle.getString("message");
            if (string == null) {
                return false;
            }
            String string2 = new JSONObject(string).getString("IBGHost");
            InstabugSDKLogger.d("IBG-Core", "IBGHost: " + string2);
            return string2 != null && Boolean.parseBoolean(string2);
        } catch (JSONException e11) {
            e = e11;
            str = "Parsing GCM response failed";
            InstabugSDKLogger.e("IBG-Core", str, e);
            return false;
        } catch (NullPointerException e12) {
            e = e12;
            str = "Something went wrong while showing notification";
            InstabugSDKLogger.e("IBG-Core", str, e);
            return false;
        }
    }

    public boolean a(Map map) {
        String str;
        if (!map.containsKey("message")) {
            return false;
        }
        try {
            String string = new JSONObject((String) map.get("message")).getString("IBGHost");
            return string != null && Boolean.parseBoolean(string);
        } catch (JSONException e11) {
            e = e11;
            str = "Parsing GCM response failed";
            InstabugSDKLogger.e("IBG-Core", str, e);
            return false;
        } catch (NullPointerException e12) {
            e = e12;
            str = "Something went wrong while showing notification";
            InstabugSDKLogger.e("IBG-Core", str, e);
            return false;
        }
    }

    public void b(@Nullable Context context) {
        if (context != null && InstabugDeviceProperties.checkRingerIsOn(context)) {
            MediaPlayer create = MediaPlayer.create(context, com.instabug.library.R.raw.ib_core_sound_new_message);
            create.setAudioAttributes(new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
            create.start();
            create.setOnCompletionListener(new t(this, create));
        }
    }

    public void b(Bundle bundle) {
        if (InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == Feature.State.ENABLED && a(bundle) && SynchronizationManager.getInstance() != null) {
            SynchronizationManager.getInstance().sync();
        }
    }

    public void b(Map map) {
        if (InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == Feature.State.ENABLED && a(map) && SynchronizationManager.getInstance() != null) {
            SynchronizationManager.getInstance().sync();
        }
    }
}
