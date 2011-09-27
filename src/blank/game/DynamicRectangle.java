package blank.game;

import org.jbox2d.common.Vec2;
import org.lwjgl.input.Mouse;

import blank.game.physics.CollisionData;
import blank.game.physics.PhysicsBox;
import blank.game.physics.PhysicsObject;
import blank.game.physics.PhysicsOwner;
import blank.game.rendering.Drawable;
import blank.game.rendering.Sprite;

public class DynamicRectangle implements GameObject, PhysicsOwner, Drawable {

	private PhysicsObject phys;
	private Sprite sprite;
	public float width, height;
	private int zIndex;
	private boolean visible;

	public DynamicRectangle(float x, float y, float width, float height) {
		this.width = width;
		this.height = height;
		phys = new PhysicsBox(x, y, width, height);
		phys.setOwner(this);
		Game.getPhysicsWorld().addObject(phys);

//		sprite = new Sprite((int) width, (int) height);
//		Graphics2D g2d = sprite.getGraphics2D();
//		g2d.setColor(Color.MAGENTA);
//		g2d.fillRect(0, 0, (int) width, (int) height);
//		sprite.update();
		
		
		sprite = new Sprite("res/player.png");
	}

	@Override
	public void draw() {	
		
		sprite.setTranslate(new Vec2(
				phys.getPosition().x - width / 2, phys.getPosition().y - height
						/ 2));
		
		sprite.setRotationPoint(new Vec2(width / 2, height / 2));
		sprite.setRotationAngle(phys.getAngle());
		sprite.setScaleFactor(new Vec2(width/sprite.getWidth(), height/sprite.getHeight()));
		sprite.draw();
		
	}

	@Override
	public void update(int delta) {
		phys.applyForce(new Vec2((Mouse.getX()-phys.getPosition().x)*100, ((600-Mouse.getY())-phys.getPosition().y)*100), new Vec2(width/2,height/2));
		phys.stop();
	}

	@Override
	public void beginCollision(CollisionData collision) {

	}

	@Override
	public void endCollision(CollisionData collision) {

	}
	
	
	
	
	public PhysicsObject getPhysicsObject() {
		return phys;
	}
	
	
	@Override
	public boolean getVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public int getZIndex() {
		return zIndex;
	}
	
	@Override
	public void setZIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	@Override
	public void beforeCollision(CollisionData data) {
		// TODO Auto-generated method stub
		
	}



}
