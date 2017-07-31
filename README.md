# Point

A 2D Point

## Notes

* All functions change the object and they don't create new instances *(mutable)*.
* The **x** and **y** are public *(instead of getters and setters with no restrictions)*.

## Usage

Create points

```java
Point p1 = new Point();
Point p2 = new Point(2.3f, 4.5f);
Point p3 = new Point(1.5f * TAU);
Point p4 = new Point(p3);
Point p5 = p3.clone();
```

Manipulate points

```java
p1.x += 2.6f;
p1.add(2.6f, 0);
p1.add(new Point(2.6f, 0));
p1.sub(-2.6f, 0);

p1.norm();
p1.mul(2);
p1.norm().mul(2);

p2 = p1.clone().add(new Point(1,2).rotate(0.23f));
a = p3.clone().add(new Point(1,2).rotate(0.23f)).add(p4).angle();
a = p3.clone().addAngled(0.23f, p1.len()).add(p4).lenSq();

a = p1.len();
a = p1.dis(p2);

b = p1.isZero() || p2.isNorm();

speed = new Point(angle).mul(ac);
location.add(speed);
```

No need for getters and setters

```java
p.x = p.y = (p.x + p.y) / 2;
// instead of p.setY((p.getX() + p.getY()) / 2); p.setX(p.getY());
```

Can be used in an environmental way (no garbage)

```java
// environmental
p1.init(p2).addAngled(0.33f, 10);

// instead of (still valid)
p1 = p2.clone().add(new Point(0.33f).mul(10));
```

