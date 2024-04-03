package com.instabug.commons.snapshot;

import com.instabug.commons.logging.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CaptorsRegistry {
    @NotNull
    private final Map<Integer, Set<Integer>> registry = new LinkedHashMap();
    @NotNull
    private final List<Captor> running = new ArrayList();

    private final Captor getRunningCaptorInstance(int i11) {
        T t11;
        boolean z11;
        Iterator<T> it = this.running.iterator();
        while (true) {
            if (!it.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it.next();
            Captor captor = (Captor) t11;
            if (captor.getId() != i11 || captor.isShutdown()) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (Captor) t11;
    }

    private final boolean isCaptorRegisteredForAnotherLauncher(int i11, int i12) {
        boolean z11;
        Map<Integer, Set<Integer>> map = this.registry;
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Number) next.getKey()).intValue() == i11 || !((Set) next.getValue()).contains(Integer.valueOf(i12))) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final boolean isCaptorRegisteredForLauncher(int i11, int i12) {
        boolean z11;
        Map<Integer, Set<Integer>> map = this.registry;
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Number) next.getKey()).intValue() != i11 || !((Set) next.getValue()).contains(Integer.valueOf(i12))) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInstanceOfCaptorRunning(int i11) {
        boolean z11;
        List<Captor> list = this.running;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (Captor captor : list) {
            if (captor.getId() != i11 || captor.isShutdown()) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final Object registerCaptorForLauncher(int i11, Captor captor) {
        Map<Integer, Set<Integer>> map = this.registry;
        Set set = map.get(Integer.valueOf(i11));
        Boolean valueOf = set == null ? null : Boolean.valueOf(set.add(Integer.valueOf(captor.getId())));
        if (valueOf != null) {
            return valueOf;
        }
        return map.put(Integer.valueOf(i11), SetsKt__SetsKt.mutableSetOf(Integer.valueOf(captor.getId())));
    }

    private final Boolean removeCaptorForLauncher(int i11, int i12) {
        Set set = this.registry.get(Integer.valueOf(i11));
        if (set == null) {
            return null;
        }
        return Boolean.valueOf(set.remove(Integer.valueOf(i12)));
    }

    public final void force(int i11, int i12) {
        synchronized (this) {
            a.b("Forcing captor " + i12 + " for launcher: " + i11);
            if (isCaptorRegisteredForLauncher(i11, i12)) {
                Captor runningCaptorInstance = getRunningCaptorInstance(i12);
                if (runningCaptorInstance != null) {
                    runningCaptorInstance.force();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void start(int i11, @NotNull Captor captor) {
        T t11;
        boolean z11;
        Intrinsics.checkNotNullParameter(captor, "captor");
        synchronized (this) {
            a.b("Starting captor " + captor.getId() + " for Launcher: " + i11);
            boolean isCaptorRegisteredForLauncher = isCaptorRegisteredForLauncher(i11, captor.getId());
            boolean isInstanceOfCaptorRunning = isInstanceOfCaptorRunning(captor.getId());
            if (!isCaptorRegisteredForLauncher || !isInstanceOfCaptorRunning) {
                registerCaptorForLauncher(i11, captor);
                if (!isInstanceOfCaptorRunning) {
                    List<Captor> list = this.running;
                    captor.start();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t11 = null;
                            break;
                        }
                        t11 = it.next();
                        if (((Captor) t11).getId() == captor.getId()) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (z11) {
                            break;
                        }
                    }
                    Captor captor2 = (Captor) t11;
                    if (captor2 != null) {
                        list.remove(captor2);
                    }
                    list.add(captor);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void stop(int i11, int i12) {
        T t11;
        boolean z11;
        synchronized (this) {
            a.b("Stopping captor " + i12 + " for launcher: " + i11);
            if (isCaptorRegisteredForLauncher(i11, i12)) {
                removeCaptorForLauncher(i11, i12);
                if (!isCaptorRegisteredForAnotherLauncher(i11, i12)) {
                    Iterator<T> it = this.running.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t11 = null;
                            break;
                        }
                        t11 = it.next();
                        if (((Captor) t11).getId() == i12) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (z11) {
                            break;
                        }
                    }
                    Captor captor = (Captor) t11;
                    if (captor != null) {
                        captor.shutdown();
                        this.running.remove(captor);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
