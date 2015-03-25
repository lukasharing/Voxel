package voxel.client.core.world.block.type;

import voxel.client.core.world.block.Tile;

import com.nishu.utils.Color4f;

public class TileVoid extends Tile {

	@Override
	public byte getId() {
		return 0;
	}

	@Override
	public Color4f getColor() {
		return Color4f.BLACK;
	}

	@Override
	public int getTextID() {
		return 3;
	}
}