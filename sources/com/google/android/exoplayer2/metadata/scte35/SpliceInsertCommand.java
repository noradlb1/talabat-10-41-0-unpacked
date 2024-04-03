package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        public SpliceInsertCommand[] newArray(int i11) {
            return new SpliceInsertCommand[i11];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        private ComponentSplice(int i11, long j11, long j12) {
            this.componentTag = i11;
            this.componentSplicePts = j11;
            this.componentSplicePlaybackPositionUs = j12;
        }
    }

    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j11, TimestampAdjuster timestampAdjuster) {
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        int i13;
        long j12;
        boolean z13;
        List list;
        long j13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        long j14;
        long j15;
        boolean z21;
        boolean z22;
        long j16;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        List emptyList = Collections.emptyList();
        if (!z11) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if ((readUnsignedByte & 128) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((readUnsignedByte & 64) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if ((readUnsignedByte & 32) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if ((readUnsignedByte & 16) != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z17 || z19) {
                j14 = C.TIME_UNSET;
            } else {
                j14 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j11);
            }
            if (!z17) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList = new ArrayList(readUnsignedByte2);
                for (int i14 = 0; i14 < readUnsignedByte2; i14++) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if (!z19) {
                        j16 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j11);
                    } else {
                        j16 = C.TIME_UNSET;
                    }
                    arrayList.add(new ComponentSplice(readUnsignedByte3, j16, timestampAdjuster2.adjustTsTimestamp(j16)));
                }
                emptyList = arrayList;
            }
            if (z18) {
                long readUnsignedByte4 = (long) parsableByteArray.readUnsignedByte();
                if ((128 & readUnsignedByte4) != 0) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                j15 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                z21 = z22;
            } else {
                z21 = false;
                j15 = C.TIME_UNSET;
            }
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            i13 = readUnsignedShort;
            z12 = z17;
            i12 = parsableByteArray.readUnsignedByte();
            i11 = parsableByteArray.readUnsignedByte();
            list = emptyList;
            long j17 = j14;
            z13 = z21;
            j12 = j15;
            z14 = z19;
            z15 = z16;
            j13 = j17;
        } else {
            list = emptyList;
            z15 = false;
            z14 = false;
            j13 = C.TIME_UNSET;
            z13 = false;
            j12 = C.TIME_UNSET;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            z12 = false;
        }
        return new SpliceInsertCommand(readUnsignedInt, z11, z15, z12, z14, j13, timestampAdjuster2.adjustTsTimestamp(j13), list, z13, j12, i13, i12, i11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.componentSpliceList.get(i12).writeToParcel(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }

    private SpliceInsertCommand(long j11, boolean z11, boolean z12, boolean z13, boolean z14, long j12, long j13, List<ComponentSplice> list, boolean z15, long j14, int i11, int i12, int i13) {
        this.spliceEventId = j11;
        this.spliceEventCancelIndicator = z11;
        this.outOfNetworkIndicator = z12;
        this.programSpliceFlag = z13;
        this.spliceImmediateFlag = z14;
        this.programSplicePts = j12;
        this.programSplicePlaybackPositionUs = j13;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z15;
        this.breakDurationUs = j14;
        this.uniqueProgramId = i11;
        this.availNum = i12;
        this.availsExpected = i13;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        boolean z11 = false;
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1 ? true : z11;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
