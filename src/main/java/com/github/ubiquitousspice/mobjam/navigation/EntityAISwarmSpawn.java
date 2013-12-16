package com.github.ubiquitousspice.mobjam.navigation;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.ChunkCoordinates;

public class EntityAISwarmSpawn extends EntityAIBase
{

	private boolean shouldRun;
	private EntityLiving entityLiving;

	/**
	 * The PathNavigate of our entity
	 */
	private PathNavigate entityPathNavigate;

	public EntityAISwarmSpawn(EntityLiving entityLiving)
	{
		this.entityLiving = entityLiving;
		this.entityPathNavigate = entityLiving.getNavigator();
	}

	@Override
	public boolean isInterruptible()
	{
		return false;
	}

	@Override
	public boolean continueExecuting()
	{
		return true;
	}

	@Override
	public void startExecuting()
	{
		ChunkCoordinates spawn = entityLiving.worldObj.getSpawnPoint();

		this.entityPathNavigate.tryMoveToXYZ(spawn.posX, spawn.posY, spawn.posZ, 1);
	}

	@Override
	public boolean shouldExecute()
	{
		shouldRun = !shouldRun;
		return shouldRun;//I don't know why this works.
	}
}