package hexlet.code;
public class Status {
    private String status;
    private Object value1;
    private Object value2;
    public Status(String status, Object value1, Object value2) {
        this.status = status;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getStatus() {
        return status;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Status{"
                +
                "status='" + status + '\''
                +
                ", value1=" + value1
                +
                ", value2=" + value2
                +
                '}';
    }
}
