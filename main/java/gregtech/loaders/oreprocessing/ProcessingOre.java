/*     */ package gregtech.loaders.oreprocessing;
/*     */ 
/*     */ import gregtech.api.enums.GT_Values;
/*     */ import gregtech.api.enums.ItemList;
/*     */ import gregtech.api.enums.Materials;
/*     */ import gregtech.api.enums.OrePrefixes;
/*     */ import gregtech.api.enums.SubTag;
/*     */ import gregtech.api.interfaces.internal.IGT_RecipeAdder;
/*     */ import gregtech.api.util.GT_ModHandler;
/*     */ import gregtech.api.util.GT_OreDictUnificator;
/*     */ import gregtech.api.util.GT_Utility;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ProcessingOre implements gregtech.api.interfaces.IOreRecipeRegistrator
/*     */ {
/*     */   public ProcessingOre()
/*     */   {
/*  19 */     for (OrePrefixes tPrefix : OrePrefixes.values()) if ((tPrefix.name().startsWith("ore")) && (tPrefix != OrePrefixes.orePoor) && (tPrefix != OrePrefixes.oreSmall) && (tPrefix != OrePrefixes.oreRich) && (tPrefix != OrePrefixes.oreNormal)) tPrefix.add(this);
/*     */   }
/*     */   
/*     */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/*     */   {
/*  24 */     boolean tIsRich = (aPrefix == OrePrefixes.oreNether) || (aPrefix == OrePrefixes.oreEnd) || (aPrefix == OrePrefixes.oreDense);
/*     */     
/*  26 */     if (aMaterial == Materials.Oilsands) {
/*  27 */       GT_Values.RA.addCentrifugeRecipe(GT_Utility.copyAmount(1L, new Object[] { aStack }), null, null, Materials.Oil.getFluid(tIsRich ? 1000L : 500L), new ItemStack(net.minecraft.init.Blocks.sand, 1, 0), null, null, null, null, null, new int[] { tIsRich ? '?' : '?' }, tIsRich ? 2000 : 1000, 5);
/*     */     } else {
/*  29 */       registerStandardOreRecipes(aPrefix, aMaterial, GT_Utility.copyAmount(1L, new Object[] { aStack }), Math.max(1, gregtech.api.GregTech_API.sOPStuff.get(gregtech.api.enums.ConfigCategories.Materials.oreprocessingoutputmultiplier, aMaterial.toString(), 1)) * (tIsRich ? 2 : 1));
/*     */     }
/*     */   }
/*     */   
/*  33 */   private ArrayList<Materials> mAlreadyListedOres = new ArrayList(1000);
/*     */   
/*     */   private boolean registerStandardOreRecipes(OrePrefixes aPrefix, Materials aMaterial, ItemStack aOreStack, int aMultiplier) {
/*  36 */     if ((aOreStack == null) || (aMaterial == null)) return false;
/*  37 */     GT_ModHandler.addValuableOre(GT_Utility.getBlockFromStack(aOreStack), aOreStack.getItemDamage(), aMaterial.mOreValue);
/*  38 */     Materials tMaterial = aMaterial.mOreReplacement;Materials tPrimaryByMaterial = null;Materials tSecondaryByMaterial = null;
/*  39 */     aMultiplier = Math.max(1, aMultiplier);
/*  40 */     aOreStack = GT_Utility.copyAmount(1L, new Object[] { aOreStack });
/*  41 */     aOreStack.stackSize = 1;
/*     */     
/*     */ 
/*  44 */     ItemStack tIngot = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial.mDirectSmelting, 1L);
/*  45 */     ItemStack tGem = GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial, 1L);
/*  46 */     ItemStack tSmeltInto = tIngot == null ? null : aMaterial.contains(SubTag.SMELTING_TO_GEM) ? GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial.mDirectSmelting, GT_OreDictUnificator.get(OrePrefixes.crystal, tMaterial.mDirectSmelting, GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial, GT_OreDictUnificator.get(OrePrefixes.crystal, tMaterial, 1L), 1L), 1L), 1L) : tIngot;
/*     */     
/*  48 */     ItemStack tSmall = GT_OreDictUnificator.get(OrePrefixes.dustSmall, tMaterial, 1L);
/*  49 */     ItemStack tDust = GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial, tGem, 1L);
/*  50 */     ItemStack tCleaned = GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tMaterial, tDust, 1L);
/*  51 */     ItemStack tCrushed = GT_OreDictUnificator.get(OrePrefixes.crushed, tMaterial, aMaterial.mOreMultiplier * aMultiplier);
/*  52 */     ItemStack tPrimaryByProduct = null;ItemStack tPrimaryByProductSmall = null;ItemStack tSecondaryByProduct = null;ItemStack tSecondaryByProductSmall = null;
/*     */     
/*  54 */     if (tCrushed == null) {
/*  55 */       tCrushed = GT_OreDictUnificator.get(OrePrefixes.dustImpure, tMaterial, GT_Utility.copyAmount(aMaterial.mOreMultiplier * aMultiplier, new Object[] { tCleaned, tDust, tGem }), aMaterial.mOreMultiplier * aMultiplier);
/*     */     }
/*     */     
/*  58 */     ArrayList<ItemStack> tByProductStacks = new ArrayList();
/*     */     
/*  60 */     for (Materials tMat : aMaterial.mOreByProducts) {
/*  61 */       ItemStack tByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
/*  62 */       if (tByProduct != null) tByProductStacks.add(tByProduct);
/*  63 */       if (tPrimaryByProduct == null) {
/*  64 */         tPrimaryByMaterial = tMat;
/*  65 */         tPrimaryByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
/*  66 */         tPrimaryByProductSmall = GT_OreDictUnificator.get(OrePrefixes.dustSmall, tMat, 1L);
/*  67 */         if (tPrimaryByProductSmall == null) tPrimaryByProductSmall = GT_OreDictUnificator.get(OrePrefixes.dustTiny, tMat, GT_OreDictUnificator.get(OrePrefixes.nugget, tMat, 2L), 2L);
/*     */       }
/*  69 */       if ((tSecondaryByProduct == null) || (tSecondaryByMaterial == tPrimaryByMaterial)) {
/*  70 */         tSecondaryByMaterial = tMat;
/*  71 */         tSecondaryByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
/*  72 */         tSecondaryByProductSmall = GT_OreDictUnificator.get(OrePrefixes.dustSmall, tMat, 1L);
/*  73 */         if (tSecondaryByProductSmall == null) { tSecondaryByProductSmall = GT_OreDictUnificator.get(OrePrefixes.dustTiny, tMat, GT_OreDictUnificator.get(OrePrefixes.nugget, tMat, 2L), 2L);
/*     */         }
/*     */       }
/*     */     }
/*  77 */     if ((!tByProductStacks.isEmpty()) && (!this.mAlreadyListedOres.contains(aMaterial))) {
/*  78 */       this.mAlreadyListedOres.add(aMaterial);
/*  79 */       gregtech.api.util.GT_Recipe.GT_Recipe_Map.sByProductList.addFakeRecipe(false, new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial, aOreStack, 1L) }, (ItemStack[])tByProductStacks.toArray(new ItemStack[tByProductStacks.size()]), null, null, null, null, 0, 0, 0);
/*     */     }
/*     */     
/*  82 */     if (tPrimaryByMaterial == null) tPrimaryByMaterial = tMaterial;
/*  83 */     if (tPrimaryByProduct == null) tPrimaryByProduct = tDust;
/*  84 */     if (tPrimaryByProductSmall == null) { tPrimaryByProductSmall = tSmall;
/*     */     }
/*  86 */     if (tSecondaryByMaterial == null) tSecondaryByMaterial = tPrimaryByMaterial;
/*  87 */     if (tSecondaryByProduct == null) tSecondaryByProduct = tPrimaryByProduct;
/*  88 */     if (tSecondaryByProductSmall == null) { tSecondaryByProductSmall = tPrimaryByProductSmall;
/*     */     }
/*  90 */     boolean tHasSmelting = false;
/*     */     
/*  92 */     if (tSmeltInto != null) {
/*  93 */       if ((aMaterial.mBlastFurnaceRequired) || (aMaterial.mDirectSmelting.mBlastFurnaceRequired)) {
/*  94 */         GT_ModHandler.removeFurnaceSmelting(aOreStack);
/*     */       } else {
/*  96 */         GT_ModHandler.addInductionSmelterRecipe(aOreStack, new ItemStack(net.minecraft.init.Blocks.sand, 1), GT_Utility.mul(aMultiplier * (aMaterial.contains(SubTag.INDUCTIONSMELTING_LOW_OUTPUT) ? 1 : 2) * aMaterial.mSmeltingMultiplier, new Object[] { tSmeltInto }), ItemList.TE_Slag_Rich.get(1L, new Object[0]), 300 * aMultiplier, 10 * aMultiplier);
/*  97 */         GT_ModHandler.addInductionSmelterRecipe(aOreStack, ItemList.TE_Slag_Rich.get(aMultiplier, new Object[0]), GT_Utility.mul(aMultiplier * (aMaterial.contains(SubTag.INDUCTIONSMELTING_LOW_OUTPUT) ? 2 : 3) * aMaterial.mSmeltingMultiplier, new Object[] { tSmeltInto }), ItemList.TE_Slag.get(aMultiplier, new Object[0]), 300 * aMultiplier, 95);
/*  98 */         tHasSmelting = GT_ModHandler.addSmeltingRecipe(aOreStack, GT_Utility.copyAmount(aMultiplier * aMaterial.mSmeltingMultiplier, new Object[] { tSmeltInto }));
/*     */       }
/*     */       
/* 101 */       if (aMaterial.contains(SubTag.BLASTFURNACE_CALCITE_TRIPLE)) {
/* 102 */         GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, aMultiplier), null, null, GT_Utility.mul(aMultiplier * 3 * aMaterial.mSmeltingMultiplier, new Object[] { tSmeltInto }), ItemList.TE_Slag.get(1L, new Object[] { GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L) }), tSmeltInto.stackSize * 500, 120, 1500);
/* 103 */       } else if (aMaterial.contains(SubTag.BLASTFURNACE_CALCITE_DOUBLE)) {
/* 104 */         GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, aMultiplier), null, null, GT_Utility.mul(aMultiplier * 2 * aMaterial.mSmeltingMultiplier, new Object[] { tSmeltInto }), ItemList.TE_Slag.get(1L, new Object[] { GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L) }), tSmeltInto.stackSize * 500, 120, 1500);
/*     */       }
/*     */     }
/*     */     
/* 108 */     if (!tHasSmelting) {
/* 109 */       tHasSmelting = GT_ModHandler.addSmeltingRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial.mDirectSmelting, Math.max(1, aMultiplier * aMaterial.mSmeltingMultiplier / 2)));
/*     */     }
/*     */     
/* 112 */     if (tCrushed != null) {
/* 113 */       GT_Values.RA.addForgeHammerRecipe(aOreStack, GT_Utility.copy(new Object[] { GT_Utility.copyAmount(tCrushed.stackSize, new Object[] { tGem }), tCrushed }), 16, 10);
/* 114 */       GT_ModHandler.addPulverisationRecipe(aOreStack, GT_Utility.mul(2L, new Object[] { tCrushed }), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, new Object[] { tPrimaryByProduct }), 1L), tPrimaryByProduct == null ? 0 : tPrimaryByProduct.stackSize * 10 * aMultiplier * aMaterial.mByProductMultiplier, GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), 50, true);
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */