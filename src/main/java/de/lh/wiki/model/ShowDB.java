package de.lh.wiki.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.InputType.file;

/**
 * @author Joern Kuhlenkamp (j.kuhlenkamp@gmail.com)
 *         Created by on 18.03.18.
 */
public class ShowDB {

    public class Show {
        public final String name;
        public final boolean active;
        public final String article;
        public final String project;

        public Show(String name, boolean active, String article, String project) {
            this.name = name;
            this.active = active;
            this.article = article;
            this.project = project;
        }
    }

    private final List<Show> shows = new ArrayList<Show>();

    public void init(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] c = line.split(";");
                boolean inProgram = false;
                if (c[1].equals("1")) { inProgram = true; }
                shows.add(new Show(c[0],inProgram,c[2],c[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        shows.add(new Show("2 BROKE GIRLS", true, "2_Broke_Girls", "de"));
        shows.add(new Show("AKTE X", true, "Akte_X_–_Die_unheimlichen_Fälle_des_FBI", "de"));
        shows.add(new Show("BEGINNER GEGEN GEWINNER", true,	"Beginner_gegen_Gewinner", "de"));
        shows.add(new Show("DAS DING DES JAHRES", true,	"Das_Ding_des_Jahres", "de"));
        shows.add(new Show("DIE SIMPSONS", true, "Die_Simpsons", "de"));
        shows.add(new Show("FAMILY GUY - ALLES ZUM ZEICHENTRICKHIT",true, "Family_Guy", "de"));
        shows.add(new Show("GALILEO", true,	"Galileo_(Fernsehsendung)",	"de"));
        shows.add(new Show("GALILEO BIG PICTURES", true, "Galileo_Big_Pictures", "de"));
        shows.add(new Show("GERMANY'S NEXT TOPMODEL", true, "Germany’s_Next_Topmodel", "de"));
        shows.add(new Show("GET THE F*CK OUT OF MY HOUSE", true, "Get_the_F*ck_out_of_my_House", "de"));
        shows.add(new Show("GREEN SEVEN - SAVE THE ICE", true, null, null));
        shows.add(new Show("HOW I MET YOUR MOTHER", true, "How_I_Met_Your_Mother", "de"));
        shows.add(new Show("DUELL UM DIE WELT", true, "Joko_gegen_Klaas_–_Das_Duell_um_die_Welt", "de"));
        shows.add(new Show("KISS BANG LOVE", true, "Kiss_Bang_Love", "en"));
        shows.add(new Show("LAST MAN STANDING", true, "Last_Man_Standing_(Fernsehserie)", "de"));
        shows.add(new Show("LATE NIGHT BERLIN - MIT KLASS HEUFER-UMLAUF", true, "Late_Night_Berlin", "de"));
        shows.add(new Show("LUCIFER", true, "Lucifer_(Fernsehserie)", "de"));
        shows.add(new Show("MALCOLM MITTENDRIN", true, "Malcolm_mittendrin", "de"));
        shows.add(new Show("MIKE & MOLLY", true, "Mike_%26_Molly", "de"));
        shows.add(new Show("MISSION WAHNSINN", true, null, null));
        shows.add(new Show("NEW GIRLS", true, "New_Girl", "de"));
        shows.add(new Show("NEWSTIME", true, "Newstime", "de"));
        shows.add(new Show("red.", true, "Red!_Stars,_Lifestyle_%26_More", "de"));
        shows.add(new Show("SCHLAG DEN HENSSLER", true, "Schlag_den_Henssler", "de"));
        shows.add(new Show("SUPERSTORE", true, "Superstore", "de"));
        shows.add(new Show("SWORD ART ONLINE", true, "Sword_Art_Online", "de"));
        shows.add(new Show("TAFF", true, "Taff", "de"));
        shows.add(new Show("THE BIG BANG THEORY", true, "The_Big_Bang_Theory", "de"));
        shows.add(new Show("THE EXORCIST", true, "The_Exorcist_(Fernsehserie)",	"de"));
        shows.add(new Show("THE GRINDER - IMMER IM RECHT", true, "The_Grinder_–_Immer_im_Recht", "de"));
        shows.add(new Show("THE MICK", true, "The_Mick", "de"));
        shows.add(new Show("THE MIDDLE", true, "The_Middle", "de"));
        shows.add(new Show("THE ORVILLE", true, "The_Orville", "de"));
        shows.add(new Show("THE VOICE OF GERMANY", true, "The_Voice_of_Germany", "de"));
        shows.add(new Show("TWO AND A HALF MEN", true, "Two_and_a_Half_Men", "de"));
        shows.add(new Show("YOUNG SHELDON", true, "Young_Sheldon", "de"));
        shows.add(new Show("10 FAKTEN", false, null, null));
        shows.add(new Show("ABSOLUTE MEHRHEIT", false, null, null));
        shows.add(new Show("APARTMENT 23", false, "Apartment_23", "de"));
        shows.add(new Show("APPLAUS UND RAUS", false, null,	null));
        shows.add(new Show("ARE YOU THERE, CHELSEA", false, "Are_You_There,_Chelsea%3F", "de"));
        shows.add(new Show("BABY DADDY", false, "Baby_Daddy", "de"));
        shows.add(new Show("BAMBI",	false, "Bambi_(Auszeichnung)", "de"));
        shows.add(new Show("BEAUTY & THE NERD", false, null, null));
        shows.add(new Show("BESTE SHOW DER WELT",  false, "Die_beste_Show_der_Welt", "de"));
        shows.add(new Show("BIG STORIES", false, null, null));
        shows.add(new Show("BRICKLEBERRY", false, "Brickleberry", "de"));
        shows.add(new Show("Bully macht Buddy", false, "Bully_macht_Buddy", "de"));
        shows.add(new Show("Bundesvision Song Contest", false, "Bundesvision_Song_Contest", "de"));
        shows.add(new Show("CATCH THE MILLIONAIRE",	false, null, null));
        shows.add(new Show("CIRCUS HALLIGALLI",	false, "Circus_HalliGalli",	"de"));
        shows.add(new Show("CLASH! BOOM! BANG!", false, null, null));
        shows.add(new Show("COMEDY CLASSICS", false, null, null));
        shows.add(new Show("COMEDYSTREET XXL", false, "Comedystreet", "de"));
        shows.add(new Show("CONTAINMENT", false, "Containment_–_Eine_Stadt_hofft_auf_Rettung", "de"));
        shows.add(new Show("COVER UP - WIR RETTEN DEIN TATTOO", false, null, null));
        shows.add(new Show("CRASH GAMES", false, "Crash_Games_–_Jeder_Sturz_zählt!", "de"));
        shows.add(new Show("CRAZY DATES", false, null, null));
        shows.add(new Show("DIE VERRÜCKTESTEN CELEBRITIES, DIE HIPSTEN VIP-LADYS UND PROTZIGSTEN MILLIONÄRE", false, null, null));
        shows.add(new Show("DAS DUELL UM DIE GELD", false, null, null));
        shows.add(new Show("DAS GROSSE PROSIEBEN PROMIBOXEN", false, "Promiboxen", "de"));
        shows.add(new Show("DAS MODEL UND DER FREAK", false, "Das_Model_und_der_Freak", "de"));
        shows.add(new Show("DAS PROSIEBEN AUSWÄRTSSPIEL", false, "Das_ProSieben_Auswärtsspiel", "de"));
        shows.add(new Show("DAS PROSIEBEN LÄNDERSPIEL", false, null, null));
        shows.add(new Show("DEUTSCHLAND TANZT", false, "Deutschland_tanzt",	"de"));
        shows.add(new Show("DEVIOUS MAIDS", false, "Devious_Maids_–_Schmutzige_Geheimnisse", "de"));
    }

    public Show getShow(String name) {
        for(Show show : shows) {
            if(name.equals(show.article)) {
                return show;
            }
        }
        return null;
    }

}
