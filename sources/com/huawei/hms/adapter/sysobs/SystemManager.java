package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SystemManager {

    /* renamed from: a  reason: collision with root package name */
    private static SystemManager f47808a = new SystemManager();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f47809b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static SystemNotifier f47810c = new a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f47808a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f47810c;
    }

    public void notifyNoticeResult(int i11) {
        f47810c.notifyNoticeObservers(i11);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f47810c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i11) {
        f47810c.notifyObservers(i11);
    }

    public class a implements SystemNotifier {

        /* renamed from: a  reason: collision with root package name */
        private final List<SystemObserver> f47811a = new ArrayList();

        public void notifyNoticeObservers(int i11) {
            synchronized (SystemManager.f47809b) {
                Iterator<SystemObserver> it = this.f47811a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i11)) {
                        it.remove();
                    }
                }
            }
        }

        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f47809b) {
                Iterator<SystemObserver> it = this.f47811a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver != null && !this.f47811a.contains(systemObserver)) {
                synchronized (SystemManager.f47809b) {
                    this.f47811a.add(systemObserver);
                }
            }
        }

        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f47809b) {
                this.f47811a.remove(systemObserver);
            }
        }

        public void notifyObservers(int i11) {
            synchronized (SystemManager.f47809b) {
                Iterator<SystemObserver> it = this.f47811a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i11)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
