# JCamera

**JCamera** is a lightweight Java library for handling **2D camera systems** in games and simulations.  
It provides simple world-to-screen transformations, camera following, and boundary restrictions.

---

## Features

- **2D Camera Control**
    - Move or snap instantly to any position.
    - World-to-screen transformations with scaling.
- **Camera Boundaries**
    - Restrict movement to world/map limits.
    - Dynamically update bounds if the world size changes.
- **Camera Following**
    - Smooth follow (lerp-style) or instant snapping.
    - Works with any object that implements a simple position interface.

---

## Installation

Download the latest release from [Releases](../../releases) and add the JAR to your project’s classpath:

```bash
javac -cp jcamera-1.0.0.jar MyGame.java
java -cp .;jcamera-1.0.0.jar MyGame
```

---

## Usage

### Basic Camera
```java
Camera camera = new Camera(0, 0, 16, 9); // Start at (0,0), 16x9 world units

camera.move(1, 0);   // Move right by 1 unit
camera.setPosition(5, 5); // Jump to (5,5)
```

### Camera Boundaries
```java
CameraBoundary boundary = new CameraBoundary(0, 0, 100, 100);
boundary.enforceBounds(camera);
```

### Camera Following
```java
// Define a simple object with x/y
class Player implements Positionable {
    private float x, y;
    public float getX() { return x; }
    public float getY() { return y; }
}

Player player = new Player();
CameraFollower follower = new CameraFollower(camera, player, 5.0f, true);

// Inside your game loop
follower.update(deltaTime);
```

---
