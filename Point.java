/**
 * A 2D Point (mutable)
 * 
 * All functions change the object and they don't create new instances.
 * 
 * The x and y are public (instead of getters and setters with no restrictions).
 * 
 * @author Akritas
 */
public class Point {
    
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
        this.x = (float) Math.cos(angle);
        this.y = (float) Math.sin(angle);
    }
    
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
    
    // Ovveride
    
    @Override
    public String toString() {
        return "[" + Float.toString(x) + ", " + Float.toString(y) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        final Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }   

    @Override
    public int hashCode() {
        return Float.floatToIntBits(x) ^ Float.floatToIntBits(y);
    }
    
    public Point clone() {
        return new Point(x, y);
    }
    
    // Is
    
    public boolean isZero() {
        return x == 0 && y == 0;
    }
    
    public boolean isNorm() {
        return lenSq() == 1;
    }
    
    // Setting
    
    public Point set(Point v) {
        x = v.x;
        y = v.y;
        return this;
    }
    public Point set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }     
    
    public Point swap(Point v) {
        float o = x;
        x = v.x;
        v.x = o;
        o = y;
        y = v.y;
        v.y = o;
        return this;
    }
    
    // Basic operations
    
    public Point add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }
    public Point sub(float x, float y) {
        this.x -= x;
        this.y -= y;
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
    
    private static float pow2(float x) {
        return x*x;
    }
    
    public Point norm() {
        float len = this.len();
        if (len != 0) this.div(len);
        return this;
    }
    
    public float dot(Point v) {
        return x*v.x + y*v.y;
    }
    
    public Point rotate(float angle) {
        float c = (float) Math.cos(angle);
        float s = (float) Math.sin(angle);
        float ox = x, oy = y; // old
        x = c * ox - s * oy;
        y = s * ox + c * oy;
        return this;
    }
    
    public Point rotate(float angle, Point center) {
        this.sub(center);
        this.rotate(angle);
        this.add(center);
        return this;
    }
    
    
    public float angle() {
        return (float) (Math.atan2(y, x));
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
    
    // Complex
        
    public int dsign(Point v) {
        return y * v.x > x * v.y ? 1 : -1;
    }
    
}
