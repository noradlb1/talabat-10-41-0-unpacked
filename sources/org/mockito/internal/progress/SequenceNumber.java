package org.mockito.internal.progress;

public final class SequenceNumber {
    private static int sequenceNumber = 1;

    private SequenceNumber() {
    }

    public static synchronized int next() {
        int i11;
        synchronized (SequenceNumber.class) {
            i11 = sequenceNumber;
            sequenceNumber = i11 + 1;
        }
        return i11;
    }
}
