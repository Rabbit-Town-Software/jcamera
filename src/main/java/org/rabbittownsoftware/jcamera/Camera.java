package main.java.org.rabbittownsoftware.jcamera;

import java.awt.Graphics2D;

/**
 * Camera handles world-to-screen transformations for rendering.
 *
 * <p>
 * It defines a position (x, y) in world space and a viewport size in units.
 * The camera can move, reset, or jump instantly to a position.
 * </p>
 */
public class Camera
{
    private float x;
    private float y;

    private final float viewportUnitsWidth;
    private final float viewportUnitsHeight;

    /**
     * Creates a new Camera.
     *
     * @param startX Starting X position in world units.
     * @param startY Starting Y position in world units.
     * @param viewportUnitsWidth Width of the camera view in world units.
     * @param viewportUnitsHeight Height of the camera view in world units.
     */
    public Camera(float startX, float startY, float viewportUnitsWidth, float viewportUnitsHeight)
    {
        if (viewportUnitsWidth <= 0 || viewportUnitsHeight <= 0)
        {
            throw new IllegalArgumentException("Viewport dimensions must be > 0.");
        }

        this.x = startX;
        this.y = startY;
        this.viewportUnitsWidth = viewportUnitsWidth;
        this.viewportUnitsHeight = viewportUnitsHeight;
    }

    /** Moves the camera by a delta. */
    public void move(float dx, float dy)
    {
        this.x += dx;
        this.y += dy;
    }

    /** Sets the camera to a specific position instantly. */
    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /** Instantly centers the camera on a given world coordinate. */
    public void centerOn(float centerX, float centerY)
    {
        this.x = centerX - viewportUnitsWidth / 2f;
        this.y = centerY - viewportUnitsHeight / 2f;
    }

    // --- Getters ---
    public float getX() { return x; }
    public float getY() { return y; }
    public float getViewportUnitsWidth() { return viewportUnitsWidth; }
    public float getViewportUnitsHeight() { return viewportUnitsHeight; }

    /**
     * Applies translation and scaling transforms to a Graphics2D context.
     *
     * @param graphics2D Graphics2D context to modify.
     * @param pixelsPerUnit How many pixels correspond to one world unit.
     */
    @SuppressWarnings("unused")
    public void applyTransformations(Graphics2D graphics2D, int pixelsPerUnit)
    {
        graphics2D.translate(-x * pixelsPerUnit, -y * pixelsPerUnit);
        graphics2D.scale(pixelsPerUnit, pixelsPerUnit);
    }
}
