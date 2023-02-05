package net.undidiridium.tutorialmod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.block.entity.ModBlockEntities;
import net.undidiridium.tutorialmod.item.ModItems;
import net.undidiridium.tutorialmod.recipe.GemCuttingStationRecipe;
import net.undidiridium.tutorialmod.screen.GemCuttingStationMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class GemCuttingStationBlockEntity extends BlockEntity implements MenuProvider {
    public static final int containerSize = 3;
    public static final int stationContainerSize = 4;
    protected final ContainerData data;
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(final int slot) {
            GemCuttingStationBlockEntity.this.setChanged();
        }
    };
    private int instantCraft;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private int progress = 0;
    private int maxProgress = 72;

    public GemCuttingStationBlockEntity(final BlockPos pWorldPosition, final BlockState pBlockState) {
        this(pWorldPosition, pBlockState, 0);
    }

    public GemCuttingStationBlockEntity(final BlockPos pWorldPosition, final BlockState pBlockState, final int instantCraftable) {
        super(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.instantCraft = instantCraftable;
        this.data = new ContainerData() {
            @Override
            public int get(final int index) {
                switch (index) {
                    case 0:
                        return GemCuttingStationBlockEntity.this.progress;
                    case 1:
                        return GemCuttingStationBlockEntity.this.maxProgress;
                    case 2:
                        return GemCuttingStationBlockEntity.this.instantCraft;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(final int index, final int value) {
                switch (index) {
                    case 0:
                        GemCuttingStationBlockEntity.this.progress = value;
                        break;
                    case 1:
                        GemCuttingStationBlockEntity.this.maxProgress = value;
                        break;
                    case 2:
                        GemCuttingStationBlockEntity.this.instantCraft = value;
                        break;
                }
            }

            /**
             * How many variables we have (progress, maxprogress)
             * @return
             */
            @Override
            public int getCount() {
                return GemCuttingStationBlockEntity.containerSize;
            }
        };
    }

    public static void tick(final Level pLevel, final BlockPos pPos, final BlockState pState, final GemCuttingStationBlockEntity pBlockEntity) {
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            //Tells game to update render? No..Whenever your data changes you need to call BlockEntity#setChanged(),
            // otherwise the LevelChunk containing your BlockEntity might be skipped while the level is saved.
            // https://forge.gemwire.uk/wiki/Block_Entities

            BlockEntity.setChanged(pLevel, pPos, pState);
            if (pBlockEntity.progress > pBlockEntity.maxProgress || pBlockEntity.instantCraft == 1) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            BlockEntity.setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(final GemCuttingStationBlockEntity entity) {
        final Level level = entity.level;
        final SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        final Optional<GemCuttingStationRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
                && hasWaterInWaterSlot(entity) && hasToolsInToolSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(final GemCuttingStationBlockEntity entity) {
        return PotionUtils.getPotion(entity.itemHandler.getStackInSlot(0)) == Potions.WATER;
    }

    private static boolean hasToolsInToolSlot(final GemCuttingStationBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.GEM_CUTTER_TOOL.get();
    }

    private static void craftItem(final GemCuttingStationBlockEntity entity) {
        final Level level = entity.level;
        final SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        final Optional<GemCuttingStationRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        final ItemStack ItemAddedToConsume;
        if (match.isPresent()) {

//            ItemAddedToConsume = entity.itemHandler.extractItem(1, 1, false);
            //Grab current item
            ItemAddedToConsume = entity.itemHandler.getStackInSlot(1);


            /**
             * FYI ALL RECIPES AND INFORMATION FROM DATA FOLDER IS AUTO READ IN.
             * CTRL + SHIFT + F9 then reload classes, do this in intellij
             */
//            System.out.println("What is the item: " + match.get().getResultItem().getItem().getRegistryName()
//                    + " : " + ItemAddedToConsume.getItem().getRegistryName() + " : "
//                    + ItemAddedToConsume.getItem().getRegistryName().compareTo(ModItems.RAW_CITRINE.getId()));
//            System.out.println("What is the item of citrine and block: " + ModItems.RAW_CITRINE.getId() + "  :  " + ModBlocks.CITRINE_BLOCK.getId());
//            System.out.println("Comparing time: " + ItemAddedToConsume.getItem().getRegistryName().toString().equals(ModBlocks.CITRINE_BLOCK.getId().toString()));

            //TODO Better way of handling comparing names. There MUST be a smarter way than this or resource checking (which showed -15 for the "same" object")
            if (ItemAddedToConsume.getItem().getRegistryName().toString().equals(ModBlocks.CITRINE_BLOCK.getId().toString())) {
                if (canInsertAmountIntoOutputSlot(inventory, 9)) {
                    entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                            entity.itemHandler.getStackInSlot(3).getCount() + 9));
                } else {
                    return;
                }
            } else {
                entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                        entity.itemHandler.getStackInSlot(3).getCount() + 1));
            }

            if (entity.itemHandler.getStackInSlot(2).hurt(1, new Random(), null)) {
                entity.itemHandler.extractItem(2, 1, false);
            }
            entity.itemHandler.extractItem(1, 1, false);
            entity.itemHandler.extractItem(0, 1, false);
            entity.resetProgress();
        }
    }

    private static boolean canInsertItemIntoOutputSlot(final SimpleContainer inventory, final ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(final SimpleContainer inventory, final int amountToAdd) {
        return inventory.getItem(3).getMaxStackSize() >= (inventory.getItem(3).getCount() + amountToAdd);
    }

    private static boolean canInsertAmountIntoOutputSlot(final SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() >= inventory.getItem(3).getCount();
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Gem Cutting Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(final int pContainerId, final Inventory pInventory, final Player pPlayer) {
        return new GemCuttingStationMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @javax.annotation.Nullable final Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return this.lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.lazyItemHandler = LazyOptional.of(() -> this.itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull final CompoundTag tag) {
        tag.put("inventory", this.itemHandler.serializeNBT());
        tag.putInt("gem_cutting_station.progress", this.progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(final CompoundTag nbt) {
        super.load(nbt);
        this.itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        this.progress = nbt.getInt("gem_cutting_station.progress");
    }

    public void drops() {
        final SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
