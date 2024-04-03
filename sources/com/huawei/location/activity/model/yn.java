package com.huawei.location.activity.model;

import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.activity.RiemannSoftArService;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.List;

public class yn {
    private int E5 = 0;
    private int FB = -2;
    private int LW = -2;
    private int Vw = -2;

    /* renamed from: d2  reason: collision with root package name */
    private int f49991d2 = 0;
    private int dC = 0;

    /* renamed from: ut  reason: collision with root package name */
    private Vw f49992ut = new Vw();

    /* renamed from: yn  reason: collision with root package name */
    public List<DetectedActivity> f49993yn;

    /* renamed from: zp  reason: collision with root package name */
    private int f49994zp = 0;

    public class Vw implements ARCallback {
        private Vw() {
        }

        public void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            yn.this.f49993yn = activityRecognitionResult.getProbableActivities();
            yn ynVar = yn.this;
            List<DetectedActivity> list = ynVar.f49993yn;
            if (list == null) {
                LogConsole.e("ATProvider", "detectedActivities is null.");
                return;
            }
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < list.size(); i13++) {
                if (list.get(i13).getType() != 2 && list.get(i13).getConfidence() > i12) {
                    i11 = list.get(i13).getType();
                    i12 = list.get(i13).getConfidence();
                }
            }
            yn.a(ynVar, i11);
        }
    }

    public static void a(yn ynVar, int i11) {
        ynVar.getClass();
        LogConsole.i("ATProvider", " GET NEW RESULT : " + i11 + " currentStatus is : " + ynVar.Vw);
        ynVar.FB = i11;
        int i12 = ynVar.Vw;
        if (i12 == -2) {
            ynVar.Vw = i11;
            ynVar.yn(i11, 1);
        } else if (i11 != i12) {
            int i13 = ynVar.E5 + 1;
            ynVar.E5 = i13;
            ynVar.dC = 1;
            int i14 = ynVar.LW;
            if (i14 == -2 || i14 == -1) {
                ynVar.LW = i11;
                return;
            }
            if (i13 == 10 && i12 != -1) {
                ynVar.yn(i12, 2);
                ynVar.Vw = -1;
            }
            int i15 = ynVar.FB;
            if (i15 == ynVar.LW) {
                ynVar.f49991d2++;
            } else {
                ynVar.LW = i15;
                ynVar.f49991d2 = 1;
            }
            if (ynVar.f49991d2 >= 10) {
                ynVar.dC = 0;
                ynVar.E5 = 0;
                ynVar.f49991d2 = 0;
                ynVar.f49994zp = 0;
                int i16 = ynVar.LW;
                ynVar.Vw = i16;
                ynVar.LW = -1;
                ynVar.yn(i16, 1);
            }
        } else if (ynVar.dC != 0) {
            int i17 = ynVar.f49994zp + 1;
            ynVar.f49994zp = i17;
            if (i17 >= 10) {
                ynVar.dC = 0;
                ynVar.E5 = 0;
                ynVar.f49991d2 = 0;
                ynVar.f49994zp = 0;
            }
        }
    }

    private void yn(int i11, int i12) {
        LogConsole.i("ATProvider", "report ！  statu is : " + this.Vw + " inOrOut is : " + i12);
        RiemannSoftArService.getInstance().onStatusChanged(i11, i12);
    }

    public void Vw() {
        this.Vw = -2;
        this.FB = -2;
        this.LW = -2;
        this.dC = 0;
        this.E5 = 0;
        this.f49991d2 = 0;
        this.f49994zp = 0;
    }

    public Vw yn() {
        return this.f49992ut;
    }
}
