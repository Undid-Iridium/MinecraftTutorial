package net.undidiridium.tutorialmod.block.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.slf4j.Logger;

public class CitrineLampBlock extends Block {

    //Kind of assigning it to a dictionary, the block state basically can refer to this such as line 26.
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");
    private static final Logger LOGGER = LogUtils.getLogger();

    public CitrineLampBlock(final Properties pProperties) {
        super(pProperties);
    }


    /**
     * BlockBehavior is what you need to use instead of block, don't know how yet. Additionally, this is shared across ALL block objects, they all pass through
     * this single function. Meaning, the pBuilder.add(CLICKED) is really just copied over as an base (AKA loops through all cur properties
     * we want to add and then adds them as a new one with the value we passed, not a direct reference). Each objects has its own version of the
     * property getter, but they all pass through this use method.
     * <p>
     * I don't see how to replace this method, yet
     *
     * @param pState
     * @param pLevel
     * @param pPos
     * @param pPlayer
     * @param pHand
     * @param pHit
     * @return
     */
    @Override
    public InteractionResult use(final BlockState pState, final Level pLevel, final BlockPos pPos, final Player pPlayer, final InteractionHand pHand, final BlockHitResult pHit) {
        LOGGER.info("Hello from CitrineLampBlock Onuse, what is current class hash >> {} and CLICKED hash {} versus original {}. Also pState hash {}",
                pState.hashCode(), pState.getValue(CLICKED).hashCode(), CLICKED.hashCode(), pHit.hashCode());
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            final boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
        }
        return InteractionResult.SUCCESS;
    }


    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
}
