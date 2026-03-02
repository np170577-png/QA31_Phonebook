package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]>example(){
        List<Object[]>list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"np7788@inbox.ru", "WadiNisnas8#"});
        list.add(new Object[]{"np77@inbox.ru", "Satiblai4t!"});
        list.add(new Object[]{"np7788@inbox.ru", "WadiNisnas8#"});
        list.add(new Object[]{"np7788@inbox.ru", "WadiNisnas8#"});
//        list.add(new Object[]{"margo@gmail.com","Mmar123456$"});
//        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
//        list.add(new Object[]{"mara@gmail.com","Mmar123456$"});
//        list.add(new Object[]{"margo@gmail.com","Mmar123456$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>loginModel(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#")});
        list.add(new Object[]{new User().setEmail("np77@inbox.ru").setPassword("Satiblai4t!")});
        list.add(new Object[]{new User().setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>loginFile() throws IOException {
        List<Object[]>list = new ArrayList<>();
        //read from file --> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line =  reader.readLine();
        while (line!=null){
            String[] all =  line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

}
