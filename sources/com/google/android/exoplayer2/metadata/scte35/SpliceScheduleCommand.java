package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        public SpliceScheduleCommand[] newArray(int i11) {
            return new SpliceScheduleCommand[i11];
        }
    };
    public final List<Event> events;

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        /* access modifiers changed from: private */
        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }

        private ComponentSplice(int i11, long j11) {
            this.componentTag = i11;
            this.utcSpliceTime = j11;
        }
    }

    public static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i11 = 0; i11 < readUnsignedByte; i11++) {
            arrayList.add(Event.parseFromSection(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.events.get(i12).writeToParcel(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.events = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long j11, boolean z11, boolean z12, boolean z13, List<ComponentSplice> list, long j12, boolean z14, long j13, int i11, int i12, int i13) {
            this.spliceEventId = j11;
            this.spliceEventCancelIndicator = z11;
            this.outOfNetworkIndicator = z12;
            this.programSpliceFlag = z13;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j12;
            this.autoReturn = z14;
            this.breakDurationUs = j13;
            this.uniqueProgramId = i11;
            this.availNum = i12;
            this.availsExpected = i13;
        }

        /* access modifiers changed from: private */
        public static Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* access modifiers changed from: private */
        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            boolean z11;
            boolean z12;
            int i11;
            int i12;
            int i13;
            long j11;
            boolean z13;
            long j12;
            ArrayList arrayList;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            long j13;
            long j14;
            boolean z18;
            boolean z19;
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z11) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if ((readUnsignedByte & 128) != 0) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((readUnsignedByte & 64) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((readUnsignedByte & 32) != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z16) {
                    j13 = parsableByteArray.readUnsignedInt();
                } else {
                    j13 = C.TIME_UNSET;
                }
                if (!z16) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    for (int i14 = 0; i14 < readUnsignedByte2; i14++) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z17) {
                    long readUnsignedByte3 = (long) parsableByteArray.readUnsignedByte();
                    if ((128 & readUnsignedByte3) != 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    j14 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z18 = z19;
                } else {
                    z18 = false;
                    j14 = C.TIME_UNSET;
                }
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                z12 = z16;
                i11 = parsableByteArray.readUnsignedByte();
                j11 = j14;
                arrayList = arrayList2;
                long j15 = j13;
                i13 = readUnsignedShort;
                i12 = readUnsignedByte4;
                j12 = j15;
                boolean z21 = z15;
                z13 = z18;
                z14 = z21;
            } else {
                arrayList = arrayList2;
                z14 = false;
                j12 = C.TIME_UNSET;
                z13 = false;
                j11 = C.TIME_UNSET;
                i13 = 0;
                i12 = 0;
                i11 = 0;
                z12 = false;
            }
            return new Event(readUnsignedInt, z11, z14, z12, arrayList, j12, z13, j11, i13, i12, i11);
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.componentSpliceList.get(i11).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        private Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            boolean z11 = false;
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1 ? true : z11;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
