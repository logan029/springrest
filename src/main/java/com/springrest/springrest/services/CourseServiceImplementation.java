package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService{

    @Autowired
    private CourseDao courseDAO;

//    List<Course> list;

//    public CourseServiceImplementation(){
//        list = new ArrayList<>();
//        list.add(new Course(123, "Java Core Course", "This course contains basics of Java"));
//        list.add(new Course(145, "Python Course", "This course contains basic of Python"));
//    }

    @Override
    public List<Course> getCourses() {
//        return list;
        return courseDAO.findAll();
    }

    @Override
    public Course getCourseByID(long courseID) {
//        Course course = null;
//        for(Course c : list){
//            if(c.getCourseID() == courseID){
//                course = c;
//                break;
//            }
//        }
//        return course;
        return courseDAO.getById(courseID);
    }

    @Override
    public Course addCourse(Course course){
//        list.add(course);
//        return course;
        courseDAO.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course){
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).getCourseID() == course.getCourseID()){
//                list.get(i).setCourseTitle(course.getCourseTitle());
//                list.get(i).setCourseDescription(course.getCourseDescription());
//            }
//        }
//        return course;
        courseDAO.save(course);

        return course;
    }

    @Override
    public void deleteCourse(long courseID){
//        list = this.list.stream().filter(e -> e.getCourseID() != courseID).collect(Collectors.toList());

        Course entity = courseDAO.getById(courseID);
        courseDAO.delete(entity);
    }
}
