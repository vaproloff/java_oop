package sem_06_cw.SolidOcp;

import sem_06_cw.SolidOcp.ocp.Circle;
import sem_06_cw.SolidOcp.ocp.RightTriangle;
import sem_06_cw.SolidOcp.ocp.Shape;
import sem_06_cw.SolidOcp.ocp.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new RightTriangle(2, 3));
        shapes.add(new Square(4));
        shapes.add(new Circle(2));
        double sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.getArea();
        }

        System.out.printf("Сумма площадей фигур равна %f \n", sumArea);
    }
}
