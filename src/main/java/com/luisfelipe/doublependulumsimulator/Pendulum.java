package com.luisfelipe.doublependulumsimulator;

/**
 * The Pendulum class represents a simple pendulum with physics-based motion.
 * It calculates the pendulum's angular displacement, velocity, and acceleration
 * using numerical integration.
 *
 * The simulation accounts for gravity and damping to create a more
 * realistic motion.
 *
 * This class can be used as a standalone pendulum simulation or as part
 * of a more complex system, such as a double pendulum.
 *
 * @author Luis Felipe
 */

public class Pendulum {
    private double angle;
    private double angleVelocity;
    private double angleAcceleration;
    private final double gravity = 9.8;
    private final double length;
    private final double damping;
    private final double timeStep;

    public Pendulum(double length, double damping, double timeStep) {
        this.length = length;
        this.damping = damping;
        this.timeStep = timeStep;
        this.angle = Math.PI / 4;
        this.angleVelocity = 0;
    }

    public void update() {
        angleAcceleration = (-gravity / length) * Math.sin(angle) - damping * angleVelocity;
        angleVelocity += angleAcceleration * timeStep;
        angle += angleVelocity * timeStep;
    }

    public double getAngle() {
        return angle;
    }
}
