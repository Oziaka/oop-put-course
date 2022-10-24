#include <iostream>

class Point {
public:
    int y;
    int x;
};

class Segment {
public:
    Point start;
    Point end;
};

class Triangle {
public:
    Point a;
    Point b;
    Point c;
};

class Circle {
public:
    Point center;
    int radius;
};
class square{
public:
    Point a;
    Point b;
};
//
// Created by Oziaka on 10.10.2022.
//
int main() {
    //create simple point
    Point point1 = *new Point();
    point1.x = 1;
    point1.y = 1;
    //create segment
    Point point2 = *new Point();
    point2.x = 2;
    point2.y = 2;
    Point point3 = *new Point();
    point2.x = 2;
    point2.y = 3;
    Segment segment = *new Segment();
    segment.start = point2;
    segment.end = point3;
    //create triangle

    return 0;
}
