package com.instabug.chat.cache;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.chat.model.a;
import com.instabug.chat.model.b;
import com.instabug.chat.model.d;
import com.instabug.chat.model.h;
import com.instabug.chat.model.j;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class k {
    @Nullable
    public static d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        InMemoryCache b11 = b();
        if (b11 != null) {
            for (d dVar : b11.getValues()) {
                if (dVar.getId() != null && dVar.getId().equals(str)) {
                    return dVar;
                }
            }
        }
        InstabugSDKLogger.e("IBG-BR", "No chat with id: " + str + " found, returning null");
        return null;
    }

    public static void a() {
        InstabugSDKLogger.v("IBG-BR", "cleanupChats");
        InMemoryCache b11 = b();
        if (b11 != null) {
            List<d> values = b11.getValues();
            ArrayList<d> arrayList = new ArrayList<>();
            for (d dVar : values) {
                if (dVar.a() == b.WAITING_ATTACHMENT_MESSAGE) {
                    arrayList.add(dVar);
                }
            }
            for (d id2 : arrayList) {
                b11.delete(id2.getId());
            }
        }
        k();
    }

    public static void a(@NonNull Context context, @NonNull com.instabug.chat.model.k kVar) {
        d dVar;
        AssetEntity.AssetType assetType;
        InstabugSDKLogger.v("IBG-BR", "Updating local messages after sync");
        InMemoryCache b11 = b();
        if (b11 != null && kVar.d() != null && (dVar = (d) b11.get(kVar.d())) != null) {
            ArrayList f11 = dVar.f();
            int i11 = 0;
            while (i11 < f11.size()) {
                if (!((com.instabug.chat.model.k) f11.get(i11)).f().equals(kVar.f()) || !((com.instabug.chat.model.k) f11.get(i11)).h().equals(j.READY_TO_BE_SYNCED) || ((com.instabug.chat.model.k) f11.get(i11)).b().size() != kVar.b().size()) {
                    i11++;
                } else {
                    for (int i12 = 0; i12 < ((com.instabug.chat.model.k) f11.get(i11)).b().size(); i12++) {
                        a aVar = (a) kVar.b().get(i12);
                        if (!(aVar == null || aVar.f() == null || aVar.g() == null)) {
                            String f12 = aVar.f();
                            f12.hashCode();
                            char c11 = 65535;
                            switch (f12.hashCode()) {
                                case 93166550:
                                    if (f12.equals(MimeTypes.BASE_TYPE_AUDIO)) {
                                        c11 = 0;
                                        break;
                                    }
                                    break;
                                case 1710800780:
                                    if (f12.equals("extra_video")) {
                                        c11 = 1;
                                        break;
                                    }
                                    break;
                                case 1830389646:
                                    if (f12.equals("video_gallery")) {
                                        c11 = 2;
                                        break;
                                    }
                                    break;
                            }
                            String g11 = aVar.g();
                            switch (c11) {
                                case 0:
                                    assetType = AssetEntity.AssetType.AUDIO;
                                    break;
                                case 1:
                                case 2:
                                    assetType = AssetEntity.AssetType.VIDEO;
                                    break;
                                default:
                                    assetType = AssetEntity.AssetType.IMAGE;
                                    break;
                            }
                            AssetEntity createEmptyEntity = AssetsCacheManager.createEmptyEntity(context, g11, assetType);
                            String c12 = ((a) ((com.instabug.chat.model.k) f11.get(i11)).b().get(i12)).c();
                            if (c12 != null) {
                                File file = new File(c12);
                                DiskUtils.copyFromUriIntoFile(context, Uri.fromFile(file), createEmptyEntity.getFile());
                                AssetsCacheManager.addAssetEntity(createEmptyEntity);
                                file.delete();
                            }
                        }
                    }
                    dVar.f().set(i11, kVar);
                    b11.put(dVar.getId(), dVar);
                    return;
                }
            }
        }
    }

    @Nullable
    public static synchronized InMemoryCache b() {
        InMemoryCache inMemoryCache;
        synchronized (k.class) {
            inMemoryCache = (InMemoryCache) PoolProvider.getChatsCacheExecutor().executeAndGet(new f());
        }
        return inMemoryCache;
    }

    public static long c() {
        ArrayList arrayList = new ArrayList();
        InMemoryCache b11 = b();
        if (b11 != null) {
            for (d f11 : b11.getValues()) {
                Iterator it = f11.f().iterator();
                while (it.hasNext()) {
                    com.instabug.chat.model.k kVar = (com.instabug.chat.model.k) it.next();
                    if (kVar.h() == j.SYNCED) {
                        arrayList.add(kVar);
                    }
                }
            }
        }
        Collections.sort(arrayList, new h());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            com.instabug.chat.model.k kVar2 = (com.instabug.chat.model.k) arrayList.get(size);
            if (!kVar2.f().equals("0")) {
                return kVar2.i();
            }
        }
        return 0;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        InMemoryCache b11 = b();
        if (b11 != null) {
            for (d f11 : b11.getValues()) {
                Iterator it = f11.f().iterator();
                while (it.hasNext()) {
                    com.instabug.chat.model.k kVar = (com.instabug.chat.model.k) it.next();
                    if (kVar.h() == j.SENT || kVar.h() == j.READY_TO_BE_SENT) {
                        arrayList.add(kVar);
                    }
                }
            }
        }
        InstabugSDKLogger.v("IBG-BR", "not sent messages count: " + arrayList.size());
        return arrayList;
    }

    public static synchronized List e() {
        ArrayList arrayList;
        synchronized (k.class) {
            arrayList = new ArrayList();
            InMemoryCache b11 = b();
            if (b11 != null) {
                for (d dVar : b11.getValues()) {
                    if (dVar.a() != null && ((dVar.a().equals(b.READY_TO_BE_SENT) || dVar.a().equals(b.LOGS_READY_TO_BE_UPLOADED)) && dVar.f().size() > 0)) {
                        arrayList.add(dVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List f() {
        ArrayList arrayList = new ArrayList();
        InMemoryCache b11 = b();
        if (b11 != null) {
            for (d dVar : b11.getValues()) {
                if (dVar.a() != null && dVar.a().equals(b.SENT)) {
                    Iterator it = dVar.f().iterator();
                    while (it.hasNext()) {
                        com.instabug.chat.model.k kVar = (com.instabug.chat.model.k) it.next();
                        if (kVar.h().equals(j.READY_TO_BE_SENT) || kVar.h().equals(j.SENT)) {
                            arrayList.add(kVar);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static int g() {
        InMemoryCache b11 = b();
        int i11 = 0;
        if (b11 != null) {
            for (d f11 : b11.getValues()) {
                Iterator it = f11.f().iterator();
                while (it.hasNext()) {
                    if (((com.instabug.chat.model.k) it.next()).h().equals(j.SYNCED)) {
                        i11++;
                    }
                }
            }
        }
        return i11;
    }

    public static int h() {
        InMemoryCache b11 = b();
        int i11 = 0;
        if (b11 != null) {
            for (d j11 : b11.getValues()) {
                i11 += j11.j();
            }
        }
        return i11;
    }

    public static List i() {
        ArrayList arrayList = new ArrayList();
        InMemoryCache b11 = b();
        if (b11 != null) {
            for (d dVar : b11.getValues()) {
                if (dVar.f().size() > 0) {
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    public static void j() {
        PoolProvider.getChatsCacheExecutor().execute(new j());
    }

    public static void k() {
        InstabugSDKLogger.d("IBG-BR", "Persisting chats to disk");
        PoolProvider.getChatsCacheExecutor().execute(new h());
    }
}
