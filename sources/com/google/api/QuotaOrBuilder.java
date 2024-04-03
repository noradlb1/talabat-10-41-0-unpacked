package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface QuotaOrBuilder extends MessageLiteOrBuilder {
    QuotaLimit getLimits(int i11);

    int getLimitsCount();

    List<QuotaLimit> getLimitsList();

    MetricRule getMetricRules(int i11);

    int getMetricRulesCount();

    List<MetricRule> getMetricRulesList();
}
