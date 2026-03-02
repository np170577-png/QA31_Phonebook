package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContacts {

    @DataProvider
    public Iterator<Object[]> exapmle() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder().
                name("Jason").
                lastName("Momoa").
                phone("12245630679").
                email("momoa@gmail.com").
                address("Washington, DC").
                description("All fields")
                .build()});

        list.add(new Object[]{Contact.builder().
                name("Jasonito").
                lastName("Momoato").
                phone("198765430679").
                email("momoato@gmail.com").
                address("Washington, DC")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder().
                name("Jas").
                lastName("Mom").
                phone("").
                email("mom@gmail.com").
                address("Washington, DC").
                description("Wrong phone").
                build()});
        list.add(new Object[]{Contact.builder().
                name("Jaso").
                lastName("Momo").
                phone("123456789").
                email("moma@gmail.com").
                address("Washington, DC").
                description("Wrong phone").
                build()});
        list.add(new Object[]{Contact.builder().
                name("Jass").
                lastName("Moma").
                phone("1234567890123456").
                email("momo@gmail.com").
                address("Washington, DC").
                description("Wrong phone").
                build()});
        list.add(new Object[]{Contact.builder().
                name("Jasonn").
                lastName("Momoaa").
                phone("qwertyuiopdk").
                email("momoa@gmail.com").
                address("Washington, DC").
                description("Wrong phone").
                build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .phone(all[2])
                    .address(all[3])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
