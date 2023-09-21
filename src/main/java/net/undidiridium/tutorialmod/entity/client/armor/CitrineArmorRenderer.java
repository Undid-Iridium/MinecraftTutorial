package net.undidiridium.tutorialmod.entity.client.armor;

import net.undidiridium.tutorialmod.item.custom.CitrineArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CitrineArmorRenderer extends GeoArmorRenderer<CitrineArmorItem> {
    public CitrineArmorRenderer() {
        super(new CitrineArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg"; //armorLeftLeg may need to switch
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
