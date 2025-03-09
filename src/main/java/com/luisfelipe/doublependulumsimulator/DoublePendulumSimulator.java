package com.luisfelipe.doublependulumsimulator;

/**
 * The DoublePendulumSimulator class is a JavaFX application that simulates
 * the motion of a double pendulum using physics-based calculations.
 * It displays the pendulum's movement in real time and traces the path
 * of the second pendulum bob.
 *
 * The simulation uses numerical integration to update the pendulum's
 * angles and velocities based on gravitational forces.
 *
 * This class initializes the JavaFX scene, handles rendering, and updates
 * the pendulum's motion using an animation timer.
 *
 * @author Luis Felipe
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.stage.Stage;

public class DoublePendulumSimulator extends Application {
    private static final double TIME_STEP = 0.016;
    private static final double GRAVITY = 9.8;

    private double length1 = 150, length2 = 150;
    private double mass1 = 10, mass2 = 10;
    private double angle1 = Math.PI / 2, angle2 = Math.PI / 2;
    private double angleVelocity1 = 0, angleVelocity2 = 0;

    private Line pendulumArm1, pendulumArm2;
    private Circle pendulumBall1, pendulumBall2;
    private Path trailPath;
    private boolean firstTrailPoint = true;

    @Override
    public void start(Stage primaryStage) {
        pendulumArm1 = new Line();
        pendulumArm1.setStrokeWidth(2);
        pendulumArm1.setStroke(Color.BLACK);

        pendulumArm2 = new Line();
        pendulumArm2.setStrokeWidth(2);
        pendulumArm2.setStroke(Color.BLACK);

        pendulumBall1 = new Circle(10);
        pendulumBall1.setFill(Color.RED);

        pendulumBall2 = new Circle(10);
        pendulumBall2.setFill(Color.BLUE);

        trailPath = new Path();
        trailPath.setStroke(Color.PURPLE);
        trailPath.setStrokeWidth(1);

        Group root = new Group();
        root.getChildren().addAll(trailPath, pendulumArm1, pendulumArm2, pendulumBall1, pendulumBall2);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Double Pendulum Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
            }
        }.start();
    }

    private void update() {
        double num1 = -GRAVITY * (2 * mass1 + mass2) * Math.sin(angle1);
        double num2 = -mass2 * GRAVITY * Math.sin(angle1 - 2 * angle2);
        double num3 = -2 * Math.sin(angle1 - angle2) * mass2;
        double num4 = angleVelocity2 * angleVelocity2 * length2 + angleVelocity1 * angleVelocity1 * length1 * Math.cos(angle1 - angle2);
        double denominator = length1 * (2 * mass1 + mass2 - mass2 * Math.cos(2 * angle1 - 2 * angle2));
        double angleAcceleration1 = (num1 + num2 + num3 * num4) / denominator;

        num1 = 2 * Math.sin(angle1 - angle2);
        num2 = (angleVelocity1 * angleVelocity1 * length1 * (mass1 + mass2) + GRAVITY * (mass1 + mass2) * Math.cos(angle1) + angleVelocity2 * angleVelocity2 * length2 * mass2 * Math.cos(angle1 - angle2));
        denominator = length2 * (2 * mass1 + mass2 - mass2 * Math.cos(2 * angle1 - 2 * angle2));
        double angleAcceleration2 = (num1 * num2) / denominator;

        angleVelocity1 += angleAcceleration1 * TIME_STEP;
        angleVelocity2 += angleAcceleration2 * TIME_STEP;
        angle1 += angleVelocity1 * TIME_STEP;
        angle2 += angleVelocity2 * TIME_STEP;
    }

    private void render() {
        double x1 = 300 + length1 * Math.sin(angle1);
        double y1 = 100 + length1 * Math.cos(angle1);
        double x2 = x1 + length2 * Math.sin(angle2);
        double y2 = y1 + length2 * Math.cos(angle2);

        pendulumArm1.setStartX(300);
        pendulumArm1.setStartY(100);
        pendulumArm1.setEndX(x1);
        pendulumArm1.setEndY(y1);

        pendulumArm2.setStartX(x1);
        pendulumArm2.setStartY(y1);
        pendulumArm2.setEndX(x2);
        pendulumArm2.setEndY(y2);

        pendulumBall1.setCenterX(x1);
        pendulumBall1.setCenterY(y1);
        pendulumBall2.setCenterX(x2);
        pendulumBall2.setCenterY(y2);

        if (firstTrailPoint) {
            trailPath.getElements().add(new MoveTo(x2, y2));
            firstTrailPoint = false;
        } else {
            trailPath.getElements().add(new LineTo(x2, y2));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
