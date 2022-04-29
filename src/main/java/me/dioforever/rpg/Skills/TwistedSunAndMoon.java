package me.dioforever.rpg.Skills;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.*;
import org.bukkit.Bukkit;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;

public class TwistedSunAndMoon extends BukkitRunnable {
    @Override
    public void run() {
            for(Player p : Bukkit.getOnlinePlayers()){
                String nick = p.getName();
                List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");


                int Strength = CCStats.get().getInt(nick+".Strength");
                int Stamina = CCStats.get().getInt(nick+".Stamina");
                int Intelligence = CCStats.get().getInt(nick+".Intelligence");
                int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                int Luck = CCStats.get().getInt(nick+".Luck");
                int Agility = CCStats.get().getInt(nick+".Agility");
                int Defense = CCStats.get().getInt(nick+".Defense");
                int Health = CCStats.get().getInt(nick+".Health");

                // nick - List(Skills)
               Map <String,List> SkillsActivatedTemp = new HashMap<>();
                if(Main.getSkillsActivatedTemp()!=null){
                    SkillsActivatedTemp = Main.getSkillsActivatedTemp();
                }
                // nick - Map(skill-List(effects))
                Map <String,HashMap> SkillsEffectT= new HashMap<>();
                if(Main.getSkillsEffect()!=null){
                    SkillsEffectT = Main.getSkillsEffectT();
                }
                // nick - Map(skill - seconds)
                Map <String,HashMap> SkillsCooldownT= new HashMap<>();
                if(Main.getSkillsCooldown()!=null){
                    SkillsCooldownT = Main.getSkillsCooldownT();
                }

                //Will have nick - Hashmap of the Skill (String) + Effect(List) for example

                //If the player has the TSAM Skill
                if(skills.contains("Twisted Sun and Moon")){
                    if( p.getWorld().getEnvironment().equals(World.Environment.NETHER) || p.getWorld().getEnvironment().equals(World.Environment.THE_END )	) {
                        if(SkillsActivatedTemp.containsKey(nick)){
                            //Player has any skill activated

                            //Add him to ActivatedTemp
                            List skillsT = SkillsActivatedTemp.get(nick);
                            if(!skillsT.contains("Twisted Sun and Moon")){
                                skillsT.add("Twisted Sun and Moon");
                                SkillsActivatedTemp.put(nick,skillsT);
                                Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                //Add him to Effects
                                List effects = new ArrayList<>();
                                effects.add(Strength*0.15);
                                effects.add(Stamina*0.15);
                                effects.add(Health*0.15);
                                effects.add(Intelligence*0.15);
                                effects.add(Wisdom*0.15);
                                effects.add(Luck*0.15);
                                effects.add(Defense*0.15);
                                effects.add(Agility*0.15);
                                HashMap <String,List> effect= new HashMap<>();
                                effect.put("Twisted Sun and Moon", effects);
                                SkillsEffectT.put(nick,effect);
                                Main.setSkillsEffectT(SkillsEffectT);
                                //Add him to cooldown (None)
                                HashMap <String,Integer> cooldowns= new HashMap<>();
                                cooldowns.put("Twisted Sun and Moon",-1);
                                SkillsCooldownT.put(nick,cooldowns);

                                int TStrength = CCStats.get().getInt(nick+".TStrength");
                                int TStamina = CCStats.get().getInt(nick+".TStamina");
                                int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                int TLuck = CCStats.get().getInt(nick+".TLuck");
                                int TAgility = CCStats.get().getInt(nick+".TAgility");
                                int TDefense = CCStats.get().getInt(nick+".TDefense");
                                int THealth = CCStats.get().getInt(nick+".THealth");
                                //Give him the Temp Stats
                                CCStats.get().set(nick+".TStrength",(int)(TStrength+Strength*0.15));
                                CCStats.get().set(nick+".TStamina",(int)(TStamina+Stamina*0.15));
                                CCStats.get().set(nick+".TIntelligence",(int)(TIntelligence+Intelligence*0.15));
                                CCStats.get().set(nick+".TWisdom",(int)(TWisdom+Wisdom*0.15));
                                CCStats.get().set(nick+".TLuck",(int)(TLuck+Luck*0.15));
                                CCStats.get().set(nick+".TAgility",(int)(TAgility+Agility*0.15));
                                CCStats.get().set(nick+".TDefense",(int)(TDefense+Defense*0.15));
                                CCStats.get().set(nick+".THealth",(int)(THealth+Health*0.15));
                                CCStats.save();
                                p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));

                            }else{
                                List effectsS = (List) SkillsEffectT.get(nick).get("Twisted Sun and Moon");
                                if((double)effectsS.get(0)<0.0){
                                    //Was buffed so remove buff

                                    int TStrength = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense = CCStats.get().getInt(nick+".TDefense");
                                    int THealth = CCStats.get().getInt(nick+".THealth");
                                    //Now remove the Temp Stats
                                    List skillsAT =  SkillsActivatedTemp.get(nick);
                                    HashMap skillsEf = SkillsEffectT.get(nick);
                                    HashMap cooldownsT = SkillsCooldownT.get(nick);

                                    List effectStats = (List) skillsEf.get("Twisted Sun and Moon");
                                    CCStats.get().set(nick+".TStrength",TStrength-(double)effectStats.get(0));
                                    CCStats.get().set(nick+".TStamina",TStamina-(double)effectStats.get(1));
                                    CCStats.get().set(nick+".THealth",THealth-(double)effectStats.get(2));
                                    CCStats.get().set(nick+".TIntelligence",TIntelligence-(double)effectStats.get(3));
                                    CCStats.get().set(nick+".TWisdom",TWisdom-(double)effectStats.get(4));
                                    CCStats.get().set(nick+".TLuck",TLuck-(double)effectStats.get(5));
                                    CCStats.get().set(nick+".TDefense",TDefense-(double)effectStats.get(6));
                                    CCStats.get().set(nick+".TAgility",TAgility-(double)effectStats.get(7));
                                    CCStats.save();


                                    //Remove from list of skills

                                    skillsAT.remove("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsAT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Remove from Effects

                                    skillsEf.remove("Twisted Sun and Moon");
                                    SkillsEffectT.put(nick,skillsEf);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Remove from Cooldowns

                                    cooldownsT.remove("Twisted Sun and Moon");
                                    SkillsCooldownT.put(nick,cooldownsT);
                                    Main.setSkillsCooldownT(SkillsCooldownT);





                                    skillsT.add("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Add him to Effects
                                    List effects = new ArrayList<>();
                                    effects.add(Strength*0.15);
                                    effects.add(Stamina*0.15);
                                    effects.add(Health*0.15);
                                    effects.add(Intelligence*0.15);
                                    effects.add(Wisdom*0.15);
                                    effects.add(Luck*0.15);
                                    effects.add(Defense*0.15);
                                    effects.add(Agility*0.15);
                                    HashMap <String,List> effect= new HashMap<>();
                                    effect.put("Twisted Sun and Moon", effects);
                                    SkillsEffectT.put(nick,effect);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Add him to cooldown (None)
                                    HashMap <String,Integer> cooldowns= new HashMap<>();
                                    cooldowns.put("Twisted Sun and Moon",-1);
                                    SkillsCooldownT.put(nick,cooldowns);

                                    int TStrength1 = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina1 = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence1 = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom1 = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck1 = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility1 = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense1 = CCStats.get().getInt(nick+".TDefense");
                                    int THealth1 = CCStats.get().getInt(nick+".THealth");
                                    //Give him the Temp Stats
                                    CCStats.get().set(nick+".TStrength",(int)(TStrength1+Strength*0.15));
                                    CCStats.get().set(nick+".TStamina",(int)(TStamina1+Stamina*0.15));
                                    CCStats.get().set(nick+".TIntelligence",(int)(TIntelligence1+Intelligence*0.15));
                                    CCStats.get().set(nick+".TWisdom",(int)(TWisdom1+Wisdom*0.15));
                                    CCStats.get().set(nick+".TLuck",(int)(TLuck1+Luck*0.15));
                                    CCStats.get().set(nick+".TAgility",(int)(TAgility1+Agility*0.15));
                                    CCStats.get().set(nick+".TDefense",(int)(TDefense1+Defense*0.15));
                                    CCStats.get().set(nick+".THealth",(int)(THealth1+Health*0.15));
                                    CCStats.save();
                                    p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));
                                }
                                //
                            }


                        }else{
                            //Player does not have any skill activated

                            //Add him to ActivatedTemp
                            List skillsT = new ArrayList<>();
                            skillsT.add("Twisted Sun and Moon");
                            SkillsActivatedTemp.put(nick,skillsT);
                            Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                            //Add him to Effects
                            List effects = new ArrayList<>();
                            effects.add(Strength*0.15);
                            effects.add(Stamina*0.15);
                            effects.add(Health*0.15);
                            effects.add(Intelligence*0.15);
                            effects.add(Wisdom*0.15);
                            effects.add(Luck*0.15);
                            effects.add(Defense*0.15);
                            effects.add(Agility*0.15);
                            HashMap <String,List> effect= new HashMap<>();
                            effect.put("Twisted Sun and Moon", effects);
                            SkillsEffectT.put(nick,effect);
                            Main.setSkillsEffectT(SkillsEffectT);
                            //Add him to cooldown (None)
                            HashMap <String,Integer> cooldowns= new HashMap<>();
                            cooldowns.put("Twisted Sun and Moon",-1);
                            SkillsCooldownT.put(nick,cooldowns);

                            int TStrength = CCStats.get().getInt(nick+".TStrength");
                            int TStamina = CCStats.get().getInt(nick+".TStamina");
                            int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                            int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                            int TLuck = CCStats.get().getInt(nick+".TLuck");
                            int TAgility = CCStats.get().getInt(nick+".TAgility");
                            int TDefense = CCStats.get().getInt(nick+".TDefense");
                            int THealth = CCStats.get().getInt(nick+".THealth");
                            //Give him the Temp Stats
                            CCStats.get().set(nick+".TStrength",(TStrength+Strength*0.15));
                            CCStats.get().set(nick+".TStamina",(TStamina+Stamina*0.15));
                            CCStats.get().set(nick+".TIntelligence",(TIntelligence+Intelligence*0.15));
                            CCStats.get().set(nick+".TWisdom",(TWisdom+Wisdom*0.15));
                            CCStats.get().set(nick+".TLuck",(TLuck+Luck*0.15));
                            CCStats.get().set(nick+".TAgility",(TAgility+Agility*0.15));
                            CCStats.get().set(nick+".TDefense",(TDefense+Defense*0.15));
                            CCStats.get().set(nick+".THealth",(THealth+Health*0.15));
                            CCStats.save();
                            p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));



                        }

                    }else{

                        //Overworld
                        if(!(p.getWorld().getTime()>0&& p.getWorld().getTime()<12301)){
                            //Its day

                            if(SkillsActivatedTemp.containsKey(nick)){
                                //Player has any skill activated
                                //Check if player has a debuff, if does, remove it
                                List effectsS = (List) SkillsEffectT.get(nick).get("Twisted Sun and Moon");
                                if((double)effectsS.get(0)<0.0){
                                    //Was buffed so remove buff

                                    int TStrength = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense = CCStats.get().getInt(nick+".TDefense");
                                    int THealth = CCStats.get().getInt(nick+".THealth");
                                    //Now remove the Temp Stats
                                    List skillsAT =  SkillsActivatedTemp.get(nick);
                                    HashMap skillsEf = SkillsEffectT.get(nick);
                                    HashMap cooldownsT = SkillsCooldownT.get(nick);

                                    List effectStats = (List) skillsEf.get("Twisted Sun and Moon");
                                    CCStats.get().set(nick+".TStrength",TStrength-(double)effectStats.get(0));
                                    CCStats.get().set(nick+".TStamina",TStamina-(double)effectStats.get(1));
                                    CCStats.get().set(nick+".THealth",THealth-(double)effectStats.get(2));
                                    CCStats.get().set(nick+".TIntelligence",TIntelligence-(double)effectStats.get(3));
                                    CCStats.get().set(nick+".TWisdom",TWisdom-(double)effectStats.get(4));
                                    CCStats.get().set(nick+".TLuck",TLuck-(double)effectStats.get(5));
                                    CCStats.get().set(nick+".TDefense",TDefense-(double)effectStats.get(6));
                                    CCStats.get().set(nick+".TAgility",TAgility-(double)effectStats.get(7));
                                    CCStats.save();


                                    //Remove from list of skills

                                    skillsAT.remove("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsAT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Remove from Effects

                                    skillsEf.remove("Twisted Sun and Moon");
                                    SkillsEffectT.put(nick,skillsEf);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Remove from Cooldowns

                                    cooldownsT.remove("Twisted Sun and Moon");
                                    SkillsCooldownT.put(nick,cooldownsT);
                                    Main.setSkillsCooldownT(SkillsCooldownT);


                                }
                                //


                                //Add him to ActivatedTemp
                                List skillsT = SkillsActivatedTemp.get(nick);
                                if(!skillsT.contains("Twisted Sun and Moon")){
                                    skillsT.add("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Add him to Effects
                                    List effects = new ArrayList<>();
                                    effects.add(Strength*0.15);
                                    effects.add(Stamina*0.15);
                                    effects.add(Health*0.15);
                                    effects.add(Intelligence*0.15);
                                    effects.add(Wisdom*0.15);
                                    effects.add(Luck*0.15);
                                    effects.add(Defense*0.15);
                                    effects.add(Agility*0.15);
                                    HashMap <String,List> effect= new HashMap<>();
                                    effect.put("Twisted Sun and Moon", effects);
                                    SkillsEffectT.put(nick,effect);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Add him to cooldown (None)
                                    HashMap <String,Integer> cooldowns= new HashMap<>();
                                    cooldowns.put("Twisted Sun and Moon",-1);
                                    SkillsCooldownT.put(nick,cooldowns);

                                    int TStrength = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense = CCStats.get().getInt(nick+".TDefense");
                                    int THealth = CCStats.get().getInt(nick+".THealth");
                                    //Give him the Temp Stats
                                    CCStats.get().set(nick+".TStrength",(TStrength+Strength*0.15));
                                    CCStats.get().set(nick+".TStamina",(TStamina+Stamina*0.15));
                                    CCStats.get().set(nick+".TIntelligence",(TIntelligence+Intelligence*0.15));
                                    CCStats.get().set(nick+".TWisdom",(TWisdom+Wisdom*0.15));
                                    CCStats.get().set(nick+".TLuck",(TLuck+Luck*0.15));
                                    CCStats.get().set(nick+".TAgility",(TAgility+Agility*0.15));
                                    CCStats.get().set(nick+".TDefense",(TDefense+Defense*0.15));
                                    CCStats.get().set(nick+".THealth",(THealth+Health*0.15));
                                    CCStats.save();
                                    p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));




                                }else{

                                }


                            }else{
                                //Player does not have any skill activated

                                //Add him to ActivatedTemp
                                List skillsT = new ArrayList<>();
                                skillsT.add("Twisted Sun and Moon");
                                SkillsActivatedTemp.put(nick,skillsT);
                                Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                //Add him to Effects
                                List effects = new ArrayList<>();
                                effects.add(Strength*0.15);
                                effects.add(Stamina*0.15);
                                effects.add(Health*0.15);
                                effects.add(Intelligence*0.15);
                                effects.add(Wisdom*0.15);
                                effects.add(Luck*0.15);
                                effects.add(Defense*0.15);
                                effects.add(Agility*0.15);
                                HashMap <String,List> effect= new HashMap<>();
                                effect.put("Twisted Sun and Moon", effects);
                                SkillsEffectT.put(nick,effect);
                                Main.setSkillsEffectT(SkillsEffectT);
                                //Add him to cooldown (None)
                                HashMap <String,Integer> cooldowns= new HashMap<>();
                                cooldowns.put("Twisted Sun and Moon",-1);
                                SkillsCooldownT.put(nick,cooldowns);

                                int TStrength = CCStats.get().getInt(nick+".TStrength");
                                int TStamina = CCStats.get().getInt(nick+".TStamina");
                                int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                int TLuck = CCStats.get().getInt(nick+".TLuck");
                                int TAgility = CCStats.get().getInt(nick+".TAgility");
                                int TDefense = CCStats.get().getInt(nick+".TDefense");
                                int THealth = CCStats.get().getInt(nick+".THealth");
                                //Give him the Temp Stats
                                CCStats.get().set(nick+".TStrength",(TStrength+Strength*0.15));
                                CCStats.get().set(nick+".TStamina",(TStamina+Stamina*0.15));
                                CCStats.get().set(nick+".TIntelligence",(TIntelligence+Intelligence*0.15));
                                CCStats.get().set(nick+".TWisdom",(TWisdom+Wisdom*0.15));
                                CCStats.get().set(nick+".TLuck",(TLuck+Luck*0.15));
                                CCStats.get().set(nick+".TAgility",(TAgility+Agility*0.15));
                                CCStats.get().set(nick+".TDefense",(TDefense+Defense*0.5));
                                CCStats.get().set(nick+".THealth",(THealth+Health*0.15));
                                CCStats.save();

                                p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));



                            }

                        }else{
                            //Debuff
                            if(SkillsActivatedTemp.containsKey(nick)){
                                //Player has any skill activated
                                //Check if player has a buff, if does, remove it
                                List effectsS = (List) SkillsEffectT.get(nick).get("Twisted Sun and Moon");
                                //Check if Player was buffed
                                if((double)effectsS.get(0)>0.0){
                                    //Was buffed so remove buff

                                    int TStrength = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense = CCStats.get().getInt(nick+".TDefense");
                                    int THealth = CCStats.get().getInt(nick+".THealth");
                                    //Now remove the Temp Stats
                                    List skillsAT =  SkillsActivatedTemp.get(nick);
                                    HashMap skillsEf = SkillsEffectT.get(nick);
                                    HashMap cooldownsT = SkillsCooldownT.get(nick);

                                    List effectStats = (List) skillsEf.get("Twisted Sun and Moon");
                                    CCStats.get().set(nick+".TStrength",TStrength-(double)effectStats.get(0));
                                    CCStats.get().set(nick+".TStamina",TStamina-(double)effectStats.get(1));
                                    CCStats.get().set(nick+".THealth",THealth-(double)effectStats.get(2));
                                    CCStats.get().set(nick+".TIntelligence",TIntelligence-(double)effectStats.get(3));
                                    CCStats.get().set(nick+".TWisdom",TWisdom-(double)effectStats.get(4));
                                    CCStats.get().set(nick+".TLuck",TLuck-(double)effectStats.get(5));
                                    CCStats.get().set(nick+".TDefense",TDefense-(double)effectStats.get(6));
                                    CCStats.get().set(nick+".TAgility",TAgility-(double)effectStats.get(7));
                                    CCStats.save();


                                    //Remove from list of skills

                                    skillsAT.remove("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsAT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Remove from Effects

                                    skillsEf.remove("Twisted Sun and Moon");
                                    SkillsEffectT.put(nick,skillsEf);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Remove from Cooldowns

                                    cooldownsT.remove("Twisted Sun and Moon");
                                    SkillsCooldownT.put(nick,cooldownsT);
                                    Main.setSkillsCooldownT(SkillsCooldownT);


                                }
                                //Now his buff was removed and can be Debuffed :)


                                //Add him to ActivatedTemp
                                List skillsT = SkillsActivatedTemp.get(nick);
                                if(!skillsT.contains("Twisted Sun and Moon")){
                                    skillsT.add("Twisted Sun and Moon");
                                    SkillsActivatedTemp.put(nick,skillsT);
                                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                    //Add him to Effects
                                    List effects = new ArrayList<>();
                                    effects.add(Strength*0.10*(-1));
                                    effects.add(Stamina*0.10*(-1));
                                    effects.add(Health*0.10*(-1));
                                    effects.add(Intelligence*0.10*(-1));
                                    effects.add(Wisdom*0.10*(-1));
                                    effects.add(Luck*0.10*(-1));
                                    effects.add(Defense*0.10*(-1));
                                    effects.add(Agility*0.10*(-1));
                                    HashMap <String,List> effect= new HashMap<>();
                                    effect.put("Twisted Sun and Moon", effects);
                                    SkillsEffectT.put(nick,effect);
                                    Main.setSkillsEffectT(SkillsEffectT);
                                    //Add him to cooldown (None)
                                    HashMap <String,Integer> cooldowns= new HashMap<>();
                                    cooldowns.put("Twisted Sun and Moon",-1);
                                    SkillsCooldownT.put(nick,cooldowns);

                                    int TStrength = CCStats.get().getInt(nick+".TStrength");
                                    int TStamina = CCStats.get().getInt(nick+".TStamina");
                                    int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                    int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                    int TLuck = CCStats.get().getInt(nick+".TLuck");
                                    int TAgility = CCStats.get().getInt(nick+".TAgility");
                                    int TDefense = CCStats.get().getInt(nick+".TDefense");
                                    int THealth = CCStats.get().getInt(nick+".THealth");
                                    //Give him the Temp Stats
                                    CCStats.get().set(nick+".TStrength",TStrength-Strength*0.1);
                                    CCStats.get().set(nick+".TStamina",TStamina-Stamina*0.1);
                                    CCStats.get().set(nick+".TIntelligence",TIntelligence-Intelligence*0.1);
                                    CCStats.get().set(nick+".TWisdom",TWisdom-Wisdom*0.1);
                                    CCStats.get().set(nick+".TLuck",TLuck-Luck*0.1);
                                    CCStats.get().set(nick+".TAgility",TAgility-Agility*0.1);
                                    CCStats.get().set(nick+".TDefense",TDefense-Defense*0.1);
                                    CCStats.get().set(nick+".THealth",THealth-Health*0.1);
                                    CCStats.save();
                                    p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Debuff 10%) has taken effect!"));




                                }else{

                                }


                            }else{
                                //Player does not have any skill activated

                                //Add him to ActivatedTemp
                                List skillsT = new ArrayList<>();
                                skillsT.add("Twisted Sun and Moon");
                                SkillsActivatedTemp.put(nick,skillsT);
                                Main.setSkillsActivatedTemp(SkillsActivatedTemp);
                                //Add him to Effects
                                List effects = new ArrayList<>();
                                effects.add(Strength*0.10*(-1));
                                effects.add(Stamina*0.10*(-1));
                                effects.add(Health*0.10*(-1));
                                effects.add(Intelligence*0.10*(-1));
                                effects.add(Wisdom*0.10*(-1));
                                effects.add(Luck*0.10*(-1));
                                effects.add(Defense*0.10*(-1));
                                effects.add(Agility*0.10*(-1));
                                HashMap <String,List> effect= new HashMap<>();
                                effect.put("Twisted Sun and Moon", effects);
                                SkillsEffectT.put(nick,effect);
                                Main.setSkillsEffectT(SkillsEffectT);
                                //Add him to cooldown (None)
                                HashMap <String,Integer> cooldowns= new HashMap<>();
                                cooldowns.put("Twisted Sun and Moon",-1);
                                SkillsCooldownT.put(nick,cooldowns);

                                int TStrength = CCStats.get().getInt(nick+".TStrength");
                                int TStamina = CCStats.get().getInt(nick+".TStamina");
                                int TIntelligence = CCStats.get().getInt(nick+".TIntelligence");
                                int TWisdom = CCStats.get().getInt(nick+".TWisdom");
                                int TLuck = CCStats.get().getInt(nick+".TLuck");
                                int TAgility = CCStats.get().getInt(nick+".TAgility");
                                int TDefense = CCStats.get().getInt(nick+".TDefense");
                                int THealth = CCStats.get().getInt(nick+".THealth");
                                //Give him the Temp Stats
                                CCStats.get().set(nick+".TStrength",TStrength+Strength*0.10*(-1));
                                CCStats.get().set(nick+".TStamina",TStamina+Stamina*0.10*(-1));
                                CCStats.get().set(nick+".TIntelligence",TIntelligence+Intelligence*0.10*(-1));
                                CCStats.get().set(nick+".TWisdom",TWisdom+Wisdom*0.10*(-1));
                                CCStats.get().set(nick+".TLuck",TLuck+Luck*0.10*(-1));
                                CCStats.get().set(nick+".TAgility",TAgility+Agility*0.10*(-1));
                                CCStats.get().set(nick+".TDefense",TDefense+Defense*0.10*(-1));
                                CCStats.get().set(nick+".THealth",THealth+Health*0.10*(-1));
                                CCStats.save();
                                p.sendMessage(color("&5&l(!) Skill Twisted Sun and Moon (Debuff 10%) has taken effect!"));



                            }
                        }


                    }
                    //If in Nether or End, always buffed, cuz its always Night
                    /*
                    if( p.getWorld().getEnvironment().equals(World.Environment.NETHER) || p.getWorld().getEnvironment().equals(World.Environment.THE_END )	) {
                        p.sendMessage("Nether or End");
                        //If player has any buff
                        if(BuffsActivatedTemp.containsKey(nick)){
                            //If player has the Twisted Sun and Moon buff
                            if(BuffsActivatedTemp.get(nick).contains("Twisted Sun and Moon")){
                                //If the buff given was updated to new values



                            }else{
                                //Player doesnt have the TSAM Buff, so give it to him


                                List TwistedSAM = new ArrayList<>();
                                Map <String, List> BuffsEfT = new HashMap();
                                int Tstr = (int) (TStrength+(Strength*1.15));
                                int Tstm = (int) (TStamina+(Stamina*1.15));
                                int Tint = (int) (TIntelligence+(Intelligence*1.15));
                                int Twsd = (int) (TWisdom+(Wisdom*1.15));
                                int Tlck = (int) (TLuck+(Luck*1.15));
                                int Tagl = (int) (TAgility+(Agility*1.15));
                                int Tdfn = (int) (TDefense+(Defense*1.15));
                                int Thlt = (int) (THealth+(Health*1.15));

                                //Give the Temporary Stats
                                CCStats.get().set(nick+".TStrength",Tstr);
                                CCStats.get().set(nick+".TStamina",Tstm);
                                CCStats.get().set(nick+".TIntelligence",Tint);
                                CCStats.get().set(nick+".TWisdom",Twsd);
                                CCStats.get().set(nick+".TLuck",Tlck);
                                CCStats.get().set(nick+".TAgility",Tagl);
                                CCStats.get().set(nick+".TDefense",Tdfn);
                                CCStats.get().set(nick+".THealth",Thlt);
                                CCStats.save();
                                //Stats given

                                //Save to the Lists
                                TwistedSAM.add(Tstr);
                                TwistedSAM.add(Tstm);
                                TwistedSAM.add(Tint);
                                TwistedSAM.add(Twsd);
                                TwistedSAM.add(Tlck);
                                TwistedSAM.add(Tagl);
                                TwistedSAM.add(Tdfn);
                                TwistedSAM.add(Thlt);

                                //Effects
                                if(Main.getBuffsEffectT().get(nick).get("Twisted Sun and Moon")==null){
                                    // nick - Twisted Sun and Moon - List (of str,stm,...)
                                    BuffsEfT.put("Twisted Sun and Moon",TwistedSAM);
                                    Main.setBuffsEffectT(nick,);



                                }else{

                                }


                                Main.setBuffsActivatedTemp(BuffsEfT);
                                for(int i = 0; i<TwistedSAM.size();i++){
                                    p.sendMessage((String) TwistedSAM.get(i));
                                }



                            }
                        }else{
                            //Player doesnt have any buff, but is in Nether or End
                            //If player is debuffed, give him a buff and remove the debuff
                            //Have to add him to the list
                            if(DeBuffsActivatedTemp.containsKey(nick)){

                            }else{
                                p.sendMessage("Not buffed and not debuffed, is in Nether or End");
                                //Player isn´t debuffed
                                BuffsActivatedTemp = Main.getBuffsActivatedTemp();
                                String skill = "Twisted Sun and Moon";
                                List skillsList = new ArrayList<>();
                                if(BuffsActivatedTemp.get(nick)!=null){
                                    skillsList = BuffsActivatedTemp.get(nick);
                                    skillsList.add(skill);

                                }else{
                                    skillsList.add(skill);

                                }

                                List TwistedSAM = new ArrayList<>();
                                int Tstr =  (int) (TStrength+(Strength*0.15));
                                int Tstm =  (int) (TStamina+(Stamina*0.15));
                                int Tint =  (int) (TIntelligence+(Intelligence*0.15));
                                int Twsd =  (int) (TWisdom+(Wisdom*0.15));
                                int Tlck =  (int) (TLuck+(Luck*0.15));
                                int Tagl =  (int) (TAgility+(Agility*0.15));
                                int Tdfn =  (int) (TDefense+(Defense*0.15));
                                int Thlt =  (int) (THealth+(Health*0.15));
                                /*
                                //Give the Temporary Stats
                                CCStats.get().set(nick+".TStrength",Tstr);
                                CCStats.get().set(nick+".TStamina",Tstm);
                                CCStats.get().set(nick+".TIntelligence",Tint);
                                CCStats.get().set(nick+".TWisdom",Twsd);
                                CCStats.get().set(nick+".TLuck",Tlck);
                                CCStats.get().set(nick+".TAgility",Tagl);
                                CCStats.get().set(nick+".TDefense",Tdfn);
                                CCStats.get().set(nick+".THealth",Thlt);
                                CCStats.save();
                                //Stats given

                                //Save to the Lists
                                TwistedSAM.add(Tstr);
                                TwistedSAM.add(Tstm);
                                TwistedSAM.add(Tint);
                                TwistedSAM.add(Twsd);
                                TwistedSAM.add(Tlck);
                                TwistedSAM.add(Tagl);
                                TwistedSAM.add(Tdfn);
                                TwistedSAM.add(Thlt);
                                    p.sendMessage("str"+Tstr);
                                    p.sendMessage("stm"+Tstm);
                                    p.sendMessage("int"+Tint);
                                    p.sendMessage("wsd"+Twsd);
                                    p.sendMessage("lck"+Tlck);
                                    p.sendMessage("agl"+Tagl);
                                    p.sendMessage("dfn"+Tdfn);
                                    p.sendMessage("hkt"+Thlt);
                            //Now save the effects




                                //Finally putting the player to the lists
                                BuffsActivatedTemp.put(nick,skillsList);
                                //Main.setBuffsActivatedTemp(BuffsActivatedTemp);


                            }
                        }
                    }else{
                     //in OverWold


                    }*/





                        /*
                        //If skill is already activated, its in buffs, but if its not then give him a buff
                        if(!CCOn.get().getList(nick+".Buffs").contains("Twisted Sun and Moon")){
                            //Give the Temporary Stats
                            CCStats.get().set(nick+".TStrength",TStrength+Strength/100*110);
                            CCStats.get().set(nick+".TStamina",TStamina+Stamina/100*110);
                            CCStats.get().set(nick+".TIntelligence",TIntelligence+Intelligence/100*110);
                            CCStats.get().set(nick+".TWisdom",TWisdom+Wisdom/100*110);
                            CCStats.get().set(nick+".TLuck",TLuck+Luck/100*110);
                            CCStats.get().set(nick+".TAgility",TAgility+Agility/100*110);
                            CCStats.get().set(nick+".TDefense",TDefense+Defense/100*110);
                            CCStats.get().set(nick+".THealth",THealth+Health/100*110);
                            CCStats.save();
                            //Add it to the lists
                            List debuffs = new ArrayList<>();
                            debuffs = CCOn.get().getList(nick+".Buffs");
                            List debuffsC = new ArrayList<>();
                            debuffsC = CCOn.get().getList(nick+".BuffsC");
                            List debuffsEf = new ArrayList<>();
                            debuffsEf = CCOn.get().getList(nick+".BuffsEf");

                            List DebuffsEffect = new ArrayList<>();

                            debuffs.add("Twisted Sun and Moon");
                            debuffsC.add("None");
                            DebuffsEffect.add("Strength "+Strength/100*110);
                            DebuffsEffect.add("Stamina "+Stamina/100*110);
                            DebuffsEffect.add("Intelligence "+Intelligence/100*110);
                            DebuffsEffect.add("Wisdom "+Wisdom/100*110);
                            DebuffsEffect.add("Luck "+Luck/100*110);
                            DebuffsEffect.add("Agility "+Agility/100*110);
                            DebuffsEffect.add("Defense "+Defense/100*110);
                            DebuffsEffect.add("Health "+Health/100*110);

                            debuffsEf.add(DebuffsEffect);

                            CCOn.get().set(nick+".Debuffs",debuffs);
                            CCOn.get().set(nick+".DebuffsC",debuffsC);
                            CCOn.get().set(nick+".DebuffEf",debuffsEf);
                            p.sendMessage(String.valueOf(Strength));
                            p.sendMessage(String.valueOf(Stamina));
                            p.sendMessage(String.valueOf(Intelligence));
                            p.sendMessage(String.valueOf(Wisdom));
                            p.sendMessage(String.valueOf(Luck));
                            p.sendMessage(String.valueOf(Agility));
                            p.sendMessage(String.valueOf(Defense));
                            p.sendMessage(String.valueOf(Health));
                            //Saved all info in files
                        }
                        //Check if the player stats didnt change
                        List BuffsEf = CCOn.get().getList(nick+".BuffsEf");
                        if(BuffsEf!=null){
                            int EfStr = (int) BuffsEf.get(1);
                            int EfStm = (int) BuffsEf.get(2);
                            int EfInt = (int) BuffsEf.get(3);
                            int EfWis = (int) BuffsEf.get(4);
                            int EfLck = (int) BuffsEf.get(5);
                            int EfSAgl = (int) BuffsEf.get(6);
                            int EfDef = (int) BuffsEf.get(7);
                            int EfHlt = (int) BuffsEf.get(8);
                            //Stats did change
                            if(CCStats.get().getInt(nick+".Strength")/100*110!=EfStr ||
                                    CCStats.get().getInt(nick+".Strength")/100*110!=EfStr||CCStats.get().getInt(nick+".Strength")/100*110!=EfStm
                                    ||CCStats.get().getInt(nick+".Strength")/100*110!=EfInt
                                    ||CCStats.get().getInt(nick+".Strength")/100*110!=EfWis
                                    ||CCStats.get().getInt(nick+".Strength")/100*110!=EfLck
                                    ||CCStats.get().getInt(nick+".Strength")/100*110!=EfSAgl
                                    |CCStats.get().getInt(nick+".Strength")/100*110!=EfDef
                                    ||CCStats.get().getInt(nick+".Strength")/100*110!=EfHlt
                            ){

                                //Change the buff accordingly to the players new stats
                                //Add it to the lists
                                List debuffs = new ArrayList<>();
                                debuffs = CCOn.get().getList(nick+".Buffs");
                                List debuffsC = new ArrayList<>();
                                debuffsC = CCOn.get().getList(nick+".BuffsC");
                                List debuffsEf = new ArrayList<>();
                                debuffsEf = CCOn.get().getList(nick+".BuffsEf");

                                List DebuffsEffect = new ArrayList<>();

                                DebuffsEffect.add("Strength "+Strength/100*110);
                                DebuffsEffect.add("Stamina "+Stamina/100*110);
                                DebuffsEffect.add("Intelligence "+Intelligence/100*110);
                                DebuffsEffect.add("Wisdom "+Wisdom/100*110);
                                DebuffsEffect.add("Luck "+Luck/100*110);
                                DebuffsEffect.add("Agility "+Agility/100*110);
                                DebuffsEffect.add("Defense "+Defense/100*110);
                                DebuffsEffect.add("Health "+Health/100*110);

                                debuffsEf.add(DebuffsEffect);

                                CCOn.get().set(nick+".Debuffs",debuffs);
                                CCOn.get().set(nick+".DebuffsC",debuffsC);
                                CCOn.get().set(nick+".DebuffEf",debuffsEf);

                            }
                        }

                        //||


                        //its overworld
                    }else{
                        if(p.getWorld().getTime()>0&& p.getWorld().getTime()<12301){
                            if(!CCOn.get().getList(nick+".Debuffs").contains("Twisted Sun and Moon")){
                                CCStats.get().set(nick+".TStrength",TStrength+Strength/100*110);
                                CCStats.get().set(nick+".TStamina",TStamina+Stamina/100*110);
                                CCStats.get().set(nick+".TIntelligence",TIntelligence+Intelligence/100*110);
                                CCStats.get().set(nick+".TWisdom",TWisdom+Wisdom/100*110);
                                CCStats.get().set(nick+".TLuck",TLuck+Luck/100*110);
                                CCStats.get().set(nick+".TAgility",TAgility+Agility/100*110);
                                CCStats.get().set(nick+".TDefense",TDefense+Defense/100*110);
                                CCStats.get().set(nick+".THealth",THealth+Health/100*110);
                                CCStats.save();
                                List debuffs = new ArrayList<>();
                                debuffs = CCOn.get().getList(nick+".Debuffs");
                                List debuffsC = new ArrayList<>();
                                debuffsC = CCOn.get().getList(nick+".DebuffsC");
                                int index = debuffs.indexOf("Twisted Sun and Moon");
                                debuffs.remove(index);
                                debuffsC.remove(index);
                                CCOn.get().set(nick+".Debuffs",debuffs);
                                CCOn.get().set(nick+".DebuffsC",debuffsC);
                            }
                        } else{
                            if(!CCOn.get().getList(nick+".Debuffs").contains("Twisted Sun and Moon")){
                                CCStats.get().set(nick+".TStrength",TStrength+Strength/100*110);
                                CCStats.get().set(nick+".TStamina",TStamina+Stamina/100*110);
                                CCStats.get().set(nick+".TIntelligence",TIntelligence+Intelligence/100*110);
                                CCStats.get().set(nick+".TWisdom",TWisdom+Wisdom/100*110);
                                CCStats.get().set(nick+".TLuck",TLuck+Luck/100*110);
                                CCStats.get().set(nick+".TAgility",TAgility+Agility/100*110);
                                CCStats.get().set(nick+".TDefense",TDefense+Defense/100*110);
                                CCStats.get().set(nick+".THealth",THealth+Health/100*110);
                                CCStats.save();
                                List debuffs = new ArrayList<>();
                                debuffs = CCOn.get().getList(nick+".Debuffs");
                                List debuffsC = new ArrayList<>();
                                debuffsC = CCOn.get().getList(nick+".DebuffsC");
                                int index = debuffs.indexOf("Twisted Sun and Moon");
                                debuffs.remove(index);
                                debuffsC.remove(index);
                                CCOn.get().set(nick+".Debuffs",debuffs);
                                CCOn.get().set(nick+".DebuffsC",debuffsC);
                            }
                        }

                    }*/


                }

            }
    }
}
