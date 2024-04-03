package com.instabug.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class f {
    @Nullable
    public ActivityManager.ProcessErrorStateInfo a() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        Context applicationContext = Instabug.getApplicationContext();
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (!(applicationContext == null || (processesInErrorState = ((ActivityManager) applicationContext.getSystemService("activity")).getProcessesInErrorState()) == null)) {
            try {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next.pid == Process.myPid()) {
                        processErrorStateInfo = next;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return processErrorStateInfo;
    }

    public String b(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        String str = processErrorStateInfo.longMsg;
        if (str == null) {
            return "";
        }
        if (str.length() >= 200) {
            return processErrorStateInfo.longMsg.substring(0, Opcodes.IFNONNULL);
        }
        return processErrorStateInfo.longMsg;
    }
}
