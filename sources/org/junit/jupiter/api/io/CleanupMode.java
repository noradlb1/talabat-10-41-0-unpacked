package org.junit.jupiter.api.io;

import org.apiguardian.api.API;

@API(since = "5.9", status = API.Status.EXPERIMENTAL)
public enum CleanupMode {
    DEFAULT,
    ALWAYS,
    ON_SUCCESS,
    NEVER
}
