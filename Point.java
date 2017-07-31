/**
 * A 2D Point (mutable)
 * 
 * All functions change the object and they don't create new instances.
 * 
 * The x and y are public (instead of getters and setters with no restrictions).
 * 
 * @author Akritas
 */
public class Point implements Cloneable {

    // Public members, no need for getters and setter

    public float x;
    public float y;

    // Constructors

    public Point() {
        x = y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(float angle) {
        this.x = (float) -Math.sin(Math.toRadians(angle));
        this.y = (float) Math.cos(Math.toRadians(angle));
    }

    public Point(Point other) {
        x = other.x;
        y = other.y;
    }

    // Fake constructors

    public Point init() {
        x = y = 0.0f;
        return this;
    }

    public Point init(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Point init(float angle) {
        this.x = (float) -Math.sin(Math.toRadians(angle));
        this.y = (float) Math.cos(Math.toRadians(angle));
        return this;
    }

    public Point init(Point point) {
        this.x = point.x;
        this.y = point.y;
        return this;
    }

    // Is

    public boolean isZero() {
        return x == 0 && y == 0;
    }
    
    public boolean isNorm() {
        return lenSq() == 1;
    }

    // Simple

    public Point set(Point v) {
        x = v.x;
        y = v.y;
        return this;
    }

    public Point add(Point v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Point sub(Point v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Point mul(float v) {
        x *= v;
        y *= v;
        return this;
    }

    public Point div(float v) {
        x /= v;
        y /= v;
        return this;
    }

    public Point add(float dx, float dy) {
        x += dx;
        y += dy;
        return this;
    }

    public Point swap(Point v) {
        final float ox = x, oy = y;
        x = v.x;
        y = v.y;
        v.x = ox;
        v.y = oy;
        return this;
    }

    public Point addAngled(float angle, float len) {
        x += len * (float) -Math.sin(Math.toRadians(angle));
        y += len * (float) Math.cos(Math.toRadians(angle));
        return this;
    }

    // complex

    public float len() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float lenSq() {
        return x * x + y * y;
    }

    public float dis(Point p) {
        return (float) Math.sqrt(pow2(x - p.x) + pow2(y - p.y));
    }

    public float disSq(Point p) {
        return pow2(x - p.x) + pow2(y - p.y);
    }

    public float disAngle(Point p) {
        final float x = this.x - p.x;
        final float y = this.y - p.y;
        return (float) Math.toDegrees(Math.atan2(x, -y)) + 180;
    }

    private static float pow2(float x) {
        return x * x;
    }

    public Point norm() {
        final float len = len();
        if (len != 0) div(len);
        return this;
    }

    public float dot(Point v) {
        return x * v.x + y * v.y;
    }

    public Point rotate(float angle) {
        final float c = (float) Math.cos(Math.toRadians(angle));
        final float s = (float) Math.sin(Math.toRadians(angle));
        final float ox = x, oy = y; // old
        x = c * ox - s * oy;
        y = s * ox + c * oy;
        return this;
    }

    public Point rotate(float angle, Point p) {
        sub(p);
        rotate(angle);
        add(p);
        return this;
    }

    public float angle() {
        return (float) (Math.atan2(y, x));
    }

    public float angleDeg() {
        return (float) Math.toDegrees(Math.atan2(x, -y)) + 180;
    }
    
    // Rounding
    
    public Point round() {
        x = Math.round(x);
        y = Math.round(y);
        return this;
    }
    
    public Point ceil() {
        x = (float) Math.ceil(x);
        y = (float) Math.ceil(y);
        return this;
    }
    
    public Point floor() {
        x = (float) Math.floor(x);
        y = (float) Math.floor(y);
        return this;
    }

    // Comlex

    public int dsign(Point v) {
        return y * v.x > x * v.y ? 1 : -1;
    }

    // Overrides

    @Override
    public Point clone() {
        return new Point(x, y);
    }

    @Override
    public int hashCode() {
        return Float.hashCode(x) ^ Float.hashCode(y);
    }

    @Override
    public boolean equals(Object o) {
        final Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "[" + Float.toString(x) + ", " + Float.toString(y) + "]";
    }
}
