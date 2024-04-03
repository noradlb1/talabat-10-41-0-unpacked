package com.instabug.chat.ui.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.cache.m;
import com.instabug.chat.model.a;
import com.instabug.chat.model.d;
import com.instabug.chat.model.h;
import com.instabug.chat.model.i;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.chat.model.o;
import com.instabug.chat.network.f;
import com.instabug.chat.notification.v;
import com.instabug.chat.screenrecording.c;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.chat.synchronization.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.CacheChangedListener;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.internal.video.RequestPermissionActivity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.VideoManipulationUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
class l extends BasePresenter implements d, CacheChangedListener, b {

    /* renamed from: a  reason: collision with root package name */
    private PublishSubject f46228a;

    /* renamed from: b  reason: collision with root package name */
    private Disposable f46229b;

    /* renamed from: c  reason: collision with root package name */
    private Disposable f46230c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f46231d;

    public l(e eVar) {
        super(eVar);
    }

    @RequiresApi(api = 19)
    private void a(e eVar, Intent intent) {
        Pair<String, String> fileNameAndSize;
        if (eVar.getViewContext() != null && ((Fragment) eVar.getViewContext()).getContext() != null && (fileNameAndSize = AttachmentsUtility.getFileNameAndSize(((Fragment) eVar.getViewContext()).getContext(), intent.getData())) != null) {
            Object obj = fileNameAndSize.first;
            String str = (String) obj;
            String extension = obj != null ? FileUtils.getExtension(str) : null;
            Object obj2 = fileNameAndSize.second;
            String str2 = obj2 != null ? (String) obj2 : "0";
            if (extension == null) {
                InstabugSDKLogger.e("IBG-BR", "Selected file extension is null");
            } else if (FileUtils.isImageExtension(extension)) {
                h();
                File fileFromContentProvider = AttachmentsUtility.getFileFromContentProvider(((Fragment) eVar.getViewContext()).getContext(), intent.getData(), str);
                if (fileFromContentProvider != null) {
                    a(a(Uri.fromFile(fileFromContentProvider), "image_gallery"));
                }
            } else if (FileUtils.isVideoExtension(extension)) {
                try {
                    if ((Long.parseLong(str2) / 1024) / 1024 > 50) {
                        eVar.h();
                        InstabugSDKLogger.e("IBG-BR", "Selected video size exceeded the limit");
                        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
                        if (chatPlugin != null) {
                            chatPlugin.setState(1);
                            return;
                        }
                        return;
                    }
                    File fileFromContentProvider2 = AttachmentsUtility.getFileFromContentProvider(((Fragment) eVar.getViewContext()).getContext(), intent.getData(), str);
                    if (fileFromContentProvider2 == null) {
                        InstabugSDKLogger.e("IBG-BR", "Selected video file was null");
                    } else if (VideoManipulationUtils.extractVideoDuration(fileFromContentProvider2.getPath()) > 60000) {
                        eVar.d();
                        InstabugSDKLogger.e("IBG-BR", "Selected video length exceeded the limit");
                        if (fileFromContentProvider2.delete()) {
                            InstabugSDKLogger.v("IBG-BR", "file deleted");
                        }
                    } else {
                        h();
                        a(a(Uri.fromFile(fileFromContentProvider2)));
                    }
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-BR", "Error while selecting video from gallery", e11);
                }
            }
        }
    }

    private void a(CacheChangedListener cacheChangedListener) {
        try {
            CacheManager.getInstance().subscribe("chats_memory_cache", cacheChangedListener);
        } catch (IllegalArgumentException e11) {
            InstabugSDKLogger.e("ChatPresenter", "Couldn't subscribe to cache", e11);
            IBGDiagnostics.reportNonFatal(e11, "Couldn't subscribe to cache");
        }
    }

