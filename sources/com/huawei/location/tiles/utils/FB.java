package com.huawei.location.tiles.utils;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.tiles.store.dC;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class FB {

    /* renamed from: yn  reason: collision with root package name */
    private static AtomicInteger f50262yn = new AtomicInteger(0);

    public static void FB() {
        String valueOf = String.valueOf(f50262yn.decrementAndGet());
        yn.yn(valueOf, new File(dC.f50249yn + "DailyDownloads"));
    }

    public static int Vw() {
        String str = dC.f50249yn + "DailyDownloads";
        File file = new File(str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        String format2 = simpleDateFormat.format(Long.valueOf(file.lastModified()));
        if (!file.exists() || !format.equals(format2)) {
            yn.yn(String.valueOf(0), file);
            f50262yn.set(0);
        } else if (f50262yn.get() <= 0) {
            try {
                f50262yn.set(Integer.parseInt(yn.Vw(str)));
            } catch (NumberFormatException e11) {
                LogConsole.e("DailyDownloadsUtil", "get delay downloads error:" + e11.getMessage());
                if (file.delete()) {
                    LogConsole.e("DailyDownloadsUtil", "downloads file delete error:" + e11.getMessage());
                }
            }
        }
        return f50262yn.get();
    }

    public static void yn() {
        String valueOf = String.valueOf(f50262yn.incrementAndGet());
        yn.yn(valueOf, new File(dC.f50249yn + "DailyDownloads"));
    }
}
