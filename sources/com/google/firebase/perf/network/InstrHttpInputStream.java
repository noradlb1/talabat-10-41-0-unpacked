package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

public final class InstrHttpInputStream extends InputStream {
    private long bytesRead = -1;
    private final InputStream inputStream;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeToResponseInitiated;
    private long timeToResponseLastRead = -1;
    private final Timer timer;

    public InstrHttpInputStream(InputStream inputStream2, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer2) {
        this.timer = timer2;
        this.inputStream = inputStream2;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timeToResponseInitiated = networkRequestMetricBuilder.getTimeToResponseInitiatedMicros();
    }

    public int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public void close() throws IOException {
        long durationMicros = this.timer.getDurationMicros();
        if (this.timeToResponseLastRead == -1) {
            this.timeToResponseLastRead = durationMicros;
        }
        try {
            this.inputStream.close();
            long j11 = this.bytesRead;
            if (j11 != -1) {
                this.networkMetricBuilder.setResponsePayloadBytes(j11);
            }
            long j12 = this.timeToResponseInitiated;
            if (j12 != -1) {
                this.networkMetricBuilder.setTimeToResponseInitiatedMicros(j12);
            }
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timeToResponseLastRead);
            this.networkMetricBuilder.build();
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public void mark(int i11) {
        this.inputStream.mark(i11);
    }

    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    public int read() throws IOException {
        try {
            int read = this.inputStream.read();
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j11 = this.bytesRead + 1;
                this.bytesRead = j11;
                this.networkMetricBuilder.setResponsePayloadBytes(j11);
            }
            return read;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public void reset() throws IOException {
        try {
            this.inputStream.reset();
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public long skip(long j11) throws IOException {
        try {
            long skip = this.inputStream.skip(j11);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (skip == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            } else {
                long j12 = this.bytesRead + skip;
                this.bytesRead = j12;
                this.networkMetricBuilder.setResponsePayloadBytes(j12);
            }
            return skip;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            int read = this.inputStream.read(bArr, i11, i12);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j11 = this.bytesRead + ((long) read);
                this.bytesRead = j11;
                this.networkMetricBuilder.setResponsePayloadBytes(j11);
            }
            return read;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.inputStream.read(bArr);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j11 = this.bytesRead + ((long) read);
                this.bytesRead = j11;
                this.networkMetricBuilder.setResponsePayloadBytes(j11);
            }
            return read;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }
}
