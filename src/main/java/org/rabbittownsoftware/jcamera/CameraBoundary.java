package main.java.org.rabbittownsoftware.jcamera;

/**
 * CameraBoundary restricts the Camera so it cannot move outside a defined world area (in world units).
 *
 * <p>
 * Useful for keeping the camera locked to a map or world bounds.
 * Boundaries can be dynamically updated if the map size changes.
 * </p>
 */
@SuppressWarnings("unused")
public class CameraBoundary
{
    private final float minX;
    private final float minY;
    private float maxX;
    private float maxY;
    private final float originalMinX;
    private final float originalMinY;

    /**
     * Creates a new CameraBoundary.
     *
     * @param minX Minimum world X coordinate.
     * @param minY Minimum world Y coordinate.
     * @param maxX Maximum world X coordinate.
     * @param maxY Maximum world Y coordinate.
     */
    public CameraBoundary(float minX, float minY, float maxX, float maxY)
    {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

        this.originalMinX = minX;
        this.originalMinY = minY;
    }

    /**
     * Enforces that the Camera stays within the boundary.
     *
     * @param camera The camera to restrict.
     */
    public void enforceBounds(Camera camera)
    {
        if (camera == null) return;

        float clampedX = clamp(camera.getX(), minX, Math.max(minX, maxX - camera.getViewportUnitsWidth()));
        float clampedY = clamp(camera.getY(), minY, Math.max(minY, maxY - camera.getViewportUnitsHeight()));

        camera.setPosition(clampedX, clampedY);
    }

    /**
     * Updates the maximum boundary values based on new world size.
     * <p>
     * Note: this does not change the minimum values, which remain fixed at their original values.
     * </p>
     *
     * @param worldUnitsWidth  New width of the world in units.
     * @param worldUnitsHeight New height of the world in units.
     */
    public void update(float worldUnitsWidth, float worldUnitsHeight)
    {
        float adjustedMaxX = originalMinX + worldUnitsWidth;
        float adjustedMaxY = originalMinY + worldUnitsHeight;

        this.maxX = Math.max(originalMinX, adjustedMaxX);
        this.maxY = Math.max(originalMinY, adjustedMaxY);
    }

    /**
     * Clamps a value between a minimum and maximum.
     */
    private float clamp(float value, float min, float max)
    {
        return Math.max(min, Math.min(value, max));
    }

    // --- Getters ---

    public float getMinX() { return minX; }
    public float getMinY() { return minY; }
    public float getMaxX() { return maxX; }
    public float getMaxY() { return maxY; }

    /** @return The total width of the boundary in world units. */
    public float getWidth() { return maxX - minX; }

    /** @return The total height of the boundary in world units. */
    public float getHeight() { return maxY - minY; }
}
