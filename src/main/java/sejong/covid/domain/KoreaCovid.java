package sejong.covid.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@Builder
public class KoreaCovid {
    private String city;

    private String DTD_Total;

    private String DTD_Kor;

    private String DTD_Foreign;

    private String total;

    private String death;

    private String incidence;
}
