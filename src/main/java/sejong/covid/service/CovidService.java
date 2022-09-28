package sejong.covid.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.thymeleaf.engine.ElementName;
import sejong.covid.domain.KoreaCovid;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService {
    private final String url = "http://ncov.kdca.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";

    @PostConstruct
    public List<KoreaCovid> getCovidData() throws IOException{
        List<KoreaCovid> koreaCovidList = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        Elements class_contents = doc.getElementsByClass("num midsize");
        Elements td_contents = class_contents.select("tbody tr");

        for(Element content : td_contents){
            Elements tdContents = content.select("td");

            KoreaCovid koreaCovid = KoreaCovid.builder()
                    .city(content.select("th").text())
                    .DTD_Total(tdContents.get(0).text())
                    .DTD_Kor(tdContents.get(1).text())
                    .DTD_Foreign(tdContents.get(2).text())
                    .total(tdContents.get(3).text())
                    .death(tdContents.get(4).text())
                    .incidence(tdContents.get(5).text())
                    .build();
            koreaCovidList.add(koreaCovid);
        }

        return koreaCovidList;
    }
}
