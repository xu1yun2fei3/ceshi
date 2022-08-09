public class DBUTILS_borrow {

    private int r_no;
    private int b_no;
    private String b_time;

    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
    }

    public int getB_no() {
        return b_no;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public String getB_time() {
        return b_time;
    }

    public void setB_time(String b_time) {
        this.b_time = b_time;
    }

    @Override
    public String toString() {
        return "DBUTILS_borrow{" +
                "r_no=" + r_no +
                ", b_no=" + b_no +
                ", b_time='" + b_time + '\'' +
                '}';
    }
}
