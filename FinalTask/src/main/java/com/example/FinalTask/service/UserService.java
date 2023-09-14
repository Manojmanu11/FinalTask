package com.example.FinalTask.service;

import com.example.FinalTask.entity.User;
import com.example.FinalTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);

    }
//    @PostConstruct
//    public User initDB() {
//        List<User> users = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new User("user" + i, new Random().nextInt(100), new Random().nextInt(50000), "user" + i + "@gmail.com"))
//                .collect(Collectors.toList());
//        return (User) userRepository.saveAll(users);
//    }


    public List<User> getAll(){
        return userRepository.findAll();
    }
    public List<User> getAllBySorting(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<User> getUserByPagination(int offset, int pageSize){
         Page<User>users=userRepository.findAll(PageRequest.of(offset,pageSize));
         return users;
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
    public  void delete(int id){
        userRepository.deleteById(id);
    }
    public User update(Integer id, User updatedUser) {
        Optional<User> optionalStudent = userRepository.findById(id);
        if (optionalStudent.isPresent()) {
            User user = optionalStudent.get();
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            user.setPhoneNo(updatedUser.getPhoneNo());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }
        return null;
    }


        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            return new org.springframework.security.core.userdetails.User("manoj","password",new ArrayList<>());

        }
    }

