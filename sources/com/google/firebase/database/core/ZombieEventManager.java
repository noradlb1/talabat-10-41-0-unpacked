package com.google.firebase.database.core;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ZombieEventManager implements EventRegistrationZombieListener {
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> globalEventRegistrations = new HashMap<>();

    private ZombieEventManager() {
    }

    @NotNull
    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    private void unRecordEventRegistration(EventRegistration eventRegistration) {
        EventRegistration clone;
        List list;
        synchronized (this.globalEventRegistrations) {
            List list2 = this.globalEventRegistrations.get(eventRegistration);
            boolean z11 = true;
            int i11 = 0;
            int i12 = 0;
            if (list2 != null) {
                while (true) {
                    if (i12 >= list2.size()) {
                        i12 = 0;
                        break;
                    } else if (list2.get(i12) == eventRegistration) {
                        list2.remove(i12);
                        i12 = 1;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (list2.isEmpty()) {
                    this.globalEventRegistrations.remove(eventRegistration);
                }
            }
            if (i12 == 0) {
                if (eventRegistration.isUserInitiated()) {
                    z11 = false;
                }
            }
            Utilities.hardAssert(z11);
            if (!eventRegistration.getQuerySpec().isDefault() && (list = this.globalEventRegistrations.get(clone)) != null) {
                while (true) {
                    if (i11 >= list.size()) {
                        break;
                    } else if (list.get(i11) == eventRegistration) {
                        list.remove(i11);
                        break;
                    } else {
                        i11++;
                    }
                }
                if (list.isEmpty()) {
                    this.globalEventRegistrations.remove((clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()))));
                }
            }
        }
    }

    public void onZombied(EventRegistration eventRegistration) {
        unRecordEventRegistration(eventRegistration);
    }

    public void recordEventRegistration(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            List list = this.globalEventRegistrations.get(eventRegistration);
            if (list == null) {
                list = new ArrayList();
                this.globalEventRegistrations.put(eventRegistration, list);
            }
            list.add(eventRegistration);
            if (!eventRegistration.getQuerySpec().isDefault()) {
                EventRegistration clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                List list2 = this.globalEventRegistrations.get(clone);
                if (list2 == null) {
                    list2 = new ArrayList();
                    this.globalEventRegistrations.put(clone, list2);
                }
                list2.add(eventRegistration);
            }
            eventRegistration.setIsUserInitiated(true);
            eventRegistration.setOnZombied(this);
        }
    }

    public void zombifyForRemove(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            List list = this.globalEventRegistrations.get(eventRegistration);
            if (list != null && !list.isEmpty()) {
                if (eventRegistration.getQuerySpec().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        EventRegistration eventRegistration2 = (EventRegistration) list.get(size);
                        if (!hashSet.contains(eventRegistration2.getQuerySpec())) {
                            hashSet.add(eventRegistration2.getQuerySpec());
                            eventRegistration2.zombify();
                        }
                    }
                } else {
                    ((EventRegistration) list.get(0)).zombify();
                }
            }
        }
    }
}
