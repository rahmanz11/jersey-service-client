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
   * Adds a subject
   * @param subject
   * @return
   */
  public static Subject addSubject(Subject subject) {
    subject.setId(subjectId++);
    subjects.add(subject);
    return subject;
  }

  /**
   * Returns a subjet
   * 
   * @param Subject
   * @return
   */
  public static Subject getSubject(int subjectId) {
    Optional<Subject> available = subjects.stream().filter(s -> s.getId() == subjectId).findFirst();
    try {
      return available.get();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Updates a subject
   * @param Subject
   * @return
   */
  public static Subject updateSubject(Subject subject) {
    Subject response = null;
    for (Subject sub : subjects) {
      if (sub.getId() == subject.getId()) {
        sub.setName(subject.getName());
        response = sub;
        break;
      }
    }

    return response;
  }

  /**
   * Deletes a subject
   * @param Subject
   * @return
   */
  public static Subject deleteSubject(Subject subject) {
    if (subjects.size() > 0) {
      subjects.remove(subject);
      return subject;
    }

    return null;
  }

  /**
   * Adds a group
   * @param Group
   * @return
   */
  public static Group addGroup(Group group) {
    group.setId(groupId++);
    groups.add(group);
    return group;
  }


  /**
   * Returns a group
   * @param Group
   * @return
   */
  public static Group getGroup(int groupId) {
    Optional<Group> available = groups.stream().filter(s -> s.getId() == groupId).findFirst();
    try {
      return available.get();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Updates a group
   * @param Group
   * @return
   */
  public static Group updateGroup(Group group) {
    Group response = null;
    for (Group grp : groups) {
      if (grp.getId() == group.getId()) {
        grp.setName(group.getName());
        response = grp;
        break;
      }
    }

    return response;
  }

  /**
   * Deletes a group
   * @param Group
   * @return
   */
  public static Group deleteGroup(Group group) {
    if (groups.size() > 0) {
      groups.remove(group);
      return group;
    }

    return null;
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
