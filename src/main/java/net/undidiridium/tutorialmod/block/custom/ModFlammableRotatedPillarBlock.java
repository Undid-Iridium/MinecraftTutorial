package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.undidiridium.tutorialmod.EbonyRegistration;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    public ModFlammableRotatedPillarBlock(final Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return true;
    }

    @Override
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(final BlockState state, final UseOnContext context, final ToolAction toolAction, final boolean simulate) {
        // if (stack.getItem() instanceof AxeItem) { previous
        // Suggested (context.getItemInHand().getItem() instanceof AxeItem)
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(EbonyRegistration.EBONY_LOG.get())) {
                return EbonyRegistration.STRIPPED_EBONY_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
            if (state.is(EbonyRegistration.EBONY_WOOD.get())) {
                return EbonyRegistration.STRIPPED_EBONY_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
