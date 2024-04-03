package com.talabat.core.observabilityNew.data.di;

import com.talabat.observabilityNew.tracker.TimeTrackingData;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.HashMap;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.observabilityNew.data.di.TimeCacheMap"})
public final class TimeTrackerModule_Companion_TimeCachesHashMapFactory implements Factory<HashMap<Object, TimeTrackingData>> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TimeTrackerModule_Companion_TimeCachesHashMapFactory INSTANCE = new TimeTrackerModule_Companion_TimeCachesHashMapFactory();

        private InstanceHolder() {
        }
    }

    public static TimeTrackerModule_Companion_TimeCachesHashMapFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HashMap<Object, TimeTrackingData> timeCachesHashMap() {
        return (HashMap) Preconditions.checkNotNullFromProvides(TimeTrackerModule.Companion.timeCachesHashMap());
    }

    public HashMap<Object, TimeTrackingData> get() {
        return timeCachesHashMap();
    }
}
