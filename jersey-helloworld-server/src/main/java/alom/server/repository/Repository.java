package alom.server.repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import alom.server.payload.Group;
import alom.server.payload.GroupAndSubjects;
import alom.server.payload.Note;
import alom.server.payload.Student;
import alom.server.payload.StudentAndGroup;
import alom.server.payload.Subject;

public class Repository implements Serializable {
  static Set<Student> students = new HashSet<>();
  static Set<Subject> subjects = new HashSet<>();
  static Set<Group> groups = new HashSet<>();

  static Set<StudentAndGroup> studentAndGroup = new HashSet<>();
  static Set<GroupAndSubjects> groupAndSubjects = new HashSet<>();
  static Set<Note> notes = new HashSet<>();

  static int studentId = 1;
  static int subjectId = 1;
  static int groupId = 1;

  /**
   * Add a new student
   * @param student
   * @return
   */
  public static Student addStudent(Student student) {
    student.setId(studentId++);
    students.add(student);
    return student;
  }

  /**
   * Returns a student
   * 
   * @param Student
   * @return
   */
  public static Student getStudent(int studentId) {
    Optional<Student> available = students.stream().filter(s -> s.getId() == studentId).findFirst();
    try {
      return available.get();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Updates a student
   * @param Student
   * @return
   */
  public static Student updateStudent(Student student) {
    Student response = null;
    for (Student std : students) {
      if (std.getId() == student.getId()) {
        std.setName(student.getName());
        std.setSurName(student.getSurName());
        response = std;
        break;
      }
    }

    return response;
  }

  /**
   * Deletes a student
   * @param Student
   * @return
   */
  public static Student deleteStudent(Student student) {
    if (students.size() > 0) {
      students.remove(student);
      return student;
    }

    return null;
  }

  /**
   * Add new subject to the hash
   * 
   * @param Subject
   */
  public static void addSubject(Subject subject) {
    subject.setId(subjectId++);
    subjects.add(subject);
  }

  /**
   * Returns a subject
   * 
   * @param Subject
   * @return
   */
  public static Subject getSubject(Subject subject) {
    for (Subject sub : subjects) {
      if (sub.getId() == subject.getId()) {
        return sub;
      }
    }
    return null;
  }

  /**
   * Updates a subject
   * 
   * @param Subject
   */
  public static void updateSubject(Subject subject) {
    for (Subject sub : subjects) {
      if (sub.getId() == subject.getId()) {
        sub.setName(subject.getName());
      }
    }
  }

  /**
   * Deletes a subject
   * 
   * @param Subject
   */
  public static void deleteSubject(Subject subject) {
    if (subjects.size() > 0) {
      subjects.remove(subject);
    }
  }

  /**
   * Add new group to the hash
   * 
   * @param Group
   */
  public static void addGroup(Group group) {
    group.setId(groupId++);
    groups.add(group);
  }

  /**
   * Returns a group
   * 
   * @param Group
   * @return
   */
  public static Group getGroup(Group group) {
    for (Group grp : groups) {
      if (grp.getId() == group.getId()) {
        return grp;
      }
    }
    return null;
  }

  /**
   * Updates a group
   * 
   * @param Group
   */
  public static void updateGroup(Group group) {
    for (Group grp : groups) {
      if (grp.getId() == group.getId()) {
        grp.setName(group.getName());
      }
    }
  }

  /**
   * Deletes a group
   * 
   * @param Group
   */
  public static void deleteGroup(Group group) {
    if (groups.size() > 0) {
      groups.remove(group);
    }
  }

  /**
   * Addss student to the group
   * 
   * @param Student
   * @param Group
   */
  public static void addStudentToTheGroup(Student student, Group group) {
    removeStudentFromTheGroup(student, group);
    studentAndGroup.add(new StudentAndGroup(student, group));
  }

  /**
   * Removes student from the group
   * 
   * @param Group
   * @param Group
   */
  public static void removeStudentFromTheGroup(Student student, Group group) {
    studentAndGroup.removeIf(sg -> sg.getGroup().getId() == student.getId() && sg.getGroup().getId() == group.getId());
  }

  /**
   * Joint a group with subjects
   * 
   * @param Group
   * @param Set<Subject>
   */
  public static void jointGroupWithSubjects(Group group, Set<Subject> subjects) {
    AtomicBoolean added = new AtomicBoolean(false);
    groupAndSubjects.forEach(gs -> {
      if (gs.getGroup().getId() == group.getId()) {
        gs.getSubjects().addAll(subjects);
        added.set(true);
      }
    });
    if (!added.get()) {
      groupAndSubjects.add(new GroupAndSubjects(group, subjects));
    }
  }

  /**
   * Disjoint a group with subjects
   * 
   * @param Group
   * @param Set<Subject>
   */
  public static void disjointGroupFromSubjects(Group group, Set<Subject> subjects) {
    groupAndSubjects.forEach(gs -> {
      if (gs.getGroup().getId() == group.getId()) {
        gs.getSubjects().removeAll(subjects);
      }
    });
  }

  /**
   * Give note in a subject to a student
   * 
   * @param Student
   * @param Subject
   * @param note
   */
  public static void giveNoteInASubjectToAStudent(Student student, Subject subject, Integer note) {
    notes.add(new Note(student, subject, note));
  }

  /**
   * Modify note in a subject to a student
   * 
   * @param Student
   * @param Subject
   * @param note
   */
  public static void modifyNoteInASubjectToAStudent(Student student, Subject subject, Integer note) {
    notes.forEach(n -> {
      if (n.getStudent().getId() == student.getId() && n.getSubject().getId() == subject.getId()) {
        n.setNote(note);
      }
    });
  }

  /**
   * Delete note in a subject to a student
   * 
   * @param Student
   * @param Subject
   */
  public static void deleteNoteInASubjectOfAStudent(Student student, Subject subject) {
    Iterator<Note> nIterator = notes.iterator();
    while (nIterator.hasNext()) {
      Note n = nIterator.next();
      if (n.getStudent().getId() == student.getId() && n.getSubject().getId() == subject.getId()) {
        nIterator.remove();
      }
    }
  }
}
