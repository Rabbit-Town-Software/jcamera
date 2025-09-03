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

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/jcamera/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/jcamera-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=jcamera-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=jcamera   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `jcamera-1.0.0-sources.jar` and `jcamera-1.0.0-javadoc.jar` for inline documentation in your IDE.

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

## License

JTiled is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?  
Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)

---


## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>

