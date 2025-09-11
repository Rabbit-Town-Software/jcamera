# JCamera Documentation

Welcome to the **JCamera** user documentation!  

This library provides tools for **camera handling** in Java 2D games: world-to-screen transforms, boundaries, and smooth following of entities.

---
## Overview

JCamera is built around four main components:

1. **Camera** – World-to-screen transform and viewport control.  
2. **CameraBoundary** – Restricts a camera to a defined world area.  
3. **CameraFollower** – Lets a camera track a target entity.  
4. **Positionable** – Minimal interface for any object with a world position.  

---

## Table of Contents

- [Installation](Java%20Libraries/JLoop/Documentation%20(Users)/1.%20Installation.md)  
- [Positionable](2.%20Positionable.md)  
- [Camera](3.%20Camera.md)  
- [CameraBoundary](4.%20CameraBoundary.md)  
- [CameraFollower](5.%20CameraFollower.md)  
- [Basic Demo](Java%20Libraries/JCamera/Documentation%20(Users)/6.%20Basic%20Demo.md) 

---

## Getting Started

1. Create a `Camera` with a starting position and viewport size.  
2. Optionally apply a `CameraBoundary` to restrict movement.  
3. Use `CameraFollower` to make the camera track a `Positionable` (like a player).  
4. Call `camera.applyTransformations(...)` inside your render loop to shift the Graphics2D context.  
