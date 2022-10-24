package alom.server.payload;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupAndSubjects implements Serializable {
    private Group group;
    private Set<Subject> subjects = new HashSet<>();
}
