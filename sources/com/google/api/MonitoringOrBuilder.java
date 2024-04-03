package com.google.api;

import com.google.api.Monitoring;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface MonitoringOrBuilder extends MessageLiteOrBuilder {
    Monitoring.MonitoringDestination getConsumerDestinations(int i11);

    int getConsumerDestinationsCount();

    List<Monitoring.MonitoringDestination> getConsumerDestinationsList();

    Monitoring.MonitoringDestination getProducerDestinations(int i11);

    int getProducerDestinationsCount();

    List<Monitoring.MonitoringDestination> getProducerDestinationsList();
}
