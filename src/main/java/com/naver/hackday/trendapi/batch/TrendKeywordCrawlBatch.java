package com.naver.hackday.trendapi.batch;

import com.naver.hackday.trendapi.model.TrendKeyword;
import com.naver.hackday.trendapi.repository.TrendKeywordRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class TrendKeywordCrawlBatch {
    private final TrendKeywordRepository trendKeywordRepository;

    @Autowired
    public TrendKeywordCrawlBatch(TrendKeywordRepository trendKeywordRepository) {
        this.trendKeywordRepository = trendKeywordRepository;
    }

    // 애플리케이션 시작 후 10초 후에 첫 실행, 그 후 매 fixedDelay 밀리세컨드마다 주기적으로 실행한다.
    @Scheduled(initialDelay = 10000, fixedDelay = 1800000)
    public void crawl() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://datalab.naver.com/keyword/realtimeList.naver").get();
            Elements nodes = doc.select("[data-age='all']").select("span.title");
            trendKeywordRepository.save(new TrendKeyword(nodes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("batch!!");
    }

  /*  크론탭 형태로도 설정 가능
    // 매월 1일 0시 0분 0초에 실행한다.
    @Scheduled(cron = "0 0 0 1 * *")
    public void anotherJob() {

        // 실행될 로직
    }
    */
}
