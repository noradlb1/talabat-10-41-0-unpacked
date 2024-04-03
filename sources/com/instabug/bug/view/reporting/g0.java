package com.instabug.bug.view.reporting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.util.Pair;
import android.util.Patterns;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.model.a;
import com.instabug.bug.model.c;
import com.instabug.bug.model.d;
import com.instabug.bug.n;
import com.instabug.bug.screenshot.h;
import com.instabug.bug.settings.b;
import com.instabug.bug.utils.e;
import com.instabug.bug.utils.f;
import com.instabug.bug.v;
import com.instabug.library.Feature;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.video.RequestPermissionActivity;
import com.instabug.library.model.Attachment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.VideoManipulationUtils;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.lang.ref.WeakReference;

public abstract class g0 extends BasePresenter implements h0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private CompositeDisposable f45891a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public f0 f45892b = f0.f45885a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f45893c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45894d = false;

    public g0(i0 i0Var) {
        super(i0Var);
    }

    /* access modifiers changed from: private */
    public void a(@Nullable i0 i0Var) {
        if (i0Var != null && ((Fragment) i0Var.getViewContext()).getActivity() != null) {
            ((Fragment) i0Var.getViewContext()).getActivity().runOnUiThread(new d0(this, i0Var));
        }
    }

    @RequiresApi(api = 19)
    private void a(i0 i0Var, Intent intent) {
        Pair<String, String> fileNameAndSize = AttachmentsUtility.getFileNameAndSize(i0Var.c(), intent.getData());
        if (fileNameAndSize != null) {
            Object obj = fileNameAndSize.first;
            String str = (String) obj;
            String extension = obj != null ? FileUtils.getExtension(str) : null;
            Object obj2 = fileNameAndSize.second;
            String str2 = obj2 != null ? (String) obj2 : "0";
            if (extension == null) {
                return;
            }
            if (FileUtils.isImageExtension(extension)) {
                File fileFromContentProvider = AttachmentsUtility.getFileFromContentProvider(i0Var.getContext(), intent.getData(), str);
                if (fileFromContentProvider != null) {
                    n.e().a(i0Var.getContext(), fileFromContentProvider, Attachment.Type.GALLERY_IMAGE);
                }
            } else if (FileUtils.isVideoExtension(extension)) {
                try {
                    if ((Double.parseDouble(str2) / 1024.0d) / 1024.0d > 50.0d) {
                        i0Var.x();
                        InstabugSDKLogger.e("IBG-BR", "Attached video size exceeded the limit");
                        return;
                    }
                    File fileFromContentProvider2 = AttachmentsUtility.getFileFromContentProvider(i0Var.getContext(), intent.getData(), str);
                    if (fileFromContentProvider2 == null) {
                        InstabugSDKLogger.e("IBG-BR", "Couldn't get video attachment, file is null");
                    } else if (VideoManipulationUtils.extractVideoDuration(fileFromContentProvider2.getPath()) > 60000) {
                        i0Var.t();
                        InstabugSDKLogger.e("IBG-BR", "Attached video length exceeded the limit, deleting file");
                        if (fileFromContentProvider2.delete()) {
                            InstabugSDKLogger.v("IBG-BR", "Attachment deleted");
                        }
                    } else {
                        n.e().b(i0Var.getContext(), Uri.fromFile(fileFromContentProvider2), Attachment.Type.GALLERY_VIDEO);
                    }
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-BR", "Error: " + e11.getMessage() + " while adding video attachment", e11);
                }
            }
        }
    }

    private void a(String str, boolean z11) {
        i0 i0Var;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && weakReference.get() != null && (i0Var = (i0) this.f34200f.get()) != null) {
            if (z11) {
                str = f.a(str);
            }
            i0Var.c(str);
        }
    }

    private void b(i0 i0Var) {
        if (n.e().c() != null) {
            n.e().c().a(a.IN_PROGRESS);
        }
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (!(bugPlugin == null || bugPlugin.getAppContext() == null)) {
            bugPlugin.setState(2);
            SettingsManager.getInstance().setProcessingForeground(false);
            h.b().a(bugPlugin.getAppContext());
        }
        if (i0Var != null) {
            i0Var.finishActivity();
        }
        n.e().g();
    }

    private void b(i0 i0Var, @NonNull Intent intent) {
        String galleryImagePath = AttachmentsUtility.getGalleryImagePath(i0Var.c(), intent.getData());
        if (galleryImagePath == null && intent.getData() != null) {
            galleryImagePath = intent.getData().getPath();
        }
        if (galleryImagePath == null) {
            InstabugSDKLogger.e("IBG-BR", "Null file path while adding attachment from gallery");
            return;
        }
        String extension = FileUtils.getExtension(galleryImagePath);
        if (FileUtils.isImageExtension(extension)) {
            n.e().a(i0Var.getContext(), Uri.fromFile(new File(galleryImagePath)), Attachment.Type.GALLERY_IMAGE);
        } else if (FileUtils.isVideoExtension(extension)) {
            File file = new File(galleryImagePath);
            if ((file.length() / 1024) / 1024 > 50) {
                i0Var.x();
            } else if (VideoManipulationUtils.extractVideoDuration(galleryImagePath) > 60000) {
                i0Var.t();
            } else {
                n.e().b(i0Var.getContext(), Uri.fromFile(file), Attachment.Type.GALLERY_VIDEO);
            }
        }
        n.e().a(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Attachment attachment) {
        InstabugSDKLogger.v("IBG-BR", "Removing attachment: " + attachment.getName());
        if (n.e().c() != null) {
            n.e().c().a().remove(attachment);
        }
        if (attachment.getLocalPath() != null) {
            File file = new File(attachment.getLocalPath());
            if (Attachment.Type.EXTRA_VIDEO.equals(attachment.getType()) || Attachment.Type.GALLERY_VIDEO.equals(attachment.getType())) {
                InstabugSDKLogger.v("IBG-BR", "Removing video attachment");
                Cache cache = CacheManager.getInstance().getCache(CacheManager.DEFAULT_IN_MEMORY_CACHE_KEY);
                if (!(cache == null || cache.delete("video.path") == null)) {
                    InstabugSDKLogger.v("IBG-BR", "video attachment removed successfully");
                }
                if (n.e().c() != null) {
                    n.e().c().setHasVideo(false);
                }
            }
            if (file.delete()) {
                InstabugSDKLogger.v("IBG-BR", "attachment removed successfully");
                c(attachment);
            }
        }
    }

    private void d(String str) {
        if (n.e().c() != null && n.e().c().getState() != null) {
            n.e().c().getState().setCustomUserAttribute(str);
        }
    }

    public static /* synthetic */ int e(g0 g0Var) {
        int i11 = g0Var.f45893c - 1;
        g0Var.f45893c = i11;
        return i11;
    }

    private void e(String str) {
        b.f().c(f.b(str));
    }

    private void f(String str) {
        if (n.e().c() != null && n.e().c().getState() != null) {
            n.e().c().getState().setCustomUserAttribute(str);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private boolean l() {
        i0 i0Var = (i0) this.f34200f.get();
        String g11 = n.e().c() != null ? n.e().c().g() : null;
        int a11 = b.f().a(u());
        int max = Math.max(2, a11);
        if (!(b.f().o() || a11 != 0) || ((g11 != null && g11.trim().length() >= max) || i0Var == null)) {
            return true;
        }
        String format = String.format(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_INSUFFICIENT_CONTENT, i0Var.getLocalizedString(R.string.instabug_err_invalid_comment)), new Object[]{Integer.valueOf(max)});
        String str = (g11 == null || g11.isEmpty()) ? "empty-comment" : "non-empty-comment";
        InstabugSDKLogger.v("IBG-BR", "checkCommentValid comment field is invalid : " + str);
        i0Var.b(format);
        return false;
    }

    private void m() {
        WeakReference<V> weakReference;
        i0 i0Var;
        if (InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER) && (weakReference = this.f34200f) != null && (i0Var = (i0) weakReference.get()) != null) {
            i0Var.e();
        }
    }

    private void o() {
        boolean z11;
        if (InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER)) {
            String i11 = b.f().i();
            if (n.e().c() == null || n.e().c().getState() == null) {
                if (i11 != null && !i11.trim().isEmpty()) {
                    z11 = true;
                } else {
                    return;
                }
            } else if (n.e().c().getState().getCustomUserAttribute() != null && !n.e().c().getState().getCustomUserAttribute().trim().isEmpty()) {
                i11 = n.e().c().getState().getCustomUserAttribute();
                z11 = false;
            } else {
                return;
            }
            a(i11, z11);
        }
    }

    private boolean q() {
        i0 i0Var = (i0) this.f34200f.get();
        if (i0Var == null) {
            return false;
        }
        String k11 = i0Var.k();
        if (k11 == null || k11.trim().isEmpty()) {
            return true;
        }
        return e.a(k11);
    }

    private void r() {
        this.f45893c++;
        CompositeDisposable compositeDisposable = this.f45891a;
        if (compositeDisposable != null) {
            compositeDisposable.add(v.a().getEventObservable().subscribe(new b0(this), new c0(this)));
        }
    }

    private void s() {
        this.f45893c++;
        CompositeDisposable compositeDisposable = this.f45891a;
        if (compositeDisposable != null) {
            compositeDisposable.add(com.instabug.bug.screenshot.viewhierarchy.utilities.e.a().getEventObservable().subscribe(new z(this), new a0(this)));
        }
    }

    public void a(int i11, int i12, Intent intent) {
        WeakReference<V> weakReference;
        i0 i0Var;
        if (i11 == 3862) {
            if (i12 == -1 && intent != null && intent.getData() != null && (weakReference = this.f34200f) != null && (i0Var = (i0) weakReference.get()) != null) {
                a(i0Var, intent);
            }
        } else if (i11 == 3890) {
            if (i12 == -1 && intent != null) {
                InstabugMediaProjectionIntent.setMediaProjectionIntent(intent);
                InstabugMediaProjectionIntent.setStaticResultCode(i12);
                g();
            }
        } else if (i11 == 2030 && this.f34200f.get() != null && intent != null && intent.getBooleanExtra(RequestPermissionActivity.KEY_IS_PERMISSION_GRANDTED, false)) {
            b((i0) this.f34200f.get());
        }
    }

    public void a(@Nullable Bundle bundle) {
    }

    public void a(@NonNull Attachment attachment) {
        PoolProvider.postIOTask(new zb.b(this, attachment));
    }

    public void a(String str) {
        if (n.e().c() != null && n.e().c().getState() != null) {
            n.e().c().getState().setUserEmail(str);
        }
    }

    public void a(String str, String str2) {
        i0 i0Var;
        if (!com.instabug.bug.view.visualusersteps.a.b(str)) {
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
                i0Var.d();
            }
        } else if (this.f34200f != null) {
            Spanned a11 = com.instabug.bug.view.visualusersteps.a.a(str, str2);
            i0 i0Var2 = (i0) this.f34200f.get();
            if (i0Var2 != null) {
                i0Var2.a(a11, str);
            }
        }
    }

    public void b() {
        WeakReference<V> weakReference;
        if (!this.f45894d && (weakReference = this.f34200f) != null) {
            i0 i0Var = (i0) weakReference.get();
            if (n.e().c() != null && n.e().c().n() && n.e().c().k() == c.IN_PROGRESS) {
                this.f45892b = f0.TAKE_EXTRA_SCREENSHOT;
                if (i0Var != null) {
                    i0Var.b();
                }
            } else if (i0Var == null) {
            } else {
                if (SettingsManager.getInstance().isScreenshotByMediaProjectionEnabled()) {
                    i0Var.u();
                } else {
                    b(i0Var);
                }
            }
        }
    }

    public void b(Bundle bundle) {
    }

    public void b(String str) {
        if (n.e().c() != null) {
            n.e().c().d(str);
        }
    }

    public void c() {
        CompositeDisposable compositeDisposable = this.f45891a;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    public void c(Attachment attachment) {
        i0 i0Var;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
            PoolProvider.postMainThreadTask(new zb.c(i0Var, attachment));
        }
    }

    public void c(String str) {
        f(str);
    }

    public void d() {
        i0 i0Var;
        i0 i0Var2;
        if (b.f().c() == null || b.f().c().length() <= 0) {
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
                i0Var.p();
                return;
            }
            return;
        }
        WeakReference<V> weakReference2 = this.f34200f;
        if (weakReference2 != null && (i0Var2 = (i0) weakReference2.get()) != null) {
            i0Var2.a(b.f().c());
        }
    }

    public void e() {
        this.f45891a = new CompositeDisposable();
        d c11 = n.e().c();
        if (c11 != null) {
            if (c11.n()) {
                s();
            }
            if (c11.getState() == null) {
                r();
            }
        }
        if (InstabugCore.isFeatureEnabled(Feature.VIEW_HIERARCHY_V2)) {
            s();
        }
        m();
        o();
    }

    public void f() {
        WeakReference<V> weakReference;
        i0 i0Var;
        if (!this.f45894d && (weakReference = this.f34200f) != null && (i0Var = (i0) weakReference.get()) != null) {
            if (n.e().c() == null) {
                InstabugSDKLogger.e("IBG-BR", "BUG WAS NULL - Recreate a new bug");
                if (((Fragment) i0Var.getViewContext()).getContext() != null) {
                    n.e().d(((Fragment) i0Var.getViewContext()).getContext());
                } else {
                    InstabugSDKLogger.e("IBG-BR", "Couldn't create the Bug due to Null context");
                }
            } else if (!(n.e().c() == null || n.e().c().getState() == null || b.f().q())) {
                n.e().c().getState().updateIdentificationAttrs();
            }
            boolean n11 = n();
            boolean l11 = l();
            if (n11 && l11) {
                if (n.e().c() != null && n.e().c().n() && n.e().c().k() == c.IN_PROGRESS) {
                    this.f45892b = f0.SEND_BUG;
                    i0Var.b();
                } else if (n.e().c() == null || n.e().c().getState() != null) {
                    if (InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER)) {
                        if (q()) {
                            e(i0Var.k());
                            d(i0Var.k());
                        } else {
                            i0Var.d(i0Var.getLocalizedString(R.string.ib_error_phone_number));
                            return;
                        }
                    }
                    if (b.f().q()) {
                        SettingsManager.getInstance().setEnteredEmail(i0Var.s());
                    }
                    if (i()) {
                        i0Var.C();
                    } else if (n.e().c() == null || n.e().c().getState() != null) {
                        if (((Fragment) i0Var.getViewContext()).getContext() != null) {
                            n.e().a();
                            this.f45894d = true;
                        } else {
                            InstabugSDKLogger.e("IBG-BR", "Couldn't commit the Bug due to Null context");
                        }
                        i0Var.z();
                    } else {
                        i0Var.b();
                    }
                    i0Var.b(false);
                } else {
                    this.f45892b = f0.SEND_BUG;
                    i0Var.b();
                }
            }
        }
    }

    public void g() {
        WeakReference<V> weakReference;
        if (!this.f45894d && (weakReference = this.f34200f) != null) {
            i0 i0Var = (i0) weakReference.get();
            if (n.e().c() == null || !n.e().c().n() || n.e().c().k() != c.IN_PROGRESS) {
                n.e().g();
                com.instabug.bug.screenrecording.c.a().d();
                if (i0Var != null) {
                    i0Var.finishActivity();
                }
                BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
                if (bugPlugin != null) {
                    bugPlugin.setState(2);
                    return;
                }
                return;
            }
            this.f45892b = f0.RECORD_VIDEO;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void j() {
        i0 i0Var;
        if (!this.f45894d) {
            n.e().a(true);
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
                PermissionsUtils.requestPermission((Fragment) i0Var.getViewContext(), PermissionsUtils.mediaStoragePermission(), 3873, (Runnable) null, (Runnable) new y(this, i0Var));
            }
        }
    }

    public void k() {
        WeakReference<V> weakReference;
        i0 i0Var;
        d c11 = n.e().c();
        if (c11 != null && (weakReference = this.f34200f) != null && (i0Var = (i0) weakReference.get()) != null) {
            i0Var.a(c11.a());
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public boolean n() {
        String str;
        i0 i0Var = (i0) this.f34200f.get();
        d c11 = n.e().c();
        String str2 = "empty-email";
        if (c11 == null || c11.getState() == null) {
            str = null;
        } else {
            str = c11.getState().getUserEmail();
            if (str != null) {
                str = str.trim();
                InstabugSDKLogger.v("IBG-BR", "checkUserEmailValid :" + (str.isEmpty() ? str2 : "non-empty-email"));
            }
        }
        if ((str == null || str.isEmpty()) && i0Var != null) {
            str = i0Var.s().trim();
            a(str);
        }
        boolean z11 = true;
        if (b.f().q()) {
            if (b.f().p() && (str == null || str.isEmpty())) {
                z11 = false;
            }
            if (str != null && !str.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(str.trim()).matches()) {
                z11 = false;
            }
            if (!z11 && i0Var != null) {
                String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.INVALID_EMAIL_MESSAGE, i0Var.getLocalizedString(R.string.instabug_err_invalid_email));
                if (str != null && !str.isEmpty()) {
                    str2 = "non-empty-email";
                }
                InstabugSDKLogger.v("IBG-BR", "checkUserEmailValid failed with " + str2 + " email");
                i0Var.e(placeHolder);
            }
        }
        return z11;
    }

    public abstract String u();
}
