package com.uxcam.internals;

import android.content.Context;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.uxcam.internals.gu;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import mz.s;

public class gc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f13431a;

    public class aa implements Comparator {
        public aa(gc gcVar) {
        }

        public int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file.lastModified() > file2.lastModified()) {
                return -1;
            }
            if (file.lastModified() < file2.lastModified()) {
                return 1;
            }
            return 0;
        }
    }

    public gc(Context context) {
        this.f13431a = context;
    }

    public void a() {
        int i11 = gm.f13452a;
        try {
            a(true);
        } catch (Exception e11) {
            gu.f13504c.getClass();
            fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
            a11.a("site_of_error", "SendOfflineData::deleteOfflineData()");
            a11.a("reason", e11.getMessage());
            a11.a(2);
        }
    }

    public void b() {
        int i11 = gm.f13452a;
        try {
            a(false);
        } catch (Exception e11) {
            gu.f13504c.getClass();
            fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
            a11.a("site_of_error", "SendOfflineData::uploadOfflineData()");
            a11.a("reason", e11.getMessage());
            a11.a(2);
        }
    }

    public final void a(boolean z11) {
        File[] listFiles;
        try {
            File[] listFiles2 = new File(by.a()).listFiles();
            if (listFiles2 == null) {
                fx a11 = new fx().a("Process offline files on session");
                a11.a("site_of_error", "SendOfflineData::ProcessFilesInSDCard()");
                a11.a("reason", "Folder is empty");
                a11.a(1);
                return;
            }
            Arrays.sort(listFiles2, new aa(this));
            fx a12 = new fx().a("Processing Previous Session");
            a12.a("site_of_error", "SendOfflineData::ProcessFilesInSDCard()");
            a12.a("sessionCount", "" + (listFiles2.length - 1));
            a12.a(1);
            for (File file : listFiles2) {
                if (!file.getName().equals(gm.f13453b) && (listFiles = file.listFiles()) != null) {
                    if (listFiles.length == 0) {
                        file.delete();
                    } else if (z11) {
                        if (!ia.a(file)) {
                            ia.c(file);
                        } else {
                            ia.b(file);
                            new bj("").a(1, by.a() + "/" + file.getName() + "/");
                        }
                    } else if (bh.a(this.f13431a)) {
                        String name2 = file.getName();
                        String str = hm.e().f12942b;
                        Iterator it = af.a().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String str2 = (String) it.next();
                            if (name2.endsWith(String.valueOf(str2.hashCode()))) {
                                str = str2;
                                break;
                            }
                        }
                        b(file, str);
                    }
                }
            }
        } catch (Exception e11) {
            gu.f13504c.getClass();
            fx a13 = new fx().a(AgentHealth.DEFAULT_KEY);
            a13.a("site_of_error", "SendOfflineData::ProcessFilesInSDCard()");
            a13.a("reason", e11.getMessage());
            a13.a(2);
        }
    }

    public final void b(File file, String str) {
        boolean z11;
        File[] listFiles = file.listFiles(new s());
        if (listFiles != null) {
            a(listFiles);
            if (listFiles.length > 0) {
                Iterator it = HttpPostService.f13679b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z11 = true;
                        break;
                    }
                    if (file.getAbsolutePath().equals((String) it.next())) {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    ae aeVar = new ae();
                    aeVar.f12978d = true;
                    Context context = this.f13431a;
                    aeVar.f12975a = context;
                    aeVar.f12976b = file;
                    if (file.exists()) {
                        new ij(context).a(aeVar, str);
                        return;
                    }
                    return;
                }
                gu.ab a11 = gu.a("gc");
                file.toString();
                a11.getClass();
            }
        }
    }

    public static boolean a(File file, String str) {
        return by.a(str) || str.startsWith("data") || str.startsWith("icon");
    }

    public final void a(File[] fileArr) {
        int length = fileArr.length;
        int i11 = 0;
        while (i11 < length) {
            File file = fileArr[i11];
            if (file.length() != 0 || file.getName().startsWith("icon")) {
                if (file.getName().contains(".aes")) {
                    ia.c(file);
                    fx a11 = new fx().a("Unexpected File found");
                    a11.a("site_of_error", "SendOfflineData::deleteSessionIfUnexpectedlyClosed");
                    a11.a("desc", "delete .aes file").a("directory", file.getPath()).a("event_happened", (float) System.currentTimeMillis()).a(3);
                } else if (file.getName().contains(".mp4")) {
                    try {
                        il ilVar = new il(file);
                        ilVar.a();
                        ia.c(file);
                        ia.c(ilVar.f13644b);
                    } catch (Exception unused) {
                        fx a12 = new fx().a("Unexpected File found");
                        a12.a("site_of_error", "SendOfflineData::deleteSessionIfUnexpectedlyClosed");
                        a12.a("desc", "re-encrypt video file").a("directory", file.getPath()).a("event_happened", (float) System.currentTimeMillis()).a(3);
                    }
                }
                i11++;
            } else {
                ia.c(file.getParentFile());
                fx a13 = new fx().a("Unexpected Session End");
                a13.a("site_of_error", "SendOfflineData::deleteSessionIfUnexpectedlyClosed");
                a13.a("directory", file.getParentFile().getName()).a("event_happened", (float) System.currentTimeMillis()).a(2);
                new bj("").a(3, by.a() + "/" + file.getParentFile().getName() + "/");
                return;
            }
        }
    }
}
