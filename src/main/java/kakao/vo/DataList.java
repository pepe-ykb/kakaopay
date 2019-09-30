package kakao.vo;

public class DataList {

    private String brName;
    private String brCode;
    private long sumAmt;

    public DataList(String brName, String brCode, long sumAmt) {
        this.brName = brName;
        this.brCode = brCode;
        this.sumAmt = sumAmt;
    }

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public String getBrCode() {
        return brCode;
    }

    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }

    public long getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(long sumAmt) {
        this.sumAmt = sumAmt;
    }
}
