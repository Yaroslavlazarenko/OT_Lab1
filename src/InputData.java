import java.util.Arrays;

public class InputData {
    int baseOrig;
    int baseTarget;
    char[] baseNumber;
    public InputData(int baseOrig, int baseTarget, char[] baseNumber) {
        this.baseOrig = baseOrig;
        this.baseTarget = baseTarget;
        this.baseNumber = baseNumber;
    }

    public int getBaseOrig() {
        return this.baseOrig;
    }

    public void setBaseOrig(int baseOrig) {
        this.baseOrig = baseOrig;
    }

    public int getBaseTarget() {
        return this.baseTarget;
    }

    public void setBaseTarget(int baseTarget) {
        this.baseTarget = baseTarget;
    }

    public char[] getBaseNumber() {
        return this.baseNumber;
    }

    public void setBaseNumber(char[] baseNumber) {
        this.baseNumber = baseNumber;
    }

    public String toString() {
        return "InputData{baseOrig=" + this.baseOrig +
                ", baseTarget=" + this.baseTarget +
                ", baseNumber=" + Arrays.toString(this.baseNumber) +
                "}";
    }
}
