package com.example.N.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.N.model.TeacherModel;
import com.example.N.repository.TeacherRepository;

@Service
public class TeacherService implements UserDetailsService {
 
    @Autowired
    private TeacherRepository teacherRepository;
 
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        TeacherModel teacher = teacherRepository.findByTeacherIdEquals(id);
        if (teacher == null) {
            throw new UsernameNotFoundException("User not found with ID: " + id);
        }
        return new org.springframework.security.core.userdetails.User(
            teacher.getTeacherId(),
            teacher.getPassword(),
            Collections.emptyList()
        );
    }
 
    public boolean authenticate(String id, String password) {
        TeacherModel teacher = teacherRepository.findByTeacherIdEquals(id);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return true; // パスワードが一致した場合は認証成功
        }
        return false; // IDが見つからないか、パスワードが一致しない場合は認証失敗
    }
 
}