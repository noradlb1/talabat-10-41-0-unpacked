package com.instabug.library.ui.promptoptions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import com.instabug.library.invocation.invocationdialog.a;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f51992a;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = f51992a;
            if (bVar == null) {
                bVar = new b();
                f51992a = bVar;
            }
        }
        return bVar;
    }

    private ArrayList b() {
        return a((ArrayList) InvocationManager.getInstance().getAvailablePromptOptions());
    }

    public void a(Activity activity, @Nullable Uri uri) {
        activity.startActivity(InstabugDialogActivity.getIntent(activity, a((Context) activity), uri, b(), false));
    }

    public void a(Activity activity, @Nullable Uri uri, @Nullable String str, @Nullable ArrayList arrayList) {
        PoolProvider.postMainThreadTask(new a(this, activity, str, uri, arrayList));
    }

    @Nullable
    private String a(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.INVOCATION_HEADER, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.instabug_str_invocation_dialog_title, context));
    }

    private ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int i11 = 0;
        while (true) {
            if (i11 >= (arrayList != null ? arrayList.size() : 0)) {
                return arrayList2;
            }
            arrayList2.add(a((PluginPromptOption) arrayList.get(i11), (InstabugDialogItem) null));
            i11++;
        }
    }

    public InstabugDialogItem a(PluginPromptOption pluginPromptOption, @Nullable InstabugDialogItem instabugDialogItem) {
        InstabugDialogItem instabugDialogItem2;
        if (pluginPromptOption.getOrder() == -1) {
            instabugDialogItem2 = new a();
            instabugDialogItem2.setOrder(-1);
        } else {
            instabugDialogItem2 = new InstabugDialogItem();
            instabugDialogItem2.setOrder(pluginPromptOption.getOrder());
        }
        instabugDialogItem2.setResDrawable(pluginPromptOption.getIcon());
        instabugDialogItem2.setTitle(pluginPromptOption.getTitle());
        instabugDialogItem2.setDescription(pluginPromptOption.getDescription());
        instabugDialogItem2.setBadge(pluginPromptOption.getNotificationCount());
        instabugDialogItem2.setInitialScreenshotRequired(pluginPromptOption.isInitialScreenshotRequired());
        instabugDialogItem2.setParent(instabugDialogItem);
        instabugDialogItem2.setSubItems(a((ArrayList) pluginPromptOption.getSubOptions(), instabugDialogItem2));
        instabugDialogItem2.setIdentifier(pluginPromptOption.getPromptOptionIdentifier());
        return instabugDialogItem2;
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    private ArrayList a(@Nullable ArrayList arrayList, @Nullable InstabugDialogItem instabugDialogItem) {
        ArrayList arrayList2 = new ArrayList();
        int i11 = 0;
        while (true) {
            if (i11 >= (arrayList != null ? arrayList.size() : 0)) {
                return arrayList2;
            }
            if (arrayList.get(i11) != null) {
                arrayList2.add(a((PluginPromptOption) arrayList.get(i11), instabugDialogItem));
            }
            i11++;
        }
    }
}
