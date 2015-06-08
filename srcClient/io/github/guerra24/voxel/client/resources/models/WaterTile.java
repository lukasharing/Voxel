package io.github.guerra24.voxel.client.resources.models;

public class WaterTile {

	// public static final float TILE_SIZE = 0.5f;
	public static final float TILE_SIZE = 1000f;

	private float height;
	private float x, z;

	public WaterTile(float centerX, float centerZ, float height) {
		this.x = centerX;
		this.z = centerZ;
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public float getX() {
		return x;
	}

	public float getZ() {
		return z;
	}

}
