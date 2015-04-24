/*    */ package gregtech.loaders.oreprocessing;
/*    */ 
/*    */ import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
/*    */ import gregtech.api.enums.ConfigCategories.Recipes;
/*    */ import gregtech.api.enums.GT_Values;
/*    */ import gregtech.api.enums.ItemList;
/*    */ import gregtech.api.enums.Materials;
/*    */ import gregtech.api.enums.OrePrefixes;
/*    */ import gregtech.api.interfaces.internal.IGT_RecipeAdder;
/*    */ import gregtech.api.util.GT_ModHandler;
/*    */ import gregtech.api.util.GT_OreDictUnificator;
/*    */ import gregtech.api.util.GT_Utility;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ProcessingBlock implements gregtech.api.interfaces.IOreRecipeRegistrator
/*    */ {
/*    */   public ProcessingBlock()
/*    */   {
/* 19 */     OrePrefixes.block.add(this);
/*    */   }
/*    */   
/*    */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*    */   {
/* 24 */     GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L), null, (int)Math.max(aMaterial.getMass() * 10L, 1L), 30);
/*    */     
/* 26 */     ItemStack tStack1 = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L);ItemStack tStack2 = GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L);ItemStack tStack3 = GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L);
/*    */     
/* 28 */     GT_ModHandler.removeRecipe(new ItemStack[] { GT_Utility.copyAmount(1L, new Object[] { aStack }) });
/*    */     
/* 30 */     if (tStack1 != null) GT_ModHandler.removeRecipe(new ItemStack[] { tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1 });
/* 31 */     if (tStack2 != null) GT_ModHandler.removeRecipe(new ItemStack[] { tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2 });
/* 32 */     if (tStack3 != null) { GT_ModHandler.removeRecipe(new ItemStack[] { tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3 });
/*    */     }
/* 34 */     if (aMaterial.mStandardMoltenFluid != null) { GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L, new Object[0]), aMaterial.getMolten(1296L), GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), 288, 8);
/*    */     }
/* 36 */     if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockcrafting, OrePrefixes.block.get(aMaterial).toString(), false)) {
/* 37 */       if ((tStack1 == null) && (tStack2 == null) && (tStack3 != null)) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), OrePrefixes.dust.get(aMaterial) });
/* 38 */       if (tStack2 != null) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), OrePrefixes.gem.get(aMaterial) });
/* 39 */       if (tStack1 != null) { GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), OrePrefixes.ingot.get(aMaterial) });
/*    */       }
/*    */     }
/* 42 */     if (tStack1 != null) tStack1.stackSize = 9;
/* 43 */     if (tStack2 != null) tStack2.stackSize = 9;
/* 44 */     if (tStack3 != null) { tStack3.stackSize = 9;
/*    */     }
/* 46 */     GT_Values.RA.addForgeHammerRecipe(aStack, tStack2, 100, 24);
/*    */     
/* 48 */     if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockdecrafting, OrePrefixes.block.get(aMaterial).toString(), tStack2 != null)) {
/* 49 */       if (tStack3 != null) GT_ModHandler.addShapelessCraftingRecipe(tStack3, new Object[] { OrePrefixes.block.get(aMaterial) });
/* 50 */       if (tStack2 != null) GT_ModHandler.addShapelessCraftingRecipe(tStack2, new Object[] { OrePrefixes.block.get(aMaterial) });
/* 51 */       if (tStack1 != null) { GT_ModHandler.addShapelessCraftingRecipe(tStack1, new Object[] { OrePrefixes.block.get(aMaterial) });
/*    */       }
/*    */     }
/* 54 */     switch (aMaterial) {
/*    */     case Mercury: 
/* 56 */       System.err.println("'blockQuickSilver'?, In which Ice Desert can you actually place this as a solid Block?");
/* 57 */       break;
/*    */     case Iron: case WroughtIron: 
/* 59 */       GT_Values.RA.addExtruderRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.Shape_Extruder_Rod.get(0L, new Object[0]), ItemList.IC2_ShaftIron.get(1L, new Object[0]), 640, 120);
/* 60 */       GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L, new Object[0]), GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.IC2_Compressed_Coal_Chunk.get(1L, new Object[0]), 400, 4);
/* 61 */       break;
/*    */     case Steel: 
/* 63 */       GT_Values.RA.addExtruderRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.Shape_Extruder_Rod.get(0L, new Object[0]), ItemList.IC2_ShaftSteel.get(1L, new Object[0]), 1280, 120);
/* 64 */       GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L, new Object[0]), GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.IC2_Compressed_Coal_Chunk.get(1L, new Object[0]), 400, 4);
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */