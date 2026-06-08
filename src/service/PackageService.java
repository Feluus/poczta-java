package service;

import model.PackageData;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageService {
    ArrayList<PackageData> packages = new ArrayList<>();
    public ArrayList<PackageData> getPackages()
    {
        return packages;
    }
    public void savePackagesToFile()
    {
        try(PrintWriter writer =
                    new PrintWriter("src/TXT/packages.txt"))
        {
            for(PackageData p : packages)
            {
                writer.println(
                        p.ownerLogin + ";" +
                                p.receiverName + ";" +
                                p.city + ";" +
                                p.address + ";" +
                                p.senderPhone + ";" +
                                p.receiverPhone + ";" +
                                p.size + ";" +
                                p.packageCode + ";" +
                                p.status
                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void loadPackagesFromFile()
    {
        packages.clear();

        try(Scanner fileScanner =
                    new Scanner(new File("src/TXT/packages.txt")))
        {
            while(fileScanner.hasNextLine())
            {
                String[] data =
                        fileScanner.nextLine().split(";");

                packages.add(
                        new PackageData(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                data[5],
                                data[6],
                                data[7],
                                data[8]
                        )
                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addPackage(PackageData pack)
    {
        packages.add(pack);
        savePackagesToFile();
    }
    public PackageService()
    {
        loadPackagesFromFile();
    }

    public PackageData findPackage(String code, String phone)
    {
        for(PackageData p : packages)
        {
            if(p.packageCode.equals(code)
                    &&
                    (p.senderPhone.equals(phone)
                            || p.receiverPhone.equals(phone)))
            {
                return p;
            }
        }

        return null;
    }
}
