package service;

import model.UserProfile;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserProfileService {

    ArrayList<UserProfile> profiles = new ArrayList<>();

    public UserProfileService() {
        loadProfilesFromFile();
    }

    public void saveProfilesToFile() {

        try(PrintWriter writer =
                    new PrintWriter("src/TXT/userProfiles.txt")) {

            for(UserProfile p : profiles) {

                writer.println(
                        p.login + ";" +
                                p.firstName + ";" +
                                p.lastName + ";" +
                                p.address + ";" +
                                p.phone
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void loadProfilesFromFile() {

        profiles.clear();

        try(Scanner scanner =
                    new Scanner(new File("src/TXT/userProfiles.txt"))) {

            while(scanner.hasNextLine()) {

                String[] data =
                        scanner.nextLine().split(";");

                profiles.add(
                        new UserProfile(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4]
                        )
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void saveProfile(UserProfile profile) {

        boolean found = false;

        for(int i=0; i<profiles.size(); i++) {

            if(profiles.get(i).login.equals(profile.login)) {

                profiles.set(i, profile);
                found = true;
                break;
            }
        }

        if(!found) {
            profiles.add(profile);
        }

        saveProfilesToFile();
    }

    public UserProfile getProfile(String login) {

        for(UserProfile p : profiles) {

            if(p.login.equals(login)) {
                return p;
            }
        }

        return null;
    }
}