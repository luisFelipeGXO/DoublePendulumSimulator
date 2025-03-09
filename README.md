# Double Pendulum Simulator

## Overview

The **Double Pendulum Simulator** is a JavaFX application that visually simulates the motion of a double pendulum using physics-based calculations. The simulation implements numerical integration to update the pendulum's angles and velocities based on gravitational forces, creating a realistic chaotic motion.

## Features

- Real-time simulation of a double pendulum.
- Uses **Lagrangian mechanics** for accurate motion calculation.
- JavaFX-based rendering with smooth animations.
- Trail path visualization to track the motion of the second pendulum bob.
- Adjustable parameters such as length, mass, and initial conditions.

## Technologies Used

- **Java 17+**  
- **JavaFX** for UI and animation  
- **Git** for version control  

## Installation & Usage

### Prerequisites

- Install **Java 17+**  
- Install **JavaFX SDK**  

### Running the Simulation

1. Clone this repository:
   ```sh
   git clone https://github.com/luisfelipeGXO/DoublePendulumSimulator.git
   cd DoublePendulumSimulator

    Compile and run the application:

    javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d bin src/com/luisfelipe/doublependulumsimulator/*.java
    java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp bin com.luisfelipe.doublependulumsimulator.DoublePendulumSimulator

        Replace /path/to/javafx-sdk/lib with the actual path to your JavaFX SDK.

Alternatively, you can use an IDE like IntelliJ IDEA or Eclipse to build and run the project.

This project is licensed under the MIT License - see the LICENSE file for details.
Contribution

Feel free to contribute by submitting pull requests or opening issues for bug reports or feature suggestions.
Contact

Author: Luis Felipe
GitHub: luisfelipeGXO
Email: gluisfelipe934@gmail.com