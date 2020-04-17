package in.bugr.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BugRui
 * @date 2020/3/25 下午12:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RecognitionResult {
    long id;
    @Builder
    @Getter
    public static class Detail {
        long personId;
        byte[] faceImgData;
        float compareScore;
    }

    List<Detail> persons = new ArrayList<>();

    public RecognitionResult add(Long personId, float compareScore, byte[] faceImgData) {
        persons.add(Detail.builder().personId(personId)
                .compareScore(compareScore)
                .faceImgData(faceImgData).build());
        return this;
    }
}
