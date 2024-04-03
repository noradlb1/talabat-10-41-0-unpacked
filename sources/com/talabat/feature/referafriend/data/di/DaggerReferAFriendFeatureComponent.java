package com.talabat.feature.referafriend.data.di;

import com.talabat.feature.referafriend.data.di.ReferAFriendFeatureComponent;
import dagger.internal.DaggerGenerated;

@DaggerGenerated
public final class DaggerReferAFriendFeatureComponent {

    public static final class Factory implements ReferAFriendFeatureComponent.Factory {
        private Factory() {
        }

        public ReferAFriendFeatureComponent create() {
            return new ReferAFriendFeatureComponentImpl();
        }
    }

    public static final class ReferAFriendFeatureComponentImpl implements ReferAFriendFeatureComponent {
        private final ReferAFriendFeatureComponentImpl referAFriendFeatureComponentImpl;

        private ReferAFriendFeatureComponentImpl() {
            this.referAFriendFeatureComponentImpl = this;
        }
    }

    private DaggerReferAFriendFeatureComponent() {
    }

    public static ReferAFriendFeatureComponent create() {
        return new Factory().create();
    }

    public static ReferAFriendFeatureComponent.Factory factory() {
        return new Factory();
    }
}
