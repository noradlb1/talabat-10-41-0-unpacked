package com.instabug.library.invocation.invocationdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.core.plugin.d;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.invoker.v;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class e extends BasePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f51289a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private InstabugDialogItem f51290b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Handler f51291c;

    /* renamed from: d  reason: collision with root package name */
    private int f51292d;

    /* renamed from: e  reason: collision with root package name */
    private int f51293e;

    public e(c cVar) {
        super(cVar);
        this.f51289a = cVar;
        this.f51292d = cVar.getFadeInAnimation();
        this.f51293e = cVar.getSlidOutLeftAnimation();
        SettingsManager.getInstance().setProcessingForeground(false);
    }

    private void i() {
        Handler handler = new Handler();
        this.f51291c = handler;
        if (this.f51289a != null) {
            handler.postDelayed(new d(this), 10000);
        }
    }

    public void b(@Nullable InstabugDialogItem instabugDialogItem, @Nullable Uri uri) {
        this.f51290b = instabugDialogItem;
        a();
        if (instabugDialogItem != null) {
            ArrayList<InstabugDialogItem> subItems = instabugDialogItem.getSubItems();
            if (subItems == null || subItems.isEmpty()) {
                a(instabugDialogItem, uri);
                return;
            }
            this.f51292d = this.f51289a.getSlidInRightAnimation();
            this.f51293e = this.f51289a.getSlidOutLeftAnimation();
            String title = b(instabugDialogItem).getTitle();
            if (title == null) {
                title = "";
            }
            this.f51289a.setContent(title, false, subItems);
        }
    }

    public int c() {
        return this.f51293e;
    }

    public boolean d() {
        return this.f51290b != null;
    }

    public void e() {
        InstabugDialogItem instabugDialogItem = this.f51290b;
        if (instabugDialogItem != null) {
            this.f51290b = instabugDialogItem.getParent();
        }
        this.f51292d = this.f51289a.getSlidInLeftAnimation();
        this.f51293e = this.f51289a.getSlidOutRightAnimation();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void f() {
        if (InvocationManager.getInstance().getLastUsedInvoker() instanceof v) {
            i();
        }
    }

    public void g() {
        a();
        SettingsManager.getInstance().setShouldAutoShowOnboarding(false);
    }

    public void h() {
        this.f51290b = null;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a() {
        Handler handler = this.f51291c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void d(InstabugDialogItem instabugDialogItem) {
        c cVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (cVar = (c) weakReference.get()) != null && instabugDialogItem != null && !instabugDialogItem.isInitialScreenshotRequired()) {
            cVar.onInitialScreenShotNotRequired();
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private void a(InstabugDialogItem instabugDialogItem, @Nullable Uri uri) {
        ArrayList<PluginPromptOption> availablePromptOptions = InvocationManager.getInstance().getAvailablePromptOptions();
        if (b(instabugDialogItem).getOrder() == -1) {
            Iterator<PluginPromptOption> it = availablePromptOptions.iterator();
            while (it.hasNext()) {
                PluginPromptOption next = it.next();
                if (next.getOrder() == -1) {
                    next.invoke();
                    return;
                }
            }
            return;
        }
        PluginPromptOption a11 = d.a(instabugDialogItem.getIdentifier(), true);
        if (a11 != null) {
            a11.invoke(uri, a(instabugDialogItem));
        }
    }

    public int b() {
        return this.f51292d;
    }

    private InstabugDialogItem b(InstabugDialogItem instabugDialogItem) {
        while (instabugDialogItem.getParent() != null) {
            instabugDialogItem = instabugDialogItem.getParent();
        }
        return instabugDialogItem;
    }

    public void a(Uri... uriArr) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            DiskUtils with = DiskUtils.with(applicationContext);
            if (uriArr != null) {
                for (Uri deleteUriDiskOperation : uriArr) {
                    with.deleteOperation(new DeleteUriDiskOperation(deleteUriDiskOperation)).executeAsync((DiskOperationCallback<Boolean>) null);
                }
                return;
            }
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Can't execute dumpAttachments() due to null context");
    }

    private String[] a(InstabugDialogItem instabugDialogItem) {
        ArrayList arrayList = new ArrayList();
        while (instabugDialogItem.getParent() != null) {
            arrayList.add(instabugDialogItem.getTitle());
            instabugDialogItem = instabugDialogItem.getParent();
        }
        Collections.reverse(arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }
}
