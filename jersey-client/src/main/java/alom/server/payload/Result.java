package alom.server.payload;

import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result implements Serializable {
    private Student student;
    private Group group;
    private Map<Subject, Integer> subjectAndNote;
}
