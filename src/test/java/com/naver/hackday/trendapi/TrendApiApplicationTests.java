package com.naver.hackday.trendapi;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrendApiApplicationTests {

    @Test
    public void contextLoads() {
        try {

            //Document doc = Jsoup.connect("https://datalab.naver.com/keyword/").get();

            File input = new File("/Users/shani/Desktop/test.html");
            Document doc = Jsoup.parse(input, "UTF-8", "https://datalab.naver.com");
            Elements nodes = doc.select("[data-age='all']").select("span.title");
            System.out.println(nodes);
            nodes.stream().forEach(n->System.out.println(n.text()));

//            Optional<Element> allAgeNode = nodes.stream().filter(n -> "all".equals(n.attr("data-age"))).findFirst();
//            if(allAgeNode.isPresent()){
//                Elements titleNodes = allAgeNode.get().select("span .title");
//
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
