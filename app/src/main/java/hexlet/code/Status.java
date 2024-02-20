package hexlet.code;
public class Status {
    String status;
    Object value1;
    Object value2;
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