    private boolean a(Disposable disposable) {
        return disposable != null && !disposable.isDisposed();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void b(e eVar, @NonNull Intent intent) {
        a a11;
        if (eVar.getViewContext() != null && ((Fragment) eVar.getViewContext()).getActivity() != null) {
            String galleryImagePath = AttachmentsUtility.getGalleryImagePath(((Fragment) eVar.getViewContext()).getActivity(), intent.getData());
            if (galleryImagePath == null && intent.getData() != null) {
                galleryImagePath = intent.getData().getPath();
            }
            String extension = FileUtils.getExtension(galleryImagePath);
            Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(((Fragment) eVar.getViewContext()).getContext(), Uri.fromFile(new File(galleryImagePath)));
            if (newFileAttachmentUri != null) {
                if (FileUtils.isImageExtension(extension)) {
                    h();
                    a11 = a(newFileAttachmentUri, "image_gallery");
                } else if (!FileUtils.isVideoExtension(extension)) {
                    return;
                } else {
                    if ((new File(galleryImagePath).length() / 1024) / 1024 > 50) {
                        eVar.h();
                        return;
                    } else if (VideoManipulationUtils.extractVideoDuration(galleryImagePath) > 60000) {
                        eVar.d();
                        return;
                    } else {
                        h();
                        a11 = a(newFileAttachmentUri);
                    }
                }
                a(a11);
            }
        }
    }

    private void b(List list) {
        int size = list.size() - 1;
        while (size >= 0) {
            if (((k) list.get(size)).o() || ((k) list.get(size)).p()) {
                size--;
            } else {
                o oVar = new o();
                oVar.a(((k) list.get(size)).d());
                oVar.b(((k) list.get(size)).f());
                oVar.a(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds());
                m.b().a(oVar);
                return;
            }
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    private d c(String str) {
        return (com.instabug.chat.cache.k.b() == null || com.instabug.chat.cache.k.a(str) == null) ? new d() : com.instabug.chat.cache.k.a(str);
    }

    private void d(d dVar) {
        e eVar;
        b((List) dVar.f());
        Collections.sort(dVar.f(), new h());
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (eVar = (e) weakReference.get()) != null) {
            eVar.a(dVar.f());
            eVar.p();
        }
    }

    private void d(String str) {
        if (str.equals(this.f46231d.getId())) {
            this.f46228a.onNext(str);
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        d c11 = c(str);
        this.f46231d = c11;
        if (c11 != null) {
            d(c11);
        }
    }

    private a k() {
        a aVar = new a();
        aVar.d("offline");
        return aVar;
    }

    private void l() {
        e eVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (eVar = (e) weakReference.get()) != null) {
            if (com.instabug.chat.cache.k.i().size() > 0) {
                eVar.o();
            } else {
                eVar.n();
            }
        }
    }

    private void m() {
        e eVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (eVar = (e) weakReference.get()) != null) {
            if (com.instabug.chat.settings.a.h()) {
                eVar.j();
            } else {
                eVar.e();
            }
        }
    }

    private boolean n() {
        return SettingsManager.getInstance().isScreenshotByMediaProjectionEnabled();
    }

    private void o() {
        if (this.f46231d.a() == com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE) {
            this.f46231d.a(com.instabug.chat.model.b.READY_TO_BE_SENT);
        }
    }

    private void q() {
        if (!a(this.f46230c)) {
            this.f46230c = com.instabug.chat.eventbus.b.a().subscribe(new k(this));
        }
    }

    private void r() {
        PublishSubject create = PublishSubject.create();
        this.f46228a = create;
        this.f46229b = create.debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this));
    }

    private void s() {
        if (a(this.f46230c)) {
            this.f46230c.dispose();
        }
    }

    private void t() {
        if (a(this.f46229b)) {
            this.f46229b.dispose();
        }
    }

    public a a(Uri uri) {
        a k11 = k();
        k11.e("video_gallery").b(uri.getPath());
        k11.a(true);
        return k11;
    }

    public a a(Uri uri, String str) {
        a k11 = k();
        k11.e(str).b(uri.getPath()).c(uri.getLastPathSegment());
        return k11;
    }

    public k a(String str, a aVar) {
        k a11 = a(str, "");
        a11.a(aVar);
        return a11;
    }

    public k a(String str, String str2) {
        k kVar = new k(UserManagerWrapper.getUserName(), UserManagerWrapper.getUserEmail(), InstabugCore.getPushNotificationToken());
        kVar.b(str).a(str2).a(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()).b(InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()).a(i.INBOUND).e(InstabugCore.getIdentifiedUsername()).a(j.READY_TO_BE_SENT);
        return kVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012e, code lost:
        if (r1.a().size() > 0) goto L_0x0176;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(java.util.List r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0009:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x017e
            java.lang.Object r1 = r8.next()
            com.instabug.chat.model.k r1 = (com.instabug.chat.model.k) r1
            java.util.ArrayList r2 = r1.b()
            if (r2 == 0) goto L_0x00ec
            java.util.ArrayList r2 = r1.b()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x00ec
            java.util.ArrayList r2 = r1.b()
            java.util.Iterator r2 = r2.iterator()
        L_0x002d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00ec
            java.lang.Object r3 = r2.next()
            com.instabug.chat.model.a r3 = (com.instabug.chat.model.a) r3
            com.instabug.chat.model.g r4 = new com.instabug.chat.model.g
            r4.<init>()
            java.lang.String r5 = r1.c()
            com.instabug.chat.model.g r4 = r4.a((java.lang.String) r5)
            java.lang.String r5 = r1.m()
            com.instabug.chat.model.g r4 = r4.c(r5)
            long r5 = r1.i()
            com.instabug.chat.model.g r4 = r4.a((long) r5)
            java.lang.String r5 = r3.g()
            com.instabug.chat.model.g r4 = r4.d(r5)
            java.lang.String r5 = r3.c()
            com.instabug.chat.model.g r4 = r4.b(r5)
            boolean r5 = r1.o()
            com.instabug.chat.model.g r4 = r4.a((boolean) r5)
            java.lang.String r5 = r3.f()
            if (r5 == 0) goto L_0x00e7
            java.lang.String r3 = r3.f()
            r3.hashCode()
            int r5 = r3.hashCode()
            r6 = -1
            switch(r5) {
                case -831439762: goto L_0x00c6;
                case 93166550: goto L_0x00bb;
                case 100313435: goto L_0x00b0;
                case 112202875: goto L_0x00a5;
                case 1698911340: goto L_0x009a;
                case 1710800780: goto L_0x008f;
                case 1830389646: goto L_0x0084;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x00d0
        L_0x0084:
            java.lang.String r5 = "video_gallery"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x008d
            goto L_0x00d0
        L_0x008d:
            r6 = 6
            goto L_0x00d0
        L_0x008f:
            java.lang.String r5 = "extra_video"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0098
            goto L_0x00d0
        L_0x0098:
            r6 = 5
            goto L_0x00d0
        L_0x009a:
            java.lang.String r5 = "extra_image"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00a3
            goto L_0x00d0
        L_0x00a3:
            r6 = 4
            goto L_0x00d0
        L_0x00a5:
            java.lang.String r5 = "video"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00ae
            goto L_0x00d0
        L_0x00ae:
            r6 = 3
            goto L_0x00d0
        L_0x00b0:
            java.lang.String r5 = "image"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00b9
            goto L_0x00d0
        L_0x00b9:
            r6 = 2
            goto L_0x00d0
        L_0x00bb:
            java.lang.String r5 = "audio"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00c4
            goto L_0x00d0
        L_0x00c4:
            r6 = 1
            goto L_0x00d0
        L_0x00c6:
            java.lang.String r5 = "image_gallery"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r6 = 0
        L_0x00d0:
            switch(r6) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00d7;
                case 2: goto L_0x00e2;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00d4;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            goto L_0x00e7
        L_0x00d4:
            com.instabug.chat.model.f r3 = com.instabug.chat.model.f.f46034d
            goto L_0x00e4
        L_0x00d7:
            com.instabug.chat.model.f r3 = com.instabug.chat.model.f.AUDIO
            r4.a((com.instabug.chat.model.f) r3)
            com.instabug.chat.model.e r3 = com.instabug.chat.model.e.f46028a
            r4.a((com.instabug.chat.model.e) r3)
            goto L_0x00e7
        L_0x00e2:
            com.instabug.chat.model.f r3 = com.instabug.chat.model.f.f46032b
        L_0x00e4:
            r4.a((com.instabug.chat.model.f) r3)
        L_0x00e7:
            r0.add(r4)
            goto L_0x002d
        L_0x00ec:
            java.lang.String r2 = r1.c()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0136
            com.instabug.chat.model.g r2 = new com.instabug.chat.model.g
            r2.<init>()
            java.lang.String r3 = r1.c()
            com.instabug.chat.model.g r3 = r2.a((java.lang.String) r3)
            java.lang.String r4 = r1.m()
            com.instabug.chat.model.g r3 = r3.c(r4)
            long r4 = r1.i()
            com.instabug.chat.model.g r3 = r3.a((long) r4)
            boolean r4 = r1.o()
            com.instabug.chat.model.g r3 = r3.a((boolean) r4)
            com.instabug.chat.model.f r4 = com.instabug.chat.model.f.MESSAGE
            r3.a((com.instabug.chat.model.f) r4)
            java.util.ArrayList r3 = r1.a()
            if (r3 == 0) goto L_0x0131
            java.util.ArrayList r3 = r1.a()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0131
            goto L_0x0176
        L_0x0131:
            r0.add(r2)
            goto L_0x0009
        L_0x0136:
            boolean r2 = r1.o()
            if (r2 != 0) goto L_0x0009
            java.util.ArrayList r2 = r1.a()
            if (r2 == 0) goto L_0x0009
            java.util.ArrayList r2 = r1.a()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0009
            com.instabug.chat.model.g r2 = new com.instabug.chat.model.g
            r2.<init>()
            java.lang.String r3 = r1.c()
            com.instabug.chat.model.g r3 = r2.a((java.lang.String) r3)
            java.lang.String r4 = r1.m()
            com.instabug.chat.model.g r3 = r3.c(r4)
            long r4 = r1.i()
            com.instabug.chat.model.g r3 = r3.a((long) r4)
            boolean r4 = r1.o()
            com.instabug.chat.model.g r3 = r3.a((boolean) r4)
            com.instabug.chat.model.f r4 = com.instabug.chat.model.f.MESSAGE
            r3.a((com.instabug.chat.model.f) r4)
        L_0x0176:
            java.util.ArrayList r1 = r1.a()
            r2.a((java.util.ArrayList) r1)
            goto L_0x0131
        L_0x017e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.ui.chat.l.a(java.util.List):java.util.List");
    }

    public void a() {
        if (n()) {
            e eVar = (e) this.f34200f.get();
            if (eVar != null) {
                eVar.f();
                return;
            }
            return;
        }
        p();
    }

    public void a(int i11, int i12, Intent intent) {
        e eVar = (e) this.f34200f.get();
        if (eVar != null) {
            FragmentActivity activity = ((Fragment) eVar.getViewContext()).getActivity();
            if (i11 == 161) {
                if (!(i12 != -1 || intent == null || intent.getData() == null || activity == null)) {
                    a(eVar, intent);
                }
                ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
                if (chatPlugin != null) {
                    chatPlugin.setState(1);
                }
            } else if (i11 != 2030) {
                if (i11 == 3890 && i12 == -1 && intent != null) {
                    InstabugMediaProjectionIntent.setMediaProjectionIntent(intent);
                    a(intent);
                }
            } else if (intent != null && intent.getBooleanExtra(RequestPermissionActivity.KEY_IS_PERMISSION_GRANDTED, false)) {
                p();
            }
        }
    }

    public void a(Intent intent) {
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null) {
            e eVar = (e) weakReference.get();
            c.a().c(this.f46231d.getId());
            this.f46231d.a(com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE);
            if (eVar != null) {
                eVar.finishActivity();
            }
            ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
            if (chatPlugin != null) {
                chatPlugin.setState(2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.instabug.chat.model.a r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.f()
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = r4.c()
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = r4.f()
            int r1 = r0.hashCode()
            r2 = 1
            switch(r1) {
                case -831439762: goto L_0x0041;
                case 93166550: goto L_0x0037;
                case 1698911340: goto L_0x002d;
                case 1710800780: goto L_0x0023;
                case 1830389646: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x004b
        L_0x0019:
            java.lang.String r1 = "video_gallery"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 3
            goto L_0x004c
        L_0x0023:
            java.lang.String r1 = "extra_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 4
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "extra_image"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = r2
            goto L_0x004c
        L_0x0037:
            java.lang.String r1 = "audio"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 2
            goto L_0x004c
        L_0x0041:
            java.lang.String r1 = "image_gallery"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004b
            r0 = 0
            goto L_0x004c
        L_0x004b:
            r0 = -1
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            if (r0 == r2) goto L_0x0051
            goto L_0x0061
        L_0x0051:
            java.lang.ref.WeakReference<V> r0 = r3.f34200f
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r0.get()
            com.instabug.chat.ui.chat.e r0 = (com.instabug.chat.ui.chat.e) r0
            boolean r1 = com.instabug.chat.settings.a.m()
            if (r1 == 0) goto L_0x006f
        L_0x0061:
            com.instabug.chat.model.d r0 = r3.f46231d
            java.lang.String r0 = r0.getId()
            com.instabug.chat.model.k r4 = r3.a((java.lang.String) r0, (com.instabug.chat.model.a) r4)
            r3.a((com.instabug.chat.model.k) r4)
            goto L_0x0085
        L_0x006f:
            if (r0 == 0) goto L_0x0085
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r4.c()
            r1.<init>(r2)
            android.net.Uri r1 = android.net.Uri.fromFile(r1)
            java.lang.String r4 = r4.f()
            r0.a(r1, r4)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.ui.chat.l.a(com.instabug.chat.model.a):void");
    }

    /* renamed from: a */
    public void onCachedItemAdded(d dVar) {
        d(dVar.getId());
    }

    /* renamed from: a */
    public void onCachedItemUpdated(d dVar, d dVar2) {
        d(dVar2.getId());
    }

    public void a(k kVar) {
        e eVar;
        this.f46231d.f().add(kVar);
        if (this.f46231d.getState() == null) {
            this.f46231d.a(com.instabug.chat.model.b.SENT);
        }
        InMemoryCache b11 = com.instabug.chat.cache.k.b();
        if (b11 != null) {
            b11.put(this.f46231d.getId(), this.f46231d);
            com.instabug.chat.cache.k.k();
        }
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (eVar = (e) weakReference.get()) != null && ((Fragment) eVar.getViewContext()).getContext() != null) {
            f.b().start();
        }
    }

    /* renamed from: b */
    public void onCachedItemRemoved(d dVar) {
        d(dVar.getId());
    }

    public void b(String str) {
        this.f46231d = c(str);
        l();
        m();
        d(this.f46231d);
        c(this.f46231d);
        if (SynchronizationManager.getInstance() != null) {
            SynchronizationManager.getInstance().sync();
        }
    }

    public void c() {
        InMemoryCache b11;
        d dVar = this.f46231d;
        if (dVar != null && dVar.f().size() == 0 && this.f46231d.a() != com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE && (b11 = com.instabug.chat.cache.k.b()) != null) {
            b11.delete(this.f46231d.getId());
        }
    }

    public void c(d dVar) {
        dVar.k();
        if (com.instabug.chat.cache.k.b() != null) {
            com.instabug.chat.cache.k.b().put(dVar.getId(), dVar);
        }
    }

    public d d() {
        return this.f46231d;
    }

    public void e() {
        CacheManager.getInstance().unSubscribe("chats_memory_cache", this);
        com.instabug.chat.synchronization.a.b().b((b) this);
        s();
        t();
    }

    public void h() {
        o();
        r();
        a((CacheChangedListener) this);
        com.instabug.chat.synchronization.a.b().a((b) this);
        q();
    }

    public void j() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getAppContext() != null && this.f46231d != null) {
            InstabugSDKLogger.v("IBG-BR", "picking image from gallery");
            chatPlugin.setState(2);
            this.f46231d.a(com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE);
            e eVar = (e) this.f34200f.get();
            if (eVar != null) {
                eVar.r();
            }
        }
    }

    public void onCacheInvalidated() {
        InstabugSDKLogger.d("IBG-BR", "Chats cache was invalidated, Time: " + System.currentTimeMillis());
    }

    public List onNewMessagesReceived(@NonNull List list) {
        e eVar;
        WeakReference<V> weakReference = this.f34200f;
        if (!(weakReference == null || (eVar = (e) weakReference.get()) == null || ((Fragment) eVar.getViewContext()).getActivity() == null)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar.d() != null && kVar.d().equals(this.f46231d.getId())) {
                    list.remove(kVar);
                    v.a().b((Context) ((Fragment) eVar.getViewContext()).getActivity());
                    c(this.f46231d);
                }
            }
        }
        return list;
    }

    public void p() {
        e eVar;
        SettingsManager.getInstance().setProcessingForeground(false);
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getAppContext() != null && this.f46231d != null) {
            InstabugSDKLogger.v("IBG-BR", "taking extra screenshot");
            chatPlugin.setState(2);
            this.f46231d.a(com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE);
            com.instabug.chat.screenshot.a.a().a(chatPlugin.getAppContext(), this.f46231d.getId());
            WeakReference<V> weakReference = this.f34200f;
            if (weakReference != null && (eVar = (e) weakReference.get()) != null) {
                eVar.finishActivity();
            }
        }
    }
}
