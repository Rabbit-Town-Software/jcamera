package main.java.org.casepresley.jcamera;

import java.util.Objects;

/**
 * CameraFollower smoothly or instantly moves the Camera to follow a target Positionable.
 *
 * <p>
 * - In smooth mode: camera gradually approaches the target.
 * - In snap mode: camera jumps immediately to center on the target.
 * </p>
 */
@SuppressWarnings("unused")
public class CameraFollower
{
    private final Camera camera;
    private Positionable target;
    private float followSpeed;     // Speed factor when smoothing (units per second)
    private boolean smoothFollow;

    /**
     * Creates a new CameraFollower.
     *
     * @param camera       The Camera to control.
     * @param target       The Positionable to follow (e.g., player, entity).
     * @param followSpeed  How fast to move towards the target (only relevant if smoothFollow is true).
     * @param smoothFollow Whether to use smooth interpolation or instant snapping.
     */
    public CameraFollower(Camera camera, Positionable target, float followSpeed, boolean smoothFollow)
    {
        this.camera = Objects.requireNonNull(camera, "Camera cannot be null");
        this.target = Objects.requireNonNull(target, "Target cannot be null");
        this.followSpeed = Math.max(0, followSpeed);
        this.smoothFollow = smoothFollow;
    }

    /**
     * Updates the camera position each frame.
     *
     * @param deltaTime Time elapsed since last update (in seconds).
     */
    public void update(float deltaTime)
    {
        if (target == null) return;

        // Target camera position to center the target
        float targetX = target.getX() - camera.getViewportUnitsWidth() / 2f;
        float targetY = target.getY() - camera.getViewportUnitsHeight() / 2f;

        if (smoothFollow && followSpeed > 0)
        {
            float dx = targetX - camera.getX();
            float dy = targetY - camera.getY();

            camera.move(dx * followSpeed * deltaTime, dy * followSpeed * deltaTime);
        }
        else
        {
            camera.setPosition(targetX, targetY);
        }
    }

    /**
     * Sets a new target for the camera to follow.
     *
     * @param newTarget The new Positionable to follow.
     */
    public void setTarget(Positionable newTarget)
    {
        this.target = Objects.requireNonNull(newTarget, "Target cannot be null");
    }

    /**
     * @return The current target being followed.
     */
    public Positionable getTarget()
    {
        return target;
    }

    /**
     * @return Whether this follower is in smooth mode.
     */
    public boolean isSmoothFollow()
    {
        return smoothFollow;
    }

    /**
     * Switches between smooth and snap follow modes.
     *
     * @param smoothFollow True for smooth follow, false for snap.
     */
    public void setSmoothFollow(boolean smoothFollow)
    {
        this.smoothFollow = smoothFollow;
    }

    /**
     * @return The follow speed in units per second.
     */
    public float getFollowSpeed()
    {
        return followSpeed;
    }

    /**
     * Sets the follow speed.
     *
     * @param followSpeed New speed (must be >= 0).
     */
    public void setFollowSpeed(float followSpeed)
    {
        this.followSpeed = Math.max(0, followSpeed);
    }
}
