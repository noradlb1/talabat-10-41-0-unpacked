package com.huawei.hms.analytics.framework.policy;

public interface IStoragePolicy {

    public enum PolicyType {
        NETWORK,
        STORAGECYCLY,
        STORAGELENGTH,
        STORAGESIZE,
        PARAMS
    }

    boolean decide(PolicyType policyType, long j11);

    boolean decide(PolicyType policyType, Object obj);
}
