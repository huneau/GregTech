/*    */ package gregtech.loaders.oreprocessing;
/*    */ 
/*    */ import gregtech.api.enums.GT_Values;
/*    */ import gregtech.api.enums.ItemList;
/*    */ import gregtech.api.enums.Materials;
/*    */ import gregtech.api.enums.OrePrefixes;
/*    */ import gregtech.api.interfaces.IOreRecipeRegistrator;
/*    */ import gregtech.api.interfaces.internal.IGT_RecipeAdder;
/*    */ import gregtech.api.util.GT_ModHandler;
/*    */ import gregtech.api.util.GT_OreDictUnificator;
/*    */ import gregtech.api.util.GT_Utility;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ProcessingStone
/*    */   implements IOreRecipeRegistrator
/*    */ {
/*    */   public ProcessingStone()
/*    */   {
/* 22 */     OrePrefixes.stone.add(this);
/*    */   }
/*    */   
/*    */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*    */   {
/* 27 */     Block aBlock = GT_Utility.getBlockFromStack(aStack);
/* 28 */     switch (aMaterial) {
/*    */     case _NULL: 
/* 30 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(3L, new Object[] { aStack }), new ItemStack(Blocks.redstone_torch, 2), Materials.Redstone.getMolten(144L), new ItemStack(Items.repeater, 1), 100, 4);
/* 31 */       break;
/*    */     case Sand: 
/* 33 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), new ItemStack(Blocks.sand, 1, 0), null, 10, false);
/* 34 */       break;
/*    */     case Endstone: 
/* 36 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Endstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), 5, false);
/* 37 */       break;
/*    */     case Netherrack: 
/* 39 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Netherrack, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 1L), 5, false);
/* 40 */       break;
/*    */     case NetherBrick: 
/* 42 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 1L, new Object[0]), new ItemStack(Blocks.nether_brick_fence, 1), 100, 4);
/* 43 */       break;
/*    */     case Obsidian: 
/* 45 */       if (aBlock != Blocks.air) aBlock.setResistance(20.0F);
/* 46 */       GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_Utility.copyAmount(5L, new Object[] { aStack }), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 6), 64, 32);
/* 47 */       GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1L), GT_Utility.copyAmount(3L, new Object[] { aStack }), Materials.Glass.getMolten(720L), new ItemStack(Blocks.beacon, 1, 0), 32, 16);
/* 48 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.IC2_Compressed_Coal_Ball.get(8L, new Object[0]), ItemList.IC2_Compressed_Coal_Chunk.get(1L, new Object[0]), 400, 4);
/* 49 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1L), new ItemStack(Blocks.ender_chest, 1), 400, 4);
/* 50 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_ModHandler.getModItem("Railcraft", "cube.crushed.obsidian", 1L, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L)), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), 10, true);
/* 51 */       GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
/* 52 */       break;
/*    */     case Concrete: 
/* 54 */       GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 100, 32);
/* 55 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L));
/* 56 */       break;
/*    */     case Redrock: case Marble: case Basalt: case Quartzite: 
/* 58 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), 10, false);
/* 59 */       break;
/*    */     case Flint: 
/* 61 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 2L), new ItemStack(Items.flint, 1), 50, false);
/* 62 */       break;
/*    */     case GraniteBlack: 
/* 64 */       GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
/* 65 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L), 1, false);
/* 66 */       break;
/*    */     case GraniteRed: 
/* 68 */       GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
/* 69 */       GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1L), 1, false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */