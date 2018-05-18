package ch.hevs.vleiot.IslandOnCloud;

public class Thing<T> {
    private String type;
    private String constraint;
    private double timestamp;
    private T value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestModule{" +
                "type='" + type + '\'' +
                ", constraint='" + constraint + '\'' +
                ", timestamp=" + timestamp +
                ", value["+ value.getClass().toString()+"]=" + value +
                '}';
    }
}
