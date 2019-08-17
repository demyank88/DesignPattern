package kr.co.practice.creational.Prototype.practice;

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        // todo
        return new Line(new Point(this.start.x, this.start.y), new Point(this.end.x, this.end.y));
    }
}

public class practice {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(1,2), new Point(3,4));
        Line line2 = line1.deepCopy();
    }
}
