/*    */ package gregtech.loaders.oreprocessing;
/*    */ 
/*    */ import gregtech.api.GregTech_API;
/*    */ import gregtech.api.enums.Materials;
/*    */ import gregtech.api.enums.OrePrefixes;
/*    */ import gregtech.api.interfaces.IOreRecipeRegistrator;
/*    */ import gregtech.api.objects.GT_RenderedTexture;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ProcessingFoil implements IOreRecipeRegistrator
/*    */ {
/*    */   public ProcessingFoil()
/*    */   {
/* 14 */     OrePrefixes.foil.add(this);
/*    */   }
/*    */   
/*    */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*    */   {
/* 19 */     GregTech_API.registerCover(aStack, new GT_RenderedTexture(aMaterial.mIconSet.mTextures[70], aMaterial.mRGBa, false), null);
/*    */   }
/*    */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingFoil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */