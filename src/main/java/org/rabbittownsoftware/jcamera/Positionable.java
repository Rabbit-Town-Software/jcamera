package main.java.org.rabbittownsoftware.jcamera;

/**
 * Positionable represents any object that has a world-space position.
 *
 * <p>
 * This interface is intentionally minimal so that users can easily
 * adapt their own entity or object classes by implementing it.
 * </p>
 */
public interface Positionable
{
    /**
     * @return X position in world units.
     */
    float getX();

    /**
     * @return Y position in world units.
     */
    float getY();
}
