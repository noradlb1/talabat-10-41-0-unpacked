package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.core.log.HiLog;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import java.io.File;
import java.io.IOException;

public final class br {
    private String klm;
    Context lmn;

    public br() {
        Context context = av.lmn().lmn.ghi;
        this.lmn = context;
        this.klm = context.getFilesDir().getPath();
    }

    private String klm(String str) {
        return this.klm + "/openness/component/".replace(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY, str);
    }

    private static boolean klm(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            HiLog.w("ComponentCommander", "create new file error!");
            return false;
        }
    }

    public static boolean lmn() {
        ax axVar = av.lmn().lmn;
        return lmn(new File(axVar.ghi.getFilesDir().getPath() + "/openness"));
    }

    private static boolean lmn(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    HiLog.i("ComponentCommander", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                lmn(file2);
            }
        }
        return file.delete();
    }

    public final String lmn(String str) {
        File file = new File(klm(str), "hianalytics_".concat(String.valueOf(str)));
        if (klm(file)) {
            return dw.lmn(file);
        }
        String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(128);
        dw.lmn(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    public final void lmn(String str, String str2) {
        File file = new File(klm(str));
        File file2 = new File(klm(str), "hianalytics_".concat(String.valueOf(str)));
        if (!file.exists() && file.mkdirs()) {
            HiLog.i("ComponentCommander", "file directory is mkdirs");
        }
        if (klm(file2)) {
            dw.lmn(file2, str2);
        } else {
            HiLog.w("ComponentCommander", "refreshComponent():file is not found,and file is create failed");
        }
    }
}
