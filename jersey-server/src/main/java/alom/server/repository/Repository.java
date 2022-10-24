package alom.server.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import alom.server.payload.Group;
import alom.server.payload.GroupAndSubjects;
import alom.server.payload.Note;
import alom.server.payload.Result;
import alom.server.payload.Results;
import alom.server.payload.Student;
import alom.server.payload.StudentAndGroup;
import alom.server.payload.Subject;
import alom.server.payload.SubjectAndNote;

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
   * Adds a student to a group
   * @param student
   * @param group
   * @return
   */
  public static String addStudentToTheGroup(Student student, Group group) {
    removeStudentFromTheGroup(student, group);
    studentAndGroup.add(new StudentAndGroup(student, group));
    return "Success";
  }

  /**
   * Removes a student from a group
   * @param student
   * @param group
   * @return
   */
  public static String removeStudentFromTheGroup(Student student, Group group) {
    studentAndGroup.removeIf(sg -> sg.getGroup().getId() == student.getId() && sg.getGroup().getId() == group.getId());
    return "Success";
  }

  /**
   * Join a group with subjects
   * @param group
   * @param subjects
   * @return
   */
  public static String jointGroupWithSubjects(Group group, Set<Subject> subjects) {
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
    return "Success";
  }

  /**
   * Remove link between group and subject
   * @param group
   * @param subjects
   * @return
   */
  public static String disjointGroupFromSubjects(Group group, Set<Subject> subjects) {
    groupAndSubjects.forEach(gs -> {
      if (gs.getGroup().getId() == group.getId()) {
        gs.getSubjects().removeAll(subjects);
      }
    });
    return "Success";
  }

  /**
   * Give note in a subject to a student
   * @param student
   * @param subject
   * @param note
   * @return
   */
  public static String giveNoteInASubjectToAStudent(Student student, Subject subject, Integer note) {
    notes.add(new Note(student, new SubjectAndNote(subject, note)));
    return "Success";
  }

  /**
   * Modify note in a subject to a student
   * @param student
   * @param subject
   * @param note
   * @return
   */
  public static String modifyNoteInASubjectToAStudent(Student student, Subject subject, Integer note) {
    notes.forEach(n -> {
      if (n.getStudent().getId() == student.getId() && n.getSubjectAndNote().getSubject().getId() == subject.getId()) {
        n.getSubjectAndNote().setNote(note);
      }
    });
    return "Success";
  }

  /**
   * Delete note in a subject to a student
   * @param student
   * @param subject
   * @return
   */
  public static String deleteNoteInASubjectOfAStudent(Student student, Subject subject) {
    Iterator<Note> nIterator = notes.iterator();
    while (nIterator.hasNext()) {
      Note n = nIterator.next();
      if (n.getStudent().getId() == student.getId() && n.getSubjectAndNote().getSubject().getId() == subject.getId()) {
        nIterator.remove();
      }
    }
    return "Success";
  }

  public static Results showResults() {
    Results results = null;
    Set<Result> resultList = new HashSet<>();
    for (Student std : students) {
      Result result = new Result();
      result.setStudent(std);
      for (StudentAndGroup sg : studentAndGroup) {
        if (sg.getStudent().getId() == std.getId()) {
          result.setGroup(sg.getGroup());
          for (GroupAndSubjects gs : groupAndSubjects) {
            if (gs.getGroup().getId() == sg.getGroup().getId()) {
              for (Subject sub : gs.getSubjects()) {
                Set<SubjectAndNote> subjectAndNotes = new HashSet<>();
                for (Note note : notes) {
                  if (note.getStudent().getId() == std.getId() && note.getSubjectAndNote().getSubject().getId() == sub.getId()) {
                    subjectAndNotes.add(new SubjectAndNote(sub, note.getSubjectAndNote().getNote()));
                  }
                }
                result.setSubjectAndNote(subjectAndNotes);
              }
            }
          }
        }
      }
      resultList.add(result);
    }

    if (resultList.size() > 0) {
      results = new Results(resultList);
    }
    return results;
  }
}
