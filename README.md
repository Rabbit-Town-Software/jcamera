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

JCamera is currently distributed as standalone JARs through the [GitHub Releases page](https://github.com/Rabbit-Town-Software/jcamera/releases).  
You can include it in your project in several ways, depending on your build system.  

---
### Manual JAR (Recommended for most users)

Download the latest **jcamera-1.0.0.jar**, **jcamera-1.0.0-sources.jar**, and **jcamera-1.0.0-javadoc.jar** and place it into your project’s `libs/` folder.  

**Gradle**  
```gradle
dependencies {
    implementation files('libs/jcamera-1.0.0.jar')
    compileOnly files('libs/jcamera/jcamera-1.0.0-sources.jar')  
    compileOnly files('libs/jcamera/jcamera-1.0.0-javadoc.jar')
}
```

**Maven (local install)**  
Since JCamera isn’t on Maven Central, you can install it into your local Maven repository:  

```bash
mvn install:install-file     
-Dfile=jcamera-1.0.0.jar     
-DgroupId=org.rabbittownsoftware     
-DartifactId=jcamera     
-Dversion=1.0.0     
-Dpackaging=jar
```

Then include it in your `pom.xml`:  
```xml
<dependency>
  <groupId>org.rabbittownsoftware</groupId>
  <artifactId>jcamera</artifactId>
  <version>1.0.0</version>
</dependency>
```

---
### Attach Sources and Javadoc (Optional)

To get **inline documentation and source browsing** inside your IDE, download the extra JARs from the release:  

- `jcamera-1.0.0-sources.jar`  
- `jcamera-1.0.0-javadoc.jar`  

Attach them manually in your IDE:  

**IntelliJ IDEA**  
1. Right-click the dependency in the Project view.  
2. Select **Library Properties**.  
3. Attach the `-sources.jar` and `-javadoc.jar`.  

**Eclipse**  
1. Right-click the library under *Referenced Libraries*.  
2. Select **Properties → Javadoc Location**.  
3. Point to the `-javadoc.jar`.  
4. Do the same for **Source Attachment** with the `-sources.jar`.  

---
### Option 3 – Build From Source (For contributors)

Clone the repo and build with Gradle:  

```bash
git clone https://github.com/Rabbit-Town-Software/jcamera.git
cd jcamera
./gradlew build
```

This produces JARs under `build/libs/`, which you can then include in your project manually.  

---

## License

JCamera is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?  
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/jcamera/issues/new)

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

