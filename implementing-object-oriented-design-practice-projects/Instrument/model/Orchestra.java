package model;

import java.util.ArrayList;

public class Orchestra {
    private ArrayList<BrassInstrument> brassInstruments;
    private ArrayList<StringInstrument> stringInstruments;

    public Orchestra() {
        brassInstruments = new ArrayList<>();
        stringInstruments = new ArrayList<>();
    }

    public void addBrassInstrument(BrassInstrument brassInstrument) {
        if (!brassInstruments.contains(brassInstrument)) {
            brassInstruments.add(brassInstrument);
            brassInstrument.setOrchestra(this);
        }

    }

    public void addStringInstrument(StringInstrument stringInstrument) {
        if (!stringInstruments.contains(stringInstrument)) {
            stringInstruments.add(stringInstrument);
            stringInstrument.setOrchestra(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orchestra orchestra = (Orchestra) o;

        if (brassInstruments != null ? !brassInstruments.equals(orchestra.brassInstruments) : orchestra.brassInstruments != null)
            return false;
        return stringInstruments != null ? stringInstruments.equals(orchestra.stringInstruments) : orchestra.stringInstruments == null;
    }

    @Override
    public int hashCode() {
        int result = brassInstruments != null ? brassInstruments.hashCode() : 0;
        result = 31 * result + (stringInstruments != null ? stringInstruments.hashCode() : 0);
        return result;
    }
}
