/*    */ package gregtech.loaders.oreprocessing;
/*    */ 
/*    */ import gregtech.api.enums.GT_Values;
/*    */ import gregtech.api.enums.ItemList;
/*    */ import gregtech.api.enums.Materials;
/*    */ import gregtech.api.enums.OrePrefixes;
/*    */ import gregtech.api.interfaces.internal.IGT_RecipeAdder;
/*    */ import gregtech.api.util.GT_ModHandler;
/*    */ import gregtech.api.util.GT_OreDictUnificator;
/*    */ import gregtech.api.util.GT_Utility;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ProcessingPlank implements gregtech.api.interfaces.IOreRecipeRegistrator
/*    */ {
/*    */   public ProcessingPlank()
/*    */   {
/* 19 */     OrePrefixes.plank.add(this);
/*    */   }
/*    */   
/*    */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*    */   {
/* 24 */     if (aOreDictName.startsWith("plankWood")) {
/* 25 */       GT_Values.RA.addLatheRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), null, 10, 8);
/* 26 */       GT_Values.RA.addCNCRecipe(GT_Utility.copyAmount(4L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Wood, 1L), 800, 1);
/* 27 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), new ItemStack(Blocks.noteblock, 1), 200, 4);
/* 28 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1L), new ItemStack(Blocks.jukebox, 1), 400, 4);
/* 29 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L), ItemList.Crate_Empty.get(1L, new Object[0]), 200, 1);
/* 30 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.WroughtIron, 1L), ItemList.Crate_Empty.get(1L, new Object[0]), 200, 1);
/* 31 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L), ItemList.Crate_Empty.get(1L, new Object[0]), 200, 1);
/* 32 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 1L, new Object[0]), new ItemStack(Blocks.wooden_button, 1), 100, 4);
/* 33 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(2L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 2L, new Object[0]), new ItemStack(Blocks.wooden_pressure_plate, 1), 200, 4);
/* 34 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(3L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 3L, new Object[0]), new ItemStack(Blocks.trapdoor, 1), 300, 4);
/* 35 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(4L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 4L, new Object[0]), new ItemStack(Blocks.crafting_table, 1), 400, 4);
/* 36 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(6L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 6L, new Object[0]), new ItemStack(Items.wooden_door, 1), 600, 4);
/* 37 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, new Object[] { aStack }), ItemList.Circuit_Integrated.getWithDamage(0L, 8L, new Object[0]), new ItemStack(Blocks.chest, 1), 800, 4);
/* 38 */       GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(6L, new Object[] { aStack }), new ItemStack(Items.book, 3), new ItemStack(Blocks.bookshelf, 1), 400, 4);
/*    */       
/* 40 */       if (aStack.getItemDamage() == 32767) {
/* 41 */         for (byte i = 0; i < 16; i = (byte)(i + 1)) {
/* 42 */           ItemStack tStack = GT_Utility.copyMetaData(i, new Object[] { aStack });ItemStack tOutput = GT_ModHandler.getRecipeOutput(new ItemStack[] { tStack, tStack, tStack });
/* 43 */           if ((tOutput != null) && (tOutput.stackSize >= 3)) {
/* 44 */             GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { tStack }), GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[] { tOutput }), null, 25, 4);
/* 45 */             GT_ModHandler.removeRecipe(new ItemStack[] { tStack, tStack, tStack });
/* 46 */             GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[] { tOutput }), new Object[] { "sP", Character.valueOf('P'), tStack });
/*    */           }
/*    */         }
/*    */       } else {
/* 50 */         ItemStack tOutput = GT_ModHandler.getRecipeOutput(new ItemStack[] { aStack, aStack, aStack });
/* 51 */         if ((tOutput != null) && (tOutput.stackSize >= 3)) {
/* 52 */           GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[] { tOutput }), null, 25, 4);
/* 53 */           GT_ModHandler.removeRecipe(new ItemStack[] { aStack, aStack, aStack });
/* 54 */           GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[] { tOutput }), new Object[] { "sP", Character.valueOf('P'), aStack });
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingPlank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */