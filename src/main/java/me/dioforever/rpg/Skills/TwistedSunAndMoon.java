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
                                p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));

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
                                    p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));
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
                            p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));



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
                                    p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));




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

                                p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Buff 15%) has taken effect!"));



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
                                    p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Debuff 10%) has taken effect!"));




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
                                p.sendMessage(color("&5&l[RPG]&r&5 Skill Twisted Sun and Moon (Debuff 10%) has taken effect!"));



                            }
                        }
                    }
                }
        }
    }
}
