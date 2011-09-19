package blank.game.physics;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PhysicsBox extends PhysicsObject {
	
	private BodyDef def;
	private FixtureDef fdef;
	
	public PhysicsBox(float x, float y, float width, float height) {
		def = new BodyDef();
		def.position.set(x/PhysicsWorld.pixelsPerMeter+(width/(PhysicsWorld.pixelsPerMeter*2)), y/PhysicsWorld.pixelsPerMeter+(height/(PhysicsWorld.pixelsPerMeter*2)));
		def.type = BodyType.DYNAMIC;
		
		PolygonShape shape = new PolygonShape();
		
		shape.setAsBox(width/(PhysicsWorld.pixelsPerMeter*2),height/(PhysicsWorld.pixelsPerMeter*2));
		
		fdef = new FixtureDef();
		
		fdef.shape = shape;
		fdef.friction = 0.3f;
		fdef.density = 1f;
		
	}
	
	@Override
	public void init(World world) {
		
		body = world.createBody(def);
		body.createFixture(fdef);
	}
	
}