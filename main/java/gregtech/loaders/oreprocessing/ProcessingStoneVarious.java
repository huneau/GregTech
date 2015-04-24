/*    */ package gregtech.loaders.oreprocessing;
/*    */ 
/*    */ import gregtech.api.enums.GT_Values;
/*    */ import gregtech.api.enums.ItemList;
/*    */ import gregtech.api.enums.OrePrefixes;
/*    */ import gregtech.api.interfaces.internal.IGT_RecipeAdder;
/*    */ import gregtech.api.util.GT_Utility;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ProcessingStoneVarious implements gregtech.api.interfaces.IOreRecipeRegistrator
/*    */ {
/*    */   public ProcessingStoneVarious()
/*    */   {
/* 15 */     OrePrefixes.stone.add(this);
/* 16 */     OrePrefixes.stoneCobble.add(this);
/* 17 */     OrePrefixes.stoneBricks.add(this);
/* 18 */     OrePrefixes.stoneChiseled.add(this);
/* 19 */     OrePrefixes.stoneCracked.add(this);
/* 20 */     OrePrefixes.stoneMossy.add(this);
/* 21 */     OrePrefixes.stoneMossyBricks.add(this);
/* 22 */     OrePrefixes.stoneSmooth.add(this);
/*    */   }
/*    */   
/*    */   public void registerOre(OrePrefixes aPrefix, gregtech.api.enums.Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*    */   {
/* 27 */     if (aPrefix == OrePrefixes.stoneSmooth) {
/* 28 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 1L, new Object[0]), new ItemStack(Blocks.stone_button, 1), 100, 4);
/* 29 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(2L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 2L, new Object[0]), new ItemStack(Blocks.stone_pressure_plate, 1), 200, 4);
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingStoneVarious.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */