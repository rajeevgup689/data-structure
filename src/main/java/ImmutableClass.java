import java.util.Date;

// final class
public final class ImmutableClass {
    // private final mutable variable
    // Immutable classes/variables are Integer, Long, Float, Double, Boolean, Character, Byte, Short and String
    private final Date remindingDate;

    // initialization in constructor
    public ImmutableClass(Date remindingDate) {
        if (remindingDate.getTime() < System.currentTimeMillis()) {
            throw new IllegalArgumentException("Can't set reminder for past time: " + remindingDate);
        }

        // always assign new instance
        this.remindingDate = new Date(remindingDate.getTime());
    }

    public Date getRemindingDate() {
        // return deep clone obj
        return (Date) remindingDate.clone();
    }

    // no setter
}