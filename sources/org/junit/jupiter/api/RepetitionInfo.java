package org.junit.jupiter.api;

import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface RepetitionInfo {
    int getCurrentRepetition();

    int getTotalRepetitions();
}
